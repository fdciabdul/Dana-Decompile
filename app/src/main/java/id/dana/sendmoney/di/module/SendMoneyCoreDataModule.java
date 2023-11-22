package id.dana.sendmoney.di.module;

import dagger.Binds;
import dagger.Module;
import id.dana.sendmoney.data.repository.core.source.SendMoneyCoreEntityData;
import id.dana.sendmoney.data.repository.core.source.network.NetworkSendMoneyCoreEntityData;
import id.dana.sendmoney.data.repository.core.source.split.SplitSendMoneyCoreEntityData;
import id.dana.sendmoney.data.repository.core.source.split.SplitSendMoneyCoreEntityDataImpl;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/sendmoney/di/module/SendMoneyCoreDataModule;", "", "Lid/dana/sendmoney/data/repository/core/source/network/NetworkSendMoneyCoreEntityData;", "p0", "Lid/dana/sendmoney/data/repository/core/source/SendMoneyCoreEntityData;", "PlaceComponentResult", "(Lid/dana/sendmoney/data/repository/core/source/network/NetworkSendMoneyCoreEntityData;)Lid/dana/sendmoney/data/repository/core/source/SendMoneyCoreEntityData;", "Lid/dana/sendmoney/data/repository/core/source/split/SplitSendMoneyCoreEntityDataImpl;", "Lid/dana/sendmoney/data/repository/core/source/split/SplitSendMoneyCoreEntityData;", "getAuthRequestContext", "(Lid/dana/sendmoney/data/repository/core/source/split/SplitSendMoneyCoreEntityDataImpl;)Lid/dana/sendmoney/data/repository/core/source/split/SplitSendMoneyCoreEntityData;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes2.dex */
public abstract class SendMoneyCoreDataModule {
    @Binds
    public abstract SendMoneyCoreEntityData PlaceComponentResult(NetworkSendMoneyCoreEntityData p0);

    @Binds
    public abstract SplitSendMoneyCoreEntityData getAuthRequestContext(SplitSendMoneyCoreEntityDataImpl p0);
}
