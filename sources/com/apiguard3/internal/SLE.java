package com.apiguard3.internal;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class SLE implements Serializable {
    private static final long serialVersionUID = -1908426775837684290L;

    /* renamed from: id  reason: collision with root package name */
    public String f7413id;
    public Number timeStamp;

    public SLE(String str, long j) {
        this.f7413id = str;
        this.timeStamp = Long.valueOf(j);
    }
}
