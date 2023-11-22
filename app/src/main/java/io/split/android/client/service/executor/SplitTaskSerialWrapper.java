package io.split.android.client.service.executor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class SplitTaskSerialWrapper implements SplitTask {
    public static final String SPLIT_EXTRA_EXECUTION_RESULTS = "serial_task_results";
    private final SplitTaskType mSplitTaskType;
    private final List<SplitTask> mTaskList;

    public SplitTaskSerialWrapper(SplitTaskType splitTaskType, SplitTask... splitTaskArr) {
        this.mSplitTaskType = splitTaskType;
        this.mTaskList = Arrays.asList(splitTaskArr);
    }

    public SplitTaskSerialWrapper(SplitTask... splitTaskArr) {
        this(SplitTaskType.GENERIC_TASK, splitTaskArr);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        boolean z;
        ArrayList arrayList = new ArrayList();
        Iterator<SplitTask> it = this.mTaskList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            SplitTaskExecutionInfo execute = it.next().execute();
            if (execute != null) {
                arrayList.add(execute);
                if (!SplitTaskExecutionStatus.SUCCESS.equals(execute.getStatus())) {
                    z = false;
                    break;
                }
            }
        }
        Map singletonMap = Collections.singletonMap(SPLIT_EXTRA_EXECUTION_RESULTS, arrayList);
        if (z) {
            return SplitTaskExecutionInfo.success(this.mSplitTaskType, singletonMap);
        }
        return SplitTaskExecutionInfo.error(this.mSplitTaskType, singletonMap);
    }

    public List<SplitTask> getTaskList() {
        return this.mTaskList;
    }
}
