package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.sendmoney.RecipientContract;
import id.dana.contract.sendmoney.RecipientPresenter;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class RecipientActivityModule {
    private final RecipientContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public RecipientContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(RecipientPresenter recipientPresenter) {
        return recipientPresenter;
    }

    public RecipientActivityModule(RecipientContract.View view) {
        this.MyBillsEntityDataFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public RecipientContract.View PlaceComponentResult() {
        return this.MyBillsEntityDataFactory;
    }
}
