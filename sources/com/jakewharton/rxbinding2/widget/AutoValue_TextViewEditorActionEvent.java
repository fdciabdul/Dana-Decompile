package com.jakewharton.rxbinding2.widget;

import android.view.KeyEvent;
import android.widget.TextView;

/* loaded from: classes8.dex */
final class AutoValue_TextViewEditorActionEvent extends TextViewEditorActionEvent {
    private final int actionId;
    private final KeyEvent keyEvent;
    private final TextView view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_TextViewEditorActionEvent(TextView textView, int i, KeyEvent keyEvent) {
        if (textView == null) {
            throw new NullPointerException("Null view");
        }
        this.view = textView;
        this.actionId = i;
        this.keyEvent = keyEvent;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewEditorActionEvent
    public final TextView view() {
        return this.view;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewEditorActionEvent
    public final int actionId() {
        return this.actionId;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewEditorActionEvent
    public final KeyEvent keyEvent() {
        return this.keyEvent;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TextViewEditorActionEvent{view=");
        sb.append(this.view);
        sb.append(", actionId=");
        sb.append(this.actionId);
        sb.append(", keyEvent=");
        sb.append(this.keyEvent);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TextViewEditorActionEvent) {
            TextViewEditorActionEvent textViewEditorActionEvent = (TextViewEditorActionEvent) obj;
            if (this.view.equals(textViewEditorActionEvent.view()) && this.actionId == textViewEditorActionEvent.actionId()) {
                KeyEvent keyEvent = this.keyEvent;
                if (keyEvent == null) {
                    if (textViewEditorActionEvent.keyEvent() == null) {
                        return true;
                    }
                } else if (keyEvent.equals(textViewEditorActionEvent.keyEvent())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.view.hashCode();
        int i = this.actionId;
        KeyEvent keyEvent = this.keyEvent;
        return ((((hashCode ^ 1000003) * 1000003) ^ i) * 1000003) ^ (keyEvent == null ? 0 : keyEvent.hashCode());
    }
}
