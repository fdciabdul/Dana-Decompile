package id.dana.contract.oauth;

import com.alibaba.griver.core.GriverParams;
import id.dana.base.AbstractContractKt;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.domain.featureconfig.model.ShowAlipayConnectBrandConfig;
import id.dana.oauth.OauthConstant;
import id.dana.oauth.model.AuthCodeModel;
import id.dana.oauth.model.BindingBenefitModel;
import id.dana.oauth.model.OauthInitModel;
import id.dana.oauth.model.OauthParamsModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/oauth/OauthGrantContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface OauthGrantContract {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\f\u001a\u00020\u0003H&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&JB\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Lid/dana/contract/oauth/OauthGrantContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "confirmScope", "", "oauthParamsModel", "Lid/dana/oauth/model/OauthParamsModel;", "bindingType", "", "getAuthAgreement", "getAvatarUrl", "getBindingBenefits", "getOauthScope", "getPhoneNumber", "getShowAlipayConnectBrandConfig", "oauthInitModel", "Lid/dana/oauth/model/OauthInitModel;", "submitAuthApply", "qrBinding", "", BioUtilityBridge.SECURITY_ID, "verificationMethods", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(OauthParamsModel oauthParamsModel, String str);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(OauthParamsModel oauthParamsModel, String str);

        void PlaceComponentResult(OauthParamsModel oauthParamsModel, String str);

        void PlaceComponentResult(OauthParamsModel oauthParamsModel, String str, boolean z, String str2, List<String> list);

        void getAuthRequestContext();
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\"\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00032\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000bH&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H&J\u001e\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u001b\u001a\u00020\u0003H&J\u001a\u0010\u001c\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0006H&J\b\u0010!\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\"À\u0006\u0001"}, d2 = {"Lid/dana/contract/oauth/OauthGrantContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "dismissConfirmProgress", "", "onConfirmOauthScopeSuccess", OauthConstant.PathParams.MOBILE_AUTH_CODE, "", OauthConstant.PathParams.SERVER_AUTH_CODE, "onGetAuthCodeRiskFailed", BioUtilityBridge.SECURITY_ID, "verificationMethods", "", "onGetAuthCodeSuccess", "authCodeModel", "Lid/dana/oauth/model/AuthCodeModel;", "onGetBindingBenefitsSuccess", "bindingBenefitModelList", "Lid/dana/oauth/model/BindingBenefitModel;", "onGetOauthScopeSuccess", "oauthInitModel", "Lid/dana/oauth/model/OauthInitModel;", "onGetPhoneNumberSuccess", "phoneNumber", "onOauthError", "throwable", "", "errorPath", "onQrBindingError", "showAlipayConnectBrand", "showAlipayConnectBrandConfig", "Lid/dana/domain/featureconfig/model/ShowAlipayConnectBrandConfig;", "showAvatar", GriverParams.ShareParams.IMAGE_URL, "showConfirmProgress", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void dismissConfirmProgress();

        void onConfirmOauthScopeSuccess(String mobileAuthCode, String serverAuthCode);

        void onGetAuthCodeRiskFailed(String securityId, List<String> verificationMethods);

        void onGetAuthCodeSuccess(AuthCodeModel authCodeModel);

        void onGetBindingBenefitsSuccess(List<BindingBenefitModel> bindingBenefitModelList);

        void onGetOauthScopeSuccess(OauthInitModel oauthInitModel);

        void onGetPhoneNumberSuccess(String phoneNumber);

        void onOauthError(Throwable throwable, String errorPath);

        void onQrBindingError();

        void showAlipayConnectBrand(OauthInitModel oauthInitModel, ShowAlipayConnectBrandConfig showAlipayConnectBrandConfig);

        void showAvatar(String imageUrl);

        void showConfirmProgress();

        /* renamed from: id.dana.contract.oauth.OauthGrantContract$View$-CC  reason: invalid class name */
        /* loaded from: classes.dex */
        public final /* synthetic */ class CC {
        }
    }
}
