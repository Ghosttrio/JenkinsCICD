package jenkins.test.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JenkinsControllerTest {

    @Autowired JenkinsController jenkinsController;

    @Test
    void logic() {
        int result = jenkinsController.logic(1, 1);
        Assertions.assertThat(2).isEqualTo(result);
    }
}