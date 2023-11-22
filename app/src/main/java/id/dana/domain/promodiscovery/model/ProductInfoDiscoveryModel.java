package id.dana.domain.promodiscovery.model;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.nearbyme.model.VoucherInfo;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0013\u0012\b\b\u0002\u0010!\u001a\u00020\u0013\u0012\b\b\u0002\u0010\"\u001a\u00020\u0017\u0012\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005\u0012\b\b\u0002\u0010$\u001a\u00020\b\u0012\b\b\u0002\u0010%\u001a\u00020\u000b¢\u0006\u0004\bA\u0010BJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0094\u0001\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00132\b\b\u0002\u0010!\u001a\u00020\u00132\b\b\u0002\u0010\"\u001a\u00020\u00172\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010)\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*J\u0010\u0010,\u001a\u00020+HÖ\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b.\u0010\u0004R\u0017\u0010\"\u001a\u00020\u00178\u0007¢\u0006\f\n\u0004\b\"\u0010/\u001a\u0004\b0\u0010\u0019R\u001a\u0010!\u001a\u00020\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00101\u001a\u0004\b2\u0010\u0015R\u001a\u0010\u001d\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00103\u001a\u0004\b4\u0010\u0004R&\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u00105\u001a\u0004\b6\u0010\u0007R\u001a\u0010\u001a\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00103\u001a\u0004\b7\u0010\u0004R\u001a\u0010\u001f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00103\u001a\u0004\b8\u0010\u0004R\u001a\u0010\u001e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00103\u001a\u0004\b9\u0010\u0004R\u001a\u0010 \u001a\u00020\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00101\u001a\u0004\b:\u0010\u0015R\u001a\u0010\u001b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00103\u001a\u0004\b;\u0010\u0004R\u001a\u0010%\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010<\u001a\u0004\b=\u0010\rR\u001a\u0010\u001c\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00103\u001a\u0004\b>\u0010\u0004R\u001a\u0010$\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010?\u001a\u0004\b@\u0010\n"}, d2 = {"Lid/dana/domain/promodiscovery/model/ProductInfoDiscoveryModel;", "", "", "component1", "()Ljava/lang/String;", "", "component10", "()Ljava/util/Map;", "Lid/dana/domain/nearbyme/model/VoucherInfo;", "component11", "()Lid/dana/domain/nearbyme/model/VoucherInfo;", "", "component12", "()D", "component2", "component3", "component4", "component5", "component6", "Lid/dana/domain/nearbyme/model/MoneyView;", "component7", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component8", "", "component9", "()Z", "goodsId", "provider", "type", "description", "goodsTitle", "goodsImageUrl", FirebaseAnalytics.Param.PRICE, UpdateSubscriptionRequest.KEY_EXTEND_INFO_DENOM, "available", "extendInfo", "voucherInfo", "savingRate", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;ZLjava/util/Map;Lid/dana/domain/nearbyme/model/VoucherInfo;D)Lid/dana/domain/promodiscovery/model/ProductInfoDiscoveryModel;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getAvailable", "Lid/dana/domain/nearbyme/model/MoneyView;", "getDenom", "Ljava/lang/String;", "getDescription", "Ljava/util/Map;", "getExtendInfo", "getGoodsId", "getGoodsImageUrl", "getGoodsTitle", "getPrice", "getProvider", SummaryActivity.DAYS, "getSavingRate", "getType", "Lid/dana/domain/nearbyme/model/VoucherInfo;", "getVoucherInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;ZLjava/util/Map;Lid/dana/domain/nearbyme/model/VoucherInfo;D)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ProductInfoDiscoveryModel {
    private final boolean available;
    private final MoneyView denom;
    private final String description;
    private final Map<String, String> extendInfo;
    private final String goodsId;
    private final String goodsImageUrl;
    private final String goodsTitle;
    private final MoneyView price;
    private final String provider;
    private final double savingRate;
    private final String type;
    private final VoucherInfo voucherInfo;

    public ProductInfoDiscoveryModel() {
        this(null, null, null, null, null, null, null, null, false, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, ARiverTrackWatchDogEventConstant.STARTUP_FLAG, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    public final Map<String, String> component10() {
        return this.extendInfo;
    }

    /* renamed from: component11  reason: from getter */
    public final VoucherInfo getVoucherInfo() {
        return this.voucherInfo;
    }

    /* renamed from: component12  reason: from getter */
    public final double getSavingRate() {
        return this.savingRate;
    }

    /* renamed from: component2  reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    /* renamed from: component3  reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component4  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component5  reason: from getter */
    public final String getGoodsTitle() {
        return this.goodsTitle;
    }

    /* renamed from: component6  reason: from getter */
    public final String getGoodsImageUrl() {
        return this.goodsImageUrl;
    }

    /* renamed from: component7  reason: from getter */
    public final MoneyView getPrice() {
        return this.price;
    }

    /* renamed from: component8  reason: from getter */
    public final MoneyView getDenom() {
        return this.denom;
    }

    /* renamed from: component9  reason: from getter */
    public final boolean getAvailable() {
        return this.available;
    }

    public final ProductInfoDiscoveryModel copy(String goodsId, String provider, String type, String description, String goodsTitle, String goodsImageUrl, MoneyView price, MoneyView denom, boolean available, Map<String, String> extendInfo, VoucherInfo voucherInfo, double savingRate) {
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(provider, "");
        Intrinsics.checkNotNullParameter(type, "");
        Intrinsics.checkNotNullParameter(description, "");
        Intrinsics.checkNotNullParameter(goodsTitle, "");
        Intrinsics.checkNotNullParameter(goodsImageUrl, "");
        Intrinsics.checkNotNullParameter(price, "");
        Intrinsics.checkNotNullParameter(denom, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        Intrinsics.checkNotNullParameter(voucherInfo, "");
        return new ProductInfoDiscoveryModel(goodsId, provider, type, description, goodsTitle, goodsImageUrl, price, denom, available, extendInfo, voucherInfo, savingRate);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ProductInfoDiscoveryModel) {
            ProductInfoDiscoveryModel productInfoDiscoveryModel = (ProductInfoDiscoveryModel) other;
            return Intrinsics.areEqual(this.goodsId, productInfoDiscoveryModel.goodsId) && Intrinsics.areEqual(this.provider, productInfoDiscoveryModel.provider) && Intrinsics.areEqual(this.type, productInfoDiscoveryModel.type) && Intrinsics.areEqual(this.description, productInfoDiscoveryModel.description) && Intrinsics.areEqual(this.goodsTitle, productInfoDiscoveryModel.goodsTitle) && Intrinsics.areEqual(this.goodsImageUrl, productInfoDiscoveryModel.goodsImageUrl) && Intrinsics.areEqual(this.price, productInfoDiscoveryModel.price) && Intrinsics.areEqual(this.denom, productInfoDiscoveryModel.denom) && this.available == productInfoDiscoveryModel.available && Intrinsics.areEqual(this.extendInfo, productInfoDiscoveryModel.extendInfo) && Intrinsics.areEqual(this.voucherInfo, productInfoDiscoveryModel.voucherInfo) && Intrinsics.areEqual((Object) Double.valueOf(this.savingRate), (Object) Double.valueOf(productInfoDiscoveryModel.savingRate));
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.goodsId.hashCode();
        int hashCode2 = this.provider.hashCode();
        int hashCode3 = this.type.hashCode();
        int hashCode4 = this.description.hashCode();
        int hashCode5 = this.goodsTitle.hashCode();
        int hashCode6 = this.goodsImageUrl.hashCode();
        int hashCode7 = this.price.hashCode();
        int hashCode8 = this.denom.hashCode();
        boolean z = this.available;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + i) * 31) + this.extendInfo.hashCode()) * 31) + this.voucherInfo.hashCode()) * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.savingRate);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductInfoDiscoveryModel(goodsId=");
        sb.append(this.goodsId);
        sb.append(", provider=");
        sb.append(this.provider);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", goodsTitle=");
        sb.append(this.goodsTitle);
        sb.append(", goodsImageUrl=");
        sb.append(this.goodsImageUrl);
        sb.append(", price=");
        sb.append(this.price);
        sb.append(", denom=");
        sb.append(this.denom);
        sb.append(", available=");
        sb.append(this.available);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", voucherInfo=");
        sb.append(this.voucherInfo);
        sb.append(", savingRate=");
        sb.append(this.savingRate);
        sb.append(')');
        return sb.toString();
    }

    public ProductInfoDiscoveryModel(String str, String str2, String str3, String str4, String str5, String str6, MoneyView moneyView, MoneyView moneyView2, boolean z, Map<String, String> map, VoucherInfo voucherInfo, double d) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(moneyView, "");
        Intrinsics.checkNotNullParameter(moneyView2, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(voucherInfo, "");
        this.goodsId = str;
        this.provider = str2;
        this.type = str3;
        this.description = str4;
        this.goodsTitle = str5;
        this.goodsImageUrl = str6;
        this.price = moneyView;
        this.denom = moneyView2;
        this.available = z;
        this.extendInfo = map;
        this.voucherInfo = voucherInfo;
        this.savingRate = d;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getProvider")
    public final String getProvider() {
        return this.provider;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "getGoodsTitle")
    public final String getGoodsTitle() {
        return this.goodsTitle;
    }

    @JvmName(name = "getGoodsImageUrl")
    public final String getGoodsImageUrl() {
        return this.goodsImageUrl;
    }

    public /* synthetic */ ProductInfoDiscoveryModel(String str, String str2, String str3, String str4, String str5, String str6, MoneyView moneyView, MoneyView moneyView2, boolean z, Map map, VoucherInfo voucherInfo, double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) == 0 ? str6 : "", (i & 64) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView, (i & 128) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView2, (i & 256) != 0 ? false : z, (i & 512) != 0 ? MapsKt.emptyMap() : map, (i & 1024) != 0 ? new VoucherInfo(null, null, null, null, null, null, null, null, null, null, null, null, ARiverTrackWatchDogEventConstant.STARTUP_FLAG, null) : voucherInfo, (i & 2048) != 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : d);
    }

    @JvmName(name = "getPrice")
    public final MoneyView getPrice() {
        return this.price;
    }

    @JvmName(name = "getDenom")
    public final MoneyView getDenom() {
        return this.denom;
    }

    @JvmName(name = "getAvailable")
    public final boolean getAvailable() {
        return this.available;
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getVoucherInfo")
    public final VoucherInfo getVoucherInfo() {
        return this.voucherInfo;
    }

    @JvmName(name = "getSavingRate")
    public final double getSavingRate() {
        return this.savingRate;
    }
}
