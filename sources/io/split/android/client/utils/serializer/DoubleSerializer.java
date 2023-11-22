package io.split.android.client.utils.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes6.dex */
public class DoubleSerializer implements JsonSerializer<Double> {
    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(Double d, Type type, JsonSerializationContext jsonSerializationContext) {
        if (d.doubleValue() == d.longValue()) {
            return new JsonPrimitive(Long.valueOf(d.longValue()));
        }
        return new JsonPrimitive(d);
    }
}
