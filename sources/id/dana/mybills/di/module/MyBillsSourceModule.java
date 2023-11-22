package id.dana.mybills.di.module;

import dagger.Binds;
import dagger.Module;
import id.dana.mybills.data.repository.MyBillsEntityRepository;
import id.dana.mybills.data.repository.source.MyBillsEntityData;
import id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData;
import id.dana.mybills.data.repository.source.split.SplitMyBillsEntityData;
import id.dana.mybills.di.scope.MyBillsScope;
import id.dana.mybills.domain.MyBillsRepository;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/mybills/di/module/MyBillsSourceModule;", "", "Lid/dana/mybills/data/repository/MyBillsEntityRepository;", "p0", "Lid/dana/mybills/domain/MyBillsRepository;", "PlaceComponentResult", "(Lid/dana/mybills/data/repository/MyBillsEntityRepository;)Lid/dana/mybills/domain/MyBillsRepository;", "Lid/dana/mybills/data/repository/source/network/NetworkMyBillsEntityData;", "Lid/dana/mybills/data/repository/source/MyBillsEntityData;", "(Lid/dana/mybills/data/repository/source/network/NetworkMyBillsEntityData;)Lid/dana/mybills/data/repository/source/MyBillsEntityData;", "Lid/dana/mybills/data/repository/source/split/SplitMyBillsEntityData;", "MyBillsEntityDataFactory", "(Lid/dana/mybills/data/repository/source/split/SplitMyBillsEntityData;)Lid/dana/mybills/data/repository/source/MyBillsEntityData;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes9.dex */
public abstract class MyBillsSourceModule {
    @Binds
    @MyBillsScope
    public abstract MyBillsEntityData MyBillsEntityDataFactory(SplitMyBillsEntityData p0);

    @Binds
    @MyBillsScope
    public abstract MyBillsEntityData PlaceComponentResult(NetworkMyBillsEntityData p0);

    @Binds
    @MyBillsScope
    public abstract MyBillsRepository PlaceComponentResult(MyBillsEntityRepository p0);
}
