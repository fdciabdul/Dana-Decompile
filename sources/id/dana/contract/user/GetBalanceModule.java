package id.dana.contract.user;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.user.GetBalanceContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes2.dex */
public class GetBalanceModule {
    private final GetBalanceContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public GetBalanceContract.Presenter PlaceComponentResult(GetBalancePresenter getBalancePresenter) {
        return getBalancePresenter;
    }

    public GetBalanceModule(GetBalanceContract.View view) {
        this.MyBillsEntityDataFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public GetBalanceContract.View PlaceComponentResult() {
        return this.MyBillsEntityDataFactory;
    }
}
