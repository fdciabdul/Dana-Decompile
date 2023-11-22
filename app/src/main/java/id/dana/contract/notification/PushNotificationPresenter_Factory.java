package id.dana.contract.notification;

import dagger.internal.Factory;
import id.dana.contract.notification.PushNotificationContract;
import id.dana.domain.featureconfig.interactor.CheckPushNotifDiagnosticFeature;
import id.dana.domain.notificationcenter.interactor.BindApp;
import id.dana.domain.notificationcenter.interactor.ReportDevice;
import id.dana.domain.twilio.interactor.SaveTwilioChallengeAttempt;
import id.dana.domain.twilio.interactor.UpdateTwilioPushToken;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PushNotificationPresenter_Factory implements Factory<PushNotificationPresenter> {
    private final Provider<CheckPushNotifDiagnosticFeature> BuiltInFictitiousFunctionClassFactory;
    private final Provider<BindApp> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SaveTwilioChallengeAttempt> MyBillsEntityDataFactory;
    private final Provider<ReportDevice> PlaceComponentResult;
    private final Provider<UpdateTwilioPushToken> getAuthRequestContext;
    private final Provider<PushNotificationContract.View> moveToNextValue;

    private PushNotificationPresenter_Factory(Provider<PushNotificationContract.View> provider, Provider<CheckPushNotifDiagnosticFeature> provider2, Provider<ReportDevice> provider3, Provider<BindApp> provider4, Provider<UpdateTwilioPushToken> provider5, Provider<SaveTwilioChallengeAttempt> provider6) {
        this.moveToNextValue = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.PlaceComponentResult = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.getAuthRequestContext = provider5;
        this.MyBillsEntityDataFactory = provider6;
    }

    public static PushNotificationPresenter_Factory MyBillsEntityDataFactory(Provider<PushNotificationContract.View> provider, Provider<CheckPushNotifDiagnosticFeature> provider2, Provider<ReportDevice> provider3, Provider<BindApp> provider4, Provider<UpdateTwilioPushToken> provider5, Provider<SaveTwilioChallengeAttempt> provider6) {
        return new PushNotificationPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PushNotificationPresenter(this.moveToNextValue.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
