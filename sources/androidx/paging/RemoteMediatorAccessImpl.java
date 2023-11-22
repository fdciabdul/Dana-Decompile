package androidx.paging;

import androidx.paging.AccessorState;
import androidx.paging.LoadState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000  *\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0001 B#\u0012\u0006\u0010\t\u001a\u00020\u0019\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010\u0006\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\r\u001a\u00020\f2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000fR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0018R\u0014\u0010\r\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001aR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/RemoteMediatorAccessImpl;", "", "Key", "Value", "Landroidx/paging/RemoteMediatorAccessor;", "Landroidx/paging/RemoteMediator$InitializeAction;", "MyBillsEntityDataFactory", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/LoadType;", "p0", "Landroidx/paging/PagingState;", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/paging/LoadType;Landroidx/paging/PagingState;)V", "(Landroidx/paging/PagingState;)V", "Landroidx/paging/AccessorStateHolder;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/paging/AccessorStateHolder;", "Landroidx/paging/SingleRunner;", "PlaceComponentResult", "Landroidx/paging/SingleRunner;", "getAuthRequestContext", "Landroidx/paging/RemoteMediator;", "Landroidx/paging/RemoteMediator;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/StateFlow;", "Landroidx/paging/LoadStates;", "()Lkotlinx/coroutines/flow/StateFlow;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/paging/RemoteMediator;)V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteMediatorAccessImpl<Key, Value> implements RemoteMediatorAccessor<Key, Value> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final AccessorStateHolder<Key, Value> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final CoroutineScope BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final SingleRunner getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final RemoteMediator<Key, Value> KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[LoadType.values().length];
            iArr[LoadType.REFRESH.ordinal()] = 1;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    public RemoteMediatorAccessImpl(CoroutineScope coroutineScope, RemoteMediator<Key, Value> remoteMediator) {
        Intrinsics.checkNotNullParameter(coroutineScope, "");
        Intrinsics.checkNotNullParameter(remoteMediator, "");
        this.BuiltInFictitiousFunctionClassFactory = coroutineScope;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = remoteMediator;
        this.MyBillsEntityDataFactory = new AccessorStateHolder<>();
        this.getAuthRequestContext = new SingleRunner(false);
    }

    @Override // androidx.paging.RemoteMediatorAccessor
    @JvmName(name = "getAuthRequestContext")
    public final StateFlow<LoadStates> getAuthRequestContext() {
        return this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // androidx.paging.RemoteMediatorConnection
    public final void BuiltInFictitiousFunctionClassFactory(final LoadType p0, final PagingState<Key, Value> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (((Boolean) this.MyBillsEntityDataFactory.PlaceComponentResult(new Function1<AccessorState<Key, Value>, Boolean>() { // from class: androidx.paging.RemoteMediatorAccessImpl$requestLoad$newRequest$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return invoke((AccessorState) ((AccessorState) obj));
            }

            public final Boolean invoke(AccessorState<Key, Value> accessorState) {
                Intrinsics.checkNotNullParameter(accessorState, "");
                return Boolean.valueOf(accessorState.getAuthRequestContext(LoadType.this, p1));
            }
        })).booleanValue()) {
            if (WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[p0.ordinal()] == 1) {
                BuildersKt__Builders_commonKt.launch$default(this.BuiltInFictitiousFunctionClassFactory, null, null, new RemoteMediatorAccessImpl$launchRefresh$1(this, null), 3, null);
            } else {
                BuildersKt__Builders_commonKt.launch$default(this.BuiltInFictitiousFunctionClassFactory, null, null, new RemoteMediatorAccessImpl$launchBoundary$1(this, null), 3, null);
            }
        }
    }

    @Override // androidx.paging.RemoteMediatorConnection
    public final void BuiltInFictitiousFunctionClassFactory(PagingState<Key, Value> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final ArrayList arrayList = new ArrayList();
        this.MyBillsEntityDataFactory.PlaceComponentResult(new Function1<AccessorState<Key, Value>, Unit>() { // from class: androidx.paging.RemoteMediatorAccessImpl$retryFailed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke((AccessorState) ((AccessorState) obj));
                return Unit.INSTANCE;
            }

            public final void invoke(AccessorState<Key, Value> accessorState) {
                Intrinsics.checkNotNullParameter(accessorState, "");
                LoadStates BuiltInFictitiousFunctionClassFactory = accessorState.BuiltInFictitiousFunctionClassFactory();
                boolean z = BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory instanceof LoadState.Error;
                int length = accessorState.PlaceComponentResult.length - 1;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        accessorState.PlaceComponentResult[i] = null;
                        if (i2 > length) {
                            break;
                        }
                        i = i2;
                    }
                }
                if (z) {
                    arrayList.add(LoadType.REFRESH);
                    LoadType loadType = LoadType.REFRESH;
                    AccessorState.BlockState blockState = AccessorState.BlockState.UNBLOCKED;
                    Intrinsics.checkNotNullParameter(loadType, "");
                    Intrinsics.checkNotNullParameter(blockState, "");
                    accessorState.MyBillsEntityDataFactory[loadType.ordinal()] = blockState;
                }
                if (BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory instanceof LoadState.Error) {
                    if (!z) {
                        arrayList.add(LoadType.APPEND);
                    }
                    LoadType loadType2 = LoadType.APPEND;
                    Intrinsics.checkNotNullParameter(loadType2, "");
                    CollectionsKt.removeAll((List) accessorState.getAuthRequestContext, (Function1) new AccessorState$clearPendingRequest$1(loadType2));
                }
                if (BuiltInFictitiousFunctionClassFactory.PlaceComponentResult instanceof LoadState.Error) {
                    if (!z) {
                        arrayList.add(LoadType.PREPEND);
                    }
                    LoadType loadType3 = LoadType.PREPEND;
                    Intrinsics.checkNotNullParameter(loadType3, "");
                    CollectionsKt.removeAll((List) accessorState.getAuthRequestContext, (Function1) new AccessorState$clearPendingRequest$1(loadType3));
                }
            }
        });
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            BuiltInFictitiousFunctionClassFactory((LoadType) it.next(), p0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    @Override // androidx.paging.RemoteMediatorAccessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object MyBillsEntityDataFactory(kotlin.coroutines.Continuation<? super androidx.paging.RemoteMediator.InitializeAction> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.paging.RemoteMediatorAccessImpl$initialize$1
            if (r0 == 0) goto L14
            r0 = r5
            androidx.paging.RemoteMediatorAccessImpl$initialize$1 r0 = (androidx.paging.RemoteMediatorAccessImpl$initialize$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 + r2
            r0.label = r5
            goto L19
        L14:
            androidx.paging.RemoteMediatorAccessImpl$initialize$1 r0 = new androidx.paging.RemoteMediatorAccessImpl$initialize$1
            r0.<init>(r4, r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            androidx.paging.RemoteMediatorAccessImpl r0 = (androidx.paging.RemoteMediatorAccessImpl) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L45
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = androidx.paging.RemoteMediator.getAuthRequestContext()
            if (r5 != r1) goto L44
            return r1
        L44:
            r0 = r4
        L45:
            r1 = r5
            androidx.paging.RemoteMediator$InitializeAction r1 = (androidx.paging.RemoteMediator.InitializeAction) r1
            androidx.paging.RemoteMediator$InitializeAction r2 = androidx.paging.RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH
            if (r1 != r2) goto L55
            androidx.paging.AccessorStateHolder<Key, Value> r0 = r0.MyBillsEntityDataFactory
            androidx.paging.RemoteMediatorAccessImpl$initialize$2$1 r1 = new kotlin.jvm.functions.Function1<androidx.paging.AccessorState<Key, Value>, kotlin.Unit>() { // from class: androidx.paging.RemoteMediatorAccessImpl$initialize$2$1
                static {
                    /*
                        androidx.paging.RemoteMediatorAccessImpl$initialize$2$1 r0 = new androidx.paging.RemoteMediatorAccessImpl$initialize$2$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.paging.RemoteMediatorAccessImpl$initialize$2$1) androidx.paging.RemoteMediatorAccessImpl$initialize$2$1.INSTANCE androidx.paging.RemoteMediatorAccessImpl$initialize$2$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl$initialize$2$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl$initialize$2$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Object r1) {
                    /*
                        r0 = this;
                        androidx.paging.AccessorState r1 = (androidx.paging.AccessorState) r1
                        r0.invoke(r1)
                        kotlin.Unit r1 = kotlin.Unit.INSTANCE
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl$initialize$2$1.invoke(java.lang.Object):java.lang.Object");
                }

                public final void invoke(androidx.paging.AccessorState<Key, Value> r5) {
                    /*
                        r4 = this;
                        java.lang.String r0 = ""
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                        androidx.paging.LoadType r1 = androidx.paging.LoadType.APPEND
                        androidx.paging.AccessorState$BlockState r2 = androidx.paging.AccessorState.BlockState.REQUIRES_REFRESH
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                        androidx.paging.AccessorState$BlockState[] r3 = r5.MyBillsEntityDataFactory
                        int r1 = r1.ordinal()
                        r3[r1] = r2
                        androidx.paging.LoadType r1 = androidx.paging.LoadType.PREPEND
                        androidx.paging.AccessorState$BlockState r2 = androidx.paging.AccessorState.BlockState.REQUIRES_REFRESH
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                        androidx.paging.AccessorState$BlockState[] r5 = r5.MyBillsEntityDataFactory
                        int r0 = r1.ordinal()
                        r5[r0] = r2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl$initialize$2$1.invoke(androidx.paging.AccessorState):void");
                }
            }
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r0.PlaceComponentResult(r1)
        L55:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl.MyBillsEntityDataFactory(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
