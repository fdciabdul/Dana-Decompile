package id.dana.myprofile.mepagerevamp.profilesettings;

import com.alibaba.griver.core.GriverParams;
import id.dana.base.AbstractContractKt;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.MyProfileBundleKey;
import id.dana.wallet_v3.constant.WalletConstant;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ProfileSettingsContract {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0005\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "MyBillsEntityDataFactory", "()V", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/io/File;", "p0", "(Ljava/io/File;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void getAuthRequestContext();

        void getAuthRequestContext(File p0);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0004J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0005H&¢\u0006\u0004\b\u0013\u0010\rJ\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0018\u0010\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "onGetUserInfoFailed", "()V", "", WalletConstant.KYC_LEVEL, "", "kycCertified", "onUserKycInfo", "(Ljava/lang/String;Z)V", GriverParams.ShareParams.IMAGE_URL, "showAvatar", "(Ljava/lang/String;)V", "emailAddress", "showEmailAddress", "showEmailAddressUnset", "showErrorToast", "phoneNumber", "showPhoneNumber", "Lid/dana/domain/profilemenu/model/SettingModel;", MyProfileBundleKey.SETTING_MODEL, "toggleShareFeedConsentFailed", "(Lid/dana/domain/profilemenu/model/SettingModel;)V", "toggleShareFeedConsentSuccess"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void onGetUserInfoFailed();

        void onUserKycInfo(String kycLevel, boolean kycCertified);

        void showAvatar(String imageUrl);

        void showEmailAddress(String emailAddress);

        void showEmailAddressUnset();

        void showErrorToast();

        void showPhoneNumber(String phoneNumber);

        void toggleShareFeedConsentFailed(SettingModel settingModel);

        void toggleShareFeedConsentSuccess(SettingModel settingModel);
    }
}
