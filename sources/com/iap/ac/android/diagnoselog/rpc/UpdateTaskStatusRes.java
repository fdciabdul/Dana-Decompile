package com.iap.ac.android.diagnoselog.rpc;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class UpdateTaskStatusRes implements Serializable {
    private Boolean success;

    public Boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean bool) {
        this.success = bool;
    }
}
