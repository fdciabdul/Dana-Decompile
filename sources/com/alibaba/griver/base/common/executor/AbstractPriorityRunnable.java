package com.alibaba.griver.base.common.executor;

/* loaded from: classes3.dex */
public abstract class AbstractPriorityRunnable implements Comparable<AbstractPriorityRunnable>, Runnable {
    public static final int MAX_PRIORITY = 10;
    public static final int MIN_PRIORITY = 1;
    public static final int NORMAL_PRIORITY = 5;
    int priority;

    public abstract void runTask();

    public AbstractPriorityRunnable(int i) {
        this.priority = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(AbstractPriorityRunnable abstractPriorityRunnable) {
        int i;
        int i2;
        if (abstractPriorityRunnable != null && (i = this.priority) <= (i2 = abstractPriorityRunnable.priority)) {
            return i == i2 ? 0 : -1;
        }
        return 1;
    }

    @Override // java.lang.Runnable
    public void run() {
        runTask();
    }
}
