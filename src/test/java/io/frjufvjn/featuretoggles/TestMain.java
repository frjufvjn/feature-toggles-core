package io.frjufvjn.featuretoggles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "io.frjufvjn.featuretoggles")
@SpringBootApplication
public class TestMain {
    public static void main(final String[] args) {
        SpringApplication.run(TestMain.class, args);
    }
}
