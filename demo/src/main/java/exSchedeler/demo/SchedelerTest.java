package exSchedeler.demo;

import exSchedeler.demo.dto.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@EnableScheduling
public class SchedelerTest {
    private final TestService testService;

    //@Autowired
    public SchedelerTest(TestService testService) {
        this.testService = testService;
    }

    @Scheduled(cron="0/1 * * * * ?")  // 1초마다 수행
    public void test1() {

        LocalDateTime endTime = LocalDateTime.now().minusMinutes(5);
        LocalDateTime startTime = endTime.minusHours(1);
        List<Test> testlist = this.testService.findAllBycreatedDateBetween(startTime, endTime);

        for (Test test : testlist){
            test.setCount(test.getCount() + 1);
            this.testService.save(test);
        }
        System.out.println("test : " + Thread.currentThread().getName());
    }
}
