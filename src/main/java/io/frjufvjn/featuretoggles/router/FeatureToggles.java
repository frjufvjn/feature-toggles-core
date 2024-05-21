package io.frjufvjn.featuretoggles.router;

import io.frjufvjn.featuretoggles.FeatureBlockedException;
import io.frjufvjn.featuretoggles.orchestration.FeatureOrchestration;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FeatureToggles {
    private final FeatureTogglesStrategy featureTogglesCache;

    public FeatureToggles(FeatureTogglesStrategy featureTogglesCache) {
        this.featureTogglesCache = featureTogglesCache;
    }

    private static void bolckToggleCheck(String toggle) {
        if (ManagedToggleType.isBlocked(toggle)) {
            throw new FeatureBlockedException();
        }
    }

    private FeatureTogglesStrategy instance() {
        return this.featureTogglesCache;
    }

    /**
     * [Feature Toggles] 현재 토글대상 인스턴스 반환
     * <pre>
     * 설정에 의해 정의된 혹은 런타임중 변경된 토글된 대상 인스턴스를 반환한다.
     * 런타임중에 변동이 될 수 있으므로 생성자에서 호출하지 않는다.
     * </pre>
     *
     * @param feature   토글 대상 기능명
     * @param instances 인스턴스 맵
     * @param <T>
     * @return 인스턴스
     */
    public <T> T getInstance(final String feature, Map<String, T> instances) {
        return FeatureOrchestration.getInstanceInternal(getActiveToggle(feature), instances);
    }

    public String getActiveToggle(String feature) {
        String toggle = instance().getActiveToggle(feature);
        bolckToggleCheck(toggle);
        return toggle;
    }

    /**
     * feature에 대한 토글을 변경 (정적인 방식에서만 사용할것)
     */
    public void setActiveToggle(String feature, String toggle) {
        instance().setActiveToggle(feature, toggle);
    }

    /**
     * 정적인 방식에서만 사용할것
     */
    public void clear() {
        instance().clear();
    }
}
