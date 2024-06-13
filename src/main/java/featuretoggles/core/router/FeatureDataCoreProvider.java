package featuretoggles.core.router;

public interface FeatureDataCoreProvider {
    FeaturesResource getActiveToggle(String feature);
}
