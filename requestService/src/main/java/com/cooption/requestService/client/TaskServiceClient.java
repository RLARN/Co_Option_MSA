package com.cooption.requestService.client;

import com.cooption.requestService.vo.RequestVO;
import com.cooption.requestService.vo.TaskVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "localhost:9003")  // Eureka에 등록된 마이크로서비스 이름
@FeignClient(name = "taskService", url = "http://localhost:9003")
public interface TaskServiceClient {

    @PostMapping("/coOption/addTask")  // task 등록
    void createTask(@RequestBody TaskVO taskVO);

    @PutMapping("/coOption/modifyTask")  // task 수정 (승인 또는 거절)
    void modifyTask(@RequestBody TaskVO taskVO);
}
