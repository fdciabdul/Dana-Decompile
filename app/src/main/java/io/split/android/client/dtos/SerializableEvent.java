package io.split.android.client.dtos;

import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* loaded from: classes6.dex */
public class SerializableEvent {
    public static final String EVENT_TYPE_FIELD = "eventTypeId";
    public static final String KEY_FIELD = "key";
    public static final String PROPERTIES_FIELD = "properties";
    public static final String TIMESTAMP_FIELD = "timestamp";
    public static final String TRAFFIC_TYPE_NAME_FIELD = "trafficTypeName";
    public static final String VALUE_FIELD = "value";
    @SerializedName(EVENT_TYPE_FIELD)
    public String eventTypeId;
    @SerializedName("key")
    public String key;
    @SerializedName("properties")
    public Map<String, Object> properties;
    @SerializedName("timestamp")
    public long timestamp;
    @SerializedName(TRAFFIC_TYPE_NAME_FIELD)
    public String trafficTypeName;
    @SerializedName("value")
    public double value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Event event = (Event) obj;
        return Double.compare(event.value, this.value) == 0 && this.timestamp == event.timestamp && Objects.equal(this.eventTypeId, event.eventTypeId) && Objects.equal(this.trafficTypeName, event.trafficTypeName) && Objects.equal(this.key, event.key) && Objects.equal(this.properties, event.properties);
    }

    public int hashCode() {
        return Objects.hashCode(this.eventTypeId, this.trafficTypeName, this.key, Double.valueOf(this.value), Long.valueOf(this.timestamp));
    }
}
