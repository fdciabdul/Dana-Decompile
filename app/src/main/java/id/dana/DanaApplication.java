package id.dana;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.multidex.MultiDexApplication;
import androidx.startup.AppInitializer;
import androidx.view.Observer;
import androidx.view.ProcessLifecycleOwner;
import androidx.work.Configuration;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.imobile.network.quake.exception.ClientException;
import com.alipay.imobile.network.quake.exception.ServerException;
import com.alipay.imobile.network.quake.exception.TimeoutException;
import com.google.common.base.Ascii;
import dagger.Lazy;
import id.dana.analytics.mixpanel.MixPanelDataTracker;
import id.dana.danapoly.di.component.DanapolyComponent;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.config.model.FeedCacheData;
import id.dana.data.config.source.HomeWidgetEntityData;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.foundation.facade.IAPPushFacade;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.foundation.utils.CommonUtil;
import id.dana.data.toggle.SplitFacade;
import id.dana.di.SubComponents;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.ImageCaptureComponent;
import id.dana.di.component.InstalledAppComponent;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.LocalSplitAttributesEntityData;
import id.dana.domain.featureconfig.StartupConfigEntityData;
import id.dana.domain.fullstory.interactor.IsEligibleForFullstorySession;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.domain.transferaccount.StatusTransferAccount;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.globalnetwork.AlipayConnectInitializer;
import id.dana.lib.gcontainer.util.UserAgentFactory;
import id.dana.model.ThirdPartyService;
import id.dana.mybills.di.component.MyBillsComponent;
import id.dana.oauth.OauthLoginManager;
import id.dana.oauth.activity.OauthGrantActivity;
import id.dana.onboarding.splash.LocalConfigSplashActivity;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.riskChallenges.di.component.RiskChallengesComponent;
import id.dana.rum.Rum;
import id.dana.sendmoney.di.component.GlobalSendComponent;
import id.dana.sendmoney.di.component.GroupSendComponent;
import id.dana.social.di.component.RestrictedContactComponent;
import id.dana.social.di.component.SocialCommonComponent;
import id.dana.social.di.factory.RestrictedContactComponentFactory;
import id.dana.social.di.factory.SocialCommonComponentFactory;
import id.dana.toggle.SplitObservant;
import id.dana.tracker.EventConfig;
import id.dana.tracker.EventConfigFactory;
import id.dana.tracker.EventConfigProperty;
import id.dana.tracker.constant.TrackerType;
import id.dana.tracker.fullstory.FullstoryTracker;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.transferaccount.TransferAccountStatusChecker;
import id.dana.utils.foundation.facede.ApSecurity;
import id.dana.utils.log.CrashlyticsLogUtil;
import id.dana.xyz.F4X93h6JwT;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.Thread;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;
import org.greenrobot.eventbus.Subscribe;

