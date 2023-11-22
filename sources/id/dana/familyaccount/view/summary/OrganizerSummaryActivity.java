package id.dana.familyaccount.view.summary;

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
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.google.android.material.card.MaterialCardView;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.databinding.ActivityOrganizerSummaryBinding;
import id.dana.databinding.LayoutToolbarBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerFamilyAccountOrganizerSummaryComponent;
import id.dana.di.modules.FamilyAccountOrganizerSummaryModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.familyaccount.model.ApproveSendMoneyRequest;
import id.dana.domain.familyaccount.model.ApproveSendMoneyResult;
import id.dana.domain.familyaccount.model.AttributesResult;
import id.dana.domain.familyaccount.model.RejectSendMoneyRequest;
import id.dana.familyaccount.constants.FamilyAccountTransactionType;
import id.dana.familyaccount.constants.StatusInformationType;
import id.dana.familyaccount.contract.OrganizerSummaryContract;
import id.dana.familyaccount.di.FamilyAccountTrackerModule;
import id.dana.familyaccount.model.SummaryModel;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;
import id.dana.familyaccount.view.statusinformation.StatusInformationView;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.pay.PayActivity;
import id.dana.utils.DANAToast;
import id.dana.utils.ShimmeringUtil;
import id.dana.utils.danah5.DanaH5Listener;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import kotlin.jvm.internal.StringCompanionObject;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b:\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000e\u0010\u0005J!\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0015R!\u0010\u001c\u001a\f\u0012\b\u0012\u0006*\u00020\u00180\u00180\u00178\u0007¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0016\u001a\u00020\u001dX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u0010\u0014\u001a\u00020\u00108\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0018\u0010\u0012\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b8\u00109"}, d2 = {"Lid/dana/familyaccount/view/summary/OrganizerSummaryActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityOrganizerSummaryBinding;", "", "configToolbar", "()V", "", "p0", "getAuthRequestContext", "(I)V", "inflateViewBinding", "()Lid/dana/databinding/ActivityOrganizerSummaryBinding;", IAPSyncCommand.COMMAND_INIT, "initComponent", "onDestroy", "", "", "p1", "PlaceComponentResult", "(ZLjava/lang/String;)V", "MyBillsEntityDataFactory", "(Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "Landroidx/activity/result/ActivityResultLauncher;", "getCashierResult", "()Landroidx/activity/result/ActivityResultLauncher;", "cashierResult", "Lid/dana/dialog/DanaLoadingDialog;", "getErrorConfigVersion", "Lkotlin/Lazy;", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "familyAccountAnalyticalTracker", "Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "getFamilyAccountAnalyticalTracker", "()Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "setFamilyAccountAnalyticalTracker", "(Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;)V", "scheduleImpl", "Ljava/lang/String;", "Lid/dana/familyaccount/contract/OrganizerSummaryContract$Presenter;", "presenter", "Lid/dana/familyaccount/contract/OrganizerSummaryContract$Presenter;", "getPresenter", "()Lid/dana/familyaccount/contract/OrganizerSummaryContract$Presenter;", "setPresenter", "(Lid/dana/familyaccount/contract/OrganizerSummaryContract$Presenter;)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "lookAheadTest", "Lcom/ethanhua/skeleton/SkeletonScreen;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OrganizerSummaryActivity extends BaseViewBindingActivity<ActivityOrganizerSummaryBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static char[] GetContactSyncConfig = null;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
    public static final String PAYMENT_RESULT = "PAYMENT_RESULT";
    private static boolean initRecordTimeStamp;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;
    @Inject
    public FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ActivityResultLauncher<Intent> cashierResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private SkeletonScreen PlaceComponentResult;
    @Inject
    public OrganizerSummaryContract.Presenter presenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;
    public static final byte[] $$a = {42, -48, 107, -19, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 188;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {75, -23, 102, -23, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 35;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.familyaccount.view.summary.OrganizerSummaryActivity$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(OrganizerSummaryActivity.this);
        }
    });

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        GetContactSyncConfig = new char[]{39898, 39887, 39897, 39883, 39884, 39890, 39823, 39885, 39930, 39896, 39881, 39879, 39874, 39913, 39893, 39894, 39878, 39889, 39880, 39917, 39886, 39910, 39812, 39815, 39813, 39821, 39810, 39895, 39819, 39818, 39816, 39817, 39899, 39814, 39811, 39820, 39892, 39882};
        NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
        initRecordTimeStamp = true;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = 909155261;
    }

    private static void a(short s, byte b, short s2, Object[] objArr) {
        byte[] bArr = KClassImpl$Data$declaredNonStaticMembers$2;
        int i = s + 97;
        int i2 = s2 + 16;
        int i3 = 56 - b;
        byte[] bArr2 = new byte[i2];
        int i4 = -1;
        int i5 = i2 - 1;
        if (bArr == null) {
            i = (i + i3) - 4;
            i3++;
            i5 = i5;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
        }
        while (true) {
            int i6 = i4 + 1;
            bArr2[i6] = (byte) i;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i = (i + bArr[i3]) - 4;
            i3++;
            i5 = i5;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = i6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002f -> B:23:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.familyaccount.view.summary.OrganizerSummaryActivity.$$a
            int r6 = r6 + 4
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r7 = r7 * 2
            int r7 = 103 - r7
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L37
        L1a:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r5
        L1e:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r7 = r7 + 1
            int r4 = r3 + 1
            if (r3 != r8) goto L2f
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2f:
            r3 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L37:
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.summary.OrganizerSummaryActivity.c(int, int, byte, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final Intent createSendMoneyRequestApprovalIntent(Context context, String str) {
        return Companion.MyBillsEntityDataFactory(context, str);
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
        b(null, AndroidCharacter.getMirror('0') + 'O', new byte[]{-109, -109, -112, -118, -123, -124, -108, -121, -109, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(null, (Process.myTid() >> 22) + 127, new byte[]{-125, -122, -106, -115, -107}, null, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 35, (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(null, 127 - (Process.myTid() >> 22), new byte[]{-112, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -112, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -112, -100, -118, -112, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(null, TextUtils.getOffsetAfter("", 0) + 127, new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -112, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -112, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(null, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 126, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -112, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -112, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -112, -98, -99}, null, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(null, 127 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), new byte[]{-109, -117, -126, -112, -116, -112, -92, -99, -116, -92, -117, -109, -112, -91, -126, -122, -92, -122, -120, -127, -92, -107, -123, -118, -121, -112, -124, -127, -111, -90, -109, -125, -124, -127, -111, -91, -121, -117, -109, -127, -118, -117, -127, -112, -124, -113, -117, -121, -127, -126, -127, -125, -92, -92, -93, -109, -120, -117, -117, -113}, null, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(null, 128 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (KeyEvent.getMaxKeyCode() >> 16), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 17, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a(KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[31], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (PlaceComponentResult >>> 2);
                Object[] objArr14 = new Object[1];
                a(b, (byte) (b | 22), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 56, View.MeasureSpec.makeMeasureSpec(0, 0) + 3, (char) (ViewConfiguration.getEdgeSlop() >> 16));
                        Object[] objArr16 = new Object[1];
                        c($$a[78], (byte) (-$$a[12]), $$a[68], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 15 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - KeyEvent.normalizeMetaState(0), Color.rgb(0, 0, 0) + 16777231, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(816 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 29, (char) (57994 - Color.red(0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 800, 15 - (ViewConfiguration.getScrollBarSize() >> 8), (char) Drawable.resolveOpacity(0, 0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r10 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 35 - View.MeasureSpec.getMode(0), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-2011770736, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[31], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b2 = (byte) (PlaceComponentResult >>> 2);
                Object[] objArr20 = new Object[1];
                a(b2, (byte) (b2 | 22), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 62, Process.getGidForName("") + 47, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16));
                        Object[] objArr22 = new Object[1];
                        c((byte) (-$$a[28]), (byte) ($$a[47] - 1), (byte) (-$$a[8]), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.getCapsMode("", 0, 0), (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-2011770736, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 911, 18 - KeyEvent.normalizeMetaState(0), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[31], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b3 = (byte) (PlaceComponentResult >>> 2);
                Object[] objArr26 = new Object[1];
                a(b3, (byte) (b3 | 22), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - View.combineMeasuredStates(0, 0), 3 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (38967 - TextUtils.lastIndexOf("", '0')));
                        Object[] objArr28 = new Object[1];
                        c((byte) (-$$a[28]), (byte) ($$a[47] - 1), (byte) (-$$a[8]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - KeyEvent.getDeadChar(0, 0), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-2011770736, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (KeyEvent.getMaxKeyCode() >> 16), 18 - Color.red(0), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[31], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b4 = (byte) (PlaceComponentResult >>> 2);
                Object[] objArr32 = new Object[1];
                a(b4, (byte) (b4 | 22), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + 107, Process.getGidForName("") + 4, (char) (Color.rgb(0, 0, 0) + 16777216));
                        Object[] objArr34 = new Object[1];
                        c($$a[0], (byte) (-$$a[9]), (byte) ($$a[47] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getTrimmedLength(""), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 35, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-2011770736, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 910, TextUtils.lastIndexOf("", '0') + 19, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        b(null, getPackageName().codePointAt(4) + 30, new byte[]{-109, -109, -112, -118, -123, -124, -108, -121, -109, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        b(null, super.getResources().getString(R.string.add_new_debit_card).substring(0, 6).length() + 121, new byte[]{-125, -122, -106, -115, -107}, null, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                b(null, (ViewConfiguration.getWindowTouchSlop() >> 8) + 127, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                b(null, 127 - Color.red(0), new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0'), 35 - KeyEvent.normalizeMetaState(0), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        byte b = KClassImpl$Data$declaredNonStaticMembers$2[25];
                        Object[] objArr6 = new Object[1];
                        a(b, (byte) (b | TarHeader.LF_BLK), (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[56], objArr7);
                        Object[] objArr8 = new Object[1];
                        b(null, ((ApplicationInfo) cls3.getMethod((String) objArr7[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-112, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -112, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -112, -100, -118, -112, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr8);
                        String str = (String) objArr8[0];
                        try {
                            byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                            Object[] objArr9 = new Object[1];
                            a(b2, (byte) (b2 | TarHeader.LF_BLK), (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), objArr9);
                            Class<?> cls4 = Class.forName((String) objArr9[0]);
                            Object[] objArr10 = new Object[1];
                            a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[56], objArr10);
                            Object[] objArr11 = new Object[1];
                            b(null, ((ApplicationInfo) cls4.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -112, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -112, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr11);
                            String str2 = (String) objArr11[0];
                            Object[] objArr12 = new Object[1];
                            b(null, 127 - (KeyEvent.getMaxKeyCode() >> 16), new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -112, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -112, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -112, -98, -99}, null, objArr12);
                            String str3 = (String) objArr12[0];
                            Object[] objArr13 = new Object[1];
                            b(null, super.getResources().getString(R.string.family_text_check_status_member_error).substring(48, 49).codePointAt(0) + 19, new byte[]{-109, -117, -126, -112, -116, -112, -92, -99, -116, -92, -117, -109, -112, -91, -126, -122, -92, -122, -120, -127, -92, -107, -123, -118, -121, -112, -124, -127, -111, -90, -109, -125, -124, -127, -111, -91, -121, -117, -109, -127, -118, -117, -127, -112, -124, -113, -117, -121, -127, -126, -127, -125, -92, -92, -93, -109, -120, -117, -117, -113}, null, objArr13);
                            String str4 = (String) objArr13[0];
                            Object[] objArr14 = new Object[1];
                            b(null, super.getResources().getString(R.string.error_select_non_indo_number).substring(10, 11).codePointAt(0) + 95, new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr14);
                            try {
                                Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + 911, TextUtils.lastIndexOf("", '0', 0, 0) + 19, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            Object[] objArr16 = new Object[1];
            a(KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[31], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr16);
            Class<?> cls5 = Class.forName((String) objArr16[0]);
            byte b3 = (byte) (PlaceComponentResult >>> 2);
            Object[] objArr17 = new Object[1];
            a(b3, (byte) (b3 | 22), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr17);
            try {
                Object[] objArr18 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + 494, 4 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) View.MeasureSpec.getMode(0));
                    Object[] objArr19 = new Object[1];
                    c($$a[0], (byte) (-$$a[9]), (byte) ($$a[47] - 1), objArr19);
                    obj3 = cls6.getMethod((String) objArr19[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                int i = ((int[]) objArr20[1])[0];
                if (((int[]) objArr20[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - MotionEvent.axisFromString(""), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 35, (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr21 = {-2013222543, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 911, 19 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr21);
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
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                byte b = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr = new Object[1];
                a(b, (byte) (b | TarHeader.LF_BLK), (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[56], objArr2);
                Object[] objArr3 = new Object[1];
                b(null, ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                b(null, getPackageName().codePointAt(3) + 27, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 35, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 911, ((Process.getThreadPriority(0) + 20) >> 6) + 18, (char) View.combineMeasuredStates(0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(null, super.getResources().getString(R.string.error_saving_exceed_max).substring(11, 12).codePointAt(0) + 26, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(null, getPackageName().length() + 120, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ExpandableListView.getPackedPositionChild(0L), Process.getGidForName("") + 36, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.argb(0, 0, 0, 0), 18 - Color.red(0), (char) Color.argb(0, 0, 0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    public OrganizerSummaryActivity() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.familyaccount.view.summary.OrganizerSummaryActivity$$ExternalSyntheticLambda0
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                OrganizerSummaryActivity.$r8$lambda$zZFi0cnfUDTH8vEee00QdblnbqY(OrganizerSummaryActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.cashierResult = registerForActivityResult;
    }

    @JvmName(name = "getPresenter")
    public final OrganizerSummaryContract.Presenter getPresenter() {
        OrganizerSummaryContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(OrganizerSummaryContract.Presenter presenter) {
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
    public final ActivityOrganizerSummaryBinding inflateViewBinding() {
        ActivityOrganizerSummaryBinding authRequestContext = ActivityOrganizerSummaryBinding.getAuthRequestContext(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        DaggerFamilyAccountOrganizerSummaryComponent.Builder authRequestContext = DaggerFamilyAccountOrganizerSummaryComponent.getAuthRequestContext();
        Application application = getApplication();
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        authRequestContext.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) application).getApplicationComponent());
        authRequestContext.BuiltInFictitiousFunctionClassFactory = (FamilyAccountOrganizerSummaryModule) Preconditions.getAuthRequestContext(new FamilyAccountOrganizerSummaryModule(new OrganizerSummaryContract.View() { // from class: id.dana.familyaccount.view.summary.OrganizerSummaryActivity$getFamilyAccountOrganizerSummaryModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.familyaccount.contract.OrganizerSummaryContract.View
            public final void PlaceComponentResult(boolean p0) {
                String str;
                OrganizerSummaryActivity.this.KClassImpl$Data$declaredNonStaticMembers$2(p0);
                OrganizerSummaryActivity organizerSummaryActivity = OrganizerSummaryActivity.this;
                organizerSummaryActivity.PlaceComponentResult(!p0, organizerSummaryActivity.getResources().getString(R.string.family_account_text_organizer_summary_error_cashier_native_disabled));
                OrganizerSummaryContract.Presenter presenter = OrganizerSummaryActivity.this.getPresenter();
                str = OrganizerSummaryActivity.this.MyBillsEntityDataFactory;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    str = null;
                }
                presenter.MyBillsEntityDataFactory(str);
            }

            @Override // id.dana.familyaccount.contract.OrganizerSummaryContract.View
            public final void getAuthRequestContext(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                StringBuilder sb = new StringBuilder();
                sb.append("https://m.dana.id");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(DanaUrl.TRANSACTION_DETAIL, Arrays.copyOf(new Object[]{p0}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "");
                sb.append(format);
                String obj = sb.toString();
                final OrganizerSummaryActivity organizerSummaryActivity = OrganizerSummaryActivity.this;
                DanaH5.startContainerFullUrl(obj, new DanaH5Listener() { // from class: id.dana.familyaccount.view.summary.OrganizerSummaryActivity$getFamilyAccountOrganizerSummaryModule$1$onTransactionHistoryDetail$$inlined$withDanaH5Callback$1
                    @Override // id.dana.utils.danah5.DanaH5Listener
                    public final void onContainerDestroyed(Bundle p02) {
                    }

                    @Override // id.dana.utils.danah5.DanaH5Listener
                    public final void onContainerCreated(Bundle p02) {
                        OrganizerSummaryActivity.this.finish();
                    }
                });
            }

            @Override // id.dana.familyaccount.contract.OrganizerSummaryContract.View
            public final void getAuthRequestContext(SummaryModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                OrganizerSummaryActivity.access$loadSummaryData(OrganizerSummaryActivity.this, p0);
                OrganizerSummaryActivity.access$loadPayLayoutData(OrganizerSummaryActivity.this, p0);
                OrganizerSummaryActivity.access$actionButtonSummary(OrganizerSummaryActivity.this, p0);
            }

            @Override // id.dana.familyaccount.contract.OrganizerSummaryContract.View
            public final void MyBillsEntityDataFactory(SummaryModel p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                OrganizerSummaryActivity.access$setupX2BSummary(OrganizerSummaryActivity.this, p0, p1);
            }

            @Override // id.dana.familyaccount.contract.OrganizerSummaryContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                OrganizerSummaryActivity.this.getFamilyAccountAnalyticalTracker().MyBillsEntityDataFactory(false);
                DANAToast dANAToast = DANAToast.PlaceComponentResult;
                OrganizerSummaryActivity organizerSummaryActivity = OrganizerSummaryActivity.this;
                OrganizerSummaryActivity organizerSummaryActivity2 = organizerSummaryActivity;
                String string = organizerSummaryActivity.getString(R.string.family_account_success_reject);
                Intrinsics.checkNotNullExpressionValue(string, "");
                DANAToast.getAuthRequestContext(organizerSummaryActivity2, string);
                OrganizerSummaryActivity.this.finish();
            }

            @Override // id.dana.familyaccount.contract.OrganizerSummaryContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DANAToast dANAToast = DANAToast.PlaceComponentResult;
                DANAToast.PlaceComponentResult(OrganizerSummaryActivity.this, p0);
            }

            @Override // id.dana.familyaccount.contract.OrganizerSummaryContract.View
            public final void PlaceComponentResult(ApproveSendMoneyResult p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                OrganizerSummaryActivity.this.getFamilyAccountAnalyticalTracker().MyBillsEntityDataFactory(true);
                OrganizerSummaryActivity.access$openCashierNativePage(OrganizerSummaryActivity.this, p0);
            }

            @Override // id.dana.familyaccount.contract.OrganizerSummaryContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DANAToast dANAToast = DANAToast.PlaceComponentResult;
                DANAToast.PlaceComponentResult(OrganizerSummaryActivity.this, p0);
            }

            @Override // id.dana.familyaccount.contract.OrganizerSummaryContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                OrganizerSummaryActivity.access$showShimmeringView(OrganizerSummaryActivity.this);
            }

            @Override // id.dana.familyaccount.contract.OrganizerSummaryContract.View
            public final void PlaceComponentResult() {
                OrganizerSummaryActivity.access$hideShimmeringView(OrganizerSummaryActivity.this);
            }

            @Override // id.dana.familyaccount.contract.OrganizerSummaryContract.View
            public final void PlaceComponentResult(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                OrganizerSummaryActivity.access$setViewStatusInformation(OrganizerSummaryActivity.this, p0);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                DanaLoadingDialog access$getDanaLoadingDialog = OrganizerSummaryActivity.access$getDanaLoadingDialog(OrganizerSummaryActivity.this);
                if (access$getDanaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                    return;
                }
                access$getDanaLoadingDialog.MyBillsEntityDataFactory.show();
                access$getDanaLoadingDialog.getAuthRequestContext.startRefresh();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                OrganizerSummaryActivity.access$getDanaLoadingDialog(OrganizerSummaryActivity.this).PlaceComponentResult();
            }

            @Override // id.dana.familyaccount.contract.OrganizerSummaryContract.View
            public final void MyBillsEntityDataFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (Intrinsics.areEqual(p0, StatusInformationType.MEMBER_USER_FREEZE)) {
                    DANAToast dANAToast = DANAToast.PlaceComponentResult;
                    OrganizerSummaryActivity organizerSummaryActivity = OrganizerSummaryActivity.this;
                    OrganizerSummaryActivity organizerSummaryActivity2 = organizerSummaryActivity;
                    String string = organizerSummaryActivity.getResources().getString(R.string.family_account_member_onhold_error);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    DANAToast.PlaceComponentResult(organizerSummaryActivity2, string);
                }
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.BuiltInFictitiousFunctionClassFactory, FamilyAccountOrganizerSummaryModule.class);
        if (authRequestContext.PlaceComponentResult == null) {
            authRequestContext.PlaceComponentResult = new FamilyAccountTrackerModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerFamilyAccountOrganizerSummaryComponent.FamilyAccountOrganizerSummaryComponentImpl(authRequestContext.BuiltInFictitiousFunctionClassFactory, authRequestContext.PlaceComponentResult, authRequestContext.MyBillsEntityDataFactory, (byte) 0).BuiltInFictitiousFunctionClassFactory(this);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        if (p0) {
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setActiveButton(getString(R.string.family_account_text_organizer_summary_button_approve), null);
        } else {
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setDisabled(getString(R.string.family_account_text_organizer_summary_button_approve));
        }
    }

    public final void PlaceComponentResult(boolean p0, String p1) {
        ActivityOrganizerSummaryBinding binding = getBinding();
        AppCompatImageView appCompatImageView = binding.GetContactSyncConfig;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(p0 ? 0 : 8);
        TextView textView = binding.NetworkUserEntityData$$ExternalSyntheticLambda7;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(p0 ? 0 : 8);
        if (p1 != null) {
            textView.setText(p1);
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        getAuthRequestContext(R.string.family_account_text_organizer_summary_title_toolbar);
    }

    private final void MyBillsEntityDataFactory(boolean p0) {
        if (p0) {
            getAuthRequestContext(R.string.family_account_text_title_toolbar);
        } else {
            configToolbar();
        }
        ActivityOrganizerSummaryBinding binding = getBinding();
        MaterialCardView materialCardView = binding.initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(materialCardView, "");
        materialCardView.setVisibility(p0 ? 0 : 8);
        StatusInformationView statusInformationView = binding.NetworkUserEntityData$$ExternalSyntheticLambda6;
        Intrinsics.checkNotNullExpressionValue(statusInformationView, "");
        statusInformationView.setVisibility(p0 ? 0 : 8);
        ConstraintLayout constraintLayout = binding.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(p0 ^ true ? 0 : 8);
    }

    @JvmName(name = "getCashierResult")
    public final ActivityResultLauncher<Intent> getCashierResult() {
        return this.cashierResult;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        getPresenter().onDestroy();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/familyaccount/view/summary/OrganizerSummaryActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", OrganizerSummaryActivity.PAYMENT_RESULT, "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Intent MyBillsEntityDataFactory(Context p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intent intent = new Intent(p0, OrganizerSummaryActivity.class);
            intent.putExtra("ORDER_ID", p1);
            return intent;
        }
    }

    /* renamed from: $r8$lambda$6TDbiZG1FJob-XuNnKfjYkt551M */
    public static /* synthetic */ void m2605$r8$lambda$6TDbiZG1FJobXuNnKfjYkt551M(OrganizerSummaryActivity organizerSummaryActivity, View view) {
        Intrinsics.checkNotNullParameter(organizerSummaryActivity, "");
        organizerSummaryActivity.getOnBackPressedDispatcher().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void $r8$lambda$bW9e0W6mKWlH48SjggDZhKk3mQc(OrganizerSummaryActivity organizerSummaryActivity, View view) {
        Intrinsics.checkNotNullParameter(organizerSummaryActivity, "");
        OrganizerSummaryContract.Presenter presenter = organizerSummaryActivity.getPresenter();
        String str = organizerSummaryActivity.MyBillsEntityDataFactory;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        presenter.BuiltInFictitiousFunctionClassFactory(new ApproveSendMoneyRequest(null, str, "1.0", null, null, null, null, null, 249, null));
    }

    public static /* synthetic */ void $r8$lambda$zZFi0cnfUDTH8vEee00QdblnbqY(OrganizerSummaryActivity organizerSummaryActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(organizerSummaryActivity, "");
        if (activityResult.BuiltInFictitiousFunctionClassFactory == -1) {
            Intent intent = activityResult.MyBillsEntityDataFactory;
            if (Intrinsics.areEqual(intent != null ? intent.getStringExtra(PAYMENT_RESULT) : null, "success")) {
                organizerSummaryActivity.finish();
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$zZyl2lnWBaCcUfGT9ZlIQMDBwEE(final OrganizerSummaryActivity organizerSummaryActivity, final SummaryModel summaryModel, View view) {
        Intrinsics.checkNotNullParameter(organizerSummaryActivity, "");
        Intrinsics.checkNotNullParameter(summaryModel, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(organizerSummaryActivity);
        builder.SubSequence = organizerSummaryActivity.getString(R.string.family_account_text_dialog_approval_transaction_title);
        builder.GetContactSyncConfig = organizerSummaryActivity.getString(R.string.family_account_text_dialog_approval_confirmation_message);
        builder.KClassImpl$Data$declaredNonStaticMembers$2(organizerSummaryActivity.getString(R.string.option_no), new Function1<View, Unit>() { // from class: id.dana.familyaccount.view.summary.OrganizerSummaryActivity$showConfirmationDialog$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view2) {
                Intrinsics.checkNotNullParameter(view2, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }
        }).BuiltInFictitiousFunctionClassFactory(organizerSummaryActivity.getString(R.string.option_yes), new Function1<View, Unit>() { // from class: id.dana.familyaccount.view.summary.OrganizerSummaryActivity$showConfirmationDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                OrganizerSummaryActivity.access$rejectSendMoney(OrganizerSummaryActivity.this, summaryModel);
            }
        }).BuiltInFictitiousFunctionClassFactory().show();
    }

    public static final /* synthetic */ void access$actionButtonSummary(final OrganizerSummaryActivity organizerSummaryActivity, final SummaryModel summaryModel) {
        ActivityOrganizerSummaryBinding binding = organizerSummaryActivity.getBinding();
        binding.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.summary.OrganizerSummaryActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrganizerSummaryActivity.$r8$lambda$bW9e0W6mKWlH48SjggDZhKk3mQc(OrganizerSummaryActivity.this, view);
            }
        });
        binding.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.summary.OrganizerSummaryActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrganizerSummaryActivity.$r8$lambda$zZyl2lnWBaCcUfGT9ZlIQMDBwEE(OrganizerSummaryActivity.this, summaryModel, view);
            }
        });
    }

    public static final /* synthetic */ DanaLoadingDialog access$getDanaLoadingDialog(OrganizerSummaryActivity organizerSummaryActivity) {
        return (DanaLoadingDialog) organizerSummaryActivity.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    public static final /* synthetic */ void access$hideShimmeringView(OrganizerSummaryActivity organizerSummaryActivity) {
        SkeletonScreen skeletonScreen = organizerSummaryActivity.PlaceComponentResult;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    public static final /* synthetic */ void access$initView(OrganizerSummaryActivity organizerSummaryActivity) {
        organizerSummaryActivity.MyBillsEntityDataFactory(false);
        organizerSummaryActivity.PlaceComponentResult(false, null);
        organizerSummaryActivity.getPresenter().getAuthRequestContext();
    }

    public static final /* synthetic */ void access$loadPayLayoutData(OrganizerSummaryActivity organizerSummaryActivity, SummaryModel summaryModel) {
        String str;
        String format;
        organizerSummaryActivity.getBinding().initRecordTimeStamp.setVisibility(0);
        TextView textView = organizerSummaryActivity.getBinding().PrepareContext;
        MoneyViewModel moneyViewModel = summaryModel.getAuthRequestContext;
        Boolean bool = null;
        if (moneyViewModel != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
            format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
            if (format == null) {
                format = "";
            }
            sb.append(format);
            str = sb.toString();
        } else {
            str = null;
        }
        textView.setText(str);
        if (summaryModel.getAuthRequestContext != null) {
            if (summaryModel.scheduleImpl != null) {
                bool = Boolean.valueOf(!r9.getAuthRequestContext(r0));
            }
        } else {
            bool = Boolean.TRUE;
        }
        if (bool == null || bool.booleanValue()) {
            return;
        }
        organizerSummaryActivity.KClassImpl$Data$declaredNonStaticMembers$2(false);
        organizerSummaryActivity.PlaceComponentResult(true, organizerSummaryActivity.getResources().getString(R.string.family_account_text_organizer_summary_error_insufficient_fund));
    }

    public static final /* synthetic */ void access$loadSummaryData(OrganizerSummaryActivity organizerSummaryActivity, SummaryModel summaryModel) {
        organizerSummaryActivity.getBinding().isLayoutRequested.setSummaryHeader(summaryModel);
        String str = summaryModel.getErrorConfigVersion;
        if (!Intrinsics.areEqual(str, FamilyAccountTransactionType.TRANSFER_X2B)) {
            if (Intrinsics.areEqual(str, FamilyAccountTransactionType.TRANSFER_X2P)) {
                OrganizerSummaryX2PBodyView organizerSummaryX2PBodyView = organizerSummaryActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda5;
                organizerSummaryX2PBodyView.setVisibility(0);
                organizerSummaryX2PBodyView.setSummaryView(summaryModel);
                return;
            }
            return;
        }
        MoneyViewModel moneyViewModel = summaryModel.BuiltInFictitiousFunctionClassFactory;
        if (!Intrinsics.areEqual(moneyViewModel != null ? moneyViewModel.PlaceComponentResult : null, "0")) {
            MoneyViewModel moneyViewModel2 = summaryModel.BuiltInFictitiousFunctionClassFactory;
            String str2 = moneyViewModel2 != null ? moneyViewModel2.PlaceComponentResult : null;
            if (!(str2 == null || str2.length() == 0)) {
                OrganizerSummaryX2BBodyView organizerSummaryX2BBodyView = organizerSummaryActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda4;
                organizerSummaryX2BBodyView.setVisibility(0);
                organizerSummaryX2BBodyView.setSummaryView(summaryModel, 0);
                return;
            }
        }
        organizerSummaryActivity.getPresenter().getAuthRequestContext(summaryModel);
    }

    public static final /* synthetic */ void access$navigateToCustomerCare(OrganizerSummaryActivity organizerSummaryActivity) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:1500445"));
        organizerSummaryActivity.startActivity(intent);
    }

    public static final /* synthetic */ void access$openCashierNativePage(OrganizerSummaryActivity organizerSummaryActivity, ApproveSendMoneyResult approveSendMoneyResult) {
        AttributesResult attributes = approveSendMoneyResult.getAttributes();
        ActivityResultLauncher<Intent> activityResultLauncher = organizerSummaryActivity.cashierResult;
        PayActivity.Companion companion = PayActivity.INSTANCE;
        activityResultLauncher.MyBillsEntityDataFactory(PayActivity.Companion.MyBillsEntityDataFactory(organizerSummaryActivity, approveSendMoneyResult.getCashierOrderId(), AttributeCashierPayModelExtKt.getAuthRequestContext(attributes)), null);
    }

    public static final /* synthetic */ void access$rejectSendMoney(OrganizerSummaryActivity organizerSummaryActivity, SummaryModel summaryModel) {
        OrganizerSummaryContract.Presenter presenter = organizerSummaryActivity.getPresenter();
        String str = organizerSummaryActivity.MyBillsEntityDataFactory;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        String str2 = summaryModel.getErrorConfigVersion;
        presenter.BuiltInFictitiousFunctionClassFactory(new RejectSendMoneyRequest(str, str2 != null ? str2 : ""));
    }

    public static final /* synthetic */ void access$setViewStatusInformation(final OrganizerSummaryActivity organizerSummaryActivity, final String str) {
        organizerSummaryActivity.MyBillsEntityDataFactory(true);
        organizerSummaryActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda6.setStatusInformationType(str);
        if (Intrinsics.areEqual(str, StatusInformationType.KYC_REVOKED)) {
            StatusInformationView statusInformationView = organizerSummaryActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda6;
            statusInformationView.setNegativeButtonListener(new Function0<Unit>() { // from class: id.dana.familyaccount.view.summary.OrganizerSummaryActivity$setupButtonTypeKycRevoked$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    OrganizerSummaryActivity.this.finish();
                }
            });
            statusInformationView.setPositiveButtonListener(new Function0<Unit>() { // from class: id.dana.familyaccount.view.summary.OrganizerSummaryActivity$setupButtonTypeKycRevoked$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("https://m.dana.id");
                    sb.append(OrganizerSummaryActivity.this.getDynamicUrlWrapper().getKycLandingPageUrl());
                    DanaH5.startContainerFullUrl(sb.toString());
                }
            });
            return;
        }
        organizerSummaryActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda6.setGotItButtonListener(new Function0<Unit>() { // from class: id.dana.familyaccount.view.summary.OrganizerSummaryActivity$setupButtonTypeDefault$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str2 = str;
                int hashCode = str2.hashCode();
                if (hashCode == 330987829) {
                    if (str2.equals("REQUEST_EXPIRED")) {
                        organizerSummaryActivity.finish();
                    }
                } else if (hashCode == 944938249) {
                    if (str2.equals("ACCOUNT_FREEZE")) {
                        OrganizerSummaryActivity.access$navigateToCustomerCare(organizerSummaryActivity);
                    }
                } else if (hashCode == 1109826930 && str2.equals(StatusInformationType.GENERAL_STATUS_ERROR)) {
                    OrganizerSummaryActivity.access$initView(organizerSummaryActivity);
                }
            }
        });
    }

    public static final /* synthetic */ void access$setupX2BSummary(OrganizerSummaryActivity organizerSummaryActivity, SummaryModel summaryModel, int i) {
        OrganizerSummaryX2BBodyView organizerSummaryX2BBodyView = organizerSummaryActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda4;
        organizerSummaryX2BBodyView.setVisibility(0);
        organizerSummaryX2BBodyView.setSummaryView(summaryModel, i);
    }

    public static final /* synthetic */ void access$showShimmeringView(OrganizerSummaryActivity organizerSummaryActivity) {
        SkeletonScreen skeletonScreen = organizerSummaryActivity.PlaceComponentResult;
        if (skeletonScreen != null) {
            skeletonScreen.MyBillsEntityDataFactory();
        }
    }

    private final void getAuthRequestContext(int p0) {
        LayoutToolbarBinding layoutToolbarBinding = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda2;
        TextView textView = layoutToolbarBinding.initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
        ImageView imageView = layoutToolbarBinding.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(8);
        layoutToolbarBinding.initRecordTimeStamp.setText(getString(p0));
        LayoutToolbarBinding layoutToolbarBinding2 = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda2;
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationIcon(R.drawable.btn_arrow_left);
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.summary.OrganizerSummaryActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrganizerSummaryActivity.m2605$r8$lambda$6TDbiZG1FJobXuNnKfjYkt551M(OrganizerSummaryActivity.this, view);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        ViewSkeletonScreen PlaceComponentResult2 = ShimmeringUtil.PlaceComponentResult(getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0, R.layout.view_organizer_summary_skeleton);
        this.PlaceComponentResult = PlaceComponentResult2;
        if (PlaceComponentResult2 != null) {
            PlaceComponentResult2.MyBillsEntityDataFactory();
        }
        String stringExtra = getIntent().getStringExtra("ORDER_ID");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.MyBillsEntityDataFactory = stringExtra;
        MyBillsEntityDataFactory(false);
        PlaceComponentResult(false, null);
        getPresenter().getAuthRequestContext();
    }

    private static void b(int[] iArr, int i, byte[] bArr, char[] cArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = GetContactSyncConfig;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        int i3 = (int) (4571606982258105150L ^ NetworkUserEntityData$$ExternalSyntheticLambda1);
        if (initRecordTimeStamp) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr4);
        } else if (NetworkUserEntityData$$ExternalSyntheticLambda2) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr5);
        } else {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr6);
        }
    }
}
