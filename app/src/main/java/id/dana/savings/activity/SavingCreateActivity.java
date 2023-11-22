package id.dana.savings.activity;

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
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import butterknife.OnClick;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.SingleClickListener;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.customsnackbarcomponent.CustomSnackbar;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.danah5.DanaH5;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSavingUpdateComponent;
import id.dana.di.component.SavingUpdateComponent;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.SavingCreateModule;
import id.dana.di.modules.SavingUpdateModule;
import id.dana.dialog.LoadingDialog;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.savings.activity.SavingCreateActivity;
import id.dana.savings.contract.SavingCreateContract;
import id.dana.savings.contract.SavingUpdateListener;
import id.dana.savings.ext.SavingModelExtKt;
import id.dana.savings.model.SavingCategoryModel;
import id.dana.savings.model.SavingCreateInitModel;
import id.dana.savings.model.SavingModel;
import id.dana.savings.view.CategorySelectorView;
import id.dana.savings.view.SavingGoalEntryView;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.MixPanelTracker;
import java.lang.reflect.Method;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 U2\u00020\u0001:\u0001UB\u0007¢\u0006\u0004\bT\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0010\u0010\u0004J\u0015\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0007H\u0004¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010!\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0007H\u0004¢\u0006\u0004\b!\u0010\"J5\u0010&\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010\u00072\b\u0010%\u001a\u0004\u0018\u00010\u0007H\u0004¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u0002¢\u0006\u0004\b(\u0010\u0004R\"\u0010*\u001a\u00020)8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00102\u001a\u00020\u00058\u0005@\u0005X\u0085\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u0010\u0013R\u0013\u00108\u001a\u000205X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b6\u00107R\"\u0010:\u001a\u0002098\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0018\u0010\b\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0013\u0010E\u001a\u00020CX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bD\u00107R\"\u0010G\u001a\u00020F8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010N\u001a\u00020M8\u0005@\u0005X\u0085.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010S"}, d2 = {"Lid/dana/savings/activity/SavingCreateActivity;", "Lid/dana/base/BaseActivity;", "", "configToolbar", "()V", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)Ljava/lang/String;", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "initComponent", "onBackPressed", "onTotalSavingLimitAboutClick", "enable", "setButtonEnable", "(Z)V", "errorMessage", "showBottomWarningSnackbar", "(Ljava/lang/String;)V", "titleResId", "messageResId", "positiveBtnResId", "negativeBtnResId", "showQuitEditingDialog", "(IIII)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "maxSavingCount", "maxSavingAmount", "showTotalSavingLimitInfoDialog", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "maxSavingCountNonKyc", "maxSavingAmountNonKyc", "maxSavingAmountKyc", "showUpgradeToKycDialog", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "trackCanceledCreateActivity", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "lookAheadTest", "Z", "isUpdate", "()Z", "setUpdate", "Lid/dana/dialog/LoadingDialog;", "getErrorConfigVersion", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "Lid/dana/savings/contract/SavingCreateContract$Presenter;", "presenter", "Lid/dana/savings/contract/SavingCreateContract$Presenter;", "getPresenter", "()Lid/dana/savings/contract/SavingCreateContract$Presenter;", "setPresenter", "(Lid/dana/savings/contract/SavingCreateContract$Presenter;)V", "Lid/dana/savings/model/SavingCreateInitModel;", "scheduleImpl", "Lid/dana/savings/model/SavingCreateInitModel;", "Lid/dana/di/modules/SavingCreateModule;", "GetContactSyncConfig", "PlaceComponentResult", "Lid/dana/savings/model/SavingModel;", "savingModel", "Lid/dana/savings/model/SavingModel;", "getSavingModel", "()Lid/dana/savings/model/SavingModel;", "setSavingModel", "(Lid/dana/savings/model/SavingModel;)V", "Lid/dana/di/component/SavingUpdateComponent;", "savingUpdateComponent", "Lid/dana/di/component/SavingUpdateComponent;", "getSavingUpdateComponent", "()Lid/dana/di/component/SavingUpdateComponent;", "setSavingUpdateComponent", "(Lid/dana/di/component/SavingUpdateComponent;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class SavingCreateActivity extends BaseActivity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static int DatabaseTableConfigUtil = 0;
    public static final String EXTRA_CREATED_SAVING = "created_saving_model";
    public static final String EXTRA_SAVING = "extra_saving";
    public static final String EXTRA_SAVING_CREATE_INIT_MODEL = "extra_saving_create_init_model";
    private static final MoneyViewModel NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static long NetworkUserEntityData$$ExternalSyntheticLambda1;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda2;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean isUpdate;
    @Inject
    public SavingCreateContract.Presenter presenter;
    public SavingModel savingModel;
    protected SavingUpdateComponent savingUpdateComponent;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private SavingCreateInitModel KClassImpl$Data$declaredNonStaticMembers$2;
    public static final byte[] $$a = {107, 78, -84, 46, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 80;
    public static final byte[] getAuthRequestContext = {112, 91, -28, 61, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 191;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<LoadingDialog>() { // from class: id.dana.savings.activity.SavingCreateActivity$loadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LoadingDialog invoke() {
            return new LoadingDialog(SavingCreateActivity.this);
        }
    });

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult = LazyKt.lazy(new Function0<SavingCreateModule>() { // from class: id.dana.savings.activity.SavingCreateActivity$savingCreateModule$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SavingCreateModule invoke() {
            final SavingCreateActivity savingCreateActivity = SavingCreateActivity.this;
            return new SavingCreateModule(new SavingCreateContract.View() { // from class: id.dana.savings.activity.SavingCreateActivity$savingCreateModule$2.1
                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.savings.contract.SavingCreateContract.View
                public final void MyBillsEntityDataFactory(SavingModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    SavingCreateActivity savingCreateActivity2 = SavingCreateActivity.this;
                    String str = p0.PlaceComponentResult;
                    String str2 = p0.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    String string = SavingCreateActivity.this.getString(R.string.saving_level, SavingModelExtKt.MyBillsEntityDataFactory(p0));
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    SavingCreateActivity.access$trackingCreateSaving(savingCreateActivity2, str, str2, string);
                    SavingCreateActivity.access$finishCreateGoalSaving(SavingCreateActivity.this, p0);
                }

                @Override // id.dana.savings.contract.SavingCreateContract.View
                public final void PlaceComponentResult() {
                    SavingCreateActivity.this.setButtonEnable(false);
                    SavingCreateActivity.this.getPresenter().MyBillsEntityDataFactory();
                }

                @Override // id.dana.savings.contract.SavingCreateContract.View
                public final void PlaceComponentResult(boolean p0) {
                    SavingCreateInitModel savingCreateInitModel;
                    SavingCreateInitModel savingCreateInitModel2;
                    SavingCreateInitModel savingCreateInitModel3;
                    SavingCreateInitModel savingCreateInitModel4;
                    SavingCreateInitModel savingCreateInitModel5;
                    if (p0) {
                        SavingCreateActivity savingCreateActivity2 = SavingCreateActivity.this;
                        SavingCreateActivity savingCreateActivity3 = savingCreateActivity2;
                        savingCreateInitModel4 = savingCreateActivity2.KClassImpl$Data$declaredNonStaticMembers$2;
                        String str = savingCreateInitModel4 != null ? savingCreateInitModel4.MyBillsEntityDataFactory : null;
                        savingCreateInitModel5 = SavingCreateActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                        savingCreateActivity2.showTotalSavingLimitInfoDialog(savingCreateActivity3, str, savingCreateInitModel5 != null ? savingCreateInitModel5.getAuthRequestContext : null);
                        return;
                    }
                    SavingCreateActivity savingCreateActivity4 = SavingCreateActivity.this;
                    SavingCreateActivity savingCreateActivity5 = savingCreateActivity4;
                    savingCreateInitModel = savingCreateActivity4.KClassImpl$Data$declaredNonStaticMembers$2;
                    String str2 = savingCreateInitModel != null ? savingCreateInitModel.BuiltInFictitiousFunctionClassFactory : null;
                    savingCreateInitModel2 = SavingCreateActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    String str3 = savingCreateInitModel2 != null ? savingCreateInitModel2.PlaceComponentResult : null;
                    savingCreateInitModel3 = SavingCreateActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    savingCreateActivity4.showUpgradeToKycDialog(savingCreateActivity5, str2, str3, savingCreateInitModel3 != null ? savingCreateInitModel3.getAuthRequestContext : null);
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void showProgress() {
                    LoadingDialog access$getLoadingDialog = SavingCreateActivity.access$getLoadingDialog(SavingCreateActivity.this);
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
                    SavingCreateActivity.access$getLoadingDialog(SavingCreateActivity.this).KClassImpl$Data$declaredNonStaticMembers$2();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void onError(String p0) {
                    if (p0 != null) {
                        SavingCreateActivity.this.showBottomWarningSnackbar(p0);
                    }
                }

                @Override // id.dana.savings.contract.SavingCreateContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(Throwable p0, String p1, String p2, String p3) {
                    Intrinsics.checkNotNullParameter(p1, "");
                    Intrinsics.checkNotNullParameter(p2, "");
                    Intrinsics.checkNotNullParameter(p3, "");
                    if (p1.length() > 0) {
                        if (p3.length() > 0) {
                            MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(SavingCreateActivity.this.getApplicationContext(), p1, p2, p3, p0);
                        }
                    }
                }
            });
        }
    });

    public static /* synthetic */ void $r8$lambda$rcfkoJICtNxoFfYGQLUqFNbN_bc(boolean z) {
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        NetworkUserEntityData$$ExternalSyntheticLambda2 = (char) 13492;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = 4707483783240777918L;
        DatabaseTableConfigUtil = -956812108;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = 106 - r8
            byte[] r0 = id.dana.savings.activity.SavingCreateActivity.getAuthRequestContext
            int r7 = 23 - r7
            int r6 = 55 - r6
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L32
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            int r6 = r6 + 1
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L32:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + (-4)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.activity.SavingCreateActivity.b(short, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 2
            int r7 = r7 + 75
            int r9 = r9 * 3
            int r9 = 42 - r9
            byte[] r0 = id.dana.savings.activity.SavingCreateActivity.$$a
            int r8 = 47 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L31
        L18:
            r3 = 0
        L19:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L28:
            r3 = r0[r8]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L31:
            int r7 = -r7
            int r8 = r8 + 1
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.activity.SavingCreateActivity.c(int, short, byte, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final void startActivityForResult(BaseActivity baseActivity, int i, SavingCreateInitModel savingCreateInitModel) {
        Companion.BuiltInFictitiousFunctionClassFactory(baseActivity, i, savingCreateInitModel);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        Object[] objArr5;
        super.attachBaseContext(context);
        Object[] objArr6 = new Object[1];
        a(new char[]{46090, 64258, 3465, 32209}, new char[]{620, 41617, 6985, 39971}, 1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (8987 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))), new char[]{41323, 60078, 65148, 62941, 3352, 914, 18867, 29454, 48109, 29268, 27947, 51636, 9708, 15189, 48442, 62028, 14978, 20326}, objArr6);
        Class<?> cls = Class.forName((String) objArr6[0]);
        Object[] objArr7 = new Object[1];
        a(new char[]{46090, 64258, 3465, 32209}, new char[]{22664, 42825, 42453, 31519}, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 710457001, (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 8101), new char[]{42951, 53449, 9959, 15475, 27857}, objArr7);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr7[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj != null) {
                        objArr = null;
                    } else {
                        objArr = null;
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 930, TextUtils.getOffsetBefore("", 0) + 35, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(objArr, objArr);
                    Object[] objArr8 = new Object[1];
                    a(new char[]{46090, 64258, 3465, 32209}, new char[]{27216, 10027, 6823, 57216}, 1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (ViewConfiguration.getTapTimeout() >> 16), new char[]{51905, 59605, 14847, 12681, 43736, 57979, 26298, 64063, 43422, 28075, 9999, 39549, 48904, 14925, 45150, 8469, 49023, 6163, 23471, 24803, 46324, 34540, 35092, 60904, 37172, 10412, 3738, 20909, 53714, 20330, 54432, 7218, 23821, 20401, 56077, 41626, 33910, 51118, 12246, 24142, 33891, 18210, 20514, 18337, 56608, 18614, 27217, 41485}, objArr8);
                    String str = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(new char[]{46090, 64258, 3465, 32209}, new char[]{27542, 42034, 7012, 56227}, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), new char[]{35736, 6627, 24038, 49182, 56301, 23595, 26423, 53515, 60734, 23575, 54645, 36970, 35217, 59713, 22944, 1931, 19137, 6516, 23396, 7539, 25354, 62250, 11979, 25967, 41616, 16591, 7426, 24441, 11834, 24665, 45326, 16374, 22776, 65178, 54716, 28752, 29671, 12044, 39016, 11947, 25050, 25990, 56916, 36372, 2881, 54385, 7336, 35477, 51838, 62171, 42678, 56677, 57012, 40218, 28951, 17449, 3001, 8430, 7304, 28190, 33973, 33736, 47165, 17640}, objArr9);
                    String str2 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(new char[]{46090, 64258, 3465, 32209}, new char[]{1644, 35038, 52418, 42865}, TextUtils.indexOf("", "", 0, 0), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16), new char[]{31645, 26795, 57317, 10668, 29701, 10331, 22688, 48932, 42206, 5206, 40126, 33858, 46637, 34145, 50334, 6337, 14798, 36177, 4600, 57559, 61676, 36006, 36565, 46977, 39505, 29439, 53364, 38746, 43044, 34611, 16061, 3703, 5881, 61997, 43148, 30765, 62081, 28755, 40658, 27658, 56911, 25141, 10024, 18960, 52641, 61659, 61574, 62209, 6459, 56546, 26606, 43418, 60176, 23549, 23810, 46963, 1472, 47280, 24754, 15808, 42896, 30206, 58319, 14570}, objArr10);
                    String str3 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(new char[]{46090, 64258, 3465, 32209}, new char[]{8418, 35985, 64201, 40654}, 1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) Gravity.getAbsoluteGravity(0, 0), new char[]{1453, 5469, 42530, 53502, 24745, 32711, 21757, 22253, 62890, 17444, 16280, 3238, 52711, 48126, 34896, 36591, 59759, 11640, 34561, 38418, 47005, 3372, 38371, 57735, 3919, 46695, 63770, 21992, 30578, 20602, 55292, 55526, 28080, 5826, 17989, 9609, 2889, 11536, 4682, 12340, 43030, 2541, 63321, 58592, 44411, 47633, 62482, 62216, 26825, 42898, 3227, 49276, 64839, 361, 12212, 4706, 40955, 13790, 36840, 21713}, objArr11);
                    String str4 = (String) objArr11[0];
                    Object[] objArr12 = new Object[1];
                    a(new char[]{46090, 64258, 3465, 32209}, new char[]{11215, 45005, 20829, 26213}, ViewConfiguration.getTapTimeout() >> 16, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 25936), new char[]{28127, 252, 24461, 32860, 33920, 60857}, objArr12);
                    try {
                        Object[] objArr13 = {applicationContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 911, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 19, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            }
        }
        Context applicationContext2 = context != null ? context.getApplicationContext() : context;
        if (applicationContext2 != null) {
            try {
                Object[] objArr14 = new Object[1];
                b((byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], getAuthRequestContext[25], objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                Object[] objArr15 = new Object[1];
                b((byte) (PlaceComponentResult & 94), getAuthRequestContext[30], getAuthRequestContext[9], objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - ExpandableListView.getPackedPositionGroup(0L), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 2, (char) View.MeasureSpec.getSize(0));
                        Object[] objArr17 = new Object[1];
                        c($$a[47], (byte) (-$$a[53]), $$a[68], objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 800, KeyEvent.getDeadChar(0, 0) + 15, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, TextUtils.getOffsetAfter("", 0) + 15, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - TextUtils.getOffsetBefore("", 0), 28 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (((Process.getThreadPriority(0) + 20) >> 6) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - MotionEvent.axisFromString(""), ImageFormat.getBitsPerPixel(0) + 16, (char) (Process.myTid() >> 22)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr18));
                                    long j = ((r7 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr2 = null;
                                        } else {
                                            objArr2 = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 930, 34 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr2, objArr2);
                                        try {
                                            Object[] objArr19 = {-1137046892, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), View.combineMeasuredStates(0, 0) + 18, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], getAuthRequestContext[25], objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                Object[] objArr22 = new Object[1];
                b((byte) (PlaceComponentResult & 94), getAuthRequestContext[30], getAuthRequestContext[9], objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - TextUtils.indexOf("", "", 0), 46 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                        Object[] objArr24 = new Object[1];
                        c((byte) (-$$a[9]), $$a[20], (byte) (-$$a[8]), objArr24);
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
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.resolveSizeAndState(0, 0, 0), 35 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr26 = {-1137046892, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (Process.myPid() >> 22) + 18, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], getAuthRequestContext[25], objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                Object[] objArr29 = new Object[1];
                b((byte) (PlaceComponentResult & 94), getAuthRequestContext[30], getAuthRequestContext[9], objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getFadingEdgeLength() >> 16), 4 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (((Process.getThreadPriority(0) + 20) >> 6) + 38968));
                        Object[] objArr31 = new Object[1];
                        c((byte) (-$$a[9]), $$a[20], (byte) (-$$a[8]), objArr31);
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
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - Process.getGidForName(""), 35 - Gravity.getAbsoluteGravity(0, 0), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr33 = {-1137046892, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.green(0), 18 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], getAuthRequestContext[25], objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                Object[] objArr36 = new Object[1];
                b((byte) (PlaceComponentResult & 94), getAuthRequestContext[30], getAuthRequestContext[9], objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 2 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16));
                        byte b = (byte) ($$a[47] - 1);
                        byte b2 = b;
                        Object[] objArr38 = new Object[1];
                        c(b, b2, b2, objArr38);
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
                                objArr5 = null;
                            } else {
                                objArr5 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 36 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr5, objArr5);
                            try {
                                Object[] objArr40 = {-1137046892, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public int getLayout() {
        return R.layout.activity_create_update_saving;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(new char[]{46090, 64258, 3465, 32209}, new char[]{620, 41617, 6985, 39971}, ViewConfiguration.getLongPressTimeout() >> 16, (char) (super.getResources().getString(R.string.otp_error_too_often_request).substring(3, 4).codePointAt(0) + 8955), new char[]{41323, 60078, 65148, 62941, 3352, 914, 18867, 29454, 48109, 29268, 27947, 51636, 9708, 15189, 48442, 62028, 14978, 20326}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(new char[]{46090, 64258, 3465, 32209}, new char[]{22664, 42825, 42453, 31519}, View.MeasureSpec.getSize(0) - 710457000, (char) (8101 - (KeyEvent.getMaxKeyCode() >> 16)), new char[]{42951, 53449, 9959, 15475, 27857}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                char[] cArr = {46090, 64258, 3465, 32209};
                char[] cArr2 = {21104, 53430, 39480, 15032};
                int maxKeyCode = KeyEvent.getMaxKeyCode() >> 16;
                try {
                    Object[] objArr4 = new Object[1];
                    b((byte) (PlaceComponentResult & 116), getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    b(getAuthRequestContext[25], getAuthRequestContext[41], getAuthRequestContext[48], objArr5);
                    Object[] objArr6 = new Object[1];
                    a(cArr, cArr2, maxKeyCode, (char) (((ApplicationInfo) cls2.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + 47225), new char[]{5495, 30098, 5947, 62802, 32674, 36611, 29511, 56909, 4359, 55122, 48696, 53960, 48282, 58040, 65205, 25808, 23963, 47732, 58604, 56972, 39650, 21529, 25309, 43705, 63773, 41514}, objArr6);
                    Class<?> cls3 = Class.forName((String) objArr6[0]);
                    Object[] objArr7 = new Object[1];
                    a(new char[]{46090, 64258, 3465, 32209}, new char[]{19302, 51953, 44438, 14523}, getPackageName().codePointAt(1) - 100, (char) (ExpandableListView.getPackedPositionGroup(0L) + 48045), new char[]{19056, 60142, 21484, 30514, 14818, 1012, 55359, 8437, 22393, 27774, 11436, 25769, 12603, 21059, 47327, 12465, 21302, 58639}, objArr7);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Color.argb(0, 0, 0, 0), (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr8 = new Object[1];
                    a(new char[]{46090, 64258, 3465, 32209}, new char[]{27216, 10027, 6823, 57216}, getPackageName().codePointAt(1) - 100, (char) View.combineMeasuredStates(0, 0), new char[]{51905, 59605, 14847, 12681, 43736, 57979, 26298, 64063, 43422, 28075, 9999, 39549, 48904, 14925, 45150, 8469, 49023, 6163, 23471, 24803, 46324, 34540, 35092, 60904, 37172, 10412, 3738, 20909, 53714, 20330, 54432, 7218, 23821, 20401, 56077, 41626, 33910, 51118, 12246, 24142, 33891, 18210, 20514, 18337, 56608, 18614, 27217, 41485}, objArr8);
                    String str = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(new char[]{46090, 64258, 3465, 32209}, new char[]{27542, 42034, 7012, 56227}, getPackageName().length() - 7, (char) (super.getResources().getString(R.string.global_search_empty_state_title).substring(9, 11).codePointAt(1) - 114), new char[]{35736, 6627, 24038, 49182, 56301, 23595, 26423, 53515, 60734, 23575, 54645, 36970, 35217, 59713, 22944, 1931, 19137, 6516, 23396, 7539, 25354, 62250, 11979, 25967, 41616, 16591, 7426, 24441, 11834, 24665, 45326, 16374, 22776, 65178, 54716, 28752, 29671, 12044, 39016, 11947, 25050, 25990, 56916, 36372, 2881, 54385, 7336, 35477, 51838, 62171, 42678, 56677, 57012, 40218, 28951, 17449, 3001, 8430, 7304, 28190, 33973, 33736, 47165, 17640}, objArr9);
                    String str2 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(new char[]{46090, 64258, 3465, 32209}, new char[]{1644, 35038, 52418, 42865}, ImageFormat.getBitsPerPixel(0) + 1, (char) View.combineMeasuredStates(0, 0), new char[]{31645, 26795, 57317, 10668, 29701, 10331, 22688, 48932, 42206, 5206, 40126, 33858, 46637, 34145, 50334, 6337, 14798, 36177, 4600, 57559, 61676, 36006, 36565, 46977, 39505, 29439, 53364, 38746, 43044, 34611, 16061, 3703, 5881, 61997, 43148, 30765, 62081, 28755, 40658, 27658, 56911, 25141, 10024, 18960, 52641, 61659, 61574, 62209, 6459, 56546, 26606, 43418, 60176, 23549, 23810, 46963, 1472, 47280, 24754, 15808, 42896, 30206, 58319, 14570}, objArr10);
                    String str3 = (String) objArr10[0];
                    char[] cArr3 = {46090, 64258, 3465, 32209};
                    char[] cArr4 = {8418, 35985, 64201, 40654};
                    int codePointAt = super.getResources().getString(R.string.zface_retry_max_title).substring(2, 3).codePointAt(0) - 116;
                    try {
                        Object[] objArr11 = new Object[1];
                        b((byte) (PlaceComponentResult & 116), getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr11);
                        Class<?> cls4 = Class.forName((String) objArr11[0]);
                        b(getAuthRequestContext[25], getAuthRequestContext[41], getAuthRequestContext[48], new Object[1]);
                        Object[] objArr12 = new Object[1];
                        a(cArr3, cArr4, codePointAt, (char) (((ApplicationInfo) cls4.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33), new char[]{1453, 5469, 42530, 53502, 24745, 32711, 21757, 22253, 62890, 17444, 16280, 3238, 52711, 48126, 34896, 36591, 59759, 11640, 34561, 38418, 47005, 3372, 38371, 57735, 3919, 46695, 63770, 21992, 30578, 20602, 55292, 55526, 28080, 5826, 17989, 9609, 2889, 11536, 4682, 12340, 43030, 2541, 63321, 58592, 44411, 47633, 62482, 62216, 26825, 42898, 3227, 49276, 64839, 361, 12212, 4706, 40955, 13790, 36840, 21713}, objArr12);
                        String str4 = (String) objArr12[0];
                        Object[] objArr13 = new Object[1];
                        a(new char[]{46090, 64258, 3465, 32209}, new char[]{11215, 45005, 20829, 26213}, getPackageName().codePointAt(2) - 46, (char) (super.getResources().getString(R.string.resend_otp_cashier).substring(9, 10).length() + 25936), new char[]{28127, 252, 24461, 32860, 33920, 60857}, objArr13);
                        try {
                            Object[] objArr14 = {baseContext, str, str2, str3, str4, true, (String) objArr13[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 912, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 18, (char) Color.red(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr14);
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
            Object[] objArr15 = new Object[1];
            b((byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], getAuthRequestContext[25], objArr15);
            Class<?> cls5 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            b((byte) (PlaceComponentResult & 94), getAuthRequestContext[30], getAuthRequestContext[9], objArr16);
            try {
                Object[] objArr17 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - Gravity.getAbsoluteGravity(0, 0), View.combineMeasuredStates(0, 0) + 4, (char) ExpandableListView.getPackedPositionGroup(0L));
                    byte b = (byte) ($$a[47] - 1);
                    byte b2 = b;
                    Object[] objArr18 = new Object[1];
                    c(b, b2, b2, objArr18);
                    obj3 = cls6.getMethod((String) objArr18[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr19 = (Object[]) ((Method) obj3).invoke(null, objArr17);
                int i = ((int[]) objArr19[1])[0];
                if (((int[]) objArr19[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.green(0), 35 - (Process.myPid() >> 22), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr20 = {946397349, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(new char[]{46090, 64258, 3465, 32209}, new char[]{21104, 53430, 39480, 15032}, ViewConfiguration.getScrollDefaultDelay() >> 16, (char) (47258 - TextUtils.indexOf("", "", 0, 0)), new char[]{5495, 30098, 5947, 62802, 32674, 36611, 29511, 56909, 4359, 55122, 48696, 53960, 48282, 58040, 65205, 25808, 23963, 47732, 58604, 56972, 39650, 21529, 25309, 43705, 63773, 41514}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(new char[]{46090, 64258, 3465, 32209}, new char[]{19302, 51953, 44438, 14523}, KeyEvent.getDeadChar(0, 0), (char) (48046 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), new char[]{19056, 60142, 21484, 30514, 14818, 1012, 55359, 8437, 22393, 27774, 11436, 25769, 12603, 21059, 47327, 12465, 21302, 58639}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 35, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), TextUtils.getOffsetAfter("", 0) + 18, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            char[] cArr = {46090, 64258, 3465, 32209};
            char[] cArr2 = {21104, 53430, 39480, 15032};
            try {
                Object[] objArr = new Object[1];
                b((byte) (PlaceComponentResult & 116), getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                b(getAuthRequestContext[25], getAuthRequestContext[41], getAuthRequestContext[48], new Object[1]);
                Object[] objArr2 = new Object[1];
                a(cArr, cArr2, ((ApplicationInfo) cls.getMethod((String) r3[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (super.getResources().getString(R.string.group_send_member_count).substring(0, 3).length() + 47255), new char[]{5495, 30098, 5947, 62802, 32674, 36611, 29511, 56909, 4359, 55122, 48696, 53960, 48282, 58040, 65205, 25808, 23963, 47732, 58604, 56972, 39650, 21529, 25309, 43705, 63773, 41514}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                char[] cArr3 = {46090, 64258, 3465, 32209};
                char[] cArr4 = {19302, 51953, 44438, 14523};
                try {
                    Object[] objArr3 = new Object[1];
                    b((byte) (PlaceComponentResult & 116), getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    b(getAuthRequestContext[25], getAuthRequestContext[41], getAuthRequestContext[48], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    a(cArr3, cArr4, ((ApplicationInfo) cls3.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (View.combineMeasuredStates(0, 0) + 48045), new char[]{19056, 60142, 21484, 30514, 14818, 1012, 55359, 8437, 22393, 27774, 11436, 25769, 12603, 21059, 47327, 12465, 21302, 58639}, objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0, 0), (ViewConfiguration.getEdgeSlop() >> 16) + 35, (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ExpandableListView.getPackedPositionChild(0L), 18 - Color.blue(0), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
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
        super.onResume();
    }

    @JvmName(name = "getPresenter")
    public final SavingCreateContract.Presenter getPresenter() {
        SavingCreateContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(SavingCreateContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
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

    @JvmName(name = "getSavingModel")
    public final SavingModel getSavingModel() {
        SavingModel savingModel = this.savingModel;
        if (savingModel != null) {
            return savingModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSavingModel")
    public final void setSavingModel(SavingModel savingModel) {
        Intrinsics.checkNotNullParameter(savingModel, "");
        this.savingModel = savingModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getSavingUpdateComponent")
    public final SavingUpdateComponent getSavingUpdateComponent() {
        SavingUpdateComponent savingUpdateComponent = this.savingUpdateComponent;
        if (savingUpdateComponent != null) {
            return savingUpdateComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "setSavingUpdateComponent")
    public final void setSavingUpdateComponent(SavingUpdateComponent savingUpdateComponent) {
        Intrinsics.checkNotNullParameter(savingUpdateComponent, "");
        this.savingUpdateComponent = savingUpdateComponent;
    }

    @JvmName(name = "isUpdate")
    /* renamed from: isUpdate  reason: from getter */
    protected final boolean getIsUpdate() {
        return this.isUpdate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "setUpdate")
    public final void setUpdate(boolean z) {
        this.isUpdate = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r5v8, types: [T, id.dana.component.customsnackbarcomponent.CustomSnackbar] */
    public final void showBottomWarningSnackbar(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        View findViewById = getWindow().getDecorView().findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        CustomSnackbar.Builder builder = new CustomSnackbar.Builder((ViewGroup) findViewById);
        builder.initRecordTimeStamp = errorMessage;
        builder.lookAheadTest = getString(R.string.pop_up_positive_button_saving_limit_info);
        builder.moveToNextValue = 0;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_warning_orange;
        builder.MyBillsEntityDataFactory = R.drawable.bg_rectangle_tangerine;
        Function1<CustomSnackbar, Unit> function1 = new Function1<CustomSnackbar, Unit>() { // from class: id.dana.savings.activity.SavingCreateActivity$showBottomWarningSnackbar$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CustomSnackbar customSnackbar) {
                invoke2(customSnackbar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CustomSnackbar customSnackbar) {
                Intrinsics.checkNotNullParameter(customSnackbar, "");
                CustomSnackbar customSnackbar2 = objectRef.element;
                if (customSnackbar2 != null) {
                    customSnackbar2.dismiss();
                }
            }
        };
        Intrinsics.checkNotNullParameter(function1, "");
        builder.getErrorConfigVersion = function1;
        objectRef.element = builder.BuiltInFictitiousFunctionClassFactory();
        ((CustomSnackbar) objectRef.element).show();
    }

    public final void setButtonEnable(boolean enable) {
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.f);
        if (danaButtonPrimaryView != null) {
            if (enable) {
                danaButtonPrimaryView.setActiveButton(KClassImpl$Data$declaredNonStaticMembers$2(this.isUpdate), null);
            } else {
                danaButtonPrimaryView.setDisabled(KClassImpl$Data$declaredNonStaticMembers$2(this.isUpdate));
            }
            danaButtonPrimaryView.setEnabled(enable);
        }
    }

    @Override // id.dana.base.BaseActivity
    public void init() {
        MoneyViewModel moneyViewModel;
        initComponent();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (SavingCreateInitModel) getIntent().getParcelableExtra(EXTRA_SAVING_CREATE_INIT_MODEL);
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.f);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new SingleClickListener() { // from class: id.dana.savings.activity.SavingCreateActivity$initViews$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(SavingCreateActivity.this);
                }

                @Override // id.dana.base.SingleClickListener
                public final void PlaceComponentResult(View p0) {
                    MoneyViewModel PlaceComponentResult2;
                    SavingCreateInitModel savingCreateInitModel;
                    MoneyViewModel PlaceComponentResult3;
                    SavingCreateContract.Presenter presenter = SavingCreateActivity.this.getPresenter();
                    CategorySelectorView categorySelectorView = (CategorySelectorView) SavingCreateActivity.this._$_findCachedViewById(R.id.view_category_selector);
                    String selectedCategoryCode = categorySelectorView != null ? categorySelectorView.getSelectedCategoryCode() : null;
                    if (selectedCategoryCode == null) {
                        selectedCategoryCode = "";
                    }
                    SavingGoalEntryView savingGoalEntryView = (SavingGoalEntryView) SavingCreateActivity.this._$_findCachedViewById(R.id.res_0x7f0a1b77_r8_lambda_gvlr6n_yiv9b1lq66he21ajmiku);
                    String title = savingGoalEntryView != null ? savingGoalEntryView.getTitle() : null;
                    String str = title != null ? title : "";
                    SavingGoalEntryView savingGoalEntryView2 = (SavingGoalEntryView) SavingCreateActivity.this._$_findCachedViewById(R.id.res_0x7f0a1b77_r8_lambda_gvlr6n_yiv9b1lq66he21ajmiku);
                    if (savingGoalEntryView2 == null || (PlaceComponentResult2 = savingGoalEntryView2.getTargetAmount()) == null) {
                        SavingCreateActivity.Companion companion = SavingCreateActivity.INSTANCE;
                        PlaceComponentResult2 = SavingCreateActivity.Companion.PlaceComponentResult();
                    }
                    savingCreateInitModel = SavingCreateActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (savingCreateInitModel == null || (PlaceComponentResult3 = savingCreateInitModel.lookAheadTest) == null) {
                        SavingCreateActivity.Companion companion2 = SavingCreateActivity.INSTANCE;
                        PlaceComponentResult3 = SavingCreateActivity.Companion.PlaceComponentResult();
                    }
                    presenter.BuiltInFictitiousFunctionClassFactory(selectedCategoryCode, str, PlaceComponentResult2, PlaceComponentResult3);
                }
            });
        }
        SavingGoalEntryView savingGoalEntryView = (SavingGoalEntryView) _$_findCachedViewById(R.id.res_0x7f0a1b77_r8_lambda_gvlr6n_yiv9b1lq66he21ajmiku);
        if (savingGoalEntryView != null) {
            savingGoalEntryView.setOnGoalChangeListener(new SavingGoalEntryView.OnGoalChangeListener() { // from class: id.dana.savings.activity.SavingCreateActivity$initViews$2
                @Override // id.dana.savings.view.SavingGoalEntryView.OnGoalChangeListener
                public final void getAuthRequestContext(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // id.dana.savings.view.SavingGoalEntryView.OnGoalChangeListener
                public final void MyBillsEntityDataFactory(boolean p0) {
                    SavingCreateActivity.this.setButtonEnable(p0);
                }
            });
        }
        SavingGoalEntryView savingGoalEntryView2 = (SavingGoalEntryView) _$_findCachedViewById(R.id.res_0x7f0a1b77_r8_lambda_gvlr6n_yiv9b1lq66he21ajmiku);
        if (savingGoalEntryView2 != null) {
            SavingCreateInitModel savingCreateInitModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (savingCreateInitModel == null || (moneyViewModel = savingCreateInitModel.lookAheadTest) == null) {
                moneyViewModel = NetworkUserEntityData$$ExternalSyntheticLambda0;
            }
            savingGoalEntryView2.setMaximumAmount(moneyViewModel);
        }
        CategorySelectorView categorySelectorView = (CategorySelectorView) _$_findCachedViewById(R.id.view_category_selector);
        if (categorySelectorView != null) {
            SavingCreateInitModel savingCreateInitModel2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            List<SavingCategoryModel> list = savingCreateInitModel2 != null ? savingCreateInitModel2.scheduleImpl : null;
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            categorySelectorView.setCategories(list);
        }
    }

    private final String KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        if (p0) {
            String string = getString(R.string.saving_save_changes);
            Intrinsics.checkNotNullExpressionValue(string, "");
            return string;
        }
        String string2 = getString(R.string.create_savings);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        return string2;
    }

    protected void initComponent() {
        DaggerSavingUpdateComponent.Builder PlaceComponentResult2 = DaggerSavingUpdateComponent.PlaceComponentResult();
        PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2 = (SavingCreateModule) Preconditions.getAuthRequestContext((SavingCreateModule) this.PlaceComponentResult.getValue());
        PlaceComponentResult2.MyBillsEntityDataFactory = (SavingUpdateModule) Preconditions.getAuthRequestContext(new SavingUpdateModule(new SavingUpdateListener()));
        PlaceComponentResult2.getAuthRequestContext = (CheckoutH5EventModule) Preconditions.getAuthRequestContext(new CheckoutH5EventModule(new CheckoutH5EventContract.View() { // from class: id.dana.savings.activity.SavingCreateActivity$$ExternalSyntheticLambda0
            @Override // id.dana.h5event.CheckoutH5EventContract.View
            public final void getAuthRequestContext(boolean z) {
                SavingCreateActivity.$r8$lambda$rcfkoJICtNxoFfYGQLUqFNbN_bc(z);
            }
        }));
        SavingUpdateComponent KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        setSavingUpdateComponent(KClassImpl$Data$declaredNonStaticMembers$2);
        getSavingUpdateComponent().BuiltInFictitiousFunctionClassFactory(this);
        registerPresenter(getPresenter());
    }

    @Override // id.dana.base.BaseActivity
    public void configToolbar() {
        setTitle(getString(R.string.create_savings_title));
        setMenuLeftButton(R.drawable.btn_arrow_left);
    }

    public final void showQuitEditingDialog(int titleResId, int messageResId, int positiveBtnResId, int negativeBtnResId) {
        CustomDialog.Builder builder = new CustomDialog.Builder(this);
        builder.SubSequence = getString(titleResId);
        builder.GetContactSyncConfig = getString(messageResId);
        CustomDialog.Builder PlaceComponentResult2 = builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false);
        PlaceComponentResult2.moveToNextValue = 0L;
        PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory(getString(positiveBtnResId), new Function1<View, Unit>() { // from class: id.dana.savings.activity.SavingCreateActivity$showQuitEditingDialog$1
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
                SavingCreateActivity.this.trackCanceledCreateActivity();
                super/*id.dana.base.BaseActivity*/.onBackPressed();
            }
        }).KClassImpl$Data$declaredNonStaticMembers$2(getString(negativeBtnResId), new Function1<View, Unit>() { // from class: id.dana.savings.activity.SavingCreateActivity$showQuitEditingDialog$2
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

    @OnClick({R.id.f3959iv_total_saving_limit_tooltip})
    public final void onTotalSavingLimitAboutClick() {
        getPresenter().MyBillsEntityDataFactory();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void showTotalSavingLimitInfoDialog(Context context, String maxSavingCount, String maxSavingAmount) {
        Intrinsics.checkNotNullParameter(context, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(context);
        builder.SubSequence = getString(R.string.pop_up_title_saving_limit_about_info);
        String string = getString(R.string.pop_up_description_saving_limit_about_info);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{maxSavingCount, maxSavingAmount}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "");
        builder.GetContactSyncConfig = format;
        builder.DatabaseTableConfigUtil = R.drawable.maximum_limit;
        builder.moveToNextValue = 0L;
        builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory(getString(R.string.pop_up_positive_button_saving_limit_info), new Function1<View, Unit>() { // from class: id.dana.savings.activity.SavingCreateActivity$showTotalSavingLimitInfoDialog$1
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final void showUpgradeToKycDialog(Context context, String maxSavingCountNonKyc, String maxSavingAmountNonKyc, String maxSavingAmountKyc) {
        Intrinsics.checkNotNullParameter(context, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(context);
        builder.SubSequence = getString(R.string.saving_withdrawal_title_dialog);
        String string = getString(R.string.pop_up_description_saving_limit_about_info_non_kyc);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{maxSavingCountNonKyc, maxSavingAmountNonKyc, maxSavingAmountKyc}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "");
        builder.GetContactSyncConfig = format;
        builder.DatabaseTableConfigUtil = R.drawable.ic_premium_feature;
        builder.moveToNextValue = 0L;
        builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false).KClassImpl$Data$declaredNonStaticMembers$2(getString(R.string.saving_withdrawal_negative_dialog), new Function1<View, Unit>() { // from class: id.dana.savings.activity.SavingCreateActivity$showUpgradeToKycDialog$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        }).BuiltInFictitiousFunctionClassFactory(getString(R.string.upgrade), new Function1<View, Unit>() { // from class: id.dana.savings.activity.SavingCreateActivity$showUpgradeToKycDialog$2
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
                SavingCreateActivity.access$openKycContainer(SavingCreateActivity.this);
            }
        }).BuiltInFictitiousFunctionClassFactory().show();
    }

    public final void trackCanceledCreateActivity() {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getApplicationContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.GOAL_SAVINGS_CANCELLED;
        builder.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0010\u001a\u00020\u000b8\u0007¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00118\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013"}, d2 = {"Lid/dana/savings/activity/SavingCreateActivity$Companion;", "", "Lid/dana/base/BaseActivity;", "p0", "", "p1", "Lid/dana/savings/model/SavingCreateInitModel;", "p2", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/base/BaseActivity;ILid/dana/savings/model/SavingCreateInitModel;)V", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "PlaceComponentResult", "()Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "EXTRA_CREATED_SAVING", "Ljava/lang/String;", "EXTRA_SAVING", "EXTRA_SAVING_CREATE_INIT_MODEL", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static void BuiltInFictitiousFunctionClassFactory(BaseActivity p0, int p1, SavingCreateInitModel p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intent intentClassWithTracking = p0.getIntentClassWithTracking(SavingCreateActivity.class);
            intentClassWithTracking.putExtra(SavingCreateActivity.EXTRA_SAVING_CREATE_INIT_MODEL, p2);
            p0.startActivityForResult(intentClassWithTracking, p1);
        }

        @JvmName(name = "PlaceComponentResult")
        public static MoneyViewModel PlaceComponentResult() {
            return SavingCreateActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
        NetworkUserEntityData$$ExternalSyntheticLambda0 = new MoneyViewModel("0", "Rp", null, 4, null);
    }

    public static final /* synthetic */ void access$finishCreateGoalSaving(SavingCreateActivity savingCreateActivity, SavingModel savingModel) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_CREATED_SAVING, savingModel);
        savingCreateActivity.setResult(-1, intent);
        savingCreateActivity.finish();
    }

    public static final /* synthetic */ LoadingDialog access$getLoadingDialog(SavingCreateActivity savingCreateActivity) {
        return (LoadingDialog) savingCreateActivity.MyBillsEntityDataFactory.getValue();
    }

    public static final /* synthetic */ void access$openKycContainer(SavingCreateActivity savingCreateActivity) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(savingCreateActivity.getDynamicUrlWrapper().getKycFromGoalSavingUrl());
        DanaH5.startContainerFullUrl(sb.toString());
    }

    public static final /* synthetic */ void access$trackingCreateSaving(SavingCreateActivity savingCreateActivity, String str, String str2, String str3) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(savingCreateActivity.getApplicationContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.GOAL_SAVINGS_CREATED;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(TrackerKey.Property.GOAL_CATEGORY, str).MyBillsEntityDataFactory(TrackerKey.Property.GOAL_NAME, str2).MyBillsEntityDataFactory(TrackerKey.Property.GOAL_AMOUNT, str3);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        CustomDialog.Builder builder = new CustomDialog.Builder(this);
        builder.SubSequence = getString(R.string.pop_up_title_cancel_create_saving_goal);
        builder.GetContactSyncConfig = getString(R.string.pop_up_description_cancel_create_saving_goal);
        CustomDialog.Builder PlaceComponentResult2 = builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false);
        PlaceComponentResult2.moveToNextValue = 0L;
        PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory(getString(R.string.pop_up_positive_button_cancel_create_saving_goal), new Function1<View, Unit>() { // from class: id.dana.savings.activity.SavingCreateActivity$showCancelDialog$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        }).KClassImpl$Data$declaredNonStaticMembers$2(getString(R.string.pop_up_negative_button_cancel_create_saving_goal), new Function1<View, Unit>() { // from class: id.dana.savings.activity.SavingCreateActivity$showCancelDialog$2
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
                SavingCreateActivity.this.trackCanceledCreateActivity();
                super/*id.dana.base.BaseActivity*/.onBackPressed();
            }
        }).BuiltInFictitiousFunctionClassFactory().show();
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
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr3[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 4360990799332652212L)) ^ ((int) (DatabaseTableConfigUtil ^ 4360990799332652212L))) ^ ((char) (NetworkUserEntityData$$ExternalSyntheticLambda2 ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
