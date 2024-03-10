package com.rye.study.cloud.controller;

import com.rye.study.cloud.entities.PayDto;
import com.rye.study.cloud.reps.ResultData;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

//    public static final String PAYMENT_SRV_URL = "http://localhost:8001";
    public static final String PAYMENT_SRV_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/pay/add")
    public ResultData<String> add(@RequestBody PayDto payDto) {
        return restTemplate.postForObject(PAYMENT_SRV_URL + "/pay/add", payDto, ResultData.class);
    }

    @DeleteMapping("/consumer/pay/del/{id}")
    public ResultData<String> delete(@PathVariable("id") String id) {
        restTemplate.delete(PAYMENT_SRV_URL + "/pay/del/" + id);
        return ResultData.success("执行成功");
    }

    @PutMapping("/consumer/pay/update")
    public ResultData<String> update(@RequestBody PayDto payDto) {
        return restTemplate.postForObject(PAYMENT_SRV_URL + "/pay/update", payDto, ResultData.class);
    }

    @GetMapping("consumer/pay/get/{id}")
    public ResultData<String> get(@PathVariable("id") String id) {
        return restTemplate.getForObject(PAYMENT_SRV_URL + "/pay/getById/"+id, ResultData.class,id);
    }

}
