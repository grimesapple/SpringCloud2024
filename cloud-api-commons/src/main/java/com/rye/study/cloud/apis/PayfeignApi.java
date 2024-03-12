package com.rye.study.cloud.apis;

import com.rye.study.cloud.entities.PayDto;
import com.rye.study.cloud.reps.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "cloud-payment-service")
public interface PayfeignApi {
    @PostMapping("/pay/add")
    ResultData<String> add(@RequestBody PayDto payDto);

    @DeleteMapping("/pay/del/{id}")
    ResultData<String> delete(@PathVariable("id") String id);

    @PutMapping("/pay/update")
    ResultData<String> update(@RequestBody PayDto payDto);

    @GetMapping("/pay/get/{id}")
    ResultData<String> get(@PathVariable("id") String id);

    @GetMapping(value = "/pay/get/info")
    String getInfoByConsul();


}
