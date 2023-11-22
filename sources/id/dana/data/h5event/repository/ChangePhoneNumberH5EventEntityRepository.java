package id.dana.data.h5event.repository;

import id.dana.data.h5event.changephone.ChangePhoneFinishEntity;
import id.dana.data.h5event.changephone.ChangePhoneNumberEventManager;
import id.dana.domain.h5event.ChangePhoneNumberH5EventRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class ChangePhoneNumberH5EventEntityRepository implements ChangePhoneNumberH5EventRepository {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public ChangePhoneNumberH5EventEntityRepository() {
    }

    @Override // id.dana.domain.h5event.ChangePhoneNumberH5EventRepository
    public Observable<Boolean> getChangePhoneNumberH5Event() {
        return Observable.defer(new Callable() { // from class: id.dana.data.h5event.repository.ChangePhoneNumberH5EventEntityRepository$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource create;
                create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.h5event.repository.ChangePhoneNumberH5EventEntityRepository$$ExternalSyntheticLambda0
                    @Override // io.reactivex.ObservableOnSubscribe
                    public final void subscribe(ObservableEmitter observableEmitter) {
                        ChangePhoneNumberEventManager.setChangePhoneFinishCallback(new ChangePhoneNumberEventManager.ChangePhoneFinishCallback() { // from class: id.dana.data.h5event.repository.ChangePhoneNumberH5EventEntityRepository$$ExternalSyntheticLambda2
                            @Override // id.dana.data.h5event.changephone.ChangePhoneNumberEventManager.ChangePhoneFinishCallback
                            public final void onChangePhoneFinished(ChangePhoneFinishEntity changePhoneFinishEntity) {
                                ChangePhoneNumberH5EventEntityRepository.lambda$getChangePhoneNumberH5Event$0(ObservableEmitter.this, changePhoneFinishEntity);
                            }
                        });
                    }
                });
                return create;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getChangePhoneNumberH5Event$0(ObservableEmitter observableEmitter, ChangePhoneFinishEntity changePhoneFinishEntity) {
        if (changePhoneFinishEntity != null) {
            observableEmitter.onNext(Boolean.valueOf(changePhoneFinishEntity.isApiSuccess()));
            observableEmitter.onComplete();
            return;
        }
        observableEmitter.onError(new NullPointerException());
    }
}
