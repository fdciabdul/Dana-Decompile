package id.dana.data.mybills.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/data/mybills/model/request/MonthlyAmountSubscriptionRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "goodsType", "ipRoleId", "recurringType", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/mybills/model/request/MonthlyAmountSubscriptionRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getGoodsType", "getIpRoleId", "getRecurringType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MonthlyAmountSubscriptionRequest extends BaseRpcRequest {
    private final String goodsType;
    private final String ipRoleId;
    private final String recurringType;

    public MonthlyAmountSubscriptionRequest() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ MonthlyAmountSubscriptionRequest copy$default(MonthlyAmountSubscriptionRequest monthlyAmountSubscriptionRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = monthlyAmountSubscriptionRequest.goodsType;
        }
        if ((i & 2) != 0) {
            str2 = monthlyAmountSubscriptionRequest.ipRoleId;
        }
        if ((i & 4) != 0) {
            str3 = monthlyAmountSubscriptionRequest.recurringType;
        }
        return monthlyAmountSubscriptionRequest.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getGoodsType() {
        return this.goodsType;
    }

    /* renamed from: component2  reason: from getter */
    public final String getIpRoleId() {
        return this.ipRoleId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getRecurringType() {
        return this.recurringType;
    }

    public final MonthlyAmountSubscriptionRequest copy(String goodsType, String ipRoleId, String recurringType) {
        Intrinsics.checkNotNullParameter(goodsType, "");
        Intrinsics.checkNotNullParameter(ipRoleId, "");
        Intrinsics.checkNotNullParameter(recurringType, "");
        return new MonthlyAmountSubscriptionRequest(goodsType, ipRoleId, recurringType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MonthlyAmountSubscriptionRequest) {
            MonthlyAmountSubscriptionRequest monthlyAmountSubscriptionRequest = (MonthlyAmountSubscriptionRequest) other;
            return Intrinsics.areEqual(this.goodsType, monthlyAmountSubscriptionRequest.goodsType) && Intrinsics.areEqual(this.ipRoleId, monthlyAmountSubscriptionRequest.ipRoleId) && Intrinsics.areEqual(this.recurringType, monthlyAmountSubscriptionRequest.recurringType);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.goodsType.hashCode() * 31) + this.ipRoleId.hashCode()) * 31) + this.recurringType.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MonthlyAmountSubscriptionRequest(goodsType=");
        sb.append(this.goodsType);
        sb.append(", ipRoleId=");
        sb.append(this.ipRoleId);
        sb.append(", recurringType=");
        sb.append(this.recurringType);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ MonthlyAmountSubscriptionRequest(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    @JvmName(name = "getGoodsType")
    public final String getGoodsType() {
        return this.goodsType;
    }

    @JvmName(name = "getIpRoleId")
    public final String getIpRoleId() {
        return this.ipRoleId;
    }

    @JvmName(name = "getRecurringType")
    public final String getRecurringType() {
        return this.recurringType;
    }

    public MonthlyAmountSubscriptionRequest(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.goodsType = str;
        this.ipRoleId = str2;
        this.recurringType = str3;
    }
}
