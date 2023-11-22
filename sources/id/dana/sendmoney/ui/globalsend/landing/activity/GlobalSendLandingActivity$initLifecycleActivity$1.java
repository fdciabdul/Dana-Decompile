package id.dana.sendmoney.ui.globalsend.landing.activity;

import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.view.Lifecycle;
import androidx.view.RepeatOnLifecycleKt;
import id.dana.core.ui.util.DANAToast;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ActivityGlobalSendLandingBinding;
import id.dana.sendmoney.ui.globalsend.form.GlobalSendFormActivity;
import id.dana.sendmoney.ui.globalsend.form.model.BeneficiaryInfoModel;
import id.dana.sendmoney.ui.globalsend.form.model.TransferValidateResultModel;
import id.dana.sendmoney.ui.globalsend.landing.adapter.GlobalSendBeneficiaryAdapter;
import id.dana.sendmoney.ui.globalsend.landing.model.QueryBeneficiaryResultModel;
import id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingUiState;
import id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$initLifecycleActivity$1", f = "GlobalSendLandingActivity.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class GlobalSendLandingActivity$initLifecycleActivity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GlobalSendLandingActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSendLandingActivity$initLifecycleActivity$1(GlobalSendLandingActivity globalSendLandingActivity, Continuation<? super GlobalSendLandingActivity$initLifecycleActivity$1> continuation) {
        super(2, continuation);
        this.this$0 = globalSendLandingActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlobalSendLandingActivity$initLifecycleActivity$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GlobalSendLandingActivity$initLifecycleActivity$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$initLifecycleActivity$1$1", f = "GlobalSendLandingActivity.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$initLifecycleActivity$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GlobalSendLandingActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GlobalSendLandingActivity globalSendLandingActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = globalSendLandingActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<GlobalSendLandingUiState> stateFlow = GlobalSendLandingActivity.access$getVm(this.this$0).scheduleImpl;
                final GlobalSendLandingActivity globalSendLandingActivity = this.this$0;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity.initLifecycleActivity.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
                    public final Object emit(GlobalSendLandingUiState globalSendLandingUiState, Continuation<? super Unit> continuation) {
                        String str;
                        GlobalSendBeneficiaryAdapter globalSendBeneficiaryAdapter;
                        QueryBeneficiaryResultModel queryBeneficiaryResultModel;
                        ActivityGlobalSendLandingBinding binding;
                        ActivityGlobalSendLandingBinding binding2;
                        ActivityGlobalSendLandingBinding binding3;
                        BeneficiaryInfoModel beneficiaryInfoModel;
                        int i2;
                        QueryBeneficiaryResultModel queryBeneficiaryResultModel2;
                        if (!(globalSendLandingUiState instanceof GlobalSendLandingUiState.None)) {
                            if (globalSendLandingUiState instanceof GlobalSendLandingUiState.ShimmerLoading) {
                                GlobalSendLandingActivity.access$toggleLoadingShimmerState(GlobalSendLandingActivity.this, ((GlobalSendLandingUiState.ShimmerLoading) globalSendLandingUiState).getGetAuthRequestContext());
                            } else if (globalSendLandingUiState instanceof GlobalSendLandingUiState.DanaLoading) {
                                GlobalSendLandingActivity.access$toggleDanaLoadingDialogState(GlobalSendLandingActivity.this, ((GlobalSendLandingUiState.DanaLoading) globalSendLandingUiState).getGetAuthRequestContext());
                            } else if (globalSendLandingUiState instanceof GlobalSendLandingUiState.OnSuccessGetBeneficiaryList) {
                                GlobalSendLandingActivity.this.GetContactSyncConfig = ((GlobalSendLandingUiState.OnSuccessGetBeneficiaryList) globalSendLandingUiState).MyBillsEntityDataFactory;
                                GlobalSendLandingActivity globalSendLandingActivity2 = GlobalSendLandingActivity.this;
                                queryBeneficiaryResultModel2 = globalSendLandingActivity2.GetContactSyncConfig;
                                GlobalSendLandingActivity.access$handleActivityStateAfterQueryBeneficiary(globalSendLandingActivity2, queryBeneficiaryResultModel2);
                            } else if (globalSendLandingUiState instanceof GlobalSendLandingUiState.OnErrorGetBeneficiary) {
                                GlobalSendLandingActivity.access$setErrorTextGetBeneficiary(GlobalSendLandingActivity.this);
                                GlobalSendLandingActivity.access$setErrorState(GlobalSendLandingActivity.this, true);
                            } else if (globalSendLandingUiState instanceof GlobalSendLandingUiState.OnSuccessGetMaxBeneficiaryPageSize) {
                                GlobalSendLandingActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = ((GlobalSendLandingUiState.OnSuccessGetMaxBeneficiaryPageSize) globalSendLandingUiState).KClassImpl$Data$declaredNonStaticMembers$2;
                                GlobalSendLandingViewModel access$getVm = GlobalSendLandingActivity.access$getVm(GlobalSendLandingActivity.this);
                                i2 = GlobalSendLandingActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                                access$getVm.PlaceComponentResult(i2);
                            } else {
                                BeneficiaryInfoModel beneficiaryInfoModel2 = null;
                                if (!(globalSendLandingUiState instanceof GlobalSendLandingUiState.OnSuccessValidateRecurringTransaction)) {
                                    if (globalSendLandingUiState instanceof GlobalSendLandingUiState.OnErrorCode) {
                                        GlobalSendLandingUiState.OnErrorCode onErrorCode = (GlobalSendLandingUiState.OnErrorCode) globalSendLandingUiState;
                                        GlobalSendLandingActivity.access$handleOnErrorWithCode(GlobalSendLandingActivity.this, onErrorCode.PlaceComponentResult, onErrorCode.BuiltInFictitiousFunctionClassFactory);
                                    } else if (globalSendLandingUiState instanceof GlobalSendLandingUiState.OnSuccessDeleteBeneficiary) {
                                        globalSendBeneficiaryAdapter = GlobalSendLandingActivity.this.getErrorConfigVersion;
                                        if (globalSendBeneficiaryAdapter == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("");
                                            globalSendBeneficiaryAdapter = null;
                                        }
                                        GlobalSendLandingActivity globalSendLandingActivity3 = GlobalSendLandingActivity.this;
                                        Iterator<T> it = globalSendBeneficiaryAdapter.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            T next = it.next();
                                            if (Intrinsics.areEqual(((BeneficiaryInfoModel) next).MyBillsEntityDataFactory, ((GlobalSendLandingUiState.OnSuccessDeleteBeneficiary) globalSendLandingUiState).KClassImpl$Data$declaredNonStaticMembers$2)) {
                                                beneficiaryInfoModel2 = next;
                                                break;
                                            }
                                        }
                                        BeneficiaryInfoModel beneficiaryInfoModel3 = beneficiaryInfoModel2;
                                        if (beneficiaryInfoModel3 != null) {
                                            int indexOf = globalSendBeneficiaryAdapter.KClassImpl$Data$declaredNonStaticMembers$2.indexOf(beneficiaryInfoModel3);
                                            binding3 = globalSendLandingActivity3.getBinding();
                                            View childAt = binding3.PlaceComponentResult.initRecordTimeStamp.getChildAt(indexOf);
                                            Intrinsics.checkNotNullExpressionValue(childAt, "");
                                            Intrinsics.checkNotNullParameter(childAt, "");
                                            Animation loadAnimation = AnimationUtils.loadAnimation(childAt.getContext(), R.anim.BuiltInFictitiousFunctionClassFactory_res_0x7f01005c);
                                            loadAnimation.setDuration(700L);
                                            childAt.startAnimation(loadAnimation);
                                            globalSendBeneficiaryAdapter.KClassImpl$Data$declaredNonStaticMembers$2.remove(indexOf);
                                            globalSendBeneficiaryAdapter.notifyItemRemoved(indexOf);
                                        }
                                        GlobalSendLandingActivity.access$removeItemFromBeneficiaryResult(globalSendLandingActivity3, ((GlobalSendLandingUiState.OnSuccessDeleteBeneficiary) globalSendLandingUiState).KClassImpl$Data$declaredNonStaticMembers$2);
                                        if (globalSendBeneficiaryAdapter.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
                                            queryBeneficiaryResultModel = globalSendLandingActivity3.GetContactSyncConfig;
                                            if (queryBeneficiaryResultModel.BuiltInFictitiousFunctionClassFactory.isEmpty()) {
                                                binding = globalSendLandingActivity3.getBinding();
                                                ConstraintLayout constraintLayout = binding.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
                                                Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                                                constraintLayout.setVisibility(0);
                                                binding2 = globalSendLandingActivity3.getBinding();
                                                ConstraintLayout constraintLayout2 = binding2.PlaceComponentResult.lookAheadTest;
                                                Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
                                                constraintLayout2.setVisibility(8);
                                                globalSendLandingActivity3.getBinding().BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setOnClickListener(new GlobalSendLandingActivity$$ExternalSyntheticLambda6(globalSendLandingActivity3));
                                            } else {
                                                globalSendLandingActivity3.PlaceComponentResult();
                                            }
                                        }
                                        DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
                                        GlobalSendLandingActivity globalSendLandingActivity4 = GlobalSendLandingActivity.this;
                                        GlobalSendLandingActivity globalSendLandingActivity5 = globalSendLandingActivity4;
                                        String string = globalSendLandingActivity4.getString(R.string.text_success_delete);
                                        Intrinsics.checkNotNullExpressionValue(string, "");
                                        DANAToast.PlaceComponentResult(globalSendLandingActivity5, string, "");
                                    } else if (globalSendLandingUiState instanceof GlobalSendLandingUiState.OnErrorDeleteBeneficiary) {
                                        DANAToast dANAToast2 = DANAToast.BuiltInFictitiousFunctionClassFactory;
                                        GlobalSendLandingActivity globalSendLandingActivity6 = GlobalSendLandingActivity.this;
                                        GlobalSendLandingActivity globalSendLandingActivity7 = globalSendLandingActivity6;
                                        String string2 = globalSendLandingActivity6.getString(R.string.text_failed_delete);
                                        Intrinsics.checkNotNullExpressionValue(string2, "");
                                        DANAToast.MyBillsEntityDataFactory(globalSendLandingActivity7, string2, "");
                                    } else if (globalSendLandingUiState instanceof GlobalSendLandingUiState.OnSuccessGetSort) {
                                        GlobalSendLandingActivity.this.DatabaseTableConfigUtil = ((GlobalSendLandingUiState.OnSuccessGetSort) globalSendLandingUiState).BuiltInFictitiousFunctionClassFactory;
                                        GlobalSendLandingActivity globalSendLandingActivity8 = GlobalSendLandingActivity.this;
                                        str = globalSendLandingActivity8.DatabaseTableConfigUtil;
                                        globalSendLandingActivity8.BuiltInFictitiousFunctionClassFactory(str);
                                    } else if (globalSendLandingUiState instanceof GlobalSendLandingUiState.Error) {
                                        DANAToast dANAToast3 = DANAToast.BuiltInFictitiousFunctionClassFactory;
                                        DANAToast.MyBillsEntityDataFactory(GlobalSendLandingActivity.this, String.valueOf(((GlobalSendLandingUiState.Error) globalSendLandingUiState).getAuthRequestContext), "");
                                    }
                                } else {
                                    TransferValidateResultModel transferValidateResultModel = ((GlobalSendLandingUiState.OnSuccessValidateRecurringTransaction) globalSendLandingUiState).BuiltInFictitiousFunctionClassFactory;
                                    GlobalSendLandingActivity globalSendLandingActivity9 = GlobalSendLandingActivity.this;
                                    GlobalSendFormActivity.Companion companion = GlobalSendFormActivity.INSTANCE;
                                    GlobalSendLandingActivity globalSendLandingActivity10 = globalSendLandingActivity9;
                                    beneficiaryInfoModel = globalSendLandingActivity9.PlaceComponentResult;
                                    if (beneficiaryInfoModel == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("");
                                    } else {
                                        beneficiaryInfoModel2 = beneficiaryInfoModel;
                                    }
                                    String str2 = transferValidateResultModel.getAuthRequestContext;
                                    Intrinsics.checkNotNullParameter(globalSendLandingActivity10, "");
                                    Intrinsics.checkNotNullParameter(beneficiaryInfoModel2, "");
                                    Intrinsics.checkNotNullParameter(str2, "");
                                    Intrinsics.checkNotNullParameter("Landing Page", "");
                                    Intent intent = new Intent(globalSendLandingActivity10, GlobalSendFormActivity.class);
                                    intent.putExtra(GlobalSendFormActivity.IS_NEW_RECIPIENT, false);
                                    intent.putExtra("BENEFICIARY_INFO_MODEL", beneficiaryInfoModel2);
                                    intent.putExtra("CARD_NUMBER", str2);
                                    intent.putExtra(GlobalSendFormActivity.PAGE_SOURCE, "Landing Page");
                                    globalSendLandingActivity10.startActivity(intent);
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (RepeatOnLifecycleKt.KClassImpl$Data$declaredNonStaticMembers$2(this.this$0, Lifecycle.State.STARTED, new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
