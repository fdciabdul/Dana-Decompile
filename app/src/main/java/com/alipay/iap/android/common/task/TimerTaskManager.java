package com.alipay.iap.android.common.task;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.alipay.iap.android.common.log.LoggerWrapper;

/* loaded from: classes6.dex */
public class TimerTaskManager {
    private static TimerTaskManager INSTANCE = null;
    private static final String TAG = "TimerTaskManager";
    private Handler mMainHandler = new Handler(Looper.getMainLooper());
    private TaskHandlerThread mTaskHandlerThread;

    public static TimerTaskManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TimerTaskManager();
        }
        return INSTANCE;
    }

    private TimerTaskManager() {
    }

    public void postToMain(Runnable runnable) {
        this.mMainHandler.post(runnable);
    }

    public void postToMain(Runnable runnable, int i) {
        this.mMainHandler.postDelayed(runnable, i);
    }

    public void start() {
        if (this.mTaskHandlerThread == null) {
            TaskHandlerThread taskHandlerThread = new TaskHandlerThread();
            this.mTaskHandlerThread = taskHandlerThread;
            taskHandlerThread.start();
        }
    }

    public void shutdown() {
        TaskHandlerThread taskHandlerThread = this.mTaskHandlerThread;
        if (taskHandlerThread != null) {
            taskHandlerThread.quit();
            this.mTaskHandlerThread = null;
        }
    }

    public void scheduleTask(BaseTask baseTask, long j) {
        if (this.mTaskHandlerThread == null) {
            start();
        }
        this.mTaskHandlerThread.waitUntilReady();
        StringBuilder sb = new StringBuilder();
        sb.append("schedule task:");
        sb.append(baseTask);
        LoggerWrapper.i("TimerTaskManager", sb.toString());
        baseTask.bindTimer(this);
        if (j > 0) {
            this.mTaskHandlerThread.mHandler.postDelayed(baseTask, j);
        } else {
            this.mTaskHandlerThread.mHandler.post(baseTask);
        }
    }

    public void scheduleTask(BaseTask baseTask) {
        scheduleTask(baseTask, 0L);
    }

    public void scheduleTaskDelay(BaseTask baseTask) {
        scheduleTask(baseTask, baseTask.nextDelayMillSeconds());
        baseTask.onScheduleFinish();
    }

    public void cancelTask(BaseTask baseTask) {
        TaskHandlerThread taskHandlerThread = this.mTaskHandlerThread;
        if (taskHandlerThread == null) {
            return;
        }
        taskHandlerThread.waitUntilReady();
        this.mTaskHandlerThread.mHandler.removeCallbacks(baseTask);
        baseTask.reset();
        StringBuilder sb = new StringBuilder();
        sb.append("cancel task:");
        sb.append(baseTask);
        LoggerWrapper.i("TimerTaskManager", sb.toString());
    }

    /* loaded from: classes6.dex */
    public static abstract class BaseTask implements Runnable {
        private TimerTaskManager mTaskManager;

        public abstract void call();

        public abstract int nextDelayMillSeconds();

        public void onScheduleFinish() {
        }

        public void reset() {
        }

        public void bindTimer(TimerTaskManager timerTaskManager) {
            this.mTaskManager = timerTaskManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            scheduleNext();
            call();
        }

        private void scheduleNext() {
            TimerTaskManager timerTaskManager = this.mTaskManager;
            if (timerTaskManager == null) {
                return;
            }
            timerTaskManager.scheduleTaskDelay(this);
            onScheduleFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class TaskHandlerThread extends HandlerThread {
        private Handler mHandler;

        private TaskHandlerThread() {
            super("TaskHandlerThread");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void waitUntilReady() {
            synchronized (this) {
                if (this.mHandler == null) {
                    this.mHandler = new Handler(getLooper());
                }
            }
        }
    }
}
