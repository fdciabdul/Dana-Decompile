package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: classes8.dex */
public class ci extends cj {
    boolean BuiltInFictitiousFunctionClassFactory;
    String GetContactSyncConfig;
    boolean KClassImpl$Data$declaredNonStaticMembers$2;
    String MyBillsEntityDataFactory;
    String NetworkUserEntityData$$ExternalSyntheticLambda0;
    String NetworkUserEntityData$$ExternalSyntheticLambda1;
    String NetworkUserEntityData$$ExternalSyntheticLambda2;
    public String PlaceComponentResult;
    String getAuthRequestContext;
    String getErrorConfigVersion;
    String lookAheadTest;
    String moveToNextValue;
    String scheduleImpl;

    public ci() {
        this.PlaceComponentResult = null;
        this.MyBillsEntityDataFactory = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = "";
        this.GetContactSyncConfig = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = "";
        this.BuiltInFictitiousFunctionClassFactory = false;
    }

    public ci(Bundle bundle) {
        super(bundle);
        this.PlaceComponentResult = null;
        this.MyBillsEntityDataFactory = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = "";
        this.GetContactSyncConfig = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = "";
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.PlaceComponentResult = bundle.getString("ext_msg_type");
        this.getAuthRequestContext = bundle.getString("ext_msg_lang");
        this.MyBillsEntityDataFactory = bundle.getString("ext_msg_thread");
        this.moveToNextValue = bundle.getString("ext_msg_sub");
        this.lookAheadTest = bundle.getString("ext_msg_body");
        this.getErrorConfigVersion = bundle.getString("ext_body_encode");
        this.scheduleImpl = bundle.getString("ext_msg_appid");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bundle.getBoolean("ext_msg_trans", false);
        this.BuiltInFictitiousFunctionClassFactory = bundle.getBoolean("ext_msg_encrypt", false);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = bundle.getString("ext_msg_seq");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = bundle.getString("ext_msg_mseq");
        this.GetContactSyncConfig = bundle.getString("ext_msg_fseq");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = bundle.getString("ext_msg_status");
    }

