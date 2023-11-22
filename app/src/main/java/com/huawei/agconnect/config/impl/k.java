package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.fullstory.instrumentation.InstrumentInjector;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class k extends j {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private g KClassImpl$Data$declaredNonStaticMembers$2;
    private final Object MyBillsEntityDataFactory;
    private final Map<String, String> PlaceComponentResult;
    private final String getAuthRequestContext;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SecurityResourcesReader{mKey=, encrypt=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, String str) {
        super(context, str);
        this.PlaceComponentResult = new HashMap();
        this.MyBillsEntityDataFactory = new Object();
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.getAuthRequestContext = str;
        try {
            String BuiltInFictitiousFunctionClassFactory = super.BuiltInFictitiousFunctionClassFactory("/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138", null);
            String BuiltInFictitiousFunctionClassFactory2 = super.BuiltInFictitiousFunctionClassFactory("/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C", null);
            String BuiltInFictitiousFunctionClassFactory3 = super.BuiltInFictitiousFunctionClassFactory("/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B", null);
            String BuiltInFictitiousFunctionClassFactory4 = super.BuiltInFictitiousFunctionClassFactory("/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD", null);
            if (BuiltInFictitiousFunctionClassFactory == null || BuiltInFictitiousFunctionClassFactory2 == null || BuiltInFictitiousFunctionClassFactory3 == null || BuiltInFictitiousFunctionClassFactory4 == null) {
                this.BuiltInFictitiousFunctionClassFactory = false;
            } else {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new f(BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2, BuiltInFictitiousFunctionClassFactory3, BuiltInFictitiousFunctionClassFactory4);
            }
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            InstrumentInjector.log_e("SecurityResourcesReader", "Exception when reading the 'K&I' for 'Config'.");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
    }

    @Override // com.huawei.agconnect.config.impl.j, com.huawei.agconnect.config.impl.d
    public final String BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        if (!this.BuiltInFictitiousFunctionClassFactory) {
            String BuiltInFictitiousFunctionClassFactory = super.BuiltInFictitiousFunctionClassFactory(str, null);
            return BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory : str2;
        } else if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            InstrumentInjector.log_e("SecurityResourcesReader", "KEY is null return def directly");
            return str2;
        } else {
            synchronized (this.MyBillsEntityDataFactory) {
                String str3 = this.PlaceComponentResult.get(str);
                if (str3 != null) {
                    return str3;
                }
                String BuiltInFictitiousFunctionClassFactory2 = super.BuiltInFictitiousFunctionClassFactory(str, null);
                if (BuiltInFictitiousFunctionClassFactory2 == null) {
                    return str2;
                }
                String PlaceComponentResult = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2, str2);
                this.PlaceComponentResult.put(str, PlaceComponentResult);
                return PlaceComponentResult;
            }
        }
    }
}
