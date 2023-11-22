package com.jakewharton.rxbinding2.widget;

import android.widget.SeekBar;

/* loaded from: classes8.dex */
final class AutoValue_SeekBarProgressChangeEvent extends SeekBarProgressChangeEvent {
    private final boolean fromUser;
    private final int progress;
    private final SeekBar view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SeekBarProgressChangeEvent(SeekBar seekBar, int i, boolean z) {
        if (seekBar == null) {
            throw new NullPointerException("Null view");
        }
        this.view = seekBar;
        this.progress = i;
        this.fromUser = z;
    }

    @Override // com.jakewharton.rxbinding2.widget.SeekBarChangeEvent
    public final SeekBar view() {
        return this.view;
    }

    @Override // com.jakewharton.rxbinding2.widget.SeekBarProgressChangeEvent
    public final int progress() {
        return this.progress;
    }

    @Override // com.jakewharton.rxbinding2.widget.SeekBarProgressChangeEvent
    public final boolean fromUser() {
        return this.fromUser;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SeekBarProgressChangeEvent{view=");
        sb.append(this.view);
        sb.append(", progress=");
        sb.append(this.progress);
        sb.append(", fromUser=");
        sb.append(this.fromUser);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SeekBarProgressChangeEvent) {
            SeekBarProgressChangeEvent seekBarProgressChangeEvent = (SeekBarProgressChangeEvent) obj;
            return this.view.equals(seekBarProgressChangeEvent.view()) && this.progress == seekBarProgressChangeEvent.progress() && this.fromUser == seekBarProgressChangeEvent.fromUser();
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.view.hashCode();
        return ((((hashCode ^ 1000003) * 1000003) ^ this.progress) * 1000003) ^ (this.fromUser ? 1231 : 1237);
    }
}
