package io.frjufvjn.featuretoggles.router;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FeatureTogglesCache {
    private final FeaturesPort featuresPort;

    public FeatureTogglesCache(FeaturesPort featuresPort) {
        this.featuresPort = featuresPort;
    }

    public String getActiveToggle(String feature) {
        return Optional.ofNullable(featuresPort.findActiveToggle(feature))
                .map(FeaturesResource::getToggle)
                .orElse(ManagedToggleType.DEFAULT.getCode());
    }
}
