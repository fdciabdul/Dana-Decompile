package id.dana.data.sendmoney.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DefaultBillerX2BEntityData_Factory implements Factory<DefaultBillerX2BEntityData> {
    private final Provider<Context> contextProvider;

    public DefaultBillerX2BEntityData_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final DefaultBillerX2BEntityData get() {
        return newInstance(this.contextProvider.get());
    }

    public static DefaultBillerX2BEntityData_Factory create(Provider<Context> provider) {
        return new DefaultBillerX2BEntityData_Factory(provider);
    }

    public static DefaultBillerX2BEntityData newInstance(Context context) {
        return new DefaultBillerX2BEntityData(context);
    }
}
