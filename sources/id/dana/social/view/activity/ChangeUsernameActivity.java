package id.dana.social.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.RxTextView;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.domain.social.model.FeedConfig;
import id.dana.extension.view.InputExtKt;
import id.dana.feeds.data.username.model.UsernameCheck;
import id.dana.myprofile.MyProfileBundleKey;
import id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.social.contract.RelationshipBottomSheetContract;
import id.dana.social.contract.UsernameContract;
import id.dana.social.di.module.RelationshipBottomSheetModule;
import id.dana.social.di.module.UsernameModule;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u001a\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0013\u0010\n\u001a\u00020\u0005*\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/social/view/activity/ChangeUsernameActivity;", "Lid/dana/base/BaseActivity;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "onBackPressed", "Lid/dana/component/buttoncomponent/DanaButtonPrimaryView;", "MyBillsEntityDataFactory", "(Lid/dana/component/buttoncomponent/DanaButtonPrimaryView;)V", "Lid/dana/social/contract/RelationshipBottomSheetContract$Presenter;", "settingPresenter", "Lid/dana/social/contract/RelationshipBottomSheetContract$Presenter;", "getSettingPresenter", "()Lid/dana/social/contract/RelationshipBottomSheetContract$Presenter;", "setSettingPresenter", "(Lid/dana/social/contract/RelationshipBottomSheetContract$Presenter;)V", "Lid/dana/social/contract/UsernameContract$Presenter;", "usernamePresenter", "Lid/dana/social/contract/UsernameContract$Presenter;", "getUsernamePresenter", "()Lid/dana/social/contract/UsernameContract$Presenter;", "setUsernamePresenter", "(Lid/dana/social/contract/UsernameContract$Presenter;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChangeUsernameActivity extends BaseActivity {
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
    public static final String PARAM_FROM_DEEPLINK = "PARAM_FROM_DEEPLINK";
    public static final String PARAM_ILLEGAL_ERROR_CODE = "AE15012158172008";
    public static final String PARAM_USERNAME = "PARAM_USERNAME";
    private static long lookAheadTest;
    private static char scheduleImpl;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public RelationshipBottomSheetContract.Presenter settingPresenter;
    @Inject
    public UsernameContract.Presenter usernamePresenter;
    public static final byte[] $$a = {Ascii.US, -80, -88, -103, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 67;
    public static final byte[] getAuthRequestContext = {Ascii.ESC, -74, -29, -66, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 4;

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        scheduleImpl = (char) 13492;
        lookAheadTest = -6263076069434627631L;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = -956812108;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.social.view.activity.ChangeUsernameActivity.getAuthRequestContext
            int r7 = r7 + 16
            int r9 = r9 + 97
            int r8 = 55 - r8
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L2f
        L14:
            r3 = 0
        L15:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            int r8 = r8 + 1
            if (r4 != r7) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L2f:
            int r10 = r10 + r8
            int r8 = r10 + (-4)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.view.activity.ChangeUsernameActivity.a(short, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = 103 - r8
            int r7 = r7 + 4
            int r6 = r6 * 3
            int r6 = r6 + 21
            byte[] r0 = id.dana.social.view.activity.ChangeUsernameActivity.$$a
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r8
            r3 = 0
            r8 = r7
            goto L2e
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r7 = r7 + 1
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
        L2e:
            int r7 = r7 + r4
            int r7 = r7 + (-7)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.view.activity.ChangeUsernameActivity.c(short, int, short, java.lang.Object[]):void");
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
        b(new char[]{23909, 18145, 20345, 38288}, new char[]{26006, 58559, 34958, 25417}, (-1) - TextUtils.lastIndexOf("", '0', 0, 0), (char) (View.MeasureSpec.getSize(0) + 18824), new char[]{39591, 11133, 62327, 1311, 335, 64180, 26758, 41700, 57524, 2429, 15992, 14178, 61938, 60736, 18232, 7709, 17328, 7769}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(new char[]{23909, 18145, 20345, 38288}, new char[]{32312, 37644, 33275, 65114}, (-74249090) - View.resolveSize(0, 0), (char) (TextUtils.getTrimmedLength("") + 23169), new char[]{40738, 19730, 11523, 58152, 31533}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 930, (Process.myTid() >> 22) + 35, (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(new char[]{23909, 18145, 20345, 38288}, new char[]{39233, 18578, 62686, 44091}, ViewConfiguration.getDoubleTapTimeout() >> 16, (char) ((-16777216) - Color.rgb(0, 0, 0)), new char[]{28696, 4277, 44597, 16190, 43334, 23349, 64974, 39669, 41820, 12416, 15088, 27968, 27224, 14822, 15609, 56587, 17055, 58830, 15483, 55288, 54057, 7062, 8530, 61178, 64892, 25076, 47284, 59590, 64772, 1636, 9507, 44956, 29691, 51515, 6431, 60404, 39909, 48652, 42282, 61730, 14942, 34074, 50441, 53878, 20508, 58118, 25420, 7763}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(new char[]{23909, 18145, 20345, 38288}, new char[]{3263, 59260, 17046, 20148}, TextUtils.getTrimmedLength(""), (char) View.MeasureSpec.makeMeasureSpec(0, 0), new char[]{1420, 14836, 31516, 2101, 63095, 7865, 58826, 45389, 54453, 32689, 8643, 59026, 25200, 63164, 40569, 9344, 32104, 48901, 6866, 63592, 9419, 61557, 8336, 51810, 1320, 13959, 17560, 65519, 57205, 28096, 26882, 48976, 16123, 65408, 48769, 6652, 55744, 30721, 54951, 38927, 9265, 28598, 13472, 4305, 22174, 36166, 49524, 43910, 47098, 34860, 61665, 45278, 28326, 953, 8342, 5251, 49477, 5618, 13636, 19604, 17890, 30799, 25428, 12672}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(new char[]{23909, 18145, 20345, 38288}, new char[]{25863, 48089, 1297, 7335}, ExpandableListView.getPackedPositionChild(0L) + 1, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1), new char[]{7132, 26336, 60069, 25821, 10865, 32254, 45900, 36149, 38596, 60485, 39309, 50678, 29840, 2577, 35244, 4998, 46819, 15243, 45269, 4602, 36401, 54677, 36254, 52068, 58187, 20120, 25659, 31607, 23939, 39025, 62961, 24302, 47113, 47512, 64610, 10161, 4918, 39920, 61493, 60591, 35257, 49837, 42984, 28931, 9679, 46059, 57552, 29148, 45367, 56018, 6102, 61321, 48386, 41969, 25358, 6638, 49499, 44351, 26891, 11853, 31151, 62041, 26870, 24452}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(new char[]{23909, 18145, 20345, 38288}, new char[]{21311, 60030, 56328, 7242}, (-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1), new char[]{60343, 60293, 49353, 17122, 32014, 34952, 61844, 18281, 27576, 65522, 33267, 7289, 55056, 15395, 31406, 28809, 2164, 17922, 865, 53453, 32787, 47864, 32688, 45644, 13082, 24873, 59077, 39559, 3909, 13335, 55942, 10390, 51423, 44843, 10220, 38131, 16101, 56092, 10940, 12716, 10846, 20844, 26991, 31375, 4602, 51052, 34968, 25991, 58823, 34282, 33701, 29445, 64210, 40360, 56841, 55271, 38441, 8256, 57106, 9664}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(new char[]{23909, 18145, 20345, 38288}, new char[]{13941, 36775, 17279, 32443}, TextUtils.indexOf("", ""), (char) (Gravity.getAbsoluteGravity(0, 0) + 47939), new char[]{23601, 42261, 58418, 56424, 17922, 64185}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + 911, (ViewConfiguration.getEdgeSlop() >> 16) + 18, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                Object[] objArr13 = {this};
                Object[] objArr14 = new Object[1];
                a(getAuthRequestContext[25], getAuthRequestContext[31], getAuthRequestContext[32], objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                byte b = getAuthRequestContext[25];
                byte b2 = (byte) (b | Ascii.RS);
                Object[] objArr15 = new Object[1];
                a(b, b2, (byte) (b2 & 40), objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 56, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 2, (char) TextUtils.getOffsetAfter("", 0));
                        Object[] objArr17 = new Object[1];
                        c($$a[78], $$a[47], $$a[12], objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 801, View.combineMeasuredStates(0, 0) + 15, (char) Color.argb(0, 0, 0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 800, Drawable.resolveOpacity(0, 0) + 15, (char) (Process.myTid() >> 22))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(816 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 30 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 57993))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 800, 16 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) ((-1) - ImageFormat.getBitsPerPixel(0))));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr18));
                                    long j = ((r8 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 34, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {857970136, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 18 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr20 = {this};
                Object[] objArr21 = new Object[1];
                a(getAuthRequestContext[25], getAuthRequestContext[31], getAuthRequestContext[32], objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                byte b3 = getAuthRequestContext[25];
                byte b4 = (byte) (b3 | Ascii.RS);
                Object[] objArr22 = new Object[1];
                a(b3, b4, (byte) (b4 & 40), objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + 61, 46 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) (ViewConfiguration.getScrollBarSize() >> 8));
                        Object[] objArr24 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[28], (byte) ($$a[78] - 1), objArr24);
                        obj9 = cls5.getMethod((String) objArr24[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr25 = (Object[]) ((Method) obj9).invoke(null, objArr23);
                    int i = ((int[]) objArr25[1])[0];
                    if (((int[]) objArr25[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr26 = {857970136, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), 17 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) KeyEvent.keyCodeFromString(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr26);
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
                Object[] objArr27 = {this};
                Object[] objArr28 = new Object[1];
                a(getAuthRequestContext[25], getAuthRequestContext[31], getAuthRequestContext[32], objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                byte b5 = getAuthRequestContext[25];
                byte b6 = (byte) (b5 | Ascii.RS);
                Object[] objArr29 = new Object[1];
                a(b5, b6, (byte) (b6 & 40), objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 119, 3 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (38968 - ExpandableListView.getPackedPositionGroup(0L)));
                        Object[] objArr31 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[28], (byte) ($$a[78] - 1), objArr31);
                        obj12 = cls7.getMethod((String) objArr31[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr32 = (Object[]) ((Method) obj12).invoke(null, objArr30);
                    int i2 = ((int[]) objArr32[1])[0];
                    if (((int[]) objArr32[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), Color.blue(0) + 35, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {857970136, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0'), ImageFormat.getBitsPerPixel(0) + 19, (char) Color.green(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr33);
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
                Object[] objArr34 = {this};
                Object[] objArr35 = new Object[1];
                a(getAuthRequestContext[25], getAuthRequestContext[31], getAuthRequestContext[32], objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                byte b7 = getAuthRequestContext[25];
                byte b8 = (byte) (b7 | Ascii.RS);
                Object[] objArr36 = new Object[1];
                a(b7, b8, (byte) (b8 & 40), objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 107, (ViewConfiguration.getLongPressTimeout() >> 16) + 3, (char) TextUtils.getOffsetAfter("", 0));
                        Object[] objArr38 = new Object[1];
                        c($$a[8], (byte) (-$$a[40]), $$a[9], objArr38);
                        obj15 = cls9.getMethod((String) objArr38[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr39 = (Object[]) ((Method) obj15).invoke(null, objArr37);
                    int i3 = ((int[]) objArr39[1])[0];
                    if (((int[]) objArr39[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ((Process.getThreadPriority(0) + 20) >> 6), 35 - View.combineMeasuredStates(0, 0), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr40 = {857970136, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getMode(0), ((Process.getThreadPriority(0) + 20) >> 6) + 18, (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr40);
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

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_change_username;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        char[] cArr = {23909, 18145, 20345, 38288};
        char[] cArr2 = {26006, 58559, 34958, 25417};
        int resolveOpacity = Drawable.resolveOpacity(0, 0);
        try {
            Object[] objArr2 = new Object[1];
            a((byte) (-getAuthRequestContext[30]), (byte) (PlaceComponentResult | 48), getAuthRequestContext[25], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            a(getAuthRequestContext[56], getAuthRequestContext[25], (byte) (-getAuthRequestContext[5]), objArr3);
            Object[] objArr4 = new Object[1];
            b(cArr, cArr2, resolveOpacity, (char) (((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 18791), new char[]{39591, 11133, 62327, 1311, 335, 64180, 26758, 41700, 57524, 2429, 15992, 14178, 61938, 60736, 18232, 7709, 17328, 7769}, objArr4);
            Class<?> cls2 = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            b(new char[]{23909, 18145, 20345, 38288}, new char[]{32312, 37644, 33275, 65114}, TextUtils.indexOf("", "", 0, 0) - 74249090, (char) (getPackageName().length() + 23162), new char[]{40738, 19730, 11523, 58152, 31533}, objArr5);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    char[] cArr3 = {23909, 18145, 20345, 38288};
                    char[] cArr4 = {64897, 61502, 29296, 30522};
                    try {
                        Object[] objArr6 = new Object[1];
                        a((byte) (-getAuthRequestContext[30]), (byte) (PlaceComponentResult | 48), getAuthRequestContext[25], objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        a(getAuthRequestContext[56], getAuthRequestContext[25], (byte) (-getAuthRequestContext[5]), new Object[1]);
                        Object[] objArr7 = new Object[1];
                        b(cArr3, cArr4, ((ApplicationInfo) cls3.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (getPackageName().codePointAt(1) + 14862), new char[]{30930, 39505, 7700, 31263, 61470, 51018, 35443, 62646, 25553, 61606, 45933, 38936, 25476, 24570, 61972, 1566, 37851, 39590, 14433, 1680, 52416, 38669, 60701, 10094, 17289, 25546}, objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        char[] cArr5 = {23909, 18145, 20345, 38288};
                        char[] cArr6 = {57040, 45527, 11682, 23080};
                        try {
                            Object[] objArr8 = new Object[1];
                            a((byte) (-getAuthRequestContext[30]), (byte) (PlaceComponentResult | 48), getAuthRequestContext[25], objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            a(getAuthRequestContext[56], getAuthRequestContext[25], (byte) (-getAuthRequestContext[5]), new Object[1]);
                            Object[] objArr9 = new Object[1];
                            b(cArr5, cArr6, ((ApplicationInfo) cls5.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (super.getResources().getString(R.string.my_bills_delete_bills_dialog_confirmation_title_description).substring(0, 1).length() + 10284), new char[]{20568, 5341, 62821, 40462, 3222, 10635, 46669, 53411, 34693, 64342, 378, 28530, 64917, 20948, 53899, 64663, 50160, 54988}, objArr9);
                            baseContext = (Context) cls4.getMethod((String) objArr9[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getFadingEdgeLength() >> 16), Color.blue(0) + 35, (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        char[] cArr7 = {23909, 18145, 20345, 38288};
                        char[] cArr8 = {39233, 18578, 62686, 44091};
                        try {
                            Object[] objArr10 = new Object[1];
                            a((byte) (-getAuthRequestContext[30]), (byte) (PlaceComponentResult | 48), getAuthRequestContext[25], objArr10);
                            Class<?> cls6 = Class.forName((String) objArr10[0]);
                            a(getAuthRequestContext[56], getAuthRequestContext[25], (byte) (-getAuthRequestContext[5]), new Object[1]);
                            Object[] objArr11 = new Object[1];
                            b(cArr7, cArr8, ((ApplicationInfo) cls6.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (super.getResources().getString(R.string.checking).substring(9, 11).length() - 2), new char[]{28696, 4277, 44597, 16190, 43334, 23349, 64974, 39669, 41820, 12416, 15088, 27968, 27224, 14822, 15609, 56587, 17055, 58830, 15483, 55288, 54057, 7062, 8530, 61178, 64892, 25076, 47284, 59590, 64772, 1636, 9507, 44956, 29691, 51515, 6431, 60404, 39909, 48652, 42282, 61730, 14942, 34074, 50441, 53878, 20508, 58118, 25420, 7763}, objArr11);
                            String str = (String) objArr11[0];
                            Object[] objArr12 = new Object[1];
                            b(new char[]{23909, 18145, 20345, 38288}, new char[]{3263, 59260, 17046, 20148}, ViewConfiguration.getMaximumDrawingCacheSize() >> 24, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1), new char[]{1420, 14836, 31516, 2101, 63095, 7865, 58826, 45389, 54453, 32689, 8643, 59026, 25200, 63164, 40569, 9344, 32104, 48901, 6866, 63592, 9419, 61557, 8336, 51810, 1320, 13959, 17560, 65519, 57205, 28096, 26882, 48976, 16123, 65408, 48769, 6652, 55744, 30721, 54951, 38927, 9265, 28598, 13472, 4305, 22174, 36166, 49524, 43910, 47098, 34860, 61665, 45278, 28326, 953, 8342, 5251, 49477, 5618, 13636, 19604, 17890, 30799, 25428, 12672}, objArr12);
                            String str2 = (String) objArr12[0];
                            Object[] objArr13 = new Object[1];
                            b(new char[]{23909, 18145, 20345, 38288}, new char[]{25863, 48089, 1297, 7335}, 1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (getPackageName().codePointAt(2) - 46), new char[]{7132, 26336, 60069, 25821, 10865, 32254, 45900, 36149, 38596, 60485, 39309, 50678, 29840, 2577, 35244, 4998, 46819, 15243, 45269, 4602, 36401, 54677, 36254, 52068, 58187, 20120, 25659, 31607, 23939, 39025, 62961, 24302, 47113, 47512, 64610, 10161, 4918, 39920, 61493, 60591, 35257, 49837, 42984, 28931, 9679, 46059, 57552, 29148, 45367, 56018, 6102, 61321, 48386, 41969, 25358, 6638, 49499, 44351, 26891, 11853, 31151, 62041, 26870, 24452}, objArr13);
                            String str3 = (String) objArr13[0];
                            Object[] objArr14 = new Object[1];
                            b(new char[]{23909, 18145, 20345, 38288}, new char[]{21311, 60030, 56328, 7242}, (-1) - ImageFormat.getBitsPerPixel(0), (char) (getPackageName().length() - 7), new char[]{60343, 60293, 49353, 17122, 32014, 34952, 61844, 18281, 27576, 65522, 33267, 7289, 55056, 15395, 31406, 28809, 2164, 17922, 865, 53453, 32787, 47864, 32688, 45644, 13082, 24873, 59077, 39559, 3909, 13335, 55942, 10390, 51423, 44843, 10220, 38131, 16101, 56092, 10940, 12716, 10846, 20844, 26991, 31375, 4602, 51052, 34968, 25991, 58823, 34282, 33701, 29445, 64210, 40360, 56841, 55271, 38441, 8256, 57106, 9664}, objArr14);
                            String str4 = (String) objArr14[0];
                            char[] cArr9 = {23909, 18145, 20345, 38288};
                            char[] cArr10 = {13941, 36775, 17279, 32443};
                            try {
                                Object[] objArr15 = new Object[1];
                                a((byte) (-getAuthRequestContext[30]), (byte) (PlaceComponentResult | 48), getAuthRequestContext[25], objArr15);
                                Class<?> cls7 = Class.forName((String) objArr15[0]);
                                a(getAuthRequestContext[56], getAuthRequestContext[25], (byte) (-getAuthRequestContext[5]), new Object[1]);
                                Object[] objArr16 = new Object[1];
                                b(cArr9, cArr10, ((ApplicationInfo) cls7.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (KeyEvent.getDeadChar(0, 0) + 47939), new char[]{23601, 42261, 58418, 56424, 17922, 64185}, objArr16);
                                try {
                                    Object[] objArr17 = {baseContext, str, str2, str3, str4, true, (String) objArr16[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 911, TextUtils.indexOf("", "") + 18, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr17);
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
                    } catch (Throwable th6) {
                        Throwable cause6 = th6.getCause();
                        if (cause6 == null) {
                            throw th6;
                        }
                        throw cause6;
                    }
                }
            }
            try {
                Object[] objArr18 = new Object[1];
                a(getAuthRequestContext[25], getAuthRequestContext[31], getAuthRequestContext[32], objArr18);
                Class<?> cls8 = Class.forName((String) objArr18[0]);
                byte b = getAuthRequestContext[25];
                byte b2 = (byte) (b | Ascii.RS);
                Object[] objArr19 = new Object[1];
                a(b, b2, (byte) (b2 & 40), objArr19);
                try {
                    Object[] objArr20 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr19[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 494, 4 - Color.argb(0, 0, 0, 0), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)));
                        Object[] objArr21 = new Object[1];
                        c($$a[8], (byte) (-$$a[40]), $$a[9], objArr21);
                        obj3 = cls9.getMethod((String) objArr21[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr22 = (Object[]) ((Method) obj3).invoke(null, objArr20);
                    int i = ((int[]) objArr22[1])[0];
                    if (((int[]) objArr22[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.indexOf((CharSequence) "", '0'), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr23 = {-1351952871, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 911, Process.getGidForName("") + 19, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr23);
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
                    }
                    super.onCreate(bundle);
                } catch (Throwable th9) {
                    Throwable cause9 = th9.getCause();
                    if (cause9 == null) {
                        throw th9;
                    }
                    throw cause9;
                }
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            char[] cArr = {23909, 18145, 20345, 38288};
            char[] cArr2 = {64897, 61502, 29296, 30522};
            int scrollBarFadeDuration = ViewConfiguration.getScrollBarFadeDuration() >> 16;
            try {
                Object[] objArr = new Object[1];
                a((byte) (-getAuthRequestContext[30]), (byte) (PlaceComponentResult | 48), getAuthRequestContext[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a(getAuthRequestContext[56], getAuthRequestContext[25], (byte) (-getAuthRequestContext[5]), objArr2);
                try {
                    Object[] objArr3 = new Object[1];
                    b(cArr, cArr2, scrollBarFadeDuration, (char) (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 14929), new char[]{30930, 39505, 7700, 31263, 61470, 51018, 35443, 62646, 25553, 61606, 45933, 38936, 25476, 24570, 61972, 1566, 37851, 39590, 14433, 1680, 52416, 38669, 60701, 10094, 17289, 25546}, objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    Object[] objArr4 = new Object[1];
                    b(new char[]{23909, 18145, 20345, 38288}, new char[]{57040, 45527, 11682, 23080}, (-1) - TextUtils.lastIndexOf("", '0', 0), (char) (getPackageName().codePointAt(3) + 10185), new char[]{20568, 5341, 62821, 40462, 3222, 10635, 46669, 53411, 34693, 64342, 378, 28530, 64917, 20948, 53899, 64663, 50160, 54988}, objArr4);
                    baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
                } catch (Throwable th) {
                    th = th;
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - ImageFormat.getBitsPerPixel(0), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778127, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) TextUtils.indexOf("", ""))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
                } catch (Throwable th3) {
                    Throwable cause2 = th3.getCause();
                    if (cause2 == null) {
                        throw th3;
                    }
                    throw cause2;
                }
            } catch (Throwable th4) {
                Throwable cause3 = th4.getCause();
                if (cause3 == null) {
                    throw th4;
                }
                throw cause3;
            }
        }
        super.onPause();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(new char[]{23909, 18145, 20345, 38288}, new char[]{64897, 61502, 29296, 30522}, super.getResources().getString(R.string.error_updating_app_toast).substring(15, 18).codePointAt(0) - 32, (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 14962), new char[]{30930, 39505, 7700, 31263, 61470, 51018, 35443, 62646, 25553, 61606, 45933, 38936, 25476, 24570, 61972, 1566, 37851, 39590, 14433, 1680, 52416, 38669, 60701, 10094, 17289, 25546}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(new char[]{23909, 18145, 20345, 38288}, new char[]{57040, 45527, 11682, 23080}, TextUtils.indexOf("", ""), (char) (10285 - ((Process.getThreadPriority(0) + 20) >> 6)), new char[]{20568, 5341, 62821, 40462, 3222, 10635, 46669, 53411, 34693, 64342, 378, 28530, 64917, 20948, 53899, 64663, 50160, 54988}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, Color.rgb(0, 0, 0) + 16777251, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 911, Color.green(0) + 18, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getUsernamePresenter")
    public final UsernameContract.Presenter getUsernamePresenter() {
        UsernameContract.Presenter presenter = this.usernamePresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setUsernamePresenter")
    public final void setUsernamePresenter(UsernameContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.usernamePresenter = presenter;
    }

    @JvmName(name = "getSettingPresenter")
    public final RelationshipBottomSheetContract.Presenter getSettingPresenter() {
        RelationshipBottomSheetContract.Presenter presenter = this.settingPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSettingPresenter")
    public final void setSettingPresenter(RelationshipBottomSheetContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.settingPresenter = presenter;
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        Bundle extras;
        Intent intent = getIntent();
        Unit unit = null;
        if (intent != null && (extras = intent.getExtras()) != null) {
            if (extras.getBoolean(PARAM_FROM_DEEPLINK, false)) {
                RelationshipBottomSheetContract.Presenter.CC.BuiltInFictitiousFunctionClassFactory(getSettingPresenter());
            } else {
                super.onBackPressed();
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            super.onBackPressed();
        }
    }

    private static void MyBillsEntityDataFactory(DanaButtonPrimaryView danaButtonPrimaryView) {
        String string = danaButtonPrimaryView.getContext().getString(R.string.submit);
        if (string == null) {
            string = "";
        }
        danaButtonPrimaryView.setDanaButtonView(1, string, "", null);
        danaButtonPrimaryView.setEnabled(true);
    }

    public static /* synthetic */ void $r8$lambda$Vf1Lr0NsLlOBj30LKJG7HLXU3A0(ChangeUsernameActivity changeUsernameActivity, View view) {
        Editable text;
        String obj;
        Intrinsics.checkNotNullParameter(changeUsernameActivity, "");
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) changeUsernameActivity._$_findCachedViewById(R.id.getDefaultSenderId_res_0x7f0a0238);
        String str = null;
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setDanaButtonView(0, danaButtonPrimaryView.getContext().getString(R.string.submit), "", null);
            danaButtonPrimaryView.setEnabled(false);
        }
        UsernameContract.Presenter usernamePresenter = changeUsernameActivity.getUsernamePresenter();
        AppCompatEditText appCompatEditText = (AppCompatEditText) changeUsernameActivity._$_findCachedViewById(R.id.et_username);
        if (appCompatEditText != null && (text = appCompatEditText.getText()) != null && (obj = text.toString()) != null) {
            str = StringsKt.trim((CharSequence) obj).toString();
        }
        usernamePresenter.KClassImpl$Data$declaredNonStaticMembers$2(str != null ? str : "");
    }

    public static final /* synthetic */ void access$displayChangeUsernameSuccessToast(ChangeUsernameActivity changeUsernameActivity) {
        CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
        ChangeUsernameActivity changeUsernameActivity2 = changeUsernameActivity;
        String string = changeUsernameActivity.getResources().getString(R.string.username_submitted);
        Intrinsics.checkNotNullExpressionValue(string, "");
        CustomToast.MyBillsEntityDataFactory(changeUsernameActivity2, R.drawable.ic_success, R.drawable.bg_rounded_border_green_50, string);
    }

    public static final /* synthetic */ void access$displayErrorToast(ChangeUsernameActivity changeUsernameActivity, String str) {
        CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
        CustomToast.MyBillsEntityDataFactory(changeUsernameActivity, R.drawable.ic_warning_yellow, R.drawable.bg_rounded_border_yellow_50, str);
    }

    public static final /* synthetic */ void access$openSettingsMoreActivity(ChangeUsernameActivity changeUsernameActivity, SettingModel settingModel) {
        Bundle extras;
        Intent intent = new Intent(changeUsernameActivity, ProfileSettingsActivity.class);
        intent.putExtra(MyProfileBundleKey.SETTING_MODEL, settingModel);
        Intent intent2 = changeUsernameActivity.getIntent();
        if (intent2 != null && (extras = intent2.getExtras()) != null && extras.getBoolean(PARAM_FROM_DEEPLINK, false)) {
            intent.addFlags(335544320);
        }
        changeUsernameActivity.startActivity(intent);
        changeUsernameActivity.finish();
    }

    public static final /* synthetic */ void access$renderSubmitError(ChangeUsernameActivity changeUsernameActivity, String str) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) changeUsernameActivity._$_findCachedViewById(R.id.getSecondaryProgressTintMode);
        if (appCompatTextView != null) {
            appCompatTextView.setText(str);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) changeUsernameActivity._$_findCachedViewById(R.id.getSecondaryProgressTintMode);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(changeUsernameActivity, R.color.f26712131100373));
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) changeUsernameActivity._$_findCachedViewById(R.id.BarLineScatterCandleBubbleRenderer$XBounds);
        if (appCompatTextView3 != null) {
            appCompatTextView3.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(changeUsernameActivity, R.color.f26712131100373));
        }
        AppCompatEditText appCompatEditText = (AppCompatEditText) changeUsernameActivity._$_findCachedViewById(R.id.et_username);
        if (appCompatEditText != null) {
            InputExtKt.BuiltInFictitiousFunctionClassFactory(appCompatEditText, R.color.f26712131100373);
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) changeUsernameActivity._$_findCachedViewById(R.id.lav_loading);
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) changeUsernameActivity._$_findCachedViewById(R.id.StatementViewType);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(8);
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) changeUsernameActivity._$_findCachedViewById(R.id.CircularRevealCoordinatorLayout);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setVisibility(8);
        }
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) changeUsernameActivity._$_findCachedViewById(R.id.newSslSocketFactory);
        if (appCompatImageView3 != null) {
            appCompatImageView3.setVisibility(0);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) changeUsernameActivity._$_findCachedViewById(R.id.cl_bottom_hint);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) changeUsernameActivity._$_findCachedViewById(R.id.getDefaultSenderId_res_0x7f0a0238);
        if (danaButtonPrimaryView != null) {
            MyBillsEntityDataFactory(danaButtonPrimaryView);
        }
    }

    public static final /* synthetic */ void access$renderUsernameEmpty(ChangeUsernameActivity changeUsernameActivity) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) changeUsernameActivity._$_findCachedViewById(R.id.BarLineScatterCandleBubbleRenderer$XBounds);
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(changeUsernameActivity, R.color.f26762131100391));
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) changeUsernameActivity._$_findCachedViewById(R.id.lav_loading);
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) changeUsernameActivity._$_findCachedViewById(R.id.StatementViewType);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(8);
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) changeUsernameActivity._$_findCachedViewById(R.id.CircularRevealCoordinatorLayout);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setVisibility(0);
        }
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) changeUsernameActivity._$_findCachedViewById(R.id.newSslSocketFactory);
        if (appCompatImageView3 != null) {
            appCompatImageView3.setVisibility(8);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) changeUsernameActivity._$_findCachedViewById(R.id.cl_bottom_hint);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) changeUsernameActivity._$_findCachedViewById(R.id.getDefaultSenderId_res_0x7f0a0238);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setDanaButtonView(0, danaButtonPrimaryView.getContext().getString(R.string.submit), "", null);
            danaButtonPrimaryView.setEnabled(false);
        }
    }

    public static final /* synthetic */ void access$renderUsernameError(ChangeUsernameActivity changeUsernameActivity, String str) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) changeUsernameActivity._$_findCachedViewById(R.id.getSecondaryProgressTintMode);
        if (appCompatTextView != null) {
            appCompatTextView.setText(str);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) changeUsernameActivity._$_findCachedViewById(R.id.getSecondaryProgressTintMode);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(changeUsernameActivity, R.color.f26712131100373));
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) changeUsernameActivity._$_findCachedViewById(R.id.BarLineScatterCandleBubbleRenderer$XBounds);
        if (appCompatTextView3 != null) {
            appCompatTextView3.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(changeUsernameActivity, R.color.f26712131100373));
        }
        AppCompatEditText appCompatEditText = (AppCompatEditText) changeUsernameActivity._$_findCachedViewById(R.id.et_username);
        if (appCompatEditText != null) {
            InputExtKt.BuiltInFictitiousFunctionClassFactory(appCompatEditText, R.color.f26712131100373);
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) changeUsernameActivity._$_findCachedViewById(R.id.lav_loading);
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) changeUsernameActivity._$_findCachedViewById(R.id.StatementViewType);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(8);
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) changeUsernameActivity._$_findCachedViewById(R.id.CircularRevealCoordinatorLayout);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setVisibility(8);
        }
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) changeUsernameActivity._$_findCachedViewById(R.id.newSslSocketFactory);
        if (appCompatImageView3 != null) {
            appCompatImageView3.setVisibility(0);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) changeUsernameActivity._$_findCachedViewById(R.id.cl_bottom_hint);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) changeUsernameActivity._$_findCachedViewById(R.id.getDefaultSenderId_res_0x7f0a0238);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setDanaButtonView(0, danaButtonPrimaryView.getContext().getString(R.string.submit), "", null);
            danaButtonPrimaryView.setEnabled(false);
        }
    }

    public static final /* synthetic */ void access$renderUsernameLoading(ChangeUsernameActivity changeUsernameActivity) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) changeUsernameActivity._$_findCachedViewById(R.id.getSecondaryProgressTintMode);
        if (appCompatTextView != null) {
            appCompatTextView.setText(changeUsernameActivity.getString(R.string.username_bottom_hint));
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) changeUsernameActivity._$_findCachedViewById(R.id.getSecondaryProgressTintMode);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(changeUsernameActivity, R.color.f26762131100391));
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) changeUsernameActivity._$_findCachedViewById(R.id.BarLineScatterCandleBubbleRenderer$XBounds);
        if (appCompatTextView3 != null) {
            appCompatTextView3.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(changeUsernameActivity, R.color.f26762131100391));
        }
        AppCompatEditText appCompatEditText = (AppCompatEditText) changeUsernameActivity._$_findCachedViewById(R.id.et_username);
        if (appCompatEditText != null) {
            InputExtKt.BuiltInFictitiousFunctionClassFactory(appCompatEditText, R.color.f23962131099992);
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) changeUsernameActivity._$_findCachedViewById(R.id.lav_loading);
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) changeUsernameActivity._$_findCachedViewById(R.id.StatementViewType);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(8);
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) changeUsernameActivity._$_findCachedViewById(R.id.CircularRevealCoordinatorLayout);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setVisibility(0);
        }
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) changeUsernameActivity._$_findCachedViewById(R.id.newSslSocketFactory);
        if (appCompatImageView3 != null) {
            appCompatImageView3.setVisibility(8);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) changeUsernameActivity._$_findCachedViewById(R.id.cl_bottom_hint);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) changeUsernameActivity._$_findCachedViewById(R.id.getDefaultSenderId_res_0x7f0a0238);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setDanaButtonView(0, danaButtonPrimaryView.getContext().getString(R.string.submit), "", null);
            danaButtonPrimaryView.setEnabled(false);
        }
    }

    public static final /* synthetic */ void access$renderUsernameValid(ChangeUsernameActivity changeUsernameActivity) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) changeUsernameActivity._$_findCachedViewById(R.id.getSecondaryProgressTintMode);
        if (appCompatTextView != null) {
            appCompatTextView.setText(changeUsernameActivity.getString(R.string.username_bottom_hint));
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) changeUsernameActivity._$_findCachedViewById(R.id.getSecondaryProgressTintMode);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(changeUsernameActivity, R.color.f26762131100391));
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) changeUsernameActivity._$_findCachedViewById(R.id.BarLineScatterCandleBubbleRenderer$XBounds);
        if (appCompatTextView3 != null) {
            appCompatTextView3.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(changeUsernameActivity, R.color.f26762131100391));
        }
        AppCompatEditText appCompatEditText = (AppCompatEditText) changeUsernameActivity._$_findCachedViewById(R.id.et_username);
        if (appCompatEditText != null) {
            InputExtKt.BuiltInFictitiousFunctionClassFactory(appCompatEditText, R.color.f23962131099992);
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) changeUsernameActivity._$_findCachedViewById(R.id.lav_loading);
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) changeUsernameActivity._$_findCachedViewById(R.id.StatementViewType);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(0);
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) changeUsernameActivity._$_findCachedViewById(R.id.CircularRevealCoordinatorLayout);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setVisibility(0);
        }
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) changeUsernameActivity._$_findCachedViewById(R.id.newSslSocketFactory);
        if (appCompatImageView3 != null) {
            appCompatImageView3.setVisibility(8);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) changeUsernameActivity._$_findCachedViewById(R.id.cl_bottom_hint);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) changeUsernameActivity._$_findCachedViewById(R.id.getDefaultSenderId_res_0x7f0a0238);
        if (danaButtonPrimaryView != null) {
            MyBillsEntityDataFactory(danaButtonPrimaryView);
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        Bundle extras;
        String string;
        AppCompatEditText appCompatEditText;
        setTitle(getResources().getString(R.string.username_toolbar_title));
        setMenuLeftButton(R.drawable.arrow_left_white);
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null && (string = extras.getString(PARAM_USERNAME)) != null && (appCompatEditText = (AppCompatEditText) _$_findCachedViewById(R.id.et_username)) != null) {
            appCompatEditText.setText(string);
            Unit unit = Unit.INSTANCE;
        }
        AppCompatEditText appCompatEditText2 = (AppCompatEditText) _$_findCachedViewById(R.id.et_username);
        if (appCompatEditText2 != null) {
            appCompatEditText2.addTextChangedListener(new TextWatcher() { // from class: id.dana.social.view.activity.ChangeUsernameActivity$setupTextChangedListener$$inlined$onTextAfterChanged$1
                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void afterTextChanged(Editable p0) {
                    String obj = p0 != null ? p0.toString() : null;
                    if (obj == null) {
                        obj = "";
                    }
                    if (obj.length() == 0) {
                        ChangeUsernameActivity.access$renderUsernameEmpty(ChangeUsernameActivity.this);
                    }
                }
            });
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.tv_guideline);
        if (appCompatTextView != null) {
            String string2 = getString(R.string.username_guidelines_span);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            InputExtKt.PlaceComponentResult(appCompatTextView, string2, false, new Function0<Unit>() { // from class: id.dana.social.view.activity.ChangeUsernameActivity$setupSpanText$1
                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String authRequestContext = UrlUtil.getAuthRequestContext(DanaUrl.COMMUNITY_GUIDELINES);
                    Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                    DanaH5.startContainerFullUrl(authRequestContext);
                }
            }, 4);
            Unit unit2 = Unit.INSTANCE;
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.getDefaultSenderId_res_0x7f0a0238);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.activity.ChangeUsernameActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChangeUsernameActivity.$r8$lambda$Vf1Lr0NsLlOBj30LKJG7HLXU3A0(ChangeUsernameActivity.this, view);
                }
            });
            Unit unit3 = Unit.INSTANCE;
        }
        getApplicationComponent().PlaceComponentResult(new UsernameModule(new UsernameContract.View() { // from class: id.dana.social.view.activity.ChangeUsernameActivity$injectDagger$1
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

            @Override // id.dana.social.contract.UsernameContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(UsernameCheck p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ChangeUsernameActivity.access$renderUsernameError(ChangeUsernameActivity.this, p0.MyBillsEntityDataFactory);
            }

            @Override // id.dana.social.contract.UsernameContract.View
            public final void MyBillsEntityDataFactory() {
                ChangeUsernameActivity.access$renderUsernameValid(ChangeUsernameActivity.this);
            }

            @Override // id.dana.social.contract.UsernameContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                ChangeUsernameActivity.access$renderUsernameLoading(ChangeUsernameActivity.this);
            }

            @Override // id.dana.social.contract.UsernameContract.View
            public final void PlaceComponentResult() {
                ChangeUsernameActivity.access$displayChangeUsernameSuccessToast(ChangeUsernameActivity.this);
                ChangeUsernameActivity.this.getSettingPresenter().KClassImpl$Data$declaredNonStaticMembers$2("setting_more");
            }

            @Override // id.dana.social.contract.UsernameContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                ChangeUsernameActivity.access$renderSubmitError(ChangeUsernameActivity.this, p1);
                if (Intrinsics.areEqual(p0, ChangeUsernameActivity.PARAM_ILLEGAL_ERROR_CODE)) {
                    ChangeUsernameActivity changeUsernameActivity = ChangeUsernameActivity.this;
                    String string3 = changeUsernameActivity.getString(R.string.username_error_param);
                    Intrinsics.checkNotNullExpressionValue(string3, "");
                    ChangeUsernameActivity.access$displayErrorToast(changeUsernameActivity, string3);
                    return;
                }
                ChangeUsernameActivity.access$displayErrorToast(ChangeUsernameActivity.this, p1);
            }

            @Override // id.dana.social.contract.UsernameContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                ChangeUsernameActivity changeUsernameActivity = ChangeUsernameActivity.this;
                String string3 = changeUsernameActivity.getString(R.string.username_system_busy);
                Intrinsics.checkNotNullExpressionValue(string3, "");
                ChangeUsernameActivity.access$displayErrorToast(changeUsernameActivity, string3);
            }
        }), new RelationshipBottomSheetModule(new RelationshipBottomSheetContract.View() { // from class: id.dana.social.view.activity.ChangeUsernameActivity$injectDagger$2
            @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
            public final /* synthetic */ String BuiltInFictitiousFunctionClassFactory() {
                return RelationshipBottomSheetContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory() {
                RelationshipBottomSheetContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory(FeedConfig feedConfig) {
                Intrinsics.checkNotNullParameter(feedConfig, "");
            }

            @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory(boolean z) {
                RelationshipBottomSheetContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
            public final /* synthetic */ void PlaceComponentResult() {
                RelationshipBottomSheetContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
            public final /* synthetic */ void PlaceComponentResult(List list) {
                RelationshipBottomSheetContract.View.CC.MyBillsEntityDataFactory(list);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
            public final /* synthetic */ void getAuthRequestContext(ModifyRelationOperationType modifyRelationOperationType) {
                Intrinsics.checkNotNullParameter(modifyRelationOperationType, "");
            }

            @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
            public final /* synthetic */ void getAuthRequestContext(List list) {
                RelationshipBottomSheetContract.View.CC.getAuthRequestContext(list);
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

            @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
            public final void BuiltInFictitiousFunctionClassFactory(SettingModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ChangeUsernameActivity.access$openSettingsMoreActivity(ChangeUsernameActivity.this, p0);
            }
        })).getAuthRequestContext(this);
        registerPresenter(getSettingPresenter(), getUsernamePresenter());
        UsernameContract.Presenter usernamePresenter = getUsernamePresenter();
        InitialValueObservable<CharSequence> textChanges = RxTextView.textChanges((AppCompatEditText) _$_findCachedViewById(R.id.et_username));
        Intrinsics.checkNotNullExpressionValue(textChanges, "");
        usernamePresenter.MyBillsEntityDataFactory(textChanges);
    }

    private static void b(char[] cArr, char[] cArr2, int i, char c, char[] cArr3, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
            int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
            cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
            cArr4[i3] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr3[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (lookAheadTest ^ 4360990799332652212L)) ^ ((int) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 4360990799332652212L))) ^ ((char) (scheduleImpl ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
