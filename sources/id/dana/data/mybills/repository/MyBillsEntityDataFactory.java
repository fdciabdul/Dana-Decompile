package id.dana.data.mybills.repository;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.mybills.repository.source.network.NetworkMyBillsEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/mybills/repository/MyBillsEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/mybills/repository/MyBillsEntityData;", "Lid/dana/data/mybills/repository/source/network/NetworkMyBillsEntityData;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/mybills/repository/source/network/NetworkMyBillsEntityData;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/data/mybills/repository/source/network/NetworkMyBillsEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MyBillsEntityDataFactory extends AbstractEntityDataFactory<MyBillsEntityData> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final NetworkMyBillsEntityData MyBillsEntityDataFactory;

    @Inject
    public MyBillsEntityDataFactory(NetworkMyBillsEntityData networkMyBillsEntityData) {
        Intrinsics.checkNotNullParameter(networkMyBillsEntityData, "");
        this.MyBillsEntityDataFactory = networkMyBillsEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* bridge */ /* synthetic */ MyBillsEntityData createData2(String str) {
        return this.MyBillsEntityDataFactory;
    }
}
