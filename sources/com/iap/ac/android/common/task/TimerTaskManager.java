package com.iap.ac.android.common.task;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes8.dex */
public class TimerTaskManager {
    public static TimerTaskManager INSTANCE = null;
    public static final String TAG = "TimerTaskManager";
    public Handler mMainHandler = new Handler(Looper.getMainLooper());
    public TaskHandlerThread mTaskHandlerThread;

    /* loaded from: classes8.dex */
    public static abstract class BaseTask implements Runnable {
        public TimerTaskManager mTaskManager;

        private void scheduleNext() {
            TimerTaskManager timerTaskManager = this.mTaskManager;
            if (timerTaskManager == null) {
                return;
            }
            timerTaskManager.scheduleTaskDelay(this);
            onScheduleFinish();
        }

        public void bindTimer(TimerTaskManager timerTaskManager) {
            this.mTaskManager = timerTaskManager;
        }

        public abstract void call();

        public abstract int nextDelayMillSeconds();

        public void onScheduleFinish() {
        }

        public void reset() {
        }

        @Override // java.lang.Runnable
        public void run() {
            scheduleNext();
            call();
        }
    }

    /* loaded from: classes8.dex */
    public static class TaskHandlerThread extends HandlerThread {
        public Handler mHandler;

        /* JADX INFO: Access modifiers changed from: private */
        public void waitUntilReady() {
            synchronized (this) {
                if (this.mHandler == null) {
                    this.mHandler = new Handler(getLooper());
                }
            }
        }

        public TaskHandlerThread() {
            super("TaskHandlerThread");
        }
    }

    public static TimerTaskManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TimerTaskManager();
        }
        return INSTANCE;
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
        ACLog.i(TAG, sb.toString());
    }

    public void postToMain(Runnable runnable) {
        this.mMainHandler.post(runnable);
    }

    public void scheduleTask(BaseTask baseTask, long j) {
        if (this.mTaskHandlerThread == null) {
            start();
        }
        this.mTaskHandlerThread.waitUntilReady();
        StringBuilder sb = new StringBuilder();
        sb.append("schedule task:");
        sb.append(baseTask);
        ACLog.i(TAG, sb.toString());
        baseTask.bindTimer(this);
        if (j > 0) {
            this.mTaskHandlerThread.mHandler.postDelayed(baseTask, j);
        } else {
            this.mTaskHandlerThread.mHandler.post(baseTask);
        }
    }

    public void scheduleTaskDelay(BaseTask baseTask) {
        scheduleTask(baseTask, baseTask.nextDelayMillSeconds());
        baseTask.onScheduleFinish();
    }

    public void shutdown() {
        TaskHandlerThread taskHandlerThread = this.mTaskHandlerThread;
        if (taskHandlerThread != null) {
            taskHandlerThread.quit();
            this.mTaskHandlerThread = null;
        }
    }

    public void start() {
        if (this.mTaskHandlerThread == null) {
            TaskHandlerThread taskHandlerThread = new TaskHandlerThread();
            this.mTaskHandlerThread = taskHandlerThread;
            taskHandlerThread.start();
        }
    }

    public void postToMain(Runnable runnable, int i) {
        this.mMainHandler.postDelayed(runnable, i);
    }

    public void scheduleTask(BaseTask baseTask) {
        scheduleTask(baseTask, 0L);
    }
}
