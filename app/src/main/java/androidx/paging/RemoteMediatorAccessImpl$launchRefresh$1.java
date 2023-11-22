package androidx.paging;

import androidx.paging.AccessorState;
import androidx.paging.LoadState;
import androidx.paging.RemoteMediator;
import com.alipay.iap.android.aplog.util.zip.LZMA_Base;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1", f = "RemoteMediatorAccessor.kt", i = {0}, l = {266}, m = "invokeSuspend", n = {"launchAppendPrepend"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class RemoteMediatorAccessImpl$launchRefresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RemoteMediatorAccessImpl<Key, Value> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteMediatorAccessImpl$launchRefresh$1(RemoteMediatorAccessImpl<Key, Value> remoteMediatorAccessImpl, Continuation<? super RemoteMediatorAccessImpl$launchRefresh$1> continuation) {
        super(2, continuation);
        this.this$0 = remoteMediatorAccessImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RemoteMediatorAccessImpl$launchRefresh$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RemoteMediatorAccessImpl$launchRefresh$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SingleRunner singleRunner;
        Ref.BooleanRef booleanRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            singleRunner = ((RemoteMediatorAccessImpl) this.this$0).getAuthRequestContext;
            this.L$0 = booleanRef2;
            this.label = 1;
            if (singleRunner.getAuthRequestContext(2, new AnonymousClass1(this.this$0, booleanRef2, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = booleanRef2;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            booleanRef = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (booleanRef.element) {
            BuildersKt__Builders_commonKt.launch$default(r7.BuiltInFictitiousFunctionClassFactory, null, null, new RemoteMediatorAccessImpl$launchBoundary$1(this.this$0, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000H\u008a@"}, d2 = {"", "Key", "Value", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1$1", f = "RemoteMediatorAccessor.kt", i = {}, l = {LZMA_Base.kMatchMaxLen}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.BooleanRef $launchAppendPrepend;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ RemoteMediatorAccessImpl<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RemoteMediatorAccessImpl<Key, Value> remoteMediatorAccessImpl, Ref.BooleanRef booleanRef, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.this$0 = remoteMediatorAccessImpl;
            this.$launchAppendPrepend = booleanRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$launchAppendPrepend, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AccessorStateHolder accessorStateHolder;
            RemoteMediatorAccessImpl remoteMediatorAccessImpl;
            RemoteMediator remoteMediator;
            Ref.BooleanRef booleanRef;
            AccessorStateHolder accessorStateHolder2;
            boolean booleanValue;
            AccessorStateHolder accessorStateHolder3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                accessorStateHolder = ((RemoteMediatorAccessImpl) this.this$0).MyBillsEntityDataFactory;
                if (((PagingState) accessorStateHolder.PlaceComponentResult(new Function1<AccessorState<Key, Value>, PagingState<Key, Value>>() { // from class: androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1$1$pendingPagingState$1
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        return invoke((AccessorState) ((AccessorState) obj2));
                    }

                    public final PagingState<Key, Value> invoke(AccessorState<Key, Value> accessorState) {
                        AccessorState.PendingRequest<Key, Value> pendingRequest;
                        Intrinsics.checkNotNullParameter(accessorState, "");
                        Iterator<AccessorState.PendingRequest<Key, Value>> it = accessorState.getAuthRequestContext.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                pendingRequest = null;
                                break;
                            }
                            pendingRequest = it.next();
                            if (pendingRequest.PlaceComponentResult == LoadType.REFRESH) {
                                break;
                            }
                        }
                        AccessorState.PendingRequest<Key, Value> pendingRequest2 = pendingRequest;
                        if (pendingRequest2 == null) {
                            return null;
                        }
                        return pendingRequest2.getAuthRequestContext;
                    }
                })) != null) {
                    remoteMediatorAccessImpl = this.this$0;
                    Ref.BooleanRef booleanRef2 = this.$launchAppendPrepend;
                    remoteMediator = remoteMediatorAccessImpl.KClassImpl$Data$declaredNonStaticMembers$2;
                    LoadType loadType = LoadType.REFRESH;
                    this.L$0 = remoteMediatorAccessImpl;
                    this.L$1 = booleanRef2;
                    this.label = 1;
                    Object MyBillsEntityDataFactory = remoteMediator.MyBillsEntityDataFactory();
                    if (MyBillsEntityDataFactory == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    booleanRef = booleanRef2;
                    obj = MyBillsEntityDataFactory;
                }
                return Unit.INSTANCE;
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                booleanRef = (Ref.BooleanRef) this.L$1;
                remoteMediatorAccessImpl = (RemoteMediatorAccessImpl) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            final RemoteMediator.MediatorResult mediatorResult = (RemoteMediator.MediatorResult) obj;
            if (mediatorResult instanceof RemoteMediator.MediatorResult.Success) {
                accessorStateHolder3 = remoteMediatorAccessImpl.MyBillsEntityDataFactory;
                booleanValue = ((Boolean) accessorStateHolder3.PlaceComponentResult(new Function1<AccessorState<Key, Value>, Boolean>() { // from class: androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Boolean invoke(Object obj2) {
                        return invoke((AccessorState) ((AccessorState) obj2));
                    }

                    public final Boolean invoke(AccessorState<Key, Value> accessorState) {
                        Intrinsics.checkNotNullParameter(accessorState, "");
                        LoadType loadType2 = LoadType.REFRESH;
                        Intrinsics.checkNotNullParameter(loadType2, "");
                        CollectionsKt.removeAll((List) accessorState.getAuthRequestContext, (Function1) new AccessorState$clearPendingRequest$1(loadType2));
                        if (((RemoteMediator.MediatorResult.Success) RemoteMediator.MediatorResult.this).getGetAuthRequestContext()) {
                            LoadType loadType3 = LoadType.REFRESH;
                            AccessorState.BlockState blockState = AccessorState.BlockState.COMPLETED;
                            Intrinsics.checkNotNullParameter(loadType3, "");
                            Intrinsics.checkNotNullParameter(blockState, "");
                            accessorState.MyBillsEntityDataFactory[loadType3.ordinal()] = blockState;
                            LoadType loadType4 = LoadType.PREPEND;
                            AccessorState.BlockState blockState2 = AccessorState.BlockState.COMPLETED;
                            Intrinsics.checkNotNullParameter(loadType4, "");
                            Intrinsics.checkNotNullParameter(blockState2, "");
                            accessorState.MyBillsEntityDataFactory[loadType4.ordinal()] = blockState2;
                            LoadType loadType5 = LoadType.APPEND;
                            AccessorState.BlockState blockState3 = AccessorState.BlockState.COMPLETED;
                            Intrinsics.checkNotNullParameter(loadType5, "");
                            Intrinsics.checkNotNullParameter(blockState3, "");
                            accessorState.MyBillsEntityDataFactory[loadType5.ordinal()] = blockState3;
                            accessorState.getAuthRequestContext.clear();
                        } else {
                            LoadType loadType6 = LoadType.PREPEND;
                            AccessorState.BlockState blockState4 = AccessorState.BlockState.UNBLOCKED;
                            Intrinsics.checkNotNullParameter(loadType6, "");
                            Intrinsics.checkNotNullParameter(blockState4, "");
                            accessorState.MyBillsEntityDataFactory[loadType6.ordinal()] = blockState4;
                            LoadType loadType7 = LoadType.APPEND;
                            AccessorState.BlockState blockState5 = AccessorState.BlockState.UNBLOCKED;
                            Intrinsics.checkNotNullParameter(loadType7, "");
                            Intrinsics.checkNotNullParameter(blockState5, "");
                            accessorState.MyBillsEntityDataFactory[loadType7.ordinal()] = blockState5;
                        }
                        LoadType loadType8 = LoadType.PREPEND;
                        Intrinsics.checkNotNullParameter(loadType8, "");
                        accessorState.PlaceComponentResult[loadType8.ordinal()] = null;
                        LoadType loadType9 = LoadType.APPEND;
                        Intrinsics.checkNotNullParameter(loadType9, "");
                        accessorState.PlaceComponentResult[loadType9.ordinal()] = null;
                        return Boolean.valueOf(accessorState.getAuthRequestContext() != null);
                    }
                })).booleanValue();
            } else if (mediatorResult instanceof RemoteMediator.MediatorResult.Error) {
                accessorStateHolder2 = remoteMediatorAccessImpl.MyBillsEntityDataFactory;
                booleanValue = ((Boolean) accessorStateHolder2.PlaceComponentResult(new Function1<AccessorState<Key, Value>, Boolean>() { // from class: androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1$1$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Boolean invoke(Object obj2) {
                        return invoke((AccessorState) ((AccessorState) obj2));
                    }

                    public final Boolean invoke(AccessorState<Key, Value> accessorState) {
                        Intrinsics.checkNotNullParameter(accessorState, "");
                        LoadType loadType2 = LoadType.REFRESH;
                        Intrinsics.checkNotNullParameter(loadType2, "");
                        CollectionsKt.removeAll((List) accessorState.getAuthRequestContext, (Function1) new AccessorState$clearPendingRequest$1(loadType2));
                        LoadType loadType3 = LoadType.REFRESH;
                        LoadState.Error error = new LoadState.Error(((RemoteMediator.MediatorResult.Error) RemoteMediator.MediatorResult.this).PlaceComponentResult);
                        Intrinsics.checkNotNullParameter(loadType3, "");
                        accessorState.PlaceComponentResult[loadType3.ordinal()] = error;
                        return Boolean.valueOf(accessorState.getAuthRequestContext() != null);
                    }
                })).booleanValue();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            booleanRef.element = booleanValue;
            return Unit.INSTANCE;
        }
    }
}
