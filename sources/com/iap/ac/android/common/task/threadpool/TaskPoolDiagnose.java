package com.iap.ac.android.common.task.threadpool;

import android.util.Pair;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.threadpool.TaskPoolRunnable;
import com.iap.ac.android.common.utils.LoggerUtil;
import io.split.android.client.service.ServiceConstants;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class TaskPoolDiagnose {
    public static final String FOOT_PRINT_TYPE = "TaskScheduleService";
    public static final int MAX_REPORTED_COUNT = 5;
    public static int sReportedCount = 1;

    public static void invokerThrowsException(TaskPoolRunnable.TaskType taskType, String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(taskType);
        sb.append(": developer invoked throws exception. ");
        sb.append(LoggerUtil.throwableToString(th));
        String obj = sb.toString();
        ACLog.e("TaskScheduleService", obj);
        if (sReportedCount > 5) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ServiceConstants.TASK_INFO_FIELD_TYPE, String.valueOf(taskType));
        hashMap.put("className", str);
        hashMap.put("methodName", str2);
        hashMap.put("stackTrace", obj);
        sReportedCount++;
    }

    public static boolean isShutdownCheckInvoker(Pair<String, String> pair) {
        return (pair != null && "finalize".equals(pair.second) && "java.util.concurrent.ThreadPoolExecutor".equals(pair.first)) ? false : true;
    }

    public static void shouldNotBeInvoked(TaskPoolRunnable.TaskType taskType, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(taskType);
        sb.append(": developer should not invoke this. ");
        String stackTraceToString = LoggerUtil.stackTraceToString(sb.toString());
        ACLog.e("TaskScheduleService", stackTraceToString);
        if (sReportedCount > 5) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ServiceConstants.TASK_INFO_FIELD_TYPE, String.valueOf(taskType));
        hashMap.put("className", str);
        hashMap.put("methodName", str2);
        hashMap.put("stackTrace", stackTraceToString);
        sReportedCount++;
    }

    public static void taskWasDiscard(TaskPoolRunnable.TaskType taskType, Runnable runnable) {
        if (taskType != null && sReportedCount <= 5) {
            HashMap hashMap = new HashMap();
            hashMap.put(ServiceConstants.TASK_INFO_FIELD_TYPE, String.valueOf(taskType));
            if (runnable != null) {
                hashMap.put("runnable", runnable.getClass().getName());
            }
            sReportedCount++;
        }
    }

    public static void waitOrSpendLongTime(boolean z, TaskPoolRunnable.TaskType taskType, String str, String str2, long j, long j2) {
        if (sReportedCount > 5) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ServiceConstants.TASK_INFO_FIELD_TYPE, String.valueOf(taskType));
        hashMap.put("className", str);
        hashMap.put("methodName", str2);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, String.valueOf(j));
        hashMap.put("spendTime", String.valueOf(j2));
        sReportedCount++;
    }
}
