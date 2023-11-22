package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.mixpanel.android.util.MPLog;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ConnectIntegrations {
    final MixpanelAPI BuiltInFictitiousFunctionClassFactory;
    Context KClassImpl$Data$declaredNonStaticMembers$2;
    private String MyBillsEntityDataFactory;
    private int moveToNextValue;
    public static final byte[] getAuthRequestContext = {114, -79, -70, 22, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int PlaceComponentResult = 226;

    public ConnectIntegrations(MixpanelAPI mixpanelAPI, Context context) {
        this.BuiltInFictitiousFunctionClassFactory = mixpanelAPI;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory() {
        try {
            Object invoke = Class.forName("com.urbanairship.UAirship").getMethod("shared", new Class[0]).invoke(null, new Object[0]);
            Object invoke2 = invoke.getClass().getMethod("getPushManager", new Class[0]).invoke(invoke, new Object[0]);
            String str = (String) invoke2.getClass().getMethod("getChannelId", new Class[0]).invoke(invoke2, new Object[0]);
            if (str != null && !str.isEmpty()) {
                this.moveToNextValue = 0;
                String str2 = this.MyBillsEntityDataFactory;
                if (str2 == null || !str2.equals(str)) {
                    this.BuiltInFictitiousFunctionClassFactory.scheduleImpl.MyBillsEntityDataFactory("$android_urban_airship_channel_id", str);
                    this.MyBillsEntityDataFactory = str;
                    return;
                }
                return;
            }
            int i = this.moveToNextValue + 1;
            this.moveToNextValue = i;
            if (i <= 3) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.mixpanel.android.mpmetrics.ConnectIntegrations.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ConnectIntegrations.this.BuiltInFictitiousFunctionClassFactory();
                    }
                }, 2000L);
            }
        } catch (ClassNotFoundException e) {
            MPLog.BuiltInFictitiousFunctionClassFactory("MixpanelAPI.CnctInts", "Airship SDK not found but Urban Airship is integrated on Mixpanel", e);
        } catch (IllegalAccessException e2) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.CnctInts", "method invocation failed", e2);
        } catch (NoSuchMethodException e3) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.CnctInts", "Airship SDK class exists but methods do not", e3);
        } catch (InvocationTargetException e4) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.CnctInts", "method invocation failed", e4);
        } catch (Exception e5) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.CnctInts", "Error setting Airship people property", e5);
        }
    }
}
