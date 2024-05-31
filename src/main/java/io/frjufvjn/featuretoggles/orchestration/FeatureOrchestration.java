package io.frjufvjn.featuretoggles.orchestration;

import io.frjufvjn.featuretoggles.router.FeatureCoreRouter;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class FeatureOrchestration {

    /**
     * [Feature Toggles] 인스턴스 컴포지션
     * <pre>
     * Gate기능을 수행하는 클래스에서 토글 대상 인스턴스들의 컴포지션을 수행한다.
     * 토글대상 클래스의 명칭별로 클래스의 인스턴스를 맵으로 관리할 수 있도록 해준다.
     * </pre>
     * <pre>
     * - 'default'인스턴스를 지정하는 방법 제공
     *   Service, Component 애노테이션과 더불어 @FeatureOption 애노테이션을 추가한다.
     *   feature의 인스턴스들 중에 default인스턴스를 1개 지정 필요, 그렇지 않다면 예외 발생함.
     *   {@code @FeatureOption(defaultFeature = true)}
     *
     * - feature 버전 식별이름은 기본적으로 클래스명으로 제공되나 별도로 이름을 지정할 수 있다.
     *   {@code @FeatureOption(name = "member-v2")}
     * </pre>
     */
    public static <T> Map<String, T> compose(final String feature, final Set<T> instances) {
        InstanceChecker.specification(instances);
        Map<String, T> composedMap = instances.stream()
                .collect(Collectors.toMap(
                        InstanceNames::getInstanceName,
                        instance -> instance));
        InstanceNames.applyFeatureInstanceNames(feature, composedMap);
        return composedMap;
    }

    /**
     * {@link FeatureCoreRouter#getInstance(String, Map)}에서 참조하기 위해 제공
     */
    public static <T> T getInstanceInternal(final String toggle, Map<String, T> instances) {
        return Optional.ofNullable(instances.get(toggle))
                .orElseGet(() -> InstanceDefault.getDefaultInstance(instances));
    }
}
