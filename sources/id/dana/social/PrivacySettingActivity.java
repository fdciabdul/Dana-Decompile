package id.dana.social;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
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
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.SwitchCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.plus.security.lite.SecLiteException;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.component.cellcomponent.DanaCellRightView;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.di.component.ApplicationComponent;
import id.dana.dialog.LoadingDialog;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.myprofile.MyProfileBundleKey;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.social.contract.PrivacySettingContract;
import id.dana.social.di.component.DaggerPrivacySettingComponent;
import id.dana.social.di.module.PrivacySettingModule;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rR\u0013\u0010\u0011\u001a\u00020\u000eX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\u00020\u00128\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001b\u001a\u00020\u0019X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u0010R\"\u0010\u001d\u001a\u00020\u001c8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\""}, d2 = {"Lid/dana/social/PrivacySettingActivity;", "Lid/dana/base/BaseActivity;", "", "p0", "", "PlaceComponentResult", "(Z)V", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "()V", "BuiltInFictitiousFunctionClassFactory", "()Z", "Lcom/afollestad/materialdialogs/MaterialDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/Lazy;", "getAuthRequestContext", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "friendshipAnalyticTracker", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "getFriendshipAnalyticTracker", "()Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "setFriendshipAnalyticTracker", "(Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;)V", "Lid/dana/dialog/LoadingDialog;", "getErrorConfigVersion", "MyBillsEntityDataFactory", "Lid/dana/social/contract/PrivacySettingContract$Presenter;", "presenter", "Lid/dana/social/contract/PrivacySettingContract$Presenter;", "getPresenter", "()Lid/dana/social/contract/PrivacySettingContract$Presenter;", "setPresenter", "(Lid/dana/social/contract/PrivacySettingContract$Presenter;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PrivacySettingActivity extends BaseActivity {
    private static short[] DatabaseTableConfigUtil;
    @Inject
    public FriendshipAnalyticTracker friendshipAnalyticTracker;
    @Inject
    public PrivacySettingContract.Presenter presenter;
    public static final byte[] $$a = {117, -10, 119, -11, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 57;
    public static final byte[] getAuthRequestContext = {11, 41, -68, -59, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 31;
    private static int lookAheadTest = 1257195688;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda1 = -407953563;
    private static byte[] GetContactSyncConfig = {-124, 9, Ascii.DC4, -69, -79, -20, -126, -68, Ascii.DC4, -70, 18, -74, -93, -76, 71, -123, -72, -44, -5, 12, 11, 10, -73, 15, -70, 119, -48, 65, -37, 120, 116, 121, 122, -50, -89, -119, -48, -59, 123, -50, 121, -36, -110, -108, -112, 94, 37, 112, 112, -25, -114, -47, 88, 39, 40, 37, -108, 92, -107, -62, -19, -91, Ascii.NAK, -24, -60, TarHeader.LF_SYMLINK, -25, -59, 9, -24, -64, 91, 88, TarHeader.LF_BLK, -26, -64, 87, 86, 47, -1, 86, Ascii.NAK, 9, -25, -2, 8, -23, TarHeader.LF_BLK, -61, 88, -60, -20, -2, -61, 92, -2, 88, 6, 88, -60, 89, -23, 88, 88, 46, 15, 91, -59, TarHeader.LF_BLK, -25, -102, 125, 34, -102, -118, 79, 32, -118, 32, -120, -117, 33, 95, 37, 33, -115, 35, -121, 117, 79, -99, 84, -122, 95, 94, -100, 33, 118, 37, 113, 32, 80, 33, -101, 125, 110, 125, 114, 125, 94, -116, 36, -100, 78, -106, 85, 33, -117, 94, 33, -100, 122, -115, 115, -118, 125, 89, -110, 110, 95, 123, 32, 117, -21, -25, 38, -41, Ascii.DC4, -21, Ascii.NAK, -23, 38, -36, 22, 36, -23, -63, 58, -21, -24, -40, 15, -21, -22, 34, -59, -25, -23, 22, 60, -63, -19, 37, -60, 59, -61, 56, -25, -59, 22, 58, -58, -21, 57, 22, -41, 37, -41, 38, -21, -63, -18, Ascii.DC4, -23, -25, 16, -25, -25, -21, -23, 18, Ascii.NAK, 62, Ascii.DC4, -37, 22, -127, -88, -77, -111, -37, -8, -65, 126, -23, 69, -85, -80, Byte.MIN_VALUE, -125, -89, -60, 104, -125, -79, -4, 108, Byte.MIN_VALUE, -82, -9, 115, -67, -37, -114, -90, Byte.MIN_VALUE, -79, -68, -37, -114, -80, -61, 68, -85, -36, Byte.MIN_VALUE, -111, -35, -66, -67, -76, -74, -24, 111, -67, -81, -65, -9, -86, -73, 105, -83, -66, -86, -82, TarHeader.LF_LINK, -26, 44, -24, TarHeader.LF_CONTIG, -97, -97, -97, -97, -97, -97, -97, -97, -97};
    private static int scheduleImpl = 538233358;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<LoadingDialog>() { // from class: id.dana.social.PrivacySettingActivity$loadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LoadingDialog invoke() {
            return new LoadingDialog(PrivacySettingActivity.this);
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<MaterialDialog>() { // from class: id.dana.social.PrivacySettingActivity$deactivateDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MaterialDialog invoke() {
            CustomDialog.Builder builder = new CustomDialog.Builder(PrivacySettingActivity.this);
            builder.SubSequence = PrivacySettingActivity.this.getString(R.string.deactivate_feed_dialog_title);
            builder.GetContactSyncConfig = PrivacySettingActivity.this.getString(R.string.deactivate_feed_dialog_desc);
            String string = PrivacySettingActivity.this.getString(R.string.option_no);
            final PrivacySettingActivity privacySettingActivity = PrivacySettingActivity.this;
            CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2(string, new Function1<View, Unit>() { // from class: id.dana.social.PrivacySettingActivity$deactivateDialog$2.1
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
                    PrivacySettingActivity.access$getDeactivateDialog(PrivacySettingActivity.this).dismiss();
                }
            });
            String string2 = PrivacySettingActivity.this.getString(R.string.option_yes);
            final PrivacySettingActivity privacySettingActivity2 = PrivacySettingActivity.this;
            CustomDialog.Builder BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(string2, new Function1<View, Unit>() { // from class: id.dana.social.PrivacySettingActivity$deactivateDialog$2.2
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
                    boolean BuiltInFictitiousFunctionClassFactory2;
                    Intrinsics.checkNotNullParameter(view, "");
                    PrivacySettingActivity.this.getPresenter().BuiltInFictitiousFunctionClassFactory();
                    PrivacySettingActivity.this.getFriendshipAnalyticTracker().PlaceComponentResult();
                    PrivacySettingActivity.access$getDeactivateDialog(PrivacySettingActivity.this).dismiss();
                    BuiltInFictitiousFunctionClassFactory2 = PrivacySettingActivity.this.BuiltInFictitiousFunctionClassFactory();
                    if (BuiltInFictitiousFunctionClassFactory2) {
                        PrivacySettingActivity.access$openHomeToActivate(PrivacySettingActivity.this);
                    }
                }
            });
            BuiltInFictitiousFunctionClassFactory.moveToNextValue = 0L;
            return BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory();
        }
    });

    /* JADX WARN: Removed duplicated region for block: B:20:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r5, byte r6, int r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = id.dana.social.PrivacySettingActivity.getAuthRequestContext
            int r5 = r5 + 4
            int r7 = 23 - r7
            int r6 = 106 - r6
            byte[] r1 = new byte[r7]
            r2 = -1
            int r7 = r7 + r2
            if (r0 != 0) goto L15
            r6 = r5
            r2 = r1
            r3 = -1
            r1 = r0
            r0 = r8
            r8 = r7
            goto L31
        L15:
            r4 = r6
            r6 = r5
            r5 = r4
        L18:
            int r2 = r2 + 1
            byte r3 = (byte) r5
            r1[r2] = r3
            if (r2 != r7) goto L28
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r1, r6)
            r8[r6] = r5
            return
        L28:
            r3 = r0[r6]
            r4 = r8
            r8 = r7
            r7 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r4
        L31:
            int r5 = r5 + r7
            int r6 = r6 + 1
            int r5 = r5 + (-4)
            r7 = r8
            r8 = r0
            r0 = r1
            r1 = r2
            r2 = r3
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.PrivacySettingActivity.a(short, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002d -> B:23:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 3
            int r9 = 42 - r9
            int r7 = r7 + 4
            byte[] r0 = id.dana.social.PrivacySettingActivity.$$a
            int r8 = r8 * 2
            int r8 = 103 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r7
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L37
        L18:
            r3 = 0
            r6 = r9
            r9 = r8
        L1b:
            r8 = r6
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            int r7 = r7 + 1
            if (r5 != r8) goto L2d
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2d:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L37:
            int r10 = r10 + r7
            int r7 = r10 + (-7)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r9
            r9 = r7
            r7 = r8
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.PrivacySettingActivity.c(short, int, int, java.lang.Object[]):void");
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
        b((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 1388292198, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) - 37, (byte) ((-89) - MotionEvent.axisFromString("")), (short) ((-101) - KeyEvent.getDeadChar(0, 0)), (-1794867816) - MotionEvent.axisFromString(""), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(Color.blue(0) + 1388292211, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) - 49, (byte) (Color.rgb(0, 0, 0) + 16777238), (short) ((-113) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), (-1794867798) - (ViewConfiguration.getPressedStateDuration() >> 16), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 881, 35 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(1388292156 - TextUtils.indexOf((CharSequence) "", '0'), (-8) - Process.getGidForName(""), (byte) ((ViewConfiguration.getLongPressTimeout() >> 16) - 54), (short) (110 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), ((byte) KeyEvent.getModifierMetaStateMask()) - 1794867793, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(ImageFormat.getBitsPerPixel(0) + 1388292200, (KeyEvent.getMaxKeyCode() >> 16) + 9, (byte) (84 - KeyEvent.normalizeMetaState(0)), (short) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 107), (-1794867746) - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b((KeyEvent.getMaxKeyCode() >> 16) + 1388292152, View.combineMeasuredStates(0, 0) + 9, (byte) ((Process.myTid() >> 22) - 9), (short) ((ViewConfiguration.getEdgeSlop() >> 16) + 127), TextUtils.indexOf((CharSequence) "", '0', 0) - 1794867683, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(1388292207 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), TextUtils.indexOf("", "") + 5, (byte) (View.MeasureSpec.getMode(0) - 117), (short) ((ViewConfiguration.getLongPressTimeout() >> 16) + 86), (-1794867621) - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(View.MeasureSpec.getSize(0) + 1388292159, TextUtils.lastIndexOf("", '0', 0, 0) - 48, (byte) ((-25) - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), (short) (105 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), (-1794867563) - TextUtils.indexOf((CharSequence) "", '0'), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 911, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 18, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a((short) 37, getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(getAuthRequestContext[35], getAuthRequestContext[7], (byte) (-getAuthRequestContext[30]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(54 - MotionEvent.axisFromString(""), KeyEvent.keyCodeFromString("") + 3, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        Object[] objArr16 = new Object[1];
                        c($$a[47], $$a[12], $$a[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.resolveSizeAndState(0, 0, 0), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 15, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 800, TextUtils.getCapsMode("", 0, 0) + 15, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 814, View.MeasureSpec.getMode(0) + 29, (char) (57994 - (Process.myTid() >> 22)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - ((Process.getThreadPriority(0) + 20) >> 6), 15 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) TextUtils.getTrimmedLength("")));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r6 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getLongPressTimeout() >> 16), 34 - MotionEvent.axisFromString(""), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {709467372, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 911, 19 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((short) 37, getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                a(getAuthRequestContext[35], getAuthRequestContext[7], (byte) (-getAuthRequestContext[30]), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + 61, 46 - TextUtils.indexOf("", "", 0), (char) Color.red(0));
                        Object[] objArr22 = new Object[1];
                        c($$a[28], (byte) ($$a[78] - 1), $$a[8], objArr22);
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
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {709467372, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 910, 18 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((short) 37, getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                a(getAuthRequestContext[35], getAuthRequestContext[7], (byte) (-getAuthRequestContext[30]), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(117 - TextUtils.lastIndexOf("", '0'), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 3, (char) (38968 - (ViewConfiguration.getPressedStateDuration() >> 16)));
                        Object[] objArr28 = new Object[1];
                        c($$a[28], (byte) ($$a[78] - 1), $$a[8], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, Color.red(0) + 35, (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {709467372, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 911, ExpandableListView.getPackedPositionType(0L) + 18, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((short) 37, getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                a(getAuthRequestContext[35], getAuthRequestContext[7], (byte) (-getAuthRequestContext[30]), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (KeyEvent.getMaxKeyCode() >> 16), 4 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16));
                        Object[] objArr34 = new Object[1];
                        c((byte) (-$$a[40]), $$a[9], (byte) ($$a[78] - 1), objArr34);
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
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 35 - (ViewConfiguration.getScrollBarSize() >> 8), (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {709467372, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTouchSlop() >> 8), (-16777198) - Color.rgb(0, 0, 0), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_privacy_setting;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        int i;
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3 = new Object[1];
        b(TextUtils.lastIndexOf("", '0', 0) + 1388292200, AndroidCharacter.getMirror('0') - 'U', (byte) ((-87) - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), (short) (super.getResources().getString(R.string.verify_pin_error_subtitle).substring(0, 1).codePointAt(0) - 184), (-1794867815) - TextUtils.getOffsetBefore("", 0), objArr3);
        Class<?> cls = Class.forName((String) objArr3[0]);
        Object[] objArr4 = new Object[1];
        b(getPackageName().length() + 1388292204, super.getResources().getString(R.string.image_saved_to_gallery_failed).substring(1, 2).codePointAt(0) - 147, (byte) (super.getResources().getString(R.string.clear_all).substring(5, 6).length() + 21), (short) ((-111) - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), (-1794867798) - TextUtils.indexOf("", "", 0, 0), objArr4);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    Object[] objArr5 = new Object[1];
                    a(getAuthRequestContext[25], getAuthRequestContext[32], getAuthRequestContext[25], objArr5);
                    Class<?> cls2 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[13], getAuthRequestContext[27], objArr6);
                    Object[] objArr7 = new Object[1];
                    b(((ApplicationInfo) cls2.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 1388292166, (-29) - Gravity.getAbsoluteGravity(0, 0), (byte) ((-63) - ExpandableListView.getPackedPositionType(0L)), (short) (getPackageName().length() - 96), (-1794867857) - View.MeasureSpec.getSize(0), objArr7);
                    Class<?> cls3 = Class.forName((String) objArr7[0]);
                    try {
                        Object[] objArr8 = new Object[1];
                        a(getAuthRequestContext[25], getAuthRequestContext[32], getAuthRequestContext[25], objArr8);
                        Class<?> cls4 = Class.forName((String) objArr8[0]);
                        Object[] objArr9 = new Object[1];
                        a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[13], getAuthRequestContext[27], objArr9);
                        int i2 = ((ApplicationInfo) cls4.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 1388292168;
                        i = 3;
                        int codePointAt = super.getResources().getString(R.string.transfer_account_status_subtitle_success).substring(3, 4).codePointAt(0) - 134;
                        byte keyRepeatDelay = (byte) ((ViewConfiguration.getKeyRepeatDelay() >> 16) - 76);
                        try {
                            Object[] objArr10 = new Object[1];
                            a(getAuthRequestContext[25], getAuthRequestContext[32], getAuthRequestContext[25], objArr10);
                            Class<?> cls5 = Class.forName((String) objArr10[0]);
                            Object[] objArr11 = new Object[1];
                            a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[13], getAuthRequestContext[27], objArr11);
                            Object[] objArr12 = new Object[1];
                            b(i2, codePointAt, keyRepeatDelay, (short) (((ApplicationInfo) cls5.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 66), super.getResources().getString(R.string.continue_without_promo).substring(2, 3).codePointAt(0) - 1794867942, objArr12);
                            baseContext = (Context) cls3.getMethod((String) objArr12[0], new Class[0]).invoke(null, null);
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
            } else {
                i = 3;
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj != null) {
                        objArr = null;
                    } else {
                        objArr = null;
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778145, 34 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(objArr, objArr);
                    Object[] objArr13 = new Object[1];
                    b((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1388292157, (-7) - View.resolveSizeAndState(0, 0, 0), (byte) (super.getResources().getString(R.string.send_money_summary_bottom_sheet_description).substring(2, i).codePointAt(0) - 161), (short) (super.getResources().getString(R.string.api_limit_error_message).substring(0, 1).length() + 109), View.MeasureSpec.getMode(0) - 1794867794, objArr13);
                    String str = (String) objArr13[0];
                    try {
                        Object[] objArr14 = new Object[1];
                        a(getAuthRequestContext[25], getAuthRequestContext[32], getAuthRequestContext[25], objArr14);
                        Class<?> cls6 = Class.forName((String) objArr14[0]);
                        Object[] objArr15 = new Object[1];
                        a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[13], getAuthRequestContext[27], objArr15);
                        Object[] objArr16 = new Object[1];
                        b(((ApplicationInfo) cls6.getMethod((String) objArr15[0], null).invoke(this, null)).targetSdkVersion + 1388292166, getPackageName().codePointAt(5) + SecLiteException.ERROR_API_KEY_OR_SIGN, (byte) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 84), (short) (super.getResources().getString(R.string.join_invitation_title_content).substring(9, 10).length() - 107), getPackageName().length() - 1794867754, objArr16);
                        String str2 = (String) objArr16[0];
                        int codePointAt2 = super.getResources().getString(R.string.card_binding_cashier_main_error_description).substring(16, 18).codePointAt(1) + 1388292120;
                        int codePointAt3 = getPackageName().codePointAt(2) - 37;
                        byte offsetBefore = (byte) ((-9) - TextUtils.getOffsetBefore("", 0));
                        try {
                            Object[] objArr17 = new Object[1];
                            a(getAuthRequestContext[25], getAuthRequestContext[32], getAuthRequestContext[25], objArr17);
                            Class<?> cls7 = Class.forName((String) objArr17[0]);
                            Object[] objArr18 = new Object[1];
                            a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[13], getAuthRequestContext[27], objArr18);
                            Object[] objArr19 = new Object[1];
                            b(codePointAt2, codePointAt3, offsetBefore, (short) (((ApplicationInfo) cls7.getMethod((String) objArr18[0], null).invoke(this, null)).targetSdkVersion + 94), super.getResources().getString(R.string.lbl_account_deactivation_title).substring(11, 12).length() - 1794867685, objArr19);
                            String str3 = (String) objArr19[0];
                            int codePointAt4 = super.getResources().getString(R.string.verification_list_title).substring(0, 6).codePointAt(1) + 1388292105;
                            int codePointAt5 = super.getResources().getString(R.string.deactivate_feed_title).substring(10, 15).codePointAt(3) - 96;
                            byte codePointAt6 = (byte) (getPackageName().codePointAt(4) - 214);
                            short length = (short) (getPackageName().length() + 79);
                            try {
                                Object[] objArr20 = new Object[1];
                                a(getAuthRequestContext[25], getAuthRequestContext[32], getAuthRequestContext[25], objArr20);
                                Class<?> cls8 = Class.forName((String) objArr20[0]);
                                Object[] objArr21 = new Object[1];
                                a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[13], getAuthRequestContext[27], objArr21);
                                int i3 = ((ApplicationInfo) cls8.getMethod((String) objArr21[0], null).invoke(this, null)).targetSdkVersion - 1794867654;
                                Object[] objArr22 = new Object[1];
                                b(codePointAt4, codePointAt5, codePointAt6, length, i3, objArr22);
                                String str4 = (String) objArr22[0];
                                try {
                                    Object[] objArr23 = new Object[1];
                                    a(getAuthRequestContext[25], getAuthRequestContext[32], getAuthRequestContext[25], objArr23);
                                    Class<?> cls9 = Class.forName((String) objArr23[0]);
                                    Object[] objArr24 = new Object[1];
                                    a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[13], getAuthRequestContext[27], objArr24);
                                    int i4 = ((ApplicationInfo) cls9.getMethod((String) objArr24[0], null).invoke(this, null)).targetSdkVersion + 1388292126;
                                    try {
                                        Object[] objArr25 = new Object[1];
                                        a(getAuthRequestContext[25], getAuthRequestContext[32], getAuthRequestContext[25], objArr25);
                                        Class<?> cls10 = Class.forName((String) objArr25[0]);
                                        Object[] objArr26 = new Object[1];
                                        a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[13], getAuthRequestContext[27], objArr26);
                                        int i5 = ((ApplicationInfo) cls10.getMethod((String) objArr26[0], null).invoke(this, null)).targetSdkVersion - 82;
                                        try {
                                            Object[] objArr27 = new Object[1];
                                            a(getAuthRequestContext[25], getAuthRequestContext[32], getAuthRequestContext[25], objArr27);
                                            Class<?> cls11 = Class.forName((String) objArr27[0]);
                                            a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[13], getAuthRequestContext[27], new Object[1]);
                                            Object[] objArr28 = new Object[1];
                                            b(i4, i5, (byte) (((ApplicationInfo) cls11.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 58), (short) (super.getResources().getString(R.string.mybills_edit_bill_amount_label).substring(3, 4).codePointAt(0) - 2), (-1794867563) - ExpandableListView.getPackedPositionChild(0L), objArr28);
                                            try {
                                                Object[] objArr29 = {baseContext, str, str2, str3, str4, true, (String) objArr28[0], 995651014};
                                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                                if (obj2 == null) {
                                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 911, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 17, (char) TextUtils.indexOf("", "", 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                                }
                                                ((Method) obj2).invoke(invoke, objArr29);
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
        }
        try {
            Object[] objArr30 = new Object[1];
            a((short) 37, getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), objArr30);
            Class<?> cls12 = Class.forName((String) objArr30[0]);
            Object[] objArr31 = new Object[1];
            a(getAuthRequestContext[35], getAuthRequestContext[7], (byte) (-getAuthRequestContext[30]), objArr31);
            try {
                Object[] objArr32 = {Integer.valueOf(((Integer) cls12.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls13 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - Color.green(0), 5 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))));
                    Object[] objArr33 = new Object[1];
                    c((byte) (-$$a[40]), $$a[9], (byte) ($$a[78] - 1), objArr33);
                    obj3 = cls13.getMethod((String) objArr33[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr34 = (Object[]) ((Method) obj3).invoke(null, objArr32);
                int i6 = ((int[]) objArr34[1])[0];
                if (((int[]) objArr34[0])[0] != i6) {
                    long j = ((r0 ^ i6) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr2 = null;
                        } else {
                            objArr2 = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 35 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr2, objArr2);
                        try {
                            Object[] objArr35 = {-989606819, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 912, 18 - (ViewConfiguration.getEdgeSlop() >> 16), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr35);
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
                super.onCreate(bundle);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int length = super.getResources().getString(R.string.risk_reject_blacklist_title).substring(2, 3).length() + 1388292198;
            int codePointAt = getPackageName().codePointAt(2) - 75;
            byte codePointAt2 = (byte) (getPackageName().codePointAt(3) - 163);
            short length2 = (short) (super.getResources().getString(R.string.saved_bank).substring(1, 2).length() - 90);
            try {
                Object[] objArr = new Object[1];
                a(getAuthRequestContext[25], getAuthRequestContext[32], getAuthRequestContext[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[13], getAuthRequestContext[27], objArr2);
                int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion - 1794867890;
                Object[] objArr3 = new Object[1];
                b(length, codePointAt, codePointAt2, length2, i, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                int mode = View.MeasureSpec.getMode(0) + 1388292201;
                int i2 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 38;
                try {
                    Object[] objArr4 = new Object[1];
                    a(getAuthRequestContext[25], getAuthRequestContext[32], getAuthRequestContext[25], objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[13], getAuthRequestContext[27], new Object[1]);
                    byte b = (byte) (((ApplicationInfo) cls3.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 109);
                    short s = (short) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 98);
                    try {
                        Object[] objArr5 = new Object[1];
                        a(getAuthRequestContext[25], getAuthRequestContext[32], getAuthRequestContext[25], objArr5);
                        Class<?> cls4 = Class.forName((String) objArr5[0]);
                        Object[] objArr6 = new Object[1];
                        a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[13], getAuthRequestContext[27], objArr6);
                        int i3 = ((ApplicationInfo) cls4.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion - 1794867865;
                        Object[] objArr7 = new Object[1];
                        b(mode, i2, b, s, i3, objArr7);
                        baseContext = (Context) cls2.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 35, (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr8 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, KeyEvent.getDeadChar(0, 0) + 18, (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr8);
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
        super.onPause();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int keyRepeatTimeout = 1388292199 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
            int length = getPackageName().length() - 36;
            try {
                Object[] objArr = new Object[1];
                a(getAuthRequestContext[25], getAuthRequestContext[32], getAuthRequestContext[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[13], getAuthRequestContext[27], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(keyRepeatTimeout, length, (byte) (((ApplicationInfo) cls.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 96), (short) ((-89) - KeyEvent.keyCodeFromString("")), getPackageName().codePointAt(4) - 1794867954, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(1371514985 - Color.rgb(0, 0, 0), super.getResources().getString(R.string.payment_setting_bottomsheet_content_desc_1).substring(0, 5).length() - 42, (byte) ((ViewConfiguration.getTapTimeout() >> 16) - 76), (short) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 99), super.getResources().getString(R.string.zdoc_noface_msg).substring(0, 1).codePointAt(0) - 1794867909, objArr3);
                baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 930, Gravity.getAbsoluteGravity(0, 0) + 35, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.alpha(0), 18 - TextUtils.getTrimmedLength(""), (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getPresenter")
    public final PrivacySettingContract.Presenter getPresenter() {
        PrivacySettingContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(PrivacySettingContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "getFriendshipAnalyticTracker")
    public final FriendshipAnalyticTracker getFriendshipAnalyticTracker() {
        FriendshipAnalyticTracker friendshipAnalyticTracker = this.friendshipAnalyticTracker;
        if (friendshipAnalyticTracker != null) {
            return friendshipAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFriendshipAnalyticTracker")
    public final void setFriendshipAnalyticTracker(FriendshipAnalyticTracker friendshipAnalyticTracker) {
        Intrinsics.checkNotNullParameter(friendshipAnalyticTracker, "");
        this.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }

    private final void PlaceComponentResult(boolean p0) {
        PrivacySettingActivity privacySettingActivity = this;
        ((SwitchCompat) _$_findCachedViewById(R.id.share_feed_switch)).setThumbTintList(AppCompatResources.getAuthRequestContext(privacySettingActivity, R.color.f27072131100488));
        if (p0) {
            ((SwitchCompat) _$_findCachedViewById(R.id.share_feed_switch)).setTrackTintList(AppCompatResources.getAuthRequestContext(privacySettingActivity, R.color.f22912131099753));
        } else {
            ((SwitchCompat) _$_findCachedViewById(R.id.share_feed_switch)).setTrackTintList(AppCompatResources.getAuthRequestContext(privacySettingActivity, R.color.f23962131099992));
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return getIntent().getBooleanExtra(MyProfileBundleKey.FROM_FEEDS_SETTING_ICON, false);
    }

    public static /* synthetic */ void $r8$lambda$7oJ2teDy4RdLZWKN2C45j2uIkbk(PrivacySettingActivity privacySettingActivity, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(privacySettingActivity, "");
        privacySettingActivity.PlaceComponentResult(z);
    }

    public static /* synthetic */ void $r8$lambda$9lCGd0_3BBXcjyai2Tp1UXdp0ts(PrivacySettingActivity privacySettingActivity, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(privacySettingActivity, "");
        privacySettingActivity.PlaceComponentResult(z);
        privacySettingActivity.getPresenter().BuiltInFictitiousFunctionClassFactory(z);
    }

    public static /* synthetic */ void $r8$lambda$lcPlDW4d9sRYixRYmAMZLaWWYnA(PrivacySettingActivity privacySettingActivity, View view) {
        Intrinsics.checkNotNullParameter(privacySettingActivity, "");
        ((MaterialDialog) privacySettingActivity.getAuthRequestContext.getValue()).show();
    }

    public static final /* synthetic */ MaterialDialog access$getDeactivateDialog(PrivacySettingActivity privacySettingActivity) {
        return (MaterialDialog) privacySettingActivity.getAuthRequestContext.getValue();
    }

    public static final /* synthetic */ LoadingDialog access$getLoadingDialog(PrivacySettingActivity privacySettingActivity) {
        return (LoadingDialog) privacySettingActivity.MyBillsEntityDataFactory.getValue();
    }

    public static final /* synthetic */ void access$openHomeToActivate(PrivacySettingActivity privacySettingActivity) {
        privacySettingActivity.setResult(-1);
        privacySettingActivity.finish();
    }

    public static final /* synthetic */ void access$setShareFeedSwitchWithNoSideEffect(PrivacySettingActivity privacySettingActivity, boolean z) {
        ((SwitchCompat) privacySettingActivity._$_findCachedViewById(R.id.share_feed_switch)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.social.PrivacySettingActivity$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                PrivacySettingActivity.$r8$lambda$7oJ2teDy4RdLZWKN2C45j2uIkbk(PrivacySettingActivity.this, compoundButton, z2);
            }
        });
        ((SwitchCompat) privacySettingActivity._$_findCachedViewById(R.id.share_feed_switch)).setChecked(z);
        ((SwitchCompat) privacySettingActivity._$_findCachedViewById(R.id.share_feed_switch)).setOnCheckedChangeListener(new PrivacySettingActivity$$ExternalSyntheticLambda0(privacySettingActivity));
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        DaggerPrivacySettingComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerPrivacySettingComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (PrivacySettingModule) Preconditions.getAuthRequestContext(new PrivacySettingModule(new PrivacySettingContract.View() { // from class: id.dana.social.PrivacySettingActivity$injectComponent$1
            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.social.contract.PrivacySettingContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
                PrivacySettingActivity.access$setShareFeedSwitchWithNoSideEffect(PrivacySettingActivity.this, p0);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                LoadingDialog access$getLoadingDialog = PrivacySettingActivity.access$getLoadingDialog(PrivacySettingActivity.this);
                if (access$getLoadingDialog.BuiltInFictitiousFunctionClassFactory.isShowing()) {
                    return;
                }
                try {
                    access$getLoadingDialog.BuiltInFictitiousFunctionClassFactory.show();
                } catch (Exception unused) {
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                PrivacySettingActivity.access$getLoadingDialog(PrivacySettingActivity.this).KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.social.contract.PrivacySettingContract.View
            public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
                PrivacySettingActivity.this.getFriendshipAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }

            @Override // id.dana.social.contract.PrivacySettingContract.View
            public final void MyBillsEntityDataFactory(boolean p0) {
                PrivacySettingActivity privacySettingActivity = PrivacySettingActivity.this;
                privacySettingActivity.showToast(privacySettingActivity.getString(R.string.SchedulerPoolFactory));
                PrivacySettingActivity.access$setShareFeedSwitchWithNoSideEffect(PrivacySettingActivity.this, !p0);
            }

            @Override // id.dana.social.contract.PrivacySettingContract.View
            public final void getAuthRequestContext(boolean p0) {
                PrivacySettingActivity.this.finish();
            }

            @Override // id.dana.social.contract.PrivacySettingContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                PrivacySettingActivity privacySettingActivity = PrivacySettingActivity.this;
                privacySettingActivity.showToast(privacySettingActivity.getString(R.string.SchedulerPoolFactory));
            }
        }));
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory(this);
        setTitle(getResources().getString(R.string.privacy_setting_title));
        setMenuLeftButton(R.drawable.arrow_left_white);
        ((SwitchCompat) _$_findCachedViewById(R.id.share_feed_switch)).setOnCheckedChangeListener(new PrivacySettingActivity$$ExternalSyntheticLambda0(this));
        ((DanaCellRightView) _$_findCachedViewById(R.id.deactivate_feed_arrow)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.PrivacySettingActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrivacySettingActivity.$r8$lambda$lcPlDW4d9sRYixRYmAMZLaWWYnA(PrivacySettingActivity.this, view);
            }
        });
        getPresenter().MyBillsEntityDataFactory();
    }

    private static void b(int i, int i2, byte b, short s, int i3, Object[] objArr) {
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
                i4 = (byte) (((byte) (GetContactSyncConfig[i3 + ((int) (scheduleImpl ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (lookAheadTest ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (DatabaseTableConfigUtil[i3 + ((int) (scheduleImpl ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (lookAheadTest ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (scheduleImpl ^ 3097486228508854431L)) + i5;
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
