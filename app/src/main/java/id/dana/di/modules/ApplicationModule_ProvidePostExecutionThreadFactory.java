package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.UIThread;
import id.dana.domain.PostExecutionThread;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvidePostExecutionThreadFactory implements Factory<PostExecutionThread> {
    private final Provider<UIThread> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvidePostExecutionThreadFactory(ApplicationModule applicationModule, Provider<UIThread> provider) {
        this.getAuthRequestContext = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvidePostExecutionThreadFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<UIThread> provider) {
        return new ApplicationModule_ProvidePostExecutionThreadFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PostExecutionThread) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
