package id.dana.data.familyaccount.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.constant.UrlParam;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\b"}, d2 = {"Lid/dana/data/familyaccount/model/request/CreateOrderTopUpRequestEntity;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component3", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "accountType", UrlParam.REQUEST_ID, "topUpAmount", "copy", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)Lid/dana/data/familyaccount/model/request/CreateOrderTopUpRequestEntity;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAccountType", "getRequestId", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getTopUpAmount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CreateOrderTopUpRequestEntity extends BaseRpcRequest {
    private final String accountType;
    private final String requestId;
    private final MoneyViewEntity topUpAmount;

    public static /* synthetic */ CreateOrderTopUpRequestEntity copy$default(CreateOrderTopUpRequestEntity createOrderTopUpRequestEntity, String str, String str2, MoneyViewEntity moneyViewEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createOrderTopUpRequestEntity.accountType;
        }
        if ((i & 2) != 0) {
            str2 = createOrderTopUpRequestEntity.requestId;
        }
        if ((i & 4) != 0) {
            moneyViewEntity = createOrderTopUpRequestEntity.topUpAmount;
        }
        return createOrderTopUpRequestEntity.copy(str, str2, moneyViewEntity);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAccountType() {
        return this.accountType;
    }

    /* renamed from: component2  reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: component3  reason: from getter */
    public final MoneyViewEntity getTopUpAmount() {
        return this.topUpAmount;
    }

    public final CreateOrderTopUpRequestEntity copy(String accountType, String requestId, MoneyViewEntity topUpAmount) {
        Intrinsics.checkNotNullParameter(accountType, "");
        Intrinsics.checkNotNullParameter(requestId, "");
        Intrinsics.checkNotNullParameter(topUpAmount, "");
        return new CreateOrderTopUpRequestEntity(accountType, requestId, topUpAmount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CreateOrderTopUpRequestEntity) {
            CreateOrderTopUpRequestEntity createOrderTopUpRequestEntity = (CreateOrderTopUpRequestEntity) other;
            return Intrinsics.areEqual(this.accountType, createOrderTopUpRequestEntity.accountType) && Intrinsics.areEqual(this.requestId, createOrderTopUpRequestEntity.requestId) && Intrinsics.areEqual(this.topUpAmount, createOrderTopUpRequestEntity.topUpAmount);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.accountType.hashCode() * 31) + this.requestId.hashCode()) * 31) + this.topUpAmount.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreateOrderTopUpRequestEntity(accountType=");
        sb.append(this.accountType);
        sb.append(", requestId=");
        sb.append(this.requestId);
        sb.append(", topUpAmount=");
        sb.append(this.topUpAmount);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ CreateOrderTopUpRequestEntity(String str, String str2, MoneyViewEntity moneyViewEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "SHARED_ACCOUNT" : str, str2, moneyViewEntity);
    }

    @JvmName(name = "getAccountType")
    public final String getAccountType() {
        return this.accountType;
    }

    @JvmName(name = "getRequestId")
    public final String getRequestId() {
        return this.requestId;
    }

    @JvmName(name = "getTopUpAmount")
    public final MoneyViewEntity getTopUpAmount() {
        return this.topUpAmount;
    }

    public CreateOrderTopUpRequestEntity(String str, String str2, MoneyViewEntity moneyViewEntity) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(moneyViewEntity, "");
        this.accountType = str;
        this.requestId = str2;
        this.topUpAmount = moneyViewEntity;
    }
}
