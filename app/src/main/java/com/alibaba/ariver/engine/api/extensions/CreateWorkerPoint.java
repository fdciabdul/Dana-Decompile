package com.alibaba.ariver.engine.api.extensions;

import android.content.Context;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.node.Node;

/* loaded from: classes6.dex */
public interface CreateWorkerPoint extends Extension {
    Worker createWorker(Context context, Node node, String str, String str2);
}
