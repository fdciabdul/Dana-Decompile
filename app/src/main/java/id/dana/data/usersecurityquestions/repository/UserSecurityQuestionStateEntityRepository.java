package id.dana.data.usersecurityquestions.repository;

import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.usersecurityquestions.UserSecurityQuestionStateEntityData;
import id.dana.data.usersecurityquestions.mapper.UserSecurityQuestionResultMapper;
import id.dana.data.usersecurityquestions.repository.source.UserSecurityQuestionStateEntityDataFactory;
import id.dana.data.usersecurityquestions.repository.source.network.result.UserSecurityQuestionEntityResult;
import id.dana.domain.usersecurityquestions.model.UserSecurityQuestionInfo;
import id.dana.domain.usersecurityquestions.repository.UserSecurityQuestionStateRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class UserSecurityQuestionStateEntityRepository implements UserSecurityQuestionStateRepository {
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final UserSecurityQuestionResultMapper mapper;
    private final UserSecurityQuestionStateEntityDataFactory userSecurityQuestionStateEntityDataFactory;

    @Inject
    public UserSecurityQuestionStateEntityRepository(UserSecurityQuestionStateEntityDataFactory userSecurityQuestionStateEntityDataFactory, UserSecurityQuestionResultMapper userSecurityQuestionResultMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.userSecurityQuestionStateEntityDataFactory = userSecurityQuestionStateEntityDataFactory;
        this.mapper = userSecurityQuestionResultMapper;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    private UserSecurityQuestionStateEntityData createData() {
        return this.userSecurityQuestionStateEntityDataFactory.createData2("network");
    }

    @Override // id.dana.domain.usersecurityquestions.repository.UserSecurityQuestionStateRepository
    public Observable<UserSecurityQuestionInfo> getSecurityQuestionState(final String str) {
        return Observable.defer(new Callable() { // from class: id.dana.data.usersecurityquestions.repository.UserSecurityQuestionStateEntityRepository$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UserSecurityQuestionStateEntityRepository.this.m2138x9b083b67();
            }
        }).flatMap(new Function() { // from class: id.dana.data.usersecurityquestions.repository.UserSecurityQuestionStateEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserSecurityQuestionStateEntityRepository.this.m2139x84100068(str, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSecurityQuestionState$0$id-dana-data-usersecurityquestions-repository-UserSecurityQuestionStateEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2138x9b083b67() throws Exception {
        String userId = UserInfoManager.instance().getUserId();
        return userId != null ? Observable.just(userId) : this.holdLoginV1EntityRepository.createAccountData().getUserId();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSecurityQuestionState$1$id-dana-data-usersecurityquestions-repository-UserSecurityQuestionStateEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2139x84100068(String str, String str2) throws Exception {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createData().getSecurityQuestionState(str2, str));
        final UserSecurityQuestionResultMapper userSecurityQuestionResultMapper = this.mapper;
        Objects.requireNonNull(userSecurityQuestionResultMapper);
        return authenticatedRequest.map(new Function() { // from class: id.dana.data.usersecurityquestions.repository.UserSecurityQuestionStateEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserSecurityQuestionResultMapper.this.apply((UserSecurityQuestionEntityResult) obj);
            }
        });
    }
}
