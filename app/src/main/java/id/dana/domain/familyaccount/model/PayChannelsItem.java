package id.dana.domain.familyaccount.model;

import id.dana.domain.nearbyme.model.MoneyView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ@\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b \u0010\u0004"}, d2 = {"Lid/dana/domain/familyaccount/model/PayChannelsItem;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lid/dana/domain/nearbyme/model/MoneyView;", "component3", "()Lid/dana/domain/nearbyme/model/MoneyView;", "Lid/dana/domain/familyaccount/model/ExtendInfo;", "component4", "()Lid/dana/domain/familyaccount/model/ExtendInfo;", "payMethod", "payOption", "chargeAmount", "extendInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/familyaccount/model/ExtendInfo;)Lid/dana/domain/familyaccount/model/PayChannelsItem;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/domain/nearbyme/model/MoneyView;", "getChargeAmount", "Lid/dana/domain/familyaccount/model/ExtendInfo;", "getExtendInfo", "Ljava/lang/String;", "getPayMethod", "getPayOption", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/familyaccount/model/ExtendInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PayChannelsItem {
    private final MoneyView chargeAmount;
    private final ExtendInfo extendInfo;
    private final String payMethod;
    private final String payOption;

    public PayChannelsItem() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ PayChannelsItem copy$default(PayChannelsItem payChannelsItem, String str, String str2, MoneyView moneyView, ExtendInfo extendInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payChannelsItem.payMethod;
        }
        if ((i & 2) != 0) {
            str2 = payChannelsItem.payOption;
        }
        if ((i & 4) != 0) {
            moneyView = payChannelsItem.chargeAmount;
        }
        if ((i & 8) != 0) {
            extendInfo = payChannelsItem.extendInfo;
        }
        return payChannelsItem.copy(str, str2, moneyView, extendInfo);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPayMethod() {
        return this.payMethod;
    }

    /* renamed from: component2  reason: from getter */
    public final String getPayOption() {
        return this.payOption;
    }

    /* renamed from: component3  reason: from getter */
    public final MoneyView getChargeAmount() {
        return this.chargeAmount;
    }

    /* renamed from: component4  reason: from getter */
    public final ExtendInfo getExtendInfo() {
        return this.extendInfo;
    }

    public final PayChannelsItem copy(String payMethod, String payOption, MoneyView chargeAmount, ExtendInfo extendInfo) {
        return new PayChannelsItem(payMethod, payOption, chargeAmount, extendInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PayChannelsItem) {
            PayChannelsItem payChannelsItem = (PayChannelsItem) other;
            return Intrinsics.areEqual(this.payMethod, payChannelsItem.payMethod) && Intrinsics.areEqual(this.payOption, payChannelsItem.payOption) && Intrinsics.areEqual(this.chargeAmount, payChannelsItem.chargeAmount) && Intrinsics.areEqual(this.extendInfo, payChannelsItem.extendInfo);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.payMethod;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.payOption;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        MoneyView moneyView = this.chargeAmount;
        int hashCode3 = moneyView == null ? 0 : moneyView.hashCode();
        ExtendInfo extendInfo = this.extendInfo;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (extendInfo != null ? extendInfo.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PayChannelsItem(payMethod=");
        sb.append(this.payMethod);
        sb.append(", payOption=");
        sb.append(this.payOption);
        sb.append(", chargeAmount=");
        sb.append(this.chargeAmount);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(')');
        return sb.toString();
    }

    public PayChannelsItem(String str, String str2, MoneyView moneyView, ExtendInfo extendInfo) {
        this.payMethod = str;
        this.payOption = str2;
        this.chargeAmount = moneyView;
        this.extendInfo = extendInfo;
    }

    public /* synthetic */ PayChannelsItem(String str, String str2, MoneyView moneyView, ExtendInfo extendInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : moneyView, (i & 8) != 0 ? null : extendInfo);
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "getPayOption")
    public final String getPayOption() {
        return this.payOption;
    }

    @JvmName(name = "getChargeAmount")
    public final MoneyView getChargeAmount() {
        return this.chargeAmount;
    }

    @JvmName(name = "getExtendInfo")
    public final ExtendInfo getExtendInfo() {
        return this.extendInfo;
    }
}
