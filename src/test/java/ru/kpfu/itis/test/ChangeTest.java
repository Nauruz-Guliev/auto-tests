package ru.kpfu.itis.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import ru.kpfu.itis.helper.ChangeHelper;
import ru.kpfu.itis.helper.NavigationHelper;
import ru.kpfu.itis.mapper.ValidDataMapper;
import ru.kpfu.itis.model.TestData;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangeTest extends AuthBase {

    @ParameterizedTest
    @ArgumentsSource(ValidDataMapper.class)
    public void test_note_change(TestData testData) {
        NavigationHelper navigationHelper = app.getNavigationHelper();
        ChangeHelper changeHelper = app.getChangeHelper();
        navigationHelper.goMainPage(testData.getBaseUrl());
        changeHelper.changeNote(testData.getNoteText());
        navigationHelper.openNote(testData.getNoteTitle());

        boolean pageContainsText = changeHelper
                .getNote()
                .getText()
                .contains(testData.getNoteText());

        assertTrue(pageContainsText);
    }
}
