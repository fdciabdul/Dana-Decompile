package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.requestmoney.bank.UserBankContract;
import id.dana.requestmoney.bank.UserBankPresenter;

@Module
/* loaded from: classes4.dex */
public class UserBankModule {
    private UserBankContract.View BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public UserBankContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(UserBankPresenter userBankPresenter) {
        return userBankPresenter;
    }

    public UserBankModule(UserBankContract.View view) {
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public UserBankContract.View PlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
