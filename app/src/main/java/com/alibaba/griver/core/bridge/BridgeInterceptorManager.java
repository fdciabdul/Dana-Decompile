package com.alibaba.griver.core.bridge;

import android.text.TextUtils;
import com.alibaba.griver.api.bridge.BridgeInterceptor;
import com.alibaba.griver.base.common.logger.GriverLogger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class BridgeInterceptorManager {
    private static volatile BridgeInterceptorManager b;

    /* renamed from: a  reason: collision with root package name */
    private Map<String, BridgeInterceptor> f6392a = new HashMap();

    private BridgeInterceptorManager() {
    }

    public static BridgeInterceptorManager getInstance() {
        if (b == null) {
            synchronized (BridgeInterceptorManager.class) {
                if (b == null) {
                    b = new BridgeInterceptorManager();
                }
            }
        }
        return b;
    }

    public void register(String str, BridgeInterceptor bridgeInterceptor) {
        synchronized (this) {
            if (TextUtils.isEmpty(str) || bridgeInterceptor == null) {
                GriverLogger.w("BridgeInterceptorManager", "invalid parameters, return directly");
                return;
            }
            this.f6392a.put(str, bridgeInterceptor);
            StringBuilder sb = new StringBuilder();
            sb.append("register jsapi interceptor for ");
            sb.append(str);
            sb.append(" success, interceptor: ");
            sb.append(bridgeInterceptor);
            GriverLogger.d("BridgeInterceptorManager", sb.toString());
        }
    }

    public void unregister(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                GriverLogger.w("BridgeInterceptorManager", "invalid param, unregister jsapi interceptor failed");
                return;
            }
            this.f6392a.remove(str);
            StringBuilder sb = new StringBuilder();
            sb.append("unregister interceptor for ");
            sb.append(str);
            GriverLogger.d("BridgeInterceptorManager", sb.toString());
        }
    }

    public BridgeInterceptor getBridgeInterceptor(String str) {
        return this.f6392a.get(str);
    }
}
