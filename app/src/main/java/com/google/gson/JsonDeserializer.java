package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public interface JsonDeserializer<T> {
    T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException;
}
