package com.huawei.hms.common.internal;

import com.huawei.hmf.tasks.TaskCompletionSource;

/* loaded from: classes7.dex */
public class TaskApiCallWrapper<TResult> extends BaseContentWrapper {
    private final TaskApiCall<? extends AnyClient, TResult> mTaskApiCall;
    private final TaskCompletionSource<TResult> mTaskCompletionSource;

    public TaskApiCallWrapper(TaskApiCall<? extends AnyClient, TResult> taskApiCall, TaskCompletionSource<TResult> taskCompletionSource) {
        super(1);
        this.mTaskApiCall = taskApiCall;
        this.mTaskCompletionSource = taskCompletionSource;
    }

    public TaskApiCall<? extends AnyClient, TResult> getTaskApiCall() {
        return this.mTaskApiCall;
    }

    public TaskCompletionSource<TResult> getTaskCompletionSource() {
        return this.mTaskCompletionSource;
    }
}
