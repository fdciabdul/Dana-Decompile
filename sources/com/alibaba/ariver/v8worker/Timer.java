package com.alibaba.ariver.v8worker;

import java.util.Date;

/* loaded from: classes6.dex */
public class Timer {
    private static long timerId;
    private final FinalizerHelper finalizer;
    private final TimerImpl impl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class TimerImpl extends Thread {
        private boolean cancelled;
        private boolean finished;
        private volatile boolean suspended = false;
        private TimerHeap tasks = new TimerHeap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public static final class TimerHeap {
            private int DEFAULT_HEAP_SIZE;
            private int deletedCancelledNumber;
            private int size;
            private TimerTask[] timers;

            private TimerHeap() {
                this.DEFAULT_HEAP_SIZE = 256;
                this.timers = new TimerTask[256];
                this.size = 0;
                this.deletedCancelledNumber = 0;
            }

            public final TimerTask minimum() {
                return this.timers[0];
            }

            public final boolean isEmpty() {
                return this.size == 0;
            }

            public final void insert(TimerTask timerTask) {
                TimerTask[] timerTaskArr = this.timers;
                int length = timerTaskArr.length;
                int i = this.size;
                if (length == i) {
                    TimerTask[] timerTaskArr2 = new TimerTask[i * 2];
                    System.arraycopy(timerTaskArr, 0, timerTaskArr2, 0, i);
                    this.timers = timerTaskArr2;
                }
                TimerTask[] timerTaskArr3 = this.timers;
                int i2 = this.size;
                this.size = i2 + 1;
                timerTaskArr3[i2] = timerTask;
                upHeap();
            }

            public final void delete(int i) {
                int i2;
                if (i < 0 || i >= (i2 = this.size)) {
                    return;
                }
                TimerTask[] timerTaskArr = this.timers;
                int i3 = i2 - 1;
                this.size = i3;
                timerTaskArr[i] = timerTaskArr[i3];
                timerTaskArr[i3] = null;
                downHeap(i);
            }

            private void upHeap() {
                int i = this.size - 1;
                int i2 = (i - 1) / 2;
                while (this.timers[i].when < this.timers[i2].when) {
                    TimerTask[] timerTaskArr = this.timers;
                    TimerTask timerTask = timerTaskArr[i];
                    timerTaskArr[i] = timerTaskArr[i2];
                    timerTaskArr[i2] = timerTask;
                    int i3 = i2;
                    i2 = (i2 - 1) / 2;
                    i = i3;
                }
            }

            private void downHeap(int i) {
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.size;
                    if (i2 >= i3 || i3 <= 0) {
                        return;
                    }
                    int i4 = i2 + 1;
                    if (i4 < i3 && this.timers[i4].when < this.timers[i2].when) {
                        i2 = i4;
                    }
                    if (this.timers[i].when < this.timers[i2].when) {
                        return;
                    }
                    TimerTask[] timerTaskArr = this.timers;
                    TimerTask timerTask = timerTaskArr[i];
                    timerTaskArr[i] = timerTaskArr[i2];
                    timerTaskArr[i2] = timerTask;
                    int i5 = i2;
                    i2 = (i2 * 2) + 1;
                    i = i5;
                }
            }

            public final void reset() {
                this.timers = new TimerTask[this.DEFAULT_HEAP_SIZE];
                this.size = 0;
            }

            public final void adjustMinimum() {
                downHeap(0);
            }

            public final void deleteIfCancelled() {
                int i = 0;
                while (i < this.size) {
                    if (this.timers[i].cancelled) {
                        this.deletedCancelledNumber++;
                        delete(i);
                        i--;
                    }
                    i++;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int getTask(TimerTask timerTask) {
                int i = 0;
                while (true) {
                    TimerTask[] timerTaskArr = this.timers;
                    if (i >= timerTaskArr.length) {
                        return -1;
                    }
                    if (timerTaskArr[i] == timerTask) {
                        return i;
                    }
                    i++;
                }
            }
        }

        TimerImpl(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX WARN: Code restructure failed: missing block: B:65:0x00a9, code lost:
        
            r2.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00ae, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00af, code lost:
        
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00b1, code lost:
        
            r10.cancelled = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x00b4, code lost:
        
            throw r0;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 195
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.v8worker.Timer.TimerImpl.run():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void insertTask(TimerTask timerTask) {
            this.tasks.insert(timerTask);
            notify();
        }

        public final void cancel() {
            synchronized (this) {
                this.cancelled = true;
                this.tasks.reset();
                notify();
            }
        }

        public final int purge() {
            if (this.tasks.isEmpty()) {
                return 0;
            }
            this.tasks.deletedCancelledNumber = 0;
            this.tasks.deleteIfCancelled();
            return this.tasks.deletedCancelledNumber;
        }
    }

    /* loaded from: classes6.dex */
    static final class FinalizerHelper {
        private final TimerImpl impl;

        FinalizerHelper(TimerImpl timerImpl) {
            this.impl = timerImpl;
        }

        protected final void finalize() throws Throwable {
            try {
                synchronized (this.impl) {
                    this.impl.finished = true;
                    this.impl.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    private static long nextId() {
        long j;
        synchronized (Timer.class) {
            j = timerId;
            timerId = 1 + j;
        }
        return j;
    }

    public Timer(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        TimerImpl timerImpl = new TimerImpl(str, z);
        this.impl = timerImpl;
        this.finalizer = new FinalizerHelper(timerImpl);
    }

    public Timer(String str) {
        this(str, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Timer(boolean r4) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Timer-"
            r0.append(r1)
            long r1 = nextId()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r3.<init>(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.v8worker.Timer.<init>(boolean):void");
    }

    public Timer() {
        this(false);
    }

    public void pause() {
        synchronized (this.impl) {
            this.impl.suspended = true;
            this.impl.notify();
        }
    }

    public void resume() {
        synchronized (this.impl) {
            this.impl.suspended = false;
            this.impl.notify();
        }
    }

    public void cancel() {
        this.impl.cancel();
    }

    public int purge() {
        int purge;
        synchronized (this.impl) {
            purge = this.impl.purge();
        }
        return purge;
    }

    public void schedule(TimerTask timerTask, Date date) {
        if (date.getTime() < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("when < 0: ");
            sb.append(date.getTime());
            throw new IllegalArgumentException(sb.toString());
        }
        long time = date.getTime() - System.currentTimeMillis();
        scheduleImpl(timerTask, time < 0 ? 0L : time, -1L, false);
    }

    public void schedule(TimerTask timerTask, long j) {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("delay < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
        scheduleImpl(timerTask, j, -1L, false);
    }

    public void schedule(TimerTask timerTask, long j, long j2) {
        if (j < 0 || j2 <= 0) {
            throw new IllegalArgumentException();
        }
        scheduleImpl(timerTask, j, j2, false);
    }

    public void schedule(TimerTask timerTask, Date date, long j) {
        if (j <= 0 || date.getTime() < 0) {
            throw new IllegalArgumentException();
        }
        long time = date.getTime() - System.currentTimeMillis();
        scheduleImpl(timerTask, time < 0 ? 0L : time, j, false);
    }

    public void scheduleAtFixedRate(TimerTask timerTask, long j, long j2) {
        if (j < 0 || j2 <= 0) {
            throw new IllegalArgumentException();
        }
        scheduleImpl(timerTask, j, j2, true);
    }

    public void scheduleAtFixedRate(TimerTask timerTask, Date date, long j) {
        if (j <= 0 || date.getTime() < 0) {
            throw new IllegalArgumentException();
        }
        scheduleImpl(timerTask, date.getTime() - System.currentTimeMillis(), j, true);
    }

    private void scheduleImpl(TimerTask timerTask, long j, long j2, boolean z) {
        synchronized (this.impl) {
            if (this.impl.cancelled) {
                throw new IllegalStateException("Timer was canceled");
            }
            long currentTimeMillis = j + System.currentTimeMillis();
            if (currentTimeMillis < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Illegal delay to start the TimerTask: ");
                sb.append(currentTimeMillis);
                throw new IllegalArgumentException(sb.toString());
            }
            synchronized (timerTask.lock) {
                if (timerTask.isScheduled()) {
                    throw new IllegalStateException("TimerTask is scheduled already");
                }
                if (timerTask.cancelled) {
                    throw new IllegalStateException("TimerTask is canceled");
                }
                timerTask.when = currentTimeMillis;
                timerTask.period = j2;
                timerTask.fixedRate = z;
            }
            this.impl.insertTask(timerTask);
        }
    }
}
