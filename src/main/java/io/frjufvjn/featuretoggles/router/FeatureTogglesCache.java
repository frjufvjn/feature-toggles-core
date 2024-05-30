package io.frjufvjn.featuretoggles.router;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FeatureTogglesCache implements FeatureTogglesStrategy {
    private final FeaturesPort featuresPort;

    public FeatureTogglesCache(FeaturesPort featuresPort) {
        this.featuresPort = featuresPort;
    }

    @Override
    public String getActiveToggle(String feature) {
        return Optional.ofNullable(featuresPort.findActiveToggle(feature))
                .map(FeaturesResource::getToggle)
                .orElse(ManagedToggleType.DEFAULT.getCode());
    }

    @Override
    public void setActiveToggle(String feature, String toggle) {
        // config memory 전략일때만 필요.
    }

    @Override
    public void clear() {
        // config memory 전략일때만 필요.
    }
}
