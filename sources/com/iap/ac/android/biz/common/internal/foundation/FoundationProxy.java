package com.iap.ac.android.biz.common.internal.foundation;

import android.content.Context;
import com.google.common.base.Ascii;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.biz.common.model.InitConfig;
import com.iap.ac.android.common.log.ACLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class FoundationProxy {
    public static final String COMPONENT_AMCS = "amcs";
    public static final String COMPONENT_DIAGNOSE_LOG = "diagnoseLog";
    public static final String COMPONENT_GRADIENT = "gradient";
    public static final String COMPONENT_INSTANCE_ID = "instanceId";
    public static final String COMPONENT_LOG = "log";
    public static final String COMPONENT_NETWORK = "network";
    public static final String COMPONENT_USER_INFO = "userInfo";
    public static final Map<String, String> SUPPORTED_COMPONENT_MAP;
    public InitConfig initConfig;
    public String mBizCode;
    public CommonConfig mCommonConfig;
    public NetworkType mNetworkType = NetworkType.NETWORK_TYPE_ACRPC;
    public static final byte[] MyBillsEntityDataFactory = {Ascii.ETB, -59, 18, 83, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 207;
    public static Map<String, FoundationProxy> mFoundationProxyMap = new HashMap();

    /* loaded from: classes3.dex */
    public enum NetworkType {
        NETWORK_TYPE_ACRPC,
        NETWORK_TYPE_PROXY,
        NETWORK_TYPE_EXTERNAL
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SUPPORTED_COMPONENT_MAP = linkedHashMap;
        linkedHashMap.put("log", "com.iap.ac.android.biz.common.internal.foundation.facade.LogFacade");
        linkedHashMap.put("userInfo", "com.iap.ac.android.biz.common.internal.foundation.facade.UserInfoFacade");
        linkedHashMap.put(COMPONENT_INSTANCE_ID, "com.iap.ac.android.biz.common.internal.foundation.facade.InstanceInfoFacade");
        linkedHashMap.put("network", "com.iap.ac.android.biz.common.internal.foundation.facade.NetworkFacade");
        linkedHashMap.put("amcs", "com.iap.ac.android.biz.common.internal.foundation.facade.AmcsFacade");
        linkedHashMap.put(COMPONENT_GRADIENT, "com.iap.ac.android.biz.common.internal.foundation.facade.GradientFacade");
        linkedHashMap.put(COMPONENT_DIAGNOSE_LOG, "com.iap.ac.android.biz.common.internal.foundation.facade.DiagnoseLogFacade");
    }

    public FoundationProxy(String str) {
        this.mBizCode = str;
    }

    public static FoundationProxy getInstance(String str) {
        FoundationProxy foundationProxy;
        synchronized (FoundationProxy.class) {
            foundationProxy = mFoundationProxyMap.get(str);
            if (foundationProxy == null) {
                foundationProxy = new FoundationProxy(str);
                mFoundationProxyMap.put(str, foundationProxy);
            }
        }
        return foundationProxy;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0066 -> B:11:0x0071). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void invokeInitComponent(java.lang.String r18, android.content.Context r19, java.lang.String r20, com.iap.ac.android.biz.common.model.CommonConfig r21) throws java.lang.ClassNotFoundException, java.lang.NoSuchMethodException, java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r17 = this;
            java.lang.Class r0 = java.lang.Class.forName(r18)
            r1 = 3
            java.lang.Class[] r2 = new java.lang.Class[r1]
            byte[] r3 = com.iap.ac.android.biz.common.internal.foundation.FoundationProxy.MyBillsEntityDataFactory
            r4 = 23
            byte[] r5 = new byte[r4]
            r6 = 4
            r7 = 1
            r8 = 0
            if (r3 != 0) goto L23
            r9 = r2
            r10 = r9
            r11 = r3
            r12 = r5
            r1 = 23
            r13 = 4
            r14 = 3
            r15 = 0
            r2 = r20
            r3 = r21
            r5 = r0
            r0 = r19
            goto L71
        L23:
            r9 = 97
            r6 = r2
            r9 = r6
            r10 = r3
            r11 = r5
            r12 = 97
            r13 = 4
            r14 = 0
            r2 = r20
            r3 = r21
            r5 = r0
            r0 = r19
        L34:
            int r15 = r14 + 1
            byte r1 = (byte) r12
            r11[r14] = r1
            if (r15 != r4) goto L66
            java.lang.String r1 = new java.lang.String
            r1.<init>(r11, r8)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            r6[r8] = r1
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            r9[r7] = r1
            java.lang.Class<com.iap.ac.android.biz.common.model.CommonConfig> r1 = com.iap.ac.android.biz.common.model.CommonConfig.class
            r4 = 2
            r9[r4] = r1
            java.lang.String r1 = "initComponent"
            java.lang.reflect.Method r1 = r5.getDeclaredMethod(r1, r9)
            java.lang.Object r5 = r5.newInstance()
            r14 = 3
            java.lang.Object[] r6 = new java.lang.Object[r14]
            r6[r8] = r0
            r6[r7] = r2
            r6[r4] = r3
            r1.invoke(r5, r6)
            return
        L66:
            r14 = 3
            r1 = r10[r13]
            r16 = r9
            r9 = r6
            r6 = r12
            r12 = r11
            r11 = r10
            r10 = r16
        L71:
            int r1 = -r1
            int r6 = r6 + r1
            int r13 = r13 + r7
            int r1 = r6 + (-8)
            r6 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r14 = r15
            r12 = r1
            r1 = 3
            goto L34
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.biz.common.internal.foundation.FoundationProxy.invokeInitComponent(java.lang.String, android.content.Context, java.lang.String, com.iap.ac.android.biz.common.model.CommonConfig):void");
    }

    public String getGateWayUrl() {
        CommonConfig commonConfig = this.mCommonConfig;
        if (commonConfig != null) {
            return commonConfig.gatewayUrl;
        }
        return null;
    }

    public NetworkType getNetworkType() {
        return this.mNetworkType;
    }

    public void init(Context context, CommonConfig commonConfig) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(SUPPORTED_COMPONENT_MAP.keySet());
        init(context, commonConfig, linkedHashSet);
    }

    public void setNetworkType(NetworkType networkType) {
        this.mNetworkType = networkType;
    }

    public void init(Context context, CommonConfig commonConfig, Set<String> set) {
        this.mCommonConfig = commonConfig;
        if (commonConfig == null || set == null) {
            return;
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            try {
                invokeInitComponent(SUPPORTED_COMPONENT_MAP.get(it.next()), context, this.mBizCode, commonConfig);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("init exception:");
                sb.append(e);
                ACLog.e(Constants.TAG, sb.toString());
            }
        }
    }
}
