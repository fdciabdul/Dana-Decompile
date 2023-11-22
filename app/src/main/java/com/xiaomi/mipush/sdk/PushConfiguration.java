package com.xiaomi.mipush.sdk;

import com.xiaomi.push.service.module.PushChannelRegion;

/* loaded from: classes8.dex */
public class PushConfiguration {
    String BuiltInFictitiousFunctionClassFactory;
    private PushChannelRegion NetworkUserEntityData$$ExternalSyntheticLambda0 = PushChannelRegion.Global;
    private boolean MyBillsEntityDataFactory = false;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
    private boolean getAuthRequestContext = false;
    private boolean PlaceComponentResult = false;

    /* loaded from: classes8.dex */
    public static class PushConfigurationBuilder {
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.getAuthRequestContext;
    }

    public final boolean PlaceComponentResult() {
        return this.MyBillsEntityDataFactory;
    }

    public final boolean getAuthRequestContext() {
        return this.PlaceComponentResult;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PushConfiguration{");
        stringBuffer.append("Region:");
        PushChannelRegion pushChannelRegion = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        stringBuffer.append(pushChannelRegion == null ? "null" : pushChannelRegion.name());
        StringBuilder sb = new StringBuilder();
        sb.append(",mOpenHmsPush:");
        sb.append(this.MyBillsEntityDataFactory);
        stringBuffer.append(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(",mOpenFCMPush:");
        sb2.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        stringBuffer.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(",mOpenCOSPush:");
        sb3.append(this.getAuthRequestContext);
        stringBuffer.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(",mOpenFTOSPush:");
        sb4.append(this.PlaceComponentResult);
        stringBuffer.append(sb4.toString());
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
