package id.dana.domain.oauth.repository;

import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.authcode.QueryAuthInfo;
import id.dana.domain.oauth.model.OauthConfirmation;
import id.dana.domain.oauth.model.OauthInit;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface OauthRepository {
    Observable<OauthConfirmation> confirmOauthScope(String str, String str2, List<String> list, String str3, boolean z);

    Observable<AuthCodeResult> getAuthCode(String str, String str2, String str3, boolean z, String str4, String str5, boolean z2);

    Observable<AuthCodeResult> getGnAuthAgreement(String str, List<String> list, String str2, String str3, String str4, String str5, String str6);

    Observable<OauthInit> getOauthScope(String str, String str2, List<String> list, String str3, boolean z);

    Observable<QueryAuthInfo> queryAuthInfo(String str, String str2);

    Observable<AuthCodeResult> submitGnAuthApply(String str, String str2, List<String> list, String str3, String str4, String str5, String str6, String str7);
}
