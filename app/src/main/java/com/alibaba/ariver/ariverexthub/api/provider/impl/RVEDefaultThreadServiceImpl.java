package com.alibaba.ariver.ariverexthub.api.provider.impl;

import android.os.Handler;
import android.os.Looper;
import com.alibaba.ariver.ariverexthub.api.model.RVEExecutorType;
import com.alibaba.ariver.ariverexthub.api.provider.RVEThreadService;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class RVEDefaultThreadServiceImpl implements RVEThreadService {

    /* renamed from: a  reason: collision with root package name */
    private Handler f6009a = new Handler(Looper.getMainLooper());
    private Executor b = new Executor() { // from class: com.alibaba.ariver.ariverexthub.api.provider.impl.RVEDefaultThreadServiceImpl.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            RVEDefaultThreadServiceImpl.this.f6009a.post(runnable);
        }
    };
    private Map<RVEExecutorType, Executor> c = new ConcurrentHashMap();

    /* renamed from: com.alibaba.ariver.ariverexthub.api.provider.impl.RVEDefaultThreadServiceImpl$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$ariverexthub$api$model$RVEExecutorType;

        static {
            int[] iArr = new int[RVEExecutorType.values().length];
            $SwitchMap$com$alibaba$ariver$ariverexthub$api$model$RVEExecutorType = iArr;
            try {
                iArr[RVEExecutorType.UI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$ariverexthub$api$model$RVEExecutorType[RVEExecutorType.IO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$ariverexthub$api$model$RVEExecutorType[RVEExecutorType.NETWORK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$ariverexthub$api$model$RVEExecutorType[RVEExecutorType.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.alibaba.ariver.ariverexthub.api.provider.RVEThreadService
    public Executor getExecutor(final RVEExecutorType rVEExecutorType) {
        if (AnonymousClass3.$SwitchMap$com$alibaba$ariver$ariverexthub$api$model$RVEExecutorType[rVEExecutorType.ordinal()] == 1) {
            return this.b;
        }
        Executor executor = this.c.get(rVEExecutorType);
        if (executor == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 10, 1L, TimeUnit.HOURS, new ArrayBlockingQueue(1), new ThreadFactory() { // from class: com.alibaba.ariver.ariverexthub.api.provider.impl.RVEDefaultThreadServiceImpl.2
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    return new Thread(runnable, rVEExecutorType.name());
                }
            });
            this.c.put(rVEExecutorType, threadPoolExecutor);
            return threadPoolExecutor;
        }
        return executor;
    }
}
