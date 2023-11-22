package id.dana.sendmoney.data.repository.groupsend.source.split;

import android.graphics.Color;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.JSONLexer;
import id.dana.data.toggle.constant.ConfigType;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.exception.UnexpectedTreatment;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.lib.toggle.ToggleCallback;
import id.dana.lib.toggle.ToggleManager;
import id.dana.sendmoney.data.config.groupsend.model.GroupSendScenarioConfigEntity;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "Lid/dana/sendmoney/data/config/groupsend/model/GroupSendScenarioConfigEntity;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1", f = "SplitGroupSendEntityData.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class SplitGroupSendEntityData$getGroupSendScenarios$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends GroupSendScenarioConfigEntity>>, Continuation<? super Unit>, Object> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int MyBillsEntityDataFactory;
    private static int[] PlaceComponentResult = {1692310917, 1816783461, 1706791158, -1410284594, 439470819, -296214296, -2078675135, 659773958, 953746584, -2009620110, -857808388, 130934278, -1090854543, -851034967, 136792621, 1852194633, 519853411, -1478261342};
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SplitGroupSendEntityData this$0;

    /* renamed from: $r8$lambda$6zQXdZP09mHYyJf-WCynGgUzGIQ  reason: not valid java name */
    public static /* synthetic */ ObservableSource m2900$r8$lambda$6zQXdZP09mHYyJfWCynGgUzGIQ(BaseTrafficType baseTrafficType) {
        int i = BuiltInFictitiousFunctionClassFactory + 107;
        MyBillsEntityDataFactory = i % 128;
        char c = i % 2 != 0 ? 'V' : '1';
        ObservableSource m2901invokeSuspend$lambda2 = m2901invokeSuspend$lambda2(baseTrafficType);
        if (c == 'V') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = MyBillsEntityDataFactory + 11;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        if ((i2 % 2 == 0 ? '9' : (char) 21) != '9') {
            return m2901invokeSuspend$lambda2;
        }
        int i3 = 20 / 0;
        return m2901invokeSuspend$lambda2;
    }

    public static /* synthetic */ List $r8$lambda$l0h4tXiHLVOsgZcslhIuU44eKZM(List list) {
        try {
            int i = MyBillsEntityDataFactory + 97;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            List m2902invokeSuspend$lambda2$lambda1 = m2902invokeSuspend$lambda2$lambda1(list);
            int i3 = BuiltInFictitiousFunctionClassFactory + 37;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return m2902invokeSuspend$lambda2$lambda1;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitGroupSendEntityData$getGroupSendScenarios$1(SplitGroupSendEntityData splitGroupSendEntityData, Continuation<? super SplitGroupSendEntityData$getGroupSendScenarios$1> continuation) {
        super(2, continuation);
        try {
            this.this$0 = splitGroupSendEntityData;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SplitGroupSendEntityData$getGroupSendScenarios$1 splitGroupSendEntityData$getGroupSendScenarios$1 = new SplitGroupSendEntityData$getGroupSendScenarios$1(this.this$0, continuation);
        splitGroupSendEntityData$getGroupSendScenarios$1.L$0 = obj;
        SplitGroupSendEntityData$getGroupSendScenarios$1 splitGroupSendEntityData$getGroupSendScenarios$12 = splitGroupSendEntityData$getGroupSendScenarios$1;
        int i = MyBillsEntityDataFactory + 75;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? '@' : JSONLexer.EOI) != 26) {
            int i2 = 49 / 0;
            return splitGroupSendEntityData$getGroupSendScenarios$12;
        }
        return splitGroupSendEntityData$getGroupSendScenarios$12;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends GroupSendScenarioConfigEntity>> flowCollector, Continuation<? super Unit> continuation) {
        int i = BuiltInFictitiousFunctionClassFactory + 85;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        Object invoke2 = invoke2((FlowCollector<? super List<GroupSendScenarioConfigEntity>>) flowCollector, continuation);
        int i3 = MyBillsEntityDataFactory + 55;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 22 : 'a') != 22) {
            return invoke2;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return invoke2;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super List<GroupSendScenarioConfigEntity>> flowCollector, Continuation<? super Unit> continuation) {
        int i = BuiltInFictitiousFunctionClassFactory + 53;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        Object invokeSuspend = ((SplitGroupSendEntityData$getGroupSendScenarios$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        int i3 = BuiltInFictitiousFunctionClassFactory + 105;
        MyBillsEntityDataFactory = i3 % 128;
        if ((i3 % 2 != 0 ? '[' : (char) 18) != '[') {
            return invokeSuspend;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return invokeSuspend;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        if (r4 != 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        r0 = id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1.MyBillsEntityDataFactory + 35;
        id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1.BuiltInFictitiousFunctionClassFactory = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        if ((r0 % 2) != 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003a, code lost:
    
        if (r4 != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
    
        if (r4 != 1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        kotlin.ResultKt.throwOnFailure(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
    
        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        kotlin.ResultKt.throwOnFailure(r7);
        r7 = (kotlinx.coroutines.flow.FlowCollector) r6.L$0;
        r1 = r6.this$0.getAuthRequestContext;
        r1 = r1.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1$$ExternalSyntheticLambda0()).blockingFirst();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "");
        r6.label = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
    
        if (r7.emit(r1, r6) != r0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007b, code lost:
    
        r7 = '\r';
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007e, code lost:
    
        r7 = 'N';
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0080, code lost:
    
        if (r7 == '\r') goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0089, code lost:
    
        r7 = id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1.MyBillsEntityDataFactory + 57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008c, code lost:
    
        id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1.BuiltInFictitiousFunctionClassFactory = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0090, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0092, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0093, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
    
        if ((r4 != 0 ? '9' : '#') != '9') goto L24;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            int r0 = id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 87
            int r1 = r0 % 128
            id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 35
            r2 = 1
            r3 = 57
            if (r0 == 0) goto L27
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r6.label
            r5 = 0
            r5.hashCode()     // Catch: java.lang.Throwable -> L25
            if (r4 == 0) goto L20
            r5 = 57
            goto L22
        L20:
            r5 = 35
        L22:
            if (r5 == r3) goto L2f
            goto L4b
        L25:
            r7 = move-exception
            throw r7
        L27:
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r6.label
            if (r4 == 0) goto L4b
        L2f:
            int r0 = id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1.MyBillsEntityDataFactory
            int r0 = r0 + r1
            int r1 = r0 % 128
            id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L3d
            if (r4 != 0) goto L43
            goto L3f
        L3d:
            if (r4 != r2) goto L43
        L3f:
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L85
            goto L82
        L43:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L4b:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData r1 = r6.this$0
            id.dana.data.toggle.SplitFacade r1 = id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData.KClassImpl$Data$declaredNonStaticMembers$2(r1)
            io.reactivex.Observable r1 = r1.KClassImpl$Data$declaredNonStaticMembers$2()
            id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1$$ExternalSyntheticLambda0 r4 = new id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1$$ExternalSyntheticLambda0
            r4.<init>()
            io.reactivex.Observable r1 = r1.flatMap(r4)
            java.lang.Object r1 = r1.blockingFirst()
            java.lang.String r4 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6.label = r2
            java.lang.Object r7 = r7.emit(r1, r4)
            r1 = 13
            if (r7 != r0) goto L7e
            r7 = 13
            goto L80
        L7e:
            r7 = 78
        L80:
            if (r7 == r1) goto L87
        L82:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L85
            return r7
        L85:
            r7 = move-exception
            goto L91
        L87:
            int r7 = id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L92
            int r7 = r7 + r3
            int r1 = r7 % 128
            id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1.BuiltInFictitiousFunctionClassFactory = r1     // Catch: java.lang.Exception -> L85
            int r7 = r7 % 2
            return r0
        L91:
            throw r7
        L92:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* renamed from: invokeSuspend$lambda-2  reason: not valid java name */
    private static final ObservableSource m2901invokeSuspend$lambda2(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullExpressionValue(baseTrafficType, "");
        GroupSendDefaultConfigGenerator groupSendDefaultConfigGenerator = GroupSendDefaultConfigGenerator.INSTANCE;
        final List<JSONObject> KClassImpl$Data$declaredNonStaticMembers$2 = GroupSendDefaultConfigGenerator.KClassImpl$Data$declaredNonStaticMembers$2();
        Object[] objArr = new Object[1];
        a(Color.blue(0) + 20, new int[]{1322219112, 2025194488, -485856533, 1586903842, -1412232717, 102553069, 804302090, 1302984761, -1622612483, -541763947}, objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1$invokeSuspend$lambda-2$$inlined$getConfigOnceReady$default$1
            final /* synthetic */ boolean $MyBillsEntityDataFactory = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory2 = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = KClassImpl$Data$declaredNonStaticMembers$2;
                final boolean z = this.$MyBillsEntityDataFactory;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory2.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, List.class, obj, new ToggleCallback<T>() { // from class: id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1$invokeSuspend$lambda-2$$inlined$getConfigOnceReady$default$1.1
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
        Observable map = create.map(new Function() { // from class: id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitGroupSendEntityData$getGroupSendScenarios$1.$r8$lambda$l0h4tXiHLVOsgZcslhIuU44eKZM((List) obj);
            }
        });
        int i = MyBillsEntityDataFactory + 79;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        return map;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:25:0x007b
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    /* renamed from: invokeSuspend$lambda-2$lambda-1  reason: not valid java name */
    private static final java.util.List m2902invokeSuspend$lambda2$lambda1(java.util.List r4) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)     // Catch: java.lang.Exception -> L79
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch: java.lang.Exception -> L79
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Exception -> L79
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r1)     // Catch: java.lang.Exception -> L79
            r0.<init>(r1)     // Catch: java.lang.Exception -> L79
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Exception -> L79
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Exception -> L79
            int r1 = id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1.BuiltInFictitiousFunctionClassFactory
            int r1 = r1 + 107
            int r2 = r1 % 128
            id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1.MyBillsEntityDataFactory = r2
            int r1 = r1 % 2
        L22:
            boolean r1 = r4.hasNext()
            r2 = 50
            if (r1 == 0) goto L2d
            r1 = 50
            goto L2f
        L2d:
            r1 = 63
        L2f:
            if (r1 == r2) goto L34
            java.util.List r0 = (java.util.List) r0
            return r0
        L34:
            int r1 = id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1.BuiltInFictitiousFunctionClassFactory
            int r1 = r1 + 71
            int r3 = r1 % 128
            id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1.MyBillsEntityDataFactory = r3
            int r1 = r1 % 2
            if (r1 == 0) goto L43
            r1 = 67
            goto L45
        L43:
            r1 = 50
        L45:
            if (r1 == r2) goto L63
            java.lang.Object r1 = r4.next()
            com.alibaba.fastjson.JSONObject r1 = (com.alibaba.fastjson.JSONObject) r1
            java.lang.String r1 = r1.toJSONString()
            java.lang.Class<id.dana.sendmoney.data.config.groupsend.model.GroupSendScenarioConfigEntity> r2 = id.dana.sendmoney.data.config.groupsend.model.GroupSendScenarioConfigEntity.class
            java.lang.Object r1 = com.alibaba.fastjson.JSONObject.parseObject(r1, r2)
            id.dana.sendmoney.data.config.groupsend.model.GroupSendScenarioConfigEntity r1 = (id.dana.sendmoney.data.config.groupsend.model.GroupSendScenarioConfigEntity) r1
            r0.add(r1)
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L61
            goto L22
        L61:
            r4 = move-exception
            throw r4
        L63:
            java.lang.Object r1 = r4.next()
            com.alibaba.fastjson.JSONObject r1 = (com.alibaba.fastjson.JSONObject) r1
            java.lang.String r1 = r1.toJSONString()
            java.lang.Class<id.dana.sendmoney.data.config.groupsend.model.GroupSendScenarioConfigEntity> r2 = id.dana.sendmoney.data.config.groupsend.model.GroupSendScenarioConfigEntity.class
            java.lang.Object r1 = com.alibaba.fastjson.JSONObject.parseObject(r1, r2)
            id.dana.sendmoney.data.config.groupsend.model.GroupSendScenarioConfigEntity r1 = (id.dana.sendmoney.data.config.groupsend.model.GroupSendScenarioConfigEntity) r1
            r0.add(r1)
            goto L22
        L79:
            r4 = move-exception
            throw r4
        L7b:
            r4 = move-exception
            goto L7e
        L7d:
            throw r4
        L7e:
            goto L7d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.groupsend.source.split.SplitGroupSendEntityData$getGroupSendScenarios$1.m2902invokeSuspend$lambda2$lambda1(java.util.List):java.util.List");
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int i2;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        int i3 = 2;
        char[] cArr2 = new char[iArr.length * 2];
        try {
            int[] iArr2 = PlaceComponentResult;
            if (iArr2 != null) {
                int length = iArr2.length;
                int[] iArr3 = new int[length];
                int i4 = 0;
                while (true) {
                    if (!(i4 < length)) {
                        break;
                    }
                    int i5 = $10 + 71;
                    $11 = i5 % 128;
                    int i6 = i5 % 2;
                    iArr3[i4] = (int) (iArr2[i4] ^ (-3152031022165484798L));
                    i4++;
                }
                iArr2 = iArr3;
            }
            int length2 = iArr2.length;
            int[] iArr4 = new int[length2];
            int[] iArr5 = PlaceComponentResult;
            if (iArr5 != null) {
                int length3 = iArr5.length;
                int[] iArr6 = new int[length3];
                int i7 = 0;
                while (i7 < length3) {
                    int i8 = $10 + 31;
                    $11 = i8 % 128;
                    int i9 = i8 % i3;
                    iArr6[i7] = (int) (iArr5[i7] ^ (-3152031022165484798L));
                    i7++;
                    length2 = length2;
                    i3 = 2;
                }
                iArr5 = iArr6;
                i2 = length2;
            } else {
                i2 = length2;
            }
            System.arraycopy(iArr5, 0, iArr4, 0, i2);
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
            while (true) {
                if (!(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length)) {
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
                int i10 = 0;
                while (true) {
                    if (i10 >= 16) {
                        break;
                    }
                    int i11 = $11 + 33;
                    $10 = i11 % 128;
                    int i12 = i11 % 2;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i10];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    int i13 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i13;
                    i10++;
                }
                int i14 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i14;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
                int i15 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                int i16 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
