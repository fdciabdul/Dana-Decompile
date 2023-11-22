package id.dana.domain.promoquest.model;

import id.dana.domain.user.CurrencyAmount;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b3\u00104J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004Jd\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004\"\u0004\b \u0010!R\u0011\u0010$\u001a\u00020\u00178G¢\u0006\u0006\u001a\u0004\b\"\u0010#R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001e\u001a\u0004\b%\u0010\u0004\"\u0004\b&\u0010!R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b'\u0010\u0004\"\u0004\b(\u0010!R$\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010)\u001a\u0004\b*\u0010\t\"\u0004\b+\u0010,R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b-\u0010\u0004\"\u0004\b.\u0010!R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b/\u0010\u0004\"\u0004\b0\u0010!R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b1\u0010\u0004\"\u0004\b2\u0010!"}, d2 = {"Lid/dana/domain/promoquest/model/PrizeInfoEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lid/dana/domain/user/CurrencyAmount;", "component4", "()Lid/dana/domain/user/CurrencyAmount;", "component5", "component6", "component7", "prizeAwardOrderId", "bizNo", "prizeId", "prizeMoneyAmount", "prizeType", "voucherId", "voucherName", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/user/CurrencyAmount;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/promoquest/model/PrizeInfoEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizNo", "setBizNo", "(Ljava/lang/String;)V", "getHasVoucher", "()Z", "hasVoucher", "getPrizeAwardOrderId", "setPrizeAwardOrderId", "getPrizeId", "setPrizeId", "Lid/dana/domain/user/CurrencyAmount;", "getPrizeMoneyAmount", "setPrizeMoneyAmount", "(Lid/dana/domain/user/CurrencyAmount;)V", "getPrizeType", "setPrizeType", "getVoucherId", "setVoucherId", "getVoucherName", "setVoucherName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/user/CurrencyAmount;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PrizeInfoEntity {
    private String bizNo;
    private String prizeAwardOrderId;
    private String prizeId;
    private CurrencyAmount prizeMoneyAmount;
    private String prizeType;
    private String voucherId;
    private String voucherName;

    public PrizeInfoEntity() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ PrizeInfoEntity copy$default(PrizeInfoEntity prizeInfoEntity, String str, String str2, String str3, CurrencyAmount currencyAmount, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = prizeInfoEntity.prizeAwardOrderId;
        }
        if ((i & 2) != 0) {
            str2 = prizeInfoEntity.bizNo;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = prizeInfoEntity.prizeId;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            currencyAmount = prizeInfoEntity.prizeMoneyAmount;
        }
        CurrencyAmount currencyAmount2 = currencyAmount;
        if ((i & 16) != 0) {
            str4 = prizeInfoEntity.prizeType;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = prizeInfoEntity.voucherId;
        }
        String str10 = str5;
        if ((i & 64) != 0) {
            str6 = prizeInfoEntity.voucherName;
        }
        return prizeInfoEntity.copy(str, str7, str8, currencyAmount2, str9, str10, str6);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPrizeAwardOrderId() {
        return this.prizeAwardOrderId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getBizNo() {
        return this.bizNo;
    }

    /* renamed from: component3  reason: from getter */
    public final String getPrizeId() {
        return this.prizeId;
    }

    /* renamed from: component4  reason: from getter */
    public final CurrencyAmount getPrizeMoneyAmount() {
        return this.prizeMoneyAmount;
    }

    /* renamed from: component5  reason: from getter */
    public final String getPrizeType() {
        return this.prizeType;
    }

    /* renamed from: component6  reason: from getter */
    public final String getVoucherId() {
        return this.voucherId;
    }

    /* renamed from: component7  reason: from getter */
    public final String getVoucherName() {
        return this.voucherName;
    }

    public final PrizeInfoEntity copy(String prizeAwardOrderId, String bizNo, String prizeId, CurrencyAmount prizeMoneyAmount, String prizeType, String voucherId, String voucherName) {
        return new PrizeInfoEntity(prizeAwardOrderId, bizNo, prizeId, prizeMoneyAmount, prizeType, voucherId, voucherName);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PrizeInfoEntity) {
            PrizeInfoEntity prizeInfoEntity = (PrizeInfoEntity) other;
            return Intrinsics.areEqual(this.prizeAwardOrderId, prizeInfoEntity.prizeAwardOrderId) && Intrinsics.areEqual(this.bizNo, prizeInfoEntity.bizNo) && Intrinsics.areEqual(this.prizeId, prizeInfoEntity.prizeId) && Intrinsics.areEqual(this.prizeMoneyAmount, prizeInfoEntity.prizeMoneyAmount) && Intrinsics.areEqual(this.prizeType, prizeInfoEntity.prizeType) && Intrinsics.areEqual(this.voucherId, prizeInfoEntity.voucherId) && Intrinsics.areEqual(this.voucherName, prizeInfoEntity.voucherName);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.prizeAwardOrderId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.bizNo;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.prizeId;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        CurrencyAmount currencyAmount = this.prizeMoneyAmount;
        int hashCode4 = currencyAmount == null ? 0 : currencyAmount.hashCode();
        String str4 = this.prizeType;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.voucherId;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.voucherName;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (str6 != null ? str6.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PrizeInfoEntity(prizeAwardOrderId=");
        sb.append(this.prizeAwardOrderId);
        sb.append(", bizNo=");
        sb.append(this.bizNo);
        sb.append(", prizeId=");
        sb.append(this.prizeId);
        sb.append(", prizeMoneyAmount=");
        sb.append(this.prizeMoneyAmount);
        sb.append(", prizeType=");
        sb.append(this.prizeType);
        sb.append(", voucherId=");
        sb.append(this.voucherId);
        sb.append(", voucherName=");
        sb.append(this.voucherName);
        sb.append(')');
        return sb.toString();
    }

    public PrizeInfoEntity(String str, String str2, String str3, CurrencyAmount currencyAmount, String str4, String str5, String str6) {
        this.prizeAwardOrderId = str;
        this.bizNo = str2;
        this.prizeId = str3;
        this.prizeMoneyAmount = currencyAmount;
        this.prizeType = str4;
        this.voucherId = str5;
        this.voucherName = str6;
    }

    public /* synthetic */ PrizeInfoEntity(String str, String str2, String str3, CurrencyAmount currencyAmount, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : currencyAmount, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6);
    }

    @JvmName(name = "getPrizeAwardOrderId")
    public final String getPrizeAwardOrderId() {
        return this.prizeAwardOrderId;
    }

    @JvmName(name = "setPrizeAwardOrderId")
    public final void setPrizeAwardOrderId(String str) {
        this.prizeAwardOrderId = str;
    }

    @JvmName(name = "getBizNo")
    public final String getBizNo() {
        return this.bizNo;
    }

    @JvmName(name = "setBizNo")
    public final void setBizNo(String str) {
        this.bizNo = str;
    }

    @JvmName(name = "getPrizeId")
    public final String getPrizeId() {
        return this.prizeId;
    }

    @JvmName(name = "setPrizeId")
    public final void setPrizeId(String str) {
        this.prizeId = str;
    }

    @JvmName(name = "getPrizeMoneyAmount")
    public final CurrencyAmount getPrizeMoneyAmount() {
        return this.prizeMoneyAmount;
    }

    @JvmName(name = "setPrizeMoneyAmount")
    public final void setPrizeMoneyAmount(CurrencyAmount currencyAmount) {
        this.prizeMoneyAmount = currencyAmount;
    }

    @JvmName(name = "getPrizeType")
    public final String getPrizeType() {
        return this.prizeType;
    }

    @JvmName(name = "setPrizeType")
    public final void setPrizeType(String str) {
        this.prizeType = str;
    }

    @JvmName(name = "getVoucherId")
    public final String getVoucherId() {
        return this.voucherId;
    }

    @JvmName(name = "setVoucherId")
    public final void setVoucherId(String str) {
        this.voucherId = str;
    }

    @JvmName(name = "getVoucherName")
    public final String getVoucherName() {
        return this.voucherName;
    }

    @JvmName(name = "setVoucherName")
    public final void setVoucherName(String str) {
        this.voucherName = str;
    }

    @JvmName(name = "getHasVoucher")
    public final boolean getHasVoucher() {
        return Intrinsics.areEqual(this.prizeType, PrizeType.CASHCOUPON) || Intrinsics.areEqual(this.prizeType, PrizeType.DISCOUNTCOUPON);
    }
}
