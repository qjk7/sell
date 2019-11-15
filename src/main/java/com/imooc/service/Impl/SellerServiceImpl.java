package com.imooc.service.Impl;

import com.imooc.dataobject.SellerInfo;
import com.imooc.repository.SellerInfoRepository;
import com.imooc.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by 廖师兄
 * 2017-07-29 23:15
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }

    @Override
    public SellerInfo findSellerInfoByUserAndPassword(String username, String password) {

        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setUsername(username);
        sellerInfo.setPassword(password);
        Example<SellerInfo> example =Example.of(sellerInfo);
        Optional<SellerInfo> result = repository.findOne(example);

        return result.isPresent()?result.get():null;
    }
}
