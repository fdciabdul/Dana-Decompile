package com.apiguard3.internal;

import id.dana.cashier.view.InputCardNumberView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
public class RB<T> implements Serializable {
    private static final long serialVersionUID = 5376938948150806962L;
    private static int valueOf = 0;
    private static int values = 1;
    private final LinkedList<T> list;
    private int maxSize;
    private final Lock readLock;
    private final ReentrantReadWriteLock readWriteLock;
    private final Lock writeLock;

    public RB(int i) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(false);
        this.readWriteLock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.maxSize = i;
        this.list = new LinkedList<>();
    }

    public final boolean APIGuard(T t) {
        try {
            this.writeLock.lock();
            boolean add = this.list.add(t);
            if (this.list.size() > this.maxSize) {
                int i = values + 73;
                valueOf = i % 128;
                if (i % 2 != 0) {
                }
                this.list.remove(0);
            }
            this.writeLock.unlock();
            int i2 = valueOf + 19;
            values = i2 % 128;
            if (!(i2 % 2 == 0)) {
                return add;
            }
            throw new NullPointerException();
        } catch (Throwable th) {
            this.writeLock.unlock();
            throw th;
        }
    }

    public final int values() {
        int i = values + 97;
        valueOf = i % 128;
        try {
            if ((i % 2 != 0 ? Typography.greater : InputCardNumberView.DIVIDER) == ' ') {
                this.readLock.lock();
                return this.list.size();
            }
            this.readLock.lock();
            this.list.size();
            throw new NullPointerException();
        } finally {
            this.readLock.unlock();
        }
    }

    public final void AGState() {
        int i = valueOf + 109;
        values = i % 128;
        try {
            if ((i % 2 == 0 ? Typography.dollar : '(') != '$') {
                this.writeLock.lock();
                this.list.clear();
                return;
            }
            this.writeLock.lock();
            this.list.clear();
            this.writeLock.unlock();
            throw null;
        } finally {
            this.writeLock.unlock();
        }
    }

    public final boolean APIGuard() {
        int i = values + 113;
        valueOf = i % 128;
        try {
            if ((i % 2 != 0 ? (char) 30 : 'a') == 'a') {
                this.readLock.lock();
                boolean z = false;
                if ((this.list.size() >= this.maxSize ? (char) 0 : ';') != ';') {
                    valueOf = (values + 99) % 128;
                    z = true;
                } else {
                    values = (valueOf + 43) % 128;
                }
                return z;
            }
            this.readLock.lock();
            this.list.size();
            throw new ArithmeticException();
        } finally {
            this.readLock.unlock();
        }
    }

    public final List<T> getSharedInstance() {
        try {
            this.readLock.lock();
            ArrayList arrayList = new ArrayList(this.list);
            this.readLock.unlock();
            valueOf = (values + 75) % 128;
            return arrayList;
        } catch (Throwable th) {
            this.readLock.unlock();
            throw th;
        }
    }

    public final void AGState(int i) {
        values = (valueOf + 77) % 128;
        try {
            this.writeLock.lock();
            int i2 = this.maxSize;
            if ((i != i2) && i > 0) {
                if (i < i2) {
                    Iterator<T> it = this.list.iterator();
                    int i3 = 0;
                    while (it.hasNext()) {
                        if (!(i3 < i2 - i)) {
                            break;
                        }
                        values = (valueOf + 55) % 128;
                        it.next();
                        it.remove();
                        i3++;
                    }
                }
                this.maxSize = i;
            }
        } finally {
            this.writeLock.unlock();
        }
    }

    public final boolean valueOf() {
        int i = values + 89;
        valueOf = i % 128;
        try {
            if (i % 2 == 0) {
                this.readLock.lock();
                boolean z = false;
                if (!(values() != 0)) {
                    valueOf = (values + 1) % 128;
                    z = true;
                }
                return z;
            }
            this.readLock.lock();
            values();
            throw null;
        } finally {
            this.readLock.unlock();
        }
    }
}
