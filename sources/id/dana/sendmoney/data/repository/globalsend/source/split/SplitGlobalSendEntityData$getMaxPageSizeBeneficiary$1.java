package id.dana.sendmoney.data.repository.globalsend.source.split;

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
import kotlinx.coroutines.flow.FlowCollector;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.data.repository.globalsend.source.split.SplitGlobalSendEntityData$getMaxPageSizeBeneficiary$1", f = "SplitGlobalSendEntityData.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class SplitGlobalSendEntityData$getMaxPageSizeBeneficiary$1 extends SuspendLambda implements Function2<FlowCollector<? super Integer>, Continuation<? super Unit>, Object> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static char[] MyBillsEntityDataFactory = {35505, 35579, 35572, 35573, 35573, 35568, 35565, 35565, 35570, 35575, 35575, 35583, 35576, 35568, 35568, 35575, 35569, 35570, 35581, 35575, 35571, 35574, 35583, 35576, 35579, 35575, 35565, 35575, 35577, 35566, 35570, 35579, 35573};
    private static int PlaceComponentResult;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SplitGlobalSendEntityData this$0;

    public static /* synthetic */ ObservableSource $r8$lambda$VWeE01MfyeBdDukyj787CvDaKAw(BaseTrafficType baseTrafficType) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 45;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            ObservableSource m2895invokeSuspend$lambda0 = m2895invokeSuspend$lambda0(baseTrafficType);
            int i3 = BuiltInFictitiousFunctionClassFactory + 55;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return m2895invokeSuspend$lambda0;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitGlobalSendEntityData$getMaxPageSizeBeneficiary$1(SplitGlobalSendEntityData splitGlobalSendEntityData, Continuation<? super SplitGlobalSendEntityData$getMaxPageSizeBeneficiary$1> continuation) {
        super(2, continuation);
        this.this$0 = splitGlobalSendEntityData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        try {
            SplitGlobalSendEntityData$getMaxPageSizeBeneficiary$1 splitGlobalSendEntityData$getMaxPageSizeBeneficiary$1 = new SplitGlobalSendEntityData$getMaxPageSizeBeneficiary$1(this.this$0, continuation);
            splitGlobalSendEntityData$getMaxPageSizeBeneficiary$1.L$0 = obj;
            SplitGlobalSendEntityData$getMaxPageSizeBeneficiary$1 splitGlobalSendEntityData$getMaxPageSizeBeneficiary$12 = splitGlobalSendEntityData$getMaxPageSizeBeneficiary$1;
            int i = PlaceComponentResult + 51;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            return splitGlobalSendEntityData$getMaxPageSizeBeneficiary$12;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Integer> flowCollector, Continuation<? super Unit> continuation) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 43;
            PlaceComponentResult = i % 128;
            char c = i % 2 == 0 ? 'C' : '+';
            Object invoke2 = invoke2(flowCollector, continuation);
            if (c != 'C') {
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = PlaceComponentResult + 121;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            if (!(i2 % 2 != 0)) {
                int i3 = 62 / 0;
                return invoke2;
            }
            return invoke2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super Integer> flowCollector, Continuation<? super Unit> continuation) {
        int i = BuiltInFictitiousFunctionClassFactory + 117;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Object invokeSuspend = ((SplitGlobalSendEntityData$getMaxPageSizeBeneficiary$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        int i3 = PlaceComponentResult + 107;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if ((i3 % 2 == 0 ? 'N' : '(') != 'N') {
            return invokeSuspend;
        }
        Object obj = null;
        obj.hashCode();
        return invokeSuspend;
    }

    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    private static final ObservableSource m2895invokeSuspend$lambda0(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullExpressionValue(baseTrafficType, "");
        GlobalSendDefaultConfigGenerator globalSendDefaultConfigGenerator = GlobalSendDefaultConfigGenerator.INSTANCE;
        Object[] objArr = new Object[1];
        a(new int[]{0, 33, 0, 7}, false, new byte[]{1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1}, objArr);
        final String intern = ((String) objArr[0]).intern();
        final int i = 10;
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.sendmoney.data.repository.globalsend.source.split.SplitGlobalSendEntityData$getMaxPageSizeBeneficiary$1$invokeSuspend$lambda-0$$inlined$getConfigOnceReady$default$1
            final /* synthetic */ boolean $getAuthRequestContext = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory2 = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = i;
                final boolean z = this.$getAuthRequestContext;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory2.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, Integer.class, obj, new ToggleCallback<T>() { // from class: id.dana.sendmoney.data.repository.globalsend.source.split.SplitGlobalSendEntityData$getMaxPageSizeBeneficiary$1$invokeSuspend$lambda-0$$inlined$getConfigOnceReady$default$1.1
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
        int i2 = PlaceComponentResult + 89;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        if ((i2 % 2 == 0 ? '%' : 'V') != '%') {
            return observable;
        }
        Object obj = null;
        obj.hashCode();
        return observable;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        if ((r2 != 0 ? 'b' : 'U') != 'b') goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        if ((r2 != 0 ? 'T' : '*') != '*') goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
    
        if (r2 != 1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
    
        kotlin.ResultKt.throwOnFailure(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
    
        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
    
        kotlin.ResultKt.throwOnFailure(r6);
        r6 = (kotlinx.coroutines.flow.FlowCollector) r5.L$0;
        r2 = r5.this$0.BuiltInFictitiousFunctionClassFactory;
        r2 = r2.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new id.dana.sendmoney.data.repository.globalsend.source.split.SplitGlobalSendEntityData$getMaxPageSizeBeneficiary$1$$ExternalSyntheticLambda0()).blockingFirst();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "");
        r5.label = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
    
        if (r6.emit(r2, r5) != r0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0074, code lost:
    
        r6 = '_';
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0077, code lost:
    
        r6 = '%';
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0079, code lost:
    
        if (r6 == '_') goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007e, code lost:
    
        r6 = id.dana.sendmoney.data.repository.globalsend.source.split.SplitGlobalSendEntityData$getMaxPageSizeBeneficiary$1.PlaceComponentResult + 105;
        id.dana.sendmoney.data.repository.globalsend.source.split.SplitGlobalSendEntityData$getMaxPageSizeBeneficiary$1.BuiltInFictitiousFunctionClassFactory = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0088, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            int r0 = id.dana.sendmoney.data.repository.globalsend.source.split.SplitGlobalSendEntityData$getMaxPageSizeBeneficiary$1.PlaceComponentResult
            int r0 = r0 + 89
            int r1 = r0 % 128
            id.dana.sendmoney.data.repository.globalsend.source.split.SplitGlobalSendEntityData$getMaxPageSizeBeneficiary$1.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 1
            if (r0 != 0) goto L25
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r5.label
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L23
            r3 = 98
            if (r2 == 0) goto L1e
            r4 = 98
            goto L20
        L1e:
            r4 = 85
        L20:
            if (r4 == r3) goto L36
            goto L44
        L23:
            r6 = move-exception
            throw r6
        L25:
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch: java.lang.Exception -> L89
            int r2 = r5.label     // Catch: java.lang.Exception -> L89
            r3 = 42
            if (r2 == 0) goto L32
            r4 = 84
            goto L34
        L32:
            r4 = 42
        L34:
            if (r4 == r3) goto L44
        L36:
            if (r2 != r1) goto L3c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L7b
        L3c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L44:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.Object r6 = r5.L$0
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            id.dana.sendmoney.data.repository.globalsend.source.split.SplitGlobalSendEntityData r2 = r5.this$0
            id.dana.data.toggle.SplitFacade r2 = id.dana.sendmoney.data.repository.globalsend.source.split.SplitGlobalSendEntityData.MyBillsEntityDataFactory(r2)
            io.reactivex.Observable r2 = r2.KClassImpl$Data$declaredNonStaticMembers$2()
            id.dana.sendmoney.data.repository.globalsend.source.split.SplitGlobalSendEntityData$getMaxPageSizeBeneficiary$1$$ExternalSyntheticLambda0 r3 = new id.dana.sendmoney.data.repository.globalsend.source.split.SplitGlobalSendEntityData$getMaxPageSizeBeneficiary$1$$ExternalSyntheticLambda0
            r3.<init>()
            io.reactivex.Observable r2 = r2.flatMap(r3)
            java.lang.Object r2 = r2.blockingFirst()
            java.lang.String r3 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r5.label = r1
            java.lang.Object r6 = r6.emit(r2, r3)
            r1 = 95
            if (r6 != r0) goto L77
            r6 = 95
            goto L79
        L77:
            r6 = 37
        L79:
            if (r6 == r1) goto L7e
        L7b:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L7e:
            int r6 = id.dana.sendmoney.data.repository.globalsend.source.split.SplitGlobalSendEntityData$getMaxPageSizeBeneficiary$1.PlaceComponentResult
            int r6 = r6 + 105
            int r1 = r6 % 128
            id.dana.sendmoney.data.repository.globalsend.source.split.SplitGlobalSendEntityData$getMaxPageSizeBeneficiary$1.BuiltInFictitiousFunctionClassFactory = r1
            int r6 = r6 % 2
            return r0
        L89:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.globalsend.source.split.SplitGlobalSendEntityData$getMaxPageSizeBeneficiary$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        char[] cArr = MyBillsEntityDataFactory;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i5 = 0;
            while (true) {
                if (!(i5 < length)) {
                    break;
                }
                cArr2[i5] = (char) (cArr[i5] ^ 5097613533456403102L);
                i5++;
                int i6 = $11 + 63;
                $10 = i6 % 128;
                int i7 = i6 % 2;
            }
            cArr = cArr2;
        }
        char[] cArr3 = new char[i2];
        System.arraycopy(cArr, i, cArr3, 0, i2);
        if (bArr != null) {
            char[] cArr4 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            char c = 0;
            while (true) {
                if (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory >= i2) {
                    break;
                }
                try {
                    int i8 = $11 + 5;
                    $10 = i8 % 128;
                    int i9 = i8 % 2;
                    if ((bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1 ? '`' : (char) 21) == '`') {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                    } else {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                    }
                    c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                } catch (Exception e) {
                    throw e;
                }
            }
            cArr3 = cArr4;
        }
        if (i4 > 0) {
            char[] cArr5 = new char[i2];
            System.arraycopy(cArr3, 0, cArr5, 0, i2);
            int i10 = i2 - i4;
            System.arraycopy(cArr5, 0, cArr3, i10, i4);
            System.arraycopy(cArr5, i4, cArr3, 0, i10);
            int i11 = $10 + 111;
            $11 = i11 % 128;
            int i12 = i11 % 2;
        }
        if (z) {
            char[] cArr6 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr6;
        }
        if (!(i3 <= 0)) {
            int i13 = $10 + 37;
            $11 = i13 % 128;
            int i14 = i13 % 2;
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
        }
        objArr[0] = new String(cArr3);
    }
}
