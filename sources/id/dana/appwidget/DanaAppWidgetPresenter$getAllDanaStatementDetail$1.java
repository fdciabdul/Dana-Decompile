package id.dana.appwidget;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.appwidget.DanaAppWidgetContract;
import id.dana.domain.statement.StatementType;
import id.dana.domain.statement.model.UserStatementDetail;
import id.dana.statement.model.UserStatementDetailModelKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lid/dana/domain/statement/model/UserStatementDetail;", "statements", "", BridgeDSL.INVOKE, "(Ljava/util/List;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
final class DanaAppWidgetPresenter$getAllDanaStatementDetail$1 extends Lambda implements Function1<List<? extends UserStatementDetail>, Unit> {
    final /* synthetic */ DanaAppWidgetPresenter this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[StatementType.values().length];
            iArr[StatementType.INCOME.ordinal()] = 1;
            iArr[StatementType.EXPENSE.ordinal()] = 2;
            MyBillsEntityDataFactory = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DanaAppWidgetPresenter$getAllDanaStatementDetail$1(DanaAppWidgetPresenter danaAppWidgetPresenter) {
        super(1);
        this.this$0 = danaAppWidgetPresenter;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(List<? extends UserStatementDetail> list) {
        invoke2((List<UserStatementDetail>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<UserStatementDetail> list) {
        DanaAppWidgetContract.View view;
        DanaAppWidgetContract.View view2;
        Intrinsics.checkNotNullParameter(list, "");
        DanaAppWidgetPresenter danaAppWidgetPresenter = this.this$0;
        for (UserStatementDetail userStatementDetail : list) {
            int i = WhenMappings.MyBillsEntityDataFactory[userStatementDetail.getStatementType().ordinal()];
            if (i == 1) {
                view2 = danaAppWidgetPresenter.lookAheadTest;
                view2.KClassImpl$Data$declaredNonStaticMembers$2(UserStatementDetailModelKt.getAuthRequestContext(userStatementDetail));
            } else if (i == 2) {
                view = danaAppWidgetPresenter.lookAheadTest;
                view.MyBillsEntityDataFactory(UserStatementDetailModelKt.getAuthRequestContext(userStatementDetail));
            }
        }
    }
}
