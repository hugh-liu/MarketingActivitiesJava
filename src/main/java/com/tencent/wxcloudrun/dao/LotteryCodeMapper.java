package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.LotteryCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Copyright © 2022 ITL Info. Tech Ltd. All rights reserved.
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

}
