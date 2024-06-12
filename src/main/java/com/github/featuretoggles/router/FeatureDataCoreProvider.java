package com.github.featuretoggles.router;

public interface FeatureDataCoreProvider {
    FeaturesResource getActiveToggle(String feature);
}
