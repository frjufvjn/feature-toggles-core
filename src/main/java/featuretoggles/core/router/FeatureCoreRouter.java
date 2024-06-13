package featuretoggles.core.router;

import featuretoggles.core.orchestration.FeatureOrchestration;

import java.util.Map;

public class FeatureCoreRouter {
    private final FeatureDataCoreProvider featureCoreData;

    public FeatureCoreRouter(FeatureDataCoreProvider featureCoreData) {
        this.featureCoreData = featureCoreData;
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
        var featuresResource = featureCoreData.getActiveToggle(feature);
        return featuresResource.getToggle();
    }
}
