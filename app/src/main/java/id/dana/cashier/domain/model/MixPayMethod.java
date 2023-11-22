package id.dana.cashier.domain.model;

import id.dana.data.encryptcardno.CardCredInfo;
import id.dana.wallet_v3.constant.WalletConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004JÀ\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010'\u001a\u00020\u00112\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010*\u001a\u00020)HÖ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b,\u0010\u0004R\u0019\u0010!\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b!\u0010-\u001a\u0004\b.\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010-\u001a\u0004\b/\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b0\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b1\u0010\u0004R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010-\u001a\u0004\b2\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010-\u001a\u0004\b3\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010-\u001a\u0004\b4\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010-\u001a\u0004\b5\u0010\u0004R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010-\u001a\u0004\b6\u0010\u0004R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010-\u001a\u0004\b7\u0010\u0004R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010-\u001a\u0004\b8\u0010\u0004R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010-\u001a\u0004\b9\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010-\u001a\u0004\b:\u0010\u0004R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010;\u001a\u0004\b<\u0010\u0013R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010-\u001a\u0004\b=\u0010\u0004"}, d2 = {"Lid/dana/cashier/domain/model/MixPayMethod;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "", "component8", "()Ljava/lang/Boolean;", "component9", "payMethod", "channelIndex", "bindingId", CardCredInfo.CARD_NO, "cvv2", CardCredInfo.CARD_EXPIRE_MONTH, CardCredInfo.CARD_EXPIRE_YEAR, "saveCard", WalletConstant.CARD_INDEX_NO, "deviceId", "limitMaximum", "maskedCardNo", "bankPhoneNo", "instCode", "xcoId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/domain/model/MixPayMethod;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBankPhoneNo", "getBindingId", "getCardExpireMonth", "getCardExpireYear", "getCardIndexNo", "getCardNo", "getChannelIndex", "getCvv2", "getDeviceId", "getInstCode", "getLimitMaximum", "getMaskedCardNo", "getPayMethod", "Ljava/lang/Boolean;", "getSaveCard", "getXcoId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MixPayMethod {
    private final String bankPhoneNo;
    private final String bindingId;
    private final String cardExpireMonth;
    private final String cardExpireYear;
    private final String cardIndexNo;
    private final String cardNo;
    private final String channelIndex;
    private final String cvv2;
    private final String deviceId;
    private final String instCode;
    private final String limitMaximum;
    private final String maskedCardNo;
    private final String payMethod;
    private final Boolean saveCard;
    private final String xcoId;

    /* renamed from: component1  reason: from getter */
    public final String getPayMethod() {
        return this.payMethod;
    }

    /* renamed from: component10  reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component11  reason: from getter */
    public final String getLimitMaximum() {
        return this.limitMaximum;
    }

    /* renamed from: component12  reason: from getter */
    public final String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    /* renamed from: component13  reason: from getter */
    public final String getBankPhoneNo() {
        return this.bankPhoneNo;
    }

    /* renamed from: component14  reason: from getter */
    public final String getInstCode() {
        return this.instCode;
    }

    /* renamed from: component15  reason: from getter */
    public final String getXcoId() {
        return this.xcoId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getChannelIndex() {
        return this.channelIndex;
    }

    /* renamed from: component3  reason: from getter */
    public final String getBindingId() {
        return this.bindingId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCardNo() {
        return this.cardNo;
    }

    /* renamed from: component5  reason: from getter */
    public final String getCvv2() {
        return this.cvv2;
    }

    /* renamed from: component6  reason: from getter */
    public final String getCardExpireMonth() {
        return this.cardExpireMonth;
    }

    /* renamed from: component7  reason: from getter */
    public final String getCardExpireYear() {
        return this.cardExpireYear;
    }

    /* renamed from: component8  reason: from getter */
    public final Boolean getSaveCard() {
        return this.saveCard;
    }

    /* renamed from: component9  reason: from getter */
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    public final MixPayMethod copy(String payMethod, String channelIndex, String bindingId, String cardNo, String cvv2, String cardExpireMonth, String cardExpireYear, Boolean saveCard, String cardIndexNo, String deviceId, String limitMaximum, String maskedCardNo, String bankPhoneNo, String instCode, String xcoId) {
        Intrinsics.checkNotNullParameter(payMethod, "");
        Intrinsics.checkNotNullParameter(channelIndex, "");
        return new MixPayMethod(payMethod, channelIndex, bindingId, cardNo, cvv2, cardExpireMonth, cardExpireYear, saveCard, cardIndexNo, deviceId, limitMaximum, maskedCardNo, bankPhoneNo, instCode, xcoId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MixPayMethod) {
            MixPayMethod mixPayMethod = (MixPayMethod) other;
            return Intrinsics.areEqual(this.payMethod, mixPayMethod.payMethod) && Intrinsics.areEqual(this.channelIndex, mixPayMethod.channelIndex) && Intrinsics.areEqual(this.bindingId, mixPayMethod.bindingId) && Intrinsics.areEqual(this.cardNo, mixPayMethod.cardNo) && Intrinsics.areEqual(this.cvv2, mixPayMethod.cvv2) && Intrinsics.areEqual(this.cardExpireMonth, mixPayMethod.cardExpireMonth) && Intrinsics.areEqual(this.cardExpireYear, mixPayMethod.cardExpireYear) && Intrinsics.areEqual(this.saveCard, mixPayMethod.saveCard) && Intrinsics.areEqual(this.cardIndexNo, mixPayMethod.cardIndexNo) && Intrinsics.areEqual(this.deviceId, mixPayMethod.deviceId) && Intrinsics.areEqual(this.limitMaximum, mixPayMethod.limitMaximum) && Intrinsics.areEqual(this.maskedCardNo, mixPayMethod.maskedCardNo) && Intrinsics.areEqual(this.bankPhoneNo, mixPayMethod.bankPhoneNo) && Intrinsics.areEqual(this.instCode, mixPayMethod.instCode) && Intrinsics.areEqual(this.xcoId, mixPayMethod.xcoId);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.payMethod.hashCode();
        int hashCode2 = this.channelIndex.hashCode();
        String str = this.bindingId;
        int hashCode3 = str == null ? 0 : str.hashCode();
        String str2 = this.cardNo;
        int hashCode4 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.cvv2;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.cardExpireMonth;
        int hashCode6 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.cardExpireYear;
        int hashCode7 = str5 == null ? 0 : str5.hashCode();
        Boolean bool = this.saveCard;
        int hashCode8 = bool == null ? 0 : bool.hashCode();
        String str6 = this.cardIndexNo;
        int hashCode9 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.deviceId;
        int hashCode10 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.limitMaximum;
        int hashCode11 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.maskedCardNo;
        int hashCode12 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.bankPhoneNo;
        int hashCode13 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.instCode;
        int hashCode14 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.xcoId;
        return (((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + (str12 != null ? str12.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MixPayMethod(payMethod=");
        sb.append(this.payMethod);
        sb.append(", channelIndex=");
        sb.append(this.channelIndex);
        sb.append(", bindingId=");
        sb.append(this.bindingId);
        sb.append(", cardNo=");
        sb.append(this.cardNo);
        sb.append(", cvv2=");
        sb.append(this.cvv2);
        sb.append(", cardExpireMonth=");
        sb.append(this.cardExpireMonth);
        sb.append(", cardExpireYear=");
        sb.append(this.cardExpireYear);
        sb.append(", saveCard=");
        sb.append(this.saveCard);
        sb.append(", cardIndexNo=");
        sb.append(this.cardIndexNo);
        sb.append(", deviceId=");
        sb.append(this.deviceId);
        sb.append(", limitMaximum=");
        sb.append(this.limitMaximum);
        sb.append(", maskedCardNo=");
        sb.append(this.maskedCardNo);
        sb.append(", bankPhoneNo=");
        sb.append(this.bankPhoneNo);
        sb.append(", instCode=");
        sb.append(this.instCode);
        sb.append(", xcoId=");
        sb.append(this.xcoId);
        sb.append(')');
        return sb.toString();
    }

    public MixPayMethod(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.payMethod = str;
        this.channelIndex = str2;
        this.bindingId = str3;
        this.cardNo = str4;
        this.cvv2 = str5;
        this.cardExpireMonth = str6;
        this.cardExpireYear = str7;
        this.saveCard = bool;
        this.cardIndexNo = str8;
        this.deviceId = str9;
        this.limitMaximum = str10;
        this.maskedCardNo = str11;
        this.bankPhoneNo = str12;
        this.instCode = str13;
        this.xcoId = str14;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "getChannelIndex")
    public final String getChannelIndex() {
        return this.channelIndex;
    }

    @JvmName(name = "getBindingId")
    public final String getBindingId() {
        return this.bindingId;
    }

    @JvmName(name = "getCardNo")
    public final String getCardNo() {
        return this.cardNo;
    }

    @JvmName(name = "getCvv2")
    public final String getCvv2() {
        return this.cvv2;
    }

    @JvmName(name = "getCardExpireMonth")
    public final String getCardExpireMonth() {
        return this.cardExpireMonth;
    }

    @JvmName(name = "getCardExpireYear")
    public final String getCardExpireYear() {
        return this.cardExpireYear;
    }

    @JvmName(name = "getSaveCard")
    public final Boolean getSaveCard() {
        return this.saveCard;
    }

    @JvmName(name = "getCardIndexNo")
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    @JvmName(name = "getDeviceId")
    public final String getDeviceId() {
        return this.deviceId;
    }

    @JvmName(name = "getLimitMaximum")
    public final String getLimitMaximum() {
        return this.limitMaximum;
    }

    @JvmName(name = "getMaskedCardNo")
    public final String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    @JvmName(name = "getBankPhoneNo")
    public final String getBankPhoneNo() {
        return this.bankPhoneNo;
    }

    @JvmName(name = "getInstCode")
    public final String getInstCode() {
        return this.instCode;
    }

    @JvmName(name = "getXcoId")
    public final String getXcoId() {
        return this.xcoId;
    }
}
