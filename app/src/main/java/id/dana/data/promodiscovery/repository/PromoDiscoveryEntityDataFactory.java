package id.dana.data.promodiscovery.repository;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.promodiscovery.repository.source.local.LocalPromoDiscoveryEntityData;
import id.dana.data.promodiscovery.repository.source.network.NetworkPromoDiscoveryEntityData;
import id.dana.data.promodiscovery.repository.source.split.SplitPromoDiscoveryConfigEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/data/promodiscovery/repository/PromoDiscoveryEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/promodiscovery/repository/PromoDiscoveryEntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/promodiscovery/repository/PromoDiscoveryEntityData;", "Lid/dana/data/promodiscovery/repository/source/local/LocalPromoDiscoveryEntityData;", "localPromoDiscoveryEntityData", "Lid/dana/data/promodiscovery/repository/source/local/LocalPromoDiscoveryEntityData;", "Lid/dana/data/promodiscovery/repository/source/network/NetworkPromoDiscoveryEntityData;", "networkPromoDiscoveryEntityData", "Lid/dana/data/promodiscovery/repository/source/network/NetworkPromoDiscoveryEntityData;", "Lid/dana/data/promodiscovery/repository/source/split/SplitPromoDiscoveryConfigEntityData;", "splitPromoDiscoveryConfigEntityData", "Lid/dana/data/promodiscovery/repository/source/split/SplitPromoDiscoveryConfigEntityData;", "<init>", "(Lid/dana/data/promodiscovery/repository/source/split/SplitPromoDiscoveryConfigEntityData;Lid/dana/data/promodiscovery/repository/source/network/NetworkPromoDiscoveryEntityData;Lid/dana/data/promodiscovery/repository/source/local/LocalPromoDiscoveryEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PromoDiscoveryEntityDataFactory extends AbstractEntityDataFactory<PromoDiscoveryEntityData> {
    private final LocalPromoDiscoveryEntityData localPromoDiscoveryEntityData;
    private final NetworkPromoDiscoveryEntityData networkPromoDiscoveryEntityData;
    private final SplitPromoDiscoveryConfigEntityData splitPromoDiscoveryConfigEntityData;

    @Inject
    public PromoDiscoveryEntityDataFactory(SplitPromoDiscoveryConfigEntityData splitPromoDiscoveryConfigEntityData, NetworkPromoDiscoveryEntityData networkPromoDiscoveryEntityData, LocalPromoDiscoveryEntityData localPromoDiscoveryEntityData) {
        Intrinsics.checkNotNullParameter(splitPromoDiscoveryConfigEntityData, "");
        Intrinsics.checkNotNullParameter(networkPromoDiscoveryEntityData, "");
        Intrinsics.checkNotNullParameter(localPromoDiscoveryEntityData, "");
        this.splitPromoDiscoveryConfigEntityData = splitPromoDiscoveryConfigEntityData;
        this.networkPromoDiscoveryEntityData = networkPromoDiscoveryEntityData;
        this.localPromoDiscoveryEntityData = localPromoDiscoveryEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final PromoDiscoveryEntityData createData2(String source) {
        if (!(source != null)) {
            throw new IllegalArgumentException("Null source".toString());
        }
        int hashCode = source.hashCode();
        if (hashCode != 103145323) {
            if (hashCode != 109648666) {
                if (hashCode == 1843485230 && source.equals("network")) {
                    return this.networkPromoDiscoveryEntityData;
                }
            } else if (source.equals("split")) {
                return this.splitPromoDiscoveryConfigEntityData;
            }
        } else if (source.equals("local")) {
            return this.localPromoDiscoveryEntityData;
        }
        throw new IllegalStateException();
    }
}
