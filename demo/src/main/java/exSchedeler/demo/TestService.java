package exSchedeler.demo;

import exSchedeler.demo.dto.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TestService {
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository){
        this.testRepository = testRepository;
    }

    public Long save(Test test) {
        testRepository.save(test);
        return test.getId();
    }

    public List<Test> findTest() {
        return testRepository.findAll();
    }

    public List<Test> findAllBycreatedDateBetween(LocalDateTime timeStart, LocalDateTime timeEnd) {
        return testRepository.findAllBycreatedDateBetween(timeStart, timeEnd);
    }

    public Optional<Test> findOne(Long docsId) {
        return testRepository.findById(docsId);
    }

    public void delete(Long id){
        testRepository.deleteById(id);
    }
}
