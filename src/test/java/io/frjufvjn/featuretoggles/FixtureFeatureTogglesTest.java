package io.frjufvjn.featuretoggles;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = TestMain.class)
public class FixtureFeatureTogglesTest {
    @Autowired
    private AdvertServiceGate advertServiceGate;

    @DisplayName("feature 데이터에 토글이 'release'로 설정이 되어 잇다면")
    @Test
    void releaseToggleTest() {
        String result = advertServiceGate.findAdvert();
        assertThat(result).isEqualTo("release");
    }
}
