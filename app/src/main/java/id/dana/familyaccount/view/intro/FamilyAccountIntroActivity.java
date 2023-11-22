package id.dana.familyaccount.view.intro;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
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
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.plus.security.lite.SecLiteException;
import com.google.android.material.tabs.TabLayout;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.danah5.DanaH5;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.data.social.common.PhoneNumberUtilKt;
import id.dana.databinding.ActivityFamilyAccountIntroBinding;
import id.dana.databinding.LayoutToolbarBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerFamilyAccountIntroComponent;
import id.dana.di.modules.FamilyAccountIntroModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.user.UserInfoResponse;
import id.dana.extension.view.ViewPagerExtKt;
import id.dana.extension.view.ViewPagerExtKt$attachViewPager$1;
import id.dana.familyaccount.adapter.FamilyAccountIntroContentAdapter;
import id.dana.familyaccount.contract.FamilyActivationContract;
import id.dana.familyaccount.di.FamilyAccountTrackerModule;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;
import id.dana.familyaccount.view.invite.FamilyTncConsentActivity;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.DANAToast;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b$\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000b\u0010\u0005R\u0013\u0010\r\u001a\u00020\fX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#"}, d2 = {"Lid/dana/familyaccount/view/intro/FamilyAccountIntroActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityFamilyAccountIntroBinding;", "", "configToolbar", "()V", "inflateViewBinding", "()Lid/dana/databinding/ActivityFamilyAccountIntroBinding;", IAPSyncCommand.COMMAND_INIT, "initComponent", "onBackPressed", "onDestroy", "Lid/dana/dialog/DanaLoadingDialog;", "PlaceComponentResult", "Lkotlin/Lazy;", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "familyAccountAnalyticalTracker", "Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "getFamilyAccountAnalyticalTracker", "()Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "setFamilyAccountAnalyticalTracker", "(Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;)V", "Lid/dana/familyaccount/contract/FamilyActivationContract$Presenter;", "presenter", "Lid/dana/familyaccount/contract/FamilyActivationContract$Presenter;", "getPresenter", "()Lid/dana/familyaccount/contract/FamilyActivationContract$Presenter;", "setPresenter", "(Lid/dana/familyaccount/contract/FamilyActivationContract$Presenter;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyAccountIntroActivity extends BaseViewBindingActivity<ActivityFamilyAccountIntroBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static short[] NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
    public static final String USER_CLICK_BACK = "Back";
    private static int getErrorConfigVersion;
    private static byte[] initRecordTimeStamp;
    private static int lookAheadTest;
    private static int scheduleImpl;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;
    @Inject
    public FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker;
    @Inject
    public FamilyActivationContract.Presenter presenter;
    public static final byte[] $$a = {125, -100, 71, Ascii.FS, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 111;
    public static final byte[] getAuthRequestContext = {4, -87, 42, 65, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 128;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy PlaceComponentResult = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.familyaccount.view.intro.FamilyAccountIntroActivity$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(FamilyAccountIntroActivity.this);
        }
    });

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        scheduleImpl = 1257195690;
        lookAheadTest = -276029581;
        initRecordTimeStamp = new byte[]{-100, 99, 108, -107, -117, 68, -102, -108, 108, -110, 106, -114, -67, -116, 33, -97, -112, -84, 85, 100, 101, 98, -111, 105, -110, 96, -103, 106, -116, 97, 101, 98, 99, -97, -80, 82, -103, -106, 108, -97, 98, -115, -97, -111, -99, 107, 98, -67, -67, 36, -101, -34, 85, 100, 101, 98, -111, 105, -110, 100, -117, 67, -109, -80, -100, 78, -77, -99, 81, -80, -104, 103, 96, 76, -78, -104, 99, 98, 75, -101, 98, -83, 81, -77, -102, 80, -79, 76, -97, 96, -100, -76, -102, -97, 100, -102, 96, 82, 96, -100, 97, -79, 96, 96, 74, -85, 103, -99, 76, -77, 80, -77, -104, 80, 96, -83, -98, 96, -98, 102, 97, -97, -99, -101, -97, 99, -103, 101, 75, -83, 83, -86, 100, -99, -100, 82, -97, -76, -101, 79, -98, -82, -97, 81, -77, 76, -77, 72, -77, -100, 98, -102, 82, -84, 84, -85, -97, 97, -100, -97, 82, -80, 99, 73, 96, -77, -105, 104, 76, -99, -79, -98, 75, -101, -97, 80, -81, 98, -101, 97, -99, 80, -86, 96, 82, -99, -75, 76, -101, -98, -82, 103, -101, -100, 84, -79, -97, -99, 96, 74, -75, -103, 81, -78, 75, -77, 78, -97, -79, 96, 76, -80, -101, 77, 96, -81, 81, -81, 80, -101, -75, -104, 98, -99, -97, 102, -97, -97, -101, -99, 100, 97, 72, 98, -85, 96, 96, -103, -106, 112, -114, -87, 98, 35, -40, 36, -98, -111, 97, 102, -102, -91, 89, 102, -112, -83, 93, 97, -109, -86, 86, 108, -114, 115, -101, 97, -112, 109, -114, 115, -111, -90, 37, -98, -115, 97, 112, -116, 99, 108, -107, 107, -39, 82, 108, -110, 98, -86, -97, 106, 88, -100, 99, -97, -109, 96, -101, 101, -103, 106, -97, -97, -97, -97, -97, -97, -97, -97, -97};
        getErrorConfigVersion = -2119539325;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = 55 - r7
            byte[] r0 = id.dana.familyaccount.view.intro.FamilyAccountIntroActivity.getAuthRequestContext
            int r8 = r8 + 16
            int r6 = r6 + 97
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L31
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            int r7 = r7 + 1
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L31:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.intro.FamilyAccountIntroActivity.b(int, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.familyaccount.view.intro.FamilyAccountIntroActivity.$$a
            int r6 = 47 - r6
            int r7 = r7 * 3
            int r7 = r7 + 21
            int r8 = r8 * 2
            int r8 = 103 - r8
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L33
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r3 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L33:
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            int r6 = r6 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.intro.FamilyAccountIntroActivity.c(short, int, byte, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final Intent createFamilyAccountIntroIntent(Context context) {
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
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(TextUtils.lastIndexOf("", '0', 0) + 1520216182, (-34) - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (byte) ((-1) - TextUtils.lastIndexOf("", '0', 0)), (short) Drawable.resolveOpacity(0, 0), TextUtils.lastIndexOf("", '0', 0) + 884658959, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(1520216193 - ExpandableListView.getPackedPositionType(0L), View.resolveSize(0, 0) - 48, (byte) (ViewConfiguration.getPressedStateDuration() >> 16), (short) KeyEvent.getDeadChar(0, 0), 884658975 - ExpandableListView.getPackedPositionType(0L), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.blue(0), 35 - (Process.myPid() >> 22), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 1520216138, (-5) - ((Process.getThreadPriority(0) + 20) >> 6), (byte) KeyEvent.normalizeMetaState(0), (short) View.combineMeasuredStates(0, 0), (ViewConfiguration.getEdgeSlop() >> 16) + 884658979, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((Process.myPid() >> 22) + 1520216181, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 10, (byte) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (short) KeyEvent.keyCodeFromString(""), 884659026 - (ViewConfiguration.getFadingEdgeLength() >> 16), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(Color.blue(0) + 1520216134, 11 - View.MeasureSpec.getSize(0), (byte) TextUtils.getCapsMode("", 0, 0), (short) Color.blue(0), 884659090 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((KeyEvent.getMaxKeyCode() >> 16) + 1520216188, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 6, (byte) View.resolveSize(0, 0), (short) (ViewConfiguration.getFadingEdgeLength() >> 16), 884659152 - (ViewConfiguration.getScrollDefaultDelay() >> 16), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(1520216141 - TextUtils.getCapsMode("", 0, 0), (-47) - Color.blue(0), (byte) (ImageFormat.getBitsPerPixel(0) + 1), (short) (ViewConfiguration.getScrollDefaultDelay() >> 16), 884659211 - (ViewConfiguration.getPressedStateDuration() >> 16), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (Process.myTid() >> 22) + 18, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b((byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                byte b = (byte) (getAuthRequestContext[30] + 1);
                Object[] objArr15 = new Object[1];
                b(b, (byte) (b | 22), getAuthRequestContext[25], objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (Process.myPid() >> 22), 3 - ExpandableListView.getPackedPositionType(0L), (char) (Process.myTid() >> 22));
                        Object[] objArr17 = new Object[1];
                        c($$a[53], $$a[78], $$a[12], objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 15 - View.resolveSizeAndState(0, 0, 0), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - MotionEvent.axisFromString(""), 15 - KeyEvent.getDeadChar(0, 0), (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - View.MeasureSpec.getMode(0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 29, (char) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 800, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 15, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1))));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr18));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {-1430757366, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.alpha(0), 18 - Gravity.getAbsoluteGravity(0, 0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                byte b2 = (byte) (getAuthRequestContext[30] + 1);
                Object[] objArr22 = new Object[1];
                b(b2, (byte) (b2 | 22), getAuthRequestContext[25], objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 61, 45 - ExpandableListView.getPackedPositionChild(0L), (char) TextUtils.indexOf("", ""));
                        byte b3 = $$a[84];
                        byte b4 = (byte) ($$a[78] - 1);
                        Object[] objArr24 = new Object[1];
                        c(b3, b4, b4, objArr24);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr26 = {-1430757366, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776305) - Color.rgb(0, 0, 0), (Process.myTid() >> 22) + 18, (char) Color.red(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                byte b5 = (byte) (getAuthRequestContext[30] + 1);
                Object[] objArr29 = new Object[1];
                b(b5, (byte) (b5 | 22), getAuthRequestContext[25], objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - Color.blue(0), TextUtils.getCapsMode("", 0, 0) + 3, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 38969));
                        byte b6 = $$a[84];
                        byte b7 = (byte) ($$a[78] - 1);
                        Object[] objArr31 = new Object[1];
                        c(b6, b7, b7, objArr31);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {-1430757366, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 912, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 18, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                byte b8 = (byte) (getAuthRequestContext[30] + 1);
                Object[] objArr36 = new Object[1];
                b(b8, (byte) (b8 | 22), getAuthRequestContext[25], objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (ViewConfiguration.getKeyRepeatDelay() >> 16), View.MeasureSpec.makeMeasureSpec(0, 0) + 3, (char) (AndroidCharacter.getMirror('0') - '0'));
                        Object[] objArr38 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[8], $$a[9], objArr38);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, View.MeasureSpec.makeMeasureSpec(0, 0) + 35, (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr40 = {-1430757366, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 911, (ViewConfiguration.getWindowTouchSlop() >> 8) + 18, (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        int codePointAt = getPackageName().codePointAt(1) + 1520216081;
        int codePointAt2 = getPackageName().codePointAt(3) - 135;
        byte codePointAt3 = (byte) (getPackageName().codePointAt(6) - 97);
        short codePointAt4 = (short) (super.getResources().getString(R.string.upload_files_bridge_bottomsheet_title).substring(9, 10).codePointAt(0) - 121);
        try {
            byte b = getAuthRequestContext[25];
            Object[] objArr = new Object[1];
            b(b, (byte) (b | TarHeader.LF_BLK), getAuthRequestContext[30], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(getAuthRequestContext[5], getAuthRequestContext[25], getAuthRequestContext[8], objArr2);
            int i = 884658925 + ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion;
            Object[] objArr3 = new Object[1];
            a(codePointAt, codePointAt2, codePointAt3, codePointAt4, i, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(super.getResources().getString(R.string.empty_state_investment_btn).substring(0, 5).length() + 1520216188, (-49) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (byte) (super.getResources().getString(R.string.cancel_survey_header_label).substring(5, 6).codePointAt(0) - 97), (short) (getPackageName().codePointAt(3) - 100), super.getResources().getString(R.string.scan_cpm_to_sendmoney_dialog_dont_show).substring(2, 3).codePointAt(0) + 884658865, objArr4);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    int codePointAt5 = super.getResources().getString(R.string.recipient_not_found_title).substring(7, 8).codePointAt(0) + 1520216081;
                    int argb = Color.argb(0, 0, 0, 0) - 27;
                    byte length = (byte) (getPackageName().length() - 7);
                    short length2 = (short) (super.getResources().getString(R.string.lbl_profile_completion_desc_finished_kyc).substring(14, 15).length() - 1);
                    try {
                        byte b2 = getAuthRequestContext[25];
                        Object[] objArr5 = new Object[1];
                        b(b2, (byte) (b2 | TarHeader.LF_BLK), getAuthRequestContext[30], objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        Object[] objArr6 = new Object[1];
                        b(getAuthRequestContext[5], getAuthRequestContext[25], getAuthRequestContext[8], objArr6);
                        int i2 = ((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 884658883;
                        Object[] objArr7 = new Object[1];
                        a(codePointAt5, argb, length, length2, i2, objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        a(TextUtils.lastIndexOf("", '0') + 1520216184, super.getResources().getString(R.string.my_bills_label_service_gaspgn).substring(0, 3).codePointAt(2) - 113, (byte) (super.getResources().getString(R.string.desc_call_cs_emoney).substring(0, 1).length() - 1), (short) (super.getResources().getString(R.string.explore_all_online_merchant).substring(1, 2).codePointAt(0) - 73), super.getResources().getString(R.string.setting_security_settings).substring(1, 2).codePointAt(0) + 884658840, objArr8);
                        baseContext = (Context) cls4.getMethod((String) objArr8[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getWindowTouchSlop() >> 8), Process.getGidForName("") + 36, (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr9 = new Object[1];
                        a(getPackageName().length() + 1520216132, (-5) - TextUtils.getTrimmedLength(""), (byte) (super.getResources().getString(R.string.bottom_sheet_auto_routing_title).substring(8, 9).codePointAt(0) + SecLiteException.ERROR_API_KEY_OR_SIGN), (short) (super.getResources().getString(R.string.board_info).substring(10, 11).length() - 1), getPackageName().codePointAt(4) + 884658882, objArr9);
                        String str = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a(getPackageName().length() + 1520216174, (ViewConfiguration.getPressedStateDuration() >> 16) + 11, (byte) (((byte) KeyEvent.getModifierMetaStateMask()) + 1), (short) (getPackageName().length() - 7), 884659026 - Color.alpha(0), objArr10);
                        String str2 = (String) objArr10[0];
                        try {
                            byte b3 = getAuthRequestContext[25];
                            Object[] objArr11 = new Object[1];
                            b(b3, (byte) (b3 | TarHeader.LF_BLK), getAuthRequestContext[30], objArr11);
                            Class<?> cls5 = Class.forName((String) objArr11[0]);
                            Object[] objArr12 = new Object[1];
                            b(getAuthRequestContext[5], getAuthRequestContext[25], getAuthRequestContext[8], objArr12);
                            Object[] objArr13 = new Object[1];
                            a(((ApplicationInfo) cls5.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion + 1520216101, Color.red(0) + 11, (byte) (Process.getGidForName("") + 1), (short) (super.getResources().getString(R.string.pushverify_verify_dialog_login_success_title).substring(14, 15).length() - 1), super.getResources().getString(R.string.bottom_on_boarding_subtitle_dana_kaget_fourth).substring(2, 3).length() + 884659088, objArr13);
                            String str3 = (String) objArr13[0];
                            int length3 = getPackageName().length() + 1520216181;
                            int codePointAt6 = super.getResources().getString(R.string.open_all_day).substring(4, 8).codePointAt(1) - 43;
                            byte codePointAt7 = (byte) (super.getResources().getString(R.string.my_bills_prepaid).substring(0, 2).codePointAt(0) - 80);
                            try {
                                byte b4 = getAuthRequestContext[25];
                                Object[] objArr14 = new Object[1];
                                b(b4, (byte) (b4 | TarHeader.LF_BLK), getAuthRequestContext[30], objArr14);
                                Class<?> cls6 = Class.forName((String) objArr14[0]);
                                b(getAuthRequestContext[5], getAuthRequestContext[25], getAuthRequestContext[8], new Object[1]);
                                Object[] objArr15 = new Object[1];
                                a(length3, codePointAt6, codePointAt7, (short) (((ApplicationInfo) cls6.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 33), super.getResources().getString(R.string.cashier_dana_kaget_additional_header).substring(9, 10).length() + 884659151, objArr15);
                                String str4 = (String) objArr15[0];
                                try {
                                    byte b5 = getAuthRequestContext[25];
                                    Object[] objArr16 = new Object[1];
                                    b(b5, (byte) (b5 | TarHeader.LF_BLK), getAuthRequestContext[30], objArr16);
                                    Class<?> cls7 = Class.forName((String) objArr16[0]);
                                    Object[] objArr17 = new Object[1];
                                    b(getAuthRequestContext[5], getAuthRequestContext[25], getAuthRequestContext[8], objArr17);
                                    Object[] objArr18 = new Object[1];
                                    a(((ApplicationInfo) cls7.getMethod((String) objArr17[0], null).invoke(this, null)).targetSdkVersion + 1520216108, super.getResources().getString(R.string.family_account_text_desc_intro_3).substring(7, 8).length() - 48, (byte) (super.getResources().getString(R.string.promo_quest_error_mission_description).substring(14, 15).codePointAt(0) - 32), (short) (super.getResources().getString(R.string.send_money_text_desc_dialog_delete_quick_action).substring(26, 28).length() - 2), 884659211 - KeyEvent.getDeadChar(0, 0), objArr18);
                                    try {
                                        Object[] objArr19 = {baseContext, str, str2, str3, str4, true, (String) objArr18[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.getDeadChar(0, 0), 18 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                        }
                                        ((Method) obj2).invoke(invoke, objArr19);
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
                }
            }
            try {
                Object[] objArr20 = new Object[1];
                b((byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr20);
                Class<?> cls8 = Class.forName((String) objArr20[0]);
                byte b6 = (byte) (getAuthRequestContext[30] + 1);
                Object[] objArr21 = new Object[1];
                b(b6, (byte) (b6 | 22), getAuthRequestContext[25], objArr21);
                try {
                    Object[] objArr22 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr21[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 494, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 3, (char) TextUtils.getTrimmedLength(""));
                        Object[] objArr23 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[8], $$a[9], objArr23);
                        obj3 = cls9.getMethod((String) objArr23[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr24 = (Object[]) ((Method) obj3).invoke(null, objArr22);
                    int i3 = ((int[]) objArr24[1])[0];
                    if (((int[]) objArr24[0])[0] != i3) {
                        long j = ((r0 ^ i3) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 35 - ExpandableListView.getPackedPositionGroup(0L), (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(null, null);
                            try {
                                Object[] objArr25 = {100503427, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 911, Process.getGidForName("") + 19, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr25);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.voucher_and_ticket_header_new_total_assets_nine_plus).substring(0, 3).length() + 1520216178, View.combineMeasuredStates(0, 0) - 27, (byte) Color.blue(0), (short) View.MeasureSpec.getSize(0), super.getResources().getString(R.string.profile_completion_task_description_security_question).substring(1, 2).length() + 884658915, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            int codePointAt = super.getResources().getString(R.string.tooltip_smartpay_available_description).substring(22, 23).codePointAt(0) + 1520216067;
            int length = getPackageName().length() - 42;
            try {
                byte b = getAuthRequestContext[25];
                Object[] objArr2 = new Object[1];
                b(b, (byte) (b | TarHeader.LF_BLK), getAuthRequestContext[30], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                b(getAuthRequestContext[5], getAuthRequestContext[25], getAuthRequestContext[8], new Object[1]);
                Object[] objArr3 = new Object[1];
                a(codePointAt, length, (byte) (((ApplicationInfo) cls2.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 33), (short) (AndroidCharacter.getMirror('0') - '0'), getPackageName().length() + 884658934, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 18 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
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
        super.onPause();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Class<?> cls;
        Object[] objArr;
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.my_bills_intro_first_content_subtitle).substring(1, 2).length() + 1520216180, getPackageName().length() - 34, (byte) (super.getResources().getString(R.string.bottom_on_boarding_title_scan).substring(1, 2).codePointAt(0) - 97), (short) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), getPackageName().length() + 884658909, objArr2);
            Class<?> cls2 = Class.forName((String) objArr2[0]);
            int codePointAt = getPackageName().codePointAt(2) + 1520216137;
            int lastIndexOf = (-36) - TextUtils.lastIndexOf("", '0');
            byte codePointAt2 = (byte) (getPackageName().codePointAt(1) - 100);
            short scrollBarSize = (short) (ViewConfiguration.getScrollBarSize() >> 8);
            try {
                byte b = getAuthRequestContext[25];
                Object[] objArr3 = new Object[1];
                b(b, (byte) (b | TarHeader.LF_BLK), getAuthRequestContext[30], objArr3);
                cls = Class.forName((String) objArr3[0]);
                objArr = new Object[1];
                b(getAuthRequestContext[5], getAuthRequestContext[25], getAuthRequestContext[8], objArr);
            } catch (Throwable th) {
                th = th;
            }
            try {
                int i = ((ApplicationInfo) cls.getMethod((String) objArr[0], null).invoke(this, null)).targetSdkVersion + 884658908;
                Object[] objArr4 = new Object[1];
                a(codePointAt, lastIndexOf, codePointAt2, scrollBarSize, i, objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Gravity.getAbsoluteGravity(0, 0), View.resolveSize(0, 0) + 35, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778127, 19 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
    public final FamilyActivationContract.Presenter getPresenter() {
        FamilyActivationContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(FamilyActivationContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "getFamilyAccountAnalyticalTracker")
    public final FamilyAccountAnalyticalTracker getFamilyAccountAnalyticalTracker() {
        FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker = this.familyAccountAnalyticalTracker;
        if (familyAccountAnalyticalTracker != null) {
            return familyAccountAnalyticalTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFamilyAccountAnalyticalTracker")
    public final void setFamilyAccountAnalyticalTracker(FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker) {
        Intrinsics.checkNotNullParameter(familyAccountAnalyticalTracker, "");
        this.familyAccountAnalyticalTracker = familyAccountAnalyticalTracker;
    }

    @JvmName(name = "getDynamicUrlWrapper")
    public final DynamicUrlWrapper getDynamicUrlWrapper() {
        DynamicUrlWrapper dynamicUrlWrapper = this.dynamicUrlWrapper;
        if (dynamicUrlWrapper != null) {
            return dynamicUrlWrapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDynamicUrlWrapper")
    public final void setDynamicUrlWrapper(DynamicUrlWrapper dynamicUrlWrapper) {
        Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
        this.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        initComponent();
        ViewPager2 viewPager2 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Context context = viewPager2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        viewPager2.setAdapter(new FamilyAccountIntroContentAdapter(context));
        TabLayout tabLayout = getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(tabLayout, "");
        ViewPager2 viewPager22 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(viewPager22, "");
        ViewPagerExtKt.getAuthRequestContext(tabLayout, viewPager22, ViewPagerExtKt$attachViewPager$1.INSTANCE);
        getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.intro.FamilyAccountIntroActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyAccountIntroActivity.m2591$r8$lambda$Gs1ZIWoEs2Ot38N6s6HlvCDN3Q(FamilyAccountIntroActivity.this, view);
            }
        });
        getFamilyAccountAnalyticalTracker().getAuthRequestContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityFamilyAccountIntroBinding inflateViewBinding() {
        ActivityFamilyAccountIntroBinding MyBillsEntityDataFactory = ActivityFamilyAccountIntroBinding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        DaggerFamilyAccountIntroComponent.Builder KClassImpl$Data$declaredNonStaticMembers$22 = DaggerFamilyAccountIntroComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        Application application = getApplication();
        DanaApplication danaApplication = application instanceof DanaApplication ? (DanaApplication) application : null;
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(danaApplication != null ? danaApplication.getApplicationComponent() : null);
        KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = (FamilyAccountIntroModule) Preconditions.getAuthRequestContext(new FamilyAccountIntroModule(new FamilyActivationContract.View() { // from class: id.dana.familyaccount.view.intro.FamilyAccountIntroActivity$getFamilyAccountModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.familyaccount.contract.FamilyActivationContract.View
            public final void PlaceComponentResult(UserInfoResponse p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                FamilyAccountIntroActivity.this.getPresenter().KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
            }

            @Override // id.dana.familyaccount.contract.FamilyActivationContract.View
            public final void getAuthRequestContext() {
                FamilyAccountIntroActivity.this.getFamilyAccountAnalyticalTracker().KClassImpl$Data$declaredNonStaticMembers$2("Pending");
                FamilyAccountIntroActivity.access$showUpgradePremiumDialog(FamilyAccountIntroActivity.this);
            }

            @Override // id.dana.familyaccount.contract.FamilyActivationContract.View
            public final void getAuthRequestContext(UserInfoResponse p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                FamilyAccountIntroActivity.this.getFamilyAccountAnalyticalTracker().KClassImpl$Data$declaredNonStaticMembers$2("Success");
                FamilyAccountIntroActivity.access$redirectRegistrationSuccess(FamilyAccountIntroActivity.this, p0, p1);
            }

            @Override // id.dana.familyaccount.contract.FamilyActivationContract.View
            public final void PlaceComponentResult(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                FamilyAccountIntroActivity.this.getFamilyAccountAnalyticalTracker().KClassImpl$Data$declaredNonStaticMembers$2("Failed");
                DANAToast dANAToast = DANAToast.PlaceComponentResult;
                DANAToast.PlaceComponentResult(FamilyAccountIntroActivity.this, p0);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                DanaLoadingDialog access$getDanaLoadingDialog = FamilyAccountIntroActivity.access$getDanaLoadingDialog(FamilyAccountIntroActivity.this);
                if (access$getDanaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                    return;
                }
                access$getDanaLoadingDialog.MyBillsEntityDataFactory.show();
                access$getDanaLoadingDialog.getAuthRequestContext.startRefresh();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                FamilyAccountIntroActivity.access$getDanaLoadingDialog(FamilyAccountIntroActivity.this).PlaceComponentResult();
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory, FamilyAccountIntroModule.class);
        if (KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult == null) {
            KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult = new FamilyAccountTrackerModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext, ApplicationComponent.class);
        new DaggerFamilyAccountIntroComponent.FamilyAccountIntroComponentImpl(KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext, (byte) 0).BuiltInFictitiousFunctionClassFactory(this);
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        super.onBackPressed();
        getFamilyAccountAnalyticalTracker().KClassImpl$Data$declaredNonStaticMembers$2(USER_CLICK_BACK);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        getPresenter().onDestroy();
        super.onDestroy();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/familyaccount/view/intro/FamilyAccountIntroActivity$Companion;", "", "Landroid/content/Context;", "p0", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "(Landroid/content/Context;)Landroid/content/Intent;", "", "USER_CLICK_BACK", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Intent MyBillsEntityDataFactory(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new Intent(p0, FamilyAccountIntroActivity.class);
        }
    }

    public static /* synthetic */ void $r8$lambda$5kn3KEm9wcf1ItZaYNzhQ4XASVU(FamilyAccountIntroActivity familyAccountIntroActivity, View view) {
        Intrinsics.checkNotNullParameter(familyAccountIntroActivity, "");
        familyAccountIntroActivity.finish();
    }

    /* renamed from: $r8$lambda$Gs1ZIWoEs2Ot38N6s6HlvCDN3-Q  reason: not valid java name */
    public static /* synthetic */ void m2591$r8$lambda$Gs1ZIWoEs2Ot38N6s6HlvCDN3Q(FamilyAccountIntroActivity familyAccountIntroActivity, View view) {
        Intrinsics.checkNotNullParameter(familyAccountIntroActivity, "");
        familyAccountIntroActivity.getPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static final /* synthetic */ DanaLoadingDialog access$getDanaLoadingDialog(FamilyAccountIntroActivity familyAccountIntroActivity) {
        return (DanaLoadingDialog) familyAccountIntroActivity.PlaceComponentResult.getValue();
    }

    public static final /* synthetic */ void access$redirectRegistrationSuccess(FamilyAccountIntroActivity familyAccountIntroActivity, UserInfoResponse userInfoResponse, String str) {
        Intent intent = new Intent(familyAccountIntroActivity, FamilyAccountRegistrationActivity.class);
        FamilyTncConsentActivity.Companion companion = FamilyTncConsentActivity.INSTANCE;
        intent.putExtra(FamilyTncConsentActivity.Companion.PlaceComponentResult(), userInfoResponse.getKtpName());
        FamilyTncConsentActivity.Companion companion2 = FamilyTncConsentActivity.INSTANCE;
        intent.putExtra(FamilyTncConsentActivity.Companion.BuiltInFictitiousFunctionClassFactory(), PhoneNumberUtilKt.removeIndoPhonePrefix(str));
        familyAccountIntroActivity.startActivity(intent);
        familyAccountIntroActivity.finish();
    }

    public static final /* synthetic */ void access$showUpgradePremiumDialog(final FamilyAccountIntroActivity familyAccountIntroActivity) {
        CustomDialog.Builder builder = new CustomDialog.Builder(familyAccountIntroActivity);
        builder.SubSequence = familyAccountIntroActivity.getString(R.string.family_account_text_upgrade_premium_dialog);
        builder.GetContactSyncConfig = familyAccountIntroActivity.getString(R.string.family_account_text_desc_upgrade_premium_dialog);
        builder.DatabaseTableConfigUtil = R.drawable.ic_illustration_kyc_unlock;
        builder.moveToNextValue = 0L;
        builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory(familyAccountIntroActivity.getString(R.string.upgrade), new Function1<View, Unit>() { // from class: id.dana.familyaccount.view.intro.FamilyAccountIntroActivity$showUpgradePremiumDialog$1
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
                StringBuilder sb = new StringBuilder();
                sb.append("https://m.dana.id");
                sb.append(FamilyAccountIntroActivity.this.getDynamicUrlWrapper().getKycLandingPageUrl());
                DanaH5.startContainerFullUrl(sb.toString());
            }
        }).KClassImpl$Data$declaredNonStaticMembers$2(familyAccountIntroActivity.getString(R.string.later), new Function1<View, Unit>() { // from class: id.dana.familyaccount.view.intro.FamilyAccountIntroActivity$showUpgradePremiumDialog$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        }).BuiltInFictitiousFunctionClassFactory().show();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        LayoutToolbarBinding layoutToolbarBinding = getBinding().getAuthRequestContext;
        TextView textView = layoutToolbarBinding.initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
        ImageView imageView = layoutToolbarBinding.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(8);
        layoutToolbarBinding.initRecordTimeStamp.setText(getString(R.string.family_account_text_title_toolbar));
        LayoutToolbarBinding layoutToolbarBinding2 = getBinding().getAuthRequestContext;
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationIcon(R.drawable.btn_arrow_left);
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.intro.FamilyAccountIntroActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyAccountIntroActivity.$r8$lambda$5kn3KEm9wcf1ItZaYNzhQ4XASVU(FamilyAccountIntroActivity.this, view);
            }
        });
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(4);
        Toolbar toolbar = layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        int childCount = toolbar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = toolbar.getChildAt(i);
            ImageButton imageButton = childAt instanceof ImageButton ? (ImageButton) childAt : null;
            if (imageButton != null) {
                imageButton.setContentDescription(getResources().getString(R.string.imgBtnLeft));
            }
        }
    }

    private static void a(int i, int i2, byte b, short s, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (scheduleImpl ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = initRecordTimeStamp;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (initRecordTimeStamp[i3 + ((int) (getErrorConfigVersion ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (scheduleImpl ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (NetworkUserEntityData$$ExternalSyntheticLambda1[i3 + ((int) (getErrorConfigVersion ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (scheduleImpl ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (getErrorConfigVersion ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i + ((int) (lookAheadTest ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = initRecordTimeStamp;
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
                    byte[] bArr5 = initRecordTimeStamp;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = NetworkUserEntityData$$ExternalSyntheticLambda1;
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
