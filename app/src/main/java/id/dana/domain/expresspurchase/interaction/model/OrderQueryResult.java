package id.dana.domain.expresspurchase.interaction.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/OrderQueryResult;", "", "", "acquirementId", "Ljava/lang/String;", "getAcquirementId", "()Ljava/lang/String;", "setAcquirementId", "(Ljava/lang/String;)V", "", "bizFinished", "Ljava/lang/Boolean;", "getBizFinished", "()Ljava/lang/Boolean;", "setBizFinished", "(Ljava/lang/Boolean;)V", "clientId", "getClientId", "setClientId", "merchantId", "getMerchantId", "setMerchantId", "merchantTransId", "getMerchantTransId", "setMerchantTransId", "productCode", "getProductCode", "setProductCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OrderQueryResult {
    private String acquirementId;
    private Boolean bizFinished;
    private String clientId;
    private String merchantId;
    private String merchantTransId;
    private String productCode;

    public OrderQueryResult(String str, String str2, String str3, String str4, String str5, Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.clientId = str;
        this.acquirementId = str2;
        this.merchantId = str3;
        this.merchantTransId = str4;
        this.productCode = str5;
        this.bizFinished = bool;
    }

    public /* synthetic */ OrderQueryResult(String str, String str2, String str3, String str4, String str5, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, (i & 32) != 0 ? null : bool);
    }

    @JvmName(name = "getClientId")
    public final String getClientId() {
        return this.clientId;
    }

    @JvmName(name = "setClientId")
    public final void setClientId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.clientId = str;
    }

    @JvmName(name = "getAcquirementId")
    public final String getAcquirementId() {
        return this.acquirementId;
    }

    @JvmName(name = "setAcquirementId")
    public final void setAcquirementId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.acquirementId = str;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "setMerchantId")
    public final void setMerchantId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.merchantId = str;
    }

    @JvmName(name = "getMerchantTransId")
    public final String getMerchantTransId() {
        return this.merchantTransId;
    }

    @JvmName(name = "setMerchantTransId")
    public final void setMerchantTransId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.merchantTransId = str;
    }

    @JvmName(name = "getProductCode")
    public final String getProductCode() {
        return this.productCode;
    }

    @JvmName(name = "setProductCode")
    public final void setProductCode(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.productCode = str;
    }

    @JvmName(name = "getBizFinished")
    public final Boolean getBizFinished() {
        return this.bizFinished;
    }

    @JvmName(name = "setBizFinished")
    public final void setBizFinished(Boolean bool) {
        this.bizFinished = bool;
    }
}
