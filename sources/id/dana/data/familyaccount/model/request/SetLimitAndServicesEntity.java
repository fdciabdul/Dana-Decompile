package id.dana.data.familyaccount.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J4\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007"}, d2 = {"Lid/dana/data/familyaccount/model/request/SetLimitAndServicesEntity;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "component3", "memberId", "useCases", "amount", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lid/dana/data/familyaccount/model/request/SetLimitAndServicesEntity;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAmount", "getMemberId", "Ljava/util/List;", "getUseCases", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SetLimitAndServicesEntity extends BaseRpcRequest {
    private final String amount;
    private final String memberId;
    private final List<String> useCases;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SetLimitAndServicesEntity copy$default(SetLimitAndServicesEntity setLimitAndServicesEntity, String str, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = setLimitAndServicesEntity.memberId;
        }
        if ((i & 2) != 0) {
            list = setLimitAndServicesEntity.useCases;
        }
        if ((i & 4) != 0) {
            str2 = setLimitAndServicesEntity.amount;
        }
        return setLimitAndServicesEntity.copy(str, list, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMemberId() {
        return this.memberId;
    }

    public final List<String> component2() {
        return this.useCases;
    }

    /* renamed from: component3  reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    public final SetLimitAndServicesEntity copy(String memberId, List<String> useCases, String amount) {
        Intrinsics.checkNotNullParameter(memberId, "");
        Intrinsics.checkNotNullParameter(useCases, "");
        Intrinsics.checkNotNullParameter(amount, "");
        return new SetLimitAndServicesEntity(memberId, useCases, amount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SetLimitAndServicesEntity) {
            SetLimitAndServicesEntity setLimitAndServicesEntity = (SetLimitAndServicesEntity) other;
            return Intrinsics.areEqual(this.memberId, setLimitAndServicesEntity.memberId) && Intrinsics.areEqual(this.useCases, setLimitAndServicesEntity.useCases) && Intrinsics.areEqual(this.amount, setLimitAndServicesEntity.amount);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.memberId.hashCode() * 31) + this.useCases.hashCode()) * 31) + this.amount.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SetLimitAndServicesEntity(memberId=");
        sb.append(this.memberId);
        sb.append(", useCases=");
        sb.append(this.useCases);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getMemberId")
    public final String getMemberId() {
        return this.memberId;
    }

    @JvmName(name = "getUseCases")
    public final List<String> getUseCases() {
        return this.useCases;
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    public SetLimitAndServicesEntity(String str, List<String> list, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.memberId = str;
        this.useCases = list;
        this.amount = str2;
    }
}
