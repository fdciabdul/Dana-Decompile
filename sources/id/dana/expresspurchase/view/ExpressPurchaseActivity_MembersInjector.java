package id.dana.expresspurchase.view;

import dagger.MembersInjector;
import id.dana.cancelsurvey.presenter.CancelSurveyContract;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.expresspurchase.presenter.ExpressPurchaseContract;
import id.dana.expresspurchase.tracker.ExpressPurchaseAnalyticTracker;

/* loaded from: classes5.dex */
public final class ExpressPurchaseActivity_MembersInjector implements MembersInjector<ExpressPurchaseActivity> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(ExpressPurchaseActivity expressPurchaseActivity, ExpressPurchaseContract.Presenter presenter) {
        expressPurchaseActivity.expressPurchasePresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(ExpressPurchaseActivity expressPurchaseActivity, CancelSurveyContract.Presenter presenter) {
        expressPurchaseActivity.cancelSurveyPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(ExpressPurchaseActivity expressPurchaseActivity, ReadLinkPropertiesContract.Presenter presenter) {
        expressPurchaseActivity.readDeepLinkPropertiesPresenter = presenter;
    }

    public static void getAuthRequestContext(ExpressPurchaseActivity expressPurchaseActivity, DynamicUrlWrapper dynamicUrlWrapper) {
        expressPurchaseActivity.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    public static void PlaceComponentResult(ExpressPurchaseActivity expressPurchaseActivity, ExpressPurchaseAnalyticTracker expressPurchaseAnalyticTracker) {
        expressPurchaseActivity.expressPurchaseAnalyticTracker = expressPurchaseAnalyticTracker;
    }
}
