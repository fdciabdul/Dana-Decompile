package androidx.paging;

import androidx.paging.RemoteMediator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004J\u0013\u0010\u0006\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8'X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/RemoteMediatorAccessor;", "", "Key", "Value", "Landroidx/paging/RemoteMediatorConnection;", "Landroidx/paging/RemoteMediator$InitializeAction;", "MyBillsEntityDataFactory", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/StateFlow;", "Landroidx/paging/LoadStates;", "getAuthRequestContext", "()Lkotlinx/coroutines/flow/StateFlow;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface RemoteMediatorAccessor<Key, Value> extends RemoteMediatorConnection<Key, Value> {
    Object MyBillsEntityDataFactory(Continuation<? super RemoteMediator.InitializeAction> continuation);

    @JvmName(name = "getAuthRequestContext")
    StateFlow<LoadStates> getAuthRequestContext();
}
