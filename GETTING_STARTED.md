# User Guide

## 프로젝트 의존성 추가
[jitpack 가이드](https://jitpack.io/#frjufvjn/feature-toggles-core)

## 초기 설정
### 데이터 영역 구현체 작성
- core에 정의된 인터페이스 `featuretoggles.core.router.FeatureDataCoreProvider` 의 구현체를 작성한다. 
- `FeatureDataFetcher` 라는 피처 데이터 조회하는 역할을 처리하는 객체가 있다면 이를 의존성 주입시킨다.
```java
import featuretoggles.core.router.FeatureDataCoreProvider;
import featuretoggles.core.router.FeaturesResource;

public class FeatureDataProvider implements FeatureDataCoreProvider {
    private final FeatureDataFetcher featureDataFetcher;

    public FeatureDataProvider(FeatureDataFetcher featureDataFetcher) {
        this.featureDataFetcher = featureDataFetcher;
    }

    @Override
    public FeaturesResource getActiveToggle(String feature) {
        return featureDataFetcher.find(feature)
                .map(featureInfo -> FeaturesResource.of(
                        featureInfo.getId(),
                        featureInfo.getName(),
                        featureInfo.getSelectedToggle())
                ).orElse(FeaturesResource.of(0L, feature, "default"));
    }
}
```

### 데이터를 조회하는 서비스 작성
- DB의 데이터를 `JdbcTemplate`를 통해 access한다고 가정하여 조회 서비스를 작성한 예시
- 성능을 고려하여 `@Cacheable`을 적용할 수 있다.
```java
@Service
public class FeatureDataFetcher {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public FeatureDataFetcher(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Cacheable(value = "feature-data")
    public Optional<FeatureInfo> find(String feature) {
        try {
            FeatureInfo result = jdbcTemplate.queryForObject("""
                            SELECT * FROM feature WHERE name = :feature
                            """,
                    new MapSqlParameterSource().addValue("feature", feature),
                    (rs, rowNum) -> FeatureInfo.builder()
                            ...
                            .build()
            );
            return Optional.ofNullable(result);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
```

### Configuration
- 위와 같이 사용자의 환경에 맞게 작성된 데이터 영역의 객체들이 `feature-toggles-core`에서 사용될 수 있도록 설정한다.
```java
@Configuration
public class FeatureTogglesConfiguration {
    @Bean
    public FeatureCoreRouter featureCoreRouter(NamedParameterJdbcTemplate jdbcTemplate) {
        FeatureDataFetcher featureDataFetcher = new FeatureDataFetcher(jdbcTemplate);
        return new FeatureCoreRouter(new FeatureDataProvider(featureDataFetcher));
    }
}
```

## 서비스 코드 적용 
> 광고(advert)를 다루는 서비스에 피처토글을 적용하여 release를 한다고 가정하여 예시를 작성한다.
### 인터페이스 작성
```java
public interface AdvertService {
    String getContext();
}
```
### 구현 토글 대상 서비스 작성
- default 토글 서비스 
```java
@FeatureOption(defaultFeature = true)
@Service
public class AdvertServiceDefaultImpl implements AdvertService {
    @Transactional
    @Override
    public String getContext() {
        return "default";
    }
}
```
- release 토글 서비스 
```java
@FeatureOption(name = "release")
@Service
public class AdvertServiceReleaseImpl implements AdvertService {
    @Transactional
    @Override
    public String getContext() {
        return "release";
    }
}
```
### Gate 클래스 작성
```java
@Service
public class AdvertServiceGate {
    private final Map<String, AdvertService> advertServiceMap;
    private final FeatureCoreRouter featureCoreRouter;

    public AdvertServiceGate(Set<AdvertService> advertServices,
                             FeatureCoreRouter featureCoreRouter) {
        this.advertServiceMap = FeatureOrchestration.compose("advert", advertServices);
        this.featureCoreRouter = featureCoreRouter;
    }

    public String getContext() {
        return getActiveInstance().getContext();
    }

    public AdvertService getActiveInstance() {
        return featureCoreRouter.getInstance("advert", advertServiceMap);
    }
}
```

## Done