package id.dana.statement;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.statement.UserStatementContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", BridgeDSL.INVOKE, "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final class UserStatementPresenter$getStatementDetail$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ UserStatementPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UserStatementPresenter$getStatementDetail$2(UserStatementPresenter userStatementPresenter) {
        super(1);
        this.this$0 = userStatementPresenter;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        UserStatementContract.View view;
        UserStatementContract.View view2;
        Intrinsics.checkNotNullParameter(th, "");
        DanaLog.scheduleImpl(DanaLogConstants.TAG.STATEMENT, th.getMessage());
        view = this.this$0.moveToNextValue;
        view.dismissProgress();
        view2 = this.this$0.moveToNextValue;
        view2.PlaceComponentResult();
    }
}
