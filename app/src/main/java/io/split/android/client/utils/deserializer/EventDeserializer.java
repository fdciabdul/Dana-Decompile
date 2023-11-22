package io.split.android.client.utils.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import io.split.android.client.dtos.Event;
import io.split.android.client.dtos.SerializableEvent;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class EventDeserializer implements JsonDeserializer<Event> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Event deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        JsonObject asJsonObject2 = !asJsonObject.get("properties").isJsonNull() ? asJsonObject.get("properties").getAsJsonObject() : new JsonObject();
        Event event = new Event();
        if (asJsonObject.get(Event.SIZE_IN_BYTES_FIELD) != null && !asJsonObject.get(Event.SIZE_IN_BYTES_FIELD).isJsonNull()) {
            event.setSizeInBytes(asJsonObject.get(Event.SIZE_IN_BYTES_FIELD).getAsInt());
        }
        event.eventTypeId = asJsonObject.get(SerializableEvent.EVENT_TYPE_FIELD).getAsString();
        event.trafficTypeName = asJsonObject.get(SerializableEvent.TRAFFIC_TYPE_NAME_FIELD).getAsString();
        event.key = asJsonObject.get("key").getAsString();
        event.value = asJsonObject.get("value").getAsDouble();
        event.timestamp = asJsonObject.get("timestamp").getAsLong();
        event.properties = buildMappedProperties(asJsonObject2);
        return event;
    }

    private static Map<String, Object> buildMappedProperties(JsonObject jsonObject) {
        HashMap hashMap = new HashMap();
        if (jsonObject == null) {
            return Collections.unmodifiableMap(hashMap);
        }
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            if (value != null && !value.isJsonNull()) {
                try {
                    String asString = value.getAsString();
                    if (asString.equals(String.valueOf(value.getAsBoolean()))) {
                        hashMap.put(key, Boolean.valueOf(value.getAsBoolean()));
                    } else if (asString.equals(String.valueOf(value.getAsInt()))) {
                        hashMap.put(key, Integer.valueOf(value.getAsInt()));
                    } else if (asString.equals(String.valueOf(value.getAsLong()))) {
                        hashMap.put(key, Long.valueOf(value.getAsLong()));
                    } else if (asString.equals(String.valueOf(value.getAsDouble()))) {
                        hashMap.put(key, Double.valueOf(value.getAsDouble()));
                    } else if (asString.equals(String.valueOf(value.getAsBigDecimal()))) {
                        hashMap.put(key, value.getAsBigDecimal());
                    } else {
                        hashMap.put(key, asString);
                    }
                } catch (NumberFormatException unused) {
                    hashMap.put(key, value.getAsString());
                }
            } else {
                hashMap.put(key, null);
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
