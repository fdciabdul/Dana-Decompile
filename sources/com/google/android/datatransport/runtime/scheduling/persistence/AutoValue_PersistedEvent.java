package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class AutoValue_PersistedEvent extends PersistedEvent {
    private final EventInternal event;

    /* renamed from: id  reason: collision with root package name */
    private final long f7432id;
    private final TransportContext transportContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_PersistedEvent(long j, TransportContext transportContext, EventInternal eventInternal) {
        this.f7432id = j;
        if (transportContext == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.transportContext = transportContext;
        if (eventInternal == null) {
            throw new NullPointerException("Null event");
        }
        this.event = eventInternal;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public final long getId() {
        return this.f7432id;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public final TransportContext getTransportContext() {
        return this.transportContext;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public final EventInternal getEvent() {
        return this.event;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PersistedEvent{id=");
        sb.append(this.f7432id);
        sb.append(", transportContext=");
        sb.append(this.transportContext);
        sb.append(", event=");
        sb.append(this.event);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PersistedEvent) {
            PersistedEvent persistedEvent = (PersistedEvent) obj;
            return this.f7432id == persistedEvent.getId() && this.transportContext.equals(persistedEvent.getTransportContext()) && this.event.equals(persistedEvent.getEvent());
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f7432id;
        int i = (int) (j ^ (j >>> 32));
        return ((this.transportContext.hashCode() ^ ((i ^ 1000003) * 1000003)) * 1000003) ^ this.event.hashCode();
    }
}
