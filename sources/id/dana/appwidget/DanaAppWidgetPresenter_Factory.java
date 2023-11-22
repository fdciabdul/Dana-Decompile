package id.dana.appwidget;

import dagger.internal.Factory;
import id.dana.appwidget.DanaAppWidgetContract;
import id.dana.appwidget.mapper.IncomeAndExpenseEntryChartModelMapper;
import id.dana.domain.account.interactor.HasAccount;
import id.dana.domain.statement.interactor.GetAllStatementDetail;
import id.dana.domain.statement.interactor.GetAllStatementSummary;
import id.dana.domain.statement.interactor.GetAllStatementSummarySynchronously;
import id.dana.domain.statement.interactor.GetCustomStatementSummary;
import id.dana.domain.user.interactor.GetBalance;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DanaAppWidgetPresenter_Factory implements Factory<DanaAppWidgetPresenter> {
    private final Provider<CurrencyAmountModelMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetAllStatementDetail> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetAllStatementSummarySynchronously> MyBillsEntityDataFactory;
    private final Provider<GetCustomStatementSummary> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetAllStatementSummary> PlaceComponentResult;
    private final Provider<GetBalance> getAuthRequestContext;
    private final Provider<IncomeAndExpenseEntryChartModelMapper> getErrorConfigVersion;
    private final Provider<HasAccount> moveToNextValue;
    private final Provider<DanaAppWidgetContract.View> scheduleImpl;

    private DanaAppWidgetPresenter_Factory(Provider<DanaAppWidgetContract.View> provider, Provider<GetBalance> provider2, Provider<CurrencyAmountModelMapper> provider3, Provider<GetAllStatementSummary> provider4, Provider<GetAllStatementDetail> provider5, Provider<GetCustomStatementSummary> provider6, Provider<GetAllStatementSummarySynchronously> provider7, Provider<IncomeAndExpenseEntryChartModelMapper> provider8, Provider<HasAccount> provider9) {
        this.scheduleImpl = provider;
        this.getAuthRequestContext = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.PlaceComponentResult = provider4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider6;
        this.MyBillsEntityDataFactory = provider7;
        this.getErrorConfigVersion = provider8;
        this.moveToNextValue = provider9;
    }

    public static DanaAppWidgetPresenter_Factory MyBillsEntityDataFactory(Provider<DanaAppWidgetContract.View> provider, Provider<GetBalance> provider2, Provider<CurrencyAmountModelMapper> provider3, Provider<GetAllStatementSummary> provider4, Provider<GetAllStatementDetail> provider5, Provider<GetCustomStatementSummary> provider6, Provider<GetAllStatementSummarySynchronously> provider7, Provider<IncomeAndExpenseEntryChartModelMapper> provider8, Provider<HasAccount> provider9) {
        return new DanaAppWidgetPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaAppWidgetPresenter(this.scheduleImpl.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.MyBillsEntityDataFactory.get(), this.getErrorConfigVersion.get(), this.moveToNextValue.get());
    }
}
