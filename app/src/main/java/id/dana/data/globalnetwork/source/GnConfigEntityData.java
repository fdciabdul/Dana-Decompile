package id.dana.data.globalnetwork.source;

import id.dana.data.globalnetwork.model.GnHereLocationConfig;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H&¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0002H&¢\u0006\u0004\b\u000b\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/globalnetwork/source/GnConfigEntityData;", "", "Lio/reactivex/Observable;", "", "", "getGnCScanBBlacklistedCountry", "()Lio/reactivex/Observable;", "getMerchantBlockRegistration", "", "isGoogleBlockRegistration", "Lid/dana/data/globalnetwork/model/GnHereLocationConfig;", "isHereLocationEnabled"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface GnConfigEntityData {
    Observable<List<String>> getGnCScanBBlacklistedCountry();

    Observable<List<String>> getMerchantBlockRegistration();

    Observable<Boolean> isGoogleBlockRegistration();

    Observable<GnHereLocationConfig> isHereLocationEnabled();
}
