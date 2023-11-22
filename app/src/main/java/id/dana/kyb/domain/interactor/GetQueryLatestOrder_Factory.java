package id.dana.kyb.domain.interactor;

import dagger.internal.Factory;
import id.dana.kyb.domain.KybRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetQueryLatestOrder_Factory implements Factory<GetQueryLatestOrder> {
    private final Provider<KybRepository> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetQueryLatestOrder(this.PlaceComponentResult.get());
    }
}
