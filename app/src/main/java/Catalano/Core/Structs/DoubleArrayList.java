package Catalano.Core.Structs;

import java.io.Serializable;

/* loaded from: classes6.dex */
public final class DoubleArrayList implements Serializable {
    private static final int DEFAULT_CAPACITY = 10;
    private double[] data;
    private int size;

    public DoubleArrayList() {
        this(10);
    }

    public DoubleArrayList(int i) {
        this.data = new double[i];
        this.size = 0;
    }

    public DoubleArrayList(double[] dArr) {
        this(Math.max(dArr.length, 10));
        add(dArr);
    }

    public final void ensureCapacity(int i) {
        double[] dArr = this.data;
        if (i > dArr.length) {
            double[] dArr2 = new double[Math.max(dArr.length << 1, i)];
            double[] dArr3 = this.data;
            System.arraycopy(dArr3, 0, dArr2, 0, dArr3.length);
            this.data = dArr2;
        }
    }

    public final int size() {
        return this.size;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final void trimToSize() {
        if (this.data.length > size()) {
            this.data = toArray();
        }
    }

    public final void add(double d) {
        ensureCapacity(this.size + 1);
        double[] dArr = this.data;
        int i = this.size;
        this.size = i + 1;
        dArr[i] = d;
    }

    public final void add(double[] dArr) {
        ensureCapacity(this.size + dArr.length);
        System.arraycopy(dArr, 0, this.data, this.size, dArr.length);
        this.size += dArr.length;
    }

    public final double get(int i) {
        return this.data[i];
    }

    public final void set(int i, double d) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }
        this.data[i] = d;
    }

    public final void clear() {
        this.size = 0;
    }

    public final double remove(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }
        double d = get(i);
        if (i == 0) {
            double[] dArr = this.data;
            System.arraycopy(dArr, 1, dArr, 0, this.size - 1);
        } else {
            int i2 = this.size;
            if (i2 - 1 != i) {
                double[] dArr2 = this.data;
                int i3 = i + 1;
                System.arraycopy(dArr2, i3, dArr2, i, i2 - i3);
            }
        }
        this.size--;
        return d;
    }

    public final double[] toArray() {
        return toArray(null);
    }

    public final double[] toArray(double[] dArr) {
        if (dArr == null || dArr.length < size()) {
            dArr = new double[this.size];
        }
        System.arraycopy(this.data, 0, dArr, 0, this.size);
        return dArr;
    }
}
