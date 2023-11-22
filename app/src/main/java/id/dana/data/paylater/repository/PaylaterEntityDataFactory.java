package id.dana.data.paylater.repository;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.paylater.repository.source.local.LocalPaylaterEntityData;
import id.dana.data.paylater.repository.source.network.NetworkPaylaterEntityData;
import id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/data/paylater/repository/PaylaterEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/paylater/repository/PaylaterEntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/paylater/repository/PaylaterEntityData;", "Lid/dana/data/paylater/repository/source/local/LocalPaylaterEntityData;", "localPaylaterEntityData", "Lid/dana/data/paylater/repository/source/local/LocalPaylaterEntityData;", "Lid/dana/data/paylater/repository/source/network/NetworkPaylaterEntityData;", "networkPaylaterEntityData", "Lid/dana/data/paylater/repository/source/network/NetworkPaylaterEntityData;", "Lid/dana/data/paylater/repository/source/split/SplitPaylaterEntityData;", "splitPaylaterEntityData", "Lid/dana/data/paylater/repository/source/split/SplitPaylaterEntityData;", "<init>", "(Lid/dana/data/paylater/repository/source/network/NetworkPaylaterEntityData;Lid/dana/data/paylater/repository/source/local/LocalPaylaterEntityData;Lid/dana/data/paylater/repository/source/split/SplitPaylaterEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PaylaterEntityDataFactory extends AbstractEntityDataFactory<PaylaterEntityData> {
    private final LocalPaylaterEntityData localPaylaterEntityData;
    private final NetworkPaylaterEntityData networkPaylaterEntityData;
    private final SplitPaylaterEntityData splitPaylaterEntityData;

    @Inject
    public PaylaterEntityDataFactory(NetworkPaylaterEntityData networkPaylaterEntityData, LocalPaylaterEntityData localPaylaterEntityData, SplitPaylaterEntityData splitPaylaterEntityData) {
        Intrinsics.checkNotNullParameter(networkPaylaterEntityData, "");
        Intrinsics.checkNotNullParameter(localPaylaterEntityData, "");
        Intrinsics.checkNotNullParameter(splitPaylaterEntityData, "");
        this.networkPaylaterEntityData = networkPaylaterEntityData;
        this.localPaylaterEntityData = localPaylaterEntityData;
        this.splitPaylaterEntityData = splitPaylaterEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final PaylaterEntityData createData2(String source) {
        return Intrinsics.areEqual(source, "network") ? this.networkPaylaterEntityData : Intrinsics.areEqual(source, "split") ? this.splitPaylaterEntityData : this.localPaylaterEntityData;
    }
}
