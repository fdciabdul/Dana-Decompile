package id.dana.sendmoney.ui.core.presenter;

import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.sendmoney.domain.core.interactor.GetSendMoneyApiMigrationConfig;
import id.dana.sendmoney.domain.core.model.config.SendMoneyApiMigrationConfig;
import id.dana.sendmoney.ui.core.mapper.SendMoneyApiMigrationModelMapperKt;
import id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract;
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

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.ui.core.presenter.SendMoneyCorePresenter$getSendMoneyApiMigrationConfig$1", f = "SendMoneyCorePresenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class SendMoneyCorePresenter$getSendMoneyApiMigrationConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SendMoneyCorePresenter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendMoneyCorePresenter$getSendMoneyApiMigrationConfig$1(SendMoneyCorePresenter sendMoneyCorePresenter, Continuation<? super SendMoneyCorePresenter$getSendMoneyApiMigrationConfig$1> continuation) {
        super(2, continuation);
        this.this$0 = sendMoneyCorePresenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SendMoneyCorePresenter$getSendMoneyApiMigrationConfig$1 sendMoneyCorePresenter$getSendMoneyApiMigrationConfig$1 = new SendMoneyCorePresenter$getSendMoneyApiMigrationConfig$1(this.this$0, continuation);
        sendMoneyCorePresenter$getSendMoneyApiMigrationConfig$1.L$0 = obj;
        return sendMoneyCorePresenter$getSendMoneyApiMigrationConfig$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SendMoneyCorePresenter$getSendMoneyApiMigrationConfig$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GetSendMoneyApiMigrationConfig getSendMoneyApiMigrationConfig;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            getSendMoneyApiMigrationConfig = this.this$0.KClassImpl$Data$declaredNonStaticMembers$2;
            NoParams noParams = NoParams.INSTANCE;
            final SendMoneyCorePresenter sendMoneyCorePresenter = this.this$0;
            Function1<SendMoneyApiMigrationConfig, Unit> function1 = new Function1<SendMoneyApiMigrationConfig, Unit>() { // from class: id.dana.sendmoney.ui.core.presenter.SendMoneyCorePresenter$getSendMoneyApiMigrationConfig$1.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(SendMoneyApiMigrationConfig sendMoneyApiMigrationConfig) {
                    invoke2(sendMoneyApiMigrationConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(SendMoneyApiMigrationConfig sendMoneyApiMigrationConfig) {
                    SendMoneyCoreContract.View view;
                    Intrinsics.checkNotNullParameter(sendMoneyApiMigrationConfig, "");
                    view = SendMoneyCorePresenter.this.getAuthRequestContext;
                    view.BuiltInFictitiousFunctionClassFactory(SendMoneyApiMigrationModelMapperKt.PlaceComponentResult(sendMoneyApiMigrationConfig));
                }
            };
            final SendMoneyCorePresenter sendMoneyCorePresenter2 = this.this$0;
            BaseFlowUseCase.execute$default(getSendMoneyApiMigrationConfig, noParams, null, function1, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.core.presenter.SendMoneyCorePresenter$getSendMoneyApiMigrationConfig$1.2
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
                    SendMoneyCoreContract.View view;
                    Intrinsics.checkNotNullParameter(th, "");
                    view = SendMoneyCorePresenter.this.getAuthRequestContext;
                    view.getAuthRequestContext();
                }
            }, null, coroutineScope, 18, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
