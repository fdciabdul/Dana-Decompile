package id.dana.contract.account;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.account.FirstTimeContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class FirstTimeModule {
    private final FirstTimeContract.View PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public FirstTimeContract.Presenter MyBillsEntityDataFactory(FirstTimePresenter firstTimePresenter) {
        return firstTimePresenter;
    }

    public FirstTimeModule(FirstTimeContract.View view) {
        this.PlaceComponentResult = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public FirstTimeContract.View BuiltInFictitiousFunctionClassFactory() {
        return this.PlaceComponentResult;
    }
}
