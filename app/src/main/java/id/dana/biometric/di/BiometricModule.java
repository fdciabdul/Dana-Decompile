package id.dana.biometric.di;

import dagger.Binds;
import dagger.Module;
import id.dana.biometric.data.RiskTrackerEntityRepository;
import id.dana.biometric.domain.RiskTrackerRepository;
import id.dana.biometric.presentation.RiskTracker;
import id.dana.biometric.presentation.RiskTrackerImpl;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/biometric/di/BiometricModule;", "", "<init>", "()V", "BindsModule"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {BindsModule.class})
/* loaded from: classes.dex */
public final class BiometricModule {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/biometric/di/BiometricModule$BindsModule;", "", "Lid/dana/biometric/presentation/RiskTrackerImpl;", "p0", "Lid/dana/biometric/presentation/RiskTracker;", "MyBillsEntityDataFactory", "(Lid/dana/biometric/presentation/RiskTrackerImpl;)Lid/dana/biometric/presentation/RiskTracker;", "Lid/dana/biometric/data/RiskTrackerEntityRepository;", "Lid/dana/biometric/domain/RiskTrackerRepository;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/biometric/data/RiskTrackerEntityRepository;)Lid/dana/biometric/domain/RiskTrackerRepository;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Module
    /* loaded from: classes8.dex */
    public interface BindsModule {
        @Binds
        RiskTrackerRepository BuiltInFictitiousFunctionClassFactory(RiskTrackerEntityRepository p0);

        @Binds
        RiskTracker MyBillsEntityDataFactory(RiskTrackerImpl p0);
    }
}
