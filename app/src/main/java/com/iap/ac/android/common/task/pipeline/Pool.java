package com.iap.ac.android.common.task.pipeline;

import java.util.ArrayDeque;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class Pool<T> {
    public final ArrayDeque<T> freeObjects;
    public final int max;
    public int peak;

    /* loaded from: classes8.dex */
    public interface Poolable {
        void reset();
    }

    public Pool() {
        this(16, Integer.MAX_VALUE);
    }

    public void clear() {
        this.freeObjects.clear();
    }

    public void free(T t) {
        if (t != null) {
            if (this.freeObjects.size() < this.max) {
                this.freeObjects.add(t);
                this.peak = Math.max(this.peak, this.freeObjects.size());
            }
            if (t instanceof Poolable) {
                ((Poolable) t).reset();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("object cannot be null.");
    }

    public void freeAll(List<T> list) {
        if (list != null) {
            ArrayDeque<T> arrayDeque = this.freeObjects;
            int i = this.max;
            for (int i2 = 0; i2 < list.size(); i2++) {
                T t = list.get(i2);
                if (t != null) {
                    if (arrayDeque.size() < i) {
                        arrayDeque.add(t);
                    }
                    if (t instanceof Poolable) {
                        ((Poolable) t).reset();
                    }
                }
            }
            this.peak = Math.max(this.peak, arrayDeque.size());
            return;
        }
        throw new IllegalArgumentException("object cannot be null.");
    }

    public int getFree() {
        return this.freeObjects.size();
    }

    public abstract T newObject();

    public T obtain() {
        return this.freeObjects.size() == 0 ? newObject() : this.freeObjects.pop();
    }

    public Pool(int i) {
        this(i, Integer.MAX_VALUE);
    }

    public Pool(int i, int i2) {
        this.freeObjects = new ArrayDeque<>(i);
        this.max = i2;
    }
}
