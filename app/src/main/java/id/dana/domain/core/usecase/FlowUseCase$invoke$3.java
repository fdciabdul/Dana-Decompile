package id.dana.domain.core.usecase;

import com.huawei.hms.push.e;
import id.dana.domain.social.Result;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0000 \u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"P", "", "R", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.domain.core.usecase.FlowUseCase$invoke$3", f = "FlowUseCase.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class FlowUseCase$invoke$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Exception, Unit> $onError;
    final /* synthetic */ Function1<R, Unit> $onSuccess;
    final /* synthetic */ P $params;
    int label;
    final /* synthetic */ FlowUseCase<P, R> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowUseCase$invoke$3(FlowUseCase<? super P, R> flowUseCase, P p, Function1<? super R, Unit> function1, Function1<? super Exception, Unit> function12, Continuation<? super FlowUseCase$invoke$3> continuation) {
        super(2, continuation);
        this.this$0 = flowUseCase;
        this.$params = p;
        this.$onSuccess = function1;
        this.$onError = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FlowUseCase$invoke$3(this.this$0, this.$params, this.$onSuccess, this.$onError, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FlowUseCase$invoke$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineDispatcher coroutineDispatcher;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow m4649catch = FlowKt.m4649catch(this.this$0.execute(this.$params), new AnonymousClass1(null));
            coroutineDispatcher = ((FlowUseCase) this.this$0).coroutineDispatcher;
            Flow flowOn = FlowKt.flowOn(m4649catch, coroutineDispatcher);
            final Function1<R, Unit> function1 = this.$onSuccess;
            final Function1<Exception, Unit> function12 = this.$onError;
            this.label = 1;
            if (flowOn.collect(new FlowCollector() { // from class: id.dana.domain.core.usecase.FlowUseCase$invoke$3.2

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0000 \u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"P", "", "R", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
                @DebugMetadata(c = "id.dana.domain.core.usecase.FlowUseCase$invoke$3$2$1", f = "FlowUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: id.dana.domain.core.usecase.FlowUseCase$invoke$3$2$1  reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Function1<R, Unit> $onSuccess;
                    final /* synthetic */ Result<R> $result;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass1(Function1<? super R, Unit> function1, Result<? extends R> result, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$onSuccess = function1;
                        this.$result = result;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$onSuccess, this.$result, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.$onSuccess.invoke(((Result.Success) this.$result).getData());
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
                public final Object emit(Result<? extends R> result, Continuation<? super Unit> continuation) {
                    if (result instanceof Result.Success) {
                        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(function1, result, null), continuation);
                        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
                    } else if (result instanceof Result.Error) {
                        Object withContext2 = BuildersKt.withContext(Dispatchers.getMain(), new C01752(function12, result, null), continuation);
                        return withContext2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext2 : Unit.INSTANCE;
                    } else {
                        return Unit.INSTANCE;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0000 \u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"P", "", "R", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
                @DebugMetadata(c = "id.dana.domain.core.usecase.FlowUseCase$invoke$3$2$2", f = "FlowUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: id.dana.domain.core.usecase.FlowUseCase$invoke$3$2$2  reason: invalid class name and collision with other inner class name */
                /* loaded from: classes4.dex */
                public static final class C01752 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Function1<Exception, Unit> $onError;
                    final /* synthetic */ Result<R> $result;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C01752(Function1<? super Exception, Unit> function1, Result<? extends R> result, Continuation<? super C01752> continuation) {
                        super(2, continuation);
                        this.$onError = function1;
                        this.$result = result;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C01752(this.$onError, this.$result, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C01752) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.$onError.invoke(((Result.Error) this.$result).getException());
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\b\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u0000 \u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u008a@"}, d2 = {"P", "", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "Lid/dana/domain/social/Result;", "", e.PlaceComponentResult, "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.domain.core.usecase.FlowUseCase$invoke$3$1", f = "FlowUseCase.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.domain.core.usecase.FlowUseCase$invoke$3$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1<R> extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends R>>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Throwable th, Continuation<? super Unit> continuation) {
            return invoke((FlowCollector) ((FlowCollector) obj), th, continuation);
        }

        public final Object invoke(FlowCollector<? super Result<? extends R>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = flowCollector;
            anonymousClass1.L$1 = th;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = null;
                this.label = 1;
                if (((FlowCollector) this.L$0).emit(new Result.Error(new Exception((Throwable) this.L$1)), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
