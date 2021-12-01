package ru.javawebinar.topjava.web.json;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeConverter implements Converter<String, LocalTime> {

    private final DateTimeFormatter formatter;

    public LocalTimeConverter(String dateFormat) {
        this.formatter = DateTimeFormatter.ofPattern(dateFormat);
    }

    @Override
    public LocalTime convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }

        return LocalTime.parse(source, formatter);
    }
}
