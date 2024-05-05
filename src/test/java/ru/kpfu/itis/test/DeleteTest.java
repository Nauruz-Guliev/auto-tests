package ru.kpfu.itis.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import ru.kpfu.itis.helper.ChangeHelper;
import ru.kpfu.itis.helper.CreateHelper;
import ru.kpfu.itis.helper.DeleteHelper;
import ru.kpfu.itis.helper.NavigationHelper;
import ru.kpfu.itis.mapper.ValidDataMapper;
import ru.kpfu.itis.model.TestData;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class DeleteTest extends AuthBase {

    @ParameterizedTest
    @ArgumentsSource(ValidDataMapper.class)
    public void test_note_change(TestData testData) {
        NavigationHelper navigationHelper = app.getNavigationHelper();
        CreateHelper createHelper = app.getCreateHelper();
        DeleteHelper deleteHelper = app.getDeleteHelper();
        navigationHelper.goMainPage(testData.getBaseUrl());
        createHelper.createNote(testData.getNoteText(), testData.getNoteTitle());
        deleteHelper.deleteNote();
        boolean isNotePresent = deleteHelper.checkElementExistsLinkText(testData.getNoteTitle());
        assertFalse(isNotePresent);
    }
}
