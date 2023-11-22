package id.dana.data.nearbyme.repository.source.split;

import id.dana.data.nearbyme.model.MerchantDetailPromoConfigEntity;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.constant.ConfigType;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.exception.UnexpectedTreatment;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.domain.extension.CoroutinesExtKt;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lid/dana/data/nearbyme/model/MerchantDetailPromoConfigEntity;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$2", f = "SplitMerchantConfigEntity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MerchantDetailPromoConfigEntity>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SplitMerchantConfigEntity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$2(SplitMerchantConfigEntity splitMerchantConfigEntity, Continuation<? super SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$2> continuation) {
        super(2, continuation);
        this.this$0 = splitMerchantConfigEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$2 splitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$2 = new SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$2(this.this$0, continuation);
        splitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$2.L$0 = obj;
        return splitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super MerchantDetailPromoConfigEntity> continuation) {
        return ((SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SplitFacade splitFacade;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            splitFacade = this.this$0.splitFacade;
            return splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$2$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj2) {
                    ObservableSource m1535invokeSuspend$lambda0;
                    m1535invokeSuspend$lambda0 = SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$2.m1535invokeSuspend$lambda0((BaseTrafficType) obj2);
                    return m1535invokeSuspend$lambda0;
                }
            }).observeOn(CoroutinesExtKt.asScheduler(coroutineScope)).blockingFirst();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final ObservableSource m1535invokeSuspend$lambda0(final BaseTrafficType baseTrafficType) {
        final boolean z = true;
        final MerchantDetailPromoConfigEntity merchantDetailPromoConfigEntity = new MerchantDetailPromoConfigEntity(true, 4);
        final String str = "merchant_detail_promo_config";
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$2$invokeSuspend$lambda-0$$inlined$getConfigOnceReady$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(str);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str2 = str;
                String BuiltInFictitiousFunctionClassFactory = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = merchantDetailPromoConfigEntity;
                final boolean z2 = z;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str3 = str;
                MyBillsEntityDataFactory.getAuthRequestContext(str2, BuiltInFictitiousFunctionClassFactory, MerchantDetailPromoConfigEntity.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$2$invokeSuspend$lambda-0$$inlined$getConfigOnceReady$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String treatment, T value) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(treatment, "");
                        if (value != null) {
                            boolean z3 = z2;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str4 = str3;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z3 && Intrinsics.areEqual(treatment, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(treatment), str4, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str4));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(treatment), str4, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(value);
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
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(treatment), str5, "Not Received", ConfigType.ASYNC);
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
