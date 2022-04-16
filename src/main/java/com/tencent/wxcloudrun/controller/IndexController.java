package com.tencent.wxcloudrun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * index控制器
 */
@Controller

public class IndexController {

  /**
   * 主页页面
   * @return API response html
   */
  @GetMapping
  public String index() {
    return "index";
  }

  /**
   * 生成抽奖码页面
   * @return
   */
  @GetMapping(value = "/generateLotteryCode")
  public String generateLotteryCode() {
    return "generateLotteryCode";
  }

  @GetMapping(value = "/indexWC")
  public String indexWC() {
    return "indexWC";
  }

}
