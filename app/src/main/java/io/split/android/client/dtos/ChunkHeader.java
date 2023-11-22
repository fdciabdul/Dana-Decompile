package io.split.android.client.dtos;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

/* loaded from: classes9.dex */
public class ChunkHeader {
    public static final Type CHUNK_HEADER_TYPE = new TypeToken<List<ChunkHeader>>() { // from class: io.split.android.client.dtos.ChunkHeader.1
    }.getType();
    private int attempt;

    /* renamed from: id  reason: collision with root package name */
    private String f8251id;
    private long timestamp;

    public ChunkHeader(String str, int i, long j) {
        this.f8251id = str;
        this.attempt = i;
        this.timestamp = j;
    }

    public ChunkHeader(String str, int i) {
        this(str, i, 0L);
    }

    public String getId() {
        return this.f8251id;
    }

    public int getAttempt() {
        return this.attempt;
    }

    public int getTimestamp() {
        return this.attempt;
    }
}
