package io.frjufvjn.featuretoggles.router;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FeaturesResource {
    private Long id;
    private String name;
    private String toggle;

    public static FeaturesResource of(long id, String featureName, String toggle) {
        return FeaturesResource.builder()
                .id(id)
                .name(featureName)
                .toggle(toggle)
                .build();
    }

    public static FeaturesResource ofToggle(String toggle) {
        return FeaturesResource.builder()
                .toggle(toggle)
                .build();
    }
}
