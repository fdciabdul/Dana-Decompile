package id.dana.expresspurchase.tracker;

import id.dana.analytics.tracker.TrackerKey;
import id.dana.expresspurchase.model.ExpressPurchaseModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J)\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000eH&JF\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0011H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0011H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Lid/dana/expresspurchase/tracker/ExpressPurchaseAnalyticTracker;", "", "startEpTimer", "", "trackExpressPurchaseConfirmation", TrackerKey.ExpressPurchaseProperties.IS_DISMISS, "", "isPriceChange", "epConfirmationPopUp", "(ZZLjava/lang/Boolean;)V", "trackExpressPurchaseOpen", "expressPurchaseModel", "Lid/dana/expresspurchase/model/ExpressPurchaseModel;", "trackExpressPurchasePaylaterActivation", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Paylater;", "trackExpressPurchaseResult", "status", "", "pendingReason", "failedReason", "productCode", "source", "trackUserBuyDeals", "merchantName", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ExpressPurchaseAnalyticTracker {
    void KClassImpl$Data$declaredNonStaticMembers$2();

    void KClassImpl$Data$declaredNonStaticMembers$2(boolean z, boolean z2, Boolean bool);

    void MyBillsEntityDataFactory(String str);

    void MyBillsEntityDataFactory(String str, String str2, String str3, ExpressPurchaseModel expressPurchaseModel, String str4, String str5);

    void PlaceComponentResult(ExpressPurchaseModel.Paylater paylater);

    void getAuthRequestContext(ExpressPurchaseModel expressPurchaseModel);

    /* renamed from: id.dana.expresspurchase.tracker.ExpressPurchaseAnalyticTracker$-CC  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC {
    }
}
