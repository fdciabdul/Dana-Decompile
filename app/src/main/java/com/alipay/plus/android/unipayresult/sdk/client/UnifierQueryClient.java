package com.alipay.plus.android.unipayresult.sdk.client;

import com.alipay.plus.android.unipayresult.sdk.client.IUnifierQuery;
import com.alipay.plus.android.unipayresult.sdk.executor.AbstractUnifierQueryExecutor;
import com.alipay.plus.android.unipayresult.sdk.executor.UnifierSyncQueryExecutor;
import com.alipay.plus.android.unipayresult.sdk.executor.a.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class UnifierQueryClient implements IUnifierQuery {

    /* renamed from: a  reason: collision with root package name */
    private static UnifierQueryClient f7397a;
    private UnifierQueryClientContext c;
    private Map<String, IUnifierQuery.QueryConfig> b = new HashMap();
    private b d = new b();

    public static UnifierQueryClient getInstance() {
        if (f7397a == null) {
            f7397a = new UnifierQueryClient();
        }
        return f7397a;
    }

    public UnifierQueryClientContext getClientContext() {
        return this.c;
    }

    public void initialize(UnifierQueryClientContext unifierQueryClientContext) {
        this.c = unifierQueryClientContext;
    }

    @Override // com.alipay.plus.android.unipayresult.sdk.client.IUnifierQuery
    public boolean isQueryingNow(String str) {
        return this.b.get(str) != null;
    }

    @Override // com.alipay.plus.android.unipayresult.sdk.client.IUnifierQuery
    public void startQuery(IUnifierQuery.QueryConfig queryConfig) {
        if (queryConfig.isValid()) {
            this.b.put(queryConfig.mBizType, queryConfig);
            for (AbstractUnifierQueryExecutor abstractUnifierQueryExecutor : queryConfig.mQueryExecutors) {
                if (abstractUnifierQueryExecutor instanceof UnifierSyncQueryExecutor) {
                    this.d.a();
                    ((UnifierSyncQueryExecutor) abstractUnifierQueryExecutor).setSyncCenter(this.d);
                }
                abstractUnifierQueryExecutor.setQueryConfig(queryConfig);
                abstractUnifierQueryExecutor.setPayResultHandler(queryConfig.mPayResultHandler);
                abstractUnifierQueryExecutor.start();
            }
        }
    }

    @Override // com.alipay.plus.android.unipayresult.sdk.client.IUnifierQuery
    public void stopQuery(String str) {
        IUnifierQuery.QueryConfig queryConfig = this.b.get(str);
        if (queryConfig == null) {
            return;
        }
        Iterator<AbstractUnifierQueryExecutor> it = queryConfig.mQueryExecutors.iterator();
        while (it.hasNext()) {
            it.next().stop();
        }
    }
}
