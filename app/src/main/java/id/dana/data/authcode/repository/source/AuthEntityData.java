package id.dana.data.authcode.repository.source;

import id.dana.data.authcode.AuthCodeEntity;
import id.dana.data.authcode.QueryAuthInfoResult;
import io.reactivex.Observable;

/* loaded from: classes4.dex */
public interface AuthEntityData {
    Observable<AuthCodeEntity> getAuthCode(String str, String str2, String str3, boolean z, String str4, String str5, boolean z2);

    Observable<AuthCodeEntity> getAuthCode(String str, String str2, String str3, boolean z, String str4, boolean z2, String str5);

    Observable<AuthCodeEntity> getGnAuthCode(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, String str7, String str8, String str9, String str10);

    Observable<QueryAuthInfoResult> queryAuthInfo(String str, String str2);
}
