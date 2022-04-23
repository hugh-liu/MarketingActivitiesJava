package com.tencent.wxcloudrun.dto;

import lombok.Data;

import java.util.Date;

/**
 * Copyright © 2022 ITL Info. Tech Ltd. All rights reserved.
 * 功能描述：
 *
 * @author: 刘锦辉
 * @date: 2022/4/17
 */
@Data
public class LotteryRequest {

    // 抽奖号
    private String lotteryNumber;
    // 获得者
    private String winner;
    // 姓名
    private String name;
    // 收货地址
    private String receivingAddress;

}
