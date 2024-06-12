package com.github.frjufvjn.featuretoggles.orchestration;

import com.github.frjufvjn.featuretoggles.FeatureException;

import java.util.Set;

public class InstanceChecker {
    /**
     * Feature 인스턴스 정의 체크
     * <li>Feature 인스턴스들 중에 디폴트로 정의되어 있는 인스턴스가 있는지 체크</li>
     * <li>name 중복 체크</li>
     */
    protected static <T> void specification(Set<T> instances) {
        checkDefault(instances);
        checkDuplicated(instances);
    }

    private static <T> void checkDefault(Set<T> instances) {
        long defaultCount = instances.stream()
                .filter(InstanceDefault::hasDefaultInstance)
                .count();
        if (defaultCount != 1) {
            throw new FeatureException("[feature-toggles] 해당 feature에 디폴트로 정의된 인스턴스 1개가 필요합니다.");
        }
    }

    private static <T> void checkDuplicated(Set<T> instances) {
        long uniqueNameCount = instances.stream()
                .map(InstanceNames::getInstanceName)
                .distinct().count();
        if (instances.size() != uniqueNameCount) {
            throw new FeatureException("[feature-toggles] @FeatureOption(name=)을 통해 정의된 이름에 중복을 허용할 수 없습니다.");
        }
    }
}
