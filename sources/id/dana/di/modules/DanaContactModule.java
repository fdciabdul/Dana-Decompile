package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.contact.DanaContactContract;
import id.dana.contract.contact.DanaContactPresenter;

@Module
/* loaded from: classes2.dex */
public class DanaContactModule {
    private DanaContactContract.View PlaceComponentResult;

    @Provides
    public DanaContactContract.Presenter MyBillsEntityDataFactory(DanaContactPresenter danaContactPresenter) {
        return danaContactPresenter;
    }

    public DanaContactModule(DanaContactContract.View view) {
        this.PlaceComponentResult = view;
    }

    @Provides
    public DanaContactContract.View BuiltInFictitiousFunctionClassFactory() {
        return this.PlaceComponentResult;
    }
}
