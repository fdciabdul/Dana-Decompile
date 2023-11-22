package id.dana.danaviz;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContractKt;
import id.dana.challenge.ChallengeControl;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.core.ui.util.DANAToast;
import id.dana.danah5.DanaH5;
import id.dana.danaviz.DanaVizPromptContract;
import id.dana.databinding.ActivityDanaVizPromptBinding;
import id.dana.databinding.LayoutToolbarBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerDanaVizPromptComponent;
import id.dana.di.modules.DanaVizPromptModule;
import id.dana.extension.view.ViewExtKt;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.onboarding.track.OnboardingFirebaseTracker;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule;
import id.dana.showcase.DanaVizPromptShowcaseBuilder;
import id.dana.showcase.shape.CircleShape;
import id.dana.showcase.target.Target;
import id.dana.showcase.target.TargetBuilder;
import id.dana.utils.UrlUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0019\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\u0007J)\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0007R\"\u0010\u0013\u001a\u00020\u00128\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/danaviz/DanaVizPromptActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityDanaVizPromptBinding;", "inflateViewBinding", "()Lid/dana/databinding/ActivityDanaVizPromptBinding;", "", IAPSyncCommand.COMMAND_INIT, "()V", "initComponent", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onBackPressed", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/danaviz/DanaVizPromptContract$Presenter;", "presenter", "Lid/dana/danaviz/DanaVizPromptContract$Presenter;", "getPresenter", "()Lid/dana/danaviz/DanaVizPromptContract$Presenter;", "setPresenter", "(Lid/dana/danaviz/DanaVizPromptContract$Presenter;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanaVizPromptActivity extends BaseViewBindingActivity<ActivityDanaVizPromptBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final String DANA_VIZ_DETAIL_URL = "https://a.m.dana.id/resource/htmls/dana-viz/DANAVIZ_FAQ_EN.html";
    public static final float MARGIN_RIGHT_BUTTON_TOOLBAR = 12.0f;
    public static final float MARGIN_TOOLTIP_ARROW = 24.0f;
    public static final String RESET_PIN = "RESET_PIN";
    private static char[] getAuthRequestContext;
    private static char lookAheadTest;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public DanaVizPromptContract.Presenter presenter;
    public static final byte[] $$a = {61, 16, -46, 32, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 79;
    public static final byte[] PlaceComponentResult = {Ascii.FS, 71, 97, TarHeader.LF_DIR, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 89;

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        lookAheadTest = (char) 42066;
        getAuthRequestContext = new char[]{37308, 37279, 37295, 37281, 37459, 37275, 37461, 37302, 37462, 37291, 37370, 37463, 37287, 37290, 37368, 37280, 37456, 37294, 37293, 37374, 37309, 37345, 37372, 37375, 37288, 37365, 37284, 37371, 37289, 37282, 37304, 37307, 37369, 37366, 37283, 37305, 37286, 37285, 37310, 37460, 37344, 37274, 37262, 37292, 37457, 37311, 37306, 37367, 37373};
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 97
            int r6 = 55 - r6
            byte[] r0 = id.dana.danaviz.DanaVizPromptActivity.PlaceComponentResult
            int r8 = 23 - r8
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L13
            r4 = r7
            r3 = 0
            r7 = r6
            goto L2a
        L13:
            r3 = 0
        L14:
            int r6 = r6 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r5
        L2a:
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + (-4)
            r5 = r7
            r7 = r6
            r6 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danaviz.DanaVizPromptActivity.a(short, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = 46 - r9
            int r8 = r8 * 2
            int r8 = 103 - r8
            int r7 = r7 * 3
            int r7 = r7 + 21
            byte[] r0 = id.dana.danaviz.DanaVizPromptActivity.$$a
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L31
        L17:
            r3 = 0
        L18:
            int r9 = r9 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L29
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
            int r9 = -r9
            int r8 = r8 + r9
            int r8 = r8 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danaviz.DanaVizPromptActivity.c(byte, short, int, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final Intent createActivity(Context context) {
        return Companion.MyBillsEntityDataFactory(context);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        Object[] objArr5;
        super.attachBaseContext(context);
        Object[] objArr6 = new Object[1];
        b((byte) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 95), new char[]{24, '\n', '\r', 16, 22, '+', 7, 23, 14, 1, 22, 0, 14, 16, '0', '\b', 13896, 13896}, 19 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr6);
        Class<?> cls = Class.forName((String) objArr6[0]);
        Object[] objArr7 = new Object[1];
        b((byte) (113 - (ViewConfiguration.getPressedStateDuration() >> 16)), new char[]{28, '\b', '#', '%', 13935}, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 6, objArr7);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr7[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj != null) {
                        objArr = null;
                    } else {
                        objArr = null;
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + PDF417Common.NUMBER_OF_CODEWORDS, Color.rgb(0, 0, 0) + 16777251, (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(objArr, objArr);
                    Object[] objArr8 = new Object[1];
                    b((byte) (42 - TextUtils.lastIndexOf("", '0', 0, 0)), new char[]{15, '*', '!', '.', 30, 16, '(', 5, 20, 7, '*', 29, 20, 6, 18, '!', 13782, 13782, 31, 18, '\b', ',', '.', 29, '\b', 23, ',', '\f', ',', '\r', 20, '\n', Typography.quote, '!', '/', Typography.quote, 29, Typography.quote, ',', JSONLexer.EOI, 21, '#', 25, Typography.quote, 15, 25, Typography.quote, 11}, (ViewConfiguration.getTapTimeout() >> 16) + 48, objArr8);
                    String str = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b((byte) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 110), new char[]{24, 17, 30, 11, 29, Typography.quote, JSONLexer.EOI, ',', '\b', ',', 31, '\f', '\f', 16, 20, JSONLexer.EOI, 13846, 13846, '!', 14, '\f', 16, 29, 25, '\'', 25, Typography.quote, '\f', ',', '\f', 13846, 13846, ',', '\b', JSONLexer.EOI, '0', 13927, 13927, 24, 23, '\t', 24, '\f', 20, '*', 15, 20, 15, 13847, 13847, 19, 28, 28, 19, JSONLexer.EOI, 16, JSONLexer.EOI, 16, '.', 15, JSONLexer.EOI, 5, '\b', 23}, 64 - TextUtils.indexOf("", "", 0), objArr9);
                    String str2 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b((byte) (72 - View.resolveSizeAndState(0, 0, 0)), new char[]{'/', 20, 11, 20, 28, 19, 6, Typography.quote, 13802, 13802, 5, JSONLexer.EOI, 15, JSONLexer.EOI, 21, 16, 20, '\n', 23, '\r', '.', 20, 15, 24, 21, '#', '(', 5, 13892, 13892, 15, '*', 16, 7, '*', '0', 19, 15, '!', '.', '*', '!', 20, JSONLexer.EOI, ',', JSONLexer.EOI, 18, 19, 29, Typography.quote, '0', '\b', '/', 20, 31, 7, 17, 7, Typography.quote, '!', 31, 7, '\f', 31}, 65 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), objArr10);
                    String str3 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b((byte) (32 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), new char[]{'\n', '!', Typography.amp, 3, 4, 21, 13780, 13780, '\n', 16, '\n', 24, 24, 28, '\r', 19, '\n', 20, 29, '-', 14, 3, 28, 24, 25, '-', 18, 14, 7, 2, '\'', '-', 18, 14, 7, 27, 1, 22, '!', Typography.dollar, 24, 3, '%', ')', Typography.amp, 1, 27, '\n', 3, 28, ')', Typography.dollar, '/', ')', 7, ')', '\n', 6, 28, 3}, ExpandableListView.getPackedPositionChild(0L) + 61, objArr11);
                    String str4 = (String) objArr11[0];
                    Object[] objArr12 = new Object[1];
                    b((byte) (((Process.getThreadPriority(0) + 20) >> 6) + 24), new char[]{28, JSONLexer.EOI, 21, 22, '/', 20}, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 5, objArr12);
                    try {
                        Object[] objArr13 = {applicationContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.getDeadChar(0, 0), ((Process.getThreadPriority(0) + 20) >> 6) + 18, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            }
        }
        Context applicationContext2 = context != null ? context.getApplicationContext() : context;
        if (applicationContext2 != null) {
            try {
                Object[] objArr14 = new Object[1];
                a((byte) (-PlaceComponentResult[31]), (byte) (-PlaceComponentResult[32]), PlaceComponentResult[30], objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                Object[] objArr15 = new Object[1];
                a((short) 30, 8, PlaceComponentResult[30], objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 56, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 3, (char) ((-1) - Process.getGidForName("")));
                        Object[] objArr17 = new Object[1];
                        c($$a[47], (byte) (-$$a[12]), (byte) (-$$a[53]), objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.lastIndexOf("", '0', 0), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 15, (char) View.combineMeasuredStates(0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.combineMeasuredStates(0, 0), 15 - View.MeasureSpec.getSize(0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - TextUtils.getCapsMode("", 0, 0), TextUtils.getCapsMode("", 0, 0) + 29, (char) ((KeyEvent.getMaxKeyCode() >> 16) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.MeasureSpec.getSize(0), 15 - View.resolveSizeAndState(0, 0, 0), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr18));
                                    long j = ((r7 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr2 = null;
                                        } else {
                                            objArr2 = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 930, 35 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr2, objArr2);
                                        try {
                                            Object[] objArr19 = {834626527, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 18 - Color.red(0), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr19);
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
                Object[] objArr20 = new Object[1];
                a((byte) (-PlaceComponentResult[31]), (byte) (-PlaceComponentResult[32]), PlaceComponentResult[30], objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                Object[] objArr21 = new Object[1];
                a((short) 30, 8, PlaceComponentResult[30], objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(60 - TextUtils.lastIndexOf("", '0'), 46 - TextUtils.getOffsetBefore("", 0), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                        byte b = (byte) ($$a[47] - 1);
                        Object[] objArr23 = new Object[1];
                        c(b, b, $$a[20], objArr23);
                        obj9 = cls5.getMethod((String) objArr23[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr24 = (Object[]) ((Method) obj9).invoke(null, objArr22);
                    int i = ((int[]) objArr24[1])[0];
                    if (((int[]) objArr24[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr25 = {834626527, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 912, (ViewConfiguration.getWindowTouchSlop() >> 8) + 18, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr25);
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
                Object[] objArr26 = new Object[1];
                a((byte) (-PlaceComponentResult[31]), (byte) (-PlaceComponentResult[32]), PlaceComponentResult[30], objArr26);
                Class<?> cls6 = Class.forName((String) objArr26[0]);
                Object[] objArr27 = new Object[1];
                a((short) 30, 8, PlaceComponentResult[30], objArr27);
                try {
                    Object[] objArr28 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr27[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(119 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 3 - View.MeasureSpec.getSize(0), (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 38968));
                        byte b2 = (byte) ($$a[47] - 1);
                        Object[] objArr29 = new Object[1];
                        c(b2, b2, $$a[20], objArr29);
                        obj12 = cls7.getMethod((String) objArr29[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr30 = (Object[]) ((Method) obj12).invoke(null, objArr28);
                    int i2 = ((int[]) objArr30[1])[0];
                    if (((int[]) objArr30[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 930, (ViewConfiguration.getTapTimeout() >> 16) + 35, (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr31 = {834626527, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + 911, 18 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr31);
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
                Object[] objArr32 = new Object[1];
                a((byte) (-PlaceComponentResult[31]), (byte) (-PlaceComponentResult[32]), PlaceComponentResult[30], objArr32);
                Class<?> cls8 = Class.forName((String) objArr32[0]);
                Object[] objArr33 = new Object[1];
                a((short) 30, 8, PlaceComponentResult[30], objArr33);
                try {
                    Object[] objArr34 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr33[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 108, TextUtils.indexOf("", "", 0) + 3, (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))));
                        Object[] objArr35 = new Object[1];
                        c((byte) (-$$a[8]), (byte) (-$$a[9]), (byte) ($$a[47] - 1), objArr35);
                        obj15 = cls9.getMethod((String) objArr35[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr36 = (Object[]) ((Method) obj15).invoke(null, objArr34);
                    int i3 = ((int[]) objArr36[1])[0];
                    if (((int[]) objArr36[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr5 = null;
                            } else {
                                objArr5 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), ExpandableListView.getPackedPositionGroup(0L) + 35, (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr5, objArr5);
                            try {
                                Object[] objArr37 = {834626527, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 911, 18 - Color.blue(0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr37);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        b((byte) (95 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), new char[]{24, '\n', '\r', 16, 22, '+', 7, 23, 14, 1, 22, 0, 14, 16, '0', '\b', 13896, 13896}, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 18, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        b((byte) (114 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), new char[]{28, '\b', '#', '%', 13935}, super.getResources().getString(R.string.promotion).substring(0, 5).length() + 0, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                byte codePointAt = (byte) (super.getResources().getString(R.string.subtitle_no_connection).substring(3, 4).codePointAt(0) - 41);
                char[] cArr = {24, '\n', '\r', 16, 22, '+', 7, 23, 24, 3, '*', 24, '+', ',', 29, Typography.amp, Typography.dollar, '%', 28, '\n', '\f', 19, 27, 20, 16, '\n'};
                try {
                    byte b = (byte) (PlaceComponentResult[3] - 1);
                    byte b2 = PlaceComponentResult[25];
                    Object[] objArr4 = new Object[1];
                    a(b, b2, b2, objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    a(PlaceComponentResult[25], PlaceComponentResult[5], PlaceComponentResult[41], new Object[1]);
                    Object[] objArr5 = new Object[1];
                    b(codePointAt, cArr, ((ApplicationInfo) cls2.getMethod((String) r4[0], null).invoke(this, null)).targetSdkVersion - 7, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    byte mode = (byte) (View.MeasureSpec.getMode(0) + 104);
                    char[] cArr2 = {',', '/', 13904, 13904, '\n', 6, 28, '-', 13906, 13906, 29, ')', '-', 15, 29, Typography.amp, 17, 1};
                    try {
                        byte b3 = (byte) (PlaceComponentResult[3] - 1);
                        byte b4 = PlaceComponentResult[25];
                        Object[] objArr6 = new Object[1];
                        a(b3, b4, b4, objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        a(PlaceComponentResult[25], PlaceComponentResult[5], PlaceComponentResult[41], new Object[1]);
                        Object[] objArr7 = new Object[1];
                        b(mode, cArr2, ((ApplicationInfo) cls4.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 15, objArr7);
                        baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 930, ((byte) KeyEvent.getModifierMetaStateMask()) + 36, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr8 = new Object[1];
                    b((byte) (43 - KeyEvent.keyCodeFromString("")), new char[]{15, '*', '!', '.', 30, 16, '(', 5, 20, 7, '*', 29, 20, 6, 18, '!', 13782, 13782, 31, 18, '\b', ',', '.', 29, '\b', 23, ',', '\f', ',', '\r', 20, '\n', Typography.quote, '!', '/', Typography.quote, 29, Typography.quote, ',', JSONLexer.EOI, 21, '#', 25, Typography.quote, 15, 25, Typography.quote, 11}, TextUtils.getOffsetBefore("", 0) + 48, objArr8);
                    String str = (String) objArr8[0];
                    try {
                        byte b5 = (byte) (PlaceComponentResult[3] - 1);
                        byte b6 = PlaceComponentResult[25];
                        Object[] objArr9 = new Object[1];
                        a(b5, b6, b6, objArr9);
                        Class<?> cls5 = Class.forName((String) objArr9[0]);
                        Object[] objArr10 = new Object[1];
                        a(PlaceComponentResult[25], PlaceComponentResult[5], PlaceComponentResult[41], objArr10);
                        Object[] objArr11 = new Object[1];
                        b((byte) (((ApplicationInfo) cls5.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 77), new char[]{24, 17, 30, 11, 29, Typography.quote, JSONLexer.EOI, ',', '\b', ',', 31, '\f', '\f', 16, 20, JSONLexer.EOI, 13846, 13846, '!', 14, '\f', 16, 29, 25, '\'', 25, Typography.quote, '\f', ',', '\f', 13846, 13846, ',', '\b', JSONLexer.EOI, '0', 13927, 13927, 24, 23, '\t', 24, '\f', 20, '*', 15, 20, 15, 13847, 13847, 19, 28, 28, 19, JSONLexer.EOI, 16, JSONLexer.EOI, 16, '.', 15, JSONLexer.EOI, 5, '\b', 23}, ImageFormat.getBitsPerPixel(0) + 65, objArr11);
                        String str2 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        b((byte) (super.getResources().getString(R.string.request_money_AE15112158147535).substring(10, 11).length() + 71), new char[]{'/', 20, 11, 20, 28, 19, 6, Typography.quote, 13802, 13802, 5, JSONLexer.EOI, 15, JSONLexer.EOI, 21, 16, 20, '\n', 23, '\r', '.', 20, 15, 24, 21, '#', '(', 5, 13892, 13892, 15, '*', 16, 7, '*', '0', 19, 15, '!', '.', '*', '!', 20, JSONLexer.EOI, ',', JSONLexer.EOI, 18, 19, 29, Typography.quote, '0', '\b', '/', 20, 31, 7, 17, 7, Typography.quote, '!', 31, 7, '\f', 31}, 65 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), objArr12);
                        String str3 = (String) objArr12[0];
                        Object[] objArr13 = new Object[1];
                        b((byte) (31 - TextUtils.getOffsetBefore("", 0)), new char[]{'\n', '!', Typography.amp, 3, 4, 21, 13780, 13780, '\n', 16, '\n', 24, 24, 28, '\r', 19, '\n', 20, 29, '-', 14, 3, 28, 24, 25, '-', 18, 14, 7, 2, '\'', '-', 18, 14, 7, 27, 1, 22, '!', Typography.dollar, 24, 3, '%', ')', Typography.amp, 1, 27, '\n', 3, 28, ')', Typography.dollar, '/', ')', 7, ')', '\n', 6, 28, 3}, KeyEvent.normalizeMetaState(0) + 60, objArr13);
                        String str4 = (String) objArr13[0];
                        Object[] objArr14 = new Object[1];
                        b((byte) (getPackageName().codePointAt(3) - 76), new char[]{28, JSONLexer.EOI, 21, 22, '/', 20}, super.getResources().getString(R.string.nearby_me_direction).substring(0, 9).length() - 3, objArr14);
                        try {
                            Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.green(0), 18 - Color.red(0), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr15);
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
            Object[] objArr16 = new Object[1];
            a((byte) (-PlaceComponentResult[31]), (byte) (-PlaceComponentResult[32]), PlaceComponentResult[30], objArr16);
            Class<?> cls6 = Class.forName((String) objArr16[0]);
            Object[] objArr17 = new Object[1];
            a((short) 30, 8, PlaceComponentResult[30], objArr17);
            try {
                Object[] objArr18 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 494, TextUtils.indexOf((CharSequence) "", '0') + 5, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)));
                    Object[] objArr19 = new Object[1];
                    c((byte) (-$$a[8]), (byte) (-$$a[9]), (byte) ($$a[47] - 1), objArr19);
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
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.argb(0, 0, 0, 0), (ViewConfiguration.getLongPressTimeout() >> 16) + 35, (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr21 = {630357828, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 911, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 17, (char) KeyEvent.normalizeMetaState(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr21);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                byte b = (byte) (PlaceComponentResult[3] - 1);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a(PlaceComponentResult[25], PlaceComponentResult[5], PlaceComponentResult[41], objArr2);
                byte b3 = (byte) (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 23);
                char[] cArr = {24, '\n', '\r', 16, 22, '+', 7, 23, 24, 3, '*', 24, '+', ',', 29, Typography.amp, Typography.dollar, '%', 28, '\n', '\f', 19, 27, 20, 16, '\n'};
                try {
                    byte b4 = (byte) (PlaceComponentResult[3] - 1);
                    byte b5 = PlaceComponentResult[25];
                    Object[] objArr3 = new Object[1];
                    a(b4, b5, b5, objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    a(PlaceComponentResult[25], PlaceComponentResult[5], PlaceComponentResult[41], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    b(b3, cArr, ((ApplicationInfo) cls2.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 7, objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    b((byte) (super.getResources().getString(R.string.saved_bank).substring(1, 2).length() + 103), new char[]{',', '/', 13904, 13904, '\n', 6, 28, '-', 13906, 13906, 29, ')', '-', 15, 29, Typography.amp, 17, 1}, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 17, objArr5);
                    baseContext = (Context) cls3.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getMode(0), 35 - (Process.myTid() >> 22), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr6 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTouchSlop() >> 8), KeyEvent.keyCodeFromString("") + 18, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr6);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b((byte) (super.getResources().getString(R.string.popular_places_desc).substring(32, 34).codePointAt(0) - 61), new char[]{24, '\n', '\r', 16, 22, '+', 7, 23, 24, 3, '*', 24, '+', ',', 29, Typography.amp, Typography.dollar, '%', 28, '\n', '\f', 19, 27, 20, 16, '\n'}, 27 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                byte b = (byte) (PlaceComponentResult[3] - 1);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr2 = new Object[1];
                a(b, b2, b2, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                a(PlaceComponentResult[25], PlaceComponentResult[5], PlaceComponentResult[41], objArr3);
                Object[] objArr4 = new Object[1];
                b((byte) (((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 71), new char[]{',', '/', 13904, 13904, '\n', 6, 28, '-', 13906, 13906, 29, ')', '-', 15, 29, Typography.amp, 17, 1}, super.getResources().getString(R.string.kyc_renewal_dialog_title).substring(1, 2).codePointAt(0) - 83, objArr4);
                baseContext = (Context) cls.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf("", "", 0, 0) + 35, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionGroup(0L), 18 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
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
        super.onResume();
    }

    @JvmName(name = "getPresenter")
    public final DanaVizPromptContract.Presenter getPresenter() {
        DanaVizPromptContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(DanaVizPromptContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityDanaVizPromptBinding inflateViewBinding() {
        ActivityDanaVizPromptBinding MyBillsEntityDataFactory = ActivityDanaVizPromptBinding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            boolean z = extras.getBoolean("dana_viz_prompt_skippable", true);
            LayoutToolbarBinding layoutToolbarBinding = getBinding().scheduleImpl;
            layoutToolbarBinding.initRecordTimeStamp.setText(getString(R.string.dana_viz_prompt_button_activate_dana_viz));
            TextView textView = layoutToolbarBinding.getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(0);
            TextView textView2 = layoutToolbarBinding.getErrorConfigVersion;
            Drawable PlaceComponentResult2 = ContextCompat.PlaceComponentResult(this, (int) R.drawable.ic_information);
            if (PlaceComponentResult2 != null) {
                PlaceComponentResult2.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
            } else {
                PlaceComponentResult2 = null;
            }
            textView2.setBackground(PlaceComponentResult2);
            TextView textView3 = layoutToolbarBinding.getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(textView3, "");
            ViewExtKt.MyBillsEntityDataFactory(textView3, null, null, Integer.valueOf(ViewExtKt.PlaceComponentResult(12.0f)), null, 11);
            layoutToolbarBinding.getErrorConfigVersion.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danaviz.DanaVizPromptActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DanaVizPromptActivity.$r8$lambda$Q5lhVWudkhmCE1YtZ6NDZLyiLc8(DanaVizPromptActivity.this, view);
                }
            });
            String string = getString(R.string.dana_viz_prompt_tnc);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String string2 = getString(R.string.dana_viz_prompt_tnc_highlight);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            String string3 = getString(R.string.dana_viz_prompt_tnc_highlight_second);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            AppCompatTextView appCompatTextView = getBinding().GetContactSyncConfig;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
            String str = string;
            int indexOf$default = StringsKt.indexOf$default((CharSequence) str, string2, 0, false, 6, (Object) null);
            int length = string2.length() + indexOf$default;
            int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str, string3, 0, false, 6, (Object) null);
            int length2 = string3.length() + indexOf$default2;
            SpannableString spannableString = new SpannableString(str);
            final String str2 = "https://m.dana.id/i/kyc/dana-viz/tnc";
            ClickableSpan clickableSpan = new ClickableSpan() { // from class: id.dana.danaviz.DanaVizPromptActivity$setHyperlinkText$clickableSpan$1
                @Override // android.text.style.ClickableSpan
                public final void onClick(View p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    String authRequestContext = UrlUtil.getAuthRequestContext(str2);
                    Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                    DanaH5.startContainerFullUrl(authRequestContext);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(TextPaint p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    p0.setUnderlineText(true);
                }
            };
            final String str3 = DANA_VIZ_DETAIL_URL;
            ClickableSpan clickableSpan2 = new ClickableSpan() { // from class: id.dana.danaviz.DanaVizPromptActivity$setHyperlinkText$secondClickableSpan$1
                @Override // android.text.style.ClickableSpan
                public final void onClick(View p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    String authRequestContext = UrlUtil.getAuthRequestContext(str3);
                    Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                    DanaH5.startContainerFullUrl(authRequestContext);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(TextPaint p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    p0.setUnderlineText(true);
                }
            };
            spannableString.setSpan(clickableSpan, indexOf$default, length, 33);
            spannableString.setSpan(new StyleSpan(1), indexOf$default, length, 33);
            spannableString.setSpan(clickableSpan2, indexOf$default2, length2, 33);
            spannableString.setSpan(new StyleSpan(1), indexOf$default2, length2, 33);
            appCompatTextView.setText(spannableString);
            appCompatTextView.setMovementMethod(LinkMovementMethod.getInstance());
            getBinding().BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danaviz.DanaVizPromptActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DanaVizPromptActivity.$r8$lambda$e9m2lrFRIBrd6OBEqLZPPMnU88o(DanaVizPromptActivity.this, view);
                }
            });
            getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danaviz.DanaVizPromptActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DanaVizPromptActivity.m733$r8$lambda$_jxT7OS4pulLyxRmnncSe8vhl8(DanaVizPromptActivity.this, view);
                }
            });
            AppCompatButton appCompatButton = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(appCompatButton, "");
            appCompatButton.setVisibility(z ? 0 : 8);
            if (z) {
                return;
            }
            DanaButtonSecondaryView danaButtonSecondaryView = getBinding().BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
            ViewExtKt.MyBillsEntityDataFactory(danaButtonSecondaryView, null, null, null, Integer.valueOf(ViewExtKt.PlaceComponentResult(34.0f)), 7);
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        DaggerDanaVizPromptComponent.Builder MyBillsEntityDataFactory = DaggerDanaVizPromptComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (DanaVizPromptModule) Preconditions.getAuthRequestContext(new DanaVizPromptModule(new DanaVizPromptContract.View() { // from class: id.dana.danaviz.DanaVizPromptActivity$initComponent$1
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

            @Override // id.dana.danaviz.DanaVizPromptContract.View
            public final void PlaceComponentResult() {
                DanaVizPromptActivity.this.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.danaviz.DanaVizPromptContract.View
            public final void getAuthRequestContext() {
                DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
                DanaVizPromptActivity danaVizPromptActivity = DanaVizPromptActivity.this;
                DanaVizPromptActivity danaVizPromptActivity2 = danaVizPromptActivity;
                String string = danaVizPromptActivity.getString(R.string.dana_viz_prompt_toast_error_activation);
                Intrinsics.checkNotNullExpressionValue(string, "");
                DANAToast.MyBillsEntityDataFactory(danaVizPromptActivity2, string, "");
            }

            @Override // id.dana.danaviz.DanaVizPromptContract.View
            public final void MyBillsEntityDataFactory(String p0, String p1, boolean p2) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                ChallengeControl.Builder builder = new ChallengeControl.Builder(DanaVizPromptActivity.this);
                builder.scheduleImpl = "face_activation";
                builder.VerifyPinStateManager$executeRiskChallenge$2$1 = ChallengeControl.Key.FACE_ACTIVATION_SMART_PAY;
                new ChallengeControl(builder.MyBillsEntityDataFactory(false, p0, p1, p2), null).getAuthRequestContext();
            }

            @Override // id.dana.danaviz.DanaVizPromptContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                DanaVizPromptActivity.access$goToHome(DanaVizPromptActivity.this);
            }
        }));
        Application application = getApplication();
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) application).getApplicationComponent());
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, DanaVizPromptModule.class);
        if (MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = new FaceAuthenticationModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerDanaVizPromptComponent.DanaVizPromptComponentImpl(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.MyBillsEntityDataFactory, (byte) 0).MyBillsEntityDataFactory(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1002) {
            if (resultCode == -1) {
                KClassImpl$Data$declaredNonStaticMembers$2();
                return;
            }
            DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
            String string = getString(R.string.dana_viz_prompt_toast_error_activation);
            Intrinsics.checkNotNullExpressionValue(string, "");
            DANAToast.MyBillsEntityDataFactory(this, string, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        CustomDialog.Builder builder = new CustomDialog.Builder(this);
        builder.SubSequence = getString(R.string.dana_viz_prompt_dialog_success_verification_title);
        builder.DatabaseTableConfigUtil = R.drawable.ic_dana_viz_verified;
        builder.GetContactSyncConfig = getString(R.string.dana_viz_prompt_dialog_success_verification_subtitle);
        CustomDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(getString(R.string.dana_viz_prompt_dialog_success_verification_button), new Function1<View, Unit>() { // from class: id.dana.danaviz.DanaVizPromptActivity$showSuccessDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                DanaVizPromptActivity.access$goToHome(DanaVizPromptActivity.this);
            }
        });
        id.dana.component.extension.ViewExtKt.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(), BuiltInFictitiousFunctionClassFactory.moveToNextValue);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\t"}, d2 = {"Lid/dana/danaviz/DanaVizPromptActivity$Companion;", "", "Landroid/content/Context;", "p0", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "(Landroid/content/Context;)Landroid/content/Intent;", "", "DANA_VIZ_DETAIL_URL", "Ljava/lang/String;", "", "MARGIN_RIGHT_BUTTON_TOOLBAR", LogConstants.RESULT_FALSE, "MARGIN_TOOLTIP_ARROW", "RESET_PIN", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Intent MyBillsEntityDataFactory(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new Intent(p0, DanaVizPromptActivity.class);
        }
    }

    public static /* synthetic */ void $r8$lambda$Q5lhVWudkhmCE1YtZ6NDZLyiLc8(DanaVizPromptActivity danaVizPromptActivity, View view) {
        Intrinsics.checkNotNullParameter(danaVizPromptActivity, "");
        LayoutToolbarBinding layoutToolbarBinding = danaVizPromptActivity.getBinding().scheduleImpl;
        int[] iArr = new int[2];
        layoutToolbarBinding.getErrorConfigVersion.getLocationInWindow(iArr);
        DanaVizPromptActivity danaVizPromptActivity2 = danaVizPromptActivity;
        Target KClassImpl$Data$declaredNonStaticMembers$22 = new TargetBuilder(danaVizPromptActivity2).BuiltInFictitiousFunctionClassFactory((iArr[0] + layoutToolbarBinding.getErrorConfigVersion.getWidth()) - ViewExtKt.PlaceComponentResult(24.0f), iArr[1] + (layoutToolbarBinding.getErrorConfigVersion.getHeight() / 2)).BuiltInFictitiousFunctionClassFactory(new CircleShape(layoutToolbarBinding.getErrorConfigVersion.getWidth())).getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$22, "");
        DanaVizPromptShowcaseBuilder KClassImpl$Data$declaredNonStaticMembers$23 = new DanaVizPromptShowcaseBuilder(danaVizPromptActivity2, KClassImpl$Data$declaredNonStaticMembers$22).KClassImpl$Data$declaredNonStaticMembers$2(R.color.transparent);
        String string = danaVizPromptActivity.getString(R.string.dana_viz_prompt_information_tooltip);
        Intrinsics.checkNotNullExpressionValue(string, "");
        Intrinsics.checkNotNullParameter(string, "");
        KClassImpl$Data$declaredNonStaticMembers$23.moveToNextValue = string;
        KClassImpl$Data$declaredNonStaticMembers$23.BuiltInFictitiousFunctionClassFactory(true).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* renamed from: $r8$lambda$_-jxT7OS4pulLyxRmnncSe8vhl8  reason: not valid java name */
    public static /* synthetic */ void m733$r8$lambda$_jxT7OS4pulLyxRmnncSe8vhl8(DanaVizPromptActivity danaVizPromptActivity, View view) {
        Intrinsics.checkNotNullParameter(danaVizPromptActivity, "");
        danaVizPromptActivity.getPresenter().MyBillsEntityDataFactory();
    }

    public static /* synthetic */ void $r8$lambda$e9m2lrFRIBrd6OBEqLZPPMnU88o(DanaVizPromptActivity danaVizPromptActivity, View view) {
        Intrinsics.checkNotNullParameter(danaVizPromptActivity, "");
        danaVizPromptActivity.getPresenter().MyBillsEntityDataFactory(true, danaVizPromptActivity, "", "RESET_PIN");
    }

    public static final /* synthetic */ void access$goToHome(DanaVizPromptActivity danaVizPromptActivity) {
        Intent data = new Intent(danaVizPromptActivity, HomeTabActivity.class).setData(danaVizPromptActivity.getIntent().getData());
        Intrinsics.checkNotNullExpressionValue(data, "");
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        Intrinsics.checkNotNullParameter(TrackerKey.Event.APP_TOTAL_LOGIN_TIME, "");
        OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, TrackerKey.Event.APP_TOTAL_LOGIN_TIME);
        danaVizPromptActivity.startActivity(data);
        danaVizPromptActivity.finish();
    }

    private static void b(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = getAuthRequestContext;
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
