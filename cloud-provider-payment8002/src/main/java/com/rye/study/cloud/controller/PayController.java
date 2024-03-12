package com.rye.study.cloud.controller;

import cn.hutool.core.bean.BeanUtil;
import com.rye.study.cloud.entities.Pay;
import com.rye.study.cloud.entities.PayDto;
import com.rye.study.cloud.reps.ResultData;
import com.rye.study.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "支付微服务模块", description = "支付CRUD")
public class PayController {
    @Resource
    PayService payService;

    @PostMapping("/pay/add")
    @Operation(summary = "新增", description = "新增支付流水方法,json串做参数")
    public ResultData<String> add(@RequestBody Pay pay) {
        int add = payService.add(pay);
        return ResultData.success("成功插入数据" + add + "条数据");
    }

    @DeleteMapping("/pay/del/{id}")
    @Operation(summary = "删除", description = "删除支付流水方法")
    public ResultData<String> delete(@PathVariable("id") String id) {
        int del = payService.delete(id);
        return ResultData.success("成功删除数据" + del + "条数据");

    }

    @PutMapping("/pay/update")
    @Operation(summary = "修改", description = "修改支付流水方法")
    public ResultData<String> update(@RequestBody PayDto payDto) {
        Pay pay = new Pay();
        BeanUtil.copyProperties(payDto, pay);

        int update = payService.update(pay);
        return ResultData.success("成功更新数据" + update + "条数据");
    }

    @GetMapping("/pay/getById/{id}")
    @Operation(summary = "按照ID查流水", description = "查询支付流水方法")
    public ResultData<Pay> getById(@PathVariable("id") String id) {
        if (id.equals("-4")) throw new RuntimeException("id不能为负数");
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @GetMapping("/pay/getAll")
    @Operation(summary = "查询所有流水", description = "查询所有支付流水方法")
    public ResultData<List<Pay>> getAll() {
        List<Pay> all = payService.getAll();
        return ResultData.success(all);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/pay/get/info")
    private String getInfoByConsul(@Value("${rye.info}") String atguiguInfo)
    {
        return "info: "+atguiguInfo+"\t"+"port: "+port;
    }

}
