package id.dana.appwidget;

import id.dana.appwidget.model.IncomeAndExpenseEntryChartModel;
import id.dana.base.AbstractContractKt;
import id.dana.domain.statement.model.UserStatement;
import id.dana.model.CurrencyAmountModel;
import id.dana.statement.model.StatementViewModel;
import id.dana.statement.model.UserStatementDetailModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/appwidget/DanaAppWidgetContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public interface DanaAppWidgetContract {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\bJ\u001d\u0010\u000e\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\rH&¢\u0006\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "Lid/dana/domain/statement/model/UserStatement;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/List;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "PlaceComponentResult", "", "p0", "getAuthRequestContext", "Lkotlin/Function0;", "MyBillsEntityDataFactory", "(Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        List<UserStatement> KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory(Function0<Unit> p0);

        void PlaceComponentResult();

        void getAuthRequestContext();
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Lid/dana/appwidget/DanaAppWidgetContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onAuthorizedAccess", "", "onGetAllStatementSummary", "listStatementViewModel", "", "Lid/dana/statement/model/StatementViewModel;", "onGetBalance", "balance", "Lid/dana/model/CurrencyAmountModel;", "onGetStatementDetailExpense", "userStatementDetailModelExpense", "Lid/dana/statement/model/UserStatementDetailModel;", "onGetStatementDetailIncome", "userStatementDetailModelIncome", "onShowChart", "incomeAndExpenseEntryChartModel", "Lid/dana/appwidget/model/IncomeAndExpenseEntryChartModel;", "onUnauthorizedAccess", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public interface View extends AbstractContractKt.AbstractView {

        /* renamed from: id.dana.appwidget.DanaAppWidgetContract$View$-CC  reason: invalid class name */
        /* loaded from: classes8.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            public static void MyBillsEntityDataFactory(CurrencyAmountModel currencyAmountModel) {
                Intrinsics.checkNotNullParameter(currencyAmountModel, "");
            }

            public static void MyBillsEntityDataFactory(UserStatementDetailModel userStatementDetailModel) {
                Intrinsics.checkNotNullParameter(userStatementDetailModel, "");
            }

            public static void PlaceComponentResult() {
            }

            public static void getAuthRequestContext(IncomeAndExpenseEntryChartModel incomeAndExpenseEntryChartModel) {
                Intrinsics.checkNotNullParameter(incomeAndExpenseEntryChartModel, "");
            }
        }

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(IncomeAndExpenseEntryChartModel incomeAndExpenseEntryChartModel);

        void KClassImpl$Data$declaredNonStaticMembers$2(UserStatementDetailModel userStatementDetailModel);

        void MyBillsEntityDataFactory(CurrencyAmountModel currencyAmountModel);

        void MyBillsEntityDataFactory(UserStatementDetailModel userStatementDetailModel);

        void getAuthRequestContext(List<StatementViewModel> list);
    }
}
