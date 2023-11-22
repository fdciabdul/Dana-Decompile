package id.dana.kyb.data.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.iap.ac.android.acs.plugin.utils.Constants;
import id.dana.kyb.data.model.ScannerInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b)\u0010*J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJL\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004\"\u0004\b\u001d\u0010\u001eR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001f\u0010\u0004\"\u0004\b \u0010\u001eR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b!\u0010\u0004\"\u0004\b\"\u0010\u001eR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001b\u001a\u0004\b#\u0010\u0004\"\u0004\b$\u0010\u001eR$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010("}, d2 = {"Lid/dana/kyb/data/repository/source/network/request/PaymentOrderCpmRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "Lid/dana/kyb/data/model/ScannerInfoEntity;", "component5", "()Lid/dana/kyb/data/model/ScannerInfoEntity;", "merchantId", "authCode", "note", "amount", "scannerInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/kyb/data/model/ScannerInfoEntity;)Lid/dana/kyb/data/repository/source/network/request/PaymentOrderCpmRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAmount", "setAmount", "(Ljava/lang/String;)V", Constants.JS_API_GET_AUTH_CODE, "setAuthCode", "getMerchantId", "setMerchantId", "getNote", "setNote", "Lid/dana/kyb/data/model/ScannerInfoEntity;", "getScannerInfo", "setScannerInfo", "(Lid/dana/kyb/data/model/ScannerInfoEntity;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/kyb/data/model/ScannerInfoEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaymentOrderCpmRequest extends BaseRpcRequest {
    private String amount;
    private String authCode;
    private String merchantId;
    private String note;
    private ScannerInfoEntity scannerInfo;

    public PaymentOrderCpmRequest() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ PaymentOrderCpmRequest copy$default(PaymentOrderCpmRequest paymentOrderCpmRequest, String str, String str2, String str3, String str4, ScannerInfoEntity scannerInfoEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paymentOrderCpmRequest.merchantId;
        }
        if ((i & 2) != 0) {
            str2 = paymentOrderCpmRequest.authCode;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = paymentOrderCpmRequest.note;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = paymentOrderCpmRequest.amount;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            scannerInfoEntity = paymentOrderCpmRequest.scannerInfo;
        }
        return paymentOrderCpmRequest.copy(str, str5, str6, str7, scannerInfoEntity);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAuthCode() {
        return this.authCode;
    }

    /* renamed from: component3  reason: from getter */
    public final String getNote() {
        return this.note;
    }

    /* renamed from: component4  reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component5  reason: from getter */
    public final ScannerInfoEntity getScannerInfo() {
        return this.scannerInfo;
    }

    public final PaymentOrderCpmRequest copy(String merchantId, String authCode, String note, String amount, ScannerInfoEntity scannerInfo) {
        return new PaymentOrderCpmRequest(merchantId, authCode, note, amount, scannerInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PaymentOrderCpmRequest) {
            PaymentOrderCpmRequest paymentOrderCpmRequest = (PaymentOrderCpmRequest) other;
            return Intrinsics.areEqual(this.merchantId, paymentOrderCpmRequest.merchantId) && Intrinsics.areEqual(this.authCode, paymentOrderCpmRequest.authCode) && Intrinsics.areEqual(this.note, paymentOrderCpmRequest.note) && Intrinsics.areEqual(this.amount, paymentOrderCpmRequest.amount) && Intrinsics.areEqual(this.scannerInfo, paymentOrderCpmRequest.scannerInfo);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.merchantId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.authCode;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.note;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.amount;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        ScannerInfoEntity scannerInfoEntity = this.scannerInfo;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (scannerInfoEntity != null ? scannerInfoEntity.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaymentOrderCpmRequest(merchantId=");
        sb.append(this.merchantId);
        sb.append(", authCode=");
        sb.append(this.authCode);
        sb.append(", note=");
        sb.append(this.note);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", scannerInfo=");
        sb.append(this.scannerInfo);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ PaymentOrderCpmRequest(String str, String str2, String str3, String str4, ScannerInfoEntity scannerInfoEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : scannerInfoEntity);
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "setMerchantId")
    public final void setMerchantId(String str) {
        this.merchantId = str;
    }

    @JvmName(name = Constants.JS_API_GET_AUTH_CODE)
    public final String getAuthCode() {
        return this.authCode;
    }

    @JvmName(name = "setAuthCode")
    public final void setAuthCode(String str) {
        this.authCode = str;
    }

    @JvmName(name = "getNote")
    public final String getNote() {
        return this.note;
    }

    @JvmName(name = "setNote")
    public final void setNote(String str) {
        this.note = str;
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "setAmount")
    public final void setAmount(String str) {
        this.amount = str;
    }

    @JvmName(name = "getScannerInfo")
    public final ScannerInfoEntity getScannerInfo() {
        return this.scannerInfo;
    }

    @JvmName(name = "setScannerInfo")
    public final void setScannerInfo(ScannerInfoEntity scannerInfoEntity) {
        this.scannerInfo = scannerInfoEntity;
    }

    public PaymentOrderCpmRequest(String str, String str2, String str3, String str4, ScannerInfoEntity scannerInfoEntity) {
        this.merchantId = str;
        this.authCode = str2;
        this.note = str3;
        this.amount = str4;
        this.scannerInfo = scannerInfoEntity;
    }
}
