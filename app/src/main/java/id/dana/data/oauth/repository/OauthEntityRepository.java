package id.dana.data.oauth.repository;

import com.alipay.mobile.security.bio.utils.StringUtil;
import id.dana.data.authcode.QueryAuthInfoResult;
import id.dana.data.authcode.mapper.AuthMapper;
import id.dana.data.authcode.repository.source.AuthEntityData;
import id.dana.data.authcode.repository.source.AuthEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.oauth.mapper.OauthConfirmResultMapper;
import id.dana.data.oauth.mapper.OauthInitResultMapper;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.authcode.QueryAuthInfo;
import id.dana.domain.oauth.model.OauthConfirmation;
import id.dana.domain.oauth.model.OauthInit;
import id.dana.domain.oauth.repository.OauthRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class OauthEntityRepository implements OauthRepository {
    private final AuthEntityDataFactory authEntityDataFactory;
    private final AuthMapper authMapper;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final OauthConfirmResultMapper oauthConfirmResultMapper;
    private final OauthInitResultMapper oauthInitResultMapper;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public OauthEntityRepository(OauthInitResultMapper oauthInitResultMapper, AuthEntityDataFactory authEntityDataFactory, OauthConfirmResultMapper oauthConfirmResultMapper, AuthMapper authMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.oauthInitResultMapper = oauthInitResultMapper;
        this.authEntityDataFactory = authEntityDataFactory;
        this.oauthConfirmResultMapper = oauthConfirmResultMapper;
        this.authMapper = authMapper;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.oauth.repository.OauthRepository
    public Observable<OauthInit> getOauthScope(String str, String str2, List<String> list, String str3, boolean z) {
        Observable<AuthCodeResult> authCode = getAuthCode(str3, str2, StringUtil.join(list, ","), false, str, z);
        final OauthInitResultMapper oauthInitResultMapper = this.oauthInitResultMapper;
        Objects.requireNonNull(oauthInitResultMapper);
        return authCode.map(new Function() { // from class: id.dana.data.oauth.repository.OauthEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return OauthInitResultMapper.this.apply((AuthCodeResult) obj);
            }
        });
    }

    @Override // id.dana.domain.oauth.repository.OauthRepository
    public Observable<OauthConfirmation> confirmOauthScope(String str, String str2, List<String> list, String str3, boolean z) {
        Observable<AuthCodeResult> authCode = getAuthCode(str3, str2, StringUtil.join(list, ","), true, str, z);
        final OauthConfirmResultMapper oauthConfirmResultMapper = this.oauthConfirmResultMapper;
        Objects.requireNonNull(oauthConfirmResultMapper);
        return authCode.map(new Function() { // from class: id.dana.data.oauth.repository.OauthEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return OauthConfirmResultMapper.this.apply((AuthCodeResult) obj);
            }
        });
    }

    @Override // id.dana.domain.oauth.repository.OauthRepository
    public Observable<AuthCodeResult> getGnAuthAgreement(String str, List<String> list, String str2, String str3, String str4, String str5, String str6) {
        return getGnAuthCode("", str2, str, StringUtil.join(list, ","), false, str3, str4, "", str5, str6, null);
    }

    @Override // id.dana.domain.oauth.repository.OauthRepository
    public Observable<AuthCodeResult> submitGnAuthApply(String str, String str2, List<String> list, String str3, String str4, String str5, String str6, String str7) {
        return getGnAuthCode(str, str3, str2, StringUtil.join(list, ","), true, str4, str5, str6, "", "", str7);
    }

    @Override // id.dana.domain.oauth.repository.OauthRepository
    public Observable<AuthCodeResult> getAuthCode(String str, String str2, String str3, boolean z, String str4, String str5, boolean z2) {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createAuthData().getAuthCode(str, str2, str3, z, str4, str5, z2));
        AuthMapper authMapper = this.authMapper;
        Objects.requireNonNull(authMapper);
        return authenticatedRequest.map(new OauthEntityRepository$$ExternalSyntheticLambda2(authMapper));
    }

    @Override // id.dana.domain.oauth.repository.OauthRepository
    public Observable<QueryAuthInfo> queryAuthInfo(String str, String str2) {
        Observable<QueryAuthInfoResult> queryAuthInfo = createAuthData().queryAuthInfo(str, str2);
        final AuthMapper authMapper = this.authMapper;
        Objects.requireNonNull(authMapper);
        return queryAuthInfo.map(new Function() { // from class: id.dana.data.oauth.repository.OauthEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AuthMapper.this.transform((QueryAuthInfoResult) obj);
            }
        });
    }

    private Observable<AuthCodeResult> getAuthCode(String str, String str2, String str3, boolean z, String str4, boolean z2) {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createAuthData().getAuthCode(str, str2, str3, z, str4, z2, ""));
        AuthMapper authMapper = this.authMapper;
        Objects.requireNonNull(authMapper);
        return authenticatedRequest.map(new OauthEntityRepository$$ExternalSyntheticLambda2(authMapper));
    }

    private Observable<AuthCodeResult> getGnAuthCode(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, String str9, String str10) {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createAuthData().getGnAuthCode(str, str2, str3, str4, Boolean.valueOf(z), str5, str6, str7, str8, str9, str10));
        AuthMapper authMapper = this.authMapper;
        Objects.requireNonNull(authMapper);
        return authenticatedRequest.map(new OauthEntityRepository$$ExternalSyntheticLambda2(authMapper));
    }

    private AuthEntityData createAuthData() {
        return this.authEntityDataFactory.createData2("network");
    }
}
