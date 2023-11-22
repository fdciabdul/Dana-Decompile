package com.google.firebase.perf.util;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class Timer implements Parcelable {
    public static final Parcelable.Creator<Timer> CREATOR = new Parcelable.Creator<Timer>() { // from class: com.google.firebase.perf.util.Timer.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Timer createFromParcel(Parcel parcel) {
            return new Timer(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Timer[] newArray(int i) {
            return new Timer[i];
        }
    };
    private long highResTime;
    private long timeInMicros;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Timer() {
        this.timeInMicros = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.highResTime = System.nanoTime();
    }

    public Timer(long j) {
        this.timeInMicros = j;
        this.highResTime = TimeUnit.MICROSECONDS.toNanos(j);
    }

    public Timer(long j, long j2) {
        this.timeInMicros = j;
        this.highResTime = j2;
    }

    private Timer(Parcel parcel) {
        this.timeInMicros = parcel.readLong();
        this.highResTime = parcel.readLong();
    }

    public void reset() {
        this.timeInMicros = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.highResTime = System.nanoTime();
    }

    public long getMicros() {
        return this.timeInMicros;
    }

    public long getDurationMicros() {
        return TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - this.highResTime);
    }

    public long getDurationMicros(Timer timer) {
        return TimeUnit.NANOSECONDS.toMicros(timer.highResTime - this.highResTime);
    }

    public long getCurrentTimestampMicros() {
        return this.timeInMicros + getDurationMicros();
    }

    public long getHighResTime() {
        return TimeUnit.NANOSECONDS.toMicros(this.highResTime);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.timeInMicros);
        parcel.writeLong(this.highResTime);
    }
}
