package id.dana.danapoly.di.module;

import dagger.Binds;
import dagger.Module;
import id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository;
import id.dana.danapoly.data.config.repository.source.DanapolyConfigData;
import id.dana.danapoly.data.config.repository.source.local.LocalDanapolyConfigEntityData;
import id.dana.danapoly.data.config.repository.source.network.NetworkDanapolyConfigEntityData;
import id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository;
import id.dana.danapoly.data.dailycheck.repository.source.DanapolyCheckInData;
import id.dana.danapoly.data.dailycheck.repository.source.network.NetworkDanapolyCheckInEntityData;
import id.dana.danapoly.data.play.repository.DanapolyPlayEntityRepository;
import id.dana.danapoly.data.play.repository.source.DanapolyPlayData;
import id.dana.danapoly.data.play.repository.source.network.NetworkDanapolyPlayEntityData;
import id.dana.danapoly.data.rewards.repository.DanapolyRewardsEntityRepository;
import id.dana.danapoly.di.DanapolyScope;
import id.dana.danapoly.domain.config.DanapolyConfigRepository;
import id.dana.danapoly.domain.dailycheck.DanapolyCheckInRepository;
import id.dana.danapoly.domain.play.DanapolyPlayRepository;
import id.dana.danapoly.domain.rewards.DanapolyRewardsRepository;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\t\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\t\u0010\u0011J\u0017\u0010\r\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0012H'¢\u0006\u0004\b\r\u0010\u0014J\u0017\u0010\t\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0015H'¢\u0006\u0004\b\t\u0010\u0017J\u0017\u0010\t\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0018H'¢\u0006\u0004\b\t\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u001aH'¢\u0006\u0004\b\u001c\u0010\u001d"}, d2 = {"Lid/dana/danapoly/di/module/DanapolyDataModule;", "", "Lid/dana/danapoly/data/dailycheck/repository/DanapolyCheckInEntityRepository;", "p0", "Lid/dana/danapoly/domain/dailycheck/DanapolyCheckInRepository;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/danapoly/data/dailycheck/repository/DanapolyCheckInEntityRepository;)Lid/dana/danapoly/domain/dailycheck/DanapolyCheckInRepository;", "Lid/dana/danapoly/data/config/repository/DanapolyConfigEntityRepository;", "Lid/dana/danapoly/domain/config/DanapolyConfigRepository;", "MyBillsEntityDataFactory", "(Lid/dana/danapoly/data/config/repository/DanapolyConfigEntityRepository;)Lid/dana/danapoly/domain/config/DanapolyConfigRepository;", "Lid/dana/danapoly/data/play/repository/DanapolyPlayEntityRepository;", "Lid/dana/danapoly/domain/play/DanapolyPlayRepository;", "getAuthRequestContext", "(Lid/dana/danapoly/data/play/repository/DanapolyPlayEntityRepository;)Lid/dana/danapoly/domain/play/DanapolyPlayRepository;", "Lid/dana/danapoly/data/rewards/repository/DanapolyRewardsEntityRepository;", "Lid/dana/danapoly/domain/rewards/DanapolyRewardsRepository;", "(Lid/dana/danapoly/data/rewards/repository/DanapolyRewardsEntityRepository;)Lid/dana/danapoly/domain/rewards/DanapolyRewardsRepository;", "Lid/dana/danapoly/data/config/repository/source/local/LocalDanapolyConfigEntityData;", "Lid/dana/danapoly/data/config/repository/source/DanapolyConfigData;", "(Lid/dana/danapoly/data/config/repository/source/local/LocalDanapolyConfigEntityData;)Lid/dana/danapoly/data/config/repository/source/DanapolyConfigData;", "Lid/dana/danapoly/data/dailycheck/repository/source/network/NetworkDanapolyCheckInEntityData;", "Lid/dana/danapoly/data/dailycheck/repository/source/DanapolyCheckInData;", "(Lid/dana/danapoly/data/dailycheck/repository/source/network/NetworkDanapolyCheckInEntityData;)Lid/dana/danapoly/data/dailycheck/repository/source/DanapolyCheckInData;", "Lid/dana/danapoly/data/config/repository/source/network/NetworkDanapolyConfigEntityData;", "(Lid/dana/danapoly/data/config/repository/source/network/NetworkDanapolyConfigEntityData;)Lid/dana/danapoly/data/config/repository/source/DanapolyConfigData;", "Lid/dana/danapoly/data/play/repository/source/network/NetworkDanapolyPlayEntityData;", "Lid/dana/danapoly/data/play/repository/source/DanapolyPlayData;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/danapoly/data/play/repository/source/network/NetworkDanapolyPlayEntityData;)Lid/dana/danapoly/data/play/repository/source/DanapolyPlayData;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes8.dex */
public abstract class DanapolyDataModule {
    @DanapolyScope
    @Binds
    public abstract DanapolyCheckInRepository BuiltInFictitiousFunctionClassFactory(DanapolyCheckInEntityRepository p0);

    @DanapolyScope
    @Binds
    public abstract DanapolyPlayData KClassImpl$Data$declaredNonStaticMembers$2(NetworkDanapolyPlayEntityData p0);

    @DanapolyScope
    @Binds
    public abstract DanapolyConfigData MyBillsEntityDataFactory(NetworkDanapolyConfigEntityData p0);

    @DanapolyScope
    @Binds
    public abstract DanapolyCheckInData MyBillsEntityDataFactory(NetworkDanapolyCheckInEntityData p0);

    @DanapolyScope
    @Binds
    public abstract DanapolyConfigRepository MyBillsEntityDataFactory(DanapolyConfigEntityRepository p0);

    @DanapolyScope
    @Binds
    public abstract DanapolyRewardsRepository MyBillsEntityDataFactory(DanapolyRewardsEntityRepository p0);

    @DanapolyScope
    @Binds
    public abstract DanapolyConfigData getAuthRequestContext(LocalDanapolyConfigEntityData p0);

    @DanapolyScope
    @Binds
    public abstract DanapolyPlayRepository getAuthRequestContext(DanapolyPlayEntityRepository p0);
}
