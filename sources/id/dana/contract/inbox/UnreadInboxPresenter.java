package id.dana.contract.inbox;

import dagger.Lazy;
import id.dana.contract.inbox.UnreadInboxContract;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.notificationcenter.interactor.HasNewInbox;
import id.dana.domain.notificationcenter.model.HasNewResponse;
import javax.inject.Inject;

@PerActivity
/* loaded from: classes4.dex */
public class UnreadInboxPresenter implements UnreadInboxContract.Presenter {
    private final Lazy<UnreadInboxContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Lazy<HasNewInbox> KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public UnreadInboxPresenter(Lazy<UnreadInboxContract.View> lazy, Lazy<HasNewInbox> lazy2) {
        this.BuiltInFictitiousFunctionClassFactory = lazy;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy2;
    }

    @Override // id.dana.contract.inbox.UnreadInboxContract.Presenter
    public final void getAuthRequestContext() {
        this.BuiltInFictitiousFunctionClassFactory.get().showProgress();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(new DefaultObserver<HasNewResponse>() { // from class: id.dana.contract.inbox.UnreadInboxPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                ((UnreadInboxContract.View) UnreadInboxPresenter.this.BuiltInFictitiousFunctionClassFactory.get()).dismissProgress();
                ((UnreadInboxContract.View) UnreadInboxPresenter.this.BuiltInFictitiousFunctionClassFactory.get()).BuiltInFictitiousFunctionClassFactory(((HasNewResponse) obj).isHasNew());
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                ((UnreadInboxContract.View) UnreadInboxPresenter.this.BuiltInFictitiousFunctionClassFactory.get()).dismissProgress();
                ((UnreadInboxContract.View) UnreadInboxPresenter.this.BuiltInFictitiousFunctionClassFactory.get()).onError(th.getMessage());
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
    }
}
