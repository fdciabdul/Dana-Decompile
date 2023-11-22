package id.dana.feeds.data.activation.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PreferenceFeedInitEntityData_Factory implements Factory<PreferenceFeedInitEntityData> {
    private final Provider<Context> PlaceComponentResult;
    private final Provider<Serializer> getAuthRequestContext;

    private PreferenceFeedInitEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
    }

    public static PreferenceFeedInitEntityData_Factory PlaceComponentResult(Provider<Context> provider, Provider<Serializer> provider2) {
        return new PreferenceFeedInitEntityData_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PreferenceFeedInitEntityData(this.PlaceComponentResult.get(), this.getAuthRequestContext.get());
    }
}
