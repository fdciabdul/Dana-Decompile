package id.dana.domain.familyaccount.model;

import id.dana.data.constant.UrlParam;
import id.dana.domain.nearbyme.model.MoneyView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007"}, d2 = {"Lid/dana/domain/familyaccount/model/CreateOrderTopupRequest;", "", "", "component1", "()Ljava/lang/String;", "Lid/dana/domain/nearbyme/model/MoneyView;", "component2", "()Lid/dana/domain/nearbyme/model/MoneyView;", UrlParam.REQUEST_ID, "topUpAmount", "copy", "(Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;)Lid/dana/domain/familyaccount/model/CreateOrderTopupRequest;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getRequestId", "Lid/dana/domain/nearbyme/model/MoneyView;", "getTopUpAmount", "<init>", "(Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CreateOrderTopupRequest {
    private final String requestId;
    private final MoneyView topUpAmount;

    public static /* synthetic */ CreateOrderTopupRequest copy$default(CreateOrderTopupRequest createOrderTopupRequest, String str, MoneyView moneyView, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createOrderTopupRequest.requestId;
        }
        if ((i & 2) != 0) {
            moneyView = createOrderTopupRequest.topUpAmount;
        }
        return createOrderTopupRequest.copy(str, moneyView);
    }

    /* renamed from: component1  reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyView getTopUpAmount() {
        return this.topUpAmount;
    }

    public final CreateOrderTopupRequest copy(String requestId, MoneyView topUpAmount) {
        Intrinsics.checkNotNullParameter(requestId, "");
        Intrinsics.checkNotNullParameter(topUpAmount, "");
        return new CreateOrderTopupRequest(requestId, topUpAmount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CreateOrderTopupRequest) {
            CreateOrderTopupRequest createOrderTopupRequest = (CreateOrderTopupRequest) other;
            return Intrinsics.areEqual(this.requestId, createOrderTopupRequest.requestId) && Intrinsics.areEqual(this.topUpAmount, createOrderTopupRequest.topUpAmount);
        }
        return false;
    }

    public final int hashCode() {
        return (this.requestId.hashCode() * 31) + this.topUpAmount.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreateOrderTopupRequest(requestId=");
        sb.append(this.requestId);
        sb.append(", topUpAmount=");
        sb.append(this.topUpAmount);
        sb.append(')');
        return sb.toString();
    }

    public CreateOrderTopupRequest(String str, MoneyView moneyView) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(moneyView, "");
        this.requestId = str;
        this.topUpAmount = moneyView;
    }

    @JvmName(name = "getRequestId")
    public final String getRequestId() {
        return this.requestId;
    }

    @JvmName(name = "getTopUpAmount")
    public final MoneyView getTopUpAmount() {
        return this.topUpAmount;
    }
}
