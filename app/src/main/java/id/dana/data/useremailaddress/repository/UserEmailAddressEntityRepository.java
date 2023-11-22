package id.dana.data.useremailaddress.repository;

import id.dana.data.foundation.utils.CookieUtil;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.security.SecureString;
import id.dana.data.useremailaddress.UserEmailAddressEntityData;
import id.dana.data.useremailaddress.mapper.UserEmailAddressEntityResultMapper;
import id.dana.data.useremailaddress.repository.source.UserEmailAddressEntityDataFactory;
import id.dana.data.useremailaddress.repository.source.network.result.UserEmailAddressEntityResult;
import id.dana.domain.useremailaddress.model.UserEmailAddress;
import id.dana.domain.useremailaddress.repository.UserEmailAddressRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class UserEmailAddressEntityRepository implements UserEmailAddressRepository {
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final UserEmailAddressEntityResultMapper mapper;
    private final UserEmailAddressEntityDataFactory userEmailAddressEntityDataFactory;

    @Inject
    public UserEmailAddressEntityRepository(UserEmailAddressEntityDataFactory userEmailAddressEntityDataFactory, UserEmailAddressEntityResultMapper userEmailAddressEntityResultMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.userEmailAddressEntityDataFactory = userEmailAddressEntityDataFactory;
        this.mapper = userEmailAddressEntityResultMapper;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.useremailaddress.repository.UserEmailAddressRepository
    public Observable<String> getEmailAddress() {
        SecureString authRequestContext = CookieUtil.getAuthRequestContext();
        Observable<String> map = this.holdLoginV1EntityRepository.authenticatedRequest(createSendMoneyData().getEmailAddress(authRequestContext.toString())).map(new Function() { // from class: id.dana.data.useremailaddress.repository.UserEmailAddressEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ((UserEmailAddressEntityResult) obj).getUserEmail();
            }
        });
        authRequestContext.clear();
        return map;
    }

    @Override // id.dana.domain.useremailaddress.repository.UserEmailAddressRepository
    public Observable<UserEmailAddress> getEmailAddressAndVerifyResult() {
        SecureString authRequestContext = CookieUtil.getAuthRequestContext();
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createSendMoneyData().getEmailAddress(authRequestContext.toString()));
        final UserEmailAddressEntityResultMapper userEmailAddressEntityResultMapper = this.mapper;
        Objects.requireNonNull(userEmailAddressEntityResultMapper);
        Observable<UserEmailAddress> map = authenticatedRequest.map(new Function() { // from class: id.dana.data.useremailaddress.repository.UserEmailAddressEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEmailAddressEntityResultMapper.this.apply((UserEmailAddressEntityResult) obj);
            }
        });
        authRequestContext.clear();
        return map;
    }

    private UserEmailAddressEntityData createSendMoneyData() {
        return this.userEmailAddressEntityDataFactory.createData2("network");
    }
}
