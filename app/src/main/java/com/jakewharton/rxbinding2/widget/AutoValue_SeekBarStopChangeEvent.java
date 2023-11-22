package com.jakewharton.rxbinding2.widget;

import android.widget.SeekBar;

/* loaded from: classes8.dex */
final class AutoValue_SeekBarStopChangeEvent extends SeekBarStopChangeEvent {
    private final SeekBar view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SeekBarStopChangeEvent(SeekBar seekBar) {
        if (seekBar == null) {
            throw new NullPointerException("Null view");
        }
        this.view = seekBar;
    }

    @Override // com.jakewharton.rxbinding2.widget.SeekBarChangeEvent
    public final SeekBar view() {
        return this.view;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SeekBarStopChangeEvent{view=");
        sb.append(this.view);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SeekBarStopChangeEvent) {
            return this.view.equals(((SeekBarStopChangeEvent) obj).view());
        }
        return false;
    }

    public final int hashCode() {
        return this.view.hashCode() ^ 1000003;
    }
}
