package id.dana.paymentsetting;

import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.base.AbstractContractKt;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.danah5.customdialog.CustomDialogKey;
import id.dana.domain.autoroute.model.AuthenticationTypeOption;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.MyProfileBundleKey;
import id.dana.myprofile.model.PaymentSecurityInitModel;
import id.dana.myprofile.model.PaymentSecuritySwitchModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/paymentsetting/PaymentSettingContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface PaymentSettingContract {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u0005\u0010\fJ5\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0010\u0010\tJ1\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nH&¢\u0006\u0004\b\b\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/paymentsetting/PaymentSettingContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "MyBillsEntityDataFactory", "", "p0", "getAuthRequestContext", "(Ljava/lang/String;)V", "Lid/dana/domain/profilemenu/model/SettingModel;", "p1", "(Ljava/lang/String;Lid/dana/domain/profilemenu/model/SettingModel;)V", "", "p2", "p3", "PlaceComponentResult", "(ZLjava/lang/String;Ljava/lang/String;Lid/dana/domain/profilemenu/model/SettingModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(String p0, SettingModel p1);

        void PlaceComponentResult(String str);

        void getAuthRequestContext(String p0);

        void getAuthRequestContext(boolean p0, String p1, String p2, SettingModel p3);
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\"\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\tH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0007H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0018\u0010\u0014\u001a\u00020\u00032\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H&J\b\u0010\u0018\u001a\u00020\u0003H&J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u001d\u001a\u00020\u0003H&J \u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H&J\b\u0010\"\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006#À\u0006\u0001"}, d2 = {"Lid/dana/paymentsetting/PaymentSettingContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onAlwaysAskPin", "", "actionClick", "", MyProfileBundleKey.SETTING_MODEL, "Lid/dana/domain/profilemenu/model/SettingModel;", "success", "", "onAlwaysAskPinChallengePassword", "paymentSecuritySwitchModel", "Lid/dana/myprofile/model/PaymentSecuritySwitchModel;", "onCheckPaymentSettingRequired", ContainerUIProvider.KEY_SHOW, "onGetProfileSettingModelFail", "onGetProfileSettingModelSuccessForAutoRoute", "setting", "onGetProfileSettingModelSuccessForPin", "onInitAutoRouteDisabled", "onInitAutoRouteStateOff", "authenticationSettingOptions", "", "Lid/dana/domain/autoroute/model/AuthenticationTypeOption;", "onInitAutoRouteStateOn", "onInitPaymentAuthError", "onInitPaymentAuthSuccess", "paymentSecurityInitModel", "Lid/dana/myprofile/model/PaymentSecurityInitModel;", "onSwitchAutoRouteFailed", "onSwitchAutoRouteNeedRisk", CustomDialogKey.Response.IS_CHECKED, BioUtilityBridge.SECURITY_ID, RecordError.KEY_PUB_KEY, "onSwitchAutoRouteSuccess", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(SettingModel settingModel);

        void KClassImpl$Data$declaredNonStaticMembers$2(PaymentSecurityInitModel paymentSecurityInitModel, String str, SettingModel settingModel);

        void KClassImpl$Data$declaredNonStaticMembers$2(PaymentSecuritySwitchModel paymentSecuritySwitchModel, String str, SettingModel settingModel);

        void MyBillsEntityDataFactory(SettingModel settingModel);

        void MyBillsEntityDataFactory(String str);

        void MyBillsEntityDataFactory(String str, SettingModel settingModel);

        void PlaceComponentResult();

        void PlaceComponentResult(boolean z, String str, String str2);

        void getAuthRequestContext();

        void getAuthRequestContext(String str, SettingModel settingModel, boolean z);

        void getAuthRequestContext(List<AuthenticationTypeOption> list);

        void getAuthRequestContext(boolean z);
    }
}
