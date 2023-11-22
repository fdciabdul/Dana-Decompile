package id.dana.familyaccount.view.invite;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebView;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewGroupKt;
import androidx.core.widget.NestedScrollView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.SkeletonScreen;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.challenge.ChallengeControl;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.databinding.ActivityFamilyTncConsentBinding;
import id.dana.databinding.LayoutToolbarBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerFamilyAccountInvitationComponent;
import id.dana.di.modules.FamilyAccountInvitationModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.familyaccount.model.QuestionnaireDataConfig;
import id.dana.domain.useragreement.model.AgreementInfo;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import id.dana.familyaccount.constants.StatusInformationType;
import id.dana.familyaccount.contract.FamilyInvitationContract;
import id.dana.familyaccount.model.InviteMemberModel;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;
import id.dana.familyaccount.view.invite.FamilyTncConsentActivity;
import id.dana.familyaccount.view.statusinformation.StatusInformationView;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.utils.DANAToast;
import id.dana.utils.ShimmeringUtil;
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
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.C;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002CDB\u0007¢\u0006\u0004\bB\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u0006\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0006\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0011\u0010\tJ\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001c\u0010\tJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001d\u0010\tJ\u000f\u0010\u001e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001e\u0010\tJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001f\u0010\tJ\u0019\u0010!\u001a\u00020\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b!\u0010\u0014J\u000f\u0010\"\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\"\u0010\tJ\u000f\u0010#\u001a\u00020\u0005H\u0002¢\u0006\u0004\b#\u0010\tJ\u000f\u0010$\u001a\u00020\u0005H\u0002¢\u0006\u0004\b$\u0010\tJ'\u0010(\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0012H\u0002¢\u0006\u0004\b(\u0010)J#\u0010(\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00122\b\u0010&\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b(\u0010*J#\u0010\u0013\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00122\b\u0010&\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0013\u0010*J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\n\u0010\u0014R\u001b\u0010(\u001a\u00020+8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b(\u0010.R\"\u00100\u001a\u00020/8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u0010\u0006\u001a\u0002068\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0018\u0010\n\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b#\u0010A"}, d2 = {"Lid/dana/familyaccount/view/invite/FamilyTncConsentActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityFamilyTncConsentBinding;", "", "p0", "", "PlaceComponentResult", "(Z)V", "configToolbar", "()V", "MyBillsEntityDataFactory", "Lid/dana/di/modules/FamilyAccountInvitationModule;", "()Lid/dana/di/modules/FamilyAccountInvitationModule;", "scheduleImpl", "inflateViewBinding", "()Lid/dana/databinding/ActivityFamilyTncConsentBinding;", IAPSyncCommand.COMMAND_INIT, "initComponent", "", "getAuthRequestContext", "(Ljava/lang/String;)V", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onDestroy", "moveToNextValue", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "message", "showInvitationFailToast", "lookAheadTest", "GetContactSyncConfig", "DatabaseTableConfigUtil", "Lid/dana/familyaccount/model/InviteMemberModel;", "p1", "p2", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/familyaccount/model/InviteMemberModel;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/dialog/DanaLoadingDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lkotlin/Lazy;", "()Lid/dana/dialog/DanaLoadingDialog;", "Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "familyAccountAnalyticalTracker", "Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "getFamilyAccountAnalyticalTracker", "()Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "setFamilyAccountAnalyticalTracker", "(Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;)V", "Lid/dana/familyaccount/view/invite/FamilyTncConsentActivity$StartParams;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/familyaccount/view/invite/FamilyTncConsentActivity$StartParams;", "Lid/dana/familyaccount/contract/FamilyInvitationContract$Presenter;", "presenter", "Lid/dana/familyaccount/contract/FamilyInvitationContract$Presenter;", "getPresenter", "()Lid/dana/familyaccount/contract/FamilyInvitationContract$Presenter;", "setPresenter", "(Lid/dana/familyaccount/contract/FamilyInvitationContract$Presenter;)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "<init>", "Companion", "StartParams"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyTncConsentActivity extends BaseViewBindingActivity<ActivityFamilyTncConsentBinding> {
    private static int $10 = 0;
    private static int $11 = 1;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static String DatabaseTableConfigUtil = null;
    public static final String EXTRA_START_PARAMS = "startParams";
    private static char FragmentBottomSheetPaymentSettingBinding;
    public static String KClassImpl$Data$declaredNonStaticMembers$2;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda5;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda7;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda8;
    public static String PlaceComponentResult;
    private static int PrepareContext;
    public static String getAuthRequestContext;
    private static String getErrorConfigVersion;
    private static long initRecordTimeStamp;
    private static char isLayoutRequested;
    public static final byte[] lookAheadTest;
    private static char newProxyInstance;
    public static final int scheduleImpl;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private SkeletonScreen MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private StartParams PlaceComponentResult;
    @Inject
    public FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker;
    @Inject
    public FamilyInvitationContract.Presenter presenter;
    public static final byte[] $$a = {111, 84, 114, 59, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 144;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda3 = 0;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.familyaccount.view.invite.FamilyTncConsentActivity$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(FamilyTncConsentActivity.this);
        }
    });

    public static /* synthetic */ void $r8$lambda$Xcfl1Io8GR9qTRIr_vwM99vsaUM(FamilyTncConsentActivity familyTncConsentActivity, View view) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 23;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            char c = i % 2 != 0 ? 'V' : '\f';
            PlaceComponentResult(familyTncConsentActivity);
            if (c != '\f') {
                int i2 = 40 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$ZF-uxJ5kaTS7gu8qRLuTqIal3lA  reason: not valid java name */
    public static /* synthetic */ void m2596$r8$lambda$ZFuxJ5kaTS7gu8qRLuTqIal3lA(FamilyTncConsentActivity familyTncConsentActivity, String str, boolean z, View view) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 117;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
        if ((i % 2 == 0 ? '`' : '7') != '`') {
            try {
                MyBillsEntityDataFactory(familyTncConsentActivity, str, z);
            } catch (Exception e) {
                throw e;
            }
        } else {
            MyBillsEntityDataFactory(familyTncConsentActivity, str, z);
            int i2 = 16 / 0;
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 81;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i3 % 128;
        int i4 = i3 % 2;
    }

    public static /* synthetic */ void $r8$lambda$srsJzOsRjGhC5QSBIA0tuXR0cdA(FamilyTncConsentActivity familyTncConsentActivity, String str, CompoundButton compoundButton, boolean z) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 57;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        try {
            BuiltInFictitiousFunctionClassFactory(familyTncConsentActivity, str, z);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 87;
            NetworkUserEntityData$$ExternalSyntheticLambda5 = i3 % 128;
            if ((i3 % 2 == 0 ? '@' : Typography.greater) != '>') {
                int i4 = 2 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 35;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        newProxyInstance = (char) 13492;
        initRecordTimeStamp = 4360990799332652212L;
        PrepareContext = 1025053522;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 105;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 17 : '4') != '4') {
            int i4 = 80 / 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0042 -> B:18:0x0049). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r0 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3     // Catch: java.lang.Exception -> L72
            int r0 = r0 + 119
            int r1 = r0 % 128
            id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5 = r1     // Catch: java.lang.Exception -> L72
            int r0 = r0 % 2
            int r7 = 106 - r7
            int r9 = 56 - r9
            int r8 = 23 - r8
            byte[] r0 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.lookAheadTest
            byte[] r1 = new byte[r8]
            r2 = -1
            int r8 = r8 + r2
            r3 = 33
            if (r0 != 0) goto L1d
            r4 = 33
            goto L1f
        L1d:
            r4 = 45
        L1f:
            r5 = 0
            r6 = 1
            if (r4 == r3) goto L2b
            r2 = r1
            r3 = -1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r7
            r7 = r8
            goto L49
        L2b:
            int r7 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5
            int r7 = r7 + r3
            int r3 = r7 % 128
            id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r3
            int r7 = r7 % 2
            if (r7 == 0) goto L3c
            r5.hashCode()     // Catch: java.lang.Throwable -> L3a
            goto L3c
        L3a:
            r7 = move-exception
            throw r7
        L3c:
            r7 = r8
            r2 = r1
            r3 = -1
            r1 = r0
            r0 = r10
            r10 = r9
        L42:
            int r8 = -r8
            int r9 = r9 + r8
            int r8 = r10 + 1
            int r9 = r9 + (-4)
            r10 = r8
        L49:
            int r3 = r3 + r6
            byte r8 = (byte) r9
            r2[r3] = r8
            if (r3 != r7) goto L6f
            java.lang.String r7 = new java.lang.String
            r8 = 0
            r7.<init>(r2, r8)
            int r9 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3
            int r9 = r9 + 51
            int r10 = r9 % 128
            id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5 = r10
            int r9 = r9 % 2
            if (r9 != 0) goto L62
            r6 = 0
        L62:
            if (r6 == 0) goto L67
            r0[r8] = r7
            return
        L67:
            r5.hashCode()     // Catch: java.lang.Throwable -> L6d
            r0[r8] = r7     // Catch: java.lang.Throwable -> L6d
            return
        L6d:
            r7 = move-exception
            throw r7
        L6f:
            r8 = r1[r10]
            goto L42
        L72:
            r7 = move-exception
            goto L75
        L74:
            throw r7
        L75:
            goto L74
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.invite.FamilyTncConsentActivity.c(byte, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(byte r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.$$a
            int r8 = r8 * 2
            int r8 = 103 - r8
            int r7 = 47 - r7
            int r9 = r9 * 3
            int r9 = r9 + 21
            byte[] r1 = new byte[r9]
            int r9 = r9 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L36
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r9) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L28:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L36:
            int r7 = r7 + r9
            int r7 = r7 + (-7)
            int r8 = r8 + 1
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.invite.FamilyTncConsentActivity.g(byte, byte, int, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        NetworkUserEntityData$$ExternalSyntheticLambda8 = (char) 37371;
        isLayoutRequested = (char) 41864;
        FragmentBottomSheetPaymentSettingBinding = (char) 7435;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = (char) 28314;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 45;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
        int i2 = i % 2;
        try {
            this._$_findViewCache.clear();
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 31;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final View _$_findCachedViewById(int i) {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 87;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i2 % 128;
        int i3 = i2 % 2;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        Object[] objArr = null;
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        if (!(findViewById != null)) {
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 51;
            NetworkUserEntityData$$ExternalSyntheticLambda5 = i4 % 128;
            int i5 = i4 % 2;
            return null;
        }
        try {
            int i6 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 49;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i6 % 128;
            int i7 = i6 % 2;
            map.put(Integer.valueOf(i), findViewById);
            if (i7 != 0) {
                int length = objArr.length;
                return findViewById;
            }
            return findViewById;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x009b, code lost:
    
        if (r2 > 99999) goto L6;
     */
    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void attachBaseContext(android.content.Context r23) {
        /*
            Method dump skipped, instructions count: 3276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.invite.FamilyTncConsentActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        Context applicationContext;
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 51;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            if (i % 2 == 0) {
                applicationContext = super.getApplicationContext();
            } else {
                applicationContext = super.getApplicationContext();
                int i2 = 7 / 0;
            }
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 99;
            NetworkUserEntityData$$ExternalSyntheticLambda5 = i3 % 128;
            int i4 = i3 % 2;
            return applicationContext;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 41;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            int i2 = i % 2;
            Context baseContext = super.getBaseContext();
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 35;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
                int i4 = i3 % 2;
                return baseContext;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 11;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
        int i2 = i % 2;
        Resources resources = super.getResources();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 75;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i3 % 128;
        if (i3 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
            return resources;
        }
        return resources;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 3;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        Object[] objArr2 = new Object[1];
        b(new char[]{0, 0, 0, 0}, new char[]{37975, 57726, 891, 8828}, (-1) - ExpandableListView.getPackedPositionChild(0L), (char) (super.getResources().getString(R.string.global_search_network_error_desc).substring(0, 1).codePointAt(0) + 31680), new char[]{13330, 20646, 24630, 212, 53705, 3045, 33557, 41460, 23193, 11, 1712, 1229, 48763, 57916, 37106, 60259, 28805, 29862}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        b(new char[]{0, 0, 0, 0}, new char[]{51295, 34636, 57006, 25797}, super.getResources().getString(R.string.error_search_not_found_title).substring(17, 18).codePointAt(0) - 1366864728, (char) (getPackageName().length() + 50647), new char[]{6111, 11932, 53342, 52428, 5780}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                b(new char[]{0, 0, 0, 0}, new char[]{22124, 33177, 30908, 4241}, Color.red(0), (char) (super.getResources().getString(R.string.akamai_verify_failed_message).substring(9, 10).length() + 37239), new char[]{42748, 24222, 11632, 37061, 62948, 1368, 28068, 62194, 14699, 13617, 61714, 3476, 26754, 45893, 65518, 47854, 30329, 27856, 31857, 13032, 7191, 50147, 22670, 751, 30960, 44453}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                b(new char[]{0, 0, 0, 0}, new char[]{52216, 63461, 30334, 55101}, TextUtils.getOffsetBefore("", 0), (char) (getPackageName().length() + 15727), new char[]{29918, 56303, 46647, 64014, 20350, 42996, 33545, 23570, 45337, 51143, 62215, 37606, 31336, 38458, 64414, 59192, 23530, 34287}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 105;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
                int i4 = i3 % 2;
                baseContext = baseContext.getApplicationContext();
            }
            if (!(baseContext == null)) {
                int i5 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 81;
                NetworkUserEntityData$$ExternalSyntheticLambda5 = i5 % 128;
                int i6 = i5 % 2;
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.getOffsetBefore("", 0) + 35, (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{14639, 64579, 9472, 59411}, TextUtils.indexOf("", "", 0, 0), (char) (getPackageName().length() - 7), new char[]{22159, 2866, 53972, 46579, 51931, 65441, 30044, 1023, 55770, 9847, 51450, 44639, 38617, 34883, 65431, 2904, 63191, 45015, 40068, 9673, 60834, 2288, 63061, 28671, 29823, 62674, 34130, 36033, 61905, 39998, 60483, 18566, 12125, 9116, 16889, 59210, 17722, 58792, 25326, 15406, 25132, 63476, 57166, 15810, 39131, 14146, 31297, 56473}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{28255, 36841, 40278, 33118}, super.getResources().getString(R.string.zface_distance_too_far).substring(0, 2).length() - 2, (char) TextUtils.indexOf("", "", 0), new char[]{3851, 52024, 60682, 22332, 55661, 64816, 36514, 48543, 17770, 40115, 15937, 4985, 15980, 6808, 2394, 11922, 39075, 43889, 29497, 46658, 29977, 23063, 47131, 38550, 53285, 58585, 24559, 64053, 13824, 6633, 42361, 57412, 64374, 25564, 44920, 12232, 3298, 9939, 46601, 30738, 58932, 18214, 56351, 27988, 22227, 40482, 28629, 46263, 38727, 27633, 64430, 55370, 46926, 4799, 7508, 56888, 3356, 53289, 24896, 61593, 44845, 49641, 17416, 33078}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{18088, 7595, 62543, 61193}, getPackageName().codePointAt(3) - 100, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), new char[]{29090, 7447, 16979, 29033, 14866, 23695, 59835, 51320, 30590, 33695, 49623, 63448, 4897, 2691, 45351, 4844, 33842, 19769, 27806, 1086, 20572, 58877, 27616, 12129, 53402, 53810, 38296, 62250, 42429, 42264, 27267, 36249, 3589, 27161, 31612, 14282, 62689, 3461, 11533, 59855, 65310, 59467, 39783, 15344, 40745, 55263, 53411, 15817, 927, 46446, 50792, 55519, 2079, 50527, 53056, 38098, 38356, 12636, 29595, 45001, 23347, 10873, 7552, 43651}, objArr8);
                    String str3 = (String) objArr8[0];
                    char[] cArr = {0, 0, 0, 0};
                    char[] cArr2 = {18741, 58704, 45276, 22686};
                    int codePointAt = super.getResources().getString(R.string.promocode_bottomsheet_risk_reject_title).substring(15, 17).codePointAt(1) - 32;
                    try {
                        byte b = (byte) (-lookAheadTest[32]);
                        byte b2 = lookAheadTest[25];
                        Object[] objArr9 = new Object[1];
                        c(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr9);
                        Class<?> cls3 = Class.forName((String) objArr9[0]);
                        c(lookAheadTest[48], lookAheadTest[41], lookAheadTest[25], new Object[1]);
                        Object[] objArr10 = new Object[1];
                        b(cArr, cArr2, codePointAt, (char) (((ApplicationInfo) cls3.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 33), new char[]{32700, 62090, 54861, 17193, 1130, 49382, 18601, 9509, 23530, 44885, 50501, 3809, 43895, 50393, 25731, 40356, 34557, 59572, 22175, 49401, 60392, 54035, 33624, 5915, 3320, 44914, 44729, 19907, 1862, 43913, 5112, 51460, 14869, 19278, 33810, 17828, 19812, 51600, 2536, 218, 32920, 39608, 20261, 24896, 22903, 12788, 7526, 32951, 60845, 31807, 37187, 9469, 16032, 16106, 9138, 18622, 33519, 39602, 43651, 8704}, objArr10);
                        String str4 = (String) objArr10[0];
                        char[] cArr3 = {0, 0, 0, 0};
                        char[] cArr4 = {3701, 18992, 18615, 59260};
                        int i7 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 83;
                        NetworkUserEntityData$$ExternalSyntheticLambda5 = i7 % 128;
                        int i8 = i7 % 2;
                        try {
                            byte b3 = (byte) (-lookAheadTest[32]);
                            byte b4 = lookAheadTest[25];
                            Object[] objArr11 = new Object[1];
                            c(b3, b4, (byte) (b4 | TarHeader.LF_BLK), objArr11);
                            Class<?> cls4 = Class.forName((String) objArr11[0]);
                            c(lookAheadTest[48], lookAheadTest[41], lookAheadTest[25], new Object[1]);
                            Object[] objArr12 = new Object[1];
                            b(cArr3, cArr4, ((ApplicationInfo) cls4.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (super.getResources().getString(R.string.card_filter_done).substring(3, 4).codePointAt(0) + 31715), new char[]{20161, 15603, 36421, 63087, 18315, 52849}, objArr12);
                            try {
                                Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - MotionEvent.axisFromString(""), Color.argb(0, 0, 0, 0) + 18, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr13);
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
            Object[] objArr14 = new Object[1];
            c(lookAheadTest[25], lookAheadTest[30], (byte) (-lookAheadTest[31]), objArr14);
            Class<?> cls5 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            c(lookAheadTest[9], lookAheadTest[30], 30, objArr15);
            try {
                Object[] objArr16 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getWindowTouchSlop() >> 8), 4 - ExpandableListView.getPackedPositionType(0L), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                    Object[] objArr17 = new Object[1];
                    g((byte) ($$a[78] - 1), $$a[9], $$a[8], objArr17);
                    obj3 = cls6.getMethod((String) objArr17[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                int i9 = ((int[]) objArr18[1])[0];
                if (((int[]) objArr18[0])[0] != i9) {
                    long j = ((r0 ^ i9) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr19 = {-1562306646, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.makeMeasureSpec(0, 0), ExpandableListView.getPackedPositionGroup(0L) + 18, (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr19);
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
        Object[] objArr = null;
        if ((baseContext == null ? '+' : (char) 2) == '+') {
            Object[] objArr2 = new Object[1];
            b(new char[]{0, 0, 0, 0}, new char[]{22124, 33177, 30908, 4241}, super.getResources().getString(R.string.payment_guarantee).substring(0, 5).codePointAt(2) - 48, (char) (super.getResources().getString(R.string.split_bill_qr_desc_message).substring(17, 18).codePointAt(0) + 37208), new char[]{42748, 24222, 11632, 37061, 62948, 1368, 28068, 62194, 14699, 13617, 61714, 3476, 26754, 45893, 65518, 47854, 30329, 27856, 31857, 13032, 7191, 50147, 22670, 751, 30960, 44453}, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            b(new char[]{0, 0, 0, 0}, new char[]{52216, 63461, 30334, 55101}, Process.myPid() >> 22, (char) (super.getResources().getString(R.string.my_bills_phone_number_hint).substring(3, 4).codePointAt(0) + 15617), new char[]{29918, 56303, 46647, 64014, 20350, 42996, 33545, 23570, 45337, 51143, 62215, 37606, 31336, 38458, 64414, 59192, 23530, 34287}, objArr3);
            baseContext = (Context) cls.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 73;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            int i2 = i % 2;
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 103;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            if (i3 % 2 != 0) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.getOffsetBefore("", 0), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr4 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 911, 19 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("MyBillsEntityDataFactory", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr4);
                        int length = objArr.length;
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
            } else {
                try {
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj3 == null) {
                        obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - MotionEvent.axisFromString(""), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, null);
                    try {
                        Object[] objArr5 = {baseContext};
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getPressedStateDuration() >> 16), ExpandableListView.getPackedPositionType(0L) + 18, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj4);
                        }
                        ((Method) obj4).invoke(invoke2, objArr5);
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
        super.onPause();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        char[] cArr;
        char[] cArr2;
        Class<?> cls;
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 1;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            if ((i % 2 != 0 ? '%' : 'N') != '%') {
                cArr = new char[]{0, 0, 0, 0};
                cArr2 = new char[]{22124, 33177, 30908, 4241};
            } else {
                cArr = new char[]{0, 0, 0, 0};
                cArr2 = new char[]{22124, 33177, 30908, 4241};
                int i2 = 38 / 0;
            }
            char[] cArr3 = cArr;
            char[] cArr4 = cArr2;
            try {
                byte b = (byte) (-lookAheadTest[32]);
                byte b2 = lookAheadTest[25];
                Object[] objArr = new Object[1];
                c(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr);
                cls = Class.forName((String) objArr[0]);
                c(lookAheadTest[48], lookAheadTest[41], lookAheadTest[25], new Object[1]);
            } catch (Throwable th) {
                th = th;
            }
            try {
                Object[] objArr2 = new Object[1];
                b(cArr3, cArr4, ((ApplicationInfo) cls.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (View.combineMeasuredStates(0, 0) + 37240), new char[]{42748, 24222, 11632, 37061, 62948, 1368, 28068, 62194, 14699, 13617, 61714, 3476, 26754, 45893, 65518, 47854, 30329, 27856, 31857, 13032, 7191, 50147, 22670, 751, 30960, 44453}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(new char[]{0, 0, 0, 0}, new char[]{52216, 63461, 30334, 55101}, Process.myTid() >> 22, (char) (super.getResources().getString(R.string.no_space_available).substring(43, 45).codePointAt(0) + 15620), new char[]{29918, 56303, 46647, 64014, 20350, 42996, 33545, 23570, 45337, 51143, 62215, 37606, 31336, 38458, 64414, 59192, 23530, 34287}, objArr3);
                baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
            } catch (Throwable th2) {
                th = th2;
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        if ((baseContext != null ? 'a' : '-') == 'a') {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 93;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            boolean z = i3 % 2 != 0;
            baseContext = baseContext.getApplicationContext();
            if (z) {
                int i4 = 22 / 0;
            }
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + PDF417Common.NUMBER_OF_CODEWORDS, AndroidCharacter.getMirror('0') - '\r', (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), ExpandableListView.getPackedPositionType(0L) + 18, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
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
        int i5 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 79;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i5 % 128;
        int i6 = i5 % 2;
    }

    public static final /* synthetic */ void access$dismissDanaLoadingDialog(FamilyTncConsentActivity familyTncConsentActivity) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 11;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
        int i2 = i % 2;
        familyTncConsentActivity.MyBillsEntityDataFactory();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 73;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static final /* synthetic */ ActivityFamilyTncConsentBinding access$getBinding(FamilyTncConsentActivity familyTncConsentActivity) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 75;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        boolean z = i % 2 != 0;
        ActivityFamilyTncConsentBinding binding = familyTncConsentActivity.getBinding();
        if (z) {
            Object obj = null;
            obj.hashCode();
        }
        return binding;
    }

    public static final /* synthetic */ String access$getMEMBER_LOCATION$cp() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 117;
            NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
            if (i % 2 != 0) {
                return PlaceComponentResult;
            }
            String str = PlaceComponentResult;
            Object obj = null;
            obj.hashCode();
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ String access$getMEMBER_NAME$cp() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 9;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        try {
            String str = getAuthRequestContext;
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 97;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            if ((i3 % 2 != 0 ? '!' : (char) 11) != 11) {
                int i4 = 94 / 0;
                return str;
            }
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ String access$getMEMBER_RELATIONSHIP$cp() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 51;
            NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
            int i2 = i % 2;
            String str = KClassImpl$Data$declaredNonStaticMembers$2;
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 87;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ String access$getORGANIZER_NAME$cp() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 33;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
        if ((i % 2 == 0 ? (char) 29 : 'G') != 29) {
            return getErrorConfigVersion;
        }
        String str = getErrorConfigVersion;
        Object[] objArr = null;
        int length = objArr.length;
        return str;
    }

    public static final /* synthetic */ String access$getORGANIZER_PHONE_NUMBER$cp() {
        String str;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 123;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        if (!(i % 2 != 0)) {
            str = DatabaseTableConfigUtil;
        } else {
            str = DatabaseTableConfigUtil;
            int i2 = 48 / 0;
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 77;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
        if ((i3 % 2 != 0 ? 'T' : (char) 2) != 2) {
            Object obj = null;
            obj.hashCode();
            return str;
        }
        return str;
    }

    public static final /* synthetic */ StartParams access$getParams$p(FamilyTncConsentActivity familyTncConsentActivity) {
        StartParams startParams;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 27;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
        if ((i % 2 == 0 ? (char) 31 : '\f') != 31) {
            startParams = familyTncConsentActivity.PlaceComponentResult;
        } else {
            try {
                startParams = familyTncConsentActivity.PlaceComponentResult;
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 33;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i2 % 128;
        int i3 = i2 % 2;
        return startParams;
    }

    public static final /* synthetic */ void access$hideTncShimmering(FamilyTncConsentActivity familyTncConsentActivity) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 125;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
                int i2 = i % 2;
                familyTncConsentActivity.scheduleImpl();
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 45;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$initTncWebContentView(FamilyTncConsentActivity familyTncConsentActivity, String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 109;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        familyTncConsentActivity.getAuthRequestContext(str);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 23;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
        if (i3 % 2 == 0) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public static final /* synthetic */ void access$setMEMBER_LOCATION$cp(String str) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 59;
            NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
            if ((i % 2 == 0 ? (char) 3 : '\b') != 3) {
                PlaceComponentResult = str;
            } else {
                PlaceComponentResult = str;
                Object obj = null;
                obj.hashCode();
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 55;
            NetworkUserEntityData$$ExternalSyntheticLambda5 = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setMEMBER_NAME$cp(String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 11;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        if (!(i % 2 == 0)) {
            getAuthRequestContext = str;
            Object obj = null;
            obj.hashCode();
            return;
        }
        try {
            getAuthRequestContext = str;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setMEMBER_RELATIONSHIP$cp(String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 37;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        KClassImpl$Data$declaredNonStaticMembers$2 = str;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 59;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i3 % 128;
        if (i3 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static final /* synthetic */ void access$setORGANIZER_NAME$cp(String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 45;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        getErrorConfigVersion = str;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 117;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
        if (!(i3 % 2 == 0)) {
            int i4 = 73 / 0;
        }
    }

    public static final /* synthetic */ void access$setORGANIZER_PHONE_NUMBER$cp(String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 29;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        DatabaseTableConfigUtil = str;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 1;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void access$showDanaLoadingDialog(FamilyTncConsentActivity familyTncConsentActivity) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 35;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
        boolean z = i % 2 != 0;
        familyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda0();
        if (z) {
            return;
        }
        int i2 = 16 / 0;
    }

    public static final /* synthetic */ void access$showInvitationSuccessToast(FamilyTncConsentActivity familyTncConsentActivity) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 107;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
        char c = i % 2 == 0 ? (char) 16 : (char) 19;
        familyTncConsentActivity.lookAheadTest();
        if (c != 19) {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static final /* synthetic */ void access$showPageErrorAgreement(FamilyTncConsentActivity familyTncConsentActivity) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 121;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
        int i2 = i % 2;
        familyTncConsentActivity.GetContactSyncConfig();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 123;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static final /* synthetic */ void access$showTncShimmering(FamilyTncConsentActivity familyTncConsentActivity) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 119;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
                int i2 = i % 2;
                familyTncConsentActivity.DatabaseTableConfigUtil();
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 89;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$startPinChallenge(FamilyTncConsentActivity familyTncConsentActivity, InviteMemberModel inviteMemberModel, String str, String str2) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 9;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
        boolean z = i % 2 == 0;
        familyTncConsentActivity.BuiltInFictitiousFunctionClassFactory(inviteMemberModel, str, str2);
        if (z) {
            int i2 = 42 / 0;
        }
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 25;
            NetworkUserEntityData$$ExternalSyntheticLambda5 = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 14 : 'H') != 14) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$validateCheckboxTnc(FamilyTncConsentActivity familyTncConsentActivity, String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 65;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        char c = i % 2 != 0 ? '-' : '+';
        Object obj = null;
        familyTncConsentActivity.MyBillsEntityDataFactory(str);
        if (c != '+') {
            obj.hashCode();
        }
        try {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 63;
            NetworkUserEntityData$$ExternalSyntheticLambda5 = i2 % 128;
            if (!(i2 % 2 == 0)) {
                return;
            }
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final /* bridge */ /* synthetic */ ActivityFamilyTncConsentBinding inflateViewBinding() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 33;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            if ((i % 2 != 0 ? ':' : '0') != ':') {
                return inflateViewBinding();
            }
            int i2 = 18 / 0;
            return inflateViewBinding();
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
    
        if (r0 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0027, code lost:
    
        if ((r0 != null) != true) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0029, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
    
        r0 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 + 99;
        id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
    
        r3 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5 + 9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0041, code lost:
    
        id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0045, code lost:
    
        if ((r3 % 2) == 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0047, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0049, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004a, code lost:
    
        if (r3 == true) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004c, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004f, code lost:
    
        r2 = 73 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0050, code lost:
    
        return r0;
     */
    @kotlin.jvm.JvmName(name = "getPresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.familyaccount.contract.FamilyInvitationContract.Presenter getPresenter() {
        /*
            r5 = this;
            int r0 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3
            int r0 = r0 + 93
            int r1 = r0 % 128
            id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            r3 = 0
            if (r0 == 0) goto L20
            id.dana.familyaccount.contract.FamilyInvitationContract$Presenter r0 = r5.presenter     // Catch: java.lang.Exception -> L1e
            r3.hashCode()     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L29
            goto L3b
        L1c:
            r0 = move-exception
            throw r0
        L1e:
            r0 = move-exception
            goto L54
        L20:
            id.dana.familyaccount.contract.FamilyInvitationContract$Presenter r0 = r5.presenter
            if (r0 == 0) goto L26
            r4 = 1
            goto L27
        L26:
            r4 = 0
        L27:
            if (r4 == r2) goto L3b
        L29:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r0 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3     // Catch: java.lang.Exception -> L39
            int r0 = r0 + 99
            int r1 = r0 % 128
            id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5 = r1     // Catch: java.lang.Exception -> L39
            int r0 = r0 % 2
            return r3
        L39:
            r0 = move-exception
            goto L53
        L3b:
            int r3 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5     // Catch: java.lang.Exception -> L1e
            int r3 = r3 + 9
            int r4 = r3 % 128
            id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r4     // Catch: java.lang.Exception -> L39
            int r3 = r3 % 2
            if (r3 == 0) goto L49
            r3 = 1
            goto L4a
        L49:
            r3 = 0
        L4a:
            if (r3 == r2) goto L4d
            return r0
        L4d:
            r2 = 73
            int r2 = r2 / r1
            return r0
        L51:
            r0 = move-exception
            throw r0
        L53:
            throw r0
        L54:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.invite.FamilyTncConsentActivity.getPresenter():id.dana.familyaccount.contract.FamilyInvitationContract$Presenter");
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(FamilyInvitationContract.Presenter presenter) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 119;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
        if ((i % 2 == 0 ? (char) 22 : 'D') != 'D') {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.presenter = presenter;
            int i2 = 44 / 0;
        } else {
            try {
                Intrinsics.checkNotNullParameter(presenter, "");
                this.presenter = presenter;
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 109;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
    
        if ((r0 != null ? '4' : ':') != '4') goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002f, code lost:
    
        if ((r0 != null ? 20 : 3) != 20) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0031, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0039, code lost:
    
        r1 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5 + 19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0041, code lost:
    
        if ((r1 % 2) == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0043, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0049, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004b, code lost:
    
        throw r0;
     */
    @kotlin.jvm.JvmName(name = "getFamilyAccountAnalyticalTracker")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker getFamilyAccountAnalyticalTracker() {
        /*
            r4 = this;
            int r0 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5     // Catch: java.lang.Exception -> L4e
            int r0 = r0 + 77
            int r1 = r0 % 128
            id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r1     // Catch: java.lang.Exception -> L4e
            int r0 = r0 % 2
            r1 = 95
            if (r0 == 0) goto L11
            r0 = 95
            goto L13
        L11:
            r0 = 9
        L13:
            r2 = 0
            if (r0 == r1) goto L24
            id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker r0 = r4.familyAccountAnalyticalTracker     // Catch: java.lang.Exception -> L4e
            r1 = 52
            if (r0 == 0) goto L1f
            r3 = 52
            goto L21
        L1f:
            r3 = 58
        L21:
            if (r3 == r1) goto L37
            goto L31
        L24:
            id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker r0 = r4.familyAccountAnalyticalTracker
            int r1 = r2.length     // Catch: java.lang.Throwable -> L4c
            r1 = 20
            if (r0 == 0) goto L2e
            r3 = 20
            goto L2f
        L2e:
            r3 = 3
        L2f:
            if (r3 == r1) goto L37
        L31:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r2
        L37:
            int r1 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5     // Catch: java.lang.Exception -> L4a
            int r1 = r1 + 19
            int r3 = r1 % 128
            id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r3     // Catch: java.lang.Exception -> L4e
            int r1 = r1 % 2
            if (r1 == 0) goto L49
            r2.hashCode()     // Catch: java.lang.Throwable -> L47
            goto L49
        L47:
            r0 = move-exception
            throw r0
        L49:
            return r0
        L4a:
            r0 = move-exception
            throw r0
        L4c:
            r0 = move-exception
            throw r0
        L4e:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.invite.FamilyTncConsentActivity.getFamilyAccountAnalyticalTracker():id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker");
    }

    @JvmName(name = "setFamilyAccountAnalyticalTracker")
    public final void setFamilyAccountAnalyticalTracker(FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 73;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        if (!(i % 2 != 0)) {
            Intrinsics.checkNotNullParameter(familyAccountAnalyticalTracker, "");
            this.familyAccountAnalyticalTracker = familyAccountAnalyticalTracker;
            return;
        }
        Intrinsics.checkNotNullParameter(familyAccountAnalyticalTracker, "");
        this.familyAccountAnalyticalTracker = familyAccountAnalyticalTracker;
        Object obj = null;
        obj.hashCode();
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    private final DanaLoadingDialog BuiltInFictitiousFunctionClassFactory() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 117;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
        if ((i % 2 == 0 ? '3' : '.') != '3') {
            try {
                try {
                    return (DanaLoadingDialog) this.BuiltInFictitiousFunctionClassFactory.getValue();
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        DanaLoadingDialog danaLoadingDialog = (DanaLoadingDialog) this.BuiltInFictitiousFunctionClassFactory.getValue();
        Object[] objArr = null;
        int length = objArr.length;
        return danaLoadingDialog;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityFamilyTncConsentBinding inflateViewBinding() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 105;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        if ((i % 2 != 0 ? (char) 17 : 'B') != 17) {
            ActivityFamilyTncConsentBinding PlaceComponentResult2 = ActivityFamilyTncConsentBinding.PlaceComponentResult(getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
            return PlaceComponentResult2;
        }
        try {
            ActivityFamilyTncConsentBinding PlaceComponentResult3 = ActivityFamilyTncConsentBinding.PlaceComponentResult(getLayoutInflater());
            try {
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult3, "");
                Object obj = null;
                obj.hashCode();
                return PlaceComponentResult3;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 97;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
        int i2 = i % 2;
        getPresenter().PlaceComponentResult();
        Parcelable parcelableExtra = getIntent().getParcelableExtra("startParams");
        Intrinsics.checkNotNull(parcelableExtra);
        this.PlaceComponentResult = (StartParams) parcelableExtra;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 1;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 39 / 0;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 71;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
        int i2 = i % 2;
        DaggerFamilyAccountInvitationComponent.Builder PlaceComponentResult2 = DaggerFamilyAccountInvitationComponent.PlaceComponentResult();
        Application application = getApplication();
        if (!(application != null)) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        try {
            try {
                PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) application).getApplicationComponent());
                PlaceComponentResult2.getAuthRequestContext = (FamilyAccountInvitationModule) Preconditions.getAuthRequestContext(PlaceComponentResult());
                PlaceComponentResult2.MyBillsEntityDataFactory().getAuthRequestContext(this);
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 111;
                NetworkUserEntityData$$ExternalSyntheticLambda5 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 61;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
        int i2 = i % 2;
        moveToNextValue();
        getErrorConfigVersion();
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 19;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void moveToNextValue() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 63;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
        int i2 = i % 2;
        LayoutToolbarBinding layoutToolbarBinding = getBinding().BuiltInFictitiousFunctionClassFactory;
        TextView textView = layoutToolbarBinding.initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
        ImageView imageView = layoutToolbarBinding.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(8);
        layoutToolbarBinding.initRecordTimeStamp.setText(getString(R.string.family_account_text_title_toolbar_invite_members));
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 43;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
        if ((i3 % 2 != 0 ? 'H' : 'S') != 'H') {
            return;
        }
        int i4 = 37 / 0;
    }

    private final void getErrorConfigVersion() {
        ImageButton imageButton;
        LayoutToolbarBinding layoutToolbarBinding = getBinding().BuiltInFictitiousFunctionClassFactory;
        layoutToolbarBinding.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationIcon(R.drawable.btn_arrow_left);
        layoutToolbarBinding.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.invite.FamilyTncConsentActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyTncConsentActivity.$r8$lambda$Xcfl1Io8GR9qTRIr_vwM99vsaUM(FamilyTncConsentActivity.this, view);
            }
        });
        Toolbar toolbar = layoutToolbarBinding.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        Iterator<View> it = ViewGroupKt.BuiltInFictitiousFunctionClassFactory(toolbar).iterator();
        while (true) {
            if (!(!it.hasNext())) {
                View next = it.next();
                if ((next instanceof ImageButton ? 'T' : '!') != '!') {
                    int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 45;
                    NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
                    int i2 = i % 2;
                    imageButton = (ImageButton) next;
                } else {
                    imageButton = null;
                }
                if (imageButton != null) {
                    imageButton.setContentDescription(getResources().getString(R.string.imgBtnLeft));
                }
            } else {
                TextView textView = layoutToolbarBinding.NetworkUserEntityData$$ExternalSyntheticLambda0;
                Intrinsics.checkNotNullExpressionValue(textView, "");
                textView.setVisibility(4);
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 19;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
                int i4 = i3 % 2;
                return;
            }
        }
    }

    private static final void PlaceComponentResult(FamilyTncConsentActivity familyTncConsentActivity) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 45;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(familyTncConsentActivity, "");
        familyTncConsentActivity.getOnBackPressedDispatcher().KClassImpl$Data$declaredNonStaticMembers$2();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 89;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
        if ((i3 % 2 != 0 ? 'I' : (char) 30) != 'I') {
            return;
        }
        int i4 = 25 / 0;
    }

    private final FamilyAccountInvitationModule PlaceComponentResult() {
        FamilyAccountInvitationModule familyAccountInvitationModule = new FamilyAccountInvitationModule(new FamilyInvitationContract.View() { // from class: id.dana.familyaccount.view.invite.FamilyTncConsentActivity$getFamilyAccountInvitationModule$1
            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final /* synthetic */ void PlaceComponentResult(QuestionnaireDataConfig questionnaireDataConfig) {
                FamilyInvitationContract.View.CC.BuiltInFictitiousFunctionClassFactory(questionnaireDataConfig);
            }

            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final /* synthetic */ void PlaceComponentResult(RecipientModel recipientModel) {
                Intrinsics.checkNotNullParameter(recipientModel, "");
            }

            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final /* synthetic */ void getAuthRequestContext(String str) {
                FamilyInvitationContract.View.CC.MyBillsEntityDataFactory(str);
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
            public final void MyBillsEntityDataFactory(ConsultAgreementResponse p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                FamilyTncConsentActivity familyTncConsentActivity = FamilyTncConsentActivity.this;
                List<AgreementInfo> agreementInfos = p0.getAgreementInfos();
                if (agreementInfos != null) {
                    for (AgreementInfo agreementInfo : agreementInfos) {
                        String contentValue = agreementInfo.getContentValue();
                        if (contentValue != null) {
                            FamilyTncConsentActivity.access$initTncWebContentView(familyTncConsentActivity, contentValue);
                        }
                        String agreementKey = agreementInfo.getAgreementKey();
                        if (agreementKey != null) {
                            FamilyTncConsentActivity.access$validateCheckboxTnc(familyTncConsentActivity, agreementKey);
                        }
                    }
                }
            }

            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final void getAuthRequestContext(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                FamilyTncConsentActivity.access$showPageErrorAgreement(FamilyTncConsentActivity.this);
            }

            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final void MyBillsEntityDataFactory() {
                FamilyInvitationContract.Presenter presenter = FamilyTncConsentActivity.this.getPresenter();
                FamilyTncConsentActivity.StartParams access$getParams$p = FamilyTncConsentActivity.access$getParams$p(FamilyTncConsentActivity.this);
                FamilyTncConsentActivity.StartParams startParams = null;
                if (access$getParams$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    access$getParams$p = null;
                }
                String str = access$getParams$p.PlaceComponentResult;
                FamilyTncConsentActivity.StartParams access$getParams$p2 = FamilyTncConsentActivity.access$getParams$p(FamilyTncConsentActivity.this);
                if (access$getParams$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    access$getParams$p2 = null;
                }
                String str2 = access$getParams$p2.MyBillsEntityDataFactory;
                FamilyTncConsentActivity.StartParams access$getParams$p3 = FamilyTncConsentActivity.access$getParams$p(FamilyTncConsentActivity.this);
                if (access$getParams$p3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    startParams = access$getParams$p3;
                }
                presenter.PlaceComponentResult(new InviteMemberModel(false, str, str2, startParams.getAuthRequestContext, "", ""));
            }

            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final void MyBillsEntityDataFactory(InviteMemberModel p0, String p1, String p2) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                FamilyTncConsentActivity.access$startPinChallenge(FamilyTncConsentActivity.this, p0, p1, p2);
            }

            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final void PlaceComponentResult(InviteMemberModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                FamilyTncConsentActivity.access$showInvitationSuccessToast(FamilyTncConsentActivity.this);
            }

            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final void BuiltInFictitiousFunctionClassFactory(InviteMemberModel p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                FamilyTncConsentActivity.this.showInvitationFailToast(p1);
            }

            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final void PlaceComponentResult() {
                FamilyTncConsentActivity.access$showTncShimmering(FamilyTncConsentActivity.this);
            }

            @Override // id.dana.familyaccount.contract.FamilyInvitationContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                FamilyTncConsentActivity.access$hideTncShimmering(FamilyTncConsentActivity.this);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                FamilyTncConsentActivity.access$showDanaLoadingDialog(FamilyTncConsentActivity.this);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                FamilyTncConsentActivity.access$dismissDanaLoadingDialog(FamilyTncConsentActivity.this);
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 55;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
        int i2 = i % 2;
        return familyAccountInvitationModule;
    }

    private final void GetContactSyncConfig() {
        NestedScrollView nestedScrollView = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(nestedScrollView, "");
        nestedScrollView.setVisibility(8);
        StatusInformationView statusInformationView = getBinding().lookAheadTest;
        Intrinsics.checkNotNullExpressionValue(statusInformationView, "");
        statusInformationView.setVisibility(0);
        statusInformationView.setStatusInformationType(StatusInformationType.GENERAL_STATUS_ERROR);
        statusInformationView.setGotItButtonListener(new Function0<Unit>() { // from class: id.dana.familyaccount.view.invite.FamilyTncConsentActivity$showPageErrorAgreement$1$1
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
                FamilyTncConsentActivity.this.getPresenter().PlaceComponentResult();
                StatusInformationView statusInformationView2 = FamilyTncConsentActivity.access$getBinding(FamilyTncConsentActivity.this).lookAheadTest;
                Intrinsics.checkNotNullExpressionValue(statusInformationView2, "");
                statusInformationView2.setVisibility(8);
            }
        });
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 85;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void scheduleImpl() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 91;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
        int i2 = i % 2;
        SkeletonScreen skeletonScreen = this.MyBillsEntityDataFactory;
        if ((skeletonScreen != null ? (char) 20 : '(') != '(') {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 113;
            NetworkUserEntityData$$ExternalSyntheticLambda5 = i3 % 128;
            int i4 = i3 % 2;
            try {
                skeletonScreen.PlaceComponentResult();
                int i5 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 1;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i5 % 128;
                int i6 = i5 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        NestedScrollView nestedScrollView = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(nestedScrollView, "");
        nestedScrollView.setVisibility(0);
    }

    private final void BuiltInFictitiousFunctionClassFactory(InviteMemberModel p0, String p1, String p2) {
        ChallengeControl.Builder builder = new ChallengeControl.Builder(this);
        builder.scheduleImpl = "family_account";
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = "family_account";
        new ChallengeControl(builder.PlaceComponentResult(p0, p1, p2), null).getAuthRequestContext();
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 47;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0058, code lost:
    
        if (r5 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
    
        if ((r5 != null) != true) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
    
        r3 = r5.getExtras();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
    
        if (r3 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006b, code lost:
    
        r3 = r3.getString(id.dana.challenge.ChallengeControl.Key.CANCEL_REASON);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0072, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0079, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r3, "back") != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0083, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r3, "close") != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0085, code lost:
    
        r5 = '7';
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0088, code lost:
    
        r5 = 'Q';
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008a, code lost:
    
        if (r5 == '7') goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008d, code lost:
    
        r5 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5 + 31;
        id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r5 % 128;
        r5 = r5 % 2;
        showInvitationFailToast(r3);
        r3 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 + 25;
        id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5 = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a4, code lost:
    
        PlaceComponentResult(false);
        r3 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5 + 45;
        id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b1, code lost:
    
        return;
     */
    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onActivityResult(int r3, int r4, android.content.Intent r5) {
        /*
            r2 = this;
            super.onActivityResult(r3, r4, r5)
            r0 = 1008(0x3f0, float:1.413E-42)
            if (r3 != r0) goto Lb1
            r3 = -1
            r0 = 17
            if (r4 == r3) goto Lf
            r3 = 17
            goto L11
        Lf:
            r3 = 56
        L11:
            r1 = 1
            if (r3 == r0) goto L41
            r2.lookAheadTest()
            r2.PlaceComponentResult(r1)
            android.content.Intent r3 = new android.content.Intent
            r4 = r2
            android.content.Context r4 = (android.content.Context) r4
            java.lang.Class<id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity> r5 = id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity.class
            r3.<init>(r4, r5)
            id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$StartParams r4 = new id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$StartParams
            java.lang.String r5 = "SUCCESS"
            java.lang.String r0 = ""
            r4.<init>(r5, r0)
            android.os.Parcelable r4 = (android.os.Parcelable) r4
            java.lang.String r5 = "startParams"
            r3.putExtra(r5, r4)
            r4 = 67108864(0x4000000, float:1.5046328E-36)
            r3.setFlags(r4)
            r2.startActivity(r3)
            r2.finish()
            goto Lb1
        L41:
            if (r4 != 0) goto Lb1
            int r3 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3
            int r3 = r3 + 101
            int r4 = r3 % 128
            id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5 = r4
            int r3 = r3 % 2
            r4 = 0
            if (r3 != 0) goto L52
            r3 = 1
            goto L53
        L52:
            r3 = 0
        L53:
            if (r3 == 0) goto L5d
            r3 = 39
            int r3 = r3 / r4
            if (r5 == 0) goto L72
            goto L65
        L5b:
            r3 = move-exception
            throw r3
        L5d:
            if (r5 == 0) goto L61
            r3 = 1
            goto L62
        L61:
            r3 = 0
        L62:
            if (r3 == r1) goto L65
            goto L72
        L65:
            android.os.Bundle r3 = r5.getExtras()
            if (r3 == 0) goto L72
            java.lang.String r5 = "cancel_reason"
            java.lang.String r3 = r3.getString(r5)
            goto L73
        L72:
            r3 = 0
        L73:
            java.lang.String r5 = "back"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r5)
            if (r5 != 0) goto La4
            java.lang.String r5 = "close"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r5)
            r0 = 55
            if (r5 != 0) goto L88
            r5 = 55
            goto L8a
        L88:
            r5 = 81
        L8a:
            if (r5 == r0) goto L8d
            goto La4
        L8d:
            int r5 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5
            int r5 = r5 + 31
            int r0 = r5 % 128
            id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r0
            int r5 = r5 % 2
            r2.showInvitationFailToast(r3)
            int r3 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3
            int r3 = r3 + 25
            int r5 = r3 % 128
            id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5 = r5
            int r3 = r3 % 2
        La4:
            r2.PlaceComponentResult(r4)
            int r3 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5
            int r3 = r3 + 45
            int r4 = r3 % 128
            id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r4
            int r3 = r3 % 2
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.invite.FamilyTncConsentActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    private final void lookAheadTest() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 19;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        DANAToast dANAToast = DANAToast.PlaceComponentResult;
        String string = getString(R.string.dialog_invitation_success);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = getString(R.string.toast_invite_success);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        DANAToast.PlaceComponentResult(this, string, string2);
        StartParams startParams = this.PlaceComponentResult;
        if ((startParams == null ? (char) 2 : JSONLexer.EOI) != 26) {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 9;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            int i4 = i3 % 2;
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams = null;
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 83;
            NetworkUserEntityData$$ExternalSyntheticLambda5 = i5 % 128;
            int i6 = i5 % 2;
        }
        getAuthRequestContext(startParams.MyBillsEntityDataFactory, startParams.getAuthRequestContext);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:
    
        if (((r3 & 1) != 0 ? 'R' : 23) != 23) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0029, code lost:
    
        if (((r3 ^ 1) != 0 ? 'P' : 'B') != 'B') goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002b, code lost:
    
        r2 = null;
        r3 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5 + 83;
        id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0036, code lost:
    
        r1.showInvitationFailToast(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003a, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003b, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void showInvitationFailToast$default(id.dana.familyaccount.view.invite.FamilyTncConsentActivity r1, java.lang.String r2, int r3, java.lang.Object r4) {
        /*
            int r4 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3     // Catch: java.lang.Exception -> L3c
            int r4 = r4 + 69
            int r0 = r4 % 128
            id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5 = r0     // Catch: java.lang.Exception -> L3c
            int r4 = r4 % 2
            r0 = 1
            if (r4 != 0) goto Lf
            r4 = 1
            goto L10
        Lf:
            r4 = 0
        L10:
            if (r4 == r0) goto L1f
            r3 = r3 & r0
            r4 = 23
            if (r3 == 0) goto L1a
            r3 = 82
            goto L1c
        L1a:
            r3 = 23
        L1c:
            if (r3 == r4) goto L36
            goto L2b
        L1f:
            r3 = r3 ^ r0
            r4 = 66
            if (r3 == 0) goto L27
            r3 = 80
            goto L29
        L27:
            r3 = 66
        L29:
            if (r3 == r4) goto L36
        L2b:
            r2 = 0
            int r3 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5
            int r3 = r3 + 83
            int r4 = r3 % 128
            id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r4
            int r3 = r3 % 2
        L36:
            r1.showInvitationFailToast(r2)     // Catch: java.lang.Exception -> L3a
            return
        L3a:
            r1 = move-exception
            throw r1
        L3c:
            r1 = move-exception
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.invite.FamilyTncConsentActivity.showInvitationFailToast$default(id.dana.familyaccount.view.invite.FamilyTncConsentActivity, java.lang.String, int, java.lang.Object):void");
    }

    public final void showInvitationFailToast(String message) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 21;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        DANAToast dANAToast = DANAToast.PlaceComponentResult;
        FamilyTncConsentActivity familyTncConsentActivity = this;
        if (!(message != null)) {
            message = getResources().getString(R.string.family_account_general_toast_error);
            Intrinsics.checkNotNullExpressionValue(message, "");
        }
        DANAToast.PlaceComponentResult(familyTncConsentActivity, message);
        StartParams startParams = this.PlaceComponentResult;
        Object[] objArr = null;
        if ((startParams == null ? 'T' : (char) 29) == 'T') {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 123;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            if (i3 % 2 != 0) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                int length = objArr.length;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 117;
            NetworkUserEntityData$$ExternalSyntheticLambda5 = i4 % 128;
            int i5 = i4 % 2;
            startParams = null;
        }
        BuiltInFictitiousFunctionClassFactory(startParams.MyBillsEntityDataFactory, startParams.getAuthRequestContext);
    }

    private final void getAuthRequestContext(String p0) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 117;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        String str = getErrorConfigVersion;
        StartParams startParams = this.PlaceComponentResult;
        StartParams startParams2 = null;
        if (!(startParams != null)) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams = null;
        }
        String replace$default = StringsKt.replace$default(p0, str, startParams.BuiltInFictitiousFunctionClassFactory, false, 4, (Object) null);
        String str2 = getAuthRequestContext;
        StartParams startParams3 = this.PlaceComponentResult;
        if (startParams3 == null) {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 1;
            NetworkUserEntityData$$ExternalSyntheticLambda5 = i3 % 128;
            int i4 = i3 % 2;
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams3 = null;
        }
        String replace$default2 = StringsKt.replace$default(replace$default, str2, startParams3.KClassImpl$Data$declaredNonStaticMembers$2, false, 4, (Object) null);
        String str3 = KClassImpl$Data$declaredNonStaticMembers$2;
        StartParams startParams4 = this.PlaceComponentResult;
        if (startParams4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams4 = null;
        }
        String replace$default3 = StringsKt.replace$default(replace$default2, str3, startParams4.MyBillsEntityDataFactory, false, 4, (Object) null);
        String str4 = PlaceComponentResult;
        StartParams startParams5 = this.PlaceComponentResult;
        if (startParams5 == null) {
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 59;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i5 % 128;
            if (i5 % 2 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
                int i6 = 75 / 0;
            }
        } else {
            startParams2 = startParams5;
        }
        String replace$default4 = StringsKt.replace$default(replace$default3, str4, startParams2.getAuthRequestContext, false, 4, (Object) null);
        WebView webView = getBinding().moveToNextValue;
        InstrumentInjector.trackWebView(webView);
        Object[] objArr = new Object[1];
        a(super.getResources().getString(R.string.bottom_on_boarding_title_dana_kaget).substring(1, 2).codePointAt(0) - 96, new char[]{56134, 29596, 13348, 59744, 64301, 63765}, objArr);
        webView.loadData(replace$default4, "text/html", ((String) objArr[0]).intern());
        scheduleImpl();
    }

    private final void MyBillsEntityDataFactory(final String p0) {
        try {
            try {
                getBinding().MyBillsEntityDataFactory.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.familyaccount.view.invite.FamilyTncConsentActivity$$ExternalSyntheticLambda1
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        FamilyTncConsentActivity.$r8$lambda$srsJzOsRjGhC5QSBIA0tuXR0cdA(FamilyTncConsentActivity.this, p0, compoundButton, z);
                    }
                });
                int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 101;
                NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
                if ((i % 2 == 0 ? '9' : '-') != '9') {
                    return;
                }
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        if (r7 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        if (r7 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        r7 = r7.BuiltInFictitiousFunctionClassFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        r8 = r12.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        if (r8 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
    
        r10 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        r10 = '0';
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
    
        if (r10 == '0') goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
    
        r8 = r8.lookAheadTest;
        r9 = r12.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        if (r9 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
    
        r9 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 + 29;
        id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5 = r9 % 128;
        r9 = r9 % 2;
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
    
        r9 = r9.PlaceComponentResult;
        r10 = r12.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0064, code lost:
    
        if (r10 != null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0066, code lost:
    
        r10 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 + 75;
        id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5 = r10 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0070, code lost:
    
        if ((r10 % 2) != 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0072, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0075, code lost:
    
        r5.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007c, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007f, code lost:
    
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0080, code lost:
    
        r10 = r10.MyBillsEntityDataFactory;
        r0 = r12.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0084, code lost:
    
        if (r0 != null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0086, code lost:
    
        r0 = id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 + 67;
        id.dana.familyaccount.view.invite.FamilyTncConsentActivity.NetworkUserEntityData$$ExternalSyntheticLambda5 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0090, code lost:
    
        if ((r0 % 2) != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0093, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0094, code lost:
    
        if (r4 == true) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0096, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0099, code lost:
    
        r5.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a0, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a4, code lost:
    
        r5 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a5, code lost:
    
        r2.KClassImpl$Data$declaredNonStaticMembers$2(r13, r14, r7, r8, r9, r10, r5.MyBillsEntityDataFactory);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b2, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void MyBillsEntityDataFactory(id.dana.familyaccount.view.invite.FamilyTncConsentActivity r12, java.lang.String r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 186
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.invite.FamilyTncConsentActivity.MyBillsEntityDataFactory(id.dana.familyaccount.view.invite.FamilyTncConsentActivity, java.lang.String, boolean):void");
    }

    private static final void BuiltInFictitiousFunctionClassFactory(final FamilyTncConsentActivity familyTncConsentActivity, final String str, final boolean z) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 41;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(familyTncConsentActivity, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (z) {
            DanaButtonPrimaryView danaButtonPrimaryView = familyTncConsentActivity.getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
            danaButtonPrimaryView.setActiveButton(familyTncConsentActivity.getString(R.string.family_account_text_continue), null);
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.invite.FamilyTncConsentActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FamilyTncConsentActivity.m2596$r8$lambda$ZFuxJ5kaTS7gu8qRLuTqIal3lA(FamilyTncConsentActivity.this, str, z, view);
                }
            });
            danaButtonPrimaryView.setEnabled(true);
            return;
        }
        DanaButtonPrimaryView danaButtonPrimaryView2 = familyTncConsentActivity.getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        danaButtonPrimaryView2.setDisabled(familyTncConsentActivity.getString(R.string.family_account_text_continue));
        danaButtonPrimaryView2.setEnabled(false);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 61;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
        if (i3 % 2 == 0) {
            return;
        }
        int i4 = 40 / 0;
    }

    private final void getAuthRequestContext(String p0, String p1) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 65;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            if (!(i % 2 == 0)) {
                int i2 = 56 / 0;
                if ((p0 != null ? '!' : 'V') == 'V') {
                    return;
                }
            } else {
                if (!(p0 != null)) {
                    return;
                }
            }
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 17;
            NetworkUserEntityData$$ExternalSyntheticLambda5 = i3 % 128;
            int i4 = i3 % 2;
            if (p1 != null) {
                try {
                    getFamilyAccountAnalyticalTracker().MyBillsEntityDataFactory(p0, p1);
                    int i5 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 67;
                    NetworkUserEntityData$$ExternalSyntheticLambda5 = i5 % 128;
                    int i6 = i5 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 75;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            int i2 = i % 2;
            if ((p0 != null ? (char) 2 : 'J') != 'J') {
                try {
                    int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 41;
                    NetworkUserEntityData$$ExternalSyntheticLambda5 = i3 % 128;
                    if (i3 % 2 == 0) {
                        Object obj = null;
                        obj.hashCode();
                        if (p1 == null) {
                            return;
                        }
                    } else {
                        if ((p1 != null ? 'P' : '\n') == '\n') {
                            return;
                        }
                    }
                    getFamilyAccountAnalyticalTracker().BuiltInFictitiousFunctionClassFactory(p0, p1);
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void MyBillsEntityDataFactory() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 67;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        try {
            BuiltInFictitiousFunctionClassFactory().PlaceComponentResult();
            try {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 101;
                NetworkUserEntityData$$ExternalSyntheticLambda5 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void PlaceComponentResult(boolean p0) {
        Intent intent = new Intent();
        intent.putExtra(FamilyInviteMemberActivity.IS_MEMBER_INVITED, p0);
        setResult(-1, intent);
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 63;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 11;
            NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
            Object[] objArr = null;
            if ((i % 2 == 0 ? '.' : 'U') != '.') {
                super.onDestroy();
                getPresenter().onDestroy();
            } else {
                super.onDestroy();
                getPresenter().onDestroy();
                objArr.hashCode();
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 27;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i2 % 128;
            if ((i2 % 2 != 0 ? 'Z' : '-') != 'Z') {
                return;
            }
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0006\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0012\u0010\u0007\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0012\u0010\b\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\u0005\u0010\nR\u001a\u0010\u0005\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\u0007\u0010\n"}, d2 = {"Lid/dana/familyaccount/view/invite/FamilyTncConsentActivity$Companion;", "", "", "EXTRA_START_PARAMS", "Ljava/lang/String;", "PlaceComponentResult", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "getErrorConfigVersion", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "DatabaseTableConfigUtil", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "PlaceComponentResult")
        public static String PlaceComponentResult() {
            return FamilyTncConsentActivity.access$getORGANIZER_NAME$cp();
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        public static String BuiltInFictitiousFunctionClassFactory() {
            return FamilyTncConsentActivity.access$getORGANIZER_PHONE_NUMBER$cp();
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    static {
        NetworkUserEntityData$$ExternalSyntheticLambda5 = 1;
        getAuthRequestContext();
        lookAheadTest = new byte[]{117, -10, 119, -11, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
        scheduleImpl = 48;
        KClassImpl$Data$declaredNonStaticMembers$2();
        ?? r1 = 0;
        INSTANCE = new Companion(r1);
        getErrorConfigVersion = "organizer-name";
        DatabaseTableConfigUtil = "organizer-phone";
        getAuthRequestContext = "member-name";
        KClassImpl$Data$declaredNonStaticMembers$2 = "member-relationship";
        PlaceComponentResult = "member-location";
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 21;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
        if ((i % 2 == 0 ? (char) 27 : '7') != '7') {
            int length = r1.length;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u001b\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\u0006\u0010\u001d\u001a\u00020\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0013\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014"}, d2 = {"Lid/dana/familyaccount/view/invite/FamilyTncConsentActivity$StartParams;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getAuthRequestContext", "MyBillsEntityDataFactory", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "moveToNextValue", "lookAheadTest", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class StartParams implements Parcelable {
        public static final Parcelable.Creator<StartParams> CREATOR = new Creator();
        final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final String getAuthRequestContext;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;
        final String PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        final String lookAheadTest;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof StartParams) {
                StartParams startParams = (StartParams) p0;
                return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, startParams.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.lookAheadTest, startParams.lookAheadTest) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, startParams.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, startParams.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getAuthRequestContext, startParams.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, startParams.PlaceComponentResult);
            }
            return false;
        }

        public final int hashCode() {
            return (((((((((this.BuiltInFictitiousFunctionClassFactory.hashCode() * 31) + this.lookAheadTest.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.PlaceComponentResult.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("StartParams(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", lookAheadTest=");
            sb.append(this.lookAheadTest);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
            p0.writeString(this.lookAheadTest);
            p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
            p0.writeString(this.MyBillsEntityDataFactory);
            p0.writeString(this.getAuthRequestContext);
            p0.writeString(this.PlaceComponentResult);
        }

        public StartParams(String str, String str2, String str3, String str4, String str5, String str6) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            Intrinsics.checkNotNullParameter(str6, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.lookAheadTest = str2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
            this.MyBillsEntityDataFactory = str4;
            this.getAuthRequestContext = str5;
            this.PlaceComponentResult = str6;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<StartParams> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ StartParams createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new StartParams(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ StartParams[] newArray(int i) {
                return new StartParams[i];
            }
        }
    }

    private final void DatabaseTableConfigUtil() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda5 + 69;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        this.MyBillsEntityDataFactory = ShimmeringUtil.PlaceComponentResult(getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0, R.layout.view_family_tnc_consent_skeleton);
        NestedScrollView nestedScrollView = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(nestedScrollView, "");
        nestedScrollView.setVisibility(8);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 55;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        DanaLoadingDialog BuiltInFictitiousFunctionClassFactory;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 93;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? 'I' : 'X') != 'X') {
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
            boolean isShowing = BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.isShowing();
            int length = objArr.length;
            if ((!isShowing ? (char) 4 : 'Y') != 4) {
                return;
            }
        } else {
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
            if (BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.isShowing()) {
                return;
            }
        }
        try {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda5 + 65;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i2 % 128;
            if ((i2 % 2 != 0 ? '\f' : ')') != ')') {
                BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.show();
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.startRefresh();
                int length2 = objArr.length;
            } else {
                BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.show();
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.startRefresh();
            }
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 27;
            NetworkUserEntityData$$ExternalSyntheticLambda5 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void b(char[] cArr, char[] cArr2, int i, char c, char[] cArr3, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        int i2 = $10 + 7;
        $11 = i2 % 128;
        while (true) {
            int i3 = i2 % 2;
            if (e.KClassImpl$Data$declaredNonStaticMembers$2 >= length3) {
                break;
            }
            int i4 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i5 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i4]) % 65535);
            cArr5[i5] = (char) (((cArr4[i5] * 32718) + cArr5[i4]) / 65535);
            cArr4[i5] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i5] ^ cArr3[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (initRecordTimeStamp ^ 4360990799332652212L)) ^ ((int) (PrepareContext ^ 4360990799332652212L))) ^ ((char) (newProxyInstance ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
            i2 = $11 + 63;
            $10 = i2 % 128;
        }
        String str = new String(cArr6);
        int i6 = $11 + 73;
        $10 = i6 % 128;
        if (i6 % 2 == 0) {
            objArr[0] = str;
            return;
        }
        Object obj = null;
        obj.hashCode();
        objArr[0] = str;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (true) {
            if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? 'O' : '_') != 'O') {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
            int i2 = $11 + 73;
            $10 = i2 % 128;
            int i3 = 58224;
            if ((i2 % 2 != 0 ? '1' : '\t') != '\t') {
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory * 0];
            } else {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            }
            int i4 = 0;
            while (true) {
                if (!(i4 < 16)) {
                    break;
                }
                int i5 = $10 + 55;
                $11 = i5 % 128;
                int i6 = i5 % 2;
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i3) ^ ((cArr3[0] << 4) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda7 ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (FragmentBottomSheetPaymentSettingBinding ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i3) ^ ((cArr3[1] << 4) + ((char) (isLayoutRequested ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda8 ^ 6353485791441662354L)))));
                i3 -= 40503;
                i4++;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
    }
}
