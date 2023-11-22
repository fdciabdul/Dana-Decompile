package androidx.paging;

import androidx.paging.HintHandler;
import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import androidx.paging.PageFetcherSnapshotState;
import androidx.paging.PagingSource;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u0085\u0001\u0012\b\u0010\n\u001a\u0004\u0018\u00018\u0000\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010.\u0012\u0006\u0010\u0012\u001a\u00020\u0018\u0012\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00070,\u0012\b\b\u0002\u0010>\u001a\u00020:\u0012\u0016\b\u0002\u0010?\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u000103\u0012\u0016\b\u0002\u0010@\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00070 ¢\u0006\u0004\bB\u0010CJ\u001f\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006J#\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\rJ'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u000fJ9\u0010\u0013\u001a\u0004\u0018\u00018\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0005\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0015H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0016J+\u0010\b\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00102\u0006\u0010\n\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0000¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R \u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010$0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010\u0019\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010(\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010+R\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010$0,X\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010-R\u001d\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010.X\u0000¢\u0006\u0006\n\u0004\b\u0005\u0010/R\"\u00102\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001f\u00105\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u000103X\u0006¢\u0006\u0006\n\u0004\b2\u00104R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u00070,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010-R \u00100\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/PageFetcherSnapshot;", "", "Key", "Value", "Landroidx/paging/PagingState;", "PlaceComponentResult", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "BuiltInFictitiousFunctionClassFactory", "Landroidx/paging/LoadType;", "p0", "Landroidx/paging/GenerationalViewportHint;", "p1", "(Landroidx/paging/LoadType;Landroidx/paging/GenerationalViewportHint;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PagingSource$LoadParams;", "(Landroidx/paging/LoadType;Ljava/lang/Object;)Landroidx/paging/PagingSource$LoadParams;", "Landroidx/paging/PageFetcherSnapshotState;", "", "p2", "MyBillsEntityDataFactory", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;II)Ljava/lang/Object;", "Landroidx/paging/LoadState$Error;", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;Landroidx/paging/LoadState$Error;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PagingConfig;", "moveToNextValue", "Landroidx/paging/PagingConfig;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/paging/HintHandler;", "Landroidx/paging/HintHandler;", "getAuthRequestContext", "Ljava/lang/Object;", "Lkotlin/Function0;", "lookAheadTest", "Lkotlin/jvm/functions/Function0;", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/paging/PageEvent;", "getErrorConfigVersion", "Lkotlinx/coroutines/channels/Channel;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingSource;", "Landroidx/paging/PagingSource;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Landroidx/paging/PagingState;", "scheduleImpl", "Landroidx/paging/RemoteMediatorConnection;", "Landroidx/paging/RemoteMediatorConnection;", "initRecordTimeStamp", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Landroidx/paging/PageFetcherSnapshotState$Holder;", "Landroidx/paging/PageFetcherSnapshotState$Holder;", "", "GetContactSyncConfig", "Z", "p3", "p4", "p5", "p6", "p7", "<init>", "(Ljava/lang/Object;Landroidx/paging/PagingSource;Landroidx/paging/PagingConfig;Lkotlinx/coroutines/flow/Flow;ZLandroidx/paging/RemoteMediatorConnection;Landroidx/paging/PagingState;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class PageFetcherSnapshot<Key, Value> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final HintHandler PlaceComponentResult;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final Flow<Unit> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final boolean GetContactSyncConfig;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final Flow<PageEvent<Value>> getErrorConfigVersion;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final CompletableJob NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final AtomicBoolean moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final PagingState<Key, Value> scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final PageFetcherSnapshotState.Holder<Key, Value> NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final PagingSource<Key, Value> lookAheadTest;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Key BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Channel<PageEvent<Value>> getAuthRequestContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Function0<Unit> MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final PagingConfig KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    final RemoteMediatorConnection<Key, Value> initRecordTimeStamp;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[LoadType.values().length];
            iArr[LoadType.REFRESH.ordinal()] = 1;
            iArr[LoadType.PREPEND.ordinal()] = 2;
            iArr[LoadType.APPEND.ordinal()] = 3;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    public PageFetcherSnapshot(Key key, PagingSource<Key, Value> pagingSource, PagingConfig pagingConfig, Flow<Unit> flow, boolean z, RemoteMediatorConnection<Key, Value> remoteMediatorConnection, PagingState<Key, Value> pagingState, Function0<Unit> function0) {
        CompletableJob Job$default;
        Intrinsics.checkNotNullParameter(pagingSource, "");
        Intrinsics.checkNotNullParameter(pagingConfig, "");
        Intrinsics.checkNotNullParameter(flow, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.BuiltInFictitiousFunctionClassFactory = key;
        this.lookAheadTest = pagingSource;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = pagingConfig;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = flow;
        this.GetContactSyncConfig = z;
        this.initRecordTimeStamp = remoteMediatorConnection;
        this.scheduleImpl = pagingState;
        this.MyBillsEntityDataFactory = function0;
        if (!(pagingConfig.KClassImpl$Data$declaredNonStaticMembers$2 == Integer.MIN_VALUE || pagingSource.getAuthRequestContext())) {
            throw new IllegalArgumentException("PagingConfig.jumpThreshold was set, but the associated PagingSource has not marked support for jumps by overriding PagingSource.jumpingSupported to true.".toString());
        }
        this.PlaceComponentResult = new HintHandler();
        this.moveToNextValue = new AtomicBoolean(false);
        this.getAuthRequestContext = ChannelKt.Channel$default(-2, null, null, 6, null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new PageFetcherSnapshotState.Holder<>(pagingConfig);
        Job$default = JobKt__JobKt.Job$default(null, 1, null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Job$default;
        this.getErrorConfigVersion = FlowKt.onStart(CancelableChannelFlowKt.BuiltInFictitiousFunctionClassFactory(Job$default, new PageFetcherSnapshot$pageEventFlow$1(this, null)), new PageFetcherSnapshot$pageEventFlow$2(this, null));
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Key", "Value", "", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: androidx.paging.PageFetcherSnapshot$1 */
    /* loaded from: classes3.dex */
    static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        /* renamed from: invoke */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object PlaceComponentResult(kotlin.coroutines.Continuation<? super androidx.paging.PagingState<Key, Value>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.paging.PageFetcherSnapshot$currentPagingState$1
            if (r0 == 0) goto L14
            r0 = r6
            androidx.paging.PageFetcherSnapshot$currentPagingState$1 r0 = (androidx.paging.PageFetcherSnapshot$currentPagingState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            androidx.paging.PageFetcherSnapshot$currentPagingState$1 r0 = new androidx.paging.PageFetcherSnapshot$currentPagingState$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r1 = r0.L$2
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r2 = r0.L$1
            androidx.paging.PageFetcherSnapshotState$Holder r2 = (androidx.paging.PageFetcherSnapshotState.Holder) r2
            java.lang.Object r0 = r0.L$0
            androidx.paging.PageFetcherSnapshot r0 = (androidx.paging.PageFetcherSnapshot) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L59
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3f:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.paging.PageFetcherSnapshotState$Holder<Key, Value> r2 = r5.NetworkUserEntityData$$ExternalSyntheticLambda1
            kotlinx.coroutines.sync.Mutex r6 = androidx.paging.PageFetcherSnapshotState.Holder.KClassImpl$Data$declaredNonStaticMembers$2(r2)
            r0.L$0 = r5
            r0.L$1 = r2
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r0 = r6.lock(r4, r0)
            if (r0 != r1) goto L57
            return r1
        L57:
            r0 = r5
            r1 = r6
        L59:
            androidx.paging.PageFetcherSnapshotState r6 = androidx.paging.PageFetcherSnapshotState.Holder.PlaceComponentResult(r2)     // Catch: java.lang.Throwable -> L6b
            androidx.paging.HintHandler r0 = r0.PlaceComponentResult     // Catch: java.lang.Throwable -> L6b
            androidx.paging.HintHandler$State r0 = r0.getAuthRequestContext     // Catch: java.lang.Throwable -> L6b
            androidx.paging.ViewportHint$Access r0 = r0.getAuthRequestContext     // Catch: java.lang.Throwable -> L6b
            androidx.paging.PagingState r6 = r6.MyBillsEntityDataFactory(r0)     // Catch: java.lang.Throwable -> L6b
            r1.unlock(r4)
            return r6
        L6b:
            r6 = move-exception
            r1.unlock(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot.PlaceComponentResult(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final PagingSource.LoadParams<Key> PlaceComponentResult(LoadType p0, Key p1) {
        PagingSource.LoadParams.Companion companion = PagingSource.LoadParams.INSTANCE;
        return PagingSource.LoadParams.Companion.getAuthRequestContext(p0, p1, p0 == LoadType.REFRESH ? this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult : this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x00fa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0118 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x015d A[Catch: all -> 0x0227, TryCatch #3 {all -> 0x0227, blocks: (B:180:0x0139, B:182:0x015d, B:183:0x016c, B:185:0x0173), top: B:253:0x0139 }] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0173 A[Catch: all -> 0x0227, TRY_LEAVE, TryCatch #3 {all -> 0x0227, blocks: (B:180:0x0139, B:182:0x015d, B:183:0x016c, B:185:0x0173), top: B:253:0x0139 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x01c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x026a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x026b  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v28, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v8, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object BuiltInFictitiousFunctionClassFactory(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instructions count: 684
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot.BuiltInFictitiousFunctionClassFactory(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:350:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x0318 A[Catch: all -> 0x0862, TRY_LEAVE, TryCatch #0 {all -> 0x0862, blocks: (B:412:0x0301, B:415:0x0318), top: B:658:0x0301 }] */
    /* JADX WARN: Removed duplicated region for block: B:423:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x049c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:476:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:489:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:493:0x0507 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:507:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x054f  */
    /* JADX WARN: Removed duplicated region for block: B:510:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:553:0x061d  */
    /* JADX WARN: Removed duplicated region for block: B:588:0x0730 A[Catch: all -> 0x0855, TryCatch #4 {all -> 0x0855, blocks: (B:586:0x071b, B:588:0x0730, B:590:0x073a, B:592:0x0740, B:594:0x074d, B:593:0x0747, B:595:0x0752, B:599:0x0784, B:581:0x06fb, B:585:0x0714, B:631:0x080c, B:632:0x083d, B:635:0x0842, B:636:0x0854, B:354:0x008f, B:357:0x00c4), top: B:665:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:592:0x0740 A[Catch: all -> 0x0855, TryCatch #4 {all -> 0x0855, blocks: (B:586:0x071b, B:588:0x0730, B:590:0x073a, B:592:0x0740, B:594:0x074d, B:593:0x0747, B:595:0x0752, B:599:0x0784, B:581:0x06fb, B:585:0x0714, B:631:0x080c, B:632:0x083d, B:635:0x0842, B:636:0x0854, B:354:0x008f, B:357:0x00c4), top: B:665:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:593:0x0747 A[Catch: all -> 0x0855, TryCatch #4 {all -> 0x0855, blocks: (B:586:0x071b, B:588:0x0730, B:590:0x073a, B:592:0x0740, B:594:0x074d, B:593:0x0747, B:595:0x0752, B:599:0x0784, B:581:0x06fb, B:585:0x0714, B:631:0x080c, B:632:0x083d, B:635:0x0842, B:636:0x0854, B:354:0x008f, B:357:0x00c4), top: B:665:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:597:0x077c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:598:0x077d  */
    /* JADX WARN: Removed duplicated region for block: B:618:0x07d4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:619:0x07d5  */
    /* JADX WARN: Removed duplicated region for block: B:623:0x07ea  */
    /* JADX WARN: Removed duplicated region for block: B:625:0x07f3  */
    /* JADX WARN: Removed duplicated region for block: B:635:0x0842 A[Catch: all -> 0x0855, TryCatch #4 {all -> 0x0855, blocks: (B:586:0x071b, B:588:0x0730, B:590:0x073a, B:592:0x0740, B:594:0x074d, B:593:0x0747, B:595:0x0752, B:599:0x0784, B:581:0x06fb, B:585:0x0714, B:631:0x080c, B:632:0x083d, B:635:0x0842, B:636:0x0854, B:354:0x008f, B:357:0x00c4), top: B:665:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:649:0x0869  */
    /* JADX WARN: Removed duplicated region for block: B:669:0x0628 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v44, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [T] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v25, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v6, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v55 */
    /* JADX WARN: Type inference failed for: r7v36, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:613:0x07a7 -> B:626:0x07fa). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:615:0x07ab -> B:626:0x07fa). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:619:0x07d5 -> B:663:0x07d6). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object BuiltInFictitiousFunctionClassFactory(androidx.paging.LoadType r21, androidx.paging.GenerationalViewportHint r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            Method dump skipped, instructions count: 2212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot.BuiltInFictitiousFunctionClassFactory(androidx.paging.LoadType, androidx.paging.GenerationalViewportHint, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Key MyBillsEntityDataFactory(PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, LoadType loadType, int i, int i2) {
        if (i == pageFetcherSnapshotState.PlaceComponentResult(loadType) && !(pageFetcherSnapshotState.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2(loadType) instanceof LoadState.Error) && i2 < this.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion) {
            if (loadType == LoadType.PREPEND) {
                return ((PagingSource.LoadResult.Page) CollectionsKt.first((List) pageFetcherSnapshotState.NetworkUserEntityData$$ExternalSyntheticLambda0)).getAuthRequestContext;
            }
            return ((PagingSource.LoadResult.Page) CollectionsKt.last((List) pageFetcherSnapshotState.NetworkUserEntityData$$ExternalSyntheticLambda0)).KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return null;
    }

    public static final /* synthetic */ Object KClassImpl$Data$declaredNonStaticMembers$2(PageFetcherSnapshot pageFetcherSnapshot, Flow flow, final LoadType loadType, Continuation continuation) {
        Object collect = FlowKt.conflate(FlowExtKt.KClassImpl$Data$declaredNonStaticMembers$2(FlowExtKt.MyBillsEntityDataFactory(flow, new PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1(null, pageFetcherSnapshot, loadType)), new PageFetcherSnapshot$collectAsGenerationalViewportHints$3(loadType, null))).collect(new FlowCollector<GenerationalViewportHint>() { // from class: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$collect$1
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(GenerationalViewportHint generationalViewportHint, Continuation<? super Unit> continuation2) {
                Object BuiltInFictitiousFunctionClassFactory;
                BuiltInFictitiousFunctionClassFactory = PageFetcherSnapshot.this.BuiltInFictitiousFunctionClassFactory(loadType, generationalViewportHint, continuation2);
                return BuiltInFictitiousFunctionClassFactory == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? BuiltInFictitiousFunctionClassFactory : Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public static final /* synthetic */ Object PlaceComponentResult(PageFetcherSnapshot pageFetcherSnapshot, final LoadType loadType, final ViewportHint viewportHint, Continuation continuation) {
        boolean z = true;
        if (WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[loadType.ordinal()] == 1) {
            Object BuiltInFictitiousFunctionClassFactory = pageFetcherSnapshot.BuiltInFictitiousFunctionClassFactory(continuation);
            return BuiltInFictitiousFunctionClassFactory == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? BuiltInFictitiousFunctionClassFactory : Unit.INSTANCE;
        }
        if (!(viewportHint != null)) {
            throw new IllegalStateException("Cannot retry APPEND / PREPEND load on PagingSource without ViewportHint".toString());
        }
        HintHandler hintHandler = pageFetcherSnapshot.PlaceComponentResult;
        Intrinsics.checkNotNullParameter(loadType, "");
        Intrinsics.checkNotNullParameter(viewportHint, "");
        if (loadType != LoadType.PREPEND && loadType != LoadType.APPEND) {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("invalid load type for reset: ", loadType).toString());
        }
        hintHandler.getAuthRequestContext.PlaceComponentResult(null, new Function2<HintHandler.HintFlow, HintHandler.HintFlow, Unit>() { // from class: androidx.paging.HintHandler$forceSetHint$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(HintHandler.HintFlow hintFlow, HintHandler.HintFlow hintFlow2) {
                invoke2(hintFlow, hintFlow2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(HintHandler.HintFlow hintFlow, HintHandler.HintFlow hintFlow2) {
                Intrinsics.checkNotNullParameter(hintFlow, "");
                Intrinsics.checkNotNullParameter(hintFlow2, "");
                if (LoadType.this == LoadType.PREPEND) {
                    ViewportHint viewportHint2 = viewportHint;
                    hintFlow.PlaceComponentResult = viewportHint2;
                    if (viewportHint2 != null) {
                        hintFlow.KClassImpl$Data$declaredNonStaticMembers$2.tryEmit(viewportHint2);
                        return;
                    }
                    return;
                }
                ViewportHint viewportHint3 = viewportHint;
                hintFlow2.PlaceComponentResult = viewportHint3;
                if (viewportHint3 != null) {
                    hintFlow2.KClassImpl$Data$declaredNonStaticMembers$2.tryEmit(viewportHint3);
                }
            }
        });
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PageFetcherSnapshot pageFetcherSnapshot, CoroutineScope coroutineScope) {
        if (pageFetcherSnapshot.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 != Integer.MIN_VALUE) {
            Iterator it = CollectionsKt.listOf((Object[]) new LoadType[]{LoadType.APPEND, LoadType.PREPEND}).iterator();
            while (it.hasNext()) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PageFetcherSnapshot$startConsumingHints$1$1(pageFetcherSnapshot, (LoadType) it.next(), null), 3, null);
            }
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PageFetcherSnapshot$startConsumingHints$2(pageFetcherSnapshot, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PageFetcherSnapshot$startConsumingHints$3(pageFetcherSnapshot, null), 3, null);
    }

    private final Object PlaceComponentResult(PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, LoadType loadType, LoadState.Error error, Continuation<? super Unit> continuation) {
        if (!Intrinsics.areEqual(pageFetcherSnapshotState.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2(loadType), error)) {
            pageFetcherSnapshotState.GetContactSyncConfig.getAuthRequestContext(loadType, error);
            Channel<PageEvent<Value>> channel = this.getAuthRequestContext;
            MutableLoadStateCollection mutableLoadStateCollection = pageFetcherSnapshotState.GetContactSyncConfig;
            Object send = channel.send(new PageEvent.LoadStateUpdate(new LoadStates(mutableLoadStateCollection.PlaceComponentResult, mutableLoadStateCollection.MyBillsEntityDataFactory, mutableLoadStateCollection.BuiltInFictitiousFunctionClassFactory), null), continuation);
            return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final Object BuiltInFictitiousFunctionClassFactory(PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, LoadType loadType, Continuation<? super Unit> continuation) {
        if (!Intrinsics.areEqual(pageFetcherSnapshotState.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2(loadType), LoadState.Loading.INSTANCE)) {
            pageFetcherSnapshotState.GetContactSyncConfig.getAuthRequestContext(loadType, LoadState.Loading.INSTANCE);
            Channel<PageEvent<Value>> channel = this.getAuthRequestContext;
            MutableLoadStateCollection mutableLoadStateCollection = pageFetcherSnapshotState.GetContactSyncConfig;
            Object send = channel.send(new PageEvent.LoadStateUpdate(new LoadStates(mutableLoadStateCollection.PlaceComponentResult, mutableLoadStateCollection.MyBillsEntityDataFactory, mutableLoadStateCollection.BuiltInFictitiousFunctionClassFactory), null), continuation);
            return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
