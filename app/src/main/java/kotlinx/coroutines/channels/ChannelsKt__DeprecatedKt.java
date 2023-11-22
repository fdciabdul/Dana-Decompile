package kotlinx.coroutines.channels;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a#\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0004\u001a+\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0007\u001a\u00020\u0005H\u0087@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0007\u001a\u00020\u0005H\u0087@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\t\u001aC\u0010\u000f\u001a\u00028\u0001\"\b\b\u0000\u0010\u0000*\u00020\u000b\"\u0010\b\u0001\u0010\r*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\f*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00012\u0006\u0010\u000e\u001a\u00028\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aA\u0010\u000f\u001a\u00028\u0001\"\b\b\u0000\u0010\u0000*\u00020\u000b\"\u000e\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u0011*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00012\u0006\u0010\u000e\u001a\u00028\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0012\u001a#\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0004\u001a%\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0004\u001a+\u0010\u0016\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0015\u001a\u00028\u0000H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a#\u0010\u0018\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0004\u001a+\u0010\u0019\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0015\u001a\u00028\u0000H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0017\u001a%\u0010\u001a\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0004\u001aA\u0010\u001e\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u001d\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u001bj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u001cH\u0087@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001aA\u0010 \u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u001d\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u001bj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u001cH\u0087@ø\u0001\u0000¢\u0006\u0004\b \u0010\u001f\u001a#\u0010!\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0004\u001a#\u0010\"\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0004\u001a%\u0010#\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b#\u0010\u0004\u001a;\u0010$\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u0011*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000e\u001a\u00028\u0001H\u0080@ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0012\u001a=\u0010%\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u0010\r*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000e\u001a\u00028\u0001H\u0080@ø\u0001\u0000¢\u0006\u0004\b%\u0010\u0010\u001aW\u0010+\u001a\u00028\u0002\"\u0004\b\u0000\u0010&\"\u0004\b\u0001\u0010'\"\u0018\b\u0002\u0010)*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010(*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*0\u00012\u0006\u0010\u000e\u001a\u00028\u0002H\u0080@ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"E", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "any", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "count", "index", "elementAt", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elementAtOrNull", "", "", "C", FirebaseAnalytics.Param.DESTINATION, "filterNotNullTo", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "first", "firstOrNull", LottieParams.KEY_ELEMENT_ID, "indexOf", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "last", "lastIndexOf", "lastOrNull", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "maxWith", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Comparator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "minWith", "none", "single", "singleOrNull", "toChannel", "toCollection", DiskFormatter.KB, "V", "", DiskFormatter.MB, "Lkotlin/Pair;", "toMap", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
/* loaded from: classes3.dex */
public final /* synthetic */ class ChannelsKt__DeprecatedKt {
    /* JADX WARN: Removed duplicated region for block: B:62:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x006c A[Catch: all -> 0x0092, TRY_LEAVE, TryCatch #0 {all -> 0x0092, blocks: (B:77:0x0064, B:79:0x006c, B:84:0x007a, B:85:0x0091), top: B:97:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x007a A[Catch: all -> 0x0092, TRY_ENTER, TryCatch #0 {all -> 0x0092, blocks: (B:77:0x0064, B:79:0x006c, B:84:0x007a, B:85:0x0091), top: B:97:0x0064 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0061 -> B:97:0x0064). Please submit an issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object elementAt(kotlinx.coroutines.channels.ReceiveChannel r8, int r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1
            if (r0 == 0) goto L14
            r0 = r10
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 + r2
            r0.label = r10
            goto L19
        L14:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 46
            java.lang.String r4 = "ReceiveChannel doesn't contain element at index "
            r5 = 1
            if (r2 == 0) goto L49
            if (r2 != r5) goto L41
            int r8 = r0.I$1
            int r9 = r0.I$0
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L3e
            r7 = r10
            r10 = r8
            r8 = r6
            r6 = r7
            goto L64
        L3e:
            r8 = move-exception
            goto Lb3
        L41:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L49:
            kotlin.ResultKt.throwOnFailure(r10)
            if (r9 < 0) goto L96
            r10 = 0
            kotlinx.coroutines.channels.ChannelIterator r2 = r8.iterator()     // Catch: java.lang.Throwable -> Lae
        L53:
            r0.L$0 = r8     // Catch: java.lang.Throwable -> Lae
            r0.L$1 = r2     // Catch: java.lang.Throwable -> Lae
            r0.I$0 = r9     // Catch: java.lang.Throwable -> Lae
            r0.I$1 = r10     // Catch: java.lang.Throwable -> Lae
            r0.label = r5     // Catch: java.lang.Throwable -> Lae
            java.lang.Object r6 = r2.hasNext(r0)     // Catch: java.lang.Throwable -> Lae
            if (r6 != r1) goto L64
            return r1
        L64:
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch: java.lang.Throwable -> L92
            boolean r6 = r6.booleanValue()     // Catch: java.lang.Throwable -> L92
            if (r6 == 0) goto L7a
            java.lang.Object r6 = r2.next()     // Catch: java.lang.Throwable -> L92
            if (r9 != r10) goto L77
            r9 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r8, r9)
            return r6
        L77:
            int r10 = r10 + 1
            goto L53
        L7a:
            java.lang.IndexOutOfBoundsException r10 = new java.lang.IndexOutOfBoundsException     // Catch: java.lang.Throwable -> L92
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L92
            r0.<init>()     // Catch: java.lang.Throwable -> L92
            r0.append(r4)     // Catch: java.lang.Throwable -> L92
            r0.append(r9)     // Catch: java.lang.Throwable -> L92
            r0.append(r3)     // Catch: java.lang.Throwable -> L92
            java.lang.String r9 = r0.toString()     // Catch: java.lang.Throwable -> L92
            r10.<init>(r9)     // Catch: java.lang.Throwable -> L92
            throw r10     // Catch: java.lang.Throwable -> L92
        L92:
            r9 = move-exception
            r6 = r8
            r8 = r9
            goto Lb3
        L96:
            java.lang.IndexOutOfBoundsException r10 = new java.lang.IndexOutOfBoundsException     // Catch: java.lang.Throwable -> Lae
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lae
            r0.<init>()     // Catch: java.lang.Throwable -> Lae
            r0.append(r4)     // Catch: java.lang.Throwable -> Lae
            r0.append(r9)     // Catch: java.lang.Throwable -> Lae
            r0.append(r3)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r9 = r0.toString()     // Catch: java.lang.Throwable -> Lae
            r10.<init>(r9)     // Catch: java.lang.Throwable -> Lae
            throw r10     // Catch: java.lang.Throwable -> Lae
        Lae:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            r6 = r9
        Lb3:
            throw r8     // Catch: java.lang.Throwable -> Lb4
        Lb4:
            r9 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r8)
            goto Lba
        Lb9:
            throw r9
        Lba:
            goto Lb9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.elementAt(kotlinx.coroutines.channels.ReceiveChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x006c A[Catch: all -> 0x007d, TRY_LEAVE, TryCatch #2 {all -> 0x007d, blocks: (B:76:0x0064, B:78:0x006c, B:73:0x0053, B:72:0x004f), top: B:96:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0079  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0061 -> B:76:0x0064). Please submit an issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object elementAtOrNull(kotlinx.coroutines.channels.ReceiveChannel r7, int r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1
            if (r0 == 0) goto L14
            r0 = r9
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 + r2
            r0.label = r9
            goto L19
        L14:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L45
            if (r2 != r3) goto L3d
            int r7 = r0.I$1
            int r8 = r0.I$0
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L3b
            r6 = r9
            r9 = r7
            r7 = r5
            r5 = r6
            goto L64
        L3b:
            r7 = move-exception
            goto L82
        L3d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L45:
            kotlin.ResultKt.throwOnFailure(r9)
            if (r8 >= 0) goto L4e
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r4)
            return r4
        L4e:
            r9 = 0
            kotlinx.coroutines.channels.ChannelIterator r2 = r7.iterator()     // Catch: java.lang.Throwable -> L7d
        L53:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L7d
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L7d
            r0.I$0 = r8     // Catch: java.lang.Throwable -> L7d
            r0.I$1 = r9     // Catch: java.lang.Throwable -> L7d
            r0.label = r3     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r5 = r2.hasNext(r0)     // Catch: java.lang.Throwable -> L7d
            if (r5 != r1) goto L64
            return r1
        L64:
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch: java.lang.Throwable -> L7d
            boolean r5 = r5.booleanValue()     // Catch: java.lang.Throwable -> L7d
            if (r5 == 0) goto L79
            java.lang.Object r5 = r2.next()     // Catch: java.lang.Throwable -> L7d
            if (r8 != r9) goto L76
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r4)
            return r5
        L76:
            int r9 = r9 + 1
            goto L53
        L79:
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r4)
            return r4
        L7d:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
            r5 = r8
        L82:
            throw r7     // Catch: java.lang.Throwable -> L83
        L83:
            r8 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r7)
            goto L89
        L88:
            throw r8
        L89:
            goto L88
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.elementAtOrNull(kotlinx.coroutines.channels.ReceiveChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x005c A[Catch: all -> 0x006d, TRY_LEAVE, TryCatch #2 {all -> 0x006d, blocks: (B:62:0x0054, B:64:0x005c, B:67:0x0065, B:68:0x006c, B:59:0x0043), top: B:79:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0065 A[Catch: all -> 0x006d, TRY_ENTER, TryCatch #2 {all -> 0x006d, blocks: (B:62:0x0054, B:64:0x005c, B:67:0x0065, B:68:0x006c, B:59:0x0043), top: B:79:0x0043 }] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object first(kotlinx.coroutines.channels.ReceiveChannel r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1
            if (r0 == 0) goto L14
            r0 = r6
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r5 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r0 = (kotlinx.coroutines.channels.ReceiveChannel) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L36
            r4 = r6
            r6 = r5
            r5 = r0
            r0 = r4
            goto L54
        L36:
            r5 = move-exception
            goto L70
        L38:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L40:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.channels.ChannelIterator r6 = r5.iterator()     // Catch: java.lang.Throwable -> L6d
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L6d
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L6d
            r0.label = r3     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r0 = r6.hasNext(r0)     // Catch: java.lang.Throwable -> L6d
            if (r0 != r1) goto L54
            return r1
        L54:
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L6d
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L6d
            if (r0 == 0) goto L65
            java.lang.Object r6 = r6.next()     // Catch: java.lang.Throwable -> L6d
            r0 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r0)
            return r6
        L65:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException     // Catch: java.lang.Throwable -> L6d
            java.lang.String r0 = "ReceiveChannel is empty."
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L6d
            throw r6     // Catch: java.lang.Throwable -> L6d
        L6d:
            r6 = move-exception
            r0 = r5
            r5 = r6
        L70:
            throw r5     // Catch: java.lang.Throwable -> L71
        L71:
            r6 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r0, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.first(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0061 A[Catch: all -> 0x0069, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0069, blocks: (B:64:0x0054, B:69:0x0061, B:61:0x0043), top: B:80:0x0043 }] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object firstOrNull(kotlinx.coroutines.channels.ReceiveChannel r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1
            if (r0 == 0) goto L14
            r0 = r6
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r5 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r0 = (kotlinx.coroutines.channels.ReceiveChannel) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L36
            r4 = r6
            r6 = r5
            r5 = r0
            r0 = r4
            goto L54
        L36:
            r5 = move-exception
            goto L6c
        L38:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L40:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.channels.ChannelIterator r6 = r5.iterator()     // Catch: java.lang.Throwable -> L69
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L69
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L69
            r0.label = r3     // Catch: java.lang.Throwable -> L69
            java.lang.Object r0 = r6.hasNext(r0)     // Catch: java.lang.Throwable -> L69
            if (r0 != r1) goto L54
            return r1
        L54:
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L69
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L69
            r1 = 0
            if (r0 != 0) goto L61
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r1)
            return r1
        L61:
            java.lang.Object r6 = r6.next()     // Catch: java.lang.Throwable -> L69
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r1)
            return r6
        L69:
            r6 = move-exception
            r0 = r5
            r5 = r6
        L6c:
            throw r5     // Catch: java.lang.Throwable -> L6d
        L6d:
            r6 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r0, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.firstOrNull(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0070 A[Catch: all -> 0x0097, TryCatch #0 {all -> 0x0097, blocks: (B:71:0x0067, B:73:0x0070, B:75:0x007a, B:78:0x0084, B:67:0x0052, B:79:0x008c, B:66:0x004e), top: B:89:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x008c A[Catch: all -> 0x0097, TRY_LEAVE, TryCatch #0 {all -> 0x0097, blocks: (B:71:0x0067, B:73:0x0070, B:75:0x007a, B:78:0x0084, B:67:0x0052, B:79:0x008c, B:66:0x004e), top: B:89:0x004e }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0063 -> B:71:0x0067). Please submit an issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object indexOf(kotlinx.coroutines.channels.ReceiveChannel r7, java.lang.Object r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1
            if (r0 == 0) goto L14
            r0 = r9
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 + r2
            r0.label = r9
            goto L19
        L14:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L46
            if (r2 != r3) goto L3e
            java.lang.Object r7 = r0.L$3
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r8 = r0.L$2
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.internal.Ref$IntRef r2 = (kotlin.jvm.internal.Ref.IntRef) r2
            java.lang.Object r4 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L3c
            r6 = r4
            r4 = r7
            r7 = r8
            r8 = r6
            goto L67
        L3c:
            r7 = move-exception
            goto L9b
        L3e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L46:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.jvm.internal.Ref$IntRef r9 = new kotlin.jvm.internal.Ref$IntRef
            r9.<init>()
            kotlinx.coroutines.channels.ChannelIterator r2 = r7.iterator()     // Catch: java.lang.Throwable -> L97
        L52:
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L97
            r0.L$1 = r9     // Catch: java.lang.Throwable -> L97
            r0.L$2 = r7     // Catch: java.lang.Throwable -> L97
            r0.L$3 = r2     // Catch: java.lang.Throwable -> L97
            r0.label = r3     // Catch: java.lang.Throwable -> L97
            java.lang.Object r4 = r2.hasNext(r0)     // Catch: java.lang.Throwable -> L97
            if (r4 != r1) goto L63
            return r1
        L63:
            r6 = r2
            r2 = r9
            r9 = r4
            r4 = r6
        L67:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L97
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L97
            r5 = 0
            if (r9 == 0) goto L8c
            java.lang.Object r9 = r4.next()     // Catch: java.lang.Throwable -> L97
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r9)     // Catch: java.lang.Throwable -> L97
            if (r9 == 0) goto L84
            int r8 = r2.element     // Catch: java.lang.Throwable -> L97
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)     // Catch: java.lang.Throwable -> L97
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r5)
            return r8
        L84:
            int r9 = r2.element     // Catch: java.lang.Throwable -> L97
            int r9 = r9 + r3
            r2.element = r9     // Catch: java.lang.Throwable -> L97
            r9 = r2
            r2 = r4
            goto L52
        L8c:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L97
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r5)
            r7 = -1
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            return r7
        L97:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L9b:
            throw r7     // Catch: java.lang.Throwable -> L9c
        L9c:
            r9 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r8, r7)
            goto La2
        La1:
            throw r9
        La2:
            goto La1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.indexOf(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0096 A[Catch: all -> 0x00a3, TRY_LEAVE, TryCatch #0 {all -> 0x00a3, blocks: (B:101:0x008e, B:103:0x0096), top: B:121:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00a7 A[Catch: all -> 0x00af, TRY_ENTER, TryCatch #5 {all -> 0x00af, blocks: (B:94:0x006e, B:96:0x0076, B:109:0x00a7, B:110:0x00ae), top: B:131:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0076 A[Catch: all -> 0x00af, TRY_LEAVE, TryCatch #5 {all -> 0x00af, blocks: (B:94:0x006e, B:96:0x0076, B:109:0x00a7, B:110:0x00ae), top: B:131:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0088 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x0089 -> B:121:0x008e). Please submit an issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object last(kotlinx.coroutines.channels.ReceiveChannel r6, kotlin.coroutines.Continuation r7) {
        /*
            Method dump skipped, instructions count: 193
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.last(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x007d A[Catch: all -> 0x00a0, TryCatch #0 {all -> 0x00a0, blocks: (B:70:0x0075, B:72:0x007d, B:74:0x0087, B:75:0x008b, B:66:0x005e, B:76:0x0093, B:65:0x005a), top: B:86:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0093 A[Catch: all -> 0x00a0, TRY_LEAVE, TryCatch #0 {all -> 0x00a0, blocks: (B:70:0x0075, B:72:0x007d, B:74:0x0087, B:75:0x008b, B:66:0x005e, B:76:0x0093, B:65:0x005a), top: B:86:0x005a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0071 -> B:70:0x0075). Please submit an issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object lastIndexOf(kotlinx.coroutines.channels.ReceiveChannel r7, java.lang.Object r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1
            if (r0 == 0) goto L14
            r0 = r9
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 + r2
            r0.label = r9
            goto L19
        L14:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L4a
            if (r2 != r3) goto L42
            java.lang.Object r7 = r0.L$4
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.Ref$IntRef r2 = (kotlin.jvm.internal.Ref.IntRef) r2
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            java.lang.Object r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L40
            r6 = r5
            r5 = r7
            r7 = r8
            r8 = r6
            goto L75
        L40:
            r7 = move-exception
            goto La4
        L42:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L4a:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.jvm.internal.Ref$IntRef r9 = new kotlin.jvm.internal.Ref$IntRef
            r9.<init>()
            r2 = -1
            r9.element = r2
            kotlin.jvm.internal.Ref$IntRef r2 = new kotlin.jvm.internal.Ref$IntRef
            r2.<init>()
            kotlinx.coroutines.channels.ChannelIterator r4 = r7.iterator()     // Catch: java.lang.Throwable -> La0
        L5e:
            r0.L$0 = r8     // Catch: java.lang.Throwable -> La0
            r0.L$1 = r9     // Catch: java.lang.Throwable -> La0
            r0.L$2 = r2     // Catch: java.lang.Throwable -> La0
            r0.L$3 = r7     // Catch: java.lang.Throwable -> La0
            r0.L$4 = r4     // Catch: java.lang.Throwable -> La0
            r0.label = r3     // Catch: java.lang.Throwable -> La0
            java.lang.Object r5 = r4.hasNext(r0)     // Catch: java.lang.Throwable -> La0
            if (r5 != r1) goto L71
            return r1
        L71:
            r6 = r4
            r4 = r9
            r9 = r5
            r5 = r6
        L75:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> La0
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> La0
            if (r9 == 0) goto L93
            java.lang.Object r9 = r5.next()     // Catch: java.lang.Throwable -> La0
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r9)     // Catch: java.lang.Throwable -> La0
            if (r9 == 0) goto L8b
            int r9 = r2.element     // Catch: java.lang.Throwable -> La0
            r4.element = r9     // Catch: java.lang.Throwable -> La0
        L8b:
            int r9 = r2.element     // Catch: java.lang.Throwable -> La0
            int r9 = r9 + r3
            r2.element = r9     // Catch: java.lang.Throwable -> La0
            r9 = r4
            r4 = r5
            goto L5e
        L93:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> La0
            r8 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r8)
            int r7 = r4.element
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            return r7
        La0:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        La4:
            throw r7     // Catch: java.lang.Throwable -> La5
        La5:
            r9 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r8, r7)
            goto Lab
        Laa:
            throw r9
        Lab:
            goto Laa
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.lastIndexOf(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x009b A[Catch: all -> 0x00a7, TRY_LEAVE, TryCatch #2 {all -> 0x00a7, blocks: (B:104:0x0093, B:106:0x009b), top: B:126:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x007b A[Catch: all -> 0x00ab, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x00ab, blocks: (B:95:0x006f, B:99:0x007b), top: B:130:0x006f }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:103:0x008e -> B:126:0x0093). Please submit an issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object lastOrNull(kotlinx.coroutines.channels.ReceiveChannel r7, kotlin.coroutines.Continuation r8) {
        /*
            Method dump skipped, instructions count: 189
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.lastOrNull(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0094 A[Catch: all -> 0x009c, TRY_ENTER, TryCatch #3 {all -> 0x009c, blocks: (B:88:0x0064, B:90:0x006c, B:100:0x0094, B:101:0x009b), top: B:117:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x006c A[Catch: all -> 0x009c, TRY_LEAVE, TryCatch #3 {all -> 0x009c, blocks: (B:88:0x0064, B:90:0x006c, B:100:0x0094, B:101:0x009b), top: B:117:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x008c A[Catch: all -> 0x0033, TRY_ENTER, TryCatch #1 {all -> 0x0033, blocks: (B:73:0x002f, B:94:0x007f, B:98:0x008c, B:99:0x0093), top: B:113:0x002f }] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object single(kotlinx.coroutines.channels.ReceiveChannel r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1
            if (r0 == 0) goto L14
            r0 = r7
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L50
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r6 = r0.L$1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r0 = (kotlinx.coroutines.channels.ReceiveChannel) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L33
            goto L7f
        L33:
            r6 = move-exception
            goto La4
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L4e
            r5 = r7
            r7 = r6
            r6 = r2
            r2 = r5
            goto L64
        L4e:
            r6 = move-exception
            goto L9f
        L50:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.channels.ChannelIterator r7 = r6.iterator()     // Catch: java.lang.Throwable -> La1
            r0.L$0 = r6     // Catch: java.lang.Throwable -> La1
            r0.L$1 = r7     // Catch: java.lang.Throwable -> La1
            r0.label = r4     // Catch: java.lang.Throwable -> La1
            java.lang.Object r2 = r7.hasNext(r0)     // Catch: java.lang.Throwable -> La1
            if (r2 != r1) goto L64
            return r1
        L64:
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L9c
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L9c
            if (r2 == 0) goto L94
            java.lang.Object r2 = r7.next()     // Catch: java.lang.Throwable -> L9c
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L9c
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L9c
            r0.label = r3     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r7 = r7.hasNext(r0)     // Catch: java.lang.Throwable -> L9c
            if (r7 != r1) goto L7d
            return r1
        L7d:
            r0 = r6
            r6 = r2
        L7f:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L33
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L33
            if (r7 != 0) goto L8c
            r7 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r0, r7)
            return r6
        L8c:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L33
            java.lang.String r7 = "ReceiveChannel has more than one element."
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L33
            throw r6     // Catch: java.lang.Throwable -> L33
        L94:
            java.util.NoSuchElementException r7 = new java.util.NoSuchElementException     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = "ReceiveChannel is empty."
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L9c
            throw r7     // Catch: java.lang.Throwable -> L9c
        L9c:
            r7 = move-exception
            r2 = r6
            r6 = r7
        L9f:
            r0 = r2
            goto La4
        La1:
            r7 = move-exception
            r0 = r6
            r6 = r7
        La4:
            throw r6     // Catch: java.lang.Throwable -> La5
        La5:
            r7 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r0, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.single(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0071 A[Catch: all -> 0x0094, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0094, blocks: (B:89:0x0065, B:93:0x0071), top: B:112:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x008c  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object singleOrNull(kotlinx.coroutines.channels.ReceiveChannel r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1
            if (r0 == 0) goto L14
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 + r2
            r0.label = r8
            goto L19
        L14:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L51
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r7 = r0.L$1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r0 = (kotlinx.coroutines.channels.ReceiveChannel) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L34
            goto L84
        L34:
            r7 = move-exception
            goto L9c
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L4f
            r6 = r8
            r8 = r7
            r7 = r2
            r2 = r6
            goto L65
        L4f:
            r7 = move-exception
            goto L97
        L51:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.channels.ChannelIterator r8 = r7.iterator()     // Catch: java.lang.Throwable -> L99
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L99
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L99
            r0.label = r4     // Catch: java.lang.Throwable -> L99
            java.lang.Object r2 = r8.hasNext(r0)     // Catch: java.lang.Throwable -> L99
            if (r2 != r1) goto L65
            return r1
        L65:
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L94
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L94
            if (r2 != 0) goto L71
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r5)
            return r5
        L71:
            java.lang.Object r2 = r8.next()     // Catch: java.lang.Throwable -> L94
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L94
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L94
            r0.label = r3     // Catch: java.lang.Throwable -> L94
            java.lang.Object r8 = r8.hasNext(r0)     // Catch: java.lang.Throwable -> L94
            if (r8 != r1) goto L82
            return r1
        L82:
            r0 = r7
            r7 = r2
        L84:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L34
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L34
            if (r8 == 0) goto L90
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r0, r5)
            return r5
        L90:
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r0, r5)
            return r7
        L94:
            r8 = move-exception
            r2 = r7
            r7 = r8
        L97:
            r0 = r2
            goto L9c
        L99:
            r8 = move-exception
            r0 = r7
            r7 = r8
        L9c:
            throw r7     // Catch: java.lang.Throwable -> L9d
        L9d:
            r8 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r0, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.singleOrNull(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0068 A[Catch: all -> 0x007c, TryCatch #1 {all -> 0x007c, blocks: (B:72:0x0060, B:74:0x0068, B:76:0x006e, B:68:0x004d, B:78:0x0075, B:67:0x0049), top: B:90:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0075 A[Catch: all -> 0x007c, TRY_LEAVE, TryCatch #1 {all -> 0x007c, blocks: (B:72:0x0060, B:74:0x0068, B:76:0x006e, B:68:0x004d, B:78:0x0075, B:67:0x0049), top: B:90:0x0049 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x005c -> B:61:0x0039). Please submit an issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object filterNotNullTo(kotlinx.coroutines.channels.ReceiveChannel r5, java.util.Collection r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1
            if (r0 == 0) goto L14
            r0 = r7
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L46
            if (r2 != r3) goto L3e
            java.lang.Object r5 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r2 = r0.L$0
            java.util.Collection r2 = (java.util.Collection) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L3c
            r4 = r0
            r0 = r5
            r5 = r6
            r6 = r2
        L39:
            r2 = r1
            r1 = r4
            goto L60
        L3c:
            r5 = move-exception
            goto L80
        L3e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L46:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.channels.ChannelIterator r7 = r5.iterator()     // Catch: java.lang.Throwable -> L7c
        L4d:
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L7c
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L7c
            r0.L$2 = r7     // Catch: java.lang.Throwable -> L7c
            r0.label = r3     // Catch: java.lang.Throwable -> L7c
            java.lang.Object r2 = r7.hasNext(r0)     // Catch: java.lang.Throwable -> L7c
            if (r2 != r1) goto L5c
            return r1
        L5c:
            r4 = r0
            r0 = r7
            r7 = r2
            goto L39
        L60:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L7c
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L7c
            if (r7 == 0) goto L75
            java.lang.Object r7 = r0.next()     // Catch: java.lang.Throwable -> L7c
            if (r7 == 0) goto L71
            r6.add(r7)     // Catch: java.lang.Throwable -> L7c
        L71:
            r7 = r0
            r0 = r1
            r1 = r2
            goto L4d
        L75:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L7c
            r7 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r7)
            return r6
        L7c:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L80:
            throw r5     // Catch: java.lang.Throwable -> L81
        L81:
            r7 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r5)
            goto L87
        L86:
            throw r7
        L87:
            goto L86
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterNotNullTo(kotlinx.coroutines.channels.ReceiveChannel, java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x007e A[Catch: all -> 0x009e, TryCatch #2 {all -> 0x009e, blocks: (B:77:0x0063, B:81:0x0076, B:83:0x007e, B:85:0x0084, B:89:0x0097, B:76:0x005f), top: B:102:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0097 A[Catch: all -> 0x009e, TRY_LEAVE, TryCatch #2 {all -> 0x009e, blocks: (B:77:0x0063, B:81:0x0076, B:83:0x007e, B:85:0x0084, B:89:0x0097, B:76:0x005f), top: B:102:0x005f }] */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v8, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x0093 -> B:77:0x0063). Please submit an issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object filterNotNullTo(kotlinx.coroutines.channels.ReceiveChannel r6, kotlinx.coroutines.channels.SendChannel r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3
            if (r0 == 0) goto L14
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 + r2
            r0.label = r8
            goto L19
        L14:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L5c
            if (r2 == r4) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.SendChannel r2 = (kotlinx.coroutines.channels.SendChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L5a
            r8 = r6
            r6 = r7
            r7 = r2
            goto L63
        L3c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L44:
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.SendChannel r2 = (kotlinx.coroutines.channels.SendChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L5a
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r2
        L57:
            r2 = r1
            r1 = r5
            goto L76
        L5a:
            r6 = move-exception
            goto La2
        L5c:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch: java.lang.Throwable -> L9e
        L63:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L9e
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L9e
            r0.L$2 = r8     // Catch: java.lang.Throwable -> L9e
            r0.label = r4     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r2 = r8.hasNext(r0)     // Catch: java.lang.Throwable -> L9e
            if (r2 != r1) goto L72
            return r1
        L72:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L57
        L76:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L9e
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L9e
            if (r8 == 0) goto L97
            java.lang.Object r8 = r0.next()     // Catch: java.lang.Throwable -> L9e
            if (r8 == 0) goto L93
            r1.L$0 = r7     // Catch: java.lang.Throwable -> L9e
            r1.L$1 = r6     // Catch: java.lang.Throwable -> L9e
            r1.L$2 = r0     // Catch: java.lang.Throwable -> L9e
            r1.label = r3     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r8 = r7.send(r8, r1)     // Catch: java.lang.Throwable -> L9e
            if (r8 != r2) goto L93
            return r2
        L93:
            r8 = r0
            r0 = r1
            r1 = r2
            goto L63
        L97:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L9e
            r8 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r8)
            return r7
        L9e:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        La2:
            throw r6     // Catch: java.lang.Throwable -> La3
        La3:
            r8 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r6)
            goto La9
        La8:
            throw r8
        La9:
            goto La8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterNotNullTo(kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.SendChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0079 A[Catch: all -> 0x0054, TryCatch #1 {all -> 0x0054, blocks: (B:62:0x0035, B:77:0x0071, B:79:0x0079, B:82:0x008c, B:67:0x0050), top: B:94:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x008c A[Catch: all -> 0x0054, TRY_LEAVE, TryCatch #1 {all -> 0x0054, blocks: (B:62:0x0035, B:77:0x0071, B:79:0x0079, B:82:0x008c, B:67:0x0050), top: B:94:0x0023 }] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v14, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v5, types: [kotlinx.coroutines.channels.ReceiveChannel, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0089 -> B:63:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <E, C extends kotlinx.coroutines.channels.SendChannel<? super E>> java.lang.Object toChannel(kotlinx.coroutines.channels.ReceiveChannel<? extends E> r6, C r7, kotlin.coroutines.Continuation<? super C> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1
            if (r0 == 0) goto L14
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 + r2
            r0.label = r8
            goto L19
        L14:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L56
            if (r2 == r4) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.SendChannel r2 = (kotlinx.coroutines.channels.SendChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L54
        L38:
            r8 = r6
            r6 = r7
            r7 = r2
            goto L5d
        L3c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L44:
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.SendChannel r2 = (kotlinx.coroutines.channels.SendChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L54
            goto L71
        L54:
            r6 = move-exception
            goto L97
        L56:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch: java.lang.Throwable -> L93
        L5d:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L93
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L93
            r0.L$2 = r8     // Catch: java.lang.Throwable -> L93
            r0.label = r4     // Catch: java.lang.Throwable -> L93
            java.lang.Object r2 = r8.hasNext(r0)     // Catch: java.lang.Throwable -> L93
            if (r2 != r1) goto L6c
            return r1
        L6c:
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r2
            r2 = r5
        L71:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L54
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L54
            if (r8 == 0) goto L8c
            java.lang.Object r8 = r6.next()     // Catch: java.lang.Throwable -> L54
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L54
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L54
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L54
            r0.label = r3     // Catch: java.lang.Throwable -> L54
            java.lang.Object r8 = r2.send(r8, r0)     // Catch: java.lang.Throwable -> L54
            if (r8 != r1) goto L38
            return r1
        L8c:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L54
            r6 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r6)
            return r2
        L93:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L97:
            throw r6     // Catch: java.lang.Throwable -> L98
        L98:
            r8 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r6)
            goto L9e
        L9d:
            throw r8
        L9e:
            goto L9d
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.toChannel(kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.SendChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0068 A[Catch: all -> 0x007a, TryCatch #0 {all -> 0x007a, blocks: (B:69:0x0060, B:71:0x0068, B:65:0x004d, B:72:0x0073, B:64:0x0049), top: B:82:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0073 A[Catch: all -> 0x007a, TRY_LEAVE, TryCatch #0 {all -> 0x007a, blocks: (B:69:0x0060, B:71:0x0068, B:65:0x004d, B:72:0x0073, B:64:0x0049), top: B:82:0x0049 }] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x005c -> B:58:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <E, C extends java.util.Collection<? super E>> java.lang.Object toCollection(kotlinx.coroutines.channels.ReceiveChannel<? extends E> r5, C r6, kotlin.coroutines.Continuation<? super C> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1
            if (r0 == 0) goto L14
            r0 = r7
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L46
            if (r2 != r3) goto L3e
            java.lang.Object r5 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r2 = r0.L$0
            java.util.Collection r2 = (java.util.Collection) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L3c
            r4 = r0
            r0 = r5
            r5 = r6
            r6 = r2
        L39:
            r2 = r1
            r1 = r4
            goto L60
        L3c:
            r5 = move-exception
            goto L7e
        L3e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L46:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.channels.ChannelIterator r7 = r5.iterator()     // Catch: java.lang.Throwable -> L7a
        L4d:
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L7a
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L7a
            r0.L$2 = r7     // Catch: java.lang.Throwable -> L7a
            r0.label = r3     // Catch: java.lang.Throwable -> L7a
            java.lang.Object r2 = r7.hasNext(r0)     // Catch: java.lang.Throwable -> L7a
            if (r2 != r1) goto L5c
            return r1
        L5c:
            r4 = r0
            r0 = r7
            r7 = r2
            goto L39
        L60:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L7a
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L7a
            if (r7 == 0) goto L73
            java.lang.Object r7 = r0.next()     // Catch: java.lang.Throwable -> L7a
            r6.add(r7)     // Catch: java.lang.Throwable -> L7a
            r7 = r0
            r0 = r1
            r1 = r2
            goto L4d
        L73:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L7a
            r7 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r7)
            return r6
        L7a:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L7e:
            throw r5     // Catch: java.lang.Throwable -> L7f
        L7f:
            r7 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r5)
            goto L85
        L84:
            throw r7
        L85:
            goto L84
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.toCollection(kotlinx.coroutines.channels.ReceiveChannel, java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0068 A[Catch: all -> 0x0084, TryCatch #0 {all -> 0x0084, blocks: (B:69:0x0060, B:71:0x0068, B:65:0x004d, B:72:0x007d, B:64:0x0049), top: B:82:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x007d A[Catch: all -> 0x0084, TRY_LEAVE, TryCatch #0 {all -> 0x0084, blocks: (B:69:0x0060, B:71:0x0068, B:65:0x004d, B:72:0x007d, B:64:0x0049), top: B:82:0x0049 }] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.Map] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x005c -> B:58:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <K, V, M extends java.util.Map<? super K, ? super V>> java.lang.Object toMap(kotlinx.coroutines.channels.ReceiveChannel<? extends kotlin.Pair<? extends K, ? extends V>> r6, M r7, kotlin.coroutines.Continuation<? super M> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2
            if (r0 == 0) goto L14
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 + r2
            r0.label = r8
            goto L19
        L14:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L46
            if (r2 != r3) goto L3e
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            java.util.Map r2 = (java.util.Map) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L3c
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r2
        L39:
            r2 = r1
            r1 = r5
            goto L60
        L3c:
            r6 = move-exception
            goto L88
        L3e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L46:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch: java.lang.Throwable -> L84
        L4d:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L84
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L84
            r0.L$2 = r8     // Catch: java.lang.Throwable -> L84
            r0.label = r3     // Catch: java.lang.Throwable -> L84
            java.lang.Object r2 = r8.hasNext(r0)     // Catch: java.lang.Throwable -> L84
            if (r2 != r1) goto L5c
            return r1
        L5c:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L39
        L60:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L84
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L84
            if (r8 == 0) goto L7d
            java.lang.Object r8 = r0.next()     // Catch: java.lang.Throwable -> L84
            kotlin.Pair r8 = (kotlin.Pair) r8     // Catch: java.lang.Throwable -> L84
            java.lang.Object r4 = r8.getFirst()     // Catch: java.lang.Throwable -> L84
            java.lang.Object r8 = r8.getSecond()     // Catch: java.lang.Throwable -> L84
            r7.put(r4, r8)     // Catch: java.lang.Throwable -> L84
            r8 = r0
            r0 = r1
            r1 = r2
            goto L4d
        L7d:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L84
            r8 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r8)
            return r7
        L84:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L88:
            throw r6     // Catch: java.lang.Throwable -> L89
        L89:
            r8 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r6)
            goto L8f
        L8e:
            throw r8
        L8f:
            goto L8e
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.toMap(kotlinx.coroutines.channels.ReceiveChannel, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0036  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object any(kotlinx.coroutines.channels.ReceiveChannel r4, kotlin.coroutines.Continuation r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1
            if (r0 == 0) goto L14
            r0 = r5
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 + r2
            r0.label = r5
            goto L19
        L14:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L4d
            goto L48
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlinx.coroutines.channels.ChannelIterator r5 = r4.iterator()     // Catch: java.lang.Throwable -> L4d
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L4d
            r0.label = r3     // Catch: java.lang.Throwable -> L4d
            java.lang.Object r5 = r5.hasNext(r0)     // Catch: java.lang.Throwable -> L4d
            if (r5 != r1) goto L48
            return r1
        L48:
            r0 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r0)
            return r5
        L4d:
            r5 = move-exception
            throw r5     // Catch: java.lang.Throwable -> L4f
        L4f:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.any(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0067 A[Catch: all -> 0x007d, TryCatch #2 {all -> 0x007d, blocks: (B:65:0x005f, B:67:0x0067, B:62:0x0050, B:68:0x0070, B:61:0x004b), top: B:82:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0070 A[Catch: all -> 0x007d, TRY_LEAVE, TryCatch #2 {all -> 0x007d, blocks: (B:65:0x005f, B:67:0x0067, B:62:0x0050, B:68:0x0070, B:61:0x004b), top: B:82:0x004b }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x005c -> B:65:0x005f). Please submit an issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object count(kotlinx.coroutines.channels.ReceiveChannel r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1
            if (r0 == 0) goto L14
            r0 = r7
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L39
            r5 = r2
            r2 = r6
            r6 = r5
            goto L5f
        L39:
            r6 = move-exception
            goto L80
        L3b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L43:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.jvm.internal.Ref$IntRef r7 = new kotlin.jvm.internal.Ref$IntRef
            r7.<init>()
            kotlinx.coroutines.channels.ChannelIterator r2 = r6.iterator()     // Catch: java.lang.Throwable -> L7d
            r4 = r7
        L50:
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L7d
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L7d
            r0.L$2 = r2     // Catch: java.lang.Throwable -> L7d
            r0.label = r3     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r7 = r2.hasNext(r0)     // Catch: java.lang.Throwable -> L7d
            if (r7 != r1) goto L5f
            return r1
        L5f:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L7d
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L7d
            if (r7 == 0) goto L70
            r2.next()     // Catch: java.lang.Throwable -> L7d
            int r7 = r4.element     // Catch: java.lang.Throwable -> L7d
            int r7 = r7 + r3
            r4.element = r7     // Catch: java.lang.Throwable -> L7d
            goto L50
        L70:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L7d
            r7 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r7)
            int r6 = r4.element
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L7d:
            r7 = move-exception
            r2 = r6
            r6 = r7
        L80:
            throw r6     // Catch: java.lang.Throwable -> L81
        L81:
            r7 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r2, r6)
            goto L87
        L86:
            throw r7
        L87:
            goto L86
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.count(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00a2 A[Catch: all -> 0x00b6, TRY_LEAVE, TryCatch #1 {all -> 0x00b6, blocks: (B:101:0x009a, B:103:0x00a2, B:98:0x0089, B:89:0x0064), top: B:120:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0083 A[Catch: all -> 0x00b2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00b2, blocks: (B:92:0x0077, B:96:0x0083), top: B:118:0x0077 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x0097 -> B:101:0x009a). Please submit an issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object maxWith(kotlinx.coroutines.channels.ReceiveChannel r8, java.util.Comparator r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 195
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.maxWith(kotlinx.coroutines.channels.ReceiveChannel, java.util.Comparator, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00a2 A[Catch: all -> 0x00b6, TRY_LEAVE, TryCatch #1 {all -> 0x00b6, blocks: (B:101:0x009a, B:103:0x00a2, B:98:0x0089, B:89:0x0064), top: B:120:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0083 A[Catch: all -> 0x00b2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00b2, blocks: (B:92:0x0077, B:96:0x0083), top: B:118:0x0077 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x0097 -> B:101:0x009a). Please submit an issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object minWith(kotlinx.coroutines.channels.ReceiveChannel r8, java.util.Comparator r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 195
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.minWith(kotlinx.coroutines.channels.ReceiveChannel, java.util.Comparator, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0036  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object none(kotlinx.coroutines.channels.ReceiveChannel r4, kotlin.coroutines.Continuation r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1
            if (r0 == 0) goto L14
            r0 = r5
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 + r2
            r0.label = r5
            goto L19
        L14:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L58
            goto L48
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlinx.coroutines.channels.ChannelIterator r5 = r4.iterator()     // Catch: java.lang.Throwable -> L58
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L58
            r0.label = r3     // Catch: java.lang.Throwable -> L58
            java.lang.Object r5 = r5.hasNext(r0)     // Catch: java.lang.Throwable -> L58
            if (r5 != r1) goto L48
            return r1
        L48:
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch: java.lang.Throwable -> L58
            boolean r5 = r5.booleanValue()     // Catch: java.lang.Throwable -> L58
            r5 = r5 ^ r3
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)     // Catch: java.lang.Throwable -> L58
            r0 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r0)
            return r5
        L58:
            r5 = move-exception
            throw r5     // Catch: java.lang.Throwable -> L5a
        L5a:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.none(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
