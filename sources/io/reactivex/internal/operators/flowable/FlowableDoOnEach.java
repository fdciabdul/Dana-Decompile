package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final class FlowableDoOnEach<T> extends AbstractFlowableWithUpstream<T, T> {
    final Action KClassImpl$Data$declaredNonStaticMembers$2;
    final Action MyBillsEntityDataFactory;
    final Consumer<? super Throwable> getAuthRequestContext;
    final Consumer<? super T> moveToNextValue;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new DoOnEachConditionalSubscriber((ConditionalSubscriber) subscriber, this.moveToNextValue, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory));
        } else {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new DoOnEachSubscriber(subscriber, this.moveToNextValue, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory));
        }
    }

    /* loaded from: classes9.dex */
    static final class DoOnEachSubscriber<T> extends BasicFuseableSubscriber<T, T> {
        final Action BuiltInFictitiousFunctionClassFactory;
        final Consumer<? super T> KClassImpl$Data$declaredNonStaticMembers$2;
        final Consumer<? super Throwable> PlaceComponentResult;
        final Action getAuthRequestContext;

        DoOnEachSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            super(subscriber);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = consumer;
            this.PlaceComponentResult = consumer2;
            this.BuiltInFictitiousFunctionClassFactory = action;
            this.getAuthRequestContext = action2;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.moveToNextValue) {
                return;
            }
            if (this.getErrorConfigVersion != 0) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.onNext(null);
                return;
            }
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2.accept(t);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.onNext(t);
            } catch (Throwable th) {
                getAuthRequestContext(th);
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.moveToNextValue) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            boolean z = true;
            this.moveToNextValue = true;
            try {
                this.PlaceComponentResult.accept(th);
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.onError(th);
            }
            try {
                this.getAuthRequestContext.run();
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                RxJavaPlugins.PlaceComponentResult(th3);
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.moveToNextValue) {
                return;
            }
            try {
                this.BuiltInFictitiousFunctionClassFactory.run();
                this.moveToNextValue = true;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.onComplete();
                try {
                    this.getAuthRequestContext.run();
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    RxJavaPlugins.PlaceComponentResult(th);
                }
            } catch (Throwable th2) {
                getAuthRequestContext(th2);
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            return MyBillsEntityDataFactory(i);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() throws Exception {
            try {
                T poll = this.lookAheadTest.poll();
                if (poll != null) {
                    try {
                        this.KClassImpl$Data$declaredNonStaticMembers$2.accept(poll);
                    } catch (Throwable th) {
                        try {
                            Exceptions.MyBillsEntityDataFactory(th);
                            try {
                                this.PlaceComponentResult.accept(th);
                                throw ExceptionHelper.PlaceComponentResult(th);
                            } catch (Throwable th2) {
                                throw new CompositeException(th, th2);
                            }
                        } finally {
                            this.getAuthRequestContext.run();
                        }
                    }
                } else if (this.getErrorConfigVersion == 1) {
                    this.BuiltInFictitiousFunctionClassFactory.run();
                }
                return poll;
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                try {
                    this.PlaceComponentResult.accept(th3);
                    throw ExceptionHelper.PlaceComponentResult(th3);
                } catch (Throwable th4) {
                    throw new CompositeException(th3, th4);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class DoOnEachConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        final Consumer<? super T> BuiltInFictitiousFunctionClassFactory;
        final Action KClassImpl$Data$declaredNonStaticMembers$2;
        final Consumer<? super Throwable> PlaceComponentResult;
        final Action getAuthRequestContext;

        DoOnEachConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            super(conditionalSubscriber);
            this.BuiltInFictitiousFunctionClassFactory = consumer;
            this.PlaceComponentResult = consumer2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = action;
            this.getAuthRequestContext = action2;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                return;
            }
            if (this.lookAheadTest != 0) {
                this.moveToNextValue.onNext(null);
                return;
            }
            try {
                this.BuiltInFictitiousFunctionClassFactory.accept(t);
                this.moveToNextValue.onNext(t);
            } catch (Throwable th) {
                MyBillsEntityDataFactory(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public final boolean tryOnNext(T t) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                return false;
            }
            try {
                this.BuiltInFictitiousFunctionClassFactory.accept(t);
                return this.moveToNextValue.tryOnNext(t);
            } catch (Throwable th) {
                MyBillsEntityDataFactory(th);
                return false;
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            boolean z = true;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            try {
                this.PlaceComponentResult.accept(th);
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                this.moveToNextValue.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.moveToNextValue.onError(th);
            }
            try {
                this.getAuthRequestContext.run();
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                RxJavaPlugins.PlaceComponentResult(th3);
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                return;
            }
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2.run();
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                this.moveToNextValue.onComplete();
                try {
                    this.getAuthRequestContext.run();
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    RxJavaPlugins.PlaceComponentResult(th);
                }
            } catch (Throwable th2) {
                MyBillsEntityDataFactory(th2);
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            return KClassImpl$Data$declaredNonStaticMembers$2(i);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() throws Exception {
            try {
                T poll = this.scheduleImpl.poll();
                if (poll != null) {
                    try {
                        this.BuiltInFictitiousFunctionClassFactory.accept(poll);
                    } catch (Throwable th) {
                        try {
                            Exceptions.MyBillsEntityDataFactory(th);
                            try {
                                this.PlaceComponentResult.accept(th);
                                throw ExceptionHelper.PlaceComponentResult(th);
                            } catch (Throwable th2) {
                                throw new CompositeException(th, th2);
                            }
                        } finally {
                            this.getAuthRequestContext.run();
                        }
                    }
                } else if (this.lookAheadTest == 1) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.run();
                }
                return poll;
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                try {
                    this.PlaceComponentResult.accept(th3);
                    throw ExceptionHelper.PlaceComponentResult(th3);
                } catch (Throwable th4) {
                    throw new CompositeException(th3, th4);
                }
            }
        }
    }
}
