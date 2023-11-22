package id.dana.contract.shortener;

import id.dana.contract.shortener.ShortenUrlContract;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.shortener.interactor.ShortenUrl;
import javax.inject.Inject;

@PerActivity
/* loaded from: classes8.dex */
public class ShortenUrlPresenter implements ShortenUrlContract.Presenter {
    private final ShortenUrl MyBillsEntityDataFactory;
    private final ShortenUrlContract.View getAuthRequestContext;

    @Inject
    public ShortenUrlPresenter(ShortenUrlContract.View view, ShortenUrl shortenUrl) {
        this.getAuthRequestContext = view;
        this.MyBillsEntityDataFactory = shortenUrl;
    }

    /* renamed from: id.dana.contract.shortener.ShortenUrlPresenter$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass1 extends DefaultObserver<String> {
        final /* synthetic */ ShortenUrlPresenter PlaceComponentResult;

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public /* synthetic */ void onNext(Object obj) {
            String str = (String) obj;
            this.PlaceComponentResult.getAuthRequestContext.dismissProgress();
            ShortenUrlContract.View unused = this.PlaceComponentResult.getAuthRequestContext;
        }

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            this.PlaceComponentResult.getAuthRequestContext.dismissProgress();
            this.PlaceComponentResult.getAuthRequestContext.onError(th.getMessage());
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
    }
}
