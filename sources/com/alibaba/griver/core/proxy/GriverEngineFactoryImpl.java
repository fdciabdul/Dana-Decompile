package com.alibaba.griver.core.proxy;

import com.alibaba.ariver.engine.api.EngineFactory;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.utils.AppTypeUtils;

/* loaded from: classes6.dex */
public class GriverEngineFactoryImpl implements EngineFactory {
    @Override // com.alibaba.ariver.engine.api.EngineFactory
    public String getEngineType(String str) {
        return AppTypeUtils.TYPE_TINY;
    }

    @Override // com.alibaba.ariver.engine.api.EngineFactory
    public RVEngine createEngine(String str, Node node, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("createEngine ");
        sb.append(str);
        RVLogger.d("GriverEngineFactoryImpl", sb.toString());
        return new GriverWebEngineImpl(str2, node);
    }
}
