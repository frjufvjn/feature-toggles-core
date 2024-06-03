package io.frjufvjn.featuretoggles.router;

public interface FeatureDataCoreProvider {
    FeaturesResource getActiveToggle(String feature);
}
