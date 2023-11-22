package id.dana.explore.domain.globalsearch.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/explore/domain/globalsearch/model/ExploreRecommendedPopularPlaces;", "", "", "Lid/dana/explore/domain/globalsearch/model/PopularPlaceInfo;", "popularPlaces", "Ljava/util/List;", "getPopularPlaces", "()Ljava/util/List;", "", "showRecommendedPlacesWidget", "Z", "getShowRecommendedPlacesWidget", "()Z", "<init>", "(ZLjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExploreRecommendedPopularPlaces {
    private final List<PopularPlaceInfo> popularPlaces;
    private final boolean showRecommendedPlacesWidget;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ExploreRecommendedPopularPlaces() {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            r2 = 3
            r3.<init>(r1, r0, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.domain.globalsearch.model.ExploreRecommendedPopularPlaces.<init>():void");
    }

    public ExploreRecommendedPopularPlaces(boolean z, List<PopularPlaceInfo> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.showRecommendedPlacesWidget = z;
        this.popularPlaces = list;
    }

    @JvmName(name = "getShowRecommendedPlacesWidget")
    public final boolean getShowRecommendedPlacesWidget() {
        return this.showRecommendedPlacesWidget;
    }

    public /* synthetic */ ExploreRecommendedPopularPlaces(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getPopularPlaces")
    public final List<PopularPlaceInfo> getPopularPlaces() {
        return this.popularPlaces;
    }
}
