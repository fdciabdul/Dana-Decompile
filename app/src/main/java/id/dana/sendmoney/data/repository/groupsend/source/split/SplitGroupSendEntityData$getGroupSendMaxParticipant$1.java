package id.dana.sendmoney.data.repository.groupsend.source.split;

import id.dana.data.toggle.SplitFacade;
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

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendMaxParticipant$1", f = "SplitGroupSendEntityData.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class SplitGroupSendEntityData$getGroupSendMaxParticipant$1 extends SuspendLambda implements Function2<FlowCollector<? super Integer>, Continuation<? super Unit>, Object> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static char[] MyBillsEntityDataFactory = {35535, 35385, 35381, 35379, 35379, 35388, 35386, 35385, 35386, 35386, 35330, 35391, 35388, 35385, 35384, 35388, 35389, 35386, 35376, 35383, 35391, 35391, 35385, 35389, 35388, 35378};
    private static int getAuthRequestContext;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SplitGroupSendEntityData this$0;

    public static /* synthetic */ ObservableSource $r8$lambda$OAlFCxSUojvcqpyosMd9peCw5cc(BaseTrafficType baseTrafficType) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        ObservableSource m2899invokeSuspend$lambda0 = m2899invokeSuspend$lambda0(baseTrafficType);
        int i3 = getAuthRequestContext + 33;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (i3 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
            return m2899invokeSuspend$lambda0;
        }
        return m2899invokeSuspend$lambda0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitGroupSendEntityData$getGroupSendMaxParticipant$1(SplitGroupSendEntityData splitGroupSendEntityData, Continuation<? super SplitGroupSendEntityData$getGroupSendMaxParticipant$1> continuation) {
        super(2, continuation);
        this.this$0 = splitGroupSendEntityData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SplitGroupSendEntityData$getGroupSendMaxParticipant$1 splitGroupSendEntityData$getGroupSendMaxParticipant$1 = new SplitGroupSendEntityData$getGroupSendMaxParticipant$1(this.this$0, continuation);
        splitGroupSendEntityData$getGroupSendMaxParticipant$1.L$0 = obj;
        SplitGroupSendEntityData$getGroupSendMaxParticipant$1 splitGroupSendEntityData$getGroupSendMaxParticipant$12 = splitGroupSendEntityData$getGroupSendMaxParticipant$1;
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
            try {
                getAuthRequestContext = i % 128;
                if ((i % 2 != 0 ? '@' : '7') != '@') {
                    return splitGroupSendEntityData$getGroupSendMaxParticipant$12;
                }
                Object obj2 = null;
                obj2.hashCode();
                return splitGroupSendEntityData$getGroupSendMaxParticipant$12;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* synthetic */ Object invoke(FlowCollector<? super Integer> flowCollector, Continuation<? super Unit> continuation) {
        try {
            int i = getAuthRequestContext + 99;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if (i % 2 != 0) {
                return invoke2(flowCollector, continuation);
            }
            try {
                Object invoke2 = invoke2(flowCollector, continuation);
                Object obj = null;
                obj.hashCode();
                return invoke2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super Integer> flowCollector, Continuation<? super Unit> continuation) {
        int i = getAuthRequestContext + 51;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        boolean z = i % 2 != 0;
        Object invokeSuspend = ((SplitGroupSendEntityData$getGroupSendMaxParticipant$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return invokeSuspend;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SplitFacade splitFacade;
        int i = getAuthRequestContext + 109;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            try {
                ResultKt.throwOnFailure(obj);
                try {
                    FlowCollector flowCollector = (FlowCollector) this.L$0;
                    splitFacade = this.this$0.getAuthRequestContext;
                    Object blockingFirst = splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendMaxParticipant$1$$ExternalSyntheticLambda0
                        @Override // io.reactivex.functions.Function
                        public final Object apply(Object obj2) {
                            return SplitGroupSendEntityData$getGroupSendMaxParticipant$1.$r8$lambda$OAlFCxSUojvcqpyosMd9peCw5cc((BaseTrafficType) obj2);
                        }
                    }).blockingFirst();
                    Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
                    this.label = 1;
                    if ((flowCollector.emit(blockingFirst, this) == coroutine_suspended ? (char) 11 : 'V') != 'V') {
                        int i4 = getAuthRequestContext + 51;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                        if (i4 % 2 == 0) {
                            Object[] objArr = null;
                            int length = objArr.length;
                        }
                        return coroutine_suspended;
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    private static final ObservableSource m2899invokeSuspend$lambda0(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullExpressionValue(baseTrafficType, "");
        GroupSendDefaultConfigGenerator groupSendDefaultConfigGenerator = GroupSendDefaultConfigGenerator.INSTANCE;
        Object[] objArr = new Object[1];
        a(new int[]{0, 26, 59, 0}, false, new byte[]{0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0}, objArr);
        final String intern = ((String) objArr[0]).intern();
        final int i = 10;
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendMaxParticipant$1$invokeSuspend$lambda-0$$inlined$getConfigOnceReady$default$1
            final /* synthetic */ boolean $BuiltInFictitiousFunctionClassFactory = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory2 = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = i;
                final boolean z = this.$BuiltInFictitiousFunctionClassFactory;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory2.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory, Integer.class, obj, new ToggleCallback<T>() { // from class: id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendMaxParticipant$1$invokeSuspend$lambda-0$$inlined$getConfigOnceReady$default$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String p0, T p1) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 != null) {
                            boolean z2 = z;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str3 = str2;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z2 && Intrinsics.areEqual(p0, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str3, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str3));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str3, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(p1);
                                observableEmitter2.onComplete();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BaseTrafficType baseTrafficType4 = baseTrafficType2;
                            String str4 = str2;
                            ObservableEmitter observableEmitter3 = observableEmitter;
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Not Received", ConfigType.ASYNC);
                            observableEmitter3.onError(new SplitNull(str4));
                        }
                    }

                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onError() {
                        baseTrafficType2.MyBillsEntityDataFactory("", str2, "Not Received", ConfigType.ASYNC);
                        observableEmitter.onError(new SplitException("Error when get toggle config"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        Observable observable = create;
        int i2 = getAuthRequestContext + 17;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if (i2 % 2 != 0) {
            return observable;
        }
        int i3 = 0 / 0;
        return observable;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
    
        if (r18[r0.BuiltInFictitiousFunctionClassFactory] == 1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0095, code lost:
    
        if ((r18[r0.BuiltInFictitiousFunctionClassFactory] != 1) != true) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0097, code lost:
    
        r2[r0.BuiltInFictitiousFunctionClassFactory] = (char) (((r9[r0.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a5, code lost:
    
        r2[r0.BuiltInFictitiousFunctionClassFactory] = (char) ((r9[r0.BuiltInFictitiousFunctionClassFactory] * 2) - r8);
        r8 = id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendMaxParticipant$1.$10 + 31;
        id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendMaxParticipant$1.$11 = r8 % 128;
        r8 = r8 % 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int[] r16, boolean r17, byte[] r18, java.lang.Object[] r19) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendMaxParticipant$1.a(int[], boolean, byte[], java.lang.Object[]):void");
    }
}
