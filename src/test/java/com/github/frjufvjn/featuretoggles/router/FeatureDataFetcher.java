package com.github.frjufvjn.featuretoggles.router;

import org.springframework.stereotype.Component;

@Component
public class FeatureDataFetcher implements FeatureDataCoreProvider {
    @Override
    public FeaturesResource getActiveToggle(String feature) {
        return FeaturesResource.builder()
                .id(1L)
                .name("advert")
                .toggle("release")
                .build();
    }
}
