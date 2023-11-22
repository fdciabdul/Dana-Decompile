package id.dana.data.transferaccount.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TransferAccountPreference_Factory implements Factory<TransferAccountPreference> {
    private final Provider<Serializer> MyBillsEntityDataFactory;
    private final Provider<Context> PlaceComponentResult;

    private TransferAccountPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.PlaceComponentResult = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static TransferAccountPreference_Factory PlaceComponentResult(Provider<Context> provider, Provider<Serializer> provider2) {
        return new TransferAccountPreference_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TransferAccountPreference(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get());
    }
}
