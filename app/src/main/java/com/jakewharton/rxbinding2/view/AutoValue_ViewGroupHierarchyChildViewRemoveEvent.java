package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes8.dex */
final class AutoValue_ViewGroupHierarchyChildViewRemoveEvent extends ViewGroupHierarchyChildViewRemoveEvent {
    private final View child;
    private final ViewGroup view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ViewGroupHierarchyChildViewRemoveEvent(ViewGroup viewGroup, View view) {
        if (viewGroup == null) {
            throw new NullPointerException("Null view");
        }
        this.view = viewGroup;
        if (view == null) {
            throw new NullPointerException("Null child");
        }
        this.child = view;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewGroupHierarchyChangeEvent
    public final ViewGroup view() {
        return this.view;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewGroupHierarchyChangeEvent
    public final View child() {
        return this.child;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ViewGroupHierarchyChildViewRemoveEvent{view=");
        sb.append(this.view);
        sb.append(", child=");
        sb.append(this.child);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ViewGroupHierarchyChildViewRemoveEvent) {
            ViewGroupHierarchyChildViewRemoveEvent viewGroupHierarchyChildViewRemoveEvent = (ViewGroupHierarchyChildViewRemoveEvent) obj;
            return this.view.equals(viewGroupHierarchyChildViewRemoveEvent.view()) && this.child.equals(viewGroupHierarchyChildViewRemoveEvent.child());
        }
        return false;
    }

    public final int hashCode() {
        return ((this.view.hashCode() ^ 1000003) * 1000003) ^ this.child.hashCode();
    }
}
