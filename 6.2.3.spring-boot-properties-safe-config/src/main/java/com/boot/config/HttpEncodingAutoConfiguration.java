package com.boot.config;

import com.boot.model.HttpEncodingProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.filter.OrderedCharacterEncodingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * Created by Admin on 2017/6/9.
 */
@Configuration
@EnableConfigurationProperties(HttpEncodingProperties.class)//开启注入属性，通过@EnableConfigurationProperties声明，使用@Autowired注入
@ConditionalOnClass(CharacterEncodingFilter.class)//当CharacterEncodingFilter在类路径下时
@ConditionalOnProperty(prefix = "spring.http.encoding", value = "enabled", matchIfMissing = true)
public class HttpEncodingAutoConfiguration {

    @Autowired
    private HttpEncodingProperties httpEncodingProperties;

    /**
     * 配置filter网页编码为utf-8
     *
     * @return
     */
    @Bean//使用Java配置方式配置CharacterEncodingFilter这个Bean
    @ConditionalOnMissingBean(CharacterEncodingFilter.class)//容器中没有这个bean时新建bean
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new OrderedCharacterEncodingFilter();
        characterEncodingFilter.setEncoding(this.httpEncodingProperties.getCharset().name());
        characterEncodingFilter.setForceEncoding(this.httpEncodingProperties.isForce());
        return characterEncodingFilter;
    }
}
