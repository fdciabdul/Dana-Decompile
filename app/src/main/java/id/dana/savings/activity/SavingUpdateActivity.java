package id.dana.savings.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
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
import androidx.appcompat.widget.AppCompatTextView;
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
import id.dana.base.SingleClickListener;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.data.util.NumberUtils;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSavingUpdateComponent;
import id.dana.di.component.SavingUpdateComponent;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.SavingCreateModule;
import id.dana.di.modules.SavingUpdateModule;
import id.dana.dialog.LoadingDialog;
import id.dana.domain.DefaultObserver;
import id.dana.domain.saving.interactor.UpdateSaving;
import id.dana.domain.saving.model.SavingGoalView;
import id.dana.domain.saving.model.SavingUpdateInit;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.savings.contract.SavingCreateListener;
import id.dana.savings.contract.SavingUpdateContract;
import id.dana.savings.ext.SavingModelExtKt;
import id.dana.savings.mapper.SavingModelMapperKt;
import id.dana.savings.mapper.SavingUpdateInitModelMapperKt;
import id.dana.savings.model.SavingModel;
import id.dana.savings.model.SavingUpdateInitModel;
import id.dana.savings.presenter.SavingUpdatePresenter;
import id.dana.savings.view.CategorySelectorView;
import id.dana.savings.view.SavingGoalEntryView;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
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
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b1\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004R\u0013\u0010\u000e\u001a\u00020\u0010X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0013\u0010\b\u001a\u00020!X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\"\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001fR\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0013\u0010\u001a\u001a\u00020(X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b)\u0010\u0012R\"\u0010+\u001a\u00020*8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100"}, d2 = {"Lid/dana/savings/activity/SavingUpdateActivity;", "Lid/dana/savings/activity/SavingCreateActivity;", "", "configToolbar", "()V", IAPSyncCommand.COMMAND_INIT, "initComponent", "", "BuiltInFictitiousFunctionClassFactory", "()Z", "Lid/dana/savings/model/SavingModel;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/savings/model/SavingModel;)Z", "PlaceComponentResult", "onBackPressed", "Lid/dana/di/modules/CheckoutH5EventModule;", "scheduleImpl", "Lkotlin/Lazy;", "Lid/dana/h5event/CheckoutH5EventContract$Presenter;", "checkoutH5EventPresenter", "Lid/dana/h5event/CheckoutH5EventContract$Presenter;", "getCheckoutH5EventPresenter", "()Lid/dana/h5event/CheckoutH5EventContract$Presenter;", "setCheckoutH5EventPresenter", "(Lid/dana/h5event/CheckoutH5EventContract$Presenter;)V", "getErrorConfigVersion", "Z", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "DatabaseTableConfigUtil", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "getAuthRequestContext", "Lid/dana/dialog/LoadingDialog;", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/savings/model/SavingUpdateInitModel;", "GetContactSyncConfig", "Lid/dana/savings/model/SavingUpdateInitModel;", "lookAheadTest", "Lid/dana/di/modules/SavingUpdateModule;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/savings/presenter/SavingUpdatePresenter;", "savingUpdatePresenter", "Lid/dana/savings/presenter/SavingUpdatePresenter;", "getSavingUpdatePresenter", "()Lid/dana/savings/presenter/SavingUpdatePresenter;", "setSavingUpdatePresenter", "(Lid/dana/savings/presenter/SavingUpdatePresenter;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingUpdateActivity extends SavingCreateActivity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final int RESULT_CODE_SAVING_REVOKED = 1002;
    public static final int RESULT_CODE_SAVING_UPDATED = 1001;
    private static long isLayoutRequested;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private MoneyViewModel getAuthRequestContext;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private SavingUpdateInitModel lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private MoneyViewModel KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public CheckoutH5EventContract.Presenter checkoutH5EventPresenter;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;
    @Inject
    public SavingUpdatePresenter savingUpdatePresenter;
    public static final byte[] $$g = {113, -101, 105, Ascii.SUB, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$h = 184;
    public static final byte[] lookAheadTest = {99, 56, -99, 122, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 135;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<LoadingDialog>() { // from class: id.dana.savings.activity.SavingUpdateActivity$loadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LoadingDialog invoke() {
            return new LoadingDialog(SavingUpdateActivity.this);
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy getErrorConfigVersion = LazyKt.lazy(new Function0<SavingUpdateModule>() { // from class: id.dana.savings.activity.SavingUpdateActivity$savingUpdateModule$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SavingUpdateModule invoke() {
            final SavingUpdateActivity savingUpdateActivity = SavingUpdateActivity.this;
            return new SavingUpdateModule(new SavingUpdateContract.View() { // from class: id.dana.savings.activity.SavingUpdateActivity$savingUpdateModule$2.1
                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.savings.contract.SavingUpdateContract.View
                public final void MyBillsEntityDataFactory(SavingUpdateInitModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    SavingUpdateActivity.this.lookAheadTest = p0;
                    SavingGoalEntryView savingGoalEntryView = (SavingGoalEntryView) SavingUpdateActivity.this._$_findCachedViewById(R.id.res_0x7f0a1b77_r8_lambda_gvlr6n_yiv9b1lq66he21ajmiku);
                    if (savingGoalEntryView != null) {
                        savingGoalEntryView.setMaximumAmount(p0.PlaceComponentResult);
                    }
                    CategorySelectorView categorySelectorView = (CategorySelectorView) SavingUpdateActivity.this._$_findCachedViewById(R.id.view_category_selector);
                    if (categorySelectorView != null) {
                        SavingUpdateActivity savingUpdateActivity2 = SavingUpdateActivity.this;
                        categorySelectorView.setCurrentCategory(p0.moveToNextValue.PlaceComponentResult);
                        categorySelectorView.setCategories(p0.lookAheadTest);
                        categorySelectorView.selectCurrentCategory();
                        savingUpdateActivity2.getAuthRequestContext = p0.moveToNextValue.lookAheadTest;
                    }
                }

                @Override // id.dana.savings.contract.SavingUpdateContract.View
                public final void getAuthRequestContext(SavingModel p0) {
                    boolean KClassImpl$Data$declaredNonStaticMembers$2;
                    Intrinsics.checkNotNullParameter(p0, "");
                    KClassImpl$Data$declaredNonStaticMembers$2 = SavingUpdateActivity.this.KClassImpl$Data$declaredNonStaticMembers$2(p0);
                    if (KClassImpl$Data$declaredNonStaticMembers$2) {
                        SavingUpdateActivity savingUpdateActivity2 = SavingUpdateActivity.this;
                        String str = p0.PlaceComponentResult;
                        String str2 = p0.NetworkUserEntityData$$ExternalSyntheticLambda2;
                        String string = SavingUpdateActivity.this.getString(R.string.saving_level, SavingModelExtKt.MyBillsEntityDataFactory(p0));
                        Intrinsics.checkNotNullExpressionValue(string, "");
                        SavingUpdateActivity.access$trackingGoalEdited(savingUpdateActivity2, str, str2, string);
                    }
                    SavingUpdateActivity.access$finishUpdateGoalSaving(SavingUpdateActivity.this);
                }

                @Override // id.dana.savings.contract.SavingUpdateContract.View
                public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
                    SavingUpdateInitModel savingUpdateInitModel;
                    SavingUpdateInitModel savingUpdateInitModel2;
                    SavingUpdateInitModel savingUpdateInitModel3;
                    if (p0) {
                        String stringExtra = SavingUpdateActivity.this.getIntent().getStringExtra(SavingsActivity.MAX_SAVING_COUNT);
                        String stringExtra2 = SavingUpdateActivity.this.getIntent().getStringExtra(SavingsActivity.MAX_SAVING_AMOUNT);
                        SavingUpdateActivity savingUpdateActivity2 = SavingUpdateActivity.this;
                        savingUpdateActivity2.showTotalSavingLimitInfoDialog(savingUpdateActivity2, stringExtra, stringExtra2);
                        return;
                    }
                    SavingUpdateActivity savingUpdateActivity3 = SavingUpdateActivity.this;
                    SavingUpdateActivity savingUpdateActivity4 = savingUpdateActivity3;
                    savingUpdateInitModel = savingUpdateActivity3.lookAheadTest;
                    String str = savingUpdateInitModel != null ? savingUpdateInitModel.KClassImpl$Data$declaredNonStaticMembers$2 : null;
                    savingUpdateInitModel2 = SavingUpdateActivity.this.lookAheadTest;
                    String str2 = savingUpdateInitModel2 != null ? savingUpdateInitModel2.MyBillsEntityDataFactory : null;
                    savingUpdateInitModel3 = SavingUpdateActivity.this.lookAheadTest;
                    savingUpdateActivity3.showUpgradeToKycDialog(savingUpdateActivity4, str, str2, savingUpdateInitModel3 != null ? savingUpdateInitModel3.BuiltInFictitiousFunctionClassFactory : null);
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void showProgress() {
                    LoadingDialog access$getLoadingDialog = SavingUpdateActivity.access$getLoadingDialog(SavingUpdateActivity.this);
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
                    SavingUpdateActivity.access$getLoadingDialog(SavingUpdateActivity.this).KClassImpl$Data$declaredNonStaticMembers$2();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void onError(String p0) {
                    if (p0 != null) {
                        SavingUpdateActivity.this.showBottomWarningSnackbar(p0);
                    }
                }
            });
        }
    });

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult = LazyKt.lazy(new SavingUpdateActivity$checkoutH5EventModule$2(this));

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
    }

    static void getAuthRequestContext() {
        isLayoutRequested = 8689929880634799955L;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.savings.activity.SavingUpdateActivity.lookAheadTest
            int r7 = 106 - r7
            int r8 = 23 - r8
            int r6 = 55 - r6
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L14
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L31
        L14:
            r3 = 0
        L15:
            int r6 = r6 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
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
        L31:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.activity.SavingUpdateActivity.h(short, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(int r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.savings.activity.SavingUpdateActivity.$$g
            int r8 = 47 - r8
            int r7 = r7 * 2
            int r7 = 103 - r7
            int r6 = r6 * 3
            int r6 = r6 + 21
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
            r5 = r8
            r8 = r7
            r7 = r5
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r3 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L35:
            int r7 = -r7
            int r8 = r8 + 1
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.activity.SavingUpdateActivity.j(int, byte, byte, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final void startActivityForResult(BaseActivity baseActivity, int i, SavingModel savingModel, String str, String str2) {
        Companion.MyBillsEntityDataFactory(baseActivity, i, savingModel, str, str2);
    }

    @Override // id.dana.savings.activity.SavingCreateActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.savings.activity.SavingCreateActivity
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

    @Override // id.dana.savings.activity.SavingCreateActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        g(View.MeasureSpec.getMode(0) + 1, new char[]{16239, 56722, 16142, 57486, 37386, 42823, 5532, 57929, 54764, 47196, 136, 51513, 60120, 36210, 11246, 54355, 65497, 59010, 22231, 41626, 38060, 64394}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        g((ViewConfiguration.getKeyRepeatDelay() >> 16) + 1, new char[]{3854, 43787, 3939, 22023, 40621, 53705, 41764, 61173, 58758}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 881, 35 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    g((Process.myPid() >> 22) + 1, new char[]{35387, 38668, 35340, 56863, 5196, 60884, 11103, 25669, 24807, 62159, 15940, 20329, 24532, 51194, 5426, 21027, 19098, 44097, 26644, 9359, 8634, 45398, 32527, 4044, 7363, 34360, 21102, 4791, 3031, 27516, 43225, 58769, 59005, 28743, 49044, 51340, 56674, 17697, 37627, 54244, 51217, 10802, 59877, 42497, 42804, 12441, 64645, 35091, 37501, 1504, 54195, 40060}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    g(TextUtils.getOffsetBefore("", 0) + 1, new char[]{65423, 46340, 65518, 6182, 59458, 53130, 60774, 38935, 5381, 53402, 63604, 45927, 10803, 58868, 54097, 44670, 16175, 36426, 44589, 55427, 21517, 37725, 47462, 62354, 26999, 42082, 37890, 61116, 32305, 18725, 28385, 6558, 37827, 21071, 31230, 13525, 43148, 26491, 21700, 12267, 48544, 2144, 12244, 23052, 53890, 4807, 15085, 29978, 59336, 10220, 5517, 24608, 64684, 51452, 57495, 39738, 4682, 56708, 64356, 46686, 10071, 59030, 54811, 41273, 15466, 35763, 41224, 56436}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    g(1 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), new char[]{61716, 59225, 61734, 57278, 15559, 40403, 10925, 19604, 7105, 33481, 16366, 26606, 9460, 47090, 5320, 31487, 12769, 56341, 27060, 3077, 23237, 49495, 32428, 10050, 26554, 63084, 21453, 14905, 28843, 7036, 43385, 52550, 40198, 16, 48739, 57345, 42563, 13606, 37722, 64366, 45882, 23145, 59466, 36482, 56340, 16588, 64801, 41370, 59656, 30134, 53829, 46320, 62050, 39595, 10075, 20451, 7386, 36831, 15530, 25311, 10699, 46287, 4569, 30184, 12966, 55779, 26305, 2299}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    g(1 - ((Process.getThreadPriority(0) + 20) >> 6), new char[]{21924, 513, 21964, 30335, 20042, 30926, 33661, 15883, 48955, 26524, 38450, 5496, 32792, 21235, 48479, 2082, 38222, 14602, 49197, 32461, 65137, 9227, 55085, 21960, 50009, 4901, 64025, 18601, 54347, 65079, 224, 49025, 14772, 58717, 6116, 37530, 677, 53352, 15052, 35317, 6027, 49001, 16848, 64536, 30973, 42370, 21688, 54028, 19945, 37040, 31618, 50810, 22215, 32702, 36566, 15741, 47210, 27289, 38248, 4113, 36137, 20940, 47189, 1824}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    g(1 - Color.alpha(0), new char[]{'O', 8746, 'v', 58832, 65233, 22719, 4242, 36558, 60049, 18364}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, 19 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                h((byte) (-lookAheadTest[31]), lookAheadTest[25], lookAheadTest[30], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                h((short) 30, lookAheadTest[9], lookAheadTest[30], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 55, 3 - KeyEvent.getDeadChar(0, 0), (char) (ViewConfiguration.getJumpTapTimeout() >> 16));
                        Object[] objArr16 = new Object[1];
                        j($$g[47], (byte) (-$$g[12]), (byte) (-$$g[53]), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 800, 15 - ExpandableListView.getPackedPositionType(0L), (char) View.MeasureSpec.getSize(0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getPressedStateDuration() >> 16), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 14, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - ExpandableListView.getPackedPositionChild(0L), Color.alpha(0) + 29, (char) (57994 - Color.red(0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 800, (ViewConfiguration.getTouchSlop() >> 8) + 15, (char) (ViewConfiguration.getFadingEdgeLength() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, View.MeasureSpec.makeMeasureSpec(0, 0) + 35, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1708786223, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, 18 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                h((byte) (-lookAheadTest[31]), lookAheadTest[25], lookAheadTest[30], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                h((short) 30, lookAheadTest[9], lookAheadTest[30], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 62, ExpandableListView.getPackedPositionType(0L) + 46, (char) (ViewConfiguration.getWindowTouchSlop() >> 8));
                        byte b = (byte) ($$g[47] - 1);
                        Object[] objArr22 = new Object[1];
                        j(b, b, $$g[20], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getDoubleTapTimeout() >> 16), ImageFormat.getBitsPerPixel(0) + 36, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {1708786223, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.normalizeMetaState(0), (ViewConfiguration.getJumpTapTimeout() >> 16) + 18, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                h((byte) (-lookAheadTest[31]), lookAheadTest[25], lookAheadTest[30], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                h((short) 30, lookAheadTest[9], lookAheadTest[30], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 2 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (38968 - (Process.myTid() >> 22)));
                        byte b2 = (byte) ($$g[47] - 1);
                        Object[] objArr28 = new Object[1];
                        j(b2, b2, $$g[20], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.getOffsetBefore("", 0) + 35, (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1708786223, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 911, 'B' - AndroidCharacter.getMirror('0'), (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                h((byte) (-lookAheadTest[31]), lookAheadTest[25], lookAheadTest[30], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                h((short) 30, lookAheadTest[9], lookAheadTest[30], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 107, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 3, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))));
                        Object[] objArr34 = new Object[1];
                        j((byte) (-$$g[8]), (byte) (-$$g[9]), (byte) ($$g[47] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, TextUtils.indexOf("", "") + 35, (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {1708786223, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 17, (char) TextUtils.getOffsetBefore("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.savings.activity.SavingCreateActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.savings.activity.SavingCreateActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.savings.activity.SavingCreateActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.savings.activity.SavingCreateActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        g(super.getResources().getString(R.string.topup_and_pay_amount_maximum_error_message).substring(45, 50).codePointAt(3) - 36, new char[]{16239, 56722, 16142, 57486, 37386, 42823, 5532, 57929, 54764, 47196, 136, 51513, 60120, 36210, 11246, 54355, 65497, 59010, 22231, 41626, 38060, 64394}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        g(getPackageName().codePointAt(2) - 45, new char[]{3854, 43787, 3939, 22023, 40621, 53705, 41764, 61173, 58758}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                g(getPackageName().length() - 6, new char[]{58755, 63966, 58850, 20435, 35021, 33547, 47809, 63630, 3840, 39952, 45013, 54270, 12346, 43325, 34029, 52970, 9478, 49858, 63901, 47185, 20037, 57308, 61057, 37717, 29515, 59617, 50099, 36453, 25706, 1529}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                g((ViewConfiguration.getTouchSlop() >> 8) + 1, new char[]{26487, 10977, 26388, 37335, 65488, 20527, 25811, 36755, 36350, 20264, 29121, 42124, 45791, 31234, 23285, 47536, 42960, 4607, 10137, 53068, 52392, 3300}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 36, (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    g(super.getResources().getString(R.string.option_mute_friend).substring(0, 4).codePointAt(3) - 100, new char[]{35387, 38668, 35340, 56863, 5196, 60884, 11103, 25669, 24807, 62159, 15940, 20329, 24532, 51194, 5426, 21027, 19098, 44097, 26644, 9359, 8634, 45398, 32527, 4044, 7363, 34360, 21102, 4791, 3031, 27516, 43225, 58769, 59005, 28743, 49044, 51340, 56674, 17697, 37627, 54244, 51217, 10802, 59877, 42497, 42804, 12441, 64645, 35091, 37501, 1504, 54195, 40060}, objArr6);
                    String str = (String) objArr6[0];
                    try {
                        Object[] objArr7 = new Object[1];
                        h((byte) (lookAheadTest[49] - 1), (byte) (-lookAheadTest[32]), lookAheadTest[25], objArr7);
                        Class<?> cls3 = Class.forName((String) objArr7[0]);
                        h(lookAheadTest[25], lookAheadTest[48], lookAheadTest[41], new Object[1]);
                        Object[] objArr8 = new Object[1];
                        g(((ApplicationInfo) cls3.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{65423, 46340, 65518, 6182, 59458, 53130, 60774, 38935, 5381, 53402, 63604, 45927, 10803, 58868, 54097, 44670, 16175, 36426, 44589, 55427, 21517, 37725, 47462, 62354, 26999, 42082, 37890, 61116, 32305, 18725, 28385, 6558, 37827, 21071, 31230, 13525, 43148, 26491, 21700, 12267, 48544, 2144, 12244, 23052, 53890, 4807, 15085, 29978, 59336, 10220, 5517, 24608, 64684, 51452, 57495, 39738, 4682, 56708, 64356, 46686, 10071, 59030, 54811, 41273, 15466, 35763, 41224, 56436}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        g(super.getResources().getString(R.string.account_freeze_title).substring(4, 5).codePointAt(0) - 31, new char[]{61716, 59225, 61734, 57278, 15559, 40403, 10925, 19604, 7105, 33481, 16366, 26606, 9460, 47090, 5320, 31487, 12769, 56341, 27060, 3077, 23237, 49495, 32428, 10050, 26554, 63084, 21453, 14905, 28843, 7036, 43385, 52550, 40198, 16, 48739, 57345, 42563, 13606, 37722, 64366, 45882, 23145, 59466, 36482, 56340, 16588, 64801, 41370, 59656, 30134, 53829, 46320, 62050, 39595, 10075, 20451, 7386, 36831, 15530, 25311, 10699, 46287, 4569, 30184, 12966, 55779, 26305, 2299}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        g(super.getResources().getString(R.string.option_mute_friend).substring(0, 4).codePointAt(2) - 115, new char[]{21924, 513, 21964, 30335, 20042, 30926, 33661, 15883, 48955, 26524, 38450, 5496, 32792, 21235, 48479, 2082, 38222, 14602, 49197, 32461, 65137, 9227, 55085, 21960, 50009, 4901, 64025, 18601, 54347, 65079, 224, 49025, 14772, 58717, 6116, 37530, 677, 53352, 15052, 35317, 6027, 49001, 16848, 64536, 30973, 42370, 21688, 54028, 19945, 37040, 31618, 50810, 22215, 32702, 36566, 15741, 47210, 27289, 38248, 4113, 36137, 20940, 47189, 1824}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        g(1 - Color.red(0), new char[]{'O', 8746, 'v', 58832, 65233, 22719, 4242, 36558, 60049, 18364}, objArr11);
                        try {
                            Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 911, 18 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            }
        }
        try {
            Object[] objArr13 = new Object[1];
            h((byte) (-lookAheadTest[31]), lookAheadTest[25], lookAheadTest[30], objArr13);
            Class<?> cls4 = Class.forName((String) objArr13[0]);
            Object[] objArr14 = new Object[1];
            h((short) 30, lookAheadTest[9], lookAheadTest[30], objArr14);
            try {
                Object[] objArr15 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), View.MeasureSpec.getMode(0) + 4, (char) Gravity.getAbsoluteGravity(0, 0));
                    Object[] objArr16 = new Object[1];
                    j((byte) (-$$g[8]), (byte) (-$$g[9]), (byte) ($$g[47] - 1), objArr16);
                    obj3 = cls5.getMethod((String) objArr16[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr17 = (Object[]) ((Method) obj3).invoke(null, objArr15);
                int i = ((int[]) objArr17[1])[0];
                if (((int[]) objArr17[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), Color.rgb(0, 0, 0) + 16777251, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr18 = {1678138772, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 912, (-16777198) - Color.rgb(0, 0, 0), (char) Color.argb(0, 0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr18);
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
                super.onCreate(bundle);
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

    @Override // id.dana.savings.activity.SavingCreateActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g(1 - (KeyEvent.getMaxKeyCode() >> 16), new char[]{58755, 63966, 58850, 20435, 35021, 33547, 47809, 63630, 3840, 39952, 45013, 54270, 12346, 43325, 34029, 52970, 9478, 49858, 63901, 47185, 20037, 57308, 61057, 37717, 29515, 59617, 50099, 36453, 25706, 1529}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            g(super.getResources().getString(R.string.please_complete_your_cvv_code).substring(3, 4).codePointAt(0) - 96, new char[]{26487, 10977, 26388, 37335, 65488, 20527, 25811, 36755, 36350, 20264, 29121, 42124, 45791, 31234, 23285, 47536, 42960, 4607, 10137, 53068, 52392, 3300}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.green(0), 35 - View.resolveSize(0, 0), (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + 911, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.savings.activity.SavingCreateActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 1, new char[]{58755, 63966, 58850, 20435, 35021, 33547, 47809, 63630, 3840, 39952, 45013, 54270, 12346, 43325, 34029, 52970, 9478, 49858, 63901, 47185, 20037, 57308, 61057, 37717, 29515, 59617, 50099, 36453, 25706, 1529}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            g(super.getResources().getString(R.string.ep_paylater_activation_no_addtional_fee_title).substring(8, 9).codePointAt(0) - 96, new char[]{26487, 10977, 26388, 37335, 65488, 20527, 25811, 36755, 36350, 20264, 29121, 42124, 45791, 31234, 23285, 47536, 42960, 4607, 10137, 53068, 52392, 3300}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), Drawable.resolveOpacity(0, 0) + 35, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 912, 19 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getSavingUpdatePresenter")
    public final SavingUpdatePresenter getSavingUpdatePresenter() {
        SavingUpdatePresenter savingUpdatePresenter = this.savingUpdatePresenter;
        if (savingUpdatePresenter != null) {
            return savingUpdatePresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSavingUpdatePresenter")
    public final void setSavingUpdatePresenter(SavingUpdatePresenter savingUpdatePresenter) {
        Intrinsics.checkNotNullParameter(savingUpdatePresenter, "");
        this.savingUpdatePresenter = savingUpdatePresenter;
    }

    @JvmName(name = "getCheckoutH5EventPresenter")
    public final CheckoutH5EventContract.Presenter getCheckoutH5EventPresenter() {
        CheckoutH5EventContract.Presenter presenter = this.checkoutH5EventPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setCheckoutH5EventPresenter")
    public final void setCheckoutH5EventPresenter(CheckoutH5EventContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.checkoutH5EventPresenter = presenter;
    }

    @Override // id.dana.savings.activity.SavingCreateActivity, id.dana.base.BaseActivity
    public final void init() {
        PublishSubject<Boolean> categorySavingSelectedSubject;
        SavingModel savingModel;
        initComponent();
        Intent intent = getIntent();
        if (intent != null && (savingModel = (SavingModel) intent.getParcelableExtra(SavingCreateActivity.EXTRA_SAVING)) != null) {
            setSavingModel(savingModel);
            SavingGoalEntryView savingGoalEntryView = (SavingGoalEntryView) _$_findCachedViewById(R.id.res_0x7f0a1b77_r8_lambda_gvlr6n_yiv9b1lq66he21ajmiku);
            if (savingGoalEntryView != null) {
                savingGoalEntryView.setTitle(savingModel.NetworkUserEntityData$$ExternalSyntheticLambda2);
            }
            SavingGoalEntryView savingGoalEntryView2 = (SavingGoalEntryView) _$_findCachedViewById(R.id.res_0x7f0a1b77_r8_lambda_gvlr6n_yiv9b1lq66he21ajmiku);
            if (savingGoalEntryView2 != null) {
                savingGoalEntryView2.setGoal(savingModel.DatabaseTableConfigUtil.PlaceComponentResult);
            }
            SavingGoalEntryView savingGoalEntryView3 = (SavingGoalEntryView) _$_findCachedViewById(R.id.res_0x7f0a1b77_r8_lambda_gvlr6n_yiv9b1lq66he21ajmiku);
            if (savingGoalEntryView3 != null) {
                savingGoalEntryView3.setGoalAmount(savingModel.DatabaseTableConfigUtil.PlaceComponentResult);
            }
            SavingGoalEntryView savingGoalEntryView4 = (SavingGoalEntryView) _$_findCachedViewById(R.id.res_0x7f0a1b77_r8_lambda_gvlr6n_yiv9b1lq66he21ajmiku);
            if (savingGoalEntryView4 != null) {
                savingGoalEntryView4.setMinAmount(new MoneyViewModel(String.valueOf((int) (savingModel.lookAheadTest.BuiltInFictitiousFunctionClassFactory() + 1)), "Rp", null, 4, null));
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = savingModel.lookAheadTest;
            String str = savingModel.GetContactSyncConfig;
            final SavingUpdatePresenter savingUpdatePresenter = getSavingUpdatePresenter();
            Intrinsics.checkNotNullParameter(str, "");
            savingUpdatePresenter.PlaceComponentResult.showProgress();
            savingUpdatePresenter.KClassImpl$Data$declaredNonStaticMembers$2.execute(str, new Function1<SavingUpdateInit, Unit>() { // from class: id.dana.savings.presenter.SavingUpdatePresenter$initUpdateSaving$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(SavingUpdateInit savingUpdateInit) {
                    invoke2(savingUpdateInit);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(SavingUpdateInit savingUpdateInit) {
                    SavingUpdateContract.View view;
                    SavingUpdateContract.View view2;
                    Intrinsics.checkNotNullParameter(savingUpdateInit, "");
                    view = SavingUpdatePresenter.this.PlaceComponentResult;
                    view.dismissProgress();
                    view2 = SavingUpdatePresenter.this.PlaceComponentResult;
                    view2.MyBillsEntityDataFactory(SavingUpdateInitModelMapperKt.getAuthRequestContext(savingUpdateInit));
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.savings.presenter.SavingUpdatePresenter$initUpdateSaving$2
                private static int $10 = 0;
                private static int $11 = 1;
                private static int $BuiltInFictitiousFunctionClassFactory = 1;
                private static int $KClassImpl$Data$declaredNonStaticMembers$2;
                private static char[] getAuthRequestContext = {35511, 35524, 35573, 35569, 35573, 35572};

                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    int i = $KClassImpl$Data$declaredNonStaticMembers$2 + 109;
                    $BuiltInFictitiousFunctionClassFactory = i % 128;
                    int i2 = i % 2;
                    invoke2(th);
                    Unit unit = Unit.INSTANCE;
                    int i3 = $KClassImpl$Data$declaredNonStaticMembers$2 + 69;
                    $BuiltInFictitiousFunctionClassFactory = i3 % 128;
                    int i4 = i3 % 2;
                    return unit;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    SavingUpdateContract.View view;
                    int i = $KClassImpl$Data$declaredNonStaticMembers$2 + 5;
                    $BuiltInFictitiousFunctionClassFactory = i % 128;
                    int i2 = i % 2;
                    Intrinsics.checkNotNullParameter(th, "");
                    view = SavingUpdatePresenter.this.PlaceComponentResult;
                    view.dismissProgress();
                    SavingUpdatePresenter.KClassImpl$Data$declaredNonStaticMembers$2(SavingUpdatePresenter.this, th);
                    Object[] objArr = new Object[1];
                    a(new int[]{0, 6, 0, 0}, false, new byte[]{1, 0, 1, 1, 1, 1}, objArr);
                    DanaLog.BuiltInFictitiousFunctionClassFactory(((String) objArr[0]).intern(), "Fail to init saving update", th);
                    int i3 = $BuiltInFictitiousFunctionClassFactory + 45;
                    $KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    int i4 = i3 % 2;
                }

                /* JADX WARN: Code restructure failed: missing block: B:24:0x0084, code lost:
                
                    if (r19[r0.BuiltInFictitiousFunctionClassFactory] == 1) goto L32;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:30:0x0094, code lost:
                
                    if ((r19[r0.BuiltInFictitiousFunctionClassFactory] == 0 ? '?' : '`') != '?') goto L31;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:31:0x0096, code lost:
                
                    r2[r0.BuiltInFictitiousFunctionClassFactory] = (char) ((r7[r0.BuiltInFictitiousFunctionClassFactory] * 2) - r8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:32:0x00a3, code lost:
                
                    r2[r0.BuiltInFictitiousFunctionClassFactory] = (char) (((r7[r0.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - r8);
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                private static void a(int[] r17, boolean r18, byte[] r19, java.lang.Object[] r20) {
                    /*
                        Method dump skipped, instructions count: 327
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.presenter.SavingUpdatePresenter$initUpdateSaving$2.a(int[], boolean, byte[], java.lang.Object[]):void");
                }
            });
        }
        CategorySelectorView categorySelectorView = (CategorySelectorView) _$_findCachedViewById(R.id.view_category_selector);
        addDisposable((categorySelectorView == null || (categorySavingSelectedSubject = categorySelectorView.getCategorySavingSelectedSubject()) == null) ? null : categorySavingSelectedSubject.subscribe(new Consumer() { // from class: id.dana.savings.activity.SavingUpdateActivity$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SavingUpdateActivity.this.setButtonEnable(((Boolean) obj).booleanValue());
            }
        }));
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.f);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new SingleClickListener() { // from class: id.dana.savings.activity.SavingUpdateActivity$initViews$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(SavingUpdateActivity.this);
                }

                @Override // id.dana.base.SingleClickListener
                public final void PlaceComponentResult(View p0) {
                    SavingUpdateActivity.access$updateSaving(SavingUpdateActivity.this);
                }
            });
        }
        SavingGoalEntryView savingGoalEntryView5 = (SavingGoalEntryView) _$_findCachedViewById(R.id.res_0x7f0a1b77_r8_lambda_gvlr6n_yiv9b1lq66he21ajmiku);
        if (savingGoalEntryView5 != null) {
            savingGoalEntryView5.setOnGoalChangeListener(new SavingGoalEntryView.OnGoalChangeListener() { // from class: id.dana.savings.activity.SavingUpdateActivity$initViews$2
                @Override // id.dana.savings.view.SavingGoalEntryView.OnGoalChangeListener
                public final void MyBillsEntityDataFactory(boolean p0) {
                    boolean PlaceComponentResult;
                    PlaceComponentResult = SavingUpdateActivity.this.PlaceComponentResult();
                    if (PlaceComponentResult) {
                        SavingUpdateActivity.this.setButtonEnable(p0);
                    } else if (p0) {
                    } else {
                        SavingUpdateActivity.access$restictSaveWhenAmountIsMinimum(SavingUpdateActivity.this);
                    }
                }

                @Override // id.dana.savings.view.SavingGoalEntryView.OnGoalChangeListener
                public final void getAuthRequestContext(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (Intrinsics.areEqual(SavingUpdateActivity.this.getSavingModel().NetworkUserEntityData$$ExternalSyntheticLambda2, p0)) {
                        return;
                    }
                    SavingUpdateActivity.this.setButtonEnable(true);
                }
            });
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.iv_total_saving_limit_tooltip);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.activity.SavingUpdateActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SavingUpdateActivity.$r8$lambda$s0Ys6eYd4wK7ZZkRNmkJBxjNcFo(SavingUpdateActivity.this, view);
                }
            });
        }
        setUpdate(true);
    }

    @Override // id.dana.savings.activity.SavingCreateActivity
    protected final void initComponent() {
        DaggerSavingUpdateComponent.Builder PlaceComponentResult = DaggerSavingUpdateComponent.PlaceComponentResult();
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (SavingCreateModule) Preconditions.getAuthRequestContext(new SavingCreateModule(new SavingCreateListener()));
        PlaceComponentResult.MyBillsEntityDataFactory = (SavingUpdateModule) Preconditions.getAuthRequestContext((SavingUpdateModule) this.getErrorConfigVersion.getValue());
        PlaceComponentResult.getAuthRequestContext = (CheckoutH5EventModule) Preconditions.getAuthRequestContext((CheckoutH5EventModule) this.PlaceComponentResult.getValue());
        SavingUpdateComponent KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        setSavingUpdateComponent(KClassImpl$Data$declaredNonStaticMembers$2);
        getSavingUpdateComponent().getAuthRequestContext(this);
        registerPresenter(getSavingUpdatePresenter());
    }

    @Override // id.dana.savings.activity.SavingCreateActivity, id.dana.base.BaseActivity
    public final void configToolbar() {
        setTitle(getString(R.string.edit_savings_title));
        setMenuLeftButton(R.drawable.btn_arrow_left);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(SavingModel p0) {
        return (Intrinsics.areEqual(getSavingModel().NetworkUserEntityData$$ExternalSyntheticLambda2, p0.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(getSavingModel().DatabaseTableConfigUtil, p0.DatabaseTableConfigUtil) && Intrinsics.areEqual(getSavingModel().PlaceComponentResult, p0.PlaceComponentResult)) ? false : true;
    }

    @Override // id.dana.savings.activity.SavingCreateActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        showQuitEditingDialog(R.string.pop_up_title_cancel_edit_saving_goal, R.string.pop_up_desc_cancel_edit_saving_goal, R.string.pop_up_negative_button_cancel_edit_saving_goal, R.string.pop_up_positive_button_cancel_edit_saving_goal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean PlaceComponentResult() {
        MoneyViewModel moneyViewModel;
        if (BuiltInFictitiousFunctionClassFactory()) {
            return true;
        }
        SavingGoalEntryView savingGoalEntryView = (SavingGoalEntryView) _$_findCachedViewById(R.id.res_0x7f0a1b77_r8_lambda_gvlr6n_yiv9b1lq66he21ajmiku);
        MoneyViewModel targetAmount = savingGoalEntryView != null ? savingGoalEntryView.getTargetAmount() : null;
        if (targetAmount == null || (moneyViewModel = this.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            return false;
        }
        return moneyViewModel.PlaceComponentResult(targetAmount);
    }

    private final boolean BuiltInFictitiousFunctionClassFactory() {
        MoneyViewModel moneyViewModel = this.getAuthRequestContext;
        return Intrinsics.areEqual(moneyViewModel != null ? moneyViewModel.PlaceComponentResult : null, "0");
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f"}, d2 = {"Lid/dana/savings/activity/SavingUpdateActivity$Companion;", "", "Lid/dana/base/BaseActivity;", "p0", "", "p1", "Lid/dana/savings/model/SavingModel;", "p2", "", "p3", "p4", "", "MyBillsEntityDataFactory", "(Lid/dana/base/BaseActivity;ILid/dana/savings/model/SavingModel;Ljava/lang/String;Ljava/lang/String;)V", "RESULT_CODE_SAVING_REVOKED", "I", "RESULT_CODE_SAVING_UPDATED", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static void MyBillsEntityDataFactory(BaseActivity p0, int p1, SavingModel p2, String p3, String p4) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intent intentClassWithTracking = p0.getIntentClassWithTracking(SavingUpdateActivity.class);
            intentClassWithTracking.putExtra(SavingCreateActivity.EXTRA_SAVING, p2);
            intentClassWithTracking.putExtra(SavingsActivity.MAX_SAVING_COUNT, p3);
            intentClassWithTracking.putExtra(SavingsActivity.MAX_SAVING_AMOUNT, p4);
            p0.startActivityForResult(intentClassWithTracking, p1);
        }
    }

    public static /* synthetic */ void $r8$lambda$s0Ys6eYd4wK7ZZkRNmkJBxjNcFo(SavingUpdateActivity savingUpdateActivity, View view) {
        Intrinsics.checkNotNullParameter(savingUpdateActivity, "");
        final SavingUpdatePresenter savingUpdatePresenter = savingUpdateActivity.getSavingUpdatePresenter();
        savingUpdatePresenter.PlaceComponentResult.showProgress();
        savingUpdatePresenter.MyBillsEntityDataFactory.execute(new DefaultObserver<UserInfoResponse>() { // from class: id.dana.savings.presenter.SavingUpdatePresenter$getKycStatus$1

            /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
            public boolean MyBillsEntityDataFactory;

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                UserInfoResponse userInfoResponse = (UserInfoResponse) obj;
                Intrinsics.checkNotNullParameter(userInfoResponse, "");
                this.MyBillsEntityDataFactory = userInfoResponse.isKycCertified();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                SavingUpdateContract.View view2;
                Intrinsics.checkNotNullParameter(p0, "");
                super.onError(p0);
                view2 = SavingUpdatePresenter.this.PlaceComponentResult;
                view2.dismissProgress();
                SavingUpdatePresenter.KClassImpl$Data$declaredNonStaticMembers$2(SavingUpdatePresenter.this, p0);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onComplete() {
                SavingUpdateContract.View view2;
                SavingUpdateContract.View view3;
                super.onComplete();
                view2 = SavingUpdatePresenter.this.PlaceComponentResult;
                view2.dismissProgress();
                view3 = SavingUpdatePresenter.this.PlaceComponentResult;
                view3.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory);
            }
        }, GetUserInfoWithKyc.Params.forParams(true));
    }

    public static final /* synthetic */ void access$finishUpdateGoalSaving(SavingUpdateActivity savingUpdateActivity) {
        savingUpdateActivity.setResult(1001);
        savingUpdateActivity.finish();
    }

    public static final /* synthetic */ LoadingDialog access$getLoadingDialog(SavingUpdateActivity savingUpdateActivity) {
        return (LoadingDialog) savingUpdateActivity.BuiltInFictitiousFunctionClassFactory.getValue();
    }

    public static final /* synthetic */ void access$goToSavingGoalPage(SavingUpdateActivity savingUpdateActivity) {
        Intent intent = new Intent(savingUpdateActivity, SavingsActivity.class);
        intent.setFlags(603979776);
        savingUpdateActivity.startActivity(intent);
        savingUpdateActivity.finish();
    }

    public static final /* synthetic */ void access$onOpenH5(SavingUpdateActivity savingUpdateActivity) {
        savingUpdateActivity.MyBillsEntityDataFactory = false;
        savingUpdateActivity.getCheckoutH5EventPresenter().MyBillsEntityDataFactory();
    }

    public static final /* synthetic */ void access$restictSaveWhenAmountIsMinimum(SavingUpdateActivity savingUpdateActivity) {
        savingUpdateActivity.setButtonEnable(false);
        Object[] objArr = new Object[1];
        MoneyViewModel moneyViewModel = savingUpdateActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        objArr[0] = new MoneyViewModel(String.valueOf(moneyViewModel != null ? Integer.valueOf((int) (moneyViewModel.BuiltInFictitiousFunctionClassFactory() + 1)) : null), "Rp", null, 4, null).getAuthRequestContext();
        String string = savingUpdateActivity.getString(R.string.minimum_savings_target_warning, objArr);
        Intrinsics.checkNotNullExpressionValue(string, "");
        AppCompatTextView appCompatTextView = (AppCompatTextView) savingUpdateActivity._$_findCachedViewById(R.id.tv_maximum_target);
        if (appCompatTextView != null) {
            appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) savingUpdateActivity._$_findCachedViewById(R.id.tv_maximum_target);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(string);
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) savingUpdateActivity._$_findCachedViewById(R.id.tv_maximum_target);
        if (appCompatTextView3 != null) {
            appCompatTextView3.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(savingUpdateActivity, R.color.f26712131100373));
        }
        TextView textView = (TextView) savingUpdateActivity._$_findCachedViewById(R.id.tv_warning_note);
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_warning_14, 0);
        }
    }

    public static final /* synthetic */ void access$trackingGoalEdited(SavingUpdateActivity savingUpdateActivity, String str, String str2, String str3) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(savingUpdateActivity.getApplicationContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.GOAL_SAVINGS_EDITED;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(TrackerKey.Property.GOAL_CATEGORY, str).MyBillsEntityDataFactory(TrackerKey.Property.GOAL_NAME, str2).MyBillsEntityDataFactory(TrackerKey.Property.GOAL_AMOUNT, str3);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
    }

    public static final /* synthetic */ void access$updateSaving(SavingUpdateActivity savingUpdateActivity) {
        MoneyViewModel targetAmount;
        final SavingUpdatePresenter savingUpdatePresenter = savingUpdateActivity.getSavingUpdatePresenter();
        String str = savingUpdateActivity.getSavingModel().GetContactSyncConfig;
        CategorySelectorView categorySelectorView = (CategorySelectorView) savingUpdateActivity._$_findCachedViewById(R.id.view_category_selector);
        String str2 = null;
        String selectedCategoryCode = categorySelectorView != null ? categorySelectorView.getSelectedCategoryCode() : null;
        if (selectedCategoryCode == null) {
            selectedCategoryCode = "";
        }
        SavingGoalEntryView savingGoalEntryView = (SavingGoalEntryView) savingUpdateActivity._$_findCachedViewById(R.id.res_0x7f0a1b77_r8_lambda_gvlr6n_yiv9b1lq66he21ajmiku);
        String title = savingGoalEntryView != null ? savingGoalEntryView.getTitle() : null;
        if (title == null) {
            title = "";
        }
        SavingGoalEntryView savingGoalEntryView2 = (SavingGoalEntryView) savingUpdateActivity._$_findCachedViewById(R.id.res_0x7f0a1b77_r8_lambda_gvlr6n_yiv9b1lq66he21ajmiku);
        if (savingGoalEntryView2 != null && (targetAmount = savingGoalEntryView2.getTargetAmount()) != null) {
            String cleanAll = NumberUtils.getCleanAll(targetAmount.PlaceComponentResult);
            if (cleanAll == null) {
                cleanAll = "0";
            }
            str2 = cleanAll;
        }
        String valueOf = String.valueOf(str2);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(selectedCategoryCode, "");
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(valueOf, "");
        savingUpdatePresenter.PlaceComponentResult.showProgress();
        savingUpdatePresenter.BuiltInFictitiousFunctionClassFactory.execute(new UpdateSaving.Param(str, selectedCategoryCode, title, valueOf), new Function1<SavingGoalView, Unit>() { // from class: id.dana.savings.presenter.SavingUpdatePresenter$updateSaving$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SavingGoalView savingGoalView) {
                invoke2(savingGoalView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SavingGoalView savingGoalView) {
                SavingUpdateContract.View view;
                SavingUpdateContract.View view2;
                Intrinsics.checkNotNullParameter(savingGoalView, "");
                view = SavingUpdatePresenter.this.PlaceComponentResult;
                view.dismissProgress();
                view2 = SavingUpdatePresenter.this.PlaceComponentResult;
                view2.getAuthRequestContext(SavingModelMapperKt.BuiltInFictitiousFunctionClassFactory(savingGoalView));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.savings.presenter.SavingUpdatePresenter$updateSaving$2
            private static int $10 = 0;
            private static int $11 = 1;
            private static int $BuiltInFictitiousFunctionClassFactory = 1;
            private static int $KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            private static long getAuthRequestContext = 515275521657308772L;

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                int i = $BuiltInFictitiousFunctionClassFactory + 21;
                $KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                invoke2(th);
                Unit unit = Unit.INSTANCE;
                int i3 = $KClassImpl$Data$declaredNonStaticMembers$2 + 87;
                $BuiltInFictitiousFunctionClassFactory = i3 % 128;
                if (i3 % 2 != 0) {
                    return unit;
                }
                int i4 = 88 / 0;
                return unit;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                SavingUpdateContract.View view;
                int i = $KClassImpl$Data$declaredNonStaticMembers$2 + 103;
                $BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(th, "");
                view = SavingUpdatePresenter.this.PlaceComponentResult;
                view.dismissProgress();
                SavingUpdatePresenter.KClassImpl$Data$declaredNonStaticMembers$2(SavingUpdatePresenter.this, th);
                Object[] objArr = new Object[1];
                a(ViewConfiguration.getScrollBarSize() >> 8, new char[]{34707, 21710, 34752, 40739, 17274, 27846, 54292, 3595, 43469, 44309}, objArr);
                DanaLog.BuiltInFictitiousFunctionClassFactory(((String) objArr[0]).intern(), "Fail to update saving", th);
                int i3 = $BuiltInFictitiousFunctionClassFactory + 15;
                $KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
            }

            private static void a(int i, char[] cArr, Object[] objArr) {
                D d = new D();
                char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(getAuthRequestContext ^ 3919452569568103912L, cArr, i);
                d.MyBillsEntityDataFactory = 4;
                while (true) {
                    if ((d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length ? 'L' : (char) 0) != 0) {
                        int i2 = $10 + 55;
                        $11 = i2 % 128;
                        int i3 = i2 % 2;
                        try {
                            try {
                                d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                                KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (getAuthRequestContext ^ 3919452569568103912L)));
                                d.MyBillsEntityDataFactory++;
                                int i4 = $10 + 119;
                                $11 = i4 % 128;
                                int i5 = i4 % 2;
                            } catch (Exception e) {
                                throw e;
                            }
                        } catch (Exception e2) {
                            throw e2;
                        }
                    } else {
                        objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
                        return;
                    }
                }
            }
        });
    }

    private static void g(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(isLayoutRequested ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length) {
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (isLayoutRequested ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
        }
        objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
    }
}
