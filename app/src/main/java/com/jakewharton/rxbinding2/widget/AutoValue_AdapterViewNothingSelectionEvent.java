package com.jakewharton.rxbinding2.widget;

import android.widget.AdapterView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class AutoValue_AdapterViewNothingSelectionEvent extends AdapterViewNothingSelectionEvent {
    private final AdapterView<?> view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_AdapterViewNothingSelectionEvent(AdapterView<?> adapterView) {
        if (adapterView == null) {
            throw new NullPointerException("Null view");
        }
        this.view = adapterView;
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewSelectionEvent
    public final AdapterView<?> view() {
        return this.view;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdapterViewNothingSelectionEvent{view=");
        sb.append(this.view);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AdapterViewNothingSelectionEvent) {
            return this.view.equals(((AdapterViewNothingSelectionEvent) obj).view());
        }
        return false;
    }

    public final int hashCode() {
        return this.view.hashCode() ^ 1000003;
    }
}
