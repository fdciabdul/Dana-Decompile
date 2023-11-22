package com.alibaba.ariver.resource.api.extension;

import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.resource.api.content.ResourceQuery;

/* loaded from: classes6.dex */
public interface ResourceProviderPoint extends Extension {
    Resource getResource(ResourceQuery resourceQuery);
}
