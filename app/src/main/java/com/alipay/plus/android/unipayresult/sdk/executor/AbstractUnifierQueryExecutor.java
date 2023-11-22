package com.alipay.plus.android.unipayresult.sdk.executor;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.plus.android.unipayresult.sdk.callback.IUnifierPayResultHandler;
import com.alipay.plus.android.unipayresult.sdk.client.IUnifierQuery;
import com.alipay.plus.android.unipayresult.sdk.executor.a.a;
import com.alipay.plus.android.unipayresult.sdk.request.IUnifierQueryDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class AbstractUnifierQueryExecutor {
    protected Context mContext;
    protected boolean mIsHandlingResult;
    protected IUnifierPayResultHandler mPayResultHandler;
    protected IUnifierQuery.QueryConfig mQueryConfig;
    protected IUnifierQueryDelegate mQueryDelegate;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractUnifierQueryExecutor(Context context, IUnifierQueryDelegate iUnifierQueryDelegate) {
        this.mContext = context.getApplicationContext();
        this.mQueryDelegate = iUnifierQueryDelegate;
    }

    public Context getContext() {
        return this.mContext;
    }

    public IUnifierQuery.QueryConfig getQueryConfig() {
        return this.mQueryConfig;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handlePayResultInternal(String str) {
        String str2;
        if (!this.mIsHandlingResult) {
            str2 = "in handlePayResult! but query task stopped. do NOTHING!";
        } else if (!TextUtils.isEmpty(str)) {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<Object> it = JSON.parseArray(str).iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toString());
                }
                handlePayResultInternal(arrayList);
                return;
            } catch (Exception e) {
                LoggerWrapper.e("AbstractUnifierQueryExecutor", "Cannot parse Order List!", e);
                return;
            }
        } else {
            str2 = "pay order info is empty! do NOTHING!";
        }
        LoggerWrapper.e("AbstractUnifierQueryExecutor", str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handlePayResultInternal(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            UnifierPayResultInfo unifierPayResultInfo = new UnifierPayResultInfo();
            if (this.mQueryConfig.mDeserializeBizOrderClazz != null) {
                unifierPayResultInfo.mBizOrderInfo = JSON.parseObject(str, this.mQueryConfig.mDeserializeBizOrderClazz);
            }
            this.mQueryDelegate.parseBizResultInfo(str, unifierPayResultInfo);
            IUnifierPayResultHandler iUnifierPayResultHandler = this.mPayResultHandler;
            if (iUnifierPayResultHandler != null && iUnifierPayResultHandler.handlePayResult(unifierPayResultInfo)) {
                arrayList.add(unifierPayResultInfo);
            }
        }
        a.a(this.mQueryConfig.mBizType, arrayList);
    }

    public void setPayResultHandler(IUnifierPayResultHandler iUnifierPayResultHandler) {
        this.mPayResultHandler = iUnifierPayResultHandler;
    }

    public void setQueryConfig(IUnifierQuery.QueryConfig queryConfig) {
        this.mQueryConfig = queryConfig;
    }

    public void setQueryDelegate(IUnifierQueryDelegate iUnifierQueryDelegate) {
        this.mQueryDelegate = iUnifierQueryDelegate;
    }

    public abstract void start();

    public abstract void stop();
}
