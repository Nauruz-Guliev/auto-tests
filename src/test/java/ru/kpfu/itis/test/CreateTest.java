package ru.kpfu.itis.test;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import ru.kpfu.itis.helper.CreateHelper;
import ru.kpfu.itis.helper.NavigationHelper;
import ru.kpfu.itis.mapper.ValidDataMapper;
import ru.kpfu.itis.model.TestData;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CreateTest extends TestBase {

    @ParameterizedTest
    @Order(1)
    @ArgumentsSource(ValidDataMapper.class)
    public void test_note_creation(TestData testData) {
        NavigationHelper navigationHelper = app.getNavigationHelper();
        CreateHelper createHelper = app.getCreateHelper();
        navigationHelper.goMainPage(testData.getBaseUrl());
        createHelper.createNote(testData.getNoteText(), testData.getNoteTitle());
        navigationHelper.openNote(testData.getNoteTitle());

        boolean pageContainsText = createHelper
                .getNote()
                .getText()
                .contains(testData.getNoteText());

        assertTrue(pageContainsText);
    }
}
