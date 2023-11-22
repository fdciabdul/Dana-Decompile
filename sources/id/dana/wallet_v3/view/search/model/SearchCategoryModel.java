package id.dana.wallet_v3.view.search.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ4\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/wallet_v3/view/search/model/SearchCategoryModel;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/util/List;", "titleEn", "titleId", "assetTypes", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lid/dana/wallet_v3/view/search/model/SearchCategoryModel;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/List;", "getAssetTypes", "Ljava/lang/String;", "getTitleEn", "getTitleId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class SearchCategoryModel {
    private final List<String> assetTypes;
    private final String titleEn;
    private final String titleId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchCategoryModel copy$default(SearchCategoryModel searchCategoryModel, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = searchCategoryModel.titleEn;
        }
        if ((i & 2) != 0) {
            str2 = searchCategoryModel.titleId;
        }
        if ((i & 4) != 0) {
            list = searchCategoryModel.assetTypes;
        }
        return searchCategoryModel.copy(str, str2, list);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTitleEn() {
        return this.titleEn;
    }

    /* renamed from: component2  reason: from getter */
    public final String getTitleId() {
        return this.titleId;
    }

    public final List<String> component3() {
        return this.assetTypes;
    }

    public final SearchCategoryModel copy(String titleEn, String titleId, List<String> assetTypes) {
        Intrinsics.checkNotNullParameter(titleEn, "");
        Intrinsics.checkNotNullParameter(titleId, "");
        Intrinsics.checkNotNullParameter(assetTypes, "");
        return new SearchCategoryModel(titleEn, titleId, assetTypes);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SearchCategoryModel) {
            SearchCategoryModel searchCategoryModel = (SearchCategoryModel) other;
            return Intrinsics.areEqual(this.titleEn, searchCategoryModel.titleEn) && Intrinsics.areEqual(this.titleId, searchCategoryModel.titleId) && Intrinsics.areEqual(this.assetTypes, searchCategoryModel.assetTypes);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.titleEn.hashCode() * 31) + this.titleId.hashCode()) * 31) + this.assetTypes.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SearchCategoryModel(titleEn=");
        sb.append(this.titleEn);
        sb.append(", titleId=");
        sb.append(this.titleId);
        sb.append(", assetTypes=");
        sb.append(this.assetTypes);
        sb.append(')');
        return sb.toString();
    }

    public SearchCategoryModel(String str, String str2, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.titleEn = str;
        this.titleId = str2;
        this.assetTypes = list;
    }

    @JvmName(name = "getTitleEn")
    public final String getTitleEn() {
        return this.titleEn;
    }

    @JvmName(name = "getTitleId")
    public final String getTitleId() {
        return this.titleId;
    }

    public /* synthetic */ SearchCategoryModel(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getAssetTypes")
    public final List<String> getAssetTypes() {
        return this.assetTypes;
    }
}
