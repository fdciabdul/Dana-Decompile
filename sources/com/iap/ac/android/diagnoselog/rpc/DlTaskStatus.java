package com.iap.ac.android.diagnoselog.rpc;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;

/* loaded from: classes3.dex */
public interface DlTaskStatus {
    @OperationType("ap.mobileamcs.diagnose.update.task.status")
    @SignCheck
    UpdateTaskStatusRes updateTaskStatus(UpdateTaskStatusReq updateTaskStatusReq);
}
