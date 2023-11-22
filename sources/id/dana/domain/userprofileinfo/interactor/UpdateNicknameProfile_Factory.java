package id.dana.domain.userprofileinfo.interactor;

import dagger.internal.Factory;
import id.dana.domain.userprofileinfo.UserProfileInfoRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class UpdateNicknameProfile_Factory implements Factory<UpdateNicknameProfile> {
    private final Provider<UserProfileInfoRepository> userProfileInfoRepositoryProvider;

    public UpdateNicknameProfile_Factory(Provider<UserProfileInfoRepository> provider) {
        this.userProfileInfoRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final UpdateNicknameProfile get() {
        return newInstance(this.userProfileInfoRepositoryProvider.get());
    }

    public static UpdateNicknameProfile_Factory create(Provider<UserProfileInfoRepository> provider) {
        return new UpdateNicknameProfile_Factory(provider);
    }

    public static UpdateNicknameProfile newInstance(UserProfileInfoRepository userProfileInfoRepository) {
        return new UpdateNicknameProfile(userProfileInfoRepository);
    }
}
