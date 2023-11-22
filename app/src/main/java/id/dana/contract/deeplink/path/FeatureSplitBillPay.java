package id.dana.contract.deeplink.path;

import id.dana.contract.deeplink.listener.DeeplinkFeatureListener;
import id.dana.domain.splitbill.interactor.GetPayerSplitBillDetail;
import id.dana.splitbill.mapper.SplitBillHistoryToSplitBillModelMapper;
import id.dana.splitbill.model.SplitBillModel;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class FeatureSplitBillPay {
    private final SplitBillHistoryToSplitBillModelMapper BuiltInFictitiousFunctionClassFactory;
    final GetPayerSplitBillDetail PlaceComponentResult;

    /* loaded from: classes4.dex */
    interface Listener {
        void KClassImpl$Data$declaredNonStaticMembers$2(SplitBillModel splitBillModel);

        void MyBillsEntityDataFactory(Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public FeatureSplitBillPay(GetPayerSplitBillDetail getPayerSplitBillDetail, SplitBillHistoryToSplitBillModelMapper splitBillHistoryToSplitBillModelMapper) {
        this.PlaceComponentResult = getPayerSplitBillDetail;
        this.BuiltInFictitiousFunctionClassFactory = splitBillHistoryToSplitBillModelMapper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void KClassImpl$Data$declaredNonStaticMembers$2(DeeplinkFeatureListener deeplinkFeatureListener) {
        if (deeplinkFeatureListener != null) {
            deeplinkFeatureListener.PlaceComponentResult();
        }
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(DeeplinkFeatureListener deeplinkFeatureListener) {
        if (deeplinkFeatureListener != null) {
            deeplinkFeatureListener.PlaceComponentResult();
        }
    }
}
