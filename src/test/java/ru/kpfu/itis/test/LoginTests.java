package ru.kpfu.itis.test;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import ru.kpfu.itis.helper.LoginHelper;
import ru.kpfu.itis.helper.NavigationHelper;
import ru.kpfu.itis.mapper.InvalidDataMapper;
import ru.kpfu.itis.mapper.ValidDataMapper;
import ru.kpfu.itis.model.TestData;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTests extends TestBase {

    @ParameterizedTest
    @Order(1)
    @ArgumentsSource(InvalidDataMapper.class)
    public void test_login_invalid(TestData testData) {
        LoginHelper loginHelper = app.getLoginHelper();
        NavigationHelper navigationHelper = app.getNavigationHelper();
        navigationHelper.goMainPage(testData.getBaseUrl());
        loginHelper.login(testData);
        boolean isSignUpButtonPresent = loginHelper.checkElementExistsLinkText("Sign Up");
        assertTrue(isSignUpButtonPresent);
    }

    @ParameterizedTest
    @Order(2)
    @ArgumentsSource(ValidDataMapper.class)
    public void test_login_valid(TestData testData) {
        LoginHelper loginHelper = app.getLoginHelper();
        NavigationHelper navigationHelper = app.getNavigationHelper();
        navigationHelper.goMainPage(testData.getBaseUrl());
        loginHelper.login(testData);
        boolean isMyAccountButtonPresent = loginHelper.checkElementExistsLinkText("My Account");
        assertTrue(isMyAccountButtonPresent);
    }

    @ParameterizedTest
    @Order(3)
    @ArgumentsSource(ValidDataMapper.class)
    public void test_logout(TestData testData) {
        LoginHelper loginHelper = app.getLoginHelper();
        NavigationHelper navigationHelper = app.getNavigationHelper();
        navigationHelper.goMainPage(testData.getBaseUrl());
        loginHelper.logout();
        boolean isSignInButtonPresent = loginHelper.checkElementExistsLinkText("Log In");
        assertTrue(isSignInButtonPresent);
    }
}
