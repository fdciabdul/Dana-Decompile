package androidx.window.layout;

import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/window/layout/WindowLayoutInfo;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", i = {0, 0, 1, 1}, l = {54, 55}, m = "invokeSuspend", n = {"$this$flow", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "$this$flow", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes6.dex */
final class WindowInfoTrackerImpl$windowLayoutInfo$1 extends SuspendLambda implements Function2<FlowCollector<? super WindowLayoutInfo>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ WindowInfoTrackerImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowInfoTrackerImpl$windowLayoutInfo$1(WindowInfoTrackerImpl windowInfoTrackerImpl, Activity activity, Continuation<? super WindowInfoTrackerImpl$windowLayoutInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = windowInfoTrackerImpl;
        this.$activity = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WindowInfoTrackerImpl$windowLayoutInfo$1 windowInfoTrackerImpl$windowLayoutInfo$1 = new WindowInfoTrackerImpl$windowLayoutInfo$1(this.this$0, this.$activity, continuation);
        windowInfoTrackerImpl$windowLayoutInfo$1.L$0 = obj;
        return windowInfoTrackerImpl$windowLayoutInfo$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super WindowLayoutInfo> flowCollector, Continuation<? super Unit> continuation) {
        return ((WindowInfoTrackerImpl$windowLayoutInfo$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007e A[Catch: all -> 0x00a2, TRY_LEAVE, TryCatch #0 {all -> 0x00a2, blocks: (B:17:0x0064, B:20:0x0076, B:22:0x007e), top: B:34:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0096  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0093 -> B:34:0x0064). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L38
            if (r1 == r3) goto L26
            if (r1 != r2) goto L1e
            java.lang.Object r1 = r8.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r8.L$1
            androidx.core.util.Consumer r4 = (androidx.core.util.Consumer) r4
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> La4
            goto L63
        L1e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L26:
            java.lang.Object r1 = r8.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r8.L$1
            androidx.core.util.Consumer r4 = (androidx.core.util.Consumer) r4
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> La4
            r6 = r9
            r9 = r8
            goto L76
        L38:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            r5 = r9
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            kotlinx.coroutines.channels.BufferOverflow r9 = kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST
            r1 = 10
            r4 = 4
            r6 = 0
            kotlinx.coroutines.channels.Channel r9 = kotlinx.coroutines.channels.ChannelKt.Channel$default(r1, r9, r6, r4, r6)
            androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1$$ExternalSyntheticLambda0 r4 = new androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1$$ExternalSyntheticLambda0
            r4.<init>()
            androidx.window.layout.WindowInfoTrackerImpl r1 = r8.this$0
            androidx.window.layout.WindowBackend r1 = androidx.window.layout.WindowInfoTrackerImpl.MyBillsEntityDataFactory(r1)
            android.app.Activity r6 = r8.$activity
            androidx.credentials.CredentialManager$$ExternalSyntheticLambda0 r7 = new androidx.credentials.CredentialManager$$ExternalSyntheticLambda0
            r7.<init>()
            r1.BuiltInFictitiousFunctionClassFactory(r6, r7, r4)
            kotlinx.coroutines.channels.ChannelIterator r1 = r9.iterator()     // Catch: java.lang.Throwable -> La4
        L63:
            r9 = r8
        L64:
            r6 = r9
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Throwable -> La2
            r9.L$0 = r5     // Catch: java.lang.Throwable -> La2
            r9.L$1 = r4     // Catch: java.lang.Throwable -> La2
            r9.L$2 = r1     // Catch: java.lang.Throwable -> La2
            r9.label = r3     // Catch: java.lang.Throwable -> La2
            java.lang.Object r6 = r1.hasNext(r6)     // Catch: java.lang.Throwable -> La2
            if (r6 != r0) goto L76
            return r0
        L76:
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch: java.lang.Throwable -> La2
            boolean r6 = r6.booleanValue()     // Catch: java.lang.Throwable -> La2
            if (r6 == 0) goto L96
            java.lang.Object r6 = r1.next()     // Catch: java.lang.Throwable -> La2
            androidx.window.layout.WindowLayoutInfo r6 = (androidx.window.layout.WindowLayoutInfo) r6     // Catch: java.lang.Throwable -> La2
            r7 = r9
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch: java.lang.Throwable -> La2
            r9.L$0 = r5     // Catch: java.lang.Throwable -> La2
            r9.L$1 = r4     // Catch: java.lang.Throwable -> La2
            r9.L$2 = r1     // Catch: java.lang.Throwable -> La2
            r9.label = r2     // Catch: java.lang.Throwable -> La2
            java.lang.Object r6 = r5.emit(r6, r7)     // Catch: java.lang.Throwable -> La2
            if (r6 != r0) goto L64
            return r0
        L96:
            androidx.window.layout.WindowInfoTrackerImpl r9 = r9.this$0
            androidx.window.layout.WindowBackend r9 = androidx.window.layout.WindowInfoTrackerImpl.MyBillsEntityDataFactory(r9)
            r9.KClassImpl$Data$declaredNonStaticMembers$2(r4)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        La2:
            r0 = move-exception
            goto La7
        La4:
            r9 = move-exception
            r0 = r9
            r9 = r8
        La7:
            androidx.window.layout.WindowInfoTrackerImpl r9 = r9.this$0
            androidx.window.layout.WindowBackend r9 = androidx.window.layout.WindowInfoTrackerImpl.MyBillsEntityDataFactory(r9)
            r9.KClassImpl$Data$declaredNonStaticMembers$2(r4)
            goto Lb2
        Lb1:
            throw r0
        Lb2:
            goto Lb1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m46invokeSuspend$lambda0(Channel channel, WindowLayoutInfo windowLayoutInfo) {
        Intrinsics.checkNotNullExpressionValue(windowLayoutInfo, "");
        channel.mo42trySendJP2dKIU(windowLayoutInfo);
    }
}
