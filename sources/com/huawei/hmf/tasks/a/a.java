package com.huawei.hmf.tasks.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public final class a {
    static final int BuiltInFictitiousFunctionClassFactory;
    static final int KClassImpl$Data$declaredNonStaticMembers$2;
    private static final a MyBillsEntityDataFactory = new a();
    private static final int getAuthRequestContext;
    private final Executor PlaceComponentResult = new ExecutorC0114a(0);

    /* renamed from: com.huawei.hmf.tasks.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static final class ExecutorC0114a implements Executor {
        private ExecutorC0114a() {
        }

        /* synthetic */ ExecutorC0114a(byte b) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        getAuthRequestContext = availableProcessors;
        KClassImpl$Data$declaredNonStaticMembers$2 = availableProcessors + 1;
        BuiltInFictitiousFunctionClassFactory = (availableProcessors * 2) + 1;
    }

    public static ExecutorService MyBillsEntityDataFactory() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
