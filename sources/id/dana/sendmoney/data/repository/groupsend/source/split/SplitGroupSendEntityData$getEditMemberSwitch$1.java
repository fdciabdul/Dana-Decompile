package id.dana.sendmoney.data.repository.groupsend.source.split;

import android.os.Process;
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
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getEditMemberSwitch$1", f = "SplitGroupSendEntityData.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class SplitGroupSendEntityData$getEditMemberSwitch$1 extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int MyBillsEntityDataFactory = 1;
    private static int[] PlaceComponentResult = {1067964056, -449592816, 1074915714, -792766886, 1286802454, -1723352369, -1359250517, 1339480995, -1443092810, -1287056730, 1096001284, -1056499433, 1731759878, 1555659251, 1229639861, -1282272126, 74177667, -605575040};
    private static int getAuthRequestContext;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SplitGroupSendEntityData this$0;

    public static /* synthetic */ ObservableSource $r8$lambda$GpW3tlD3QUZRoQpLwDCldVKYYM8(BaseTrafficType baseTrafficType) {
        int i = MyBillsEntityDataFactory + 111;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        ObservableSource m2896invokeSuspend$lambda0 = m2896invokeSuspend$lambda0(baseTrafficType);
        int i3 = getAuthRequestContext + 65;
        MyBillsEntityDataFactory = i3 % 128;
        if (i3 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
            return m2896invokeSuspend$lambda0;
        }
        return m2896invokeSuspend$lambda0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitGroupSendEntityData$getEditMemberSwitch$1(SplitGroupSendEntityData splitGroupSendEntityData, Continuation<? super SplitGroupSendEntityData$getEditMemberSwitch$1> continuation) {
        super(2, continuation);
        this.this$0 = splitGroupSendEntityData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SplitGroupSendEntityData$getEditMemberSwitch$1 splitGroupSendEntityData$getEditMemberSwitch$1 = new SplitGroupSendEntityData$getEditMemberSwitch$1(this.this$0, continuation);
        splitGroupSendEntityData$getEditMemberSwitch$1.L$0 = obj;
        SplitGroupSendEntityData$getEditMemberSwitch$1 splitGroupSendEntityData$getEditMemberSwitch$12 = splitGroupSendEntityData$getEditMemberSwitch$1;
        int i = getAuthRequestContext + 59;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        return splitGroupSendEntityData$getEditMemberSwitch$12;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Boolean> flowCollector, Continuation<? super Unit> continuation) {
        Object invoke2;
        int i = MyBillsEntityDataFactory + 95;
        getAuthRequestContext = i % 128;
        if (!(i % 2 == 0)) {
            invoke2 = invoke2(flowCollector, continuation);
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            try {
                invoke2 = invoke2(flowCollector, continuation);
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = getAuthRequestContext + 45;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        return invoke2;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super Boolean> flowCollector, Continuation<? super Unit> continuation) {
        try {
            int i = getAuthRequestContext + 79;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            try {
                Object invokeSuspend = ((SplitGroupSendEntityData$getEditMemberSwitch$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
                int i3 = getAuthRequestContext + 97;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return invokeSuspend;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SplitFacade splitFacade;
        int i = getAuthRequestContext + 57;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if ((i3 != 0 ? 'A' : (char) 11) != 'A') {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            splitFacade = this.this$0.getAuthRequestContext;
            Object blockingFirst = splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getEditMemberSwitch$1$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj2) {
                    return SplitGroupSendEntityData$getEditMemberSwitch$1.$r8$lambda$GpW3tlD3QUZRoQpLwDCldVKYYM8((BaseTrafficType) obj2);
                }
            }).blockingFirst();
            Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
            this.label = 1;
            if (!(flowCollector.emit(blockingFirst, this) != coroutine_suspended)) {
                int i4 = getAuthRequestContext + 99;
                MyBillsEntityDataFactory = i4 % 128;
                if (i4 % 2 == 0) {
                    int i5 = 22 / 0;
                }
                return coroutine_suspended;
            }
        } else {
            int i6 = MyBillsEntityDataFactory + 37;
            getAuthRequestContext = i6 % 128;
            int i7 = i6 % 2;
            if ((i3 == 1 ? '\b' : '?') != '\b') {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    private static final ObservableSource m2896invokeSuspend$lambda0(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullExpressionValue(baseTrafficType, "");
        Object[] objArr = new Object[1];
        a(28 - (Process.myTid() >> 22), new int[]{1522027959, -1476273373, -1029763717, -936714561, -200220155, -1687684038, 2104752367, -2017488320, 960135338, -1060442680, -809474010, 734273223, -1849214677, -1048458586}, objArr);
        final String intern = ((String) objArr[0]).intern();
        final Boolean bool = Boolean.FALSE;
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getEditMemberSwitch$1$invokeSuspend$lambda-0$$inlined$getConfigOnceReady$default$1
            final /* synthetic */ boolean $getAuthRequestContext = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory2 = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = bool;
                final boolean z = this.$getAuthRequestContext;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory2.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory, Boolean.class, obj, new ToggleCallback<T>() { // from class: id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getEditMemberSwitch$1$invokeSuspend$lambda-0$$inlined$getConfigOnceReady$default$1.1
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
        int i = MyBillsEntityDataFactory + 57;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        return observable;
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int i2;
        int length;
        int[] iArr2;
        int i3;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        int i4 = 2;
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr3 = PlaceComponentResult;
        if ((iArr3 != null ? '5' : '^') == '5') {
            int length2 = iArr3.length;
            int[] iArr4 = new int[length2];
            for (int i5 = 0; i5 < length2; i5++) {
                iArr4[i5] = (int) (iArr3[i5] ^ (-3152031022165484798L));
            }
            int i6 = $10 + 99;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            iArr3 = iArr4;
        }
        int length3 = iArr3.length;
        int[] iArr5 = new int[length3];
        int[] iArr6 = PlaceComponentResult;
        if (iArr6 != null) {
            int i8 = $10 + 77;
            $11 = i8 % 128;
            if (i8 % 2 != 0) {
                length = iArr6.length;
                iArr2 = new int[length];
            } else {
                length = iArr6.length;
                iArr2 = new int[length];
            }
            int i9 = 0;
            while (i9 < length) {
                int i10 = $11 + 65;
                $10 = i10 % 128;
                if (i10 % i4 != 0) {
                    i3 = length3;
                    iArr2[i9] = (int) (iArr6[i9] - (-3152031022165484798L));
                    i9 /= 0;
                } else {
                    i3 = length3;
                    iArr2[i9] = (int) (iArr6[i9] ^ (-3152031022165484798L));
                    i9++;
                }
                length3 = i3;
                i4 = 2;
            }
            iArr6 = iArr2;
            i2 = length3;
        } else {
            i2 = length3;
        }
        System.arraycopy(iArr6, 0, iArr5, 0, i2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        int i11 = $10 + 31;
        $11 = i11 % 128;
        int i12 = i11 % 2;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            try {
                cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr5);
                for (int i13 = 0; i13 < 16; i13++) {
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr5[i13];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    int i14 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i14;
                }
                int i15 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i15;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr5[16];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr5[17];
                int i16 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                int i17 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr5);
                cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
            } catch (Exception e) {
                throw e;
            }
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
