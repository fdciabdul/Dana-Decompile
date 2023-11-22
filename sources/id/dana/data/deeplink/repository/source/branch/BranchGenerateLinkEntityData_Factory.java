package id.dana.data.deeplink.repository.source.branch;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BranchGenerateLinkEntityData_Factory implements Factory<BranchGenerateLinkEntityData> {
    private final Provider<Context> contextProvider;

    public BranchGenerateLinkEntityData_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final BranchGenerateLinkEntityData get() {
        return newInstance(this.contextProvider.get());
    }

    public static BranchGenerateLinkEntityData_Factory create(Provider<Context> provider) {
        return new BranchGenerateLinkEntityData_Factory(provider);
    }

    public static BranchGenerateLinkEntityData newInstance(Context context) {
        return new BranchGenerateLinkEntityData(context);
    }
}
