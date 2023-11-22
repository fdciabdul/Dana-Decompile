package id.dana.data.services.repository.source.model;

import com.google.gson.annotations.SerializedName;
import id.dana.animation.view.FourKingView;
import id.dana.domain.notificationcenter.interactor.ConnectionType;
import id.dana.domain.services.Category;
import id.dana.mybills.ui.constant.ServiceName;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/data/services/repository/source/model/CategoryServices;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "category", "en", "id", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/services/repository/source/model/CategoryServices;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCategory", "getEn", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CategoryServices {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    @SerializedName("category")
    private final String category;
    @SerializedName("en")
    private final String en;
    @SerializedName("id")
    private final String id;

    public static /* synthetic */ CategoryServices copy$default(CategoryServices categoryServices, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = categoryServices.category;
        }
        if ((i & 2) != 0) {
            str2 = categoryServices.en;
        }
        if ((i & 4) != 0) {
            str3 = categoryServices.id;
        }
        return categoryServices.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component2  reason: from getter */
    public final String getEn() {
        return this.en;
    }

    /* renamed from: component3  reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final CategoryServices copy(String category, String en, String id2) {
        Intrinsics.checkNotNullParameter(category, "");
        Intrinsics.checkNotNullParameter(en, "");
        Intrinsics.checkNotNullParameter(id2, "");
        return new CategoryServices(category, en, id2);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CategoryServices) {
            CategoryServices categoryServices = (CategoryServices) other;
            return Intrinsics.areEqual(this.category, categoryServices.category) && Intrinsics.areEqual(this.en, categoryServices.en) && Intrinsics.areEqual(this.id, categoryServices.id);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.category.hashCode() * 31) + this.en.hashCode()) * 31) + this.id.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CategoryServices(category=");
        sb.append(this.category);
        sb.append(", en=");
        sb.append(this.en);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(')');
        return sb.toString();
    }

    public CategoryServices(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.category = str;
        this.en = str2;
        this.id = str3;
    }

    @JvmName(name = "getCategory")
    public final String getCategory() {
        return this.category;
    }

    @JvmName(name = "getEn")
    public final String getEn() {
        return this.en;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/services/repository/source/model/CategoryServices$Companion;", "", "", "Lid/dana/data/services/repository/source/model/CategoryServices;", "getDefault", "()Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<CategoryServices> getDefault() {
            return CollectionsKt.listOf((Object[]) new CategoryServices[]{new CategoryServices(Category.FEATURED, "My Favourite", "Favorit Saya"), new CategoryServices("category_daily", "Daily", "Kebutuhan Harian"), new CategoryServices("category_transfer", "Transfer", "Transfer"), new CategoryServices("category_bills", "Bills", "Tagihan"), new CategoryServices("category_entertainment", "Entertainment", "Hiburan"), new CategoryServices(WalletConstant.CATEGORY_FINANCE, "Finance", "Keuangan"), new CategoryServices("category_top_up", FourKingView.FEATURE_TOP_UP, FourKingView.FEATURE_TOP_UP), new CategoryServices("category_insurance", ServiceName.INSURANCE, "Asuransi Pribadi"), new CategoryServices("category_charity", "Charity", "Donasi"), new CategoryServices("category_transportation", "Transportation", "Transportasi"), new CategoryServices("category_shopping", "Shopping", "Belanja"), new CategoryServices("category_health", "Health", "Kesehatan"), new CategoryServices("category_others", ConnectionType.OTHERS, "Lainnya")});
        }
    }
}
