package id.dana.tracker.appsflyer;

import android.content.Context;
import android.text.TextUtils;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import id.dana.BuildConfig;
import id.dana.constants.AnalyticEventConstant;
import id.dana.tracker.EventConfig;
import id.dana.tracker.EventConfigProperty;
import id.dana.tracker.mixpanel.MixPanelTracker;
import java.util.Map;

/* loaded from: classes2.dex */
public class AppsflyerConfig implements EventConfig {
    private final EventConfigProperty MyBillsEntityDataFactory;

    @Override // id.dana.tracker.EventConfig
    public final void getAuthRequestContext() {
    }

    public AppsflyerConfig(EventConfigProperty eventConfigProperty) {
        this.MyBillsEntityDataFactory = eventConfigProperty;
    }

    @Override // id.dana.tracker.EventConfig
    public final void MyBillsEntityDataFactory() {
        Context context;
        Context context2;
        Context context3;
        String str;
        String str2;
        EventConfigProperty eventConfigProperty = this.MyBillsEntityDataFactory;
        if (eventConfigProperty != null) {
            context = eventConfigProperty.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
            if (context != null) {
                AppsFlyerLib appsFlyerLib = AppsFlyerLib.getInstance();
                AppsFlyerConversionListener appsFlyerConversionListener = new AppsFlyerConversionListener() { // from class: id.dana.tracker.appsflyer.AppsflyerConfig.1
                    @Override // com.appsflyer.AppsFlyerConversionListener
                    public void onAppOpenAttribution(Map<String, String> map) {
                    }

                    @Override // com.appsflyer.AppsFlyerConversionListener
                    public void onAttributionFailure(String str3) {
                    }

                    @Override // com.appsflyer.AppsFlyerConversionListener
                    public void onConversionDataFail(String str3) {
                    }

                    @Override // com.appsflyer.AppsFlyerConversionListener
                    public void onConversionDataSuccess(Map<String, Object> map) {
                        String str3 = (String) map.get(AnalyticEventConstant.AE_MEDIA_SOURCE);
                        String str4 = (String) map.get(AnalyticEventConstant.AE_AF_STATUS);
                        if (str3 == null) {
                            str3 = str4;
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            MixPanelTracker.PlaceComponentResult(str3);
                        }
                        MixPanelTracker.PlaceComponentResult();
                    }
                };
                context2 = this.MyBillsEntityDataFactory.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                appsFlyerLib.init(BuildConfig.APPS_FLYER_KEY, appsFlyerConversionListener, context2);
                AppsFlyerLib.getInstance().setDebugLog(false);
                AppsFlyerLib.getInstance().setCollectIMEI(false);
                AppsFlyerLib.getInstance().setCollectAndroidID(false);
                if (!this.MyBillsEntityDataFactory.PlaceComponentResult()) {
                    str = this.MyBillsEntityDataFactory.PlaceComponentResult.getErrorConfigVersion;
                    if (TextUtils.isEmpty(str)) {
                        str2 = this.MyBillsEntityDataFactory.PlaceComponentResult.lookAheadTest;
                        if (!TextUtils.isEmpty(str2)) {
                            AppsFlyerLib.getInstance().setCustomerUserId(str2);
                        }
                    }
                }
                AppsFlyerLib appsFlyerLib2 = AppsFlyerLib.getInstance();
                context3 = this.MyBillsEntityDataFactory.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                appsFlyerLib2.start(context3);
            }
        }
    }

    @Override // id.dana.tracker.EventConfig
    public final void PlaceComponentResult() {
        if (lookAheadTest()) {
            AppsFlyerLib.getInstance().setCustomerUserId(KClassImpl$Data$declaredNonStaticMembers$2());
        }
    }

    @Override // id.dana.tracker.EventConfig
    public final void BuiltInFictitiousFunctionClassFactory() {
        if (lookAheadTest()) {
            AppsFlyerLib.getInstance().setCustomerUserId(KClassImpl$Data$declaredNonStaticMembers$2());
        }
    }

    private String KClassImpl$Data$declaredNonStaticMembers$2() {
        String str;
        String str2;
        str = this.MyBillsEntityDataFactory.PlaceComponentResult.getErrorConfigVersion;
        if (TextUtils.isEmpty(str)) {
            str2 = this.MyBillsEntityDataFactory.PlaceComponentResult.lookAheadTest;
            return str2;
        }
        return str;
    }

    private boolean lookAheadTest() {
        String str;
        EventConfigProperty eventConfigProperty = this.MyBillsEntityDataFactory;
        if (eventConfigProperty != null) {
            str = eventConfigProperty.PlaceComponentResult.getErrorConfigVersion;
            if (!TextUtils.isEmpty(str)) {
                return true;
            }
        }
        return false;
    }
}
