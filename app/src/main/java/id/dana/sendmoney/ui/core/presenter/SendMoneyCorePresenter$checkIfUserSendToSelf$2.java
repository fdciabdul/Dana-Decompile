package id.dana.sendmoney.ui.core.presenter;

import android.text.TextUtils;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetUserId;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.ui.core.presenter.SendMoneyCorePresenter$checkIfUserSendToSelf$2", f = "SendMoneyCorePresenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class SendMoneyCorePresenter$checkIfUserSendToSelf$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $recipientUserId;
    int label;
    final /* synthetic */ SendMoneyCorePresenter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendMoneyCorePresenter$checkIfUserSendToSelf$2(SendMoneyCorePresenter sendMoneyCorePresenter, String str, Continuation<? super SendMoneyCorePresenter$checkIfUserSendToSelf$2> continuation) {
        super(2, continuation);
        this.this$0 = sendMoneyCorePresenter;
        this.$recipientUserId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SendMoneyCorePresenter$checkIfUserSendToSelf$2(this.this$0, this.$recipientUserId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SendMoneyCorePresenter$checkIfUserSendToSelf$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GetUserId getUserId;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            getUserId = this.this$0.MyBillsEntityDataFactory;
            final String str = this.$recipientUserId;
            final SendMoneyCorePresenter sendMoneyCorePresenter = this.this$0;
            getUserId.execute(new DefaultObserver<String>() { // from class: id.dana.sendmoney.ui.core.presenter.SendMoneyCorePresenter$checkIfUserSendToSelf$2.1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final /* synthetic */ void onNext(Object obj2) {
                    String str2 = (String) obj2;
                    Intrinsics.checkNotNullParameter(str2, "");
                    if (TextUtils.isEmpty(str2) || !Intrinsics.areEqual(str2, str)) {
                        return;
                    }
                    SendMoneyCorePresenter.NetworkUserEntityData$$ExternalSyntheticLambda0(sendMoneyCorePresenter);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
