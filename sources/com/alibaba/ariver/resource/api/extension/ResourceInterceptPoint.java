package com.alibaba.ariver.resource.api.extension;

import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes6.dex */
public interface ResourceInterceptPoint extends Extension {
    Resource intercept(Resource resource);
}
