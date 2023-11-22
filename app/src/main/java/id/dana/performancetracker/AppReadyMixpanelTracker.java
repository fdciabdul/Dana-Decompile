package id.dana.performancetracker;

import android.app.Application;
import android.view.ViewConfiguration;
import com.google.firebase.perf.metrics.Trace;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.adapter.HomeAdapter;
import id.dana.animation.adapter.HomeViewWidgetModel;
import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.domain.featureconfig.model.StartupConfig;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.AppPerformanceData;
import id.dana.utils.AppPerformanceSubflow;
import id.dana.utils.AppPerformanceSubflowDefaultImpl;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.D;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u001c\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010<\u001a\u00020.H\u0007J\b\u0010=\u001a\u00020\u0006H\u0002J\u0018\u0010>\u001a\u00020.2\u0006\u0010?\u001a\u00020\u00132\b\b\u0002\u0010@\u001a\u00020\u000eJ\t\u0010A\u001a\u00020.H\u0096\u0001J\u0018\u0010B\u001a\u00020.2\u0006\u0010C\u001a\u00020\u00132\u0006\u0010D\u001a\u00020\u0006H\u0002J\u0010\u0010E\u001a\u0004\u0018\u00010\u0006H\u0096\u0001¢\u0006\u0002\u0010FJ\u0010\u0010G\u001a\u0004\u0018\u00010\u0006H\u0096\u0001¢\u0006\u0002\u0010FJ\u0010\u0010H\u001a\u0004\u0018\u00010\u0006H\u0096\u0001¢\u0006\u0002\u0010FJ\u0018\u0010I\u001a\u0004\u0018\u00010\u00062\u0006\u0010J\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0002\u0010KJ\u0010\u0010L\u001a\u0004\u0018\u00010\u0006H\u0096\u0001¢\u0006\u0002\u0010FJ\u0010\u0010M\u001a\u0004\u0018\u00010\u0006H\u0096\u0001¢\u0006\u0002\u0010FJ\b\u0010N\u001a\u00020\u0013H\u0002J\u0010\u0010O\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\u0013H\u0002J\u0012\u0010P\u001a\u00020\u00132\b\u0010Q\u001a\u0004\u0018\u000108H\u0002J\u0010\u0010R\u001a\u00020.2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010S\u001a\u00020\u000eH\u0002J\b\u0010T\u001a\u00020\u000eH\u0002J\u0006\u0010U\u001a\u00020\u000eJ \u0010V\u001a\u00020.2\u000e\b\u0002\u0010W\u001a\b\u0012\u0004\u0012\u0002080X2\u0006\u0010?\u001a\u00020\u0013H\u0002J\b\u0010Y\u001a\u00020.H\u0007J\u0006\u0010Z\u001a\u00020.J\t\u0010[\u001a\u00020.H\u0096\u0001J\t\u0010\\\u001a\u00020.H\u0096\u0001J\u000e\u0010]\u001a\u00020.2\u0006\u0010^\u001a\u00020\u000eJ\u000e\u0010_\u001a\u00020.2\u0006\u00103\u001a\u00020\u0006J\t\u0010`\u001a\u00020.H\u0096\u0001J\t\u0010a\u001a\u00020.H\u0096\u0001J\t\u0010b\u001a\u00020.H\u0096\u0001J\t\u0010c\u001a\u00020.H\u0096\u0001J\u0006\u0010d\u001a\u00020.J\u0014\u0010e\u001a\u00020.2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020g0XJ\u000e\u0010h\u001a\u00020.2\u0006\u0010i\u001a\u00020\u000eJ\u000e\u0010j\u001a\u00020.2\u0006\u0010i\u001a\u00020\u000eJ\u0010\u0010k\u001a\u00020.2\u0006\u0010\u001f\u001a\u00020\u000eH\u0007J\u0016\u0010l\u001a\u00020.2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020\u000e0*H\u0007J\u0010\u0010n\u001a\u00020.2\u0006\u0010i\u001a\u00020\u000eH\u0007J\u0010\u0010o\u001a\u00020.2\u0006\u0010i\u001a\u00020\u000eH\u0007J\u000e\u0010p\u001a\u00020.2\u0006\u0010i\u001a\u00020\u000eJ\b\u0010q\u001a\u00020.H\u0007J\u000e\u0010r\u001a\u00020.2\u0006\u0010i\u001a\u00020\u000eJ\u000e\u0010s\u001a\u00020.2\u0006\u0010i\u001a\u00020\u000eJ\u0010\u0010t\u001a\u00020.2\u0006\u0010u\u001a\u00020\u0013H\u0007J\u0011\u0010v\u001a\u00020.2\u0006\u0010J\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010w\u001a\u00020.2\u0006\u0010J\u001a\u00020\u0013H\u0096\u0001J\t\u0010x\u001a\u00020.H\u0096\u0001J\t\u0010y\u001a\u00020.H\u0096\u0001J\t\u0010z\u001a\u00020.H\u0096\u0001J\t\u0010{\u001a\u00020.H\u0096\u0001J\u0010\u0010|\u001a\u00020.2\u0006\u00104\u001a\u000205H\u0007J\u0006\u0010}\u001a\u00020.J\u0010\u0010~\u001a\u00020.2\u0006\u0010\u007f\u001a\u000208H\u0007J\u0011\u0010\u0080\u0001\u001a\u00020.2\u0006\u0010\u007f\u001a\u000208H\u0007J\t\u0010\u0081\u0001\u001a\u00020\u000eH\u0002J\u0011\u0010\u0082\u0001\u001a\u00020.2\u0006\u0010?\u001a\u00020\u0013H\u0002J\t\u0010\u0083\u0001\u001a\u00020.H\u0002J\t\u0010\u0084\u0001\u001a\u00020.H\u0007J\t\u0010\u0085\u0001\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0002\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001b\u0010\u0018R$\u0010\u001c\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\u0002\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u0018\u0010\u001f\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u0002R\u0018\u0010!\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u0002R\u0018\u0010#\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\u0002R\u0018\u0010%\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b&\u0010\u0002R\u0018\u0010'\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b(\u0010\u0002R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010-\u001a\b\u0012\u0004\u0012\u00020.0*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u000607X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u000607X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u0002080;X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0086\u0001"}, d2 = {"Lid/dana/performancetracker/AppReadyMixpanelTracker;", "Lid/dana/utils/AppPerformanceSubflow;", "()V", "appPerformanceData", "Lid/dana/utils/AppPerformanceData;", "appReadyTrackedMillis", "", "getAppReadyTrackedMillis", "()J", "setAppReadyTrackedMillis", "(J)V", "applicationContext", "Landroid/app/Application;", "coldStartInCurrentSessionTracked", "", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "failedSource", "Lio/reactivex/subjects/PublishSubject;", "", "isFromApplaunch", "isFromApplaunch$annotations", "()Z", "setFromApplaunch", "(Z)V", "isFromDeeplink", "isFromDeeplink$annotations", "setFromDeeplink", "isFromNotification", "isFromNotification$annotations", "setFromNotification", "isHotStartup", "isHotStartup$annotations", "isMobileRechargeReady", "isMobileRechargeReady$annotations", "isScanQrReady", "isScanQrReady$annotations", "isSendMoneyReady", "isSendMoneyReady$annotations", "isTransactionHistoryReady", "isTransactionHistoryReady$annotations", "isWarmStartTrackingEnable", "Lkotlin/Function0;", "isWarmStartup", "nonColdStartInCurrentSessionTracked", "onAppReady", "", "getOnAppReady", "()Lkotlin/jvm/functions/Function0;", "setOnAppReady", "(Lkotlin/jvm/functions/Function0;)V", "startHomeAssetReadyInMillis", "startupConfig", "Lid/dana/domain/featureconfig/model/StartupConfig;", "widgetStartTimeMap", "Ljava/util/EnumMap;", "Lid/dana/home/adapter/HomeAdapter$HomeWidget;", "widgetTimeMap", "widgetViewPortList", "", "calculatePassiveBiometricReadyTime", "calculateReadyInMillis", "checkTrackAppReadyFailed", "stopCriteria", "skipDebounce", "clearSubflowTime", "firebaseTrackAppReadyEvent", "startupType", "readyTime", "getDanaApplicationDuration", "()Ljava/lang/Long;", "getHomeCheckSession", "getHomeDuration", "getSpanDuration", "key", "(Ljava/lang/String;)Ljava/lang/Long;", "getSplashCheckSession", "getSplashDuration", "getStartType", "getStartTypeFirebase", "getWidgetName", "homeWidget", "initTracking", "isColdStartupNotTracked", "isNonColdStartupTrackable", "isNotFirstAction", "mixpanelTrackAppReadyEvent", "notReadyList", "", "resetTracking", "setColdStartTime", "setDanaApplicationTimeStart", "setDanaApplicationTimeStop", "setFaceLoginPageShown", "faceLoginPageShown", "setHomeAssetReadyInMillis", "setHomeCheckSessionTimeStart", "setHomeCheckSessionTimeStop", "setHomeTimeStart", "setHomeTimeStop", "setHotStartTime", "setInitialHomeWidgetListItem", "homeWidgetList", "Lid/dana/home/adapter/HomeViewWidgetModel;", "setInputOtpPageShown", "value", "setInputPinPageShown", "setIsHotStartup", "setIsWarmStartTrackingEnable", "isWarmStartEnable", "setIsWarmStartup", "setOptionalUpdatePopUpShown", "setPassiveBiometricEnable", "setPassiveBiometricStartTime", "setPhoneNumberPageShown", "setReinputPinPageShown", "setSessionId", "uuid", "setSpanTimeStart", "setSpanTimeStop", "setSplashCheckSessionTimeStart", "setSplashCheckSessionTimeStop", "setSplashTimeStart", "setSplashTimeStop", "setStartupConfig", "setWarmStartTime", "setWidgetReady", ShareToFeedBridge.WIDGET, "setWidgetStart", "startupTimeNotZero", "trackAppReadyFailed", "trackAppReadyWithChecking", "trackHotAppReady", "widgetLoadingFinish", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppReadyMixpanelTracker implements AppPerformanceSubflow {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final AppReadyMixpanelTracker BuiltInFictitiousFunctionClassFactory;
    private static boolean DatabaseTableConfigUtil = false;
    private static Set<HomeAdapter.HomeWidget> FragmentBottomSheetPaymentSettingBinding = null;
    private static boolean GetContactSyncConfig = false;
    private static final AppPerformanceData KClassImpl$Data$declaredNonStaticMembers$2;
    public static boolean MyBillsEntityDataFactory = false;
    private static final PublishSubject<String> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
    private static EnumMap<HomeAdapter.HomeWidget, Long> NetworkUserEntityData$$ExternalSyntheticLambda3 = null;
    private static StartupConfig NetworkUserEntityData$$ExternalSyntheticLambda4 = null;
    private static EnumMap<HomeAdapter.HomeWidget, Long> NetworkUserEntityData$$ExternalSyntheticLambda5 = null;
    private static long NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
    private static Application PlaceComponentResult = null;
    private static Function0<Boolean> PrepareContext = null;
    private static long getAuthRequestContext = 0;
    private static long getCallingPid = 0;
    private static boolean getErrorConfigVersion = false;
    private static int getSupportButtonTintMode = 1;
    private static boolean initRecordTimeStamp;
    private static Function0<Unit> isLayoutRequested;
    private static final CompositeDisposable lookAheadTest;
    private static boolean moveToNextValue;
    private static boolean newProxyInstance;
    private static int readMicros;
    private static boolean scheduleImpl;
    private final /* synthetic */ AppPerformanceSubflowDefaultImpl NetworkUserEntityData$$ExternalSyntheticLambda6 = new AppPerformanceSubflowDefaultImpl();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[HomeAdapter.HomeWidget.values().length];
            iArr[HomeAdapter.HomeWidget.BALANCE.ordinal()] = 1;
            iArr[HomeAdapter.HomeWidget.FOUR_KINGS.ordinal()] = 2;
            iArr[HomeAdapter.HomeWidget.SOCIAL_WIDGET.ordinal()] = 3;
            iArr[HomeAdapter.HomeWidget.NEARBY_ME.ordinal()] = 4;
            iArr[HomeAdapter.HomeWidget.PROMO_BANNER.ordinal()] = 5;
            iArr[HomeAdapter.HomeWidget.PROMO_CENTER.ordinal()] = 6;
            iArr[HomeAdapter.HomeWidget.SERVICES.ordinal()] = 7;
            iArr[HomeAdapter.HomeWidget.BOTTOM_BAR.ordinal()] = 8;
            iArr[HomeAdapter.HomeWidget.HOME_INVESTMENT.ordinal()] = 9;
            iArr[HomeAdapter.HomeWidget.MORE_FOR_YOU.ordinal()] = 10;
            iArr[HomeAdapter.HomeWidget.DANA_PROTECTION.ordinal()] = 11;
            iArr[HomeAdapter.HomeWidget.PERSONALIZED_BACKGROUND.ordinal()] = 12;
            iArr[HomeAdapter.HomeWidget.SPACERS.ordinal()] = 13;
            iArr[HomeAdapter.HomeWidget.NOTIFICATION.ordinal()] = 14;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        int i = readMicros + 113;
        getSupportButtonTintMode = i % 128;
        Object[] objArr = null;
        if (i % 2 == 0) {
            MyBillsEntityDataFactory(str);
            int length = objArr.length;
        } else {
            try {
                MyBillsEntityDataFactory(str);
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = getSupportButtonTintMode + 45;
        readMicros = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 25 : 'E') != 'E') {
            int length2 = objArr.length;
        }
    }

    static void getCallingPid() {
        getCallingPid = 6780920083461708875L;
    }

    private AppReadyMixpanelTracker() {
    }

    @JvmName(name = "setFromNotification")
    public static final void PlaceComponentResult() {
        int i = readMicros + 79;
        getSupportButtonTintMode = i % 128;
        moveToNextValue = (i % 2 == 0 ? ',' : 'H') == 'H';
    }

    static {
        getCallingPid();
        BuiltInFictitiousFunctionClassFactory = new AppReadyMixpanelTracker();
        getErrorConfigVersion = true;
        KClassImpl$Data$declaredNonStaticMembers$2 = new AppPerformanceData();
        NetworkUserEntityData$$ExternalSyntheticLambda3 = new EnumMap<>(HomeAdapter.HomeWidget.class);
        NetworkUserEntityData$$ExternalSyntheticLambda5 = new EnumMap<>(HomeAdapter.HomeWidget.class);
        FragmentBottomSheetPaymentSettingBinding = new LinkedHashSet();
        PrepareContext = new Function0<Boolean>() { // from class: id.dana.performancetracker.AppReadyMixpanelTracker$isWarmStartTrackingEnable$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.FALSE;
            }
        };
        isLayoutRequested = new Function0<Unit>() { // from class: id.dana.performancetracker.AppReadyMixpanelTracker$onAppReady$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        PublishSubject<String> PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        NetworkUserEntityData$$ExternalSyntheticLambda0 = PlaceComponentResult2;
        lookAheadTest = new CompositeDisposable();
        GetContactSyncConfig = true;
        newProxyInstance = true;
        int i = getSupportButtonTintMode + 97;
        readMicros = i % 128;
        if ((i % 2 != 0 ? 'G' : 'U') != 'G') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    @JvmName(name = "setFromApplaunch")
    public static final void MyBillsEntityDataFactory() {
        int i = readMicros + 119;
        getSupportButtonTintMode = i % 128;
        if (!(i % 2 == 0)) {
            try {
                getErrorConfigVersion = false;
            } catch (Exception e) {
                throw e;
            }
        } else {
            getErrorConfigVersion = true;
        }
        int i2 = getSupportButtonTintMode + 59;
        readMicros = i2 % 128;
        int i3 = i2 % 2;
    }

    @JvmName(name = "getAppReadyTrackedMillis")
    public static long NetworkUserEntityData$$ExternalSyntheticLambda0() {
        long j;
        int i = getSupportButtonTintMode + 25;
        readMicros = i % 128;
        if ((i % 2 != 0 ? (char) 31 : (char) 6) != 6) {
            j = getAuthRequestContext;
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            try {
                j = getAuthRequestContext;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            int i2 = getSupportButtonTintMode + 115;
            readMicros = i2 % 128;
            int i3 = i2 % 2;
            return j;
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmStatic
    public static final void getAuthRequestContext(String str) {
        try {
            Intrinsics.checkNotNullParameter(str, "");
            AppPerformanceData appPerformanceData = KClassImpl$Data$declaredNonStaticMembers$2;
            StringBuilder sb = new StringBuilder();
            try {
                sb.append(str);
                sb.append('_');
                sb.append(appPerformanceData.getAuthRequestContext);
                appPerformanceData.initRecordTimeStamp = sb.toString();
                int i = readMicros + 49;
                getSupportButtonTintMode = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "setOnAppReady")
    public static void getAuthRequestContext(Function0<Unit> function0) {
        int i = readMicros + 97;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(function0, "");
            isLayoutRequested = function0;
            int i3 = getSupportButtonTintMode + 55;
            readMicros = i3 % 128;
            if ((i3 % 2 != 0 ? 'T' : (char) 5) != 'T') {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmStatic
    public static final void MyBillsEntityDataFactory(Application application) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$22;
        Intrinsics.checkNotNullParameter(application, "");
        PlaceComponentResult = application;
        CompositeDisposable compositeDisposable = lookAheadTest;
        PublishSubject<String> publishSubject = NetworkUserEntityData$$ExternalSyntheticLambda0;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        compositeDisposable.getAuthRequestContext(publishSubject.debounce(4L, timeUnit, KClassImpl$Data$declaredNonStaticMembers$22).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.performancetracker.AppReadyMixpanelTracker$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AppReadyMixpanelTracker.KClassImpl$Data$declaredNonStaticMembers$2((String) obj);
            }
        }));
        int i = getSupportButtonTintMode + 83;
        readMicros = i % 128;
        if (!(i % 2 != 0)) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private static final void MyBillsEntityDataFactory(String str) {
        int i = getSupportButtonTintMode + 125;
        readMicros = i % 128;
        if ((i % 2 != 0 ? 'a' : (char) 25) != 'a') {
            try {
                AppReadyMixpanelTracker appReadyMixpanelTracker = BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(str, "");
                appReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory(str);
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            AppReadyMixpanelTracker appReadyMixpanelTracker2 = BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(str, "");
            appReadyMixpanelTracker2.BuiltInFictitiousFunctionClassFactory(str);
            Object obj = null;
            obj.hashCode();
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmStatic
    public static final void MyBillsEntityDataFactory(Function0<Boolean> function0) {
        int i = getSupportButtonTintMode + 105;
        readMicros = i % 128;
        if ((i % 2 != 0 ? '/' : (char) 28) != 28) {
            try {
                Intrinsics.checkNotNullParameter(function0, "");
                try {
                    PrepareContext = function0;
                    Object obj = null;
                    obj.hashCode();
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            Intrinsics.checkNotNullParameter(function0, "");
            PrepareContext = function0;
        }
        int i2 = readMicros + 105;
        getSupportButtonTintMode = i2 % 128;
        int i3 = i2 % 2;
    }

    @JvmStatic
    public static final void MyBillsEntityDataFactory(boolean z) {
        int i = getSupportButtonTintMode + 97;
        readMicros = i % 128;
        boolean z2 = i % 2 == 0;
        GetContactSyncConfig = z;
        if (!z2) {
            int i2 = 86 / 0;
        }
        int i3 = getSupportButtonTintMode + 1;
        readMicros = i3 % 128;
        int i4 = i3 % 2;
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(boolean z) {
        int i = readMicros + 95;
        getSupportButtonTintMode = i % 128;
        char c = i % 2 == 0 ? (char) 4 : '!';
        newProxyInstance = z;
        if (c == 4) {
            int i2 = 4 / 0;
        }
        try {
            int i3 = getSupportButtonTintMode + 101;
            readMicros = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmStatic
    public static final void getAuthRequestContext(HomeAdapter.HomeWidget homeWidget) {
        int i = getSupportButtonTintMode + 27;
        readMicros = i % 128;
        if ((i % 2 != 0 ? '\'' : (char) 20) != 20) {
            Intrinsics.checkNotNullParameter(homeWidget, "");
            NetworkUserEntityData$$ExternalSyntheticLambda5.put((EnumMap<HomeAdapter.HomeWidget, Long>) homeWidget, (HomeAdapter.HomeWidget) Long.valueOf(System.currentTimeMillis()));
            Object[] objArr = null;
            int length = objArr.length;
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(homeWidget, "");
            NetworkUserEntityData$$ExternalSyntheticLambda5.put((EnumMap<HomeAdapter.HomeWidget, Long>) homeWidget, (HomeAdapter.HomeWidget) Long.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f A[PHI: r1
      0x003f: PHI (r1v8 java.lang.Long) = (r1v3 long), (r1v14 long) binds: [B:12:0x003b, B:9:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0096 A[PHI: r1
      0x0096: PHI (r1v4 java.lang.Long) = (r1v3 long), (r1v14 long) binds: [B:12:0x003b, B:9:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void BuiltInFictitiousFunctionClassFactory(id.dana.home.adapter.HomeAdapter.HomeWidget r8) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.performancetracker.AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory(id.dana.home.adapter.HomeAdapter$HomeWidget):void");
    }

    public static void lookAheadTest() {
        int i = getSupportButtonTintMode + 119;
        readMicros = i % 128;
        if (!(i % 2 == 0)) {
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = System.currentTimeMillis();
            int i2 = 10 / 0;
            return;
        }
        try {
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = System.currentTimeMillis();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void SubSequence() {
        int i = readMicros + 31;
        getSupportButtonTintMode = i % 128;
        if (!(i % 2 == 0)) {
            KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1 = System.currentTimeMillis();
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1 = System.currentTimeMillis();
        Object obj = null;
        obj.hashCode();
    }

    public static void PrepareContext() {
        try {
            int i = getSupportButtonTintMode + 73;
            readMicros = i % 128;
            if ((i % 2 != 0 ? '\b' : (char) 2) != 2) {
                KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = System.currentTimeMillis();
                Object[] objArr = null;
                int length = objArr.length;
            } else {
                KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = System.currentTimeMillis();
            }
            int i2 = readMicros + 13;
            getSupportButtonTintMode = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmStatic
    public static final void moveToNextValue() {
        int i = readMicros + 119;
        getSupportButtonTintMode = i % 128;
        if ((i % 2 == 0 ? (char) 4 : (char) 21) != 4) {
            KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest = System.currentTimeMillis();
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest = System.currentTimeMillis();
        int i2 = 70 / 0;
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory() {
        try {
            int i = getSupportButtonTintMode + 21;
            try {
                readMicros = i % 128;
                int i2 = i % 2;
                AppPerformanceData appPerformanceData = KClassImpl$Data$declaredNonStaticMembers$2;
                appPerformanceData.getAuthRequestContext = 0L;
                appPerformanceData.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0L;
                appPerformanceData.BuiltInFictitiousFunctionClassFactory = 0L;
                appPerformanceData.lookAheadTest = 0L;
                appPerformanceData.scheduleImpl = 0L;
                NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
                DatabaseTableConfigUtil = false;
                initRecordTimeStamp = false;
                GetContactSyncConfig = true;
                newProxyInstance = true;
                scheduleImpl = false;
                NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
                MyBillsEntityDataFactory = false;
                moveToNextValue = false;
                getErrorConfigVersion = true;
                int i3 = readMicros + 21;
                getSupportButtonTintMode = i3 % 128;
                if ((i3 % 2 == 0 ? (char) 20 : (char) 27) != 20) {
                    return;
                }
                int i4 = 0 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
    
        if (r1 != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        if (r1 != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (r2 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        r1 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
    
        r1 = 'H';
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
    
        if (r1 == 'H') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
    
        if (r3 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0040, code lost:
    
        if (r1 == true) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0043, code lost:
    
        MyBillsEntityDataFactory(r5, id.dana.analytics.tracker.TrackerKey.Property.HAPPY_PATH);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
    
        r0 = id.dana.performancetracker.AppReadyMixpanelTracker.getSupportButtonTintMode + 73;
        id.dana.performancetracker.AppReadyMixpanelTracker.readMicros = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0077, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0078, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void B() {
        /*
            r5 = this;
            boolean r0 = BottomSheetCardBindingView$watcherCardNumberView$1()
            boolean r1 = A()
            boolean r2 = getSupportButtonTintMode()
            boolean r3 = VerifyPinStateManager$executeRiskChallenge$2$1()
            if (r0 == 0) goto L57
            int r0 = id.dana.performancetracker.AppReadyMixpanelTracker.readMicros     // Catch: java.lang.Exception -> L55
            int r0 = r0 + 47
            int r4 = r0 % 128
            id.dana.performancetracker.AppReadyMixpanelTracker.getSupportButtonTintMode = r4
            int r0 = r0 % 2
            r4 = 94
            if (r0 != 0) goto L23
            r0 = 94
            goto L25
        L23:
            r0 = 75
        L25:
            if (r0 == r4) goto L2a
            if (r1 == 0) goto L57
            goto L30
        L2a:
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L53
            if (r1 == 0) goto L57
        L30:
            r0 = 72
            if (r2 != 0) goto L36
            r1 = 5
            goto L38
        L36:
            r1 = 72
        L38:
            if (r1 == r0) goto L43
            r0 = 1
            if (r3 == 0) goto L3f
            r1 = 1
            goto L40
        L3f:
            r1 = 0
        L40:
            if (r1 == r0) goto L43
            goto L57
        L43:
            java.lang.String r0 = "Happy Path"
            MyBillsEntityDataFactory(r5, r0)     // Catch: java.lang.Exception -> L77
            int r0 = id.dana.performancetracker.AppReadyMixpanelTracker.getSupportButtonTintMode
            int r0 = r0 + 73
            int r1 = r0 % 128
            id.dana.performancetracker.AppReadyMixpanelTracker.readMicros = r1
            int r0 = r0 % 2
            goto L57
        L53:
            r0 = move-exception
            throw r0
        L55:
            r0 = move-exception
            throw r0
        L57:
            boolean r0 = BottomSheetCardBindingView$watcherCardNumberView$1()
            r1 = 74
            if (r0 == 0) goto L62
            r0 = 74
            goto L64
        L62:
            r0 = 99
        L64:
            if (r0 == r1) goto L67
            goto L76
        L67:
            int r0 = id.dana.performancetracker.AppReadyMixpanelTracker.readMicros
            int r0 = r0 + 87
            int r1 = r0 % 128
            id.dana.performancetracker.AppReadyMixpanelTracker.getSupportButtonTintMode = r1
            int r0 = r0 % 2
            kotlin.jvm.functions.Function0<kotlin.Unit> r0 = id.dana.performancetracker.AppReadyMixpanelTracker.isLayoutRequested     // Catch: java.lang.Exception -> L77
            r0.invoke()     // Catch: java.lang.Exception -> L77
        L76:
            return
        L77:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.performancetracker.AppReadyMixpanelTracker.B():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
    
        if ((!r0 ? ',' : id.dana.cashier.view.InputCardNumberView.DIVIDER) != ' ') goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        if (getSupportButtonTintMode() == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
    
        if (VerifyPinStateManager$executeRiskChallenge$2$1() == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
    
        id.dana.performancetracker.AppReadyMixpanelTracker.GetContactSyncConfig = false;
        id.dana.performancetracker.AppReadyMixpanelTracker.newProxyInstance = false;
        r2 = id.dana.performancetracker.AppReadyMixpanelTracker.FragmentBottomSheetPaymentSettingBinding;
        r3 = new java.util.ArrayList();
        r2 = r2.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
    
        if (r2.hasNext() == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
    
        r4 = r2.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006a, code lost:
    
        if ((!id.dana.performancetracker.AppReadyMixpanelTracker.NetworkUserEntityData$$ExternalSyntheticLambda3.containsKey((id.dana.home.adapter.HomeAdapter.HomeWidget) r4)) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006e, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006f, code lost:
    
        if (r5 == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0071, code lost:
    
        r3.add(r4);
        r4 = id.dana.performancetracker.AppReadyMixpanelTracker.getSupportButtonTintMode + 59;
        id.dana.performancetracker.AppReadyMixpanelTracker.readMicros = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0080, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0081, code lost:
    
        PlaceComponentResult(r3, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void BuiltInFictitiousFunctionClassFactory(java.lang.String r8) {
        /*
            r7 = this;
            boolean r0 = BottomSheetCardBindingView$watcherCardNumberView$1()     // Catch: java.lang.Exception -> L87
            if (r0 != 0) goto L86
            int r0 = id.dana.performancetracker.AppReadyMixpanelTracker.readMicros
            int r0 = r0 + 5
            int r1 = r0 % 128
            id.dana.performancetracker.AppReadyMixpanelTracker.getSupportButtonTintMode = r1
            int r0 = r0 % 2
            boolean r0 = A()
            if (r0 == 0) goto L86
            int r0 = id.dana.performancetracker.AppReadyMixpanelTracker.readMicros
            r1 = 1
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.performancetracker.AppReadyMixpanelTracker.getSupportButtonTintMode = r2
            int r0 = r0 % 2
            if (r0 != 0) goto L36
            boolean r0 = getSupportButtonTintMode()
            r2 = 0
            int r2 = r2.length     // Catch: java.lang.Throwable -> L34
            r2 = 32
            if (r0 != 0) goto L2f
            r0 = 44
            goto L31
        L2f:
            r0 = 32
        L31:
            if (r0 == r2) goto L42
            goto L3c
        L34:
            r8 = move-exception
            throw r8
        L36:
            boolean r0 = getSupportButtonTintMode()
            if (r0 != 0) goto L42
        L3c:
            boolean r0 = VerifyPinStateManager$executeRiskChallenge$2$1()
            if (r0 == 0) goto L86
        L42:
            r0 = 0
            id.dana.performancetracker.AppReadyMixpanelTracker.GetContactSyncConfig = r0
            id.dana.performancetracker.AppReadyMixpanelTracker.newProxyInstance = r0
            java.util.Set<id.dana.home.adapter.HomeAdapter$HomeWidget> r2 = id.dana.performancetracker.AppReadyMixpanelTracker.FragmentBottomSheetPaymentSettingBinding
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r2 = r2.iterator()
        L56:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L81
            java.lang.Object r4 = r2.next()     // Catch: java.lang.Exception -> L7f
            r5 = r4
            id.dana.home.adapter.HomeAdapter$HomeWidget r5 = (id.dana.home.adapter.HomeAdapter.HomeWidget) r5     // Catch: java.lang.Exception -> L7f
            java.util.EnumMap<id.dana.home.adapter.HomeAdapter$HomeWidget, java.lang.Long> r6 = id.dana.performancetracker.AppReadyMixpanelTracker.NetworkUserEntityData$$ExternalSyntheticLambda3     // Catch: java.lang.Exception -> L87
            boolean r5 = r6.containsKey(r5)     // Catch: java.lang.Exception -> L87
            r5 = r5 ^ r1
            if (r5 == 0) goto L6e
            r5 = 1
            goto L6f
        L6e:
            r5 = 0
        L6f:
            if (r5 == 0) goto L56
            r3.add(r4)
            int r4 = id.dana.performancetracker.AppReadyMixpanelTracker.getSupportButtonTintMode
            int r4 = r4 + 59
            int r5 = r4 % 128
            id.dana.performancetracker.AppReadyMixpanelTracker.readMicros = r5
            int r4 = r4 % 2
            goto L56
        L7f:
            r8 = move-exception
            throw r8
        L81:
            java.util.List r3 = (java.util.List) r3
            r7.PlaceComponentResult(r3, r8)
        L86:
            return
        L87:
            r8 = move-exception
            goto L8a
        L89:
            throw r8
        L8a:
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.performancetracker.AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory(java.lang.String):void");
    }

    public final void getAuthRequestContext(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        if ((z ? '8' : Typography.dollar) != '8') {
            NetworkUserEntityData$$ExternalSyntheticLambda0.onNext(str);
            int i = readMicros + 85;
            getSupportButtonTintMode = i % 128;
            int i2 = i % 2;
            return;
        }
        int i3 = readMicros + 63;
        getSupportButtonTintMode = i3 % 128;
        if ((i3 % 2 == 0 ? 'P' : (char) 22) != 22) {
            BuiltInFictitiousFunctionClassFactory(str);
            Object obj = null;
            obj.hashCode();
            return;
        }
        BuiltInFictitiousFunctionClassFactory(str);
    }

    private static boolean BottomSheetCardBindingView$watcherCardNumberView$1() {
        boolean isEmpty;
        Set mutableSet = CollectionsKt.toMutableSet(CollectionsKt.sorted(FragmentBottomSheetPaymentSettingBinding));
        if (mutableSet.isEmpty()) {
            return false;
        }
        synchronized (mutableSet) {
            StringBuilder sb = new StringBuilder();
            sb.append("WIDGETS IN VIEW PORT - ");
            sb.append(CollectionsKt.joinToString$default(CollectionsKt.sorted(mutableSet), null, null, null, 0, null, null, 63, null));
            DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.APP_READY, sb.toString());
            Iterable keySet = NetworkUserEntityData$$ExternalSyntheticLambda3.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "");
            Iterator it = CollectionsKt.sorted(keySet).iterator();
            while (it.hasNext()) {
                mutableSet.remove((HomeAdapter.HomeWidget) it.next());
            }
            isEmpty = mutableSet.isEmpty();
            if (!isEmpty) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("WIDGETS ARE NOT READY - ");
                sb2.append(CollectionsKt.joinToString$default(CollectionsKt.sorted(mutableSet), null, null, null, 0, null, null, 63, null));
                DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.APP_READY, sb2.toString());
            }
        }
        return isEmpty;
    }

    private static boolean A() {
        long j;
        int i = getSupportButtonTintMode + 13;
        readMicros = i % 128;
        int i2 = i % 2;
        boolean z = true;
        if (GetContactSyncConfig) {
            j = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
        } else {
            if (newProxyInstance) {
                j = KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1;
            } else {
                try {
                    try {
                        j = KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        if ((j > 0 ? 'W' : 'S') != 'S') {
            int i3 = getSupportButtonTintMode + 31;
            readMicros = i3 % 128;
            int i4 = i3 % 2;
        } else {
            z = false;
        }
        int i5 = getSupportButtonTintMode + 69;
        readMicros = i5 % 128;
        int i6 = i5 % 2;
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if ((!r0 ? 'D' : 24) != 24) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0029, code lost:
    
        if ((id.dana.performancetracker.AppReadyMixpanelTracker.newProxyInstance) != true) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
    
        if (id.dana.performancetracker.AppReadyMixpanelTracker.GetContactSyncConfig == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0031, code lost:
    
        r0 = '4';
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
    
        r0 = 'a';
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
    
        if (r0 == '4') goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0045, code lost:
    
        if (id.dana.performancetracker.AppReadyMixpanelTracker.PrepareContext.invoke().booleanValue() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0049, code lost:
    
        r0 = id.dana.performancetracker.AppReadyMixpanelTracker.readMicros + 19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004d, code lost:
    
        id.dana.performancetracker.AppReadyMixpanelTracker.getSupportButtonTintMode = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0053, code lost:
    
        if (id.dana.performancetracker.AppReadyMixpanelTracker.NetworkUserEntityData$$ExternalSyntheticLambda8 != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0055, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0057, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0058, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:?, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean VerifyPinStateManager$executeRiskChallenge$2$1() {
        /*
            int r0 = id.dana.performancetracker.AppReadyMixpanelTracker.readMicros
            int r0 = r0 + 35
            int r1 = r0 % 128
            id.dana.performancetracker.AppReadyMixpanelTracker.getSupportButtonTintMode = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L22
            boolean r0 = id.dana.performancetracker.AppReadyMixpanelTracker.newProxyInstance
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L20
            r3 = 24
            if (r0 != 0) goto L1b
            r0 = 68
            goto L1d
        L1b:
            r0 = 24
        L1d:
            if (r0 == r3) goto L39
            goto L2b
        L20:
            r0 = move-exception
            throw r0
        L22:
            boolean r0 = id.dana.performancetracker.AppReadyMixpanelTracker.newProxyInstance     // Catch: java.lang.Exception -> L59
            if (r0 != 0) goto L28
            r0 = 0
            goto L29
        L28:
            r0 = 1
        L29:
            if (r0 == r2) goto L39
        L2b:
            boolean r0 = id.dana.performancetracker.AppReadyMixpanelTracker.GetContactSyncConfig
            r3 = 52
            if (r0 == 0) goto L34
            r0 = 52
            goto L36
        L34:
            r0 = 97
        L36:
            if (r0 == r3) goto L39
            goto L56
        L39:
            kotlin.jvm.functions.Function0<java.lang.Boolean> r0 = id.dana.performancetracker.AppReadyMixpanelTracker.PrepareContext     // Catch: java.lang.Exception -> L57
            java.lang.Object r0 = r0.invoke()     // Catch: java.lang.Exception -> L59
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L56
            int r0 = id.dana.performancetracker.AppReadyMixpanelTracker.readMicros     // Catch: java.lang.Exception -> L59
            int r0 = r0 + 19
            int r3 = r0 % 128
            id.dana.performancetracker.AppReadyMixpanelTracker.getSupportButtonTintMode = r3     // Catch: java.lang.Exception -> L59
            int r0 = r0 % 2
            boolean r0 = id.dana.performancetracker.AppReadyMixpanelTracker.NetworkUserEntityData$$ExternalSyntheticLambda8
            if (r0 != 0) goto L56
            r1 = 1
        L56:
            return r1
        L57:
            r0 = move-exception
            throw r0
        L59:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.performancetracker.AppReadyMixpanelTracker.VerifyPinStateManager$executeRiskChallenge$2$1():boolean");
    }

    private static /* synthetic */ void MyBillsEntityDataFactory(AppReadyMixpanelTracker appReadyMixpanelTracker, String str) {
        int i = getSupportButtonTintMode + 101;
        readMicros = i % 128;
        if ((i % 2 != 0 ? 'c' : (char) 4) != 'c') {
            try {
                appReadyMixpanelTracker.PlaceComponentResult(CollectionsKt.emptyList(), str);
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        appReadyMixpanelTracker.PlaceComponentResult(CollectionsKt.emptyList(), str);
        int i2 = 43 / 0;
    }

    private final void PlaceComponentResult(List<? extends HomeAdapter.HomeWidget> list, String str) {
        Object next;
        Long l;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("WIDGETS SUCCESS - ");
            try {
                sb.append(str);
                DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.APP_READY, sb.toString());
                G();
                String readMicros2 = readMicros();
                long whenAvailable = whenAvailable();
                IdleTimeUtil idleTimeUtil = IdleTimeUtil.INSTANCE;
                IdleTimeUtil.getAuthRequestContext();
                FirstActionTracker firstActionTracker = FirstActionTracker.INSTANCE;
                FirstActionTracker.getAuthRequestContext(readMicros2);
                getAuthRequestContext(readMicros2, whenAvailable);
                EnumMap<HomeAdapter.HomeWidget, Long> enumMap = NetworkUserEntityData$$ExternalSyntheticLambda3;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator it = enumMap.entrySet().iterator();
                while (true) {
                    if (!(it.hasNext())) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    if (!(!FragmentBottomSheetPaymentSettingBinding.contains(entry.getKey()))) {
                        int i = readMicros + 69;
                        getSupportButtonTintMode = i % 128;
                        int i2 = i % 2;
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                Iterator it2 = linkedHashMap.entrySet().iterator();
                Object[] objArr = null;
                if ((!it2.hasNext() ? 'O' : (char) 21) != 21) {
                    next = null;
                } else {
                    next = it2.next();
                    if (it2.hasNext()) {
                        Long l2 = (Long) ((Map.Entry) next).getValue();
                        do {
                            Object next2 = it2.next();
                            Long l3 = (Long) ((Map.Entry) next2).getValue();
                            if (l2.compareTo(l3) < 0) {
                                int i3 = readMicros + 63;
                                getSupportButtonTintMode = i3 % 128;
                                if (i3 % 2 == 0) {
                                    int i4 = 94 / 0;
                                }
                                next = next2;
                                l2 = l3;
                            }
                        } while (it2.hasNext());
                    }
                }
                Map.Entry entry2 = (Map.Entry) next;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("All TimeMap - ");
                sb2.append(NetworkUserEntityData$$ExternalSyntheticLambda3);
                DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.APP_READY, sb2.toString());
                if (entry2 != null) {
                    int i5 = readMicros + 97;
                    getSupportButtonTintMode = i5 % 128;
                    int i6 = i5 % 2;
                    l = (Long) entry2.getValue();
                } else {
                    l = null;
                }
                long longValue = l == null ? 0L : l.longValue();
                String MyBillsEntityDataFactory2 = MyBillsEntityDataFactory((entry2 != null ? (char) 7 : (char) 11) != 11 ? (HomeAdapter.HomeWidget) entry2.getKey() : null);
                ArrayList arrayList = new ArrayList();
                Iterator<T> it3 = list.iterator();
                while (it3.hasNext()) {
                    arrayList.add(MyBillsEntityDataFactory((HomeAdapter.HomeWidget) it3.next()));
                }
                Application application = PlaceComponentResult;
                if ((application == null ? 'c' : 'S') != 'S') {
                    int i7 = readMicros + 7;
                    getSupportButtonTintMode = i7 % 128;
                    if (i7 % 2 == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        objArr.hashCode();
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    application = null;
                }
                EventTrackerModel.Builder builder = new EventTrackerModel.Builder(application);
                builder.MyBillsEntityDataFactory = TrackerKey.Event.APP_READY;
                EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory2 = builder.MyBillsEntityDataFactory(TrackerKey.Property.START_TYPE, readMicros2).BuiltInFictitiousFunctionClassFactory("Ready in Milliseconds", whenAvailable);
                AppPerformanceData appPerformanceData = KClassImpl$Data$declaredNonStaticMembers$2;
                EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory3 = BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory(TrackerKey.Property.SESSION_ID, appPerformanceData.initRecordTimeStamp).BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.INPUT_PIN_PAGE_SHOWN, appPerformanceData.getKClassImpl$Data$declaredNonStaticMembers$2()).BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.INPUT_OTP_PAGE_SHOWN, appPerformanceData.getPlaceComponentResult()).BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.FACE_LOGIN_PAGE_SHOWN, appPerformanceData.getMyBillsEntityDataFactory()).BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.OPTIONAL_UPDATE_POP_UP_SHOWN, appPerformanceData.getNetworkUserEntityData$$ExternalSyntheticLambda0()).BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.PHONE_NUMBER_PAGE_SHOWN, appPerformanceData.getMoveToNextValue()).BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.REINPUT_PIN_PAGE_SHOWN, appPerformanceData.getDatabaseTableConfigUtil()).BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.FROM_DEEPLINK, MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.FROM_NOTIFICATION, moveToNextValue).BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.PASSIVE_BIOMETRIC_ENABLE, appPerformanceData.getGetErrorConfigVersion());
                Long VerifyPinStateManager$executeRiskChallenge$2$2 = VerifyPinStateManager$executeRiskChallenge$2$2();
                if (VerifyPinStateManager$executeRiskChallenge$2$2 != null) {
                    BuiltInFictitiousFunctionClassFactory3.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.APP_INIT_DURATION, VerifyPinStateManager$executeRiskChallenge$2$2.longValue());
                }
                Long E = E();
                if (E != null) {
                    int i8 = readMicros + 99;
                    getSupportButtonTintMode = i8 % 128;
                    if (i8 % 2 == 0) {
                        BuiltInFictitiousFunctionClassFactory3.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.SPLASH_DURATION, E.longValue());
                        int i9 = 51 / 0;
                    } else {
                        BuiltInFictitiousFunctionClassFactory3.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.SPLASH_DURATION, E.longValue());
                    }
                }
                Long D = D();
                if ((D != null ? ')' : (char) 22) != 22) {
                    int i10 = getSupportButtonTintMode + 29;
                    readMicros = i10 % 128;
                    if (i10 % 2 != 0) {
                        BuiltInFictitiousFunctionClassFactory3.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.HOME_DURATION, D.longValue());
                        int length = objArr.length;
                    } else {
                        BuiltInFictitiousFunctionClassFactory3.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.HOME_DURATION, D.longValue());
                    }
                }
                Long valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
                if (valueOfTouchPositionAbsolute != null) {
                    BuiltInFictitiousFunctionClassFactory3.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.SPLASH_CHECK_SESSION_IN_MILLIS, valueOfTouchPositionAbsolute.longValue());
                }
                Long onBoardingScenario = getOnBoardingScenario();
                if (!(onBoardingScenario == null)) {
                    BuiltInFictitiousFunctionClassFactory3.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.HOME_CHECK_SESSION_IN_MILLIS, onBoardingScenario.longValue());
                }
                if ((Intrinsics.areEqual(readMicros2, TrackerKey.AppStartProperty.APP_START_COLD) ? 'S' : '+') != '+') {
                    BuiltInFictitiousFunctionClassFactory3.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.SLOWEST_COMPONENT_TIME, longValue).MyBillsEntityDataFactory(TrackerKey.Property.SLOWEST_COMPONENT, MyBillsEntityDataFactory2).BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.UNFINISHED_COMPONENTS, CollectionsKt.toList(arrayList)).MyBillsEntityDataFactory(TrackerKey.Property.APP_READY_STOP_CRITERIA, str);
                }
                StartupConfig startupConfig = NetworkUserEntityData$$ExternalSyntheticLambda4;
                if ((startupConfig != null ? (char) 6 : '2') == 6) {
                    int i11 = readMicros + 31;
                    getSupportButtonTintMode = i11 % 128;
                    int i12 = i11 % 2;
                    Intrinsics.checkNotNull(startupConfig);
                    EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory4 = BuiltInFictitiousFunctionClassFactory3.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.NON_BLOCKING_SPLASH, startupConfig.isEnableNonBlockingSplash());
                    StartupConfig startupConfig2 = NetworkUserEntityData$$ExternalSyntheticLambda4;
                    Intrinsics.checkNotNull(startupConfig2);
                    BuiltInFictitiousFunctionClassFactory4.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.SIMPLE_GET_USER_ID, startupConfig2.isEnableSimpleGetUserId());
                }
                if (appPerformanceData.scheduleImpl > 0) {
                    BuiltInFictitiousFunctionClassFactory3.BuiltInFictitiousFunctionClassFactory(TrackerKey.PassiveBioProperties.PASSIVE_BIOMETRIC_READY, appPerformanceData.scheduleImpl);
                }
                BuiltInFictitiousFunctionClassFactory3.PlaceComponentResult();
                EventTracker.PlaceComponentResult(new EventTrackerModel(BuiltInFictitiousFunctionClassFactory3, (byte) 0));
                C();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static String MyBillsEntityDataFactory(HomeAdapter.HomeWidget homeWidget) {
        int i;
        if (!(homeWidget == null)) {
            i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[homeWidget.ordinal()];
        } else {
            int i2 = readMicros + 95;
            getSupportButtonTintMode = i2 % 128;
            int i3 = i2 % 2;
            i = -1;
        }
        switch (i) {
            case 1:
                int i4 = getSupportButtonTintMode + 125;
                readMicros = i4 % 128;
                int i5 = i4 % 2;
                return "Balance";
            case 2:
                int i6 = getSupportButtonTintMode + 123;
                readMicros = i6 % 128;
                if ((i6 % 2 != 0 ? '\'' : '3') != '3') {
                    int i7 = 52 / 0;
                    return "Four Kings";
                }
                return "Four Kings";
            case 3:
                return "Social Widget";
            case 4:
                return "Nearby";
            case 5:
                return "Rolling Banner";
            case 6:
                return "News";
            case 7:
                Object[] objArr = new Object[1];
                a((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1, new char[]{3344, 25316, 3395, 13090, 52029, 26633, 58499, 4124, 19445, 64168, 33214, 11034}, objArr);
                return ((String) objArr[0]).intern();
            case 8:
                return "Bottom Bar";
            case 9:
                return "Home Investment";
            case 10:
                return "More For You";
            case 11:
                return TrackerKey.SourceType.DANA_PROTECTION;
            case 12:
                return "Home Personalization";
            case 13:
            default:
                return "";
            case 14:
                return "Notification Icon";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        if (r0.getKClassImpl$Data$declaredNonStaticMembers$2() == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        if (r0.getPlaceComponentResult() != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        if (r5 == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        r5 = id.dana.performancetracker.AppReadyMixpanelTracker.getSupportButtonTintMode + 25;
        id.dana.performancetracker.AppReadyMixpanelTracker.readMicros = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        if ((r5 % 2) == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r5 = r0.getMyBillsEntityDataFactory();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0043, code lost:
    
        if (r5 != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004c, code lost:
    
        if (r0.getMyBillsEntityDataFactory() != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0052, code lost:
    
        if (r0.getNetworkUserEntityData$$ExternalSyntheticLambda0() != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0054, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
    
        if (r5 == true) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005a, code lost:
    
        r5 = id.dana.performancetracker.AppReadyMixpanelTracker.getSupportButtonTintMode + 71;
        id.dana.performancetracker.AppReadyMixpanelTracker.readMicros = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0067, code lost:
    
        if (r0.getMoveToNextValue() != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
    
        r5 = id.dana.performancetracker.AppReadyMixpanelTracker.readMicros + 57;
        id.dana.performancetracker.AppReadyMixpanelTracker.getSupportButtonTintMode = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0072, code lost:
    
        if ((r5 % 2) != 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0074, code lost:
    
        r0 = r0.getDatabaseTableConfigUtil();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0078, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007b, code lost:
    
        if (r0 != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0084, code lost:
    
        if (r0.getDatabaseTableConfigUtil() != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0086, code lost:
    
        r0 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0088, code lost:
    
        r0 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0089, code lost:
    
        if (r0 == 2) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008b, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008c, code lost:
    
        r0 = id.dana.performancetracker.AppReadyMixpanelTracker.readMicros + 111;
        id.dana.performancetracker.AppReadyMixpanelTracker.getSupportButtonTintMode = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0095, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0096, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0097, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
    
        if (r5 == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean scheduleImpl() {
        /*
            int r0 = id.dana.performancetracker.AppReadyMixpanelTracker.getSupportButtonTintMode
            int r0 = r0 + 103
            int r1 = r0 % 128
            id.dana.performancetracker.AppReadyMixpanelTracker.readMicros = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L1d
            id.dana.utils.AppPerformanceData r0 = id.dana.performancetracker.AppReadyMixpanelTracker.KClassImpl$Data$declaredNonStaticMembers$2
            boolean r5 = r0.getKClassImpl$Data$declaredNonStaticMembers$2()
            r3.hashCode()     // Catch: java.lang.Throwable -> L1b
            if (r5 != 0) goto L8b
            goto L25
        L1b:
            r0 = move-exception
            throw r0
        L1d:
            id.dana.utils.AppPerformanceData r0 = id.dana.performancetracker.AppReadyMixpanelTracker.KClassImpl$Data$declaredNonStaticMembers$2
            boolean r5 = r0.getKClassImpl$Data$declaredNonStaticMembers$2()
            if (r5 != 0) goto L8b
        L25:
            boolean r5 = r0.getPlaceComponentResult()
            if (r5 != 0) goto L2d
            r5 = 0
            goto L2e
        L2d:
            r5 = 1
        L2e:
            if (r5 == 0) goto L31
            goto L8b
        L31:
            int r5 = id.dana.performancetracker.AppReadyMixpanelTracker.getSupportButtonTintMode
            int r5 = r5 + 25
            int r6 = r5 % 128
            id.dana.performancetracker.AppReadyMixpanelTracker.readMicros = r6
            int r5 = r5 % r1
            if (r5 == 0) goto L48
            boolean r5 = r0.getMyBillsEntityDataFactory()
            r3.hashCode()     // Catch: java.lang.Throwable -> L46
            if (r5 != 0) goto L8b
            goto L4e
        L46:
            r0 = move-exception
            throw r0
        L48:
            boolean r5 = r0.getMyBillsEntityDataFactory()
            if (r5 != 0) goto L8b
        L4e:
            boolean r5 = r0.getNetworkUserEntityData$$ExternalSyntheticLambda0()
            if (r5 != 0) goto L56
            r5 = 1
            goto L57
        L56:
            r5 = 0
        L57:
            if (r5 == r4) goto L5a
            goto L8b
        L5a:
            int r5 = id.dana.performancetracker.AppReadyMixpanelTracker.getSupportButtonTintMode
            int r5 = r5 + 71
            int r6 = r5 % 128
            id.dana.performancetracker.AppReadyMixpanelTracker.readMicros = r6
            int r5 = r5 % r1
            boolean r5 = r0.getMoveToNextValue()
            if (r5 != 0) goto L8b
            int r5 = id.dana.performancetracker.AppReadyMixpanelTracker.readMicros
            int r5 = r5 + 57
            int r6 = r5 % 128
            id.dana.performancetracker.AppReadyMixpanelTracker.getSupportButtonTintMode = r6
            int r5 = r5 % r1
            if (r5 != 0) goto L80
            boolean r0 = r0.getDatabaseTableConfigUtil()
            r3.hashCode()     // Catch: java.lang.Throwable -> L7e
            if (r0 != 0) goto L8b
            goto L8c
        L7e:
            r0 = move-exception
            throw r0
        L80:
            boolean r0 = r0.getDatabaseTableConfigUtil()     // Catch: java.lang.Exception -> L96
            if (r0 != 0) goto L88
            r0 = 2
            goto L89
        L88:
            r0 = 3
        L89:
            if (r0 == r1) goto L8c
        L8b:
            r2 = 1
        L8c:
            int r0 = id.dana.performancetracker.AppReadyMixpanelTracker.readMicros     // Catch: java.lang.Exception -> L96
            int r0 = r0 + 111
            int r3 = r0 % 128
            id.dana.performancetracker.AppReadyMixpanelTracker.getSupportButtonTintMode = r3     // Catch: java.lang.Exception -> L96
            int r0 = r0 % r1
            return r2
        L96:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.performancetracker.AppReadyMixpanelTracker.scheduleImpl():boolean");
    }

    private static void getAuthRequestContext(String str, long j) {
        if ((KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue() ? (char) 29 : '3') == 29) {
            FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory().MyBillsEntityDataFactory(PlaceComponentResult(str), "Ready in Milliseconds", j);
            FirebasePerformanceMonitor MyBillsEntityDataFactory2 = FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
            String PlaceComponentResult2 = PlaceComponentResult(str);
            Intrinsics.checkNotNullParameter(PlaceComponentResult2, "");
            Trace trace = MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2.get(PlaceComponentResult2);
            if (trace != null) {
                int i = getSupportButtonTintMode + 103;
                readMicros = i % 128;
                if (!(i % 2 == 0)) {
                    trace.stop();
                    int i2 = 61 / 0;
                } else {
                    trace.stop();
                }
                int i3 = getSupportButtonTintMode + 93;
                readMicros = i3 % 128;
                int i4 = i3 % 2;
            }
            AppReadyRumTracker.MyBillsEntityDataFactory(TuplesKt.to(TrackerKey.Event.LOGGED_IN_SPLUNK, Boolean.TRUE));
        }
        int i5 = readMicros + 117;
        getSupportButtonTintMode = i5 % 128;
        int i6 = i5 % 2;
    }

    private static String PlaceComponentResult(String str) {
        String str2;
        if (Intrinsics.areEqual(str, TrackerKey.AppStartProperty.APP_START_HOT)) {
            return "app_ready_hot";
        }
        try {
            if ((Intrinsics.areEqual(str, TrackerKey.AppStartProperty.APP_START_WARM) ? (char) 30 : '6') != '6') {
                int i = getSupportButtonTintMode + 41;
                readMicros = i % 128;
                int i2 = i % 2;
                int i3 = readMicros + 31;
                getSupportButtonTintMode = i3 % 128;
                int i4 = i3 % 2;
                str2 = "app_ready_warm";
            } else {
                str2 = "app_ready_cold";
                int i5 = readMicros + 115;
                try {
                    getSupportButtonTintMode = i5 % 128;
                    int i6 = i5 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
            return str2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static boolean getSupportButtonTintMode() {
        try {
            int i = getSupportButtonTintMode + 47;
            try {
                readMicros = i % 128;
                int i2 = i % 2;
                if ((!newProxyInstance ? '#' : '`') != '`' && !GetContactSyncConfig) {
                    if (!(scheduleImpl)) {
                        if (getErrorConfigVersion) {
                            int i3 = getSupportButtonTintMode + 117;
                            readMicros = i3 % 128;
                            int i4 = i3 % 2;
                            return true;
                        }
                    }
                }
                return false;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static String readMicros() {
        boolean z = !GetContactSyncConfig;
        String str = TrackerKey.AppStartProperty.APP_START_WARM;
        if (!z) {
            int i = getSupportButtonTintMode + 31;
            readMicros = i % 128;
            if (i % 2 != 0) {
                NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
            } else {
                NetworkUserEntityData$$ExternalSyntheticLambda8 = true;
            }
            int i2 = getSupportButtonTintMode + 47;
            readMicros = i2 % 128;
            int i3 = i2 % 2;
            str = TrackerKey.AppStartProperty.APP_START_HOT;
        } else {
            if (!(newProxyInstance)) {
                scheduleImpl = true;
                str = TrackerKey.AppStartProperty.APP_START_COLD;
            } else {
                try {
                    int i4 = getSupportButtonTintMode + 119;
                    try {
                        readMicros = i4 % 128;
                        if ((i4 % 2 != 0 ? (char) 21 : 'S') != 'S') {
                            NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
                        } else {
                            NetworkUserEntityData$$ExternalSyntheticLambda8 = true;
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        int i5 = getSupportButtonTintMode + 47;
        readMicros = i5 % 128;
        if (!(i5 % 2 == 0)) {
            int i6 = 69 / 0;
            return str;
        }
        return str;
    }

    private static long whenAvailable() {
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        getAuthRequestContext = currentTimeMillis;
        if (!(!GetContactSyncConfig)) {
            j = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
            int i = readMicros + 23;
            getSupportButtonTintMode = i % 128;
            int i2 = i % 2;
        } else {
            try {
                if ((newProxyInstance ? 'R' : (char) 16) != 16) {
                    int i3 = readMicros + 71;
                    getSupportButtonTintMode = i3 % 128;
                    int i4 = i3 % 2;
                    j = KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1;
                } else {
                    long j2 = currentTimeMillis - KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
                    return BuiltInFictitiousFunctionClassFactory.VerifyPinStateManager$executeRiskChallenge$2$2() != null ? j2 : j2;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        return currentTimeMillis - j;
    }

    @JvmStatic
    public static final void KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = getSupportButtonTintMode + 57;
        readMicros = i % 128;
        int i2 = i % 2;
        AppPerformanceData appPerformanceData = KClassImpl$Data$declaredNonStaticMembers$2;
        appPerformanceData.scheduleImpl = System.currentTimeMillis() - appPerformanceData.lookAheadTest;
        int i3 = readMicros + 67;
        getSupportButtonTintMode = i3 % 128;
        int i4 = i3 % 2;
    }

    @JvmStatic
    public static final void getErrorConfigVersion() {
        int i = readMicros + 45;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        try {
            AppReadyMixpanelTracker appReadyMixpanelTracker = BuiltInFictitiousFunctionClassFactory;
            if ((GetContactSyncConfig ? '8' : '=') == '8') {
                if ((PrepareContext.invoke().booleanValue() ? 'J' : 'b') != 'b') {
                    try {
                        MyBillsEntityDataFactory(appReadyMixpanelTracker, TrackerKey.Property.HAPPY_PATH);
                        int i3 = getSupportButtonTintMode + 33;
                        readMicros = i3 % 128;
                        int i4 = i3 % 2;
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
            int i5 = readMicros + 99;
            getSupportButtonTintMode = i5 % 128;
            int i6 = i5 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void initRecordTimeStamp() {
        try {
            int i = getSupportButtonTintMode + 85;
            readMicros = i % 128;
            int i2 = i % 2;
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = true;
            int i3 = readMicros + 33;
            try {
                getSupportButtonTintMode = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void MyBillsEntityDataFactory(long j) {
        int i = readMicros + 55;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = j;
        int i3 = readMicros + 67;
        getSupportButtonTintMode = i3 % 128;
        if ((i3 % 2 == 0 ? 'I' : 'V') != 'V') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    @JvmStatic
    public static final void getAuthRequestContext(StartupConfig startupConfig) {
        int i = readMicros + 25;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(startupConfig, "");
        NetworkUserEntityData$$ExternalSyntheticLambda4 = startupConfig;
        int i3 = readMicros + 115;
        getSupportButtonTintMode = i3 % 128;
        if (i3 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(List<HomeViewWidgetModel> list) {
        int i = getSupportButtonTintMode + 65;
        readMicros = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(list, "");
        if (!getSupportButtonTintMode()) {
            int i3 = getSupportButtonTintMode + 45;
            readMicros = i3 % 128;
            if (!(i3 % 2 == 0)) {
                boolean VerifyPinStateManager$executeRiskChallenge$2$1 = VerifyPinStateManager$executeRiskChallenge$2$1();
                Object obj = null;
                obj.hashCode();
                if (!VerifyPinStateManager$executeRiskChallenge$2$1) {
                    return;
                }
            } else if (!VerifyPinStateManager$executeRiskChallenge$2$1()) {
                return;
            }
        }
        FragmentBottomSheetPaymentSettingBinding.clear();
        Iterator<T> it = list.iterator();
        int i4 = readMicros + 99;
        getSupportButtonTintMode = i4 % 128;
        while (true) {
            int i5 = i4 % 2;
            if ((it.hasNext() ? 'H' : '#') == '#') {
                return;
            }
            int i6 = getSupportButtonTintMode + 77;
            readMicros = i6 % 128;
            int i7 = i6 % 2;
            try {
                try {
                    FragmentBottomSheetPaymentSettingBinding.add(((HomeViewWidgetModel) it.next()).MyBillsEntityDataFactory);
                    i4 = readMicros + 95;
                    getSupportButtonTintMode = i4 % 128;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    @JvmStatic
    public static final void getAuthRequestContext() {
        AppPerformanceData appPerformanceData;
        boolean z;
        try {
            int i = getSupportButtonTintMode + 35;
            readMicros = i % 128;
            if ((i % 2 != 0 ? (char) 19 : 'B') != 19) {
                appPerformanceData = KClassImpl$Data$declaredNonStaticMembers$2;
                z = true;
            } else {
                appPerformanceData = KClassImpl$Data$declaredNonStaticMembers$2;
                z = false;
            }
            appPerformanceData.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
            int i2 = readMicros + 105;
            getSupportButtonTintMode = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private void C() {
        int i = readMicros + 81;
        getSupportButtonTintMode = i % 128;
        if (!(i % 2 != 0)) {
            try {
                AppPerformanceSubflowDefaultImpl appPerformanceSubflowDefaultImpl = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                try {
                    appPerformanceSubflowDefaultImpl.KClassImpl$Data$declaredNonStaticMembers$2.clear();
                    appPerformanceSubflowDefaultImpl.PlaceComponentResult.clear();
                    Object[] objArr = null;
                    int length = objArr.length;
                    return;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        AppPerformanceSubflowDefaultImpl appPerformanceSubflowDefaultImpl2 = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        appPerformanceSubflowDefaultImpl2.KClassImpl$Data$declaredNonStaticMembers$2.clear();
        appPerformanceSubflowDefaultImpl2.PlaceComponentResult.clear();
    }

    private Long VerifyPinStateManager$executeRiskChallenge$2$2() {
        try {
            int i = getSupportButtonTintMode + 69;
            readMicros = i % 128;
            int i2 = i % 2;
            Long BuiltInFictitiousFunctionClassFactory2 = this.NetworkUserEntityData$$ExternalSyntheticLambda6.BuiltInFictitiousFunctionClassFactory("danaapplication");
            int i3 = getSupportButtonTintMode + 69;
            readMicros = i3 % 128;
            if (!(i3 % 2 == 0)) {
                Object obj = null;
                obj.hashCode();
                return BuiltInFictitiousFunctionClassFactory2;
            }
            return BuiltInFictitiousFunctionClassFactory2;
        } catch (Exception e) {
            throw e;
        }
    }

    private Long getOnBoardingScenario() {
        int i = readMicros + 77;
        getSupportButtonTintMode = i % 128;
        if (i % 2 != 0) {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda6.BuiltInFictitiousFunctionClassFactory("homechecksessiontime");
        }
        Long BuiltInFictitiousFunctionClassFactory2 = this.NetworkUserEntityData$$ExternalSyntheticLambda6.BuiltInFictitiousFunctionClassFactory("homechecksessiontime");
        Object[] objArr = null;
        int length = objArr.length;
        return BuiltInFictitiousFunctionClassFactory2;
    }

    private Long D() {
        int i = readMicros + 99;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        Long BuiltInFictitiousFunctionClassFactory2 = this.NetworkUserEntityData$$ExternalSyntheticLambda6.BuiltInFictitiousFunctionClassFactory("hometime");
        int i3 = getSupportButtonTintMode + 27;
        readMicros = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return BuiltInFictitiousFunctionClassFactory2;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return BuiltInFictitiousFunctionClassFactory2;
    }

    private Long getValueOfTouchPositionAbsolute() {
        int i = getSupportButtonTintMode + 13;
        readMicros = i % 128;
        int i2 = i % 2;
        try {
            Long BuiltInFictitiousFunctionClassFactory2 = this.NetworkUserEntityData$$ExternalSyntheticLambda6.BuiltInFictitiousFunctionClassFactory("splashchecksessiontime");
            int i3 = getSupportButtonTintMode + 47;
            readMicros = i3 % 128;
            int i4 = i3 % 2;
            return BuiltInFictitiousFunctionClassFactory2;
        } catch (Exception e) {
            throw e;
        }
    }

    private Long E() {
        Long BuiltInFictitiousFunctionClassFactory2;
        int i = readMicros + 27;
        getSupportButtonTintMode = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? Typography.dollar : (char) 28) != 28) {
            BuiltInFictitiousFunctionClassFactory2 = this.NetworkUserEntityData$$ExternalSyntheticLambda6.BuiltInFictitiousFunctionClassFactory("splashtime");
            int length = objArr.length;
        } else {
            BuiltInFictitiousFunctionClassFactory2 = this.NetworkUserEntityData$$ExternalSyntheticLambda6.BuiltInFictitiousFunctionClassFactory("splashtime");
        }
        int i2 = readMicros + 17;
        getSupportButtonTintMode = i2 % 128;
        if (!(i2 % 2 == 0)) {
            return BuiltInFictitiousFunctionClassFactory2;
        }
        objArr.hashCode();
        return BuiltInFictitiousFunctionClassFactory2;
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        try {
            int i = getSupportButtonTintMode + 75;
            readMicros = i % 128;
            if (!(i % 2 != 0)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda6.KClassImpl$Data$declaredNonStaticMembers$2("danaapplication");
                return;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda6.KClassImpl$Data$declaredNonStaticMembers$2("danaapplication");
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        int i = readMicros + 93;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.MyBillsEntityDataFactory("danaapplication");
        int i3 = readMicros + 89;
        getSupportButtonTintMode = i3 % 128;
        if ((i3 % 2 == 0 ? '_' : '\t') != '\t') {
            int i4 = 16 / 0;
        }
    }

    public final void GetContactSyncConfig() {
        int i = getSupportButtonTintMode + 37;
        readMicros = i % 128;
        if (i % 2 != 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6.KClassImpl$Data$declaredNonStaticMembers$2("homechecksessiontime");
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6.KClassImpl$Data$declaredNonStaticMembers$2("homechecksessiontime");
        }
        int i2 = getSupportButtonTintMode + 121;
        readMicros = i2 % 128;
        int i3 = i2 % 2;
    }

    public final void DatabaseTableConfigUtil() {
        int i = getSupportButtonTintMode + 3;
        readMicros = i % 128;
        int i2 = i % 2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.MyBillsEntityDataFactory("homechecksessiontime");
        int i3 = getSupportButtonTintMode + 35;
        readMicros = i3 % 128;
        if (i3 % 2 != 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        int i = getSupportButtonTintMode + 125;
        readMicros = i % 128;
        if (i % 2 == 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6.KClassImpl$Data$declaredNonStaticMembers$2("hometime");
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.KClassImpl$Data$declaredNonStaticMembers$2("hometime");
        int i2 = 15 / 0;
    }

    private void G() {
        int i = readMicros + 25;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.MyBillsEntityDataFactory("hometime");
        int i3 = getSupportButtonTintMode + 105;
        readMicros = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 19 : '8') != 19) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        try {
            int i = getSupportButtonTintMode + 79;
            readMicros = i % 128;
            int i2 = i % 2;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = true;
                int i3 = getSupportButtonTintMode + 17;
                readMicros = i3 % 128;
                if ((i3 % 2 != 0 ? 'R' : 'X') != 'X') {
                    Object obj = null;
                    obj.hashCode();
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void newProxyInstance() {
        AppPerformanceData appPerformanceData;
        boolean z;
        int i = getSupportButtonTintMode + 45;
        readMicros = i % 128;
        if ((i % 2 != 0 ? 'M' : 'U') != 'U') {
            appPerformanceData = KClassImpl$Data$declaredNonStaticMembers$2;
            z = false;
        } else {
            appPerformanceData = KClassImpl$Data$declaredNonStaticMembers$2;
            z = true;
        }
        appPerformanceData.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        int i2 = readMicros + 91;
        getSupportButtonTintMode = i2 % 128;
        int i3 = i2 % 2;
    }

    public static void getAuthRequestContext(boolean z) {
        int i = getSupportButtonTintMode + 11;
        readMicros = i % 128;
        int i2 = i % 2;
        KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = z;
        int i3 = getSupportButtonTintMode + 101;
        readMicros = i3 % 128;
        if ((i3 % 2 != 0 ? '?' : '#') != '#') {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static void isLayoutRequested() {
        try {
            int i = readMicros + 49;
            getSupportButtonTintMode = i % 128;
            int i2 = i % 2;
            KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = true;
            int i3 = readMicros + 45;
            try {
                getSupportButtonTintMode = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda6() {
        int i = readMicros + 27;
        getSupportButtonTintMode = i % 128;
        if ((i % 2 == 0 ? (char) 22 : '6') != '6') {
            KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil = false;
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil = true;
        }
        int i2 = getSupportButtonTintMode + 71;
        readMicros = i2 % 128;
        if ((i2 % 2 != 0 ? 'B' : ':') != ':') {
            int i3 = 11 / 0;
        }
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        int i = getSupportButtonTintMode + 89;
        readMicros = i % 128;
        int i2 = i % 2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.KClassImpl$Data$declaredNonStaticMembers$2("splashchecksessiontime");
        int i3 = readMicros + 107;
        getSupportButtonTintMode = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 18 : 'D') != 'D') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        int i = readMicros + 91;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.MyBillsEntityDataFactory("splashchecksessiontime");
        int i3 = getSupportButtonTintMode + 41;
        readMicros = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda5() {
        int i = getSupportButtonTintMode + 7;
        readMicros = i % 128;
        int i2 = i % 2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.KClassImpl$Data$declaredNonStaticMembers$2("splashtime");
        int i3 = getSupportButtonTintMode + 123;
        readMicros = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 30 : '\\') != 30) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public final void FragmentBottomSheetPaymentSettingBinding() {
        int i = getSupportButtonTintMode + 27;
        readMicros = i % 128;
        int i2 = i % 2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.MyBillsEntityDataFactory("splashtime");
        int i3 = getSupportButtonTintMode + 107;
        readMicros = i3 % 128;
        int i4 = i3 % 2;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        try {
            char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(getCallingPid ^ 3919452569568103912L, cArr, i);
            d.MyBillsEntityDataFactory = 4;
            int i2 = $10 + 1;
            $11 = i2 % 128;
            int i3 = i2 % 2;
            while (true) {
                if (d.MyBillsEntityDataFactory >= KClassImpl$Data$declaredNonStaticMembers$22.length) {
                    objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
                    return;
                }
                int i4 = $10 + 119;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (getCallingPid ^ 3919452569568103912L)));
                d.MyBillsEntityDataFactory++;
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
