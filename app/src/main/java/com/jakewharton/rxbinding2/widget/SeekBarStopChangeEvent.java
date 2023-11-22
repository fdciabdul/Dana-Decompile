package com.jakewharton.rxbinding2.widget;

import android.widget.SeekBar;

/* loaded from: classes8.dex */
public abstract class SeekBarStopChangeEvent extends SeekBarChangeEvent {
    public static SeekBarStopChangeEvent create(SeekBar seekBar) {
        return new AutoValue_SeekBarStopChangeEvent(seekBar);
    }
}
