package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.requestmoney.RequestMoneyQrContract;
import id.dana.requestmoney.RequestMoneyQrPresenter;

@Module
/* loaded from: classes4.dex */
public class RequestMoneyQrModule {
    private RequestMoneyQrContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public RequestMoneyQrContract.Presenter PlaceComponentResult(RequestMoneyQrPresenter requestMoneyQrPresenter) {
        return requestMoneyQrPresenter;
    }

    public RequestMoneyQrModule(RequestMoneyQrContract.View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public RequestMoneyQrContract.View BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
