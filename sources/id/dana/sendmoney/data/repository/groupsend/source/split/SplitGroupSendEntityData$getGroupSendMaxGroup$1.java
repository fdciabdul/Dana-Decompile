package id.dana.sendmoney.data.repository.groupsend.source.split;

import android.text.TextUtils;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import kotlinx.coroutines.flow.FlowCollector;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendMaxGroup$1", f = "SplitGroupSendEntityData.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class SplitGroupSendEntityData$getGroupSendMaxGroup$1 extends SuspendLambda implements Function2<FlowCollector<? super Integer>, Continuation<? super Unit>, Object> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int[] KClassImpl$Data$declaredNonStaticMembers$2 = {751342255, -773094378, -571709653, -257932209, -378991269, -1842235608, -1270875507, 467610028, -1022293505, -383301388, 374479538, -920419471, -2012106206, -702523275, 1206219993, -420138527, -381407960, 1237835078};
    private static int PlaceComponentResult = 0;
    private static int getAuthRequestContext = 1;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SplitGroupSendEntityData this$0;

    /* renamed from: $r8$lambda$m-8msolc6iki43oj5jbC0QslIv0  reason: not valid java name */
    public static /* synthetic */ ObservableSource m2897$r8$lambda$m8msolc6iki43oj5jbC0QslIv0(BaseTrafficType baseTrafficType) {
        ObservableSource m2898invokeSuspend$lambda0;
        int i = PlaceComponentResult + 21;
        getAuthRequestContext = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? 'a' : ']') != 'a') {
            m2898invokeSuspend$lambda0 = m2898invokeSuspend$lambda0(baseTrafficType);
        } else {
            try {
                m2898invokeSuspend$lambda0 = m2898invokeSuspend$lambda0(baseTrafficType);
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = PlaceComponentResult + 87;
        getAuthRequestContext = i2 % 128;
        if (!(i2 % 2 == 0)) {
            return m2898invokeSuspend$lambda0;
        }
        int length2 = objArr.length;
        return m2898invokeSuspend$lambda0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitGroupSendEntityData$getGroupSendMaxGroup$1(SplitGroupSendEntityData splitGroupSendEntityData, Continuation<? super SplitGroupSendEntityData$getGroupSendMaxGroup$1> continuation) {
        super(2, continuation);
        this.this$0 = splitGroupSendEntityData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SplitGroupSendEntityData$getGroupSendMaxGroup$1 splitGroupSendEntityData$getGroupSendMaxGroup$1 = new SplitGroupSendEntityData$getGroupSendMaxGroup$1(this.this$0, continuation);
        splitGroupSendEntityData$getGroupSendMaxGroup$1.L$0 = obj;
        SplitGroupSendEntityData$getGroupSendMaxGroup$1 splitGroupSendEntityData$getGroupSendMaxGroup$12 = splitGroupSendEntityData$getGroupSendMaxGroup$1;
        int i = PlaceComponentResult + 121;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        return splitGroupSendEntityData$getGroupSendMaxGroup$12;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Integer> flowCollector, Continuation<? super Unit> continuation) {
        int i = getAuthRequestContext + 107;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Object invoke2 = invoke2(flowCollector, continuation);
        int i3 = getAuthRequestContext + 79;
        PlaceComponentResult = i3 % 128;
        if (i3 % 2 == 0) {
            return invoke2;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return invoke2;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super Integer> flowCollector, Continuation<? super Unit> continuation) {
        int i = PlaceComponentResult + 65;
        getAuthRequestContext = i % 128;
        char c = i % 2 == 0 ? 'B' : Typography.quote;
        Object invokeSuspend = ((SplitGroupSendEntityData$getGroupSendMaxGroup$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        if (c == 'B') {
            int i2 = 98 / 0;
        }
        try {
            int i3 = getAuthRequestContext + 105;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return invokeSuspend;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    private static final ObservableSource m2898invokeSuspend$lambda0(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullExpressionValue(baseTrafficType, "");
        GroupSendDefaultConfigGenerator groupSendDefaultConfigGenerator = GroupSendDefaultConfigGenerator.INSTANCE;
        Object[] objArr = new Object[1];
        a(TextUtils.indexOf("", "", 0) + 20, new int[]{631595974, 235774133, -1957953530, 1845998012, 712195467, 569295970, -1371113499, -581346312, -904306371, -2109689922}, objArr);
        final String intern = ((String) objArr[0]).intern();
        final int i = 10;
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendMaxGroup$1$invokeSuspend$lambda-0$$inlined$getConfigOnceReady$default$1
            final /* synthetic */ boolean $PlaceComponentResult = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = i;
                final boolean z = this.$PlaceComponentResult;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory, Integer.class, obj, new ToggleCallback<T>() { // from class: id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendMaxGroup$1$invokeSuspend$lambda-0$$inlined$getConfigOnceReady$default$1.1
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
        int i2 = getAuthRequestContext + 51;
        PlaceComponentResult = i2 % 128;
        if (!(i2 % 2 == 0)) {
            int i3 = 85 / 0;
            return observable;
        }
        return observable;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        if ((r3 != 0 ? ';' : '*') != ';') goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        if (r3 != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        if (r3 != 1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        kotlin.ResultKt.throwOnFailure(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        kotlin.ResultKt.throwOnFailure(r7);
        r7 = (kotlinx.coroutines.flow.FlowCollector) r6.L$0;
        r3 = r6.this$0.getAuthRequestContext;
        r3 = r3.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendMaxGroup$1$$ExternalSyntheticLambda0()).blockingFirst();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "");
        r6.label = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
    
        if (r7.emit(r3, r6) != r0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006a, code lost:
    
        r7 = '(';
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
    
        r7 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006e, code lost:
    
        if (r7 == 5) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0070, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            int r0 = id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendMaxGroup$1.getAuthRequestContext
            int r0 = r0 + 17
            int r1 = r0 % 128
            id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendMaxGroup$1.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L25
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch: java.lang.Exception -> L23
            int r3 = r6.label     // Catch: java.lang.Exception -> L23
            int r4 = r1.length     // Catch: java.lang.Throwable -> L21
            r4 = 59
            if (r3 == 0) goto L1c
            r5 = 59
            goto L1e
        L1c:
            r5 = 42
        L1e:
            if (r5 == r4) goto L2d
            goto L3b
        L21:
            r7 = move-exception
            throw r7
        L23:
            r7 = move-exception
            throw r7
        L25:
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r6.label
            if (r3 == 0) goto L3b
        L2d:
            if (r3 != r2) goto L33
            kotlin.ResultKt.throwOnFailure(r7)
            goto L71
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3b:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData r3 = r6.this$0
            id.dana.data.toggle.SplitFacade r3 = id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData.KClassImpl$Data$declaredNonStaticMembers$2(r3)
            io.reactivex.Observable r3 = r3.KClassImpl$Data$declaredNonStaticMembers$2()
            id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendMaxGroup$1$$ExternalSyntheticLambda0 r4 = new id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendMaxGroup$1$$ExternalSyntheticLambda0
            r4.<init>()
            io.reactivex.Observable r3 = r3.flatMap(r4)
            java.lang.Object r3 = r3.blockingFirst()
            java.lang.String r4 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6.label = r2
            java.lang.Object r7 = r7.emit(r3, r4)
            r3 = 5
            if (r7 != r0) goto L6d
            r7 = 40
            goto L6e
        L6d:
            r7 = 5
        L6e:
            if (r7 == r3) goto L71
            return r0
        L71:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L89
            int r0 = id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendMaxGroup$1.getAuthRequestContext
            int r0 = r0 + 101
            int r3 = r0 % 128
            id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendMaxGroup$1.PlaceComponentResult = r3
            int r0 = r0 % 2
            if (r0 == 0) goto L81
            r0 = 0
            goto L82
        L81:
            r0 = 1
        L82:
            if (r0 == r2) goto L88
            int r0 = r1.length     // Catch: java.lang.Throwable -> L86
            return r7
        L86:
            r7 = move-exception
            throw r7
        L88:
            return r7
        L89:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendMaxGroup$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int i2;
        int i3;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        int i4 = 2;
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            for (int i5 = 0; i5 < length; i5++) {
                int i6 = $10 + 95;
                $11 = i6 % 128;
                if (!(i6 % 2 == 0)) {
                    iArr3[i5] = (int) (iArr2[i5] ^ (-3152031022165484798L));
                } else {
                    try {
                        iArr3[i5] = (int) (iArr2[i5] ^ (-3152031022165484798L));
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        try {
            int[] iArr5 = KClassImpl$Data$declaredNonStaticMembers$2;
            if ((iArr5 != null ? 'V' : '3') != '3') {
                int length3 = iArr5.length;
                int[] iArr6 = new int[length3];
                int i7 = $10 + 17;
                $11 = i7 % 128;
                int i8 = i7 % 2;
                int i9 = 0;
                while (true) {
                    if (!(i9 < length3)) {
                        break;
                    }
                    int i10 = $10 + 47;
                    $11 = i10 % 128;
                    if (i10 % i4 == 0) {
                        i3 = length2;
                        iArr6[i9] = (int) (iArr5[i9] % (-3152031022165484798L));
                        i9 >>= 1;
                    } else {
                        i3 = length2;
                        iArr6[i9] = (int) (iArr5[i9] ^ (-3152031022165484798L));
                        i9++;
                    }
                    length2 = i3;
                    i4 = 2;
                }
                int i11 = $11 + 51;
                $10 = i11 % 128;
                int i12 = i11 % 2;
                iArr5 = iArr6;
                i2 = length2;
            } else {
                i2 = length2;
            }
            int i13 = 0;
            System.arraycopy(iArr5, 0, iArr4, 0, i2);
            while (true) {
                verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = i13;
                if ((verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length ? (char) 24 : '8') != 24) {
                    objArr[0] = new String(cArr2, 0, i);
                    return;
                }
                cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                for (int i14 = 0; i14 < 16; i14++) {
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i14];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    int i15 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i15;
                }
                int i16 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i16;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
                int i17 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                int i18 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                i13 = verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 2;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
