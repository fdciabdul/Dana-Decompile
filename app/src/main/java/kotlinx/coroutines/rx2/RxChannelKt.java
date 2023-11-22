package kotlinx.coroutines.rx2;

import io.reactivex.MaybeSource;
import io.reactivex.ObservableSource;
import kotlin.Metadata;
import kotlinx.coroutines.channels.ReceiveChannel;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a7\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\b\u001a%\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0000¢\u0006\u0004\b\n\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"T", "Lio/reactivex/MaybeSource;", "Lkotlin/Function1;", "", "action", "collect", "(Lio/reactivex/MaybeSource;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/reactivex/ObservableSource;", "(Lio/reactivex/ObservableSource;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "toChannel", "(Lio/reactivex/MaybeSource;)Lkotlinx/coroutines/channels/ReceiveChannel;", "(Lio/reactivex/ObservableSource;)Lkotlinx/coroutines/channels/ReceiveChannel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class RxChannelKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e A[Catch: all -> 0x0086, TRY_LEAVE, TryCatch #1 {all -> 0x0086, blocks: (B:26:0x0066, B:28:0x006e), top: B:45:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0062 -> B:14:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object collect(io.reactivex.MaybeSource<T> r5, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.rx2.RxChannelKt$collect$1
            if (r0 == 0) goto L14
            r0 = r7
            kotlinx.coroutines.rx2.RxChannelKt$collect$1 r0 = (kotlinx.coroutines.rx2.RxChannelKt$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            kotlinx.coroutines.rx2.RxChannelKt$collect$1 r0 = new kotlinx.coroutines.rx2.RxChannelKt$collect$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L45
            if (r2 != r3) goto L3d
            java.lang.Object r5 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L3b
            r4 = r0
            r0 = r6
            r6 = r2
        L38:
            r2 = r1
            r1 = r4
            goto L66
        L3b:
            r5 = move-exception
            goto L90
        L3d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L45:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.channels.ReceiveChannel r5 = toChannel(r5)
            kotlinx.coroutines.channels.ChannelIterator r7 = r5.iterator()     // Catch: java.lang.Throwable -> L8c
            r4 = r7
            r7 = r5
            r5 = r4
        L53:
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L89
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L89
            r0.L$2 = r5     // Catch: java.lang.Throwable -> L89
            r0.label = r3     // Catch: java.lang.Throwable -> L89
            java.lang.Object r2 = r5.hasNext(r0)     // Catch: java.lang.Throwable -> L89
            if (r2 != r1) goto L62
            return r1
        L62:
            r4 = r0
            r0 = r7
            r7 = r2
            goto L38
        L66:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L86
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L86
            if (r7 == 0) goto L79
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Throwable -> L86
            r6.invoke(r7)     // Catch: java.lang.Throwable -> L86
            r7 = r0
            r0 = r1
            r1 = r2
            goto L53
        L79:
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            r5 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r0, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L86:
            r5 = move-exception
            r6 = r0
            goto L90
        L89:
            r5 = move-exception
            r6 = r7
            goto L90
        L8c:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L90:
            throw r5     // Catch: java.lang.Throwable -> L91
        L91:
            r7 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            goto L9d
        L9c:
            throw r7
        L9d:
            goto L9c
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxChannelKt.collect(io.reactivex.MaybeSource, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e A[Catch: all -> 0x0086, TRY_LEAVE, TryCatch #1 {all -> 0x0086, blocks: (B:26:0x0066, B:28:0x006e), top: B:45:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0062 -> B:14:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object collect(io.reactivex.ObservableSource<T> r5, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.rx2.RxChannelKt$collect$2
            if (r0 == 0) goto L14
            r0 = r7
            kotlinx.coroutines.rx2.RxChannelKt$collect$2 r0 = (kotlinx.coroutines.rx2.RxChannelKt$collect$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            kotlinx.coroutines.rx2.RxChannelKt$collect$2 r0 = new kotlinx.coroutines.rx2.RxChannelKt$collect$2
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L45
            if (r2 != r3) goto L3d
            java.lang.Object r5 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L3b
            r4 = r0
            r0 = r6
            r6 = r2
        L38:
            r2 = r1
            r1 = r4
            goto L66
        L3b:
            r5 = move-exception
            goto L90
        L3d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L45:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.channels.ReceiveChannel r5 = toChannel(r5)
            kotlinx.coroutines.channels.ChannelIterator r7 = r5.iterator()     // Catch: java.lang.Throwable -> L8c
            r4 = r7
            r7 = r5
            r5 = r4
        L53:
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L89
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L89
            r0.L$2 = r5     // Catch: java.lang.Throwable -> L89
            r0.label = r3     // Catch: java.lang.Throwable -> L89
            java.lang.Object r2 = r5.hasNext(r0)     // Catch: java.lang.Throwable -> L89
            if (r2 != r1) goto L62
            return r1
        L62:
            r4 = r0
            r0 = r7
            r7 = r2
            goto L38
        L66:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L86
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L86
            if (r7 == 0) goto L79
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Throwable -> L86
            r6.invoke(r7)     // Catch: java.lang.Throwable -> L86
            r7 = r0
            r0 = r1
            r1 = r2
            goto L53
        L79:
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            r5 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r0, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L86:
            r5 = move-exception
            r6 = r0
            goto L90
        L89:
            r5 = move-exception
            r6 = r7
            goto L90
        L8c:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L90:
            throw r5     // Catch: java.lang.Throwable -> L91
        L91:
            r7 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            goto L9d
        L9c:
            throw r7
        L9d:
            goto L9c
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxChannelKt.collect(io.reactivex.ObservableSource, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final <T> ReceiveChannel<T> toChannel(MaybeSource<T> maybeSource) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel();
        maybeSource.PlaceComponentResult(subscriptionChannel);
        return subscriptionChannel;
    }

    public static final <T> ReceiveChannel<T> toChannel(ObservableSource<T> observableSource) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel();
        observableSource.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }
}
