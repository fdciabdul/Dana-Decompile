package id.dana.sendmoney.ui.globalsend.form.fragment;

import androidx.fragment.app.FragmentActivity;
import androidx.view.Lifecycle;
import androidx.view.RepeatOnLifecycleKt;
import androidx.view.ViewModelKt;
import id.dana.core.ui.util.DANAToast;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.sendmoney.domain.globalsend.model.province.Province;
import id.dana.sendmoney.ui.globalsend.form.mapper.ProvinceModelMapperKt;
import id.dana.sendmoney.ui.globalsend.form.model.BeneficiaryInfoModel;
import id.dana.sendmoney.ui.globalsend.form.model.GlobalTransferInitModel;
import id.dana.sendmoney.ui.globalsend.form.model.SubTransferMethodInfoModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CountryModel;
import id.dana.sendmoney.ui.globalsend.form.viewmodel.ReceiverFormUiState;
import id.dana.sendmoney.ui.globalsend.form.viewmodel.ReceiverFormViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$initLifecycleFragment$1", f = "ReceiverFormFragment.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class ReceiverFormFragment$initLifecycleFragment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ReceiverFormFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReceiverFormFragment$initLifecycleFragment$1(ReceiverFormFragment receiverFormFragment, Continuation<? super ReceiverFormFragment$initLifecycleFragment$1> continuation) {
        super(2, continuation);
        this.this$0 = receiverFormFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReceiverFormFragment$initLifecycleFragment$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ReceiverFormFragment$initLifecycleFragment$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$initLifecycleFragment$1$1", f = "ReceiverFormFragment.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$initLifecycleFragment$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ReceiverFormFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ReceiverFormFragment receiverFormFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = receiverFormFragment;
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
                StateFlow<ReceiverFormUiState> stateFlow = ReceiverFormFragment.scheduleImpl(this.this$0).getAuthRequestContext;
                final ReceiverFormFragment receiverFormFragment = this.this$0;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment.initLifecycleFragment.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
                    public final Object emit(ReceiverFormUiState receiverFormUiState, Continuation<? super Unit> continuation) {
                        GlobalTransferInitModel globalTransferInitModel;
                        CountryModel countryModel;
                        GlobalTransferInitModel globalTransferInitModel2;
                        if (receiverFormUiState instanceof ReceiverFormUiState.OnValidationIsFormNotFilled) {
                            ReceiverFormFragment.this.getErrorConfigVersion = ((ReceiverFormUiState.OnValidationIsFormNotFilled) receiverFormUiState).getBuiltInFictitiousFunctionClassFactory();
                        } else if (receiverFormUiState instanceof ReceiverFormUiState.DanaLoading) {
                            ReceiverFormFragment.getAuthRequestContext(ReceiverFormFragment.this, ((ReceiverFormUiState.DanaLoading) receiverFormUiState).getGetAuthRequestContext());
                        } else {
                            GlobalTransferInitModel globalTransferInitModel3 = null;
                            GlobalTransferInitModel globalTransferInitModel4 = null;
                            CountryModel countryModel2 = null;
                            if (!(receiverFormUiState instanceof ReceiverFormUiState.OnSuccessValidate)) {
                                if (receiverFormUiState instanceof ReceiverFormUiState.OnErrorCodeInit) {
                                    ReceiverFormUiState.OnErrorCodeInit onErrorCodeInit = (ReceiverFormUiState.OnErrorCodeInit) receiverFormUiState;
                                    ReceiverFormFragment.getAuthRequestContext(ReceiverFormFragment.this, onErrorCodeInit.getAuthRequestContext, onErrorCodeInit.KClassImpl$Data$declaredNonStaticMembers$2, false);
                                } else {
                                    boolean z = true;
                                    if (receiverFormUiState instanceof ReceiverFormUiState.OnErrorCodeValidate) {
                                        ReceiverFormUiState.OnErrorCodeValidate onErrorCodeValidate = (ReceiverFormUiState.OnErrorCodeValidate) receiverFormUiState;
                                        ReceiverFormFragment.getAuthRequestContext(ReceiverFormFragment.this, onErrorCodeValidate.MyBillsEntityDataFactory, onErrorCodeValidate.getAuthRequestContext, true);
                                    } else if (receiverFormUiState instanceof ReceiverFormUiState.Error) {
                                        DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
                                        FragmentActivity requireActivity = ReceiverFormFragment.this.requireActivity();
                                        Intrinsics.checkNotNullExpressionValue(requireActivity, "");
                                        DANAToast.MyBillsEntityDataFactory(requireActivity, String.valueOf(((ReceiverFormUiState.Error) receiverFormUiState).PlaceComponentResult), "");
                                    } else if (receiverFormUiState instanceof ReceiverFormUiState.OnErrorFetchInit) {
                                        ReceiverFormFragment.KClassImpl$Data$declaredNonStaticMembers$2(ReceiverFormFragment.this, true);
                                    } else if (receiverFormUiState instanceof ReceiverFormUiState.ShimmerLoading) {
                                        if (((ReceiverFormUiState.ShimmerLoading) receiverFormUiState).getBuiltInFictitiousFunctionClassFactory()) {
                                            ReceiverFormFragment.GetContactSyncConfig(ReceiverFormFragment.this);
                                        } else {
                                            ReceiverFormFragment.getErrorConfigVersion(ReceiverFormFragment.this);
                                        }
                                    } else if (receiverFormUiState instanceof ReceiverFormUiState.OnSuccessInitGlobalTransfer) {
                                        ReceiverFormUiState.OnSuccessInitGlobalTransfer onSuccessInitGlobalTransfer = (ReceiverFormUiState.OnSuccessInitGlobalTransfer) receiverFormUiState;
                                        if (!onSuccessInitGlobalTransfer.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.isEmpty()) {
                                            List<SubTransferMethodInfoModel> list = onSuccessInitGlobalTransfer.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0;
                                            if (!(list instanceof Collection) || !list.isEmpty()) {
                                                Iterator<T> it = list.iterator();
                                                while (it.hasNext()) {
                                                    if (((SubTransferMethodInfoModel) it.next()).getBuiltInFictitiousFunctionClassFactory()) {
                                                        break;
                                                    }
                                                }
                                            }
                                            z = false;
                                            if (!z) {
                                                ReceiverFormFragment.KClassImpl$Data$declaredNonStaticMembers$2(ReceiverFormFragment.this, false);
                                                ReceiverFormFragment.this.PlaceComponentResult = onSuccessInitGlobalTransfer.KClassImpl$Data$declaredNonStaticMembers$2;
                                                final ReceiverFormViewModel scheduleImpl = ReceiverFormFragment.scheduleImpl(ReceiverFormFragment.this);
                                                countryModel = ReceiverFormFragment.this.MyBillsEntityDataFactory;
                                                if (countryModel == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                                } else {
                                                    countryModel2 = countryModel;
                                                }
                                                String str = countryModel2.BuiltInFictitiousFunctionClassFactory;
                                                Intrinsics.checkNotNullParameter(str, "");
                                                BaseFlowUseCase.execute$default(scheduleImpl.PlaceComponentResult, str, null, new Function1<List<? extends Province>, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.ReceiverFormViewModel$getProvinceAndCityList$1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final /* bridge */ /* synthetic */ Unit invoke(List<? extends Province> list2) {
                                                        invoke2((List<Province>) list2);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                    public final void invoke2(List<Province> list2) {
                                                        MutableStateFlow mutableStateFlow;
                                                        Object value;
                                                        ArrayList arrayList;
                                                        Intrinsics.checkNotNullParameter(list2, "");
                                                        mutableStateFlow = ReceiverFormViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                                                        do {
                                                            value = mutableStateFlow.getValue();
                                                            ReceiverFormUiState receiverFormUiState2 = (ReceiverFormUiState) value;
                                                            List<Province> list3 = list2;
                                                            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                                                            Iterator<T> it2 = list3.iterator();
                                                            while (it2.hasNext()) {
                                                                arrayList.add(ProvinceModelMapperKt.getAuthRequestContext((Province) it2.next()));
                                                            }
                                                        } while (!mutableStateFlow.compareAndSet(value, new ReceiverFormUiState.OnSuccessGetProvinceAndCityList(arrayList)));
                                                    }
                                                }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.ReceiverFormViewModel$getProvinceAndCityList$2
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
                                                        mutableStateFlow = ReceiverFormViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                                                        do {
                                                            value = mutableStateFlow.getValue();
                                                            ReceiverFormUiState receiverFormUiState2 = (ReceiverFormUiState) value;
                                                        } while (!mutableStateFlow.compareAndSet(value, new ReceiverFormUiState.OnErrorFetchInit(th.getMessage())));
                                                    }
                                                }, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.ReceiverFormViewModel$getProvinceAndCityList$3
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
                                                        mutableStateFlow = ReceiverFormViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                                                        do {
                                                            value = mutableStateFlow.getValue();
                                                            ReceiverFormUiState receiverFormUiState2 = (ReceiverFormUiState) value;
                                                        } while (!mutableStateFlow.compareAndSet(value, new ReceiverFormUiState.ShimmerLoading(false)));
                                                    }
                                                }, ViewModelKt.PlaceComponentResult(scheduleImpl), 2, null);
                                            }
                                        }
                                        ReceiverFormFragment.this.PlaceComponentResult(false);
                                    } else if (receiverFormUiState instanceof ReceiverFormUiState.OnSuccessGetProvinceAndCityList) {
                                        ReceiverFormFragment receiverFormFragment2 = ReceiverFormFragment.this;
                                        globalTransferInitModel = receiverFormFragment2.PlaceComponentResult;
                                        if (globalTransferInitModel == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("");
                                        } else {
                                            globalTransferInitModel3 = globalTransferInitModel;
                                        }
                                        ReceiverFormFragment.KClassImpl$Data$declaredNonStaticMembers$2(receiverFormFragment2, globalTransferInitModel3.NetworkUserEntityData$$ExternalSyntheticLambda0, ((ReceiverFormUiState.OnSuccessGetProvinceAndCityList) receiverFormUiState).BuiltInFictitiousFunctionClassFactory);
                                    } else if (receiverFormUiState instanceof ReceiverFormUiState.OnFormValid) {
                                        if (((ReceiverFormUiState.OnFormValid) receiverFormUiState).getMyBillsEntityDataFactory()) {
                                            ReceiverFormFragment.MyBillsEntityDataFactory(ReceiverFormFragment.this);
                                        } else {
                                            ReceiverFormFragment.KClassImpl$Data$declaredNonStaticMembers$2(ReceiverFormFragment.this);
                                        }
                                    }
                                }
                            } else {
                                Function3<BeneficiaryInfoModel, String, GlobalTransferInitModel, Unit> function3 = ReceiverFormFragment.this.scheduleImpl;
                                ReceiverFormUiState.OnSuccessValidate onSuccessValidate = (ReceiverFormUiState.OnSuccessValidate) receiverFormUiState;
                                BeneficiaryInfoModel beneficiaryInfoModel = onSuccessValidate.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
                                String str2 = onSuccessValidate.KClassImpl$Data$declaredNonStaticMembers$2;
                                globalTransferInitModel2 = ReceiverFormFragment.this.PlaceComponentResult;
                                if (globalTransferInitModel2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                } else {
                                    globalTransferInitModel4 = globalTransferInitModel2;
                                }
                                Unit invoke = function3.invoke(beneficiaryInfoModel, str2, globalTransferInitModel4);
                                if (invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                    return invoke;
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
