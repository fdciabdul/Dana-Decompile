package id.dana.xyz;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.WheelView;
import com.google.common.base.Ascii;
import com.iap.ac.config.lite.ConfigCenter;
import dagger.Lazy;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.constants.AnalyticEventConstant;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.domain.featureconfig.StartupConfigEntityData;
import id.dana.domain.featureconfig.model.StartupConfig;
import id.dana.onboarding.unsafe.UnsafeDeviceActivity;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.UtdIdUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Singleton;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;
import o.X$KClassImpl$Data$declaredNonStaticMembers$2;

@Singleton
/* loaded from: classes.dex */
public class F4X93h6JwT {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final ArrayList<Runnable> KClassImpl$Data$declaredNonStaticMembers$2;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static int[] PlaceComponentResult;
    private Disposable BuiltInFictitiousFunctionClassFactory = null;
    private final Lazy<DeviceInformationProvider> MyBillsEntityDataFactory;
    private final Application getAuthRequestContext;
    public static final byte[] $$a = {3, -83, -69, 19, TarHeader.LF_LINK, -50, 44, 8, 5, 12, -41, 46, 11, -6, 16, 10, -48, 34, Ascii.CAN, -14, -22, 32, 7, 22, 0, 8, 12, 33, -6, 7, 7, -29, TarHeader.LF_LINK, 3, 8, 4, 4, -4, 14, 11, -29, Ascii.CAN, 19, 7, -4, 13};
    public static final int $$b = WheelView.DIVIDER_ALPHA;
    private static int getErrorConfigVersion = 0;

    static void MyBillsEntityDataFactory() {
        PlaceComponentResult = new int[]{-1773222519, -1371884080, -290733350, -990552003, 1901739790, -87761701, 185139672, 293532010, -250659051, -506195232, -1404831405, -62902964, -1203845770, 818471683, 887231943, -837085701, -1507704138, 345056618};
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(int i, int i2) {
        int i3 = getErrorConfigVersion + 61;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        int i4 = i3 % 2;
        BuiltInFictitiousFunctionClassFactory(i, i2);
        int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 113;
        getErrorConfigVersion = i5 % 128;
        if (!(i5 % 2 != 0)) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 4
            int r7 = 24 - r7
            int r8 = r8 * 23
            int r8 = r8 + 4
            byte[] r0 = id.dana.xyz.F4X93h6JwT.$$a
            int r9 = r9 * 3
            int r9 = r9 + 77
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L35
        L1b:
            r3 = 0
        L1c:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r7) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L35:
            int r10 = r10 + r7
            int r7 = r9 + 1
            int r9 = r10 + (-5)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.xyz.F4X93h6JwT.a(int, byte, short, java.lang.Object[]):void");
    }

    static {
        NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
        MyBillsEntityDataFactory();
        KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList<>();
        int i = getErrorConfigVersion + 99;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
    }

