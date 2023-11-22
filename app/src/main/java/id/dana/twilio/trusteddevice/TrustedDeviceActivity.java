package id.dana.twilio.trusteddevice;

import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.view.ComponentActivity;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.iap.android.common.utils.NetworkUtils;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.challenge.ChallengeControl;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.di.component.ApplicationComponent;
import id.dana.dialog.DialogWithImage;
import id.dana.domain.usereducation.BottomSheetOnBoardingScenario;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import id.dana.twilio.onboarding.TwilioIntroductionActivity;
import id.dana.twilio.trusteddevice.DaggerTrustedDeviceComponent;
import id.dana.twilio.trusteddevice.TrustedDeviceBottomSheetHelpActivity;
import id.dana.twilio.trusteddevice.TrustedDeviceContract;
import id.dana.usereducation.model.ContentOnBoardingModel;
import id.dana.usereducation.model.OnBoardingModel;
import id.dana.utils.CustomToastUtil;
import id.dana.utils.PhoneCall;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b3\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0005\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR$\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102"}, d2 = {"Lid/dana/twilio/trusteddevice/TrustedDeviceActivity;", "Lid/dana/base/BaseActivity;", "", "p0", "", "MyBillsEntityDataFactory", "(I)V", "", "getAuthRequestContext", "()Ljava/lang/String;", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "()V", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/view/View;", "view", "onClickRightMenuButton", "(Landroid/view/View;)V", "(Ljava/lang/String;)V", "Lid/dana/challenge/ChallengeControl;", "getErrorConfigVersion", "Lid/dana/challenge/ChallengeControl;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/afollestad/materialdialogs/MaterialDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lcom/afollestad/materialdialogs/MaterialDialog;", "PlaceComponentResult", "Ljava/util/ArrayList;", "Lid/dana/usereducation/model/ContentOnBoardingModel;", "Lkotlin/collections/ArrayList;", "lookAheadTest", "Ljava/util/ArrayList;", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "scheduleImpl", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "BuiltInFictitiousFunctionClassFactory", "DatabaseTableConfigUtil", "I", "Lid/dana/twilio/trusteddevice/TrustedDeviceContract$Presenter;", "trustedDevicePresenter", "Lid/dana/twilio/trusteddevice/TrustedDeviceContract$Presenter;", "getTrustedDevicePresenter", "()Lid/dana/twilio/trusteddevice/TrustedDeviceContract$Presenter;", "setTrustedDevicePresenter", "(Lid/dana/twilio/trusteddevice/TrustedDeviceContract$Presenter;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TrustedDeviceActivity extends BaseActivity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda1;
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private MaterialDialog PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private ChallengeControl KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final ActivityPermissionRequest BuiltInFictitiousFunctionClassFactory;
    @Inject
    public TrustedDeviceContract.Presenter trustedDevicePresenter;
    public static final byte[] $$a = {117, -10, 119, -11, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = WSContextConstant.HANDSHAKE_SEND_SIZE;
    public static final byte[] getAuthRequestContext = {TarHeader.LF_CHR, -70, 75, 72, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 35;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final ArrayList<ContentOnBoardingModel> getAuthRequestContext = new ArrayList<>();

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        NetworkUserEntityData$$ExternalSyntheticLambda1 = (char) 42066;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = new char[]{37344, 37281, 37280, 37275, 37373, 37283, 37345, 37369, 37310, 37289, 37353, 37291, 37287, 37346, 37294, 37306, 37365, 37290, 37302, 37311, 37367, 37370, 37262, 37292, 37286, 37372, 37358, 37282, 37274, 37357, 37352, 37371, 37355, 37354, 37347, 37374, 37368, 37305, 37356, 37269, 37293, 37366, 37308, 37288, 37375, 37359, 37309, 37307, 37279};
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = 55 - r8
            int r6 = r6 + 16
            int r7 = 106 - r7
            byte[] r0 = id.dana.twilio.trusteddevice.TrustedDeviceActivity.getAuthRequestContext
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L13
            r4 = r7
            r3 = 0
            r7 = r6
            goto L2a
        L13:
            r3 = 0
        L14:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            int r3 = r3 + 1
            r4 = r0[r8]
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.twilio.trusteddevice.TrustedDeviceActivity.a(short, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = r6 + 21
            byte[] r0 = id.dana.twilio.trusteddevice.TrustedDeviceActivity.$$a
            int r7 = r7 * 2
            int r7 = 103 - r7
            int r8 = r8 + 4
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L35
        L19:
            r3 = 0
        L1a:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L35:
            int r8 = r8 + r7
            int r7 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.twilio.trusteddevice.TrustedDeviceActivity.c(int, byte, int, java.lang.Object[]):void");
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
        b((byte) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 79), new char[]{15, 0, 18, 4, 3, 23, '\r', 4, 0, ',', '\r', 6, ',', 4, 24, 16, 13881, 13881}, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 17, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b((byte) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 34), new char[]{25, 20, 31, 21, 13856}, 5 - Drawable.resolveOpacity(0, 0), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b((byte) (117 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), new char[]{'%', 22, '\r', 14, '.', '\t', '0', 27, Typography.amp, 15, 30, 16, 18, 3, '*', 14, 13856, 13856, 14, 21, '\t', 25, 21, '\t', 18, InputCardNumberView.DIVIDER, 18, '\r', 11, 18, 15, 18, '#', '\r', 6, '\'', '\r', '%', 16, '0', '%', '\b', 28, '\n', '\'', JSONLexer.EOI, '\n', 14}, View.MeasureSpec.makeMeasureSpec(0, 0) + 48, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b((byte) (ExpandableListView.getPackedPositionType(0L) + 88), new char[]{21, 28, '\b', '\f', '\r', '%', '0', 16, '\t', 25, '#', 27, 7, '\'', Typography.amp, 28, 13824, 13824, 7, '%', 7, '\'', 11, 21, '\f', '#', Typography.amp, 20, 18, '\r', 13824, 13824, 25, '\t', Typography.quote, 17, 13905, 13905, '.', 23, 23, '*', 14, Typography.amp, 22, '%', Typography.dollar, '%', 13825, 13825, '%', '#', '#', '%', '*', '%', '*', '%', JSONLexer.EOI, '%', ')', 14, 18, InputCardNumberView.DIVIDER}, 64 - Color.red(0), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b((byte) (23 - Color.green(0)), new char[]{0, '\'', 19, Typography.amp, '#', '%', 3, InputCardNumberView.DIVIDER, 13753, 13753, 14, ')', '\'', 21, '+', '%', 15, 18, InputCardNumberView.DIVIDER, '\n', 5, '\'', 18, 21, '%', '\b', '0', 27, 13843, 13843, '%', 22, '\'', '\b', 6, 18, ')', '%', '\r', 14, 16, '\r', Typography.amp, 28, 16, '0', 19, '#', '\r', '%', 24, 16, 0, '\'', 7, 23, '#', 22, '#', '\r', 7, 23, 27, '#'}, 63 - ((byte) KeyEvent.getModifierMetaStateMask()), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b((byte) (86 - ImageFormat.getBitsPerPixel(0)), new char[]{19, 5, 5, JSONLexer.EOI, ',', 14, 13836, 13836, 7, 18, 0, 15, 5, '0', 11, '/', 18, 15, ',', JSONLexer.EOI, 21, 0, '0', 5, 1, 22, 18, '*', 7, '.', 15, 22, 18, '*', 20, 3, 30, '\t', 21, 6, 15, 20, 21, 3, 22, 3, '-', 15, '+', '0', 2, '#', 5, 1, 16, Typography.amp, 15, 3, '0', '+'}, 61 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b((byte) (76 - TextUtils.indexOf("", "", 0)), new char[]{'0', '\r', Typography.quote, 3, 0, '\''}, 6 - Color.red(0), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, View.MeasureSpec.getSize(0) + 18, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = getAuthRequestContext[25];
                Object[] objArr13 = new Object[1];
                a(b, b, (byte) (-getAuthRequestContext[31]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(getAuthRequestContext[25], getAuthRequestContext[9], (byte) (PlaceComponentResult - 5), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - TextUtils.indexOf("", ""), Gravity.getAbsoluteGravity(0, 0) + 3, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1));
                        Object[] objArr16 = new Object[1];
                        c($$a[78], $$a[12], $$a[47], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getEdgeSlop() >> 16), 14 - TextUtils.lastIndexOf("", '0', 0), (char) KeyEvent.normalizeMetaState(0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.getCapsMode("", 0, 0), 14 - MotionEvent.axisFromString(""), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 815, 29 - View.resolveSize(0, 0), (char) ((KeyEvent.getMaxKeyCode() >> 16) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + 800, TextUtils.lastIndexOf("", '0') + 16, (char) (ViewConfiguration.getFadingEdgeLength() >> 16)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r8 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), View.resolveSizeAndState(0, 0, 0) + 35, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-954764220, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.normalizeMetaState(0), 17 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b2 = getAuthRequestContext[25];
                Object[] objArr19 = new Object[1];
                a(b2, b2, (byte) (-getAuthRequestContext[31]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                a(getAuthRequestContext[25], getAuthRequestContext[9], (byte) (PlaceComponentResult - 5), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 61, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 47, (char) (ViewConfiguration.getTapTimeout() >> 16));
                        byte b3 = (byte) ($$a[78] - 1);
                        Object[] objArr22 = new Object[1];
                        c(b3, b3, $$a[28], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0), 35 - Gravity.getAbsoluteGravity(0, 0), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-954764220, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0'), 19 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = getAuthRequestContext[25];
                Object[] objArr25 = new Object[1];
                a(b4, b4, (byte) (-getAuthRequestContext[31]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                a(getAuthRequestContext[25], getAuthRequestContext[9], (byte) (PlaceComponentResult - 5), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 118, (ViewConfiguration.getEdgeSlop() >> 16) + 3, (char) (38969 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))));
                        byte b5 = (byte) ($$a[78] - 1);
                        Object[] objArr28 = new Object[1];
                        c(b5, b5, $$a[28], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getLongPressTimeout() >> 16), 35 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-954764220, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getCapsMode("", 0, 0), 18 - View.MeasureSpec.getSize(0), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b6 = getAuthRequestContext[25];
                Object[] objArr31 = new Object[1];
                a(b6, b6, (byte) (-getAuthRequestContext[31]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                a(getAuthRequestContext[25], getAuthRequestContext[9], (byte) (PlaceComponentResult - 5), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), TextUtils.lastIndexOf("", '0', 0) + 4, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1));
                        Object[] objArr34 = new Object[1];
                        c($$a[8], $$a[9], (byte) (-$$a[40]), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-954764220, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), View.resolveSizeAndState(0, 0, 0) + 18, (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return R.layout.activity_trusted_device;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr = new Object[1];
        b((byte) (getPackageName().length() + 73), new char[]{15, 0, 18, 4, 3, 23, '\r', 4, 0, ',', '\r', 6, ',', 4, 24, 16, 13881, 13881}, 18 - ((Process.getThreadPriority(0) + 20) >> 6), objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        byte lastIndexOf = (byte) (TextUtils.lastIndexOf("", '0') + 35);
        char[] cArr = {25, 20, 31, 21, 13856};
        try {
            Object[] objArr2 = new Object[1];
            a(getAuthRequestContext[30], (byte) (-getAuthRequestContext[32]), (byte) (getAuthRequestContext[49] - 1), objArr2);
            Class<?> cls2 = Class.forName((String) objArr2[0]);
            a(getAuthRequestContext[8], getAuthRequestContext[48], getAuthRequestContext[25], new Object[1]);
            Object[] objArr3 = new Object[1];
            b(lastIndexOf, cArr, ((ApplicationInfo) cls2.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 28, objArr3);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr4 = new Object[1];
                    b((byte) (Color.argb(0, 0, 0, 0) + 102), new char[]{15, 0, 18, 4, 3, 23, '\r', 4, 15, 20, 20, 5, 23, 24, '-', JSONLexer.EOI, Typography.amp, 23, '.', 19, 5, '\n', '-', 18, 18, 7}, super.getResources().getString(R.string.add_new_bills_first_onboarding_description).substring(11, 12).length() + 25, objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    b((byte) (ExpandableListView.getPackedPositionChild(0L) + 14), new char[]{22, 16, 13813, 13813, 15, 3, '+', JSONLexer.EOI, 13815, 13815, 3, JSONLexer.EOI, 21, 16, '-', JSONLexer.EOI, 3, 2}, (ViewConfiguration.getWindowTouchSlop() >> 8) + 18, objArr5);
                    baseContext = (Context) cls3.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 36 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr6 = new Object[1];
                        b((byte) (getPackageName().codePointAt(4) + 20), new char[]{'%', 22, '\r', 14, '.', '\t', '0', 27, Typography.amp, 15, 30, 16, 18, 3, '*', 14, 13856, 13856, 14, 21, '\t', 25, 21, '\t', 18, InputCardNumberView.DIVIDER, 18, '\r', 11, 18, 15, 18, '#', '\r', 6, '\'', '\r', '%', 16, '0', '%', '\b', 28, '\n', '\'', JSONLexer.EOI, '\n', 14}, View.resolveSizeAndState(0, 0, 0) + 48, objArr6);
                        String str = (String) objArr6[0];
                        byte codePointAt = (byte) (super.getResources().getString(R.string.incorrect_expiry_date).substring(6, 7).codePointAt(0) - 13);
                        char[] cArr2 = {21, 28, '\b', '\f', '\r', '%', '0', 16, '\t', 25, '#', 27, 7, '\'', Typography.amp, 28, 13824, 13824, 7, '%', 7, '\'', 11, 21, '\f', '#', Typography.amp, 20, 18, '\r', 13824, 13824, 25, '\t', Typography.quote, 17, 13905, 13905, '.', 23, 23, '*', 14, Typography.amp, 22, '%', Typography.dollar, '%', 13825, 13825, '%', '#', '#', '%', '*', '%', '*', '%', JSONLexer.EOI, '%', ')', 14, 18, InputCardNumberView.DIVIDER};
                        try {
                            Object[] objArr7 = new Object[1];
                            a(getAuthRequestContext[30], (byte) (-getAuthRequestContext[32]), (byte) (getAuthRequestContext[49] - 1), objArr7);
                            Class<?> cls4 = Class.forName((String) objArr7[0]);
                            Object[] objArr8 = new Object[1];
                            a(getAuthRequestContext[8], getAuthRequestContext[48], getAuthRequestContext[25], objArr8);
                            Object[] objArr9 = new Object[1];
                            b(codePointAt, cArr2, ((ApplicationInfo) cls4.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 31, objArr9);
                            String str2 = (String) objArr9[0];
                            try {
                                Object[] objArr10 = new Object[1];
                                a(getAuthRequestContext[30], (byte) (-getAuthRequestContext[32]), (byte) (getAuthRequestContext[49] - 1), objArr10);
                                Class<?> cls5 = Class.forName((String) objArr10[0]);
                                a(getAuthRequestContext[8], getAuthRequestContext[48], getAuthRequestContext[25], new Object[1]);
                                Object[] objArr11 = new Object[1];
                                b((byte) (((ApplicationInfo) cls5.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 10), new char[]{0, '\'', 19, Typography.amp, '#', '%', 3, InputCardNumberView.DIVIDER, 13753, 13753, 14, ')', '\'', 21, '+', '%', 15, 18, InputCardNumberView.DIVIDER, '\n', 5, '\'', 18, 21, '%', '\b', '0', 27, 13843, 13843, '%', 22, '\'', '\b', 6, 18, ')', '%', '\r', 14, 16, '\r', Typography.amp, 28, 16, '0', 19, '#', '\r', '%', 24, 16, 0, '\'', 7, 23, '#', 22, '#', '\r', 7, 23, 27, '#'}, 64 - (Process.myPid() >> 22), objArr11);
                                String str3 = (String) objArr11[0];
                                Object[] objArr12 = new Object[1];
                                b((byte) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 87), new char[]{19, 5, 5, JSONLexer.EOI, ',', 14, 13836, 13836, 7, 18, 0, 15, 5, '0', 11, '/', 18, 15, ',', JSONLexer.EOI, 21, 0, '0', 5, 1, 22, 18, '*', 7, '.', 15, 22, 18, '*', 20, 3, 30, '\t', 21, 6, 15, 20, 21, 3, 22, 3, '-', 15, '+', '0', 2, '#', 5, 1, 16, Typography.amp, 15, 3, '0', '+'}, 'l' - AndroidCharacter.getMirror('0'), objArr12);
                                String str4 = (String) objArr12[0];
                                Object[] objArr13 = new Object[1];
                                b((byte) (76 - Drawable.resolveOpacity(0, 0)), new char[]{'0', '\r', Typography.quote, 3, 0, '\''}, getPackageName().codePointAt(1) - 94, objArr13);
                                try {
                                    Object[] objArr14 = {baseContext, str, str2, str3, str4, true, (String) objArr13[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), Color.blue(0) + 18, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr14);
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
                }
            }
            try {
                byte b = getAuthRequestContext[25];
                Object[] objArr15 = new Object[1];
                a(b, b, (byte) (-getAuthRequestContext[31]), objArr15);
                Class<?> cls6 = Class.forName((String) objArr15[0]);
                Object[] objArr16 = new Object[1];
                a(getAuthRequestContext[25], getAuthRequestContext[9], (byte) (PlaceComponentResult - 5), objArr16);
                try {
                    Object[] objArr17 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - Color.argb(0, 0, 0, 0), 4 - TextUtils.getTrimmedLength(""), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1));
                        Object[] objArr18 = new Object[1];
                        c($$a[8], $$a[9], (byte) (-$$a[40]), objArr18);
                        obj3 = cls7.getMethod((String) objArr18[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr19 = (Object[]) ((Method) obj3).invoke(null, objArr17);
                    int i = ((int[]) objArr19[1])[0];
                    if (((int[]) objArr19[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf((CharSequence) "", '0') + 36, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(null, null);
                            try {
                                Object[] objArr20 = {393966485, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 911, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 18, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr20);
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
                    super.onCreate(bundle);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                a(getAuthRequestContext[30], (byte) (-getAuthRequestContext[32]), (byte) (getAuthRequestContext[49] - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a(getAuthRequestContext[8], getAuthRequestContext[48], getAuthRequestContext[25], objArr2);
                byte b = (byte) (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 69);
                char[] cArr = {15, 0, 18, 4, 3, 23, '\r', 4, 15, 20, 20, 5, 23, 24, '-', JSONLexer.EOI, Typography.amp, 23, '.', 19, 5, '\n', '-', 18, 18, 7};
                try {
                    Object[] objArr3 = new Object[1];
                    a(getAuthRequestContext[30], (byte) (-getAuthRequestContext[32]), (byte) (getAuthRequestContext[49] - 1), objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    a(getAuthRequestContext[8], getAuthRequestContext[48], getAuthRequestContext[25], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    b(b, cArr, ((ApplicationInfo) cls2.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 7, objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    b((byte) (14 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), new char[]{22, 16, 13813, 13813, 15, 3, '+', JSONLexer.EOI, 13815, 13815, 3, JSONLexer.EOI, 21, 16, '-', JSONLexer.EOI, 3, 2}, super.getResources().getString(R.string.create_profile_title).substring(17, 18).codePointAt(0) - 79, objArr5);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 35 - Gravity.getAbsoluteGravity(0, 0), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr6 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 911, 18 - TextUtils.getCapsMode("", 0, 0), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            byte codePointAt = (byte) (super.getResources().getString(R.string.balance).substring(1, 3).codePointAt(1) - 6);
            char[] cArr = {15, 0, 18, 4, 3, 23, '\r', 4, 15, 20, 20, 5, 23, 24, '-', JSONLexer.EOI, Typography.amp, 23, '.', 19, 5, '\n', '-', 18, 18, 7};
            try {
                Object[] objArr = new Object[1];
                a(getAuthRequestContext[30], (byte) (-getAuthRequestContext[32]), (byte) (getAuthRequestContext[49] - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(getAuthRequestContext[8], getAuthRequestContext[48], getAuthRequestContext[25], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(codePointAt, cArr, ((ApplicationInfo) cls.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 7, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b((byte) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 13), new char[]{22, 16, 13813, 13813, 15, 3, '+', JSONLexer.EOI, 13815, 13815, 3, JSONLexer.EOI, 21, 16, '-', JSONLexer.EOI, 3, 2}, getPackageName().codePointAt(3) - 82, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf((CharSequence) "", '0') + 36, (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetBefore("", 0), 18 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    public TrustedDeviceActivity() {
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = {"android.permission.CALL_PHONE"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.twilio.trusteddevice.TrustedDeviceActivity$phonePermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    PhoneCall.KClassImpl$Data$declaredNonStaticMembers$2(TrustedDeviceActivity.this, "1500445", true);
                }
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.BuiltInFictitiousFunctionClassFactory = builder.PlaceComponentResult();
    }

    @JvmName(name = "getTrustedDevicePresenter")
    public final TrustedDeviceContract.Presenter getTrustedDevicePresenter() {
        TrustedDeviceContract.Presenter presenter = this.trustedDevicePresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setTrustedDevicePresenter")
    public final void setTrustedDevicePresenter(TrustedDeviceContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.trustedDevicePresenter = presenter;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        ChallengeControl challengeControl = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (challengeControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            challengeControl = null;
        }
        if (challengeControl.MyBillsEntityDataFactory(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // id.dana.base.BaseActivity
    public final void onClickRightMenuButton(View view) {
        super.onClickRightMenuButton(view);
        if (this.MyBillsEntityDataFactory != 1) {
            TrustedDeviceBottomSheetHelpActivity.Companion companion = TrustedDeviceBottomSheetHelpActivity.INSTANCE;
            String string = getString(R.string.trusted_device_bottomsheet_title);
            Intrinsics.checkNotNullExpressionValue(string, "");
            startActivity(TrustedDeviceBottomSheetHelpActivity.Companion.getAuthRequestContext(this, new OnBoardingModel(string, "list", this.getAuthRequestContext, BottomSheetOnBoardingScenario.TRUSTED_DEVICE, null, null, null, 112, null)));
            return;
        }
        String string2 = getString(R.string.twilio_waiting_check_message);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        CustomToastUtil.PlaceComponentResult(this, R.drawable.ic_icon_glyph_warning_filled, R.drawable.bg_custom_snackbar, string2, 48, 60, false, null, 384);
    }

    private static String getAuthRequestContext() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(Build.MODEL);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory(int p0) {
        this.MyBillsEntityDataFactory = p0;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_check_your_device);
        if (danaButtonPrimaryView != null) {
            int i = this.MyBillsEntityDataFactory;
            if (i == 0) {
                danaButtonPrimaryView.setEnabled(true);
                danaButtonPrimaryView.setActiveButton(getString(R.string.twilio_button_check), null);
            } else if (i == 1) {
                danaButtonPrimaryView.setEnabled(true);
                danaButtonPrimaryView.setDisabled(getString(R.string.twilio_button_loading));
            } else if (i == 2) {
                danaButtonPrimaryView.setDisabled(getString(R.string.twilio_button_check));
                danaButtonPrimaryView.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void MyBillsEntityDataFactory$default(TrustedDeviceActivity trustedDeviceActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        trustedDeviceActivity.MyBillsEntityDataFactory(str);
    }

    private final void MyBillsEntityDataFactory(String p0) {
        String string = getString(R.string.twilio_enroll_failed_message);
        Intrinsics.checkNotNullExpressionValue(string, "");
        CustomToastUtil.PlaceComponentResult(this, R.drawable.res_0x7f08065e_networkuserentitydata_externalsyntheticlambda1, R.drawable.bg_rounded_toast_failed, p0 == null ? string : p0, 48, 60, false, null, 384);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/twilio/trusteddevice/TrustedDeviceActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "(Landroid/content/Context;)Landroid/content/Intent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Intent MyBillsEntityDataFactory(Context context) {
            Intrinsics.checkNotNullParameter(context, "");
            Intent intent = new Intent(context, TrustedDeviceActivity.class);
            intent.putExtra("success", true);
            return intent;
        }
    }

    /* renamed from: $r8$lambda$7PLC_a9CQw4GXaqGyfUlGtlqR-E  reason: not valid java name */
    public static /* synthetic */ void m2992$r8$lambda$7PLC_a9CQw4GXaqGyfUlGtlqRE(TrustedDeviceActivity trustedDeviceActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(trustedDeviceActivity, "");
        Intrinsics.checkNotNullParameter(dialogInterface, "");
        if (i != -2) {
            if (i != -1) {
                return;
            }
            trustedDeviceActivity.BuiltInFictitiousFunctionClassFactory.check();
        }
        dialogInterface.dismiss();
    }

    public static /* synthetic */ void $r8$lambda$9s1RITo95eUe343JISxi8UUypd8(TrustedDeviceActivity trustedDeviceActivity, View view) {
        Intrinsics.checkNotNullParameter(trustedDeviceActivity, "");
        int i = trustedDeviceActivity.MyBillsEntityDataFactory;
        if (i == 0) {
            if (NetworkUtils.isNetworkAvailable(trustedDeviceActivity)) {
                trustedDeviceActivity.getTrustedDevicePresenter().getAuthRequestContext();
            } else {
                trustedDeviceActivity.MyBillsEntityDataFactory(trustedDeviceActivity.getString(R.string.no_internet_connection_message));
            }
        } else if (i == 1) {
            String string = trustedDeviceActivity.getString(R.string.twilio_waiting_check_message);
            Intrinsics.checkNotNullExpressionValue(string, "");
            CustomToastUtil.PlaceComponentResult(trustedDeviceActivity, R.drawable.ic_icon_glyph_warning_filled, R.drawable.bg_custom_snackbar, string, 48, 60, false, null, 384);
        }
    }

    public static /* synthetic */ void $r8$lambda$UV5PysflGPbVdB9qe1x1Bdn1n3Q(final TrustedDeviceActivity trustedDeviceActivity, View view) {
        Intrinsics.checkNotNullParameter(trustedDeviceActivity, "");
        if (trustedDeviceActivity.MyBillsEntityDataFactory != 1) {
            CustomDialog.Builder builder = new CustomDialog.Builder(trustedDeviceActivity);
            builder.SubSequence = trustedDeviceActivity.getString(R.string.twilio_remove_device_dialog_title);
            builder.GetContactSyncConfig = trustedDeviceActivity.getString(R.string.twilio_remove_device_dialog_description);
            MaterialDialog BuiltInFictitiousFunctionClassFactory = builder.PlaceComponentResult(false).KClassImpl$Data$declaredNonStaticMembers$2(false).KClassImpl$Data$declaredNonStaticMembers$2(trustedDeviceActivity.getString(R.string.option_cancel), new Function1<View, Unit>() { // from class: id.dana.twilio.trusteddevice.TrustedDeviceActivity$openRemoveDialog$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view2) {
                    invoke2(view2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view2) {
                    MaterialDialog materialDialog;
                    Intrinsics.checkNotNullParameter(view2, "");
                    materialDialog = TrustedDeviceActivity.this.PlaceComponentResult;
                    if (materialDialog == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        materialDialog = null;
                    }
                    materialDialog.dismiss();
                }
            }).BuiltInFictitiousFunctionClassFactory(trustedDeviceActivity.getString(R.string.option_remove), new Function1<View, Unit>() { // from class: id.dana.twilio.trusteddevice.TrustedDeviceActivity$openRemoveDialog$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view2) {
                    invoke2(view2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view2) {
                    Intrinsics.checkNotNullParameter(view2, "");
                    TrustedDeviceActivity.this.getTrustedDevicePresenter().MyBillsEntityDataFactory(TwilioIntroductionActivity.SETTING_PAGE);
                }
            }).BuiltInFictitiousFunctionClassFactory();
            trustedDeviceActivity.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
            if (BuiltInFictitiousFunctionClassFactory == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                BuiltInFictitiousFunctionClassFactory = null;
            }
            BuiltInFictitiousFunctionClassFactory.show();
            return;
        }
        String string = trustedDeviceActivity.getString(R.string.twilio_waiting_check_message);
        Intrinsics.checkNotNullExpressionValue(string, "");
        CustomToastUtil.PlaceComponentResult(trustedDeviceActivity, R.drawable.ic_icon_glyph_warning_filled, R.drawable.bg_custom_snackbar, string, 48, 60, false, null, 384);
    }

    public static /* synthetic */ void $r8$lambda$f_GZ9vuPFKpTBIDmDJpMVxo7Yxk(TrustedDeviceActivity trustedDeviceActivity, View view) {
        Intrinsics.checkNotNullParameter(trustedDeviceActivity, "");
        if (trustedDeviceActivity.MyBillsEntityDataFactory != 1) {
            trustedDeviceActivity.onBackPressed();
            return;
        }
        String string = trustedDeviceActivity.getString(R.string.twilio_waiting_check_message);
        Intrinsics.checkNotNullExpressionValue(string, "");
        CustomToastUtil.PlaceComponentResult(trustedDeviceActivity, R.drawable.ic_icon_glyph_warning_filled, R.drawable.bg_custom_snackbar, string, 48, 60, false, null, 384);
    }

    public static final /* synthetic */ void access$challengeCanceled(final TrustedDeviceActivity trustedDeviceActivity, String str, Bundle bundle, String str2) {
        if (Intrinsics.areEqual(str, "twilio_otp")) {
            if ((bundle != null ? bundle.getString("message") : null) != null) {
                String string = bundle.getString("message");
                if (string == null) {
                    string = "";
                }
                trustedDeviceActivity.showWarningDialog(string);
            }
        } else if (str2 != null) {
            int hashCode = str2.hashCode();
            if (hashCode == -305104263) {
                if (str2.equals("forgot_pin")) {
                    trustedDeviceActivity.BuiltInFictitiousFunctionClassFactory.check();
                }
            } else if (hashCode == -109866462) {
                if (str2.equals(ChallengeControl.CancelReason.PIN_TEMPORARY_LOCKED)) {
                    DialogWithImage.BuiltInFictitiousFunctionClassFactory(trustedDeviceActivity, new DialogInterface.OnClickListener() { // from class: id.dana.twilio.trusteddevice.TrustedDeviceActivity$$ExternalSyntheticLambda3
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            TrustedDeviceActivity.m2992$r8$lambda$7PLC_a9CQw4GXaqGyfUlGtlqRE(TrustedDeviceActivity.this, dialogInterface, i);
                        }
                    }).MyBillsEntityDataFactory();
                }
            } else if (hashCode == 462997423 && str2.equals(ChallengeControl.CancelReason.SESSION_EXPIRED)) {
                trustedDeviceActivity.showWarningDialog(trustedDeviceActivity.getString(R.string.session_expired));
            }
        }
    }

    public static final /* synthetic */ void access$initChallengeControl(final TrustedDeviceActivity trustedDeviceActivity, String str, String str2, String str3) {
        ChallengeControl.Builder builder = new ChallengeControl.Builder(trustedDeviceActivity);
        if (str == null) {
            str = "";
        }
        builder.scheduleImpl = str;
        if (str2 == null) {
            str2 = "";
        }
        builder.E = str2;
        if (str3 == null) {
            str3 = "";
        }
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = str3;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda5 = new ChallengeControl.Listener() { // from class: id.dana.twilio.trusteddevice.TrustedDeviceActivity$initChallengeControl$1
            @Override // id.dana.challenge.ChallengeControl.Listener
            public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1, Bundle p2) {
                TrustedDeviceActivity.access$challengeCanceled(TrustedDeviceActivity.this, p0, p2, p1);
            }

            @Override // id.dana.challenge.ChallengeControl.Listener
            public final void getAuthRequestContext() {
                TrustedDeviceActivity.this.getTrustedDevicePresenter().MyBillsEntityDataFactory();
            }
        };
        ChallengeControl challengeControl = new ChallengeControl(builder, null);
        trustedDeviceActivity.KClassImpl$Data$declaredNonStaticMembers$2 = challengeControl;
        challengeControl.getAuthRequestContext();
    }

    public static final /* synthetic */ void access$setConnectedAccountText(TrustedDeviceActivity trustedDeviceActivity, String str) {
        TextView textView = (TextView) trustedDeviceActivity._$_findCachedViewById(R.id.tv_connected_account);
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText(trustedDeviceActivity.getString(R.string.connected_account, str));
        }
    }

    public static final /* synthetic */ void access$setConnectedAccountTextForNonKyc(TrustedDeviceActivity trustedDeviceActivity) {
        TextView textView = (TextView) trustedDeviceActivity._$_findCachedViewById(R.id.tv_connected_account);
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText(getAuthRequestContext());
        }
    }

    public static final /* synthetic */ void access$setDeviceModelText(TrustedDeviceActivity trustedDeviceActivity) {
        TextView textView = (TextView) trustedDeviceActivity._$_findCachedViewById(R.id.tv_device_model);
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText(getAuthRequestContext());
        }
    }

    public static final /* synthetic */ void access$showTrustedYourDeviceEntryPoint(TrustedDeviceActivity trustedDeviceActivity, boolean z) {
        if (z) {
            TextView textView = (TextView) trustedDeviceActivity._$_findCachedViewById(R.id.tv_trusted_device_verification);
            if (textView != null) {
                textView.setVisibility(0);
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) trustedDeviceActivity._$_findCachedViewById(R.id.cl_verify_your_device);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        DaggerTrustedDeviceComponent.Builder MyBillsEntityDataFactory = DaggerTrustedDeviceComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (TrustedDeviceModule) Preconditions.getAuthRequestContext(new TrustedDeviceModule(new TrustedDeviceContract.View() { // from class: id.dana.twilio.trusteddevice.TrustedDeviceActivity$initComponent$1
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

            @Override // id.dana.twilio.trusteddevice.TrustedDeviceContract.View
            public final void getAuthRequestContext(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                TrustedDeviceActivity.access$setConnectedAccountText(TrustedDeviceActivity.this, p0);
                TrustedDeviceActivity.access$setDeviceModelText(TrustedDeviceActivity.this);
            }

            @Override // id.dana.twilio.trusteddevice.TrustedDeviceContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                TrustedDeviceActivity.access$setConnectedAccountTextForNonKyc(TrustedDeviceActivity.this);
            }

            @Override // id.dana.twilio.trusteddevice.TrustedDeviceContract.View
            public final void MyBillsEntityDataFactory(boolean p0) {
                TrustedDeviceActivity.access$showTrustedYourDeviceEntryPoint(TrustedDeviceActivity.this, p0);
            }

            @Override // id.dana.twilio.trusteddevice.TrustedDeviceContract.View
            public final void PlaceComponentResult() {
                TwilioIntroductionActivity.Companion companion = TwilioIntroductionActivity.Companion;
                Context applicationContext = TrustedDeviceActivity.this.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "");
                TrustedDeviceActivity.this.startActivity(TwilioIntroductionActivity.Companion.getAuthRequestContext(applicationContext, TwilioIntroductionActivity.TRUSTED_DEVICE_PAGE, ""));
                TrustedDeviceActivity.this.finish();
            }

            @Override // id.dana.twilio.trusteddevice.TrustedDeviceContract.View
            public final void MyBillsEntityDataFactory() {
                TrustedDeviceActivity.MyBillsEntityDataFactory$default(TrustedDeviceActivity.this, null, 1, null);
            }

            @Override // id.dana.twilio.trusteddevice.TrustedDeviceContract.View
            public final void MyBillsEntityDataFactory(String p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Boolean valueOf = p1 != null ? Boolean.valueOf(StringsKt.equals(p1, "OTP_SMS", true)) : null;
                Intrinsics.checkNotNull(valueOf);
                if (valueOf.booleanValue()) {
                    TrustedDeviceActivity.access$initChallengeControl(TrustedDeviceActivity.this, "twilio_otp", p0, "twilio_otp");
                } else {
                    TrustedDeviceActivity.access$initChallengeControl(TrustedDeviceActivity.this, "twilio_pin", p0, "twilio_pin");
                }
            }

            @Override // id.dana.twilio.trusteddevice.TrustedDeviceContract.View
            public final void getAuthRequestContext() {
                TrustedDeviceActivity.this.MyBillsEntityDataFactory(1);
            }

            @Override // id.dana.twilio.trusteddevice.TrustedDeviceContract.View
            public final void getAuthRequestContext(boolean p0) {
                if (p0) {
                    TrustedDeviceActivity.this.MyBillsEntityDataFactory(2);
                    return;
                }
                TrustedDeviceActivity.this.MyBillsEntityDataFactory(0);
                TrustedDeviceActivity.MyBillsEntityDataFactory$default(TrustedDeviceActivity.this, null, 1, null);
            }

            @Override // id.dana.twilio.trusteddevice.TrustedDeviceContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
                Intent intent = new Intent(TrustedDeviceActivity.this, TwilioIdentityVerificationActivity.class);
                intent.putExtra(TwilioIdentityVerificationActivity.FACTOR_SID, p0);
                intent.putExtra(TwilioIdentityVerificationActivity.CHALLENGE_SID, p1);
                TrustedDeviceActivity.this.startActivity(intent);
            }

            @Override // id.dana.twilio.trusteddevice.TrustedDeviceContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                TrustedDeviceActivity trustedDeviceActivity = TrustedDeviceActivity.this;
                String string = trustedDeviceActivity.getString(R.string.twilio_not_have_pending_challenge_message);
                Intrinsics.checkNotNullExpressionValue(string, "");
                CustomToastUtil.PlaceComponentResult(trustedDeviceActivity, R.drawable.ic_icon_glyph_warning_filled, R.drawable.bg_custom_snackbar, string, 48, 60, false, null, 384);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                TrustedDeviceActivity.MyBillsEntityDataFactory$default(TrustedDeviceActivity.this, null, 1, null);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, TrustedDeviceModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.getAuthRequestContext, ApplicationComponent.class);
        new DaggerTrustedDeviceComponent.TrustedDeviceComponentImpl(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.getAuthRequestContext, (byte) 0).getAuthRequestContext(this);
        registerPresenter(getTrustedDevicePresenter());
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getBoolean("success", false)) {
            CustomToastUtil.PlaceComponentResult(this, R.drawable.success, R.drawable.bg_rounded_toast_success, getString(R.string.twilio_enroll_success_message), 48, 60, false, null, 384);
        }
        setTitle(getString(R.string.trusted_device_title));
        setMenuRightButton(R.drawable.ic_tooltip_help);
        setMenuLeftButton(ContextCompat.PlaceComponentResult(this, (int) R.drawable.arrow_left_white), new View.OnClickListener() { // from class: id.dana.twilio.trusteddevice.TrustedDeviceActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TrustedDeviceActivity.$r8$lambda$f_GZ9vuPFKpTBIDmDJpMVxo7Yxk(TrustedDeviceActivity.this, view);
            }
        });
        ArrayList<ContentOnBoardingModel> arrayList = this.getAuthRequestContext;
        String string = getString(R.string.twilio_intro_1_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = getString(R.string.twilio_intro_1_description);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        arrayList.add(new ContentOnBoardingModel((int) R.drawable.ic_twilio_dialog_icon, string, string2));
        ArrayList<ContentOnBoardingModel> arrayList2 = this.getAuthRequestContext;
        String string3 = getString(R.string.twilio_intro_2_title);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        String string4 = getString(R.string.twilio_intro_2_description);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        arrayList2.add(new ContentOnBoardingModel((int) R.drawable.ic_receive_notification, string3, string4));
        ArrayList<ContentOnBoardingModel> arrayList3 = this.getAuthRequestContext;
        String string5 = getString(R.string.twilio_intro_3_title);
        Intrinsics.checkNotNullExpressionValue(string5, "");
        String string6 = getString(R.string.twilio_intro_3_description);
        Intrinsics.checkNotNullExpressionValue(string6, "");
        arrayList3.add(new ContentOnBoardingModel((int) R.drawable.ic_faster_verification, string5, string6));
        DeviceDetailView deviceDetailView = (DeviceDetailView) _$_findCachedViewById(R.id.res_0x7f0a05b9_flowlivedataconversions_aslivedata_1);
        if (deviceDetailView != null) {
            String string7 = getString(R.string.device_model);
            Intrinsics.checkNotNullExpressionValue(string7, "");
            deviceDetailView.setTitle(string7);
        }
        DeviceDetailView deviceDetailView2 = (DeviceDetailView) _$_findCachedViewById(R.id.res_0x7f0a05bc_falconfacade_falconimagecutproxy);
        if (deviceDetailView2 != null) {
            String string8 = getString(R.string.os_version);
            Intrinsics.checkNotNullExpressionValue(string8, "");
            deviceDetailView2.setTitle(string8);
        }
        DeviceDetailView deviceDetailView3 = (DeviceDetailView) _$_findCachedViewById(R.id.res_0x7f0a05b9_flowlivedataconversions_aslivedata_1);
        if (deviceDetailView3 != null) {
            DeviceDetailView.setSubTitle$default(deviceDetailView3, getAuthRequestContext(), null, 2, null);
        }
        DeviceDetailView deviceDetailView4 = (DeviceDetailView) _$_findCachedViewById(R.id.res_0x7f0a05bc_falconfacade_falconimagecutproxy);
        if (deviceDetailView4 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.title_device_type));
            sb.append(Build.VERSION.RELEASE);
            DeviceDetailView.setSubTitle$default(deviceDetailView4, sb.toString(), null, 2, null);
        }
        getTrustedDevicePresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        getTrustedDevicePresenter().PlaceComponentResult();
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.res_0x7f0a0218_requestmoneyqrcontract_view);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.twilio.trusteddevice.TrustedDeviceActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TrustedDeviceActivity.$r8$lambda$UV5PysflGPbVdB9qe1x1Bdn1n3Q(TrustedDeviceActivity.this, view);
                }
            });
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_check_your_device);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.twilio.trusteddevice.TrustedDeviceActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TrustedDeviceActivity.$r8$lambda$9s1RITo95eUe343JISxi8UUypd8(TrustedDeviceActivity.this, view);
                }
            });
        }
        MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
        DanaApplication danaApplication = getDanaApplication();
        if (danaApplication != null) {
            danaApplication.chckTmprdApp();
        }
    }

    private static void b(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ NetworkUserEntityData$$ExternalSyntheticLambda1);
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
