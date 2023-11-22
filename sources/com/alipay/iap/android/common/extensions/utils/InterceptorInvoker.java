package com.alipay.iap.android.common.extensions.utils;

import com.alipay.iap.android.common.errorcode.IAPError;
import com.alipay.iap.android.common.extensions.interceptor.IFilterInterceptor;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class InterceptorInvoker {
    public static <Request, Response> IAPError beforeExecute(List<IFilterInterceptor<Request, Response>> list, Request request) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Iterator<IFilterInterceptor<Request, Response>> it = list.iterator();
        while (it.hasNext()) {
            IAPError beforeExecute = it.next().beforeExecute(request);
            if (beforeExecute != null) {
                return beforeExecute;
            }
        }
        return null;
    }

    public static <Request, Response> IAPError afterExecute(List<IFilterInterceptor<Request, Response>> list, Response response) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Iterator<IFilterInterceptor<Request, Response>> it = list.iterator();
        while (it.hasNext()) {
            IAPError afterExecute = it.next().afterExecute(response);
            if (afterExecute != null) {
                return afterExecute;
            }
        }
        return null;
    }
}
