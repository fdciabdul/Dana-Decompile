package id.dana.data.di;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.branch.referral.Branch;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BranchModule_ProvideBranchFactory implements Factory<Branch> {
    private final Provider<Application> applicationProvider;
    private final BranchModule module;

    public BranchModule_ProvideBranchFactory(BranchModule branchModule, Provider<Application> provider) {
        this.module = branchModule;
        this.applicationProvider = provider;
    }

    @Override // javax.inject.Provider
    public final Branch get() {
        return provideBranch(this.module, this.applicationProvider.get());
    }

    public static BranchModule_ProvideBranchFactory create(BranchModule branchModule, Provider<Application> provider) {
        return new BranchModule_ProvideBranchFactory(branchModule, provider);
    }

    public static Branch provideBranch(BranchModule branchModule, Application application) {
        return (Branch) Preconditions.BuiltInFictitiousFunctionClassFactory(branchModule.provideBranch(application));
    }
}
