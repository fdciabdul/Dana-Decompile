package com.jakewharton.rxbinding2.widget;

import android.text.Editable;
import android.widget.TextView;

/* loaded from: classes8.dex */
final class AutoValue_TextViewAfterTextChangeEvent extends TextViewAfterTextChangeEvent {
    private final Editable editable;
    private final TextView view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_TextViewAfterTextChangeEvent(TextView textView, Editable editable) {
        if (textView == null) {
            throw new NullPointerException("Null view");
        }
        this.view = textView;
        this.editable = editable;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent
    public final TextView view() {
        return this.view;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent
    public final Editable editable() {
        return this.editable;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TextViewAfterTextChangeEvent{view=");
        sb.append(this.view);
        sb.append(", editable=");
        sb.append((Object) this.editable);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TextViewAfterTextChangeEvent) {
            TextViewAfterTextChangeEvent textViewAfterTextChangeEvent = (TextViewAfterTextChangeEvent) obj;
            if (this.view.equals(textViewAfterTextChangeEvent.view())) {
                Editable editable = this.editable;
                if (editable == null) {
                    if (textViewAfterTextChangeEvent.editable() == null) {
                        return true;
                    }
                } else if (editable.equals(textViewAfterTextChangeEvent.editable())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.view.hashCode();
        Editable editable = this.editable;
        return ((hashCode ^ 1000003) * 1000003) ^ (editable == null ? 0 : editable.hashCode());
    }
}
