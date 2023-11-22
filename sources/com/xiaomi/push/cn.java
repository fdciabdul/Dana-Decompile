package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class cn {
    String BuiltInFictitiousFunctionClassFactory;
    List<cg> KClassImpl$Data$declaredNonStaticMembers$2;
    String MyBillsEntityDataFactory;
    String PlaceComponentResult;
    int getAuthRequestContext;
    String getErrorConfigVersion;

    /* loaded from: classes8.dex */
    public static class a {
        private String FragmentBottomSheetPaymentSettingBinding;
        public static final a MyBillsEntityDataFactory = new a("internal-server-error");
        public static final a PlaceComponentResult = new a("forbidden");
        public static final a getAuthRequestContext = new a("bad-request");
        public static final a KClassImpl$Data$declaredNonStaticMembers$2 = new a("conflict");
        public static final a BuiltInFictitiousFunctionClassFactory = new a("feature-not-implemented");
        public static final a scheduleImpl = new a("gone");
        public static final a NetworkUserEntityData$$ExternalSyntheticLambda0 = new a("item-not-found");
        public static final a moveToNextValue = new a("jid-malformed");
        public static final a lookAheadTest = new a("not-acceptable");
        public static final a getErrorConfigVersion = new a("not-allowed");
        public static final a NetworkUserEntityData$$ExternalSyntheticLambda2 = new a("not-authorized");
        public static final a initRecordTimeStamp = new a("payment-required");
        public static final a NetworkUserEntityData$$ExternalSyntheticLambda1 = new a("recipient-unavailable");
        public static final a DatabaseTableConfigUtil = new a("redirect");
        public static final a GetContactSyncConfig = new a("registration-required");
        public static final a NetworkUserEntityData$$ExternalSyntheticLambda8 = new a("remote-server-error");
        public static final a newProxyInstance = new a("remote-server-not-found");
        public static final a PrepareContext = new a("remote-server-timeout");
        public static final a NetworkUserEntityData$$ExternalSyntheticLambda7 = new a("resource-constraint");
        public static final a isLayoutRequested = new a("service-unavailable");
        public static final a NetworkUserEntityData$$ExternalSyntheticLambda6 = new a("subscription-required");
        public static final a NetworkUserEntityData$$ExternalSyntheticLambda5 = new a("undefined-condition");
        public static final a NetworkUserEntityData$$ExternalSyntheticLambda4 = new a("unexpected-request");
        public static final a NetworkUserEntityData$$ExternalSyntheticLambda3 = new a("request-timeout");

        private a(String str) {
            this.FragmentBottomSheetPaymentSettingBinding = str;
        }

        public String toString() {
            return this.FragmentBottomSheetPaymentSettingBinding;
        }
    }

    public cn(int i, String str, String str2, String str3, String str4, List<cg> list) {
        this.getAuthRequestContext = i;
        this.PlaceComponentResult = str;
        this.MyBillsEntityDataFactory = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.getErrorConfigVersion = str4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
    }

    public cn(Bundle bundle) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.getAuthRequestContext = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.PlaceComponentResult = bundle.getString("ext_err_type");
        }
        this.BuiltInFictitiousFunctionClassFactory = bundle.getString("ext_err_cond");
        this.MyBillsEntityDataFactory = bundle.getString("ext_err_reason");
        this.getErrorConfigVersion = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.add(cg.KClassImpl$Data$declaredNonStaticMembers$2((Bundle) parcelable));
            }
        }
    }

    private List<cg> MyBillsEntityDataFactory() {
        synchronized (this) {
            List<cg> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (list == null) {
                return Collections.emptyList();
            }
            return Collections.unmodifiableList(list);
        }
    }

    public final String PlaceComponentResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("<error code=\"");
        sb.append(this.getAuthRequestContext);
        sb.append("\"");
        if (this.PlaceComponentResult != null) {
            sb.append(" type=\"");
            sb.append(this.PlaceComponentResult);
            sb.append("\"");
        }
        if (this.MyBillsEntityDataFactory != null) {
            sb.append(" reason=\"");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append("\"");
        }
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            sb.append(SimpleComparison.LESS_THAN_OPERATION);
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.getErrorConfigVersion != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.getErrorConfigVersion);
            sb.append("</text>");
        }
        Iterator<cg> it = MyBillsEntityDataFactory().iterator();
        while (it.hasNext()) {
            sb.append(it.next().BuiltInFictitiousFunctionClassFactory());
        }
        sb.append("</error>");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.BuiltInFictitiousFunctionClassFactory;
        if (str != null) {
            sb.append(str);
        }
        sb.append("(");
        sb.append(this.getAuthRequestContext);
        sb.append(")");
        if (this.getErrorConfigVersion != null) {
            sb.append(" ");
            sb.append(this.getErrorConfigVersion);
        }
        return sb.toString();
    }

    public cn(a aVar) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.BuiltInFictitiousFunctionClassFactory = aVar.FragmentBottomSheetPaymentSettingBinding;
        this.getErrorConfigVersion = null;
    }
}
