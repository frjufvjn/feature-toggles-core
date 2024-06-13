package featuretoggles.core.router;

import java.util.Objects;

public enum ManagedToggleType {
    DEFAULT("default", "features의 selectedToggle에 저장될 수 없는 Map의 getOrDefault와 동일한 목적을 가진 타입입니다."),
    RELEASE("release", "릴리즈토글");

    private final String code;
    private final String description;

    ManagedToggleType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static boolean isDefault(String toggle) {
        return Objects.equals(toggle, DEFAULT.getCode());
    }
}
