package id.dana.sendmoney_v2.smartfriction;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.fragment.app.FragmentManager;
import androidx.view.Lifecycle;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.core.ui.richview.StoryProgressBar;
import id.dana.di.component.ApplicationComponent;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.sendmoney.databinding.ActivitySuspiciousAccountBinding;
import id.dana.sendmoney_v2.landing.di.component.DaggerSuspiciousAccountComponent;
import id.dana.sendmoney_v2.landing.di.module.SuspiciousAccountModule;
import id.dana.sendmoney_v2.smartfriction.adapter.SuspiciousAccountAdapter;
import id.dana.sendmoney_v2.smartfriction.contract.SuspiciousAccountContract;
import id.dana.sendmoney_v2.smartfriction.fragment.StoryFragment;
import id.dana.sendmoney_v2.smartfriction.fragment.SurveyFragment;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\u0007R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000b\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/sendmoney_v2/smartfriction/SuspiciousAccountActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/sendmoney/databinding/ActivitySuspiciousAccountBinding;", "inflateViewBinding", "()Lid/dana/sendmoney/databinding/ActivitySuspiciousAccountBinding;", "", IAPSyncCommand.COMMAND_INIT, "()V", "initComponent", "onBackPressed", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney_v2/smartfriction/adapter/SuspiciousAccountAdapter;", "scheduleImpl", "Lid/dana/sendmoney_v2/smartfriction/adapter/SuspiciousAccountAdapter;", "Lid/dana/sendmoney_v2/smartfriction/contract/SuspiciousAccountContract$Presenter;", "suspiciousAccountPresenter", "Lid/dana/sendmoney_v2/smartfriction/contract/SuspiciousAccountContract$Presenter;", "getSuspiciousAccountPresenter", "()Lid/dana/sendmoney_v2/smartfriction/contract/SuspiciousAccountContract$Presenter;", "setSuspiciousAccountPresenter", "(Lid/dana/sendmoney_v2/smartfriction/contract/SuspiciousAccountContract$Presenter;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SuspiciousAccountActivity extends BaseViewBindingActivity<ActivitySuspiciousAccountBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private SuspiciousAccountAdapter KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public SuspiciousAccountContract.Presenter suspiciousAccountPresenter;
    public static final byte[] $$a = {112, Ascii.US, -51, -82, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 137;
    public static final byte[] getAuthRequestContext = {99, 56, -99, 122, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int PlaceComponentResult = 24;
    private static char[] lookAheadTest = {35559, 35438, 35439, 35431, 35429, 35442, 35434, 35738, 35426, 35427, 35427, 35426, 35431, 35454, 35419, 35395, 35424, 35432, 35403, 35401, 35434, 35428, 35424, 35431, 35433, 35435, 35503, 35570, 35565, 35564, 35573, 35575, 35567, 35524, 35526, 35566, 35568, 35572, 35576, 35580, 35572, 35568, 35570, 35568, 35465, 35543, 35576, 35570, 35566, 35573, 35575, 35577, 35572, 35565, 35570, 35578, 35575, 35566, 35583, 35489, 35534, 35567, 35496, 35565, 35577, 35521, 35576, 35500, 35539, 35498, 35540, 35538, 35499, 35539, 35536, 35501, 35498, 35494, 35537, 35537, 35499, 35498, 35497, 35537, 35581, 35580, 35541, 35541, 35536, 35499, 35541, 35539, 35538, 35581, 35581, 35580, 35541, 35501, 35503, 35501, 35501, 35503, 35541, 35579, 35578, 35578, 35536, 35497, 35494, 35536, 35540, 35498, 35497, 35538, 35539, 35502, 35541, 35499, 35539, 35579, 35537, 35498, 35498, 35536, 35581, 35536, 35497, 35538, 35540, 35503, 35500, 35501, 35500, 35538, 35541, 35540, 35540, 35501, 35498, 35498, 35538, 35539, 35537, 35536, 35536, 35541, 35500, 35540, 35581, 35538, 35496, 35539, 35581, 35543, 35503, 35498, 35500, 35540, 35541, 35540, 35539, 35498, 35498, 35499, 35501, 35499, 35494, 35495, 35494, 35501, 35502, 35502, 35502, 35540, 35580, 35543, 35498, 35536, 35541, 35458, 35497, 35499, 35539, 35536, 35497, 35497, 35496, 35496, 35539, 35541, 35503, 35541, 35578, 35536, 35537, 35578, 35583, 35542, 35498, 35496, 35500, 35541, 35537, 35494, 35497, 35496, 35538, 35539, 35499, 35541, 35539, 35539, 35539, 35536, 35576, 35537, 35494, 35537, 35536, 35499, 35540, 35583, 35540, 35541, 35538, 35538, 35581, 35538, 35501, 35503, 35500, 35503, 35498, 35494, 35494, 35496, 35501, 35498, 35494, 35539, 35581, 35541, 35503, 35492, 35562, 35564, 35572, 35568, 35568, 35541, 35503, 35531, 35533, 35532, 35562, 35571, 35577, 35573, 35570, 35539, 35539, 35571, 35575, 35543, 35537, 35569, 35572, 35543, 35540, 35570, 35572, 35570, 35562, 35565, 35570, 35570, 35572, 35570, 35569, 35541, 35532, 35562, 35573, 35581, 35570, 35573, 35578, 35570, 35568, 35569, 35532, 35542, 35574, 35574, 35581, 35540, 35502, 35499, 35529, 35564, 35565, 35563, 35569, 35575, 35411, 35413, 35413, 35412, 35413};

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = 16 - r8
            int r6 = 106 - r6
            byte[] r0 = id.dana.sendmoney_v2.smartfriction.SuspiciousAccountActivity.getAuthRequestContext
            int r7 = r7 * 15
            int r7 = 18 - r7
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
        L37:
            int r6 = -r6
            int r7 = r7 + r6
            int r6 = r7 + 2
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.smartfriction.SuspiciousAccountActivity.b(short, short, int, java.lang.Object[]):void");
    }

    private static void c(byte b, byte b2, short s, Object[] objArr) {
        int i = 42 - (b2 * 3);
        byte[] bArr = $$a;
        int i2 = s + 4;
        int i3 = (b * 2) + 75;
        byte[] bArr2 = new byte[i];
        int i4 = -1;
        int i5 = i - 1;
        if (bArr == null) {
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
            i2++;
            i3 = (i5 + i3) - 7;
            i5 = i5;
        }
        while (true) {
            int i6 = i4 + 1;
            bArr2[i6] = (byte) i3;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b3 = bArr[i2];
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = i6;
            i2++;
            i3 = (i3 + b3) - 7;
            i5 = i5;
        }
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
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(true, new int[]{44, 18, 0, 8}, new byte[]{0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(false, new int[]{62, 5, 0, 0}, new byte[]{1, 0, 0, 0, 1}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.getDeadChar(0, 0), TextUtils.indexOf("", "") + 35, (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(true, new int[]{67, 48, 0, 0}, new byte[]{1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(false, new int[]{115, 64, 0, 0}, new byte[]{1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(true, new int[]{179, 64, 0, 0}, new byte[]{1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(true, new int[]{243, 60, 1, 0}, new byte[]{0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(false, new int[]{303, 6, 154, 6}, new byte[]{1, 1, 0, 0, 0, 1}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 911, 17 - TextUtils.lastIndexOf("", '0', 0, 0), (char) TextUtils.indexOf("", "", 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (getAuthRequestContext[5] - 1);
                byte b2 = b;
                Object[] objArr13 = new Object[1];
                b(b, b2, b2, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = getAuthRequestContext[5];
                byte b4 = b3;
                Object[] objArr14 = new Object[1];
                b(b3, b4, (byte) (b4 - 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 55, TextUtils.getTrimmedLength("") + 3, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                        Object[] objArr16 = new Object[1];
                        c($$a[78], $$a[31], (byte) ($$a[78] - 1), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getScrollDefaultDelay() >> 16), Drawable.resolveOpacity(0, 0) + 15, (char) View.combineMeasuredStates(0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 15 - KeyEvent.getDeadChar(0, 0), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 815, Color.argb(0, 0, 0, 0) + 29, (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776416) - Color.rgb(0, 0, 0), TextUtils.lastIndexOf("", '0', 0, 0) + 16, (char) (ViewConfiguration.getTouchSlop() >> 8)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {505643330, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 17, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b5 = (byte) (getAuthRequestContext[5] - 1);
                byte b6 = b5;
                Object[] objArr19 = new Object[1];
                b(b5, b6, b6, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b7 = getAuthRequestContext[5];
                byte b8 = b7;
                Object[] objArr20 = new Object[1];
                b(b7, b8, (byte) (b8 - 1), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16777277, 47 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) ExpandableListView.getPackedPositionGroup(0L));
                        byte b9 = $$a[9];
                        byte b10 = $$a[8];
                        Object[] objArr22 = new Object[1];
                        c(b9, b10, (byte) (b10 | 16), objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r0 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {505643330, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 910, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 17, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b11 = (byte) (getAuthRequestContext[5] - 1);
                byte b12 = b11;
                Object[] objArr25 = new Object[1];
                b(b11, b12, b12, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b13 = getAuthRequestContext[5];
                byte b14 = b13;
                Object[] objArr26 = new Object[1];
                b(b13, b14, (byte) (b14 - 1), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 118, 3 - (ViewConfiguration.getTouchSlop() >> 8), (char) (ExpandableListView.getPackedPositionGroup(0L) + 38968));
                        byte b15 = $$a[9];
                        byte b16 = $$a[8];
                        Object[] objArr28 = new Object[1];
                        c(b15, b16, (byte) (b16 | 16), objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r0 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionGroup(0L), 35 - KeyEvent.keyCodeFromString(""), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {505643330, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 911, 18 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b17 = (byte) (getAuthRequestContext[5] - 1);
                byte b18 = b17;
                Object[] objArr31 = new Object[1];
                b(b17, b18, b18, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b19 = getAuthRequestContext[5];
                byte b20 = b19;
                Object[] objArr32 = new Object[1];
                b(b19, b20, (byte) (b20 - 1), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16777109) - Color.rgb(0, 0, 0), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 2, (char) Color.red(0));
                        byte b21 = (byte) ($$a[78] - 1);
                        Object[] objArr34 = new Object[1];
                        c(b21, b21, $$a[53], objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r0 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionGroup(0L), 34 - ExpandableListView.getPackedPositionChild(0L), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {505643330, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 910, 18 - View.MeasureSpec.getSize(0), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(true, new int[]{44, 18, 0, 8}, new byte[]{0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(false, new int[]{62, 5, 0, 0}, new byte[]{1, 0, 0, 0, 1}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(true, new int[]{0, 26, 142, 0}, new byte[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a(false, new int[]{26, 18, 0, 0}, new byte[]{1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.getDeadChar(0, 0), MotionEvent.axisFromString("") + 36, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a(true, new int[]{67, 48, 0, 0}, new byte[]{1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(false, new int[]{115, 64, 0, 0}, new byte[]{1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(true, new int[]{179, 64, 0, 0}, new byte[]{1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1}, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(true, new int[]{243, 60, 1, 0}, new byte[]{0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0}, objArr9);
                    String str4 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(false, new int[]{303, 6, 154, 6}, new byte[]{1, 1, 0, 0, 0, 1}, objArr10);
                    try {
                        Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 863, Color.red(0) + 18, (char) TextUtils.indexOf("", "", 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr11);
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
        try {
            byte b = (byte) (getAuthRequestContext[5] - 1);
            byte b2 = b;
            Object[] objArr12 = new Object[1];
            b(b, b2, b2, objArr12);
            Class<?> cls3 = Class.forName((String) objArr12[0]);
            byte b3 = getAuthRequestContext[5];
            byte b4 = b3;
            Object[] objArr13 = new Object[1];
            b(b3, b4, (byte) (b4 - 1), objArr13);
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 4 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                    byte b5 = (byte) ($$a[78] - 1);
                    Object[] objArr15 = new Object[1];
                    c(b5, b5, $$a[53], objArr15);
                    obj3 = cls4.getMethod((String) objArr15[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr16 = (Object[]) ((Method) obj3).invoke(null, objArr14);
                int i = ((int[]) objArr16[1])[0];
                if (((int[]) objArr16[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + PDF417Common.NUMBER_OF_CODEWORDS, 34 - ExpandableListView.getPackedPositionChild(0L), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr17 = {-822337989, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 912, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 18, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr17);
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
                super.onCreate(bundle);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(true, new int[]{0, 26, 142, 0}, new byte[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(false, new int[]{26, 18, 0, 0}, new byte[]{1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.blue(0), 35 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 911, 18 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(true, new int[]{0, 26, 142, 0}, new byte[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(false, new int[]{26, 18, 0, 0}, new byte[]{1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 911, 17 - ImageFormat.getBitsPerPixel(0), (char) KeyEvent.normalizeMetaState(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getSuspiciousAccountPresenter")
    public final SuspiciousAccountContract.Presenter getSuspiciousAccountPresenter() {
        SuspiciousAccountContract.Presenter presenter = this.suspiciousAccountPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSuspiciousAccountPresenter")
    public final void setSuspiciousAccountPresenter(SuspiciousAccountContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.suspiciousAccountPresenter = presenter;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivitySuspiciousAccountBinding inflateViewBinding() {
        ActivitySuspiciousAccountBinding KClassImpl$Data$declaredNonStaticMembers$2 = ActivitySuspiciousAccountBinding.KClassImpl$Data$declaredNonStaticMembers$2(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        initComponent();
        ArrayList arrayList = new ArrayList();
        StoryFragment.Companion companion = id.dana.sendmoney_v2.smartfriction.fragment.StoryFragment.INSTANCE;
        String string = getString(R.string.suspicious_account_title_1);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = getString(R.string.suspicious_account_description_1);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        arrayList.add(StoryFragment.Companion.PlaceComponentResult(R.drawable.ic_suspicious_ilustration1, string, string2, new SuspiciousAccountAdapter.OnStoryClickedListener() { // from class: id.dana.sendmoney_v2.smartfriction.SuspiciousAccountActivity$getStoryClickListener$1
            @Override // id.dana.sendmoney_v2.smartfriction.adapter.SuspiciousAccountAdapter.OnStoryClickedListener
            public final void PlaceComponentResult() {
                ActivitySuspiciousAccountBinding binding;
                binding = SuspiciousAccountActivity.this.getBinding();
                binding.MyBillsEntityDataFactory.skip();
            }

            @Override // id.dana.sendmoney_v2.smartfriction.adapter.SuspiciousAccountAdapter.OnStoryClickedListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                ActivitySuspiciousAccountBinding binding;
                binding = SuspiciousAccountActivity.this.getBinding();
                binding.MyBillsEntityDataFactory.reverse();
            }
        }));
        StoryFragment.Companion companion2 = id.dana.sendmoney_v2.smartfriction.fragment.StoryFragment.INSTANCE;
        String string3 = getString(R.string.suspicious_account_title_2);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        String string4 = getString(R.string.suspicious_account_description_2);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        arrayList.add(StoryFragment.Companion.PlaceComponentResult(R.drawable.ic_suspicious_ilustration2, string3, string4, new SuspiciousAccountAdapter.OnStoryClickedListener() { // from class: id.dana.sendmoney_v2.smartfriction.SuspiciousAccountActivity$getStoryClickListener$1
            @Override // id.dana.sendmoney_v2.smartfriction.adapter.SuspiciousAccountAdapter.OnStoryClickedListener
            public final void PlaceComponentResult() {
                ActivitySuspiciousAccountBinding binding;
                binding = SuspiciousAccountActivity.this.getBinding();
                binding.MyBillsEntityDataFactory.skip();
            }

            @Override // id.dana.sendmoney_v2.smartfriction.adapter.SuspiciousAccountAdapter.OnStoryClickedListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                ActivitySuspiciousAccountBinding binding;
                binding = SuspiciousAccountActivity.this.getBinding();
                binding.MyBillsEntityDataFactory.reverse();
            }
        }));
        SurveyFragment.Companion companion3 = id.dana.sendmoney_v2.smartfriction.fragment.SurveyFragment.INSTANCE;
        arrayList.add(SurveyFragment.Companion.BuiltInFictitiousFunctionClassFactory(new SuspiciousAccountAdapter.OnStoryClickedListener() { // from class: id.dana.sendmoney_v2.smartfriction.SuspiciousAccountActivity$getStoryClickListener$1
            @Override // id.dana.sendmoney_v2.smartfriction.adapter.SuspiciousAccountAdapter.OnStoryClickedListener
            public final void PlaceComponentResult() {
                ActivitySuspiciousAccountBinding binding;
                binding = SuspiciousAccountActivity.this.getBinding();
                binding.MyBillsEntityDataFactory.skip();
            }

            @Override // id.dana.sendmoney_v2.smartfriction.adapter.SuspiciousAccountAdapter.OnStoryClickedListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                ActivitySuspiciousAccountBinding binding;
                binding = SuspiciousAccountActivity.this.getBinding();
                binding.MyBillsEntityDataFactory.reverse();
            }
        }, new SurveyFragment.Companion.OnSubmitClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.SuspiciousAccountActivity$getOnSubmitClickListener$1
            @Override // id.dana.sendmoney_v2.smartfriction.fragment.SurveyFragment.Companion.OnSubmitClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SuspiciousAccountActivity.this.getSuspiciousAccountPresenter().getAuthRequestContext(p0);
            }
        }));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new SuspiciousAccountAdapter(supportFragmentManager, arrayList, lifecycle);
        ViewPager2 viewPager2 = getBinding().BuiltInFictitiousFunctionClassFactory;
        viewPager2.setUserInputEnabled(false);
        SuspiciousAccountAdapter suspiciousAccountAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        SuspiciousAccountAdapter suspiciousAccountAdapter2 = null;
        if (suspiciousAccountAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            suspiciousAccountAdapter = null;
        }
        viewPager2.setAdapter(suspiciousAccountAdapter);
        SuspiciousAccountAdapter suspiciousAccountAdapter3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (suspiciousAccountAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            suspiciousAccountAdapter3 = null;
        }
        viewPager2.setPageTransformer(suspiciousAccountAdapter3);
        StoryProgressBar storyProgressBar = getBinding().MyBillsEntityDataFactory;
        SuspiciousAccountAdapter suspiciousAccountAdapter4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (suspiciousAccountAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            suspiciousAccountAdapter2 = suspiciousAccountAdapter4;
        }
        storyProgressBar.setStoriesCount(suspiciousAccountAdapter2.getItemCount());
        storyProgressBar.setStoryDuration(12000L);
        storyProgressBar.setStoriesListener(new StoryProgressBar.StoriesListener() { // from class: id.dana.sendmoney_v2.smartfriction.SuspiciousAccountActivity$getStoriesListener$1
            @Override // id.dana.core.ui.richview.StoryProgressBar.StoriesListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                int i;
                SuspiciousAccountAdapter suspiciousAccountAdapter5;
                int i2;
                ActivitySuspiciousAccountBinding binding;
                int i3;
                i = SuspiciousAccountActivity.this.BuiltInFictitiousFunctionClassFactory;
                suspiciousAccountAdapter5 = SuspiciousAccountActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (suspiciousAccountAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    suspiciousAccountAdapter5 = null;
                }
                if (i < suspiciousAccountAdapter5.getItemCount() - 1) {
                    SuspiciousAccountActivity suspiciousAccountActivity = SuspiciousAccountActivity.this;
                    i2 = suspiciousAccountActivity.BuiltInFictitiousFunctionClassFactory;
                    suspiciousAccountActivity.BuiltInFictitiousFunctionClassFactory = i2 + 1;
                    binding = SuspiciousAccountActivity.this.getBinding();
                    ViewPager2 viewPager22 = binding.BuiltInFictitiousFunctionClassFactory;
                    i3 = SuspiciousAccountActivity.this.BuiltInFictitiousFunctionClassFactory;
                    viewPager22.setCurrentItem(i3, false);
                }
            }

            @Override // id.dana.core.ui.richview.StoryProgressBar.StoriesListener
            public final void MyBillsEntityDataFactory() {
                int i;
                int i2;
                ActivitySuspiciousAccountBinding binding;
                int i3;
                i = SuspiciousAccountActivity.this.BuiltInFictitiousFunctionClassFactory;
                if (i > 0) {
                    SuspiciousAccountActivity suspiciousAccountActivity = SuspiciousAccountActivity.this;
                    i2 = suspiciousAccountActivity.BuiltInFictitiousFunctionClassFactory;
                    suspiciousAccountActivity.BuiltInFictitiousFunctionClassFactory = i2 - 1;
                    binding = SuspiciousAccountActivity.this.getBinding();
                    ViewPager2 viewPager22 = binding.BuiltInFictitiousFunctionClassFactory;
                    i3 = SuspiciousAccountActivity.this.BuiltInFictitiousFunctionClassFactory;
                    viewPager22.setCurrentItem(i3, false);
                }
            }
        });
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.SuspiciousAccountActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuspiciousAccountActivity.$r8$lambda$8yyqfHdo_q0DpN8iijQJwESljwQ(SuspiciousAccountActivity.this, view);
            }
        });
        if (this.suspiciousAccountPresenter != null) {
            getSuspiciousAccountPresenter().BuiltInFictitiousFunctionClassFactory();
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        DaggerSuspiciousAccountComponent.Builder authRequestContext = DaggerSuspiciousAccountComponent.getAuthRequestContext();
        Application application = getApplication();
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        authRequestContext.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) application).getApplicationComponent());
        authRequestContext.BuiltInFictitiousFunctionClassFactory = (SuspiciousAccountModule) Preconditions.getAuthRequestContext(new SuspiciousAccountModule(new SuspiciousAccountContract.View() { // from class: id.dana.sendmoney_v2.smartfriction.SuspiciousAccountActivity$initComponent$1
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

            @Override // id.dana.sendmoney_v2.smartfriction.contract.SuspiciousAccountContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
                SuspiciousAccountAdapter suspiciousAccountAdapter;
                ActivitySuspiciousAccountBinding binding;
                ActivitySuspiciousAccountBinding binding2;
                ActivitySuspiciousAccountBinding binding3;
                if (!p0) {
                    binding3 = SuspiciousAccountActivity.this.getBinding();
                    binding3.MyBillsEntityDataFactory.startStories();
                    return;
                }
                suspiciousAccountAdapter = SuspiciousAccountActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (suspiciousAccountAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    suspiciousAccountAdapter = null;
                }
                int itemCount = suspiciousAccountAdapter.getItemCount() - 1;
                binding = SuspiciousAccountActivity.this.getBinding();
                binding.BuiltInFictitiousFunctionClassFactory.setCurrentItem(itemCount, false);
                binding2 = SuspiciousAccountActivity.this.getBinding();
                binding2.MyBillsEntityDataFactory.startStories(itemCount);
                SuspiciousAccountActivity.this.BuiltInFictitiousFunctionClassFactory = itemCount;
            }

            @Override // id.dana.sendmoney_v2.smartfriction.contract.SuspiciousAccountContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SuspiciousAccountActivity.this.setResult(-1, new Intent());
                SuspiciousAccountActivity.this.finish();
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.BuiltInFictitiousFunctionClassFactory, SuspiciousAccountModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getAuthRequestContext, ApplicationComponent.class);
        new DaggerSuspiciousAccountComponent.SuspiciousAccountComponentImpl(authRequestContext.BuiltInFictitiousFunctionClassFactory, authRequestContext.getAuthRequestContext, (byte) 0).PlaceComponentResult(this);
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        getOnBackPressedDispatcher().KClassImpl$Data$declaredNonStaticMembers$2();
        finish();
    }

    public static /* synthetic */ void $r8$lambda$8yyqfHdo_q0DpN8iijQJwESljwQ(SuspiciousAccountActivity suspiciousAccountActivity, View view) {
        Intrinsics.checkNotNullParameter(suspiciousAccountActivity, "");
        suspiciousAccountActivity.finish();
    }

    private static void a(boolean z, int[] iArr, byte[] bArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        char[] cArr = lookAheadTest;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            for (int i5 = 0; i5 < length; i5++) {
                cArr2[i5] = (char) (cArr[i5] ^ 5097613533456403102L);
            }
            cArr = cArr2;
        }
        char[] cArr3 = new char[i2];
        System.arraycopy(cArr, i, cArr3, 0, i2);
        if (bArr != null) {
            char[] cArr4 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            char c = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                } else {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                }
                c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr4;
        }
        if (i4 > 0) {
            char[] cArr5 = new char[i2];
            System.arraycopy(cArr3, 0, cArr5, 0, i2);
            int i6 = i2 - i4;
            System.arraycopy(cArr5, 0, cArr3, i6, i4);
            System.arraycopy(cArr5, i4, cArr3, 0, i6);
        }
        if (z) {
            char[] cArr6 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr6;
        }
        if (i3 > 0) {
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
        }
        objArr[0] = new String(cArr3);
    }
}
