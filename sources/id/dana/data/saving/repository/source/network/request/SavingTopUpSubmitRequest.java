package id.dana.data.saving.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.constant.UrlParam;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/data/saving/repository/source/network/request/SavingTopUpSubmitRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "savingId", "fundAmount", UrlParam.REQUEST_ID, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/saving/repository/source/network/request/SavingTopUpSubmitRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getFundAmount", "getRequestId", "getSavingId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SavingTopUpSubmitRequest extends BaseRpcRequest {
    private final String fundAmount;
    private final String requestId;
    private final String savingId;

    public static /* synthetic */ SavingTopUpSubmitRequest copy$default(SavingTopUpSubmitRequest savingTopUpSubmitRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = savingTopUpSubmitRequest.savingId;
        }
        if ((i & 2) != 0) {
            str2 = savingTopUpSubmitRequest.fundAmount;
        }
        if ((i & 4) != 0) {
            str3 = savingTopUpSubmitRequest.requestId;
        }
        return savingTopUpSubmitRequest.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getSavingId() {
        return this.savingId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getFundAmount() {
        return this.fundAmount;
    }

    /* renamed from: component3  reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    public final SavingTopUpSubmitRequest copy(String savingId, String fundAmount, String requestId) {
        Intrinsics.checkNotNullParameter(savingId, "");
        Intrinsics.checkNotNullParameter(fundAmount, "");
        Intrinsics.checkNotNullParameter(requestId, "");
        return new SavingTopUpSubmitRequest(savingId, fundAmount, requestId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SavingTopUpSubmitRequest) {
            SavingTopUpSubmitRequest savingTopUpSubmitRequest = (SavingTopUpSubmitRequest) other;
            return Intrinsics.areEqual(this.savingId, savingTopUpSubmitRequest.savingId) && Intrinsics.areEqual(this.fundAmount, savingTopUpSubmitRequest.fundAmount) && Intrinsics.areEqual(this.requestId, savingTopUpSubmitRequest.requestId);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.savingId.hashCode() * 31) + this.fundAmount.hashCode()) * 31) + this.requestId.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingTopUpSubmitRequest(savingId=");
        sb.append(this.savingId);
        sb.append(", fundAmount=");
        sb.append(this.fundAmount);
        sb.append(", requestId=");
        sb.append(this.requestId);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getSavingId")
    public final String getSavingId() {
        return this.savingId;
    }

    @JvmName(name = "getFundAmount")
    public final String getFundAmount() {
        return this.fundAmount;
    }

    @JvmName(name = "getRequestId")
    public final String getRequestId() {
        return this.requestId;
    }

    public SavingTopUpSubmitRequest(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.savingId = str;
        this.fundAmount = str2;
        this.requestId = str3;
    }
}
