package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.client.Status;

/* loaded from: classes7.dex */
public class AbstractMessageEntity implements IMessageEntity {
    @Packed
    private Status PlaceComponentResult;

    public Status getCommonStatus() {
        return this.PlaceComponentResult;
    }

    public void setCommonStatus(Status status) {
        this.PlaceComponentResult = status;
    }
}
