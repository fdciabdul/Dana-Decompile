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
public class Logout extends UseCase<Boolean, Void> {
    private final GlobalNetworkRepository globalNetworkRepository;
    private final HomeWidgetClearable homeWidgetClearable;
    private final LoginRepository loginRepository;

    @Inject
    public Logout(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, LoginRepository loginRepository, HomeWidgetClearable homeWidgetClearable, GlobalNetworkRepository globalNetworkRepository) {
        super(threadExecutor, postExecutionThread);
        this.loginRepository = loginRepository;
        this.globalNetworkRepository = globalNetworkRepository;
        this.homeWidgetClearable = homeWidgetClearable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Void r2) {
        return this.globalNetworkRepository.clearGlobalNetwork().onErrorResumeNext(new Function() { // from class: id.dana.domain.login.interactor.Logout$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return Logout.this.m2362x1bf3d4b((Throwable) obj);
            }
        }).flatMap(new Function() { // from class: id.dana.domain.login.interactor.Logout$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Observable doLogout;
                doLogout = Logout.this.doLogout(((Boolean) obj).booleanValue());
                return doLogout;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$buildUseCaseObservable$0$id-dana-domain-login-interactor-Logout  reason: not valid java name */
    public /* synthetic */ ObservableSource m2362x1bf3d4b(Throwable th) throws Exception {
        return doLogout(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Observable<Boolean> doLogout(boolean z) {
        this.homeWidgetClearable.clearHomeWidgetCache();
        return z ? this.loginRepository.logout() : Observable.just(Boolean.FALSE);
    }
}
