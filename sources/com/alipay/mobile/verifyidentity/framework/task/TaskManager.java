package com.alipay.mobile.verifyidentity.framework.task;

/* loaded from: classes3.dex */
public class TaskManager {
    private static TaskManager instance;
    private TaskThreadPool taskThreadPool = new TaskThreadPool();

    public static TaskManager getInstance() {
        TaskManager taskManager;
        synchronized (TaskManager.class) {
            if (instance == null) {
                instance = new TaskManager();
            }
            taskManager = instance;
        }
        return taskManager;
    }

    private TaskManager() {
    }

    public void execute(Task task) {
        this.taskThreadPool.execute(task);
    }
}
