package com.huawei.hms.support.api.client;

import com.huawei.hms.core.aidl.IMessageEntity;

/* loaded from: classes8.dex */
public abstract class Result implements IMessageEntity {
    private Status status = Status.FAILURE;

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        if (status == null) {
            return;
        }
        this.status = status;
    }
}
