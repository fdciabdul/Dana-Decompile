package com.alibaba.griver.api.resource.extensions;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.resource.parser.ParseFailedException;

/* loaded from: classes6.dex */
public interface GriverParseFailedPoint extends Extension {
    void parseFailed(ParseFailedException parseFailedException);
}
