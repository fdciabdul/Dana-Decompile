package id.dana.domain.util;

import android.content.Context;
import android.location.Location;
import id.dana.domain.globalsearch.model.LatLng;
import id.dana.domain.globalsearch.model.LatLngKt;
import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.domain.util.SingleShotLocationProvider$requestSingleUpdateObservable$1$1", f = "SingleShotLocationProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class SingleShotLocationProvider$requestSingleUpdateObservable$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ObservableEmitter<LatLng> $emitter;
    final /* synthetic */ Location $location;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleShotLocationProvider$requestSingleUpdateObservable$1$1(Location location, Context context, ObservableEmitter<LatLng> observableEmitter, Continuation<? super SingleShotLocationProvider$requestSingleUpdateObservable$1$1> continuation) {
        super(2, continuation);
        this.$location = location;
        this.$context = context;
        this.$emitter = observableEmitter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SingleShotLocationProvider$requestSingleUpdateObservable$1$1(this.$location, this.$context, this.$emitter, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SingleShotLocationProvider$requestSingleUpdateObservable$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Unit unit;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Location location = this.$location;
            if (location != null) {
                this.$emitter.onNext(LatLngKt.toLatLng(location));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                SingleShotLocationProvider singleShotLocationProvider = SingleShotLocationProvider.INSTANCE;
                Context context = this.$context;
                final ObservableEmitter<LatLng> observableEmitter = this.$emitter;
                singleShotLocationProvider.requestSingleUpdate(context, new Function1<Location, Unit>() { // from class: id.dana.domain.util.SingleShotLocationProvider$requestSingleUpdateObservable$1$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Location location2) {
                        invoke2(location2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Location location2) {
                        Intrinsics.checkNotNullParameter(location2, "");
                        observableEmitter.onNext(LatLngKt.toLatLng(location2));
                    }
                });
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
