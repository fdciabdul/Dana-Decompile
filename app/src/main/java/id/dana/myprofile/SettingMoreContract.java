package id.dana.myprofile;

import com.alibaba.griver.core.GriverParams;
import id.dana.base.AbstractContractKt;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.wallet_v3.constant.WalletConstant;
import java.io.File;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/myprofile/SettingMoreContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SettingMoreContract {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0003\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u0005\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/myprofile/SettingMoreContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "PlaceComponentResult", "getAuthRequestContext", "", "p0", "(Ljava/lang/String;)V", "getErrorConfigVersion", "Ljava/io/File;", "(Ljava/io/File;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(File p0);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(String p0);

        void MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void getAuthRequestContext();

        void getErrorConfigVersion();
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001f\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00022\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0004J!\u0010\u0015\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\u0005H&¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\bH&¢\u0006\u0004\b \u0010\u001eJ\u000f\u0010!\u001a\u00020\u0002H&¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0002H&¢\u0006\u0004\b\"\u0010\u0004J\u0017\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\bH&¢\u0006\u0004\b$\u0010\u001eJ\u000f\u0010%\u001a\u00020\u0002H&¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0002H&¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010'\u001a\u00020\u0002H&¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0002H&¢\u0006\u0004\b(\u0010\u0004J\u0017\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\rH&¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\rH&¢\u0006\u0004\b,\u0010+ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/myprofile/SettingMoreContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "onAlreadyEnrolled", "()V", "", "isVisible", "isSwitchActive", "", "authenticationType", "onGetAutoSwitchInitialState", "(ZZLjava/lang/String;)V", "", "Lid/dana/domain/profilemenu/model/SettingModel;", "settings", "onGetSettingCollectionSuccess", "(Ljava/util/List;)V", "onGetUserInfoFailed", "onUnenrolled", WalletConstant.KYC_LEVEL, "kycCertified", "onUserKycInfo", "(Ljava/lang/String;Z)V", "isFaceLoginEnabled", "hasEnrolled", "isFaceLoginReady", "setFaceLoginState", "(ZZZ)V", GriverParams.ShareParams.IMAGE_URL, "showAvatar", "(Ljava/lang/String;)V", "emailAddress", "showEmailAddress", "showEmailAddressUnset", "showErrorToast", "phoneNumber", "showPhoneNumber", "showSecurityQuestionStateOff", "showSecurityQuestionStateOn", "showTrustedDevice", "showTrustedDeviceUnset", MyProfileBundleKey.SETTING_MODEL, "toggleShareFeedConsentFailed", "(Lid/dana/domain/profilemenu/model/SettingModel;)V", "toggleShareFeedConsentSuccess"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void onAlreadyEnrolled();

        void onGetAutoSwitchInitialState(boolean isVisible, boolean isSwitchActive, String authenticationType);

        void onGetSettingCollectionSuccess(List<? extends SettingModel> settings);

        void onGetUserInfoFailed();

        void onUnenrolled();

        void onUserKycInfo(String kycLevel, boolean kycCertified);

        void setFaceLoginState(boolean isFaceLoginEnabled, boolean hasEnrolled, boolean isFaceLoginReady);

        void showAvatar(String imageUrl);

        void showEmailAddress(String emailAddress);

        void showEmailAddressUnset();

        void showErrorToast();

        void showPhoneNumber(String phoneNumber);

        void showSecurityQuestionStateOff();

        void showSecurityQuestionStateOn();

        void showTrustedDevice();

        void showTrustedDeviceUnset();

        void toggleShareFeedConsentFailed(SettingModel settingModel);

        void toggleShareFeedConsentSuccess(SettingModel settingModel);
    }
}
