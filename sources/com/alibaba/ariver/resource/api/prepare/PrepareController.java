package com.alibaba.ariver.resource.api.prepare;

import com.alibaba.ariver.resource.api.models.AppModel;
import java.util.List;

/* loaded from: classes3.dex */
public interface PrepareController {
    void finish();

    Status getStatus();

    void lock(Object obj);

    void moveToError(PrepareException prepareException);

    void moveToNext();

    void onGetAppInfo(AppModel appModel);

    void postTimeOut(long j);

    void setInterceptors(List<StepInterceptor> list);

    void start();

    void unlock(Object obj);

    /* loaded from: classes6.dex */
    public enum Status {
        INIT,
        EXECUTING,
        ERROR,
        FINISH;

        public final boolean canContinue() {
            return this == INIT || this == EXECUTING;
        }
    }
}
