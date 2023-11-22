package id.dana.data.homeinfo.repository.source.network.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007"}, d2 = {"Lid/dana/data/homeinfo/repository/source/network/result/ProcessingTransactionResult;", "", "", "component1", "()Ljava/lang/Integer;", "", "component2", "()Ljava/lang/Boolean;", "count", "hasMore", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;)Lid/dana/data/homeinfo/repository/source/network/result/ProcessingTransactionResult;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getCount", "Ljava/lang/Boolean;", "getHasMore", "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ProcessingTransactionResult {
    @SerializedName("count")
    private final Integer count;
    @SerializedName("hasMore")
    private final Boolean hasMore;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean, java.lang.Integer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ProcessingTransactionResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.homeinfo.repository.source.network.result.ProcessingTransactionResult.<init>():void");
    }

    public static /* synthetic */ ProcessingTransactionResult copy$default(ProcessingTransactionResult processingTransactionResult, Integer num, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = processingTransactionResult.count;
        }
        if ((i & 2) != 0) {
            bool = processingTransactionResult.hasMore;
        }
        return processingTransactionResult.copy(num, bool);
    }

    /* renamed from: component1  reason: from getter */
    public final Integer getCount() {
        return this.count;
    }

    /* renamed from: component2  reason: from getter */
    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public final ProcessingTransactionResult copy(@JSONField(name = "count") Integer count, @JSONField(name = "hasMore") Boolean hasMore) {
        return new ProcessingTransactionResult(count, hasMore);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ProcessingTransactionResult) {
            ProcessingTransactionResult processingTransactionResult = (ProcessingTransactionResult) other;
            return Intrinsics.areEqual(this.count, processingTransactionResult.count) && Intrinsics.areEqual(this.hasMore, processingTransactionResult.hasMore);
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.count;
        int hashCode = num == null ? 0 : num.hashCode();
        Boolean bool = this.hasMore;
        return (hashCode * 31) + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProcessingTransactionResult(count=");
        sb.append(this.count);
        sb.append(", hasMore=");
        sb.append(this.hasMore);
        sb.append(')');
        return sb.toString();
    }

    public ProcessingTransactionResult(@JSONField(name = "count") Integer num, @JSONField(name = "hasMore") Boolean bool) {
        this.count = num;
        this.hasMore = bool;
    }

    public /* synthetic */ ProcessingTransactionResult(Integer num, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : bool);
    }

    @JvmName(name = "getCount")
    public final Integer getCount() {
        return this.count;
    }

    @JvmName(name = "getHasMore")
    public final Boolean getHasMore() {
        return this.hasMore;
    }
}
