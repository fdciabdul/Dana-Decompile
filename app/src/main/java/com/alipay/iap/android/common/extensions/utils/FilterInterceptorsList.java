package com.alipay.iap.android.common.extensions.utils;

import com.alipay.iap.android.common.errorcode.IAPError;
import com.alipay.iap.android.common.extensions.interceptor.IFilterInterceptor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class FilterInterceptorsList<Request, Response> {
    private List<IFilterInterceptor<Request, Response>> mInterceptors = new ArrayList();

    public void addInterceptor(IFilterInterceptor<Request, Response> iFilterInterceptor) {
        synchronized (this) {
            if (iFilterInterceptor != null) {
                this.mInterceptors.add(iFilterInterceptor);
            }
        }
    }

    public void removeInterceptor(IFilterInterceptor<Request, Response> iFilterInterceptor) {
        synchronized (this) {
            this.mInterceptors.remove(iFilterInterceptor);
        }
    }

    public void clear() {
        synchronized (this) {
            this.mInterceptors.clear();
        }
    }

    public List<IFilterInterceptor<Request, Response>> getInterceptors() {
        return this.mInterceptors;
    }

    public IAPError executeBefore(Request request) {
        IAPError beforeExecute;
        synchronized (this) {
            beforeExecute = InterceptorInvoker.beforeExecute(this.mInterceptors, request);
        }
        return beforeExecute;
    }

    public IAPError executeAfter(Response response) {
        IAPError afterExecute;
        synchronized (this) {
            afterExecute = InterceptorInvoker.afterExecute(this.mInterceptors, response);
        }
        return afterExecute;
    }
}
