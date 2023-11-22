package id.dana.di.modules;

import dagger.Binds;
import dagger.Module;
import id.dana.data.creditscore.repository.CreditScoreEntityRepository;
import id.dana.data.installedapp.repository.InstalledAppEntityRepository;
import id.dana.di.modules.features.installedapp.InstalledAppScope;
import id.dana.domain.creditscore.CreditScoreRepository;
import id.dana.domain.installedapp.InstalledAppRepository;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/di/modules/InstalledAppModule;", "", "Lid/dana/data/creditscore/repository/CreditScoreEntityRepository;", "p0", "Lid/dana/domain/creditscore/CreditScoreRepository;", "MyBillsEntityDataFactory", "(Lid/dana/data/creditscore/repository/CreditScoreEntityRepository;)Lid/dana/domain/creditscore/CreditScoreRepository;", "Lid/dana/data/installedapp/repository/InstalledAppEntityRepository;", "Lid/dana/domain/installedapp/InstalledAppRepository;", "getAuthRequestContext", "(Lid/dana/data/installedapp/repository/InstalledAppEntityRepository;)Lid/dana/domain/installedapp/InstalledAppRepository;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes8.dex */
public abstract class InstalledAppModule {
    @InstalledAppScope
    @Binds
    public abstract CreditScoreRepository MyBillsEntityDataFactory(CreditScoreEntityRepository p0);

    @InstalledAppScope
    @Binds
    public abstract InstalledAppRepository getAuthRequestContext(InstalledAppEntityRepository p0);
}
