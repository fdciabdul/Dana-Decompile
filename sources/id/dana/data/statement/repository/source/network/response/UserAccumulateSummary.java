package id.dana.data.statement.repository.source.network.response;

import com.alipay.ap.mobileprod.service.facade.uniresultpage.model.MoneyView;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\"\u0010\u000b\u001a\u00020\u00068\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\u001aR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004\"\u0004\b\u001d\u0010\u001eR\"\u0010\n\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001f\u0010\u0004\"\u0004\b \u0010\u001e"}, d2 = {"Lid/dana/data/statement/repository/source/network/response/UserAccumulateSummary;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/alipay/ap/mobileprod/service/facade/uniresultpage/model/MoneyView;", "component3", "()Lcom/alipay/ap/mobileprod/service/facade/uniresultpage/model/MoneyView;", "bizType", "description", "amount", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/alipay/ap/mobileprod/service/facade/uniresultpage/model/MoneyView;)Lid/dana/data/statement/repository/source/network/response/UserAccumulateSummary;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lcom/alipay/ap/mobileprod/service/facade/uniresultpage/model/MoneyView;", "getAmount", "setAmount", "(Lcom/alipay/ap/mobileprod/service/facade/uniresultpage/model/MoneyView;)V", "Ljava/lang/String;", "getBizType", "setBizType", "(Ljava/lang/String;)V", "getDescription", "setDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/alipay/ap/mobileprod/service/facade/uniresultpage/model/MoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserAccumulateSummary extends BaseRpcResult {
    private MoneyView amount;
    private String bizType;
    private String description;

    public UserAccumulateSummary() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ UserAccumulateSummary copy$default(UserAccumulateSummary userAccumulateSummary, String str, String str2, MoneyView moneyView, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userAccumulateSummary.bizType;
        }
        if ((i & 2) != 0) {
            str2 = userAccumulateSummary.description;
        }
        if ((i & 4) != 0) {
            moneyView = userAccumulateSummary.amount;
        }
        return userAccumulateSummary.copy(str, str2, moneyView);
    }

    /* renamed from: component1  reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    /* renamed from: component2  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component3  reason: from getter */
    public final MoneyView getAmount() {
        return this.amount;
    }

    public final UserAccumulateSummary copy(String bizType, String description, MoneyView amount) {
        Intrinsics.checkNotNullParameter(bizType, "");
        Intrinsics.checkNotNullParameter(description, "");
        Intrinsics.checkNotNullParameter(amount, "");
        return new UserAccumulateSummary(bizType, description, amount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserAccumulateSummary) {
            UserAccumulateSummary userAccumulateSummary = (UserAccumulateSummary) other;
            return Intrinsics.areEqual(this.bizType, userAccumulateSummary.bizType) && Intrinsics.areEqual(this.description, userAccumulateSummary.description) && Intrinsics.areEqual(this.amount, userAccumulateSummary.amount);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.bizType.hashCode() * 31) + this.description.hashCode()) * 31) + this.amount.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserAccumulateSummary(bizType=");
        sb.append(this.bizType);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "setBizType")
    public final void setBizType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.bizType = str;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "setDescription")
    public final void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.description = str;
    }

    public /* synthetic */ UserAccumulateSummary(String str, String str2, MoneyView moneyView, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? new MoneyView() : moneyView);
    }

    @JvmName(name = "getAmount")
    public final MoneyView getAmount() {
        return this.amount;
    }

    @JvmName(name = "setAmount")
    public final void setAmount(MoneyView moneyView) {
        Intrinsics.checkNotNullParameter(moneyView, "");
        this.amount = moneyView;
    }

    public UserAccumulateSummary(String str, String str2, MoneyView moneyView) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(moneyView, "");
        this.bizType = str;
        this.description = str2;
        this.amount = moneyView;
    }
}
