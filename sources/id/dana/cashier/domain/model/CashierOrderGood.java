package id.dana.cashier.domain.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.domain.nearbyme.model.MoneyView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b,\u0010-R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006R\u001c\u0010(\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\t\u001a\u0004\b)\u0010\u000bR\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/model/CashierOrderGood;", "", "", "category", "Ljava/lang/String;", "getCategory", "()Ljava/lang/String;", "", "choosable", "Ljava/lang/Boolean;", "getChoosable", "()Ljava/lang/Boolean;", "chosen", "getChosen", "displayable", "getDisplayable", "Lid/dana/domain/nearbyme/model/MoneyView;", "goodsAmount", "Lid/dana/domain/nearbyme/model/MoneyView;", "getGoodsAmount", "()Lid/dana/domain/nearbyme/model/MoneyView;", "goodsDescription", "getGoodsDescription", "goodsId", "getGoodsId", "goodsName", "getGoodsName", "goodsType", "getGoodsType", "goodsUnitType", "getGoodsUnitType", "Lid/dana/cashier/domain/model/OrderCreateExtendInfo;", "orderCreateExtendInfo", "Lid/dana/cashier/domain/model/OrderCreateExtendInfo;", "getOrderCreateExtendInfo", "()Lid/dana/cashier/domain/model/OrderCreateExtendInfo;", "setOrderCreateExtendInfo", "(Lid/dana/cashier/domain/model/OrderCreateExtendInfo;)V", FirebaseAnalytics.Param.QUANTITY, "getQuantity", "stackInsurance", "getStackInsurance", "toolTip", "getToolTip", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/cashier/domain/model/OrderCreateExtendInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierOrderGood {
    private final String category;
    private final Boolean choosable;
    private final Boolean chosen;
    private final Boolean displayable;
    private final MoneyView goodsAmount;
    private final String goodsDescription;
    private final String goodsId;
    private final String goodsName;
    private final String goodsType;
    private final String goodsUnitType;
    private OrderCreateExtendInfo orderCreateExtendInfo;
    private final String quantity;
    private final Boolean stackInsurance;
    private final String toolTip;

    public CashierOrderGood(String str, Boolean bool, Boolean bool2, Boolean bool3, MoneyView moneyView, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool4, OrderCreateExtendInfo orderCreateExtendInfo) {
        this.category = str;
        this.choosable = bool;
        this.chosen = bool2;
        this.displayable = bool3;
        this.goodsAmount = moneyView;
        this.goodsDescription = str2;
        this.goodsId = str3;
        this.goodsName = str4;
        this.goodsType = str5;
        this.goodsUnitType = str6;
        this.quantity = str7;
        this.toolTip = str8;
        this.stackInsurance = bool4;
        this.orderCreateExtendInfo = orderCreateExtendInfo;
    }

    public /* synthetic */ CashierOrderGood(String str, Boolean bool, Boolean bool2, Boolean bool3, MoneyView moneyView, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool4, OrderCreateExtendInfo orderCreateExtendInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bool, bool2, bool3, moneyView, str2, str3, str4, str5, str6, str7, str8, bool4, (i & 8192) != 0 ? null : orderCreateExtendInfo);
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
    public final MoneyView getGoodsAmount() {
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

    @JvmName(name = "getOrderCreateExtendInfo")
    public final OrderCreateExtendInfo getOrderCreateExtendInfo() {
        return this.orderCreateExtendInfo;
    }

    @JvmName(name = "setOrderCreateExtendInfo")
    public final void setOrderCreateExtendInfo(OrderCreateExtendInfo orderCreateExtendInfo) {
        this.orderCreateExtendInfo = orderCreateExtendInfo;
    }
}
