package id.dana.social;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.material.tabs.TabLayout;
import com.google.common.base.Ascii;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.social.di.module.SocialCommonModule;
import id.dana.social.fragment.BlockedFragment;
import id.dana.social.fragment.MutedFragment;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.A;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007¢\u0006\u0004\b\u0018\u0010\u000bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u000bR\u0013\u0010\u0017\u001a\u00020\u0014X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/social/RestrictedContactActivity;", "Lid/dana/base/BaseActivity;", "Lid/dana/social/RestrictedContactActivtyInteractor;", "", "getErrorToast", "()Ljava/lang/String;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "Landroid/view/View;", "view", "onClickLeftMenuButton", "(Landroid/view/View;)V", "message", "showDialogToast", "(Ljava/lang/String;)V", "showErrorToast", "Lid/dana/social/BaseTabFragmentAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/Lazy;", "BuiltInFictitiousFunctionClassFactory", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RestrictedContactActivity extends BaseActivity implements RestrictedContactActivtyInteractor {
    public static final String EXTRA_RELATIONSHIP_TYPE = "RELATIONSHIP_TYPE";
    public static final String RELATIONSHIP_TYPE_FOLLOWER = "FOLLOWER";
    public static final String RELATIONSHIP_TYPE_FOLLOWING = "FOLLOWING";
    private static int lookAheadTest;
    public static final byte[] $$a = {107, 78, -84, 46, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 95;
    public static final byte[] getAuthRequestContext = {61, 16, -46, 32, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 202;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<BaseTabFragmentAdapter>() { // from class: id.dana.social.RestrictedContactActivity$viewPagerAdapter$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BaseTabFragmentAdapter invoke() {
            FragmentManager supportFragmentManager = RestrictedContactActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
            return new BaseTabFragmentAdapter(supportFragmentManager);
        }
    });

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        lookAheadTest = 269894887;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0023 -> B:35:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            byte[] r0 = id.dana.social.RestrictedContactActivity.getAuthRequestContext
            int r7 = 23 - r7
            int r8 = r8 + 97
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L13
            r4 = r8
            r3 = 0
            r8 = r7
            goto L2a
        L13:
            r3 = 0
        L14:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r5
        L2a:
            int r4 = -r4
            int r7 = r7 + r4
            int r7 = r7 + (-4)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.RestrictedContactActivity.a(int, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0027 -> B:35:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 2
            int r7 = r7 + 75
            int r9 = r9 * 3
            int r9 = r9 + 21
            int r8 = 47 - r8
            byte[] r0 = id.dana.social.RestrictedContactActivity.$$a
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L2f
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r8]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L2f:
            int r9 = -r9
            int r7 = r7 + r9
            int r7 = r7 + (-7)
            int r8 = r8 + 1
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.RestrictedContactActivity.c(int, int, short, java.lang.Object[]):void");
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

    /* JADX WARN: Removed duplicated region for block: B:625:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:626:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:703:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:704:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:749:0x0721  */
    /* JADX WARN: Removed duplicated region for block: B:750:0x0726  */
    /* JADX WARN: Removed duplicated region for block: B:795:0x08e4  */
    /* JADX WARN: Removed duplicated region for block: B:796:0x08e9  */
    /* JADX WARN: Removed duplicated region for block: B:840:0x0aa8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:867:0x0556 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:875:0x072a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:879:0x08ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:881:0x026e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void attachBaseContext(android.content.Context r25) {
        /*
            Method dump skipped, instructions count: 3024
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.RestrictedContactActivity.attachBaseContext(android.content.Context):void");
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
        return R.layout.activity_restricted_contact;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        b(true, getPackageName().length() + 286, super.getResources().getString(R.string.twilio_failed_dialog_positive_button).substring(1, 2).length() + 14, View.resolveSizeAndState(0, 0, 0) + 18, new char[]{0, '\f', 15, 65517, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, 16, 16, 2}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        b(false, super.getResources().getString(R.string.account_freeze_title).substring(4, 5).codePointAt(0) + 266, getPackageName().codePointAt(4) - 94, getPackageName().codePointAt(0) - 100, new char[]{65517, 1, 65532, 5, 17}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    byte b = getAuthRequestContext[7];
                    byte b2 = getAuthRequestContext[25];
                    Object[] objArr4 = new Object[1];
                    a(b, b2, b2, objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    a((byte) (-getAuthRequestContext[59]), getAuthRequestContext[41], getAuthRequestContext[5], objArr5);
                    int i = ((ApplicationInfo) cls2.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + DeepRecoverARiverProxy.TYPE_ENTITY_TA_PAGE;
                    try {
                        byte b3 = getAuthRequestContext[7];
                        byte b4 = getAuthRequestContext[25];
                        Object[] objArr6 = new Object[1];
                        a(b3, b4, b4, objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        a((byte) (-getAuthRequestContext[59]), getAuthRequestContext[41], getAuthRequestContext[5], new Object[1]);
                        Object[] objArr7 = new Object[1];
                        b(true, i, ((ApplicationInfo) cls3.getMethod((String) r5[0], null).invoke(this, null)).targetSdkVersion - 30, getPackageName().codePointAt(2) - 20, new char[]{1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6, '\f', 15}, objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        try {
                            byte b5 = getAuthRequestContext[7];
                            byte b6 = getAuthRequestContext[25];
                            Object[] objArr8 = new Object[1];
                            a(b5, b6, b6, objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            Object[] objArr9 = new Object[1];
                            a((byte) (-getAuthRequestContext[59]), getAuthRequestContext[41], getAuthRequestContext[5], objArr9);
                            Object[] objArr10 = new Object[1];
                            b(true, ((ApplicationInfo) cls5.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 267, getPackageName().codePointAt(4) - 80, getPackageName().codePointAt(2) - 28, new char[]{5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4}, objArr10);
                            baseContext = (Context) cls4.getMethod((String) objArr10[0], new Class[0]).invoke(null, null);
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
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 930, 35 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr11 = new Object[1];
                    b(true, super.getResources().getString(R.string.error_username_taken).substring(7, 8).codePointAt(0) + 164, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 24, super.getResources().getString(R.string.msg_referred_description).substring(35, 37).codePointAt(0) - 66, new char[]{65519, 28, 28, 29, JSONLexer.EOI, 65519, 65514, 65514, 65519, 65514, 65515, 30, 31, 28, 30, 65520, 65521, 65522, 29, 65513, 65521, 65519, 28, 65520, 30, 65519, 65516, 27, 65519, 65517, 31, 65520, 65513, 65521, 65522, 31, 65522, 65515, 65519, 65522, 30, JSONLexer.EOI, 29, 65515, 29, 65521, 65516, 29}, objArr11);
                    String str = (String) objArr11[0];
                    Object[] objArr12 = new Object[1];
                    b(false, super.getResources().getString(R.string.citcall_timeout_dialog_desc).substring(32, 33).length() + DeepRecoverARiverProxy.TYPE_ENTITY_PLUGIN, ImageFormat.getBitsPerPixel(0) + 64, 64 - View.resolveSize(0, 0), new char[]{65523, 65524, Typography.quote, Typography.dollar, 65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519, 65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524, 65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526, Typography.quote, 65520, 65520, '!', Typography.quote, 65522, 65526, '!', '!', 65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519, 65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!', InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31}, objArr12);
                    String str2 = (String) objArr12[0];
                    Object[] objArr13 = new Object[1];
                    b(false, TextUtils.getTrimmedLength("") + 262, Color.green(0) + 5, 64 - KeyEvent.normalizeMetaState(0), new char[]{65522, Typography.quote, 65521, 65521, 65525, 65518, 65517, '!', 30, 65525, 65523, 65518, 65520, 65524, 65524, 65524, 65517, 65517, 65519, 65516, 65523, 29, '!', 65520, InputCardNumberView.DIVIDER, 65518, 30, 29, 65519, 65523, Typography.quote, 65525, 65524, Typography.quote, Typography.quote, 65523, 31, 65523, InputCardNumberView.DIVIDER, 65518, 65524, 30, 65523, 65522, 65524, 65524, Typography.quote, 65517, 65520, 65524, 65516, 29, 30, Typography.quote, 65525, 31, '!', 65518, 65517, Typography.quote, 65521, 65523, 65521, 65525}, objArr13);
                    String str3 = (String) objArr13[0];
                    int length = super.getResources().getString(R.string.danapoly_banner_got_a_point_message).substring(0, 5).length() + 286;
                    try {
                        byte b7 = getAuthRequestContext[7];
                        byte b8 = getAuthRequestContext[25];
                        Object[] objArr14 = new Object[1];
                        a(b7, b8, b8, objArr14);
                        Class<?> cls6 = Class.forName((String) objArr14[0]);
                        a((byte) (-getAuthRequestContext[59]), getAuthRequestContext[41], getAuthRequestContext[5], new Object[1]);
                        Object[] objArr15 = new Object[1];
                        b(true, length, ((ApplicationInfo) cls6.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 8, getPackageName().codePointAt(5) - 50, new char[]{6, 65485, 19, 18, 0, 2, 19, 0, 4, 17, 7, 19, 65485, 0, '\r', 0, 3, 65486, 65486, 65497, 18, 15, 19, 19, 7, 18, 19, '\r', 4, 21, 4, 65486, 65489, 21, 65486, 19, 18, 4, 6, '\r', '\b', 65486, '\b', 15, 0, 65486, '\f', 14, 2, 65485, 4, 17, 0, 20, 16, 18, 3, 17, 0, 20}, objArr15);
                        String str4 = (String) objArr15[0];
                        int length2 = getPackageName().length() + 237;
                        int codePointAt = getPackageName().codePointAt(1) - 95;
                        try {
                            byte b9 = getAuthRequestContext[7];
                            byte b10 = getAuthRequestContext[25];
                            Object[] objArr16 = new Object[1];
                            a(b9, b10, b10, objArr16);
                            Class<?> cls7 = Class.forName((String) objArr16[0]);
                            a((byte) (-getAuthRequestContext[59]), getAuthRequestContext[41], getAuthRequestContext[5], new Object[1]);
                            Object[] objArr17 = new Object[1];
                            b(true, length2, codePointAt, ((ApplicationInfo) cls7.getMethod((String) r0[0], null).invoke(this, null)).targetSdkVersion - 27, new char[]{0, 65532, 2, 65532, 7, 65535}, objArr17);
                            try {
                                Object[] objArr18 = {baseContext, str, str2, str3, str4, true, (String) objArr17[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 911, TextUtils.indexOf((CharSequence) "", '0') + 19, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr18);
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
            }
        }
        try {
            Object[] objArr19 = new Object[1];
            a(36, getAuthRequestContext[30], (byte) (-getAuthRequestContext[32]), objArr19);
            Class<?> cls8 = Class.forName((String) objArr19[0]);
            byte b11 = getAuthRequestContext[30];
            Object[] objArr20 = new Object[1];
            a(21, b11, (byte) (b11 + 1), objArr20);
            try {
                Object[] objArr21 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + 494, 4 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) View.combineMeasuredStates(0, 0));
                    byte b12 = (byte) ($$a[47] - 1);
                    Object[] objArr22 = new Object[1];
                    c(b12, b12, (byte) (-$$a[8]), objArr22);
                    obj3 = cls9.getMethod((String) objArr22[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr23 = (Object[]) ((Method) obj3).invoke(null, objArr21);
                int i2 = ((int[]) objArr23[1])[0];
                if (((int[]) objArr23[0])[0] != i2) {
                    long j = ((r0 ^ i2) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (-16777181) - Color.rgb(0, 0, 0), (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr24 = {353086706, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 910, MotionEvent.axisFromString("") + 19, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr24);
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
                super.onCreate(bundle);
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
            try {
                byte b = getAuthRequestContext[7];
                byte b2 = getAuthRequestContext[25];
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a((byte) (-getAuthRequestContext[59]), getAuthRequestContext[41], getAuthRequestContext[5], objArr2);
                Object[] objArr3 = new Object[1];
                b(true, ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + DeepRecoverARiverProxy.TYPE_ENTITY_TA_PAGE, super.getResources().getString(R.string.bottom_on_boarding_subtitle_scan_fourth).substring(0, 5).codePointAt(2) - 94, super.getResources().getString(R.string.zface_not_in_center).substring(8, 9).length() + 25, new char[]{1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6, '\f', 15}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                b(true, 300 - ((Process.getThreadPriority(0) + 20) >> 6), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 16, super.getResources().getString(R.string.sendmoney_summary_admin_fee_title).substring(5, 6).codePointAt(0) - 14, new char[]{5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4}, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getFadingEdgeLength() >> 16), (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 911, ((Process.getThreadPriority(0) + 20) >> 6) + 18, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
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
        super.onPause();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(true, (ViewConfiguration.getEdgeSlop() >> 16) + 293, super.getResources().getString(R.string.bottom_on_boarding_title_request_money).substring(15, 16).length() + 2, super.getResources().getString(R.string.emergency_page_timer).substring(10, 11).length() + 25, new char[]{1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6, '\f', 15}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 300;
            int blue = Color.blue(0) + 17;
            try {
                byte b = getAuthRequestContext[7];
                byte b2 = getAuthRequestContext[25];
                Object[] objArr2 = new Object[1];
                a(b, b2, b2, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                a((byte) (-getAuthRequestContext[59]), getAuthRequestContext[41], getAuthRequestContext[5], new Object[1]);
                Object[] objArr3 = new Object[1];
                b(true, minimumFlingVelocity, blue, ((ApplicationInfo) cls2.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 15, new char[]{5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4}, objArr3);
                baseContext = (Context) cls.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ((byte) KeyEvent.getModifierMetaStateMask()), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 35, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.normalizeMetaState(0), TextUtils.getTrimmedLength("") + 18, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
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

    @Override // id.dana.base.BaseActivity
    public final void onClickLeftMenuButton(View view) {
        onBackPressed();
    }

    @Override // id.dana.social.RestrictedContactActivtyInteractor
    public final void showDialogToast(String message) {
        Intrinsics.checkNotNullParameter(message, "");
        CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
        CustomToast.MyBillsEntityDataFactory(this, R.drawable.ic_check_24_green50_filled_circle, R.drawable.bg_rounded_border_green_50, message);
    }

    @Override // id.dana.social.RestrictedContactActivtyInteractor
    public final void showErrorToast() {
        CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
        CustomToast.MyBillsEntityDataFactory(this, R.drawable.ic_close_red, R.drawable.bg_rounded_border_red_50, getErrorToast());
    }

    @Override // id.dana.social.RestrictedContactActivtyInteractor
    public final String getErrorToast() {
        String string = getString(R.string.modify_relationship_error);
        Intrinsics.checkNotNullExpressionValue(string, "");
        return string;
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        Bundle extras;
        getApplicationComponent().KClassImpl$Data$declaredNonStaticMembers$2(new SocialCommonModule(new BottomSheetOnBoardingContract.View() { // from class: id.dana.social.RestrictedContactActivity$iniInjection$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final void onGetBottomSheetOnBoardingAvailability(boolean p0, String p1) {
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str, String str2) {
                BottomSheetOnBoardingContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }
        }));
        setTitle(getResources().getString(R.string.restricted_contact_title));
        setToolbarTitleContentDescription(getString(R.string.lblRestrictedContacts));
        setMenuLeftButton(R.drawable.arrow_left_white);
        ViewPager viewPager = (ViewPager) _$_findCachedViewById(R.id.LogFileLogAppender);
        if (viewPager != null) {
            BaseTabFragmentAdapter baseTabFragmentAdapter = (BaseTabFragmentAdapter) this.BuiltInFictitiousFunctionClassFactory.getValue();
            MutedFragment mutedFragment = new MutedFragment();
            String string = getResources().getString(R.string.muted_contacts_title);
            Intrinsics.checkNotNullExpressionValue(string, "");
            baseTabFragmentAdapter.BuiltInFictitiousFunctionClassFactory(mutedFragment, string);
            BlockedFragment blockedFragment = new BlockedFragment();
            String string2 = getResources().getString(R.string.blocked_contacts_title);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            baseTabFragmentAdapter.BuiltInFictitiousFunctionClassFactory(blockedFragment, string2);
            viewPager.setAdapter(baseTabFragmentAdapter);
        }
        TabLayout tabLayout = (TabLayout) _$_findCachedViewById(R.id.res_0x7f0a1350_r8_lambda_68eytycucywsvbd4v6baosvoouk);
        if (tabLayout != null) {
            tabLayout.setupWithViewPager((ViewPager) _$_findCachedViewById(R.id.LogFileLogAppender));
        }
        List listOf = CollectionsKt.listOf((Object[]) new String[]{getString(R.string.btnTabMuted), getString(R.string.btnTabBlocked)});
        String str = null;
        if (listOf.size() == ((BaseTabFragmentAdapter) this.BuiltInFictitiousFunctionClassFactory.getValue()).getCount()) {
            int count = ((BaseTabFragmentAdapter) this.BuiltInFictitiousFunctionClassFactory.getValue()).getCount();
            for (int i = 0; i < count; i++) {
                TabLayout tabLayout2 = (TabLayout) _$_findCachedViewById(R.id.res_0x7f0a1350_r8_lambda_68eytycucywsvbd4v6baosvoouk);
                TabLayout.Tab tabAt = tabLayout2 != null ? tabLayout2.getTabAt(i) : null;
                if (tabAt != null) {
                    tabAt.setContentDescription((CharSequence) listOf.get(i));
                }
            }
        }
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            str = extras.getString(EXTRA_RELATIONSHIP_TYPE);
        }
        if (str != null) {
            if (Intrinsics.areEqual(str, RELATIONSHIP_TYPE_FOLLOWER)) {
                ((ViewPager) _$_findCachedViewById(R.id.LogFileLogAppender)).setCurrentItem(1);
                return;
            }
            Intrinsics.areEqual(str, RELATIONSHIP_TYPE_FOLLOWING);
            ((ViewPager) _$_findCachedViewById(R.id.LogFileLogAppender)).setCurrentItem(0);
        }
    }

    private static void b(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i3];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i3) {
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (lookAheadTest ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (i2 > 0) {
            a2.BuiltInFictitiousFunctionClassFactory = i2;
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, 0, cArr3, 0, i3);
            System.arraycopy(cArr3, 0, cArr2, i3 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i3 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            char[] cArr4 = new char[i3];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i3) {
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i3 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
