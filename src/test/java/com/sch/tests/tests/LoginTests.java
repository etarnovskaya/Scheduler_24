package com.sch.tests.tests;

import com.sch.tests.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends  TestBase {
    @Test
    public void testLogin() throws InterruptedException {
        app.getUserHelper().fillLoginForm(new User()
                .withEmail("aa@gmail.com")
                .withPassword("Aa1234567"));
        app.getUserHelper().closeKeyboard();
        app.getUserHelper().tapLoginButton();
        Thread.sleep(5000);

        Assert.assertFalse(app.getUserHelper().isLoginButtonPresent());
    }
}
