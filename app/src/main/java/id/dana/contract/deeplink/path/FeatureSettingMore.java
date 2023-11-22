package id.dana.contract.deeplink.path;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseActivity;
import id.dana.danah5.DanaH5;
import id.dana.data.profilemenu.MyProfileMenuAction;
import id.dana.domain.profilemenu.interactor.GetSettingByKey;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.merchantmanagement.view.MerchantManagementActivity;
import id.dana.myprofile.MyProfileBundleKey;
import id.dana.myprofile.SettingMoreProfileActivity;
import id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity;
import id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity;
import id.dana.productpage.ProductPageManagerExtKt;
import id.dana.utils.UrlUtil;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class FeatureSettingMore {
    boolean BuiltInFictitiousFunctionClassFactory = false;
    private final ProductPageManager KClassImpl$Data$declaredNonStaticMembers$2;
    final GetSettingByKey PlaceComponentResult;
    Activity getAuthRequestContext;

    @Inject
    public FeatureSettingMore(GetSettingByKey getSettingByKey, ProductPageManager productPageManager) {
        this.PlaceComponentResult = getSettingByKey;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = productPageManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BuiltInFictitiousFunctionClassFactory(SettingModel settingModel, String str) {
        Intent intent = new Intent(this.getAuthRequestContext, SecuritySettingsActivity.class);
        intent.putExtra(MyProfileBundleKey.SETTING_MODEL, settingModel);
        intent.putExtra(MyProfileBundleKey.MIXPANEL_SOURCE, str);
        this.getAuthRequestContext.startActivity(intent);
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FeatureSettingMore featureSettingMore) {
        Activity activity = featureSettingMore.getAuthRequestContext;
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).showWarningDialog(activity.getString(R.string.setting_more_deeplink_error_msg));
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(FeatureSettingMore featureSettingMore, SettingModel settingModel) {
        Intent intent = new Intent(featureSettingMore.getAuthRequestContext, SmartPayActivity.class);
        intent.putExtra(MyProfileBundleKey.SETTING_MODEL, settingModel);
        featureSettingMore.getAuthRequestContext.startActivity(intent);
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FeatureSettingMore featureSettingMore, SettingModel settingModel) {
        Intent intent = new Intent(featureSettingMore.getAuthRequestContext, SettingMoreProfileActivity.class);
        intent.putExtra(MyProfileBundleKey.SETTING_MODEL, settingModel);
        intent.putExtra(MyProfileBundleKey.HIGHLIGHT_AUTO_ROUTING_FEATURE, featureSettingMore.BuiltInFictitiousFunctionClassFactory);
        intent.putExtra("source", TrackerKey.SourceType.DEEP_LINK);
        featureSettingMore.getAuthRequestContext.startActivity(intent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void PlaceComponentResult(FeatureSettingMore featureSettingMore, SettingModel settingModel) {
        char c;
        String action = settingModel.getAction();
        switch (action.hashCode()) {
            case -1741312354:
                if (action.equals(MyProfileMenuAction.COLLECTION)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -776144932:
                if (action.equals("redirect")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -719054499:
                if (action.equals(MyProfileMenuAction.SETTING_SECURITY_QUESTIONS)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -35919189:
                if (action.equals("setting_merchant_management")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            ProductPageManagerExtKt.BuiltInFictitiousFunctionClassFactory(featureSettingMore.KClassImpl$Data$declaredNonStaticMembers$2, featureSettingMore.getAuthRequestContext);
        } else if (c == 1) {
            featureSettingMore.BuiltInFictitiousFunctionClassFactory(settingModel, TrackerKey.SourceType.UNDEFINED);
        } else if (c != 2) {
            String redirectUrl = settingModel.getRedirectUrl();
            if (TextUtils.isEmpty(redirectUrl)) {
                return;
            }
            DanaH5.startContainerFullUrl(UrlUtil.getAuthRequestContext(redirectUrl));
        } else {
            MerchantManagementActivity.openMerchantManagementActivity(featureSettingMore.getAuthRequestContext);
        }
    }
}
