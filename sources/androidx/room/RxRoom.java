package androidx.room;

import androidx.room.InvalidationTracker;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public class RxRoom {
    public static final Object getAuthRequestContext = new Object();

    /* renamed from: androidx.room.RxRoom$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements FlowableOnSubscribe<Object> {
        final /* synthetic */ String[] MyBillsEntityDataFactory;
        final /* synthetic */ RoomDatabase PlaceComponentResult;

        @Override // io.reactivex.FlowableOnSubscribe
        public void BuiltInFictitiousFunctionClassFactory(final FlowableEmitter<Object> flowableEmitter) throws Exception {
            final InvalidationTracker.Observer observer = new InvalidationTracker.Observer(this.MyBillsEntityDataFactory) { // from class: androidx.room.RxRoom.1.1
                @Override // androidx.room.InvalidationTracker.Observer
                public final void PlaceComponentResult(Set<String> set) {
                    if (flowableEmitter.isCancelled()) {
                        return;
                    }
                    flowableEmitter.onNext(RxRoom.getAuthRequestContext);
                }
            };
            if (!flowableEmitter.isCancelled()) {
                this.PlaceComponentResult.getInvalidationTracker().MyBillsEntityDataFactory(observer);
                flowableEmitter.setDisposable(Disposables.BuiltInFictitiousFunctionClassFactory(new Action() { // from class: androidx.room.RxRoom.1.2
                    @Override // io.reactivex.functions.Action
                    public void run() throws Exception {
                        AnonymousClass1.this.PlaceComponentResult.getInvalidationTracker().getAuthRequestContext(observer);
                    }
                }));
            }
            if (flowableEmitter.isCancelled()) {
                return;
            }
            flowableEmitter.onNext(RxRoom.getAuthRequestContext);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: androidx.room.RxRoom$5  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass5<T> implements SingleOnSubscribe<T> {
        final /* synthetic */ Callable PlaceComponentResult;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.SingleOnSubscribe
        public void subscribe(SingleEmitter<T> singleEmitter) throws Exception {
            try {
                singleEmitter.onSuccess(this.PlaceComponentResult.call());
            } catch (EmptyResultSetException e) {
                singleEmitter.tryOnError(e);
            }
        }
    }

    @Deprecated
    public RxRoom() {
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: androidx.room.RxRoom$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass2<T> implements Function<Object, MaybeSource<T>> {
        final /* synthetic */ Maybe getAuthRequestContext;

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return this.getAuthRequestContext;
        }
    }

    public static <T> Observable<T> BuiltInFictitiousFunctionClassFactory(final RoomDatabase roomDatabase, final String[] strArr, Callable<T> callable) {
        Scheduler BuiltInFictitiousFunctionClassFactory = Schedulers.BuiltInFictitiousFunctionClassFactory(roomDatabase.getQueryExecutor());
        final Maybe PlaceComponentResult = Maybe.PlaceComponentResult(callable);
        return (Observable<T>) Observable.create(new ObservableOnSubscribe<Object>() { // from class: androidx.room.RxRoom.3
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(final ObservableEmitter<Object> observableEmitter) throws Exception {
                final InvalidationTracker.Observer observer = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.RxRoom.3.1
                    @Override // androidx.room.InvalidationTracker.Observer
                    public final void PlaceComponentResult(Set<String> set) {
                        observableEmitter.onNext(RxRoom.getAuthRequestContext);
                    }
                };
                roomDatabase.getInvalidationTracker().MyBillsEntityDataFactory(observer);
                observableEmitter.setDisposable(Disposables.BuiltInFictitiousFunctionClassFactory(new Action() { // from class: androidx.room.RxRoom.3.2
                    @Override // io.reactivex.functions.Action
                    public void run() throws Exception {
                        roomDatabase.getInvalidationTracker().getAuthRequestContext(observer);
                    }
                }));
                observableEmitter.onNext(RxRoom.getAuthRequestContext);
            }
        }).subscribeOn(BuiltInFictitiousFunctionClassFactory).unsubscribeOn(BuiltInFictitiousFunctionClassFactory).observeOn(BuiltInFictitiousFunctionClassFactory).flatMapMaybe(new Function<Object, MaybeSource<T>>() { // from class: androidx.room.RxRoom.4
            @Override // io.reactivex.functions.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
                return Maybe.this;
            }
        });
    }
}
