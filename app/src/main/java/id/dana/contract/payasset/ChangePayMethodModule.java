package id.dana.contract.payasset;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.payasset.ChangePayMethodContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class ChangePayMethodModule {
    private final ChangePayMethodContract.View BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public ChangePayMethodContract.Presenter BuiltInFictitiousFunctionClassFactory(ChangePayMethodPresenter changePayMethodPresenter) {
        return changePayMethodPresenter;
    }

    public ChangePayMethodModule(ChangePayMethodContract.View view) {
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public ChangePayMethodContract.View BuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
