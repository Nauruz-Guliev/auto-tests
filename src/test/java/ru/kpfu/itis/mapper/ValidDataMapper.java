package ru.kpfu.itis.mapper;

import ru.kpfu.itis.Constants;
import ru.kpfu.itis.provider.TestDataProvider;

public class ValidDataMapper extends MapperBase {

    public ValidDataMapper() {
        super(Constants.VALID_FILE_NAME, new TestDataProvider());
    }
}
