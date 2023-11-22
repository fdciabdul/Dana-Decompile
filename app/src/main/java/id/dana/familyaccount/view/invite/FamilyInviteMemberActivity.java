package id.dana.familyaccount.view.invite;

import android.app.Application;
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
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import androidx.view.LifecycleOwnerKt;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.material.textfield.TextInputLayout;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.challenge.ChallengeControl;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.edittextcomponent.DanaEditTextView;
import id.dana.contract.contact.DanaContactContract;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.databinding.ActivityFamilyAccountInviteMemberBinding;
import id.dana.databinding.FamilyQuestionerViewBinding;
import id.dana.databinding.LayoutToolbarBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerFamilyAccountInvitationComponent;
import id.dana.di.modules.DanaContactModule;
import id.dana.di.modules.FamilyAccountInvitationModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.familyaccount.model.QuestionnaireDataConfig;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import id.dana.extension.view.InputExtKt;
import id.dana.familyaccount.contract.FamilyInvitationContract;
import id.dana.familyaccount.model.FamilyMemberInfoModel;
import id.dana.familyaccount.model.InviteMemberModel;
import id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity;
import id.dana.familyaccount.view.invite.FamilyMembersPickerView;
import id.dana.familyaccount.view.invite.FamilyTncConsentActivity;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.scanner.ScannerActivity;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.utils.DANAToast;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b?\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0019\u0010\t\u001a\u000e\u0012\b\u0012\u0006*\u00020\b0\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0011\u0010\u0005J\u0015\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0003H\u0014¢\u0006\u0004\b \u0010\u0005J\r\u0010!\u001a\u00020\u0003¢\u0006\u0004\b!\u0010\u0005J\u0019\u0010#\u001a\u00020\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0003H\u0002¢\u0006\u0004\b%\u0010\u0005J\u000f\u0010&\u001a\u00020\u0003H\u0002¢\u0006\u0004\b&\u0010\u0005R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010(R\u0018\u0010\u0017\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R!\u00102\u001a\f\u0012\b\u0012\u0006*\u00020\u001c0\u001c0-8\u0007¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\"\u00104\u001a\u0002038\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010&\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010;R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0'8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b>\u0010("}, d2 = {"Lid/dana/familyaccount/view/invite/FamilyInviteMemberActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityFamilyAccountInviteMemberBinding;", "", "configToolbar", "()V", "dismissDanaLoadingDialog", "Ljava/util/ArrayList;", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "getExistingMember", "()Ljava/util/ArrayList;", "", "getOrganizerPhoneNumber", "()Ljava/lang/String;", "inflateViewBinding", "()Lid/dana/databinding/ActivityFamilyAccountInviteMemberBinding;", IAPSyncCommand.COMMAND_INIT, "initComponent", "Lid/dana/sendmoney/model/RecipientModel;", "recipientModel", "initQuestionnaire", "(Lid/dana/sendmoney/model/RecipientModel;)V", "", "MyBillsEntityDataFactory", "()Z", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onDestroy", "showDanaLoadingDialog", "message", "showInvitationFailToast", "(Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "", "Ljava/util/List;", "getAuthRequestContext", "Lid/dana/dialog/DanaLoadingDialog;", "lookAheadTest", "Lid/dana/dialog/DanaLoadingDialog;", "Landroidx/activity/result/ActivityResultLauncher;", "scheduleImpl", "Landroidx/activity/result/ActivityResultLauncher;", "getInviteResult", "()Landroidx/activity/result/ActivityResultLauncher;", "inviteResult", "Lid/dana/familyaccount/contract/FamilyInvitationContract$Presenter;", "presenter", "Lid/dana/familyaccount/contract/FamilyInvitationContract$Presenter;", "getPresenter", "()Lid/dana/familyaccount/contract/FamilyInvitationContract$Presenter;", "setPresenter", "(Lid/dana/familyaccount/contract/FamilyInvitationContract$Presenter;)V", "getErrorConfigVersion", "Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "PlaceComponentResult", "GetContactSyncConfig", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyInviteMemberActivity extends BaseViewBindingActivity<ActivityFamilyAccountInviteMemberBinding> {
    public static final String DEFAULT_STATE_SPINNER = "-";
    private static boolean DatabaseTableConfigUtil = false;
    public static final String IS_AUTOMATICALLY_SHOW_CONTACTPICKER = "IS_AUTOMATICALLY_SHOW_CONTACTPICKER";
    public static final String IS_MEMBER_INVITED = "IS_MEMBER_INVITED";
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda2;
    private static boolean PrepareContext;
    private static int initRecordTimeStamp;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private DanaLoadingDialog MyBillsEntityDataFactory;
    @Inject
    public FamilyInvitationContract.Presenter presenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final ActivityResultLauncher<Intent> inviteResult;
    public static final byte[] $$a = {56, -119, 46, TarHeader.LF_CONTIG, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 68;
    public static final byte[] PlaceComponentResult = {16, -72, -107, 15, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 5;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final List<String> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final List<String> getAuthRequestContext = new ArrayList();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private String PlaceComponentResult = "";

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0025 -> B:23:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.familyaccount.view.invite.FamilyInviteMemberActivity.PlaceComponentResult
            int r7 = r7 + 4
            int r6 = r6 + 16
            int r8 = 106 - r8
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r8
            r4 = 0
            r8 = r7
            goto L2a
        L13:
            r3 = 0
        L14:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            r3 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
        L2a:
            int r7 = r7 + r3
            int r7 = r7 + (-4)
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.invite.FamilyInviteMemberActivity.b(int, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 3
            int r9 = 42 - r9
            byte[] r0 = id.dana.familyaccount.view.invite.FamilyInviteMemberActivity.$$a
            int r8 = r8 + 4
            int r7 = r7 * 2
            int r7 = 103 - r7
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L34
        L18:
            r3 = 0
            r6 = r8
            r8 = r7
            r7 = r6
        L1c:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r9) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r7]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L34:
            int r8 = r8 + r7
            int r8 = r8 + (-7)
            int r7 = r9 + 1
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.invite.FamilyInviteMemberActivity.c(short, byte, byte, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        NetworkUserEntityData$$ExternalSyntheticLambda2 = new char[]{39486, 39475, 39485, 39471, 39472, 39478, 39923, 39473, 39902, 39484, 39469, 39467, 39462, 39885, 39481, 39482, 39466, 39477, 39468, 39889, 39474, 39882, 39912, 39915, 39913, 39921, 39910, 39483, 39919, 39918, 39916, 39917, 39487, 39914, 39911, 39920, 39480, 39470};
        DatabaseTableConfigUtil = true;
        PrepareContext = true;
        initRecordTimeStamp = 909155233;
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
        a(null, 127 - (ViewConfiguration.getLongPressTimeout() >> 16), new byte[]{-109, -109, -112, -118, -123, -124, -108, -121, -109, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(null, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 127, new byte[]{-125, -122, -106, -115, -107}, null, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getTouchSlop() >> 8), (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(null, TextUtils.indexOf("", "", 0, 0) + 127, new byte[]{-112, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -112, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -112, -100, -118, -112, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(null, 127 - View.MeasureSpec.makeMeasureSpec(0, 0), new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -112, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -112, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(null, 127 - ExpandableListView.getPackedPositionType(0L), new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -112, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -112, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -112, -98, -99}, null, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(null, 127 - Color.alpha(0), new byte[]{-109, -117, -126, -112, -116, -112, -92, -99, -116, -92, -117, -109, -112, -91, -126, -122, -92, -122, -120, -127, -92, -107, -123, -118, -121, -112, -124, -127, -111, -90, -109, -125, -124, -127, -111, -91, -121, -117, -109, -127, -118, -117, -127, -112, -124, -113, -117, -121, -127, -126, -127, -125, -92, -92, -93, -109, -120, -117, -117, -113}, null, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(null, 127 - (ViewConfiguration.getKeyRepeatDelay() >> 16), new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 18 - KeyEvent.getDeadChar(0, 0), (char) Color.blue(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = PlaceComponentResult[25];
                Object[] objArr13 = new Object[1];
                b(b, (byte) (b | 36), PlaceComponentResult[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr14 = new Object[1];
                b(b2, (byte) (b2 | Ascii.NAK), PlaceComponentResult[7], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 55, 2 - TextUtils.lastIndexOf("", '0'), (char) KeyEvent.normalizeMetaState(0));
                        Object[] objArr16 = new Object[1];
                        c($$a[12], (byte) ($$a[78] - 1), $$a[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 14 - ImageFormat.getBitsPerPixel(0), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 800, 15 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 815, 30 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (57994 - Color.blue(0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getTapTimeout() >> 16), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 15, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 36, (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1485939779, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionGroup(0L), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 18, (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b3 = PlaceComponentResult[25];
                Object[] objArr19 = new Object[1];
                b(b3, (byte) (b3 | 36), PlaceComponentResult[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b4 = PlaceComponentResult[25];
                Object[] objArr20 = new Object[1];
                b(b4, (byte) (b4 | Ascii.NAK), PlaceComponentResult[7], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 62, 47 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) View.MeasureSpec.makeMeasureSpec(0, 0));
                        byte b5 = (byte) ($$a[78] - 1);
                        Object[] objArr22 = new Object[1];
                        c(b5, (byte) (b5 | Ascii.ETB), $$a[8], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 34, (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-1485939779, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 17 - TextUtils.indexOf((CharSequence) "", '0'), (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b6 = PlaceComponentResult[25];
                Object[] objArr25 = new Object[1];
                b(b6, (byte) (b6 | 36), PlaceComponentResult[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b7 = PlaceComponentResult[25];
                Object[] objArr26 = new Object[1];
                b(b7, (byte) (b7 | Ascii.NAK), PlaceComponentResult[7], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - Color.alpha(0), Color.rgb(0, 0, 0) + 16777219, (char) (38969 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))));
                        byte b8 = (byte) ($$a[78] - 1);
                        Object[] objArr28 = new Object[1];
                        c(b8, (byte) (b8 | Ascii.ETB), $$a[8], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.alpha(0), 36 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1485939779, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 911, MotionEvent.axisFromString("") + 19, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b9 = PlaceComponentResult[25];
                Object[] objArr31 = new Object[1];
                b(b9, (byte) (b9 | 36), PlaceComponentResult[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b10 = PlaceComponentResult[25];
                Object[] objArr32 = new Object[1];
                b(b10, (byte) (b10 | Ascii.NAK), PlaceComponentResult[7], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), TextUtils.lastIndexOf("", '0', 0) + 4, (char) TextUtils.indexOf("", ""));
                        Object[] objArr34 = new Object[1];
                        c($$a[9], $$a[53], (byte) ($$a[78] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.getOffsetAfter("", 0), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-1485939779, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 18, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        a(null, 127 - (Process.myPid() >> 22), new byte[]{-109, -109, -112, -118, -123, -124, -108, -121, -109, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        a(null, super.getResources().getString(R.string.text_desc_landing_second_point).substring(34, 35).length() + 126, new byte[]{-125, -122, -106, -115, -107}, null, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr3 = new Object[1];
                a(null, super.getResources().getString(R.string.profile_empty_title_non_reciprocal).substring(6, 7).length() + 126, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                a(null, super.getResources().getString(R.string.request_money_AE15112158147536).substring(26, 27).codePointAt(0) + 12, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.red(0), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 34, (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr5 = new Object[1];
                    a(null, getPackageName().length() + 120, new byte[]{-112, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -112, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -112, -100, -118, -112, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr5);
                    String str = (String) objArr5[0];
                    Object[] objArr6 = new Object[1];
                    a(null, super.getResources().getString(R.string.kyc_processing_description).substring(0, 41).codePointAt(9) + 22, new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -112, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -112, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr6);
                    String str2 = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(null, getPackageName().length() + 120, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -112, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -112, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -112, -98, -99}, null, objArr7);
                    String str3 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(null, 126 - TextUtils.lastIndexOf("", '0', 0), new byte[]{-109, -117, -126, -112, -116, -112, -92, -99, -116, -92, -117, -109, -112, -91, -126, -122, -92, -122, -120, -127, -92, -107, -123, -118, -121, -112, -124, -127, -111, -90, -109, -125, -124, -127, -111, -91, -121, -117, -109, -127, -118, -117, -127, -112, -124, -113, -117, -121, -127, -126, -127, -125, -92, -92, -93, -109, -120, -117, -117, -113}, null, objArr8);
                    String str4 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(null, 127 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr9);
                    try {
                        Object[] objArr10 = {baseContext, str, str2, str3, str4, true, (String) objArr9[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getJumpTapTimeout() >> 16) + 18, (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr10);
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
            byte b = PlaceComponentResult[25];
            Object[] objArr11 = new Object[1];
            b(b, (byte) (b | 36), PlaceComponentResult[25], objArr11);
            Class<?> cls3 = Class.forName((String) objArr11[0]);
            byte b2 = PlaceComponentResult[25];
            Object[] objArr12 = new Object[1];
            b(b2, (byte) (b2 | Ascii.NAK), PlaceComponentResult[7], objArr12);
            try {
                Object[] objArr13 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr12[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 495, 3 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ((-1) - ImageFormat.getBitsPerPixel(0)));
                    Object[] objArr14 = new Object[1];
                    c($$a[9], $$a[53], (byte) ($$a[78] - 1), objArr14);
                    obj3 = cls4.getMethod((String) objArr14[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr15 = (Object[]) ((Method) obj3).invoke(null, objArr13);
                int i = ((int[]) objArr15[1])[0];
                if (((int[]) objArr15[0])[0] != i) {
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), TextUtils.getOffsetAfter("", 0) + 35, (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(null, null);
                        try {
                            Object[] objArr16 = {-272077238, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.combineMeasuredStates(0, 0), 18 - View.resolveSize(0, 0), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr16);
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
            a(null, getPackageName().length() + 120, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                b((byte) (-PlaceComponentResult[30]), PlaceComponentResult[9], PlaceComponentResult[32], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(PlaceComponentResult[56], PlaceComponentResult[59], PlaceComponentResult[13], objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getLongPressTimeout() >> 16), 35 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getScrollBarSize() >> 8) + 18, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("MyBillsEntityDataFactory", Context.class);
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
            a(null, (ViewConfiguration.getFadingEdgeLength() >> 16) + 127, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(null, getPackageName().codePointAt(5) + 17, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778145, TextUtils.indexOf("", "", 0) + 35, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 911, 18 - KeyEvent.keyCodeFromString(""), (char) (Process.myTid() >> 22))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    public FamilyInviteMemberActivity() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.familyaccount.view.invite.FamilyInviteMemberActivity$$ExternalSyntheticLambda0
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                FamilyInviteMemberActivity.$r8$lambda$PtVsEbxWZ1gJ0z8OlTBBrvj8Bjg(FamilyInviteMemberActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.inviteResult = registerForActivityResult;
    }

    @JvmName(name = "getPresenter")
    public final FamilyInvitationContract.Presenter getPresenter() {
        FamilyInvitationContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(FamilyInvitationContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityFamilyAccountInviteMemberBinding inflateViewBinding() {
        ActivityFamilyAccountInviteMemberBinding MyBillsEntityDataFactory = ActivityFamilyAccountInviteMemberBinding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    public final String getOrganizerPhoneNumber() {
        Intent intent = getIntent();
        FamilyTncConsentActivity.Companion companion = FamilyTncConsentActivity.INSTANCE;
        return intent.getStringExtra(FamilyTncConsentActivity.Companion.BuiltInFictitiousFunctionClassFactory());
    }

    public final ArrayList<FamilyMemberInfoModel> getExistingMember() {
        return getIntent().getParcelableArrayListExtra(OrganizerDashboardActivity.GET_EXIST_MEMBER);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        DaggerFamilyAccountInvitationComponent.Builder PlaceComponentResult2 = DaggerFamilyAccountInvitationComponent.PlaceComponentResult();
        Application application = getApplication();
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) application).getApplicationComponent());
        PlaceComponentResult2.getAuthRequestContext = (FamilyAccountInvitationModule) Preconditions.getAuthRequestContext(new FamilyAccountInvitationModule(new FamilyInvitationContract.View() { // from class: id.dana.familyaccount.view.invite.FamilyInviteMemberActivity$getFamilyAccountInvitationModule$1
            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2() {
                FamilyInvitationContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory() {
                FamilyInvitationContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory(ConsultAgreementResponse consultAgreementResponse) {
                FamilyInvitationContract.View.CC.getAuthRequestContext(consultAgreementResponse);
            }

            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final /* synthetic */ void PlaceComponentResult() {
                FamilyInvitationContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final /* synthetic */ void getAuthRequestContext(Throwable th) {
                FamilyInvitationContract.View.CC.MyBillsEntityDataFactory(th);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final void PlaceComponentResult(InviteMemberModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                FamilyInviteMemberActivity.this.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final void BuiltInFictitiousFunctionClassFactory(InviteMemberModel p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                FamilyInviteMemberActivity.this.showInvitationFailToast(p1);
            }

            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final void MyBillsEntityDataFactory(InviteMemberModel p0, String p1, String p2) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                FamilyInviteMemberActivity.access$startPinChallenge(FamilyInviteMemberActivity.this, p0, p1, p2);
            }

            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final void PlaceComponentResult(QuestionnaireDataConfig p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                FamilyInviteMemberActivity familyInviteMemberActivity = FamilyInviteMemberActivity.this;
                FamilyInviteMemberActivity.access$getRelations(familyInviteMemberActivity, p0);
                FamilyInviteMemberActivity.access$getAddresses(familyInviteMemberActivity, p0);
                FamilyInviteMemberActivity.access$initSpinner(familyInviteMemberActivity);
            }

            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final void PlaceComponentResult(RecipientModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                FamilyInviteMemberActivity.access$openTncAgreementPage(FamilyInviteMemberActivity.this, p0);
            }

            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final void getAuthRequestContext(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                FamilyInviteMemberActivity.this.showInvitationFailToast(p0);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                FamilyInviteMemberActivity.this.showDanaLoadingDialog();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                FamilyInviteMemberActivity.this.dismissDanaLoadingDialog();
            }
        }));
        Preconditions.getAuthRequestContext(new DanaContactModule(new DanaContactContract.View() { // from class: id.dana.familyaccount.view.invite.FamilyInviteMemberActivity$getDanaContactModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.contact.DanaContactContract.View
            public final void onEnableContactSyncFeature() {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
            }

            @Override // id.dana.contract.contact.DanaContactContract.View
            public final void onGetContactSyncState(boolean p0) {
            }

            @Override // id.dana.contract.contact.DanaContactContract.View
            public final void onGetDanaUserContactSuccess(List<String> p0) {
            }

            @Override // id.dana.contract.contact.DanaContactContract.View
            public final /* synthetic */ void onGetRecipientSyncContacts(List list) {
                DanaContactContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.contact.DanaContactContract.View
            public final /* synthetic */ void onGetSyncContacts(List list) {
                DanaContactContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }
        }));
        PlaceComponentResult2.MyBillsEntityDataFactory().PlaceComponentResult(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r3, int resultCode, Intent data) {
        Bundle extras;
        Bundle extras2;
        Bundle extras3;
        Bundle extras4;
        Bundle extras5;
        super.onActivityResult(r3, resultCode, data);
        if (r3 == 1008) {
            if (resultCode == -1) {
                if (data != null && (extras2 = data.getExtras()) != null) {
                    extras2.getString(ChallengeControl.Key.RELATION);
                }
                if (data != null && (extras = data.getExtras()) != null) {
                    extras.getString("address");
                }
                KClassImpl$Data$declaredNonStaticMembers$2();
            } else if (resultCode == 0) {
                String string = (data == null || (extras5 = data.getExtras()) == null) ? null : extras5.getString(ChallengeControl.Key.CANCEL_REASON);
                if (data != null && (extras4 = data.getExtras()) != null) {
                    extras4.getString(ChallengeControl.Key.RELATION);
                }
                if (data != null && (extras3 = data.getExtras()) != null) {
                    extras3.getString("address");
                }
                if (string == null) {
                    return;
                }
                showInvitationFailToast(string);
            }
        }
    }

    public final void initQuestionnaire(final RecipientModel recipientModel) {
        Intrinsics.checkNotNullParameter(recipientModel, "");
        FamilyQuestionerViewBinding familyQuestionerViewBinding = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        ConstraintLayout constraintLayout = familyQuestionerViewBinding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(0);
        familyQuestionerViewBinding.BuiltInFictitiousFunctionClassFactory.loadImage(recipientModel.BuiltInFictitiousFunctionClassFactory(), R.drawable.avatar_placeholder);
        familyQuestionerViewBinding.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(recipientModel.PlaceComponentResult());
        familyQuestionerViewBinding.NetworkUserEntityData$$ExternalSyntheticLambda1.setText(recipientModel.getErrorConfigVersion);
        final FamilyQuestionerViewBinding familyQuestionerViewBinding2 = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        familyQuestionerViewBinding2.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.invite.FamilyInviteMemberActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyInviteMemberActivity.m2592$r8$lambda$cxzD5t__yLnJbA5r8ijzlzdJk(FamilyQuestionerViewBinding.this, this, view);
            }
        });
        getBinding().BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.invite.FamilyInviteMemberActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyInviteMemberActivity.$r8$lambda$jT1YoDLwGreWJKXMJeV_k8ByHKo(FamilyInviteMemberActivity.this, recipientModel, view);
            }
        });
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        DANAToast dANAToast = DANAToast.PlaceComponentResult;
        String string = getString(R.string.dialog_invitation_success);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = getString(R.string.toast_invite_success);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        DANAToast.PlaceComponentResult(this, string, string2);
    }

    public static /* synthetic */ void showInvitationFailToast$default(FamilyInviteMemberActivity familyInviteMemberActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        familyInviteMemberActivity.showInvitationFailToast(str);
    }

    public final void showInvitationFailToast(String message) {
        DANAToast dANAToast = DANAToast.PlaceComponentResult;
        FamilyInviteMemberActivity familyInviteMemberActivity = this;
        if (message == null) {
            message = getResources().getString(R.string.family_account_general_toast_error);
            Intrinsics.checkNotNullExpressionValue(message, "");
        }
        DANAToast.PlaceComponentResult(familyInviteMemberActivity, message);
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        FamilyMembersPickerView familyMembersPickerView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        familyMembersPickerView.show();
        familyMembersPickerView.openScanner(new Function0<Unit>() { // from class: id.dana.familyaccount.view.invite.FamilyInviteMemberActivity$showPickerMembers$1$1
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
                FamilyInviteMemberActivity.this.startActivity(new Intent(FamilyInviteMemberActivity.this, ScannerActivity.class));
            }
        });
        familyMembersPickerView.cancelPicker();
        familyMembersPickerView.setListener(new FamilyMembersPickerView.Listener() { // from class: id.dana.familyaccount.view.invite.FamilyInviteMemberActivity$showPickerMembers$1$2
            @Override // id.dana.familyaccount.view.invite.FamilyMembersPickerView.Listener
            public final /* synthetic */ void MyBillsEntityDataFactory() {
                FamilyMembersPickerView.Listener.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.familyaccount.view.invite.FamilyMembersPickerView.Listener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                ActivityFamilyAccountInviteMemberBinding binding;
                binding = FamilyInviteMemberActivity.this.getBinding();
                binding.lookAheadTest.setVisibility(0);
            }

            @Override // id.dana.familyaccount.view.invite.FamilyMembersPickerView.Listener
            public final void getAuthRequestContext() {
                ActivityFamilyAccountInviteMemberBinding binding;
                binding = FamilyInviteMemberActivity.this.getBinding();
                binding.lookAheadTest.setVisibility(8);
            }
        });
    }

    public final void showDanaLoadingDialog() {
        DanaLoadingDialog danaLoadingDialog = new DanaLoadingDialog(this);
        this.MyBillsEntityDataFactory = danaLoadingDialog;
        if (danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
            return;
        }
        danaLoadingDialog.MyBillsEntityDataFactory.show();
        danaLoadingDialog.getAuthRequestContext.startRefresh();
    }

    public final void dismissDanaLoadingDialog() {
        DanaLoadingDialog danaLoadingDialog = this.MyBillsEntityDataFactory;
        if (danaLoadingDialog != null) {
            danaLoadingDialog.PlaceComponentResult();
        }
    }

    private final boolean MyBillsEntityDataFactory() {
        return getIntent().getBooleanExtra(IS_AUTOMATICALLY_SHOW_CONTACTPICKER, false);
    }

    @JvmName(name = "getInviteResult")
    public final ActivityResultLauncher<Intent> getInviteResult() {
        return this.inviteResult;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        getPresenter().onDestroy();
    }

    public static /* synthetic */ void $r8$lambda$PtVsEbxWZ1gJ0z8OlTBBrvj8Bjg(FamilyInviteMemberActivity familyInviteMemberActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(familyInviteMemberActivity, "");
        if (activityResult.BuiltInFictitiousFunctionClassFactory == -1) {
            Intent intent = activityResult.MyBillsEntityDataFactory;
            boolean z = false;
            if (intent != null && intent.getBooleanExtra(IS_MEMBER_INVITED, false)) {
                z = true;
            }
            if (z) {
                familyInviteMemberActivity.finish();
            }
        }
    }

    /* renamed from: $r8$lambda$cxzD5t__yLn-J-bA5r8ijzlzdJk */
    public static /* synthetic */ void m2592$r8$lambda$cxzD5t__yLnJbA5r8ijzlzdJk(FamilyQuestionerViewBinding familyQuestionerViewBinding, FamilyInviteMemberActivity familyInviteMemberActivity, View view) {
        Intrinsics.checkNotNullParameter(familyQuestionerViewBinding, "");
        Intrinsics.checkNotNullParameter(familyInviteMemberActivity, "");
        ConstraintLayout constraintLayout = familyQuestionerViewBinding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(8);
        familyQuestionerViewBinding.NetworkUserEntityData$$ExternalSyntheticLambda0.setSelection(0);
        familyQuestionerViewBinding.getErrorConfigVersion.setSelection(0);
        DanaButtonPrimaryView danaButtonPrimaryView = familyInviteMemberActivity.getBinding().BuiltInFictitiousFunctionClassFactory;
        danaButtonPrimaryView.setDisabled(danaButtonPrimaryView.getResources().getString(R.string.family_account_text_continue));
        danaButtonPrimaryView.setEnabled(false);
    }

    /* renamed from: $r8$lambda$eIyD-JyucbPvW8yh7Pi6wlluhdU */
    public static /* synthetic */ void m2593$r8$lambda$eIyDJyucbPvW8yh7Pi6wlluhdU(FamilyInviteMemberActivity familyInviteMemberActivity, View view) {
        Intrinsics.checkNotNullParameter(familyInviteMemberActivity, "");
        familyInviteMemberActivity.getOnBackPressedDispatcher().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void $r8$lambda$jT1YoDLwGreWJKXMJeV_k8ByHKo(FamilyInviteMemberActivity familyInviteMemberActivity, RecipientModel recipientModel, View view) {
        Intrinsics.checkNotNullParameter(familyInviteMemberActivity, "");
        Intrinsics.checkNotNullParameter(recipientModel, "");
        FamilyInvitationContract.Presenter presenter = familyInviteMemberActivity.getPresenter();
        String str = recipientModel.getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(str, "");
        presenter.PlaceComponentResult(new InviteMemberModel(true, str, familyInviteMemberActivity.PlaceComponentResult, familyInviteMemberActivity.BuiltInFictitiousFunctionClassFactory, "", ""), recipientModel);
    }

    public static /* synthetic */ void $r8$lambda$sTwehZzJbgtFevjO9M7EsjlGGUI(FamilyInviteMemberActivity familyInviteMemberActivity, View view) {
        Intrinsics.checkNotNullParameter(familyInviteMemberActivity, "");
        familyInviteMemberActivity.BuiltInFictitiousFunctionClassFactory();
    }

    public static final /* synthetic */ void access$getAddresses(FamilyInviteMemberActivity familyInviteMemberActivity, QuestionnaireDataConfig questionnaireDataConfig) {
        familyInviteMemberActivity.getAuthRequestContext.add(0, "-");
        List<String> address = questionnaireDataConfig.getAddress();
        if (address != null) {
            for (String str : address) {
                if (str != null) {
                    familyInviteMemberActivity.getAuthRequestContext.add(str);
                }
            }
        }
    }

    public static final /* synthetic */ void access$getRelations(FamilyInviteMemberActivity familyInviteMemberActivity, QuestionnaireDataConfig questionnaireDataConfig) {
        familyInviteMemberActivity.KClassImpl$Data$declaredNonStaticMembers$2.add(0, "-");
        List<String> relation = questionnaireDataConfig.getRelation();
        if (relation != null) {
            for (String str : relation) {
                if (str != null) {
                    familyInviteMemberActivity.KClassImpl$Data$declaredNonStaticMembers$2.add(str);
                }
            }
        }
    }

    public static final /* synthetic */ void access$initSpinner(final FamilyInviteMemberActivity familyInviteMemberActivity) {
        final Spinner spinner = familyInviteMemberActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.getErrorConfigVersion;
        FamilyInviteMemberActivity familyInviteMemberActivity2 = familyInviteMemberActivity;
        ArrayAdapter arrayAdapter = new ArrayAdapter(familyInviteMemberActivity2, (int) R.layout.family_spinner_layout, familyInviteMemberActivity.KClassImpl$Data$declaredNonStaticMembers$2);
        arrayAdapter.setDropDownViewResource(17367049);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: id.dana.familyaccount.view.invite.FamilyInviteMemberActivity$setupSpinnerRelation$1$2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public final void onNothingSelected(AdapterView<?> p0) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public final void onItemSelected(AdapterView<?> p0, View p1, int p2, long p3) {
                FamilyInviteMemberActivity.this.PlaceComponentResult = spinner.getSelectedItem().toString();
                FamilyInviteMemberActivity.access$validateInviteButton(FamilyInviteMemberActivity.this);
                FamilyInviteMemberActivity.access$onOtherRelationSelected(FamilyInviteMemberActivity.this, p2);
            }
        });
        final Spinner spinner2 = familyInviteMemberActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.NetworkUserEntityData$$ExternalSyntheticLambda0;
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(familyInviteMemberActivity2, (int) R.layout.family_spinner_layout, familyInviteMemberActivity.getAuthRequestContext);
        arrayAdapter2.setDropDownViewResource(17367049);
        spinner2.setAdapter((SpinnerAdapter) arrayAdapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: id.dana.familyaccount.view.invite.FamilyInviteMemberActivity$setupSpinnerAddress$1$2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public final void onNothingSelected(AdapterView<?> p0) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public final void onItemSelected(AdapterView<?> p0, View p1, int p2, long p3) {
                FamilyInviteMemberActivity.this.BuiltInFictitiousFunctionClassFactory = spinner2.getSelectedItem().toString();
                FamilyInviteMemberActivity.access$validateInviteButton(FamilyInviteMemberActivity.this);
            }
        });
    }

    public static final /* synthetic */ void access$onOtherRelationSelected(final FamilyInviteMemberActivity familyInviteMemberActivity, int i) {
        if (i == familyInviteMemberActivity.KClassImpl$Data$declaredNonStaticMembers$2.size() - 1 || Intrinsics.areEqual(familyInviteMemberActivity.KClassImpl$Data$declaredNonStaticMembers$2.get(i), familyInviteMemberActivity.getString(R.string.family_relation_others))) {
            TextInputLayout textInputLayout = familyInviteMemberActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.moveToNextValue;
            Intrinsics.checkNotNullExpressionValue(textInputLayout, "");
            textInputLayout.setVisibility(0);
            DanaEditTextView danaEditTextView = familyInviteMemberActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(danaEditTextView, "");
            DanaEditTextView danaEditTextView2 = danaEditTextView;
            InputExtKt.PlaceComponentResult(danaEditTextView2);
            danaEditTextView2.addTextChangedListener(new TextWatcher() { // from class: id.dana.familyaccount.view.invite.FamilyInviteMemberActivity$onOtherRelationSelected$lambda-16$$inlined$onTextAfterChanged$1
                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void afterTextChanged(Editable p0) {
                    String obj = p0 != null ? p0.toString() : null;
                    if (obj == null) {
                        obj = "";
                    }
                    FamilyInviteMemberActivity.this.PlaceComponentResult = obj;
                    FamilyInviteMemberActivity.access$validateInviteButton(FamilyInviteMemberActivity.this);
                }
            });
            return;
        }
        TextInputLayout textInputLayout2 = familyInviteMemberActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(textInputLayout2, "");
        textInputLayout2.setVisibility(8);
    }

    public static final /* synthetic */ void access$openTncAgreementPage(FamilyInviteMemberActivity familyInviteMemberActivity, RecipientModel recipientModel) {
        Intent intent = new Intent(familyInviteMemberActivity, FamilyTncConsentActivity.class);
        Intent intent2 = familyInviteMemberActivity.getIntent();
        FamilyTncConsentActivity.Companion companion = FamilyTncConsentActivity.INSTANCE;
        String stringExtra = intent2.getStringExtra(FamilyTncConsentActivity.Companion.PlaceComponentResult());
        if (stringExtra == null) {
            FamilyTncConsentActivity.Companion companion2 = FamilyTncConsentActivity.INSTANCE;
            stringExtra = FamilyTncConsentActivity.Companion.PlaceComponentResult();
        }
        String str = stringExtra;
        String organizerPhoneNumber = familyInviteMemberActivity.getOrganizerPhoneNumber();
        if (organizerPhoneNumber == null) {
            FamilyTncConsentActivity.Companion companion3 = FamilyTncConsentActivity.INSTANCE;
            organizerPhoneNumber = FamilyTncConsentActivity.Companion.BuiltInFictitiousFunctionClassFactory();
        }
        String PlaceComponentResult2 = recipientModel.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        String str2 = familyInviteMemberActivity.PlaceComponentResult;
        String str3 = familyInviteMemberActivity.BuiltInFictitiousFunctionClassFactory;
        String str4 = recipientModel.getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(str4, "");
        intent.putExtra("startParams", new FamilyTncConsentActivity.StartParams(str, organizerPhoneNumber, PlaceComponentResult2, str2, str3, str4));
        familyInviteMemberActivity.inviteResult.MyBillsEntityDataFactory(intent, null);
    }

    public static final /* synthetic */ void access$startPinChallenge(FamilyInviteMemberActivity familyInviteMemberActivity, InviteMemberModel inviteMemberModel, String str, String str2) {
        ChallengeControl.Builder builder = new ChallengeControl.Builder(familyInviteMemberActivity);
        builder.scheduleImpl = "family_account";
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = "family_account";
        new ChallengeControl(builder.PlaceComponentResult(inviteMemberModel, str, str2), null).getAuthRequestContext();
    }

    public static final /* synthetic */ void access$validateInviteButton(FamilyInviteMemberActivity familyInviteMemberActivity) {
        if (!Intrinsics.areEqual(familyInviteMemberActivity.BuiltInFictitiousFunctionClassFactory, "-") && !Intrinsics.areEqual(familyInviteMemberActivity.PlaceComponentResult, "-")) {
            DanaButtonPrimaryView danaButtonPrimaryView = familyInviteMemberActivity.getBinding().BuiltInFictitiousFunctionClassFactory;
            danaButtonPrimaryView.setActiveButton(danaButtonPrimaryView.getResources().getString(R.string.family_account_text_continue), null);
            danaButtonPrimaryView.setEnabled(true);
            return;
        }
        DanaButtonPrimaryView danaButtonPrimaryView2 = familyInviteMemberActivity.getBinding().BuiltInFictitiousFunctionClassFactory;
        danaButtonPrimaryView2.setDisabled(danaButtonPrimaryView2.getResources().getString(R.string.family_account_text_continue));
        danaButtonPrimaryView2.setEnabled(false);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        LayoutToolbarBinding layoutToolbarBinding = getBinding().moveToNextValue;
        TextView textView = layoutToolbarBinding.initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
        ImageView imageView = layoutToolbarBinding.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(8);
        layoutToolbarBinding.initRecordTimeStamp.setText(getString(R.string.family_account_text_title_toolbar_invite_members));
        LayoutToolbarBinding layoutToolbarBinding2 = getBinding().moveToNextValue;
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationIcon(R.drawable.btn_arrow_left);
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.invite.FamilyInviteMemberActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyInviteMemberActivity.m2593$r8$lambda$eIyDJyucbPvW8yh7Pi6wlluhdU(FamilyInviteMemberActivity.this, view);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.invite.FamilyInviteMemberActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyInviteMemberActivity.$r8$lambda$sTwehZzJbgtFevjO9M7EsjlGGUI(FamilyInviteMemberActivity.this, view);
            }
        });
        getPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        if (MyBillsEntityDataFactory()) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(this), null, null, new FamilyInviteMemberActivity$setupView$2(this, null), 3, null);
        }
    }

    private static void a(int[] iArr, int i, byte[] bArr, char[] cArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        int i3 = (int) (4571606982258105150L ^ initRecordTimeStamp);
        if (PrepareContext) {
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
