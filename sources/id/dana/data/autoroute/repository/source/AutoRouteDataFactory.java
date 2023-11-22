package id.dana.data.autoroute.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.autoroute.repository.AutoRouteEntityData;
import id.dana.data.autoroute.repository.source.mock.MockAutoRouteEntityData;
import id.dana.data.autoroute.repository.source.network.NetworkAutoRouteEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/autoroute/repository/source/AutoRouteDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/autoroute/repository/AutoRouteEntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/autoroute/repository/AutoRouteEntityData;", "Lid/dana/data/autoroute/repository/source/mock/MockAutoRouteEntityData;", "mockAutoRouteEntityData", "Lid/dana/data/autoroute/repository/source/mock/MockAutoRouteEntityData;", "Lid/dana/data/autoroute/repository/source/network/NetworkAutoRouteEntityData;", "networkAutoRouteEntityData", "Lid/dana/data/autoroute/repository/source/network/NetworkAutoRouteEntityData;", "<init>", "(Lid/dana/data/autoroute/repository/source/network/NetworkAutoRouteEntityData;Lid/dana/data/autoroute/repository/source/mock/MockAutoRouteEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AutoRouteDataFactory extends AbstractEntityDataFactory<AutoRouteEntityData> {
    private final MockAutoRouteEntityData mockAutoRouteEntityData;
    private final NetworkAutoRouteEntityData networkAutoRouteEntityData;

    @Inject
    public AutoRouteDataFactory(NetworkAutoRouteEntityData networkAutoRouteEntityData, MockAutoRouteEntityData mockAutoRouteEntityData) {
        Intrinsics.checkNotNullParameter(networkAutoRouteEntityData, "");
        Intrinsics.checkNotNullParameter(mockAutoRouteEntityData, "");
        this.networkAutoRouteEntityData = networkAutoRouteEntityData;
        this.mockAutoRouteEntityData = mockAutoRouteEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final AutoRouteEntityData createData2(String source) {
        return Intrinsics.areEqual(source, "network") ? this.networkAutoRouteEntityData : this.mockAutoRouteEntityData;
    }
}
