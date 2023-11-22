package id.dana.data.globalnetwork;

import id.dana.data.globalnetwork.model.GnConsultResult;
import io.reactivex.Observable;
import java.util.Map;

/* loaded from: classes4.dex */
public interface GlobalNetworkEntityData {
    Observable<String> decodeGnQr(String str, String str2);

    GnConsultResult doGnConsult(Map<String, String> map, String str);

    Observable<Boolean> getAlipayConnectServiceFirstTime();

    Observable<String> getCurrentCountryCode();

    Observable<Long> getLastTimeGetLocation();

    Observable<String> getSelectedCountryCode();

    Observable<Boolean> isCScanBEnabled();

    Observable<Boolean> saveAlipayConnectServiceFirstTime(boolean z);

    Observable<Boolean> saveCurrentCountryCode(String str);

    Observable<Boolean> saveLastTimeGetLocation(long j);
}
