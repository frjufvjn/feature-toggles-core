package io.frjufvjn.featuretoggles.router;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
@Qualifier("featureTogglesMemory")
public class FeatureTogglesMemory implements FeatureTogglesStrategy {
    private static final ConcurrentHashMap<String, String> features = new ConcurrentHashMap<>();

    /**
     * 현재 토글대상기능(feature)의 버전을 반환
     *
     * @param feature 토글대상기능명
     * @return 토글버전
     */
    @Override
    public String getActiveToggle(String feature) {
        return features.get(feature);
    }

    /**
     * 토글대상기능(feature)의 버전을 정의/변경한다.
     *
     * @param feature 토글대상기능명
     * @param toggle  토글버전
     */
    @Override
    public void setActiveToggle(String feature, String toggle) {
        features.put(feature, toggle);
    }

    @Override
    public void clear() {

    }
}
