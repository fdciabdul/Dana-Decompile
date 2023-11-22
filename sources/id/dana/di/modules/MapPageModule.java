package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.danah5.locationpicker.contract.MapPageContract;
import id.dana.danah5.locationpicker.presenter.MapPagePresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/di/modules/MapPageModule;", "", "Lid/dana/danah5/locationpicker/presenter/MapPagePresenter;", "p0", "Lid/dana/danah5/locationpicker/contract/MapPageContract$Presenter;", "MyBillsEntityDataFactory", "(Lid/dana/danah5/locationpicker/presenter/MapPagePresenter;)Lid/dana/danah5/locationpicker/contract/MapPageContract$Presenter;", "Lid/dana/danah5/locationpicker/contract/MapPageContract$View;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/danah5/locationpicker/contract/MapPageContract$View;", "Lid/dana/danah5/locationpicker/contract/MapPageContract$View;", "<init>", "(Lid/dana/danah5/locationpicker/contract/MapPageContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes8.dex */
public final class MapPageModule {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final MapPageContract.View MyBillsEntityDataFactory;

    public MapPageModule(MapPageContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.MyBillsEntityDataFactory = view;
    }

    @Provides
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final MapPageContract.View getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Provides
    public final MapPageContract.Presenter MyBillsEntityDataFactory(MapPagePresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
