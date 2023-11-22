package com.jakewharton.rxbinding2.view;

import android.view.View;

/* loaded from: classes8.dex */
final class AutoValue_ViewAttachAttachedEvent extends ViewAttachAttachedEvent {
    private final View view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ViewAttachAttachedEvent(View view) {
        if (view == null) {
            throw new NullPointerException("Null view");
        }
        this.view = view;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewAttachEvent
    public final View view() {
        return this.view;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ViewAttachAttachedEvent{view=");
        sb.append(this.view);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ViewAttachAttachedEvent) {
            return this.view.equals(((ViewAttachAttachedEvent) obj).view());
        }
        return false;
    }

    public final int hashCode() {
        return this.view.hashCode() ^ 1000003;
    }
}
