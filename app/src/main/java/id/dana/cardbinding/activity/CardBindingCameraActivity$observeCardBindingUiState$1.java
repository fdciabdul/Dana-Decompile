package id.dana.cardbinding.activity;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.view.Lifecycle;
import androidx.view.RepeatOnLifecycleKt;
import id.dana.cardbinding.model.SupportedCardsConfigModel;
import id.dana.cardbinding.viewmodel.CardBindingUiState;
import id.dana.cashier.model.CashierPayChannelModel;
import id.dana.data.usereducation.repository.source.UserEducationScenarioKt;
import id.dana.databinding.ActivityCardBindingCameraBinding;
import java.util.List;
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

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.cardbinding.activity.CardBindingCameraActivity$observeCardBindingUiState$1", f = "CardBindingCameraActivity.kt", i = {}, l = {187}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class CardBindingCameraActivity$observeCardBindingUiState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CardBindingCameraActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardBindingCameraActivity$observeCardBindingUiState$1(CardBindingCameraActivity cardBindingCameraActivity, Continuation<? super CardBindingCameraActivity$observeCardBindingUiState$1> continuation) {
        super(2, continuation);
        this.this$0 = cardBindingCameraActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CardBindingCameraActivity$observeCardBindingUiState$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CardBindingCameraActivity$observeCardBindingUiState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.cardbinding.activity.CardBindingCameraActivity$observeCardBindingUiState$1$1", f = "CardBindingCameraActivity.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.cardbinding.activity.CardBindingCameraActivity$observeCardBindingUiState$1$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CardBindingCameraActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CardBindingCameraActivity cardBindingCameraActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = cardBindingCameraActivity;
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
                this.label = 1;
                if (this.this$0.getCardBindingVm().NetworkUserEntityData$$ExternalSyntheticLambda7.collect(new C01681(this.this$0), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            throw new KotlinNothingValueException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cardbinding/viewmodel/CardBindingUiState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: id.dana.cardbinding.activity.CardBindingCameraActivity$observeCardBindingUiState$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C01681<T> implements FlowCollector {
            final /* synthetic */ CardBindingCameraActivity getAuthRequestContext;

            C01681(CardBindingCameraActivity cardBindingCameraActivity) {
                this.getAuthRequestContext = cardBindingCameraActivity;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
            public final Object emit(CardBindingUiState cardBindingUiState, Continuation<? super Unit> continuation) {
                ActivityCardBindingCameraBinding binding;
                List<CashierPayChannelModel> list;
                CashierPayChannelModel cashierPayChannelModel;
                String str;
                CashierPayChannelModel cashierPayChannelModel2;
                ActivityCardBindingCameraBinding binding2;
                SupportedCardsConfigModel supportedCardsConfigModel;
                ActivityCardBindingCameraBinding binding3;
                ActivityCardBindingCameraBinding binding4;
                boolean z;
                ActivityCardBindingCameraBinding binding5;
                boolean z2 = false;
                if (cardBindingUiState instanceof CardBindingUiState.OnGetCardInfoSuccess) {
                    this.getAuthRequestContext.PlaceComponentResult(((CardBindingUiState.OnGetCardInfoSuccess) cardBindingUiState).KClassImpl$Data$declaredNonStaticMembers$2);
                    this.getAuthRequestContext.scheduleImpl = false;
                    this.getAuthRequestContext.lookAheadTest = false;
                } else {
                    if (cardBindingUiState instanceof CardBindingUiState.OnIsFirstTimeOpenCardBinding) {
                        CardBindingUiState.OnIsFirstTimeOpenCardBinding onIsFirstTimeOpenCardBinding = (CardBindingUiState.OnIsFirstTimeOpenCardBinding) cardBindingUiState;
                        if (Intrinsics.areEqual(onIsFirstTimeOpenCardBinding.BuiltInFictitiousFunctionClassFactory, UserEducationScenarioKt.CARD_BINDING_ONBOARDING)) {
                            if (onIsFirstTimeOpenCardBinding.getGetAuthRequestContext()) {
                                CardBindingCameraActivity.access$navigateToOnboardingActivity(this.getAuthRequestContext);
                                binding5 = this.getAuthRequestContext.getBinding();
                                ConstraintLayout constraintLayout = binding5.readMicros.BuiltInFictitiousFunctionClassFactory;
                                Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                                constraintLayout.setVisibility(0);
                                r14.getBinding().readMicros.MyBillsEntityDataFactory.setOnClickListener(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004b: INVOKE 
                                      (wrap: android.widget.Button : 0x0008: IGET 
                                      (wrap: id.dana.databinding.ViewRotateCardShowCaseBinding : 0x0006: IGET 
                                      (wrap: id.dana.databinding.ActivityCardBindingCameraBinding : 0x0000: INVOKE (r14v85 id.dana.cardbinding.activity.CardBindingCameraActivity) type: VIRTUAL call: id.dana.core.ui.BaseViewBindingActivity.getBinding():androidx.viewbinding.ViewBinding A[MD:():VB extends androidx.viewbinding.ViewBinding (m), WRAPPED] (LINE:21572))
                                     A[WRAPPED] (LINE:21572) id.dana.databinding.ActivityCardBindingCameraBinding.readMicros id.dana.databinding.ViewRotateCardShowCaseBinding)
                                     A[WRAPPED] (LINE:21572) id.dana.databinding.ViewRotateCardShowCaseBinding.MyBillsEntityDataFactory android.widget.Button)
                                      (wrap: android.view.View$OnClickListener : 0x000c: CONSTRUCTOR 
                                      (wrap: id.dana.cardbinding.activity.CardBindingCameraActivity : 0x0049: IGET 
                                      (r13v0 'this' id.dana.cardbinding.activity.CardBindingCameraActivity$observeCardBindingUiState$1$1$1<T> A[IMMUTABLE_TYPE, THIS])
                                     A[WRAPPED] (LINE:202) id.dana.cardbinding.activity.CardBindingCameraActivity.observeCardBindingUiState.1.1.1.getAuthRequestContext id.dana.cardbinding.activity.CardBindingCameraActivity)
                                     A[MD:(id.dana.cardbinding.activity.CardBindingCameraActivity):void (m), WRAPPED] (LINE:202) call: id.dana.cardbinding.activity.CardBindingCameraActivity$$ExternalSyntheticLambda0.<init>(id.dana.cardbinding.activity.CardBindingCameraActivity):void type: CONSTRUCTOR)
                                     type: VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] (LINE:21572) in method: id.dana.cardbinding.activity.CardBindingCameraActivity.observeCardBindingUiState.1.1.1.BuiltInFictitiousFunctionClassFactory(id.dana.cardbinding.viewmodel.CardBindingUiState, kotlin.coroutines.Continuation<? super kotlin.Unit>):java.lang.Object, file: classes8.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
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
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: id.dana.cardbinding.activity.CardBindingCameraActivity$$ExternalSyntheticLambda0, state: NOT_LOADED
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
                                    	... 39 more
                                    */
                                /*
                                    Method dump skipped, instructions count: 773
                                    To view this dump change 'Code comments level' option to 'DEBUG'
                                */
                                throw new UnsupportedOperationException("Method not decompiled: id.dana.cardbinding.activity.CardBindingCameraActivity$observeCardBindingUiState$1.AnonymousClass1.C01681.emit(id.dana.cardbinding.viewmodel.CardBindingUiState, kotlin.coroutines.Continuation):java.lang.Object");
                            }

                            public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CardBindingCameraActivity cardBindingCameraActivity) {
                                Intrinsics.checkNotNullParameter(cardBindingCameraActivity, "");
                                cardBindingCameraActivity.scheduleImpl = false;
                            }
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
