package id.dana.statement;

import dagger.internal.Factory;
import id.dana.domain.statement.interactor.CheckFeatureDownloadStatement;
import id.dana.domain.statement.interactor.GetAllStatementDetail;
import id.dana.domain.statement.interactor.GetAllStatementSummary;
import id.dana.domain.statement.interactor.GetStatementDetail;
import id.dana.domain.statement.interactor.GetStatementDisableDetail;
import id.dana.domain.statement.interactor.GetStatementSummary;
import id.dana.domain.statement.interactor.GetTotalStatements;
import id.dana.statement.UserStatementContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class UserStatementPresenter_Factory implements Factory<UserStatementPresenter> {
    private final Provider<GetAllStatementDetail> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetAllStatementSummary> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetStatementDetail> MyBillsEntityDataFactory;
    private final Provider<GetStatementSummary> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetStatementDisableDetail> PlaceComponentResult;
    private final Provider<CheckFeatureDownloadStatement> getAuthRequestContext;
    private final Provider<GetTotalStatements> lookAheadTest;
    private final Provider<UserStatementContract.View> moveToNextValue;

    private UserStatementPresenter_Factory(Provider<UserStatementContract.View> provider, Provider<GetStatementSummary> provider2, Provider<GetStatementDetail> provider3, Provider<GetAllStatementSummary> provider4, Provider<GetTotalStatements> provider5, Provider<GetAllStatementDetail> provider6, Provider<CheckFeatureDownloadStatement> provider7, Provider<GetStatementDisableDetail> provider8) {
        this.moveToNextValue = provider;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.lookAheadTest = provider5;
        this.BuiltInFictitiousFunctionClassFactory = provider6;
        this.getAuthRequestContext = provider7;
        this.PlaceComponentResult = provider8;
    }

    public static UserStatementPresenter_Factory getAuthRequestContext(Provider<UserStatementContract.View> provider, Provider<GetStatementSummary> provider2, Provider<GetStatementDetail> provider3, Provider<GetAllStatementSummary> provider4, Provider<GetTotalStatements> provider5, Provider<GetAllStatementDetail> provider6, Provider<CheckFeatureDownloadStatement> provider7, Provider<GetStatementDisableDetail> provider8) {
        return new UserStatementPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserStatementPresenter(this.moveToNextValue.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.lookAheadTest.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}
