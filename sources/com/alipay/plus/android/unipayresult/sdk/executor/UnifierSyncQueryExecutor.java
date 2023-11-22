package com.alipay.plus.android.unipayresult.sdk.executor;

import android.content.Context;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.plus.android.unipayresult.sdk.executor.a.b;
import com.alipay.plus.android.unipayresult.sdk.request.IUnifierQueryDelegate;
import java.util.List;

/* loaded from: classes3.dex */
public class UnifierSyncQueryExecutor extends AbstractUnifierQueryExecutor implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private b f7399a;

    public UnifierSyncQueryExecutor(Context context, IUnifierQueryDelegate iUnifierQueryDelegate) {
        super(context, iUnifierQueryDelegate);
    }

    @Override // com.alipay.plus.android.unipayresult.sdk.executor.a.b.a
    public void handleSyncMessage(List<String> list) {
        if (this.mQueryConfig == null) {
            LoggerWrapper.e("UnifierSyncQueryExecutor", "setQueryConfig should be called first");
            return;
        }
        LoggerWrapper.i("UnifierSyncQueryExecutor", String.format("Receive sync message for: bizType = %s", this.mQueryConfig.mBizType));
        handlePayResultInternal(list);
    }

    public void setSyncCenter(b bVar) {
        this.f7399a = bVar;
    }

    @Override // com.alipay.plus.android.unipayresult.sdk.executor.AbstractUnifierQueryExecutor
    public void start() {
        if (this.mQueryConfig == null) {
            LoggerWrapper.e("UnifierSyncQueryExecutor", "setQueryConfig should be called first");
        } else if (this.f7399a == null) {
            LoggerWrapper.e("UnifierSyncQueryExecutor", "setSyncCenter should be called first");
        } else {
            LoggerWrapper.i("UnifierSyncQueryExecutor", String.format("Start sync pay result: bizType = %s", this.mQueryConfig.mBizType));
            this.f7399a.a(this.mQueryConfig.mBizType, this);
        }
    }

    @Override // com.alipay.plus.android.unipayresult.sdk.executor.AbstractUnifierQueryExecutor
    public void stop() {
        if (this.mQueryConfig == null) {
            LoggerWrapper.e("UnifierSyncQueryExecutor", "setQueryConfig should be called first");
        } else if (this.f7399a == null) {
            LoggerWrapper.e("UnifierSyncQueryExecutor", "setSyncCenter should be called first");
        } else {
            LoggerWrapper.i("UnifierSyncQueryExecutor", String.format("Stop sync pay result: bizType = %s", this.mQueryConfig.mBizType));
            this.f7399a.b(this.mQueryConfig.mBizType, this);
        }
    }
}
