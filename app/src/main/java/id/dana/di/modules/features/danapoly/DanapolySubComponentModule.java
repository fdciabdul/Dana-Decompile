package id.dana.di.modules.features.danapoly;

import dagger.Module;
import dagger.Provides;
import id.dana.danapoly.data.clear.repository.DanapolyClearEntityRepository;
import id.dana.danapoly.di.component.DanapolyComponent;
import id.dana.danapoly.domain.clear.DanapolyClearRepository;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/di/modules/features/danapoly/DanapolySubComponentModule;", "", "Lid/dana/danapoly/data/clear/repository/DanapolyClearEntityRepository;", "p0", "Lid/dana/danapoly/domain/clear/DanapolyClearRepository;", "PlaceComponentResult", "(Lid/dana/danapoly/data/clear/repository/DanapolyClearEntityRepository;)Lid/dana/danapoly/domain/clear/DanapolyClearRepository;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(subcomponents = {DanapolyComponent.class})
/* loaded from: classes.dex */
public final class DanapolySubComponentModule {
    @Provides
    @Singleton
    public final DanapolyClearRepository PlaceComponentResult(DanapolyClearEntityRepository p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
