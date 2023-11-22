package id.dana.mybills.ui.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b/\u00100J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\nJ|\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\"\u0010\nR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\u0007R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010\nR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b)\u0010\nR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b*\u0010\nR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b+\u0010\u0007R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b,\u0010\nR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b-\u0010\nR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b.\u0010\n"}, d2 = {"Lid/dana/mybills/ui/model/ProductGoodsModel;", "", "", "component1", "()Ljava/lang/Boolean;", "Lid/dana/mybills/ui/model/MoneyViewModel;", "component2", "()Lid/dana/mybills/ui/model/MoneyViewModel;", "", "component3", "()Ljava/lang/String;", "component4", "component5", "component6", "component7", "component8", "component9", "available", UpdateSubscriptionRequest.KEY_EXTEND_INFO_DENOM, "description", "goodsId", "goodsTitle", FirebaseAnalytics.Param.PRICE, "productCode", "provider", "type", "copy", "(Ljava/lang/Boolean;Lid/dana/mybills/ui/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/mybills/ui/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/mybills/ui/model/ProductGoodsModel;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/Boolean;", "getAvailable", "Lid/dana/mybills/ui/model/MoneyViewModel;", "getDenom", "Ljava/lang/String;", "getDescription", "getGoodsId", "getGoodsTitle", "getPrice", "getProductCode", "getProvider", "getType", "<init>", "(Ljava/lang/Boolean;Lid/dana/mybills/ui/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/mybills/ui/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ProductGoodsModel {
    private final Boolean available;
    private final MoneyViewModel denom;
    private final String description;
    private final String goodsId;
    private final String goodsTitle;
    private final MoneyViewModel price;
    private final String productCode;
    private final String provider;
    private final String type;

    /* renamed from: component1  reason: from getter */
    public final Boolean getAvailable() {
        return this.available;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyViewModel getDenom() {
        return this.denom;
    }

    /* renamed from: component3  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getGoodsTitle() {
        return this.goodsTitle;
    }

    /* renamed from: component6  reason: from getter */
    public final MoneyViewModel getPrice() {
        return this.price;
    }

    /* renamed from: component7  reason: from getter */
    public final String getProductCode() {
        return this.productCode;
    }

    /* renamed from: component8  reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    /* renamed from: component9  reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final ProductGoodsModel copy(Boolean available, MoneyViewModel denom, String description, String goodsId, String goodsTitle, MoneyViewModel price, String productCode, String provider, String type) {
        return new ProductGoodsModel(available, denom, description, goodsId, goodsTitle, price, productCode, provider, type);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ProductGoodsModel) {
            ProductGoodsModel productGoodsModel = (ProductGoodsModel) other;
            return Intrinsics.areEqual(this.available, productGoodsModel.available) && Intrinsics.areEqual(this.denom, productGoodsModel.denom) && Intrinsics.areEqual(this.description, productGoodsModel.description) && Intrinsics.areEqual(this.goodsId, productGoodsModel.goodsId) && Intrinsics.areEqual(this.goodsTitle, productGoodsModel.goodsTitle) && Intrinsics.areEqual(this.price, productGoodsModel.price) && Intrinsics.areEqual(this.productCode, productGoodsModel.productCode) && Intrinsics.areEqual(this.provider, productGoodsModel.provider) && Intrinsics.areEqual(this.type, productGoodsModel.type);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.available;
        int hashCode = bool == null ? 0 : bool.hashCode();
        MoneyViewModel moneyViewModel = this.denom;
        int hashCode2 = moneyViewModel == null ? 0 : moneyViewModel.hashCode();
        String str = this.description;
        int hashCode3 = str == null ? 0 : str.hashCode();
        String str2 = this.goodsId;
        int hashCode4 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.goodsTitle;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        MoneyViewModel moneyViewModel2 = this.price;
        int hashCode6 = moneyViewModel2 == null ? 0 : moneyViewModel2.hashCode();
        String str4 = this.productCode;
        int hashCode7 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.provider;
        int hashCode8 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.type;
        return (((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + (str6 != null ? str6.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductGoodsModel(available=");
        sb.append(this.available);
        sb.append(", denom=");
        sb.append(this.denom);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", goodsTitle=");
        sb.append(this.goodsTitle);
        sb.append(", price=");
        sb.append(this.price);
        sb.append(", productCode=");
        sb.append(this.productCode);
        sb.append(", provider=");
        sb.append(this.provider);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(')');
        return sb.toString();
    }

    public ProductGoodsModel(Boolean bool, MoneyViewModel moneyViewModel, String str, String str2, String str3, MoneyViewModel moneyViewModel2, String str4, String str5, String str6) {
        this.available = bool;
        this.denom = moneyViewModel;
        this.description = str;
        this.goodsId = str2;
        this.goodsTitle = str3;
        this.price = moneyViewModel2;
        this.productCode = str4;
        this.provider = str5;
        this.type = str6;
    }

    @JvmName(name = "getAvailable")
    public final Boolean getAvailable() {
        return this.available;
    }

    @JvmName(name = "getDenom")
    public final MoneyViewModel getDenom() {
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
    public final MoneyViewModel getPrice() {
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
