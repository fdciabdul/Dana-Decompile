package id.dana.sendmoney_v2.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SendMoneyMixpanelTracker_Factory implements Factory<SendMoneyMixpanelTracker> {
    private final Provider<Context> MyBillsEntityDataFactory;

    private SendMoneyMixpanelTracker_Factory(Provider<Context> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static SendMoneyMixpanelTracker_Factory getAuthRequestContext(Provider<Context> provider) {
        return new SendMoneyMixpanelTracker_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SendMoneyMixpanelTracker(this.MyBillsEntityDataFactory.get());
    }
}
