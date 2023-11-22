package id.dana.oauth.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.iap.android.wallet.acl.WalletServiceManager;
import com.alipay.iap.android.wallet.acl.base.BaseService;
import com.alipay.iap.android.wallet.acl.oauth.OAuthResult;
import com.alipay.iap.android.wallet.acl.oauth.OAuthService;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.component.customsnackbarcomponent.CustomSnackbar;
import id.dana.component.edittextcomponent.DanaEditTextView;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerInputNameComponent;
import id.dana.di.modules.InputNameModule;
import id.dana.miniprogram.provider.OauthServiceProvider;
import id.dana.oauth.InputNameContract;
import id.dana.oauth.OauthLoginManager;
import id.dana.oauth.activity.OauthGrantActivity;
import id.dana.oauth.model.OauthParamsModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.LogoProgressView;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.ErrorUtil;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0007¢\u0006\u0004\b1\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0016\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0016\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0012J\u000f\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u001d\u0010\u001a\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001c\u0010\u0005J\u0019\u0010\u001e\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\"J\u000f\u0010#\u001a\u00020\u0003H\u0016¢\u0006\u0004\b#\u0010\u0005J\u001f\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0011\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010+\u001a\u00020*8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100"}, d2 = {"Lid/dana/oauth/activity/InputNameActivity;", "Lid/dana/base/BaseActivity;", "Lid/dana/oauth/InputNameContract$View;", "", "configToolbar", "()V", "dismissProgress", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "getLayout", "()I", "PlaceComponentResult", IAPSyncCommand.COMMAND_INIT, "BuiltInFictitiousFunctionClassFactory", "()Z", "", "", "p0", "getAuthRequestContext", "(Ljava/util/Set;)Z", "onBackPressed", "merchantIdEnable", "onCheckSkipButtonMerchantList", "(Ljava/util/Set;)V", "onDestroy", "errorMessage", "onUpdateNameFailed", "(Ljava/lang/String;)V", TrackerKey.Property.IS_SUCCESS, "onUpdateNameSuccess", "(Z)V", "showProgress", "p1", "(ZLjava/lang/String;)V", "Lid/dana/oauth/model/OauthParamsModel;", "getErrorConfigVersion", "Lid/dana/oauth/model/OauthParamsModel;", "MyBillsEntityDataFactory", "Lid/dana/oauth/InputNameContract$Presenter;", "presenter", "Lid/dana/oauth/InputNameContract$Presenter;", "getPresenter", "()Lid/dana/oauth/InputNameContract$Presenter;", "setPresenter", "(Lid/dana/oauth/InputNameContract$Presenter;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InputNameActivity extends BaseActivity implements InputNameContract.View {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static char lookAheadTest;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private OauthParamsModel MyBillsEntityDataFactory;
    @Inject
    public InputNameContract.Presenter presenter;
    public static final byte[] $$a = {56, -119, 46, TarHeader.LF_CONTIG, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 154;
    public static final byte[] PlaceComponentResult = {11, Ascii.GS, 107, 8, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 173;

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        lookAheadTest = (char) 42066;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = new char[]{42065, 42064, 42070, 37308, 37283, 37306, 37279, 37280, 37311, 37262, 37293, 37282, 37274, 37345, 37372, 37288, 42077, 42071, 37371, 37368, 37289, 37275, 37309, 37344, 37370, 37287, 37375, 42067, 37369, 37286, 37291, 37366, 42068, 37307, 37373, 37367, 42076, 37281, 42078, 37305, 37294, 42066, 37292, 42079, 37310, 37290, 37302, 37374, 37365};
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 16
            byte[] r0 = id.dana.oauth.activity.InputNameActivity.PlaceComponentResult
            int r6 = r6 + 4
            int r8 = r8 + 97
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L13
            r4 = r8
            r3 = 0
            r8 = r7
            goto L28
        L13:
            r3 = 0
        L14:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L21:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r5
        L28:
            int r7 = r7 + r4
            int r6 = r6 + 1
            int r7 = r7 + (-4)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.InputNameActivity.a(byte, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = 46 - r7
            byte[] r0 = id.dana.oauth.activity.InputNameActivity.$$a
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r6 = r6 * 2
            int r6 = r6 + 75
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L37
        L1a:
            r3 = 0
        L1b:
            int r7 = r7 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L37:
            int r7 = r7 + r6
            int r6 = r7 + (-7)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.InputNameActivity.c(byte, short, byte, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final Intent createIntent(Context context, OauthParamsModel oauthParamsModel, boolean z) {
        return Companion.BuiltInFictitiousFunctionClassFactory(context, oauthParamsModel, z);
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
        b((byte) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 24), new char[]{')', Typography.amp, 29, 23, '\b', 28, Typography.quote, '\t', '\n', 0, 20, '\r', 21, '\b', '+', '.', 13825, 13825}, Color.argb(0, 0, 0, 0) + 18, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b((byte) (65 - Drawable.resolveOpacity(0, 0)), new char[]{18, 4, '\b', '!', 13887}, 5 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.argb(0, 0, 0, 0), 35 - (KeyEvent.getMaxKeyCode() >> 16), (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b((byte) (107 - TextUtils.indexOf((CharSequence) "", '0', 0)), new char[]{14, '/', '#', '*', 23, '!', 28, Typography.amp, 17, '/', '0', 14, '0', 31, '*', '!', 13847, 13847, '!', '#', 28, ',', 0, '#', 28, 16, '%', 28, 28, 31, Typography.amp, '/', InputCardNumberView.DIVIDER, 29, 28, InputCardNumberView.DIVIDER, 17, Typography.quote, '(', 21, 20, 14, 14, InputCardNumberView.DIVIDER, 7, 17, 31, '*'}, 48 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b((byte) (29 - TextUtils.getTrimmedLength("")), new char[]{Typography.amp, JSONLexer.EOI, 29, 31, 17, Typography.quote, 21, '(', 28, ',', Typography.amp, 31, '!', ',', '.', 19, 13765, 13765, 19, '0', '!', ',', '#', 21, 31, 7, Typography.amp, 3, '%', 28, 13765, 13765, ',', 28, 14, '\'', 13846, 13846, 21, 19, 25, 27, '.', '0', '/', 14, 5, JSONLexer.EOI, 13766, 13766, 17, '!', '!', 17, '!', 5, '!', 5, '-', 7, '*', '(', 28, 16}, ImageFormat.getBitsPerPixel(0) + 65, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b((byte) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 61), new char[]{'!', '0', 3, 17, '!', 17, InputCardNumberView.DIVIDER, 20, 13792, 13792, '(', '*', '*', 19, '!', JSONLexer.EOI, Typography.amp, '/', 16, InputCardNumberView.DIVIDER, 31, '\r', '#', 19, 20, 14, 28, Typography.amp, 13882, 13882, 14, '/', 16, '!', 28, ')', '\f', 17, '#', '*', ')', 14, '.', 19, '(', 21, Typography.amp, '\f', 17, Typography.quote, '+', '.', '!', '0', 17, 27, 17, JSONLexer.EOI, InputCardNumberView.DIVIDER, 29, 17, 27, 31, Typography.amp}, TextUtils.indexOf((CharSequence) "", '0', 0) + 65, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b((byte) (TextUtils.indexOf((CharSequence) "", '0', 0) + 31), new char[]{JSONLexer.EOI, InputCardNumberView.DIVIDER, 29, '\f', 6, '-', 13779, 13779, '!', '%', Typography.amp, ')', '\f', Typography.quote, JSONLexer.EOI, 23, '/', Typography.amp, 28, '/', Typography.amp, 5, Typography.quote, '\f', 19, 1, Typography.dollar, JSONLexer.EOI, 31, 2, '/', 2, Typography.dollar, JSONLexer.EOI, '0', '\n', 0, 14, '\t', 25, Typography.dollar, '\f', 30, 22, 30, Typography.dollar, 17, '+', 5, 31, 25, '%', 30, 27, '.', Typography.amp, ',', Typography.amp, 31, 5}, TextUtils.indexOf("", "") + 60, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b((byte) (84 - ExpandableListView.getPackedPositionChild(0L)), new char[]{Typography.quote, '\n', 20, 11, '!', '0'}, 6 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 910, 18 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a((byte) (getAuthRequestContext & 119), PlaceComponentResult[25], PlaceComponentResult[32], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(PlaceComponentResult[35], PlaceComponentResult[25], PlaceComponentResult[3], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 54, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 3, (char) (ViewConfiguration.getPressedStateDuration() >> 16));
                        Object[] objArr16 = new Object[1];
                        c($$a[78], $$a[53], $$a[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getTapTimeout() >> 16), 15 - TextUtils.indexOf("", ""), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - ((byte) KeyEvent.getModifierMetaStateMask()), 15 - TextUtils.getTrimmedLength(""), (char) Color.green(0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - ExpandableListView.getPackedPositionChild(0L), ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.RS, (char) (TextUtils.getOffsetBefore("", 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 800, Color.green(0) + 15, (char) Color.green(0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr4 = null;
                                        } else {
                                            objArr4 = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetAfter("", 0), TextUtils.indexOf("", "", 0, 0) + 35, (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr4, objArr4);
                                        try {
                                            Object[] objArr18 = {500108499, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 18 - View.MeasureSpec.getSize(0), (char) View.resolveSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (getAuthRequestContext & 119), PlaceComponentResult[25], PlaceComponentResult[32], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                a(PlaceComponentResult[35], PlaceComponentResult[25], PlaceComponentResult[3], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(60 - TextUtils.lastIndexOf("", '0'), 46 - TextUtils.indexOf("", "", 0), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16));
                        Object[] objArr22 = new Object[1];
                        c($$a[9], $$a[84], $$a[8], objArr22);
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
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Color.green(0), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr24 = {500108499, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 911, (ViewConfiguration.getJumpTapTimeout() >> 16) + 18, (char) View.resolveSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (getAuthRequestContext & 119), PlaceComponentResult[25], PlaceComponentResult[32], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                a(PlaceComponentResult[35], PlaceComponentResult[25], PlaceComponentResult[3], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getJumpTapTimeout() >> 16), 3 - View.getDefaultSize(0, 0), (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 38968));
                        Object[] objArr28 = new Object[1];
                        c($$a[9], $$a[84], $$a[8], objArr28);
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
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr30 = {500108499, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 18 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (getAuthRequestContext & 119), PlaceComponentResult[25], PlaceComponentResult[32], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                a(PlaceComponentResult[35], PlaceComponentResult[25], PlaceComponentResult[3], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 107, TextUtils.getCapsMode("", 0, 0) + 3, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))));
                        byte b = (byte) ($$a[78] - 1);
                        byte b2 = b;
                        Object[] objArr34 = new Object[1];
                        c(b, b2, b2, objArr34);
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
                                objArr = null;
                            } else {
                                objArr = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(977 - AndroidCharacter.getMirror('0'), 34 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr, objArr);
                            try {
                                Object[] objArr36 = {500108499, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (-16777198) - Color.rgb(0, 0, 0), (char) View.resolveSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_input_name;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        b((byte) (super.getResources().getString(R.string.edit_member).substring(0, 5).codePointAt(2) - 81), new char[]{')', Typography.amp, 29, 23, '\b', 28, Typography.quote, '\t', '\n', 0, 20, '\r', 21, '\b', '+', '.', 13825, 13825}, TextUtils.getOffsetBefore("", 0) + 18, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        try {
            Object[] objArr3 = new Object[1];
            a(PlaceComponentResult[25], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[56], (byte) (-PlaceComponentResult[5]), objArr4);
            byte b = (byte) (((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 32);
            char[] cArr = {18, 4, '\b', '!', 13887};
            try {
                Object[] objArr5 = new Object[1];
                a(PlaceComponentResult[25], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr5);
                Class<?> cls3 = Class.forName((String) objArr5[0]);
                a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[56], (byte) (-PlaceComponentResult[5]), new Object[1]);
                Object[] objArr6 = new Object[1];
                b(b, cArr, ((ApplicationInfo) cls3.getMethod((String) r2[0], null).invoke(this, null)).targetSdkVersion - 28, objArr6);
                int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr7 = new Object[1];
                        b((byte) (40 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), new char[]{')', Typography.amp, 29, 23, '\b', 28, Typography.quote, '\t', Typography.dollar, '\f', '\t', 7, 7, ',', Typography.quote, 30, Typography.dollar, InputCardNumberView.DIVIDER, InputCardNumberView.DIVIDER, '/', 22, JSONLexer.EOI, 24, '+', '%', '!'}, super.getResources().getString(R.string.remaining_bill).substring(3, 4).length() + 25, objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        b((byte) (ViewConfiguration.getPressedStateDuration() >> 16), new char[]{'/', 0, 13800, 13800, ',', Typography.amp, 30, '\f', 13802, 13802, 1, InputCardNumberView.DIVIDER, '/', '#', Typography.quote, 30, '\t', '#'}, getPackageName().codePointAt(1) - 82, objArr8);
                        baseContext = (Context) cls4.getMethod((String) objArr8[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext != null) {
                        baseContext = baseContext.getApplicationContext();
                    }
                    if (baseContext != null) {
                        try {
                            Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj == null) {
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 35, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            Object[] objArr9 = new Object[1];
                            b((byte) (108 - (ViewConfiguration.getEdgeSlop() >> 16)), new char[]{14, '/', '#', '*', 23, '!', 28, Typography.amp, 17, '/', '0', 14, '0', 31, '*', '!', 13847, 13847, '!', '#', 28, ',', 0, '#', 28, 16, '%', 28, 28, 31, Typography.amp, '/', InputCardNumberView.DIVIDER, 29, 28, InputCardNumberView.DIVIDER, 17, Typography.quote, '(', 21, 20, 14, 14, InputCardNumberView.DIVIDER, 7, 17, 31, '*'}, super.getResources().getString(R.string.ss_please_select_root_storage_sdcard).substring(16, 18).length() + 46, objArr9);
                            String str = (String) objArr9[0];
                            try {
                                Object[] objArr10 = new Object[1];
                                a(PlaceComponentResult[25], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr10);
                                Class<?> cls5 = Class.forName((String) objArr10[0]);
                                a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[56], (byte) (-PlaceComponentResult[5]), new Object[1]);
                                Object[] objArr11 = new Object[1];
                                b((byte) (((ApplicationInfo) cls5.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 4), new char[]{Typography.amp, JSONLexer.EOI, 29, 31, 17, Typography.quote, 21, '(', 28, ',', Typography.amp, 31, '!', ',', '.', 19, 13765, 13765, 19, '0', '!', ',', '#', 21, 31, 7, Typography.amp, 3, '%', 28, 13765, 13765, ',', 28, 14, '\'', 13846, 13846, 21, 19, 25, 27, '.', '0', '/', 14, 5, JSONLexer.EOI, 13766, 13766, 17, '!', '!', 17, '!', 5, '!', 5, '-', 7, '*', '(', 28, 16}, 64 - TextUtils.indexOf("", "", 0, 0), objArr11);
                                String str2 = (String) objArr11[0];
                                Object[] objArr12 = new Object[1];
                                b((byte) (getPackageName().codePointAt(1) - 38), new char[]{'!', '0', 3, 17, '!', 17, InputCardNumberView.DIVIDER, 20, 13792, 13792, '(', '*', '*', 19, '!', JSONLexer.EOI, Typography.amp, '/', 16, InputCardNumberView.DIVIDER, 31, '\r', '#', 19, 20, 14, 28, Typography.amp, 13882, 13882, 14, '/', 16, '!', 28, ')', '\f', 17, '#', '*', ')', 14, '.', 19, '(', 21, Typography.amp, '\f', 17, Typography.quote, '+', '.', '!', '0', 17, 27, 17, JSONLexer.EOI, InputCardNumberView.DIVIDER, 29, 17, 27, 31, Typography.amp}, ((Process.getThreadPriority(0) + 20) >> 6) + 64, objArr12);
                                String str3 = (String) objArr12[0];
                                Object[] objArr13 = new Object[1];
                                b((byte) (getPackageName().codePointAt(1) - 70), new char[]{JSONLexer.EOI, InputCardNumberView.DIVIDER, 29, '\f', 6, '-', 13779, 13779, '!', '%', Typography.amp, ')', '\f', Typography.quote, JSONLexer.EOI, 23, '/', Typography.amp, 28, '/', Typography.amp, 5, Typography.quote, '\f', 19, 1, Typography.dollar, JSONLexer.EOI, 31, 2, '/', 2, Typography.dollar, JSONLexer.EOI, '0', '\n', 0, 14, '\t', 25, Typography.dollar, '\f', 30, 22, 30, Typography.dollar, 17, '+', 5, 31, 25, '%', 30, 27, '.', Typography.amp, ',', Typography.amp, 31, 5}, super.getResources().getString(R.string.googleplay_description).substring(0, 1).codePointAt(0) - 6, objArr13);
                                String str4 = (String) objArr13[0];
                                Object[] objArr14 = new Object[1];
                                b((byte) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 85), new char[]{Typography.quote, '\n', 20, 11, '!', '0'}, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 6, objArr14);
                                try {
                                    Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 911, 18 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) Color.argb(0, 0, 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr15);
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
                    Object[] objArr16 = new Object[1];
                    a((byte) (getAuthRequestContext & 119), PlaceComponentResult[25], PlaceComponentResult[32], objArr16);
                    Class<?> cls6 = Class.forName((String) objArr16[0]);
                    Object[] objArr17 = new Object[1];
                    a(PlaceComponentResult[35], PlaceComponentResult[25], PlaceComponentResult[3], objArr17);
                    try {
                        Object[] objArr18 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 4, (char) TextUtils.getOffsetAfter("", 0));
                            byte b2 = (byte) ($$a[78] - 1);
                            byte b3 = b2;
                            Object[] objArr19 = new Object[1];
                            c(b2, b3, b3, objArr19);
                            obj3 = cls7.getMethod((String) objArr19[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                        int i = ((int[]) objArr20[1])[0];
                        if (((int[]) objArr20[0])[0] != i) {
                            long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 != null) {
                                    objArr = null;
                                } else {
                                    objArr = null;
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                try {
                                    Object[] objArr21 = {-1975069400, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 18 - View.getDefaultSize(0, 0), (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr21);
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
                        super.onCreate(bundle);
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

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            byte b = (byte) (40 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
            char[] cArr = {')', Typography.amp, 29, 23, '\b', 28, Typography.quote, '\t', Typography.dollar, '\f', '\t', 7, 7, ',', Typography.quote, 30, Typography.dollar, InputCardNumberView.DIVIDER, InputCardNumberView.DIVIDER, '/', 22, JSONLexer.EOI, 24, '+', '%', '!'};
            try {
                Object[] objArr = new Object[1];
                a(PlaceComponentResult[25], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[56], (byte) (-PlaceComponentResult[5]), new Object[1]);
                Object[] objArr2 = new Object[1];
                b(b, cArr, ((ApplicationInfo) cls.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 7, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                try {
                    Object[] objArr3 = new Object[1];
                    a(PlaceComponentResult[25], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[56], (byte) (-PlaceComponentResult[5]), new Object[1]);
                    Object[] objArr4 = new Object[1];
                    b((byte) (((ApplicationInfo) cls3.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 33), new char[]{'/', 0, 13800, 13800, ',', Typography.amp, 30, '\f', 13802, 13802, 1, InputCardNumberView.DIVIDER, '/', '#', Typography.quote, 30, '\t', '#'}, 18 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), objArr4);
                    baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.green(0), 35 - TextUtils.getOffsetBefore("", 0), (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (-16777198) - Color.rgb(0, 0, 0), (char) View.combineMeasuredStates(0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
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
        }
        super.onPause();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b((byte) (getPackageName().codePointAt(0) - 65), new char[]{')', Typography.amp, 29, 23, '\b', 28, Typography.quote, '\t', Typography.dollar, '\f', '\t', 7, 7, ',', Typography.quote, 30, Typography.dollar, InputCardNumberView.DIVIDER, InputCardNumberView.DIVIDER, '/', 22, JSONLexer.EOI, 24, '+', '%', '!'}, getPackageName().length() + 19, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b((byte) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), new char[]{'/', 0, 13800, 13800, ',', Typography.amp, 30, '\f', 13802, 13802, 1, InputCardNumberView.DIVIDER, '/', '#', Typography.quote, 30, '\t', '#'}, 17 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 930, 35 - Gravity.getAbsoluteGravity(0, 0), (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 18, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getPresenter")
    public final InputNameContract.Presenter getPresenter() {
        InputNameContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(InputNameContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/oauth/activity/InputNameActivity$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/oauth/model/OauthParamsModel;", "p1", "", "p2", "Landroid/content/Intent;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Lid/dana/oauth/model/OauthParamsModel;Z)Landroid/content/Intent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Intent BuiltInFictitiousFunctionClassFactory(Context p0, OauthParamsModel p1, boolean p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, InputNameActivity.class);
            intent.putExtra("oauth", p1);
            intent.putExtra("EX_QR_BIND", p2);
            intent.setFlags(268468224);
            return intent;
        }
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (BuiltInFictitiousFunctionClassFactory()) {
            try {
                BaseService service = WalletServiceManager.getInstance().getService(OAuthService.class);
                if (service == null) {
                    throw new NullPointerException("null cannot be cast to non-null type id.dana.miniprogram.provider.OauthServiceProvider");
                }
                ((OauthServiceProvider) service).getAuthRequestContext(new OAuthResult());
            } catch (WalletServiceManager.ServiceNotFoundException unused) {
            }
        }
        super.onBackPressed();
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setCenterTitle(getString(R.string.oauth_input_name_title));
        setMenuLeftButton(R.drawable.btn_arrow_left);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        BuiltInFictitiousFunctionClassFactory(true);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        BuiltInFictitiousFunctionClassFactory(false);
    }

    @Override // id.dana.oauth.InputNameContract.View
    public final void onUpdateNameSuccess(boolean isSuccess) {
        BuiltInFictitiousFunctionClassFactory(isSuccess, "");
        PlaceComponentResult();
    }

    @Override // id.dana.oauth.InputNameContract.View
    public final void onUpdateNameFailed(String errorMessage) {
        if (errorMessage == null) {
            errorMessage = getString(R.string.system_busy_error);
            Intrinsics.checkNotNullExpressionValue(errorMessage, "");
        }
        BuiltInFictitiousFunctionClassFactory(false, errorMessage);
        String BuiltInFictitiousFunctionClassFactory = ErrorUtil.BuiltInFictitiousFunctionClassFactory(this);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        CustomSnackbar.Builder builder = new CustomSnackbar.Builder((ViewGroup) findViewById);
        builder.initRecordTimeStamp = BuiltInFictitiousFunctionClassFactory;
        builder.moveToNextValue = -1;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_warning_orange;
        builder.MyBillsEntityDataFactory = R.drawable.bg_custom_snackbar;
        builder.BuiltInFictitiousFunctionClassFactory().show();
    }

    @Override // id.dana.oauth.InputNameContract.View
    public final void onCheckSkipButtonMerchantList(Set<String> merchantIdEnable) {
        Intrinsics.checkNotNullParameter(merchantIdEnable, "");
        ((DanaButtonSecondaryView) _$_findCachedViewById(R.id.CaptureStatus)).setVisibility(getAuthRequestContext(merchantIdEnable) ? 0 : 8);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent ev) {
        Object systemService = getSystemService("input_method");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        View currentFocus = getCurrentFocus();
        inputMethodManager.hideSoftInputFromWindow(currentFocus != null ? currentFocus.getWindowToken() : null, 0);
        return super.dispatchTouchEvent(ev);
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        getPresenter().onDestroy();
    }

    private final boolean BuiltInFictitiousFunctionClassFactory() {
        OauthParamsModel oauthParamsModel = this.MyBillsEntityDataFactory;
        if (oauthParamsModel != null) {
            return oauthParamsModel.BuiltInFictitiousFunctionClassFactory();
        }
        return false;
    }

    private final boolean getAuthRequestContext(Set<String> p0) {
        OauthParamsModel oauthParamsModel = this.MyBillsEntityDataFactory;
        if (oauthParamsModel != null) {
            return CollectionsKt.contains(p0, oauthParamsModel.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
        return false;
    }

    private final void PlaceComponentResult() {
        OauthGrantActivity.Companion companion = OauthGrantActivity.INSTANCE;
        OauthParamsModel oauthParamsModel = this.MyBillsEntityDataFactory;
        boolean authRequestContext = getAuthRequestContext();
        OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
        OauthLoginManager.PrepareContext();
        startActivity(OauthGrantActivity.Companion.MyBillsEntityDataFactory(this, oauthParamsModel, authRequestContext));
    }

    private final boolean getAuthRequestContext() {
        Intent intent = getIntent();
        if (intent != null) {
            return intent.getBooleanExtra("EX_QR_BIND", false);
        }
        return false;
    }

    private final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        boolean z = !p0;
        ((DanaButtonPrimaryView) _$_findCachedViewById(R.id.ThreadLocalKey_res_0x7f0a05ab)).setClickable(z);
        ((DanaButtonSecondaryView) _$_findCachedViewById(R.id.CaptureStatus)).setClickable(z);
        ((DanaEditTextView) _$_findCachedViewById(R.id.getSchemeBytes)).setFocusableInTouchMode(z);
        ((LogoProgressView) _$_findCachedViewById(R.id.setSmoothScrollingEnabled)).setVisibility(p0 ? 0 : 8);
        if (p0) {
            ((LogoProgressView) _$_findCachedViewById(R.id.setSmoothScrollingEnabled)).startRefresh();
        } else {
            ((LogoProgressView) _$_findCachedViewById(R.id.setSmoothScrollingEnabled)).stopRefresh();
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(boolean p0, String p1) {
        String str;
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(this);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.ADD_NAME_COMPLETED;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", TrackerDataKey.Source.DEEPLINK_BINDING);
        OauthParamsModel oauthParamsModel = this.MyBillsEntityDataFactory;
        if (oauthParamsModel == null || (str = oauthParamsModel.lookAheadTest) == null) {
            str = "";
        }
        EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory.MyBillsEntityDataFactory("Merchant Name", str).BuiltInFictitiousFunctionClassFactory("Success", p0);
        byte b = 0;
        if (p1.length() > 0) {
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory("Fail Reason", p1);
        }
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(BuiltInFictitiousFunctionClassFactory, b));
    }

    public static /* synthetic */ void $r8$lambda$62p0Nycp0SWsXf8nF3GtqaqMVko(InputNameActivity inputNameActivity, View view) {
        Intrinsics.checkNotNullParameter(inputNameActivity, "");
        inputNameActivity.getPresenter().BuiltInFictitiousFunctionClassFactory(StringsKt.trim((CharSequence) String.valueOf(((DanaEditTextView) inputNameActivity._$_findCachedViewById(R.id.getSchemeBytes)).getText())).toString());
    }

    /* renamed from: $r8$lambda$S2kTvIMtPPws_jbHlc-3nVMdcPQ  reason: not valid java name */
    public static /* synthetic */ void m2755$r8$lambda$S2kTvIMtPPws_jbHlc3nVMdcPQ(InputNameActivity inputNameActivity, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(inputNameActivity, "");
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) inputNameActivity._$_findCachedViewById(R.id.ThreadLocalKey_res_0x7f0a05ab);
        Intrinsics.checkNotNullExpressionValue(charSequence, "");
        danaButtonPrimaryView.setDanaButtonView(!StringsKt.isBlank(charSequence) ? 1 : 0, inputNameActivity.getString(R.string.option_continue), "", null);
        ((DanaButtonPrimaryView) inputNameActivity._$_findCachedViewById(R.id.ThreadLocalKey_res_0x7f0a05ab)).setClickable(!StringsKt.isBlank(charSequence));
    }

    public static /* synthetic */ void $r8$lambda$Z0SXjnQnheUuzSAVVgMiEaSbO4s(InputNameActivity inputNameActivity, View view) {
        String str;
        String str2 = "";
        Intrinsics.checkNotNullParameter(inputNameActivity, "");
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(inputNameActivity);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.ADD_NAME_SKIP;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", TrackerDataKey.Source.DEEPLINK_BINDING);
        OauthParamsModel oauthParamsModel = inputNameActivity.MyBillsEntityDataFactory;
        if (oauthParamsModel != null && (str = oauthParamsModel.lookAheadTest) != null) {
            str2 = str;
        }
        EventTrackerModel.Builder MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory("Merchant Name", str2);
        MyBillsEntityDataFactory2.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory2, (byte) 0));
        inputNameActivity.PlaceComponentResult();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [android.os.Parcelable] */
    @Override // id.dana.base.BaseActivity
    public final void init() {
        String str;
        Bundle extras;
        Object obj;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                obj = (Parcelable) extras.getParcelable("oauth", OauthParamsModel.class);
            } else {
                ?? parcelable = extras.getParcelable("oauth");
                obj = parcelable instanceof OauthParamsModel ? parcelable : null;
            }
            r1 = (OauthParamsModel) obj;
        }
        this.MyBillsEntityDataFactory = r1;
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(this);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.ADD_NAME_OPEN;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", TrackerDataKey.Source.DEEPLINK_BINDING);
        OauthParamsModel oauthParamsModel = this.MyBillsEntityDataFactory;
        if (oauthParamsModel == null || (str = oauthParamsModel.lookAheadTest) == null) {
            str = "";
        }
        EventTrackerModel.Builder MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory("Merchant Name", str);
        MyBillsEntityDataFactory2.PlaceComponentResult();
        byte b = 0;
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory2, b));
        DaggerInputNameComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerInputNameComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (InputNameModule) Preconditions.getAuthRequestContext(new InputNameModule(this));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, InputNameModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        new DaggerInputNameComponent.InputNameComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, b).BuiltInFictitiousFunctionClassFactory(this);
        ((DanaButtonPrimaryView) _$_findCachedViewById(R.id.ThreadLocalKey_res_0x7f0a05ab)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.oauth.activity.InputNameActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputNameActivity.$r8$lambda$62p0Nycp0SWsXf8nF3GtqaqMVko(InputNameActivity.this, view);
            }
        });
        ((DanaButtonSecondaryView) _$_findCachedViewById(R.id.CaptureStatus)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.oauth.activity.InputNameActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputNameActivity.$r8$lambda$Z0SXjnQnheUuzSAVVgMiEaSbO4s(InputNameActivity.this, view);
            }
        });
        addDisposable(RxTextView.textChanges((DanaEditTextView) _$_findCachedViewById(R.id.getSchemeBytes)).subscribe(new Consumer() { // from class: id.dana.oauth.activity.InputNameActivity$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj2) {
                InputNameActivity.m2755$r8$lambda$S2kTvIMtPPws_jbHlc3nVMdcPQ(InputNameActivity.this, (CharSequence) obj2);
            }
        }));
        getPresenter().PlaceComponentResult();
    }

    private static void b(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ lookAheadTest);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            getcallingpid.getAuthRequestContext = 0;
            while (getcallingpid.getAuthRequestContext < i2) {
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                } else {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                        int i4 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i5 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i4];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i5];
                    } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                        getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                        getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                        int i6 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i7 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i6];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i7];
                    } else {
                        int i8 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                        int i9 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i8];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i9];
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        for (int i10 = 0; i10 < i; i10++) {
            cArr4[i10] = (char) (cArr4[i10] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }
}
