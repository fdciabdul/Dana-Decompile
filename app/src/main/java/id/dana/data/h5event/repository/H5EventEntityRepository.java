package id.dana.data.h5event.repository;

import id.dana.data.h5event.sendmoney.CheckoutFinishCallback;
import id.dana.data.h5event.sendmoney.CheckoutFinishEntity;
import id.dana.data.h5event.sendmoney.CheckoutFinishEventManager;
import id.dana.domain.h5event.H5EventRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class H5EventEntityRepository implements H5EventRepository {
    @Inject
    public H5EventEntityRepository() {
    }

    @Override // id.dana.domain.h5event.H5EventRepository
    public Observable<Boolean> getCheckoutH5Event() {
        return Observable.defer(new Callable() { // from class: id.dana.data.h5event.repository.H5EventEntityRepository$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource create;
                create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.h5event.repository.H5EventEntityRepository$$ExternalSyntheticLambda2
                    @Override // io.reactivex.ObservableOnSubscribe
                    public final void subscribe(ObservableEmitter observableEmitter) {
                        CheckoutFinishEventManager.setCheckoutFinishCallback(new CheckoutFinishCallback() { // from class: id.dana.data.h5event.repository.H5EventEntityRepository$$ExternalSyntheticLambda1
                            @Override // id.dana.data.h5event.sendmoney.CheckoutFinishCallback
                            public final void onCheckoutFinished(CheckoutFinishEntity checkoutFinishEntity) {
                                H5EventEntityRepository.lambda$getCheckoutH5Event$0(ObservableEmitter.this, checkoutFinishEntity);
                            }
                        });
                    }
                });
                return create;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getCheckoutH5Event$0(ObservableEmitter observableEmitter, CheckoutFinishEntity checkoutFinishEntity) {
        if (checkoutFinishEntity != null) {
            observableEmitter.onNext(Boolean.valueOf(checkoutFinishEntity.getApiSuccess()));
            observableEmitter.onComplete();
            return;
        }
        observableEmitter.onError(new NullPointerException());
    }
}
