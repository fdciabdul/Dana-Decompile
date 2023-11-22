package id.dana.statement;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.domain.statement.model.UserStatementDetail;
import id.dana.statement.UserStatementContract;
import id.dana.statement.model.StatementDetailInit;
import id.dana.statement.model.UserStatementDetailModelKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/domain/statement/model/UserStatementDetail;", "it", "", BridgeDSL.INVOKE, "(Lid/dana/domain/statement/model/UserStatementDetail;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final class UserStatementPresenter$getStatementDetail$1 extends Lambda implements Function1<UserStatementDetail, Unit> {
    final /* synthetic */ StatementDetailInit $$detailInit;
    final /* synthetic */ UserStatementPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UserStatementPresenter$getStatementDetail$1(UserStatementPresenter userStatementPresenter, StatementDetailInit statementDetailInit) {
        super(1);
        this.this$0 = userStatementPresenter;
        this.$$detailInit = statementDetailInit;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(UserStatementDetail userStatementDetail) {
        invoke2(userStatementDetail);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(UserStatementDetail userStatementDetail) {
        UserStatementContract.View view;
        boolean PlaceComponentResult;
        boolean MyBillsEntityDataFactory;
        UserStatementContract.View view2;
        UserStatementContract.View view3;
        Intrinsics.checkNotNullParameter(userStatementDetail, "");
        view = this.this$0.moveToNextValue;
        view.dismissProgress();
        PlaceComponentResult = UserStatementPresenter.PlaceComponentResult(this.$$detailInit.MyBillsEntityDataFactory);
        if (PlaceComponentResult) {
            view3 = this.this$0.moveToNextValue;
            view3.MyBillsEntityDataFactory(UserStatementDetailModelKt.getAuthRequestContext(userStatementDetail));
            return;
        }
        MyBillsEntityDataFactory = UserStatementPresenter.MyBillsEntityDataFactory(this.$$detailInit.MyBillsEntityDataFactory);
        if (MyBillsEntityDataFactory) {
            view2 = this.this$0.moveToNextValue;
            view2.getAuthRequestContext(UserStatementDetailModelKt.getAuthRequestContext(userStatementDetail));
        }
    }
}