    @Override // com.xiaomi.push.cj
    public final Bundle KClassImpl$Data$declaredNonStaticMembers$2() {
        Bundle KClassImpl$Data$declaredNonStaticMembers$2 = super.KClassImpl$Data$declaredNonStaticMembers$2();
        if (!TextUtils.isEmpty(this.PlaceComponentResult)) {
            KClassImpl$Data$declaredNonStaticMembers$2.putString("ext_msg_type", this.PlaceComponentResult);
        }
        String str = this.getAuthRequestContext;
        if (str != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.putString("ext_msg_lang", str);
        }
        String str2 = this.moveToNextValue;
        if (str2 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.putString("ext_msg_sub", str2);
        }
        String str3 = this.lookAheadTest;
        if (str3 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.getErrorConfigVersion)) {
            KClassImpl$Data$declaredNonStaticMembers$2.putString("ext_body_encode", this.getErrorConfigVersion);
        }
        String str4 = this.MyBillsEntityDataFactory;
        if (str4 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.putString("ext_msg_thread", str4);
        }
        String str5 = this.scheduleImpl;
        if (str5 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.putString("ext_msg_appid", str5);
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            KClassImpl$Data$declaredNonStaticMembers$2.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
            KClassImpl$Data$declaredNonStaticMembers$2.putString("ext_msg_seq", this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
        if (!TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
            KClassImpl$Data$declaredNonStaticMembers$2.putString("ext_msg_mseq", this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        }
        if (!TextUtils.isEmpty(this.GetContactSyncConfig)) {
            KClassImpl$Data$declaredNonStaticMembers$2.putString("ext_msg_fseq", this.GetContactSyncConfig);
        }
        if (this.BuiltInFictitiousFunctionClassFactory) {
            KClassImpl$Data$declaredNonStaticMembers$2.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda2)) {
            KClassImpl$Data$declaredNonStaticMembers$2.putString("ext_msg_status", this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // com.xiaomi.push.cj
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ci ciVar = (ci) obj;
        if (super.equals(ciVar)) {
            String str = this.lookAheadTest;
            if (str == null ? ciVar.lookAheadTest == null : str.equals(ciVar.lookAheadTest)) {
                String str2 = this.getAuthRequestContext;
                if (str2 == null ? ciVar.getAuthRequestContext == null : str2.equals(ciVar.getAuthRequestContext)) {
                    String str3 = this.moveToNextValue;
                    if (str3 == null ? ciVar.moveToNextValue == null : str3.equals(ciVar.moveToNextValue)) {
                        String str4 = this.MyBillsEntityDataFactory;
                        if (str4 == null ? ciVar.MyBillsEntityDataFactory == null : str4.equals(ciVar.MyBillsEntityDataFactory)) {
                            return this.PlaceComponentResult == ciVar.PlaceComponentResult;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.xiaomi.push.cj
    public int hashCode() {
        String str = this.PlaceComponentResult;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.lookAheadTest;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        String str3 = this.MyBillsEntityDataFactory;
        int hashCode3 = str3 != null ? str3.hashCode() : 0;
        String str4 = this.getAuthRequestContext;
        int hashCode4 = str4 != null ? str4.hashCode() : 0;
        String str5 = this.moveToNextValue;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str5 != null ? str5.hashCode() : 0);
    }

    @Override // com.xiaomi.push.cj
    public final String MyBillsEntityDataFactory() {
        cn cnVar;
        StringBuilder sb = new StringBuilder();
        sb.append("<message");
        if (moveToNextValue() != null) {
            sb.append(" xmlns=\"");
            sb.append(moveToNextValue());
            sb.append("\"");
        }
        if (this.getAuthRequestContext != null) {
            sb.append(" xml:lang=\"");
            sb.append(this.getAuthRequestContext);
            sb.append("\"");
        }
        if (getAuthRequestContext() != null) {
            sb.append(" id=\"");
            sb.append(getAuthRequestContext());
            sb.append("\"");
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 != null) {
            sb.append(" to=\"");
            sb.append(cu.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7));
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
            sb.append(" seq=\"");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
            sb.append(" mseq=\"");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.GetContactSyncConfig)) {
            sb.append(" fseq=\"");
            sb.append(this.GetContactSyncConfig);
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda2)) {
            sb.append(" status=\"");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            sb.append("\"");
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 != null) {
            sb.append(" from=\"");
            sb.append(cu.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8));
            sb.append("\"");
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda3 != null) {
            sb.append(" chid=\"");
            sb.append(cu.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
            sb.append("\"");
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.scheduleImpl)) {
            sb.append(" appid=\"");
            sb.append(this.scheduleImpl);
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.PlaceComponentResult)) {
            sb.append(" type=\"");
            sb.append(this.PlaceComponentResult);
            sb.append("\"");
        }
        if (this.BuiltInFictitiousFunctionClassFactory) {
            sb.append(" s=\"1\"");
        }
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        if (this.moveToNextValue != null) {
            sb.append("<subject>");
            sb.append(cu.BuiltInFictitiousFunctionClassFactory(this.moveToNextValue));
            sb.append("</subject>");
        }
        if (this.lookAheadTest != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.getErrorConfigVersion)) {
                sb.append(" encode=\"");
                sb.append(this.getErrorConfigVersion);
                sb.append("\"");
            }
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            sb.append(cu.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest));
            sb.append("</body>");
        }
        if (this.MyBillsEntityDataFactory != null) {
            sb.append("<thread>");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.PlaceComponentResult) && (cnVar = this.isLayoutRequested) != null) {
            sb.append(cnVar.PlaceComponentResult());
        }
        sb.append(scheduleImpl());
        sb.append("</message>");
        return sb.toString();
    }
}
