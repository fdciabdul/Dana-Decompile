package com.huawei.hms.push;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class v {
    public static final Object getAuthRequestContext = new Object();
    public static ThreadPoolExecutor BuiltInFictitiousFunctionClassFactory = new ThreadPoolExecutor(1, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static ThreadPoolExecutor getAuthRequestContext() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (getAuthRequestContext) {
            threadPoolExecutor = BuiltInFictitiousFunctionClassFactory;
        }
        return threadPoolExecutor;
    }
}
