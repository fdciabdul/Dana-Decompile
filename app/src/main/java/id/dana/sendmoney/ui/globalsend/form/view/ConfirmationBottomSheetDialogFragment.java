package id.dana.sendmoney.ui.globalsend.form.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelKt;
import androidx.view.ViewModelProvider;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.user.UserInfoResponse;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.BottomSheetGlobalSendConfirmationBinding;
import id.dana.sendmoney.di.component.GlobalSendComponent;
import id.dana.sendmoney.di.provider.GlobalSendComponentProvider;
import id.dana.sendmoney.domain.globalsend.interactor.SaveSenderDetail;
import id.dana.sendmoney.ui.globalsend.form.mapper.SenderDetailModelMapperKt;
import id.dana.sendmoney.ui.globalsend.form.model.SenderDetailModel;
import id.dana.sendmoney.ui.globalsend.form.view.EditTextFormView;
import id.dana.sendmoney.ui.globalsend.form.viewmodel.ConfirmationBottomSheetDialogUiState;
import id.dana.sendmoney.ui.globalsend.form.viewmodel.ConfirmationBottomSheetDialogViewModel;
import id.dana.sendmoney.util.FormValidationUtil;
import id.dana.sendmoney.util.GlobalSendTrackerHelper;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001f\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0005R\u0016\u0010\n\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0012\u0010\u0012\u001a\u00020\u0011X\u0087\"¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\f\u001a\u00020\u00148\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0016\u0010\r\u001a\u00020\u00168\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0012\u0010\u001a\u001a\u00020\u0019X\u0087\"¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0017\u001a\u00020\u001cX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/view/ConfirmationBottomSheetDialogFragment;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/sendmoney/databinding/BottomSheetGlobalSendConfirmationBinding;", "", "moveToNextValue", "()V", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "getAuthRequestContext", "MyBillsEntityDataFactory", "onStart", "Lid/dana/sendmoney/di/component/GlobalSendComponent;", "Lid/dana/sendmoney/di/component/GlobalSendComponent;", "Lid/dana/sendmoney/util/GlobalSendTrackerHelper;", "globalSendTrackerHelper", "Lid/dana/sendmoney/util/GlobalSendTrackerHelper;", "Lid/dana/sendmoney/ui/globalsend/form/view/ConfirmationBottomSheetDialogFragment$OnSuccessSaveSenderDetailListener;", "Lid/dana/sendmoney/ui/globalsend/form/view/ConfirmationBottomSheetDialogFragment$OnSuccessSaveSenderDetailListener;", "Lid/dana/sendmoney/ui/globalsend/form/model/SenderDetailModel;", "PlaceComponentResult", "Lid/dana/sendmoney/ui/globalsend/form/model/SenderDetailModel;", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogViewModel;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lkotlin/Lazy;", "<init>", "OnSuccessSaveSenderDetailListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ConfirmationBottomSheetDialogFragment extends BaseViewBindingBottomSheetDialogFragment<BottomSheetGlobalSendConfirmationBinding> {
    private GlobalSendComponent KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private OnSuccessSaveSenderDetailListener getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult = LazyKt.lazy(new Function0<ConfirmationBottomSheetDialogViewModel>() { // from class: id.dana.sendmoney.ui.globalsend.form.view.ConfirmationBottomSheetDialogFragment$vm$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ConfirmationBottomSheetDialogViewModel invoke() {
            ConfirmationBottomSheetDialogFragment confirmationBottomSheetDialogFragment = ConfirmationBottomSheetDialogFragment.this;
            ConfirmationBottomSheetDialogFragment confirmationBottomSheetDialogFragment2 = confirmationBottomSheetDialogFragment;
            ViewModelFactory viewModelFactory = confirmationBottomSheetDialogFragment.viewModelFactory;
            if (viewModelFactory == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                viewModelFactory = null;
            }
            return (ConfirmationBottomSheetDialogViewModel) new ViewModelProvider(confirmationBottomSheetDialogFragment2, viewModelFactory).MyBillsEntityDataFactory(ConfirmationBottomSheetDialogViewModel.class);
        }
    });

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private SenderDetailModel MyBillsEntityDataFactory;
    @Inject
    public GlobalSendTrackerHelper globalSendTrackerHelper;
    @Inject
    public ViewModelFactory viewModelFactory;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/view/ConfirmationBottomSheetDialogFragment$OnSuccessSaveSenderDetailListener;", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface OnSuccessSaveSenderDetailListener {
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.4f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ BottomSheetGlobalSendConfirmationBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        BottomSheetGlobalSendConfirmationBinding PlaceComponentResult = BottomSheetGlobalSendConfirmationBinding.PlaceComponentResult(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
        Dialog dialog = getDialog();
        if (dialog != null) {
            BottomSheetBehavior<View> o_ = o_();
            if (o_ != null) {
                o_.setDraggable(false);
            }
            setCancelable(false);
            a_(PlaceComponentResult(dialog));
        }
        final ConfirmationBottomSheetDialogViewModel confirmationBottomSheetDialogViewModel = (ConfirmationBottomSheetDialogViewModel) this.PlaceComponentResult.getValue();
        confirmationBottomSheetDialogViewModel.PlaceComponentResult.execute(NoParams.INSTANCE, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.ConfirmationBottomSheetDialogViewModel$getUserInfo$1
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
                mutableStateFlow = ConfirmationBottomSheetDialogViewModel.this.BuiltInFictitiousFunctionClassFactory;
                do {
                    value = mutableStateFlow.getValue();
                    ConfirmationBottomSheetDialogUiState confirmationBottomSheetDialogUiState = (ConfirmationBottomSheetDialogUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new ConfirmationBottomSheetDialogUiState.ShimmerLoading(true)));
            }
        }, new Function1<UserInfoResponse, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.ConfirmationBottomSheetDialogViewModel$getUserInfo$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserInfoResponse userInfoResponse) {
                invoke2(userInfoResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserInfoResponse userInfoResponse) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(userInfoResponse, "");
                mutableStateFlow = ConfirmationBottomSheetDialogViewModel.this.BuiltInFictitiousFunctionClassFactory;
                do {
                    value = mutableStateFlow.getValue();
                    ConfirmationBottomSheetDialogUiState confirmationBottomSheetDialogUiState = (ConfirmationBottomSheetDialogUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new ConfirmationBottomSheetDialogUiState.OnSuccessGetUserInfo(new SenderDetailModel(String.valueOf(userInfoResponse.getKtpName()), String.valueOf(userInfoResponse.getKtpId()), "", ""))));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.ConfirmationBottomSheetDialogViewModel$getUserInfo$3
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
                mutableStateFlow = ConfirmationBottomSheetDialogViewModel.this.BuiltInFictitiousFunctionClassFactory;
                do {
                    value = mutableStateFlow.getValue();
                    ConfirmationBottomSheetDialogUiState confirmationBottomSheetDialogUiState = (ConfirmationBottomSheetDialogUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new ConfirmationBottomSheetDialogUiState.OnErrorGetUserInfo(0, 1, null)));
            }
        }, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.ConfirmationBottomSheetDialogViewModel$getUserInfo$4
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
                mutableStateFlow = ConfirmationBottomSheetDialogViewModel.this.BuiltInFictitiousFunctionClassFactory;
                do {
                    value = mutableStateFlow.getValue();
                    ConfirmationBottomSheetDialogUiState confirmationBottomSheetDialogUiState = (ConfirmationBottomSheetDialogUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new ConfirmationBottomSheetDialogUiState.ShimmerLoading(false)));
            }
        }, ViewModelKt.PlaceComponentResult(confirmationBottomSheetDialogViewModel));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            View view = getView();
            if (view != null) {
                view.post(new BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2(view, this));
            }
            MyBillsEntityDataFactory(dialog);
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        Context applicationContext = requireActivity().getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney.di.provider.GlobalSendComponentProvider");
        }
        GlobalSendComponent authRequestContext = ((GlobalSendComponentProvider) applicationContext).provideGlobalSendComponent().getAuthRequestContext();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext;
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this);
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((BottomSheetGlobalSendConfirmationBinding) vb).PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.form.view.ConfirmationBottomSheetDialogFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConfirmationBottomSheetDialogFragment.getAuthRequestContext(ConfirmationBottomSheetDialogFragment.this);
                }
            });
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                ((BottomSheetGlobalSendConfirmationBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.form.view.ConfirmationBottomSheetDialogFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ConfirmationBottomSheetDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2(ConfirmationBottomSheetDialogFragment.this);
                    }
                });
                VB vb3 = this.MyBillsEntityDataFactory;
                if (vb3 != 0) {
                    EditTextFormView editTextFormView = ((BottomSheetGlobalSendConfirmationBinding) vb3).getAuthRequestContext;
                    editTextFormView.setEditTextAccessibilityId(R.string.txt_email);
                    editTextFormView.setFormValidityListener(new EditTextFormView.FormValidityListener() { // from class: id.dana.sendmoney.ui.globalsend.form.view.ConfirmationBottomSheetDialogFragment$initViews$3$1
                        @Override // id.dana.sendmoney.ui.globalsend.form.view.EditTextFormView.FormValidityListener
                        public final void BuiltInFictitiousFunctionClassFactory() {
                            ConfirmationBottomSheetDialogFragment.this.moveToNextValue();
                        }
                    });
                    editTextFormView.setValidationRuleList(MapsKt.mapOf(TuplesKt.to(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.view.ConfirmationBottomSheetDialogFragment$initViews$3$2
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(String str) {
                            Intrinsics.checkNotNullParameter(str, "");
                            FormValidationUtil formValidationUtil = FormValidationUtil.INSTANCE;
                            return Boolean.valueOf(FormValidationUtil.KClassImpl$Data$declaredNonStaticMembers$2((CharSequence) str));
                        }
                    }, Integer.valueOf(R.string.error_message_form_email))));
                    moveToNextValue();
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(this), null, null, new ConfirmationBottomSheetDialogFragment$initLifecycleFragment$1(this, null), 3, null);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void getAuthRequestContext(ConfirmationBottomSheetDialogFragment confirmationBottomSheetDialogFragment) {
        Intrinsics.checkNotNullParameter(confirmationBottomSheetDialogFragment, "");
        SenderDetailModel senderDetailModel = confirmationBottomSheetDialogFragment.MyBillsEntityDataFactory;
        GlobalSendTrackerHelper globalSendTrackerHelper = null;
        if (senderDetailModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            senderDetailModel = null;
        }
        senderDetailModel.PlaceComponentResult = true;
        final ConfirmationBottomSheetDialogViewModel confirmationBottomSheetDialogViewModel = (ConfirmationBottomSheetDialogViewModel) confirmationBottomSheetDialogFragment.PlaceComponentResult.getValue();
        SenderDetailModel senderDetailModel2 = confirmationBottomSheetDialogFragment.MyBillsEntityDataFactory;
        if (senderDetailModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            senderDetailModel2 = null;
        }
        Intrinsics.checkNotNullParameter(senderDetailModel2, "");
        BaseFlowUseCase.execute$default(confirmationBottomSheetDialogViewModel.getAuthRequestContext, new SaveSenderDetail.Param(SenderDetailModelMapperKt.BuiltInFictitiousFunctionClassFactory(senderDetailModel2)), null, new Function1<Unit, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.ConfirmationBottomSheetDialogViewModel$saveSenderDetail$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(unit, "");
                mutableStateFlow = ConfirmationBottomSheetDialogViewModel.this.BuiltInFictitiousFunctionClassFactory;
                do {
                    value = mutableStateFlow.getValue();
                    ConfirmationBottomSheetDialogUiState confirmationBottomSheetDialogUiState = (ConfirmationBottomSheetDialogUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, ConfirmationBottomSheetDialogUiState.OnSuccessSaveSenderDetail.INSTANCE));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.ConfirmationBottomSheetDialogViewModel$saveSenderDetail$2
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
                mutableStateFlow = ConfirmationBottomSheetDialogViewModel.this.BuiltInFictitiousFunctionClassFactory;
                do {
                    value = mutableStateFlow.getValue();
                    ConfirmationBottomSheetDialogUiState confirmationBottomSheetDialogUiState = (ConfirmationBottomSheetDialogUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new ConfirmationBottomSheetDialogUiState.Error(0, 1, null)));
            }
        }, null, ViewModelKt.PlaceComponentResult(confirmationBottomSheetDialogViewModel), 18, null);
        GlobalSendTrackerHelper globalSendTrackerHelper2 = confirmationBottomSheetDialogFragment.globalSendTrackerHelper;
        if (globalSendTrackerHelper2 != null) {
            globalSendTrackerHelper = globalSendTrackerHelper2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        globalSendTrackerHelper.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ConfirmationBottomSheetDialogFragment confirmationBottomSheetDialogFragment) {
        Intrinsics.checkNotNullParameter(confirmationBottomSheetDialogFragment, "");
        confirmationBottomSheetDialogFragment.dismissAllowingStateLoss();
    }

    public static final /* synthetic */ ConfirmationBottomSheetDialogViewModel getErrorConfigVersion(ConfirmationBottomSheetDialogFragment confirmationBottomSheetDialogFragment) {
        return (ConfirmationBottomSheetDialogViewModel) confirmationBottomSheetDialogFragment.PlaceComponentResult.getValue();
    }

    public final void moveToNextValue() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            if (((BottomSheetGlobalSendConfirmationBinding) vb).getAuthRequestContext.getPlaceComponentResult()) {
                VB vb2 = this.MyBillsEntityDataFactory;
                if (vb2 != 0) {
                    DanaButtonPrimaryView danaButtonPrimaryView = ((BottomSheetGlobalSendConfirmationBinding) vb2).PlaceComponentResult;
                    danaButtonPrimaryView.setActiveButton(getString(R.string.res_0x7f13039b_bottomsheetcardbindingview_watchercardnumberview_1), null);
                    danaButtonPrimaryView.setEnabled(true);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            VB vb3 = this.MyBillsEntityDataFactory;
            if (vb3 != 0) {
                DanaButtonPrimaryView danaButtonPrimaryView2 = ((BottomSheetGlobalSendConfirmationBinding) vb3).PlaceComponentResult;
                danaButtonPrimaryView2.setDisabled(getString(R.string.res_0x7f13039b_bottomsheetcardbindingview_watchercardnumberview_1));
                danaButtonPrimaryView2.setEnabled(false);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((BottomSheetGlobalSendConfirmationBinding) vb).BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
