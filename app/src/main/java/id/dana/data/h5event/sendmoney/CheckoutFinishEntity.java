package id.dana.data.h5event.sendmoney;

import com.alibaba.fastjson.annotation.JSONCreator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BC\b\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007JJ\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0007R\"\u0010\r\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004\"\u0004\b\u001d\u0010\u001eR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\"R$\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010#\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010&R$\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010#\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010&R$\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010#\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010&"}, d2 = {"Lid/dana/data/h5event/sendmoney/CheckoutFinishEntity;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "Lid/dana/data/h5event/sendmoney/PayQueryResponse;", "component4", "()Lid/dana/data/h5event/sendmoney/PayQueryResponse;", "component5", "apiSuccess", "processingStatus", "transType", "payQueryResponse", "transScenario", "copy", "(ZLjava/lang/String;Ljava/lang/String;Lid/dana/data/h5event/sendmoney/PayQueryResponse;Ljava/lang/String;)Lid/dana/data/h5event/sendmoney/CheckoutFinishEntity;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getApiSuccess", "setApiSuccess", "(Z)V", "Lid/dana/data/h5event/sendmoney/PayQueryResponse;", "getPayQueryResponse", "setPayQueryResponse", "(Lid/dana/data/h5event/sendmoney/PayQueryResponse;)V", "Ljava/lang/String;", "getProcessingStatus", "setProcessingStatus", "(Ljava/lang/String;)V", "getTransScenario", "setTransScenario", "getTransType", "setTransType", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Lid/dana/data/h5event/sendmoney/PayQueryResponse;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CheckoutFinishEntity {
    public boolean apiSuccess;
    public PayQueryResponse payQueryResponse;
    public String processingStatus;
    public String transScenario;
    public String transType;

    @JSONCreator
    public CheckoutFinishEntity() {
        this(false, null, null, null, null, 31, null);
    }

    public static /* synthetic */ CheckoutFinishEntity copy$default(CheckoutFinishEntity checkoutFinishEntity, boolean z, String str, String str2, PayQueryResponse payQueryResponse, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = checkoutFinishEntity.apiSuccess;
        }
        if ((i & 2) != 0) {
            str = checkoutFinishEntity.processingStatus;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = checkoutFinishEntity.transType;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            payQueryResponse = checkoutFinishEntity.payQueryResponse;
        }
        PayQueryResponse payQueryResponse2 = payQueryResponse;
        if ((i & 16) != 0) {
            str3 = checkoutFinishEntity.transScenario;
        }
        return checkoutFinishEntity.copy(z, str4, str5, payQueryResponse2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getApiSuccess() {
        return this.apiSuccess;
    }

    /* renamed from: component2  reason: from getter */
    public final String getProcessingStatus() {
        return this.processingStatus;
    }

    /* renamed from: component3  reason: from getter */
    public final String getTransType() {
        return this.transType;
    }

    /* renamed from: component4  reason: from getter */
    public final PayQueryResponse getPayQueryResponse() {
        return this.payQueryResponse;
    }

    /* renamed from: component5  reason: from getter */
    public final String getTransScenario() {
        return this.transScenario;
    }

    public final CheckoutFinishEntity copy(boolean apiSuccess, String processingStatus, String transType, PayQueryResponse payQueryResponse, String transScenario) {
        return new CheckoutFinishEntity(apiSuccess, processingStatus, transType, payQueryResponse, transScenario);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CheckoutFinishEntity) {
            CheckoutFinishEntity checkoutFinishEntity = (CheckoutFinishEntity) other;
            return this.apiSuccess == checkoutFinishEntity.apiSuccess && Intrinsics.areEqual(this.processingStatus, checkoutFinishEntity.processingStatus) && Intrinsics.areEqual(this.transType, checkoutFinishEntity.transType) && Intrinsics.areEqual(this.payQueryResponse, checkoutFinishEntity.payQueryResponse) && Intrinsics.areEqual(this.transScenario, checkoutFinishEntity.transScenario);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public final int hashCode() {
        boolean z = this.apiSuccess;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        String str = this.processingStatus;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.transType;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        PayQueryResponse payQueryResponse = this.payQueryResponse;
        int hashCode3 = payQueryResponse == null ? 0 : payQueryResponse.hashCode();
        String str3 = this.transScenario;
        return (((((((r0 * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CheckoutFinishEntity(apiSuccess=");
        sb.append(this.apiSuccess);
        sb.append(", processingStatus=");
        sb.append(this.processingStatus);
        sb.append(", transType=");
        sb.append(this.transType);
        sb.append(", payQueryResponse=");
        sb.append(this.payQueryResponse);
        sb.append(", transScenario=");
        sb.append(this.transScenario);
        sb.append(')');
        return sb.toString();
    }

    @JSONCreator
    public CheckoutFinishEntity(boolean z, String str, String str2, PayQueryResponse payQueryResponse, String str3) {
        this.apiSuccess = z;
        this.processingStatus = str;
        this.transType = str2;
        this.payQueryResponse = payQueryResponse;
        this.transScenario = str3;
    }

    public /* synthetic */ CheckoutFinishEntity(boolean z, String str, String str2, PayQueryResponse payQueryResponse, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : payQueryResponse, (i & 16) == 0 ? str3 : null);
    }

    @JvmName(name = "getApiSuccess")
    public final boolean getApiSuccess() {
        return this.apiSuccess;
    }

    @JvmName(name = "setApiSuccess")
    public final void setApiSuccess(boolean z) {
        this.apiSuccess = z;
    }

    @JvmName(name = "getProcessingStatus")
    public final String getProcessingStatus() {
        return this.processingStatus;
    }

    @JvmName(name = "setProcessingStatus")
    public final void setProcessingStatus(String str) {
        this.processingStatus = str;
    }

    @JvmName(name = "getTransType")
    public final String getTransType() {
        return this.transType;
    }

    @JvmName(name = "setTransType")
    public final void setTransType(String str) {
        this.transType = str;
    }

    @JvmName(name = "getPayQueryResponse")
    public final PayQueryResponse getPayQueryResponse() {
        return this.payQueryResponse;
    }

    @JvmName(name = "setPayQueryResponse")
    public final void setPayQueryResponse(PayQueryResponse payQueryResponse) {
        this.payQueryResponse = payQueryResponse;
    }

    @JvmName(name = "getTransScenario")
    public final String getTransScenario() {
        return this.transScenario;
    }

    @JvmName(name = "setTransScenario")
    public final void setTransScenario(String str) {
        this.transScenario = str;
    }
}
