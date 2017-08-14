package org.ltw.config;

import org.aspectj.lang.Aspects;
import org.ltw.aop.AopComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

/**
 * Created by Admin on 2017/8/11.
 */
@Configuration
@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.ENABLED)
public class AspectJConfig {

    @Bean
    public AopComponent component() {
        return Aspects.aspectOf(AopComponent.class);
    }
}
