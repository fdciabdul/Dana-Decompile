package id.dana.data.di;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import io.branch.referral.Branch;
import io.branch.referral.PrefHelper;
import javax.inject.Singleton;

@Module
/* loaded from: classes.dex */
public class BranchModule {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public Branch provideBranch(Application application) {
        PrefHelper.PlaceComponentResult();
        return Branch.PlaceComponentResult(application);
    }
}
