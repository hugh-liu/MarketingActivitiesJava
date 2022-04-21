package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.GenerateLotteryCodeRequest;
import com.tencent.wxcloudrun.dto.LotteryRequest;
import com.tencent.wxcloudrun.model.LotteryCode;

import java.util.List;
import java.util.Map;

/**
 * Copyright © 2022 ITL Info. Tech Ltd. All rights reserved.
 * 功能描述：抽奖接口
 *
 * @author: 刘锦辉
 * @date: 2022/4/16
 */
public interface LotteryService {

    /**
     * 生成抽奖码
     * @param request
     * @return
     * @throws Exception
     */
    List<LotteryCode> generateLotteryCode(GenerateLotteryCodeRequest request) throws Exception;

    /**
     * 获取未使用的抽奖码
     * @param awardLevel 奖品等级
     * @return
     * @throws Exception
     */
    List<LotteryCode> getLotteryCode(int awardLevel) throws Exception;

    /**
     * 查询中奖信息
     * @param winner
     * @return
     * @throws Exception
     */
    List<LotteryCode> queryWinningInfo(String winner) throws Exception;

    /**
     * 抽奖
     * @param lotteryRequest
     * @return
     * @throws Exception
     */
    int lottery(LotteryRequest lotteryRequest) throws Exception;

    /**
     * 保存收货地址
     * @param lotteryRequest
     * @throws Exception
     */
    void saveReceivingAddress(LotteryRequest lotteryRequest) throws Exception;

}
