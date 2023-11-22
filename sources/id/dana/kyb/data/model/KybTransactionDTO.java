package id.dana.kyb.data.model;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b;\u0010<J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u009e\u0001\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001a\u001a\u00020\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010(\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b*\u0010\u0004R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b-\u0010\u0004R\u001c\u0010 \u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010.\u001a\u0004\b/\u0010\bR\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010+\u001a\u0004\b0\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b1\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b2\u0010\u0004R\u001a\u0010\u001a\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00103\u001a\u0004\b4\u0010\u000fR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b5\u0010\u0004R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010+\u001a\u0004\b6\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b7\u0010\u0004R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00108\u001a\u0004\b9\u0010\u0014R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010+\u001a\u0004\b:\u0010\u0004"}, d2 = {"Lid/dana/kyb/data/model/KybTransactionDTO;", "", "", "component1", "()Ljava/lang/String;", "component10", "Lid/dana/kyb/data/model/ExtendInfoResult;", "component11", "()Lid/dana/kyb/data/model/ExtendInfoResult;", "component12", "component2", "component3", "component4", "", "component5", "()Z", "component6", "component7", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component8", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component9", "bizOrderId", "bizOrderType", "merchantId", "merchantName", "offUsMerchant", "orderTitle", "orderCreatedTime", "payMoneyAmount", "subOrderStatus", "orderStatus", "extendInfo", "inOut", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Lid/dana/kyb/data/model/ExtendInfoResult;Ljava/lang/String;)Lid/dana/kyb/data/model/KybTransactionDTO;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizOrderId", "getBizOrderType", "Lid/dana/kyb/data/model/ExtendInfoResult;", "getExtendInfo", "getInOut", "getMerchantId", "getMerchantName", "Z", "getOffUsMerchant", "getOrderCreatedTime", "getOrderStatus", CashierKeyParams.GET_ORDER_TITLE, "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getPayMoneyAmount", "getSubOrderStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Lid/dana/kyb/data/model/ExtendInfoResult;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybTransactionDTO {
    private final String bizOrderId;
    private final String bizOrderType;
    private final ExtendInfoResult extendInfo;
    private final String inOut;
    private final String merchantId;
    private final String merchantName;
    private final boolean offUsMerchant;
    private final String orderCreatedTime;
    private final String orderStatus;
    private final String orderTitle;
    private final MoneyViewEntity payMoneyAmount;
    private final String subOrderStatus;

    public KybTransactionDTO() {
        this(null, null, null, null, false, null, null, null, null, null, null, null, ARiverTrackWatchDogEventConstant.STARTUP_FLAG, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getBizOrderId() {
        return this.bizOrderId;
    }

    /* renamed from: component10  reason: from getter */
    public final String getOrderStatus() {
        return this.orderStatus;
    }

    /* renamed from: component11  reason: from getter */
    public final ExtendInfoResult getExtendInfo() {
        return this.extendInfo;
    }

    /* renamed from: component12  reason: from getter */
    public final String getInOut() {
        return this.inOut;
    }

    /* renamed from: component2  reason: from getter */
    public final String getBizOrderType() {
        return this.bizOrderType;
    }

    /* renamed from: component3  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getMerchantName() {
        return this.merchantName;
    }

    /* renamed from: component5  reason: from getter */
    public final boolean getOffUsMerchant() {
        return this.offUsMerchant;
    }

    /* renamed from: component6  reason: from getter */
    public final String getOrderTitle() {
        return this.orderTitle;
    }

    /* renamed from: component7  reason: from getter */
    public final String getOrderCreatedTime() {
        return this.orderCreatedTime;
    }

    /* renamed from: component8  reason: from getter */
    public final MoneyViewEntity getPayMoneyAmount() {
        return this.payMoneyAmount;
    }

    /* renamed from: component9  reason: from getter */
    public final String getSubOrderStatus() {
        return this.subOrderStatus;
    }

    public final KybTransactionDTO copy(String bizOrderId, String bizOrderType, String merchantId, String merchantName, boolean offUsMerchant, String orderTitle, String orderCreatedTime, MoneyViewEntity payMoneyAmount, String subOrderStatus, String orderStatus, ExtendInfoResult extendInfo, String inOut) {
        return new KybTransactionDTO(bizOrderId, bizOrderType, merchantId, merchantName, offUsMerchant, orderTitle, orderCreatedTime, payMoneyAmount, subOrderStatus, orderStatus, extendInfo, inOut);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KybTransactionDTO) {
            KybTransactionDTO kybTransactionDTO = (KybTransactionDTO) other;
            return Intrinsics.areEqual(this.bizOrderId, kybTransactionDTO.bizOrderId) && Intrinsics.areEqual(this.bizOrderType, kybTransactionDTO.bizOrderType) && Intrinsics.areEqual(this.merchantId, kybTransactionDTO.merchantId) && Intrinsics.areEqual(this.merchantName, kybTransactionDTO.merchantName) && this.offUsMerchant == kybTransactionDTO.offUsMerchant && Intrinsics.areEqual(this.orderTitle, kybTransactionDTO.orderTitle) && Intrinsics.areEqual(this.orderCreatedTime, kybTransactionDTO.orderCreatedTime) && Intrinsics.areEqual(this.payMoneyAmount, kybTransactionDTO.payMoneyAmount) && Intrinsics.areEqual(this.subOrderStatus, kybTransactionDTO.subOrderStatus) && Intrinsics.areEqual(this.orderStatus, kybTransactionDTO.orderStatus) && Intrinsics.areEqual(this.extendInfo, kybTransactionDTO.extendInfo) && Intrinsics.areEqual(this.inOut, kybTransactionDTO.inOut);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.bizOrderId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.bizOrderType;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.merchantId;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.merchantName;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        boolean z = this.offUsMerchant;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str5 = this.orderTitle;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.orderCreatedTime;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        MoneyViewEntity moneyViewEntity = this.payMoneyAmount;
        int hashCode7 = moneyViewEntity == null ? 0 : moneyViewEntity.hashCode();
        String str7 = this.subOrderStatus;
        int hashCode8 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.orderStatus;
        int hashCode9 = str8 == null ? 0 : str8.hashCode();
        ExtendInfoResult extendInfoResult = this.extendInfo;
        int hashCode10 = extendInfoResult == null ? 0 : extendInfoResult.hashCode();
        String str9 = this.inOut;
        return (((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + (str9 != null ? str9.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybTransactionDTO(bizOrderId=");
        sb.append(this.bizOrderId);
        sb.append(", bizOrderType=");
        sb.append(this.bizOrderType);
        sb.append(", merchantId=");
        sb.append(this.merchantId);
        sb.append(", merchantName=");
        sb.append(this.merchantName);
        sb.append(", offUsMerchant=");
        sb.append(this.offUsMerchant);
        sb.append(", orderTitle=");
        sb.append(this.orderTitle);
        sb.append(", orderCreatedTime=");
        sb.append(this.orderCreatedTime);
        sb.append(", payMoneyAmount=");
        sb.append(this.payMoneyAmount);
        sb.append(", subOrderStatus=");
        sb.append(this.subOrderStatus);
        sb.append(", orderStatus=");
        sb.append(this.orderStatus);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", inOut=");
        sb.append(this.inOut);
        sb.append(')');
        return sb.toString();
    }

    public KybTransactionDTO(String str, String str2, String str3, String str4, boolean z, String str5, String str6, MoneyViewEntity moneyViewEntity, String str7, String str8, ExtendInfoResult extendInfoResult, String str9) {
        this.bizOrderId = str;
        this.bizOrderType = str2;
        this.merchantId = str3;
        this.merchantName = str4;
        this.offUsMerchant = z;
        this.orderTitle = str5;
        this.orderCreatedTime = str6;
        this.payMoneyAmount = moneyViewEntity;
        this.subOrderStatus = str7;
        this.orderStatus = str8;
        this.extendInfo = extendInfoResult;
        this.inOut = str9;
    }

    public /* synthetic */ KybTransactionDTO(String str, String str2, String str3, String str4, boolean z, String str5, String str6, MoneyViewEntity moneyViewEntity, String str7, String str8, ExtendInfoResult extendInfoResult, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? false : z, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : moneyViewEntity, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : extendInfoResult, (i & 2048) == 0 ? str9 : null);
    }

    @JvmName(name = "getBizOrderId")
    public final String getBizOrderId() {
        return this.bizOrderId;
    }

    @JvmName(name = "getBizOrderType")
    public final String getBizOrderType() {
        return this.bizOrderType;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "getMerchantName")
    public final String getMerchantName() {
        return this.merchantName;
    }

    @JvmName(name = "getOffUsMerchant")
    public final boolean getOffUsMerchant() {
        return this.offUsMerchant;
    }

    @JvmName(name = CashierKeyParams.GET_ORDER_TITLE)
    public final String getOrderTitle() {
        return this.orderTitle;
    }

    @JvmName(name = "getOrderCreatedTime")
    public final String getOrderCreatedTime() {
        return this.orderCreatedTime;
    }

    @JvmName(name = "getPayMoneyAmount")
    public final MoneyViewEntity getPayMoneyAmount() {
        return this.payMoneyAmount;
    }

    @JvmName(name = "getSubOrderStatus")
    public final String getSubOrderStatus() {
        return this.subOrderStatus;
    }

    @JvmName(name = "getOrderStatus")
    public final String getOrderStatus() {
        return this.orderStatus;
    }

    @JvmName(name = "getExtendInfo")
    public final ExtendInfoResult getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getInOut")
    public final String getInOut() {
        return this.inOut;
    }
}
