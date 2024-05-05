package ru.kpfu.itis.mapper;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import ru.kpfu.itis.provider.TestDataProvider;
import java.util.stream.Stream;

public class MapperBase implements ArgumentsProvider {

    private final String fileName;
    private final TestDataProvider provider;

    public MapperBase(String fileName, TestDataProvider provider) {
        this.fileName = fileName;
        this.provider = provider;
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(Arguments.of(provider.getUserData(fileName)));
    }
}
