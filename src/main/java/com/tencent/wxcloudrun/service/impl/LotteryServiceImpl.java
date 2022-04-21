package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.LotteryCodeMapper;
import com.tencent.wxcloudrun.dto.GenerateLotteryCodeRequest;
import com.tencent.wxcloudrun.dto.LotteryRequest;
import com.tencent.wxcloudrun.model.LotteryCode;
import com.tencent.wxcloudrun.service.LotteryService;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Copyright © 2022 ITL Info. Tech Ltd. All rights reserved.
 * 功能描述：
 *
 * @author: 刘锦辉
 * @date: 2022/4/16
 */
@Service
public class LotteryServiceImpl implements LotteryService {

    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };

    final LotteryCodeMapper lotteryCodeMapper;

    public LotteryServiceImpl(@Autowired LotteryCodeMapper lotteryCodeMapper) {
        this.lotteryCodeMapper = lotteryCodeMapper;
    }

    @Override
    public List<LotteryCode> generateLotteryCode(GenerateLotteryCodeRequest request) throws Exception {
        List<LotteryCode> lotteryCodes = new ArrayList<>();
        for (int i = 0;i < request.getNumber();i++) {
            // 生成8位抽奖
            StringBuffer shortBuffer = new StringBuffer();
            String uuid = UUID.randomUUID().toString().replace("-", "");
            for (int j = 0; j < 8; j++) {
                String str = uuid.substring(j * 4, j * 4 + 4);
                int x = Integer.parseInt(str, 16);
                shortBuffer.append(chars[x % 62]);
            }
            // 保存数据
            LotteryCode lotteryCode = new LotteryCode();
            lotteryCode.setLotteryNumber(shortBuffer.toString());
            lotteryCode.setAwardLevel(request.getAwardLevel());
            lotteryCode.setUsedStatus(false);
            lotteryCode.setCreateTime(new Date());
            lotteryCodes.add(lotteryCode);
        }
        lotteryCodeMapper.insertLotteryCode(lotteryCodes);
        return lotteryCodes;
    }

    @Override
    public List<LotteryCode> getLotteryCode(int awardLevel) throws Exception {
        return lotteryCodeMapper.getLotteryCode(awardLevel);
    }

    @Override
    public List<LotteryCode> queryWinningInfo(String winner) throws Exception {
        if (StringUtils.isEmpty(winner)) {
            throw new Exception("请输入中奖获得者信息");
        }
        return lotteryCodeMapper.queryWinningInfo(winner);
    }

    @Override
    public int lottery(LotteryRequest lotteryRequest) throws Exception {
        if (StringUtils.isEmpty(lotteryRequest.getLotteryNumber())) {
            throw new Exception("请输入抽奖号码");
        }
        if (StringUtils.isEmpty(lotteryRequest.getWinner())) {
            throw new Exception("请输入手机号码");
        }
        // 查询抽奖码信息
        LotteryCode lotteryCode = lotteryCodeMapper.queryPrize(lotteryRequest.getLotteryNumber());
        // 判断抽奖码是否正确
        if (lotteryCode == null) {
            throw new Exception("抽奖码错误");
        }
        // 判断抽奖码是否已被使用
        if (lotteryCode.isUsedStatus()) {
            throw new Exception("该抽奖码已被使用");
        }
        // 修改抽奖码信息
        lotteryCode.setUsedStatus(true);
        lotteryCode.setWinner(lotteryRequest.getWinner());
        lotteryCode.setName(lotteryRequest.getName());
        lotteryCode.setReceivingAddress(lotteryRequest.getReceivingAddress());
        lotteryCode.setUsageTime(new Date());
        lotteryCodeMapper.updateLotteryInfo(lotteryCode);
        // 返回奖品等级
        return lotteryCode.getAwardLevel();
    }

    @Override
    public void saveReceivingAddress(LotteryRequest lotteryRequest) throws Exception {
        LotteryCode lotteryCode = new LotteryCode();
        lotteryCode.setWinner(lotteryRequest.getWinner());
        lotteryCode.setName(lotteryRequest.getName());
        lotteryCode.setReceivingAddress(lotteryRequest.getReceivingAddress());
        lotteryCodeMapper.saveReceivingAddress(lotteryCode);
    }
}
