package id.dana.contract.promocenter;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.promocenter.PromoCategoryContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class PromoCategoryModule {
    private final PromoCategoryContract.View getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public PromoCategoryContract.Presenter BuiltInFictitiousFunctionClassFactory(PromoCategoryPresenter promoCategoryPresenter) {
        return promoCategoryPresenter;
    }

    public PromoCategoryModule(PromoCategoryContract.View view) {
        this.getAuthRequestContext = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public PromoCategoryContract.View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