/* loaded from: classes.dex */
public class DanaApplication extends MultiDexApplication implements Configuration.Provider, SubComponents {
    public static DanaApplication application;
    private RestrictedContactComponent DatabaseTableConfigUtil;
    private SocialCommonComponent GetContactSyncConfig;
    private AlipayConnectInitializer KClassImpl$Data$declaredNonStaticMembers$2;
    private GpsStatusMonitor NetworkUserEntityData$$ExternalSyntheticLambda0;
    private AppInitializer PlaceComponentResult;
    private F4X93h6JwT PrepareContext;
    @Inject
    ApSecurity apSecurity;
    @Inject
    AppLifeCycleObserver appLifeCycleObserver;
    @Inject
    ApplicationOrientationCallback applicationOrientationCallback;
    @Inject
    DanaLocalBroadcastReceiver danaLocalBroadcastReceiver;
    @Inject
    Lazy<DeviceInformationProvider> deviceInformationProvider;
    public FeedCacheData feedData;
    @Inject
    Lazy<GetUserInfo> getUserInfo;
    @Inject
    Lazy<HomeWidgetEntityData> homeWidgetCache;
    @Inject
    IAPPushFacade iapPushFacade;
    private boolean initRecordTimeStamp;
    @Inject
    Lazy<IsEligibleForFullstorySession> isEligibleForFullstorySessionLazy;
    @Inject
    Lazy<MixpanelRepository> mixpanel;
    private ApplicationComponent moveToNextValue;
    @Inject
    Rum rumSplunk;
    private Boolean scheduleImpl;
    public List<ThirdPartyService> servicesData;
    @Inject
    LocalSplitAttributesEntityData sharedPrefForSplitAttributes;
    @Inject
    StartupConfigEntityData sharedPrefStartupConfig;
    @Inject
    Lazy<SplitConfigEntityData> splitConfigEntityData;
    @Inject
    Lazy<SplitFacade> splitFacade;
    @Inject
    Lazy<SplitObservant> splitObservant;
    @Inject
    Lazy<TransferAccountStatusChecker> transferAccountStatusChecker;
    public static final byte[] $$a = {56, -119, 46, TarHeader.LF_CONTIG, -58, 5, -10, -15, 36, -44, 33, -42, -1, -24, 4, -18, 4, -13, -13, -5, 38, -54, 0, 4, -24, 4, -13, -6, 36, -48, 4, -25, -7, 38, -34, -9, -24, -2, -10, -14, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 42;
    public static final byte[] getAuthRequestContext = {TarHeader.LF_DIR, -98, 98, -100, -15, 8, -16, 1, 4, 3, TarHeader.LF_BLK, -55, -14, -1, -8, 13, -11, -8, 68, -23, -46, -1, -8, 13, -21, 2, 2, -8, 1, 13, -4, Ascii.US, -39, -11, -20, 1, -2, 11, -11, -8, Ascii.RS, -22, -12, 11, 2, -5, 3, -3, -11, -8, 9, -13, -7, 47, -27, -20, 9, 35, -46, 9, -3, 0, -17, Ascii.US, -35, 17, -4, -10, Ascii.NAK, -32, 15, -4, -4, 7, -23, 19, TarHeader.LF_LINK, -64, 9, -15, 5, TarHeader.LF_CONTIG, -39, -40, 4, -3, 13, -10, 7, -23, 19, TarHeader.LF_LINK, -64, 9, -15, 5, TarHeader.LF_CONTIG, -40, -22, -12, 11, 2, -5, 7, -23, 19, TarHeader.LF_LINK, -64, 9, -15, 5, TarHeader.LF_CONTIG, -39, -35, 17, -4, -10, Ascii.NAK, -32, 15, -4, -4, Ascii.RS, -41, 5, -10, 6, -11, -8, 0, -17, 47, -43, 9, -20, -2, 35, -21, -14, 6, 0, -17, TarHeader.LF_LINK, -49, -2, 2, 1, 4, 0, -21, 9, -8, -1, 35, -39, 6, -11, -15, 8, -16, 1, 4, 3, TarHeader.LF_BLK, -55, -14, -1, -8, 13, -11, -8, 68, -68, 1, 61, -21, -49, -2, 2, 1, 4, 0, -21, 9, -8, -1, 35, -39, 6, -11};
    public static final int BuiltInFictitiousFunctionClassFactory = 104;
    private final BehaviorSubject<Integer> NetworkUserEntityData$$ExternalSyntheticLambda1 = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
    private final AppReadyLifecyclerObserver MyBillsEntityDataFactory = new AppReadyLifecyclerObserver();
    private boolean lookAheadTest = true;
    private boolean getErrorConfigVersion = false;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    /* JADX WARN: Removed duplicated region for block: B:32:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0027 -> B:35:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.DanaApplication.getAuthRequestContext
            int r6 = r6 + 9
            int r8 = 156 - r8
            int r7 = r7 + 97
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L34
        L17:
            r3 = 0
        L18:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L34:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + (-2)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.DanaApplication.a(byte, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0025 -> B:35:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            int r8 = r8 + 24
            int r7 = r7 + 66
            byte[] r0 = id.dana.DanaApplication.$$a
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L32
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L32:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r7 + 1
            int r7 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.DanaApplication.b(byte, short, short, java.lang.Object[]):void");
    }

    @Override // androidx.multidex.MultiDexApplication, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // androidx.multidex.MultiDexApplication, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // androidx.multidex.MultiDexApplication, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.danapoly.di.provider.DanapolyComponentProvider
    public /* synthetic */ DanapolyComponent.Factory provideDanapolyComponent() {
        return SubComponents.CC.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.sendmoney.di.provider.GlobalSendComponentProvider
    public /* synthetic */ GlobalSendComponent.Factory provideGlobalSendComponent() {
        return SubComponents.CC.PlaceComponentResult();
    }

    @Override // id.dana.sendmoney.di.provider.GroupSendComponentProvider
    public /* synthetic */ GroupSendComponent.Factory provideGroupSendComponent() {
        return SubComponents.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.di.modules.features.imagecapture.ImageCaptureComponentProvider
    public /* synthetic */ ImageCaptureComponent.Factory provideImageCaptureComponent() {
        return SubComponents.CC.getAuthRequestContext();
    }

    @Override // id.dana.di.modules.features.installedapp.InstalledAppComponentProvider
    public /* synthetic */ InstalledAppComponent.Factory provideInstalledAppComponent() {
        return SubComponents.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.mybills.di.provider.MyBillsComponentProvider
    public /* synthetic */ MyBillsComponent.Factory provideMyBillsComponent() {
        return SubComponents.CC.getErrorConfigVersion();
    }

    @Override // id.dana.riskChallenges.di.provider.RiskChallengesProvider
    public /* synthetic */ RiskChallengesComponent.Factory provideRiskChallengesComponent() {
        return SubComponents.CC.NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    public AlipayConnectInitializer getAlipayConnectInitializer() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public boolean getIsKybRevamp() {
        return this.lookAheadTest;
    }

    public void setKybRevamp(boolean z) {
        this.lookAheadTest = z;
    }

    public boolean isFeedRevamp() {
        return this.getErrorConfigVersion;
    }

    public void setFeedRevamp(boolean z) {
        this.getErrorConfigVersion = z;
    }

    public BehaviorSubject<Integer> getSecurityProviderSubject() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    public Boolean getIsMePageRevamp() {
        Boolean bool = this.scheduleImpl;
        return bool == null ? Boolean.TRUE : bool;
    }

    public void setMePageRevamp(Boolean bool) {
        this.scheduleImpl = bool;
    }

    /* JADX WARN: Code restructure failed: missing block: B:306:0x029a, code lost:
    
        r24 = r2;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x02ab, code lost:
    
        r15 = new java.lang.Object[1];
        a((byte) (id.dana.DanaApplication.getAuthRequestContext[75] - 1), id.dana.DanaApplication.getAuthRequestContext[50], (short) (id.dana.DanaApplication.getAuthRequestContext[81] - 1), r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x02bc, code lost:
    
        r2 = java.lang.Class.forName((java.lang.String) r15[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x02cd, code lost:
    
        r4 = new java.lang.Object[1];
        a(id.dana.DanaApplication.getAuthRequestContext[9], id.dana.DanaApplication.getAuthRequestContext[126(0x7e, float:1.77E-43)], 28, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x02f7, code lost:
    
        if (java.lang.Class.forName((java.lang.String) r2.getMethod((java.lang.String) r4[0], null).invoke(r0, null)).getClassLoader().toString().contains(r6) == false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x02f9, code lost:
    
        if (r14 == false) goto L333;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x0305, code lost:
    
        r0 = (java.lang.Class) o.SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (android.os.SystemClock.elapsedRealtimeNanos() > 0 ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0 ? 0 : -1)), 4 - (android.view.ViewConfiguration.getTapTimeout() >> 16), (char) android.view.View.combineMeasuredStates(0, 0));
        r2 = id.dana.DanaApplication.$$a[22];
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x0323, code lost:
    
        r13 = new java.lang.Object[1];
        b(r2, r2, (byte) (-id.dana.DanaApplication.$$a[17]), r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x0336, code lost:
    
        r0.getField((java.lang.String) r13[0]).setInt(null, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x033b, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x033d, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x0342, code lost:
    
        r3 = null;
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x0351, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x0354, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x035a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x035c, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x0362, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x036b, code lost:
    
        r4 = r0.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x0371, code lost:
    
        if (r4 == null) goto L351;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x0373, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x0374, code lost:
    
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0373 A[Catch: ClassNotFoundException -> 0x0375, TryCatch #10 {ClassNotFoundException -> 0x0375, blocks: (B:329:0x0336, B:348:0x036b, B:350:0x0373, B:351:0x0374), top: B:400:0x02a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:351:0x0374 A[Catch: ClassNotFoundException -> 0x0375, TRY_LEAVE, TryCatch #10 {ClassNotFoundException -> 0x0375, blocks: (B:329:0x0336, B:348:0x036b, B:350:0x0373, B:351:0x0374), top: B:400:0x02a1 }] */
    @Override // androidx.multidex.MultiDexApplication, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void attachBaseContext(android.content.Context r26) {
        /*
            Method dump skipped, instructions count: 948
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.DanaApplication.attachBaseContext(android.content.Context):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:476:0x0291, code lost:
    
        r23 = r2;
        r26 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:477:0x0297, code lost:
    
        r8 = new java.lang.Object[1];
        a((byte) (id.dana.DanaApplication.getAuthRequestContext[75] - 1), id.dana.DanaApplication.getAuthRequestContext[50], (short) (id.dana.DanaApplication.getAuthRequestContext[81] - 1), r8);
        r2 = java.lang.Class.forName((java.lang.String) r8[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:479:0x02c7, code lost:
    
        r13 = new java.lang.Object[1];
        a(id.dana.DanaApplication.getAuthRequestContext[9], id.dana.DanaApplication.getAuthRequestContext[126(0x7e, float:1.77E-43)], 28, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:481:0x02f1, code lost:
    
        if (java.lang.Class.forName((java.lang.String) r2.getMethod((java.lang.String) r13[0], null).invoke(r0, null)).getClassLoader().toString().contains(r6) == false) goto L487;
     */
    /* JADX WARN: Code restructure failed: missing block: B:482:0x02f3, code lost:
    
        if (r12 == false) goto L486;
     */
    /* JADX WARN: Code restructure failed: missing block: B:483:0x02f5, code lost:
    
        r0 = (java.lang.Class) o.SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(android.widget.ExpandableListView.getPackedPositionType(0) + 494, 4 - android.view.View.getDefaultSize(0, 0), (char) android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:485:0x0312, code lost:
    
        r2 = id.dana.DanaApplication.$$a[22];
        r13 = new java.lang.Object[1];
        b(r2, r2, (byte) (-id.dana.DanaApplication.$$a[17]), r13);
        r0.getField((java.lang.String) r13[0]).setInt(null, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:486:0x0331, code lost:
    
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:488:0x0338, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:490:0x033c, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:492:0x0341, code lost:
    
        r2 = r0.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:493:0x0345, code lost:
    
        if (r2 != null) goto L494;
     */
    /* JADX WARN: Code restructure failed: missing block: B:494:0x0347, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:495:0x0348, code lost:
    
        throw r0;
     */
    @Override // androidx.multidex.MultiDexApplication, android.app.Application
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate() {
        /*
            Method dump skipped, instructions count: 2061
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.DanaApplication.onCreate():void");
    }

    public void initializeGpsStatusTracker() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new GpsStatusMonitor(getApplicationContext());
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult(ProcessLifecycleOwner.PlaceComponentResult(), new Observer() { // from class: id.dana.DanaApplication$$ExternalSyntheticLambda6
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                MixPanelTracker.PlaceComponentResult(((Boolean) obj).booleanValue());
            }
        });
    }

    /* renamed from: lambda$setupStartupConfig$0$id-dana-DanaApplication */
    public /* synthetic */ Boolean m415lambda$setupStartupConfig$0$iddanaDanaApplication() {
        return Boolean.valueOf(this.sharedPrefStartupConfig.getWarmStartTrackingEnable());
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.splitFacade.get();
        SplitFacade.getAuthRequestContext(configuration);
        UserAgentFactory.create("Skywalker", "2.47.1");
    }

    public static /* synthetic */ void lambda$setGlobalExceptionHandler$1(Throwable th) throws Exception {
        if (th instanceof UndeliverableException) {
            th = th.getCause();
        }
        if ((th instanceof ServerException) || (th instanceof TimeoutException) || (th instanceof ClientException) || (th instanceof InterruptedException)) {
            return;
        }
        if ((th instanceof NullPointerException) || (th instanceof IllegalArgumentException)) {
            try {
                Object[] objArr = new Object[1];
                a(getAuthRequestContext[73], getAuthRequestContext[50], (short) (getAuthRequestContext[18] + 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b = getAuthRequestContext[8];
                byte b2 = getAuthRequestContext[25];
                Object[] objArr2 = new Object[1];
                a(b, b2, (short) (b2 | 121), objArr2);
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getUncaughtExceptionHandler();
                try {
                    Object[] objArr3 = new Object[1];
                    a(getAuthRequestContext[73], getAuthRequestContext[50], (short) (getAuthRequestContext[18] + 1), objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    byte b3 = getAuthRequestContext[8];
                    byte b4 = getAuthRequestContext[25];
                    Object[] objArr4 = new Object[1];
                    a(b3, b4, (short) (b4 | 121), objArr4);
                    uncaughtExceptionHandler.uncaughtException((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null), th);
                } catch (Throwable th2) {
                    Throwable cause = th2.getCause();
                    if (cause == null) {
                        throw th2;
                    }
                    throw cause;
                }
            } catch (Throwable th3) {
                Throwable cause2 = th3.getCause();
                if (cause2 == null) {
                    throw th3;
                }
                throw cause2;
            }
        } else if (th instanceof IllegalStateException) {
            try {
                Object[] objArr5 = new Object[1];
                a(getAuthRequestContext[73], getAuthRequestContext[50], (short) (getAuthRequestContext[18] + 1), objArr5);
                Class<?> cls3 = Class.forName((String) objArr5[0]);
                byte b5 = getAuthRequestContext[8];
                byte b6 = getAuthRequestContext[25];
                Object[] objArr6 = new Object[1];
                a(b5, b6, (short) (b6 | 121), objArr6);
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = ((Thread) cls3.getMethod((String) objArr6[0], null).invoke(null, null)).getUncaughtExceptionHandler();
                try {
                    Object[] objArr7 = new Object[1];
                    a(getAuthRequestContext[73], getAuthRequestContext[50], (short) (getAuthRequestContext[18] + 1), objArr7);
                    Class<?> cls4 = Class.forName((String) objArr7[0]);
                    byte b7 = getAuthRequestContext[8];
                    byte b8 = getAuthRequestContext[25];
                    Object[] objArr8 = new Object[1];
                    a(b7, b8, (short) (b8 | 121), objArr8);
                    uncaughtExceptionHandler2.uncaughtException((Thread) cls4.getMethod((String) objArr8[0], null).invoke(null, null), th);
                } catch (Throwable th4) {
                    Throwable cause3 = th4.getCause();
                    if (cause3 == null) {
                        throw th4;
                    }
                    throw cause3;
                }
            } catch (Throwable th5) {
                Throwable cause4 = th5.getCause();
                if (cause4 == null) {
                    throw th5;
                }
                throw cause4;
            }
        }
    }

    public void getAuthRequestContext() {
        boolean mixpanelEnable = this.sharedPrefStartupConfig.getMixpanelEnable();
        MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(this.mixpanel.get(), this.deviceInformationProvider.get(), mixpanelEnable);
        MixPanelDataTracker.MyBillsEntityDataFactory(mixpanelEnable);
    }

    public void setCurrentSessionId() {
        AppReadyMixpanelTracker.getAuthRequestContext(UUID.randomUUID().toString());
    }

    public ApplicationComponent getApplicationComponent() {
        return this.moveToNextValue;
    }

    public SocialCommonComponent getSocialCommonComponent() {
        if (this.GetContactSyncConfig == null) {
            SocialCommonComponentFactory.Companion companion = SocialCommonComponentFactory.INSTANCE;
            Intrinsics.checkNotNullParameter(this, "");
            this.GetContactSyncConfig = SocialCommonComponentFactory.Companion.getAuthRequestContext(this);
        }
        return this.GetContactSyncConfig;
    }

    public RestrictedContactComponent getRestrictedContactComponent() {
        if (this.DatabaseTableConfigUtil == null) {
            RestrictedContactComponentFactory.Companion companion = RestrictedContactComponentFactory.INSTANCE;
            Intrinsics.checkNotNullParameter(this, "");
            this.DatabaseTableConfigUtil = RestrictedContactComponentFactory.Companion.PlaceComponentResult(this);
        }
        return this.DatabaseTableConfigUtil;
    }

    public int getNetworkType() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo.isConnected()) {
                    return activeNetworkInfo.getType();
                }
                return 10;
            }
            return 10;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // androidx.work.Configuration.Provider
    public Configuration getWorkManagerConfiguration() {
        Configuration.Builder builder = new Configuration.Builder();
        builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = this.moveToNextValue.getRecommendationData();
        builder.BuiltInFictitiousFunctionClassFactory = 3;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = Math.min(50, 50);
        return new Configuration(builder);
    }

    @Subscribe
    public void onReceiveGnAuthSpecialMerchantMessageEvent(GnAuthSpecialMerchantMessageEvent gnAuthSpecialMerchantMessageEvent) {
        OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
        OauthLoginManager.MyBillsEntityDataFactory(gnAuthSpecialMerchantMessageEvent.MyBillsEntityDataFactory);
        OauthLoginManager oauthLoginManager2 = OauthLoginManager.INSTANCE;
        OauthLoginManager.getAuthRequestContext(gnAuthSpecialMerchantMessageEvent.KClassImpl$Data$declaredNonStaticMembers$2);
        OauthLoginManager oauthLoginManager3 = OauthLoginManager.INSTANCE;
        OauthLoginManager.BuiltInFictitiousFunctionClassFactory(false);
        OauthLoginManager oauthLoginManager4 = OauthLoginManager.INSTANCE;
        OauthLoginManager.MyBillsEntityDataFactory(false);
        OauthLoginManager oauthLoginManager5 = OauthLoginManager.INSTANCE;
        if (OauthLoginManager.DatabaseTableConfigUtil()) {
            startActivity(OauthGrantActivity.createOauthGrantLoadingIntent(this).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
        } else if (TextUtils.isEmpty(CommonUtil.MyBillsEntityDataFactory(new SecurityGuardFacade(this), ""))) {
            PlaceComponentResult();
        } else {
            this.getUserInfo.get().execute(new GetUserInfo.Param(true), new Function1() { // from class: id.dana.DanaApplication$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DanaApplication.this.m412lambda$googleSessionCheck$4$iddanaDanaApplication((UserInfoResponse) obj);
                }
            }, new Function1() { // from class: id.dana.DanaApplication$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DanaApplication.this.m413lambda$googleSessionCheck$5$iddanaDanaApplication((Throwable) obj);
                }
            });
        }
    }

    /* renamed from: lambda$googleSessionCheck$5$id-dana-DanaApplication */
    public /* synthetic */ Unit m413lambda$googleSessionCheck$5$iddanaDanaApplication(Throwable th) {
        PlaceComponentResult();
        return null;
    }

    private void PlaceComponentResult() {
        boolean z;
        OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
        z = OauthLoginManager.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (z) {
            return;
        }
        OauthLoginManager oauthLoginManager2 = OauthLoginManager.INSTANCE;
        OauthLoginManager.PlaceComponentResult(true);
        startActivity(new Intent(this, LocalConfigSplashActivity.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
    }

    public boolean isWarmStart() {
        return this.appLifeCycleObserver.PlaceComponentResult();
    }

    public boolean isRefreshService() {
        return this.initRecordTimeStamp;
    }

    public void setRefreshService(boolean z) {
        this.initRecordTimeStamp = z;
    }

    /* loaded from: classes.dex */
    public static class GnAuthSpecialMerchantMessageEvent {
        final String KClassImpl$Data$declaredNonStaticMembers$2;
        final String MyBillsEntityDataFactory;

        public GnAuthSpecialMerchantMessageEvent(String str, String str2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.MyBillsEntityDataFactory = str2;
        }
    }

    public void dispose() {
        this.transferAccountStatusChecker.get().dispose();
        this.compositeDisposable.dispose();
    }

    public boolean isWarmHomeDialogEnable() {
        return Boolean.TRUE.equals(this.sharedPrefStartupConfig.getAnbuConfig().getFeatureWarmHomeDialog());
    }

    public void chckTmprdApp() {
        if (this.splitConfigEntityData.get() == null || this.sharedPrefStartupConfig == null) {
            return;
        }
        this.PrepareContext.PlaceComponentResult(this.splitConfigEntityData.get(), this.sharedPrefStartupConfig);
    }

    public static Context applicationContext() {
        return application;
    }

    static /* synthetic */ void access$300(DanaApplication danaApplication) {
        CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory = danaApplication.deviceInformationProvider.get().getDeviceUtdId();
    }

    static /* synthetic */ void access$400(DanaApplication danaApplication) {
        DanaLocalBroadcastReceiver.registerLocalBroadCastRecevier(danaApplication.getApplicationContext(), danaApplication.danaLocalBroadcastReceiver);
    }

    /* renamed from: lambda$googleSessionCheck$4$id-dana-DanaApplication */
    public /* synthetic */ Unit m412lambda$googleSessionCheck$4$iddanaDanaApplication(UserInfoResponse userInfoResponse) {
        startActivity(OauthGrantActivity.createOauthGrantLoadingIntent(this).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
        return null;
    }

    /* renamed from: lambda$initializeComponentsAsync$3$id-dana-DanaApplication */
    public /* synthetic */ Void m414lambda$initializeComponentsAsync$3$iddanaDanaApplication(Context context) throws Exception {
        this.mixpanel.get();
        this.homeWidgetCache.get();
        this.apSecurity.getAuthRequestContext();
        this.splitFacade.get();
        SplitFacade.PlaceComponentResult("user_cohort", this.sharedPrefForSplitAttributes.getUserCohort());
        this.feedData = this.homeWidgetCache.get().getFeedData();
        this.servicesData = ThirdPartyService.BuiltInFictitiousFunctionClassFactory(this.homeWidgetCache.get().getServices());
        this.splitObservant.get();
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Completable ignoreElements = this.splitConfigEntityData.get().getNetworkLoggingConfig().ignoreElements();
        Scheduler MyBillsEntityDataFactory = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(ignoreElements, MyBillsEntityDataFactory));
        Scheduler MyBillsEntityDataFactory2 = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory2, "scheduler is null");
        compositeDisposable.getAuthRequestContext(RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory2)).q_());
        CompositeDisposable compositeDisposable2 = this.compositeDisposable;
        Completable ignoreElements2 = this.splitConfigEntityData.get().getDiagnosticLogConfig().ignoreElements();
        Scheduler MyBillsEntityDataFactory3 = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory3, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(ignoreElements2, MyBillsEntityDataFactory3));
        Scheduler MyBillsEntityDataFactory4 = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory4, "scheduler is null");
        compositeDisposable2.getAuthRequestContext(RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$22, MyBillsEntityDataFactory4)).q_());
        CompositeDisposable compositeDisposable3 = this.compositeDisposable;
        Completable ignoreElements3 = this.splitConfigEntityData.get().getFullstoryConfig().ignoreElements();
        Scheduler MyBillsEntityDataFactory5 = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory5, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$23 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(ignoreElements3, MyBillsEntityDataFactory5));
        Scheduler MyBillsEntityDataFactory6 = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory6, "scheduler is null");
        compositeDisposable3.getAuthRequestContext(RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(KClassImpl$Data$declaredNonStaticMembers$23, MyBillsEntityDataFactory6)).q_());
        Completable ignoreElements4 = this.splitConfigEntityData.get().getAppVersion().ignoreElements();
        Scheduler MyBillsEntityDataFactory7 = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory7, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$24 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(ignoreElements4, MyBillsEntityDataFactory7));
        Scheduler MyBillsEntityDataFactory8 = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory8, "scheduler is null");
        RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$24, MyBillsEntityDataFactory8)).q_();
        Completable ignoreElements5 = this.splitConfigEntityData.get().getStartupConfig().ignoreElements();
        Scheduler MyBillsEntityDataFactory9 = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory9, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$25 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(ignoreElements5, MyBillsEntityDataFactory9));
        Scheduler MyBillsEntityDataFactory10 = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory10, "scheduler is null");
        RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$25, MyBillsEntityDataFactory10)).q_();
        FullstoryTracker fullstoryTracker = FullstoryTracker.INSTANCE;
        FullstoryTracker.KClassImpl$Data$declaredNonStaticMembers$2(this.isEligibleForFullstorySessionLazy.get());
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = this.splitConfigEntityData.get().getUtdidFixEnabled().onErrorReturn(new Function() { // from class: id.dana.DanaApplication$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean bool;
                Throwable th = (Throwable) obj;
                bool = Boolean.FALSE;
                return bool;
            }
        }).blockingFirst(Boolean.FALSE).booleanValue();
        this.sharedPrefStartupConfig.setMixpanelEnable(true);
        getAuthRequestContext();
        String currentTrackerId = this.deviceInformationProvider.get().getCurrentTrackerId();
        if (TextUtils.isEmpty(currentTrackerId)) {
            currentTrackerId = this.deviceInformationProvider.get().getDeviceUtdId();
        }
        EventConfigProperty.Builder builder = new EventConfigProperty.Builder();
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        builder.lookAheadTest = currentTrackerId;
        builder.BuiltInFictitiousFunctionClassFactory = MixPanelTracker.MyBillsEntityDataFactory();
        builder.getAuthRequestContext = MixPanelTracker.getAuthRequestContext();
        Iterator<EventConfig> it = EventConfigFactory.getAuthRequestContext(new EventConfigProperty(builder, (byte) 0), this.deviceInformationProvider.get(), TrackerType.APPSFLYER, TrackerType.BRANCH, TrackerType.MIXPANEL).iterator();
        while (it.hasNext()) {
            it.next().MyBillsEntityDataFactory();
        }
        final TransferAccountStatusChecker transferAccountStatusChecker = this.transferAccountStatusChecker.get();
        transferAccountStatusChecker.PlaceComponentResult.execute(NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.transferaccount.TransferAccountStatusChecker$checkTransferAccountStatus$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Runnable runnable;
                Runnable runnable2;
                StatusTransferAccount value = StatusTransferAccount.INSTANCE.getValue(str);
                if (value != null) {
                    if (value == StatusTransferAccount.SUCCESS) {
                        runnable2 = TransferAccountStatusChecker.this.KClassImpl$Data$declaredNonStaticMembers$2;
                        runnable2.run();
                        return;
                    }
                    runnable = TransferAccountStatusChecker.this.BuiltInFictitiousFunctionClassFactory;
                    runnable.run();
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.transferaccount.TransferAccountStatusChecker$checkTransferAccountStatus$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        });
        return null;
    }
}
