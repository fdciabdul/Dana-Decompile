package com.huawei.hms.core.aidl;

/* loaded from: classes7.dex */
public final class CodecLookup {
    private CodecLookup() {
    }

    public static MessageCodec getAuthRequestContext(int i) {
        if (i == 2) {
            return new a();
        }
        return new MessageCodec();
    }
}
