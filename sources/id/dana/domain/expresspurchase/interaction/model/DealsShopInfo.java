package id.dana.domain.expresspurchase.interaction.model;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/DealsShopInfo;", "", "", "distanceInMeter", SummaryActivity.DAYS, "getDistanceInMeter", "()D", "", FeatureParams.SHOP_ID, "Ljava/lang/String;", "getShopId", "()Ljava/lang/String;", "shopName", "getShopName", "<init>", "(Ljava/lang/String;Ljava/lang/String;D)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DealsShopInfo {
    private final double distanceInMeter;
    private final String shopId;
    private final String shopName;

    public DealsShopInfo() {
        this(null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 7, null);
    }

    public DealsShopInfo(String str, String str2, double d) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.shopId = str;
        this.shopName = str2;
        this.distanceInMeter = d;
    }

    public /* synthetic */ DealsShopInfo(String str, String str2, double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : d);
    }

    @JvmName(name = "getShopId")
    public final String getShopId() {
        return this.shopId;
    }

    @JvmName(name = "getShopName")
    public final String getShopName() {
        return this.shopName;
    }

    @JvmName(name = "getDistanceInMeter")
    public final double getDistanceInMeter() {
        return this.distanceInMeter;
    }
}
