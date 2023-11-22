package id.dana.sendmoney.data.repository.core.source.split;

import android.view.KeyEvent;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.constant.ConfigType;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.exception.UnexpectedTreatment;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.lib.toggle.ToggleCallback;
import id.dana.lib.toggle.ToggleManager;
import id.dana.sendmoney.data.config.core.model.SendMoneyApiMigrationConfigEntity;
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
import o.getOnBoardingScenario;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lid/dana/sendmoney/data/config/core/model/SendMoneyApiMigrationConfigEntity;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.data.repository.core.source.split.SplitSendMoneyCoreEntityDataImpl$getSendMoneyApiMigrationConfig$1", f = "SplitSendMoneyCoreEntityDataImpl.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class SplitSendMoneyCoreEntityDataImpl$getSendMoneyApiMigrationConfig$1 extends SuspendLambda implements Function2<FlowCollector<? super SendMoneyApiMigrationConfigEntity>, Continuation<? super Unit>, Object> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int MyBillsEntityDataFactory = 1;
    private static long getAuthRequestContext = 1441786598054919413L;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SplitSendMoneyCoreEntityDataImpl this$0;

    public static /* synthetic */ ObservableSource $r8$lambda$L49fjS3kzcklfOCatygTPohqfOk(BaseTrafficType baseTrafficType) {
        ObservableSource m2894invokeSuspend$lambda0;
        int i = BuiltInFictitiousFunctionClassFactory + 5;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 != 0) {
            m2894invokeSuspend$lambda0 = m2894invokeSuspend$lambda0(baseTrafficType);
        } else {
            try {
                m2894invokeSuspend$lambda0 = m2894invokeSuspend$lambda0(baseTrafficType);
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            int i2 = BuiltInFictitiousFunctionClassFactory + 107;
            MyBillsEntityDataFactory = i2 % 128;
            int i3 = i2 % 2;
            return m2894invokeSuspend$lambda0;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitSendMoneyCoreEntityDataImpl$getSendMoneyApiMigrationConfig$1(SplitSendMoneyCoreEntityDataImpl splitSendMoneyCoreEntityDataImpl, Continuation<? super SplitSendMoneyCoreEntityDataImpl$getSendMoneyApiMigrationConfig$1> continuation) {
        super(2, continuation);
        this.this$0 = splitSendMoneyCoreEntityDataImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SplitSendMoneyCoreEntityDataImpl$getSendMoneyApiMigrationConfig$1 splitSendMoneyCoreEntityDataImpl$getSendMoneyApiMigrationConfig$1 = new SplitSendMoneyCoreEntityDataImpl$getSendMoneyApiMigrationConfig$1(this.this$0, continuation);
        splitSendMoneyCoreEntityDataImpl$getSendMoneyApiMigrationConfig$1.L$0 = obj;
        SplitSendMoneyCoreEntityDataImpl$getSendMoneyApiMigrationConfig$1 splitSendMoneyCoreEntityDataImpl$getSendMoneyApiMigrationConfig$12 = splitSendMoneyCoreEntityDataImpl$getSendMoneyApiMigrationConfig$1;
        int i = MyBillsEntityDataFactory + 65;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (i % 2 == 0) {
            return splitSendMoneyCoreEntityDataImpl$getSendMoneyApiMigrationConfig$12;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return splitSendMoneyCoreEntityDataImpl$getSendMoneyApiMigrationConfig$12;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super SendMoneyApiMigrationConfigEntity> flowCollector, Continuation<? super Unit> continuation) {
        int i = BuiltInFictitiousFunctionClassFactory + 79;
        MyBillsEntityDataFactory = i % 128;
        boolean z = i % 2 == 0;
        Object invoke2 = invoke2(flowCollector, continuation);
        if (z) {
            int i2 = 75 / 0;
        }
        try {
            int i3 = MyBillsEntityDataFactory + 103;
            try {
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
                return invoke2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super SendMoneyApiMigrationConfigEntity> flowCollector, Continuation<? super Unit> continuation) {
        int i = MyBillsEntityDataFactory + 109;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 != 0 ? '3' : '/') != '3') {
            try {
                return ((SplitSendMoneyCoreEntityDataImpl$getSendMoneyApiMigrationConfig$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            } catch (Exception e) {
                throw e;
            }
        }
        Object invokeSuspend = ((SplitSendMoneyCoreEntityDataImpl$getSendMoneyApiMigrationConfig$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        Object obj = null;
        obj.hashCode();
        return invokeSuspend;
    }

    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    private static final ObservableSource m2894invokeSuspend$lambda0(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullExpressionValue(baseTrafficType, "");
        SendMoneyCoreDefaultConfigGenerator sendMoneyCoreDefaultConfigGenerator = SendMoneyCoreDefaultConfigGenerator.INSTANCE;
        final SendMoneyApiMigrationConfigEntity MyBillsEntityDataFactory2 = SendMoneyCoreDefaultConfigGenerator.MyBillsEntityDataFactory();
        Object[] objArr = new Object[1];
        a(52813 - KeyEvent.normalizeMetaState(0), new char[]{44485, 25502, 12610, 50997, 38127, 43608, 30742, 2504, 57255, 60764, 41685, 28809, 1603, 54272, 58861, 47964, 18689, 7897, 11453, 57973, 46043, 16776, 5958}, objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.sendmoney.data.repository.core.source.split.SplitSendMoneyCoreEntityDataImpl$getSendMoneyApiMigrationConfig$1$invokeSuspend$lambda-0$$inlined$getConfigOnceReady$default$1
            final /* synthetic */ boolean $MyBillsEntityDataFactory = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory3 = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = MyBillsEntityDataFactory2;
                final boolean z = this.$MyBillsEntityDataFactory;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory3.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, SendMoneyApiMigrationConfigEntity.class, obj, new ToggleCallback<T>() { // from class: id.dana.sendmoney.data.repository.core.source.split.SplitSendMoneyCoreEntityDataImpl$getSendMoneyApiMigrationConfig$1$invokeSuspend$lambda-0$$inlined$getConfigOnceReady$default$1.1
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
        int i = BuiltInFictitiousFunctionClassFactory + 121;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
            return observable;
        }
        return observable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SplitFacade splitFacade;
        int i = MyBillsEntityDataFactory + 27;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if ((i3 != 0 ? '5' : '2') != '2') {
            if (!(i3 == 1)) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = MyBillsEntityDataFactory + 105;
            BuiltInFictitiousFunctionClassFactory = i4 % 128;
            int i5 = i4 % 2;
            ResultKt.throwOnFailure(obj);
        } else {
            try {
                ResultKt.throwOnFailure(obj);
                try {
                    FlowCollector flowCollector = (FlowCollector) this.L$0;
                    splitFacade = this.this$0.BuiltInFictitiousFunctionClassFactory;
                    Object blockingFirst = splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.sendmoney.data.repository.core.source.split.SplitSendMoneyCoreEntityDataImpl$getSendMoneyApiMigrationConfig$1$$ExternalSyntheticLambda0
                        @Override // io.reactivex.functions.Function
                        public final Object apply(Object obj2) {
                            return SplitSendMoneyCoreEntityDataImpl$getSendMoneyApiMigrationConfig$1.$r8$lambda$L49fjS3kzcklfOCatygTPohqfOk((BaseTrafficType) obj2);
                        }
                    }).blockingFirst();
                    Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
                    this.label = 1;
                    if (flowCollector.emit(blockingFirst, this) == coroutine_suspended) {
                        int i6 = BuiltInFictitiousFunctionClassFactory + 117;
                        MyBillsEntityDataFactory = i6 % 128;
                        int i7 = i6 % 2;
                        return coroutine_suspended;
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        return Unit.INSTANCE;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        int i2;
        int i3;
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            if ((getonboardingscenario.getAuthRequestContext < cArr.length ? (char) 0 : (char) 25) == 25) {
                break;
            }
            int i4 = $10 + 55;
            $11 = i4 % 128;
            if (!(i4 % 2 == 0)) {
                jArr[getonboardingscenario.getAuthRequestContext] = (4796183387843776835L ^ getAuthRequestContext) ^ (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory));
                i3 = getonboardingscenario.getAuthRequestContext + 1;
            } else {
                jArr[getonboardingscenario.getAuthRequestContext] = (4796183387843776835L & getAuthRequestContext) ^ (cArr[getonboardingscenario.getAuthRequestContext] / (getonboardingscenario.getAuthRequestContext + getonboardingscenario.MyBillsEntityDataFactory));
                i3 = getonboardingscenario.getAuthRequestContext % 1;
            }
            getonboardingscenario.getAuthRequestContext = i3;
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            int i5 = $11 + 45;
            $10 = i5 % 128;
            if (i5 % 2 != 0) {
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                i2 = getonboardingscenario.getAuthRequestContext * 0;
            } else {
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                i2 = getonboardingscenario.getAuthRequestContext + 1;
            }
            getonboardingscenario.getAuthRequestContext = i2;
        }
        String str = new String(cArr2);
        int i6 = $10 + 67;
        $11 = i6 % 128;
        int i7 = i6 % 2;
        objArr[0] = str;
    }
}
