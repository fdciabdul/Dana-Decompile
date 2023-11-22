package id.dana.savings.withdrawal;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContract;
import id.dana.base.BaseActivity;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.component.customsnackbarcomponent.CustomSnackbar;
import id.dana.core.ui.model.UiTextModel;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerWithdrawSavingComponent;
import id.dana.di.modules.WithdrawSavingModule;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.saving.model.SavingWithdrawInitRequest;
import id.dana.domain.saving.model.SavingWithdrawInitResult;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.savings.WithdrawSavingPresenter;
import id.dana.savings.contract.WithdrawSavingContract;
import id.dana.savings.model.SavingModel;
import id.dana.savings.parser.SavingErrorParser;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.TagFormat;
import id.dana.utils.UrlUtil;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0007¢\u0006\u0004\b.\u0010\u000eJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0012\u0010\u000eJ\u000f\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0018\u001a\u00020\u0017X\u0087\"¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001c\u001a\u00020\u000fX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001e\u001a\u00020\u001dX\u0087\"¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0012\u0010\u0004\u001a\u00020 X\u0087\"¢\u0006\u0006\n\u0004\b!\u0010\"R\u0017\u0010&\u001a\u0006*\u00020#0#X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b$\u0010%R\u0012\u0010*\u001a\u00020'X\u0087\"¢\u0006\u0006\n\u0004\b(\u0010)R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020+X\u0007¢\u0006\u0006\n\u0004\b,\u0010-"}, d2 = {"Lid/dana/savings/withdrawal/WithdrawalSavingBottomSheetDialog;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "p0", "PlaceComponentResult", "(Ljava/lang/String;)Ljava/lang/String;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "onShow", "onStart", "Lid/dana/component/customsnackbarcomponent/CustomSnackbar;", "scheduleImpl", "Lid/dana/component/customsnackbarcomponent/CustomSnackbar;", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "moveToNextValue", "Z", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/savings/WithdrawSavingPresenter;", "presenter", "Lid/dana/savings/WithdrawSavingPresenter;", "Lid/dana/savings/model/SavingModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/savings/model/SavingModel;", "Lid/dana/dialog/TwoButtonWithImageDialog;", "initRecordTimeStamp", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "Lid/dana/savings/withdrawal/WithdrawalSavingBottomSheetDialog$WithdrawListener;", "lookAheadTest", "Lid/dana/savings/withdrawal/WithdrawalSavingBottomSheetDialog$WithdrawListener;", "getAuthRequestContext", "", "getErrorConfigVersion", "Ljava/util/List;", "<init>", "Companion", "WithdrawListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WithdrawalSavingBottomSheetDialog extends BaseBottomSheetDialogFragment {

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public SavingModel PlaceComponentResult;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public WithdrawListener getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public boolean BuiltInFictitiousFunctionClassFactory;
    @Inject
    public WithdrawSavingPresenter presenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private CustomSnackbar KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    final List<String> moveToNextValue = new ArrayList();

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new WithdrawalSavingBottomSheetDialog$userKycDialog$2(this));

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/savings/withdrawal/WithdrawalSavingBottomSheetDialog$WithdrawListener;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface WithdrawListener {
        void BuiltInFictitiousFunctionClassFactory(String p0);
    }

    public final View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.48f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.view_coordinator_withdrawal_destination;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        initMatchParentDialog(getDialog());
        initTransparentDialogDim(getDialog());
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        DaggerWithdrawSavingComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerWithdrawSavingComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getBaseActivity().getApplicationComponent());
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (WithdrawSavingModule) Preconditions.getAuthRequestContext(new WithdrawSavingModule(new WithdrawalSavingBottomSheetDialog$initComponent$1(this)));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, WithdrawSavingModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerWithdrawSavingComponent.WithdrawSavingComponentImpl(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, (byte) 0).MyBillsEntityDataFactory(this);
        BaseActivity baseActivity = getBaseActivity();
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[1];
        WithdrawSavingPresenter withdrawSavingPresenter = this.presenter;
        final WithdrawSavingPresenter withdrawSavingPresenter2 = null;
        if (withdrawSavingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            withdrawSavingPresenter = null;
        }
        abstractPresenterArr[0] = withdrawSavingPresenter;
        baseActivity.registerPresenter(abstractPresenterArr);
        final WithdrawSavingPresenter withdrawSavingPresenter3 = this.presenter;
        if (withdrawSavingPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            withdrawSavingPresenter3 = null;
        }
        withdrawSavingPresenter3.getAuthRequestContext.execute(new DefaultObserver<UserInfoResponse>() { // from class: id.dana.savings.WithdrawSavingPresenter$getKycStatus$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                WithdrawSavingContract.View view;
                UserInfoResponse userInfoResponse = (UserInfoResponse) obj;
                Intrinsics.checkNotNullParameter(userInfoResponse, "");
                view = WithdrawSavingPresenter.this.MyBillsEntityDataFactory;
                view.KClassImpl$Data$declaredNonStaticMembers$2(userInfoResponse.isKycCertified());
            }
        }, GetUserInfoWithKyc.Params.forParams(true));
        WithdrawSavingPresenter withdrawSavingPresenter4 = this.presenter;
        if (withdrawSavingPresenter4 != null) {
            withdrawSavingPresenter2 = withdrawSavingPresenter4;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        withdrawSavingPresenter2.KClassImpl$Data$declaredNonStaticMembers$2.execute(NoParams.INSTANCE, new Function1<List<? extends String>, Unit>() { // from class: id.dana.savings.WithdrawSavingPresenter$getSavingWithdrawOption$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> list) {
                WithdrawSavingContract.View view;
                Intrinsics.checkNotNullParameter(list, "");
                view = WithdrawSavingPresenter.this.MyBillsEntityDataFactory;
                view.getAuthRequestContext(list);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.savings.WithdrawSavingPresenter$getSavingWithdrawOption$2
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
                WithdrawSavingContract.View view;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                view = WithdrawSavingPresenter.this.MyBillsEntityDataFactory;
                SavingErrorParser savingErrorParser = SavingErrorParser.INSTANCE;
                context = WithdrawSavingPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.onError(SavingErrorParser.PlaceComponentResult(context, th.getLocalizedMessage()));
            }
        });
        initBottomSheet(getScreenHeight(getDialog()), 3);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        super.init();
        ConstraintLayout constraintLayout = (ConstraintLayout) getAuthRequestContext(R.id.cl_first_option);
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.withdrawal.WithdrawalSavingBottomSheetDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WithdrawalSavingBottomSheetDialog.getAuthRequestContext(WithdrawalSavingBottomSheetDialog.this);
                }
            });
        }
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) getAuthRequestContext(R.id.f);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.withdrawal.WithdrawalSavingBottomSheetDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WithdrawalSavingBottomSheetDialog.PlaceComponentResult(WithdrawalSavingBottomSheetDialog.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String PlaceComponentResult(String p0) {
        TagFormat PlaceComponentResult = TagFormat.MyBillsEntityDataFactory(DanaUrl.SAVING_WITHDRAW_URL).PlaceComponentResult("withdrawType", p0);
        SavingModel savingModel = this.PlaceComponentResult;
        if (savingModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            savingModel = null;
        }
        String MyBillsEntityDataFactory = PlaceComponentResult.PlaceComponentResult("savingId", savingModel.GetContactSyncConfig).PlaceComponentResult("share", String.valueOf(this.BuiltInFictitiousFunctionClassFactory)).MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        Iterator<T> it = this.moveToNextValue.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual((String) it.next(), "withdraw_bank")) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void getAuthRequestContext(WithdrawalSavingBottomSheetDialog withdrawalSavingBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(withdrawalSavingBottomSheetDialog, "");
        final WithdrawSavingPresenter withdrawSavingPresenter = withdrawalSavingBottomSheetDialog.presenter;
        SavingModel savingModel = null;
        if (withdrawSavingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            withdrawSavingPresenter = null;
        }
        SavingModel savingModel2 = withdrawalSavingBottomSheetDialog.PlaceComponentResult;
        if (savingModel2 != null) {
            savingModel = savingModel2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        String str = savingModel.GetContactSyncConfig;
        final String str2 = "BALANCE";
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter("BALANCE", "");
        withdrawSavingPresenter.PlaceComponentResult.execute(new SavingWithdrawInitRequest(str, "BALANCE"), new Function1<SavingWithdrawInitResult, Unit>() { // from class: id.dana.savings.WithdrawSavingPresenter$initSavingWithdraw$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SavingWithdrawInitResult savingWithdrawInitResult) {
                invoke2(savingWithdrawInitResult);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Object[]] */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SavingWithdrawInitResult savingWithdrawInitResult) {
                WithdrawSavingContract.View view;
                Intrinsics.checkNotNullParameter(savingWithdrawInitResult, "");
                if (WithdrawSavingPresenter.BuiltInFictitiousFunctionClassFactory(savingWithdrawInitResult, str2).getSuccess()) {
                    view = WithdrawSavingPresenter.this.MyBillsEntityDataFactory;
                    view.MyBillsEntityDataFactory();
                    return;
                }
                ?? r2 = 0;
                WithdrawSavingPresenter.getAuthRequestContext(WithdrawSavingPresenter.this, new UiTextModel.StringResource(R.string.saving_unable_to_withdraw_error_message, r2, 2, r2));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.savings.WithdrawSavingPresenter$initSavingWithdraw$2
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
                Intrinsics.checkNotNullParameter(th, "");
                WithdrawSavingPresenter.BuiltInFictitiousFunctionClassFactory(WithdrawSavingPresenter.this, WithdrawSavingPresenter.KClassImpl$Data$declaredNonStaticMembers$2(th), th);
            }
        });
    }

    public static /* synthetic */ void PlaceComponentResult(WithdrawalSavingBottomSheetDialog withdrawalSavingBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(withdrawalSavingBottomSheetDialog, "");
        withdrawalSavingBottomSheetDialog.dismiss();
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(WithdrawalSavingBottomSheetDialog withdrawalSavingBottomSheetDialog) {
        SavingModel savingModel = withdrawalSavingBottomSheetDialog.PlaceComponentResult;
        if (savingModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            savingModel = null;
        }
        boolean authRequestContext = savingModel.DatabaseTableConfigUtil.getAuthRequestContext(new MoneyViewModel("10000", "Rp", null, 4, null));
        SavingWithdrawalDestinationView savingWithdrawalDestinationView = (SavingWithdrawalDestinationView) withdrawalSavingBottomSheetDialog.getAuthRequestContext(R.id.view_saving_withdrawal);
        if (!withdrawalSavingBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2()) {
            savingWithdrawalDestinationView.enableBankAccountWithdrawal(false, false);
        } else {
            savingWithdrawalDestinationView.enableBankAccountWithdrawal(authRequestContext, true);
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(WithdrawalSavingBottomSheetDialog withdrawalSavingBottomSheetDialog, boolean z) {
        if (z) {
            WithdrawListener withdrawListener = withdrawalSavingBottomSheetDialog.getAuthRequestContext;
            if (withdrawListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                withdrawListener = null;
            }
            String authRequestContext = UrlUtil.getAuthRequestContext(withdrawalSavingBottomSheetDialog.PlaceComponentResult("bank"));
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            withdrawListener.BuiltInFictitiousFunctionClassFactory(authRequestContext);
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(withdrawalSavingBottomSheetDialog.getContext());
            builder.MyBillsEntityDataFactory = TrackerKey.Event.GOAL_SAVINGS_WITHDRAW_CREATION;
            builder.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
            return;
        }
        TwoButtonWithImageDialog twoButtonWithImageDialog = (TwoButtonWithImageDialog) withdrawalSavingBottomSheetDialog.MyBillsEntityDataFactory.getValue();
        if (twoButtonWithImageDialog != null) {
            twoButtonWithImageDialog.MyBillsEntityDataFactory();
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(WithdrawalSavingBottomSheetDialog withdrawalSavingBottomSheetDialog) {
        DynamicUrlWrapper dynamicUrlWrapper = withdrawalSavingBottomSheetDialog.dynamicUrlWrapper;
        if (dynamicUrlWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            dynamicUrlWrapper = null;
        }
        String authRequestContext = UrlUtil.getAuthRequestContext(dynamicUrlWrapper.getKycFromGoalSavingUrl());
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        DanaH5.startContainerFullUrl(authRequestContext);
    }

    public static final /* synthetic */ void getErrorConfigVersion(WithdrawalSavingBottomSheetDialog withdrawalSavingBottomSheetDialog) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(withdrawalSavingBottomSheetDialog.getContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.GOAL_SAVINGS_WITHDRAW_CREATION;
        builder.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) getAuthRequestContext(R.id.cl_withdrawal);
        return coordinatorLayout != null ? (FrameLayout) coordinatorLayout.findViewById(R.id.bs_withdrawal_destination) : null;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
