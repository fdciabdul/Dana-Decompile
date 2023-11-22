package id.dana.domain.featureconfig.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/featureconfig/model/ExplorePromoConfig;", "", "", "promoBannerLimit", "I", "getPromoBannerLimit", "()I", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExplorePromoConfig {
    private final int promoBannerLimit;

    public ExplorePromoConfig() {
        this(0, 1, null);
    }

    public ExplorePromoConfig(int i) {
        this.promoBannerLimit = i;
    }

    public /* synthetic */ ExplorePromoConfig(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 5 : i);
    }

    @JvmName(name = "getPromoBannerLimit")
    public final int getPromoBannerLimit() {
        return this.promoBannerLimit;
    }
}
