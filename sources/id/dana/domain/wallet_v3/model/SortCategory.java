package id.dana.domain.wallet_v3.model;

import com.google.gson.annotations.SerializedName;
import id.dana.domain.pocket.model.AssetStatus;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/domain/wallet_v3/model/SortCategory;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lid/dana/domain/pocket/model/AssetStatus;", "component3", "()Lid/dana/domain/pocket/model/AssetStatus;", "titleEn", "titleId", "order", "copy", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/pocket/model/AssetStatus;)Lid/dana/domain/wallet_v3/model/SortCategory;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/domain/pocket/model/AssetStatus;", "getOrder", "Ljava/lang/String;", "getTitleEn", "getTitleId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/pocket/model/AssetStatus;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SortCategory {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    @SerializedName("asset_types")
    private final AssetStatus order;
    @SerializedName("title_en")
    private final String titleEn;
    @SerializedName("title_id")
    private final String titleId;

    public static /* synthetic */ SortCategory copy$default(SortCategory sortCategory, String str, String str2, AssetStatus assetStatus, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sortCategory.titleEn;
        }
        if ((i & 2) != 0) {
            str2 = sortCategory.titleId;
        }
        if ((i & 4) != 0) {
            assetStatus = sortCategory.order;
        }
        return sortCategory.copy(str, str2, assetStatus);
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

    public final SortCategory copy(String titleEn, String titleId, AssetStatus order) {
        Intrinsics.checkNotNullParameter(titleEn, "");
        Intrinsics.checkNotNullParameter(titleId, "");
        Intrinsics.checkNotNullParameter(order, "");
        return new SortCategory(titleEn, titleId, order);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SortCategory) {
            SortCategory sortCategory = (SortCategory) other;
            return Intrinsics.areEqual(this.titleEn, sortCategory.titleEn) && Intrinsics.areEqual(this.titleId, sortCategory.titleId) && this.order == sortCategory.order;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.titleEn.hashCode() * 31) + this.titleId.hashCode()) * 31) + this.order.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SortCategory(titleEn=");
        sb.append(this.titleEn);
        sb.append(", titleId=");
        sb.append(this.titleId);
        sb.append(", order=");
        sb.append(this.order);
        sb.append(')');
        return sb.toString();
    }

    public SortCategory(String str, String str2, AssetStatus assetStatus) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(assetStatus, "");
        this.titleEn = str;
        this.titleId = str2;
        this.order = assetStatus;
    }

    @JvmName(name = "getTitleEn")
    public final String getTitleEn() {
        return this.titleEn;
    }

    @JvmName(name = "getTitleId")
    public final String getTitleId() {
        return this.titleId;
    }

    public /* synthetic */ SortCategory(String str, String str2, AssetStatus assetStatus, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? AssetStatus.EXPIRING_SOON : assetStatus);
    }

    @JvmName(name = "getOrder")
    public final AssetStatus getOrder() {
        return this.order;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/domain/wallet_v3/model/SortCategory$Companion;", "", "", "Lid/dana/domain/wallet_v3/model/SortCategory;", "getDefault", "()Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<SortCategory> getDefault() {
            return CollectionsKt.listOf((Object[]) new SortCategory[]{new SortCategory("Expiring Soon", "Segera Kedaluwarsa", AssetStatus.EXPIRING_SOON), new SortCategory("Expiring Later", "Kedaluwarsa Nanti", AssetStatus.EXPIRING_LAST), new SortCategory("Recently Added", "Terakhir Ditambah", AssetStatus.NEWEST), new SortCategory("Earliest Added", "Paling Awal Ditambah", AssetStatus.OLDEST)});
        }
    }
}
