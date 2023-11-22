package id.dana.onboarding.splash;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.appsflyer.AppsFlyerLib;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import dagger.Lazy;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.login.source.network.HoldLoginException;
import id.dana.data.util.NumberUtils;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.account.interactor.InitSecurePreferenceAccount;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.deeplink.interactor.RemoveDeepLinkPayload;
import id.dana.domain.featureconfig.StartupConfigEntityData;
import id.dana.domain.featureconfig.interactor.IsAppFirstLaunch;
import id.dana.domain.featureconfig.model.StartupConfig;
import id.dana.domain.here.interactor.InitHereConfig;
import id.dana.domain.login.interactor.CheckSession;
import id.dana.domain.login.interactor.NotifyPay;
import id.dana.domain.login.interactor.SaveIsSessionChecked;
import id.dana.domain.sslpinning.interactor.PinCertificates;
import id.dana.domain.sslpinning.interactor.SSLPinningHotUpdate;
import id.dana.domain.version.SemanticVersion;
import id.dana.domain.version.Version;
import id.dana.onboarding.splash.LocalConfigSplashContract;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.tracker.EventConfig;
import id.dana.tracker.EventConfigFactory;
import id.dana.tracker.EventConfigProperty;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.constant.TrackerType;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.tracker.rds.RDSEvent;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.session.SessionManager;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableOnErrorComplete;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import j$.util.Optional;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import o.B;
import o.D;

