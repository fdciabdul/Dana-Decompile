package com.alipay.imobile.network.quake;

import java.io.Serializable;
import java.util.Map;

/* loaded from: classes3.dex */
public class NetworkResponse implements Serializable {
    public final byte[] data;
    public final Map<String, String> extData;
    public final long networkTimeMs;
    public final boolean notModified;
    public final int statusCode;

    public NetworkResponse(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this.statusCode = i;
        this.data = bArr;
        this.extData = map;
        this.notModified = z;
        this.networkTimeMs = j;
    }

    public NetworkResponse(int i, byte[] bArr, Map<String, String> map) {
        this(i, bArr, map, false, 0L);
    }

    public NetworkResponse(int i, byte[] bArr, boolean z) {
        this(i, bArr, null, z, 0L);
    }

    public NetworkResponse(int i, byte[] bArr) {
        this(i, bArr, null, false, 0L);
    }

    public NetworkResponse(byte[] bArr) {
        this(0, bArr, null, false, 0L);
    }
}
