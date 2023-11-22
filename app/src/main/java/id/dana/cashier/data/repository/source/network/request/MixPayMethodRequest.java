package id.dana.cashier.data.repository.source.network.request;

import com.google.gson.annotations.SerializedName;
import id.dana.wallet_v3.constant.WalletConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b5\u00106J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u009c\u0001\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b&\u0010\u0004R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u001b\u0010'\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b+\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010'\u001a\u0004\b.\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b/\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b0\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010'\u001a\u0004\b1\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u00102\u001a\u0004\b3\u0010\fR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010'\u001a\u0004\b4\u0010\u0004"}, d2 = {"Lid/dana/cashier/data/repository/source/network/request/MixPayMethodRequest;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component2", "component3", "", "component4", "()Ljava/lang/Boolean;", "component5", "component6", "component7", "component8", "component9", "payMethod", "channelIndex", "bindingId", "saveCard", WalletConstant.CARD_INDEX_NO, "cardCredential", "deviceId", "limitMaximum", "maskedCardNo", "bankPhoneNo", "instCode", "xcoId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/data/repository/source/network/request/MixPayMethodRequest;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBankPhoneNo", "getBindingId", "getCardCredential", "getCardIndexNo", "getChannelIndex", "getDeviceId", "getInstCode", "getLimitMaximum", "getMaskedCardNo", "getPayMethod", "Ljava/lang/Boolean;", "getSaveCard", "getXcoId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MixPayMethodRequest {
    private final String bankPhoneNo;
    private final String bindingId;
    private final String cardCredential;
    private final String cardIndexNo;
    private final String channelIndex;
    private final String deviceId;
    private final String instCode;
    private final String limitMaximum;
    private final String maskedCardNo;
    @SerializedName("payMethod")
    private final String payMethod;
    private final Boolean saveCard;
    private final String xcoId;

    /* renamed from: component1  reason: from getter */
    public final String getPayMethod() {
        return this.payMethod;
    }

    /* renamed from: component10  reason: from getter */
    public final String getBankPhoneNo() {
        return this.bankPhoneNo;
    }

    /* renamed from: component11  reason: from getter */
    public final String getInstCode() {
        return this.instCode;
    }

    /* renamed from: component12  reason: from getter */
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
    public final Boolean getSaveCard() {
        return this.saveCard;
    }

    /* renamed from: component5  reason: from getter */
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    /* renamed from: component6  reason: from getter */
    public final String getCardCredential() {
        return this.cardCredential;
    }

    /* renamed from: component7  reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component8  reason: from getter */
    public final String getLimitMaximum() {
        return this.limitMaximum;
    }

    /* renamed from: component9  reason: from getter */
    public final String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    public final MixPayMethodRequest copy(String payMethod, String channelIndex, String bindingId, Boolean saveCard, String cardIndexNo, String cardCredential, String deviceId, String limitMaximum, String maskedCardNo, String bankPhoneNo, String instCode, String xcoId) {
        Intrinsics.checkNotNullParameter(payMethod, "");
        Intrinsics.checkNotNullParameter(channelIndex, "");
        return new MixPayMethodRequest(payMethod, channelIndex, bindingId, saveCard, cardIndexNo, cardCredential, deviceId, limitMaximum, maskedCardNo, bankPhoneNo, instCode, xcoId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MixPayMethodRequest) {
            MixPayMethodRequest mixPayMethodRequest = (MixPayMethodRequest) other;
            return Intrinsics.areEqual(this.payMethod, mixPayMethodRequest.payMethod) && Intrinsics.areEqual(this.channelIndex, mixPayMethodRequest.channelIndex) && Intrinsics.areEqual(this.bindingId, mixPayMethodRequest.bindingId) && Intrinsics.areEqual(this.saveCard, mixPayMethodRequest.saveCard) && Intrinsics.areEqual(this.cardIndexNo, mixPayMethodRequest.cardIndexNo) && Intrinsics.areEqual(this.cardCredential, mixPayMethodRequest.cardCredential) && Intrinsics.areEqual(this.deviceId, mixPayMethodRequest.deviceId) && Intrinsics.areEqual(this.limitMaximum, mixPayMethodRequest.limitMaximum) && Intrinsics.areEqual(this.maskedCardNo, mixPayMethodRequest.maskedCardNo) && Intrinsics.areEqual(this.bankPhoneNo, mixPayMethodRequest.bankPhoneNo) && Intrinsics.areEqual(this.instCode, mixPayMethodRequest.instCode) && Intrinsics.areEqual(this.xcoId, mixPayMethodRequest.xcoId);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.payMethod.hashCode();
        int hashCode2 = this.channelIndex.hashCode();
        String str = this.bindingId;
        int hashCode3 = str == null ? 0 : str.hashCode();
        Boolean bool = this.saveCard;
        int hashCode4 = bool == null ? 0 : bool.hashCode();
        String str2 = this.cardIndexNo;
        int hashCode5 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.cardCredential;
        int hashCode6 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.deviceId;
        int hashCode7 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.limitMaximum;
        int hashCode8 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.maskedCardNo;
        int hashCode9 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.bankPhoneNo;
        int hashCode10 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.instCode;
        int hashCode11 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.xcoId;
        return (((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + (str9 != null ? str9.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MixPayMethodRequest(payMethod=");
        sb.append(this.payMethod);
        sb.append(", channelIndex=");
        sb.append(this.channelIndex);
        sb.append(", bindingId=");
        sb.append(this.bindingId);
        sb.append(", saveCard=");
        sb.append(this.saveCard);
        sb.append(", cardIndexNo=");
        sb.append(this.cardIndexNo);
        sb.append(", cardCredential=");
        sb.append(this.cardCredential);
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

    public MixPayMethodRequest(String str, String str2, String str3, Boolean bool, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.payMethod = str;
        this.channelIndex = str2;
        this.bindingId = str3;
        this.saveCard = bool;
        this.cardIndexNo = str4;
        this.cardCredential = str5;
        this.deviceId = str6;
        this.limitMaximum = str7;
        this.maskedCardNo = str8;
        this.bankPhoneNo = str9;
        this.instCode = str10;
        this.xcoId = str11;
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

    @JvmName(name = "getSaveCard")
    public final Boolean getSaveCard() {
        return this.saveCard;
    }

    @JvmName(name = "getCardIndexNo")
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    @JvmName(name = "getCardCredential")
    public final String getCardCredential() {
        return this.cardCredential;
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
