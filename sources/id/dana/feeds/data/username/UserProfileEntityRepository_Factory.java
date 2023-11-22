package id.dana.feeds.data.username;

import dagger.internal.Factory;
import id.dana.feeds.data.username.source.UserProfileEntityData;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class UserProfileEntityRepository_Factory implements Factory<UserProfileEntityRepository> {
    private final Provider<UserProfileEntityData> PlaceComponentResult;

    private UserProfileEntityRepository_Factory(Provider<UserProfileEntityData> provider) {
        this.PlaceComponentResult = provider;
    }

    public static UserProfileEntityRepository_Factory MyBillsEntityDataFactory(Provider<UserProfileEntityData> provider) {
        return new UserProfileEntityRepository_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserProfileEntityRepository(this.PlaceComponentResult.get());
    }
}
