package id.dana.domain.saving.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u000e\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\b"}, d2 = {"Lid/dana/domain/saving/model/SavingDetail;", "", "Lid/dana/domain/saving/model/SavingGoalView;", "component1", "()Lid/dana/domain/saving/model/SavingGoalView;", "", "Lid/dana/domain/saving/model/TopUpView;", "component2", "()Ljava/util/List;", "", "component3", "()Z", "savingGoalView", "topUpViews", "hasNext", "copy", "(Lid/dana/domain/saving/model/SavingGoalView;Ljava/util/List;Z)Lid/dana/domain/saving/model/SavingDetail;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getHasNext", "Lid/dana/domain/saving/model/SavingGoalView;", "getSavingGoalView", "Ljava/util/List;", "getTopUpViews", "<init>", "(Lid/dana/domain/saving/model/SavingGoalView;Ljava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SavingDetail {
    private final boolean hasNext;
    private final SavingGoalView savingGoalView;
    private final List<TopUpView> topUpViews;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SavingDetail copy$default(SavingDetail savingDetail, SavingGoalView savingGoalView, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            savingGoalView = savingDetail.savingGoalView;
        }
        if ((i & 2) != 0) {
            list = savingDetail.topUpViews;
        }
        if ((i & 4) != 0) {
            z = savingDetail.hasNext;
        }
        return savingDetail.copy(savingGoalView, list, z);
    }

    /* renamed from: component1  reason: from getter */
    public final SavingGoalView getSavingGoalView() {
        return this.savingGoalView;
    }

    public final List<TopUpView> component2() {
        return this.topUpViews;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getHasNext() {
        return this.hasNext;
    }

    public final SavingDetail copy(SavingGoalView savingGoalView, List<TopUpView> topUpViews, boolean hasNext) {
        Intrinsics.checkNotNullParameter(savingGoalView, "");
        Intrinsics.checkNotNullParameter(topUpViews, "");
        return new SavingDetail(savingGoalView, topUpViews, hasNext);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SavingDetail) {
            SavingDetail savingDetail = (SavingDetail) other;
            return Intrinsics.areEqual(this.savingGoalView, savingDetail.savingGoalView) && Intrinsics.areEqual(this.topUpViews, savingDetail.topUpViews) && this.hasNext == savingDetail.hasNext;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.savingGoalView.hashCode();
        int hashCode2 = this.topUpViews.hashCode();
        boolean z = this.hasNext;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((hashCode * 31) + hashCode2) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingDetail(savingGoalView=");
        sb.append(this.savingGoalView);
        sb.append(", topUpViews=");
        sb.append(this.topUpViews);
        sb.append(", hasNext=");
        sb.append(this.hasNext);
        sb.append(')');
        return sb.toString();
    }

    public SavingDetail(SavingGoalView savingGoalView, List<TopUpView> list, boolean z) {
        Intrinsics.checkNotNullParameter(savingGoalView, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.savingGoalView = savingGoalView;
        this.topUpViews = list;
        this.hasNext = z;
    }

    @JvmName(name = "getSavingGoalView")
    public final SavingGoalView getSavingGoalView() {
        return this.savingGoalView;
    }

    @JvmName(name = "getTopUpViews")
    public final List<TopUpView> getTopUpViews() {
        return this.topUpViews;
    }

    @JvmName(name = "getHasNext")
    public final boolean getHasNext() {
        return this.hasNext;
    }
}
