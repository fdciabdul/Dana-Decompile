package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.sendmoney.bank.SavedBankCardContract;
import id.dana.contract.sendmoney.bank.SavedBankCardPresenter;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class SavedBankModule {
    private final SavedBankCardContract.View BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SavedBankCardContract.Presenter getAuthRequestContext(SavedBankCardPresenter savedBankCardPresenter) {
        return savedBankCardPresenter;
    }

    public SavedBankModule(SavedBankCardContract.View view) {
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SavedBankCardContract.View getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
