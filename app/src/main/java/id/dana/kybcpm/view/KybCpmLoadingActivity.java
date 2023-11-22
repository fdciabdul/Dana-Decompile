package id.dana.kybcpm.view;

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
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import androidx.view.OnBackPressedDispatcherKt;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.animation.HomeTabActivity;
import id.dana.animation.tab.HomeTabs;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.danah5.DanaH5;
import id.dana.databinding.ActivityKybCpmLoadingBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerKybCpmComponent;
import id.dana.di.modules.KybCpmModule;
import id.dana.kyb.model.KybPageInfo;
import id.dana.kybcpm.KybCpmContract;
import id.dana.kybcpm.constant.KybCpmConstants;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.danah5.DanaH5Listener;
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
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/kybcpm/view/KybCpmLoadingActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityKybCpmLoadingBinding;", "", "configToolbar", "()V", IAPSyncCommand.COMMAND_INIT, "initViewBinding", "()Lid/dana/databinding/ActivityKybCpmLoadingBinding;", "Ldagger/Lazy;", "Lid/dana/kybcpm/KybCpmContract$Presenter;", "presenter", "Ldagger/Lazy;", "getPresenter", "()Ldagger/Lazy;", "setPresenter", "(Ldagger/Lazy;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybCpmLoadingActivity extends ViewBindingActivity<ActivityKybCpmLoadingBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static short[] DatabaseTableConfigUtil;
    private static byte[] GetContactSyncConfig;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda1;
    private static int lookAheadTest;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public Lazy<KybCpmContract.Presenter> presenter;
    public static final byte[] $$a = {125, -100, 71, Ascii.FS, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 247;
    public static final byte[] PlaceComponentResult = {112, Ascii.US, -51, -82, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 122;

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        lookAheadTest = 1257195759;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = -1661948715;
        GetContactSyncConfig = new byte[]{TarHeader.LF_DIR, 60, -121, -116, TarHeader.LF_DIR, 47, 100, 62, TarHeader.LF_BLK, -116, TarHeader.LF_FIFO, -114, 42, 93, 44, -55, 59, 56, 76, 117, -124, -123, -122, 57, -111, TarHeader.LF_FIFO, 61, -39, TarHeader.LF_SYMLINK, -93, 5, -38, -34, -37, -36, 56, 9, -21, TarHeader.LF_SYMLINK, 47, -91, 56, -37, 6, 61, 115, 117, 113, -65, -122, 81, 81, -56, 111, TarHeader.LF_SYMLINK, -71, -120, -119, -122, 117, -67, 118, 10, -76, 19, -37, 11, 95, -67, 97, TarHeader.LF_CHR, -66, 96, 92, -67, 101, 74, 77, TarHeader.LF_LINK, -65, 101, 78, 79, TarHeader.LF_FIFO, 102, 79, -112, 92, -66, 103, 93, -68, TarHeader.LF_LINK, 98, 77, 97, -71, 103, 98, 73, 103, 77, 95, 77, 97, 76, -68, 77, 77, TarHeader.LF_CONTIG, -106, 74, 96, TarHeader.LF_LINK, -66, 79, 7, -92, -1, 7, -9, -78, -63, -9, -63, -7, -10, -64, -62, -4, -64, -12, -2, -6, 12, -78, 4, -83, -5, -62, -61, 5, -64, -85, -4, 16, -63, -79, -64, 6, -92, 19, -92, 15, -92, -61, -11, -3, 5, -77, 11, -84, -64, -10, -61, -64, 5, -89, -12, 14, -9, -92, -56, -17, 19, -62, -90, -63, 12, 79, 70, 74, 63, 122, 45, 70, TarHeader.LF_NORMAL, 76, 63, 117, 47, 61, 76, 100, Ascii.ESC, 70, 73, 121, TarHeader.LF_SYMLINK, 70, 75, 3, 96, 74, 76, 47, Ascii.NAK, 100, 72, 0, -99, 22, -98, Ascii.EM, 74, 96, 47, Ascii.ESC, -97, 70, Ascii.FS, 47, 122, 0, 122, 63, 70, 100, 71, 45, 76, 74, TarHeader.LF_LINK, 74, 74, 70, 76, TarHeader.LF_CHR, TarHeader.LF_NORMAL, Ascii.ETB, 45, 118, 47, 83, -90, -51, -40, -74, -64, Ascii.GS, -92, 99, 14, 106, -48, -43, -91, -88, -52, -23, -115, -88, -42, -31, -111, -91, -45, Ascii.FS, -104, -94, -64, -77, -53, -91, -42, -95, -64, -77, -43, -24, 105, -48, -63, -91, -74, -62, -93, -94, -39, -37, 13, -108, -94, -44, -92, Ascii.FS, -49, -36, -114, -46, -93, -49, -45, 9, Ascii.US, -76, -30, -74, -27};
        NetworkUserEntityData$$ExternalSyntheticLambda0 = -1434637555;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0026). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.kybcpm.view.KybCpmLoadingActivity.PlaceComponentResult
            int r9 = 106 - r9
            int r8 = 23 - r8
            int r7 = r7 + 4
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L11
            r3 = r9
            r4 = 0
            r9 = r8
            goto L26
        L11:
            r3 = 0
        L12:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L21
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L21:
            r3 = r0[r7]
            r6 = r9
            r9 = r8
            r8 = r6
        L26:
            int r7 = r7 + 1
            int r3 = -r3
            int r8 = r8 + r3
            int r8 = r8 + (-4)
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kybcpm.view.KybCpmLoadingActivity.b(byte, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = r8 + 75
            byte[] r0 = id.dana.kybcpm.view.KybCpmLoadingActivity.$$a
            int r7 = r7 + 4
            int r6 = r6 * 3
            int r6 = r6 + 21
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L36
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L36:
            int r6 = -r6
            int r8 = r8 + 1
            int r9 = r9 + r6
            int r6 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kybcpm.view.KybCpmLoadingActivity.c(short, int, short, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final Intent createIntentKybCpmLoadingActivity(Context context, String str, String str2) {
        return Companion.MyBillsEntityDataFactory(context, str, str2);
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

    /* JADX WARN: Removed duplicated region for block: B:112:0x05b1  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x05b6  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x05ba  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x078c  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0791  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0795  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0967  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x096c  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0970  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0b40 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x02d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02ca  */
    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void attachBaseContext(android.content.Context r30) {
        /*
            Method dump skipped, instructions count: 2881
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kybcpm.view.KybCpmLoadingActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        int codePointAt = super.getResources().getString(R.string.investment_balance_subtitle_empty).substring(1, 2).codePointAt(0) + 702553014;
        try {
            byte b = PlaceComponentResult[25];
            Object[] objArr2 = new Object[1];
            b(b, b, (byte) (-PlaceComponentResult[32]), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], PlaceComponentResult[48], objArr3);
            int i = ((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion - 146;
            try {
                byte b2 = PlaceComponentResult[25];
                Object[] objArr4 = new Object[1];
                b(b2, b2, (byte) (-PlaceComponentResult[32]), objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], PlaceComponentResult[48], new Object[1]);
                byte b3 = (byte) (((ApplicationInfo) cls2.getMethod((String) r2[0], null).invoke(this, null)).targetSdkVersion - 57);
                try {
                    byte b4 = PlaceComponentResult[25];
                    Object[] objArr5 = new Object[1];
                    b(b4, b4, (byte) (-PlaceComponentResult[32]), objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], PlaceComponentResult[48], new Object[1]);
                    Object[] objArr6 = new Object[1];
                    a(codePointAt, i, b3, (short) (((ApplicationInfo) cls3.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 37), 527277210 - TextUtils.getCapsMode("", 0, 0), objArr6);
                    Class<?> cls4 = Class.forName((String) objArr6[0]);
                    int length = super.getResources().getString(R.string.gn_google_tnc_oauth).substring(5, 6).length() + 702553122;
                    int codePointAt2 = super.getResources().getString(R.string.error_saving_amount_below_limit).substring(1, 2).codePointAt(0) - 210;
                    byte length2 = (byte) (super.getResources().getString(R.string.username_system_busy).substring(6, 7).length() + 59);
                    short codePointAt3 = (short) (super.getResources().getString(R.string.family_organizer_account_freeze_description).substring(49, 51).codePointAt(0) - 201);
                    try {
                        byte b5 = PlaceComponentResult[25];
                        Object[] objArr7 = new Object[1];
                        b(b5, b5, (byte) (-PlaceComponentResult[32]), objArr7);
                        Class<?> cls5 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], PlaceComponentResult[48], objArr8);
                        int i2 = ((ApplicationInfo) cls5.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 527277195;
                        Object[] objArr9 = new Object[1];
                        a(length, codePointAt2, length2, codePointAt3, i2, objArr9);
                        int intValue = ((Integer) cls4.getDeclaredMethod((String) objArr9[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                        if (intValue < 99000 || intValue > 99999) {
                            Context baseContext = getBaseContext();
                            if (baseContext == null) {
                                Object[] objArr10 = new Object[1];
                                a(getPackageName().codePointAt(4) + 702553014, getPackageName().length() - 120, (byte) (super.getResources().getString(R.string.danaviz_only_confirmation_title).substring(9, 10).codePointAt(0) - 46), (short) (super.getResources().getString(R.string.risk_reject_app_update_desc_dialog).substring(27, 29).codePointAt(1) - 208), 527277166 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), objArr10);
                                Class<?> cls6 = Class.forName((String) objArr10[0]);
                                Object[] objArr11 = new Object[1];
                                a(702553113 - (ViewConfiguration.getPressedStateDuration() >> 16), (-114) - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (byte) ((-80) - TextUtils.getOffsetBefore("", 0)), (short) (TextUtils.indexOf((CharSequence) "", '0') + 10), super.getResources().getString(R.string.modify_group_name_success_message).substring(18, 19).codePointAt(0) + 527277160, objArr11);
                                baseContext = (Context) cls6.getMethod((String) objArr11[0], new Class[0]).invoke(null, null);
                            }
                            if (baseContext != null) {
                                baseContext = baseContext.getApplicationContext();
                            }
                            if (baseContext != null) {
                                try {
                                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                    if (obj == null) {
                                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Color.argb(0, 0, 0, 0), (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                                    }
                                    Object invoke = ((Method) obj).invoke(null, null);
                                    Object[] objArr12 = new Object[1];
                                    a(702553069 - ((Process.getThreadPriority(0) + 20) >> 6), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) - 113, (byte) (getPackageName().codePointAt(5) - 89), (short) (Color.argb(0, 0, 0, 0) + 24), getPackageName().codePointAt(4) + 527277136, objArr12);
                                    String str = (String) objArr12[0];
                                    int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 702553111;
                                    int i3 = (-113) - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                                    try {
                                        byte b6 = PlaceComponentResult[25];
                                        Object[] objArr13 = new Object[1];
                                        b(b6, b6, (byte) (-PlaceComponentResult[32]), objArr13);
                                        Class<?> cls7 = Class.forName((String) objArr13[0]);
                                        b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], PlaceComponentResult[48], new Object[1]);
                                        Object[] objArr14 = new Object[1];
                                        a(packedPositionType, i3, (byte) (((ApplicationInfo) cls7.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 38), (short) (ImageFormat.getBitsPerPixel(0) - 99), super.getResources().getString(R.string.sendmoney_maximum_amount).substring(0, 24).length() + 527277257, objArr14);
                                        String str2 = (String) objArr14[0];
                                        int codePointAt4 = getPackageName().codePointAt(1) + 702552964;
                                        int length3 = getPackageName().length() - 120;
                                        byte length4 = (byte) (super.getResources().getString(R.string.sendmoney_recent_transaction_empty_title).substring(5, 6).length() - 111);
                                        try {
                                            byte b7 = PlaceComponentResult[25];
                                            Object[] objArr15 = new Object[1];
                                            b(b7, b7, (byte) (-PlaceComponentResult[32]), objArr15);
                                            Class<?> cls8 = Class.forName((String) objArr15[0]);
                                            b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], PlaceComponentResult[48], new Object[1]);
                                            Object[] objArr16 = new Object[1];
                                            a(codePointAt4, length3, length4, (short) (((ApplicationInfo) cls8.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 100), getPackageName().codePointAt(3) + 527277245, objArr16);
                                            String str3 = (String) objArr16[0];
                                            int length5 = super.getResources().getString(R.string.general_error_msg).substring(2, 7).length() + 702553113;
                                            try {
                                                byte b8 = PlaceComponentResult[25];
                                                Object[] objArr17 = new Object[1];
                                                b(b8, b8, (byte) (-PlaceComponentResult[32]), objArr17);
                                                Class<?> cls9 = Class.forName((String) objArr17[0]);
                                                b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], PlaceComponentResult[48], new Object[1]);
                                                Object[] objArr18 = new Object[1];
                                                a(length5, ((ApplicationInfo) cls9.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 146, (byte) (getPackageName().length() + 4), (short) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) - 69), super.getResources().getString(R.string.approve_friend_request_success_message).substring(0, 3).codePointAt(1) + 527277294, objArr18);
                                                String str4 = (String) objArr18[0];
                                                int codePointAt5 = super.getResources().getString(R.string.success_payment).substring(0, 1).codePointAt(0) + 702552991;
                                                int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) - 113;
                                                try {
                                                    byte b9 = PlaceComponentResult[25];
                                                    Object[] objArr19 = new Object[1];
                                                    b(b9, b9, (byte) (-PlaceComponentResult[32]), objArr19);
                                                    Class<?> cls10 = Class.forName((String) objArr19[0]);
                                                    Object[] objArr20 = new Object[1];
                                                    b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], PlaceComponentResult[48], objArr20);
                                                    byte b10 = (byte) (((ApplicationInfo) cls10.getMethod((String) objArr20[0], null).invoke(this, null)).targetSdkVersion + 50);
                                                    try {
                                                        byte b11 = PlaceComponentResult[25];
                                                        Object[] objArr21 = new Object[1];
                                                        b(b11, b11, (byte) (-PlaceComponentResult[32]), objArr21);
                                                        Class<?> cls11 = Class.forName((String) objArr21[0]);
                                                        Object[] objArr22 = new Object[1];
                                                        b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], PlaceComponentResult[48], objArr22);
                                                        short s = (short) (((ApplicationInfo) cls11.getMethod((String) objArr22[0], null).invoke(this, null)).targetSdkVersion + 11);
                                                        try {
                                                            byte b12 = PlaceComponentResult[25];
                                                            Object[] objArr23 = new Object[1];
                                                            b(b12, b12, (byte) (-PlaceComponentResult[32]), objArr23);
                                                            Class<?> cls12 = Class.forName((String) objArr23[0]);
                                                            Object[] objArr24 = new Object[1];
                                                            b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], PlaceComponentResult[48], objArr24);
                                                            int i4 = ((ApplicationInfo) cls12.getMethod((String) objArr24[0], null).invoke(this, null)).targetSdkVersion + 527277436;
                                                            Object[] objArr25 = new Object[1];
                                                            a(codePointAt5, packedPositionGroup, b10, s, i4, objArr25);
                                                            try {
                                                                Object[] objArr26 = {baseContext, str, str2, str3, str4, true, (String) objArr25[0], 995651014};
                                                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                                                if (obj2 == null) {
                                                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + 911, Color.argb(0, 0, 0, 0) + 18, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                                                }
                                                                ((Method) obj2).invoke(invoke, objArr26);
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
                        }
                        try {
                            Object[] objArr27 = new Object[1];
                            b((byte) 37, PlaceComponentResult[30], PlaceComponentResult[25], objArr27);
                            Class<?> cls13 = Class.forName((String) objArr27[0]);
                            Object[] objArr28 = new Object[1];
                            b((byte) (-PlaceComponentResult[35]), PlaceComponentResult[30], PlaceComponentResult[9], objArr28);
                            try {
                                Object[] objArr29 = {Integer.valueOf(((Integer) cls13.getMethod((String) objArr28[0], Object.class).invoke(null, this)).intValue())};
                                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                                if (obj3 == null) {
                                    Class cls14 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getEdgeSlop() >> 16), 4 - Gravity.getAbsoluteGravity(0, 0), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                                    Object[] objArr30 = new Object[1];
                                    c((byte) (-$$a[8]), (byte) (-$$a[53]), (byte) ($$a[47] - 1), objArr30);
                                    obj3 = cls14.getMethod((String) objArr30[0], Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                                }
                                Object[] objArr31 = (Object[]) ((Method) obj3).invoke(null, objArr29);
                                int i5 = ((int[]) objArr31[1])[0];
                                if (((int[]) objArr31[0])[0] != i5) {
                                    long j = ((r0 ^ i5) & 4294967295L) | 42949672960L;
                                    try {
                                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj4 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), 35 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                        }
                                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr32 = {1373230630, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj5 == null) {
                                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, 18 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) View.MeasureSpec.getSize(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                            }
                                            ((Method) obj5).invoke(invoke2, objArr32);
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
                                }
                                super.onCreate(bundle);
                            } catch (Throwable th11) {
                                Throwable cause11 = th11.getCause();
                                if (cause11 == null) {
                                    throw th11;
                                }
                                throw cause11;
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
        } catch (Throwable th16) {
            Throwable cause16 = th16.getCause();
            if (cause16 == null) {
                throw th16;
            }
            throw cause16;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(TextUtils.getOffsetAfter("", 0) + 702553111, Color.red(0) - 113, (byte) (super.getResources().getString(R.string.remove_from_favorite).substring(8, 9).codePointAt(0) - 44), (short) (super.getResources().getString(R.string.family_account_text_available_service_section).substring(5, 6).length() - 95), getPackageName().codePointAt(5) + 527277056, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            int codePointAt = super.getResources().getString(R.string.gn_subtitle_jp).substring(0, 86).codePointAt(30) + 702552997;
            int length = super.getResources().getString(R.string.install).substring(2, 3).length() - 114;
            try {
                byte b = PlaceComponentResult[25];
                Object[] objArr2 = new Object[1];
                b(b, b, (byte) (-PlaceComponentResult[32]), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], PlaceComponentResult[48], new Object[1]);
                byte b2 = (byte) (((ApplicationInfo) cls2.getMethod((String) r4[0], null).invoke(this, null)).targetSdkVersion - 113);
                try {
                    byte b3 = PlaceComponentResult[25];
                    Object[] objArr3 = new Object[1];
                    b(b3, b3, (byte) (-PlaceComponentResult[32]), objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], PlaceComponentResult[48], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    a(codePointAt, length, b2, (short) (((ApplicationInfo) cls3.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 24), Color.alpha(0) + 527277192, objArr4);
                    baseContext = (Context) cls.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 35 - (ViewConfiguration.getTapTimeout() >> 16), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0), 18 - View.resolveSize(0, 0), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Class<?> cls;
        Object[] objArr;
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int length = super.getResources().getString(R.string.explore_service_topup_description).substring(3, 4).length() + 702553110;
            int length2 = super.getResources().getString(R.string.bottom_on_boarding_body_snap_receipt_second).substring(11, 12).length() - 114;
            try {
                byte b = PlaceComponentResult[25];
                Object[] objArr2 = new Object[1];
                b(b, b, (byte) (-PlaceComponentResult[32]), objArr2);
                cls = Class.forName((String) objArr2[0]);
                objArr = new Object[1];
                b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], PlaceComponentResult[48], objArr);
            } catch (Throwable th) {
                th = th;
            }
            try {
                Object[] objArr3 = new Object[1];
                a(length, length2, (byte) (((ApplicationInfo) cls.getMethod((String) objArr[0], null).invoke(this, null)).targetSdkVersion + 37), (short) ((-93) - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), 527277134 + super.getResources().getString(R.string.citcall_otp_timer).substring(9, 10).codePointAt(0), objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                a(getPackageName().codePointAt(2) + 702553067, super.getResources().getString(R.string.request_money_AE15112158147535).substring(10, 11).length() - 114, (byte) (super.getResources().getString(R.string.choose_photo).substring(9, 10).length() - 81), (short) (TextUtils.getOffsetAfter("", 0) + 9), super.getResources().getString(R.string.complete_minute).substring(0, 1).codePointAt(0) + 527277083, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            } catch (Throwable th2) {
                th = th2;
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - KeyEvent.getDeadChar(0, 0), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 18 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
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
        super.onResume();
    }

    @JvmName(name = "getPresenter")
    public final Lazy<KybCpmContract.Presenter> getPresenter() {
        Lazy<KybCpmContract.Presenter> lazy = this.presenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(Lazy<KybCpmContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.presenter = lazy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityKybCpmLoadingBinding initViewBinding() {
        ActivityKybCpmLoadingBinding MyBillsEntityDataFactory = ActivityKybCpmLoadingBinding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setCenterTitle(getString(R.string.title_toolbar_loading_kyb_cpm));
        setMenuLeftButton(R.drawable.ic_close);
        setMenuLeftButtonOnClick(new View.OnClickListener() { // from class: id.dana.kybcpm.view.KybCpmLoadingActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KybCpmLoadingActivity.$r8$lambda$PgpwK306KZmABAkBWPtp_DMih1E(KybCpmLoadingActivity.this, view);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/kybcpm/view/KybCpmLoadingActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "p2", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Intent MyBillsEntityDataFactory(Context p0, String p1, String p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intent intent = new Intent(p0, KybCpmLoadingActivity.class);
            intent.putExtra(KybCpmConstants.KEY_QR_CODE, p1);
            intent.putExtra(KybCpmConstants.KEY_INPUT_AMOUNT, p2);
            return intent;
        }
    }

    public static /* synthetic */ void $r8$lambda$PgpwK306KZmABAkBWPtp_DMih1E(KybCpmLoadingActivity kybCpmLoadingActivity, View view) {
        Intrinsics.checkNotNullParameter(kybCpmLoadingActivity, "");
        kybCpmLoadingActivity.getOnBackPressedDispatcher().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static final /* synthetic */ void access$backToKybNativeHomePage(KybCpmLoadingActivity kybCpmLoadingActivity) {
        HomeTabActivity.Companion companion = HomeTabActivity.INSTANCE;
        HomeTabActivity.Companion.getAuthRequestContext(kybCpmLoadingActivity, HomeTabs.ME, new KybPageInfo(true, false, null, false, 14, null));
        kybCpmLoadingActivity.finish();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.kybcpm.view.KybCpmLoadingActivity$getDanaH5Listener$1] */
    public static final /* synthetic */ KybCpmLoadingActivity$getDanaH5Listener$1 access$getDanaH5Listener(final KybCpmLoadingActivity kybCpmLoadingActivity) {
        return new DanaH5Listener() { // from class: id.dana.kybcpm.view.KybCpmLoadingActivity$getDanaH5Listener$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
                KybCpmLoadingActivity.this.getOnBackPressedDispatcher().KClassImpl$Data$declaredNonStaticMembers$2();
            }
        };
    }

    public static final /* synthetic */ void access$handleError(KybCpmLoadingActivity kybCpmLoadingActivity) {
        HomeTabActivity.Companion companion = HomeTabActivity.INSTANCE;
        HomeTabActivity.Companion.getAuthRequestContext(kybCpmLoadingActivity, HomeTabs.ME, new KybPageInfo(true, false, null, true, 6, null));
        kybCpmLoadingActivity.finish();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        DaggerKybCpmComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerKybCpmComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (KybCpmModule) Preconditions.getAuthRequestContext(new KybCpmModule(new KybCpmContract.View() { // from class: id.dana.kybcpm.view.KybCpmLoadingActivity$getKybCpmModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.kybcpm.KybCpmContract.View
            public final void PlaceComponentResult(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DanaH5.startContainerFullUrl(p0, KybCpmLoadingActivity.access$getDanaH5Listener(KybCpmLoadingActivity.this));
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                KybCpmLoadingActivity.access$handleError(KybCpmLoadingActivity.this);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, KybCpmModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, ApplicationComponent.class);
        new DaggerKybCpmComponent.KybCpmComponentImpl(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, (byte) 0).MyBillsEntityDataFactory(this);
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "");
        OnBackPressedDispatcherKt.PlaceComponentResult(onBackPressedDispatcher, new Function1<OnBackPressedCallback, Unit>() { // from class: id.dana.kybcpm.view.KybCpmLoadingActivity$initCallbackListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OnBackPressedCallback onBackPressedCallback) {
                invoke2(onBackPressedCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnBackPressedCallback onBackPressedCallback) {
                Intrinsics.checkNotNullParameter(onBackPressedCallback, "");
                KybCpmLoadingActivity.access$backToKybNativeHomePage(KybCpmLoadingActivity.this);
            }
        });
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            KybCpmContract.Presenter presenter = getPresenter().get();
            String string = extras.getString(KybCpmConstants.KEY_INPUT_AMOUNT, "");
            Intrinsics.checkNotNullExpressionValue(string, "");
            String string2 = extras.getString(KybCpmConstants.KEY_QR_CODE, "");
            Intrinsics.checkNotNullExpressionValue(string2, "");
            presenter.getAuthRequestContext(string, string2);
        }
        registerPresenter(getPresenter().get());
    }

    private static void a(int i, int i2, byte b, short s, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (lookAheadTest ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = GetContactSyncConfig;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (GetContactSyncConfig[i3 + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (lookAheadTest ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (DatabaseTableConfigUtil[i3 + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (lookAheadTest ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = GetContactSyncConfig;
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
                    byte[] bArr5 = GetContactSyncConfig;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = DatabaseTableConfigUtil;
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
}
