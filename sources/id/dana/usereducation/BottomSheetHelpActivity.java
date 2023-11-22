package id.dana.usereducation;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.usereducation.repository.source.UserEducationScenarioKt;
import id.dana.databinding.ActivityHelpBottomSheetBinding;
import id.dana.usereducation.adapter.HelpListAdapter;
import id.dana.usereducation.model.ContentOnBoardingModel;
import id.dana.usereducation.model.OnBoardingModel;
import id.dana.utils.OnSwipeListener;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\f\u0010\u0005R\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/usereducation/BottomSheetHelpActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityHelpBottomSheetBinding;", "", IAPSyncCommand.COMMAND_INIT, "()V", "initViewBinding", "()Lid/dana/databinding/ActivityHelpBottomSheetBinding;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "", "Lid/dana/usereducation/model/ContentOnBoardingModel;", "getAuthRequestContext", "Ljava/util/List;", "MyBillsEntityDataFactory", "", "PlaceComponentResult", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class BottomSheetHelpActivity extends ViewBindingActivity<ActivityHelpBottomSheetBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static char GetContactSyncConfig;
    private static long NetworkUserEntityData$$ExternalSyntheticLambda1;
    private static int initRecordTimeStamp;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private List<ContentOnBoardingModel> MyBillsEntityDataFactory;
    public static final byte[] $$j = {90, -83, 93, -67, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$k = 62;
    public static final byte[] lookAheadTest = {123, 85, -72, 69, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 2;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        GetContactSyncConfig = (char) 55402;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = 4360990799332652212L;
        initRecordTimeStamp = -956812108;
    }

    @JvmStatic
    public static final Intent createBottomSheetHelpIntent(Context context, OnBoardingModel onBoardingModel, boolean z) {
        return Companion.PlaceComponentResult(context, onBoardingModel, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void l(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = 56 - r8
            int r7 = r7 + 97
            int r6 = 23 - r6
            byte[] r0 = id.dana.usereducation.BottomSheetHelpActivity.lookAheadTest
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L30
        L15:
            r3 = 0
            r5 = r8
            r8 = r7
            r7 = r5
        L19:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r3 = r0[r7]
            r5 = r9
            r9 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L30:
            int r8 = r8 + r7
            int r8 = r8 + (-4)
            int r7 = r9 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.usereducation.BottomSheetHelpActivity.l(byte, short, short, java.lang.Object[]):void");
    }

    private static void m(byte b, int i, short s, Object[] objArr) {
        int i2 = 47 - b;
        int i3 = 103 - (s * 2);
        int i4 = (i * 3) + 21;
        byte[] bArr = $$j;
        byte[] bArr2 = new byte[i4];
        int i5 = i4 - 1;
        int i6 = 0;
        if (bArr == null) {
            i2++;
            i3 = (i5 + i2) - 7;
            i5 = i5;
        }
        while (true) {
            bArr2[i6] = (byte) i3;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i6++;
            byte b2 = bArr[i2];
            i2++;
            i3 = (i3 + b2) - 7;
            i5 = i5;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public View _$_findCachedViewById(int i) {
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

    /* JADX WARN: Removed duplicated region for block: B:331:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x074d  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x0752  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x0756  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x0920  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0925  */
    /* JADX WARN: Removed duplicated region for block: B:504:0x0929  */
    /* JADX WARN: Removed duplicated region for block: B:547:0x0b01 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:558:0x0296 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void attachBaseContext(android.content.Context r28) {
        /*
            Method dump skipped, instructions count: 3224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.usereducation.BottomSheetHelpActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            k(new char[]{0, 0, 0, 0}, new char[]{53707, 14866, 32147, 46762, 16723, 24979, 61015, 17875, 3808, 43349, 65212, 22299, 41157, 7736, 41073, 43320, 5186, 9473, 26997, 59479, 52584, 62779, 40167, 22823, 32017, 14057}, (char) (getPackageName().length() + 5461), new char[]{6938, 30768, 23779, 10261}, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            k(new char[]{0, 0, 0, 0}, new char[]{41118, 38320, 49768, 3501, 47946, 63396, 54835, 31409, 57180, 48104, 61232, 64859, 34397, 33012, 22726, 48108, 29933, 48870}, (char) (9350 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), new char[]{14243, 13246, 34230, 62756}, (-1) - MotionEvent.axisFromString(""), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), TextUtils.indexOf("", "", 0) + 18, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Context.class);
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
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            k(new char[]{0, 0, 0, 0}, new char[]{53707, 14866, 32147, 46762, 16723, 24979, 61015, 17875, 3808, 43349, 65212, 22299, 41157, 7736, 41073, 43320, 5186, 9473, 26997, 59479, 52584, 62779, 40167, 22823, 32017, 14057}, (char) (super.getResources().getString(R.string.contact_not_available_desc).substring(35, 36).codePointAt(0) + 5403), new char[]{6938, 30768, 23779, 10261}, super.getResources().getString(R.string.gallery).substring(0, 3).length() - 3, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            k(new char[]{0, 0, 0, 0}, new char[]{41118, 38320, 49768, 3501, 47946, 63396, 54835, 31409, 57180, 48104, 61232, 64859, 34397, 33012, 22726, 48108, 29933, 48870}, (char) (getPackageName().codePointAt(3) + 9249), new char[]{14243, 13246, 34230, 62756}, super.getResources().getString(R.string.referral_tracker_active).substring(0, 6).length() - 6, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0), (ViewConfiguration.getWindowTouchSlop() >> 8) + 35, (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 911, 17 - ExpandableListView.getPackedPositionChild(0L), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public ActivityHelpBottomSheetBinding initViewBinding() {
        ActivityHelpBottomSheetBinding PlaceComponentResult = ActivityHelpBottomSheetBinding.PlaceComponentResult(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:181:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x047a A[Catch: all -> 0x05da, TryCatch #5 {all -> 0x05da, blocks: (B:179:0x0462, B:183:0x04cc, B:182:0x047a), top: B:244:0x0462 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x04e3  */
    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r25) {
        /*
            Method dump skipped, instructions count: 2018
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.usereducation.BottomSheetHelpActivity.onCreate(android.os.Bundle):void");
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        overridePendingTransition(R.anim.f5052130772056, R.anim.f5092130772063);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lid/dana/usereducation/BottomSheetHelpActivity$Companion;", "", "()V", "BUNDLE_DISMISS_OUTSIDE", "", "createBottomSheetHelpIntent", "Landroid/content/Intent;", HummerConstants.CONTEXT, "Landroid/content/Context;", "onBoardingModel", "Lid/dana/usereducation/model/OnBoardingModel;", "dismissOutside", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Intent BuiltInFictitiousFunctionClassFactory(Context context, OnBoardingModel onBoardingModel) {
            return PlaceComponentResult(context, onBoardingModel, true);
        }

        @JvmStatic
        public static Intent PlaceComponentResult(Context context, OnBoardingModel onBoardingModel, boolean z) {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(onBoardingModel, "");
            Intent intent = new Intent(context, BottomSheetHelpActivity.class);
            intent.putExtra("data", onBoardingModel);
            intent.putExtra("dismiss_outside", z);
            return intent;
        }
    }

    public static /* synthetic */ void $r8$lambda$8dPzOXeozpRw5u0LnUnfZ9kR1C4(BottomSheetHelpActivity bottomSheetHelpActivity, View view) {
        Intrinsics.checkNotNullParameter(bottomSheetHelpActivity, "");
        if (bottomSheetHelpActivity.KClassImpl$Data$declaredNonStaticMembers$2) {
            bottomSheetHelpActivity.setResult(-1);
            bottomSheetHelpActivity.finish();
        }
    }

    public static /* synthetic */ void $r8$lambda$z4SV_VtLjCy2SKb0LqSeFd0yBFo(BottomSheetHelpActivity bottomSheetHelpActivity, View view) {
        Intrinsics.checkNotNullParameter(bottomSheetHelpActivity, "");
        bottomSheetHelpActivity.setResult(-1);
        bottomSheetHelpActivity.finish();
    }

    public static final /* synthetic */ void access$finishActivity(BottomSheetHelpActivity bottomSheetHelpActivity) {
        bottomSheetHelpActivity.setResult(-1);
        bottomSheetHelpActivity.finish();
    }

    @JvmStatic
    public static final Intent createBottomSheetHelpIntent(Context context, OnBoardingModel onBoardingModel) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(onBoardingModel, "");
        return Companion.PlaceComponentResult(context, onBoardingModel, true);
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public void init() {
        Bundle extras = getIntent().getExtras();
        List<ContentOnBoardingModel> list = null;
        if (extras != null) {
            OnBoardingModel onBoardingModel = (OnBoardingModel) extras.getParcelable("data");
            if (onBoardingModel != null) {
                Intrinsics.checkNotNullExpressionValue(onBoardingModel, "");
                getBinding().BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0.setText(onBoardingModel.lookAheadTest);
                TextView textView = getBinding().BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0;
                String replace$default = StringsKt.replace$default(onBoardingModel.lookAheadTest, (char) InputCardNumberView.DIVIDER, '-', false, 4, (Object) null);
                Locale locale = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale, "");
                String lowerCase = replace$default.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                textView.setContentDescription(lowerCase);
                this.MyBillsEntityDataFactory = onBoardingModel.KClassImpl$Data$declaredNonStaticMembers$2;
                getBinding().BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0.setContentDescription(onBoardingModel.BuiltInFictitiousFunctionClassFactory);
                getBinding().BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setVisibility(onBoardingModel.MyBillsEntityDataFactory.length() == 0 ? 8 : 0);
                TextView textView2 = getBinding().BuiltInFictitiousFunctionClassFactory.scheduleImpl;
                textView2.setText(onBoardingModel.MyBillsEntityDataFactory);
                textView2.setVisibility(onBoardingModel.MyBillsEntityDataFactory.length() == 0 ? 8 : 0);
                if (onBoardingModel.PlaceComponentResult.length() > 0) {
                    getBinding().BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.setText(onBoardingModel.PlaceComponentResult);
                }
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = extras.getBoolean("dismiss_outside", true);
            OnBoardingModel onBoardingModel2 = (OnBoardingModel) extras.getParcelable("data");
            String str = onBoardingModel2 != null ? onBoardingModel2.getAuthRequestContext : null;
            if (StringsKt.equals(str, "kyc_supporting_doc", true) || StringsKt.equals(str, UserEducationScenarioKt.CARD_BINDING_ONBOARDING, true)) {
                getBinding().BuiltInFictitiousFunctionClassFactory.lookAheadTest.setVisibility(0);
            }
            if (Intrinsics.areEqual(str, UserEducationScenarioKt.CARD_BINDING_ONBOARDING)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.clHeaderContent);
                if (constraintLayout != null) {
                    Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                    constraintLayout.setOnTouchListener(new OnSwipeListener() { // from class: id.dana.usereducation.BottomSheetHelpActivity$setSwipeListener$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(BottomSheetHelpActivity.this);
                        }

                        @Override // id.dana.utils.OnSwipeListener
                        public final void getAuthRequestContext() {
                            BottomSheetHelpActivity.access$finishActivity(BottomSheetHelpActivity.this);
                        }
                    });
                }
                TextView textView3 = (TextView) _$_findCachedViewById(R.id.handleScrollChange);
                if (textView3 != null) {
                    textView3.setTextSize(20.0f);
                }
            }
        }
        List<ContentOnBoardingModel> list2 = this.MyBillsEntityDataFactory;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            list = list2;
        }
        getBinding().BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setAdapter(new HelpListAdapter(list));
        getBinding().BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.usereducation.BottomSheetHelpActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetHelpActivity.$r8$lambda$z4SV_VtLjCy2SKb0LqSeFd0yBFo(BottomSheetHelpActivity.this, view);
            }
        });
        getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.usereducation.BottomSheetHelpActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetHelpActivity.$r8$lambda$8dPzOXeozpRw5u0LnUnfZ9kR1C4(BottomSheetHelpActivity.this, view);
            }
        });
    }

    private static void k(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr3.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr3, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr2.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
            int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
            cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
            cArr4[i3] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr2[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 4360990799332652212L)) ^ ((int) (initRecordTimeStamp ^ 4360990799332652212L))) ^ ((char) (GetContactSyncConfig ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