@PerActivity
/* loaded from: classes5.dex */
public class LocalConfigSplashPresenter implements LocalConfigSplashContract.Presenter {
    private static final String isLayoutRequested = "LocalConfigSplashPresenter";
    Context BuiltInFictitiousFunctionClassFactory;
    SessionManager DatabaseTableConfigUtil;
    private int FragmentBottomSheetPaymentSettingBinding;
    final LocalConfigSplashContract.View GetContactSyncConfig;
    Lazy<GetPhoneNumber> KClassImpl$Data$declaredNonStaticMembers$2;
    GetUserId MyBillsEntityDataFactory;
    Lazy<RemoveDeepLinkPayload> NetworkUserEntityData$$ExternalSyntheticLambda0;
    StartupConfigEntityData NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda4;
    private final Lazy<NotifyPay> NetworkUserEntityData$$ExternalSyntheticLambda5;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda7;
    Lazy<DeviceInformationProvider> PlaceComponentResult;
    private final CompositeDisposable PrepareContext = new CompositeDisposable();
    Lazy<CheckSession> getAuthRequestContext;
    Lazy<SaveIsSessionChecked> getErrorConfigVersion;
    Lazy<SSLPinningHotUpdate> initRecordTimeStamp;
    Lazy<PinCertificates> lookAheadTest;
    InitSecurePreferenceAccount moveToNextValue;
    private final Lazy<IsAppFirstLaunch> newProxyInstance;
    Lazy<InitHereConfig> scheduleImpl;
    public static final byte[] $$d = {Ascii.RS, 119, -63, 113, -3, -64, 2, TarHeader.LF_CHR, -57, 0, -16, 10, TarHeader.LF_NORMAL, -61, -10, -1, 5, TarHeader.LF_BLK, -29, -42, -1, 5, 14, -16, -4, Ascii.RS, -37, -20, 8, -16, 10, -14, -8, 82, -82, -7, 11, -10, 8, Ascii.RS, -36, -10, 4, -5, 3, -22, 12, 22, -32, -13, -4, 12, -12, 6, -16, 75, -17, -15, -1, 60, -62, 5, -18, 63, -54, -5, TarHeader.LF_SYMLINK, -54, -16, 7, -17, 0, 3, 2, TarHeader.LF_CHR, -54, -5, -19, 66, -69, 1, -12, 11, -5, -8, 61, -57, -14, -11, 6, 4, -14, 14, -6, -4, TarHeader.LF_BLK, -71, 0, -9, -2, 12, -16, 65, -23, -42, -20, 36, -19, -5, -12, 6, Ascii.DC4, -22, -24, 10, -1, 3, -22, 12, Ascii.NAK, -23, -16, 10, -9, -1, -16, 75, -17};
    public static final int $$e = 204;
    public static final byte[] $$a = {TarHeader.LF_DIR, 93, -14, -126, -58, 5, -10, -15, 36, -44, 33, -42, -1, -24, 4, -18, 4, -13, -13, -5, 38, -54, 0, 4, -24, 4, -13, -6, 36, -48, 4, -25, -7, 38, -34, -9, -24, -2, -10, -14, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, -35, 4, -9, -9, Ascii.ESC, -51, -5, -10, -6, -6, 2, -16, -13, Ascii.ESC, -26, -21, -9, 2, -15, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 104;
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda2 = {SignedBytes.MAX_POWER_OF_TWO, 19, 79, -17, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int NetworkUserEntityData$$ExternalSyntheticLambda8 = 218;
    private static long NetworkUserEntityData$$ExternalSyntheticLambda6 = -2793118494208723668L;

    /* JADX WARN: Removed duplicated region for block: B:20:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0022 -> B:23:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = 102 - r7
            int r6 = r6 + 20
            byte[] r0 = id.dana.onboarding.splash.LocalConfigSplashPresenter.$$a
            int r8 = r8 + 66
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L14
            r8 = r7
            r4 = r8
            r3 = 0
            r7 = r6
            goto L2a
        L14:
            r3 = 0
        L15:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L22
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L22:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2a:
            int r4 = -r4
            int r6 = r6 + r4
            int r8 = r8 + 1
            int r6 = r6 + (-7)
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.splash.LocalConfigSplashPresenter.a(byte, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 4
            int r6 = 16 - r6
            byte[] r0 = id.dana.onboarding.splash.LocalConfigSplashPresenter.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r8 = 106 - r8
            int r7 = r7 + 4
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L34
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            int r7 = r7 + 1
            r1[r3] = r4
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.splash.LocalConfigSplashPresenter.c(byte, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0029 -> B:23:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.onboarding.splash.LocalConfigSplashPresenter.$$d
            int r6 = 57 - r6
            int r8 = r8 + 3
            int r7 = r7 * 3
            int r7 = 105 - r7
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L33
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L33:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + (-3)
            int r7 = r7 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.splash.LocalConfigSplashPresenter.d(short, byte, byte, java.lang.Object[]):void");
    }

    @Inject
    public LocalConfigSplashPresenter(LocalConfigSplashContract.View view, Lazy<NotifyPay> lazy, Lazy<IsAppFirstLaunch> lazy2) {
        this.GetContactSyncConfig = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = lazy;
        this.newProxyInstance = lazy2;
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.Presenter
    public final void PlaceComponentResult() {
        StartupConfig startupConfig = this.NetworkUserEntityData$$ExternalSyntheticLambda1.getStartupConfig();
        AppReadyMixpanelTracker.getAuthRequestContext(startupConfig);
        this.GetContactSyncConfig.onNonBlockingSplash(startupConfig.isEnableNonBlockingSplash());
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.Presenter
    public final void getAuthRequestContext() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.getStartupConfig().isEnableSimpleGetUserId()) {
            this.moveToNextValue.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.onboarding.splash.LocalConfigSplashPresenter$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    LocalConfigSplashPresenter localConfigSplashPresenter = LocalConfigSplashPresenter.this;
                    Optional optional = (Optional) obj;
                    if (optional.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        Object obj2 = optional.PlaceComponentResult;
                        if (obj2 != null) {
                            if (!TextUtils.isEmpty((CharSequence) obj2)) {
                                localConfigSplashPresenter.GetContactSyncConfig.onAccountChecking(true);
                                Object obj3 = optional.PlaceComponentResult;
                                if (obj3 != null) {
                                    String str = (String) obj3;
                                    if (str != null && !TextUtils.isEmpty(str)) {
                                        AppsFlyerLib.getInstance().setCustomerUserId(str);
                                        localConfigSplashPresenter.MyBillsEntityDataFactory(str);
                                    }
                                    localConfigSplashPresenter.GetContactSyncConfig();
                                    return Unit.INSTANCE;
                                }
                                throw new NoSuchElementException("No value present");
                            }
                        } else {
                            throw new NoSuchElementException("No value present");
                        }
                    }
                    localConfigSplashPresenter.GetContactSyncConfig.onAccountChecking(false);
                    localConfigSplashPresenter.MyBillsEntityDataFactory((String) null);
                    return Unit.INSTANCE;
                }
            }, new Function1() { // from class: id.dana.onboarding.splash.LocalConfigSplashPresenter$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Throwable th = (Throwable) obj;
                    LocalConfigSplashPresenter.this.GetContactSyncConfig.onAccountChecking(false);
                    return Unit.INSTANCE;
                }
            });
        } else {
            this.moveToNextValue.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.onboarding.splash.LocalConfigSplashPresenter$$ExternalSyntheticLambda0
                private static short[] NetworkUserEntityData$$ExternalSyntheticLambda0;
                public static final byte[] $$d = {TarHeader.LF_DIR, -98, 98, -100, 3, SignedBytes.MAX_POWER_OF_TWO, -2, -51, 57, 0, 16, -10, -48, 61, 10, 1, -5, -52, Ascii.GS, 42, 1, -5, -14, 16, 4, -30, 37, Ascii.DC4, -8, 16, -10, 14, 8, -82, 82, 7, -11, 10, -8, -30, 36, 10, -4, 5, -3, 22, -12, -22, 32, 13, 4, -12, 12, -6, 16, -75, 17, 15, 1, -60, 62, -5, 18, -63, TarHeader.LF_FIFO, 5, -50, TarHeader.LF_FIFO, 16, -7, 17, 0, -3, -2, -51, TarHeader.LF_FIFO, 5, 19, -66, 69, -1, 12, -11, 5, 8, -61, 57, 14, 11, -6, -4, 14, -14, 6, 4, -52, 71, 0, 9, 2, -12, 16, -65, Ascii.ETB, 42, Ascii.DC4, -36, 19, 5, 12, -6, -20, 22, Ascii.CAN, -10, 1, -3, 22, -12, -21, Ascii.ETB, 16, -10, 9, 1, 16, -75, 17};
                public static final int $$e = 174;
                public static final byte[] $$a = {15, -40, -114, -21, 58, -5, 10, 15, -36, 44, -33, 42, 1, Ascii.CAN, -4, 18, -4, 13, 13, 5, -38, TarHeader.LF_FIFO, 0, -4, Ascii.CAN, -4, 13, 6, -36, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -38, 34, 9, Ascii.CAN, 2, 10, 14, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, 35, -4, 9, 9, -27, TarHeader.LF_CHR, 5, 10, 6, 6, -2, 16, 13, -27, Ascii.SUB, Ascii.NAK, 9, -2, 15, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
                public static final int $$b = 123;
                public static final byte[] PlaceComponentResult = {75, -120, 119, 39, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
                public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 131;
                private static int MyBillsEntityDataFactory = 1257195765;
                private static int getErrorConfigVersion = -424750950;
                private static byte[] lookAheadTest = {86, 114, 33, TarHeader.LF_CONTIG, -108, 86, 111, 95, 104, 4, 3, -87, 34, Ascii.US, -104, 105, 104, 107, 92, 116, 91, 73, 13, 124, Ascii.EM, Ascii.SUB, 69, -30, 119, 70, 67, 18, 22, 124, 14, 58, 99, 106, TarHeader.LF_LINK, 11, 66, 60, TarHeader.LF_SYMLINK, 106, TarHeader.LF_BLK, 108, 8, 89, 10, -91, TarHeader.LF_CONTIG, TarHeader.LF_FIFO, 42, 113, 98, 97, 100, TarHeader.LF_DIR, 109, TarHeader.LF_BLK, -2, -123, -8, -110, -3, -7, -64, -1, -125, -82, -48, -123, -116, -14, -125, -64, -111, -97, -97, -97, -97};
                private static int getAuthRequestContext = 114314149;

                /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0031). Please submit an issue!!! */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                private static void a(short r7, short r8, short r9, java.lang.Object[] r10) {
                    /*
                        byte[] r0 = id.dana.onboarding.splash.LocalConfigSplashPresenter$$ExternalSyntheticLambda0.$$a
                        int r7 = r7 + 20
                        int r8 = r8 + 66
                        int r9 = r9 + 4
                        byte[] r1 = new byte[r7]
                        r2 = 0
                        if (r0 != 0) goto L14
                        r8 = r7
                        r3 = r1
                        r4 = 0
                        r1 = r0
                        r0 = r10
                        r10 = r9
                        goto L31
                    L14:
                        r3 = 0
                        r6 = r8
                        r8 = r7
                        r7 = r6
                    L18:
                        int r9 = r9 + 1
                        int r4 = r3 + 1
                        byte r5 = (byte) r7
                        r1[r3] = r5
                        if (r4 != r8) goto L29
                        java.lang.String r7 = new java.lang.String
                        r7.<init>(r1, r2)
                        r10[r2] = r7
                        return
                    L29:
                        r3 = r0[r9]
                        r6 = r10
                        r10 = r9
                        r9 = r3
                        r3 = r1
                        r1 = r0
                        r0 = r6
                    L31:
                        int r7 = r7 + r9
                        int r7 = r7 + (-7)
                        r9 = r10
                        r10 = r0
                        r0 = r1
                        r1 = r3
                        r3 = r4
                        goto L18
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.splash.LocalConfigSplashPresenter$$ExternalSyntheticLambda0.a(short, short, short, java.lang.Object[]):void");
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0026). Please submit an issue!!! */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                private static void c(short r6, short r7, short r8, java.lang.Object[] r9) {
                    /*
                        int r7 = 106 - r7
                        byte[] r0 = id.dana.onboarding.splash.LocalConfigSplashPresenter$$ExternalSyntheticLambda0.PlaceComponentResult
                        int r6 = r6 * 15
                        int r6 = r6 + 4
                        int r8 = r8 * 2
                        int r8 = r8 + 16
                        byte[] r1 = new byte[r8]
                        r2 = 0
                        if (r0 != 0) goto L14
                        r5 = 0
                        r3 = r6
                        goto L26
                    L14:
                        r3 = 0
                    L15:
                        byte r4 = (byte) r7
                        int r5 = r3 + 1
                        r1[r3] = r4
                        if (r5 != r8) goto L24
                        java.lang.String r6 = new java.lang.String
                        r6.<init>(r1, r2)
                        r9[r2] = r6
                        return
                    L24:
                        r3 = r0[r6]
                    L26:
                        int r6 = r6 + 1
                        int r3 = -r3
                        int r7 = r7 + r3
                        int r7 = r7 + 2
                        r3 = r5
                        goto L15
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.splash.LocalConfigSplashPresenter$$ExternalSyntheticLambda0.c(short, short, short, java.lang.Object[]):void");
                }

                private static void d(byte b, int i, int i2, Object[] objArr) {
                    int i3 = 105 - (i * 3);
                    byte[] bArr = $$d;
                    int i4 = 57 - b;
                    int i5 = i2 + 3;
                    byte[] bArr2 = new byte[i5];
                    int i6 = -1;
                    int i7 = i5 - 1;
                    if (bArr == null) {
                        int i8 = (i4 + i7) - 3;
                        i7 = i7;
                        objArr = objArr;
                        bArr = bArr;
                        bArr2 = bArr2;
                        i6 = -1;
                        i3 = i8;
                        i4++;
                    }
                    while (true) {
                        int i9 = i6 + 1;
                        bArr2[i9] = (byte) i3;
                        if (i9 == i7) {
                            objArr[0] = new String(bArr2, 0);
                            return;
                        }
                        int i10 = i3;
                        i7 = i7;
                        objArr = objArr;
                        bArr = bArr;
                        bArr2 = bArr2;
                        i6 = i9;
                        i3 = (i10 + bArr[i4]) - 3;
                        i4++;
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:152:0x0628 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:22:0x02f9  */
                /* JADX WARN: Removed duplicated region for block: B:54:0x04c2 A[Catch: Exception -> 0x09f9, TRY_LEAVE, TryCatch #11 {Exception -> 0x09f9, blocks: (B:52:0x0473, B:54:0x04c2), top: B:166:0x0473 }] */
                /* JADX WARN: Removed duplicated region for block: B:60:0x0622  */
                /* JADX WARN: Removed duplicated region for block: B:79:0x0886  */
                @Override // kotlin.jvm.functions.Function1
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invoke(java.lang.Object r30) {
                    /*
                        Method dump skipped, instructions count: 2589
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.splash.LocalConfigSplashPresenter$$ExternalSyntheticLambda0.invoke(java.lang.Object):java.lang.Object");
                }

                private static void b(int i, int i2, byte b, short s, int i3, Object[] objArr) {
                    B b2 = new B();
                    StringBuilder sb = new StringBuilder();
                    int i4 = i2 + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L));
                    int i5 = i4 == -1 ? 1 : 0;
                    if (i5 != 0) {
                        byte[] bArr = lookAheadTest;
                        if (bArr != null) {
                            int length = bArr.length;
                            byte[] bArr2 = new byte[length];
                            for (int i6 = 0; i6 < length; i6++) {
                                bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                            }
                            bArr = bArr2;
                        }
                        if (bArr != null) {
                            i4 = (byte) (((byte) (lookAheadTest[i3 + ((int) (getAuthRequestContext ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L)));
                        } else {
                            i4 = (short) (((short) (NetworkUserEntityData$$ExternalSyntheticLambda0[i3 + ((int) (getAuthRequestContext ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L)));
                        }
                    }
                    if (i4 > 0) {
                        b2.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (getAuthRequestContext ^ 3097486228508854431L)) + i5;
                        b2.MyBillsEntityDataFactory = (char) (i + ((int) (getErrorConfigVersion ^ 3097486228508854431L)));
                        sb.append(b2.MyBillsEntityDataFactory);
                        b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                        byte[] bArr3 = lookAheadTest;
                        if (bArr3 != null) {
                            int length2 = bArr3.length;
                            byte[] bArr4 = new byte[length2];
                            for (int i7 = 0; i7 < length2; i7++) {
                                bArr4[i7] = (byte) (bArr3[i7] ^ 3097486228508854431L);
                            }
                            bArr3 = bArr4;
                        }
                        boolean z = bArr3 != null;
                        b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
                        while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i4) {
                            if (z) {
                                byte[] bArr5 = lookAheadTest;
                                b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                                b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                            } else {
                                short[] sArr = NetworkUserEntityData$$ExternalSyntheticLambda0;
                                b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                                b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                            }
                            sb.append(b2.MyBillsEntityDataFactory);
                            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                            b2.KClassImpl$Data$declaredNonStaticMembers$2++;
                        }
                    }
                    objArr[0] = sb.toString();
                }
            }, new Function1() { // from class: id.dana.onboarding.splash.LocalConfigSplashPresenter$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Throwable th = (Throwable) obj;
                    LocalConfigSplashPresenter.this.GetContactSyncConfig.onAccountChecking(false);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:229:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0640 A[Catch: Exception -> 0x0c79, TRY_LEAVE, TryCatch #12 {Exception -> 0x0c79, blocks: (B:259:0x05fc, B:261:0x0640), top: B:376:0x05fc }] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x07f9  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0b07  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x07ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ kotlin.Unit getAuthRequestContext(j$.util.Optional r33) {
        /*
            Method dump skipped, instructions count: 3290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.splash.LocalConfigSplashPresenter.getAuthRequestContext(j$.util.Optional):kotlin.Unit");
    }

    public final void GetContactSyncConfig() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.get().execute(NoParams.INSTANCE, new Function0() { // from class: id.dana.onboarding.splash.LocalConfigSplashPresenter$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, new Function1() { // from class: id.dana.onboarding.splash.LocalConfigSplashPresenter$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                Throwable th = (Throwable) obj;
                unit = Unit.INSTANCE;
                return unit;
            }
        });
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        Version appVersion = this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAppVersion();
        this.FragmentBottomSheetPaymentSettingBinding = appVersion.getLatestVersion().toInt();
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = appVersion.getValidVersion().toInt();
        int i = AnonymousClass5.KClassImpl$Data$declaredNonStaticMembers$2[appVersion.getUpdateOption(new SemanticVersion(2, 47, 1)).ordinal()];
        if (i == 1) {
            this.GetContactSyncConfig.onForcedAppUpdate();
        } else if (i == 2) {
            this.GetContactSyncConfig.onOptionalAppUpdate();
        } else {
            this.GetContactSyncConfig.onNonUpdate();
        }
    }

    /* renamed from: id.dana.onboarding.splash.LocalConfigSplashPresenter$5 */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[Version.UpdateOption.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[Version.UpdateOption.FORCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Version.UpdateOption.OPTIONAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.Presenter
    public final void getAuthRequestContext(final String str) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(new DefaultObserver<String>() { // from class: id.dana.onboarding.splash.LocalConfigSplashPresenter.2
            {
                LocalConfigSplashPresenter.this = this;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                LocalConfigSplashPresenter.this.GetContactSyncConfig.onMatchPhoneNumberSuccess(NumberUtils.getClearPhoneNumber(str).equals(NumberUtils.getClearPhoneNumber((String) obj)));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                LocalConfigSplashPresenter.this.GetContactSyncConfig.onMatchPhoneNumberFailed();
            }
        });
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.Presenter
    public final void getErrorConfigVersion() {
        this.initRecordTimeStamp.get().execute(new DefaultObserver());
        this.lookAheadTest.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.onboarding.splash.LocalConfigSplashPresenter.3
            {
                LocalConfigSplashPresenter.this = this;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                Boolean bool = (Boolean) obj;
                LocalConfigSplashPresenter.this.GetContactSyncConfig.onCertificatePinned();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                LocalConfigSplashPresenter.this.GetContactSyncConfig.onCertificatePinned();
            }
        });
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.newProxyInstance.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.onboarding.splash.LocalConfigSplashPresenter.4
            {
                LocalConfigSplashPresenter.this = this;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                Boolean bool = (Boolean) obj;
                LocalConfigSplashPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7 = bool.booleanValue();
                LocalConfigSplashPresenter.this.GetContactSyncConfig.onCheckAppFirstLaunch(bool.booleanValue());
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                LocalConfigSplashPresenter.this.GetContactSyncConfig.onCheckAppFirstLaunch(false);
            }
        });
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.Presenter
    public final void scheduleImpl() {
        GetContactSyncConfig();
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.Presenter
    public final void getAuthRequestContext(String str, String str2) {
        int i = this.FragmentBottomSheetPaymentSettingBinding;
        int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(this.BuiltInFictitiousFunctionClassFactory.getApplicationContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.APP_UPDATE;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(TrackerKey.AppUpdateProperty.LATEST_APP_VERSION, MyBillsEntityDataFactory(i)).MyBillsEntityDataFactory(TrackerKey.AppUpdateProperty.VALID_APP_VERSION, MyBillsEntityDataFactory(i2)).MyBillsEntityDataFactory(TrackerKey.AppUpdateProperty.APP_UPDATE_TYPE, str).MyBillsEntityDataFactory(TrackerKey.AppUpdateProperty.APP_UPDATE_ACTION, str2);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.Presenter
    public final void lookAheadTest() {
        try {
            DanaLog.getAuthRequestContext(isLayoutRequested, Boolean.TRUE.equals(this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute()) ? "Deeplink Payload removed" : "Deeplink Payload already removed");
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(isLayoutRequested, "Deeplink Payload already removed", e);
        }
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.Presenter
    public final void moveToNextValue() {
        this.GetContactSyncConfig.showProgress();
        this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory(new Function0() { // from class: id.dana.onboarding.splash.LocalConfigSplashPresenter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                LocalConfigSplashPresenter localConfigSplashPresenter = LocalConfigSplashPresenter.this;
                localConfigSplashPresenter.GetContactSyncConfig.onFinishLogout();
                localConfigSplashPresenter.GetContactSyncConfig.dismissProgress();
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.onboarding.splash.LocalConfigSplashPresenter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                LocalConfigSplashPresenter.this.GetContactSyncConfig.dismissProgress();
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        Completable PlaceComponentResult = Completable.PlaceComponentResult(new Action() { // from class: id.dana.onboarding.splash.LocalConfigSplashPresenter$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Action
            public final void run() {
                EventTracker.BuiltInFictitiousFunctionClassFactory(new RDSEvent("rds_on_page"));
            }
        });
        Predicate BuiltInFictitiousFunctionClassFactory = Functions.BuiltInFictitiousFunctionClassFactory();
        ObjectHelper.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, "predicate is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableOnErrorComplete(PlaceComponentResult, BuiltInFictitiousFunctionClassFactory));
        Scheduler MyBillsEntityDataFactory = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory));
        Scheduler PlaceComponentResult2 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult2, "scheduler is null");
        this.PrepareContext.getAuthRequestContext(RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$22, PlaceComponentResult2)).q_());
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.getAuthRequestContext.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.onboarding.splash.LocalConfigSplashPresenter$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                LocalConfigSplashPresenter.this.getAuthRequestContext((Boolean) obj);
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.onboarding.splash.LocalConfigSplashPresenter$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                LocalConfigSplashPresenter localConfigSplashPresenter = LocalConfigSplashPresenter.this;
                if (((Throwable) obj) instanceof HoldLoginException) {
                    localConfigSplashPresenter.moveToNextValue();
                } else {
                    localConfigSplashPresenter.getAuthRequestContext(Boolean.FALSE);
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void getAuthRequestContext(Boolean bool) {
        this.getErrorConfigVersion.get().execute(new SaveIsSessionChecked.Params(bool.booleanValue()), new Function1() { // from class: id.dana.onboarding.splash.LocalConfigSplashPresenter$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Boolean bool2 = (Boolean) obj;
                LocalConfigSplashPresenter.this.GetContactSyncConfig.onCheckSessionDone();
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.onboarding.splash.LocalConfigSplashPresenter$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                LocalConfigSplashPresenter.this.GetContactSyncConfig.onCheckSessionDone();
                return Unit.INSTANCE;
            }
        });
    }

    private static String MyBillsEntityDataFactory(int i) {
        String valueOf = String.valueOf(i);
        if (valueOf.length() <= 1 || valueOf.length() > 3) {
            return valueOf.length() >= 5 ? valueOf.replaceAll("0", ".") : valueOf;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        sb.append(valueOf.replaceAll("0", "."));
        return sb.toString();
    }

    public final void MyBillsEntityDataFactory(String str) {
        EventConfigProperty.Builder builder = new EventConfigProperty.Builder();
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.getApplicationContext();
        builder.lookAheadTest = this.PlaceComponentResult.get().getCurrentTrackerId();
        builder.BuiltInFictitiousFunctionClassFactory = MixPanelTracker.MyBillsEntityDataFactory();
        builder.getErrorConfigVersion = str;
        builder.PlaceComponentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        builder.getAuthRequestContext = MixPanelTracker.getAuthRequestContext();
        Iterator<EventConfig> it = EventConfigFactory.getAuthRequestContext(new EventConfigProperty(builder, (byte) 0), this.PlaceComponentResult.get(), TrackerType.APPSFLYER, TrackerType.BRANCH, TrackerType.MIXPANEL, TrackerType.FULLSTORY).iterator();
        while (it.hasNext()) {
            it.next().MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.lookAheadTest.get().dispose();
        this.initRecordTimeStamp.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.get().dispose();
        this.newProxyInstance.get().dispose();
        this.PrepareContext.MyBillsEntityDataFactory();
        this.scheduleImpl.get().dispose();
        this.moveToNextValue.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory();
        this.getErrorConfigVersion.get().dispose();
        this.getAuthRequestContext.get().dispose();
    }

    private static void b(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(NetworkUserEntityData$$ExternalSyntheticLambda6 ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length) {
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (NetworkUserEntityData$$ExternalSyntheticLambda6 ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
        }
        objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
    }
}
