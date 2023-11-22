package com.zhuinden.simplestack;

import com.zhuinden.simplestack.StateChanger;
import java.util.List;

/* loaded from: classes2.dex */
class PendingStateChange {
    StateChanger.Callback completionCallback;
    final int direction;
    final boolean initialization;
    final boolean isForceEnqueued;
    final boolean isTerminal;
    final List<?> newHistory;
    private Status status = Status.ENQUEUED;
    boolean didForceExecute = false;

    /* loaded from: classes2.dex */
    enum Status {
        ENQUEUED,
        IN_PROGRESS,
        COMPLETED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PendingStateChange(List<?> list, int i, boolean z, boolean z2, boolean z3) {
        this.newHistory = list;
        this.direction = i;
        this.initialization = z;
        this.isTerminal = z2;
        this.isForceEnqueued = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Status getStatus() {
        return this.status;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStatus(Status status) {
        if (status == null) {
            throw new NullPointerException("Status of pending state change cannot be null!");
        }
        if (status.ordinal() < this.status.ordinal()) {
            StringBuilder sb = new StringBuilder();
            sb.append("A pending state change cannot go to one of its previous states: [");
            sb.append(this.status);
            sb.append("] to [");
            sb.append(status);
            sb.append("]");
            throw new IllegalStateException(sb.toString());
        }
        this.status = status;
    }
}
