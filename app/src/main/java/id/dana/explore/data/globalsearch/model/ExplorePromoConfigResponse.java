package id.dana.explore.data.globalsearch.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/explore/data/globalsearch/model/ExplorePromoConfigResponse;", "", "", "promoBannerLimit", "Ljava/lang/Integer;", "getPromoBannerLimit", "()Ljava/lang/Integer;", "<init>", "(Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExplorePromoConfigResponse {
    public Integer promoBannerLimit;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Integer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ExplorePromoConfigResponse() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.data.globalsearch.model.ExplorePromoConfigResponse.<init>():void");
    }

    public ExplorePromoConfigResponse(Integer num) {
        this.promoBannerLimit = num;
    }

    public /* synthetic */ ExplorePromoConfigResponse(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num);
    }

    @JvmName(name = "getPromoBannerLimit")
    public final Integer getPromoBannerLimit() {
        return this.promoBannerLimit;
    }
}
