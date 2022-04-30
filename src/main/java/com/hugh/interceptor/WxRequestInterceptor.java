package com.hugh.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * Copyright © 2022 hugh. Tech Ltd. All rights reserved.
 * 功能描述：微信请求拦截器
 *
 * @author: 刘锦辉
 * @date: 2022/4/16
 */
public class WxRequestInterceptor implements HandlerInterceptor {

    @Value("${wx.appId}")
    private String appId = UUID.randomUUID().toString().replace("-", "");

    @Value("${wx.appSecret}")
    private String appSecret;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e) throws Exception {
        System.out.println("测试1");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView e) throws Exception {
        System.out.println("测试2");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        String userAgent = request.getHeader("User-Agent");
        String uri = request.getRequestURI();
        if (uri.equals("/authorize") && (userAgent == null || !userAgent.toLowerCase().contains("micromessenger"))) {
            return true;
        }
        //判断是否是微信浏览器
        if (userAgent == null || !userAgent.toLowerCase().contains("micromessenger")) {
            response.sendRedirect("/authorize");
            return false;
        }
        if (uri.equals("/authorize")) {
            response.sendRedirect("");
        }
        /*String backURL = request.getRequestURL().toString();
        HttpSession session = request.getSession();
        if (request.getQueryString() != null) {
            backURL += "?" + request.getQueryString();
        }
        if (userAgent == null || !userAgent.toLowerCase().contains("micromessenger")) {
            return true;
        }
        JSONObject wxUserInfoJson = (JSONObject) session.getAttribute("sessionWxUserInfoJson");
        if (wxUserInfoJson != null) {
            return true;
        }
        String code = request.getParameter("code");
        // 第一次访问
        if (StringUtils.isBlank(code)) {
            response.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?appid="
                    + appId
                    + "&redirect_uri="
                    + URLEncoder.encode(backURL, "UTF-8")
                    + "&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
            return false;
        }
        // 微信认证回来
        JSONObject authJson = this.getOpenId(appId, appSecret, code);
        String openId = authJson.getString("openid");
        if (openId == null) {
            return false;
        }
        String accessToken = authJson.getString("access_token");
        wxUserInfoJson = this.getWxUserInfo(accessToken, openId);
        session.setAttribute("sessionWxUserInfoJson", wxUserInfoJson);*/
        return true;
    }

    private JSONObject getOpenId(String appId, String appSecret, String code) throws Exception {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
                + appId
                + "&secret="
                + appSecret
                + "&code="
                + code
                + "&grant_type=authorization_code";
        // String res = HttpUtil.getSSL(url, null, 0, 0);
        String res = "{}";
        return JSONObject.parseObject(res);
    }

    private JSONObject getWxUserInfo(String accessToken, String openId) throws Exception {
        String url = "https://api.weixin.qq.com/sns/userinfo?access_token="
                + accessToken
                + "&openid="
                + openId
                + "&lang=zh_CN";
        // String res = HttpUtil.getSSL(url, null, 0, 0);
        String res = "{}";
        return JSONObject.parseObject(res);
    }
}