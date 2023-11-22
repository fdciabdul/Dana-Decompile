package id.dana.domain.homeinfo;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007"}, d2 = {"Lid/dana/domain/homeinfo/ProcessingTransactionModel;", "", "", "component1", "()I", "", "component2", "()Z", "count", "hasMore", "copy", "(IZ)Lid/dana/domain/homeinfo/ProcessingTransactionModel;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getCount", "Z", "getHasMore", "<init>", "(IZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ProcessingTransactionModel {
    private final int count;
    private final boolean hasMore;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ProcessingTransactionModel() {
        /*
            r3 = this;
            r0 = 0
            r1 = 3
            r2 = 0
            r3.<init>(r0, r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.homeinfo.ProcessingTransactionModel.<init>():void");
    }

    public static /* synthetic */ ProcessingTransactionModel copy$default(ProcessingTransactionModel processingTransactionModel, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = processingTransactionModel.count;
        }
        if ((i2 & 2) != 0) {
            z = processingTransactionModel.hasMore;
        }
        return processingTransactionModel.copy(i, z);
    }

    /* renamed from: component1  reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final ProcessingTransactionModel copy(int count, boolean hasMore) {
        return new ProcessingTransactionModel(count, hasMore);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ProcessingTransactionModel) {
            ProcessingTransactionModel processingTransactionModel = (ProcessingTransactionModel) other;
            return this.count == processingTransactionModel.count && this.hasMore == processingTransactionModel.hasMore;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int i = this.count;
        boolean z = this.hasMore;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return (i * 31) + i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProcessingTransactionModel(count=");
        sb.append(this.count);
        sb.append(", hasMore=");
        sb.append(this.hasMore);
        sb.append(')');
        return sb.toString();
    }

    public ProcessingTransactionModel(int i, boolean z) {
        this.count = i;
        this.hasMore = z;
    }

    public /* synthetic */ ProcessingTransactionModel(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z);
    }

    @JvmName(name = "getCount")
    public final int getCount() {
        return this.count;
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }
}
