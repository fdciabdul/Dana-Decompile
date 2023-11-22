package id.dana.transferaccount.transferaccountstatus;

import id.dana.domain.transferaccount.TransferAccountStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* synthetic */ class TransferAccountPresenter$getTransferAccountStatus$1 extends FunctionReferenceImpl implements Function1<TransferAccountStatus, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TransferAccountPresenter$getTransferAccountStatus$1(Object obj) {
        super(1, obj, TransferAccountPresenter.class, "onGetTransferAccountStatusSuccess", "onGetTransferAccountStatusSuccess(Lid/dana/domain/transferaccount/TransferAccountStatus;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(TransferAccountStatus transferAccountStatus) {
        invoke2(transferAccountStatus);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(TransferAccountStatus transferAccountStatus) {
        Intrinsics.checkNotNullParameter(transferAccountStatus, "");
        TransferAccountPresenter.getAuthRequestContext((TransferAccountPresenter) this.receiver, transferAccountStatus);
    }
}
