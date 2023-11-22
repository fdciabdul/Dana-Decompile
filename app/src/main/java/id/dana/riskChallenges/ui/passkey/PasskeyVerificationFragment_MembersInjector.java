package id.dana.riskChallenges.ui.passkey;

import dagger.MembersInjector;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Named;

/* loaded from: classes5.dex */
public final class PasskeyVerificationFragment_MembersInjector implements MembersInjector<PasskeyVerificationFragment> {
    public static void getAuthRequestContext(PasskeyVerificationFragment passkeyVerificationFragment, ViewModelFactory viewModelFactory) {
        passkeyVerificationFragment.viewModelFactory = viewModelFactory;
    }

    @Named("passkeyExecutor")
    public static void MyBillsEntityDataFactory(PasskeyVerificationFragment passkeyVerificationFragment, ThreadExecutor threadExecutor) {
        passkeyVerificationFragment.threadExecutor = threadExecutor;
    }
}
