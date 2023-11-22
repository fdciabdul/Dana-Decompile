package id.dana.statement;

import android.view.View;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.databinding.ActivityStatementBinding;
import id.dana.statement.model.StatementDetailModel;
import id.dana.statement.model.StatementViewModel;
import id.dana.statement.model.UserStatementDetailModel;
import id.dana.statement.model.UserStatementModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0007\u0010\u0010J\u001d\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00110\tH\u0016¢\u0006\u0004\b\u0007\u0010\fJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u000b\u0010\u0013J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0007\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/statement/StatementActivity$initComponent$1;", "Lid/dana/statement/UserStatementListener;", "", "dismissProgress", "()V", "", "p0", "MyBillsEntityDataFactory", "(Z)V", "", "Lid/dana/statement/model/StatementViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)V", "PlaceComponentResult", "Lid/dana/statement/model/UserStatementDetailModel;", "getAuthRequestContext", "(Lid/dana/statement/model/UserStatementDetailModel;)V", "", "Lid/dana/statement/model/UserStatementModel;", "(Lid/dana/statement/model/UserStatementModel;)V", "showProgress"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StatementActivity$initComponent$1 extends UserStatementListener {
    final /* synthetic */ StatementActivity getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StatementActivity$initComponent$1(StatementActivity statementActivity) {
        this.getAuthRequestContext = statementActivity;
    }

    @Override // id.dana.statement.UserStatementListener, id.dana.statement.UserStatementContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<StatementViewModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        StatementActivity.access$setStatementSummary(this.getAuthRequestContext, p0);
        StatementActivity statementActivity = this.getAuthRequestContext;
        Iterator<T> it = p0.iterator();
        while (it.hasNext()) {
            statementActivity.PlaceComponentResult(((StatementViewModel) it.next()).PlaceComponentResult.MyBillsEntityDataFactory);
        }
        Unit unit = Unit.INSTANCE;
        this.getAuthRequestContext.getStatementViewModels().addAll(p0);
    }

    @Override // id.dana.statement.UserStatementListener, id.dana.statement.UserStatementContract.View
    public final void MyBillsEntityDataFactory(UserStatementDetailModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        StatementActivity statementActivity = this.getAuthRequestContext;
        List<StatementDetailModel> list = p0.PlaceComponentResult;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        StatementActivity.access$fillDataToChart(statementActivity, list, "income");
    }

    @Override // id.dana.statement.UserStatementListener, id.dana.statement.UserStatementContract.View
    public final void getAuthRequestContext(UserStatementDetailModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        StatementActivity statementActivity = this.getAuthRequestContext;
        List<StatementDetailModel> list = p0.PlaceComponentResult;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        StatementActivity.access$fillDataToChart(statementActivity, list, "expense");
    }

    @Override // id.dana.statement.UserStatementListener, id.dana.statement.UserStatementContract.View
    public final void MyBillsEntityDataFactory(UserStatementModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.setUserStatementIncome(p0);
        StatementActivity statementActivity = this.getAuthRequestContext;
        UserStatementModel userStatementIncome = statementActivity.getUserStatementIncome();
        StatementActivity.access$setAdapterStatementItems(statementActivity, userStatementIncome != null ? userStatementIncome.MyBillsEntityDataFactory : null);
    }

    @Override // id.dana.statement.UserStatementListener, id.dana.statement.UserStatementContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(UserStatementModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.setUserStatementExpense(p0);
        StatementActivity statementActivity = this.getAuthRequestContext;
        UserStatementModel userStatementExpense = statementActivity.getUserStatementExpense();
        StatementActivity.access$setAdapterStatementItems(statementActivity, userStatementExpense != null ? userStatementExpense.MyBillsEntityDataFactory : null);
    }

    @Override // id.dana.statement.UserStatementListener, id.dana.statement.UserStatementContract.View
    public final void MyBillsEntityDataFactory(List<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
    }

    @Override // id.dana.statement.UserStatementListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        StatementActivity.access$showShimmeringLayout(this.getAuthRequestContext, true);
    }

    @Override // id.dana.statement.UserStatementListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        StatementActivity.access$showShimmeringLayout(this.getAuthRequestContext, false);
    }

    @Override // id.dana.statement.UserStatementListener, id.dana.statement.UserStatementContract.View
    public final void PlaceComponentResult() {
        StatementActivity.access$showChartWithNoData(this.getAuthRequestContext);
    }

    @Override // id.dana.statement.UserStatementListener, id.dana.statement.UserStatementContract.View
    public final void MyBillsEntityDataFactory(boolean p0) {
        ActivityStatementBinding binding;
        boolean z;
        this.getAuthRequestContext.MyBillsEntityDataFactory = p0;
        binding = this.getAuthRequestContext.getBinding();
        DanaButtonPrimaryView danaButtonPrimaryView = binding.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
        final StatementActivity statementActivity = this.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
        DanaButtonPrimaryView danaButtonPrimaryView2 = danaButtonPrimaryView;
        z = statementActivity.MyBillsEntityDataFactory;
        danaButtonPrimaryView2.setVisibility(z ? 0 : 8);
        danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.statement.StatementActivity$initComponent$1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StatementActivity$initComponent$1.KClassImpl$Data$declaredNonStaticMembers$2(StatementActivity.this);
            }
        });
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(StatementActivity statementActivity) {
        Intrinsics.checkNotNullParameter(statementActivity, "");
        statementActivity.onClickDownloadStatement();
    }
}
