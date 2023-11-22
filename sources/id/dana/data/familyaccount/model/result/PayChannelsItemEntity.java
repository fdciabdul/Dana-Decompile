package id.dana.data.familyaccount.model.result;

import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ@\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b \u0010\u0004"}, d2 = {"Lid/dana/data/familyaccount/model/result/PayChannelsItemEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component3", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "Lid/dana/data/familyaccount/model/result/ExtendInfoEntity;", "component4", "()Lid/dana/data/familyaccount/model/result/ExtendInfoEntity;", "payMethod", "payOption", "chargeAmountEntity", "extendInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/data/familyaccount/model/result/ExtendInfoEntity;)Lid/dana/data/familyaccount/model/result/PayChannelsItemEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getChargeAmountEntity", "Lid/dana/data/familyaccount/model/result/ExtendInfoEntity;", "getExtendInfo", "Ljava/lang/String;", "getPayMethod", "getPayOption", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/data/familyaccount/model/result/ExtendInfoEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PayChannelsItemEntity {
    private final MoneyViewEntity chargeAmountEntity;
    private final ExtendInfoEntity extendInfo;
    private final String payMethod;
    private final String payOption;

    public PayChannelsItemEntity() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ PayChannelsItemEntity copy$default(PayChannelsItemEntity payChannelsItemEntity, String str, String str2, MoneyViewEntity moneyViewEntity, ExtendInfoEntity extendInfoEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payChannelsItemEntity.payMethod;
        }
        if ((i & 2) != 0) {
            str2 = payChannelsItemEntity.payOption;
        }
        if ((i & 4) != 0) {
            moneyViewEntity = payChannelsItemEntity.chargeAmountEntity;
        }
        if ((i & 8) != 0) {
            extendInfoEntity = payChannelsItemEntity.extendInfo;
        }
        return payChannelsItemEntity.copy(str, str2, moneyViewEntity, extendInfoEntity);
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
    public final MoneyViewEntity getChargeAmountEntity() {
        return this.chargeAmountEntity;
    }

    /* renamed from: component4  reason: from getter */
    public final ExtendInfoEntity getExtendInfo() {
        return this.extendInfo;
    }

    public final PayChannelsItemEntity copy(String payMethod, String payOption, MoneyViewEntity chargeAmountEntity, ExtendInfoEntity extendInfo) {
        return new PayChannelsItemEntity(payMethod, payOption, chargeAmountEntity, extendInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PayChannelsItemEntity) {
            PayChannelsItemEntity payChannelsItemEntity = (PayChannelsItemEntity) other;
            return Intrinsics.areEqual(this.payMethod, payChannelsItemEntity.payMethod) && Intrinsics.areEqual(this.payOption, payChannelsItemEntity.payOption) && Intrinsics.areEqual(this.chargeAmountEntity, payChannelsItemEntity.chargeAmountEntity) && Intrinsics.areEqual(this.extendInfo, payChannelsItemEntity.extendInfo);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.payMethod;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.payOption;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        MoneyViewEntity moneyViewEntity = this.chargeAmountEntity;
        int hashCode3 = moneyViewEntity == null ? 0 : moneyViewEntity.hashCode();
        ExtendInfoEntity extendInfoEntity = this.extendInfo;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (extendInfoEntity != null ? extendInfoEntity.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PayChannelsItemEntity(payMethod=");
        sb.append(this.payMethod);
        sb.append(", payOption=");
        sb.append(this.payOption);
        sb.append(", chargeAmountEntity=");
        sb.append(this.chargeAmountEntity);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(')');
        return sb.toString();
    }

    public PayChannelsItemEntity(String str, String str2, MoneyViewEntity moneyViewEntity, ExtendInfoEntity extendInfoEntity) {
        this.payMethod = str;
        this.payOption = str2;
        this.chargeAmountEntity = moneyViewEntity;
        this.extendInfo = extendInfoEntity;
    }

    public /* synthetic */ PayChannelsItemEntity(String str, String str2, MoneyViewEntity moneyViewEntity, ExtendInfoEntity extendInfoEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : moneyViewEntity, (i & 8) != 0 ? null : extendInfoEntity);
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "getPayOption")
    public final String getPayOption() {
        return this.payOption;
    }

    @JvmName(name = "getChargeAmountEntity")
    public final MoneyViewEntity getChargeAmountEntity() {
        return this.chargeAmountEntity;
    }

    @JvmName(name = "getExtendInfo")
    public final ExtendInfoEntity getExtendInfo() {
        return this.extendInfo;
    }
}
