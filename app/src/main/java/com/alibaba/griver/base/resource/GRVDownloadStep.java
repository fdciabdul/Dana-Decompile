package com.alibaba.griver.base.resource;

import android.content.res.Resources;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.prepare.steps.DownloadStep;
import com.alibaba.griver.api.constants.GriverErrors;
import com.alibaba.griver.base.R;
import com.alibaba.griver.base.common.env.GriverEnv;

/* loaded from: classes6.dex */
public class GRVDownloadStep extends DownloadStep {
    @Override // com.alibaba.ariver.resource.prepare.steps.DownloadStep
    public void unlockAndMoveToNext(PrepareController prepareController) {
        if (!GriverDynamicResManager.getInstance().isUseDynamicResource()) {
            super.unlockAndMoveToNext(prepareController);
            return;
        }
        if (GriverDynamicResManager.getInstance().isAllAppxJsonResInstalled()) {
            super.unlockAndMoveToNext(prepareController);
        } else {
            prepareController.moveToError(new PrepareException(GriverErrors.ERROR_DYNAMIC_RESOURCE_LOAD_FAILED, a()));
        }
        GriverDynamicResManager.getInstance().notifyFinish();
    }

    private static String a() {
        Resources resources = GriverEnv.getResources();
        return resources == null ? "the resources in appx.json are not installed." : resources.getString(R.string.griver_prepare_dynamic_resource_load_failed);
    }
}
