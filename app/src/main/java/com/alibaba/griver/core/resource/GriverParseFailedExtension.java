package com.alibaba.griver.core.resource;

import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.resource.parser.ParseFailedException;
import com.alibaba.griver.api.resource.extensions.GriverParseFailedPoint;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.resource.utils.ErrorPageUtils;
import com.alibaba.griver.core.Griver;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class GriverParseFailedExtension implements NodeAware<App>, GriverParseFailedPoint {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<App> f6460a;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<App> weakReference) {
        this.f6460a = weakReference;
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<App> getNodeType() {
        return App.class;
    }

    @Override // com.alibaba.griver.api.resource.extensions.GriverParseFailedPoint
    public void parseFailed(ParseFailedException parseFailedException) {
        WeakReference<App> weakReference = this.f6460a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        final App app = this.f6460a.get();
        try {
            app.exit();
        } catch (Exception e) {
            GriverLogger.w("GriverParseFailedExtension", "exit app failed", e);
        }
        GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.core.resource.GriverParseFailedExtension.1
            @Override // java.lang.Runnable
            public void run() {
                Griver.openUrl(GriverEnv.getApplicationContext(), ErrorPageUtils.getErrorUrl(app.getAppId(), ErrorPageUtils.STATUS_LOAD_FAILED, "MINI_PROGRAM"), new Bundle());
            }
        });
    }
}
