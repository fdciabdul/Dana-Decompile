package id.dana.cashier.helper;

import id.dana.cashier.model.AddOnTrackingModel;
import id.dana.cashier.model.AttributeModel;
import id.dana.cashier.model.CashierCheckoutModel;
import id.dana.cashier.model.CashierOrderGoodModel;
import id.dana.data.util.NumberUtils;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\n\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\n\u0010\tJ\u0011\u0010\f\u001a\u00020\u000b*\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u0006\u001a\u00020\u000b*\u00020\u0002¢\u0006\u0004\b\u0006\u0010\r"}, d2 = {"Lid/dana/cashier/helper/CashierCheckoutModelExt;", "", "Lid/dana/cashier/model/CashierCheckoutModel;", "", "p0", "Lid/dana/cashier/model/AddOnTrackingModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/model/CashierCheckoutModel;Ljava/lang/String;)Lid/dana/cashier/model/AddOnTrackingModel;", "getAuthRequestContext", "(Lid/dana/cashier/model/CashierCheckoutModel;)Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "", "PlaceComponentResult", "(Lid/dana/cashier/model/CashierCheckoutModel;)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierCheckoutModelExt {
    public static final CashierCheckoutModelExt INSTANCE = new CashierCheckoutModelExt();

    private CashierCheckoutModelExt() {
    }

    public static AddOnTrackingModel KClassImpl$Data$declaredNonStaticMembers$2(CashierCheckoutModel cashierCheckoutModel, String str) {
        List<CashierOrderGoodModel> list;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(cashierCheckoutModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        AttributeModel attributeModel = cashierCheckoutModel.getAuthRequestContext;
        if (attributeModel != null && (list = attributeModel.NetworkUserEntityData$$ExternalSyntheticLambda0) != null) {
            for (CashierOrderGoodModel cashierOrderGoodModel : list) {
                if (Intrinsics.areEqual(str, "Send Money") && Intrinsics.areEqual(cashierOrderGoodModel.DatabaseTableConfigUtil, "Transfer Prioritas")) {
                    str2 = "Priority Transfer";
                } else {
                    str2 = cashierOrderGoodModel.DatabaseTableConfigUtil;
                    if (str2 == null) {
                        str2 = "";
                    }
                }
                if (Intrinsics.areEqual(cashierOrderGoodModel.scheduleImpl, Boolean.TRUE) && Intrinsics.areEqual(cashierOrderGoodModel.PrepareContext, "CHILD")) {
                    String str4 = cashierOrderGoodModel.MyBillsEntityDataFactory;
                    if (str4 == null) {
                        str4 = "";
                    }
                    MoneyViewModel moneyViewModel = cashierOrderGoodModel.getAuthRequestContext;
                    if (moneyViewModel != null) {
                        str3 = NumberUtils.getCleanAll(moneyViewModel.PlaceComponentResult);
                        if (str3 == null) {
                            str3 = "0";
                        }
                    } else {
                        str3 = null;
                    }
                    if (str3 == null) {
                        str3 = "";
                    }
                    Boolean bool = cashierOrderGoodModel.getErrorConfigVersion;
                    arrayList.add(new AddOnTrackingModel.AddOn(str4, str2, str3, bool != null ? bool.booleanValue() : false));
                }
                if (Intrinsics.areEqual(cashierOrderGoodModel.getErrorConfigVersion, Boolean.TRUE)) {
                    arrayList2.add(str2);
                }
                if (Intrinsics.areEqual(cashierOrderGoodModel.scheduleImpl, Boolean.TRUE)) {
                    arrayList3.add(str2);
                }
                if (Intrinsics.areEqual(cashierOrderGoodModel.PlaceComponentResult, Boolean.TRUE)) {
                    arrayList4.add(str2);
                }
            }
        }
        return new AddOnTrackingModel(arrayList, arrayList2, arrayList3, arrayList4);
    }

    public static String getAuthRequestContext(CashierCheckoutModel cashierCheckoutModel) {
        Intrinsics.checkNotNullParameter(cashierCheckoutModel, "");
        AttributeModel attributeModel = cashierCheckoutModel.getAuthRequestContext;
        String str = attributeModel != null ? attributeModel.NetworkUserEntityData$$ExternalSyntheticLambda7 : null;
        return str == null ? "" : str;
    }

    public static String BuiltInFictitiousFunctionClassFactory(CashierCheckoutModel cashierCheckoutModel) {
        Intrinsics.checkNotNullParameter(cashierCheckoutModel, "");
        AttributeModel attributeModel = cashierCheckoutModel.getAuthRequestContext;
        String str = attributeModel != null ? attributeModel.id.dana.sendmoney.summary.SummaryActivity.HOURS java.lang.String : null;
        return str == null ? "" : str;
    }

    public static boolean PlaceComponentResult(CashierCheckoutModel cashierCheckoutModel) {
        List<CashierOrderGoodModel> list;
        Intrinsics.checkNotNullParameter(cashierCheckoutModel, "");
        AttributeModel attributeModel = cashierCheckoutModel.getAuthRequestContext;
        if (attributeModel == null || (list = attributeModel.NetworkUserEntityData$$ExternalSyntheticLambda0) == null) {
            return false;
        }
        return !list.isEmpty();
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.model.CashierCheckoutModel r6) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            id.dana.cashier.model.AttributeModel r1 = r6.getAuthRequestContext
            r2 = 0
            if (r1 == 0) goto Ld
            java.lang.String r1 = r1.NetworkUserEntityData$$ExternalSyntheticLambda7
            goto Le
        Ld:
            r1 = r2
        Le:
            id.dana.cashier.model.AttributeModel r3 = r6.getAuthRequestContext
            if (r3 == 0) goto L3e
            java.util.List<id.dana.cashier.model.CashierPayChannelModel> r3 = r3.SummaryVoucherView$$ExternalSyntheticLambda1
            if (r3 == 0) goto L38
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L1c:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L30
            java.lang.Object r4 = r3.next()
            r5 = r4
            id.dana.cashier.model.CashierPayChannelModel r5 = (id.dana.cashier.model.CashierPayChannelModel) r5
            boolean r5 = r5.KClassImpl$Data$declaredNonStaticMembers$2()
            if (r5 == 0) goto L1c
            goto L31
        L30:
            r4 = r2
        L31:
            id.dana.cashier.model.CashierPayChannelModel r4 = (id.dana.cashier.model.CashierPayChannelModel) r4
            if (r4 == 0) goto L38
            java.lang.String r3 = r4.NetworkUserEntityData$$ExternalSyntheticLambda7
            goto L39
        L38:
            r3 = r2
        L39:
            if (r3 != 0) goto L3c
            goto L3f
        L3c:
            r0 = r3
            goto L3f
        L3e:
            r0 = r2
        L3f:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r0)
            r1 = 1
            r3 = 0
            if (r0 == 0) goto L82
            id.dana.cashier.model.AttributeModel r0 = r6.getAuthRequestContext
            if (r0 == 0) goto L6c
            java.util.List<id.dana.cashier.model.CashierPayChannelModel> r0 = r0.SummaryVoucherView$$ExternalSyntheticLambda1
            if (r0 == 0) goto L6c
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L55:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L6a
            java.lang.Object r4 = r0.next()
            r5 = r4
            id.dana.cashier.model.CashierPayChannelModel r5 = (id.dana.cashier.model.CashierPayChannelModel) r5
            boolean r5 = r5.scheduleImpl()
            r5 = r5 ^ r1
            if (r5 == 0) goto L55
            r2 = r4
        L6a:
            id.dana.cashier.model.CashierPayChannelModel r2 = (id.dana.cashier.model.CashierPayChannelModel) r2
        L6c:
            if (r2 == 0) goto L82
            id.dana.cashier.model.AttributeModel r6 = r6.getAuthRequestContext
            if (r6 == 0) goto L7e
            java.util.List<id.dana.cashier.model.AssetCardModel> r6 = r6.PlaceComponentResult
            if (r6 == 0) goto L7e
            boolean r6 = r6.isEmpty()
            if (r6 != r1) goto L7e
            r6 = 1
            goto L7f
        L7e:
            r6 = 0
        L7f:
            if (r6 == 0) goto L82
            goto L83
        L82:
            r1 = 0
        L83:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.helper.CashierCheckoutModelExt.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.model.CashierCheckoutModel):boolean");
    }
}
