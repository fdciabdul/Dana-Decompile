package id.dana.domain.promodiscovery.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b"}, d2 = {"Lid/dana/domain/promodiscovery/model/PromoDiscoverySectionConfig;", "", "Lid/dana/domain/promodiscovery/model/DiscoverySectionConfig;", "bankPromoBanner", "Lid/dana/domain/promodiscovery/model/DiscoverySectionConfig;", "getBankPromoBanner", "()Lid/dana/domain/promodiscovery/model/DiscoverySectionConfig;", "setBankPromoBanner", "(Lid/dana/domain/promodiscovery/model/DiscoverySectionConfig;)V", "danaDeals", "getDanaDeals", "setDanaDeals", "nearExpiredPromoBannerConfig", "getNearExpiredPromoBannerConfig", "setNearExpiredPromoBannerConfig", "specialPromo", "getSpecialPromo", "setSpecialPromo", "voucherBanner", "getVoucherBanner", "setVoucherBanner", "<init>", "(Lid/dana/domain/promodiscovery/model/DiscoverySectionConfig;Lid/dana/domain/promodiscovery/model/DiscoverySectionConfig;Lid/dana/domain/promodiscovery/model/DiscoverySectionConfig;Lid/dana/domain/promodiscovery/model/DiscoverySectionConfig;Lid/dana/domain/promodiscovery/model/DiscoverySectionConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PromoDiscoverySectionConfig {
    private DiscoverySectionConfig bankPromoBanner;
    private DiscoverySectionConfig danaDeals;
    private DiscoverySectionConfig nearExpiredPromoBannerConfig;
    private DiscoverySectionConfig specialPromo;
    private DiscoverySectionConfig voucherBanner;

    public PromoDiscoverySectionConfig(DiscoverySectionConfig discoverySectionConfig, DiscoverySectionConfig discoverySectionConfig2, DiscoverySectionConfig discoverySectionConfig3, DiscoverySectionConfig discoverySectionConfig4, DiscoverySectionConfig discoverySectionConfig5) {
        Intrinsics.checkNotNullParameter(discoverySectionConfig, "");
        Intrinsics.checkNotNullParameter(discoverySectionConfig2, "");
        Intrinsics.checkNotNullParameter(discoverySectionConfig3, "");
        Intrinsics.checkNotNullParameter(discoverySectionConfig4, "");
        Intrinsics.checkNotNullParameter(discoverySectionConfig5, "");
        this.voucherBanner = discoverySectionConfig;
        this.nearExpiredPromoBannerConfig = discoverySectionConfig2;
        this.specialPromo = discoverySectionConfig3;
        this.danaDeals = discoverySectionConfig4;
        this.bankPromoBanner = discoverySectionConfig5;
    }

    @JvmName(name = "getVoucherBanner")
    public final DiscoverySectionConfig getVoucherBanner() {
        return this.voucherBanner;
    }

    @JvmName(name = "setVoucherBanner")
    public final void setVoucherBanner(DiscoverySectionConfig discoverySectionConfig) {
        Intrinsics.checkNotNullParameter(discoverySectionConfig, "");
        this.voucherBanner = discoverySectionConfig;
    }

    @JvmName(name = "getNearExpiredPromoBannerConfig")
    public final DiscoverySectionConfig getNearExpiredPromoBannerConfig() {
        return this.nearExpiredPromoBannerConfig;
    }

    @JvmName(name = "setNearExpiredPromoBannerConfig")
    public final void setNearExpiredPromoBannerConfig(DiscoverySectionConfig discoverySectionConfig) {
        Intrinsics.checkNotNullParameter(discoverySectionConfig, "");
        this.nearExpiredPromoBannerConfig = discoverySectionConfig;
    }

    @JvmName(name = "getSpecialPromo")
    public final DiscoverySectionConfig getSpecialPromo() {
        return this.specialPromo;
    }

    @JvmName(name = "setSpecialPromo")
    public final void setSpecialPromo(DiscoverySectionConfig discoverySectionConfig) {
        Intrinsics.checkNotNullParameter(discoverySectionConfig, "");
        this.specialPromo = discoverySectionConfig;
    }

    @JvmName(name = "getDanaDeals")
    public final DiscoverySectionConfig getDanaDeals() {
        return this.danaDeals;
    }

    @JvmName(name = "setDanaDeals")
    public final void setDanaDeals(DiscoverySectionConfig discoverySectionConfig) {
        Intrinsics.checkNotNullParameter(discoverySectionConfig, "");
        this.danaDeals = discoverySectionConfig;
    }

    @JvmName(name = "getBankPromoBanner")
    public final DiscoverySectionConfig getBankPromoBanner() {
        return this.bankPromoBanner;
    }

    @JvmName(name = "setBankPromoBanner")
    public final void setBankPromoBanner(DiscoverySectionConfig discoverySectionConfig) {
        Intrinsics.checkNotNullParameter(discoverySectionConfig, "");
        this.bankPromoBanner = discoverySectionConfig;
    }
}