    public F4X93h6JwT(Application application, Lazy<DeviceInformationProvider> lazy) {
        this.getAuthRequestContext = application;
        this.MyBillsEntityDataFactory = lazy;
        KClassImpl$Data$declaredNonStaticMembers$2.add(0, new Runnable() { // from class: id.dana.xyz.F4X93h6JwT$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                F4X93h6JwT.this.PlaceComponentResult();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void PlaceComponentResult() {
        int i = getErrorConfigVersion + 89;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 == 0 ? JSONLexer.EOI : 'J') != 26) {
            PlaceComponentResult(UnsafeDeviceActivity.UnsafeStatus.ROOTED.getStatus());
            return;
        }
        PlaceComponentResult(UnsafeDeviceActivity.UnsafeStatus.ROOTED.getStatus());
        Object obj = null;
        obj.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void PlaceComponentResult(Boolean bool, Boolean bool2, Runnable runnable) {
        try {
            int i = getErrorConfigVersion + 57;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
            getAuthRequestContext(bool.booleanValue(), bool2.booleanValue(), runnable);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 69;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        ArrayList<Runnable> arrayList = KClassImpl$Data$declaredNonStaticMembers$2;
        int i3 = 0;
        if (!(i != i2)) {
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 23;
            getErrorConfigVersion = i4 % 128;
            int i5 = i4 % 2;
            i3 = 1;
        } else {
            int i6 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 81;
            getErrorConfigVersion = i6 % 128;
            int i7 = i6 % 2;
        }
        Runnable runnable = arrayList.get(i3);
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void PlaceComponentResult(final SplitConfigEntityData splitConfigEntityData, final StartupConfigEntityData startupConfigEntityData) {
        ArrayList<Runnable> arrayList = KClassImpl$Data$declaredNonStaticMembers$2;
        arrayList.add(0, new Runnable() { // from class: id.dana.xyz.F4X93h6JwT$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                F4X93h6JwT.this.getAuthRequestContext(splitConfigEntityData, startupConfigEntityData);
            }
        });
        arrayList.add(1, new Runnable() { // from class: id.dana.xyz.F4X93h6JwT$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                F4X93h6JwT.this.BuiltInFictitiousFunctionClassFactory(splitConfigEntityData, startupConfigEntityData);
            }
        });
        try {
            Object[] objArr = {this.getAuthRequestContext, new X$KClassImpl$Data$declaredNonStaticMembers$2() { // from class: id.dana.xyz.F4X93h6JwT$$ExternalSyntheticLambda2
                @Override // o.X$KClassImpl$Data$declaredNonStaticMembers$2
                public final void PlaceComponentResult(int i, int i2) {
                    F4X93h6JwT.MyBillsEntityDataFactory(i, i2);
                }
            }};
            Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-854867676);
            if (obj == null) {
                Class cls = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 119, TextUtils.lastIndexOf("", '0') + 4, (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 38968));
                byte b = (byte) ($$a[24] + 1);
                byte b2 = b;
                Object[] objArr2 = new Object[1];
                a(b, b2, b2, objArr2);
                obj = cls.getMethod((String) objArr2[0], Context.class, X$KClassImpl$Data$declaredNonStaticMembers$2.class);
                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-854867676, obj);
            }
            Object[] objArr3 = null;
            ((Method) obj).invoke(null, objArr);
            int i = getErrorConfigVersion + 89;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            if ((i % 2 == 0 ? 'b' : '1') != 'b') {
                return;
            }
            int length = objArr3.length;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void getAuthRequestContext(SplitConfigEntityData splitConfigEntityData, StartupConfigEntityData startupConfigEntityData) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 5;
        getErrorConfigVersion = i % 128;
        if (i % 2 != 0) {
        }
        MyBillsEntityDataFactory(splitConfigEntityData, startupConfigEntityData, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SplitConfigEntityData splitConfigEntityData, StartupConfigEntityData startupConfigEntityData) {
        int i = getErrorConfigVersion + 17;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        if ((BuiltInFictitiousFunctionClassFactory() ? 'D' : 'b') == 'D') {
            MyBillsEntityDataFactory(splitConfigEntityData, startupConfigEntityData, false);
        }
        int i3 = getErrorConfigVersion + 47;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if (i3 % 2 != 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    private void MyBillsEntityDataFactory(SplitConfigEntityData splitConfigEntityData, final StartupConfigEntityData startupConfigEntityData, final boolean z) {
        Disposable disposable = this.BuiltInFictitiousFunctionClassFactory;
        if ((disposable != null ? 'X' : 'U') == 'X') {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 27;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            disposable.dispose();
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 17;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
        }
        Observable<StartupConfig> take = splitConfigEntityData.getStartupConfig().take(1L);
        Objects.requireNonNull(startupConfigEntityData);
        this.BuiltInFictitiousFunctionClassFactory = take.onErrorResumeNext(Observable.fromCallable(new Callable() { // from class: id.dana.xyz.F4X93h6JwT$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return StartupConfigEntityData.this.getStartupConfig();
            }
        })).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.xyz.F4X93h6JwT$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                F4X93h6JwT.this.getAuthRequestContext(z, (StartupConfig) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void getAuthRequestContext(boolean z, StartupConfig startupConfig) throws Exception {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 17;
        getErrorConfigVersion = i % 128;
        if ((i % 2 != 0 ? (char) 23 : 'S') != 23) {
            KClassImpl$Data$declaredNonStaticMembers$2(Boolean.valueOf(startupConfig.getFeatureDexguardRootCheck()), Boolean.valueOf(startupConfig.getFeatureDexguardHookCheck()), z);
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2(Boolean.valueOf(startupConfig.getFeatureDexguardRootCheck()), Boolean.valueOf(startupConfig.getFeatureDexguardHookCheck()), z);
        Object[] objArr = null;
        int length = objArr.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if (r3.booleanValue() == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        r3 = 'W';
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        r3 = 'V';
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
    
        if (r3 == 'V') goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
    
        PlaceComponentResult(id.dana.onboarding.unsafe.UnsafeDeviceActivity.UnsafeStatus.ROOTED.getStatus());
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        if (r4.booleanValue() == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        r3 = id.dana.xyz.F4X93h6JwT.NetworkUserEntityData$$ExternalSyntheticLambda0 + 73;
        id.dana.xyz.F4X93h6JwT.getErrorConfigVersion = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        if ((r3 % 2) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        r3 = '.';
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
    
        r3 = 'O';
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
    
        if (r3 == 'O') goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        PlaceComponentResult(id.dana.onboarding.unsafe.UnsafeDeviceActivity.UnsafeStatus.TAMPERED.getStatus());
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
    
        r3 = r1.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0058, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0059, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
    
        PlaceComponentResult(id.dana.onboarding.unsafe.UnsafeDeviceActivity.UnsafeStatus.TAMPERED.getStatus());
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0063, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0064, code lost:
    
        getErrorConfigVersion();
        scheduleImpl();
        r3 = id.dana.xyz.F4X93h6JwT.getErrorConfigVersion + 41;
        id.dana.xyz.F4X93h6JwT.NetworkUserEntityData$$ExternalSyntheticLambda0 = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0074, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
    
        if (r5 != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        if (r5 != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void KClassImpl$Data$declaredNonStaticMembers$2(java.lang.Boolean r3, java.lang.Boolean r4, boolean r5) {
        /*
            r2 = this;
            int r0 = id.dana.xyz.F4X93h6JwT.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 19
            int r1 = r0 % 128
            id.dana.xyz.F4X93h6JwT.getErrorConfigVersion = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L15
            r1.hashCode()     // Catch: java.lang.Throwable -> L13
            if (r5 == 0) goto L30
            goto L17
        L13:
            r3 = move-exception
            throw r3
        L15:
            if (r5 == 0) goto L30
        L17:
            boolean r3 = r3.booleanValue()
            r5 = 86
            if (r3 == 0) goto L22
            r3 = 87
            goto L24
        L22:
            r3 = 86
        L24:
            if (r3 == r5) goto L30
            id.dana.onboarding.unsafe.UnsafeDeviceActivity$UnsafeStatus r3 = id.dana.onboarding.unsafe.UnsafeDeviceActivity.UnsafeStatus.ROOTED
            java.lang.String r3 = r3.getStatus()
            r2.PlaceComponentResult(r3)
            return
        L30:
            boolean r3 = r4.booleanValue()
            if (r3 == 0) goto L64
            int r3 = id.dana.xyz.F4X93h6JwT.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r3 = r3 + 73
            int r4 = r3 % 128
            id.dana.xyz.F4X93h6JwT.getErrorConfigVersion = r4
            int r3 = r3 % 2
            r4 = 79
            if (r3 == 0) goto L47
            r3 = 46
            goto L49
        L47:
            r3 = 79
        L49:
            if (r3 == r4) goto L5a
            id.dana.onboarding.unsafe.UnsafeDeviceActivity$UnsafeStatus r3 = id.dana.onboarding.unsafe.UnsafeDeviceActivity.UnsafeStatus.TAMPERED     // Catch: java.lang.Exception -> L58
            java.lang.String r3 = r3.getStatus()     // Catch: java.lang.Exception -> L58
            r2.PlaceComponentResult(r3)     // Catch: java.lang.Exception -> L58
            int r3 = r1.length     // Catch: java.lang.Throwable -> L56
            return
        L56:
            r3 = move-exception
            throw r3
        L58:
            r3 = move-exception
            throw r3
        L5a:
            id.dana.onboarding.unsafe.UnsafeDeviceActivity$UnsafeStatus r3 = id.dana.onboarding.unsafe.UnsafeDeviceActivity.UnsafeStatus.TAMPERED
            java.lang.String r3 = r3.getStatus()
            r2.PlaceComponentResult(r3)
            return
        L64:
            r2.getErrorConfigVersion()
            r2.scheduleImpl()
            int r3 = id.dana.xyz.F4X93h6JwT.getErrorConfigVersion
            int r3 = r3 + 41
            int r4 = r3 % 128
            id.dana.xyz.F4X93h6JwT.NetworkUserEntityData$$ExternalSyntheticLambda0 = r4
            int r3 = r3 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.xyz.F4X93h6JwT.KClassImpl$Data$declaredNonStaticMembers$2(java.lang.Boolean, java.lang.Boolean, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x00a5, code lost:
    
        if ((((java.lang.Integer) ((java.lang.reflect.Method) r0).invoke(null, r12)).intValue() == 1 ? 5 : com.alibaba.fastjson.parser.JSONLexer.EOI) != 5) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x013c, code lost:
    
        if ((((java.lang.Integer) ((java.lang.reflect.Method) r0).invoke(null, r11)).intValue() != 1) != true) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x013f, code lost:
    
        r9 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean getAuthRequestContext() {
        /*
            Method dump skipped, instructions count: 540
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.xyz.F4X93h6JwT.getAuthRequestContext():boolean");
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        try {
            Object[] objArr = {this.getAuthRequestContext, 1, 1};
            Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1452522706);
            if (obj == null) {
                Class cls = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 2, (char) (KeyEvent.getMaxKeyCode() >> 16));
                byte b = (byte) ($$a[24] + 1);
                byte b2 = b;
                Object[] objArr2 = new Object[1];
                a(b, b2, b2, objArr2);
                obj = cls.getMethod((String) objArr2[0], Context.class, Integer.TYPE, Integer.TYPE);
                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1452522706, obj);
            }
            if ((((Integer) ((Method) obj).invoke(null, objArr)).intValue() == 1 ? (char) 11 : '3') != 11) {
                return true;
            }
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 57;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 77;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
            return false;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private void PlaceComponentResult(String str) {
        getErrorConfigVersion();
        scheduleImpl();
        Intent intent = new Intent(this.getAuthRequestContext, UnsafeDeviceActivity.class);
        intent.addFlags(268468224);
        intent.putExtra(UnsafeDeviceActivity.UNSAFE_STATUS, str);
        intent.putExtra("egg_message", KClassImpl$Data$declaredNonStaticMembers$2());
        this.getAuthRequestContext.startActivity(intent);
        int i = getErrorConfigVersion + 105;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if (i % 2 != 0) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private void getErrorConfigVersion() {
        try {
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(this.getAuthRequestContext);
            builder.MyBillsEntityDataFactory = AnalyticEventConstant.AE_UNSAFE_DEVICE;
            EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("UTDID", this.MyBillsEntityDataFactory.get().getDeviceUtdId());
            MyBillsEntityDataFactory.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
            int i = getErrorConfigVersion + 47;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            if ((i % 2 != 0 ? (byte) 1 : (byte) 0) != 0) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    private void scheduleImpl() {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(this.getAuthRequestContext);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.UNSAFE_IDENTIFIED_DEVICE;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("UTDID", this.MyBillsEntityDataFactory.get().getDeviceUtdId());
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
        int i = getErrorConfigVersion + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 == 0 ? (byte) 62 : (byte) 0) != 62) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private String KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            StringBuilder sb = new StringBuilder();
            ConfigCenter configCenter = ConfigCenter.getInstance();
            if ((configCenter.isInitialized() ? '9' : '(') != '(') {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 1;
                getErrorConfigVersion = i % 128;
                int i2 = i % 2;
                String configUserId = configCenter.getConfigContext().getIdentifierProvider().getConfigUserId(this.getAuthRequestContext);
                sb.append("reference-utdid: ");
                sb.append(UtdIdUtil.MyBillsEntityDataFactory());
                sb.append("\n");
                sb.append("local-reference-utdid: ");
                sb.append(this.MyBillsEntityDataFactory.get().getReferenceUtdId());
                sb.append("\n");
                sb.append("reference-uid: ");
                sb.append(configUserId);
                sb.append("\n");
            } else {
                sb.append("AMCS ConfigSdk not initialized!\n");
                int i3 = getErrorConfigVersion + 83;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                int i4 = i3 % 2;
            }
            String obj = sb.toString();
            int i5 = getErrorConfigVersion + 25;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i5 % 128;
            if (i5 % 2 == 0) {
                int i6 = 31 / 0;
                return obj;
            }
            return obj;
        } catch (Exception unused) {
            return "";
        }
    }

    private void getAuthRequestContext(boolean z, boolean z2, Runnable runnable) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 61;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        if ((KClassImpl$Data$declaredNonStaticMembers$2(z, z2) ? Typography.dollar : (char) 2) != 2) {
            PlaceComponentResult(UnsafeDeviceActivity.UnsafeStatus.TAMPERED.getStatus());
            return;
        }
        runnable.run();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 19;
        getErrorConfigVersion = i3 % 128;
        if (!(i3 % 2 == 0)) {
            int i4 = 60 / 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        if (getAuthRequestContext() != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        r5 = id.dana.xyz.F4X93h6JwT.getErrorConfigVersion + 103;
        id.dana.xyz.F4X93h6JwT.NetworkUserEntityData$$ExternalSyntheticLambda0 = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
    
        if ((!BuiltInFictitiousFunctionClassFactory() ? 'M' : '%') != '%') goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2(boolean r4, boolean r5) {
        /*
            r3 = this;
            int r0 = id.dana.xyz.F4X93h6JwT.NetworkUserEntityData$$ExternalSyntheticLambda0
            r1 = 25
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.xyz.F4X93h6JwT.getErrorConfigVersion = r2
            int r0 = r0 % 2
            if (r4 == 0) goto L29
            int r4 = id.dana.xyz.F4X93h6JwT.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L27
            int r4 = r4 + 13
            int r0 = r4 % 128
            id.dana.xyz.F4X93h6JwT.getErrorConfigVersion = r0     // Catch: java.lang.Exception -> L27
            int r4 = r4 % 2
            boolean r4 = r3.BuiltInFictitiousFunctionClassFactory()     // Catch: java.lang.Exception -> L27
            r0 = 37
            if (r4 != 0) goto L22
            r4 = 77
            goto L24
        L22:
            r4 = 37
        L24:
            if (r4 == r0) goto L39
            goto L29
        L27:
            r4 = move-exception
            throw r4
        L29:
            if (r5 == 0) goto L2e
            r4 = 25
            goto L30
        L2e:
            r4 = 22
        L30:
            if (r4 == r1) goto L33
            goto L45
        L33:
            boolean r4 = r3.getAuthRequestContext()     // Catch: java.lang.Exception -> L47
            if (r4 == 0) goto L45
        L39:
            r4 = 1
            int r5 = id.dana.xyz.F4X93h6JwT.getErrorConfigVersion
            int r5 = r5 + 103
            int r0 = r5 % 128
            id.dana.xyz.F4X93h6JwT.NetworkUserEntityData$$ExternalSyntheticLambda0 = r0
            int r5 = r5 % 2
            goto L46
        L45:
            r4 = 0
        L46:
            return r4
        L47:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.xyz.F4X93h6JwT.KClassImpl$Data$declaredNonStaticMembers$2(boolean, boolean):boolean");
    }

    private static void b(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = PlaceComponentResult;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr3[i2] = (int) (iArr2[i2] ^ (-3152031022165484798L));
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = PlaceComponentResult;
        boolean z = true;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i3 = $11 + 5;
            $10 = i3 % 128;
            int i4 = i3 % 2;
            int i5 = 0;
            while (true) {
                if ((i5 >= length3) == z) {
                    break;
                }
                iArr6[i5] = (int) (iArr5[i5] ^ (-3152031022165484798L));
                i5++;
                int i6 = $10 + 11;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                length3 = length3;
                z = true;
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if ((verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length ? 'I' : '7') == '7') {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            int i8 = 0;
            while (true) {
                if (!(i8 < 16)) {
                    try {
                        break;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i8];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                int i9 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i9;
                i8++;
            }
            int i10 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i10;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
            int i11 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i12 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
            cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
            cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
            int i13 = $11 + 67;
            $10 = i13 % 128;
            int i14 = i13 % 2;
        }
    }
}
