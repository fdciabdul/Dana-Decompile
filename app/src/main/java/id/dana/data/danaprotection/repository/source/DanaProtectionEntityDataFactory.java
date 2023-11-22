package id.dana.data.danaprotection.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.danaprotection.repository.source.local.LocalDanaProtectionInfoEntityData;
import id.dana.data.danaprotection.repository.source.network.NetworkDanaProtectionInfoEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/data/danaprotection/repository/source/DanaProtectionEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/danaprotection/repository/source/DanaProtectionEntityData;", "Lid/dana/data/danaprotection/repository/source/local/LocalDanaProtectionInfoEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/danaprotection/repository/source/local/LocalDanaProtectionInfoEntityData;", "MyBillsEntityDataFactory", "Lid/dana/data/danaprotection/repository/source/network/NetworkDanaProtectionInfoEntityData;", "getAuthRequestContext", "Lid/dana/data/danaprotection/repository/source/network/NetworkDanaProtectionInfoEntityData;", "p0", "p1", "<init>", "(Lid/dana/data/danaprotection/repository/source/network/NetworkDanaProtectionInfoEntityData;Lid/dana/data/danaprotection/repository/source/local/LocalDanaProtectionInfoEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DanaProtectionEntityDataFactory extends AbstractEntityDataFactory<DanaProtectionEntityData> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final LocalDanaProtectionInfoEntityData MyBillsEntityDataFactory;
    public final NetworkDanaProtectionInfoEntityData getAuthRequestContext;

    @Inject
    public DanaProtectionEntityDataFactory(NetworkDanaProtectionInfoEntityData networkDanaProtectionInfoEntityData, LocalDanaProtectionInfoEntityData localDanaProtectionInfoEntityData) {
        Intrinsics.checkNotNullParameter(networkDanaProtectionInfoEntityData, "");
        Intrinsics.checkNotNullParameter(localDanaProtectionInfoEntityData, "");
        this.getAuthRequestContext = networkDanaProtectionInfoEntityData;
        this.MyBillsEntityDataFactory = localDanaProtectionInfoEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* synthetic */ DanaProtectionEntityData createData2(String str) {
        return Intrinsics.areEqual(str, "network") ? this.getAuthRequestContext : this.MyBillsEntityDataFactory;
    }
}
