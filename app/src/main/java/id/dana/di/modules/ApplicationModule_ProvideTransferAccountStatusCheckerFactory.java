package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.domain.transferaccount.interactor.GetCacheTransferAccountStatus;
import id.dana.transferaccount.TransferAccountStatusChecker;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideTransferAccountStatusCheckerFactory implements Factory<TransferAccountStatusChecker> {
    private final Provider<GetCacheTransferAccountStatus> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule MyBillsEntityDataFactory;
    private final Provider<Context> PlaceComponentResult;

    private ApplicationModule_ProvideTransferAccountStatusCheckerFactory(ApplicationModule applicationModule, Provider<Context> provider, Provider<GetCacheTransferAccountStatus> provider2) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.PlaceComponentResult = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static ApplicationModule_ProvideTransferAccountStatusCheckerFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<Context> provider, Provider<GetCacheTransferAccountStatus> provider2) {
        return new ApplicationModule_ProvideTransferAccountStatusCheckerFactory(applicationModule, provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TransferAccountStatusChecker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
