package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@ExperimentalPagingApi
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0005\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH¦@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/RemoteMediator;", "", "Key", "Value", "Landroidx/paging/RemoteMediator$InitializeAction;", "getAuthRequestContext", "()Ljava/lang/Object;", "Landroidx/paging/LoadType;", "p0", "Landroidx/paging/PagingState;", "p1", "Landroidx/paging/RemoteMediator$MediatorResult;", "MyBillsEntityDataFactory", "<init>", "()V", "InitializeAction", "MediatorResult"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class RemoteMediator<Key, Value> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005"}, d2 = {"Landroidx/paging/RemoteMediator$InitializeAction;", "", "<init>", "(Ljava/lang/String;I)V", "LAUNCH_INITIAL_REFRESH", "SKIP_INITIAL_REFRESH"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public enum InitializeAction {
        LAUNCH_INITIAL_REFRESH,
        SKIP_INITIAL_REFRESH
    }

    public abstract Object MyBillsEntityDataFactory();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007"}, d2 = {"Landroidx/paging/RemoteMediator$MediatorResult;", "", "<init>", "()V", "Error", "Success", "Landroidx/paging/RemoteMediator$MediatorResult$Error;", "Landroidx/paging/RemoteMediator$MediatorResult$Success;"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class MediatorResult {

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/paging/RemoteMediator$MediatorResult$Error;", "Landroidx/paging/RemoteMediator$MediatorResult;", "", "getAuthRequestContext", "Ljava/lang/Throwable;", "PlaceComponentResult"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Error extends MediatorResult {

            /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
            final Throwable PlaceComponentResult;
        }

        private MediatorResult() {
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/paging/RemoteMediator$MediatorResult$Success;", "Landroidx/paging/RemoteMediator$MediatorResult;", "", "MyBillsEntityDataFactory", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "getAuthRequestContext"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Success extends MediatorResult {

            /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
            private final boolean getAuthRequestContext;

            @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
            public final boolean getGetAuthRequestContext() {
                return this.getAuthRequestContext;
            }
        }
    }

    public static Object getAuthRequestContext() {
        return InitializeAction.LAUNCH_INITIAL_REFRESH;
    }
}
