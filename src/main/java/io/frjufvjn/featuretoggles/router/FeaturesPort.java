package io.frjufvjn.featuretoggles.router;

public interface FeaturesPort {
    FeaturesResource findActiveToggle(String feature);

}
