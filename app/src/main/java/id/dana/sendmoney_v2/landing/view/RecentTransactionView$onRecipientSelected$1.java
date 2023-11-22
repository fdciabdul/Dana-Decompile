package id.dana.sendmoney_v2.landing.view;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.sendmoney.model.RecipientModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/model/RecipientModel;", "it", "", BridgeDSL.INVOKE, "(Lid/dana/sendmoney/model/RecipientModel;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final class RecentTransactionView$onRecipientSelected$1 extends Lambda implements Function1<RecipientModel, Unit> {
    public static final RecentTransactionView$onRecipientSelected$1 INSTANCE = new RecentTransactionView$onRecipientSelected$1();

    RecentTransactionView$onRecipientSelected$1() {
        super(1);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(RecipientModel recipientModel) {
        Intrinsics.checkNotNullParameter(recipientModel, "");
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(RecipientModel recipientModel) {
        invoke2(recipientModel);
        return Unit.INSTANCE;
    }
}
