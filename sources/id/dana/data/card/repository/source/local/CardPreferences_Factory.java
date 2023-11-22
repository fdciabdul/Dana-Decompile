package id.dana.data.card.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CardPreferences_Factory implements Factory<CardPreferences> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public CardPreferences_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final CardPreferences get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static CardPreferences_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new CardPreferences_Factory(provider, provider2);
    }

    public static CardPreferences newInstance(Context context, Serializer serializer) {
        return new CardPreferences(context, serializer);
    }
}
