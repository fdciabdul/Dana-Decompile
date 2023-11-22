package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.base.BaseActivity;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes2.dex */
public class ActivityModule {
    private final BaseActivity BuiltInFictitiousFunctionClassFactory;

    public ActivityModule(BaseActivity baseActivity) {
        this.BuiltInFictitiousFunctionClassFactory = baseActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public BaseActivity KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
