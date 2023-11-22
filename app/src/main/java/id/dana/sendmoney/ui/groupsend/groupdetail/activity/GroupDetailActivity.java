package id.dana.sendmoney.ui.groupsend.groupdetail.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ComponentActivity;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelKt;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContract;
import androidx.view.result.contract.ActivityResultContracts;
import androidx.view.viewmodel.CreationExtras;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.dialog.DanaLogoLoadingDialog;
import id.dana.core.ui.util.DANAToast;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.recentrecipient.interactor.RemoveRecentGroup;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.sendmoney.databinding.ActivityGroupDetailBinding;
import id.dana.sendmoney.di.component.GroupSendComponent;
import id.dana.sendmoney.di.provider.GroupSendComponentProvider;
import id.dana.sendmoney.domain.groupsend.GroupSendOperationType;
import id.dana.sendmoney.domain.groupsend.interactor.DeleteGroup;
import id.dana.sendmoney.domain.groupsend.interactor.ModifyGroupImage;
import id.dana.sendmoney.domain.groupsend.model.modify.BizGroupModifyResult;
import id.dana.sendmoney.ui.groupsend.groupdetail.adapter.GroupDetailAdapter;
import id.dana.sendmoney.ui.groupsend.groupdetail.model.BizGroupDetailResultModel;
import id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailUiState;
import id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel;
import id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$getTotalFavoriteAccountCount$1;
import id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity;
import id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import id.dana.sendmoney.ui.groupsend.summary.model.GroupSendIntentModel;
import id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetImagePickerDialogFragment;
import id.dana.sendmoney.util.GroupSendTrackerHelper;
import id.dana.sendmoney.util.SourceTypeProperty;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Typography;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 E2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001EB\u0007¢\u0006\u0004\bD\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u0005R\u0016\u0010\n\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0013\u0010\f\u001a\u00020\u0010X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u000e\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\u0015\u001a\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\u0011\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u0010\u0019\u001a\u0002008\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002008\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b3\u00102R\u0016\u0010'\u001a\u00020#8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b5\u0010%R\u0016\u0010\u001d\u001a\u0002068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u001e\u0010 \u001a\f\u0012\b\u0012\u0006*\u00020\u00140\u00140\u00138\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b9\u0010\u0016R\u0016\u0010$\u001a\u0002068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b:\u00108R\"\u0010<\u001a\u00020;8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0013\u00101\u001a\u00020BX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bC\u0010\u0012"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/activity/GroupDetailActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/sendmoney/databinding/ActivityGroupDetailBinding;", "", "configToolbar", "()V", "inflateViewBinding", "()Lid/dana/sendmoney/databinding/ActivityGroupDetailBinding;", IAPSyncCommand.COMMAND_INIT, "initComponent", "getAuthRequestContext", "onBackPressed", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/ui/groupsend/groupdetail/model/BizGroupDetailResultModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/ui/groupsend/groupdetail/model/BizGroupDetailResultModel;", "Lid/dana/core/ui/dialog/DanaLogoLoadingDialog;", "scheduleImpl", "Lkotlin/Lazy;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "getErrorConfigVersion", "Landroidx/activity/result/ActivityResultLauncher;", "MyBillsEntityDataFactory", "Lcom/afollestad/materialdialogs/MaterialDialog;", "lookAheadTest", "Lcom/afollestad/materialdialogs/MaterialDialog;", "PlaceComponentResult", "Lid/dana/sendmoney/ui/groupsend/groupdetail/adapter/GroupDetailAdapter;", "DatabaseTableConfigUtil", "Lid/dana/sendmoney/ui/groupsend/groupdetail/adapter/GroupDetailAdapter;", "", "initRecordTimeStamp", "Ljava/lang/String;", "moveToNextValue", "Lid/dana/domain/recentrecipient/model/RecentRecipient;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/domain/recentrecipient/model/RecentRecipient;", "Lid/dana/sendmoney/di/component/GroupSendComponent;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/sendmoney/di/component/GroupSendComponent;", "Lid/dana/sendmoney/util/GroupSendTrackerHelper;", "groupSendTrackerHelper", "Lid/dana/sendmoney/util/GroupSendTrackerHelper;", "getGroupSendTrackerHelper", "()Lid/dana/sendmoney/util/GroupSendTrackerHelper;", "setGroupSendTrackerHelper", "(Lid/dana/sendmoney/util/GroupSendTrackerHelper;)V", "", "GetContactSyncConfig", "Z", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda0", "NetworkUserEntityData$$ExternalSyntheticLambda7", "", "PrepareContext", "I", "NetworkUserEntityData$$ExternalSyntheticLambda8", "newProxyInstance", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "getViewModelFactory", "()Lid/dana/core/ui/di/module/ViewModelFactory;", "setViewModelFactory", "(Lid/dana/core/ui/di/module/ViewModelFactory;)V", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailViewModel;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupDetailActivity extends BaseViewBindingActivity<ActivityGroupDetailBinding> {
    public static final String ACTIVITY_NAME = "GroupDetailActivity";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static char FragmentBottomSheetPaymentSettingBinding = 0;
    public static final int MAX_MEMBERS = 10;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda5;
    private static long NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private GroupDetailAdapter KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean lookAheadTest;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private BizGroupDetailResultModel getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private GroupSendComponent scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private RecentRecipient getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private final Lazy GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private RecentRecipient NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final ActivityResultLauncher<Intent> initRecordTimeStamp;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private int DatabaseTableConfigUtil;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private ActivityResultLauncher<Intent> MyBillsEntityDataFactory;
    @Inject
    public GroupSendTrackerHelper groupSendTrackerHelper;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private MaterialDialog PlaceComponentResult;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    @Inject
    public ViewModelFactory viewModelFactory;
    public static final byte[] $$a = {75, -120, 119, 39, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 53;
    public static final byte[] PlaceComponentResult = {Ascii.RS, 119, -63, 113, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 132;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String moveToNextValue = "";

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<DanaLogoLoadingDialog>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$danaLogoLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLogoLoadingDialog invoke() {
            return new DanaLogoLoadingDialog(GroupDetailActivity.this);
        }
    });

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        FragmentBottomSheetPaymentSettingBinding = (char) 3200;
        NetworkUserEntityData$$ExternalSyntheticLambda6 = 4360990799332652212L;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = -956812108;
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0026 -> B:23:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity.PlaceComponentResult
            int r7 = r7 + 97
            int r6 = r6 + 4
            int r8 = r8 + 16
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L30
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L30:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + (-4)
            int r7 = r7 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity.b(byte, short, byte, java.lang.Object[]):void");
    }

    private static void c(short s, short s2, int i, Object[] objArr) {
        int i2 = s + 4;
        byte[] bArr = $$a;
        int i3 = (i * 3) + 21;
        int i4 = (s2 * 2) + 75;
        byte[] bArr2 = new byte[i3];
        int i5 = -1;
        int i6 = i3 - 1;
        if (bArr == null) {
            int i7 = (i2 + (-i6)) - 7;
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
            i4 = i7;
            i2 = i2;
        }
        while (true) {
            int i8 = i5 + 1;
            int i9 = i2 + 1;
            bArr2[i8] = (byte) i4;
            if (i8 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            Object[] objArr2 = objArr;
            int i10 = i6;
            byte[] bArr3 = bArr2;
            byte[] bArr4 = bArr;
            int i11 = (i4 + (-bArr[i9])) - 7;
            i6 = i10;
            objArr = objArr2;
            bArr = bArr4;
            bArr2 = bArr3;
            i5 = i8;
            i4 = i11;
            i2 = i9;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:330:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0562  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x072a  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:500:0x08ff  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x0904  */
    /* JADX WARN: Removed duplicated region for block: B:545:0x0ac9 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:562:0x0284 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:566:0x0733 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:582:0x0566 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:584:0x0908 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void attachBaseContext(android.content.Context r31) {
        /*
            Method dump skipped, instructions count: 3168
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity.attachBaseContext(android.content.Context):void");
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
        a(new char[]{0, 0, 0, 0}, new char[]{4982, 31121, 44626, 38777}, (-1) - TextUtils.lastIndexOf("", '0'), (char) (super.getResources().getString(R.string.my_bills_label_service_mobilerecharge).substring(11, 12).length() + 31149), new char[]{28530, 29092, 47114, 56019, 12295, 25183, 60580, 39506, 12785, 61075, 62457, 45963, 65179, Typography.leftDoubleQuote, 58425, 18873, 11354, 64415}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        char[] cArr = {0, 0, 0, 0};
        char[] cArr2 = {38658, 51357, 39654, 34376};
        try {
            byte b = PlaceComponentResult[25];
            Object[] objArr2 = new Object[1];
            b(b, b, PlaceComponentResult[30], objArr2);
            Class<?> cls2 = Class.forName((String) objArr2[0]);
            b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[5], PlaceComponentResult[8], new Object[1]);
            Object[] objArr3 = new Object[1];
            a(cArr, cArr2, ((ApplicationInfo) cls2.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 423060106, (char) (super.getResources().getString(R.string.next_schedule_payment_late).substring(4, 5).length() + 18585), new char[]{22993, 49354, 17515, 45076, 34650}, objArr3);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr4 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{30374, 58433, 29252, 16222}, super.getResources().getString(R.string.you_can_send_money_via_agent).substring(41, 49).length() - 8, (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 24178), new char[]{8879, 17598, 50293, 734, 10885, 62530, 53689, 61418, 7502, 30452, 40082, 61469, 3266, 2898, 49542, 39043, 15902, 62986, 50731, 31146, 53813, 26903, 4234, 38710, 53379, 43475}, objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{12169, 15092, 11082, 35439}, (-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (super.getResources().getString(R.string.carrier_identification_verify_content_desc_2).substring(1, 2).length() + 28458), new char[]{47351, 59043, 63786, 1571, 50412, 57845, 59122, 14752, 49121, 22227, 43429, 36081, 9973, 45413, 32657, 25812, 60171, 37897}, objArr5);
                    baseContext = (Context) cls3.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getSize(0), 35 - (ViewConfiguration.getTapTimeout() >> 16), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr6 = new Object[1];
                        a(new char[]{0, 0, 0, 0}, new char[]{56765, 19324, 9479, 33478}, View.MeasureSpec.getMode(0), (char) (super.getResources().getString(R.string.kyc_aml_edd_dialog_button_text).substring(1, 2).length() - 1), new char[]{42954, 37015, 64979, 63550, 18751, 47077, 4706, 50639, 11866, 48217, 36367, 31399, 53083, 61702, 63352, 44651, 31683, 58500, 63212, 29845, 8107, 9982, 44721, 5181, 32973, 56921, 14619, 8326, 45755, 40551, 40393, 38069, 20654, 1915, 56517, 44824, 43020, 16465, 20751, 49128, 15759, 16824, 52186, 6616, 35154, 58345, 35117, 1799}, objArr6);
                        String str = (String) objArr6[0];
                        Object[] objArr7 = new Object[1];
                        a(new char[]{0, 0, 0, 0}, new char[]{24527, 33619, 42145, 20123}, getPackageName().length() - 7, (char) (ImageFormat.getBitsPerPixel(0) + 1), new char[]{49459, 31385, 58001, 12407, 18925, 32993, 13751, 54934, 31260, 11005, 336, 3353, 58219, 45463, 64807, 144, 47277, 30524, 27801, 14663, 61990, 25326, 53579, 15450, 54303, 61726, 60778, 29951, 11927, 35356, 43215, 45963, 37924, 46111, 58660, 22502, 39966, 43808, 39475, 4653, 3137, 19526, 6697, 3735, 41572, 22489, 38081, 63545, 17030, 56564, 13432, 7738, 41666, 27485, 46759, 44819, 52306, 172, 51863, 12336, 61104, 45473, 17631, 19727}, objArr7);
                        String str2 = (String) objArr7[0];
                        char[] cArr3 = {0, 0, 0, 0};
                        char[] cArr4 = {13511, 61132, 460, 26967};
                        try {
                            byte b2 = PlaceComponentResult[25];
                            Object[] objArr8 = new Object[1];
                            b(b2, b2, PlaceComponentResult[30], objArr8);
                            Class<?> cls4 = Class.forName((String) objArr8[0]);
                            b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[5], PlaceComponentResult[8], new Object[1]);
                            Object[] objArr9 = new Object[1];
                            a(cArr3, cArr4, ((ApplicationInfo) cls4.getMethod((String) r5[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{29565, 16370, 63799, 26294, 52908, 63564, 37777, 2108, 18430, 62784, 13395, 41027, 23998, 25464, 52435, 57971, 8880, 25433, 51419, 65215, 60150, 49843, 3648, 38569, 26586, 19559, 36470, 10868, 26253, 24252, 40911, 47806, 6684, 34074, 23354, 716, 40753, 55512, 14935, 27404, 6876, 22641, 23479, 32235, 10900, 62054, 4949, 41227, 14492, 32946, 1319, 54771, 11128, 10038, 20840, 25034, 54851, 35054, 2764, 6904, 20009, 7830, 44278, 34938}, objArr9);
                            String str3 = (String) objArr9[0];
                            char[] cArr5 = {0, 0, 0, 0};
                            char[] cArr6 = {18488, 46225, 12488, 61281};
                            try {
                                byte b3 = PlaceComponentResult[25];
                                Object[] objArr10 = new Object[1];
                                b(b3, b3, PlaceComponentResult[30], objArr10);
                                Class<?> cls5 = Class.forName((String) objArr10[0]);
                                Object[] objArr11 = new Object[1];
                                b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[5], PlaceComponentResult[8], objArr11);
                                int i = ((ApplicationInfo) cls5.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion - 33;
                                try {
                                    byte b4 = PlaceComponentResult[25];
                                    Object[] objArr12 = new Object[1];
                                    b(b4, b4, PlaceComponentResult[30], objArr12);
                                    Class<?> cls6 = Class.forName((String) objArr12[0]);
                                    b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[5], PlaceComponentResult[8], new Object[1]);
                                    Object[] objArr13 = new Object[1];
                                    a(cArr5, cArr6, i, (char) (((ApplicationInfo) cls6.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33), new char[]{12610, 13590, 36120, 44690, 48241, 52203, 58418, 61926, 39431, 6076, 54122, 45485, 39258, 61270, 20992, 32557, 38311, 34807, 9315, 43441, 11770, 24136, 4567, 25771, 13455, 47193, 65266, 41072, 20953, 9405, 59681, 17242, 35317, 36855, 63735, 14317, 206, 8244, 64822, 54934, 63017, 22368, 21405, 19828, 49617, 43323, 14908, 52569, 42500, 48222, 57155, 57185, 54891, 43849, 10453, 57727, 52924, 32037, 61526, 61820}, objArr13);
                                    String str4 = (String) objArr13[0];
                                    Object[] objArr14 = new Object[1];
                                    a(new char[]{0, 0, 0, 0}, new char[]{21999, 5520, 32846, 30599}, super.getResources().getString(R.string.payment_processing).substring(0, 1).codePointAt(0) - 80, (char) (ExpandableListView.getPackedPositionType(0L) + 34688), new char[]{63341, 10314, 41441, 51601, 8341, 7788}, objArr14);
                                    try {
                                        Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 911, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 19, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    } catch (Throwable th5) {
                        Throwable cause5 = th5.getCause();
                        if (cause5 == null) {
                            throw th5;
                        }
                        throw cause5;
                    }
                }
            }
            try {
                Object[] objArr16 = new Object[1];
                b((byte) 37, (byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], objArr16);
                Class<?> cls7 = Class.forName((String) objArr16[0]);
                Object[] objArr17 = new Object[1];
                b((byte) (-PlaceComponentResult[35]), (byte) (PlaceComponentResult[30] + 1), PlaceComponentResult[25], objArr17);
                try {
                    Object[] objArr18 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls8 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 493, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 4, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16));
                        Object[] objArr19 = new Object[1];
                        c($$a[40], (byte) ($$a[47] - 1), (byte) (-$$a[8]), objArr19);
                        obj3 = cls8.getMethod((String) objArr19[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                    int i2 = ((int[]) objArr20[1])[0];
                    if (((int[]) objArr20[0])[0] != i2) {
                        long j = ((r0 ^ i2) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - Color.green(0), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(null, null);
                            try {
                                Object[] objArr21 = {-1852624110, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 912, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 17, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr21);
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
                    }
                    super.onCreate(bundle);
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
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(new char[]{0, 0, 0, 0}, new char[]{30374, 58433, 29252, 16222}, super.getResources().getString(R.string.transfer_account_status_subtitle_failed).substring(0, 1).codePointAt(0) - 83, (char) (super.getResources().getString(R.string.referral_tracker_dana_kaget).substring(4, 15).codePointAt(5) + 24146), new char[]{8879, 17598, 50293, 734, 10885, 62530, 53689, 61418, 7502, 30452, 40082, 61469, 3266, 2898, 49542, 39043, 15902, 62986, 50731, 31146, 53813, 26903, 4234, 38710, 53379, 43475}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(new char[]{0, 0, 0, 0}, new char[]{12169, 15092, 11082, 35439}, (-1) - ExpandableListView.getPackedPositionChild(0L), (char) (getPackageName().length() + 28452), new char[]{47351, 59043, 63786, 1571, 50412, 57845, 59122, 14752, 49121, 22227, 43429, 36081, 9973, 45413, 32657, 25812, 60171, 37897}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getWindowTouchSlop() >> 8), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 35, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + 911, 18 - KeyEvent.getDeadChar(0, 0), (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("MyBillsEntityDataFactory", Context.class);
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
            a(new char[]{0, 0, 0, 0}, new char[]{30374, 58433, 29252, 16222}, ((byte) KeyEvent.getModifierMetaStateMask()) + 1, (char) (super.getResources().getString(R.string.light).substring(0, 1).length() + 24177), new char[]{8879, 17598, 50293, 734, 10885, 62530, 53689, 61418, 7502, 30452, 40082, 61469, 3266, 2898, 49542, 39043, 15902, 62986, 50731, 31146, 53813, 26903, 4234, 38710, 53379, 43475}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(new char[]{0, 0, 0, 0}, new char[]{12169, 15092, 11082, 35439}, KeyEvent.getDeadChar(0, 0), (char) (super.getResources().getString(R.string.deals_offline_category_health_and_beauty).substring(9, 10).length() + 28458), new char[]{47351, 59043, 63786, 1571, 50412, 57845, 59122, 14752, 49121, 22227, 43429, 36081, 9973, 45413, 32657, 25812, 60171, 37897}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 881, 35 - Gravity.getAbsoluteGravity(0, 0), (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 19 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    public GroupDetailActivity() {
        final GroupDetailActivity groupDetailActivity = this;
        final Function0 function0 = null;
        this.GetContactSyncConfig = new ViewModelLazy(Reflection.getOrCreateKotlinClass(GroupDetailViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GroupDetailActivity.this.getViewModelFactory();
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) {
                    CreationExtras defaultViewModelCreationExtras = groupDetailActivity.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        });
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$$ExternalSyntheticLambda4
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                GroupDetailActivity.$r8$lambda$xlocnlZMfz3_nAlgJO7CMegwgX4(GroupDetailActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.initRecordTimeStamp = registerForActivityResult;
    }

    @JvmName(name = "getViewModelFactory")
    public final ViewModelFactory getViewModelFactory() {
        ViewModelFactory viewModelFactory = this.viewModelFactory;
        if (viewModelFactory != null) {
            return viewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setViewModelFactory")
    public final void setViewModelFactory(ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "");
        this.viewModelFactory = viewModelFactory;
    }

    @JvmName(name = "getGroupSendTrackerHelper")
    public final GroupSendTrackerHelper getGroupSendTrackerHelper() {
        GroupSendTrackerHelper groupSendTrackerHelper = this.groupSendTrackerHelper;
        if (groupSendTrackerHelper != null) {
            return groupSendTrackerHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGroupSendTrackerHelper")
    public final void setGroupSendTrackerHelper(GroupSendTrackerHelper groupSendTrackerHelper) {
        Intrinsics.checkNotNullParameter(groupSendTrackerHelper, "");
        this.groupSendTrackerHelper = groupSendTrackerHelper;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        Context applicationContext = getApplicationContext();
        if (applicationContext != null) {
            GroupSendComponent authRequestContext = ((GroupSendComponentProvider) applicationContext).provideGroupSendComponent().getAuthRequestContext();
            this.scheduleImpl = authRequestContext;
            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney.di.provider.GroupSendComponentProvider");
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityGroupDetailBinding inflateViewBinding() {
        ActivityGroupDetailBinding authRequestContext = ActivityGroupDetailBinding.getAuthRequestContext(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        Toolbar toolbar = getBinding().PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        setToolbar(toolbar);
        Toolbar toolbar2 = getToolbar();
        Drawable PlaceComponentResult2 = ContextCompat.PlaceComponentResult(toolbar2.getContext(), id.dana.sendmoney.R.drawable.PlaceComponentResult);
        toolbar2.setContentDescription(getString(id.dana.sendmoney.R.string.NetworkUserEntityData$$ExternalSyntheticLambda1));
        toolbar2.setNavigationIcon(PlaceComponentResult2);
        toolbar2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupDetailActivity.$r8$lambda$4k4fR9XWTQj0EO8cIAq768Pz6W0(GroupDetailActivity.this, view);
            }
        });
        getBinding().PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(getString(id.dana.sendmoney.R.string.FamilyDashboardPresenter_Factory));
        TextView textView = getBinding().PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2;
        textView.setText(getString(id.dana.sendmoney.R.string.FamilyDashboardPresenter_Factory));
        textView.setContentDescription(getString(id.dana.sendmoney.R.string.lbl_detail_group));
        final AppCompatImageView appCompatImageView = getBinding().PlaceComponentResult.lookAheadTest;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(0);
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, id.dana.sendmoney.R.drawable.ic_remove_group);
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupDetailActivity.$r8$lambda$NycMoKIVEPgeKHfaQiot_vxElIg(GroupDetailActivity.this, appCompatImageView, view);
            }
        });
        appCompatImageView.setContentDescription(getString(id.dana.sendmoney.R.string.res_0x7f1302f2_networkuserentitydata_externalsyntheticlambda7));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    private final void BuiltInFictitiousFunctionClassFactory() {
        ?? r1 = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new GroupDetailAdapter(r1, 1, r1);
        RecyclerView recyclerView = getBinding().BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
        GroupDetailAdapter groupDetailAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (groupDetailAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            r1 = groupDetailAdapter;
        }
        recyclerView.setAdapter((RecyclerView.Adapter) r1);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4));
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            GroupSendLandingActivity.Companion companion = GroupSendLandingActivity.INSTANCE;
            setResult(-1, GroupSendLandingActivity.Companion.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        }
        super.onBackPressed();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/activity/GroupDetailActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "Landroid/content/Intent;", "getAuthRequestContext", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "(Ljava/lang/String;)Landroid/content/Intent;", "ACTIVITY_NAME", "Ljava/lang/String;", "", "MAX_MEMBERS", "I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Intent getAuthRequestContext(Context p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, GroupDetailActivity.class);
            intent.putExtra("GROUP_ID", p1);
            return intent;
        }

        public static Intent getAuthRequestContext(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intent intent = new Intent();
            intent.putExtra("GROUP_ID", p0);
            return intent;
        }
    }

    /* renamed from: $r8$lambda$-FevG43cEOpIBAHkWUR6o4usXck */
    public static /* synthetic */ void m2918$r8$lambda$FevG43cEOpIBAHkWUR6o4usXck(final GroupDetailActivity groupDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(groupDetailActivity, "");
        new BottomSheetImagePickerDialogFragment(new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$showImagePicker$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(final String str) {
                RecentRecipient recentRecipient;
                String str2;
                RecentRecipient recentRecipient2;
                RecentRecipient recentRecipient3;
                ActivityGroupDetailBinding binding;
                Intrinsics.checkNotNullParameter(str, "");
                recentRecipient = GroupDetailActivity.this.getErrorConfigVersion;
                final RecentRecipient recentRecipient4 = null;
                if (recentRecipient != null) {
                    recentRecipient3 = GroupDetailActivity.this.getErrorConfigVersion;
                    if (recentRecipient3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        recentRecipient3 = null;
                    }
                    binding = GroupDetailActivity.this.getBinding();
                    recentRecipient3.setFavorite(binding.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda0.isChecked());
                }
                final GroupDetailViewModel access$getVm = GroupDetailActivity.access$getVm(GroupDetailActivity.this);
                str2 = GroupDetailActivity.this.moveToNextValue;
                recentRecipient2 = GroupDetailActivity.this.getErrorConfigVersion;
                if (recentRecipient2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    recentRecipient4 = recentRecipient2;
                }
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
                Intrinsics.checkNotNullParameter(recentRecipient4, "");
                access$getVm.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new ModifyGroupImage.Param(str2, str), new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$modifyGroupImage$1
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
                        MutableStateFlow mutableStateFlow;
                        Object value;
                        mutableStateFlow = GroupDetailViewModel.this.getAuthRequestContext;
                        do {
                            value = mutableStateFlow.getValue();
                            GroupDetailUiState groupDetailUiState = (GroupDetailUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.DanaLogoLoading(true)));
                    }
                }, new Function1<BizGroupModifyResult, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$modifyGroupImage$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(BizGroupModifyResult bizGroupModifyResult) {
                        invoke2(bizGroupModifyResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(BizGroupModifyResult bizGroupModifyResult) {
                        MutableStateFlow mutableStateFlow;
                        Object value;
                        Intrinsics.checkNotNullParameter(bizGroupModifyResult, "");
                        RecentRecipient.this.setImageUrl(str);
                        mutableStateFlow = access$getVm.getAuthRequestContext;
                        String str3 = str;
                        do {
                            value = mutableStateFlow.getValue();
                            GroupDetailUiState groupDetailUiState = (GroupDetailUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.OnSuccessModifyGroupImage(0, str3, 1, null)));
                        access$getVm.getAuthRequestContext(RecentRecipient.this);
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$modifyGroupImage$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        MutableStateFlow mutableStateFlow;
                        Object value;
                        Intrinsics.checkNotNullParameter(th, "");
                        mutableStateFlow = GroupDetailViewModel.this.getAuthRequestContext;
                        do {
                            value = mutableStateFlow.getValue();
                            GroupDetailUiState groupDetailUiState = (GroupDetailUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.OnErrorWithShowToast(0, th, GroupSendOperationType.GROUP_MODIFY, SourceTypeProperty.GROUP_SEND_MODIFY_GROUP_IMAGE, 1, null)));
                    }
                }, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$modifyGroupImage$4
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
                        MutableStateFlow mutableStateFlow;
                        Object value;
                        mutableStateFlow = GroupDetailViewModel.this.getAuthRequestContext;
                        do {
                            value = mutableStateFlow.getValue();
                            GroupDetailUiState groupDetailUiState = (GroupDetailUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.DanaLogoLoading(false)));
                    }
                }, ViewModelKt.PlaceComponentResult(access$getVm));
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        }).show(groupDetailActivity.getSupportFragmentManager(), "ImageChooserDialogFragment");
    }

    public static /* synthetic */ void $r8$lambda$4k4fR9XWTQj0EO8cIAq768Pz6W0(GroupDetailActivity groupDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(groupDetailActivity, "");
        groupDetailActivity.onBackPressed();
    }

    public static /* synthetic */ void $r8$lambda$NycMoKIVEPgeKHfaQiot_vxElIg(final GroupDetailActivity groupDetailActivity, AppCompatImageView appCompatImageView, View view) {
        Intrinsics.checkNotNullParameter(groupDetailActivity, "");
        Intrinsics.checkNotNullParameter(appCompatImageView, "");
        Context context = appCompatImageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(context);
        builder.SubSequence = groupDetailActivity.getString(id.dana.sendmoney.R.string.delete_group_title);
        builder.GetContactSyncConfig = groupDetailActivity.getString(id.dana.sendmoney.R.string.delete_group_description);
        CustomDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(groupDetailActivity.getString(id.dana.sendmoney.R.string.setAkuEntranceOpen), new Function1<View, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$initDeleteGroupDialog$1
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
                final String str;
                Intrinsics.checkNotNullParameter(view2, "");
                final GroupDetailViewModel access$getVm = GroupDetailActivity.access$getVm(GroupDetailActivity.this);
                str = GroupDetailActivity.this.moveToNextValue;
                Intrinsics.checkNotNullParameter(str, "");
                access$getVm.BuiltInFictitiousFunctionClassFactory.execute(new DeleteGroup.Param(str), new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$deleteGroup$1
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
                        MutableStateFlow mutableStateFlow;
                        Object value;
                        mutableStateFlow = GroupDetailViewModel.this.getAuthRequestContext;
                        do {
                            value = mutableStateFlow.getValue();
                            GroupDetailUiState groupDetailUiState = (GroupDetailUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.DanaLogoLoading(true)));
                    }
                }, new Function1<BizGroupModifyResult, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$deleteGroup$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(BizGroupModifyResult bizGroupModifyResult) {
                        invoke2(bizGroupModifyResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(BizGroupModifyResult bizGroupModifyResult) {
                        Intrinsics.checkNotNullParameter(bizGroupModifyResult, "");
                        r2.lookAheadTest.execute(new RemoveRecentGroup.Params(str), 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: INVOKE 
                              (wrap: id.dana.domain.recentrecipient.interactor.RemoveRecentGroup : 0x0000: IGET (r2v1 id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel) A[WRAPPED] (LINE:1229) id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel.initRecordTimeStamp id.dana.domain.recentrecipient.interactor.RemoveRecentGroup)
                              (wrap: id.dana.domain.recentrecipient.interactor.RemoveRecentGroup$Params : 0x0004: CONSTRUCTOR 
                              (wrap: java.lang.String : 0x0007: IGET 
                              (r1v0 'this' id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$deleteGroup$2 A[IMMUTABLE_TYPE, THIS])
                             A[WRAPPED] id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$deleteGroup$2.$$groupId java.lang.String)
                             A[MD:(java.lang.String):void (m), WRAPPED] (LINE:1230) call: id.dana.domain.recentrecipient.interactor.RemoveRecentGroup.Params.<init>(java.lang.String):void type: CONSTRUCTOR)
                              (wrap: kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> : 0x0009: CONSTRUCTOR (r2v1 id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel) A[MD:(id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel):void (m), WRAPPED] (LINE:1229) call: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$doOnDeleteGroupComplete$1.<init>(id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel):void type: CONSTRUCTOR)
                              (wrap: kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> : 0x0010: CONSTRUCTOR 
                              (wrap: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel : 0x0005: IGET 
                              (r1v0 'this' id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$deleteGroup$2 A[IMMUTABLE_TYPE, THIS])
                             A[WRAPPED] (LINE:213) id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$deleteGroup$2.this$0 id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel)
                             A[MD:(id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel):void (m), WRAPPED] (LINE:213) call: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$doOnDeleteGroupComplete$2.<init>(id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel):void type: CONSTRUCTOR)
                             type: VIRTUAL call: id.dana.domain.core.usecase.BaseUseCase.execute(java.lang.Object, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void A[MD:(Params, kotlin.jvm.functions.Function1<? super T, kotlin.Unit>, kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit>):void (m)] (LINE:1229) in method: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$deleteGroup$2.invoke(id.dana.sendmoney.domain.groupsend.model.modify.BizGroupModifyResult):void, file: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                            	at java.base/java.util.ArrayList.forEach(Unknown Source)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$doOnDeleteGroupComplete$1, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:307)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1105)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                            	... 15 more
                            */
                        /*
                            this = this;
                            java.lang.String r0 = ""
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                            id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel r2 = id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel.this
                            java.lang.String r0 = r2
                            id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel.BuiltInFictitiousFunctionClassFactory(r2, r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$deleteGroup$2.invoke2(id.dana.sendmoney.domain.groupsend.model.modify.BizGroupModifyResult):void");
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$deleteGroup$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        MutableStateFlow mutableStateFlow;
                        Object value;
                        Intrinsics.checkNotNullParameter(th, "");
                        mutableStateFlow = GroupDetailViewModel.this.getAuthRequestContext;
                        do {
                            value = mutableStateFlow.getValue();
                            GroupDetailUiState groupDetailUiState = (GroupDetailUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.OnErrorWithShowToast(0, th, GroupSendOperationType.GROUP_MODIFY, SourceTypeProperty.GROUP_SEND_REMOVE_GROUP, 1, null)));
                    }
                }, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$deleteGroup$4
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
                        MutableStateFlow mutableStateFlow;
                        Object value;
                        mutableStateFlow = GroupDetailViewModel.this.getAuthRequestContext;
                        do {
                            value = mutableStateFlow.getValue();
                            GroupDetailUiState groupDetailUiState = (GroupDetailUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.DanaLogoLoading(false)));
                    }
                }, ViewModelKt.PlaceComponentResult(access$getVm));
            }
        });
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = groupDetailActivity.getString(id.dana.sendmoney.R.string.btn_confirm_delete);
        CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(groupDetailActivity.getString(id.dana.sendmoney.R.string.useDaemonThreadFactory), new Function1<View, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$initDeleteGroupDialog$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view2) {
                Intrinsics.checkNotNullParameter(view2, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }
        });
        KClassImpl$Data$declaredNonStaticMembers$2.newProxyInstance = groupDetailActivity.getString(id.dana.sendmoney.R.string.btn_cancel_delete);
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory().show();
    }

    public static /* synthetic */ void $r8$lambda$iP1uYf2RZPqhr3HU2uX4sYE7iOQ(GroupDetailActivity groupDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(groupDetailActivity, "");
        RecentRecipient recentRecipient = groupDetailActivity.getErrorConfigVersion;
        RecentRecipient recentRecipient2 = null;
        if (recentRecipient != null) {
            if (recentRecipient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                recentRecipient = null;
            }
            recentRecipient.setFavorite(groupDetailActivity.getBinding().scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda0.isChecked());
        }
        ActivityGroupDetailBinding binding = groupDetailActivity.getBinding();
        GroupDetailViewModel groupDetailViewModel = (GroupDetailViewModel) groupDetailActivity.GetContactSyncConfig.getValue();
        String str = groupDetailActivity.moveToNextValue;
        RecentRecipient recentRecipient3 = groupDetailActivity.getErrorConfigVersion;
        if (recentRecipient3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            recentRecipient2 = recentRecipient3;
        }
        GroupDetailActivityExtKt.PlaceComponentResult(groupDetailActivity, binding, groupDetailViewModel, str, recentRecipient2);
    }

    public static /* synthetic */ void $r8$lambda$rojmIwFraurJn2JjZPsOzj4Tecc(GroupDetailActivity groupDetailActivity, String str) {
        Intrinsics.checkNotNullParameter(groupDetailActivity, "");
        if (str != null) {
            if (str.length() == 0) {
                DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
                GroupDetailActivity groupDetailActivity2 = groupDetailActivity;
                String string = groupDetailActivity.getString(id.dana.sendmoney.R.string.res_0x7f13171b_getwalletv3recommendationconfig_lambda_193);
                Intrinsics.checkNotNullExpressionValue(string, "");
                DANAToast.MyBillsEntityDataFactory(groupDetailActivity2, string, "");
                return;
            }
            groupDetailActivity.moveToNextValue = str;
            groupDetailActivity.BuiltInFictitiousFunctionClassFactory();
            groupDetailActivity.getAuthRequestContext();
            DANAToast dANAToast2 = DANAToast.BuiltInFictitiousFunctionClassFactory;
            String string2 = groupDetailActivity.getString(id.dana.sendmoney.R.string.res_0x7f131723_daggerpromodiscoverycomponent_promodiscoverycomponentimpl_accountrepositoryprovider);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            String string3 = groupDetailActivity.getString(id.dana.sendmoney.R.string.res_0x7f131723_daggerpromodiscoverycomponent_promodiscoverycomponentimpl_accountrepositoryprovider);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            DANAToast.PlaceComponentResult(groupDetailActivity, string2, string3);
            groupDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        }
    }

    public static /* synthetic */ void $r8$lambda$xlocnlZMfz3_nAlgJO7CMegwgX4(GroupDetailActivity groupDetailActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(groupDetailActivity, "");
        Intrinsics.checkNotNullParameter(activityResult, "");
        Intent intent = activityResult.MyBillsEntityDataFactory;
        if (intent != null ? intent.getBooleanExtra(GroupSendLandingActivity.IS_GROUP_MODIFIED, false) : false) {
            groupDetailActivity.BuiltInFictitiousFunctionClassFactory();
            groupDetailActivity.getAuthRequestContext();
            groupDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        }
    }

    public static final /* synthetic */ GroupDetailViewModel access$getVm(GroupDetailActivity groupDetailActivity) {
        return (GroupDetailViewModel) groupDetailActivity.GetContactSyncConfig.getValue();
    }

    public static final /* synthetic */ void access$navigateToRecipientActivity(GroupDetailActivity groupDetailActivity, BizGroupDetailResultModel bizGroupDetailResultModel) {
        ActivityResultLauncher<Intent> activityResultLauncher = groupDetailActivity.MyBillsEntityDataFactory;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activityResultLauncher = null;
        }
        GroupRecipientActivity.Companion companion = GroupRecipientActivity.INSTANCE;
        GroupDetailActivity groupDetailActivity2 = groupDetailActivity;
        String KClassImpl$Data$declaredNonStaticMembers$2 = bizGroupDetailResultModel.KClassImpl$Data$declaredNonStaticMembers$2();
        List<RecipientViewModel> PlaceComponentResult2 = bizGroupDetailResultModel.PlaceComponentResult(groupDetailActivity2);
        String str = bizGroupDetailResultModel.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
        String str2 = bizGroupDetailResultModel.MyBillsEntityDataFactory.getAuthRequestContext;
        String str3 = bizGroupDetailResultModel.MyBillsEntityDataFactory.MyBillsEntityDataFactory;
        RecentRecipient recentRecipient = groupDetailActivity.getErrorConfigVersion;
        if (recentRecipient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recentRecipient = null;
        }
        activityResultLauncher.MyBillsEntityDataFactory(GroupRecipientActivity.Companion.PlaceComponentResult(groupDetailActivity2, new GroupSendIntentModel(ACTIVITY_NAME, KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult2, str, str2, str3, null, recentRecipient.isFavorite(), 64, null)), null);
    }

    public static final /* synthetic */ void access$setDanaLogoLoading(GroupDetailActivity groupDetailActivity, boolean z) {
        if (!z) {
            ((DanaLogoLoadingDialog) groupDetailActivity.BuiltInFictitiousFunctionClassFactory.getValue()).PlaceComponentResult();
            return;
        }
        DanaLogoLoadingDialog danaLogoLoadingDialog = (DanaLogoLoadingDialog) groupDetailActivity.BuiltInFictitiousFunctionClassFactory.getValue();
        if (danaLogoLoadingDialog.KClassImpl$Data$declaredNonStaticMembers$2.isShowing()) {
            return;
        }
        danaLogoLoadingDialog.KClassImpl$Data$declaredNonStaticMembers$2.show();
        danaLogoLoadingDialog.MyBillsEntityDataFactory.startRefresh();
    }

    public static final /* synthetic */ void access$setResultAndNavigateBackToLandingActivity(GroupDetailActivity groupDetailActivity) {
        GroupSendLandingActivity.Companion companion = GroupSendLandingActivity.INSTANCE;
        groupDetailActivity.setResult(-1, GroupSendLandingActivity.Companion.BuiltInFictitiousFunctionClassFactory(groupDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda0));
    }

    public static final /* synthetic */ void access$showFavoriteAccountExceedLimitDialog(final GroupDetailActivity groupDetailActivity, int i) {
        CustomDialog.Builder builder = new CustomDialog.Builder(groupDetailActivity);
        builder.DatabaseTableConfigUtil = id.dana.sendmoney.R.drawable.ic_error_favorite;
        builder.SubSequence = groupDetailActivity.getString(id.dana.sendmoney.R.string.group_favorite_reach_limit_title);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = groupDetailActivity.getString(id.dana.sendmoney.R.string.group_favorite_reach_limit_description);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        builder.GetContactSyncConfig = format;
        MaterialDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(groupDetailActivity.getString(id.dana.sendmoney.R.string.btn_continue), new Function1<View, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$showFavoriteAccountExceedLimitDialog$1
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
                RecentRecipient recentRecipient;
                RecentRecipient recentRecipient2;
                MaterialDialog materialDialog;
                Intrinsics.checkNotNullParameter(view, "");
                GroupDetailViewModel access$getVm = GroupDetailActivity.access$getVm(GroupDetailActivity.this);
                recentRecipient = GroupDetailActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                MaterialDialog materialDialog2 = null;
                if (recentRecipient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    recentRecipient = null;
                }
                access$getVm.BuiltInFictitiousFunctionClassFactory(recentRecipient, false);
                GroupDetailViewModel access$getVm2 = GroupDetailActivity.access$getVm(GroupDetailActivity.this);
                recentRecipient2 = GroupDetailActivity.this.getErrorConfigVersion;
                if (recentRecipient2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    recentRecipient2 = null;
                }
                access$getVm2.BuiltInFictitiousFunctionClassFactory(recentRecipient2, true);
                materialDialog = GroupDetailActivity.this.PlaceComponentResult;
                if (materialDialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    materialDialog2 = materialDialog;
                }
                materialDialog2.dismiss();
            }
        }).KClassImpl$Data$declaredNonStaticMembers$2(groupDetailActivity.getString(id.dana.sendmoney.R.string.cancel_text), new Function1<View, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$showFavoriteAccountExceedLimitDialog$2
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
                ActivityGroupDetailBinding binding;
                Intrinsics.checkNotNullParameter(view, "");
                GroupDetailActivity.this.lookAheadTest = true;
                binding = GroupDetailActivity.this.getBinding();
                binding.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda0.setChecked(false);
            }
        }).BuiltInFictitiousFunctionClassFactory();
        groupDetailActivity.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
        if (BuiltInFictitiousFunctionClassFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            BuiltInFictitiousFunctionClassFactory = null;
        }
        BuiltInFictitiousFunctionClassFactory.show();
    }

    public static final /* synthetic */ void access$showToastAfterManageFavorite(GroupDetailActivity groupDetailActivity, boolean z) {
        String string;
        if (z) {
            string = groupDetailActivity.getString(id.dana.sendmoney.R.string.res_0x7f131606_splitmerchantconfigentity_getmerchantdetailconfig_2_invokesuspend_lambda_0_inlined_getconfigsonceready_default_1_2);
        } else {
            string = groupDetailActivity.getString(id.dana.sendmoney.R.string.success_delete_group_from_favorite);
        }
        Intrinsics.checkNotNullExpressionValue(string, "");
        CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
        CustomToast.MyBillsEntityDataFactory(groupDetailActivity, id.dana.sendmoney.R.drawable.G, id.dana.sendmoney.R.drawable.scheduleImpl, string);
    }

    public final void getAuthRequestContext() {
        ((GroupDetailViewModel) this.GetContactSyncConfig.getValue()).PlaceComponentResult(this.moveToNextValue);
        ((GroupDetailViewModel) this.GetContactSyncConfig.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue);
        final GroupDetailViewModel groupDetailViewModel = (GroupDetailViewModel) this.GetContactSyncConfig.getValue();
        BaseUseCase.execute$default(groupDetailViewModel.getErrorConfigVersion, NoParams.INSTANCE, new Function1<Integer, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$getMaxFavoriteAccount$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = GroupDetailViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupDetailUiState groupDetailUiState = (GroupDetailUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.OnSuccessGetMaxFavoriteAccount(i)));
            }
        }, null, 4, null);
        GroupDetailViewModel groupDetailViewModel2 = (GroupDetailViewModel) this.GetContactSyncConfig.getValue();
        BaseUseCase.execute$default(groupDetailViewModel2.KClassImpl$Data$declaredNonStaticMembers$2, NoParams.INSTANCE, new GroupDetailViewModel$getTotalFavoriteAccountCount$1(groupDetailViewModel2), null, 4, null);
        final GroupDetailViewModel groupDetailViewModel3 = (GroupDetailViewModel) this.GetContactSyncConfig.getValue();
        BaseUseCase.execute$default(groupDetailViewModel3.moveToNextValue, NoParams.INSTANCE, new Function1<RecentRecipient, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$getLeastTransactionFavoriteAccount$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(RecentRecipient recentRecipient) {
                invoke2(recentRecipient);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(RecentRecipient recentRecipient) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(recentRecipient, "");
                mutableStateFlow = GroupDetailViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupDetailUiState groupDetailUiState = (GroupDetailUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.OnSuccessGetLeastTransactionFavoriteAccount(recentRecipient)));
            }
        }, null, 4, null);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContract<Intent, String>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$editRecipient$1
            @Override // androidx.view.result.contract.ActivityResultContract
            public final /* synthetic */ Intent createIntent(Context context, Intent intent) {
                Intent intent2 = intent;
                Intrinsics.checkNotNullParameter(context, "");
                Intrinsics.checkNotNullParameter(intent2, "");
                return intent2;
            }

            @Override // androidx.view.result.contract.ActivityResultContract
            public final /* synthetic */ String parseResult(int i, Intent intent) {
                if (i == -1 && intent != null) {
                    return intent.getStringExtra("GROUP_ID");
                }
                return null;
            }
        }, new ActivityResultCallback() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$$ExternalSyntheticLambda5
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                GroupDetailActivity.$r8$lambda$rojmIwFraurJn2JjZPsOzj4Tecc(GroupDetailActivity.this, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.MyBillsEntityDataFactory = registerForActivityResult;
        String stringExtra = getIntent().getStringExtra("GROUP_ID");
        this.moveToNextValue = stringExtra != null ? stringExtra : "";
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(this), null, null, new GroupDetailActivity$initLifecycleActivity$1(this, null), 3, null);
        BuiltInFictitiousFunctionClassFactory();
        getAuthRequestContext();
        getBinding().MyBillsEntityDataFactory.setOnBottomActionClickListener(new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$initOnClickListener$1
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
                ActivityGroupDetailBinding binding;
                binding = GroupDetailActivity.this.getBinding();
                GroupDetailActivityExtKt.getAuthRequestContext(binding, false);
                GroupDetailActivity.this.getAuthRequestContext();
            }
        });
        getBinding().moveToNextValue.scheduleImpl.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupDetailActivity.$r8$lambda$iP1uYf2RZPqhr3HU2uX4sYE7iOQ(GroupDetailActivity.this, view);
            }
        });
        getBinding().moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupDetailActivity.m2918$r8$lambda$FevG43cEOpIBAHkWUR6o4usXck(GroupDetailActivity.this, view);
            }
        });
    }

    private static void a(char[] cArr, char[] cArr2, int i, char c, char[] cArr3, Object[] objArr) {
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
        while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
            int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
            cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
            cArr4[i3] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr3[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (NetworkUserEntityData$$ExternalSyntheticLambda6 ^ 4360990799332652212L)) ^ ((int) (NetworkUserEntityData$$ExternalSyntheticLambda5 ^ 4360990799332652212L))) ^ ((char) (FragmentBottomSheetPaymentSettingBinding ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
