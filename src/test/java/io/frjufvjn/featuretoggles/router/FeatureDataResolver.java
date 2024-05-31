package io.frjufvjn.featuretoggles.router;

public class FeatureDataResolver extends AbstractFeatureDataResolver {
    @Override
    public FeaturesResource getActiveToggle(String feature) {
        return FeaturesResource.builder()
                .id(1L)
                .name("advert")
                .toggle("release")
                .build();
    }
}
