package id.dana.explore.domain.userpersonalization.interactor;

import dagger.internal.Factory;
import id.dana.explore.domain.userpersonalization.UserPersonalizationRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SaveUserPersonalizationShown_Factory implements Factory<SaveUserPersonalizationShown> {
    private final Provider<UserPersonalizationRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private SaveUserPersonalizationShown_Factory(Provider<UserPersonalizationRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static SaveUserPersonalizationShown_Factory getAuthRequestContext(Provider<UserPersonalizationRepository> provider) {
        return new SaveUserPersonalizationShown_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SaveUserPersonalizationShown(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
