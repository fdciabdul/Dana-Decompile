package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class Counter implements Parcelable {
    public static final Parcelable.Creator<Counter> CREATOR = new Parcelable.Creator<Counter>() { // from class: com.google.firebase.perf.metrics.Counter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Counter createFromParcel(Parcel parcel) {
            return new Counter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Counter[] newArray(int i) {
            return new Counter[i];
        }
    };
    private final AtomicLong count;
    private final String name;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Counter(String str) {
        this.name = str;
        this.count = new AtomicLong(0L);
    }

    private Counter(Parcel parcel) {
        this.name = parcel.readString();
        this.count = new AtomicLong(parcel.readLong());
    }

    public void increment(long j) {
        this.count.addAndGet(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.name;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getCount() {
        return this.count.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCount(long j) {
        this.count.set(j);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeLong(this.count.get());
    }
}
