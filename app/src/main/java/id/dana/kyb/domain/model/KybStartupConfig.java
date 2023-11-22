package id.dana.kyb.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004"}, d2 = {"Lid/dana/kyb/domain/model/KybStartupConfig;", "", "", "component1", "()Z", "cashOutV2", "copy", "(Z)Lid/dana/kyb/domain/model/KybStartupConfig;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getCashOutV2", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybStartupConfig {
    private final boolean cashOutV2;

    public static /* synthetic */ KybStartupConfig copy$default(KybStartupConfig kybStartupConfig, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = kybStartupConfig.cashOutV2;
        }
        return kybStartupConfig.copy(z);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getCashOutV2() {
        return this.cashOutV2;
    }

    public final KybStartupConfig copy(boolean cashOutV2) {
        return new KybStartupConfig(cashOutV2);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof KybStartupConfig) && this.cashOutV2 == ((KybStartupConfig) other).cashOutV2;
    }

    public final int hashCode() {
        boolean z = this.cashOutV2;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybStartupConfig(cashOutV2=");
        sb.append(this.cashOutV2);
        sb.append(')');
        return sb.toString();
    }

    public KybStartupConfig(boolean z) {
        this.cashOutV2 = z;
    }

    @JvmName(name = "getCashOutV2")
    public final boolean getCashOutV2() {
        return this.cashOutV2;
    }
}
