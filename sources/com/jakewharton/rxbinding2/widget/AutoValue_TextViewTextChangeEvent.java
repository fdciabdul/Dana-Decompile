package com.jakewharton.rxbinding2.widget;

import android.widget.TextView;

/* loaded from: classes3.dex */
final class AutoValue_TextViewTextChangeEvent extends TextViewTextChangeEvent {
    private final int before;
    private final int count;
    private final int start;
    private final CharSequence text;
    private final TextView view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_TextViewTextChangeEvent(TextView textView, CharSequence charSequence, int i, int i2, int i3) {
        if (textView == null) {
            throw new NullPointerException("Null view");
        }
        this.view = textView;
        if (charSequence == null) {
            throw new NullPointerException("Null text");
        }
        this.text = charSequence;
        this.start = i;
        this.before = i2;
        this.count = i3;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent
    public final TextView view() {
        return this.view;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent
    public final CharSequence text() {
        return this.text;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent
    public final int start() {
        return this.start;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent
    public final int before() {
        return this.before;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent
    public final int count() {
        return this.count;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TextViewTextChangeEvent{view=");
        sb.append(this.view);
        sb.append(", text=");
        sb.append((Object) this.text);
        sb.append(", start=");
        sb.append(this.start);
        sb.append(", before=");
        sb.append(this.before);
        sb.append(", count=");
        sb.append(this.count);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TextViewTextChangeEvent) {
            TextViewTextChangeEvent textViewTextChangeEvent = (TextViewTextChangeEvent) obj;
            return this.view.equals(textViewTextChangeEvent.view()) && this.text.equals(textViewTextChangeEvent.text()) && this.start == textViewTextChangeEvent.start() && this.before == textViewTextChangeEvent.before() && this.count == textViewTextChangeEvent.count();
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.view.hashCode();
        int hashCode2 = this.text.hashCode();
        return ((((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ this.start) * 1000003) ^ this.before) * 1000003) ^ this.count;
    }
}
