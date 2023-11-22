package id.dana.data.account;

import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/data/account/TransactionEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "type", MaintenanceBroadcastResult.KEY_DATE, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/account/TransactionEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getDate", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TransactionEntity {
    private final String date;
    private final String type;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TransactionEntity() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.account.TransactionEntity.<init>():void");
    }

    public static /* synthetic */ TransactionEntity copy$default(TransactionEntity transactionEntity, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = transactionEntity.type;
        }
        if ((i & 2) != 0) {
            str2 = transactionEntity.date;
        }
        return transactionEntity.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2  reason: from getter */
    public final String getDate() {
        return this.date;
    }

    public final TransactionEntity copy(String type, String date) {
        return new TransactionEntity(type, date);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TransactionEntity) {
            TransactionEntity transactionEntity = (TransactionEntity) other;
            return Intrinsics.areEqual(this.type, transactionEntity.type) && Intrinsics.areEqual(this.date, transactionEntity.date);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.type;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.date;
        return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransactionEntity(type=");
        sb.append(this.type);
        sb.append(", date=");
        sb.append(this.date);
        sb.append(')');
        return sb.toString();
    }

    public TransactionEntity(String str, String str2) {
        this.type = str;
        this.date = str2;
    }

    public /* synthetic */ TransactionEntity(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getDate")
    public final String getDate() {
        return this.date;
    }
}
