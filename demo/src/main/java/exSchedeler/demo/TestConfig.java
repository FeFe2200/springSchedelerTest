package exSchedeler.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    private final TestRepository testRepository;

    public TestConfig(TestRepository testRepository){
        this.testRepository = testRepository;
    }

    @Bean
    public TestService testService(){
        return new TestService(testRepository);
    }
}
