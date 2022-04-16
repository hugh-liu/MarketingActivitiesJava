package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.CounterRequest;
import com.tencent.wxcloudrun.dto.GenerateLotteryCodeRequest;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.model.LotteryCode;
import com.tencent.wxcloudrun.service.CounterService;
import com.tencent.wxcloudrun.service.LotteryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Copyright © 2022 ITL Info. Tech Ltd. All rights reserved.
 * 功能描述：抽奖控制器
 *
 * @author: 刘锦辉
 * @date: 2022/4/16
 */
@RestController
@RequestMapping("/api/lottery")
public class LotteryController {

    final LotteryService lotteryService;
    final Logger logger;

    public LotteryController(@Autowired LotteryService lotteryService) {
        this.lotteryService = lotteryService;
        this.logger = LoggerFactory.getLogger(CounterController.class);
    }

    /**
     * 生成抽奖码
     * @param request
     * @return
     */
    @PostMapping(value = "/generateLotteryCode")
    ApiResponse generateLotteryCode(@RequestBody GenerateLotteryCodeRequest request) {
        logger.info("/api/generateLotteryCode post request, awardLevel: {}, number: {}", request.getAwardLevel(), request.getNumber());
        try {
            List<LotteryCode> lotteryCodes = lotteryService.generateLotteryCode(request);
            return ApiResponse.ok(lotteryCodes);
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

}
