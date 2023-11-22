package id.dana.data.holdlogin.v2.entity.source;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ImplSharedHoldLoginNetwork_Factory implements Factory<ImplSharedHoldLoginNetwork> {
    private final Provider<Context> PlaceComponentResult;

    private ImplSharedHoldLoginNetwork_Factory(Provider<Context> provider) {
        this.PlaceComponentResult = provider;
    }

    public static ImplSharedHoldLoginNetwork_Factory PlaceComponentResult(Provider<Context> provider) {
        return new ImplSharedHoldLoginNetwork_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ImplSharedHoldLoginNetwork(this.PlaceComponentResult.get());
    }
}
