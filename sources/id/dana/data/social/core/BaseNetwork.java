package id.dana.data.social.core;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.network.base.ExceptionParserSuspend;
import id.dana.network.rpc.RpcConnector;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H$¢\u0006\u0004\b\u0004\u0010\u0005J1\u0010\n\u001a\u00028\u0001\"\b\b\u0001\u0010\u0007*\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bH\u0084@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ?\u0010\n\u001a\u00028\u0001\"\b\b\u0001\u0010\u0007*\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bH\u0084@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000fR\u0014\u0010\u0012\u001a\u00028\u00008EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u00188\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/data/social/core/BaseNetwork;", "T", "", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "S", "Lkotlin/Function1;", "facadeProcessor", "wrapper", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/network/base/ExceptionParserSuspend;", "exceptionParser", "processFacade", "(Lid/dana/network/base/ExceptionParserSuspend;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCastedFacade", "()Ljava/lang/Object;", "castedFacade", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/network/rpc/RpcConnector;", "getRpcConnector", "()Lid/dana/network/rpc/RpcConnector;", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseNetwork<T> {
    private final Context context;
    private final RpcConnector rpcConnector;

    protected abstract Class<T> getFacadeClass();

    public BaseNetwork(Context context, RpcConnector rpcConnector) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final <S extends BaseRpcResult> Object wrapper(Function1<? super T, ? extends S> function1, Continuation<? super S> continuation) {
        return wrapper(new ExceptionParserSuspend<>(), function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6 A[PHI: r2
      0x00a6: PHI (r2v7 java.lang.Object) = (r2v6 java.lang.Object), (r2v1 java.lang.Object) binds: [B:20:0x00a3, B:12:0x0030] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <S extends com.alipayplus.mobile.component.domain.model.result.BaseRpcResult> java.lang.Object wrapper(id.dana.network.base.ExceptionParserSuspend<S> r17, kotlin.jvm.functions.Function1<? super T, ? extends S> r18, kotlin.coroutines.Continuation<? super S> r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r19
            boolean r3 = r2 instanceof id.dana.data.social.core.BaseNetwork$wrapper$2
            if (r3 == 0) goto L1a
            r3 = r2
            id.dana.data.social.core.BaseNetwork$wrapper$2 r3 = (id.dana.data.social.core.BaseNetwork$wrapper$2) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L1a
            int r2 = r3.label
            int r2 = r2 + r5
            r3.label = r2
            goto L1f
        L1a:
            id.dana.data.social.core.BaseNetwork$wrapper$2 r3 = new id.dana.data.social.core.BaseNetwork$wrapper$2
            r3.<init>(r0, r2)
        L1f:
            java.lang.Object r2 = r3.result
            java.lang.Object r14 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r3.label
            r15 = 2
            r5 = 1
            r13 = 0
            if (r4 == 0) goto L47
            if (r4 == r5) goto L3d
            if (r4 != r15) goto L35
            kotlin.ResultKt.throwOnFailure(r2)
            goto La6
        L35:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3d:
            java.lang.Object r1 = r3.L$0
            id.dana.network.base.ExceptionParserSuspend r1 = (id.dana.network.base.ExceptionParserSuspend) r1
            kotlin.ResultKt.throwOnFailure(r2)
            r4 = r2
            r2 = r13
            goto L99
        L47:
            kotlin.ResultKt.throwOnFailure(r2)
            java.lang.Class r2 = r16.getFacadeClass()
            java.lang.String r2 = id.dana.utils.rpc.quake.ReflectHelper.PlaceComponentResult(r2)
            android.content.Context r4 = r0.context
            r1.setContext(r4)
            r1.setOperationType(r2)
            id.dana.utils.retry.RetryHelper r4 = id.dana.utils.retry.RetryHelper.INSTANCE
            id.dana.network.rpc.RpcConnector r6 = r0.rpcConnector
            id.dana.utils.holdlogin.v2.model.FeatureHoldLoginConfig r6 = r6.getHoldLoginConfig()
            java.lang.Long r10 = r6.lookAheadTest
            java.lang.String r6 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$1 r6 = new id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$1
            r7 = r18
            r6.<init>(r7, r0, r13)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$2 r7 = new id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$2
            r7.<init>()
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$3 r8 = new id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$3
            r8.<init>(r0)
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$4 r9 = new kotlin.jvm.functions.Function2<java.lang.Throwable, java.lang.String, kotlin.Unit>() { // from class: id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$4
                static {
                    /*
                        id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$4 r0 = new id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$4
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$4) id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$4.INSTANCE id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$4
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$4.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 2
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$4.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function2
                public final /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Throwable r1, java.lang.String r2) {
                    /*
                        r0 = this;
                        java.lang.Throwable r1 = (java.lang.Throwable) r1
                        java.lang.String r2 = (java.lang.String) r2
                        r0.invoke2(r1, r2)
                        kotlin.Unit r1 = kotlin.Unit.INSTANCE
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$4.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(java.lang.Throwable r5, java.lang.String r6) {
                    /*
                        r4 = this;
                        java.lang.String r0 = ""
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                        id.dana.analytics.firebase.Crashlytics$Companion r1 = id.dana.analytics.firebase.Crashlytics.INSTANCE
                        id.dana.analytics.firebase.Crashlytics r1 = id.dana.analytics.firebase.Crashlytics.Companion.getAuthRequestContext()
                        java.lang.String r2 = "case"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                        com.google.firebase.crashlytics.FirebaseCrashlytics r3 = r1.getAuthRequestContext
                        r3.setCustomKey(r2, r6)
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                        com.google.firebase.crashlytics.FirebaseCrashlytics r6 = r1.getAuthRequestContext
                        r6.recordException(r5)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$4.invoke2(java.lang.Throwable, java.lang.String):void");
                }
            }
            r11 = r9
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$5 r9 = new kotlin.jvm.functions.Function4<java.lang.String, java.lang.String, java.lang.String, java.lang.Throwable, kotlin.Unit>() { // from class: id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$5
                static {
                    /*
                        id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$5 r0 = new id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$5
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$5) id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$5.INSTANCE id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$5
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$5.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 4
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$5.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function4
                public final /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.String r1, java.lang.String r2, java.lang.String r3, java.lang.Throwable r4) {
                    /*
                        r0 = this;
                        java.lang.String r1 = (java.lang.String) r1
                        java.lang.String r2 = (java.lang.String) r2
                        java.lang.String r3 = (java.lang.String) r3
                        java.lang.Throwable r4 = (java.lang.Throwable) r4
                        r0.invoke2(r1, r2, r3, r4)
                        kotlin.Unit r1 = kotlin.Unit.INSTANCE
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$5.invoke(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.Throwable r7) {
                    /*
                        r3 = this;
                        java.lang.String r0 = ""
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                        id.dana.analytics.firebase.Crashlytics$Companion r1 = id.dana.analytics.firebase.Crashlytics.INSTANCE
                        id.dana.analytics.firebase.Crashlytics r1 = id.dana.analytics.firebase.Crashlytics.Companion.getAuthRequestContext()
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                        com.google.firebase.crashlytics.FirebaseCrashlytics r2 = r1.getAuthRequestContext
                        r2.log(r4)
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                        com.google.firebase.crashlytics.FirebaseCrashlytics r4 = r1.getAuthRequestContext
                        r4.log(r5)
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                        com.google.firebase.crashlytics.FirebaseCrashlytics r4 = r1.getAuthRequestContext
                        r4.log(r6)
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                        com.google.firebase.crashlytics.FirebaseCrashlytics r4 = r1.getAuthRequestContext
                        r4.recordException(r7)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$5.invoke2(java.lang.String, java.lang.String, java.lang.String, java.lang.Throwable):void");
                }
            }
            r12 = r9
            kotlin.jvm.functions.Function4 r12 = (kotlin.jvm.functions.Function4) r12
            r3.L$0 = r1
            r3.label = r5
            r9 = 1
            r5 = r2
            r2 = r13
            r13 = r3
            java.lang.Object r4 = r4.PlaceComponentResult(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            if (r4 != r14) goto L99
            return r14
        L99:
            com.alipayplus.mobile.component.domain.model.result.BaseRpcResult r4 = (com.alipayplus.mobile.component.domain.model.result.BaseRpcResult) r4
            r3.L$0 = r2
            r3.label = r15
            java.lang.Object r2 = r1.apply(r4, r3)
            if (r2 != r14) goto La6
            return r14
        La6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.social.core.BaseNetwork.wrapper(id.dana.network.base.ExceptionParserSuspend, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
