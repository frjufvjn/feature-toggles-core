package io.frjufvjn.featuretoggles.router;

public abstract class AbstractFeatureDataResolver {
    public abstract FeaturesResource getActiveToggle(String feature);
}
