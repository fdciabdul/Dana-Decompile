package id.dana.kyb.data.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.kyb.data.KybEntityData;
import id.dana.kyb.data.repository.source.mock.MockKybEntityData;
import id.dana.kyb.data.repository.source.network.NetworkKybEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0004\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/kyb/data/repository/source/KybEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/kyb/data/KybEntityData;", "Lid/dana/kyb/data/repository/source/mock/MockKybEntityData;", "PlaceComponentResult", "Lid/dana/kyb/data/repository/source/mock/MockKybEntityData;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/kyb/data/repository/source/network/NetworkKybEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/kyb/data/repository/source/network/NetworkKybEntityData;", "p0", "p1", "<init>", "(Lid/dana/kyb/data/repository/source/network/NetworkKybEntityData;Lid/dana/kyb/data/repository/source/mock/MockKybEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KybEntityDataFactory extends AbstractEntityDataFactory<KybEntityData> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final NetworkKybEntityData PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final MockKybEntityData BuiltInFictitiousFunctionClassFactory;

    @Inject
    public KybEntityDataFactory(NetworkKybEntityData networkKybEntityData, MockKybEntityData mockKybEntityData) {
        Intrinsics.checkNotNullParameter(networkKybEntityData, "");
        Intrinsics.checkNotNullParameter(mockKybEntityData, "");
        this.PlaceComponentResult = networkKybEntityData;
        this.BuiltInFictitiousFunctionClassFactory = mockKybEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* synthetic */ KybEntityData createData2(String str) {
        return Intrinsics.areEqual(str, "mock") ? this.BuiltInFictitiousFunctionClassFactory : this.PlaceComponentResult;
    }
}
