package com.jie.mango.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;

/**
 * 注入属性和配置连接池相关的配置，如黑白名单、监控管理后台登录账户密码等
 */
@Configuration
public class DruidConfig {
    /** 注册Servlet信息，配置监视视图 */
    @Bean
    @ConditionalOnMissingBean
    public ServletRegistrationBean<Servlet> druidServlet(){
        ServletRegistrationBean<Servlet> ServletRegistrationBean = new
                ServletRegistrationBean<Servlet>(new StatViewServlet(),"/druid/*");
        //白名单
        ServletRegistrationBean.addInitParameter("allow","127.0.0.1,139.196.87.48");
        //IP黑名单（存在共同时，deny优先于allow）
        //如果满足deny的话提示Sorry,you qre not permitted to view this page
        ServletRegistrationBean.addInitParameter("deny","192.168.1.119");
        //登陆查看信息的账号面膜，用于登录druid监控后台
        ServletRegistrationBean.addInitParameter("loginUsername","admin");
        ServletRegistrationBean.addInitParameter("loginPassword","admin");
        //是否能够重置数据
        ServletRegistrationBean.addInitParameter("resetEnable","true");
        return ServletRegistrationBean;
    }
}
