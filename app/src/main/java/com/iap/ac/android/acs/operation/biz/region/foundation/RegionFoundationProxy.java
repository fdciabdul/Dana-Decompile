package com.iap.ac.android.acs.operation.biz.region.foundation;

import android.content.Context;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.iap.ac.android.acs.operation.biz.region.config.RegionCommonConfig;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.common.log.ACLog;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class RegionFoundationProxy {
    public static final String COMPONENT_LOG = "log";
    public static final String COMPONENT_NETWORK = "network";
    public static final String COMPONENT_USER_INFO = "userInfo";
    public static final Map<String, String> SUPPORTED_COMPONENT_MAP;
    public static final Map<String, String> SUPPORTED_REGION_COMPONENT_MAP;
    public static RegionFoundationProxy proxy;
    public static final byte[] MyBillsEntityDataFactory = {121, 107, -47, -24, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int BuiltInFictitiousFunctionClassFactory = BlobStatic.MONITOR_IMAGE_WIDTH;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SUPPORTED_COMPONENT_MAP = linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        SUPPORTED_REGION_COMPONENT_MAP = linkedHashMap2;
        linkedHashMap.put("log", "com.iap.ac.android.biz.common.internal.foundation.facade.LogFacade");
        linkedHashMap2.put("userInfo", "com.iap.ac.android.acs.operation.biz.region.foundation.facade.RegionUserInfoFacade");
        linkedHashMap2.put("network", "com.iap.ac.android.acs.operation.biz.region.foundation.facade.RegionNetworkFacade");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.Object[] r6) {
        /*
            byte[] r0 = com.iap.ac.android.acs.operation.biz.region.foundation.RegionFoundationProxy.MyBillsEntityDataFactory
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 4
            r3 = 97
            r4 = -1
            if (r0 != 0) goto L10
            r3 = 4
            r5 = 97
            goto L27
        L10:
            r2 = 97
            r3 = 4
        L13:
            int r4 = r4 + 1
            byte r5 = (byte) r2
            r1[r4] = r5
            r5 = 22
            if (r4 != r5) goto L25
            java.lang.String r0 = new java.lang.String
            r2 = 0
            r0.<init>(r1, r2)
            r6[r2] = r0
            return
        L25:
            r5 = r0[r3]
        L27:
            int r5 = -r5
            int r2 = r2 + r5
            int r2 = r2 + (-8)
            int r3 = r3 + 1
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.acs.operation.biz.region.foundation.RegionFoundationProxy.a(java.lang.Object[]):void");
    }

    public static RegionFoundationProxy getInstance() {
        RegionFoundationProxy regionFoundationProxy;
        synchronized (RegionFoundationProxy.class) {
            if (proxy == null) {
                proxy = new RegionFoundationProxy();
            }
            regionFoundationProxy = proxy;
        }
        return regionFoundationProxy;
    }

    private void invokeInitComponent(String str, Context context, String str2, CommonConfig commonConfig) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> cls = Class.forName(str);
        Object[] objArr = new Object[1];
        a(objArr);
        cls.getDeclaredMethod("initComponent", Class.forName((String) objArr[0]), String.class, CommonConfig.class).invoke(cls.newInstance(), context, str2, commonConfig);
    }

    public void init(Context context, CommonConfig commonConfig, RegionCommonConfig regionCommonConfig) {
        init(context, commonConfig);
        init(context, regionCommonConfig);
    }

    public void init(Context context, CommonConfig commonConfig) {
        if (commonConfig == null) {
            return;
        }
        Iterator<String> it = SUPPORTED_COMPONENT_MAP.keySet().iterator();
        while (it.hasNext()) {
            try {
                invokeInitComponent(SUPPORTED_COMPONENT_MAP.get(it.next()), context, "region_biz", commonConfig);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("init exception:");
                sb.append(e);
                ACLog.e("IAPConnectPlugin", sb.toString());
            }
        }
    }

    private void invokeInitComponent(String str, Context context, String str2, RegionCommonConfig regionCommonConfig) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> cls = Class.forName(str);
        Object[] objArr = new Object[1];
        a(objArr);
        cls.getDeclaredMethod("initComponent", Class.forName((String) objArr[0]), String.class, RegionCommonConfig.class).invoke(cls.newInstance(), context, str2, regionCommonConfig);
    }

    public void init(Context context, RegionCommonConfig regionCommonConfig) {
        if (regionCommonConfig == null) {
            return;
        }
        Iterator<String> it = SUPPORTED_REGION_COMPONENT_MAP.keySet().iterator();
        while (it.hasNext()) {
            try {
                invokeInitComponent(SUPPORTED_REGION_COMPONENT_MAP.get(it.next()), context, "region_biz", regionCommonConfig);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("init exception:");
                sb.append(e);
                ACLog.e("IAPConnectPlugin", sb.toString());
            }
        }
    }
}
