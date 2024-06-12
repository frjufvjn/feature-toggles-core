package com.github.frjufvjn.featuretoggles.router;

public interface FeatureDataCoreProvider {
    FeaturesResource getActiveToggle(String feature);
}
