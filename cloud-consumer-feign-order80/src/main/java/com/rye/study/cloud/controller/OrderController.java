package com.rye.study.cloud.controller;


import com.rye.study.cloud.apis.PayfeignApi;
import com.rye.study.cloud.entities.PayDto;
import com.rye.study.cloud.reps.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Resource
    PayfeignApi payfeignApi;

    @PostMapping("/feign/pay/add")
    public ResultData<String> add(@RequestBody PayDto payDto) {
        return payfeignApi.add(payDto);
    }

    @DeleteMapping("/feign/pay/del/{id}")
    public ResultData<String> delete(@PathVariable("id") String id) {
        payfeignApi.delete(id);
        return ResultData.success("执行成功");
    }

    @PutMapping("/feign/pay/update")
    public ResultData<String> update(@RequestBody PayDto payDto) {
        return payfeignApi.update(payDto);
    }

    @GetMapping("feign/pay/get/{id}")
    public ResultData<String> get(@PathVariable("id") String id) {
        return payfeignApi.get(id);
    }

    @GetMapping(value = "/feign/get/info")
    public String getInfoByConsul() {
        return payfeignApi.getInfoByConsul();
    }

}
