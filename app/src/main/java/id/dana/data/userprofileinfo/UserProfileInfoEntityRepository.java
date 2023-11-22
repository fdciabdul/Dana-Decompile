package id.dana.data.userprofileinfo;

import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.userprofileinfo.mapper.UserProfileInfoMapper;
import id.dana.data.userprofileinfo.source.UserProfileInfoEntityData;
import id.dana.data.userprofileinfo.source.UserProfileInfoEntityDataFactory;
import id.dana.data.userprofileinfo.source.network.result.UserProfileInfoResult;
import id.dana.domain.userprofileinfo.UserProfileInfoRepository;
import id.dana.domain.userprofileinfo.response.UserProfileInfoResponse;
import io.reactivex.Observable;
import java.util.Objects;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class UserProfileInfoEntityRepository implements UserProfileInfoRepository {
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final UserProfileInfoMapper mapper;
    private final UserProfileInfoEntityDataFactory userProfileInfoEntityDataFactory;

    @Inject
    public UserProfileInfoEntityRepository(UserProfileInfoEntityDataFactory userProfileInfoEntityDataFactory, UserProfileInfoMapper userProfileInfoMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.userProfileInfoEntityDataFactory = userProfileInfoEntityDataFactory;
        this.mapper = userProfileInfoMapper;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.userprofileinfo.UserProfileInfoRepository
    public Observable<UserProfileInfoResponse> updateUserProfileInfo(String str) {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createUserProfileInfo().updateUserProfileInfo(AccountEntityRepository.UpdateType.AVATAR, str));
        UserProfileInfoMapper userProfileInfoMapper = this.mapper;
        Objects.requireNonNull(userProfileInfoMapper);
        return authenticatedRequest.map(new UserProfileInfoEntityRepository$$ExternalSyntheticLambda0(userProfileInfoMapper));
    }

    @Override // id.dana.domain.userprofileinfo.UserProfileInfoRepository
    public Observable<UserProfileInfoResponse> updateNicknameProfile(String str) {
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = this.holdLoginV1EntityRepository;
        Observable<UserProfileInfoResult> updateUserProfileInfo = createUserProfileInfo().updateUserProfileInfo("nickname", str);
        UserProfileInfoMapper userProfileInfoMapper = this.mapper;
        Objects.requireNonNull(userProfileInfoMapper);
        return holdLoginV1EntityRepository.authenticatedRequest(updateUserProfileInfo.map(new UserProfileInfoEntityRepository$$ExternalSyntheticLambda0(userProfileInfoMapper)));
    }

    private UserProfileInfoEntityData createUserProfileInfo() {
        return this.userProfileInfoEntityDataFactory.createData2("network");
    }
}
