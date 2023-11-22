package id.dana.contract.notification;

import id.dana.contract.notification.PushNotificationContract;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.featureconfig.interactor.CheckPushNotifDiagnosticFeature;
import id.dana.domain.notificationcenter.interactor.BindApp;
import id.dana.domain.notificationcenter.interactor.ReportDevice;
import id.dana.domain.twilio.interactor.SaveTwilioChallengeAttempt;
import id.dana.domain.twilio.interactor.UpdateTwilioPushToken;
import javax.inject.Inject;

@PerActivity
/* loaded from: classes4.dex */
public class PushNotificationPresenter implements PushNotificationContract.Presenter {
    public final ReportDevice BuiltInFictitiousFunctionClassFactory;
    public final UpdateTwilioPushToken KClassImpl$Data$declaredNonStaticMembers$2;
    private final BindApp MyBillsEntityDataFactory;
    public final SaveTwilioChallengeAttempt PlaceComponentResult;
    public final CheckPushNotifDiagnosticFeature getAuthRequestContext;
    private final PushNotificationContract.View scheduleImpl;

    @Inject
    public PushNotificationPresenter(PushNotificationContract.View view, CheckPushNotifDiagnosticFeature checkPushNotifDiagnosticFeature, ReportDevice reportDevice, BindApp bindApp, UpdateTwilioPushToken updateTwilioPushToken, SaveTwilioChallengeAttempt saveTwilioChallengeAttempt) {
        this.scheduleImpl = view;
        this.BuiltInFictitiousFunctionClassFactory = reportDevice;
        this.MyBillsEntityDataFactory = bindApp;
        this.getAuthRequestContext = checkPushNotifDiagnosticFeature;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = updateTwilioPushToken;
        this.PlaceComponentResult = saveTwilioChallengeAttempt;
    }

    @Override // id.dana.contract.notification.PushNotificationContract.Presenter
    public final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory.execute(new DefaultObserver());
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.getAuthRequestContext.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.PlaceComponentResult.dispose();
    }
}
