package id.dana.mybills.data.repository.source.split;

import id.dana.data.toggle.constant.ConfigType;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.exception.UnexpectedTreatment;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.lib.toggle.ToggleCallback;
import id.dana.lib.toggle.ToggleManager;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.data.repository.source.split.SplitMyBillsEntityData$isServiceEnable$1", f = "SplitMyBillsEntityData.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes9.dex */
final class SplitMyBillsEntityData$isServiceEnable$1 extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $splitName;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SplitMyBillsEntityData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitMyBillsEntityData$isServiceEnable$1(SplitMyBillsEntityData splitMyBillsEntityData, String str, Continuation<? super SplitMyBillsEntityData$isServiceEnable$1> continuation) {
        super(2, continuation);
        this.this$0 = splitMyBillsEntityData;
        this.$splitName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SplitMyBillsEntityData$isServiceEnable$1 splitMyBillsEntityData$isServiceEnable$1 = new SplitMyBillsEntityData$isServiceEnable$1(this.this$0, this.$splitName, continuation);
        splitMyBillsEntityData$isServiceEnable$1.L$0 = obj;
        return splitMyBillsEntityData$isServiceEnable$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Boolean> flowCollector, Continuation<? super Unit> continuation) {
        return ((SplitMyBillsEntityData$isServiceEnable$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Observable<BaseTrafficType> KClassImpl$Data$declaredNonStaticMembers$2 = SplitMyBillsEntityData.MyBillsEntityDataFactory(this.this$0).KClassImpl$Data$declaredNonStaticMembers$2();
            final String str = this.$splitName;
            Object blockingFirst = KClassImpl$Data$declaredNonStaticMembers$2.flatMap(new Function() { // from class: id.dana.mybills.data.repository.source.split.SplitMyBillsEntityData$isServiceEnable$1$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj2) {
                    ObservableSource m2676invokeSuspend$lambda0;
                    m2676invokeSuspend$lambda0 = SplitMyBillsEntityData$isServiceEnable$1.m2676invokeSuspend$lambda0(str, (BaseTrafficType) obj2);
                    return m2676invokeSuspend$lambda0;
                }
            }).blockingFirst();
            Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
            this.label = 1;
            if (flowCollector.emit(blockingFirst, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final ObservableSource m2676invokeSuspend$lambda0(final String str, final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullExpressionValue(baseTrafficType, "");
        final Boolean bool = Boolean.FALSE;
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.mybills.data.repository.source.split.SplitMyBillsEntityData$isServiceEnable$1$invokeSuspend$lambda-0$$inlined$getConfigOnceReady$default$1
            final /* synthetic */ boolean $getAuthRequestContext = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(str);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str2 = str;
                String BuiltInFictitiousFunctionClassFactory = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = bool;
                final boolean z = this.$getAuthRequestContext;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str3 = str;
                MyBillsEntityDataFactory.getAuthRequestContext(str2, BuiltInFictitiousFunctionClassFactory, Boolean.class, obj, new ToggleCallback<T>() { // from class: id.dana.mybills.data.repository.source.split.SplitMyBillsEntityData$isServiceEnable$1$invokeSuspend$lambda-0$$inlined$getConfigOnceReady$default$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String p0, T p1) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 != null) {
                            boolean z2 = z;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str4 = str3;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z2 && Intrinsics.areEqual(p0, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str4));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(p1);
                                observableEmitter2.onComplete();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BaseTrafficType baseTrafficType4 = baseTrafficType2;
                            String str5 = str3;
                            ObservableEmitter observableEmitter3 = observableEmitter;
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str5, "Not Received", ConfigType.ASYNC);
                            observableEmitter3.onError(new SplitNull(str5));
                        }
                    }

                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onError() {
                        baseTrafficType2.MyBillsEntityDataFactory("", str3, "Not Received", ConfigType.ASYNC);
                        observableEmitter.onError(new SplitException("Error when get toggle config"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create;
    }
}
