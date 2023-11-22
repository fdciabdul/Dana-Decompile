package id.dana.contract.deeplink.path;

import id.dana.base.AbstractContractKt;
import id.dana.contract.deeplink.listener.DeeplinkFeatureListener;
import id.dana.model.ThirdPartyService;
import java.util.Map;

/* loaded from: classes4.dex */
public interface FeatureContract {

    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void PlaceComponentResult(String str);

        void getAuthRequestContext(DeeplinkFeatureListener deeplinkFeatureListener);

        void getAuthRequestContext(String str, Map<String, String> map);

        void getAuthRequestContext(String str, Map<String, String> map, String str2);
    }

    /* loaded from: classes4.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void KClassImpl$Data$declaredNonStaticMembers$2(ThirdPartyService thirdPartyService, String str, String str2, String str3);

        void MyBillsEntityDataFactory(String str, Map<String, String> map, String str2, boolean z, boolean z2, boolean z3);

        void MyBillsEntityDataFactory(boolean z);

        void PlaceComponentResult(DeeplinkFeatureListener deeplinkFeatureListener);

        void PlaceComponentResult(String str);

        void getAuthRequestContext();

        void getAuthRequestContext(String str);
    }
}
