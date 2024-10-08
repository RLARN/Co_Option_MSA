package com.cooption.requestService.client;

import com.cooption.requestService.vo.EventVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "localhost:9002")  // Eureka에 등록된 마이크로서비스 이름
@FeignClient(name = "eventService", url = "http://localhost:9002")
public interface EventServiceClient {

    @PostMapping("/coOption/addEventUserRel")  // task 등록
    void addEventUserRel(EventVO eventVO);

}
