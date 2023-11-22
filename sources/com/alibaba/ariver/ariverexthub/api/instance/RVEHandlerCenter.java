package com.alibaba.ariver.ariverexthub.api.instance;

import android.text.TextUtils;
import com.alibaba.ariver.ariverexthub.api.RVEApiHandler;
import com.alibaba.ariver.ariverexthub.api.model.RVEApiInfo;
import com.alibaba.ariver.ariverexthub.api.model.RVEApp;
import com.alibaba.ariver.ariverexthub.api.model.RVEExecutorType;
import com.alibaba.ariver.ariverexthub.api.utils.ExtHubLogger;
import com.alibaba.ariver.ariverexthub.api.utils.RVEReflectUtil;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class RVEHandlerCenter {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, RVEApp> f6002a;
    private final ConcurrentHashMap<String, RVEApiHandler> b;

    public static RVEHandlerCenter getInstance() {
        return RVEAppCenterHolder.f6003a;
    }

    /* loaded from: classes3.dex */
    static class RVEAppCenterHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final RVEHandlerCenter f6003a = new RVEHandlerCenter();

        private RVEAppCenterHolder() {
        }
    }

    private RVEHandlerCenter() {
        this.f6002a = new ConcurrentHashMap<>();
        this.b = new ConcurrentHashMap<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alibaba.ariver.ariverexthub.api.RVEApiHandler getGlobalHandler(java.lang.String r5, com.alibaba.ariver.ariverexthub.api.model.RVEApiInfo r6) {
        /*
            r4 = this;
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.alibaba.ariver.ariverexthub.api.RVEApiHandler> r0 = r4.b
            java.lang.String r1 = r6.handlerName
            java.lang.Object r0 = r0.get(r1)
            com.alibaba.ariver.ariverexthub.api.RVEApiHandler r0 = (com.alibaba.ariver.ariverexthub.api.RVEApiHandler) r0
            if (r0 != 0) goto L48
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "获取全局实现为空, apiName ="
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            java.lang.String r1 = "RVEHandlerCenter"
            com.alibaba.ariver.ariverexthub.api.utils.ExtHubLogger.d(r1, r5)
            java.lang.String r5 = r6.handlerName
            java.lang.Class r5 = com.alibaba.ariver.ariverexthub.api.utils.RVEReflectUtil.getApiClassForApiName(r5)     // Catch: java.lang.Exception -> L35
            java.lang.Object r5 = r5.newInstance()     // Catch: java.lang.Exception -> L35
            com.alibaba.ariver.ariverexthub.api.RVEApiHandler r5 = (com.alibaba.ariver.ariverexthub.api.RVEApiHandler) r5     // Catch: java.lang.Exception -> L35
            r5.onInitialized()     // Catch: java.lang.Exception -> L33
            goto L3e
        L33:
            r0 = move-exception
            goto L39
        L35:
            r5 = move-exception
            r3 = r0
            r0 = r5
            r5 = r3
        L39:
            java.lang.String r2 = "Service 初始化 handlerClass 出错"
            com.alibaba.ariver.ariverexthub.api.utils.ExtHubLogger.e(r1, r2, r0)
        L3e:
            r0 = r5
            if (r0 == 0) goto L48
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.alibaba.ariver.ariverexthub.api.RVEApiHandler> r5 = r4.b
            java.lang.String r6 = r6.handlerName
            r5.put(r6, r0)
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.ariverexthub.api.instance.RVEHandlerCenter.getGlobalHandler(java.lang.String, com.alibaba.ariver.ariverexthub.api.model.RVEApiInfo):com.alibaba.ariver.ariverexthub.api.RVEApiHandler");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alibaba.ariver.ariverexthub.api.RVEApiHandler getAppHandler(java.lang.String r6, java.lang.String r7, com.alibaba.ariver.ariverexthub.api.model.RVEApiInfo r8) {
        /*
            r5 = this;
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.alibaba.ariver.ariverexthub.api.model.RVEApp> r0 = r5.f6002a
            java.lang.Object r0 = r0.get(r6)
            com.alibaba.ariver.ariverexthub.api.model.RVEApp r0 = (com.alibaba.ariver.ariverexthub.api.model.RVEApp) r0
            java.lang.String r1 = "RVEHandlerCenter"
            if (r0 != 0) goto L2b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "获取app为空, appId ="
            r0.append(r2)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            com.alibaba.ariver.ariverexthub.api.utils.ExtHubLogger.d(r1, r0)
            com.alibaba.ariver.ariverexthub.api.model.RVEApp r0 = new com.alibaba.ariver.ariverexthub.api.model.RVEApp
            r0.<init>(r6)
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.alibaba.ariver.ariverexthub.api.model.RVEApp> r2 = r5.f6002a
            r2.put(r6, r0)
        L2b:
            java.lang.String r6 = r8.handlerName
            com.alibaba.ariver.ariverexthub.api.RVEApiHandler r6 = r0.getHandler(r6)
            if (r6 != 0) goto L6f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "获取app实现为空, apiName ="
            r2.append(r3)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            com.alibaba.ariver.ariverexthub.api.utils.ExtHubLogger.d(r1, r7)
            java.lang.String r7 = r8.handlerName
            java.lang.Class r7 = com.alibaba.ariver.ariverexthub.api.utils.RVEReflectUtil.getApiClassForApiName(r7)
            java.lang.Object r7 = r7.newInstance()     // Catch: java.lang.Exception -> L5a
            com.alibaba.ariver.ariverexthub.api.RVEApiHandler r7 = (com.alibaba.ariver.ariverexthub.api.RVEApiHandler) r7     // Catch: java.lang.Exception -> L5a
            r7.onInitialized()     // Catch: java.lang.Exception -> L58
            goto L63
        L58:
            r6 = move-exception
            goto L5e
        L5a:
            r7 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L5e:
            java.lang.String r2 = "App 初始化 handlerClass 出错"
            com.alibaba.ariver.ariverexthub.api.utils.ExtHubLogger.e(r1, r2, r6)
        L63:
            r6 = r7
            if (r6 == 0) goto L6f
            j$.util.concurrent.ConcurrentHashMap r7 = r0.getHandlers()
            java.lang.String r8 = r8.handlerName
            r7.put(r8, r6)
        L6f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.ariverexthub.api.instance.RVEHandlerCenter.getAppHandler(java.lang.String, java.lang.String, com.alibaba.ariver.ariverexthub.api.model.RVEApiInfo):com.alibaba.ariver.ariverexthub.api.RVEApiHandler");
    }

    public RVEApiHandler getSingalHandler(String str, RVEApiInfo rVEApiInfo) {
        Exception e;
        RVEApiHandler rVEApiHandler;
        StringBuilder sb = new StringBuilder();
        sb.append("获取singal handler，apiname = ");
        sb.append(str);
        ExtHubLogger.d("RVEHandlerCenter", sb.toString());
        try {
            rVEApiHandler = RVEReflectUtil.getApiClassForApiName(rVEApiInfo.handlerName).newInstance();
            try {
                rVEApiHandler.onInitialized();
            } catch (Exception e2) {
                e = e2;
                ExtHubLogger.e("RVEHandlerCenter", "App 初始化 handlerClass 出错", e);
                return rVEApiHandler;
            }
        } catch (Exception e3) {
            e = e3;
            rVEApiHandler = null;
        }
        return rVEApiHandler;
    }

    public void appDidDestory(final String str) {
        RVEProxyCenter.getInstance().getRVEThreadService().getExecutor(RVEExecutorType.NORMAL).execute(new Runnable() { // from class: com.alibaba.ariver.ariverexthub.api.instance.RVEHandlerCenter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    boolean isLiteProcess = RVEProxyCenter.getInstance().isLiteProcess();
                    StringBuilder sb = new StringBuilder();
                    sb.append("应用销毁，appId = ");
                    sb.append(str);
                    sb.append("当前是小程序的进程是：");
                    sb.append(isLiteProcess);
                    ExtHubLogger.d("RVEHandlerCenter", sb.toString());
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    RVEApp rVEApp = (RVEApp) RVEHandlerCenter.this.f6002a.get(str);
                    if (rVEApp != null) {
                        for (Map.Entry<String, RVEApiHandler> entry : rVEApp.getHandlers().entrySet()) {
                            entry.getValue().onDestory();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("handler 销毁，apiName = ");
                            sb2.append(entry.getKey());
                            ExtHubLogger.d("RVEHandlerCenter", sb2.toString());
                        }
                    }
                    RVEHandlerCenter.this.f6002a.remove(str);
                } catch (Exception e) {
                    ExtHubLogger.e("RVEHandlerCenter", "销毁api 实例出错", e);
                }
            }
        });
    }
}
