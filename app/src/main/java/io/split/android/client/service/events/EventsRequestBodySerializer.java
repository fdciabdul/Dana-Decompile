package io.split.android.client.service.events;

import io.split.android.client.dtos.Event;
import io.split.android.client.dtos.SerializableEvent;
import io.split.android.client.service.http.HttpRequestBodySerializer;
import io.split.android.client.utils.Json;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class EventsRequestBodySerializer implements HttpRequestBodySerializer<List<Event>> {
    @Override // io.split.android.client.service.http.HttpRequestBodySerializer
    public String serialize(List<Event> list) {
        ArrayList arrayList = new ArrayList();
        for (Event event : list) {
            SerializableEvent serializableEvent = new SerializableEvent();
            serializableEvent.eventTypeId = event.eventTypeId;
            serializableEvent.trafficTypeName = event.trafficTypeName;
            serializableEvent.key = event.key;
            serializableEvent.value = event.value;
            serializableEvent.timestamp = event.timestamp;
            serializableEvent.properties = event.properties;
            arrayList.add(serializableEvent);
        }
        return Json.toJson(arrayList);
    }
}
