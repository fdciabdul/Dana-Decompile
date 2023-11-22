package id.dana.data.homeinfo.di;

import dagger.Binds;
import dagger.Module;
import id.dana.data.homeinfo.repository.HomeOmniEntityRepository;
import id.dana.data.homeinfo.repository.source.HomeOmniEntityData;
import id.dana.data.homeinfo.repository.source.network.NetworkHomeOmniEntityData;
import id.dana.domain.homeinfo.repository.HomeOmniRepository;
import javax.inject.Singleton;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/homeinfo/di/HomeOmniModule;", "", "<init>", "()V", "Declarations"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {Declarations.class})
/* loaded from: classes2.dex */
public final class HomeOmniModule {
    public static final HomeOmniModule INSTANCE = new HomeOmniModule();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/homeinfo/di/HomeOmniModule$Declarations;", "", "Lid/dana/data/homeinfo/repository/HomeOmniEntityRepository;", "repository", "Lid/dana/domain/homeinfo/repository/HomeOmniRepository;", "bindsHomeOmniRepository", "(Lid/dana/data/homeinfo/repository/HomeOmniEntityRepository;)Lid/dana/domain/homeinfo/repository/HomeOmniRepository;", "Lid/dana/data/homeinfo/repository/source/network/NetworkHomeOmniEntityData;", "network", "Lid/dana/data/homeinfo/repository/source/HomeOmniEntityData;", "bindsNetworkHomeOmniEntityData", "(Lid/dana/data/homeinfo/repository/source/network/NetworkHomeOmniEntityData;)Lid/dana/data/homeinfo/repository/source/HomeOmniEntityData;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Module
    /* loaded from: classes8.dex */
    public interface Declarations {
        @Singleton
        @Binds
        HomeOmniRepository bindsHomeOmniRepository(HomeOmniEntityRepository repository);

        @Singleton
        @Binds
        HomeOmniEntityData bindsNetworkHomeOmniEntityData(NetworkHomeOmniEntityData network);
    }

    private HomeOmniModule() {
    }
}
