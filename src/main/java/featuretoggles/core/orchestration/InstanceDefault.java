package featuretoggles.core.orchestration;

import featuretoggles.core.FeatureException;
import featuretoggles.core.FeatureOption;
import featuretoggles.core.router.ManagedToggleType;

import java.util.Map;
import java.util.Optional;

// @Log4j2
public class InstanceDefault {
    /**
     * 디폴트로 정의된 인스턴스인지 확인
     */
    protected static <T> boolean hasDefaultInstance(T instance) {
        FeatureOption featureOption = Optional.ofNullable(instance.getClass().getAnnotation(FeatureOption.class))
                .orElse(ProxyBeanExtractor.getFeatureOptionIfProxyBean(instance));
        if (featureOption == null) {
            throw new FeatureException("[feature-toggles] featureOption is null, instance: " + instance.getClass().getName());
        }
        return featureOption.defaultFeature();
    }

    /**
     * 디폴트 인스턴스 반환
     */
    protected static <T> T getDefaultInstance(Map<String, T> instances) {
        String defaultKey = instances.keySet().stream()
                .filter(ManagedToggleType.DEFAULT.getCode()::equals)
                .findFirst()
                .orElseThrow(() -> new FeatureException("[feature-toggles] feature에 해당되는 인스턴스를 찾을 수 없습니다."));
        // log.warn("[feature-toggles] 지정한 feature에 해당되는 인스턴스를 찾을 수 없어서 디폴트로 정의된 인스턴스를 반환합니다.");
        return instances.get(defaultKey);
    }
}
