package ru.kpfu.itis.mapper;

import ru.kpfu.itis.Constants;
import ru.kpfu.itis.provider.TestDataProvider;

public class InvalidDataMapper extends MapperBase {

    public InvalidDataMapper() {
        super(Constants.INVALID_FILE_NAME, new TestDataProvider());
    }
}
