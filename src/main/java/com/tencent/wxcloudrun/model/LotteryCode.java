package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright © 2022 hugh. Tech Ltd. All rights reserved.
 * 功能描述：
 *
 * @author: 刘锦辉
 * @date: 2022/4/16
 */
@Data
public class LotteryCode implements Serializable {

    // 抽奖号
    private String lotteryNumber;
    // 奖励级别
    private int awardLevel;
    // 使用状态
    private boolean usedStatus;
    // 获得者
    private String winner;
    // 姓名
    private String name;
    // 收货地址
    private String receivingAddress;
    // 创建时间
    private Date createTime;
    // 使用时间
    private Date usageTime;

}
