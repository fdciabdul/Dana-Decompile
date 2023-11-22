package id.dana.sync_engine.exception;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0007\n\u000b\f\r\u000e\u000f\u0010B\u0011\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00038\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0007\u0011\u0012\u0013\u0014\u0015\u0016\u0017"}, d2 = {"Lid/dana/sync_engine/exception/SyncEngineException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "CompleteBatchSync", "ContactNotFound", "NoAllowReSyncContact", "NoContactLeft", "NoContactPermission", "SyncContactDisable", "UserSessionIsRequired", "Lid/dana/sync_engine/exception/SyncEngineException$NoContactPermission;", "Lid/dana/sync_engine/exception/SyncEngineException$ContactNotFound;", "Lid/dana/sync_engine/exception/SyncEngineException$SyncContactDisable;", "Lid/dana/sync_engine/exception/SyncEngineException$NoContactLeft;", "Lid/dana/sync_engine/exception/SyncEngineException$UserSessionIsRequired;", "Lid/dana/sync_engine/exception/SyncEngineException$CompleteBatchSync;", "Lid/dana/sync_engine/exception/SyncEngineException$NoAllowReSyncContact;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class SyncEngineException extends Exception {
    private final String message;

    public /* synthetic */ SyncEngineException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private SyncEngineException(String str) {
        super(str);
        this.message = str;
    }

    @Override // java.lang.Throwable
    @JvmName(name = "getMessage")
    public String getMessage() {
        return this.message;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sync_engine/exception/SyncEngineException$NoContactPermission;", "Lid/dana/sync_engine/exception/SyncEngineException;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class NoContactPermission extends SyncEngineException {
        public static final NoContactPermission INSTANCE = new NoContactPermission();

        private NoContactPermission() {
            super("Required read contact permission", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sync_engine/exception/SyncEngineException$ContactNotFound;", "Lid/dana/sync_engine/exception/SyncEngineException;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ContactNotFound extends SyncEngineException {
        public static final ContactNotFound INSTANCE = new ContactNotFound();

        private ContactNotFound() {
            super("User contact not found", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sync_engine/exception/SyncEngineException$SyncContactDisable;", "Lid/dana/sync_engine/exception/SyncEngineException;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class SyncContactDisable extends SyncEngineException {
        public static final SyncContactDisable INSTANCE = new SyncContactDisable();

        private SyncContactDisable() {
            super("Sync to server is disable", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sync_engine/exception/SyncEngineException$NoContactLeft;", "Lid/dana/sync_engine/exception/SyncEngineException;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class NoContactLeft extends SyncEngineException {
        public static final NoContactLeft INSTANCE = new NoContactLeft();

        private NoContactLeft() {
            super("No contact left for sync", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sync_engine/exception/SyncEngineException$UserSessionIsRequired;", "Lid/dana/sync_engine/exception/SyncEngineException;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class UserSessionIsRequired extends SyncEngineException {
        public static final UserSessionIsRequired INSTANCE = new UserSessionIsRequired();

        private UserSessionIsRequired() {
            super("User session is required", null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004"}, d2 = {"Lid/dana/sync_engine/exception/SyncEngineException$CompleteBatchSync;", "Lid/dana/sync_engine/exception/SyncEngineException;", "", "component1", "()I", "count", "copy", "(I)Lid/dana/sync_engine/exception/SyncEngineException$CompleteBatchSync;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getCount", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class CompleteBatchSync extends SyncEngineException {
        private final int count;

        public static /* synthetic */ CompleteBatchSync copy$default(CompleteBatchSync completeBatchSync, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = completeBatchSync.count;
            }
            return completeBatchSync.copy(i);
        }

        /* renamed from: component1  reason: from getter */
        public final int getCount() {
            return this.count;
        }

        public final CompleteBatchSync copy(int count) {
            return new CompleteBatchSync(count);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CompleteBatchSync) && this.count == ((CompleteBatchSync) other).count;
        }

        public final int hashCode() {
            return this.count;
        }

        @Override // java.lang.Throwable
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CompleteBatchSync(count=");
            sb.append(this.count);
            sb.append(')');
            return sb.toString();
        }

        public CompleteBatchSync(int i) {
            super("No contact left for sync", null);
            this.count = i;
        }

        @JvmName(name = "getCount")
        public final int getCount() {
            return this.count;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sync_engine/exception/SyncEngineException$NoAllowReSyncContact;", "Lid/dana/sync_engine/exception/SyncEngineException;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class NoAllowReSyncContact extends SyncEngineException {
        public static final NoAllowReSyncContact INSTANCE = new NoAllowReSyncContact();

        private NoAllowReSyncContact() {
            super("No allow re-sync contact", null);
        }
    }
}
