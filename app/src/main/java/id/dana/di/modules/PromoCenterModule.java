package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.promocenter.promo.PromoCenterContract;
import id.dana.contract.promocenter.promo.PromoCenterPresenter;

@Module
/* loaded from: classes4.dex */
public class PromoCenterModule {
    private PromoCenterContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public PromoCenterContract.Presenter PlaceComponentResult(PromoCenterPresenter promoCenterPresenter) {
        return promoCenterPresenter;
    }

    public PromoCenterModule(PromoCenterContract.View view) {
        this.MyBillsEntityDataFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public PromoCenterContract.View PlaceComponentResult() {
        return this.MyBillsEntityDataFactory;
    }
}
