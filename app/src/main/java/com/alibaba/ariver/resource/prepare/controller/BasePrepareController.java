package com.alibaba.ariver.resource.prepare.controller;

import android.os.Bundle;
import android.os.SystemClock;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.log.AppLog;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.PrepareStep;
import com.alibaba.ariver.resource.api.prepare.StepCreator;
import com.alibaba.ariver.resource.api.prepare.StepInterceptor;
import com.alibaba.ariver.resource.api.prepare.StepType;
import com.alibaba.ariver.resource.prepare.controller.Timer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public abstract class BasePrepareController implements PrepareController, Timer.TimeoutListener {
    private static final String TAG = "AriverRes:PrepareController";
    private AtomicBoolean appInfoSetted;
    protected PrepareCallback callback;
    protected PrepareContext context;
    protected PrepareStep currentExecutingStep;
    protected boolean errorIntercepted;
    private Set<PrepareStep> interceptedBeforeSteps;
    protected List<StepInterceptor> interceptors;
    private boolean locked;
    private Object lockedKey;
    private PrepareStep pendingAfterStep;
    private PrepareController.Status status;
    protected Queue<PrepareStep> steps;
    Timer timer;

    public BasePrepareController() {
        this.interceptedBeforeSteps = new HashSet();
        this.status = PrepareController.Status.INIT;
        this.locked = false;
        this.appInfoSetted = new AtomicBoolean(false);
        this.lockedKey = null;
        this.interceptors = Collections.EMPTY_LIST;
        this.context = null;
        this.callback = null;
        this.errorIntercepted = false;
        this.timer = null;
        this.steps = new ArrayBlockingQueue(4);
        StepCreator generateStepCreator = generateStepCreator();
        this.steps.add(generateStepCreator.createStep(StepType.SETUP));
        this.steps.add(generateStepCreator.createStep(StepType.UPDATE));
        this.steps.add(generateStepCreator.createStep(StepType.OFFLINE));
        this.steps.add(generateStepCreator.createStep(StepType.START));
    }

    protected StepCreator generateStepCreator() {
        return new DefaultStepCreator();
    }

    BasePrepareController(PrepareStep... prepareStepArr) {
        this.interceptedBeforeSteps = new HashSet();
        this.status = PrepareController.Status.INIT;
        this.locked = false;
        this.appInfoSetted = new AtomicBoolean(false);
        this.lockedKey = null;
        this.interceptors = Collections.EMPTY_LIST;
        this.context = null;
        this.callback = null;
        this.errorIntercepted = false;
        this.timer = null;
        this.steps = new LinkedList(Arrays.asList(prepareStepArr));
    }

    protected void bindContext(PrepareContext prepareContext, PrepareCallback prepareCallback) {
        this.context = prepareContext;
        this.callback = prepareCallback;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareController
    public void onGetAppInfo(AppModel appModel) {
        RVLogger.d(TAG, "onGetAppInfo");
        Iterator<StepInterceptor> it = this.interceptors.iterator();
        while (it.hasNext()) {
            it.next().onGetAppInfo(appModel);
        }
        if (this.appInfoSetted.getAndSet(true)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("appInfo", appModel);
        IpcServerUtils.sendMsgToClient(this.context.getAppId(), this.context.getStartToken(), 15, bundle);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareController
    public PrepareController.Status getStatus() {
        return this.status;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareController
    public void setInterceptors(List<StepInterceptor> list) {
        if (this.status != PrepareController.Status.INIT) {
            throw new IllegalStateException("You cannot set interceptor after execute");
        }
        ArrayList arrayList = new ArrayList(list);
        this.interceptors = arrayList;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((StepInterceptor) it.next()).init(this.context, this.callback);
        }
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareController
    public void postTimeOut(long j) {
        synchronized (this) {
            if (this.timer == null) {
                this.timer = createTimer(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("postTimeout ");
            sb.append(j);
            RVLogger.d(TAG, sb.toString());
            this.timer.postTimeout(j);
        }
    }

    protected Timer createTimer(Timer.TimeoutListener timeoutListener) {
        return new Timer(timeoutListener);
    }

    @Override // com.alibaba.ariver.resource.prepare.controller.Timer.TimeoutListener
    public void onTimeout(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("onTimeout! elapsed time: ");
        sb.append(j);
        RVLogger.e(TAG, sb.toString());
        if (this.status != PrepareController.Status.FINISH) {
            if (this.currentExecutingStep != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Procedure timeout on ");
                sb2.append(this.currentExecutingStep.getType());
                moveToError(new PrepareException("3", sb2.toString()));
                return;
            }
            moveToError(new PrepareException("3", "Procedure timeout"));
        }
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareController
    public void lock(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("locked with key: ");
        sb.append(obj);
        RVLogger.d(TAG, sb.toString());
        this.lockedKey = obj;
        this.locked = true;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareController
    public void unlock(Object obj) {
        if (this.locked) {
            StringBuilder sb = new StringBuilder();
            sb.append("unlocked with key: ");
            sb.append(obj);
            sb.append(", lockedKey: ");
            sb.append(this.lockedKey);
            RVLogger.d(TAG, sb.toString());
            if (obj != this.lockedKey) {
                return;
            }
            this.locked = false;
            this.lockedKey = null;
        }
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareController
    public void moveToError(PrepareException prepareException) {
        if (!this.status.canContinue()) {
            this.errorIntercepted = true;
            onPrepareFail(this.context, prepareException);
            return;
        }
        RVLogger.e(TAG, "moveToError!", prepareException);
        unlock(this.lockedKey);
        this.errorIntercepted = false;
        if (interceptOnError(prepareException)) {
            this.errorIntercepted = true;
            onPrepareFail(this.context, prepareException);
            return;
        }
        this.locked = false;
        this.status = PrepareController.Status.ERROR;
        this.steps.clear();
        Timer timer = this.timer;
        if (timer != null) {
            timer.invalidTimeout();
        }
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareController
    public void moveToNext() {
        if (this.locked) {
            StringBuilder sb = new StringBuilder();
            sb.append("controller locked by ");
            sb.append(this.currentExecutingStep);
            sb.append(" cannot moveToNext!");
            RVLogger.e(TAG, sb.toString());
        } else if (!this.status.canContinue()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("controller cannot moveToNext with status: ");
            sb2.append(this.status);
            RVLogger.e(TAG, sb2.toString());
        } else {
            this.status = PrepareController.Status.EXECUTING;
            PrepareStep prepareStep = this.pendingAfterStep;
            if (prepareStep != null) {
                boolean interceptAfter = interceptAfter(prepareStep);
                this.pendingAfterStep = null;
                if (interceptAfter) {
                    return;
                }
            }
            PrepareStep peek = this.steps.peek();
            if (peek != null) {
                this.currentExecutingStep = peek;
                if (this.interceptedBeforeSteps.contains(peek) || !interceptBefore(peek)) {
                    try {
                        this.steps.poll();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("step ");
                        sb3.append(peek.getType());
                        sb3.append(" execute");
                        RVLogger.d(TAG, sb3.toString());
                        this.pendingAfterStep = peek;
                        peek.execute(this, this.context, this.callback);
                        if (this.locked || peek.isFinished()) {
                            return;
                        }
                        if (!this.status.canContinue()) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("step ");
                            sb4.append(peek.getType());
                            sb4.append(" can't continue after execute. status: ");
                            sb4.append(this.status);
                            RVLogger.w(TAG, sb4.toString());
                            return;
                        }
                        this.pendingAfterStep = null;
                        if (interceptAfter(peek)) {
                            return;
                        }
                        moveToNext();
                        return;
                    } catch (PrepareException e) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(peek.getType());
                        sb5.append(" execute error!");
                        RVLogger.e(TAG, sb5.toString(), e);
                        moveToError(e);
                        return;
                    }
                }
                return;
            }
            finish();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0055, code lost:
    
        r3 = new java.lang.StringBuilder();
        r3.append("step ");
        r3.append(r7.getType());
        r3.append(" intercepted before by ");
        r3.append(r4.getClass().getName());
        com.alibaba.ariver.kernel.common.utils.RVLogger.d(com.alibaba.ariver.resource.prepare.controller.BasePrepareController.TAG, r3.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x007b, code lost:
    
        r0 = true;
        r1 = new java.lang.StringBuilder();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean interceptBefore(com.alibaba.ariver.resource.api.prepare.PrepareStep r7) {
        /*
            r6 = this;
            java.lang.String r0 = "AriverRes:PrepareController"
            java.lang.String r1 = "step "
            java.lang.String r2 = "RV_Prepare_Before_"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9a
            r3.<init>()     // Catch: java.lang.Throwable -> L9a
            r3.append(r1)     // Catch: java.lang.Throwable -> L9a
            com.alibaba.ariver.resource.api.prepare.StepType r4 = r7.getType()     // Catch: java.lang.Throwable -> L9a
            r3.append(r4)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r4 = " interceptBefore"
            r3.append(r4)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L9a
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r0, r3)     // Catch: java.lang.Throwable -> L9a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9a
            r3.<init>()     // Catch: java.lang.Throwable -> L9a
            r3.append(r2)     // Catch: java.lang.Throwable -> L9a
            com.alibaba.ariver.resource.api.prepare.StepType r4 = r7.getType()     // Catch: java.lang.Throwable -> L9a
            r3.append(r4)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L9a
            com.alibaba.ariver.kernel.common.utils.RVTraceUtils.traceBeginSection(r3)     // Catch: java.lang.Throwable -> L9a
            java.util.Set<com.alibaba.ariver.resource.api.prepare.PrepareStep> r3 = r6.interceptedBeforeSteps     // Catch: java.lang.Throwable -> L9a
            r3.add(r7)     // Catch: java.lang.Throwable -> L9a
            java.util.List<com.alibaba.ariver.resource.api.prepare.StepInterceptor> r3 = r6.interceptors     // Catch: java.lang.Throwable -> L9a
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L9a
        L43:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L9a
            if (r4 == 0) goto L82
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L9a
            com.alibaba.ariver.resource.api.prepare.StepInterceptor r4 = (com.alibaba.ariver.resource.api.prepare.StepInterceptor) r4     // Catch: java.lang.Throwable -> L9a
            boolean r5 = r4.before(r7, r6)     // Catch: java.lang.Throwable -> L9a
            if (r5 == 0) goto L43
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9a
            r3.<init>()     // Catch: java.lang.Throwable -> L9a
            r3.append(r1)     // Catch: java.lang.Throwable -> L9a
            com.alibaba.ariver.resource.api.prepare.StepType r1 = r7.getType()     // Catch: java.lang.Throwable -> L9a
            r3.append(r1)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r1 = " intercepted before by "
            r3.append(r1)     // Catch: java.lang.Throwable -> L9a
            java.lang.Class r1 = r4.getClass()     // Catch: java.lang.Throwable -> L9a
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L9a
            r3.append(r1)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L9a
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r0, r1)     // Catch: java.lang.Throwable -> L9a
            r0 = 1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto L88
        L82:
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L88:
            r1.append(r2)
            com.alibaba.ariver.resource.api.prepare.StepType r7 = r7.getType()
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            com.alibaba.ariver.kernel.common.utils.RVTraceUtils.traceEndSection(r7)
            return r0
        L9a:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            com.alibaba.ariver.resource.api.prepare.StepType r7 = r7.getType()
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            com.alibaba.ariver.kernel.common.utils.RVTraceUtils.traceEndSection(r7)
            goto Lb3
        Lb2:
            throw r0
        Lb3:
            goto Lb2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.resource.prepare.controller.BasePrepareController.interceptBefore(com.alibaba.ariver.resource.api.prepare.PrepareStep):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0050, code lost:
    
        r3 = new java.lang.StringBuilder();
        r3.append("step ");
        r3.append(r7.getType());
        r3.append(" intercepted after by ");
        r3.append(r4.getClass().getName());
        com.alibaba.ariver.kernel.common.utils.RVLogger.d(com.alibaba.ariver.resource.prepare.controller.BasePrepareController.TAG, r3.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0076, code lost:
    
        r0 = true;
        r7.finish();
        r1 = new java.lang.StringBuilder();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean interceptAfter(com.alibaba.ariver.resource.api.prepare.PrepareStep r7) {
        /*
            r6 = this;
            java.lang.String r0 = "AriverRes:PrepareController"
            java.lang.String r1 = "step "
            java.lang.String r2 = "RV_Prepare_After_"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b
            r3.<init>()     // Catch: java.lang.Throwable -> L9b
            r3.append(r2)     // Catch: java.lang.Throwable -> L9b
            com.alibaba.ariver.resource.api.prepare.StepType r4 = r7.getType()     // Catch: java.lang.Throwable -> L9b
            r3.append(r4)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L9b
            com.alibaba.ariver.kernel.common.utils.RVTraceUtils.traceBeginSection(r3)     // Catch: java.lang.Throwable -> L9b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b
            r3.<init>()     // Catch: java.lang.Throwable -> L9b
            r3.append(r1)     // Catch: java.lang.Throwable -> L9b
            com.alibaba.ariver.resource.api.prepare.StepType r4 = r7.getType()     // Catch: java.lang.Throwable -> L9b
            r3.append(r4)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r4 = " interceptAfter"
            r3.append(r4)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L9b
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r0, r3)     // Catch: java.lang.Throwable -> L9b
            java.util.List<com.alibaba.ariver.resource.api.prepare.StepInterceptor> r3 = r6.interceptors     // Catch: java.lang.Throwable -> L9b
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L9b
        L3e:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L9b
            if (r4 == 0) goto L80
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L9b
            com.alibaba.ariver.resource.api.prepare.StepInterceptor r4 = (com.alibaba.ariver.resource.api.prepare.StepInterceptor) r4     // Catch: java.lang.Throwable -> L9b
            boolean r5 = r4.after(r7, r6)     // Catch: java.lang.Throwable -> L9b
            if (r5 == 0) goto L3e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b
            r3.<init>()     // Catch: java.lang.Throwable -> L9b
            r3.append(r1)     // Catch: java.lang.Throwable -> L9b
            com.alibaba.ariver.resource.api.prepare.StepType r1 = r7.getType()     // Catch: java.lang.Throwable -> L9b
            r3.append(r1)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r1 = " intercepted after by "
            r3.append(r1)     // Catch: java.lang.Throwable -> L9b
            java.lang.Class r1 = r4.getClass()     // Catch: java.lang.Throwable -> L9b
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L9b
            r3.append(r1)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L9b
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r0, r1)     // Catch: java.lang.Throwable -> L9b
            r0 = 1
            r7.finish()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto L89
        L80:
            r0 = 0
            r7.finish()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L89:
            r1.append(r2)
            com.alibaba.ariver.resource.api.prepare.StepType r7 = r7.getType()
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            com.alibaba.ariver.kernel.common.utils.RVTraceUtils.traceEndSection(r7)
            return r0
        L9b:
            r0 = move-exception
            r7.finish()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            com.alibaba.ariver.resource.api.prepare.StepType r7 = r7.getType()
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            com.alibaba.ariver.kernel.common.utils.RVTraceUtils.traceEndSection(r7)
            goto Lb7
        Lb6:
            throw r0
        Lb7:
            goto Lb6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.resource.prepare.controller.BasePrepareController.interceptAfter(com.alibaba.ariver.resource.api.prepare.PrepareStep):boolean");
    }

    private boolean interceptOnError(PrepareException prepareException) {
        Iterator<StepInterceptor> it = this.interceptors.iterator();
        while (it.hasNext()) {
            if (it.next().onError(prepareException, this)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareController
    public void start() {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", this.context.getAppId());
        ((EventTracker) RVProxy.get(EventTracker.class)).initRecordTimeStamp(hashMap);
        moveToNext();
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareController
    public void finish() {
        RVLogger.d(TAG, "finish");
        this.status = PrepareController.Status.FINISH;
        Timer timer = this.timer;
        if (timer != null) {
            timer.invalidTimeout();
        }
        this.steps.clear();
        HashMap hashMap = new HashMap();
        hashMap.put("appId", this.context.getAppId());
        ((EventTracker) RVProxy.get(EventTracker.class)).clearRecordTimeStamp(hashMap);
    }

    private void onPrepareFail(PrepareContext prepareContext, PrepareException prepareException) {
        String obj;
        if (prepareContext == null) {
            return;
        }
        prepareContext.getPrepareData().setEndTime(SystemClock.elapsedRealtime());
        if (prepareException == null) {
            obj = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(prepareException.getCode());
            sb.append("_");
            sb.append(prepareException.getMessage());
            obj = sb.toString();
        }
        AppLogger.log(new AppLog.Builder().setState(AppLog.APP_LOG_PREPARE_FAIL).setAppId(prepareContext.getAppId()).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).setDesc(obj).build());
    }
}
