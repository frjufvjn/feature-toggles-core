package io.frjufvjn.featuretoggles.router;

import org.springframework.stereotype.Component;

@Component
public class FeatureAdapter implements FeaturesPort {
    /**
     * Data영역과 Routing영역에 대한 영역은 환경에 따라 요구사항이 다르므로
     * 사용자들께 구현을 맡깁니다.
     */
    @Override
    public FeaturesResource findActiveToggle(String feature) {
        return null;
    }
}
