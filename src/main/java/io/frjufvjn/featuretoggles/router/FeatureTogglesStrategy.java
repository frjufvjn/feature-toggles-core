package io.frjufvjn.featuretoggles.router;

public interface FeatureTogglesStrategy {
    String getActiveToggle(String feature);

    void setActiveToggle(String feature, String toggle);

    void clear();
}
