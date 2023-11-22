package com.alipay.iap.android.common.task.pipeline;

import com.alipay.iap.android.common.log.LoggerWrapper;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class StandardPipeline implements PipeLine {
    static final String TAG = "StandardPipeline";
    volatile NamedRunnable mActive;
    private Executor mExecutor;
    protected volatile boolean mIsStart;
    protected ArrayList<NamedRunnable> mTasks;
    final IScheduleNext next;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface IScheduleNext {
        void scheduleNext();
    }

    public StandardPipeline() {
        this(null);
    }

    public StandardPipeline(Executor executor) {
        this.mTasks = new ArrayList<>();
        this.next = new IScheduleNext() { // from class: com.alipay.iap.android.common.task.pipeline.StandardPipeline.1
            @Override // com.alipay.iap.android.common.task.pipeline.StandardPipeline.IScheduleNext
            public void scheduleNext() {
                LoggerWrapper.v("StandardPipeline", "StandardPipeline.scheduleNext()");
                if (StandardPipeline.this.mIsStart) {
                    StandardPipeline.this.executeNext();
                }
            }
        };
        this.mIsStart = false;
        this.mExecutor = executor;
    }

    @Override // com.alipay.iap.android.common.task.pipeline.PipeLine
    public void setExecutor(Executor executor) {
        this.mExecutor = executor;
    }

    @Override // com.alipay.iap.android.common.task.pipeline.PipeLine
    public void addTask(Runnable runnable, String str) {
        addTask(runnable, str, 0);
    }

    @Override // com.alipay.iap.android.common.task.pipeline.PipeLine
    public void addTask(Runnable runnable, String str, int i) {
        addTask(NamedRunnable.TASK_POOL.obtain(runnable, str, i));
    }

    public void addTask(NamedRunnable namedRunnable) {
        LoggerWrapper.v("StandardPipeline", "StandardPipeline.addTask()");
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

    @Override // com.alipay.iap.android.common.task.pipeline.PipeLine
    public void start() {
        LoggerWrapper.v("StandardPipeline", "StandardPipeline.start()");
        if (this.mExecutor == null) {
            LoggerWrapper.e("StandardPipeline", "executor is null, can not start pipeline, return directly");
            return;
        }
        this.mIsStart = true;
        doStart();
    }

    protected void doStart() {
        if (this.mActive == null) {
            executeNext();
        } else {
            LoggerWrapper.v("StandardPipeline", "StandardPipeline.start(a task is running, so don't call scheduleNext())");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeNext() {
        synchronized (this.mTasks) {
            if (!this.mTasks.isEmpty()) {
                this.mActive = this.mTasks.remove(0);
            } else {
                this.mActive = null;
                LoggerWrapper.v("StandardPipeline", "mTasks is empty.");
            }
        }
        if (this.mActive != null) {
            LoggerWrapper.d("StandardPipeline", "StandardPipeline.scheduleNext()");
            Executor executor = this.mExecutor;
            if (executor != null) {
                executor.execute(this.mActive);
                return;
            } else {
                LoggerWrapper.e("StandardPipeline", "The StandardPipeline's Executor is null, can not execute task");
                return;
            }
        }
        LoggerWrapper.d("StandardPipeline", "StandardPipeline.scheduleNext(mTasks is empty)");
    }

    @Override // com.alipay.iap.android.common.task.pipeline.PipeLine
    public void stop() {
        this.mIsStart = false;
    }
}
