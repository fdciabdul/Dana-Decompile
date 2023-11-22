package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.richview.bank.AutoCompleteBankContract;
import id.dana.richview.bank.AutoCompleteBankPresenter;

@Module
/* loaded from: classes8.dex */
public class AutoCompleteBankModule {
    private AutoCompleteBankContract.View getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public AutoCompleteBankContract.Presenter PlaceComponentResult(AutoCompleteBankPresenter autoCompleteBankPresenter) {
        return autoCompleteBankPresenter;
    }

    public AutoCompleteBankModule(AutoCompleteBankContract.View view) {
        this.getAuthRequestContext = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public AutoCompleteBankContract.View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
