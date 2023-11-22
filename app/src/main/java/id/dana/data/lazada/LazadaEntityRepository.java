package id.dana.data.lazada;

import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.lazada.mapper.LazadaRegistrationUrlMapper;
import id.dana.data.lazada.model.UserConfigContentLazada;
import id.dana.data.lazada.model.UserConfigLazada;
import id.dana.data.lazada.repository.source.LazadaRegistrationUrlEntityData;
import id.dana.data.lazada.repository.source.LazadaRegistrationUrlEntityDataFactory;
import id.dana.data.lazada.repository.source.network.response.LazadaRegistrationUrlResult;
import id.dana.data.userconfig.UserConfigBizTypeConstant;
import id.dana.data.userconfig.repository.UserConfigEntityRepository;
import id.dana.data.userconfig.repository.UserConfigRepository;
import id.dana.domain.lazada.LazadaRegistrationUrl;
import id.dana.domain.lazada.LazadaRepository;
import id.dana.domain.userconfig.model.QueryConfig;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class LazadaEntityRepository implements LazadaRepository {
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final LazadaRegistrationUrlEntityDataFactory lazadaRegistrationUrlEntityDataFactory;
    private final LazadaRegistrationUrlMapper lazadaRegistrationUrlMapper;
    private final UserConfigRepository userConfigRepository;

    @Inject
    public LazadaEntityRepository(UserConfigEntityRepository userConfigEntityRepository, LazadaRegistrationUrlEntityDataFactory lazadaRegistrationUrlEntityDataFactory, LazadaRegistrationUrlMapper lazadaRegistrationUrlMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.userConfigRepository = userConfigEntityRepository;
        this.lazadaRegistrationUrlEntityDataFactory = lazadaRegistrationUrlEntityDataFactory;
        this.lazadaRegistrationUrlMapper = lazadaRegistrationUrlMapper;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.lazada.LazadaRepository
    public Observable<Boolean> isClickedAgree() {
        return this.userConfigRepository.getUserSpecificConfig(new QueryConfig(UserConfigBizTypeConstant.CONFIG_LAZADA_JKT_CONSENT, UserConfigContentLazada.class)).map(new Function() { // from class: id.dana.data.lazada.LazadaEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((UserConfigContentLazada) obj).userConsent);
                return valueOf;
            }
        });
    }

    @Override // id.dana.domain.lazada.LazadaRepository
    public Observable<Boolean> saveClickedAgree() {
        UserConfigContentLazada userConfigContentLazada = new UserConfigContentLazada();
        userConfigContentLazada.userConsent = true;
        return this.userConfigRepository.saveUserSpecificConfigBackendFirst(new UserConfigLazada(userConfigContentLazada));
    }

    @Override // id.dana.domain.lazada.LazadaRepository
    public Observable<LazadaRegistrationUrl> getLazadaRegistrationUrl(String str, String str2) {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createIpgEntityData().getLazadaRegistrationUrl(str, str2));
        final LazadaRegistrationUrlMapper lazadaRegistrationUrlMapper = this.lazadaRegistrationUrlMapper;
        Objects.requireNonNull(lazadaRegistrationUrlMapper);
        return authenticatedRequest.map(new Function() { // from class: id.dana.data.lazada.LazadaEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return LazadaRegistrationUrlMapper.this.transform((LazadaRegistrationUrlResult) obj);
            }
        });
    }

    private LazadaRegistrationUrlEntityData createIpgEntityData() {
        return this.lazadaRegistrationUrlEntityDataFactory.createData2("network");
    }
}
