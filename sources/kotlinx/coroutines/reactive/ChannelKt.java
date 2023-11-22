package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.reactivestreams.Publisher;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a/\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"T", "Lorg/reactivestreams/Publisher;", "Lkotlin/Function1;", "", "action", "collect", "(Lorg/reactivestreams/Publisher;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "request", "Lkotlinx/coroutines/channels/ReceiveChannel;", "toChannel", "(Lorg/reactivestreams/Publisher;I)Lkotlinx/coroutines/channels/ReceiveChannel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ChannelKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070 A[Catch: all -> 0x0087, TRY_LEAVE, TryCatch #1 {all -> 0x0087, blocks: (B:26:0x0068, B:28:0x0070), top: B:45:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0064 -> B:14:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object collect(org.reactivestreams.Publisher<T> r6, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.reactive.ChannelKt$collect$1
            if (r0 == 0) goto L14
            r0 = r8
            kotlinx.coroutines.reactive.ChannelKt$collect$1 r0 = (kotlinx.coroutines.reactive.ChannelKt$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 + r2
            r0.label = r8
            goto L19
        L14:
            kotlinx.coroutines.reactive.ChannelKt$collect$1 r0 = new kotlinx.coroutines.reactive.ChannelKt$collect$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 != r4) goto L3e
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L3c
            r5 = r0
            r0 = r7
            r7 = r2
        L39:
            r2 = r1
            r1 = r5
            goto L68
        L3c:
            r6 = move-exception
            goto L91
        L3e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L46:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = 0
            kotlinx.coroutines.channels.ReceiveChannel r6 = toChannel$default(r6, r8, r4, r3)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch: java.lang.Throwable -> L8d
            r5 = r8
            r8 = r6
            r6 = r5
        L55:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L8a
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L8a
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L8a
            r0.label = r4     // Catch: java.lang.Throwable -> L8a
            java.lang.Object r2 = r6.hasNext(r0)     // Catch: java.lang.Throwable -> L8a
            if (r2 != r1) goto L64
            return r1
        L64:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L39
        L68:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L87
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L87
            if (r8 == 0) goto L7b
            java.lang.Object r8 = r6.next()     // Catch: java.lang.Throwable -> L87
            r7.invoke(r8)     // Catch: java.lang.Throwable -> L87
            r8 = r0
            r0 = r1
            r1 = r2
            goto L55
        L7b:
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r0, r3)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L87:
            r6 = move-exception
            r7 = r0
            goto L91
        L8a:
            r6 = move-exception
            r7 = r8
            goto L91
        L8d:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L91:
            throw r6     // Catch: java.lang.Throwable -> L92
        L92:
            r8 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r6)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            goto L9e
        L9d:
            throw r8
        L9e:
            goto L9d
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.ChannelKt.collect(org.reactivestreams.Publisher, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ ReceiveChannel toChannel$default(Publisher publisher, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return toChannel(publisher, i);
    }

    public static final <T> ReceiveChannel<T> toChannel(Publisher<T> publisher, int i) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel(i);
        publisher.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }
}
