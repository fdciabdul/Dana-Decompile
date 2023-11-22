package id.dana.userpersonalization;

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
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.ThrottledOnExecuteAction;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.contract.userpersonalization.UserPersonalizationContract;
import id.dana.contract.userpersonalization.UserPersonalizationModule;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerUserPersonalizationComponent;
import id.dana.di.modules.UserPersonalizationAnalyticModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.explore.domain.userpersonalization.model.UserPersonalizationModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.userpersonalization.tracker.UserPersonalizationAnalyticTracker;
import id.dana.userpersonalization.view.UserPersonalizationListView;
import id.dana.userpersonalization.view.UserPersonalizationView;
import id.dana.utils.DANAToast;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B\u0007¢\u0006\u0004\b6\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u0019\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0005R\u0013\u0010\u0018\u001a\u00020\u0015X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0013\u0010\u0014\u001a\u00020#X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b$\u0010\u0017R\u0014\u0010\u0016\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105"}, d2 = {"Lid/dana/userpersonalization/UserPersonalizationActivity;", "Lid/dana/base/BaseActivity;", "Lid/dana/userpersonalization/view/UserPersonalizationView$UserPersonalizationViewListener;", "", "configToolbar", "()V", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "onBackPressed", "Landroid/view/View;", "view", "onClickLeftMenuButton", "(Landroid/view/View;)V", "", "Lid/dana/explore/domain/userpersonalization/model/UserPersonalizationModel;", "preferences", "onGetPreferences", "(Ljava/util/List;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/dialog/DanaLoadingDialog;", "lookAheadTest", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "Lid/dana/dialog/TwoButtonWithImageDialog;", "scheduleImpl", "Lid/dana/dialog/TwoButtonWithImageDialog;", "getAuthRequestContext", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Z", "BuiltInFictitiousFunctionClassFactory", "getErrorConfigVersion", "PlaceComponentResult", "Lid/dana/base/ThrottledOnExecuteAction;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/userpersonalization/UserPersonalizationActivity$userPersonalizationItemListener$1;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/userpersonalization/UserPersonalizationActivity$userPersonalizationItemListener$1;", "Lid/dana/contract/userpersonalization/UserPersonalizationContract$Presenter;", "userPersonalizationPresenter", "Lid/dana/contract/userpersonalization/UserPersonalizationContract$Presenter;", "getUserPersonalizationPresenter", "()Lid/dana/contract/userpersonalization/UserPersonalizationContract$Presenter;", "setUserPersonalizationPresenter", "(Lid/dana/contract/userpersonalization/UserPersonalizationContract$Presenter;)V", "Lid/dana/userpersonalization/tracker/UserPersonalizationAnalyticTracker;", "userPersonalizationTracker", "Lid/dana/userpersonalization/tracker/UserPersonalizationAnalyticTracker;", "getUserPersonalizationTracker", "()Lid/dana/userpersonalization/tracker/UserPersonalizationAnalyticTracker;", "setUserPersonalizationTracker", "(Lid/dana/userpersonalization/tracker/UserPersonalizationAnalyticTracker;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserPersonalizationActivity extends BaseActivity implements UserPersonalizationView.UserPersonalizationViewListener {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static boolean DatabaseTableConfigUtil;
    private static int GetContactSyncConfig;
    private static char[] initRecordTimeStamp;
    private static boolean newProxyInstance;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private TwoButtonWithImageDialog getAuthRequestContext;
    @Inject
    public UserPersonalizationContract.Presenter userPersonalizationPresenter;
    @Inject
    public UserPersonalizationAnalyticTracker userPersonalizationTracker;
    public static final byte[] $$a = {111, -54, 77, -36, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 130;
    public static final byte[] getAuthRequestContext = {45, -79, -67, -1, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 131;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.userpersonalization.UserPersonalizationActivity$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(UserPersonalizationActivity.this);
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<ThrottledOnExecuteAction>() { // from class: id.dana.userpersonalization.UserPersonalizationActivity$throttledOnExecuteAction$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ThrottledOnExecuteAction invoke() {
            return new ThrottledOnExecuteAction();
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final UserPersonalizationActivity$userPersonalizationItemListener$1 lookAheadTest = new UserPersonalizationListView.UserPersonalizationItemListener() { // from class: id.dana.userpersonalization.UserPersonalizationActivity$userPersonalizationItemListener$1
        @Override // id.dana.userpersonalization.view.UserPersonalizationListView.UserPersonalizationItemListener
        public final void BuiltInFictitiousFunctionClassFactory() {
            DANAToast dANAToast = DANAToast.PlaceComponentResult;
            UserPersonalizationActivity userPersonalizationActivity = UserPersonalizationActivity.this;
            UserPersonalizationActivity userPersonalizationActivity2 = userPersonalizationActivity;
            String string = userPersonalizationActivity.getString(R.string.user_personalization_reach_limit);
            Intrinsics.checkNotNullExpressionValue(string, "");
            DANAToast.MyBillsEntityDataFactory(userPersonalizationActivity2, string);
        }

        @Override // id.dana.userpersonalization.view.UserPersonalizationListView.UserPersonalizationItemListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
            if (p0) {
                DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) UserPersonalizationActivity.this._$_findCachedViewById(R.id.c);
                if (danaButtonPrimaryView != null) {
                    danaButtonPrimaryView.setActiveButton(UserPersonalizationActivity.this.getString(R.string.user_personalization_continue), null);
                }
                UserPersonalizationActivity.this.BuiltInFictitiousFunctionClassFactory = true;
                return;
            }
            DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) UserPersonalizationActivity.this._$_findCachedViewById(R.id.c);
            if (danaButtonPrimaryView2 != null) {
                danaButtonPrimaryView2.setDisabled(UserPersonalizationActivity.this.getString(R.string.user_personalization_continue));
            }
            UserPersonalizationActivity.this.BuiltInFictitiousFunctionClassFactory = false;
        }
    };

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        initRecordTimeStamp = new char[]{39878, 39483, 39877, 39479, 39480, 39486, 39931, 39481, 39910, 39876, 39477, 39475, 39470, 39893, 39873, 39874, 39474, 39485, 39476, 39897, 39482, 39890, 39920, 39923, 39921, 39929, 39918, 39875, 39927, 39926, 39924, 39925, 39879, 39922, 39919, 39928, 39872, 39478};
        DatabaseTableConfigUtil = true;
        newProxyInstance = true;
        GetContactSyncConfig = 909155241;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.userpersonalization.UserPersonalizationActivity.getAuthRequestContext
            int r8 = 106 - r8
            int r6 = 23 - r6
            int r7 = r7 + 4
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r8
            r4 = 0
            r8 = r7
            r7 = r6
            goto L2c
        L14:
            r3 = 0
        L15:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            int r7 = r7 + 1
            r3 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2c:
            int r6 = r6 + r3
            int r6 = r6 + (-4)
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.userpersonalization.UserPersonalizationActivity.b(short, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 21
            int r6 = r6 + 4
            int r7 = r7 * 2
            int r7 = 103 - r7
            byte[] r0 = id.dana.userpersonalization.UserPersonalizationActivity.$$a
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L18
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L38
        L18:
            r3 = 0
            r5 = r8
            r8 = r7
        L1b:
            r7 = r5
            byte r4 = (byte) r8
            r1[r3] = r4
            int r6 = r6 + 1
            int r3 = r3 + 1
            if (r3 != r7) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L38:
            int r9 = r9 + r6
            int r6 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.userpersonalization.UserPersonalizationActivity.c(short, short, short, java.lang.Object[]):void");
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
        a(null, 127 - View.getDefaultSize(0, 0), new byte[]{-109, -109, -112, -118, -123, -124, -108, -121, -109, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(null, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 127, new byte[]{-125, -122, -106, -115, -107}, null, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), View.resolveSizeAndState(0, 0, 0) + 35, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(null, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 127, new byte[]{-112, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -112, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -112, -100, -118, -112, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(null, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 127, new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -112, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -112, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(null, TextUtils.lastIndexOf("", '0', 0) + 128, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -112, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -112, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -112, -98, -99}, null, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(null, 127 - View.getDefaultSize(0, 0), new byte[]{-109, -117, -126, -112, -116, -112, -92, -99, -116, -92, -117, -109, -112, -91, -126, -122, -92, -122, -120, -127, -92, -107, -123, -118, -121, -112, -124, -127, -111, -90, -109, -125, -124, -127, -111, -91, -121, -117, -109, -127, -118, -117, -127, -112, -124, -113, -117, -121, -127, -126, -127, -125, -92, -92, -93, -109, -120, -117, -117, -113}, null, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(null, TextUtils.indexOf("", "") + 127, new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getPressedStateDuration() >> 16), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b((byte) (-getAuthRequestContext[30]), 36, getAuthRequestContext[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b((byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[35] - 1), getAuthRequestContext[7], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(54 - ImageFormat.getBitsPerPixel(0), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 4, (char) View.getDefaultSize(0, 0));
                        Object[] objArr16 = new Object[1];
                        c($$a[47], $$a[12], $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 800, 15 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 15 - View.resolveSizeAndState(0, 0, 0), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 29 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (57994 - (ViewConfiguration.getTapTimeout() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + 800, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 15, (char) ExpandableListView.getPackedPositionType(0L)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1548883643, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 912, 18 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[30]), 36, getAuthRequestContext[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b((byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[35] - 1), getAuthRequestContext[7], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 62, Drawable.resolveOpacity(0, 0) + 46, (char) KeyEvent.normalizeMetaState(0));
                        byte b = $$a[28];
                        byte b2 = (byte) ($$a[78] - 1);
                        Object[] objArr22 = new Object[1];
                        c(b, b2, b2, objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 35, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-1548883643, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 17, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[30]), 36, getAuthRequestContext[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b((byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[35] - 1), getAuthRequestContext[7], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getTouchSlop() >> 8), 3 - View.resolveSize(0, 0), (char) (38969 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))));
                        byte b3 = $$a[28];
                        byte b4 = (byte) ($$a[78] - 1);
                        Object[] objArr28 = new Object[1];
                        c(b3, b4, b4, objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 930, View.getDefaultSize(0, 0) + 35, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1548883643, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.blue(0), 18 - TextUtils.indexOf("", ""), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[30]), 36, getAuthRequestContext[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b((byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[35] - 1), getAuthRequestContext[7], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(108 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 3 - View.resolveSizeAndState(0, 0, 0), (char) KeyEvent.getDeadChar(0, 0));
                        Object[] objArr34 = new Object[1];
                        c((byte) (-$$a[40]), $$a[9], $$a[8], objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r2 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.getOffsetAfter("", 0) + 35, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-1548883643, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getLongPressTimeout() >> 16) + 18, (char) TextUtils.getOffsetAfter("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return R.layout.activity_user_personalization;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(null, (Process.myTid() >> 22) + 127, new byte[]{-109, -109, -112, -118, -123, -124, -108, -121, -109, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(null, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 126, new byte[]{-125, -122, -106, -115, -107}, null, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(null, MotionEvent.axisFromString("") + 128, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                try {
                    Object[] objArr5 = new Object[1];
                    b(getAuthRequestContext[25], getAuthRequestContext[3], getAuthRequestContext[32], objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    b(getAuthRequestContext[27], getAuthRequestContext[59], getAuthRequestContext[13], objArr6);
                    Object[] objArr7 = new Object[1];
                    a(null, ((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr7);
                    baseContext = (Context) cls2.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - MotionEvent.axisFromString(""), 35 - Color.argb(0, 0, 0, 0), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr8 = new Object[1];
                    a(null, super.getResources().getString(R.string.remarks_not_editable).substring(2, 3).codePointAt(0) + 11, new byte[]{-112, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -112, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -112, -100, -118, -112, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr8);
                    String str = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(null, super.getResources().getString(R.string.otp_limit_dialog_desc).substring(24, 26).length() + 125, new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -112, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -112, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr9);
                    String str2 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(null, getPackageName().codePointAt(5) + 17, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -112, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -112, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -112, -98, -99}, null, objArr10);
                    String str3 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(null, 127 - ExpandableListView.getPackedPositionType(0L), new byte[]{-109, -117, -126, -112, -116, -112, -92, -99, -116, -92, -117, -109, -112, -91, -126, -122, -92, -122, -120, -127, -92, -107, -123, -118, -121, -112, -124, -127, -111, -90, -109, -125, -124, -127, -111, -91, -121, -117, -109, -127, -118, -117, -127, -112, -124, -113, -117, -121, -127, -126, -127, -125, -92, -92, -93, -109, -120, -117, -117, -113}, null, objArr11);
                    String str4 = (String) objArr11[0];
                    try {
                        Object[] objArr12 = new Object[1];
                        b(getAuthRequestContext[25], getAuthRequestContext[3], getAuthRequestContext[32], objArr12);
                        Class<?> cls4 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        b(getAuthRequestContext[27], getAuthRequestContext[59], getAuthRequestContext[13], objArr13);
                        Object[] objArr14 = new Object[1];
                        a(null, ((ApplicationInfo) cls4.getMethod((String) objArr13[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr14);
                        try {
                            Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 911, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 18, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr15);
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
            b((byte) (-getAuthRequestContext[30]), 36, getAuthRequestContext[25], objArr16);
            Class<?> cls5 = Class.forName((String) objArr16[0]);
            Object[] objArr17 = new Object[1];
            b((byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[35] - 1), getAuthRequestContext[7], objArr17);
            try {
                Object[] objArr18 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 4, (char) (ViewConfiguration.getEdgeSlop() >> 16));
                    Object[] objArr19 = new Object[1];
                    c((byte) (-$$a[40]), $$a[9], $$a[8], objArr19);
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
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 35, (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr21 = {619471922, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 911, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 18, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(null, 128 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                b(getAuthRequestContext[25], getAuthRequestContext[3], getAuthRequestContext[32], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(getAuthRequestContext[27], getAuthRequestContext[59], getAuthRequestContext[13], objArr3);
                Object[] objArr4 = new Object[1];
                a(null, ((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, ((byte) KeyEvent.getModifierMetaStateMask()) + 36, (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetBefore("", 0), (KeyEvent.getMaxKeyCode() >> 16) + 18, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("MyBillsEntityDataFactory", Context.class);
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
            a(null, 127 - View.combineMeasuredStates(0, 0), new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(null, getPackageName().length() + 120, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, View.resolveSize(0, 0) + 35, (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.argb(0, 0, 0, 0), 19 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getUserPersonalizationPresenter")
    public final UserPersonalizationContract.Presenter getUserPersonalizationPresenter() {
        UserPersonalizationContract.Presenter presenter = this.userPersonalizationPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setUserPersonalizationPresenter")
    public final void setUserPersonalizationPresenter(UserPersonalizationContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.userPersonalizationPresenter = presenter;
    }

    @JvmName(name = "getUserPersonalizationTracker")
    public final UserPersonalizationAnalyticTracker getUserPersonalizationTracker() {
        UserPersonalizationAnalyticTracker userPersonalizationAnalyticTracker = this.userPersonalizationTracker;
        if (userPersonalizationAnalyticTracker != null) {
            return userPersonalizationAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setUserPersonalizationTracker")
    public final void setUserPersonalizationTracker(UserPersonalizationAnalyticTracker userPersonalizationAnalyticTracker) {
        Intrinsics.checkNotNullParameter(userPersonalizationAnalyticTracker, "");
        this.userPersonalizationTracker = userPersonalizationAnalyticTracker;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setCenterTitle(getString(R.string.your_preferences));
        setMenuLeftButton(R.drawable.ic_close);
        setMenuLeftContentDescription(getString(R.string.btnX));
        setToolbarTitleContentDescription(getString(R.string.lblHeader));
    }

    @Override // id.dana.base.BaseActivity
    public final void onClickLeftMenuButton(View view) {
        onBackPressed();
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        UserPersonalizationView userPersonalizationView = (UserPersonalizationView) _$_findCachedViewById(R.id.view_user_personalization);
        if (userPersonalizationView != null) {
            userPersonalizationView.showLoadingState();
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.c);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setDisabled(getString(R.string.user_personalization_continue));
        }
        this.BuiltInFictitiousFunctionClassFactory = false;
    }

    @Override // id.dana.userpersonalization.view.UserPersonalizationView.UserPersonalizationViewListener
    public final void onGetPreferences(List<UserPersonalizationModel> preferences) {
        Intrinsics.checkNotNullParameter(preferences, "");
        if (this.BuiltInFictitiousFunctionClassFactory) {
            DanaLoadingDialog danaLoadingDialog = (DanaLoadingDialog) this.MyBillsEntityDataFactory.getValue();
            if (!danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                danaLoadingDialog.MyBillsEntityDataFactory.show();
                danaLoadingDialog.getAuthRequestContext.startRefresh();
            }
            getUserPersonalizationTracker().getAuthRequestContext(this.PlaceComponentResult ? TrackerKey.SourceType.EXPLORE_FIRST_TIME : TrackerKey.SourceType.EXPLORE_WIDGET, preferences);
            UserPersonalizationContract.Presenter userPersonalizationPresenter = getUserPersonalizationPresenter();
            List<UserPersonalizationModel> list = preferences;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((UserPersonalizationModel) it.next()).getPreferenceId());
            }
            userPersonalizationPresenter.KClassImpl$Data$declaredNonStaticMembers$2(arrayList);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/userpersonalization/UserPersonalizationActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void MyBillsEntityDataFactory(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.startActivity(new Intent(p0, UserPersonalizationActivity.class));
        }
    }

    /* renamed from: $r8$lambda$A-zmorekGXEWUenZ8Bf8WLNyU5Y  reason: not valid java name */
    public static /* synthetic */ void m2993$r8$lambda$AzmorekGXEWUenZ8Bf8WLNyU5Y(UserPersonalizationActivity userPersonalizationActivity, View view) {
        Intrinsics.checkNotNullParameter(userPersonalizationActivity, "");
        userPersonalizationActivity.finish();
    }

    /* renamed from: $r8$lambda$BeV5813Z91V7A7-V5_M2YoKoA9Y  reason: not valid java name */
    public static /* synthetic */ void m2994$r8$lambda$BeV5813Z91V7A7V5_M2YoKoA9Y(UserPersonalizationActivity userPersonalizationActivity, View view) {
        Intrinsics.checkNotNullParameter(userPersonalizationActivity, "");
        UserPersonalizationView userPersonalizationView = (UserPersonalizationView) userPersonalizationActivity._$_findCachedViewById(R.id.view_user_personalization);
        if (userPersonalizationView != null) {
            userPersonalizationView.setSelectedUserPersonalizationList();
        }
    }

    public static /* synthetic */ void $r8$lambda$EWVzi2OhSzsakzkLzVaXeiHoUOY(UserPersonalizationActivity userPersonalizationActivity, View view) {
        Intrinsics.checkNotNullParameter(userPersonalizationActivity, "");
        TwoButtonWithImageDialog twoButtonWithImageDialog = userPersonalizationActivity.getAuthRequestContext;
        if (twoButtonWithImageDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            twoButtonWithImageDialog = null;
        }
        twoButtonWithImageDialog.getAuthRequestContext();
    }

    public static /* synthetic */ void $r8$lambda$PPi0iaVa_8ufihx93rntyiyQ0Ps(UserPersonalizationActivity userPersonalizationActivity, View view) {
        Intrinsics.checkNotNullParameter(userPersonalizationActivity, "");
        userPersonalizationActivity.KClassImpl$Data$declaredNonStaticMembers$2();
        userPersonalizationActivity.getUserPersonalizationPresenter().BuiltInFictitiousFunctionClassFactory();
    }

    public static final /* synthetic */ DanaLoadingDialog access$getDanaLoadingDialog(UserPersonalizationActivity userPersonalizationActivity) {
        return (DanaLoadingDialog) userPersonalizationActivity.MyBillsEntityDataFactory.getValue();
    }

    public static final /* synthetic */ ThrottledOnExecuteAction access$getThrottledOnExecuteAction(UserPersonalizationActivity userPersonalizationActivity) {
        return (ThrottledOnExecuteAction) userPersonalizationActivity.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    public static final /* synthetic */ void access$showErrorState(UserPersonalizationActivity userPersonalizationActivity, boolean z) {
        UserPersonalizationView userPersonalizationView = (UserPersonalizationView) userPersonalizationActivity._$_findCachedViewById(R.id.view_user_personalization);
        if (userPersonalizationView != null) {
            userPersonalizationView.hideLoadingState();
        }
        View _$_findCachedViewById = userPersonalizationActivity._$_findCachedViewById(R.id.res_0x7f0a1b61_com_alibaba_ariver_engine_api_extopt_3);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(z ? 0 : 8);
        }
        UserPersonalizationView userPersonalizationView2 = (UserPersonalizationView) userPersonalizationActivity._$_findCachedViewById(R.id.view_user_personalization);
        if (userPersonalizationView2 != null) {
            userPersonalizationView2.setVisibility(z ^ true ? 0 : 8);
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) userPersonalizationActivity._$_findCachedViewById(R.id.c);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setVisibility(z ^ true ? 0 : 8);
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        DaggerUserPersonalizationComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerUserPersonalizationComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (UserPersonalizationModule) Preconditions.getAuthRequestContext(new UserPersonalizationModule(new UserPersonalizationContract.View() { // from class: id.dana.userpersonalization.UserPersonalizationActivity$getUserPersonalizationView$1
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

            @Override // id.dana.contract.userpersonalization.UserPersonalizationContract.View
            public final void getAuthRequestContext() {
                View _$_findCachedViewById = UserPersonalizationActivity.this._$_findCachedViewById(R.id.res_0x7f0a1b61_com_alibaba_ariver_engine_api_extopt_3);
                if (_$_findCachedViewById != null) {
                    _$_findCachedViewById.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(UserPersonalizationActivity.this, R.color.f27072131100488));
                }
                TextView textView = (TextView) UserPersonalizationActivity.this._$_findCachedViewById(R.id.res_0x7f0a1921_textviewkt_doaftertextchanged_inlined_addtextchangedlistener_default_1);
                if (textView != null) {
                    UserPersonalizationActivity userPersonalizationActivity = UserPersonalizationActivity.this;
                    textView.setText(userPersonalizationActivity.getString(R.string.personalization_error_title));
                    textView.setContentDescription(userPersonalizationActivity.getString(R.string.lblErrorTitle));
                }
                TextView textView2 = (TextView) UserPersonalizationActivity.this._$_findCachedViewById(R.id.tv_subtitle_empty_state);
                if (textView2 != null) {
                    UserPersonalizationActivity userPersonalizationActivity2 = UserPersonalizationActivity.this;
                    textView2.setText(userPersonalizationActivity2.getString(R.string.personalziation_error_subtitle));
                    textView2.setContentDescription(userPersonalizationActivity2.getString(R.string.lbl_error_description));
                }
                AppCompatImageView appCompatImageView = (AppCompatImageView) UserPersonalizationActivity.this._$_findCachedViewById(R.id.getCustomAttributesOrThrow);
                if (appCompatImageView != null) {
                    appCompatImageView.setContentDescription(UserPersonalizationActivity.this.getString(R.string.img_error));
                }
                UserPersonalizationActivity.access$showErrorState(UserPersonalizationActivity.this, true);
            }

            @Override // id.dana.contract.userpersonalization.UserPersonalizationContract.View
            public final void getAuthRequestContext(List<UserPersonalizationModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                UserPersonalizationActivity.access$showErrorState(UserPersonalizationActivity.this, false);
                UserPersonalizationView userPersonalizationView = (UserPersonalizationView) UserPersonalizationActivity.this._$_findCachedViewById(R.id.view_user_personalization);
                if (userPersonalizationView != null) {
                    userPersonalizationView.setUserPersonalizationList(p0);
                }
            }

            @Override // id.dana.contract.userpersonalization.UserPersonalizationContract.View
            public final void MyBillsEntityDataFactory() {
                UserPersonalizationActivity.access$getDanaLoadingDialog(UserPersonalizationActivity.this).PlaceComponentResult();
                ThrottledOnExecuteAction access$getThrottledOnExecuteAction = UserPersonalizationActivity.access$getThrottledOnExecuteAction(UserPersonalizationActivity.this);
                final UserPersonalizationActivity userPersonalizationActivity = UserPersonalizationActivity.this;
                access$getThrottledOnExecuteAction.KClassImpl$Data$declaredNonStaticMembers$2(112, new Function0<Unit>() { // from class: id.dana.userpersonalization.UserPersonalizationActivity$getUserPersonalizationView$1$showFailedToast$1
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
                        DANAToast dANAToast = DANAToast.PlaceComponentResult;
                        UserPersonalizationActivity userPersonalizationActivity2 = UserPersonalizationActivity.this;
                        UserPersonalizationActivity userPersonalizationActivity3 = userPersonalizationActivity2;
                        String string = userPersonalizationActivity2.getString(R.string.personalization_submit_failed);
                        Intrinsics.checkNotNullExpressionValue(string, "");
                        DANAToast.PlaceComponentResult(userPersonalizationActivity3, string);
                    }
                }, 2000L);
            }

            @Override // id.dana.contract.userpersonalization.UserPersonalizationContract.View
            public final void MyBillsEntityDataFactory(boolean p0) {
                UserPersonalizationActivity.this.PlaceComponentResult = p0;
                UserPersonalizationActivity.this.getUserPersonalizationTracker().getAuthRequestContext(p0 ? TrackerKey.SourceType.EXPLORE_FIRST_TIME : TrackerKey.SourceType.EXPLORE_WIDGET);
            }

            @Override // id.dana.contract.userpersonalization.UserPersonalizationContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                UserPersonalizationActivity.access$getDanaLoadingDialog(UserPersonalizationActivity.this).PlaceComponentResult();
                UserPersonalizationActivity.this.finish();
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, UserPersonalizationModule.class);
        if (KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext == null) {
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = new UserPersonalizationAnalyticModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerUserPersonalizationComponent.UserPersonalizationComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).MyBillsEntityDataFactory(this);
        KClassImpl$Data$declaredNonStaticMembers$2();
        UserPersonalizationContract.Presenter userPersonalizationPresenter = getUserPersonalizationPresenter();
        userPersonalizationPresenter.BuiltInFictitiousFunctionClassFactory();
        userPersonalizationPresenter.getAuthRequestContext();
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_try_again_empty_state);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.userpersonalization.UserPersonalizationActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserPersonalizationActivity.$r8$lambda$PPi0iaVa_8ufihx93rntyiyQ0Ps(UserPersonalizationActivity.this, view);
                }
            });
        }
        UserPersonalizationView userPersonalizationView = (UserPersonalizationView) _$_findCachedViewById(R.id.view_user_personalization);
        if (userPersonalizationView != null) {
            userPersonalizationView.setListener(this);
            userPersonalizationView.setUserPersonalizationItemListener(this.lookAheadTest);
        }
        ((DanaButtonPrimaryView) _$_findCachedViewById(R.id.c)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.userpersonalization.UserPersonalizationActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserPersonalizationActivity.m2994$r8$lambda$BeV5813Z91V7A7V5_M2YoKoA9Y(UserPersonalizationActivity.this, view);
            }
        });
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(this);
        builder.FragmentBottomSheetPaymentSettingBinding = getString(R.string.exit_personalization_dialog_title);
        builder.getErrorConfigVersion = getString(R.string.exit_personalization_dialog_subtitle);
        builder.initRecordTimeStamp = true;
        builder.PlaceComponentResult(true);
        builder.MyBillsEntityDataFactory(true);
        String string = getString(R.string.option_yes);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.userpersonalization.UserPersonalizationActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserPersonalizationActivity.m2993$r8$lambda$AzmorekGXEWUenZ8Bf8WLNyU5Y(UserPersonalizationActivity.this, view);
            }
        };
        builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
        String string2 = getString(R.string.option_no);
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.userpersonalization.UserPersonalizationActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserPersonalizationActivity.$r8$lambda$EWVzi2OhSzsakzkLzVaXeiHoUOY(UserPersonalizationActivity.this, view);
            }
        };
        builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = string2;
        builder.DatabaseTableConfigUtil = onClickListener2;
        String string3 = getString(R.string.lbl_confirmation_user_personal_title);
        String string4 = getString(R.string.lbl_confirmation_user_personal_description);
        builder.SubSequence = string3;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = string4;
        builder.PrepareContext = getString(R.string.btnYes);
        builder.GetContactSyncConfig = getString(R.string.btnNo);
        TwoButtonWithImageDialog KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        this.getAuthRequestContext = KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
    }

    private static void a(int[] iArr, int i, byte[] bArr, char[] cArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = initRecordTimeStamp;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        int i3 = (int) (4571606982258105150L ^ GetContactSyncConfig);
        if (newProxyInstance) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr4);
        } else if (DatabaseTableConfigUtil) {
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
