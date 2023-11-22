package id.dana.data.globalnetwork.source.local;

import id.dana.data.globalnetwork.model.GnHereLocationConfig;
import id.dana.data.globalnetwork.source.GnConfigEntityData;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006R\u001a\u0010\r\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/data/globalnetwork/source/local/PreferenceGnConfigEntityData;", "Lid/dana/data/globalnetwork/source/GnConfigEntityData;", "Lio/reactivex/Observable;", "", "", "getGnCScanBBlacklistedCountry", "()Lio/reactivex/Observable;", "getMerchantBlockRegistration", "", "isGoogleBlockRegistration", "Lid/dana/data/globalnetwork/model/GnHereLocationConfig;", "isHereLocationEnabled", "Lid/dana/data/globalnetwork/source/local/GlobalNetworkPreference;", "globalNetworkPreference", "Lid/dana/data/globalnetwork/source/local/GlobalNetworkPreference;", "getGlobalNetworkPreference", "()Lid/dana/data/globalnetwork/source/local/GlobalNetworkPreference;", "<init>", "(Lid/dana/data/globalnetwork/source/local/GlobalNetworkPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PreferenceGnConfigEntityData implements GnConfigEntityData {
    private final GlobalNetworkPreference globalNetworkPreference;

    @Inject
    public PreferenceGnConfigEntityData(GlobalNetworkPreference globalNetworkPreference) {
        Intrinsics.checkNotNullParameter(globalNetworkPreference, "");
        this.globalNetworkPreference = globalNetworkPreference;
    }

    @JvmName(name = "getGlobalNetworkPreference")
    public final GlobalNetworkPreference getGlobalNetworkPreference() {
        return this.globalNetworkPreference;
    }

    @Override // id.dana.data.globalnetwork.source.GnConfigEntityData
    public final Observable<List<String>> getGnCScanBBlacklistedCountry() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.globalnetwork.source.GnConfigEntityData
    public final Observable<List<String>> getMerchantBlockRegistration() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.globalnetwork.source.GnConfigEntityData
    public final Observable<Boolean> isGoogleBlockRegistration() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.globalnetwork.source.GnConfigEntityData
    public final Observable<GnHereLocationConfig> isHereLocationEnabled() {
        throw new UnsupportedOperationException();
    }
}
