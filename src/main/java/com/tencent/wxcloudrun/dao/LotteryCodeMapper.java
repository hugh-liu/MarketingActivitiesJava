package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.LotteryCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Copyright © 2022 hugh. Tech Ltd. All rights reserved.
 * 功能描述：
 *
 * @author: 刘锦辉
 * @date: 2022/4/16
 */
@Mapper
public interface LotteryCodeMapper {

    /**
     * 新增抽奖码
     * @param lotteryCodes
     */
    void insertLotteryCode(@Param("lotteryCodes") List<LotteryCode> lotteryCodes);

    /**
     * 获取未使用的抽奖码
     * @param awardLevel
     * @return
     */
    List<LotteryCode> getLotteryCode(@Param("awardLevel") int awardLevel);

    /**
     * 查询中奖信息
     * @param winner
     * @return
     */
    List<LotteryCode> queryWinningInfo(@Param("winner") String winner);

    /**
     * 查询奖品信息
     * @param lotteryNumber
     * @return
     */
    LotteryCode queryPrize(@Param("lotteryNumber") String lotteryNumber);

    /**
     * 修改抽奖信息
     * @param lotteryCode
     */
    void updateLotteryInfo(@Param("lotteryCode") LotteryCode lotteryCode);

    /**
     * 修改收货地址
     * @param lotteryCode
     */
    void saveReceivingAddress(@Param("lotteryCode") LotteryCode lotteryCode);

}
