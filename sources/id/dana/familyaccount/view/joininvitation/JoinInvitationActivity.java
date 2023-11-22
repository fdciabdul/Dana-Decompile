package id.dana.familyaccount.view.joininvitation;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContractKt;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.challenge.ChallengeControl;
import id.dana.challenge.ChallengeScenario;
import id.dana.common.IntentKeySource;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.databinding.ActivityFamilyAccountJoinInvitationBinding;
import id.dana.databinding.LayoutToolbarBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerFamilyAccountJoinInvitationComponent;
import id.dana.di.modules.FamilyAccountJoinInvitationModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.familyaccount.constants.FamilyAccountInvitationStatusType;
import id.dana.familyaccount.contract.FamilyJoinInvitationContract;
import id.dana.familyaccount.di.FamilyAccountTrackerModule;
import id.dana.familyaccount.model.InvitationDecisionRequestModel;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;
import id.dana.familyaccount.view.intro.FamilyAccountIntroActivity;
import id.dana.familyaccount.view.joininvitation.InvalidJoinInvitationActivity;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.DANAToast;
import id.dana.utils.SizeUtil;
import id.dana.utils.TextUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.A;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b8\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\t\u0010\u0005J\r\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u0005J)\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0013\u0010\u0005J\r\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0015\u0010\u0005R\u0016\u0010\u0015\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010\u0017\u001a\u00020(8\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020+8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\"\u00100\u001a\u00020/8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u00107\u001a\u00020$8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b6\u0010&"}, d2 = {"Lid/dana/familyaccount/view/joininvitation/JoinInvitationActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityFamilyAccountJoinInvitationBinding;", "", "configToolbar", "()V", "inflateViewBinding", "()Lid/dana/databinding/ActivityFamilyAccountJoinInvitationBinding;", IAPSyncCommand.COMMAND_INIT, "initComponent", "initView", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onBackPressed", "onDestroy", "prepareBundle", "MyBillsEntityDataFactory", "Lid/dana/dialog/DanaLoadingDialog;", "getAuthRequestContext", "Lid/dana/dialog/DanaLoadingDialog;", "Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "familyAccountAnalyticalTracker", "Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "getFamilyAccountAnalyticalTracker", "()Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "setFamilyAccountAnalyticalTracker", "(Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;)V", "Lid/dana/familyaccount/model/InvitationDecisionRequestModel;", "lookAheadTest", "Lid/dana/familyaccount/model/InvitationDecisionRequestModel;", "BuiltInFictitiousFunctionClassFactory", "", "scheduleImpl", "Ljava/lang/String;", "PlaceComponentResult", "", "getErrorConfigVersion", "Z", "Lid/dana/di/modules/FamilyAccountJoinInvitationModule;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/di/modules/FamilyAccountJoinInvitationModule;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/familyaccount/contract/FamilyJoinInvitationContract$Presenter;", "joinInvitationPresenter", "Lid/dana/familyaccount/contract/FamilyJoinInvitationContract$Presenter;", "getJoinInvitationPresenter", "()Lid/dana/familyaccount/contract/FamilyJoinInvitationContract$Presenter;", "setJoinInvitationPresenter", "(Lid/dana/familyaccount/contract/FamilyJoinInvitationContract$Presenter;)V", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda0", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JoinInvitationActivity extends BaseViewBindingActivity<ActivityFamilyAccountJoinInvitationBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static int GetContactSyncConfig = 0;
    public static final String INVITATION_ID = "invitation_id";
    public static final String INVITATION_STATUS = "invitation_status";
    public static final String ORGANIZER_NAME = "organizer_name";
    @Inject
    public FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private DanaLoadingDialog MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda0;
    @Inject
    public FamilyJoinInvitationContract.Presenter joinInvitationPresenter;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private InvitationDecisionRequestModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private String PlaceComponentResult;
    public static final byte[] $$a = {8, 17, -121, -18, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 130;
    public static final byte[] PlaceComponentResult = {8, 17, -121, -18, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 228;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final FamilyAccountJoinInvitationModule KClassImpl$Data$declaredNonStaticMembers$2 = new FamilyAccountJoinInvitationModule(new FamilyJoinInvitationContract.View() { // from class: id.dana.familyaccount.view.joininvitation.JoinInvitationActivity$joinInvitationModule$1
        @Override // id.dana.base.AbstractContractKt.AbstractView
        public final /* synthetic */ String getErrorSource() {
            return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
        }

        @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
        public final /* synthetic */ void onError(String str) {
            AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
        }

        @Override // id.dana.familyaccount.contract.FamilyJoinInvitationContract.View
        public final void MyBillsEntityDataFactory(boolean p0) {
            JoinInvitationActivity.access$setUserPremium(JoinInvitationActivity.this, p0);
        }

        @Override // id.dana.familyaccount.contract.FamilyJoinInvitationContract.View
        public final void MyBillsEntityDataFactory() {
            JoinInvitationActivity.this.getFamilyAccountAnalyticalTracker().BuiltInFictitiousFunctionClassFactory(true);
            DANAToast dANAToast = DANAToast.PlaceComponentResult;
            JoinInvitationActivity joinInvitationActivity = JoinInvitationActivity.this;
            JoinInvitationActivity joinInvitationActivity2 = joinInvitationActivity;
            String string = joinInvitationActivity.getString(R.string.join_invitation_reject_success_message);
            Intrinsics.checkNotNullExpressionValue(string, "");
            DANAToast.getAuthRequestContext(joinInvitationActivity2, string);
            Bundle bundle = new Bundle();
            JoinInvitationActivity joinInvitationActivity3 = JoinInvitationActivity.this;
            bundle.putBoolean(IntentKeySource.FamilyAccountKey.ON_INVITATION_REJECTED, true);
            JoinInvitationActivity.access$backToHomepage(joinInvitationActivity3, bundle);
        }

        @Override // id.dana.familyaccount.contract.FamilyJoinInvitationContract.View
        public final void getAuthRequestContext() {
            JoinInvitationActivity.showErrorToastInvitation$default(JoinInvitationActivity.this, null, false, true, 3, null);
        }

        @Override // id.dana.familyaccount.contract.FamilyJoinInvitationContract.View
        public final void PlaceComponentResult() {
            JoinInvitationActivity.this.MyBillsEntityDataFactory();
        }

        @Override // id.dana.familyaccount.contract.FamilyJoinInvitationContract.View
        public final void BuiltInFictitiousFunctionClassFactory() {
            JoinInvitationActivity.showErrorToastInvitation$default(JoinInvitationActivity.this, null, true, false, 5, null);
        }

        @Override // id.dana.familyaccount.contract.FamilyJoinInvitationContract.View
        public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
            Intrinsics.checkNotNullParameter(p1, "");
            JoinInvitationActivity.access$startPinChallenge(JoinInvitationActivity.this, p0, p1);
        }

        @Override // id.dana.familyaccount.contract.FamilyJoinInvitationContract.View
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            JoinInvitationActivity.access$goToInvalidInvitationPage(JoinInvitationActivity.this);
        }

        @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
        public final void showProgress() {
            JoinInvitationActivity.access$showDanaLoading(JoinInvitationActivity.this);
        }

        @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
        public final void dismissProgress() {
            JoinInvitationActivity.access$dismissDanaLoading(JoinInvitationActivity.this);
        }
    });

    public static /* synthetic */ void $r8$lambda$Kcunzymg4LiU6h_dYzDnctOLbWw(View view) {
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        GetContactSyncConfig = 269894754;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 + 97
            byte[] r0 = id.dana.familyaccount.view.joininvitation.JoinInvitationActivity.PlaceComponentResult
            int r9 = 23 - r9
            int r7 = r7 + 4
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L14
            r8 = r7
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L2e
        L14:
            r3 = 0
        L15:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L24:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L2e:
            int r9 = r9 + r7
            int r7 = r9 + (-4)
            int r8 = r8 + 1
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r8
            r8 = r7
            r7 = r6
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.joininvitation.JoinInvitationActivity.a(byte, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 4
            int r8 = r8 * 2
            int r8 = 103 - r8
            int r6 = r6 * 3
            int r6 = r6 + 21
            byte[] r0 = id.dana.familyaccount.view.joininvitation.JoinInvitationActivity.$$a
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r8
            r4 = 0
            r8 = r7
            goto L2c
        L17:
            r3 = 0
            r5 = r8
            r8 = r7
            r7 = r5
        L1b:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r3 = r0[r8]
        L2c:
            int r7 = r7 + r3
            int r7 = r7 + (-7)
            int r8 = r8 + 1
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.joininvitation.JoinInvitationActivity.c(short, byte, int, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final Intent createJoinInvitationIntent(Context context, String str, String str2) {
        return Companion.MyBillsEntityDataFactory(context, str, str2);
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
        b(false, 170 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 4, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 17, new char[]{'\f', 0, 2, 16, 16, 65534, 11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65517, 15}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(false, 175 - View.combineMeasuredStates(0, 0), 2 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), ExpandableListView.getPackedPositionGroup(0L) + 5, new char[]{1, 65532, 5, 17, 65517}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 35 - (ViewConfiguration.getEdgeSlop() >> 16), (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(false, 142 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 11, 48 - (ViewConfiguration.getTapTimeout() >> 16), new char[]{65522, 65521, 65513, 65520, 31, 65517, 65519, 27, 65516, 65519, 30, 65520, 28, 65519, 65521, 65513, 29, 65522, 65521, 65520, 30, 28, 31, 30, 65515, 65514, 65519, 65514, 65514, 65519, JSONLexer.EOI, 29, 28, 28, 65519, 29, 65516, 65521, 29, 65515, 29, JSONLexer.EOI, 30, 65522, 65519, 65515, 65522, 31}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(true, 137 - View.resolveSize(0, 0), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 2, AndroidCharacter.getMirror('0') + 16, new char[]{65523, 31, 65521, Typography.quote, 65526, 65519, InputCardNumberView.DIVIDER, '!', 65519, 65518, 65519, 65518, 65525, 65527, 65527, 65525, 65521, 65521, 65525, 65519, 65525, '!', 65519, '#', 65518, 65523, 65521, 65518, '!', '!', 65526, 65522, Typography.quote, '!', 65520, 65520, Typography.quote, 65526, '#', 65527, InputCardNumberView.DIVIDER, 65524, 65521, 65524, 65519, Typography.quote, 65519, Typography.dollar, 65520, 65520, 65522, 65519, 65519, Typography.quote, 65523, 65527, '!', Typography.quote, 65526, 65518, 65527, Typography.dollar, Typography.quote, 65524}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(true, 138 - Process.getGidForName(""), (Process.myPid() >> 22) + 11, 64 - (ViewConfiguration.getLongPressTimeout() >> 16), new char[]{65524, 65524, 65524, 65520, 65518, 65523, 65525, 30, '!', 65517, 65518, 65525, 65521, 65521, Typography.quote, 65522, 65525, 65521, 65523, 65521, Typography.quote, 65517, 65518, '!', 31, 65525, Typography.quote, 30, 29, 65516, 65524, 65520, 65517, Typography.quote, 65524, 65524, 65522, 65523, 30, 65524, 65518, InputCardNumberView.DIVIDER, 65523, 31, 65523, Typography.quote, Typography.quote, 65524, 65525, Typography.quote, 65523, 65519, 29, 30, 65518, InputCardNumberView.DIVIDER, 65520, '!', 29, 65523, 65516, 65519, 65517, 65517}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(false, 167 - MotionEvent.axisFromString(""), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 45, TextUtils.indexOf((CharSequence) "", '0') + 61, new char[]{17, 4, 0, 19, 2, 0, 18, 19, 65485, 6, 20, 0, 17, 3, 18, 16, 20, 0, 17, 4, 65485, 2, 14, '\f', 65486, 0, 15, '\b', 65486, '\b', '\r', 6, 4, 18, 19, 65486, 21, 65489, 65486, 4, 21, 4, '\r', 19, 18, 7, 19, 19, 15, 18, 65497, 65486, 65486, 3, 0, '\r', 0, 65485, 19, 7}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(false, 121 - (ViewConfiguration.getPressedStateDuration() >> 16), 4 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 6 - (ViewConfiguration.getScrollBarSize() >> 8), new char[]{65532, 0, 65535, 7, 65532, 2}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 18, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a((byte) 37, PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(PlaceComponentResult[35], PlaceComponentResult[0], (byte) (-PlaceComponentResult[30]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 55, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 2, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))));
                        byte b = $$a[78];
                        Object[] objArr16 = new Object[1];
                        c(b, (byte) (b - 1), $$a[12], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.MeasureSpec.getMode(0), KeyEvent.normalizeMetaState(0) + 15, (char) View.combineMeasuredStates(0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 800, 16 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 29 - ExpandableListView.getPackedPositionGroup(0L), (char) (57993 - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, Color.rgb(0, 0, 0) + 16777231, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r11 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 35 - Gravity.getAbsoluteGravity(0, 0), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1072038837, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 18 - TextUtils.getCapsMode("", 0, 0), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) 37, PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                a(PlaceComponentResult[35], PlaceComponentResult[0], (byte) (-PlaceComponentResult[30]), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 61, 47 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) View.combineMeasuredStates(0, 0));
                        byte b2 = (byte) ($$a[78] - 1);
                        Object[] objArr22 = new Object[1];
                        c(b2, (byte) (b2 | Ascii.ETB), (byte) ($$a[78] - 1), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 930, TextUtils.getOffsetBefore("", 0) + 35, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-1072038837, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 912, 17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) 37, PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                a(PlaceComponentResult[35], PlaceComponentResult[0], (byte) (-PlaceComponentResult[30]), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 119, View.MeasureSpec.makeMeasureSpec(0, 0) + 3, (char) (38968 - Gravity.getAbsoluteGravity(0, 0)));
                        byte b3 = (byte) ($$a[78] - 1);
                        Object[] objArr28 = new Object[1];
                        c(b3, (byte) (b3 | Ascii.ETB), (byte) ($$a[78] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - MotionEvent.axisFromString(""), TextUtils.indexOf((CharSequence) "", '0', 0) + 36, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1072038837, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 912, 17 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (Process.myTid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) 37, PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                a(PlaceComponentResult[35], PlaceComponentResult[0], (byte) (-PlaceComponentResult[30]), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + 107, 3 - KeyEvent.normalizeMetaState(0), (char) View.resolveSize(0, 0));
                        Object[] objArr34 = new Object[1];
                        c($$a[8], $$a[53], $$a[9], objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 35, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-1072038837, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 911, 18 - TextUtils.indexOf("", ""), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        Object[] objArr = new Object[1];
        b(false, super.getResources().getString(R.string.merchant_title).substring(6, 7).length() + 169, 6 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), getPackageName().codePointAt(6) - 79, new char[]{'\f', 0, 2, 16, 16, 65534, 11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65517, 15}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        int length = super.getResources().getString(R.string.twilio_failed_dialog_description).substring(16, 17).length() + 174;
        try {
            byte b = PlaceComponentResult[25];
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            Class<?> cls2 = Class.forName((String) objArr2[0]);
            a((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], new Object[1]);
            Object[] objArr3 = new Object[1];
            b(false, length, ((ApplicationInfo) cls2.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 31, getPackageName().codePointAt(1) - 95, new char[]{1, 65532, 5, 17, 65517}, objArr3);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr4 = new Object[1];
                    b(true, super.getResources().getString(R.string.desc_update_saldo_third).substring(28, 29).length() + 169, super.getResources().getString(R.string.your_account_is_on_hold).substring(2, 3).length() + 10, 25 - ExpandableListView.getPackedPositionChild(0L), new char[]{'\r', '\r', 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483}, objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    try {
                        byte b3 = PlaceComponentResult[25];
                        byte b4 = b3;
                        Object[] objArr5 = new Object[1];
                        a(b3, b4, b4, objArr5);
                        Class<?> cls4 = Class.forName((String) objArr5[0]);
                        Object[] objArr6 = new Object[1];
                        a((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], objArr6);
                        Object[] objArr7 = new Object[1];
                        b(false, ((ApplicationInfo) cls4.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 144, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 12, getPackageName().codePointAt(1) - 82, new char[]{4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531}, objArr7);
                        baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0'), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 35, (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        int codePointAt = getPackageName().codePointAt(5) + 32;
                        try {
                            byte b5 = PlaceComponentResult[25];
                            byte b6 = b5;
                            Object[] objArr8 = new Object[1];
                            a(b5, b6, b6, objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            Object[] objArr9 = new Object[1];
                            a((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], objArr9);
                            int i = ((ApplicationInfo) cls5.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion - 22;
                            try {
                                byte b7 = PlaceComponentResult[25];
                                byte b8 = b7;
                                Object[] objArr10 = new Object[1];
                                a(b7, b8, b8, objArr10);
                                Class<?> cls6 = Class.forName((String) objArr10[0]);
                                Object[] objArr11 = new Object[1];
                                a((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], objArr11);
                                Object[] objArr12 = new Object[1];
                                b(false, codePointAt, i, ((ApplicationInfo) cls6.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 15, new char[]{65522, 65521, 65513, 65520, 31, 65517, 65519, 27, 65516, 65519, 30, 65520, 28, 65519, 65521, 65513, 29, 65522, 65521, 65520, 30, 28, 31, 30, 65515, 65514, 65519, 65514, 65514, 65519, JSONLexer.EOI, 29, 28, 28, 65519, 29, 65516, 65521, 29, 65515, 29, JSONLexer.EOI, 30, 65522, 65519, 65515, 65522, 31}, objArr12);
                                String str = (String) objArr12[0];
                                try {
                                    byte b9 = PlaceComponentResult[25];
                                    byte b10 = b9;
                                    Object[] objArr13 = new Object[1];
                                    a(b9, b10, b10, objArr13);
                                    Class<?> cls7 = Class.forName((String) objArr13[0]);
                                    Object[] objArr14 = new Object[1];
                                    a((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], objArr14);
                                    int i2 = ((ApplicationInfo) cls7.getMethod((String) objArr14[0], null).invoke(this, null)).targetSdkVersion + 104;
                                    int codePointAt2 = super.getResources().getString(R.string.transfer_account_understood).substring(6, 7).codePointAt(0) - 114;
                                    try {
                                        byte b11 = PlaceComponentResult[25];
                                        byte b12 = b11;
                                        Object[] objArr15 = new Object[1];
                                        a(b11, b12, b12, objArr15);
                                        Class<?> cls8 = Class.forName((String) objArr15[0]);
                                        Object[] objArr16 = new Object[1];
                                        a((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], objArr16);
                                        Object[] objArr17 = new Object[1];
                                        b(true, i2, codePointAt2, ((ApplicationInfo) cls8.getMethod((String) objArr16[0], null).invoke(this, null)).targetSdkVersion + 31, new char[]{65523, 31, 65521, Typography.quote, 65526, 65519, InputCardNumberView.DIVIDER, '!', 65519, 65518, 65519, 65518, 65525, 65527, 65527, 65525, 65521, 65521, 65525, 65519, 65525, '!', 65519, '#', 65518, 65523, 65521, 65518, '!', '!', 65526, 65522, Typography.quote, '!', 65520, 65520, Typography.quote, 65526, '#', 65527, InputCardNumberView.DIVIDER, 65524, 65521, 65524, 65519, Typography.quote, 65519, Typography.dollar, 65520, 65520, 65522, 65519, 65519, Typography.quote, 65523, 65527, '!', Typography.quote, 65526, 65518, 65527, Typography.dollar, Typography.quote, 65524}, objArr17);
                                        String str2 = (String) objArr17[0];
                                        Object[] objArr18 = new Object[1];
                                        b(true, getPackageName().length() + 132, super.getResources().getString(R.string.mybills_tooltip_add_to_my_bills).substring(0, 110).codePointAt(59) - 98, super.getResources().getString(R.string.deals_subtitle_text).substring(0, 1).codePointAt(0) - 2, new char[]{65524, 65524, 65524, 65520, 65518, 65523, 65525, 30, '!', 65517, 65518, 65525, 65521, 65521, Typography.quote, 65522, 65525, 65521, 65523, 65521, Typography.quote, 65517, 65518, '!', 31, 65525, Typography.quote, 30, 29, 65516, 65524, 65520, 65517, Typography.quote, 65524, 65524, 65522, 65523, 30, 65524, 65518, InputCardNumberView.DIVIDER, 65523, 31, 65523, Typography.quote, Typography.quote, 65524, 65525, Typography.quote, 65523, 65519, 29, 30, 65518, InputCardNumberView.DIVIDER, 65520, '!', 29, 65523, 65516, 65519, 65517, 65517}, objArr18);
                                        String str3 = (String) objArr18[0];
                                        try {
                                            byte b13 = PlaceComponentResult[25];
                                            byte b14 = b13;
                                            Object[] objArr19 = new Object[1];
                                            a(b13, b14, b14, objArr19);
                                            Class<?> cls9 = Class.forName((String) objArr19[0]);
                                            Object[] objArr20 = new Object[1];
                                            a((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], objArr20);
                                            int i3 = ((ApplicationInfo) cls9.getMethod((String) objArr20[0], null).invoke(this, null)).targetSdkVersion + 135;
                                            try {
                                                byte b15 = PlaceComponentResult[25];
                                                byte b16 = b15;
                                                Object[] objArr21 = new Object[1];
                                                a(b15, b16, b16, objArr21);
                                                Class<?> cls10 = Class.forName((String) objArr21[0]);
                                                Object[] objArr22 = new Object[1];
                                                a((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], objArr22);
                                                Object[] objArr23 = new Object[1];
                                                b(false, i3, ((ApplicationInfo) cls10.getMethod((String) objArr22[0], null).invoke(this, null)).targetSdkVersion + 12, super.getResources().getString(R.string.desc_card_unsupported).substring(48, 50).length() + 58, new char[]{17, 4, 0, 19, 2, 0, 18, 19, 65485, 6, 20, 0, 17, 3, 18, 16, 20, 0, 17, 4, 65485, 2, 14, '\f', 65486, 0, 15, '\b', 65486, '\b', '\r', 6, 4, 18, 19, 65486, 21, 65489, 65486, 4, 21, 4, '\r', 19, 18, 7, 19, 19, 15, 18, 65497, 65486, 65486, 3, 0, '\r', 0, 65485, 19, 7}, objArr23);
                                                String str4 = (String) objArr23[0];
                                                Object[] objArr24 = new Object[1];
                                                b(false, 121 - TextUtils.indexOf("", "", 0), super.getResources().getString(R.string.twilio_bottomsheet_countdown_timer).substring(6, 7).codePointAt(0) - 100, getPackageName().codePointAt(5) - 104, new char[]{65532, 0, 65535, 7, 65532, 2}, objArr24);
                                                try {
                                                    Object[] objArr25 = {baseContext, str, str2, str3, str4, true, (String) objArr24[0], 995651014};
                                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                                    if (obj2 == null) {
                                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 911, 19 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                                    }
                                                    ((Method) obj2).invoke(invoke, objArr25);
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
                    } catch (Throwable th9) {
                        Throwable cause9 = th9.getCause();
                        if (cause9 == null) {
                            throw th9;
                        }
                        throw cause9;
                    }
                }
            }
            try {
                Object[] objArr26 = new Object[1];
                a((byte) 37, PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), objArr26);
                Class<?> cls11 = Class.forName((String) objArr26[0]);
                Object[] objArr27 = new Object[1];
                a(PlaceComponentResult[35], PlaceComponentResult[0], (byte) (-PlaceComponentResult[30]), objArr27);
                try {
                    Object[] objArr28 = {Integer.valueOf(((Integer) cls11.getMethod((String) objArr27[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls12 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - ExpandableListView.getPackedPositionChild(0L), 4 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                        Object[] objArr29 = new Object[1];
                        c($$a[8], $$a[53], $$a[9], objArr29);
                        obj3 = cls12.getMethod((String) objArr29[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr30 = (Object[]) ((Method) obj3).invoke(null, objArr28);
                    int i4 = ((int[]) objArr30[1])[0];
                    if (((int[]) objArr30[0])[0] != i4) {
                        long j = ((r0 ^ i4) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 930, 35 - Gravity.getAbsoluteGravity(0, 0), (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(null, null);
                            try {
                                Object[] objArr31 = {-577272352, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 912, 18 - View.combineMeasuredStates(0, 0), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr31);
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
                    super.onCreate(bundle);
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
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 171;
            try {
                byte b = PlaceComponentResult[25];
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(true, bitsPerPixel, ((ApplicationInfo) cls.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 22, getPackageName().length() + 19, new char[]{'\r', '\r', 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                int codePointAt = super.getResources().getString(R.string.withdraw_cash_for_myself).substring(17, 18).codePointAt(0) + 145;
                try {
                    byte b3 = PlaceComponentResult[25];
                    byte b4 = b3;
                    Object[] objArr3 = new Object[1];
                    a(b3, b4, b4, objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    a((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    b(false, codePointAt, ((ApplicationInfo) cls3.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 20, 19 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), new char[]{4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531}, objArr4);
                    baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.argb(0, 0, 0, 0), 34 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ((byte) KeyEvent.getModifierMetaStateMask()), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 17, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(true, 170 - View.combineMeasuredStates(0, 0), getPackageName().length() + 4, 26 - TextUtils.getTrimmedLength(""), new char[]{'\r', '\r', 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                byte b = PlaceComponentResult[25];
                byte b2 = b;
                Object[] objArr2 = new Object[1];
                a(b, b2, b2, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                a((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], objArr3);
                Object[] objArr4 = new Object[1];
                b(false, ((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 144, super.getResources().getString(R.string.location_permission_prompt_home_desc).substring(15, 17).codePointAt(1) - 103, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, new char[]{4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531}, objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.keyCodeFromString(""), (ViewConfiguration.getPressedStateDuration() >> 16) + 18, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
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
        super.onResume();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public JoinInvitationActivity() {
        ?? r1 = 0;
        this.BuiltInFictitiousFunctionClassFactory = new InvitationDecisionRequestModel(r1, r1, 3, r1);
    }

    @JvmName(name = "getJoinInvitationPresenter")
    public final FamilyJoinInvitationContract.Presenter getJoinInvitationPresenter() {
        FamilyJoinInvitationContract.Presenter presenter = this.joinInvitationPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setJoinInvitationPresenter")
    public final void setJoinInvitationPresenter(FamilyJoinInvitationContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.joinInvitationPresenter = presenter;
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

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityFamilyAccountJoinInvitationBinding inflateViewBinding() {
        ActivityFamilyAccountJoinInvitationBinding PlaceComponentResult2 = ActivityFamilyAccountJoinInvitationBinding.PlaceComponentResult(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        return PlaceComponentResult2;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        prepareBundle();
        initView();
        getBinding().moveToNextValue.initInvitationView();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        DaggerFamilyAccountJoinInvitationComponent.Builder MyBillsEntityDataFactory = DaggerFamilyAccountJoinInvitationComponent.MyBillsEntityDataFactory();
        Application application = getApplication();
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        MyBillsEntityDataFactory.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) application).getApplicationComponent());
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (FamilyAccountJoinInvitationModule) Preconditions.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, FamilyAccountJoinInvitationModule.class);
        if (MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = new FamilyAccountTrackerModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.getAuthRequestContext, ApplicationComponent.class);
        new DaggerFamilyAccountJoinInvitationComponent.FamilyAccountJoinInvitationComponentImpl(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.getAuthRequestContext, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
        getJoinInvitationPresenter().getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory() {
        getFamilyAccountAnalyticalTracker().KClassImpl$Data$declaredNonStaticMembers$2(true);
        Intent intent = new Intent(this, SuccessJoinInvitationActivity.class);
        setResult(0);
        finish();
        startActivity(intent);
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        setResult(0);
        finish();
    }

    public final void prepareBundle() {
        String stringExtra = getIntent().getStringExtra("organizer_name");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("invitation_status");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.PlaceComponentResult = stringExtra2;
        InvitationDecisionRequestModel invitationDecisionRequestModel = this.BuiltInFictitiousFunctionClassFactory;
        String stringExtra3 = getIntent().getStringExtra("invitation_id");
        invitationDecisionRequestModel.PlaceComponentResult = stringExtra3 != null ? stringExtra3 : "";
    }

    public final void initView() {
        JoinInvitationView joinInvitationView = getBinding().moveToNextValue;
        String str = this.PlaceComponentResult;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        String str3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            str2 = str3;
        }
        joinInvitationView.setInvitationStatusType(str, str2);
        getBinding().getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.joininvitation.JoinInvitationActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JoinInvitationActivity.m2599$r8$lambda$svO5AZOORbXIX3V9XfL_1tGTM(JoinInvitationActivity.this, view);
            }
        });
        getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.joininvitation.JoinInvitationActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JoinInvitationActivity.$r8$lambda$EDtviOzXRM3VvWpCMzGZVZNwiYg(JoinInvitationActivity.this, view);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle extras;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1011) {
            if (resultCode == -1) {
                MyBillsEntityDataFactory();
            } else if (resultCode == 0) {
                String string = (data == null || (extras = data.getExtras()) == null) ? null : extras.getString(ChallengeControl.Key.CANCEL_REASON);
                if (Intrinsics.areEqual(string, "back") || Intrinsics.areEqual(string, "close")) {
                    return;
                }
                showErrorToastInvitation$default(this, string, true, false, 4, null);
            }
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        getJoinInvitationPresenter().onDestroy();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000b"}, d2 = {"Lid/dana/familyaccount/view/joininvitation/JoinInvitationActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "p2", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "INVITATION_ID", "Ljava/lang/String;", "INVITATION_STATUS", "ORGANIZER_NAME", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
            Intent intent = new Intent(p0, JoinInvitationActivity.class);
            intent.putExtra("organizer_name", p1);
            intent.putExtra("invitation_id", p2);
            intent.putExtra("invitation_status", "PENDING");
            return intent;
        }
    }

    public static /* synthetic */ void $r8$lambda$EDtviOzXRM3VvWpCMzGZVZNwiYg(JoinInvitationActivity joinInvitationActivity, View view) {
        Intrinsics.checkNotNullParameter(joinInvitationActivity, "");
        joinInvitationActivity.getJoinInvitationPresenter().PlaceComponentResult(joinInvitationActivity.BuiltInFictitiousFunctionClassFactory);
    }

    public static /* synthetic */ void $r8$lambda$VTXeJBNrJNbFyo4vHIMQV7HcCvk(JoinInvitationActivity joinInvitationActivity, View view) {
        Intrinsics.checkNotNullParameter(joinInvitationActivity, "");
        JoinInvitationActivity joinInvitationActivity2 = joinInvitationActivity;
        new Intent(joinInvitationActivity2, FamilyAccountIntroActivity.class).setFlags(268468224);
        joinInvitationActivity.startActivity(new Intent(joinInvitationActivity2, FamilyAccountIntroActivity.class));
    }

    /* renamed from: $r8$lambda$h3V9c0EfPU9_N4dEF6-dkJWTo0c  reason: not valid java name */
    public static /* synthetic */ void m2598$r8$lambda$h3V9c0EfPU9_N4dEF6dkJWTo0c(JoinInvitationActivity joinInvitationActivity, View view) {
        Intrinsics.checkNotNullParameter(joinInvitationActivity, "");
        joinInvitationActivity.getOnBackPressedDispatcher().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* renamed from: $r8$lambda$svO5AZOORbXI-X3V-9XfL_1tGTM  reason: not valid java name */
    public static /* synthetic */ void m2599$r8$lambda$svO5AZOORbXIX3V9XfL_1tGTM(JoinInvitationActivity joinInvitationActivity, View view) {
        Intrinsics.checkNotNullParameter(joinInvitationActivity, "");
        joinInvitationActivity.getJoinInvitationPresenter().KClassImpl$Data$declaredNonStaticMembers$2(joinInvitationActivity.BuiltInFictitiousFunctionClassFactory);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.os.Bundle, kotlin.jvm.internal.DefaultConstructorMarker] */
    public static final /* synthetic */ void access$backToHomepage(JoinInvitationActivity joinInvitationActivity, Bundle bundle) {
        ?? r1 = 0;
        EventBus.getDefault().post(new HomeTabActivity.FinishSubActivitiesMessageEvent(r1, 1, r1));
        EventBus.getDefault().post(new HomeTabActivity.OnBackToHomepageMessageEvent(bundle));
        EventBus.getDefault().post(new BaseViewBindingActivity.FinishSubActivitiesMessageEvent());
    }

    public static final /* synthetic */ void access$dismissDanaLoading(JoinInvitationActivity joinInvitationActivity) {
        DanaLoadingDialog danaLoadingDialog = joinInvitationActivity.MyBillsEntityDataFactory;
        if (danaLoadingDialog != null) {
            if (danaLoadingDialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                danaLoadingDialog = null;
            }
            danaLoadingDialog.PlaceComponentResult();
        }
    }

    public static final /* synthetic */ void access$goToInvalidInvitationPage(JoinInvitationActivity joinInvitationActivity) {
        joinInvitationActivity.finish();
        InvalidJoinInvitationActivity.Companion companion = InvalidJoinInvitationActivity.INSTANCE;
        Context baseContext = joinInvitationActivity.getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "");
        String str = joinInvitationActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        joinInvitationActivity.startActivity(InvalidJoinInvitationActivity.Companion.MyBillsEntityDataFactory(baseContext, FamilyAccountInvitationStatusType.ABORT, str));
    }

    public static final /* synthetic */ void access$setUserPremium(final JoinInvitationActivity joinInvitationActivity, boolean z) {
        joinInvitationActivity.getAuthRequestContext = z;
        if (z) {
            TextView textView = joinInvitationActivity.getBinding().BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(0);
            int BuiltInFictitiousFunctionClassFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(joinInvitationActivity, R.color.f22912131099753);
            String string = joinInvitationActivity.getString(R.string.join_invitation_text_create_family_account);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String string2 = joinInvitationActivity.getString(R.string.join_invitation_text_create_family_account_bold_colored);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            TextUtil.getAuthRequestContext(textView, new ClickableSpan() { // from class: id.dana.familyaccount.view.joininvitation.JoinInvitationActivity$setClickableTextWithColor$1
                @Override // android.text.style.ClickableSpan
                public final void onClick(View p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    JoinInvitationActivity.access$showCreateFamilyAccountDialog(JoinInvitationActivity.this);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(TextPaint p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    p0.setUnderlineText(false);
                }
            }, BuiltInFictitiousFunctionClassFactory, string, string2);
            ViewGroup.LayoutParams layoutParams = joinInvitationActivity.getBinding().MyBillsEntityDataFactory.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.setMargins(0, 0, 0, SizeUtil.getAuthRequestContext(joinInvitationActivity.getResources().getDimensionPixelSize(R.dimen.MyBillsEntityDataFactory_res_0x7f07005f)));
                joinInvitationActivity.getBinding().MyBillsEntityDataFactory.setLayoutParams(layoutParams2);
            }
        }
    }

    public static final /* synthetic */ void access$showCreateFamilyAccountDialog(final JoinInvitationActivity joinInvitationActivity) {
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(joinInvitationActivity);
        builder.FragmentBottomSheetPaymentSettingBinding = joinInvitationActivity.getString(R.string.join_invitation_create_account_dialog_title);
        Object[] objArr = new Object[1];
        String str = joinInvitationActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        objArr[0] = str;
        builder.getErrorConfigVersion = joinInvitationActivity.getString(R.string.join_invitation_create_account_dialog_desc, objArr);
        builder.getAuthRequestContext = R.color.f27072131100488;
        TwoButtonWithImageDialog.Builder MyBillsEntityDataFactory = builder.PlaceComponentResult(false).MyBillsEntityDataFactory(false);
        String string = joinInvitationActivity.getString(R.string.join_invitation_create_account_dialog_positive_button);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.familyaccount.view.joininvitation.JoinInvitationActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JoinInvitationActivity.$r8$lambda$VTXeJBNrJNbFyo4vHIMQV7HcCvk(JoinInvitationActivity.this, view);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
        String string2 = joinInvitationActivity.getString(R.string.later);
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.familyaccount.view.joininvitation.JoinInvitationActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JoinInvitationActivity.$r8$lambda$Kcunzymg4LiU6h_dYzDnctOLbWw(view);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = string2;
        MyBillsEntityDataFactory.DatabaseTableConfigUtil = onClickListener2;
        MyBillsEntityDataFactory.initRecordTimeStamp = true;
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory();
    }

    public static final /* synthetic */ void access$showDanaLoading(JoinInvitationActivity joinInvitationActivity) {
        if (joinInvitationActivity.MyBillsEntityDataFactory == null) {
            joinInvitationActivity.MyBillsEntityDataFactory = new DanaLoadingDialog(joinInvitationActivity);
        }
        DanaLoadingDialog danaLoadingDialog = joinInvitationActivity.MyBillsEntityDataFactory;
        if (danaLoadingDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danaLoadingDialog = null;
        }
        if (danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
            return;
        }
        danaLoadingDialog.MyBillsEntityDataFactory.show();
        danaLoadingDialog.getAuthRequestContext.startRefresh();
    }

    public static final /* synthetic */ void access$startPinChallenge(JoinInvitationActivity joinInvitationActivity, String str, String str2) {
        ChallengeControl.Builder builder = new ChallengeControl.Builder(joinInvitationActivity);
        builder.scheduleImpl = ChallengeScenario.JOIN_INVITATION_FAMILY_ACCOUNT;
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = "family_account";
        if (str == null) {
            str = "";
        }
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str, "");
        builder.E = str2;
        builder.PrepareContext = str;
        new ChallengeControl(builder, null).getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void showErrorToastInvitation$default(JoinInvitationActivity joinInvitationActivity, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        if (z) {
            joinInvitationActivity.getFamilyAccountAnalyticalTracker().KClassImpl$Data$declaredNonStaticMembers$2(false);
        }
        if (z2) {
            joinInvitationActivity.getFamilyAccountAnalyticalTracker().BuiltInFictitiousFunctionClassFactory(false);
        }
        DANAToast dANAToast = DANAToast.PlaceComponentResult;
        JoinInvitationActivity joinInvitationActivity2 = joinInvitationActivity;
        if (str == null) {
            str = joinInvitationActivity.getString(R.string.join_invitation_error_join_message);
            Intrinsics.checkNotNullExpressionValue(str, "");
        }
        DANAToast.PlaceComponentResult(joinInvitationActivity2, str);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        LayoutToolbarBinding layoutToolbarBinding = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        TextView textView = layoutToolbarBinding.initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
        ImageView imageView = layoutToolbarBinding.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(8);
        layoutToolbarBinding.initRecordTimeStamp.setText(getString(R.string.join_invitation_title_toolbar));
        LayoutToolbarBinding layoutToolbarBinding2 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationIcon(R.drawable.btn_arrow_left);
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.joininvitation.JoinInvitationActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JoinInvitationActivity.m2598$r8$lambda$h3V9c0EfPU9_N4dEF6dkJWTo0c(JoinInvitationActivity.this, view);
            }
        });
        Toolbar toolbar = layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        for (View view : ViewGroupKt.BuiltInFictitiousFunctionClassFactory(toolbar)) {
            ImageButton imageButton = view instanceof ImageButton ? (ImageButton) view : null;
            if (imageButton != null) {
                imageButton.setContentDescription(getResources().getString(R.string.imgBtnLeft));
            }
        }
        TextView textView2 = layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(textView2, "");
        textView2.setVisibility(4);
    }

    private static void b(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i3];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i3) {
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (GetContactSyncConfig ^ (-5694784870793460699L))));
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
