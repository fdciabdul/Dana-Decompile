package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class ObservableGenerate<T, S> extends Observable<T> {
    final BiFunction<S, Emitter<T>, S> BuiltInFictitiousFunctionClassFactory;
    final Callable<S> PlaceComponentResult;
    final Consumer<? super S> getAuthRequestContext;

    public ObservableGenerate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.PlaceComponentResult = callable;
        this.BuiltInFictitiousFunctionClassFactory = biFunction;
        this.getAuthRequestContext = consumer;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        try {
            GeneratorDisposable generatorDisposable = new GeneratorDisposable(observer, this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, this.PlaceComponentResult.call());
            observer.onSubscribe(generatorDisposable);
            S s = generatorDisposable.getErrorConfigVersion;
            if (generatorDisposable.BuiltInFictitiousFunctionClassFactory) {
                generatorDisposable.getErrorConfigVersion = null;
                try {
                    generatorDisposable.getAuthRequestContext.accept(s);
                    return;
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    RxJavaPlugins.PlaceComponentResult(th);
                    return;
                }
            }
            BiFunction<S, ? super Emitter<T>, S> biFunction = generatorDisposable.MyBillsEntityDataFactory;
            while (!generatorDisposable.BuiltInFictitiousFunctionClassFactory) {
                generatorDisposable.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                try {
                    s = biFunction.apply(s, generatorDisposable);
                    if (generatorDisposable.lookAheadTest) {
                        generatorDisposable.BuiltInFictitiousFunctionClassFactory = true;
                        generatorDisposable.getErrorConfigVersion = null;
                        try {
                            generatorDisposable.getAuthRequestContext.accept(s);
                            return;
                        } catch (Throwable th2) {
                            Exceptions.MyBillsEntityDataFactory(th2);
                            RxJavaPlugins.PlaceComponentResult(th2);
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    Exceptions.MyBillsEntityDataFactory(th3);
                    generatorDisposable.getErrorConfigVersion = null;
                    generatorDisposable.BuiltInFictitiousFunctionClassFactory = true;
                    generatorDisposable.onError(th3);
                    try {
                        generatorDisposable.getAuthRequestContext.accept(s);
                        return;
                    } catch (Throwable th4) {
                        Exceptions.MyBillsEntityDataFactory(th4);
                        RxJavaPlugins.PlaceComponentResult(th4);
                        return;
                    }
                }
            }
            generatorDisposable.getErrorConfigVersion = null;
            try {
                generatorDisposable.getAuthRequestContext.accept(s);
            } catch (Throwable th5) {
                Exceptions.MyBillsEntityDataFactory(th5);
                RxJavaPlugins.PlaceComponentResult(th5);
            }
        } catch (Throwable th6) {
            Exceptions.MyBillsEntityDataFactory(th6);
            EmptyDisposable.error(th6, observer);
        }
    }

    /* loaded from: classes9.dex */
    static final class GeneratorDisposable<T, S> implements Emitter<T>, Disposable {
        volatile boolean BuiltInFictitiousFunctionClassFactory;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final BiFunction<S, ? super Emitter<T>, S> MyBillsEntityDataFactory;
        final Observer<? super T> PlaceComponentResult;
        final Consumer<? super S> getAuthRequestContext;
        S getErrorConfigVersion;
        boolean lookAheadTest;

        GeneratorDisposable(Observer<? super T> observer, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s) {
            this.PlaceComponentResult = observer;
            this.MyBillsEntityDataFactory = biFunction;
            this.getAuthRequestContext = consumer;
            this.getErrorConfigVersion = s;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.BuiltInFictitiousFunctionClassFactory = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // io.reactivex.Emitter
        public final void onNext(T t) {
            if (this.lookAheadTest) {
                return;
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                this.PlaceComponentResult.onNext(t);
            }
        }

        @Override // io.reactivex.Emitter
        public final void onError(Throwable th) {
            if (this.lookAheadTest) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.lookAheadTest = true;
            this.PlaceComponentResult.onError(th);
        }

        @Override // io.reactivex.Emitter
        public final void onComplete() {
            if (this.lookAheadTest) {
                return;
            }
            this.lookAheadTest = true;
            this.PlaceComponentResult.onComplete();
        }
    }
}
