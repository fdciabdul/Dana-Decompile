package id.dana.myprofile.mepagerevamp.securitysettings;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.featureconfig.interactor.GetAuthenticationTypeFeature;
import id.dana.domain.resetpin.interactor.GetResetAndChangePinNativeEntryConfig;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.domain.usercredential.interactor.GetPasswordLastModifiedWithConfigChecking;
import id.dana.domain.usersecurityquestions.interactor.GetSecurityQuestionState;
import id.dana.myprofile.UserInfoMapper;
import id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SecuritySettingsPresenter_Factory implements Factory<SecuritySettingsPresenter> {
    private final Provider<GetAuthenticationTypeFeature> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetSecurityQuestionState> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetPasswordLastModifiedWithConfigChecking> MyBillsEntityDataFactory;
    private final Provider<GetResetAndChangePinNativeEntryConfig> PlaceComponentResult;
    private final Provider<Context> getAuthRequestContext;
    private final Provider<GetUserInfo> getErrorConfigVersion;
    private final Provider<SecuritySettingsContract.View> lookAheadTest;
    private final Provider<UserInfoMapper> scheduleImpl;

    private SecuritySettingsPresenter_Factory(Provider<Context> provider, Provider<SecuritySettingsContract.View> provider2, Provider<GetUserInfo> provider3, Provider<UserInfoMapper> provider4, Provider<GetSecurityQuestionState> provider5, Provider<GetPasswordLastModifiedWithConfigChecking> provider6, Provider<GetResetAndChangePinNativeEntryConfig> provider7, Provider<GetAuthenticationTypeFeature> provider8) {
        this.getAuthRequestContext = provider;
        this.lookAheadTest = provider2;
        this.getErrorConfigVersion = provider3;
        this.scheduleImpl = provider4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider5;
        this.MyBillsEntityDataFactory = provider6;
        this.PlaceComponentResult = provider7;
        this.BuiltInFictitiousFunctionClassFactory = provider8;
    }

    public static SecuritySettingsPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider, Provider<SecuritySettingsContract.View> provider2, Provider<GetUserInfo> provider3, Provider<UserInfoMapper> provider4, Provider<GetSecurityQuestionState> provider5, Provider<GetPasswordLastModifiedWithConfigChecking> provider6, Provider<GetResetAndChangePinNativeEntryConfig> provider7, Provider<GetAuthenticationTypeFeature> provider8) {
        return new SecuritySettingsPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SecuritySettingsPresenter(this.getAuthRequestContext.get(), this.lookAheadTest.get(), this.getErrorConfigVersion.get(), this.scheduleImpl.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
