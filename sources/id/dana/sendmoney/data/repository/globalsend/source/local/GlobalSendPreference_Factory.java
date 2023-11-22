package id.dana.sendmoney.data.repository.globalsend.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GlobalSendPreference_Factory implements Factory<GlobalSendPreference> {
    private final Provider<Context> MyBillsEntityDataFactory;

    private GlobalSendPreference_Factory(Provider<Context> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static GlobalSendPreference_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider) {
        return new GlobalSendPreference_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GlobalSendPreference(this.MyBillsEntityDataFactory.get());
    }
}
