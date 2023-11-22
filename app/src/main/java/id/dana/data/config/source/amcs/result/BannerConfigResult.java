package id.dana.data.config.source.amcs.result;

import j$.util.Map;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001f\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR%\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\n"}, d2 = {"Lid/dana/data/config/source/amcs/result/BannerConfigResult;", "", "", "", "", "bannerManagementEnable", "Ljava/util/Map;", "getBannerManagementEnable", "()Ljava/util/Map;", "isHomeBannerEnabled", "()Z", "isHomeInterstitialEnabled", "<init>", "(Ljava/util/Map;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BannerConfigResult {
    public static final String HOME = "home";
    public static final String INTERSTITIAL = "interstitial";
    public static final String PAYMENT_SUCCESS = "paymentSuccess";
    public Map<String, Boolean> bannerManagementEnable;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BannerConfigResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.config.source.amcs.result.BannerConfigResult.<init>():void");
    }

    public BannerConfigResult(Map<String, Boolean> map) {
        this.bannerManagementEnable = map;
    }

    public /* synthetic */ BannerConfigResult(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map);
    }

    @JvmName(name = "getBannerManagementEnable")
    public final Map<String, Boolean> getBannerManagementEnable() {
        return this.bannerManagementEnable;
    }

    @JvmName(name = "isHomeInterstitialEnabled")
    public final boolean isHomeInterstitialEnabled() {
        Map<String, Boolean> map = this.bannerManagementEnable;
        if (map != null) {
            return ((Boolean) Map.EL.KClassImpl$Data$declaredNonStaticMembers$2(map, INTERSTITIAL, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    @JvmName(name = "isHomeBannerEnabled")
    public final boolean isHomeBannerEnabled() {
        java.util.Map<String, Boolean> map = this.bannerManagementEnable;
        if (map != null) {
            return ((Boolean) Map.EL.KClassImpl$Data$declaredNonStaticMembers$2(map, "home", Boolean.FALSE)).booleanValue();
        }
        return false;
    }
}
