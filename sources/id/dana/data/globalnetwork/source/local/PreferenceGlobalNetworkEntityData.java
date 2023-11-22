package id.dana.data.globalnetwork.source.local;

import id.dana.data.globalnetwork.GlobalNetworkEntityData;
import id.dana.data.globalnetwork.model.GnConsultResult;
import io.reactivex.Observable;
import java.util.Map;

/* loaded from: classes4.dex */
public class PreferenceGlobalNetworkEntityData implements GlobalNetworkEntityData {
    private final GlobalNetworkPreference globalNetworkPreference;

    @Override // id.dana.data.globalnetwork.GlobalNetworkEntityData
    public GnConsultResult doGnConsult(Map<String, String> map, String str) {
        return null;
    }

    public PreferenceGlobalNetworkEntityData(GlobalNetworkPreference globalNetworkPreference) {
        this.globalNetworkPreference = globalNetworkPreference;
    }

    @Override // id.dana.data.globalnetwork.GlobalNetworkEntityData
    public Observable<String> getSelectedCountryCode() {
        return Observable.just(this.globalNetworkPreference.getCountryCode());
    }

    @Override // id.dana.data.globalnetwork.GlobalNetworkEntityData
    public Observable<Boolean> getAlipayConnectServiceFirstTime() {
        return Observable.just(Boolean.valueOf(this.globalNetworkPreference.getAlipayConnectServiceFirstTime()));
    }

    @Override // id.dana.data.globalnetwork.GlobalNetworkEntityData
    public Observable<Boolean> saveAlipayConnectServiceFirstTime(boolean z) {
        return Observable.just(Boolean.valueOf(this.globalNetworkPreference.saveAlipayConnectServiceFirstTime(z)));
    }

    @Override // id.dana.data.globalnetwork.GlobalNetworkEntityData
    public Observable<Boolean> saveCurrentCountryCode(String str) {
        return Observable.just(Boolean.valueOf(this.globalNetworkPreference.saveCurrentCountryCode(str)));
    }

    @Override // id.dana.data.globalnetwork.GlobalNetworkEntityData
    public Observable<String> getCurrentCountryCode() {
        return Observable.just(this.globalNetworkPreference.getCurrentCountryCode());
    }

    @Override // id.dana.data.globalnetwork.GlobalNetworkEntityData
    public Observable<String> decodeGnQr(String str, String str2) {
        return Observable.just("");
    }

    @Override // id.dana.data.globalnetwork.GlobalNetworkEntityData
    public Observable<Boolean> isCScanBEnabled() {
        return Observable.just(Boolean.FALSE);
    }

    @Override // id.dana.data.globalnetwork.GlobalNetworkEntityData
    public Observable<Boolean> saveLastTimeGetLocation(long j) {
        return Observable.just(Boolean.valueOf(this.globalNetworkPreference.saveLastTimeGetLocation(j)));
    }

    @Override // id.dana.data.globalnetwork.GlobalNetworkEntityData
    public Observable<Long> getLastTimeGetLocation() {
        return Observable.just(Long.valueOf(this.globalNetworkPreference.getLastTimeGetLocation()));
    }
}
