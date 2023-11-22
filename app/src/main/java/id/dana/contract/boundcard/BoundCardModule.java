package id.dana.contract.boundcard;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.boundcard.BoundCardContract;

@Module
/* loaded from: classes8.dex */
public class BoundCardModule {
    private final BoundCardContract.View PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public BoundCardContract.Presenter BuiltInFictitiousFunctionClassFactory(BoundCardPresenter boundCardPresenter) {
        return boundCardPresenter;
    }

    public BoundCardModule(BoundCardContract.View view) {
        this.PlaceComponentResult = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public BoundCardContract.View MyBillsEntityDataFactory() {
        return this.PlaceComponentResult;
    }
}
