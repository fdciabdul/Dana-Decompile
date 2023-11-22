package id.dana.mybills.domain.interactor;

import dagger.internal.Factory;
import id.dana.mybills.domain.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SaveSubscription_Factory implements Factory<SaveSubscription> {
    private final Provider<MyBillsRepository> PlaceComponentResult;

    private SaveSubscription_Factory(Provider<MyBillsRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static SaveSubscription_Factory getAuthRequestContext(Provider<MyBillsRepository> provider) {
        return new SaveSubscription_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SaveSubscription(this.PlaceComponentResult.get());
    }
}
