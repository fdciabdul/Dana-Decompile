package id.dana.kyb.data.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004"}, d2 = {"Lid/dana/kyb/data/model/KybStartupConfigResult;", "", "", "component1", "()Ljava/lang/Boolean;", "cashOutV2", "copy", "(Ljava/lang/Boolean;)Lid/dana/kyb/data/model/KybStartupConfigResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Boolean;", "getCashOutV2", "<init>", "(Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybStartupConfigResult {
    private final Boolean cashOutV2;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public KybStartupConfigResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.data.model.KybStartupConfigResult.<init>():void");
    }

    public static /* synthetic */ KybStartupConfigResult copy$default(KybStartupConfigResult kybStartupConfigResult, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = kybStartupConfigResult.cashOutV2;
        }
        return kybStartupConfigResult.copy(bool);
    }

    /* renamed from: component1  reason: from getter */
    public final Boolean getCashOutV2() {
        return this.cashOutV2;
    }

    public final KybStartupConfigResult copy(Boolean cashOutV2) {
        return new KybStartupConfigResult(cashOutV2);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof KybStartupConfigResult) && Intrinsics.areEqual(this.cashOutV2, ((KybStartupConfigResult) other).cashOutV2);
    }

    public final int hashCode() {
        Boolean bool = this.cashOutV2;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybStartupConfigResult(cashOutV2=");
        sb.append(this.cashOutV2);
        sb.append(')');
        return sb.toString();
    }

    public KybStartupConfigResult(Boolean bool) {
        this.cashOutV2 = bool;
    }

    public /* synthetic */ KybStartupConfigResult(Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool);
    }

    @JvmName(name = "getCashOutV2")
    public final Boolean getCashOutV2() {
        return this.cashOutV2;
    }
}
