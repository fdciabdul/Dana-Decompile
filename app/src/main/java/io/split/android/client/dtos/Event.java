package io.split.android.client.dtos;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import io.split.android.client.storage.common.InBytesSizable;
import io.split.android.client.utils.deserializer.EventDeserializer;

@JsonAdapter(EventDeserializer.class)
/* loaded from: classes6.dex */
public class Event extends SerializableEvent implements InBytesSizable, Identifiable {
    public static final String SIZE_IN_BYTES_FIELD = "sizeInBytes";
    @SerializedName(SIZE_IN_BYTES_FIELD)
    private int sizeInBytes = 0;
    public transient long storageId;

    public void setSizeInBytes(int i) {
        this.sizeInBytes = i;
    }

    @Override // io.split.android.client.storage.common.InBytesSizable
    public long getSizeInBytes() {
        return this.sizeInBytes;
    }

    @Override // io.split.android.client.dtos.Identifiable
    public long getId() {
        return this.storageId;
    }
}
