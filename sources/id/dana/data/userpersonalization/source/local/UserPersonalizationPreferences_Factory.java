package id.dana.data.userpersonalization.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserPersonalizationPreferences_Factory implements Factory<UserPersonalizationPreferences> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;

    private UserPersonalizationPreferences_Factory(Provider<Context> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static UserPersonalizationPreferences_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider) {
        return new UserPersonalizationPreferences_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserPersonalizationPreferences(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
