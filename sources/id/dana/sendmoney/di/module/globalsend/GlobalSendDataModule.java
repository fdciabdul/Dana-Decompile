package id.dana.sendmoney.di.module.globalsend;

import dagger.Binds;
import dagger.Module;
import id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData;
import id.dana.sendmoney.data.repository.globalsend.source.local.LocalGlobalSendEntityData;
import id.dana.sendmoney.data.repository.globalsend.source.mock.MockGlobalSendEntityData;
import id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData;
import id.dana.sendmoney.data.repository.globalsend.source.split.SplitGlobalSendEntityData;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH'¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/sendmoney/di/module/globalsend/GlobalSendDataModule;", "", "Lid/dana/sendmoney/data/repository/globalsend/source/local/LocalGlobalSendEntityData;", "p0", "Lid/dana/sendmoney/data/repository/globalsend/source/GlobalSendEntityData;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/data/repository/globalsend/source/local/LocalGlobalSendEntityData;)Lid/dana/sendmoney/data/repository/globalsend/source/GlobalSendEntityData;", "Lid/dana/sendmoney/data/repository/globalsend/source/mock/MockGlobalSendEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney/data/repository/globalsend/source/mock/MockGlobalSendEntityData;)Lid/dana/sendmoney/data/repository/globalsend/source/GlobalSendEntityData;", "Lid/dana/sendmoney/data/repository/globalsend/source/network/NetworkGlobalSendEntityData;", "MyBillsEntityDataFactory", "(Lid/dana/sendmoney/data/repository/globalsend/source/network/NetworkGlobalSendEntityData;)Lid/dana/sendmoney/data/repository/globalsend/source/GlobalSendEntityData;", "Lid/dana/sendmoney/data/repository/globalsend/source/split/SplitGlobalSendEntityData;", "getAuthRequestContext", "(Lid/dana/sendmoney/data/repository/globalsend/source/split/SplitGlobalSendEntityData;)Lid/dana/sendmoney/data/repository/globalsend/source/GlobalSendEntityData;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes2.dex */
public abstract class GlobalSendDataModule {
    @Binds
    public abstract GlobalSendEntityData BuiltInFictitiousFunctionClassFactory(LocalGlobalSendEntityData p0);

    @Binds
    public abstract GlobalSendEntityData KClassImpl$Data$declaredNonStaticMembers$2(MockGlobalSendEntityData p0);

    @Binds
    public abstract GlobalSendEntityData MyBillsEntityDataFactory(NetworkGlobalSendEntityData p0);

    @Binds
    public abstract GlobalSendEntityData getAuthRequestContext(SplitGlobalSendEntityData p0);
}
