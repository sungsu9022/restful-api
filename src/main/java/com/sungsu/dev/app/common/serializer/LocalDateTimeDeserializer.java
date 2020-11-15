package com.sungsu.dev.app.common.serializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {
	public LocalDateTimeDeserializer() {
		super(LocalDateTime.class);
	}

	@Override
	public LocalDateTime deserialize(final JsonParser parser,
									 final DeserializationContext context) throws IOException {
		final long value = parser.getValueAsLong();
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(value), ZoneId.systemDefault());
	}
}
