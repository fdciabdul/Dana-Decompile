package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes7.dex */
public class ResponseHeader implements IMessageEntity {
    @Packed
    protected int PlaceComponentResult;

    public final int getAuthRequestContext() {
        return this.PlaceComponentResult;
    }
}
