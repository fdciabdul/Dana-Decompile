package id.dana.cashier.data.repository.source.network.result;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010$\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\bA\u0010BJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\nJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J¸\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010)\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*J\u0010\u0010,\u001a\u00020+HÖ\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b.\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b0\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00101\u001a\u0004\b2\u0010\nR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00101\u001a\u0004\b3\u0010\nR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00101\u001a\u0004\b4\u0010\nR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00105\u001a\u0004\b6\u0010\u0013R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010/\u001a\u0004\b7\u0010\u0004R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010/\u001a\u0004\b8\u0010\u0004R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010/\u001a\u0004\b9\u0010\u0004R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010/\u001a\u0004\b:\u0010\u0004R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010/\u001a\u0004\b;\u0010\u0004R\u001c\u0010%\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010<\u001a\u0004\b=\u0010\rR\u001c\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010/\u001a\u0004\b>\u0010\u0004R\u001c\u0010$\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u00101\u001a\u0004\b?\u0010\nR\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010/\u001a\u0004\b@\u0010\u0004"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/CashierOrderGoodsResult;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "", "component13", "()Ljava/lang/Boolean;", "Lid/dana/cashier/data/repository/source/network/result/OrderCreateExtendInfoResult;", "component14", "()Lid/dana/cashier/data/repository/source/network/result/OrderCreateExtendInfoResult;", "component2", "component3", "component4", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component5", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component6", "component7", "component8", "component9", "category", "choosable", "chosen", "displayable", "goodsAmount", "goodsDescription", "goodsId", "goodsName", "goodsType", "goodsUnitType", FirebaseAnalytics.Param.QUANTITY, "toolTip", "stackInsurance", "orderCreateExtendInfoResult", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/cashier/data/repository/source/network/result/OrderCreateExtendInfoResult;)Lid/dana/cashier/data/repository/source/network/result/CashierOrderGoodsResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCategory", "Ljava/lang/Boolean;", "getChoosable", "getChosen", "getDisplayable", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getGoodsAmount", "getGoodsDescription", "getGoodsId", "getGoodsName", "getGoodsType", "getGoodsUnitType", "Lid/dana/cashier/data/repository/source/network/result/OrderCreateExtendInfoResult;", "getOrderCreateExtendInfoResult", "getQuantity", "getStackInsurance", "getToolTip", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/cashier/data/repository/source/network/result/OrderCreateExtendInfoResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierOrderGoodsResult {
    @SerializedName("category")
    private final String category;
    private final Boolean choosable;
    private final Boolean chosen;
    private final Boolean displayable;
    private final MoneyViewEntity goodsAmount;
    private final String goodsDescription;
    private final String goodsId;
    private final String goodsName;
    private final String goodsType;
    private final String goodsUnitType;
    @SerializedName("orderCreateExtendInfo")
    private final OrderCreateExtendInfoResult orderCreateExtendInfoResult;
    private final String quantity;
    private final Boolean stackInsurance;
    private final String toolTip;

    /* renamed from: component1  reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component10  reason: from getter */
    public final String getGoodsUnitType() {
        return this.goodsUnitType;
    }

    /* renamed from: component11  reason: from getter */
    public final String getQuantity() {
        return this.quantity;
    }

    /* renamed from: component12  reason: from getter */
    public final String getToolTip() {
        return this.toolTip;
    }

    /* renamed from: component13  reason: from getter */
    public final Boolean getStackInsurance() {
        return this.stackInsurance;
    }

    /* renamed from: component14  reason: from getter */
    public final OrderCreateExtendInfoResult getOrderCreateExtendInfoResult() {
        return this.orderCreateExtendInfoResult;
    }

    /* renamed from: component2  reason: from getter */
    public final Boolean getChoosable() {
        return this.choosable;
    }

    /* renamed from: component3  reason: from getter */
    public final Boolean getChosen() {
        return this.chosen;
    }

    /* renamed from: component4  reason: from getter */
    public final Boolean getDisplayable() {
        return this.displayable;
    }

    /* renamed from: component5  reason: from getter */
    public final MoneyViewEntity getGoodsAmount() {
        return this.goodsAmount;
    }

    /* renamed from: component6  reason: from getter */
    public final String getGoodsDescription() {
        return this.goodsDescription;
    }

    /* renamed from: component7  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    /* renamed from: component8  reason: from getter */
    public final String getGoodsName() {
        return this.goodsName;
    }

    /* renamed from: component9  reason: from getter */
    public final String getGoodsType() {
        return this.goodsType;
    }

    public final CashierOrderGoodsResult copy(String category, Boolean choosable, Boolean chosen, Boolean displayable, MoneyViewEntity goodsAmount, String goodsDescription, String goodsId, String goodsName, String goodsType, String goodsUnitType, String quantity, String toolTip, Boolean stackInsurance, OrderCreateExtendInfoResult orderCreateExtendInfoResult) {
        return new CashierOrderGoodsResult(category, choosable, chosen, displayable, goodsAmount, goodsDescription, goodsId, goodsName, goodsType, goodsUnitType, quantity, toolTip, stackInsurance, orderCreateExtendInfoResult);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierOrderGoodsResult) {
            CashierOrderGoodsResult cashierOrderGoodsResult = (CashierOrderGoodsResult) other;
            return Intrinsics.areEqual(this.category, cashierOrderGoodsResult.category) && Intrinsics.areEqual(this.choosable, cashierOrderGoodsResult.choosable) && Intrinsics.areEqual(this.chosen, cashierOrderGoodsResult.chosen) && Intrinsics.areEqual(this.displayable, cashierOrderGoodsResult.displayable) && Intrinsics.areEqual(this.goodsAmount, cashierOrderGoodsResult.goodsAmount) && Intrinsics.areEqual(this.goodsDescription, cashierOrderGoodsResult.goodsDescription) && Intrinsics.areEqual(this.goodsId, cashierOrderGoodsResult.goodsId) && Intrinsics.areEqual(this.goodsName, cashierOrderGoodsResult.goodsName) && Intrinsics.areEqual(this.goodsType, cashierOrderGoodsResult.goodsType) && Intrinsics.areEqual(this.goodsUnitType, cashierOrderGoodsResult.goodsUnitType) && Intrinsics.areEqual(this.quantity, cashierOrderGoodsResult.quantity) && Intrinsics.areEqual(this.toolTip, cashierOrderGoodsResult.toolTip) && Intrinsics.areEqual(this.stackInsurance, cashierOrderGoodsResult.stackInsurance) && Intrinsics.areEqual(this.orderCreateExtendInfoResult, cashierOrderGoodsResult.orderCreateExtendInfoResult);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.category;
        int hashCode = str == null ? 0 : str.hashCode();
        Boolean bool = this.choosable;
        int hashCode2 = bool == null ? 0 : bool.hashCode();
        Boolean bool2 = this.chosen;
        int hashCode3 = bool2 == null ? 0 : bool2.hashCode();
        Boolean bool3 = this.displayable;
        int hashCode4 = bool3 == null ? 0 : bool3.hashCode();
        MoneyViewEntity moneyViewEntity = this.goodsAmount;
        int hashCode5 = moneyViewEntity == null ? 0 : moneyViewEntity.hashCode();
        String str2 = this.goodsDescription;
        int hashCode6 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.goodsId;
        int hashCode7 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.goodsName;
        int hashCode8 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.goodsType;
        int hashCode9 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.goodsUnitType;
        int hashCode10 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.quantity;
        int hashCode11 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.toolTip;
        int hashCode12 = str8 == null ? 0 : str8.hashCode();
        Boolean bool4 = this.stackInsurance;
        int hashCode13 = bool4 == null ? 0 : bool4.hashCode();
        OrderCreateExtendInfoResult orderCreateExtendInfoResult = this.orderCreateExtendInfoResult;
        return (((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + (orderCreateExtendInfoResult != null ? orderCreateExtendInfoResult.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierOrderGoodsResult(category=");
        sb.append(this.category);
        sb.append(", choosable=");
        sb.append(this.choosable);
        sb.append(", chosen=");
        sb.append(this.chosen);
        sb.append(", displayable=");
        sb.append(this.displayable);
        sb.append(", goodsAmount=");
        sb.append(this.goodsAmount);
        sb.append(", goodsDescription=");
        sb.append(this.goodsDescription);
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", goodsName=");
        sb.append(this.goodsName);
        sb.append(", goodsType=");
        sb.append(this.goodsType);
        sb.append(", goodsUnitType=");
        sb.append(this.goodsUnitType);
        sb.append(", quantity=");
        sb.append(this.quantity);
        sb.append(", toolTip=");
        sb.append(this.toolTip);
        sb.append(", stackInsurance=");
        sb.append(this.stackInsurance);
        sb.append(", orderCreateExtendInfoResult=");
        sb.append(this.orderCreateExtendInfoResult);
        sb.append(')');
        return sb.toString();
    }

    public CashierOrderGoodsResult(String str, Boolean bool, Boolean bool2, Boolean bool3, MoneyViewEntity moneyViewEntity, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool4, OrderCreateExtendInfoResult orderCreateExtendInfoResult) {
        this.category = str;
        this.choosable = bool;
        this.chosen = bool2;
        this.displayable = bool3;
        this.goodsAmount = moneyViewEntity;
        this.goodsDescription = str2;
        this.goodsId = str3;
        this.goodsName = str4;
        this.goodsType = str5;
        this.goodsUnitType = str6;
        this.quantity = str7;
        this.toolTip = str8;
        this.stackInsurance = bool4;
        this.orderCreateExtendInfoResult = orderCreateExtendInfoResult;
    }

    public /* synthetic */ CashierOrderGoodsResult(String str, Boolean bool, Boolean bool2, Boolean bool3, MoneyViewEntity moneyViewEntity, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool4, OrderCreateExtendInfoResult orderCreateExtendInfoResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bool, bool2, bool3, moneyViewEntity, str2, str3, str4, str5, str6, str7, str8, bool4, (i & 8192) != 0 ? null : orderCreateExtendInfoResult);
    }

    @JvmName(name = "getCategory")
    public final String getCategory() {
        return this.category;
    }

    @JvmName(name = "getChoosable")
    public final Boolean getChoosable() {
        return this.choosable;
    }

    @JvmName(name = "getChosen")
    public final Boolean getChosen() {
        return this.chosen;
    }

    @JvmName(name = "getDisplayable")
    public final Boolean getDisplayable() {
        return this.displayable;
    }

    @JvmName(name = "getGoodsAmount")
    public final MoneyViewEntity getGoodsAmount() {
        return this.goodsAmount;
    }

    @JvmName(name = "getGoodsDescription")
    public final String getGoodsDescription() {
        return this.goodsDescription;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getGoodsName")
    public final String getGoodsName() {
        return this.goodsName;
    }

    @JvmName(name = "getGoodsType")
    public final String getGoodsType() {
        return this.goodsType;
    }

    @JvmName(name = "getGoodsUnitType")
    public final String getGoodsUnitType() {
        return this.goodsUnitType;
    }

    @JvmName(name = "getQuantity")
    public final String getQuantity() {
        return this.quantity;
    }

    @JvmName(name = "getToolTip")
    public final String getToolTip() {
        return this.toolTip;
    }

    @JvmName(name = "getStackInsurance")
    public final Boolean getStackInsurance() {
        return this.stackInsurance;
    }

    @JvmName(name = "getOrderCreateExtendInfoResult")
    public final OrderCreateExtendInfoResult getOrderCreateExtendInfoResult() {
        return this.orderCreateExtendInfoResult;
    }
}
