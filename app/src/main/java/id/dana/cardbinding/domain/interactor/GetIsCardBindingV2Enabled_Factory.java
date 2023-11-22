package id.dana.cardbinding.domain.interactor;

import dagger.internal.Factory;
import id.dana.cardbinding.domain.CardBindingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetIsCardBindingV2Enabled_Factory implements Factory<GetIsCardBindingV2Enabled> {
    private final Provider<CardBindingRepository> MyBillsEntityDataFactory;

    private GetIsCardBindingV2Enabled_Factory(Provider<CardBindingRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory(Provider<CardBindingRepository> provider) {
        return new GetIsCardBindingV2Enabled_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetIsCardBindingV2Enabled(this.MyBillsEntityDataFactory.get());
    }
}
