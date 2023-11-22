package com.alibaba.ariver.kernel.api.extension;

import com.alibaba.ariver.kernel.api.extension.Extension;
import java.util.List;

/* loaded from: classes3.dex */
public interface ExtensionFilter<T extends Extension> {
    List<T> filter(List<T> list);
}
