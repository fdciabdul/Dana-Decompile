package id.dana.onboarding.carrieridentification;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.challenge.ChallengeControl;
import id.dana.challenge.ChallengePinWithFaceActivity;
import id.dana.challenge.ChallengeScenario;
import id.dana.challenge.pin.LogoutContract;
import id.dana.core.ui.constant.DialogType;
import id.dana.core.ui.richview.InputPhoneView;
import id.dana.databinding.ActivityCarrierIdentificationVerifyBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerCarrierIdentificationVerifyComponent;
import id.dana.di.modules.CarrierIdentificationVerifyModule;
import id.dana.di.modules.LogoutModule;
import id.dana.dialog.LoadingDialog;
import id.dana.dialog.LoginInfoDialog;
import id.dana.domain.model.rpc.response.LoginAuthenticationOptionResponse;
import id.dana.domain.model.rpc.response.LoginResponse;
import id.dana.onboarding.OnboardingActivity;
import id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyContract;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.onboarding.verify.VerifyNumberTextWatcher;
import id.dana.performancetracker.VerifyMethodAnalyticTracker;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.deeplink.DeepLinkParser;
import id.dana.utils.measureloadscreen.FirstDrawListener;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen$stopTracking$1;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0015\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0013R\"\u0010\u0017\u001a\u00020\u00168\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0015\u001a\u00020 8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\u0012\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00140\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b(\u0010\u001eR\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b+\u0010,R\"\u0010/\u001a\u00020.8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u00108\u001a\u0002058\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b9\u0010$R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b>\u0010$R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b@\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bA\u0010$"}, d2 = {"Lid/dana/onboarding/carrieridentification/CarrierIdentificationVerifyActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityCarrierIdentificationVerifyBinding;", "", "configToolbar", "()V", "", "", "p0", "getAuthRequestContext", "(Ljava/util/List;)V", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "initViewBinding", "()Lid/dana/databinding/ActivityCarrierIdentificationVerifyBinding;", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)Z", "Lid/dana/domain/model/rpc/response/LoginAuthenticationOptionResponse;", "MyBillsEntityDataFactory", "Lid/dana/onboarding/carrieridentification/CarrierIdentificationVerifyContract$Presenter;", "carrierIdentificationVerifyPresenter", "Lid/dana/onboarding/carrieridentification/CarrierIdentificationVerifyContract$Presenter;", "getCarrierIdentificationVerifyPresenter", "()Lid/dana/onboarding/carrieridentification/CarrierIdentificationVerifyContract$Presenter;", "setCarrierIdentificationVerifyPresenter", "(Lid/dana/onboarding/carrieridentification/CarrierIdentificationVerifyContract$Presenter;)V", "lookAheadTest", "Ljava/util/List;", "PlaceComponentResult", "Landroid/os/Bundle;", "DatabaseTableConfigUtil", "Landroid/os/Bundle;", "initRecordTimeStamp", "Ljava/lang/String;", "Lid/dana/dialog/LoadingDialog;", "GetContactSyncConfig", "Lid/dana/dialog/LoadingDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/model/rpc/response/LoginResponse;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/domain/model/rpc/response/LoginResponse;", "getErrorConfigVersion", "Lid/dana/challenge/pin/LogoutContract$Presenter;", "logoutPresenter", "Lid/dana/challenge/pin/LogoutContract$Presenter;", "getLogoutPresenter", "()Lid/dana/challenge/pin/LogoutContract$Presenter;", "setLogoutPresenter", "(Lid/dana/challenge/pin/LogoutContract$Presenter;)V", "Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "newProxyInstance", "Lid/dana/onboarding/verify/VerifyNumberTextWatcher;", "isLayoutRequested", "Lid/dana/onboarding/verify/VerifyNumberTextWatcher;", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda7", "scheduleImpl", "PrepareContext", "FragmentBottomSheetPaymentSettingBinding", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CarrierIdentificationVerifyActivity extends ViewBindingActivity<ActivityCarrierIdentificationVerifyBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final String IPIFICATION_REDIRECT_URI = "https://m.dana.id/";
    private static final int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda3;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda4;
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda5;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private Bundle MyBillsEntityDataFactory;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private LoadingDialog BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private List<? extends LoginAuthenticationOptionResponse> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private LoginResponse getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private String scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final MeasureLoadAndRenderingScreen NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda2;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public CarrierIdentificationVerifyContract.Presenter carrierIdentificationVerifyPresenter;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String getAuthRequestContext;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private VerifyNumberTextWatcher moveToNextValue;
    @Inject
    public LogoutContract.Presenter logoutPresenter;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private List<String> PlaceComponentResult;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private String lookAheadTest;
    public static final byte[] $$a = {36, -25, -14, -85, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 24;
    public static final byte[] getAuthRequestContext = {TarHeader.LF_CHR, 112, -114, 9, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 23;

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        NetworkUserEntityData$$ExternalSyntheticLambda5 = new char[]{39440, 39429, 39439, 39425, 39426, 39432, 39877, 39427, 39472, 39438, 39551, 39549, 39544, 39455, 39435, 39436, 39548, 39431, 39550, 39459, 39428, 39452, 39482, 39485, 39483, 39875, 39480, 39437, 39873, 39872, 39486, 39487, 39441, 39484, 39481, 39874, 39434, 39424};
        NetworkUserEntityData$$ExternalSyntheticLambda4 = true;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = true;
        NetworkUserEntityData$$ExternalSyntheticLambda6 = 909155315;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = 23 - r6
            int r8 = r8 + 4
            int r7 = 106 - r7
            byte[] r0 = id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyActivity.getAuthRequestContext
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L2f
        L15:
            r3 = 0
        L16:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            r3 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L2f:
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyActivity.b(short, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyActivity.$$a
            int r7 = r7 * 3
            int r7 = r7 + 21
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r6 = 47 - r6
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L35
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L35:
            int r6 = -r6
            int r7 = r7 + 1
            int r8 = r8 + r6
            int r8 = r8 + (-7)
            r6 = r7
            r7 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyActivity.c(int, int, short, java.lang.Object[]):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        Object[] objArr = new Object[1];
        a(null, 127 - ExpandableListView.getPackedPositionType(0L), new byte[]{-109, -109, -112, -118, -123, -124, -108, -121, -109, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        a(null, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 127, new byte[]{-125, -122, -106, -115, -107}, null, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + PDF417Common.NUMBER_OF_CODEWORDS, Process.getGidForName("") + 36, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr3 = new Object[1];
                    a(null, 175 - AndroidCharacter.getMirror('0'), new byte[]{-112, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -112, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -112, -100, -118, -112, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr3);
                    String str = (String) objArr3[0];
                    Object[] objArr4 = new Object[1];
                    a(null, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 126, new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -112, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -112, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr4);
                    String str2 = (String) objArr4[0];
                    Object[] objArr5 = new Object[1];
                    a(null, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 126, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -112, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -112, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -112, -98, -99}, null, objArr5);
                    String str3 = (String) objArr5[0];
                    Object[] objArr6 = new Object[1];
                    a(null, View.combineMeasuredStates(0, 0) + 127, new byte[]{-109, -117, -126, -112, -116, -112, -92, -99, -116, -92, -117, -109, -112, -91, -126, -122, -92, -122, -120, -127, -92, -107, -123, -118, -121, -112, -124, -127, -111, -90, -109, -125, -124, -127, -111, -91, -121, -117, -109, -127, -118, -117, -127, -112, -124, -113, -117, -121, -127, -126, -127, -125, -92, -92, -93, -109, -120, -117, -117, -113}, null, objArr6);
                    String str4 = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(null, 127 - (ViewConfiguration.getPressedStateDuration() >> 16), new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr7);
                    try {
                        Object[] objArr8 = {applicationContext, str, str2, str3, str4, true, (String) objArr7[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Gravity.getAbsoluteGravity(0, 0), 18 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr8);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
        }
        Context applicationContext2 = context != null ? context.getApplicationContext() : context;
        if (applicationContext2 != null) {
            try {
                byte b = getAuthRequestContext[30];
                byte b2 = getAuthRequestContext[25];
                Object[] objArr9 = new Object[1];
                b(b, b2, (byte) (b2 | 36), objArr9);
                Class<?> cls2 = Class.forName((String) objArr9[0]);
                byte b3 = getAuthRequestContext[30];
                byte b4 = getAuthRequestContext[9];
                Object[] objArr10 = new Object[1];
                b(b3, b4, (byte) (b4 | Ascii.DC4), objArr10);
                try {
                    Object[] objArr11 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr10[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getTapTimeout() >> 16), 3 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (ViewConfiguration.getPressedStateDuration() >> 16));
                        byte b5 = (byte) (-$$a[53]);
                        byte b6 = $$a[47];
                        Object[] objArr12 = new Object[1];
                        c(b5, b6, b6, objArr12);
                        obj3 = cls3.getMethod((String) objArr12[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr11);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.lastIndexOf("", '0'), 15 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) Drawable.resolveOpacity(0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.indexOf("", "", 0), View.MeasureSpec.makeMeasureSpec(0, 0) + 15, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr13 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 816, Process.getGidForName("") + 30, (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 800, 15 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) TextUtils.indexOf("", "")));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr13));
                                    long j = ((r4 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 == null) {
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 34 - Process.getGidForName(""), (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(null, null);
                                        try {
                                            Object[] objArr14 = {2045285712, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 911, 18 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr14);
                                        } catch (Throwable th3) {
                                            Throwable cause3 = th3.getCause();
                                            if (cause3 == null) {
                                                throw th3;
                                            }
                                            throw cause3;
                                        }
                                    } catch (Throwable th4) {
                                        Throwable cause4 = th4.getCause();
                                        if (cause4 == null) {
                                            throw th4;
                                        }
                                        throw cause4;
                                    }
                                } catch (Throwable th5) {
                                    Throwable cause5 = th5.getCause();
                                    if (cause5 == null) {
                                        throw th5;
                                    }
                                    throw cause5;
                                }
                            }
                        } catch (Throwable th6) {
                            Throwable cause6 = th6.getCause();
                            if (cause6 == null) {
                                throw th6;
                            }
                            throw cause6;
                        }
                    } catch (Throwable th7) {
                        Throwable cause7 = th7.getCause();
                        if (cause7 == null) {
                            throw th7;
                        }
                        throw cause7;
                    }
                } catch (Throwable th8) {
                    Throwable cause8 = th8.getCause();
                    if (cause8 == null) {
                        throw th8;
                    }
                    throw cause8;
                }
            } catch (Throwable th9) {
                Throwable cause9 = th9.getCause();
                if (cause9 == null) {
                    throw th9;
                }
                throw cause9;
            }
        }
        Context applicationContext3 = context != null ? context.getApplicationContext() : context;
        if (applicationContext3 != null) {
            try {
                byte b7 = getAuthRequestContext[30];
                byte b8 = getAuthRequestContext[25];
                Object[] objArr15 = new Object[1];
                b(b7, b8, (byte) (b8 | 36), objArr15);
                Class<?> cls4 = Class.forName((String) objArr15[0]);
                byte b9 = getAuthRequestContext[30];
                byte b10 = getAuthRequestContext[9];
                Object[] objArr16 = new Object[1];
                b(b9, b10, (byte) (b10 | Ascii.DC4), objArr16);
                try {
                    Object[] objArr17 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(60 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 45 - TextUtils.lastIndexOf("", '0'), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1));
                        Object[] objArr18 = new Object[1];
                        c($$a[20], (byte) ($$a[47] - 1), (byte) (-$$a[2]), objArr18);
                        obj9 = cls5.getMethod((String) objArr18[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr19 = (Object[]) ((Method) obj9).invoke(null, objArr17);
                    int i = ((int[]) objArr19[1])[0];
                    if (((int[]) objArr19[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 == null) {
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(null, null);
                            try {
                                Object[] objArr20 = {2045285712, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 911, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr20);
                            } catch (Throwable th10) {
                                Throwable cause10 = th10.getCause();
                                if (cause10 == null) {
                                    throw th10;
                                }
                                throw cause10;
                            }
                        } catch (Throwable th11) {
                            Throwable cause11 = th11.getCause();
                            if (cause11 == null) {
                                throw th11;
                            }
                            throw cause11;
                        }
                    }
                } catch (Throwable th12) {
                    Throwable cause12 = th12.getCause();
                    if (cause12 == null) {
                        throw th12;
                    }
                    throw cause12;
                }
            } catch (Throwable th13) {
                Throwable cause13 = th13.getCause();
                if (cause13 == null) {
                    throw th13;
                }
                throw cause13;
            }
        }
        Context applicationContext4 = context != null ? context.getApplicationContext() : context;
        if (applicationContext4 != null) {
            try {
                byte b11 = getAuthRequestContext[30];
                byte b12 = getAuthRequestContext[25];
                Object[] objArr21 = new Object[1];
                b(b11, b12, (byte) (b12 | 36), objArr21);
                Class<?> cls6 = Class.forName((String) objArr21[0]);
                byte b13 = getAuthRequestContext[30];
                byte b14 = getAuthRequestContext[9];
                Object[] objArr22 = new Object[1];
                b(b13, b14, (byte) (b14 | Ascii.DC4), objArr22);
                try {
                    Object[] objArr23 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr22[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 118, 3 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) (KeyEvent.getDeadChar(0, 0) + 38968));
                        Object[] objArr24 = new Object[1];
                        c($$a[20], (byte) ($$a[47] - 1), (byte) (-$$a[2]), objArr24);
                        obj12 = cls7.getMethod((String) objArr24[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr25 = (Object[]) ((Method) obj12).invoke(null, objArr23);
                    int i2 = ((int[]) objArr25[1])[0];
                    if (((int[]) objArr25[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 == null) {
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.lastIndexOf("", '0'), (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(null, null);
                            try {
                                Object[] objArr26 = {2045285712, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.blue(0), View.MeasureSpec.getMode(0) + 18, (char) TextUtils.indexOf("", ""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr26);
                            } catch (Throwable th14) {
                                Throwable cause14 = th14.getCause();
                                if (cause14 == null) {
                                    throw th14;
                                }
                                throw cause14;
                            }
                        } catch (Throwable th15) {
                            Throwable cause15 = th15.getCause();
                            if (cause15 == null) {
                                throw th15;
                            }
                            throw cause15;
                        }
                    }
                } catch (Throwable th16) {
                    Throwable cause16 = th16.getCause();
                    if (cause16 == null) {
                        throw th16;
                    }
                    throw cause16;
                }
            } catch (Throwable th17) {
                Throwable cause17 = th17.getCause();
                if (cause17 == null) {
                    throw th17;
                }
                throw cause17;
            }
        }
        Context applicationContext5 = context != null ? context.getApplicationContext() : context;
        if (applicationContext5 != null) {
            try {
                byte b15 = getAuthRequestContext[30];
                byte b16 = getAuthRequestContext[25];
                Object[] objArr27 = new Object[1];
                b(b15, b16, (byte) (b16 | 36), objArr27);
                Class<?> cls8 = Class.forName((String) objArr27[0]);
                byte b17 = getAuthRequestContext[30];
                byte b18 = getAuthRequestContext[9];
                Object[] objArr28 = new Object[1];
                b(b17, b18, (byte) (b18 | Ascii.DC4), objArr28);
                try {
                    Object[] objArr29 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr28[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - View.combineMeasuredStates(0, 0), TextUtils.getTrimmedLength("") + 3, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))));
                        Object[] objArr30 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[8]), (byte) ($$a[47] - 1), objArr30);
                        obj15 = cls9.getMethod((String) objArr30[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr31 = (Object[]) ((Method) obj15).invoke(null, objArr29);
                    int i3 = ((int[]) objArr31[1])[0];
                    if (((int[]) objArr31[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 == null) {
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (Process.myTid() >> 22) + 35, (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(null, null);
                            try {
                                Object[] objArr32 = {2045285712, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getPressedStateDuration() >> 16), 18 - Color.blue(0), (char) (Process.myTid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr32);
                            } catch (Throwable th18) {
                                Throwable cause18 = th18.getCause();
                                if (cause18 == null) {
                                    throw th18;
                                }
                                throw cause18;
                            }
                        } catch (Throwable th19) {
                            Throwable cause19 = th19.getCause();
                            if (cause19 == null) {
                                throw th19;
                            }
                            throw cause19;
                        }
                    }
                } catch (Throwable th20) {
                    Throwable cause20 = th20.getCause();
                    if (cause20 == null) {
                        throw th20;
                    }
                    throw cause20;
                }
            } catch (Throwable th21) {
                Throwable cause21 = th21.getCause();
                if (cause21 == null) {
                    throw th21;
                }
                throw cause21;
            }
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_carrier_identification_verify;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(null, getPackageName().length() + 120, new byte[]{-109, -109, -112, -118, -123, -124, -108, -121, -109, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(null, 127 - (ViewConfiguration.getPressedStateDuration() >> 16), new byte[]{-125, -122, -106, -115, -107}, null, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(null, super.getResources().getString(R.string.family_account_text_organizer_summary_error_insufficient_fund).substring(1, 2).length() + 126, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                try {
                    Object[] objArr5 = new Object[1];
                    b(getAuthRequestContext[25], getAuthRequestContext[3], getAuthRequestContext[7], objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    b(getAuthRequestContext[41], getAuthRequestContext[48], getAuthRequestContext[0], objArr6);
                    Object[] objArr7 = new Object[1];
                    a(null, ((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr7);
                    baseContext = (Context) cls2.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr8 = new Object[1];
                        b(getAuthRequestContext[25], getAuthRequestContext[3], getAuthRequestContext[7], objArr8);
                        Class<?> cls4 = Class.forName((String) objArr8[0]);
                        Object[] objArr9 = new Object[1];
                        b(getAuthRequestContext[41], getAuthRequestContext[48], getAuthRequestContext[0], objArr9);
                        Object[] objArr10 = new Object[1];
                        a(null, ((ApplicationInfo) cls4.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-112, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -112, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -112, -100, -118, -112, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr10);
                        String str = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(null, Color.alpha(0) + 127, new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -112, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -112, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr11);
                        String str2 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        a(null, super.getResources().getString(R.string.dana_viz_prompt_information_tooltip).substring(43, 45).codePointAt(1) + 95, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -112, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -112, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -112, -98, -99}, null, objArr12);
                        String str3 = (String) objArr12[0];
                        try {
                            Object[] objArr13 = new Object[1];
                            b(getAuthRequestContext[25], getAuthRequestContext[3], getAuthRequestContext[7], objArr13);
                            Class<?> cls5 = Class.forName((String) objArr13[0]);
                            Object[] objArr14 = new Object[1];
                            b(getAuthRequestContext[41], getAuthRequestContext[48], getAuthRequestContext[0], objArr14);
                            Object[] objArr15 = new Object[1];
                            a(null, ((ApplicationInfo) cls5.getMethod((String) objArr14[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-109, -117, -126, -112, -116, -112, -92, -99, -116, -92, -117, -109, -112, -91, -126, -122, -92, -122, -120, -127, -92, -107, -123, -118, -121, -112, -124, -127, -111, -90, -109, -125, -124, -127, -111, -91, -121, -117, -109, -127, -118, -117, -127, -112, -124, -113, -117, -121, -127, -126, -127, -125, -92, -92, -93, -109, -120, -117, -117, -113}, null, objArr15);
                            String str4 = (String) objArr15[0];
                            Object[] objArr16 = new Object[1];
                            a(null, (ViewConfiguration.getFadingEdgeLength() >> 16) + 127, new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr16);
                            try {
                                Object[] objArr17 = {baseContext, str, str2, str3, str4, true, (String) objArr16[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (KeyEvent.getMaxKeyCode() >> 16), 18 - View.resolveSizeAndState(0, 0, 0), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr17);
                            } catch (Throwable th2) {
                                Throwable cause2 = th2.getCause();
                                if (cause2 == null) {
                                    throw th2;
                                }
                                throw cause2;
                            }
                        } catch (Throwable th3) {
                            Throwable cause3 = th3.getCause();
                            if (cause3 == null) {
                                throw th3;
                            }
                            throw cause3;
                        }
                    } catch (Throwable th4) {
                        Throwable cause4 = th4.getCause();
                        if (cause4 == null) {
                            throw th4;
                        }
                        throw cause4;
                    }
                } catch (Throwable th5) {
                    Throwable cause5 = th5.getCause();
                    if (cause5 == null) {
                        throw th5;
                    }
                    throw cause5;
                }
            }
        }
        try {
            byte b = getAuthRequestContext[30];
            byte b2 = getAuthRequestContext[25];
            Object[] objArr18 = new Object[1];
            b(b, b2, (byte) (b2 | 36), objArr18);
            Class<?> cls6 = Class.forName((String) objArr18[0]);
            byte b3 = getAuthRequestContext[30];
            byte b4 = getAuthRequestContext[9];
            Object[] objArr19 = new Object[1];
            b(b3, b4, (byte) (b4 | Ascii.DC4), objArr19);
            try {
                Object[] objArr20 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr19[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 494, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 3, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                    Object[] objArr21 = new Object[1];
                    c((byte) ($$a[47] - 1), (byte) (-$$a[8]), (byte) ($$a[47] - 1), objArr21);
                    obj3 = cls7.getMethod((String) objArr21[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr22 = (Object[]) ((Method) obj3).invoke(null, objArr20);
                int i = ((int[]) objArr22[1])[0];
                if (((int[]) objArr22[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr23 = {-273161679, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 911, 18 - (ViewConfiguration.getTapTimeout() >> 16), (char) TextUtils.getOffsetAfter("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr23);
                        } catch (Throwable th6) {
                            Throwable cause6 = th6.getCause();
                            if (cause6 == null) {
                                throw th6;
                            }
                            throw cause6;
                        }
                    } catch (Throwable th7) {
                        Throwable cause7 = th7.getCause();
                        if (cause7 == null) {
                            throw th7;
                        }
                        throw cause7;
                    }
                }
                super.onCreate(bundle);
            } catch (Throwable th8) {
                Throwable cause8 = th8.getCause();
                if (cause8 == null) {
                    throw th8;
                }
                throw cause8;
            }
        } catch (Throwable th9) {
            Throwable cause9 = th9.getCause();
            if (cause9 == null) {
                throw th9;
            }
            throw cause9;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(null, getPackageName().length() + 120, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(null, super.getResources().getString(R.string.bottom_on_boarding_body_text_scan_first).substring(1, 2).codePointAt(0) + 45, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, Color.alpha(0) + 35, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 18 - Color.green(0), (char) Color.argb(0, 0, 0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        super.onPause();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(null, getPackageName().codePointAt(2) + 81, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(null, super.getResources().getString(R.string.request_permission_desc).substring(17, 18).length() + 126, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarSize() >> 8), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 17, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        super.onResume();
    }

    public CarrierIdentificationVerifyActivity() {
        MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = new MeasureLoadAndRenderingScreen();
        Intrinsics.checkNotNullParameter("boku_verification_screen_render", "");
        measureLoadAndRenderingScreen.BuiltInFictitiousFunctionClassFactory = FirebasePerformance.startTrace("boku_verification_screen_render");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = measureLoadAndRenderingScreen;
        this.PlaceComponentResult = CollectionsKt.emptyList();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = CollectionsKt.emptyList();
    }

    @JvmName(name = "getLogoutPresenter")
    public final LogoutContract.Presenter getLogoutPresenter() {
        LogoutContract.Presenter presenter = this.logoutPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setLogoutPresenter")
    public final void setLogoutPresenter(LogoutContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.logoutPresenter = presenter;
    }

    @JvmName(name = "getCarrierIdentificationVerifyPresenter")
    public final CarrierIdentificationVerifyContract.Presenter getCarrierIdentificationVerifyPresenter() {
        CarrierIdentificationVerifyContract.Presenter presenter = this.carrierIdentificationVerifyPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setCarrierIdentificationVerifyPresenter")
    public final void setCarrierIdentificationVerifyPresenter(CarrierIdentificationVerifyContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.carrierIdentificationVerifyPresenter = presenter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityCarrierIdentificationVerifyBinding initViewBinding() {
        ActivityCarrierIdentificationVerifyBinding KClassImpl$Data$declaredNonStaticMembers$2 = ActivityCarrierIdentificationVerifyBinding.KClassImpl$Data$declaredNonStaticMembers$2(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setToolbarImage(R.drawable.ic_dana_logo_icon_text);
        setMenuLeftButton(R.drawable.arrow_left_white);
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(List<String> p0) {
        return p0.size() > 1;
    }

    private static boolean MyBillsEntityDataFactory(List<? extends LoginAuthenticationOptionResponse> p0) {
        return p0.size() > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext(final List<String> p0) {
        addDisposable(Observable.timer(1L, TimeUnit.SECONDS).subscribeOn(Schedulers.getAuthRequestContext()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyActivity$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CarrierIdentificationVerifyActivity.$r8$lambda$2gA3fhry5u4uBrQ2ZIjNjE6bUAQ(CarrierIdentificationVerifyActivity.this, p0, (Long) obj);
            }
        }));
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0086D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0087T¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/onboarding/carrieridentification/CarrierIdentificationVerifyActivity$Companion;", "", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "I", "MyBillsEntityDataFactory", "()I", "PlaceComponentResult", "", "IPIFICATION_REDIRECT_URI", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        public static int MyBillsEntityDataFactory() {
            return CarrierIdentificationVerifyActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
        NetworkUserEntityData$$ExternalSyntheticLambda0 = 2001;
    }

    public static /* synthetic */ void $r8$lambda$2gA3fhry5u4uBrQ2ZIjNjE6bUAQ(CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity, List list, Long l) {
        Intrinsics.checkNotNullParameter(carrierIdentificationVerifyActivity, "");
        Intrinsics.checkNotNullParameter(list, "");
        ArrayList<String> arrayList = list.isEmpty() ? new ArrayList<>() : (ArrayList) list;
        Intent intent = new Intent();
        intent.putStringArrayListExtra(ChallengePinWithFaceActivity.CHALLENGE_METHOD_LIST, arrayList);
        carrierIdentificationVerifyActivity.setResult(1001, intent);
        carrierIdentificationVerifyActivity.finish();
    }

    public static /* synthetic */ void $r8$lambda$6ttPK6Fnnw5fvf8gForLOrbnJ38(CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity, View view) {
        Intrinsics.checkNotNullParameter(carrierIdentificationVerifyActivity, "");
        if (view != null) {
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(view);
        }
        carrierIdentificationVerifyActivity.finish();
    }

    public static /* synthetic */ void $r8$lambda$HSmLgUm2CZgOnWJbCVBvhyhBVMM(CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity, View view) {
        Intrinsics.checkNotNullParameter(carrierIdentificationVerifyActivity, "");
        carrierIdentificationVerifyActivity.setResult(1002, new Intent());
        carrierIdentificationVerifyActivity.finish();
    }

    public static /* synthetic */ void $r8$lambda$Pitzp_kAE716mtRz0fOHe3gBdsY(CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity, String str, View view) {
        String str2;
        Intrinsics.checkNotNullParameter(carrierIdentificationVerifyActivity, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (Intrinsics.areEqual(str, ChallengeScenario.REGISTRATION)) {
            VerifyMethodAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.REGISTRATION_VERIFICATION_METHOD_CARRIER_IDENTIFICATION_TIME);
        } else {
            VerifyMethodAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.LOGIN_VERIFICATION_METHOD_CARRIER_IDENTIFICATION_TIME);
        }
        if (Intrinsics.areEqual(str, ChallengeScenario.REGISTRATION)) {
            CarrierIdentificationVerifyContract.Presenter carrierIdentificationVerifyPresenter = carrierIdentificationVerifyActivity.getCarrierIdentificationVerifyPresenter();
            CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity2 = carrierIdentificationVerifyActivity;
            String str3 = carrierIdentificationVerifyActivity.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (str3 == null) {
                str3 = "";
            }
            String str4 = carrierIdentificationVerifyActivity.lookAheadTest;
            if (str4 == null) {
                str4 = "";
            }
            if (StringsKt.contains$default((CharSequence) "production", (CharSequence) "prod", false, 2, (Object) null)) {
                str2 = IPIFICATION_REDIRECT_URI;
            } else {
                String obj = Uri.parse("https://mgs-gw.m.dana.id/mgw.htm").toString();
                Intrinsics.checkNotNullExpressionValue(obj, "");
                str2 = obj;
            }
            carrierIdentificationVerifyPresenter.MyBillsEntityDataFactory(carrierIdentificationVerifyActivity2, str3, str4, str2);
            return;
        }
        carrierIdentificationVerifyActivity.getAuthRequestContext(carrierIdentificationVerifyActivity.PlaceComponentResult);
    }

    public static final /* synthetic */ String access$checkErrorTracker(CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity, String str, boolean z) {
        boolean z2 = true;
        if (z) {
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                z2 = false;
            }
            return z2 ? TrackerKey.DefaultValue.DEFAULT_ERROR_CODE : str;
        }
        String str3 = str;
        if (str3 != null && str3.length() != 0) {
            z2 = false;
        }
        return z2 ? TrackerKey.DefaultValue.DEFAULT_ERROR_MESSAGE : str;
    }

    public static final /* synthetic */ void access$setResultVerifyCarrierIdentificationRegistration(CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity, String str, String str2, List list) {
        Intent intent = new Intent();
        int hashCode = str.hashCode();
        if (hashCode != -1089036127) {
            if (hashCode != -349917684) {
                if (hashCode == 633112728 && str.equals("failedNeedFailback")) {
                    intent.putParcelableArrayListExtra(ChallengePinWithFaceActivity.LOGIN_AUTHENTICATION_OPTIONS, list.isEmpty() ? new ArrayList<>() : (ArrayList) list);
                    intent.putExtra(ChallengeControl.Key.PHONE_NUMBER, carrierIdentificationVerifyActivity.lookAheadTest);
                    intent.putExtra(ChallengeControl.Key.SECURITY_ID, carrierIdentificationVerifyActivity.NetworkUserEntityData$$ExternalSyntheticLambda1);
                    carrierIdentificationVerifyActivity.setResult(1001, intent);
                }
            } else if (str.equals("successNeedCheckReferral")) {
                carrierIdentificationVerifyActivity.setResult(1000, intent);
            }
        } else if (str.equals("errorVerify")) {
            intent.putExtra("errorMessage", str2);
            carrierIdentificationVerifyActivity.setResult(1002, intent);
        }
        carrierIdentificationVerifyActivity.finish();
    }

    public static final /* synthetic */ void access$showInvalidNumberDialog(final CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity) {
        LoginInfoDialog.Builder builder = new LoginInfoDialog.Builder(carrierIdentificationVerifyActivity);
        builder.initRecordTimeStamp = carrierIdentificationVerifyActivity.getString(R.string.invalid_number_dialog_title);
        builder.PlaceComponentResult = carrierIdentificationVerifyActivity.getString(R.string.invalid_number_dialog_description);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = DialogType.FAILED;
        builder.MyBillsEntityDataFactory = false;
        String string = carrierIdentificationVerifyActivity.getString(R.string.try_again);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String upperCase = string.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CarrierIdentificationVerifyActivity.$r8$lambda$HSmLgUm2CZgOnWJbCVBvhyhBVMM(CarrierIdentificationVerifyActivity.this, view);
            }
        };
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = upperCase;
        builder.moveToNextValue = onClickListener;
        builder.BuiltInFictitiousFunctionClassFactory();
        builder.MyBillsEntityDataFactory();
        new LoginInfoDialog(builder.KClassImpl$Data$declaredNonStaticMembers$2, builder.getAuthRequestContext, builder.NetworkUserEntityData$$ExternalSyntheticLambda1, builder, (byte) 0).MyBillsEntityDataFactory();
    }

    public static final /* synthetic */ void access$successVerifyCarrierIdentification(CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity) {
        carrierIdentificationVerifyActivity.setResult(-1);
        carrierIdentificationVerifyActivity.finish();
    }

    static /* synthetic */ void proceedLogout$default(CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity, View view, int i, Object obj) {
        if ((i & 1) != 0) {
            view = null;
        }
        if (view != null) {
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(view);
        }
        carrierIdentificationVerifyActivity.finish();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        DaggerCarrierIdentificationVerifyComponent.Builder MyBillsEntityDataFactory = DaggerCarrierIdentificationVerifyComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        MyBillsEntityDataFactory.PlaceComponentResult = (LogoutModule) Preconditions.getAuthRequestContext(new LogoutModule(new LogoutContract.View() { // from class: id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyActivity$getLogoutModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.challenge.pin.LogoutContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity = CarrierIdentificationVerifyActivity.this;
                LoadingDialog loadingDialog = new LoadingDialog(carrierIdentificationVerifyActivity);
                if (!loadingDialog.BuiltInFictitiousFunctionClassFactory.isShowing()) {
                    try {
                        loadingDialog.BuiltInFictitiousFunctionClassFactory.show();
                    } catch (Exception unused) {
                    }
                }
                carrierIdentificationVerifyActivity.BuiltInFictitiousFunctionClassFactory = loadingDialog;
            }

            @Override // id.dana.challenge.pin.LogoutContract.View
            public final void MyBillsEntityDataFactory() {
                LoadingDialog loadingDialog;
                loadingDialog = CarrierIdentificationVerifyActivity.this.BuiltInFictitiousFunctionClassFactory;
                if (loadingDialog != null) {
                    loadingDialog.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }

            @Override // id.dana.challenge.pin.LogoutContract.View
            public final void PlaceComponentResult() {
                DeepLinkParser.getAuthRequestContext();
                OnboardingActivity.Companion companion = OnboardingActivity.INSTANCE;
                OnboardingActivity.Companion.MyBillsEntityDataFactory((Activity) CarrierIdentificationVerifyActivity.this);
            }
        }));
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (CarrierIdentificationVerifyModule) Preconditions.getAuthRequestContext(new CarrierIdentificationVerifyModule(new CarrierIdentificationVerifyActivity$getCarrierIdentificationVerifyModule$1(this)));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.PlaceComponentResult, LogoutModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, CarrierIdentificationVerifyModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerCarrierIdentificationVerifyComponent.CarrierIdentificationVerifyComponentImpl(MyBillsEntityDataFactory.PlaceComponentResult, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.MyBillsEntityDataFactory, (byte) 0).getAuthRequestContext(this);
        registerPresenter(getLogoutPresenter());
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.MyBillsEntityDataFactory = extras;
            LoginResponse loginResponse = (LoginResponse) extras.getParcelable(ChallengePinWithFaceActivity.LOGIN_RESPONSE);
            if (loginResponse == null) {
                loginResponse = new LoginResponse(null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, 65535, null);
            }
            this.getErrorConfigVersion = loginResponse;
            if (loginResponse == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                loginResponse = null;
            }
            this.scheduleImpl = loginResponse.getPin();
            LoginResponse loginResponse2 = this.getErrorConfigVersion;
            if (loginResponse2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                loginResponse2 = null;
            }
            this.getAuthRequestContext = loginResponse2.getKey();
            final String string = extras.getString(ChallengeControl.Key.SCENARIO, "login");
            Intrinsics.checkNotNullExpressionValue(string, "");
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = string;
            if (string == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                string = null;
            }
            TextView textView = this.leftButton;
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyActivity$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CarrierIdentificationVerifyActivity.$r8$lambda$6ttPK6Fnnw5fvf8gForLOrbnJ38(CarrierIdentificationVerifyActivity.this, view);
                    }
                });
            }
            getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CarrierIdentificationVerifyActivity.$r8$lambda$Pitzp_kAE716mtRz0fOHe3gBdsY(CarrierIdentificationVerifyActivity.this, string, view);
                }
            });
            ArrayList<String> stringArrayList = extras.getStringArrayList(ChallengePinWithFaceActivity.CHALLENGE_METHOD_LIST);
            if (stringArrayList == null) {
                stringArrayList = CollectionsKt.emptyList();
            }
            this.PlaceComponentResult = stringArrayList;
            if (BuiltInFictitiousFunctionClassFactory(stringArrayList)) {
                List<String> mutableList = CollectionsKt.toMutableList((Collection) stringArrayList);
                mutableList.remove(0);
                this.PlaceComponentResult = mutableList;
            }
            ArrayList parcelableArrayList = extras.getParcelableArrayList(ChallengePinWithFaceActivity.LOGIN_AUTHENTICATION_OPTIONS);
            if (parcelableArrayList == null) {
                parcelableArrayList = CollectionsKt.emptyList();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = parcelableArrayList;
            if (MyBillsEntityDataFactory(parcelableArrayList)) {
                List<? extends LoginAuthenticationOptionResponse> mutableList2 = CollectionsKt.toMutableList((Collection) parcelableArrayList);
                mutableList2.remove(0);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = mutableList2;
            }
            String string2 = extras.getString(ChallengeControl.Key.PHONE_NUMBER, "");
            this.lookAheadTest = string2;
            this.moveToNextValue = new VerifyNumberTextWatcher(getBinding().getAuthRequestContext.getInput(), this, false, null, 8, null);
            InputPhoneView inputPhoneView = getBinding().getAuthRequestContext;
            inputPhoneView.setEnabled(false);
            inputPhoneView.setPrefix(getString(R.string.id_prefix));
            inputPhoneView.getInput().addTextChangedListener(this.moveToNextValue);
            inputPhoneView.setInput(string2 != null ? new Regex("62").replaceFirst(string2, "") : null);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = extras.getString(ChallengeControl.Key.SECURITY_ID, "");
        }
        getBinding().getAuthRequestContext.setEditable(false);
        MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        Intrinsics.checkNotNullParameter(findViewById, "");
        FirstDrawListener.Companion companion = FirstDrawListener.INSTANCE;
        FirstDrawListener.Companion.MyBillsEntityDataFactory(findViewById, new MeasureLoadAndRenderingScreen$stopTracking$1(measureLoadAndRenderingScreen));
        DanaApplication danaApplication = getDanaApplication();
        if (danaApplication != null) {
            danaApplication.chckTmprdApp();
        }
    }

    private static void a(int[] iArr, int i, byte[] bArr, char[] cArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = NetworkUserEntityData$$ExternalSyntheticLambda5;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        int i3 = (int) (4571606982258105150L ^ NetworkUserEntityData$$ExternalSyntheticLambda6);
        if (NetworkUserEntityData$$ExternalSyntheticLambda3) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr4);
        } else if (NetworkUserEntityData$$ExternalSyntheticLambda4) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr5);
        } else {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr6);
        }
    }
}
