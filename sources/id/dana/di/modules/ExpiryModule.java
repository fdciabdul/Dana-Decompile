package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.sendmoney.ExpiryContract;
import id.dana.contract.sendmoney.ExpiryPresenter;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class ExpiryModule {
    private final ExpiryContract.View BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public ExpiryContract.Presenter MyBillsEntityDataFactory(ExpiryPresenter expiryPresenter) {
        return expiryPresenter;
    }

    public ExpiryModule(ExpiryContract.View view) {
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public ExpiryContract.View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
