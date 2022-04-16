package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.GenerateLotteryCodeRequest;
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

}
