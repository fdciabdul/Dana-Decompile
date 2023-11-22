package id.dana.kybcpm.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MixpanelKybCpmTracker_Factory implements Factory<MixpanelKybCpmTracker> {
    private final Provider<Context> MyBillsEntityDataFactory;

    private MixpanelKybCpmTracker_Factory(Provider<Context> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static MixpanelKybCpmTracker_Factory getAuthRequestContext(Provider<Context> provider) {
        return new MixpanelKybCpmTracker_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MixpanelKybCpmTracker(this.MyBillsEntityDataFactory.get());
    }
}
