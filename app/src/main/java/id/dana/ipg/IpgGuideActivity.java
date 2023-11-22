package id.dana.ipg;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import butterknife.OnClick;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.plus.android.push.fcm.UtdidDeviceIdProvider;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseActivity;
import id.dana.contract.deeplink.path.IpgRegistrationPayLoadMapper;
import id.dana.contract.deeplink.path.IpgRegistrationPayload;
import id.dana.danah5.DanaH5;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerIpgComponent;
import id.dana.di.modules.IpgModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.ipg.IpgRegistrationUrl;
import id.dana.extension.ContextExtKt;
import id.dana.ipg.IpgGuideContract;
import id.dana.ipg.constant.IpgConstant;
import id.dana.ipg.tncagreement.IpgTermsAndConditionActivity;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.RandomInteger;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b/\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001c\u0010\u0004J\r\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u001eR\u0014\u0010!\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0018\u0010\u000f\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b-\u0010."}, d2 = {"Lid/dana/ipg/IpgGuideActivity;", "Lid/dana/base/BaseActivity;", "", "agreeRegisterIpg", "()V", "configToolbar", "dismissDanaLoadingDialog", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "p0", "Landroid/content/Intent;", "p1", "", "PlaceComponentResult", "(ILandroid/content/Intent;)Z", RequestPermission.REQUEST_CODE, "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onPause", "BuiltInFictitiousFunctionClassFactory", "refuseRegisterIpg", "showDanaLoadingDialog", "(Z)V", "scheduleImpl", "I", "MyBillsEntityDataFactory", "Lid/dana/dialog/DanaLoadingDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/dialog/DanaLoadingDialog;", "Lid/dana/ipg/IpgGuideContract$Presenter;", "ipgPresenter", "Lid/dana/ipg/IpgGuideContract$Presenter;", "getIpgPresenter", "()Lid/dana/ipg/IpgGuideContract$Presenter;", "setIpgPresenter", "(Lid/dana/ipg/IpgGuideContract$Presenter;)V", "Lid/dana/domain/ipg/IpgRegistrationUrl;", "lookAheadTest", "Lid/dana/domain/ipg/IpgRegistrationUrl;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IpgGuideActivity extends BaseActivity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static boolean DatabaseTableConfigUtil = false;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
    public static final String PAYLOAD_INTENT_KEY = "ipg_payload_intent_key";
    private static char[] getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private DanaLoadingDialog BuiltInFictitiousFunctionClassFactory;
    @Inject
    public IpgGuideContract.Presenter ipgPresenter;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private IpgRegistrationUrl PlaceComponentResult;
    public static final byte[] $$a = {104, -34, -42, -1, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 216;
    public static final byte[] PlaceComponentResult = {95, 85, -94, TarHeader.LF_SYMLINK, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 100;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final int MyBillsEntityDataFactory = RandomInteger.BuiltInFictitiousFunctionClassFactory();

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.ipg.IpgGuideActivity.PlaceComponentResult
            int r8 = r8 + 4
            int r7 = r7 + 97
            int r6 = r6 + 16
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
            goto L31
        L17:
            r3 = 0
        L18:
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
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L31:
            int r8 = r8 + r6
            int r6 = r8 + (-4)
            int r8 = r9 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.ipg.IpgGuideActivity.b(byte, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = 47 - r6
            int r7 = r7 * 2
            int r7 = 103 - r7
            int r8 = r8 * 3
            int r8 = 42 - r8
            byte[] r0 = id.dana.ipg.IpgGuideActivity.$$a
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
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
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L32:
            int r8 = r8 + r7
            int r7 = r8 + (-7)
            int r6 = r6 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.ipg.IpgGuideActivity.c(byte, int, byte, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        getErrorConfigVersion = new char[]{39926, 39915, 39925, 39911, 39912, 39918, 39851, 39908, 39817, 39924, 39922, 39914, 39902, 39810, 39913, 39830, 39909, 39907, 39813, 39921, 39906, 39917, 39840, 39843, 39841, 39849, 39838, 39923, 39847, 39846, 39844, 39845, 39927, 39842, 39839, 39848, 39920, 39910};
        DatabaseTableConfigUtil = true;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = 909155161;
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(null, 126 - TextUtils.indexOf((CharSequence) "", '0'), new byte[]{-120, -120, -117, -118, -123, -124, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(null, MotionEvent.axisFromString("") + 128, new byte[]{-125, -122, -114, -115, -116}, null, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 35, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(null, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 127, new byte[]{-117, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -117, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -117, -100, -118, -117, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(null, 127 - View.MeasureSpec.getMode(0), new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -117, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -117, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(null, 127 - ((Process.getThreadPriority(0) + 20) >> 6), new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -117, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -117, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -117, -98, -99}, null, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(null, (KeyEvent.getMaxKeyCode() >> 16) + 127, new byte[]{-120, -111, -126, -117, -110, -117, -92, -99, -110, -92, -111, -120, -117, -91, -126, -122, -92, -122, -113, -127, -92, -116, -123, -118, -121, -117, -124, -127, -107, -90, -120, -125, -124, -127, -107, -91, -121, -111, -120, -127, -118, -111, -127, -117, -124, -108, -111, -121, -127, -126, -127, -125, -92, -92, -93, -120, -113, -111, -111, -108}, null, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(null, 127 - View.resolveSize(0, 0), new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0'), 18 - Color.red(0), (char) Color.alpha(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr12);
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
                Object[] objArr13 = new Object[1];
                b(PlaceComponentResult[25], PlaceComponentResult[32], (short) 37, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = PlaceComponentResult[25];
                Object[] objArr14 = new Object[1];
                b(b, (byte) (b | 8), PlaceComponentResult[35], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getLongPressTimeout() >> 16) + 3, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1));
                        Object[] objArr16 = new Object[1];
                        c($$a[53], $$a[12], $$a[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getTapTimeout() >> 16), 14 - TextUtils.lastIndexOf("", '0'), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - KeyEvent.normalizeMetaState(0), TextUtils.lastIndexOf("", '0') + 16, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 814, 30 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (57995 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 15 - (ViewConfiguration.getTouchSlop() >> 8), (char) (ViewConfiguration.getWindowTouchSlop() >> 8)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r7 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.normalizeMetaState(0), (ViewConfiguration.getJumpTapTimeout() >> 16) + 35, (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1564313299, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", ""), 19 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr18);
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
                Object[] objArr19 = new Object[1];
                b(PlaceComponentResult[25], PlaceComponentResult[32], (short) 37, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr20 = new Object[1];
                b(b2, (byte) (b2 | 8), PlaceComponentResult[35], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 62, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 46, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                        Object[] objArr22 = new Object[1];
                        c($$a[84], (byte) ($$a[78] - 1), $$a[8], objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), View.resolveSize(0, 0) + 35, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {1564313299, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.makeMeasureSpec(0, 0), 18 - (Process.myTid() >> 22), (char) KeyEvent.keyCodeFromString(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr24);
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
                Object[] objArr25 = new Object[1];
                b(PlaceComponentResult[25], PlaceComponentResult[32], (short) 37, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b3 = PlaceComponentResult[25];
                Object[] objArr26 = new Object[1];
                b(b3, (byte) (b3 | 8), PlaceComponentResult[35], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 117, 4 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (38969 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))));
                        Object[] objArr28 = new Object[1];
                        c($$a[84], (byte) ($$a[78] - 1), $$a[8], objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.MeasureSpec.getMode(0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1564313299, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.keyCodeFromString(""), 17 - TextUtils.lastIndexOf("", '0'), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr30);
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
                Object[] objArr31 = new Object[1];
                b(PlaceComponentResult[25], PlaceComponentResult[32], (short) 37, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b4 = PlaceComponentResult[25];
                Object[] objArr32 = new Object[1];
                b(b4, (byte) (b4 | 8), PlaceComponentResult[35], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 107, 4 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) ExpandableListView.getPackedPositionGroup(0L));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[9], (byte) ($$a[78] - 1), objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.indexOf("", "", 0), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {1564313299, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTapTimeout() >> 16), 17 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr36);
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

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_ipg;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(null, super.getResources().getString(R.string.bottom_on_boarding_title_split_bill).substring(5, 6).length() + 126, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(null, super.getResources().getString(R.string.card_binding_save_card_dialog_oneklik_desc).substring(92, 94).codePointAt(0) + 19, new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776287) - Color.rgb(0, 0, 0), 35 - TextUtils.getCapsMode("", 0, 0), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 911, TextUtils.lastIndexOf("", '0', 0, 0) + 19, (char) TextUtils.indexOf("", ""))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getIpgPresenter")
    public final IpgGuideContract.Presenter getIpgPresenter() {
        IpgGuideContract.Presenter presenter = this.ipgPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setIpgPresenter")
    public final void setIpgPresenter(IpgGuideContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.ipgPresenter = presenter;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(null, 127 - View.resolveSizeAndState(0, 0, 0), new byte[]{-120, -120, -117, -118, -123, -124, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(null, 127 - (ViewConfiguration.getEdgeSlop() >> 16), new byte[]{-125, -122, -114, -115, -116}, null, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(null, getPackageName().codePointAt(2) + 81, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a(null, super.getResources().getString(R.string.pin_incorrect_lock_desc).substring(37, 38).codePointAt(0) + 95, new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTouchSlop() >> 8), 34 - MotionEvent.axisFromString(""), (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a(null, View.MeasureSpec.getMode(0) + 127, new byte[]{-117, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -117, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -117, -100, -118, -117, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr6);
                    String str = (String) objArr6[0];
                    try {
                        byte b = (byte) (-PlaceComponentResult[30]);
                        byte b2 = PlaceComponentResult[25];
                        Object[] objArr7 = new Object[1];
                        b(b, b2, b2, objArr7);
                        Class<?> cls3 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        b(PlaceComponentResult[56], (byte) (-PlaceComponentResult[5]), (byte) (PlaceComponentResult[59] + 1), objArr8);
                        Object[] objArr9 = new Object[1];
                        a(null, ((ApplicationInfo) cls3.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -117, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -117, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr9);
                        String str2 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a(null, 127 - KeyEvent.normalizeMetaState(0), new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -117, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -117, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -117, -98, -99}, null, objArr10);
                        String str3 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(null, 127 - KeyEvent.getDeadChar(0, 0), new byte[]{-120, -111, -126, -117, -110, -117, -92, -99, -110, -92, -111, -120, -117, -91, -126, -122, -92, -122, -113, -127, -92, -116, -123, -118, -121, -117, -124, -127, -107, -90, -120, -125, -124, -127, -107, -91, -121, -111, -120, -127, -118, -111, -127, -117, -124, -108, -111, -121, -127, -126, -127, -125, -92, -92, -93, -120, -113, -111, -111, -108}, null, objArr11);
                        String str4 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        a(null, (KeyEvent.getMaxKeyCode() >> 16) + 127, new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr12);
                        try {
                            Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 911, 18 - ExpandableListView.getPackedPositionGroup(0L), (char) TextUtils.getOffsetBefore("", 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr13);
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
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            }
        }
        try {
            Object[] objArr14 = new Object[1];
            b(PlaceComponentResult[25], PlaceComponentResult[32], (short) 37, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            byte b3 = PlaceComponentResult[25];
            Object[] objArr15 = new Object[1];
            b(b3, (byte) (b3 | 8), PlaceComponentResult[35], objArr15);
            try {
                Object[] objArr16 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 494, 4 - ExpandableListView.getPackedPositionType(0L), (char) Gravity.getAbsoluteGravity(0, 0));
                    Object[] objArr17 = new Object[1];
                    c((byte) ($$a[78] - 1), $$a[9], (byte) ($$a[78] - 1), objArr17);
                    obj3 = cls5.getMethod((String) objArr17[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                int i = ((int[]) objArr18[1])[0];
                if (((int[]) objArr18[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.combineMeasuredStates(0, 0), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr19 = {-999202008, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTapTimeout() >> 16), 18 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr19);
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
                overridePendingTransition(0, 0);
                super.onCreate(savedInstanceState);
                ContextExtKt.PlaceComponentResult(this);
                FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.res_0x7f0a10ca_groupdetailactivity_initdeletegroupdialog_1);
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
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
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(null, TextUtils.getCapsMode("", 0, 0) + 127, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(null, 128 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.blue(0), 35 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 912, 17 - MotionEvent.axisFromString(""), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        overridePendingTransition(0, 0);
        super.onPause();
    }

    @OnClick({R.id.btn_refuse})
    public final void refuseRegisterIpg() {
        PlaceComponentResult(false);
        finish();
    }

    @OnClick({R.id.btn_agree})
    public final void agreeRegisterIpg() {
        PlaceComponentResult(true);
        BuiltInFictitiousFunctionClassFactory();
    }

    private final void PlaceComponentResult(boolean p0) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(this);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.HOME_POP_UP_ACTION;
        EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.IS_CONFIRM, p0);
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(BuiltInFictitiousFunctionClassFactory, (byte) 0));
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        String redirectUrl;
        IpgRegistrationPayload builtInFictitiousFunctionClassFactory = getIpgPresenter().getBuiltInFictitiousFunctionClassFactory();
        IpgGuideContract.Presenter ipgPresenter = getIpgPresenter();
        String userConsentConfigKey = builtInFictitiousFunctionClassFactory != null ? builtInFictitiousFunctionClassFactory.getUserConsentConfigKey() : null;
        if (userConsentConfigKey == null) {
            userConsentConfigKey = "";
        }
        String userConsentSyncKey = builtInFictitiousFunctionClassFactory != null ? builtInFictitiousFunctionClassFactory.getUserConsentSyncKey() : null;
        ipgPresenter.getAuthRequestContext(userConsentConfigKey, userConsentSyncKey != null ? userConsentSyncKey : "");
        IpgRegistrationUrl ipgRegistrationUrl = this.PlaceComponentResult;
        if (ipgRegistrationUrl == null || (redirectUrl = ipgRegistrationUrl.getRedirectUrl()) == null) {
            return;
        }
        DanaH5.startContainerFullUrl(redirectUrl);
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (PlaceComponentResult(requestCode, data)) {
            BuiltInFictitiousFunctionClassFactory();
        }
    }

    public final void showDanaLoadingDialog() {
        DanaLoadingDialog danaLoadingDialog = new DanaLoadingDialog(this);
        this.BuiltInFictitiousFunctionClassFactory = danaLoadingDialog;
        if (danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
            return;
        }
        danaLoadingDialog.MyBillsEntityDataFactory.show();
        danaLoadingDialog.getAuthRequestContext.startRefresh();
    }

    public final void dismissDanaLoadingDialog() {
        DanaLoadingDialog danaLoadingDialog = this.BuiltInFictitiousFunctionClassFactory;
        if (danaLoadingDialog != null) {
            danaLoadingDialog.PlaceComponentResult();
        }
    }

    private final boolean PlaceComponentResult(int p0, Intent p1) {
        return p1 != null && this.MyBillsEntityDataFactory == p0 && p1.getBooleanExtra(IpgTermsAndConditionActivity.IPG_TNC_ACTION_RESULT, false);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/ipg/IpgGuideActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "", "p1", "", "PlaceComponentResult", "(Landroid/content/Context;Ljava/util/Map;)Z", "PAYLOAD_INTENT_KEY", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static boolean PlaceComponentResult(Context p0, Map<String, String> p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            IpgRegistrationPayLoadMapper.Companion companion = IpgRegistrationPayLoadMapper.INSTANCE;
            IpgRegistrationPayload PlaceComponentResult = IpgRegistrationPayLoadMapper.Companion.PlaceComponentResult(p1);
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(PlaceComponentResult, "");
            Intent putExtra = new Intent(p0, IpgGuideActivity.class).putExtra(IpgGuideActivity.PAYLOAD_INTENT_KEY, PlaceComponentResult);
            Intrinsics.checkNotNullExpressionValue(putExtra, "");
            ContextCompat.MyBillsEntityDataFactory(p0, putExtra, null);
            return true;
        }
    }

    public static final /* synthetic */ void access$goTermsAndConditionsActivity(IpgGuideActivity ipgGuideActivity) {
        IpgRegistrationPayload builtInFictitiousFunctionClassFactory = ipgGuideActivity.getIpgPresenter().getBuiltInFictitiousFunctionClassFactory();
        if (builtInFictitiousFunctionClassFactory != null) {
            IpgTermsAndConditionActivity.Companion companion = IpgTermsAndConditionActivity.INSTANCE;
            ipgGuideActivity.startActivityForResult(IpgTermsAndConditionActivity.Companion.getAuthRequestContext(ipgGuideActivity, builtInFictitiousFunctionClassFactory.getTncUrl()), ipgGuideActivity.MyBillsEntityDataFactory);
        }
    }

    public static final /* synthetic */ void access$onCheckHasAgreedBefore(IpgGuideActivity ipgGuideActivity, boolean z) {
        String bizType;
        String redirectUrl;
        if (z) {
            IpgRegistrationUrl ipgRegistrationUrl = ipgGuideActivity.PlaceComponentResult;
            if (ipgRegistrationUrl == null || (redirectUrl = ipgRegistrationUrl.getRedirectUrl()) == null) {
                return;
            }
            DanaH5.startContainerFullUrl(redirectUrl);
            ipgGuideActivity.finish();
            return;
        }
        FrameLayout frameLayout = (FrameLayout) ipgGuideActivity._$_findCachedViewById(R.id.res_0x7f0a10ca_groupdetailactivity_initdeletegroupdialog_1);
        byte b = 0;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        Object[] objArr = new Object[1];
        IpgRegistrationPayload builtInFictitiousFunctionClassFactory = ipgGuideActivity.getIpgPresenter().getBuiltInFictitiousFunctionClassFactory();
        objArr[0] = (builtInFictitiousFunctionClassFactory == null || (bizType = builtInFictitiousFunctionClassFactory.getBizType()) == null) ? null : StringsKt.capitalize(bizType);
        String string = ipgGuideActivity.getString(R.string.purpose_property_mixpanel, objArr);
        Intrinsics.checkNotNullExpressionValue(string, "");
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(ipgGuideActivity);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.HOME_POP_UP_OPEN;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Purpose", string);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, b));
    }

    public static final /* synthetic */ void access$onSuccessGetRedirectUrl(IpgGuideActivity ipgGuideActivity, IpgRegistrationUrl ipgRegistrationUrl) {
        String userConsentSyncKey;
        ipgGuideActivity.PlaceComponentResult = ipgRegistrationUrl;
        if (ipgRegistrationUrl == null || ((TextView) ipgGuideActivity._$_findCachedViewById(R.id.tv_shopping_merchant_title)) == null) {
            return;
        }
        IpgRegistrationPayload builtInFictitiousFunctionClassFactory = ipgGuideActivity.getIpgPresenter().getBuiltInFictitiousFunctionClassFactory();
        if (ipgRegistrationUrl != null && (userConsentSyncKey = ipgRegistrationUrl.getUserConsentSyncKey()) != null) {
            String str = userConsentSyncKey;
            if (!(str.length() == 0)) {
                ((TextView) ipgGuideActivity._$_findCachedViewById(R.id.tv_shopping_merchant_title)).setText(str);
            }
        }
        IpgGuideContract.Presenter ipgPresenter = ipgGuideActivity.getIpgPresenter();
        String userConsentConfigKey = builtInFictitiousFunctionClassFactory != null ? builtInFictitiousFunctionClassFactory.getUserConsentConfigKey() : null;
        if (userConsentConfigKey == null) {
            userConsentConfigKey = "";
        }
        ipgPresenter.BuiltInFictitiousFunctionClassFactory(userConsentConfigKey);
    }

    public static final /* synthetic */ void access$showWarningDialogForFailGetRedirectUrl(IpgGuideActivity ipgGuideActivity) {
        Toast.makeText(ipgGuideActivity, ipgGuideActivity.getString(R.string.general_error_msg), 0).show();
        ipgGuideActivity.finish();
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        String enTitle;
        DaggerIpgComponent.Builder authRequestContext = DaggerIpgComponent.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        authRequestContext.BuiltInFictitiousFunctionClassFactory = (IpgModule) Preconditions.getAuthRequestContext(new IpgModule(new IpgGuideContract.View() { // from class: id.dana.ipg.IpgGuideActivity$initComponent$component$1
            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.ipg.IpgGuideContract.View
            public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
                IpgGuideActivity.access$onCheckHasAgreedBefore(IpgGuideActivity.this, p0);
            }

            @Override // id.dana.ipg.IpgGuideContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(IpgRegistrationUrl p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                IpgGuideActivity.access$onSuccessGetRedirectUrl(IpgGuideActivity.this, p0);
            }

            @Override // id.dana.ipg.IpgGuideContract.View
            public final void PlaceComponentResult() {
                IpgGuideActivity.access$showWarningDialogForFailGetRedirectUrl(IpgGuideActivity.this);
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                IpgGuideActivity.this.showDanaLoadingDialog();
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                IpgGuideActivity.this.dismissDanaLoadingDialog();
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.BuiltInFictitiousFunctionClassFactory, IpgModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerIpgComponent.IpgComponentImpl(authRequestContext.BuiltInFictitiousFunctionClassFactory, authRequestContext.MyBillsEntityDataFactory, (byte) 0).getAuthRequestContext(this);
        if (getIntent() != null) {
            IpgGuideContract.Presenter ipgPresenter = getIpgPresenter();
            Serializable serializableExtra = getIntent().getSerializableExtra(PAYLOAD_INTENT_KEY);
            if (serializableExtra != null) {
                ipgPresenter.PlaceComponentResult((IpgRegistrationPayload) serializableExtra);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.contract.deeplink.path.IpgRegistrationPayload");
            }
        } else {
            Toast.makeText(this, getString(R.string.general_error_msg), 0).show();
        }
        IpgRegistrationPayload builtInFictitiousFunctionClassFactory = getIpgPresenter().getBuiltInFictitiousFunctionClassFactory();
        if (builtInFictitiousFunctionClassFactory != null) {
            if (builtInFictitiousFunctionClassFactory.getBizType().length() == 0) {
                Toast.makeText(this, getString(R.string.general_error_msg), 0).show();
                finish();
            }
        }
        IpgRegistrationPayload builtInFictitiousFunctionClassFactory2 = getIpgPresenter().getBuiltInFictitiousFunctionClassFactory();
        if (builtInFictitiousFunctionClassFactory2 != null) {
            if (builtInFictitiousFunctionClassFactory2.getIdTitle().length() == 0) {
                String string = getString(R.string.id_title_default_value, builtInFictitiousFunctionClassFactory2.getBizType());
                Intrinsics.checkNotNullExpressionValue(string, "");
                builtInFictitiousFunctionClassFactory2.setIdTitle(string);
            }
            if (builtInFictitiousFunctionClassFactory2.getEnTitle().length() == 0) {
                String string2 = getString(R.string.id_title_default_value, builtInFictitiousFunctionClassFactory2.getBizType());
                Intrinsics.checkNotNullExpressionValue(string2, "");
                builtInFictitiousFunctionClassFactory2.setEnTitle(string2);
            }
            if (builtInFictitiousFunctionClassFactory2.getTncUrl().length() == 0) {
                String string3 = getString(R.string.tnc_url_default_value, builtInFictitiousFunctionClassFactory2.getBizType());
                Intrinsics.checkNotNullExpressionValue(string3, "");
                builtInFictitiousFunctionClassFactory2.setTncUrl(string3);
            }
            if (builtInFictitiousFunctionClassFactory2.getUserConsentConfigKey().length() == 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                IpgConstant ipgConstant = IpgConstant.INSTANCE;
                String format = String.format(IpgConstant.PlaceComponentResult(), Arrays.copyOf(new Object[]{builtInFictitiousFunctionClassFactory2.getBizType()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "");
                builtInFictitiousFunctionClassFactory2.setUserConsentConfigKey(format);
            }
            if (builtInFictitiousFunctionClassFactory2.getUserConsentSyncKey().length() == 0) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                IpgConstant ipgConstant2 = IpgConstant.INSTANCE;
                String format2 = String.format(IpgConstant.BuiltInFictitiousFunctionClassFactory(), Arrays.copyOf(new Object[]{builtInFictitiousFunctionClassFactory2.getBizType()}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "");
                builtInFictitiousFunctionClassFactory2.setUserConsentSyncKey(format2);
            }
            getIpgPresenter().PlaceComponentResult(builtInFictitiousFunctionClassFactory2);
        }
        String string4 = getString(R.string.ipg_desc);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        String string5 = getString(R.string.ipg_desc_item_click);
        Intrinsics.checkNotNullExpressionValue(string5, "");
        String str = string4;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, string5, 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            ClickableSpan clickableSpan = new ClickableSpan() { // from class: id.dana.ipg.IpgGuideActivity$createNoUnderLineClickableSpan$1
                @Override // android.text.style.ClickableSpan
                public final void onClick(View p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    IpgGuideActivity.access$goTermsAndConditionsActivity(IpgGuideActivity.this);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(TextPaint p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    p0.setUnderlineText(false);
                }
            };
            SpannableString spannableString = new SpannableString(str);
            TextView textView = (TextView) _$_findCachedViewById(R.id.MissingMainCoroutineDispatcher);
            spannableString.setSpan(clickableSpan, indexOf$default, string5.length() + indexOf$default, 33);
            spannableString.setSpan(new ForegroundColorSpan(-15692055), indexOf$default, string5.length() + indexOf$default, 33);
            spannableString.setSpan(new StyleSpan(1), indexOf$default, string5.length() + indexOf$default, 33);
            textView.setText(spannableString);
            ((TextView) _$_findCachedViewById(R.id.MissingMainCoroutineDispatcher)).setMovementMethod(LinkMovementMethod.getInstance());
        }
        IpgRegistrationPayload builtInFictitiousFunctionClassFactory3 = getIpgPresenter().getBuiltInFictitiousFunctionClassFactory();
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_shopping_merchant_title);
        if (Intrinsics.areEqual(getResources().getConfiguration().locale.getLanguage(), "in")) {
            if (builtInFictitiousFunctionClassFactory3 != null) {
                enTitle = builtInFictitiousFunctionClassFactory3.getIdTitle();
            }
            enTitle = null;
        } else {
            if (builtInFictitiousFunctionClassFactory3 != null) {
                enTitle = builtInFictitiousFunctionClassFactory3.getEnTitle();
            }
            enTitle = null;
        }
        textView2.setText(enTitle);
        IpgRegistrationPayload builtInFictitiousFunctionClassFactory4 = getIpgPresenter().getBuiltInFictitiousFunctionClassFactory();
        RequestOptions BuiltInFictitiousFunctionClassFactory = new RequestOptions().KClassImpl$Data$declaredNonStaticMembers$2((int) getResources().getDimension(R.dimen.f28572131165365)).MyBillsEntityDataFactory(R.drawable.white_circle).BuiltInFictitiousFunctionClassFactory(R.drawable.white_circle);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        Glide.getAuthRequestContext((FragmentActivity) this).getAuthRequestContext(builtInFictitiousFunctionClassFactory4 != null ? builtInFictitiousFunctionClassFactory4.getLogo() : null).MyBillsEntityDataFactory((BaseRequestOptions<?>) BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory((ImageView) _$_findCachedViewById(R.id.iv_shopping_merchant));
        IpgRegistrationPayload builtInFictitiousFunctionClassFactory5 = getIpgPresenter().getBuiltInFictitiousFunctionClassFactory();
        if (builtInFictitiousFunctionClassFactory5 != null) {
            IpgGuideContract.Presenter ipgPresenter2 = getIpgPresenter();
            String deviceId = UtdidDeviceIdProvider.getDeviceId(getApplication());
            Intrinsics.checkNotNullExpressionValue(deviceId, "");
            ipgPresenter2.MyBillsEntityDataFactory(deviceId, builtInFictitiousFunctionClassFactory5.getBizType());
        }
    }

    private static void a(int[] iArr, int i, byte[] bArr, char[] cArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = getErrorConfigVersion;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        int i3 = (int) (4571606982258105150L ^ NetworkUserEntityData$$ExternalSyntheticLambda2);
        if (NetworkUserEntityData$$ExternalSyntheticLambda1) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr4);
        } else if (DatabaseTableConfigUtil) {
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
