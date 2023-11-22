package id.dana.wallet_v3.view.sort.model;

import id.dana.domain.pocket.model.AssetStatus;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004R\"\u0010\u000f\u001a\u00020\t8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000e\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b \u0010\u0004"}, d2 = {"Lid/dana/wallet_v3/view/sort/model/SortCategoryModel;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lid/dana/domain/pocket/model/AssetStatus;", "component3", "()Lid/dana/domain/pocket/model/AssetStatus;", "", "component4", "()Z", "titleEn", "titleId", "order", "isSelected", "copy", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/pocket/model/AssetStatus;Z)Lid/dana/wallet_v3/view/sort/model/SortCategoryModel;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "setSelected", "(Z)V", "Lid/dana/domain/pocket/model/AssetStatus;", "getOrder", "Ljava/lang/String;", "getTitleEn", "getTitleId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/pocket/model/AssetStatus;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class SortCategoryModel {
    private boolean isSelected;
    private final AssetStatus order;
    private final String titleEn;
    private final String titleId;

    public static /* synthetic */ SortCategoryModel copy$default(SortCategoryModel sortCategoryModel, String str, String str2, AssetStatus assetStatus, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sortCategoryModel.titleEn;
        }
        if ((i & 2) != 0) {
            str2 = sortCategoryModel.titleId;
        }
        if ((i & 4) != 0) {
            assetStatus = sortCategoryModel.order;
        }
        if ((i & 8) != 0) {
            z = sortCategoryModel.isSelected;
        }
        return sortCategoryModel.copy(str, str2, assetStatus, z);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTitleEn() {
        return this.titleEn;
    }

    /* renamed from: component2  reason: from getter */
    public final String getTitleId() {
        return this.titleId;
    }

    /* renamed from: component3  reason: from getter */
    public final AssetStatus getOrder() {
        return this.order;
    }

    /* renamed from: component4  reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final SortCategoryModel copy(String titleEn, String titleId, AssetStatus order, boolean isSelected) {
        Intrinsics.checkNotNullParameter(titleEn, "");
        Intrinsics.checkNotNullParameter(titleId, "");
        Intrinsics.checkNotNullParameter(order, "");
        return new SortCategoryModel(titleEn, titleId, order, isSelected);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SortCategoryModel) {
            SortCategoryModel sortCategoryModel = (SortCategoryModel) other;
            return Intrinsics.areEqual(this.titleEn, sortCategoryModel.titleEn) && Intrinsics.areEqual(this.titleId, sortCategoryModel.titleId) && this.order == sortCategoryModel.order && this.isSelected == sortCategoryModel.isSelected;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.titleEn.hashCode();
        int hashCode2 = this.titleId.hashCode();
        int hashCode3 = this.order.hashCode();
        boolean z = this.isSelected;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SortCategoryModel(titleEn=");
        sb.append(this.titleEn);
        sb.append(", titleId=");
        sb.append(this.titleId);
        sb.append(", order=");
        sb.append(this.order);
        sb.append(", isSelected=");
        sb.append(this.isSelected);
        sb.append(')');
        return sb.toString();
    }

    public SortCategoryModel(String str, String str2, AssetStatus assetStatus, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(assetStatus, "");
        this.titleEn = str;
        this.titleId = str2;
        this.order = assetStatus;
        this.isSelected = z;
    }

    @JvmName(name = "getTitleEn")
    public final String getTitleEn() {
        return this.titleEn;
    }

    @JvmName(name = "getTitleId")
    public final String getTitleId() {
        return this.titleId;
    }

    public /* synthetic */ SortCategoryModel(String str, String str2, AssetStatus assetStatus, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? AssetStatus.EXPIRING_SOON : assetStatus, (i & 8) != 0 ? false : z);
    }

    @JvmName(name = "getOrder")
    public final AssetStatus getOrder() {
        return this.order;
    }

    @JvmName(name = "isSelected")
    public final boolean isSelected() {
        return this.isSelected;
    }

    @JvmName(name = "setSelected")
    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}
