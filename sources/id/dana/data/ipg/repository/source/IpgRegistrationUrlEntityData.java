package id.dana.data.ipg.repository.source;

import id.dana.data.ipg.repository.source.network.response.IpgRegistrationUrlResult;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/ipg/repository/source/IpgRegistrationUrlEntityData;", "", "", "deviceId", "bizType", "Lio/reactivex/Observable;", "Lid/dana/data/ipg/repository/source/network/response/IpgRegistrationUrlResult;", "getIpgRegistrationUrl", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IpgRegistrationUrlEntityData {
    Observable<IpgRegistrationUrlResult> getIpgRegistrationUrl(String deviceId, String bizType);
}
