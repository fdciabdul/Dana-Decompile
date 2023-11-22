package com.alipay.plus.android.unipayresult.sdk.client;

import android.text.TextUtils;
import com.alipay.plus.android.unipayresult.sdk.callback.IUnifierPayResultHandler;
import com.alipay.plus.android.unipayresult.sdk.executor.AbstractUnifierQueryExecutor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public interface IUnifierQuery {

    /* loaded from: classes3.dex */
    public static class QueryConfig {
        public String mBizType;
        public Class<?> mDeserializeBizOrderClazz;
        public IUnifierPayResultHandler mPayResultHandler;
        public List<AbstractUnifierQueryExecutor> mQueryExecutors;

        public QueryConfig(String str) {
            this.mBizType = str;
        }

        public QueryConfig addQueryExecutor(AbstractUnifierQueryExecutor abstractUnifierQueryExecutor) {
            if (this.mQueryExecutors == null) {
                this.mQueryExecutors = new ArrayList();
            }
            this.mQueryExecutors.add(abstractUnifierQueryExecutor);
            return this;
        }

        public boolean isValid() {
            List<AbstractUnifierQueryExecutor> list;
            return (TextUtils.isEmpty(this.mBizType) || (list = this.mQueryExecutors) == null || list.isEmpty()) ? false : true;
        }

        public QueryConfig setDeserializeBizOrderClazz(Class<?> cls) {
            this.mDeserializeBizOrderClazz = cls;
            return this;
        }

        public QueryConfig setPayResultHandler(IUnifierPayResultHandler iUnifierPayResultHandler) {
            this.mPayResultHandler = iUnifierPayResultHandler;
            return this;
        }
    }

    boolean isQueryingNow(String str);

    void startQuery(QueryConfig queryConfig);

    void stopQuery(String str);
}
