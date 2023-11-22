package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0003\u000b\f\rB\u0011\b\u0004\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\u000e\u000f\u0010"}, d2 = {"Landroidx/paging/LoadState;", "", "", "BuiltInFictitiousFunctionClassFactory", "Z", "getAuthRequestContext", "()Z", "MyBillsEntityDataFactory", "p0", "<init>", "(Z)V", "Error", "Loading", "NotLoading", "Landroidx/paging/LoadState$NotLoading;", "Landroidx/paging/LoadState$Loading;", "Landroidx/paging/LoadState$Error;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public abstract class LoadState {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final boolean MyBillsEntityDataFactory;

    public /* synthetic */ LoadState(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(z);
    }

    private LoadState(boolean z) {
        this.MyBillsEntityDataFactory = z;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/paging/LoadState$NotLoading;", "Landroidx/paging/LoadState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "<init>", "(Z)V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class NotLoading extends LoadState {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final NotLoading KClassImpl$Data$declaredNonStaticMembers$2 = new NotLoading(true);
        private static final NotLoading getAuthRequestContext = new NotLoading(false);

        public NotLoading(boolean z) {
            super(z, null);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NotLoading(endOfPaginationReached=");
            sb.append(getMyBillsEntityDataFactory());
            sb.append(')');
            return sb.toString();
        }

        public final boolean equals(Object p0) {
            return (p0 instanceof NotLoading) && getMyBillsEntityDataFactory() == ((NotLoading) p0).getMyBillsEntityDataFactory();
        }

        public final int hashCode() {
            return LoadState$Error$$ExternalSyntheticBackport0.BuiltInFictitiousFunctionClassFactory(getMyBillsEntityDataFactory());
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0005\u001a\u00020\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006"}, d2 = {"Landroidx/paging/LoadState$NotLoading$Companion;", "", "Landroidx/paging/LoadState$NotLoading;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/paging/LoadState$NotLoading;", "BuiltInFictitiousFunctionClassFactory", "()Landroidx/paging/LoadState$NotLoading;", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
            public static NotLoading BuiltInFictitiousFunctionClassFactory() {
                return NotLoading.KClassImpl$Data$declaredNonStaticMembers$2;
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/paging/LoadState$Loading;", "Landroidx/paging/LoadState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Loading extends LoadState {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(false, null);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Loading(endOfPaginationReached=");
            sb.append(getMyBillsEntityDataFactory());
            sb.append(')');
            return sb.toString();
        }

        public final boolean equals(Object p0) {
            return (p0 instanceof Loading) && getMyBillsEntityDataFactory() == ((Loading) p0).getMyBillsEntityDataFactory();
        }

        public final int hashCode() {
            return LoadState$Error$$ExternalSyntheticBackport0.BuiltInFictitiousFunctionClassFactory(getMyBillsEntityDataFactory());
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Landroidx/paging/LoadState$Error;", "Landroidx/paging/LoadState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "MyBillsEntityDataFactory", "Ljava/lang/Throwable;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Error extends LoadState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final Throwable KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Throwable th) {
            super(false, null);
            Intrinsics.checkNotNullParameter(th, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = th;
        }

        public final boolean equals(Object p0) {
            if (p0 instanceof Error) {
                Error error = (Error) p0;
                if (getMyBillsEntityDataFactory() == error.getMyBillsEntityDataFactory() && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, error.KClassImpl$Data$declaredNonStaticMembers$2)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return LoadState$Error$$ExternalSyntheticBackport0.BuiltInFictitiousFunctionClassFactory(getMyBillsEntityDataFactory()) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Error(endOfPaginationReached=");
            sb.append(getMyBillsEntityDataFactory());
            sb.append(", error=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(')');
            return sb.toString();
        }
    }
}
