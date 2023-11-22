package id.dana.mybills.data.model.response;

import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/mybills/data/model/response/QuerySubscriptionResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "Lid/dana/mybills/data/model/response/SubscriptionInfoResult;", "component1", "()Lid/dana/mybills/data/model/response/SubscriptionInfoResult;", "subscriptionInfo", "copy", "(Lid/dana/mybills/data/model/response/SubscriptionInfoResult;)Lid/dana/mybills/data/model/response/QuerySubscriptionResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/mybills/data/model/response/SubscriptionInfoResult;", "getSubscriptionInfo", "<init>", "(Lid/dana/mybills/data/model/response/SubscriptionInfoResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class QuerySubscriptionResult extends BaseRpcResultAphome {
    private final SubscriptionInfoResult subscriptionInfo;

    public static /* synthetic */ QuerySubscriptionResult copy$default(QuerySubscriptionResult querySubscriptionResult, SubscriptionInfoResult subscriptionInfoResult, int i, Object obj) {
        if ((i & 1) != 0) {
            subscriptionInfoResult = querySubscriptionResult.subscriptionInfo;
        }
        return querySubscriptionResult.copy(subscriptionInfoResult);
    }

    /* renamed from: component1  reason: from getter */
    public final SubscriptionInfoResult getSubscriptionInfo() {
        return this.subscriptionInfo;
    }

    public final QuerySubscriptionResult copy(SubscriptionInfoResult subscriptionInfo) {
        Intrinsics.checkNotNullParameter(subscriptionInfo, "");
        return new QuerySubscriptionResult(subscriptionInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof QuerySubscriptionResult) && Intrinsics.areEqual(this.subscriptionInfo, ((QuerySubscriptionResult) other).subscriptionInfo);
    }

    public final int hashCode() {
        return this.subscriptionInfo.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QuerySubscriptionResult(subscriptionInfo=");
        sb.append(this.subscriptionInfo);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getSubscriptionInfo")
    public final SubscriptionInfoResult getSubscriptionInfo() {
        return this.subscriptionInfo;
    }

    public QuerySubscriptionResult(SubscriptionInfoResult subscriptionInfoResult) {
        Intrinsics.checkNotNullParameter(subscriptionInfoResult, "");
        this.subscriptionInfo = subscriptionInfoResult;
    }
}
