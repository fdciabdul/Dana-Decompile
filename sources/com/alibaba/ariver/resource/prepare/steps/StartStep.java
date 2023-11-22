package com.alibaba.ariver.resource.prepare.steps;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.log.AppLog;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.StepType;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class StartStep extends BasePrepareStep {

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f6242a = new AtomicBoolean(false);

    @Override // com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    @Override // com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public /* bridge */ /* synthetic */ boolean isFinished() {
        return super.isFinished();
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareStep
    public StepType getType() {
        return StepType.START;
    }

    @Override // com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public void execute(PrepareController prepareController, PrepareContext prepareContext, PrepareCallback prepareCallback) throws PrepareException {
        AppModel appModel;
        if (this.f6242a.getAndSet(true)) {
            RVLogger.d(this.LOG_TAG, "prepareFinish but already start!!!");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(RVTraceKey.RV_Prepare_Execute_);
        sb.append(getType());
        RVTraceUtils.traceBeginSection(sb.toString());
        super.execute(prepareController, prepareContext, prepareCallback);
        String str = this.LOG_TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("prepareFinish ");
        sb2.append(prepareContext.getAppId());
        sb2.append(" with appModel:");
        sb2.append(prepareContext.getAppModel());
        RVLogger.d(str, sb2.toString());
        String string = BundleUtils.getString(prepareContext.getStartParams(), "url");
        String string2 = BundleUtils.getString(prepareContext.getStartParams(), "page");
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2) && (appModel = prepareContext.getAppModel()) != null && appModel.getContainerInfo() != null && TextUtils.isEmpty(JSONUtils.getString(appModel.getContainerInfo().getLaunchParams(), "page"))) {
            RVLogger.d(this.LOG_TAG, "url and page both null! prepare fail!");
            prepareCallback.prepareFail(prepareContext.getPrepareData(), new PrepareException("6", "url and page both null!"));
            return;
        }
        prepareContext.getPrepareData().setEndTime(SystemClock.elapsedRealtime());
        a(prepareContext);
        prepareCallback.prepareFinish(prepareContext.getPrepareData(), prepareContext.getAppModel(), prepareContext.getStartParams(), prepareContext.getSceneParams());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(RVTraceKey.RV_Prepare_Execute_);
        sb3.append(getType());
        RVTraceUtils.traceEndSection(sb3.toString());
    }

    private void a(PrepareContext prepareContext) {
        if (prepareContext == null) {
            return;
        }
        AppLog.Builder builder = new AppLog.Builder();
        StringBuilder sb = new StringBuilder();
        sb.append("prepare 8 size/");
        sb.append(RVResourceUtils.getPkgSize(prepareContext));
        sb.append(" appx2.0size/");
        sb.append(RVResourceUtils.getNewPkgSize(prepareContext));
        AppLogger.log(builder.setState(sb.toString()).setAppId(prepareContext.getAppId()).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).build());
    }
}
