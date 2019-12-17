package com.programmer.gsk;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ApplicationConfiguration.class, loader = AnnotationConfigWebContextLoader.class)
public class PaymentControllerTest {

    @Autowired
    private PaymentController paymentController;

    private BaseResponse baseResponse;

    @Test
    public void test_SHARED_KEY_GreenPath() {

        baseResponse = paymentController.pay("SHARED_KEY", 0, null);
        Assert.assertEquals("success", baseResponse.getStatus());
        Assert.assertEquals(100, baseResponse.getCode().intValue());

    }

    @Test
    public void test_SHARED_KEY_RedPath() {

        baseResponse = paymentController.pay("SHARE_KEY", 0, null);
        Assert.assertEquals("error", baseResponse.getStatus());
        Assert.assertEquals(102, baseResponse.getCode().intValue());

    }
}

