package id.dana.cardbinding.domain.interactor;

import dagger.internal.Factory;
import id.dana.cardbinding.domain.CardBindingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetCardInfoFromImage_Factory implements Factory<GetCardInfoFromImage> {
    private final Provider<CardBindingRepository> BuiltInFictitiousFunctionClassFactory;

    private GetCardInfoFromImage_Factory(Provider<CardBindingRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GetCardInfoFromImage_Factory PlaceComponentResult(Provider<CardBindingRepository> provider) {
        return new GetCardInfoFromImage_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetCardInfoFromImage(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
