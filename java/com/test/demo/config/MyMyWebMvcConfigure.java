package com.test.demo.config;

import cn.hutool.captcha.GifCaptcha;
import cn.hutool.captcha.generator.MathGenerator;
import com.test.demo.interceptor.MyHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMyWebMvcConfigure implements WebMvcConfigurer {

    /**
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(myHandlerInterceptor());
        registration.addPathPatterns("/**")
                .excludePathPatterns("/indexLogin")
                .excludePathPatterns("/syncLogin")
                .excludePathPatterns("/Home")
                .excludePathPatterns("/userAgreement")
                .excludePathPatterns("/image/p1.jpg")
                .excludePathPatterns("/image/p2.jpg")
                .excludePathPatterns("/image/LOGO.png")
                .excludePathPatterns("/image/LOGO(white).png")
                .excludePathPatterns("/image/logo.ico")
                .excludePathPatterns("/indexlogin.jpg")
                .excludePathPatterns("/**/*.css")
                .excludePathPatterns("/**/*.js")
                .excludePathPatterns("/**/font/*")
                .excludePathPatterns("/captcha")
                .excludePathPatterns("/userRegister")
                .excludePathPatterns("/submitRegister")
                .excludePathPatterns("/login");
    }

    @Bean
    public MyHandlerInterceptor myHandlerInterceptor() {
        return new MyHandlerInterceptor();
    }

    @Bean
    public GifCaptcha gifCaptcha() {
        GifCaptcha gifCaptcha = new GifCaptcha(100, 35);
        gifCaptcha.setGenerator(new MathGenerator());
        return gifCaptcha;
    }
}
