package io.frjufvjn.featuretoggles.router;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public enum ManagedToggleType {
    DEFAULT("default", "features의 selectedToggle에 저장될 수 없는 Map의 getOrDefault와 동일한 목적을 가진 타입입니다."),
    BLOCKED("blocked", "기능을 차단하는 목적으로 사용됩니다.");

    private final String code;
    private final String description;

    public static boolean isBlocked(String toggle) {
        return Objects.equals(toggle, BLOCKED.getCode());
    }

    public static boolean isDefault(String toggle) {
        return Objects.equals(toggle, DEFAULT.getCode());
    }

    public static boolean containsCode(String code) {
        if (code == null) {
            return false;
        }
        for (ManagedToggleType type : ManagedToggleType.values()) {
            if (type.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }
}
