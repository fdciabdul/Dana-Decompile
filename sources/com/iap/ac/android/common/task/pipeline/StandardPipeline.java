package com.iap.ac.android.common.task.pipeline;

import com.iap.ac.android.common.log.ACLog;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class StandardPipeline implements PipeLine {
    public static final String TAG = "StandardPipeline";
    public volatile NamedRunnable mActive;
    public Executor mExecutor;
    public volatile boolean mIsStart;
    public ArrayList<NamedRunnable> mTasks;
    public final IScheduleNext next;

    /* loaded from: classes3.dex */
    public interface IScheduleNext {
        void scheduleNext();
    }

    public StandardPipeline() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeNext() {
        synchronized (this.mTasks) {
            if (!this.mTasks.isEmpty()) {
                this.mActive = this.mTasks.remove(0);
            } else {
                this.mActive = null;
                ACLog.v(TAG, "mTasks is empty.");
            }
        }
        if (this.mActive != null) {
            ACLog.d(TAG, "StandardPipeline.scheduleNext()");
            Executor executor = this.mExecutor;
            if (executor != null) {
                executor.execute(this.mActive);
                return;
            } else {
                ACLog.e(TAG, "The StandardPipeline's Executor is null, can not execute task");
                return;
            }
        }
        ACLog.d(TAG, "StandardPipeline.scheduleNext(mTasks is empty)");
    }

    @Override // com.iap.ac.android.common.task.pipeline.PipeLine
    public void addTask(Runnable runnable, String str) {
        addTask(runnable, str, 0);
    }

    public void doStart() {
        if (this.mActive == null) {
            executeNext();
        } else {
            ACLog.v(TAG, "StandardPipeline.start(a task is running, so don't call scheduleNext())");
        }
    }

    @Override // com.iap.ac.android.common.task.pipeline.PipeLine
    public void setExecutor(Executor executor) {
        this.mExecutor = executor;
    }

    @Override // com.iap.ac.android.common.task.pipeline.PipeLine
    public void start() {
        ACLog.v(TAG, "StandardPipeline.start()");
        if (this.mExecutor == null) {
            ACLog.e(TAG, "executor is null, can not start pipeline, return directly");
            return;
        }
        this.mIsStart = true;
        doStart();
    }

    @Override // com.iap.ac.android.common.task.pipeline.PipeLine
    public void stop() {
        this.mIsStart = false;
    }

    public StandardPipeline(Executor executor) {
        this.mTasks = new ArrayList<>();
        this.mIsStart = false;
        this.next = new IScheduleNext() { // from class: com.iap.ac.android.common.task.pipeline.StandardPipeline.1
            @Override // com.iap.ac.android.common.task.pipeline.StandardPipeline.IScheduleNext
            public void scheduleNext() {
                ACLog.v(StandardPipeline.TAG, "StandardPipeline.scheduleNext()");
                if (StandardPipeline.this.mIsStart) {
                    StandardPipeline.this.executeNext();
                }
            }
        };
        this.mExecutor = executor;
    }

    @Override // com.iap.ac.android.common.task.pipeline.PipeLine
    public void addTask(Runnable runnable, String str, int i) {
        addTask(NamedRunnable.TASK_POOL.obtain(runnable, str, i));
    }

    public void addTask(NamedRunnable namedRunnable) {
        ACLog.v(TAG, "StandardPipeline.addTask()");
        if (this.mTasks == null) {
            this.mTasks = new ArrayList<>();
        }
        namedRunnable.setScheduleNext(this.next);
        synchronized (this.mTasks) {
            int i = 0;
            if (!this.mTasks.isEmpty()) {
                int size = this.mTasks.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    } else if (namedRunnable.mWeight <= this.mTasks.get(size).mWeight) {
                        size++;
                        break;
                    } else {
                        size--;
                    }
                }
                if (size >= 0) {
                    i = size;
                }
            }
            this.mTasks.add(i, namedRunnable);
        }
        if (this.mIsStart) {
            doStart();
        }
    }
}
