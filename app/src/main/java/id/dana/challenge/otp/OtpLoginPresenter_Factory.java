package id.dana.challenge.otp;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.analytics.tracker.login.LoginTracker;
import id.dana.challenge.otp.AbstractOtpContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.toggle.SplitFacade;
import id.dana.domain.featureconfig.interactor.CheckResendWhatsAppEnable;
import id.dana.domain.featureconfig.interactor.GetQueryUserDataConfig;
import id.dana.domain.login.interactor.OtpLogin;
import id.dana.domain.otp.interactor.ReceiveOtp;
import id.dana.domain.otp.interactor.SendOtp;
import id.dana.domain.otp.interactor.VerifyOtpRisk;
import id.dana.domain.registration.interactor.GetNumberOfRequestOtp;
import id.dana.domain.registration.interactor.RemoveNumberOfRequestOtp;
import id.dana.domain.registration.interactor.SaveIsFreezeVerifyOtp;
import id.dana.domain.registration.interactor.SaveNumberOfRequestOtp;
import id.dana.myprofile.UserInfoMapper;
import id.dana.sync_engine.domain.interactor.GetIsSyncPermission;
import id.dana.sync_engine.domain.interactor.SaveIsSyncPermission;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class OtpLoginPresenter_Factory implements Factory<OtpLoginPresenter> {
    private final Provider<GetNumberOfRequestOtp> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SplitFacade> DatabaseTableConfigUtil;
    private final Provider<SaveIsFreezeVerifyOtp> GetContactSyncConfig;
    private final Provider<DeviceInformationProvider> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetIsSyncPermission> MyBillsEntityDataFactory;
    private final Provider<OtpLogin> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<SendOtp> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<SaveNumberOfRequestOtp> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<VerifyOtpRisk> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Provider<CheckResendWhatsAppEnable> PlaceComponentResult;
    private final Provider<AbstractOtpContract.View> PrepareContext;
    private final Provider<Context> getAuthRequestContext;
    private final Provider<RemoveNumberOfRequestOtp> getErrorConfigVersion;
    private final Provider<SaveIsSyncPermission> initRecordTimeStamp;
    private final Provider<UserInfoMapper> isLayoutRequested;
    private final Provider<GetQueryUserDataConfig> lookAheadTest;
    private final Provider<ReceiveOtp> moveToNextValue;
    private final Provider<LoginTracker> scheduleImpl;

    private OtpLoginPresenter_Factory(Provider<AbstractOtpContract.View> provider, Provider<OtpLogin> provider2, Provider<SendOtp> provider3, Provider<ReceiveOtp> provider4, Provider<Context> provider5, Provider<DeviceInformationProvider> provider6, Provider<SplitFacade> provider7, Provider<GetIsSyncPermission> provider8, Provider<SaveIsSyncPermission> provider9, Provider<SaveIsFreezeVerifyOtp> provider10, Provider<GetNumberOfRequestOtp> provider11, Provider<SaveNumberOfRequestOtp> provider12, Provider<RemoveNumberOfRequestOtp> provider13, Provider<CheckResendWhatsAppEnable> provider14, Provider<GetQueryUserDataConfig> provider15, Provider<LoginTracker> provider16, Provider<VerifyOtpRisk> provider17, Provider<UserInfoMapper> provider18) {
        this.PrepareContext = provider;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider3;
        this.moveToNextValue = provider4;
        this.getAuthRequestContext = provider5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider6;
        this.DatabaseTableConfigUtil = provider7;
        this.MyBillsEntityDataFactory = provider8;
        this.initRecordTimeStamp = provider9;
        this.GetContactSyncConfig = provider10;
        this.BuiltInFictitiousFunctionClassFactory = provider11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider12;
        this.getErrorConfigVersion = provider13;
        this.PlaceComponentResult = provider14;
        this.lookAheadTest = provider15;
        this.scheduleImpl = provider16;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = provider17;
        this.isLayoutRequested = provider18;
    }

    public static OtpLoginPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<AbstractOtpContract.View> provider, Provider<OtpLogin> provider2, Provider<SendOtp> provider3, Provider<ReceiveOtp> provider4, Provider<Context> provider5, Provider<DeviceInformationProvider> provider6, Provider<SplitFacade> provider7, Provider<GetIsSyncPermission> provider8, Provider<SaveIsSyncPermission> provider9, Provider<SaveIsFreezeVerifyOtp> provider10, Provider<GetNumberOfRequestOtp> provider11, Provider<SaveNumberOfRequestOtp> provider12, Provider<RemoveNumberOfRequestOtp> provider13, Provider<CheckResendWhatsAppEnable> provider14, Provider<GetQueryUserDataConfig> provider15, Provider<LoginTracker> provider16, Provider<VerifyOtpRisk> provider17, Provider<UserInfoMapper> provider18) {
        return new OtpLoginPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        OtpLoginPresenter otpLoginPresenter = new OtpLoginPresenter(this.PrepareContext.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(), this.moveToNextValue.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.DatabaseTableConfigUtil.get(), this.MyBillsEntityDataFactory.get(), this.initRecordTimeStamp.get(), DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig), this.BuiltInFictitiousFunctionClassFactory.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(), this.getErrorConfigVersion.get(), this.PlaceComponentResult.get(), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7));
        OtpLoginPresenter_MembersInjector.MyBillsEntityDataFactory(otpLoginPresenter, this.isLayoutRequested.get());
        return otpLoginPresenter;
    }
}
