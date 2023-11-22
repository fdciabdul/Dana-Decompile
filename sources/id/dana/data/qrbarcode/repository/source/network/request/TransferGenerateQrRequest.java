package id.dana.data.qrbarcode.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u000bJ\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007R\u0017\u0010\r\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u001a\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004"}, d2 = {"Lid/dana/data/qrbarcode/repository/source/network/request/TransferGenerateQrRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "", "component4", "()I", "qris", "amount", DecodedScanBizInfoKey.COMMENT, "qrCount", "copy", "(ZLjava/lang/String;Ljava/lang/String;I)Lid/dana/data/qrbarcode/repository/source/network/request/TransferGenerateQrRequest;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getAmount", "getComment", "I", "getQrCount", "Z", "getQris", "<init>", "(ZLjava/lang/String;Ljava/lang/String;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TransferGenerateQrRequest extends BaseRpcRequest {
    private final String amount;
    private final String comment;
    private final int qrCount;
    private final boolean qris;

    public static /* synthetic */ TransferGenerateQrRequest copy$default(TransferGenerateQrRequest transferGenerateQrRequest, boolean z, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = transferGenerateQrRequest.qris;
        }
        if ((i2 & 2) != 0) {
            str = transferGenerateQrRequest.amount;
        }
        if ((i2 & 4) != 0) {
            str2 = transferGenerateQrRequest.comment;
        }
        if ((i2 & 8) != 0) {
            i = transferGenerateQrRequest.qrCount;
        }
        return transferGenerateQrRequest.copy(z, str, str2, i);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getQris() {
        return this.qris;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component3  reason: from getter */
    public final String getComment() {
        return this.comment;
    }

    /* renamed from: component4  reason: from getter */
    public final int getQrCount() {
        return this.qrCount;
    }

    public final TransferGenerateQrRequest copy(boolean qris, String amount, String comment, int qrCount) {
        Intrinsics.checkNotNullParameter(amount, "");
        Intrinsics.checkNotNullParameter(comment, "");
        return new TransferGenerateQrRequest(qris, amount, comment, qrCount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TransferGenerateQrRequest) {
            TransferGenerateQrRequest transferGenerateQrRequest = (TransferGenerateQrRequest) other;
            return this.qris == transferGenerateQrRequest.qris && Intrinsics.areEqual(this.amount, transferGenerateQrRequest.amount) && Intrinsics.areEqual(this.comment, transferGenerateQrRequest.comment) && this.qrCount == transferGenerateQrRequest.qrCount;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean z = this.qris;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((r0 * 31) + this.amount.hashCode()) * 31) + this.comment.hashCode()) * 31) + this.qrCount;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransferGenerateQrRequest(qris=");
        sb.append(this.qris);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", comment=");
        sb.append(this.comment);
        sb.append(", qrCount=");
        sb.append(this.qrCount);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getQris")
    public final boolean getQris() {
        return this.qris;
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "getComment")
    public final String getComment() {
        return this.comment;
    }

    @JvmName(name = "getQrCount")
    public final int getQrCount() {
        return this.qrCount;
    }

    public TransferGenerateQrRequest(boolean z, String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.qris = z;
        this.amount = str;
        this.comment = str2;
        this.qrCount = i;
    }
}
