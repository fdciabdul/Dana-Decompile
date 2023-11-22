package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.nearbyme.MerchantContract;
import id.dana.nearbyme.MerchantPresenter;

@Module
/* loaded from: classes4.dex */
public class MerchantModule {
    private final MerchantContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public MerchantContract.Presenter BuiltInFictitiousFunctionClassFactory(MerchantPresenter merchantPresenter) {
        return merchantPresenter;
    }

    public MerchantModule(MerchantContract.View view) {
        this.MyBillsEntityDataFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public MerchantContract.View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
