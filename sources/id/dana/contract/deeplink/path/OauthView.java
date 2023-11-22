package id.dana.contract.deeplink.path;

import android.app.Activity;
import id.dana.contract.deeplink.path.OauthContract;
import id.dana.oauth.activity.OauthGrantActivity;
import id.dana.oauth.model.OauthParamsModel;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class OauthView implements OauthContract.View {
    private FeatureOauth PlaceComponentResult;
    public Activity getAuthRequestContext;

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public OauthView(FeatureOauth featureOauth) {
        this.PlaceComponentResult = featureOauth;
    }

    @Override // id.dana.contract.deeplink.path.OauthContract.View
    public final void MyBillsEntityDataFactory(OauthParamsModel oauthParamsModel) {
        Activity activity = this.getAuthRequestContext;
        if (activity != null) {
            activity.startActivity(OauthGrantActivity.createOauthGrantIntent(activity, oauthParamsModel));
        }
    }
}
