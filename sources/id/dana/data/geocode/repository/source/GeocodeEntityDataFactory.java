package id.dana.data.geocode.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.geocode.repository.source.local.LocalGeocodeEntityData;
import id.dana.data.geocode.repository.source.network.NetworkGeocodeEntityData;
import id.dana.data.here.source.network.NetworkHereGeocodeEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/data/geocode/repository/source/GeocodeEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/geocode/repository/source/GeocodeEntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/geocode/repository/source/GeocodeEntityData;", "Lid/dana/data/geocode/repository/source/local/LocalGeocodeEntityData;", "localGeocodeEntityData", "Lid/dana/data/geocode/repository/source/local/LocalGeocodeEntityData;", "Lid/dana/data/geocode/repository/source/network/NetworkGeocodeEntityData;", "networkGeocodeEntityData", "Lid/dana/data/geocode/repository/source/network/NetworkGeocodeEntityData;", "Lid/dana/data/here/source/network/NetworkHereGeocodeEntityData;", "networkHereGeocodeEntityData", "Lid/dana/data/here/source/network/NetworkHereGeocodeEntityData;", "<init>", "(Lid/dana/data/here/source/network/NetworkHereGeocodeEntityData;Lid/dana/data/geocode/repository/source/network/NetworkGeocodeEntityData;Lid/dana/data/geocode/repository/source/local/LocalGeocodeEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GeocodeEntityDataFactory extends AbstractEntityDataFactory<GeocodeEntityData> {
    private final LocalGeocodeEntityData localGeocodeEntityData;
    private final NetworkGeocodeEntityData networkGeocodeEntityData;
    private final NetworkHereGeocodeEntityData networkHereGeocodeEntityData;

    @Inject
    public GeocodeEntityDataFactory(NetworkHereGeocodeEntityData networkHereGeocodeEntityData, NetworkGeocodeEntityData networkGeocodeEntityData, LocalGeocodeEntityData localGeocodeEntityData) {
        Intrinsics.checkNotNullParameter(networkHereGeocodeEntityData, "");
        Intrinsics.checkNotNullParameter(networkGeocodeEntityData, "");
        Intrinsics.checkNotNullParameter(localGeocodeEntityData, "");
        this.networkHereGeocodeEntityData = networkHereGeocodeEntityData;
        this.networkGeocodeEntityData = networkGeocodeEntityData;
        this.localGeocodeEntityData = localGeocodeEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return r2.networkHereGeocodeEntityData;
     */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.data.geocode.repository.source.GeocodeEntityData createData2(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            int r0 = r3.hashCode()
            r1 = -1240244679(0xffffffffb6135e39, float:-2.1959552E-6)
            if (r0 == r1) goto L2e
            r1 = 3198960(0x30cff0, float:4.482698E-39)
            if (r0 == r1) goto L21
            r1 = 1843485230(0x6de15a2e, float:8.7178935E27)
            if (r0 != r1) goto L36
            java.lang.String r0 = "network"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L36
            goto L29
        L21:
            java.lang.String r0 = "here"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L36
        L29:
            id.dana.data.here.source.network.NetworkHereGeocodeEntityData r3 = r2.networkHereGeocodeEntityData
            id.dana.data.geocode.repository.source.GeocodeEntityData r3 = (id.dana.data.geocode.repository.source.GeocodeEntityData) r3
            goto L3f
        L2e:
            java.lang.String r0 = "google"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L3b
        L36:
            id.dana.data.geocode.repository.source.local.LocalGeocodeEntityData r3 = r2.localGeocodeEntityData
            id.dana.data.geocode.repository.source.GeocodeEntityData r3 = (id.dana.data.geocode.repository.source.GeocodeEntityData) r3
            goto L3f
        L3b:
            id.dana.data.geocode.repository.source.network.NetworkGeocodeEntityData r3 = r2.networkGeocodeEntityData
            id.dana.data.geocode.repository.source.GeocodeEntityData r3 = (id.dana.data.geocode.repository.source.GeocodeEntityData) r3
        L3f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.geocode.repository.source.GeocodeEntityDataFactory.createData2(java.lang.String):id.dana.data.geocode.repository.source.GeocodeEntityData");
    }
}
