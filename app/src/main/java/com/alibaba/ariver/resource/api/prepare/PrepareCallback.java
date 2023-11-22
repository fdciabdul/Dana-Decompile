package com.alibaba.ariver.resource.api.prepare;

import android.os.Bundle;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.resource.api.models.AppModel;

/* loaded from: classes3.dex */
public interface PrepareCallback {
    void prepareAbort();

    void prepareFail(PrepareData prepareData, PrepareException prepareException);

    void prepareFinish(PrepareData prepareData, AppModel appModel, Bundle bundle, Bundle bundle2);

    void showLoading(boolean z, EntryInfo entryInfo);

    void startApp(PrepareCallbackParam prepareCallbackParam);

    void updateLoading(EntryInfo entryInfo, AppModel appModel);
}
