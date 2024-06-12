package com.github.frjufvjn.featuretoggles.router;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public enum ManagedToggleType {
    DEFAULT("default", "features의 selectedToggle에 저장될 수 없는 Map의 getOrDefault와 동일한 목적을 가진 타입입니다."),
    RELEASE("release", "릴리즈토글");

    private final String code;
    private final String description;

    public static boolean isDefault(String toggle) {
        return Objects.equals(toggle, DEFAULT.getCode());
    }
}
