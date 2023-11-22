package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.richview.promoclaim.PromoClaimContract;
import id.dana.richview.promoclaim.PromoClaimPresenter;

@Module
/* loaded from: classes8.dex */
public class PromoClaimModule {
    private PromoClaimContract.View PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public PromoClaimContract.Presenter getAuthRequestContext(PromoClaimPresenter promoClaimPresenter) {
        return promoClaimPresenter;
    }

    public PromoClaimModule(PromoClaimContract.View view) {
        this.PlaceComponentResult = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public PromoClaimContract.View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
