package id.dana.data.promodiscovery.repository.source.network.response;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import id.dana.data.nearbyme.model.VoucherInfoEntity;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010 \u001a\u0004\u0018\u00010\f\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\b\u0010,\u001a\u0004\u0018\u00010\f\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0011¢\u0006\u0004\b3\u00104R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u000bR\u001c\u0010 \u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010R\u001c\u0010#\u001a\u0004\u0018\u00010\"8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010(\u001a\u0004\u0018\u00010'8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\u000e\u001a\u0004\b-\u0010\u0010R\u001c\u0010/\u001a\u0004\u0018\u00010.8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102"}, d2 = {"Lid/dana/data/promodiscovery/repository/source/network/response/ProductInfoEntity;", "", "", "available", "Ljava/lang/Boolean;", "getAvailable", "()Ljava/lang/Boolean;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", UpdateSubscriptionRequest.KEY_EXTEND_INFO_DENOM, "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getDenom", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "", "extendInfo", "Ljava/util/Map;", "getExtendInfo", "()Ljava/util/Map;", "goodsId", "getGoodsId", "goodsImageUrl", "getGoodsImageUrl", "goodsTitle", "getGoodsTitle", "merchantName", "getMerchantName", FirebaseAnalytics.Param.PRICE, "getPrice", "provider", "getProvider", "", "ranking", "Ljava/lang/Integer;", "getRanking", "()Ljava/lang/Integer;", "", "savingRate", "Ljava/lang/Double;", "getSavingRate", "()Ljava/lang/Double;", "type", "getType", "Lid/dana/data/nearbyme/model/VoucherInfoEntity;", "voucherInfo", "Lid/dana/data/nearbyme/model/VoucherInfoEntity;", "getVoucherInfo", "()Lid/dana/data/nearbyme/model/VoucherInfoEntity;", "<init>", "(Ljava/lang/Boolean;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Lid/dana/data/nearbyme/model/VoucherInfoEntity;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ProductInfoEntity {
    @SerializedName("available")
    private final Boolean available;
    @SerializedName(UpdateSubscriptionRequest.KEY_EXTEND_INFO_DENOM)
    private final MoneyViewEntity denom;
    @SerializedName("description")
    private final String description;
    @SerializedName("extendInfo")
    private final Map<String, String> extendInfo;
    @SerializedName("goodsId")
    private final String goodsId;
    @SerializedName("goodsImageUrl")
    private final String goodsImageUrl;
    @SerializedName("goodsTitle")
    private final String goodsTitle;
    @SerializedName("merchantName")
    private final String merchantName;
    @SerializedName(FirebaseAnalytics.Param.PRICE)
    private final MoneyViewEntity price;
    @SerializedName("provider")
    private final String provider;
    @SerializedName("ranking")
    private final Integer ranking;
    @SerializedName("savingRate")
    private final Double savingRate;
    @SerializedName("type")
    private final String type;
    @SerializedName("voucherInfo")
    private final VoucherInfoEntity voucherInfo;

    public ProductInfoEntity(Boolean bool, MoneyViewEntity moneyViewEntity, String str, String str2, String str3, String str4, String str5, MoneyViewEntity moneyViewEntity2, String str6, Integer num, Double d, String str7, VoucherInfoEntity voucherInfoEntity, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.available = bool;
        this.denom = moneyViewEntity;
        this.description = str;
        this.goodsId = str2;
        this.goodsImageUrl = str3;
        this.goodsTitle = str4;
        this.merchantName = str5;
        this.price = moneyViewEntity2;
        this.provider = str6;
        this.ranking = num;
        this.savingRate = d;
        this.type = str7;
        this.voucherInfo = voucherInfoEntity;
        this.extendInfo = map;
    }

    @JvmName(name = "getAvailable")
    public final Boolean getAvailable() {
        return this.available;
    }

    @JvmName(name = "getDenom")
    public final MoneyViewEntity getDenom() {
        return this.denom;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getGoodsImageUrl")
    public final String getGoodsImageUrl() {
        return this.goodsImageUrl;
    }

    @JvmName(name = "getGoodsTitle")
    public final String getGoodsTitle() {
        return this.goodsTitle;
    }

    @JvmName(name = "getMerchantName")
    public final String getMerchantName() {
        return this.merchantName;
    }

    @JvmName(name = "getPrice")
    public final MoneyViewEntity getPrice() {
        return this.price;
    }

    @JvmName(name = "getProvider")
    public final String getProvider() {
        return this.provider;
    }

    @JvmName(name = "getRanking")
    public final Integer getRanking() {
        return this.ranking;
    }

    @JvmName(name = "getSavingRate")
    public final Double getSavingRate() {
        return this.savingRate;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getVoucherInfo")
    public final VoucherInfoEntity getVoucherInfo() {
        return this.voucherInfo;
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }
}
