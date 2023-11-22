package id.dana.mybills.data.model.response;

import id.dana.network.base.BaseRpcResultAphome;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ4\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\n\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\t"}, d2 = {"Lid/dana/mybills/data/model/response/UniqueValueResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()I", "component2", "", "Lid/dana/mybills/data/model/response/SubscriptionItem;", "component3", "()Ljava/util/List;", "autodeductionCount", "reminderCount", "values", "copy", "(IILjava/util/List;)Lid/dana/mybills/data/model/response/UniqueValueResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getAutodeductionCount", "getReminderCount", "Ljava/util/List;", "getValues", "<init>", "(IILjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UniqueValueResult extends BaseRpcResultAphome {
    private final int autodeductionCount;
    private final int reminderCount;
    private final List<SubscriptionItem> values;

    public UniqueValueResult() {
        this(0, 0, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UniqueValueResult copy$default(UniqueValueResult uniqueValueResult, int i, int i2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = uniqueValueResult.autodeductionCount;
        }
        if ((i3 & 2) != 0) {
            i2 = uniqueValueResult.reminderCount;
        }
        if ((i3 & 4) != 0) {
            list = uniqueValueResult.values;
        }
        return uniqueValueResult.copy(i, i2, list);
    }

    /* renamed from: component1  reason: from getter */
    public final int getAutodeductionCount() {
        return this.autodeductionCount;
    }

    /* renamed from: component2  reason: from getter */
    public final int getReminderCount() {
        return this.reminderCount;
    }

    public final List<SubscriptionItem> component3() {
        return this.values;
    }

    public final UniqueValueResult copy(int autodeductionCount, int reminderCount, List<SubscriptionItem> values) {
        Intrinsics.checkNotNullParameter(values, "");
        return new UniqueValueResult(autodeductionCount, reminderCount, values);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UniqueValueResult) {
            UniqueValueResult uniqueValueResult = (UniqueValueResult) other;
            return this.autodeductionCount == uniqueValueResult.autodeductionCount && this.reminderCount == uniqueValueResult.reminderCount && Intrinsics.areEqual(this.values, uniqueValueResult.values);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.autodeductionCount * 31) + this.reminderCount) * 31) + this.values.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UniqueValueResult(autodeductionCount=");
        sb.append(this.autodeductionCount);
        sb.append(", reminderCount=");
        sb.append(this.reminderCount);
        sb.append(", values=");
        sb.append(this.values);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getAutodeductionCount")
    public final int getAutodeductionCount() {
        return this.autodeductionCount;
    }

    @JvmName(name = "getReminderCount")
    public final int getReminderCount() {
        return this.reminderCount;
    }

    public /* synthetic */ UniqueValueResult(int i, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getValues")
    public final List<SubscriptionItem> getValues() {
        return this.values;
    }

    public UniqueValueResult(int i, int i2, List<SubscriptionItem> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.autodeductionCount = i;
        this.reminderCount = i2;
        this.values = list;
    }
}
