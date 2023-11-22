package id.dana.riskChallenges.ui.passkey.main;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.danah5.DanaH5Facade;
import javax.inject.Named;

/* loaded from: classes5.dex */
public final class EnrollmentMainFragment_MembersInjector implements MembersInjector<EnrollmentMainFragment> {
    public static void PlaceComponentResult(EnrollmentMainFragment enrollmentMainFragment, ViewModelFactory viewModelFactory) {
        enrollmentMainFragment.viewModelFactory = viewModelFactory;
    }

    @Named("passkeyExecutor")
    public static void MyBillsEntityDataFactory(EnrollmentMainFragment enrollmentMainFragment, ThreadExecutor threadExecutor) {
        enrollmentMainFragment.threadExecutor = threadExecutor;
    }

    public static void MyBillsEntityDataFactory(EnrollmentMainFragment enrollmentMainFragment, Lazy<DanaH5Facade> lazy) {
        enrollmentMainFragment.danaH5Facade = lazy;
    }
}
