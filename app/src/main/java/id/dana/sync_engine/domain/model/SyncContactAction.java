package id.dana.sync_engine.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t"}, d2 = {"Lid/dana/sync_engine/domain/model/SyncContactAction;", "", "<init>", "()V", "Changes", "InsertAll", "SelectAll", "Lid/dana/sync_engine/domain/model/SyncContactAction$InsertAll;", "Lid/dana/sync_engine/domain/model/SyncContactAction$SelectAll;", "Lid/dana/sync_engine/domain/model/SyncContactAction$Changes;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class SyncContactAction {
    public /* synthetic */ SyncContactAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sync_engine/domain/model/SyncContactAction$InsertAll;", "Lid/dana/sync_engine/domain/model/SyncContactAction;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class InsertAll extends SyncContactAction {
        public static final InsertAll INSTANCE = new InsertAll();

        private InsertAll() {
            super(null);
        }
    }

    private SyncContactAction() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sync_engine/domain/model/SyncContactAction$SelectAll;", "Lid/dana/sync_engine/domain/model/SyncContactAction;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class SelectAll extends SyncContactAction {
        public static final SelectAll INSTANCE = new SelectAll();

        private SelectAll() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sync_engine/domain/model/SyncContactAction$Changes;", "Lid/dana/sync_engine/domain/model/SyncContactAction;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Changes extends SyncContactAction {
        public static final Changes INSTANCE = new Changes();

        private Changes() {
            super(null);
        }
    }
}
