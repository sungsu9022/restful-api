package com.sungsu.dev.app.common.serializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class LocalDateTimeSerializer extends StdSerializer<LocalDateTime> {
	public LocalDateTimeSerializer() {
		super(LocalDateTime.class);
	}

	@Override
	public void serialize(final LocalDateTime value,
						  final JsonGenerator generator,
						  final SerializerProvider provider) throws IOException {
		if (value != null) {
			final long mills = value.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
			generator.writeNumber(mills);
		} else {
			generator.writeNull();
		}
	}
}
