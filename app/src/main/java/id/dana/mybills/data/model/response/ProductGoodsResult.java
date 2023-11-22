package id.dana.mybills.data.model.response;

import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001Be\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010"}, d2 = {"Lid/dana/mybills/data/model/response/ProductGoodsResult;", "", "", "available", "Ljava/lang/Boolean;", "getAvailable", "()Ljava/lang/Boolean;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", UpdateSubscriptionRequest.KEY_EXTEND_INFO_DENOM, "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getDenom", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "goodsId", "getGoodsId", "goodsTitle", "getGoodsTitle", FirebaseAnalytics.Param.PRICE, "getPrice", "productCode", "getProductCode", "provider", "getProvider", "type", "getType", "<init>", "(Ljava/lang/Boolean;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProductGoodsResult {
    private final Boolean available;
    private final MoneyViewEntity denom;
    private final String description;
    private final String goodsId;
    private final String goodsTitle;
    private final MoneyViewEntity price;
    private final String productCode;
    private final String provider;
    private final String type;

    public ProductGoodsResult(Boolean bool, MoneyViewEntity moneyViewEntity, String str, String str2, String str3, MoneyViewEntity moneyViewEntity2, String str4, String str5, String str6) {
        this.available = bool;
        this.denom = moneyViewEntity;
        this.description = str;
        this.goodsId = str2;
        this.goodsTitle = str3;
        this.price = moneyViewEntity2;
        this.productCode = str4;
        this.provider = str5;
        this.type = str6;
    }

    public /* synthetic */ ProductGoodsResult(Boolean bool, MoneyViewEntity moneyViewEntity, String str, String str2, String str3, MoneyViewEntity moneyViewEntity2, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bool, moneyViewEntity, str, str2, (i & 16) != 0 ? null : str3, moneyViewEntity2, str4, (i & 128) != 0 ? null : str5, str6);
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

    @JvmName(name = "getGoodsTitle")
    public final String getGoodsTitle() {
        return this.goodsTitle;
    }

    @JvmName(name = "getPrice")
    public final MoneyViewEntity getPrice() {
        return this.price;
    }

    @JvmName(name = "getProductCode")
    public final String getProductCode() {
        return this.productCode;
    }

    @JvmName(name = "getProvider")
    public final String getProvider() {
        return this.provider;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }
}
