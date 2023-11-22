package id.dana.network.base;

import android.content.Context;
import com.alipay.mobile.common.rpc.RpcException;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.network.rpc.RpcConnector;
import id.dana.network.util.ReflectHelper;
import id.dana.utils.holdlogin.v2.interceptor.HoldLoginV2Processing;
import id.dana.utils.retry.RetryHelper;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b \u0010!J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H$¢\u0006\u0004\b\u0004\u0010\u0005J3\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n\"\b\b\u0001\u0010\u0007*\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bH\u0004¢\u0006\u0004\b\u000b\u0010\fJC\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n\"\b\b\u0001\u0010\u0007*\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0003H\u0004¢\u0006\u0004\b\u000b\u0010\u000eJQ\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n\"\b\b\u0001\u0010\u0007*\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0003H\u0004¢\u0006\u0004\b\u000b\u0010\u0012R\u0014\u0010\u0015\u001a\u00028\u00008EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u001b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/network/base/BaseNetworkFlow;", "T", "", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "S", "Lkotlin/Function1;", "facadeProcessor", "Lkotlinx/coroutines/flow/Flow;", "wrapper", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "outputType", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Class;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/network/base/ExceptionParserFlow;", "exceptionParser", "processFacade", "(Lid/dana/network/base/ExceptionParserFlow;Lkotlin/jvm/functions/Function1;Ljava/lang/Class;)Lkotlinx/coroutines/flow/Flow;", "getCastedFacade", "()Ljava/lang/Object;", "castedFacade", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/network/rpc/RpcConnector;", "getRpcConnector", "()Lid/dana/network/rpc/RpcConnector;", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseNetworkFlow<T> {
    private final Context context;
    private final RpcConnector rpcConnector;

    protected abstract Class<T> getFacadeClass();

    public BaseNetworkFlow(Context context, RpcConnector rpcConnector) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        this.context = context;
        this.rpcConnector = rpcConnector;
    }

    @JvmName(name = "getContext")
    public final Context getContext() {
        return this.context;
    }

    @JvmName(name = "getRpcConnector")
    public final RpcConnector getRpcConnector() {
        return this.rpcConnector;
    }

    @JvmName(name = "getCastedFacade")
    public final T getCastedFacade() {
        return (T) this.rpcConnector.getFacade(getFacadeClass());
    }

    public final <S extends BaseRpcResult> Flow<S> wrapper(Function1<? super T, ? extends S> facadeProcessor) {
        Intrinsics.checkNotNullParameter(facadeProcessor, "");
        return wrapper(new ExceptionParserFlow<>(), facadeProcessor, null);
    }

    protected final <S extends BaseRpcResult> Flow<S> wrapper(Function1<? super T, ? extends S> facadeProcessor, Class<S> outputType) {
        Intrinsics.checkNotNullParameter(facadeProcessor, "");
        return wrapper(new ExceptionParserFlow<>(), facadeProcessor, outputType);
    }

    protected final <S extends BaseRpcResult> Flow<S> wrapper(final ExceptionParserFlow<S> exceptionParser, final Function1<? super T, ? extends S> processFacade, Class<S> outputType) {
        Intrinsics.checkNotNullParameter(exceptionParser, "");
        Intrinsics.checkNotNullParameter(processFacade, "");
        final String operationType = ReflectHelper.INSTANCE.getOperationType(getFacadeClass());
        exceptionParser.setContext(this.context);
        exceptionParser.setOperationType(operationType);
        RetryHelper retryHelper = RetryHelper.INSTANCE;
        final Flow PlaceComponentResult = RetryHelper.PlaceComponentResult(operationType, new Function0<S>() { // from class: id.dana.network.base.BaseNetworkFlow$wrapper$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TS; */
            @Override // kotlin.jvm.functions.Function0
            public final BaseRpcResult invoke() {
                return (BaseRpcResult) processFacade.invoke(this.getCastedFacade());
            }
        }, new Function0<Observable<Boolean>>() { // from class: id.dana.network.base.BaseNetworkFlow$wrapper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Observable<Boolean> invoke() {
                return HoldLoginV2Processing.getAuthRequestContext(operationType);
            }
        }, new Function1<Throwable, Boolean>(this) { // from class: id.dana.network.base.BaseNetworkFlow$wrapper$3
            final /* synthetic */ BaseNetworkFlow<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Throwable th) {
                boolean z;
                Intrinsics.checkNotNullParameter(th, "");
                boolean z2 = false;
                if (this.this$0.getRpcConnector().isHoldLoginV2Enable() && ((z = th instanceof RpcException))) {
                    RpcException rpcException = z ? (RpcException) th : null;
                    if ((rpcException != null && rpcException.getCode() == 2000) && this.this$0.getRpcConnector().hasSession()) {
                        z2 = true;
                    }
                }
                return Boolean.valueOf(z2);
            }
        }, this.rpcConnector.getHoldLoginConfig().lookAheadTest, new Function4<String, String, String, Throwable, Unit>() { // from class: id.dana.network.base.BaseNetworkFlow$wrapper$4
            @Override // kotlin.jvm.functions.Function4
            public final /* bridge */ /* synthetic */ Unit invoke(String str, String str2, String str3, Throwable th) {
                invoke2(str, str2, str3, th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str, String str2, String str3, Throwable th) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
                Intrinsics.checkNotNullParameter(str3, "");
                Intrinsics.checkNotNullParameter(th, "");
                Crashlytics.Companion companion = Crashlytics.INSTANCE;
                Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
                Intrinsics.checkNotNullParameter(str, "");
                authRequestContext.getAuthRequestContext.log(str);
                Intrinsics.checkNotNullParameter(str2, "");
                authRequestContext.getAuthRequestContext.log(str2);
                Intrinsics.checkNotNullParameter(str3, "");
                authRequestContext.getAuthRequestContext.log(str3);
                Intrinsics.checkNotNullParameter(th, "");
                authRequestContext.getAuthRequestContext.recordException(th);
            }
        });
        return FlowKt.m4649catch(new Flow<S>() { // from class: id.dana.network.base.BaseNetworkFlow$wrapper$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, exceptionParser), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.network.base.BaseNetworkFlow$wrapper$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ ExceptionParserFlow $$exceptionParser$inlined;
                final /* synthetic */ FlowCollector $$this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.network.base.BaseNetworkFlow$wrapper$$inlined$map$1$2", f = "BaseNetworkFlow.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.network.base.BaseNetworkFlow$wrapper$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, ExceptionParserFlow exceptionParserFlow) {
                    this.$$this_unsafeFlow = flowCollector;
                    this.$$exceptionParser$inlined = exceptionParserFlow;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof id.dana.network.base.BaseNetworkFlow$wrapper$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.network.base.BaseNetworkFlow$wrapper$$inlined$map$1$2$1 r0 = (id.dana.network.base.BaseNetworkFlow$wrapper$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.network.base.BaseNetworkFlow$wrapper$$inlined$map$1$2$1 r0 = new id.dana.network.base.BaseNetworkFlow$wrapper$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4b
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$$this_unsafeFlow
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        com.alipayplus.mobile.component.domain.model.result.BaseRpcResult r5 = (com.alipayplus.mobile.component.domain.model.result.BaseRpcResult) r5
                        id.dana.network.base.ExceptionParserFlow r2 = r4.$$exceptionParser$inlined
                        com.alipayplus.mobile.component.domain.model.result.BaseRpcResult r5 = r2.apply(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4b
                        return r1
                    L4b:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.network.base.BaseNetworkFlow$wrapper$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        }, new BaseNetworkFlow$wrapper$6(outputType, null));
    }
}
