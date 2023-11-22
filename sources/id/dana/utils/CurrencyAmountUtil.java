package id.dana.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.data.globalnetwork.constants.GlobalNetworkConstants;
import id.dana.data.util.NumberUtils;
import id.dana.lib.gcontainer.extension.NumberExtKt;
import id.dana.model.CurrencyAmountModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\u0007J!\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\u0007J\u001b\u0010\n\u001a\u00020\u0005*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u0007"}, d2 = {"Lid/dana/utils/CurrencyAmountUtil;", "", "Lid/dana/model/CurrencyAmountModel;", "p0", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/model/CurrencyAmountModel;Lid/dana/model/CurrencyAmountModel;)Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CurrencyAmountUtil {
    public static final CurrencyAmountUtil INSTANCE = new CurrencyAmountUtil();

    private CurrencyAmountUtil() {
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(CurrencyAmountModel p0, CurrencyAmountModel p1) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double BuiltInFictitiousFunctionClassFactory = p0 != null ? p0.BuiltInFictitiousFunctionClassFactory() : 0.0d;
        if (p1 != null) {
            d = p1.BuiltInFictitiousFunctionClassFactory();
        }
        return String.valueOf(BuiltInFictitiousFunctionClassFactory + d);
    }

    public static String MyBillsEntityDataFactory(CurrencyAmountModel p0, CurrencyAmountModel p1) {
        String str;
        String valueOf = String.valueOf((p0 != null ? p0.BuiltInFictitiousFunctionClassFactory() : 0.0d) - (p1 != null ? p1.BuiltInFictitiousFunctionClassFactory() : 0.0d));
        String str2 = null;
        if (p0 != null && (str = p0.BuiltInFictitiousFunctionClassFactory) != null) {
            String str3 = str;
            if (str3.length() == 0) {
                str3 = p1 != null ? p1.BuiltInFictitiousFunctionClassFactory : null;
            }
            String str4 = str3;
            if (str4 != null) {
                String str5 = str4;
                if (str5.length() == 0) {
                    str5 = "Rp";
                }
                str2 = str5;
            }
        }
        if (Double.parseDouble(valueOf) <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            valueOf = "0";
        }
        if (str2 == null) {
            str2 = GlobalNetworkConstants.IDR_CURRENCY;
        }
        String authRequestContext = new CurrencyAmountModel(valueOf, str2).getAuthRequestContext();
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    public static String getAuthRequestContext(CurrencyAmountModel currencyAmountModel, CurrencyAmountModel currencyAmountModel2) {
        Intrinsics.checkNotNullParameter(currencyAmountModel, "");
        double BuiltInFictitiousFunctionClassFactory = currencyAmountModel.BuiltInFictitiousFunctionClassFactory() - (currencyAmountModel2 != null ? currencyAmountModel2.BuiltInFictitiousFunctionClassFactory() : 0.0d);
        return BuiltInFictitiousFunctionClassFactory > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? String.valueOf(BuiltInFictitiousFunctionClassFactory) : "0";
    }

    public static String BuiltInFictitiousFunctionClassFactory(CurrencyAmountModel p0, CurrencyAmountModel p1) {
        String cleanAll = p0 != null ? NumberUtils.getCleanAll(p0.MyBillsEntityDataFactory) : null;
        if (cleanAll == null) {
            cleanAll = "0";
        }
        int safeInt$default = NumberExtKt.toSafeInt$default(cleanAll, 0, 1, (Object) null);
        String cleanAll2 = p1 != null ? NumberUtils.getCleanAll(p1.MyBillsEntityDataFactory) : null;
        return String.valueOf(safeInt$default + NumberExtKt.toSafeInt$default(cleanAll2 != null ? cleanAll2 : "0", 0, 1, (Object) null));
    }
}
