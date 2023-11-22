package id.dana.domain.ipg;

import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/ipg/IpgRepository;", "", "", "deviceId", "bizType", "Lio/reactivex/Observable;", "Lid/dana/domain/ipg/IpgRegistrationUrl;", "getIpgRegistrationUrl", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "userConsentConfigKey", "", "isClickedAgree", "(Ljava/lang/String;)Lio/reactivex/Observable;", "userConsentSyncKey", "saveClickedAgree"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IpgRepository {
    Observable<IpgRegistrationUrl> getIpgRegistrationUrl(String deviceId, String bizType);

    Observable<Boolean> isClickedAgree(String userConsentConfigKey);

    Observable<Boolean> saveClickedAgree(String userConsentConfigKey, String userConsentSyncKey);
}
