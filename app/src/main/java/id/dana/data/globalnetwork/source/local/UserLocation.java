package id.dana.data.globalnetwork.source.local;

import android.content.Context;
import com.alipay.iap.android.lbs.LBSLocation;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.domain.globalsearch.model.LatLng;
import id.dana.utils.foundation.facede.LbsFacade;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/data/globalnetwork/source/local/UserLocation;", "", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/domain/globalsearch/model/LatLng;", "getUserLocation", "(Landroid/content/Context;)Lid/dana/domain/globalsearch/model/LatLng;", "latLng", "", "validateLocation", "(Lid/dana/domain/globalsearch/model/LatLng;)Z", "", "currentCountryCode", "Ljava/lang/String;", "getCurrentCountryCode", "()Ljava/lang/String;", "setCurrentCountryCode", "(Ljava/lang/String;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserLocation {
    private String currentCountryCode;

    @Inject
    public UserLocation() {
    }

    @JvmName(name = "getCurrentCountryCode")
    public final String getCurrentCountryCode() {
        return this.currentCountryCode;
    }

    @JvmName(name = "setCurrentCountryCode")
    public final void setCurrentCountryCode(String str) {
        this.currentCountryCode = str;
    }

    public final LatLng getUserLocation(Context context) {
        try {
            LBSLocation authRequestContext = LbsFacade.getAuthRequestContext(context);
            return new LatLng(authRequestContext.getLatitude(), authRequestContext.getLongitude());
        } catch (Exception unused) {
            return new LatLng(-360.0d, -360.0d);
        }
    }

    public final boolean validateLocation(LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "");
        double longitude = latLng.getLongitude();
        if (!(-180.0d <= longitude && longitude <= 180.0d)) {
            double latitude = latLng.getLatitude();
            if (!(-90.0d <= latitude && latitude <= 90.0d)) {
                return false;
            }
        }
        return true;
    }
}
