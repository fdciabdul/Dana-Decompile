package id.dana.domain.saving.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.domain.nearbyme.model.MoneyView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\b\b\u0002\u0010\u001a\u001a\u00020\f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\f\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0010 \u001a\u00020\u0005¢\u0006\u0004\b=\u0010>J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000bJ\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016Jz\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\t2\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010 \u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010$\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b)\u0010\u000eR\u0017\u0010 \u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b \u0010*\u001a\u0004\b+\u0010\u0007R\u001a\u0010\u0018\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b-\u0010\u0004R\"\u0010\u001c\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010.\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u00101R\"\u0010\u001b\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010.\u001a\u0004\b2\u0010\u000e\"\u0004\b3\u00101R\u001a\u0010\u0019\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00104\u001a\u0004\b5\u0010\u000bR\"\u0010\u001a\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010.\u001a\u0004\b6\u0010\u000e\"\u0004\b7\u00101R\u001a\u0010\u001d\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b8\u0010\u0004R\u001a\u0010\u001e\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00104\u001a\u0004\b9\u0010\u000bR\u001a\u0010\u0017\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b:\u0010\u0004R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010;\u001a\u0004\b<\u0010\u0016"}, d2 = {"Lid/dana/domain/saving/model/SavingSummary;", "", "Lid/dana/domain/nearbyme/model/MoneyView;", "component1", "()Lid/dana/domain/nearbyme/model/MoneyView;", "", "component10", "()Z", "component2", "", "component3", "()J", "", "component4", "()Ljava/lang/String;", "component5", "component6", "component7", "component8", "", "Lid/dana/domain/saving/model/SavingGoalView;", "component9", "()Ljava/util/List;", "savingBalanceAmount", "maxSavingAmount", "maxSavingCount", "maxSavingCountNonKyc", "maxSavingAmountNonKyc", "maxSavingAmountKyc", "remainingAmount", "remainingCount", "savingGoalViews", "hasNext", "copy", "(Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;JLjava/util/List;Z)Lid/dana/domain/saving/model/SavingSummary;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getHasNext", "Lid/dana/domain/nearbyme/model/MoneyView;", "getMaxSavingAmount", "Ljava/lang/String;", "getMaxSavingAmountKyc", "setMaxSavingAmountKyc", "(Ljava/lang/String;)V", "getMaxSavingAmountNonKyc", "setMaxSavingAmountNonKyc", "J", "getMaxSavingCount", "getMaxSavingCountNonKyc", "setMaxSavingCountNonKyc", "getRemainingAmount", "getRemainingCount", "getSavingBalanceAmount", "Ljava/util/List;", "getSavingGoalViews", "<init>", "(Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;JLjava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SavingSummary {
    private final boolean hasNext;
    private final MoneyView maxSavingAmount;
    private String maxSavingAmountKyc;
    private String maxSavingAmountNonKyc;
    private final long maxSavingCount;
    private String maxSavingCountNonKyc;
    private final MoneyView remainingAmount;
    private final long remainingCount;
    private final MoneyView savingBalanceAmount;
    private final List<SavingGoalView> savingGoalViews;

    /* renamed from: component1  reason: from getter */
    public final MoneyView getSavingBalanceAmount() {
        return this.savingBalanceAmount;
    }

    /* renamed from: component10  reason: from getter */
    public final boolean getHasNext() {
        return this.hasNext;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyView getMaxSavingAmount() {
        return this.maxSavingAmount;
    }

    /* renamed from: component3  reason: from getter */
    public final long getMaxSavingCount() {
        return this.maxSavingCount;
    }

    /* renamed from: component4  reason: from getter */
    public final String getMaxSavingCountNonKyc() {
        return this.maxSavingCountNonKyc;
    }

    /* renamed from: component5  reason: from getter */
    public final String getMaxSavingAmountNonKyc() {
        return this.maxSavingAmountNonKyc;
    }

    /* renamed from: component6  reason: from getter */
    public final String getMaxSavingAmountKyc() {
        return this.maxSavingAmountKyc;
    }

    /* renamed from: component7  reason: from getter */
    public final MoneyView getRemainingAmount() {
        return this.remainingAmount;
    }

    /* renamed from: component8  reason: from getter */
    public final long getRemainingCount() {
        return this.remainingCount;
    }

    public final List<SavingGoalView> component9() {
        return this.savingGoalViews;
    }

    public final SavingSummary copy(MoneyView savingBalanceAmount, MoneyView maxSavingAmount, long maxSavingCount, String maxSavingCountNonKyc, String maxSavingAmountNonKyc, String maxSavingAmountKyc, MoneyView remainingAmount, long remainingCount, List<SavingGoalView> savingGoalViews, boolean hasNext) {
        Intrinsics.checkNotNullParameter(savingBalanceAmount, "");
        Intrinsics.checkNotNullParameter(maxSavingAmount, "");
        Intrinsics.checkNotNullParameter(maxSavingCountNonKyc, "");
        Intrinsics.checkNotNullParameter(maxSavingAmountNonKyc, "");
        Intrinsics.checkNotNullParameter(maxSavingAmountKyc, "");
        Intrinsics.checkNotNullParameter(remainingAmount, "");
        Intrinsics.checkNotNullParameter(savingGoalViews, "");
        return new SavingSummary(savingBalanceAmount, maxSavingAmount, maxSavingCount, maxSavingCountNonKyc, maxSavingAmountNonKyc, maxSavingAmountKyc, remainingAmount, remainingCount, savingGoalViews, hasNext);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SavingSummary) {
            SavingSummary savingSummary = (SavingSummary) other;
            return Intrinsics.areEqual(this.savingBalanceAmount, savingSummary.savingBalanceAmount) && Intrinsics.areEqual(this.maxSavingAmount, savingSummary.maxSavingAmount) && this.maxSavingCount == savingSummary.maxSavingCount && Intrinsics.areEqual(this.maxSavingCountNonKyc, savingSummary.maxSavingCountNonKyc) && Intrinsics.areEqual(this.maxSavingAmountNonKyc, savingSummary.maxSavingAmountNonKyc) && Intrinsics.areEqual(this.maxSavingAmountKyc, savingSummary.maxSavingAmountKyc) && Intrinsics.areEqual(this.remainingAmount, savingSummary.remainingAmount) && this.remainingCount == savingSummary.remainingCount && Intrinsics.areEqual(this.savingGoalViews, savingSummary.savingGoalViews) && this.hasNext == savingSummary.hasNext;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.savingBalanceAmount.hashCode();
        int hashCode2 = this.maxSavingAmount.hashCode();
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.maxSavingCount);
        int hashCode3 = this.maxSavingCountNonKyc.hashCode();
        int hashCode4 = this.maxSavingAmountNonKyc.hashCode();
        int hashCode5 = this.maxSavingAmountKyc.hashCode();
        int hashCode6 = this.remainingAmount.hashCode();
        int m2 = Cbor$Arg$$ExternalSyntheticBackport0.m(this.remainingCount);
        int hashCode7 = this.savingGoalViews.hashCode();
        boolean z = this.hasNext;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((((((((((hashCode * 31) + hashCode2) * 31) + m) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + m2) * 31) + hashCode7) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingSummary(savingBalanceAmount=");
        sb.append(this.savingBalanceAmount);
        sb.append(", maxSavingAmount=");
        sb.append(this.maxSavingAmount);
        sb.append(", maxSavingCount=");
        sb.append(this.maxSavingCount);
        sb.append(", maxSavingCountNonKyc=");
        sb.append(this.maxSavingCountNonKyc);
        sb.append(", maxSavingAmountNonKyc=");
        sb.append(this.maxSavingAmountNonKyc);
        sb.append(", maxSavingAmountKyc=");
        sb.append(this.maxSavingAmountKyc);
        sb.append(", remainingAmount=");
        sb.append(this.remainingAmount);
        sb.append(", remainingCount=");
        sb.append(this.remainingCount);
        sb.append(", savingGoalViews=");
        sb.append(this.savingGoalViews);
        sb.append(", hasNext=");
        sb.append(this.hasNext);
        sb.append(')');
        return sb.toString();
    }

    public SavingSummary(MoneyView moneyView, MoneyView moneyView2, long j, String str, String str2, String str3, MoneyView moneyView3, long j2, List<SavingGoalView> list, boolean z) {
        Intrinsics.checkNotNullParameter(moneyView, "");
        Intrinsics.checkNotNullParameter(moneyView2, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(moneyView3, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.savingBalanceAmount = moneyView;
        this.maxSavingAmount = moneyView2;
        this.maxSavingCount = j;
        this.maxSavingCountNonKyc = str;
        this.maxSavingAmountNonKyc = str2;
        this.maxSavingAmountKyc = str3;
        this.remainingAmount = moneyView3;
        this.remainingCount = j2;
        this.savingGoalViews = list;
        this.hasNext = z;
    }

    public /* synthetic */ SavingSummary(MoneyView moneyView, MoneyView moneyView2, long j, String str, String str2, String str3, MoneyView moneyView3, long j2, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(moneyView, moneyView2, j, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? "" : str2, (i & 32) != 0 ? "" : str3, moneyView3, j2, list, z);
    }

    @JvmName(name = "getSavingBalanceAmount")
    public final MoneyView getSavingBalanceAmount() {
        return this.savingBalanceAmount;
    }

    @JvmName(name = "getMaxSavingAmount")
    public final MoneyView getMaxSavingAmount() {
        return this.maxSavingAmount;
    }

    @JvmName(name = "getMaxSavingCount")
    public final long getMaxSavingCount() {
        return this.maxSavingCount;
    }

    @JvmName(name = "getMaxSavingCountNonKyc")
    public final String getMaxSavingCountNonKyc() {
        return this.maxSavingCountNonKyc;
    }

    @JvmName(name = "setMaxSavingCountNonKyc")
    public final void setMaxSavingCountNonKyc(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.maxSavingCountNonKyc = str;
    }

    @JvmName(name = "getMaxSavingAmountNonKyc")
    public final String getMaxSavingAmountNonKyc() {
        return this.maxSavingAmountNonKyc;
    }

    @JvmName(name = "setMaxSavingAmountNonKyc")
    public final void setMaxSavingAmountNonKyc(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.maxSavingAmountNonKyc = str;
    }

    @JvmName(name = "getMaxSavingAmountKyc")
    public final String getMaxSavingAmountKyc() {
        return this.maxSavingAmountKyc;
    }

    @JvmName(name = "setMaxSavingAmountKyc")
    public final void setMaxSavingAmountKyc(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.maxSavingAmountKyc = str;
    }

    @JvmName(name = "getRemainingAmount")
    public final MoneyView getRemainingAmount() {
        return this.remainingAmount;
    }

    @JvmName(name = "getRemainingCount")
    public final long getRemainingCount() {
        return this.remainingCount;
    }

    @JvmName(name = "getSavingGoalViews")
    public final List<SavingGoalView> getSavingGoalViews() {
        return this.savingGoalViews;
    }

    @JvmName(name = "getHasNext")
    public final boolean getHasNext() {
        return this.hasNext;
    }
}
