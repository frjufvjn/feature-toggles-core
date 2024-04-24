package io.frjufvjn.featuretoggles;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FeatureInstanceNames {
    private static final Map<String, Set<String>> instanceNames = new HashMap<>();

    public static void put(String feature, Set<String> names) {
        instanceNames.put(feature, names);
    }

    public static Set<String> get(String feature) {
        return instanceNames.get(feature);
    }

    public static Set<String> getFeatures() {
        return instanceNames.keySet();
    }
}
