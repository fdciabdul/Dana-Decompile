package id.dana.riskChallenges.di.module;

import dagger.Binds;
import dagger.Module;
import id.dana.riskChallenges.data.danaprotection.DanaProtectionEntityRepository;
import id.dana.riskChallenges.di.RiskChallengesScope;
import id.dana.riskChallenges.domain.danaprotection.DanaProtectionRepository;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/di/module/DanaProtectionModule;", "", "<init>", "()V", "BindsModule"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {BindsModule.class})
/* loaded from: classes9.dex */
public final class DanaProtectionModule {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/riskChallenges/di/module/DanaProtectionModule$BindsModule;", "", "Lid/dana/riskChallenges/data/danaprotection/DanaProtectionEntityRepository;", "p0", "Lid/dana/riskChallenges/domain/danaprotection/DanaProtectionRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/riskChallenges/data/danaprotection/DanaProtectionEntityRepository;)Lid/dana/riskChallenges/domain/danaprotection/DanaProtectionRepository;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Module
    /* loaded from: classes9.dex */
    public interface BindsModule {
        @RiskChallengesScope
        @Binds
        DanaProtectionRepository KClassImpl$Data$declaredNonStaticMembers$2(DanaProtectionEntityRepository p0);
    }
}
