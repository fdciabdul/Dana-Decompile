package id.dana.data.promodiscovery.repository.source.split.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B9\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0001\u0010\f\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b"}, d2 = {"Lid/dana/data/promodiscovery/repository/source/split/model/PromoDiscoveryEntity;", "", "Lid/dana/data/promodiscovery/repository/source/split/model/DiscoverySectionEntity;", "bankPromoBannerEntity", "Lid/dana/data/promodiscovery/repository/source/split/model/DiscoverySectionEntity;", "getBankPromoBannerEntity", "()Lid/dana/data/promodiscovery/repository/source/split/model/DiscoverySectionEntity;", "setBankPromoBannerEntity", "(Lid/dana/data/promodiscovery/repository/source/split/model/DiscoverySectionEntity;)V", "danaDealsEntity", "getDanaDealsEntity", "setDanaDealsEntity", "nearExpiredPromoBannerEntity", "getNearExpiredPromoBannerEntity", "setNearExpiredPromoBannerEntity", "specialPromoEntity", "getSpecialPromoEntity", "setSpecialPromoEntity", "voucherBannerEntity", "getVoucherBannerEntity", "setVoucherBannerEntity", "<init>", "(Lid/dana/data/promodiscovery/repository/source/split/model/DiscoverySectionEntity;Lid/dana/data/promodiscovery/repository/source/split/model/DiscoverySectionEntity;Lid/dana/data/promodiscovery/repository/source/split/model/DiscoverySectionEntity;Lid/dana/data/promodiscovery/repository/source/split/model/DiscoverySectionEntity;Lid/dana/data/promodiscovery/repository/source/split/model/DiscoverySectionEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PromoDiscoveryEntity {
    @SerializedName("bank_promo_banner")
    private DiscoverySectionEntity bankPromoBannerEntity;
    @SerializedName("dana_deals")
    private DiscoverySectionEntity danaDealsEntity;
    @SerializedName("near_expired_promo_banner")
    private DiscoverySectionEntity nearExpiredPromoBannerEntity;
    @SerializedName("special_promo")
    private DiscoverySectionEntity specialPromoEntity;
    @SerializedName("voucher_banner")
    private DiscoverySectionEntity voucherBannerEntity;

    public PromoDiscoveryEntity(@JSONField(name = "voucher_banner") DiscoverySectionEntity discoverySectionEntity, @JSONField(name = "near_expired_promo_banner") DiscoverySectionEntity discoverySectionEntity2, @JSONField(name = "special_promo") DiscoverySectionEntity discoverySectionEntity3, @JSONField(name = "dana_deals") DiscoverySectionEntity discoverySectionEntity4, @JSONField(name = "bank_promo_banner") DiscoverySectionEntity discoverySectionEntity5) {
        Intrinsics.checkNotNullParameter(discoverySectionEntity, "");
        Intrinsics.checkNotNullParameter(discoverySectionEntity2, "");
        Intrinsics.checkNotNullParameter(discoverySectionEntity3, "");
        Intrinsics.checkNotNullParameter(discoverySectionEntity4, "");
        Intrinsics.checkNotNullParameter(discoverySectionEntity5, "");
        this.voucherBannerEntity = discoverySectionEntity;
        this.nearExpiredPromoBannerEntity = discoverySectionEntity2;
        this.specialPromoEntity = discoverySectionEntity3;
        this.danaDealsEntity = discoverySectionEntity4;
        this.bankPromoBannerEntity = discoverySectionEntity5;
    }

    @JvmName(name = "getVoucherBannerEntity")
    public final DiscoverySectionEntity getVoucherBannerEntity() {
        return this.voucherBannerEntity;
    }

    @JvmName(name = "setVoucherBannerEntity")
    public final void setVoucherBannerEntity(DiscoverySectionEntity discoverySectionEntity) {
        Intrinsics.checkNotNullParameter(discoverySectionEntity, "");
        this.voucherBannerEntity = discoverySectionEntity;
    }

    @JvmName(name = "getNearExpiredPromoBannerEntity")
    public final DiscoverySectionEntity getNearExpiredPromoBannerEntity() {
        return this.nearExpiredPromoBannerEntity;
    }

    @JvmName(name = "setNearExpiredPromoBannerEntity")
    public final void setNearExpiredPromoBannerEntity(DiscoverySectionEntity discoverySectionEntity) {
        Intrinsics.checkNotNullParameter(discoverySectionEntity, "");
        this.nearExpiredPromoBannerEntity = discoverySectionEntity;
    }

    @JvmName(name = "getSpecialPromoEntity")
    public final DiscoverySectionEntity getSpecialPromoEntity() {
        return this.specialPromoEntity;
    }

    @JvmName(name = "setSpecialPromoEntity")
    public final void setSpecialPromoEntity(DiscoverySectionEntity discoverySectionEntity) {
        Intrinsics.checkNotNullParameter(discoverySectionEntity, "");
        this.specialPromoEntity = discoverySectionEntity;
    }

    @JvmName(name = "getDanaDealsEntity")
    public final DiscoverySectionEntity getDanaDealsEntity() {
        return this.danaDealsEntity;
    }

    @JvmName(name = "setDanaDealsEntity")
    public final void setDanaDealsEntity(DiscoverySectionEntity discoverySectionEntity) {
        Intrinsics.checkNotNullParameter(discoverySectionEntity, "");
        this.danaDealsEntity = discoverySectionEntity;
    }

    @JvmName(name = "getBankPromoBannerEntity")
    public final DiscoverySectionEntity getBankPromoBannerEntity() {
        return this.bankPromoBannerEntity;
    }

    @JvmName(name = "setBankPromoBannerEntity")
    public final void setBankPromoBannerEntity(DiscoverySectionEntity discoverySectionEntity) {
        Intrinsics.checkNotNullParameter(discoverySectionEntity, "");
        this.bankPromoBannerEntity = discoverySectionEntity;
    }
}
