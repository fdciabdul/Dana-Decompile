package id.dana.mybills.model;

import id.dana.mybills.model.BillPaymentAdapterModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/model/BillSubscriptionHighlightModel;", "Lid/dana/mybills/model/BillPaymentAdapterModel;", "getAuthRequestContext", "(Lid/dana/mybills/model/BillSubscriptionHighlightModel;)Lid/dana/mybills/model/BillPaymentAdapterModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BillPaymentAdapterModelKt {
    public static final BillPaymentAdapterModel getAuthRequestContext(BillSubscriptionHighlightModel billSubscriptionHighlightModel) {
        Intrinsics.checkNotNullParameter(billSubscriptionHighlightModel, "");
        String str = billSubscriptionHighlightModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
        String str2 = billSubscriptionHighlightModel.KClassImpl$Data$declaredNonStaticMembers$2;
        String str3 = billSubscriptionHighlightModel.BuiltInFictitiousFunctionClassFactory;
        Boolean bool = billSubscriptionHighlightModel.getAuthRequestContext;
        String str4 = billSubscriptionHighlightModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
        String str5 = billSubscriptionHighlightModel.scheduleImpl;
        Long l = billSubscriptionHighlightModel.lookAheadTest;
        long j = billSubscriptionHighlightModel.moveToNextValue;
        String str6 = billSubscriptionHighlightModel.initRecordTimeStamp;
        MoneyViewModel moneyViewModel = billSubscriptionHighlightModel.GetContactSyncConfig;
        MoneyViewModel moneyViewModel2 = billSubscriptionHighlightModel.getErrorConfigVersion;
        String str7 = billSubscriptionHighlightModel.DatabaseTableConfigUtil;
        String str8 = billSubscriptionHighlightModel.MyBillsEntityDataFactory;
        boolean placeComponentResult = billSubscriptionHighlightModel.getPlaceComponentResult();
        return new BillPaymentAdapterModel(null, new BillPaymentStatusModel(str, str2, str3, bool, str4, str5, l, Long.valueOf(j), str6, moneyViewModel, moneyViewModel2, str7, str8, Boolean.valueOf(placeComponentResult), billSubscriptionHighlightModel.NetworkUserEntityData$$ExternalSyntheticLambda1), null, BillPaymentAdapterModel.ViewTypeEnum.ITEMS.ordinal(), 5, null);
    }
}
