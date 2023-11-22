package com.alipay.mobile.security.bio.service.impl;

import android.content.Context;
import com.alipay.mobile.security.bio.exception.BioIllegalArgumentException;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.BioTaskService;
import com.alipay.mobile.security.bio.task.ActionFrame;
import com.alipay.mobile.security.bio.task.ActionType;
import com.alipay.mobile.security.bio.task.SubTask;
import java.util.Vector;

/* loaded from: classes7.dex */
public class BioTaskServiceImpl extends BioTaskService {
    private Context mContext;
    private int mSubTaskIndex;
    private BioTaskService.TaskListener mTaskListener;
    private Vector<SubTask> mSubTasks = new Vector<>();
    private SubTask mCurSubTask = null;

    public BioTaskServiceImpl(Context context) {
        if (context == null) {
            throw new BioIllegalArgumentException();
        }
        this.mContext = context;
    }

    @Override // com.alipay.mobile.security.bio.service.BioService
    public void onCreate(BioServiceManager bioServiceManager) {
        this.mSubTasks.clear();
    }

    @Override // com.alipay.mobile.security.bio.service.BioService
    public void onDestroy() {
        if (this.mTaskListener != null) {
            this.mTaskListener = null;
        }
        Vector<SubTask> vector = this.mSubTasks;
        if (vector != null) {
            vector.clear();
            this.mCurSubTask = null;
        }
    }

    @Override // com.alipay.mobile.security.bio.service.BioTaskService
    public void addTask(SubTask subTask) {
        Vector<SubTask> vector;
        if (subTask == null || (vector = this.mSubTasks) == null) {
            return;
        }
        vector.add(subTask);
    }

    @Override // com.alipay.mobile.security.bio.service.BioTaskService
    public int getLeftTaskCount() {
        return this.mSubTasks.size() - this.mSubTaskIndex;
    }

    @Override // com.alipay.mobile.security.bio.service.BioTaskService
    public int getSubTaskCount() {
        return this.mSubTasks.size();
    }

    @Override // com.alipay.mobile.security.bio.service.BioTaskService
    public Vector<SubTask> getTasks() {
        return this.mSubTasks;
    }

    @Override // com.alipay.mobile.security.bio.service.BioTaskService
    public void setTaskListener(BioTaskService.TaskListener taskListener) {
        this.mTaskListener = taskListener;
    }

    @Override // com.alipay.mobile.security.bio.service.BioTaskService
    public void initAndBegin() {
        BioTaskService.TaskListener taskListener = this.mTaskListener;
        if (taskListener != null) {
            taskListener.onTasksBegin();
        }
        if (this.mSubTasks.size() > 0) {
            SubTask subTask = this.mSubTasks.get(0);
            this.mCurSubTask = subTask;
            subTask.init();
        }
        this.mSubTaskIndex = 0;
    }

    @Override // com.alipay.mobile.security.bio.service.BioTaskService
    public void clearTask() {
        Vector<SubTask> vector = this.mSubTasks;
        if (vector != null) {
            vector.clear();
        }
        this.mSubTaskIndex = 0;
    }

    @Override // com.alipay.mobile.security.bio.service.BioTaskService
    public SubTask getCurrentTask() {
        return this.mCurSubTask;
    }

    @Override // com.alipay.mobile.security.bio.service.BioTaskService
    public <T> void action(ActionFrame<T> actionFrame) {
        SubTask subTask;
        SubTask subTask2 = this.mCurSubTask;
        if (subTask2 != null) {
            if (AnonymousClass1.$SwitchMap$com$alipay$mobile$security$bio$task$ActionType[subTask2.action(actionFrame).ordinal()] != 3 || (subTask = this.mCurSubTask) == null) {
                return;
            }
            subTask.done();
            int i = this.mSubTaskIndex + 1;
            this.mSubTaskIndex = i;
            if (i < this.mSubTasks.size()) {
                SubTask subTask3 = this.mSubTasks.get(this.mSubTaskIndex);
                this.mCurSubTask = subTask3;
                subTask3.init();
                return;
            }
            this.mCurSubTask = null;
        }
    }

    /* renamed from: com.alipay.mobile.security.bio.service.impl.BioTaskServiceImpl$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alipay$mobile$security$bio$task$ActionType;

        static {
            int[] iArr = new int[ActionType.values().length];
            $SwitchMap$com$alipay$mobile$security$bio$task$ActionType = iArr;
            try {
                iArr[ActionType.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alipay$mobile$security$bio$task$ActionType[ActionType.RUN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alipay$mobile$security$bio$task$ActionType[ActionType.DONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.alipay.mobile.security.bio.service.BioTaskService
    public void reset() {
        this.mSubTaskIndex = 0;
        Vector<SubTask> vector = this.mSubTasks;
        if (vector != null) {
            vector.clear();
        }
    }
}
