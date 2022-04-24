package com.tencent.wxcloudrun.dto;

import lombok.Data;

/**
 * Copyright © 2022 hugh. Tech Ltd. All rights reserved.
 * 功能描述：
 *
 * @author: 刘锦辉
 * @date: 2022/4/16
 */
@Data
public class GenerateLotteryCodeRequest {

    // 奖品等级
    private int awardLevel;
    // 数量
    private int number;

}
