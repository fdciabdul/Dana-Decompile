package com.alibaba.ariver.engine.rve;

import com.alibaba.ariver.ariverexthub.api.RVEContext;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.remote.RemoteCallbackPool;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class RVEContextPool {
    private static RVEContextPool sInstance;
    private final WeakHashMap<RVEContext, NativeCallContext> weakHashMap = new WeakHashMap<>();

    private RVEContextPool() {
    }

    public static RVEContextPool getInstance() {
        if (sInstance == null) {
            synchronized (RemoteCallbackPool.class) {
                if (sInstance == null) {
                    sInstance = new RVEContextPool();
                }
            }
        }
        return sInstance;
    }

    public void setCallback(RVEContext rVEContext, NativeCallContext nativeCallContext) {
        synchronized (this) {
            this.weakHashMap.put(rVEContext, nativeCallContext);
        }
    }

    public NativeCallContext getCallback(RVEContext rVEContext) {
        NativeCallContext nativeCallContext;
        synchronized (this) {
            nativeCallContext = this.weakHashMap.get(rVEContext);
        }
        return nativeCallContext;
    }

    public void removeCallbackContext(RVEContext rVEContext) {
        synchronized (this) {
            this.weakHashMap.remove(rVEContext);
        }
    }
}
