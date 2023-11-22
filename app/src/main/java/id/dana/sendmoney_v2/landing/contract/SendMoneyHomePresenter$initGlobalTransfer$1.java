package id.dana.sendmoney_v2.landing.contract;

import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.network.exception.NetworkException;
import id.dana.sendmoney.domain.globalsend.interactor.InitGlobalTransferVerifyUser;
import id.dana.sendmoney.domain.globalsend.model.init.GlobalTransferInitResult;
import id.dana.sendmoney_v2.landing.contract.KycAndDebitPayOptionContract;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter$initGlobalTransfer$1", f = "SendMoneyHomePresenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class SendMoneyHomePresenter$initGlobalTransfer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $param;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SendMoneyHomePresenter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendMoneyHomePresenter$initGlobalTransfer$1(SendMoneyHomePresenter sendMoneyHomePresenter, Object obj, Continuation<? super SendMoneyHomePresenter$initGlobalTransfer$1> continuation) {
        super(2, continuation);
        this.this$0 = sendMoneyHomePresenter;
        this.$param = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SendMoneyHomePresenter$initGlobalTransfer$1 sendMoneyHomePresenter$initGlobalTransfer$1 = new SendMoneyHomePresenter$initGlobalTransfer$1(this.this$0, this.$param, continuation);
        sendMoneyHomePresenter$initGlobalTransfer$1.L$0 = obj;
        return sendMoneyHomePresenter$initGlobalTransfer$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SendMoneyHomePresenter$initGlobalTransfer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InitGlobalTransferVerifyUser initGlobalTransferVerifyUser;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            initGlobalTransferVerifyUser = this.this$0.lookAheadTest;
            NoParams noParams = NoParams.INSTANCE;
            final SendMoneyHomePresenter sendMoneyHomePresenter = this.this$0;
            final Object obj2 = this.$param;
            Function1<GlobalTransferInitResult, Unit> function1 = new Function1<GlobalTransferInitResult, Unit>() { // from class: id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter$initGlobalTransfer$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(GlobalTransferInitResult globalTransferInitResult) {
                    invoke2(globalTransferInitResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(GlobalTransferInitResult globalTransferInitResult) {
                    Intrinsics.checkNotNullParameter(globalTransferInitResult, "");
                    BaseUseCase.execute$default(r2.NetworkUserEntityData$$ExternalSyntheticLambda2, NoParams.INSTANCE, 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: INVOKE 
                          (wrap: id.dana.domain.sendmoney.interactor.SaveIsUserCertifiedGlobalSend : 0x0000: IGET (r2v1 id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter) A[WRAPPED] (LINE:1215) id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter.NetworkUserEntityData$$ExternalSyntheticLambda2 id.dana.domain.sendmoney.interactor.SaveIsUserCertifiedGlobalSend)
                          (wrap: id.dana.domain.core.usecase.NoParams : 0x0005: SGET  A[WRAPPED] (LINE:1216) id.dana.domain.core.usecase.NoParams.INSTANCE id.dana.domain.core.usecase.NoParams)
                          (wrap: kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> : 0x0009: CONSTRUCTOR 
                          (wrap: id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter : 0x0005: IGET 
                          (r1v0 'this' id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter$initGlobalTransfer$1$1 A[IMMUTABLE_TYPE, THIS])
                         A[WRAPPED] (LINE:188) id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter$initGlobalTransfer$1.1.this$0 id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter)
                          (wrap: java.lang.Object : 0x0007: IGET 
                          (r1v0 'this' id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter$initGlobalTransfer$1$1 A[IMMUTABLE_TYPE, THIS])
                         A[WRAPPED] id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter$initGlobalTransfer$1.1.$$param java.lang.Object)
                         A[MD:(id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter, java.lang.Object):void (m), WRAPPED] (LINE:1215) call: id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter$saveIsUserCertifiedGlobalSend$1.<init>(id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter, java.lang.Object):void type: CONSTRUCTOR)
                          (null kotlin.jvm.functions.Function1)
                          (4 int)
                          (null java.lang.Object)
                         type: STATIC call: id.dana.domain.core.usecase.BaseUseCase.execute$default(id.dana.domain.core.usecase.BaseUseCase, java.lang.Object, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, int, java.lang.Object):void A[MD:(id.dana.domain.core.usecase.BaseUseCase, java.lang.Object, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, int, java.lang.Object):void (m)] (LINE:1215) in method: id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter$initGlobalTransfer$1.1.invoke(id.dana.sendmoney.domain.globalsend.model.init.GlobalTransferInitResult):void, file: classes5.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter$saveIsUserCertifiedGlobalSend$1, state: NOT_LOADED
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
                        id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter r2 = id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter.this
                        java.lang.Object r0 = r2
                        id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter.KClassImpl$Data$declaredNonStaticMembers$2(r2, r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter$initGlobalTransfer$1.AnonymousClass1.invoke2(id.dana.sendmoney.domain.globalsend.model.init.GlobalTransferInitResult):void");
                }
            };
            final SendMoneyHomePresenter sendMoneyHomePresenter2 = this.this$0;
            BaseFlowUseCase.execute$default(initGlobalTransferVerifyUser, noParams, null, function1, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter$initGlobalTransfer$1.2
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
                    KycAndDebitPayOptionContract.View view;
                    Intrinsics.checkNotNullParameter(th, "");
                    if ((th instanceof NetworkException) && Intrinsics.areEqual(((NetworkException) th).getErrorCode(), "DE13112088999120")) {
                        view = SendMoneyHomePresenter.this.GetContactSyncConfig;
                        view.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                }
            }, null, coroutineScope, 18, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
