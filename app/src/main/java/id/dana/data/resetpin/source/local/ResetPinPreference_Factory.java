package id.dana.data.resetpin.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ResetPinPreference_Factory implements Factory<ResetPinPreference> {
    private final Provider<Serializer> MyBillsEntityDataFactory;
    private final Provider<Context> getAuthRequestContext;

    private ResetPinPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.getAuthRequestContext = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static ResetPinPreference_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider, Provider<Serializer> provider2) {
        return new ResetPinPreference_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ResetPinPreference(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
