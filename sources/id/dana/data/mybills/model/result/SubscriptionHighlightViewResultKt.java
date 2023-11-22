package id.dana.data.mybills.model.result;

import id.dana.domain.mybills.model.MyBillIntervalInfo;
import id.dana.domain.mybills.model.MyBillView;
import id.dana.domain.mybills.model.MyBillsItemHighlightView;
import id.dana.domain.mybills.model.MyBillsMerchantInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/mybills/model/result/SubscriptionHighlightViewResult;", "Lid/dana/domain/mybills/model/MyBillsItemHighlightView;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/data/mybills/model/result/SubscriptionHighlightViewResult;)Lid/dana/domain/mybills/model/MyBillsItemHighlightView;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SubscriptionHighlightViewResultKt {
    public static final MyBillsItemHighlightView KClassImpl$Data$declaredNonStaticMembers$2(SubscriptionHighlightViewResult subscriptionHighlightViewResult) {
        Intrinsics.checkNotNullParameter(subscriptionHighlightViewResult, "");
        String str = subscriptionHighlightViewResult.PlaceComponentResult;
        MyBillView authRequestContext = BillViewResultKt.getAuthRequestContext(subscriptionHighlightViewResult.KClassImpl$Data$declaredNonStaticMembers$2);
        Long l = subscriptionHighlightViewResult.BuiltInFictitiousFunctionClassFactory;
        Long l2 = subscriptionHighlightViewResult.MyBillsEntityDataFactory;
        Long l3 = subscriptionHighlightViewResult.getAuthRequestContext;
        String str2 = subscriptionHighlightViewResult.moveToNextValue;
        MyBillIntervalInfo MyBillsEntityDataFactory = HighlightSubscriptionResultKt.MyBillsEntityDataFactory(subscriptionHighlightViewResult.NetworkUserEntityData$$ExternalSyntheticLambda0);
        MerchantInfo merchantInfo = subscriptionHighlightViewResult.lookAheadTest;
        Intrinsics.checkNotNullParameter(merchantInfo, "");
        return new MyBillsItemHighlightView(str, authRequestContext, l, l2, l3, str2, MyBillsEntityDataFactory, new MyBillsMerchantInfo(String.valueOf(merchantInfo.MyBillsEntityDataFactory), String.valueOf(merchantInfo.BuiltInFictitiousFunctionClassFactory), String.valueOf(merchantInfo.getAuthRequestContext), String.valueOf(merchantInfo.KClassImpl$Data$declaredNonStaticMembers$2)), PaymentCycleInfoViewsResultKt.PlaceComponentResult(subscriptionHighlightViewResult.getErrorConfigVersion), subscriptionHighlightViewResult.scheduleImpl, HighlightSubscriptionResultKt.MyBillsEntityDataFactory(subscriptionHighlightViewResult.DatabaseTableConfigUtil), subscriptionHighlightViewResult.NetworkUserEntityData$$ExternalSyntheticLambda1, HighlightSubscriptionResultKt.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionHighlightViewResult.GetContactSyncConfig), subscriptionHighlightViewResult.initRecordTimeStamp, subscriptionHighlightViewResult.NetworkUserEntityData$$ExternalSyntheticLambda2);
    }
}
