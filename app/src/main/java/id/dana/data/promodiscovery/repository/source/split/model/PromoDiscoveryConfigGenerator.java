package id.dana.data.promodiscovery.repository.source.split.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/promodiscovery/repository/source/split/model/PromoDiscoveryConfigGenerator;", "", "Lid/dana/data/promodiscovery/repository/source/split/model/PromoDiscoveryEntity;", "generatePromoDiscoveryConfig", "()Lid/dana/data/promodiscovery/repository/source/split/model/PromoDiscoveryEntity;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PromoDiscoveryConfigGenerator {
    public static final PromoDiscoveryConfigGenerator INSTANCE = new PromoDiscoveryConfigGenerator();

    private PromoDiscoveryConfigGenerator() {
    }

    public final PromoDiscoveryEntity generatePromoDiscoveryConfig() {
        int i = 0;
        boolean z = false;
        String str = null;
        int i2 = 7;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i3 = 0;
        boolean z2 = false;
        String str2 = null;
        int i4 = 7;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        return new PromoDiscoveryEntity(new DiscoverySectionEntity(0, false, null, 7, null), new DiscoverySectionEntity(i, z, str, i2, defaultConstructorMarker), new DiscoverySectionEntity(i3, z2, str2, i4, defaultConstructorMarker2), new DiscoverySectionEntity(i, z, str, i2, defaultConstructorMarker), new DiscoverySectionEntity(i3, z2, str2, i4, defaultConstructorMarker2));
    }
}
