package id.dana.domain.saving.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/domain/saving/model/SavingLimit;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "maxSavingCountNonKyc", "maxSavingAmountNonKyc", "maxSavingAmountKyc", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/saving/model/SavingLimit;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getMaxSavingAmountKyc", "getMaxSavingAmountNonKyc", "getMaxSavingCountNonKyc", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SavingLimit {
    private final String maxSavingAmountKyc;
    private final String maxSavingAmountNonKyc;
    private final String maxSavingCountNonKyc;

    public static /* synthetic */ SavingLimit copy$default(SavingLimit savingLimit, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = savingLimit.maxSavingCountNonKyc;
        }
        if ((i & 2) != 0) {
            str2 = savingLimit.maxSavingAmountNonKyc;
        }
        if ((i & 4) != 0) {
            str3 = savingLimit.maxSavingAmountKyc;
        }
        return savingLimit.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMaxSavingCountNonKyc() {
        return this.maxSavingCountNonKyc;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMaxSavingAmountNonKyc() {
        return this.maxSavingAmountNonKyc;
    }

    /* renamed from: component3  reason: from getter */
    public final String getMaxSavingAmountKyc() {
        return this.maxSavingAmountKyc;
    }

    public final SavingLimit copy(String maxSavingCountNonKyc, String maxSavingAmountNonKyc, String maxSavingAmountKyc) {
        Intrinsics.checkNotNullParameter(maxSavingCountNonKyc, "");
        Intrinsics.checkNotNullParameter(maxSavingAmountNonKyc, "");
        Intrinsics.checkNotNullParameter(maxSavingAmountKyc, "");
        return new SavingLimit(maxSavingCountNonKyc, maxSavingAmountNonKyc, maxSavingAmountKyc);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SavingLimit) {
            SavingLimit savingLimit = (SavingLimit) other;
            return Intrinsics.areEqual(this.maxSavingCountNonKyc, savingLimit.maxSavingCountNonKyc) && Intrinsics.areEqual(this.maxSavingAmountNonKyc, savingLimit.maxSavingAmountNonKyc) && Intrinsics.areEqual(this.maxSavingAmountKyc, savingLimit.maxSavingAmountKyc);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.maxSavingCountNonKyc.hashCode() * 31) + this.maxSavingAmountNonKyc.hashCode()) * 31) + this.maxSavingAmountKyc.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingLimit(maxSavingCountNonKyc=");
        sb.append(this.maxSavingCountNonKyc);
        sb.append(", maxSavingAmountNonKyc=");
        sb.append(this.maxSavingAmountNonKyc);
        sb.append(", maxSavingAmountKyc=");
        sb.append(this.maxSavingAmountKyc);
        sb.append(')');
        return sb.toString();
    }

    public SavingLimit(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.maxSavingCountNonKyc = str;
        this.maxSavingAmountNonKyc = str2;
        this.maxSavingAmountKyc = str3;
    }

    @JvmName(name = "getMaxSavingCountNonKyc")
    public final String getMaxSavingCountNonKyc() {
        return this.maxSavingCountNonKyc;
    }

    @JvmName(name = "getMaxSavingAmountNonKyc")
    public final String getMaxSavingAmountNonKyc() {
        return this.maxSavingAmountNonKyc;
    }

    @JvmName(name = "getMaxSavingAmountKyc")
    public final String getMaxSavingAmountKyc() {
        return this.maxSavingAmountKyc;
    }
}
