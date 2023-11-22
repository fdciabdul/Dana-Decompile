package id.dana.data.saving.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\u000e\b\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\t\u001a\u00020\u00022\u000e\b\u0003\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u001aR(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/data/saving/model/SavingEmptyStateEntity;", "", "Lid/dana/data/saving/model/MainEmptyStateEntity;", "component1", "()Lid/dana/data/saving/model/MainEmptyStateEntity;", "", "Lid/dana/data/saving/model/SavingBenefitEntity;", "component2", "()Ljava/util/List;", "mainEmptyState", "savingBenefit", "copy", "(Lid/dana/data/saving/model/MainEmptyStateEntity;Ljava/util/List;)Lid/dana/data/saving/model/SavingEmptyStateEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/data/saving/model/MainEmptyStateEntity;", "getMainEmptyState", "setMainEmptyState", "(Lid/dana/data/saving/model/MainEmptyStateEntity;)V", "Ljava/util/List;", "getSavingBenefit", "setSavingBenefit", "(Ljava/util/List;)V", "<init>", "(Lid/dana/data/saving/model/MainEmptyStateEntity;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SavingEmptyStateEntity {
    public MainEmptyStateEntity mainEmptyState;
    public List<SavingBenefitEntity> savingBenefit;

    public /* synthetic */ SavingEmptyStateEntity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SavingEmptyStateEntity copy$default(SavingEmptyStateEntity savingEmptyStateEntity, MainEmptyStateEntity mainEmptyStateEntity, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            mainEmptyStateEntity = savingEmptyStateEntity.mainEmptyState;
        }
        if ((i & 2) != 0) {
            list = savingEmptyStateEntity.savingBenefit;
        }
        return savingEmptyStateEntity.copy(mainEmptyStateEntity, list);
    }

    /* renamed from: component1  reason: from getter */
    public final MainEmptyStateEntity getMainEmptyState() {
        return this.mainEmptyState;
    }

    public final List<SavingBenefitEntity> component2() {
        return this.savingBenefit;
    }

    public final SavingEmptyStateEntity copy(@JSONField(name = "main_empty_state") MainEmptyStateEntity mainEmptyState, @JSONField(name = "benefit_list") List<SavingBenefitEntity> savingBenefit) {
        Intrinsics.checkNotNullParameter(mainEmptyState, "");
        Intrinsics.checkNotNullParameter(savingBenefit, "");
        return new SavingEmptyStateEntity(mainEmptyState, savingBenefit);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SavingEmptyStateEntity) {
            SavingEmptyStateEntity savingEmptyStateEntity = (SavingEmptyStateEntity) other;
            return Intrinsics.areEqual(this.mainEmptyState, savingEmptyStateEntity.mainEmptyState) && Intrinsics.areEqual(this.savingBenefit, savingEmptyStateEntity.savingBenefit);
        }
        return false;
    }

    public final int hashCode() {
        return (this.mainEmptyState.hashCode() * 31) + this.savingBenefit.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingEmptyStateEntity(mainEmptyState=");
        sb.append(this.mainEmptyState);
        sb.append(", savingBenefit=");
        sb.append(this.savingBenefit);
        sb.append(')');
        return sb.toString();
    }

    public SavingEmptyStateEntity(@JSONField(name = "main_empty_state") MainEmptyStateEntity mainEmptyStateEntity, @JSONField(name = "benefit_list") List<SavingBenefitEntity> list) {
        Intrinsics.checkNotNullParameter(mainEmptyStateEntity, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.mainEmptyState = mainEmptyStateEntity;
        this.savingBenefit = list;
    }

    @JvmName(name = "getMainEmptyState")
    public final MainEmptyStateEntity getMainEmptyState() {
        return this.mainEmptyState;
    }

    @JvmName(name = "setMainEmptyState")
    public final void setMainEmptyState(MainEmptyStateEntity mainEmptyStateEntity) {
        Intrinsics.checkNotNullParameter(mainEmptyStateEntity, "");
        this.mainEmptyState = mainEmptyStateEntity;
    }

    @JvmName(name = "getSavingBenefit")
    public final List<SavingBenefitEntity> getSavingBenefit() {
        return this.savingBenefit;
    }

    @JvmName(name = "setSavingBenefit")
    public final void setSavingBenefit(List<SavingBenefitEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.savingBenefit = list;
    }
}
