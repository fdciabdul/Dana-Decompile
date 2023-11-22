package id.dana.sendmoney.di.module.groupsend;

import dagger.Binds;
import dagger.Module;
import id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository;
import id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData;
import id.dana.sendmoney.data.repository.groupsend.source.local.LocalGroupSendEntityData;
import id.dana.sendmoney.data.repository.groupsend.source.network.NetworkGroupSendEntityData;
import id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData;
import id.dana.sendmoney.di.scope.GroupSendScope;
import id.dana.sendmoney.domain.groupsend.GroupSendRepository;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\t\u0010\u000f"}, d2 = {"Lid/dana/sendmoney/di/module/groupsend/GroupSendDataModule;", "", "Lid/dana/sendmoney/data/repository/groupsend/GroupSendEntityRepository;", "p0", "Lid/dana/sendmoney/domain/groupsend/GroupSendRepository;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/data/repository/groupsend/GroupSendEntityRepository;)Lid/dana/sendmoney/domain/groupsend/GroupSendRepository;", "Lid/dana/sendmoney/data/repository/groupsend/source/local/LocalGroupSendEntityData;", "Lid/dana/sendmoney/data/repository/groupsend/source/GroupSendEntityData;", "getAuthRequestContext", "(Lid/dana/sendmoney/data/repository/groupsend/source/local/LocalGroupSendEntityData;)Lid/dana/sendmoney/data/repository/groupsend/source/GroupSendEntityData;", "Lid/dana/sendmoney/data/repository/groupsend/source/network/NetworkGroupSendEntityData;", "PlaceComponentResult", "(Lid/dana/sendmoney/data/repository/groupsend/source/network/NetworkGroupSendEntityData;)Lid/dana/sendmoney/data/repository/groupsend/source/GroupSendEntityData;", "Lid/dana/sendmoney/data/repository/groupsend/source/split/SplitGroupSendEntityData;", "(Lid/dana/sendmoney/data/repository/groupsend/source/split/SplitGroupSendEntityData;)Lid/dana/sendmoney/data/repository/groupsend/source/GroupSendEntityData;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes9.dex */
public abstract class GroupSendDataModule {
    @Binds
    @GroupSendScope
    public abstract GroupSendRepository BuiltInFictitiousFunctionClassFactory(GroupSendEntityRepository p0);

    @Binds
    @GroupSendScope
    public abstract GroupSendEntityData PlaceComponentResult(NetworkGroupSendEntityData p0);

    @Binds
    @GroupSendScope
    public abstract GroupSendEntityData getAuthRequestContext(LocalGroupSendEntityData p0);

    @Binds
    @GroupSendScope
    public abstract GroupSendEntityData getAuthRequestContext(SplitGroupSendEntityData p0);
}
