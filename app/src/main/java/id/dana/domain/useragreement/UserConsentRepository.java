package id.dana.domain.useragreement;

import id.dana.domain.oauth.model.Agreement;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00060\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J\"\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rH&J0\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0014H&JJ\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0014H&J-\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0012\u001a\u00020\u0005H&J\\\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u001f\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0005H&J$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u001f\u001a\u00020\u0014H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\"À\u0006\u0001"}, d2 = {"Lid/dana/domain/useragreement/UserConsentRepository;", "", "buildAgreementContent", "Lio/reactivex/Observable;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "appName", "agreementContents", "", "Lid/dana/domain/oauth/model/Agreement;", "buildIncompleteUserDataContent", "incompleteUserData", "", "checkUserInfo", "Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo$UserInfo;", "serviceKeyOrAppId", "scopes", "clientId", "isMiniProgram", "", "consultAgreement", "Lid/dana/domain/useragreement/model/ConsultAgreementResponse;", "spaceCodes", "agreementType", "alwaysDisplayAgreementContent", "(Ljava/util/List;Ljava/lang/Boolean;)Lio/reactivex/Observable;", "getScopes", "recordAgreement", "", "agreementKeys", "userAgree", "appId", "merchantId", "domain_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface UserConsentRepository {
    Observable<ArrayList<String>> buildAgreementContent(String appName, List<? extends Agreement> agreementContents);

    Observable<List<String>> buildIncompleteUserDataContent(Set<String> incompleteUserData);

    Observable<GetEmptyUserInfo.UserInfo> checkUserInfo(String serviceKeyOrAppId, String scopes, String clientId, boolean isMiniProgram);

    Observable<ConsultAgreementResponse> consultAgreement(String serviceKeyOrAppId, List<String> spaceCodes, String agreementType, String scopes, String clientId, boolean isMiniProgram);

    Observable<ConsultAgreementResponse> consultAgreement(List<String> spaceCodes, Boolean alwaysDisplayAgreementContent);

    Observable<String> getScopes(String clientId);

    Observable<Unit> recordAgreement(String serviceKeyOrAppId, List<String> agreementKeys, boolean userAgree, String agreementType, String scopes, String appId, String clientId, String merchantId);

    Observable<Boolean> recordAgreement(List<String> agreementKeys, boolean userAgree);

    /* renamed from: id.dana.domain.useragreement.UserConsentRepository$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Observable consultAgreement$default(UserConsentRepository userConsentRepository, List list, Boolean bool, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    bool = null;
                }
                return userConsentRepository.consultAgreement(list, bool);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: consultAgreement");
        }
    }
}
