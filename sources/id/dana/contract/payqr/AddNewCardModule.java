package id.dana.contract.payqr;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.payasset.AddNewCardContract;
import id.dana.contract.payasset.AddNewCardPresenter;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class AddNewCardModule {
    private final AddNewCardContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public AddNewCardContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(AddNewCardPresenter addNewCardPresenter) {
        return addNewCardPresenter;
    }

    public AddNewCardModule(AddNewCardContract.View view) {
        this.MyBillsEntityDataFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public AddNewCardContract.View BuiltInFictitiousFunctionClassFactory() {
        return this.MyBillsEntityDataFactory;
    }
}
