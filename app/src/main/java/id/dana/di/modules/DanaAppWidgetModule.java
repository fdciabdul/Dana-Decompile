package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.appwidget.DanaAppWidgetContract;
import id.dana.appwidget.DanaAppWidgetPresenter;
import id.dana.di.PerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u0005\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/di/modules/DanaAppWidgetModule;", "", "Lid/dana/appwidget/DanaAppWidgetPresenter;", "p0", "Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/appwidget/DanaAppWidgetPresenter;)Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "Lid/dana/appwidget/DanaAppWidgetContract$View;", "()Lid/dana/appwidget/DanaAppWidgetContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/appwidget/DanaAppWidgetContract$View;", "PlaceComponentResult", "<init>", "(Lid/dana/appwidget/DanaAppWidgetContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes8.dex */
public final class DanaAppWidgetModule {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final DanaAppWidgetContract.View PlaceComponentResult;

    public DanaAppWidgetModule(DanaAppWidgetContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = view;
    }

    @Provides
    @PerActivity
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final DanaAppWidgetContract.View getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Provides
    @PerActivity
    public final DanaAppWidgetContract.Presenter BuiltInFictitiousFunctionClassFactory(DanaAppWidgetPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
