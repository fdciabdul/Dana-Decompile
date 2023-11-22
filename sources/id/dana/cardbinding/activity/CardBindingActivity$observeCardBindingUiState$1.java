package id.dana.cardbinding.activity;

import androidx.view.Lifecycle;
import androidx.view.RepeatOnLifecycleKt;
import id.dana.R;
import id.dana.cardbinding.model.CashierPayParamModel;
import id.dana.cardbinding.tracker.CardBindingTrackerUtil;
import id.dana.cardbinding.view.CardBindingDialogExtKt;
import id.dana.cardbinding.viewmodel.CardBindingUiState;
import id.dana.cashier.helper.CashierInitParamHelper;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.CashierPayChannelModel;
import id.dana.cashier.model.QueryCardPolicyInfoModel;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.danah5.DanaH5;
import id.dana.data.usereducation.repository.source.UserEducationScenarioKt;
import id.dana.databinding.ActivityCardBindingBinding;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.utils.DANAToast;
import id.dana.utils.TextUtil;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.cardbinding.activity.CardBindingActivity$observeCardBindingUiState$1", f = "CardBindingActivity.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class CardBindingActivity$observeCardBindingUiState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CardBindingActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardBindingActivity$observeCardBindingUiState$1(CardBindingActivity cardBindingActivity, Continuation<? super CardBindingActivity$observeCardBindingUiState$1> continuation) {
        super(2, continuation);
        this.this$0 = cardBindingActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CardBindingActivity$observeCardBindingUiState$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CardBindingActivity$observeCardBindingUiState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.cardbinding.activity.CardBindingActivity$observeCardBindingUiState$1$1", f = "CardBindingActivity.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.cardbinding.activity.CardBindingActivity$observeCardBindingUiState$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CardBindingActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CardBindingActivity cardBindingActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = cardBindingActivity;
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
                StateFlow<CardBindingUiState> stateFlow = this.this$0.getCardBindingVm().NetworkUserEntityData$$ExternalSyntheticLambda7;
                final CardBindingActivity cardBindingActivity = this.this$0;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: id.dana.cardbinding.activity.CardBindingActivity.observeCardBindingUiState.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
                    public final Object emit(CardBindingUiState cardBindingUiState, Continuation<? super Unit> continuation) {
                        QueryCardPolicyInfoModel queryCardPolicyInfoModel;
                        String str;
                        boolean z;
                        ActivityCardBindingBinding binding;
                        ActivityCardBindingBinding binding2;
                        if (cardBindingUiState instanceof CardBindingUiState.OnIsFirstTimeOpenCardBinding) {
                            CardBindingUiState.OnIsFirstTimeOpenCardBinding onIsFirstTimeOpenCardBinding = (CardBindingUiState.OnIsFirstTimeOpenCardBinding) cardBindingUiState;
                            if (Intrinsics.areEqual(onIsFirstTimeOpenCardBinding.BuiltInFictitiousFunctionClassFactory, UserEducationScenarioKt.CARD_BINDING_ONBOARDING) && onIsFirstTimeOpenCardBinding.getGetAuthRequestContext()) {
                                CardBindingActivity.access$showOnboarding(CardBindingActivity.this);
                            }
                        } else if (cardBindingUiState instanceof CardBindingUiState.OnSuccessQueryCardPolicy) {
                            CardBindingUiState.OnSuccessQueryCardPolicy onSuccessQueryCardPolicy = (CardBindingUiState.OnSuccessQueryCardPolicy) cardBindingUiState;
                            CardBindingActivity.access$handleQueryCardResult(CardBindingActivity.this, onSuccessQueryCardPolicy.KClassImpl$Data$declaredNonStaticMembers$2, onSuccessQueryCardPolicy.BuiltInFictitiousFunctionClassFactory);
                        } else {
                            if (cardBindingUiState instanceof CardBindingUiState.OnErrorQueryCardPolicy) {
                                binding2 = CardBindingActivity.this.getBinding();
                                InputCardNumberView inputCardNumberView = binding2.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory;
                                String str2 = ((CardBindingUiState.OnErrorQueryCardPolicy) cardBindingUiState).KClassImpl$Data$declaredNonStaticMembers$2;
                                inputCardNumberView.setErrorMessage(TextUtil.lookAheadTest(str2 != null ? str2 : ""));
                            } else if (cardBindingUiState instanceof CardBindingUiState.OnSuccessBindingCardAdd) {
                                CashierInitParamHelper cashierInitParamHelper = CashierInitParamHelper.INSTANCE;
                                CardBindingActivity.this.getCardBindingVm().getAuthRequestContext(CashierInitParamHelper.BuiltInFictitiousFunctionClassFactory(((CardBindingUiState.OnSuccessBindingCardAdd) cardBindingUiState).PlaceComponentResult));
                            } else {
                                if (cardBindingUiState instanceof CardBindingUiState.OnErrorBindingCardAdd ? true : cardBindingUiState instanceof CardBindingUiState.OnErrorGetCashierMain) {
                                    CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
                                    CardBindingTrackerUtil.BuiltInFictitiousFunctionClassFactory = CardBindingTrackerUtil.KClassImpl$Data$declaredNonStaticMembers$2(CardBindingTrackerUtil.MyBillsEntityDataFactory);
                                    CardBindingActivity cardBindingActivity2 = CardBindingActivity.this;
                                    final CardBindingActivity cardBindingActivity3 = CardBindingActivity.this;
                                    CardBindingDialogExtKt.PlaceComponentResult(cardBindingActivity2, new Function0<Unit>() { // from class: id.dana.cardbinding.activity.CardBindingActivity.observeCardBindingUiState.1.1.1.1
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
                                            CardBindingActivity.this.getCardBindingVm().MyBillsEntityDataFactory();
                                        }
                                    });
                                    CardBindingActivity.access$trackAddCardOpenIfNeeded(CardBindingActivity.this);
                                } else if (cardBindingUiState instanceof CardBindingUiState.OnSuccessGetCashierMain) {
                                    CardBindingTrackerUtil cardBindingTrackerUtil2 = CardBindingTrackerUtil.INSTANCE;
                                    CardBindingTrackerUtil.BuiltInFictitiousFunctionClassFactory = CardBindingTrackerUtil.KClassImpl$Data$declaredNonStaticMembers$2(CardBindingTrackerUtil.MyBillsEntityDataFactory);
                                    CardBindingActivity.this.setCashierMainResult(((CardBindingUiState.OnSuccessGetCashierMain) cardBindingUiState).BuiltInFictitiousFunctionClassFactory);
                                    CardBindingActivity.access$trackAddCardOpenIfNeeded(CardBindingActivity.this);
                                } else {
                                    boolean z2 = false;
                                    if (cardBindingUiState instanceof CardBindingUiState.OnSuccessGetSupportedCardsConfig) {
                                        binding = CardBindingActivity.this.getBinding();
                                        binding.getErrorConfigVersion.setupDataFromSplit(((CardBindingUiState.OnSuccessGetSupportedCardsConfig) cardBindingUiState).PlaceComponentResult, false);
                                    } else if (cardBindingUiState instanceof CardBindingUiState.OnSuccessCashierPay) {
                                        CardBindingUiState.OnSuccessCashierPay onSuccessCashierPay = (CardBindingUiState.OnSuccessCashierPay) cardBindingUiState;
                                        AttributeCashierPayModel attributeCashierPayModel = onSuccessCashierPay.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                        if (attributeCashierPayModel != null && attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2()) {
                                            z2 = true;
                                        }
                                        if (z2) {
                                            CardBindingActivity.this.PrepareContext = true;
                                            CardBindingActivity.this.MyBillsEntityDataFactory(onSuccessCashierPay.BuiltInFictitiousFunctionClassFactory);
                                        } else {
                                            String str3 = onSuccessCashierPay.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
                                            String str4 = str3 == null ? "" : str3;
                                            z = CardBindingActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                                            CashierPayParamModel cashierPayParamModel = new CashierPayParamModel(str4, null, null, false, null, null, null, z, 126, null);
                                            CardBindingActivity.this.getCardBindingVm().KClassImpl$Data$declaredNonStaticMembers$2(cashierPayParamModel);
                                            if (cashierPayParamModel == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                return cashierPayParamModel;
                                            }
                                        }
                                    } else {
                                        if (cardBindingUiState instanceof CardBindingUiState.OnSuccessPayQuery) {
                                            CardBindingActivity cardBindingActivity4 = CardBindingActivity.this;
                                            CardBindingUiState.OnSuccessPayQuery onSuccessPayQuery = (CardBindingUiState.OnSuccessPayQuery) cardBindingUiState;
                                            AttributeCashierPayModel attributeCashierPayModel2 = onSuccessPayQuery.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                            cardBindingActivity4.MyBillsEntityDataFactory = attributeCashierPayModel2 != null ? attributeCashierPayModel2.scheduleImpl : null;
                                            AttributeCashierPayModel attributeCashierPayModel3 = onSuccessPayQuery.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                            if (attributeCashierPayModel3 != null && attributeCashierPayModel3.KClassImpl$Data$declaredNonStaticMembers$2()) {
                                                CardBindingActivity.this.PrepareContext = false;
                                                CardBindingActivity.this.MyBillsEntityDataFactory(onSuccessPayQuery.BuiltInFictitiousFunctionClassFactory);
                                            } else {
                                                AttributeCashierPayModel attributeCashierPayModel4 = onSuccessPayQuery.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                                if (!Intrinsics.areEqual(attributeCashierPayModel4 != null ? attributeCashierPayModel4.O : null, "success")) {
                                                    CardBindingDialogExtKt.PlaceComponentResult(r14, r14.getString(R.string.card_binding_save_card_dialog_server_error_title), CardBindingActivity.this.getString(R.string.card_binding_save_card_dialog_desc), R.drawable.ic_save_card_server_failed);
                                                    CashierPayChannelModel access$getFirstPayMethod = CardBindingActivity.access$getFirstPayMethod(CardBindingActivity.this, onSuccessPayQuery.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2);
                                                    if (access$getFirstPayMethod != null) {
                                                        CardBindingActivity cardBindingActivity5 = CardBindingActivity.this;
                                                        String str5 = access$getFirstPayMethod.B;
                                                        CardBindingActivity.PlaceComponentResult$default(cardBindingActivity5, str5 != null ? str5 : "", null, 2, null);
                                                        r3 = Unit.INSTANCE;
                                                    }
                                                    if (r3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                        return r3;
                                                    }
                                                } else {
                                                    CardBindingActivity cardBindingActivity6 = CardBindingActivity.this;
                                                    CardBindingActivity cardBindingActivity7 = cardBindingActivity6;
                                                    str = cardBindingActivity6.MyBillsEntityDataFactory;
                                                    CardBindingDialogExtKt.KClassImpl$Data$declaredNonStaticMembers$2(cardBindingActivity7, str);
                                                    CashierPayChannelModel access$getFirstPayMethod2 = CardBindingActivity.access$getFirstPayMethod(CardBindingActivity.this, onSuccessPayQuery.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2);
                                                    if (access$getFirstPayMethod2 != null) {
                                                        CardBindingActivity cardBindingActivity8 = CardBindingActivity.this;
                                                        String str6 = access$getFirstPayMethod2.B;
                                                        cardBindingActivity8.PlaceComponentResult(str6 != null ? str6 : "");
                                                    }
                                                    CardBindingActivity.this.getCardBindingVm().BuiltInFictitiousFunctionClassFactory();
                                                }
                                            }
                                        } else if (cardBindingUiState instanceof CardBindingUiState.OnErrorCashierPay) {
                                            CardBindingUiState.OnErrorCashierPay onErrorCashierPay = (CardBindingUiState.OnErrorCashierPay) cardBindingUiState;
                                            CardBindingDialogExtKt.BuiltInFictitiousFunctionClassFactory(CardBindingActivity.this, onErrorCashierPay.MyBillsEntityDataFactory, onErrorCashierPay.getAuthRequestContext, 8);
                                            CardBindingActivity cardBindingActivity9 = CardBindingActivity.this;
                                            queryCardPolicyInfoModel = cardBindingActivity9.getSupportButtonTintMode;
                                            r3 = queryCardPolicyInfoModel != null ? queryCardPolicyInfoModel.initRecordTimeStamp : 0;
                                            cardBindingActivity9.PlaceComponentResult(r3 != null ? r3 : "", onErrorCashierPay.getAuthRequestContext);
                                        } else if (!(cardBindingUiState instanceof CardBindingUiState.OnGetOneklikRedirectUrlSuccess)) {
                                            if (cardBindingUiState instanceof CardBindingUiState.OnGetOneklikRedirectUrlError) {
                                                DANAToast dANAToast = DANAToast.PlaceComponentResult;
                                                CardBindingActivity cardBindingActivity10 = CardBindingActivity.this;
                                                CardBindingActivity cardBindingActivity11 = cardBindingActivity10;
                                                String string = cardBindingActivity10.getString(R.string.card_binding_cashier_main_error_description);
                                                Intrinsics.checkNotNullExpressionValue(string, "");
                                                DANAToast.PlaceComponentResult(cardBindingActivity11, string);
                                            } else if (cardBindingUiState instanceof CardBindingUiState.ShowProgress) {
                                                DanaLoadingDialog access$getDanaLoadingDialog = CardBindingActivity.access$getDanaLoadingDialog(CardBindingActivity.this);
                                                if (!access$getDanaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                                                    access$getDanaLoadingDialog.MyBillsEntityDataFactory.show();
                                                    access$getDanaLoadingDialog.getAuthRequestContext.startRefresh();
                                                }
                                            } else if (cardBindingUiState instanceof CardBindingUiState.DismissProgress) {
                                                CardBindingActivity.access$getDanaLoadingDialog(CardBindingActivity.this).PlaceComponentResult();
                                            } else if (cardBindingUiState instanceof CardBindingUiState.OnError) {
                                                DANAToast dANAToast2 = DANAToast.PlaceComponentResult;
                                                CardBindingActivity cardBindingActivity12 = CardBindingActivity.this;
                                                String str7 = ((CardBindingUiState.OnError) cardBindingUiState).BuiltInFictitiousFunctionClassFactory;
                                                if (str7 == null) {
                                                    str7 = CardBindingActivity.this.getString(R.string.card_binding_cashier_main_error_description);
                                                    Intrinsics.checkNotNullExpressionValue(str7, "");
                                                }
                                                DANAToast.PlaceComponentResult(cardBindingActivity12, str7);
                                            }
                                        } else {
                                            DanaH5.startContainerFullUrl(((CardBindingUiState.OnGetOneklikRedirectUrlSuccess) cardBindingUiState).PlaceComponentResult, 
                                            /*  JADX ERROR: Method code generation error
                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01e2: INVOKE 
                                                  (wrap: java.lang.String : 0x01e0: IGET 
                                                  (wrap: id.dana.cardbinding.viewmodel.CardBindingUiState$OnGetOneklikRedirectUrlSuccess : 0x01de: CHECK_CAST (id.dana.cardbinding.viewmodel.CardBindingUiState$OnGetOneklikRedirectUrlSuccess) (r13v0 'cardBindingUiState' id.dana.cardbinding.viewmodel.CardBindingUiState))
                                                 A[WRAPPED] (LINE:17043) id.dana.cardbinding.viewmodel.CardBindingUiState.OnGetOneklikRedirectUrlSuccess.PlaceComponentResult java.lang.String)
                                                  (wrap: id.dana.utils.danah5.DanaH5Listener : 0x0002: CONSTRUCTOR 
                                                  (wrap: id.dana.cardbinding.activity.CardBindingActivity : 0x01dc: IGET 
                                                  (r12v0 'this' id.dana.cardbinding.activity.CardBindingActivity$observeCardBindingUiState$1$1$1<T> A[IMMUTABLE_TYPE, THIS])
                                                 A[WRAPPED] (LINE:270) id.dana.cardbinding.activity.CardBindingActivity.observeCardBindingUiState.1.1.1.BuiltInFictitiousFunctionClassFactory id.dana.cardbinding.activity.CardBindingActivity)
                                                 A[MD:(id.dana.cardbinding.activity.CardBindingActivity):void (m), WRAPPED] (LINE:25729) call: id.dana.cardbinding.activity.CardBindingActivity$openOneklikCardBindingPage$1.<init>(id.dana.cardbinding.activity.CardBindingActivity):void type: CONSTRUCTOR)
                                                 type: STATIC call: id.dana.danah5.DanaH5.startContainerFullUrl(java.lang.String, id.dana.utils.danah5.DanaH5Listener):void A[MD:(java.lang.String, id.dana.utils.danah5.DanaH5Listener):void (m)] (LINE:25727) in method: id.dana.cardbinding.activity.CardBindingActivity.observeCardBindingUiState.1.1.1.BuiltInFictitiousFunctionClassFactory(id.dana.cardbinding.viewmodel.CardBindingUiState, kotlin.coroutines.Continuation<? super kotlin.Unit>):java.lang.Object, file: classes4.dex
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:156)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:133)
                                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:156)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:133)
                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:156)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:133)
                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:156)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:133)
                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:156)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:133)
                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:156)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:133)
                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
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
                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: id.dana.cardbinding.activity.CardBindingActivity$openOneklikCardBindingPage$1, state: NOT_LOADED
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
                                                	... 57 more
                                                */
                                            /*
                                                Method dump skipped, instructions count: 585
                                                To view this dump change 'Code comments level' option to 'DEBUG'
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: id.dana.cardbinding.activity.CardBindingActivity$observeCardBindingUiState$1.AnonymousClass1.C01651.emit(id.dana.cardbinding.viewmodel.CardBindingUiState, kotlin.coroutines.Continuation):java.lang.Object");
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
