package com.huawei.hms.push.task;

/* loaded from: classes8.dex */
public class ConsentTask extends BaseVoidTask {
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 3;
    }

    @Override // com.huawei.hms.push.task.BaseVoidTask, com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 60300300;
    }
}
