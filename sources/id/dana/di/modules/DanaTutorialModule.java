package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.tutorial.TutorialContract;
import id.dana.tutorial.TutorialPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\n"}, d2 = {"Lid/dana/di/modules/DanaTutorialModule;", "", "Lid/dana/tutorial/TutorialPresenter;", "p0", "Lid/dana/tutorial/TutorialContract$Presenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/tutorial/TutorialPresenter;)Lid/dana/tutorial/TutorialContract$Presenter;", "Lid/dana/tutorial/TutorialContract$View;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/tutorial/TutorialContract$View;", "Lid/dana/tutorial/TutorialContract$View;", "<init>", "(Lid/dana/tutorial/TutorialContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes8.dex */
public final class DanaTutorialModule {
    private final TutorialContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    public DanaTutorialModule(TutorialContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    @Provides
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final TutorialContract.View getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Provides
    public final TutorialContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(TutorialPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
