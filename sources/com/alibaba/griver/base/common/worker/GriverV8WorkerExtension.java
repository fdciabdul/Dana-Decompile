package com.alibaba.griver.base.common.worker;

import android.os.HandlerThread;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.resource.api.models.PluginModel;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
public interface GriverV8WorkerExtension extends Proxiable {
    void clearThread(App app);

    Worker getV8Worker(App app, String str, String str2, List<PluginModel> list, HandlerThread handlerThread, CountDownLatch countDownLatch);

    Worker getV8Worker(String str, HandlerThread handlerThread);

    Worker reBindJsi(Worker worker, App app, List<PluginModel> list, CountDownLatch countDownLatch, String str);
}
