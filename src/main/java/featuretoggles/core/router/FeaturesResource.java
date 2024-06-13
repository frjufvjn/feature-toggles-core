package featuretoggles.core.router;

public class FeaturesResource {
    private Long id;
    private String name;
    private String toggle;

    private FeaturesResource(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.toggle = builder.toggle;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getToggle() {
        return toggle;
    }

    public static FeaturesResource of(long id, String featureName, String toggle) {
        return new Builder()
                .id(id)
                .name(featureName)
                .toggle(toggle)
                .build();
    }

    public static FeaturesResource ofToggle(String toggle) {
        return new Builder()
                .toggle(toggle)
                .build();
    }

    // Static inner Builder class
    public static class Builder {
        private Long id;
        private String name;
        private String toggle;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder toggle(String toggle) {
            this.toggle = toggle;
            return this;
        }

        public FeaturesResource build() {
            return new FeaturesResource(this);
        }
    }
}
