package com.jakewharton.rxbinding2.widget;

import android.widget.TextView;

/* loaded from: classes8.dex */
final class AutoValue_TextViewBeforeTextChangeEvent extends TextViewBeforeTextChangeEvent {
    private final int after;
    private final int count;
    private final int start;
    private final CharSequence text;
    private final TextView view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_TextViewBeforeTextChangeEvent(TextView textView, CharSequence charSequence, int i, int i2, int i3) {
        if (textView == null) {
            throw new NullPointerException("Null view");
        }
        this.view = textView;
        if (charSequence == null) {
            throw new NullPointerException("Null text");
        }
        this.text = charSequence;
        this.start = i;
        this.count = i2;
        this.after = i3;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewBeforeTextChangeEvent
    public final TextView view() {
        return this.view;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewBeforeTextChangeEvent
    public final CharSequence text() {
        return this.text;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewBeforeTextChangeEvent
    public final int start() {
        return this.start;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewBeforeTextChangeEvent
    public final int count() {
        return this.count;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewBeforeTextChangeEvent
    public final int after() {
        return this.after;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TextViewBeforeTextChangeEvent{view=");
        sb.append(this.view);
        sb.append(", text=");
        sb.append((Object) this.text);
        sb.append(", start=");
        sb.append(this.start);
        sb.append(", count=");
        sb.append(this.count);
        sb.append(", after=");
        sb.append(this.after);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TextViewBeforeTextChangeEvent) {
            TextViewBeforeTextChangeEvent textViewBeforeTextChangeEvent = (TextViewBeforeTextChangeEvent) obj;
            return this.view.equals(textViewBeforeTextChangeEvent.view()) && this.text.equals(textViewBeforeTextChangeEvent.text()) && this.start == textViewBeforeTextChangeEvent.start() && this.count == textViewBeforeTextChangeEvent.count() && this.after == textViewBeforeTextChangeEvent.after();
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.view.hashCode();
        int hashCode2 = this.text.hashCode();
        return ((((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ this.start) * 1000003) ^ this.count) * 1000003) ^ this.after;
    }
}
