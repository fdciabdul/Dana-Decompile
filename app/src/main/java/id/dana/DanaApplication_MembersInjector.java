package id.dana;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.config.source.HomeWidgetEntityData;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.foundation.facade.IAPPushFacade;
import id.dana.data.toggle.SplitFacade;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.rum.Rum;
import id.dana.toggle.SplitObservant;
import id.dana.transferaccount.TransferAccountStatusChecker;
import id.dana.utils.foundation.facede.ApSecurity;

/* loaded from: classes.dex */
public final class DanaApplication_MembersInjector implements MembersInjector<DanaApplication> {
    public static void MyBillsEntityDataFactory(DanaApplication danaApplication, AppLifeCycleObserver appLifeCycleObserver) {
        danaApplication.appLifeCycleObserver = appLifeCycleObserver;
    }

    public static void lookAheadTest(DanaApplication danaApplication, Lazy<SplitObservant> lazy) {
        danaApplication.splitObservant = lazy;
    }

    public static void moveToNextValue(DanaApplication danaApplication, Lazy<SplitFacade> lazy) {
        danaApplication.splitFacade = lazy;
    }

    public static void BuiltInFictitiousFunctionClassFactory(DanaApplication danaApplication, ApplicationOrientationCallback applicationOrientationCallback) {
        danaApplication.applicationOrientationCallback = applicationOrientationCallback;
    }

    public static void BuiltInFictitiousFunctionClassFactory(DanaApplication danaApplication, DanaLocalBroadcastReceiver danaLocalBroadcastReceiver) {
        danaApplication.danaLocalBroadcastReceiver = danaLocalBroadcastReceiver;
    }

    public static void PlaceComponentResult(DanaApplication danaApplication, Lazy<DeviceInformationProvider> lazy) {
        danaApplication.deviceInformationProvider = lazy;
    }

    public static void PlaceComponentResult(DanaApplication danaApplication, IAPPushFacade iAPPushFacade) {
        danaApplication.iapPushFacade = iAPPushFacade;
    }

    public static void MyBillsEntityDataFactory(DanaApplication danaApplication, Lazy<MixpanelRepository> lazy) {
        danaApplication.mixpanel = lazy;
    }

    public static void BuiltInFictitiousFunctionClassFactory(DanaApplication danaApplication, Lazy<GetUserInfo> lazy) {
        danaApplication.getUserInfo = lazy;
    }

    public static void scheduleImpl(DanaApplication danaApplication, Lazy<SplitConfigEntityData> lazy) {
        danaApplication.splitConfigEntityData = lazy;
    }

    public static void getAuthRequestContext(DanaApplication danaApplication, Lazy<HomeWidgetEntityData> lazy) {
        danaApplication.homeWidgetCache = lazy;
    }

    public static void getErrorConfigVersion(DanaApplication danaApplication, Lazy<TransferAccountStatusChecker> lazy) {
        danaApplication.transferAccountStatusChecker = lazy;
    }

    public static void getAuthRequestContext(DanaApplication danaApplication, ApSecurity apSecurity) {
        danaApplication.apSecurity = apSecurity;
    }

    public static void PlaceComponentResult(DanaApplication danaApplication, Rum rum) {
        danaApplication.rumSplunk = rum;
    }
}
