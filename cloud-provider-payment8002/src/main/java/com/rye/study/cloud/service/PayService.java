package com.rye.study.cloud.service;

import com.rye.study.cloud.entities.Pay;

import java.util.List;

public interface PayService {
    int add(Pay pay);
    int delete(String id);
    int update(Pay pay);
    Pay getById(String id);
    List<Pay> getAll();


}
