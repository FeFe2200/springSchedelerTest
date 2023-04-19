package exSchedeler.demo;

import exSchedeler.demo.dto.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {
    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Test> getHome() {//"/" 게시물 리스트 출력
        List<Test> req = testService.findTest();
        return req;
    }

    @PostMapping("/test/{name}")
    @ResponseBody
    public Long postName(@PathVariable String name) {
        Test test = new Test();
        test.setName(name);
        test.setCount(0L);
        return testService.save(test);
    }
}
