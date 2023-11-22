package id.dana.domain.login.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.homeinfo.HomeWidgetClearable;
import id.dana.domain.login.LoginRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class ForceLogout extends UseCase<Boolean, Void> {
    private final GlobalNetworkRepository globalNetworkRepository;
    private final HomeWidgetClearable homeWidgetClearable;
    private final LoginRepository loginRepository;

    @Inject
    public ForceLogout(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, LoginRepository loginRepository, GlobalNetworkRepository globalNetworkRepository, HomeWidgetClearable homeWidgetClearable) {
        super(threadExecutor, postExecutionThread);
        this.loginRepository = loginRepository;
        this.globalNetworkRepository = globalNetworkRepository;
        this.homeWidgetClearable = homeWidgetClearable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Void r2) {
        this.homeWidgetClearable.clearHomeWidgetCache();
        return this.globalNetworkRepository.clearGlobalNetwork().flatMap(new Function() { // from class: id.dana.domain.login.interactor.ForceLogout$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ForceLogout.this.m2361x4be7f934((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$buildUseCaseObservable$0$id-dana-domain-login-interactor-ForceLogout  reason: not valid java name */
    public /* synthetic */ ObservableSource m2361x4be7f934(Boolean bool) throws Exception {
        return this.loginRepository.forceLogout();
    }
}
