package id.dana.cashier.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.cashier.model.AdditionalFeeModel;
import id.dana.model.CurrencyAmountModel;
import id.dana.utils.CurrencyAmountUtil;
import id.dana.utils.LocaleUtil;
import id.dana.utils.NumberFormatterUtil;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\n\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\f\u001a\u00020\u0002*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u0012¢\u0006\u0004\b\u000e\u0010\u0013J\u001b\u0010\u0015\u001a\u00020\u0002*\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/cashier/utils/CashierPriceUtils;", "", "Lid/dana/model/CurrencyAmountModel;", "p0", "", "p1", "PlaceComponentResult", "(Lid/dana/model/CurrencyAmountModel;Lid/dana/model/CurrencyAmountModel;Z)Lid/dana/model/CurrencyAmountModel;", "", "Lid/dana/cashier/model/AdditionalFeeModel;", "MyBillsEntityDataFactory", "(Lid/dana/model/CurrencyAmountModel;Ljava/util/List;Ljava/util/List;)Lid/dana/model/CurrencyAmountModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/model/CurrencyAmountModel;Lid/dana/model/CurrencyAmountModel;Lid/dana/model/CurrencyAmountModel;)Lid/dana/model/CurrencyAmountModel;", "getAuthRequestContext", "(Lid/dana/model/CurrencyAmountModel;Ljava/util/List;)Lid/dana/model/CurrencyAmountModel;", "Lid/dana/cashier/model/AttributeModel;", "Lid/dana/cashier/model/CashierPayMethodModel;", "Landroid/content/Context;", "(Lid/dana/cashier/model/AttributeModel;Lid/dana/cashier/model/CashierPayMethodModel;Landroid/content/Context;)Ljava/util/List;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/model/CurrencyAmountModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPriceUtils {
    public static final CashierPriceUtils INSTANCE = new CashierPriceUtils();

    private CashierPriceUtils() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        if (r1 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static id.dana.model.CurrencyAmountModel PlaceComponentResult(id.dana.model.CurrencyAmountModel r1, id.dana.model.CurrencyAmountModel r2, boolean r3) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            if (r3 == 0) goto Le
            id.dana.utils.CurrencyAmountUtil r3 = id.dana.utils.CurrencyAmountUtil.INSTANCE
            java.lang.String r3 = id.dana.utils.CurrencyAmountUtil.KClassImpl$Data$declaredNonStaticMembers$2(r1, r2)
            goto L14
        Le:
            id.dana.utils.CurrencyAmountUtil r3 = id.dana.utils.CurrencyAmountUtil.INSTANCE
            java.lang.String r3 = id.dana.utils.CurrencyAmountUtil.getAuthRequestContext(r1, r2)
        L14:
            java.lang.String r1 = r1.BuiltInFictitiousFunctionClassFactory
            if (r1 != 0) goto L21
            if (r2 == 0) goto L1d
            java.lang.String r1 = r2.BuiltInFictitiousFunctionClassFactory
            goto L1e
        L1d:
            r1 = 0
        L1e:
            if (r1 != 0) goto L21
            goto L22
        L21:
            r0 = r1
        L22:
            id.dana.model.CurrencyAmountModel r1 = KClassImpl$Data$declaredNonStaticMembers$2(r3, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.utils.CashierPriceUtils.PlaceComponentResult(id.dana.model.CurrencyAmountModel, id.dana.model.CurrencyAmountModel, boolean):id.dana.model.CurrencyAmountModel");
    }

    public static CurrencyAmountModel BuiltInFictitiousFunctionClassFactory(CurrencyAmountModel currencyAmountModel, CurrencyAmountModel currencyAmountModel2, CurrencyAmountModel currencyAmountModel3) {
        Intrinsics.checkNotNullParameter(currencyAmountModel, "");
        CurrencyAmountUtil currencyAmountUtil = CurrencyAmountUtil.INSTANCE;
        String KClassImpl$Data$declaredNonStaticMembers$2 = CurrencyAmountUtil.KClassImpl$Data$declaredNonStaticMembers$2(currencyAmountModel, currencyAmountModel2);
        CurrencyAmountUtil currencyAmountUtil2 = CurrencyAmountUtil.INSTANCE;
        String str = currencyAmountModel.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(str, "");
        String authRequestContext = CurrencyAmountUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, str), currencyAmountModel3);
        String str2 = currencyAmountModel.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(str2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, str2);
    }

    public static CurrencyAmountModel MyBillsEntityDataFactory(CurrencyAmountModel currencyAmountModel, List<AdditionalFeeModel> list, List<AdditionalFeeModel> list2) {
        Intrinsics.checkNotNullParameter(currencyAmountModel, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        double BuiltInFictitiousFunctionClassFactory = currencyAmountModel.BuiltInFictitiousFunctionClassFactory();
        for (AdditionalFeeModel additionalFeeModel : list) {
            if (additionalFeeModel.BuiltInFictitiousFunctionClassFactory != null) {
                BuiltInFictitiousFunctionClassFactory -= additionalFeeModel.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
            }
        }
        for (AdditionalFeeModel additionalFeeModel2 : list2) {
            if (additionalFeeModel2.BuiltInFictitiousFunctionClassFactory != null) {
                BuiltInFictitiousFunctionClassFactory += additionalFeeModel2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
            }
        }
        return new CurrencyAmountModel(NumberFormatterUtil.MyBillsEntityDataFactory(LocaleUtil.getAuthRequestContext(), BuiltInFictitiousFunctionClassFactory), currencyAmountModel.BuiltInFictitiousFunctionClassFactory);
    }

    public static CurrencyAmountModel getAuthRequestContext(CurrencyAmountModel currencyAmountModel, List<AdditionalFeeModel> list) {
        Intrinsics.checkNotNullParameter(currencyAmountModel, "");
        Intrinsics.checkNotNullParameter(list, "");
        double BuiltInFictitiousFunctionClassFactory = currencyAmountModel.BuiltInFictitiousFunctionClassFactory();
        for (AdditionalFeeModel additionalFeeModel : list) {
            if (additionalFeeModel.BuiltInFictitiousFunctionClassFactory != null) {
                BuiltInFictitiousFunctionClassFactory -= additionalFeeModel.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
            }
        }
        return new CurrencyAmountModel(NumberFormatterUtil.MyBillsEntityDataFactory(LocaleUtil.getAuthRequestContext(), BuiltInFictitiousFunctionClassFactory), currencyAmountModel.BuiltInFictitiousFunctionClassFactory);
    }

    private static CurrencyAmountModel KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        Locale authRequestContext = LocaleUtil.getAuthRequestContext();
        Double doubleOrNull = StringsKt.toDoubleOrNull(str);
        return new CurrencyAmountModel(NumberFormatterUtil.MyBillsEntityDataFactory(authRequestContext, doubleOrNull != null ? doubleOrNull.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01bc  */
    /* JADX WARN: Type inference failed for: r18v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<id.dana.cashier.model.AdditionalFeeModel> getAuthRequestContext(id.dana.cashier.model.AttributeModel r22, id.dana.cashier.model.CashierPayMethodModel r23, android.content.Context r24) {
        /*
            Method dump skipped, instructions count: 497
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.utils.CashierPriceUtils.getAuthRequestContext(id.dana.cashier.model.AttributeModel, id.dana.cashier.model.CashierPayMethodModel, android.content.Context):java.util.List");
    }
}
