package com.boot.test;

import com.boot.bean.DemoBean;
import com.boot.config.ProfileConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Admin on 2017/6/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProfileConfig.class})
@ActiveProfiles("prod")
public class DemoBeanIntegrationTest {

    @Autowired
    private DemoBean demoBean;

    @Test
    public void prodBeanShouldInject() {
        String expected = "from production profile";
        String content = demoBean.getContent();
        Assert.assertEquals(expected, content);
    }
}
