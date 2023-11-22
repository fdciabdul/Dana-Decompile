package id.dana.sendmoney.ui.core.presenter;

import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.core.ui.model.UiTextModel;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.sendmoney.domain.core.interactor.GetTransferBalanceInit;
import id.dana.sendmoney.domain.core.model.init.TransferInitResult;
import id.dana.sendmoney.ui.core.mapper.TransferInitModelMapperKt;
import id.dana.sendmoney.ui.core.model.TransferInitResultModel;
import id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract;
import id.dana.sendmoney.util.SendMoneyErrorHelper;
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
@DebugMetadata(c = "id.dana.sendmoney.ui.core.presenter.SendMoneyCorePresenter$getTransferBalanceInit$1", f = "SendMoneyCorePresenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class SendMoneyCorePresenter$getTransferBalanceInit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $loginId;
    final /* synthetic */ String $source;
    final /* synthetic */ String $userId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SendMoneyCorePresenter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendMoneyCorePresenter$getTransferBalanceInit$1(SendMoneyCorePresenter sendMoneyCorePresenter, String str, String str2, String str3, Continuation<? super SendMoneyCorePresenter$getTransferBalanceInit$1> continuation) {
        super(2, continuation);
        this.this$0 = sendMoneyCorePresenter;
        this.$loginId = str;
        this.$userId = str2;
        this.$source = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SendMoneyCorePresenter$getTransferBalanceInit$1 sendMoneyCorePresenter$getTransferBalanceInit$1 = new SendMoneyCorePresenter$getTransferBalanceInit$1(this.this$0, this.$loginId, this.$userId, this.$source, continuation);
        sendMoneyCorePresenter$getTransferBalanceInit$1.L$0 = obj;
        return sendMoneyCorePresenter$getTransferBalanceInit$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SendMoneyCorePresenter$getTransferBalanceInit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GetTransferBalanceInit getTransferBalanceInit;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            getTransferBalanceInit = this.this$0.PlaceComponentResult;
            GetTransferBalanceInit.Param param = new GetTransferBalanceInit.Param(this.$loginId, this.$userId);
            final SendMoneyCorePresenter sendMoneyCorePresenter = this.this$0;
            Function1<TransferInitResult, Unit> function1 = new Function1<TransferInitResult, Unit>() { // from class: id.dana.sendmoney.ui.core.presenter.SendMoneyCorePresenter$getTransferBalanceInit$1.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(TransferInitResult transferInitResult) {
                    invoke2(transferInitResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(TransferInitResult transferInitResult) {
                    SendMoneyCoreContract.View view;
                    SendMoneyCoreContract.View view2;
                    Intrinsics.checkNotNullParameter(transferInitResult, "");
                    TransferInitResultModel MyBillsEntityDataFactory = TransferInitModelMapperKt.MyBillsEntityDataFactory(transferInitResult);
                    view = SendMoneyCorePresenter.this.getAuthRequestContext;
                    view.PlaceComponentResult();
                    view2 = SendMoneyCorePresenter.this.getAuthRequestContext;
                    view2.PlaceComponentResult(MyBillsEntityDataFactory);
                }
            };
            final SendMoneyCorePresenter sendMoneyCorePresenter2 = this.this$0;
            final String str = this.$source;
            BaseFlowUseCase.execute$default(getTransferBalanceInit, param, null, function1, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.core.presenter.SendMoneyCorePresenter$getTransferBalanceInit$1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    SendMoneyCoreContract.View view2;
                    SendMoneyCoreContract.View view3;
                    Intrinsics.checkNotNullParameter(th, "");
                    view = SendMoneyCorePresenter.this.getAuthRequestContext;
                    view.PlaceComponentResult();
                    view2 = SendMoneyCorePresenter.this.getAuthRequestContext;
                    view2.MyBillsEntityDataFactory(th);
                    view3 = SendMoneyCorePresenter.this.getAuthRequestContext;
                    SendMoneyErrorHelper sendMoneyErrorHelper = SendMoneyErrorHelper.INSTANCE;
                    view3.MyBillsEntityDataFactory(th, TrackerDataKey.NetworkErrorOperationTypeProperty.TRANSFER_BALANCE_INIT, UiTextModel.asString$default(SendMoneyErrorHelper.BuiltInFictitiousFunctionClassFactory(th).BuiltInFictitiousFunctionClassFactory, null, 1, null), str);
                }
            }, null, coroutineScope, 18, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
