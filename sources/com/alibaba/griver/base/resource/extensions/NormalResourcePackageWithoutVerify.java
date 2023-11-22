package com.alibaba.griver.base.resource.extensions;

import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.parser.ParseContext;

/* loaded from: classes6.dex */
public class NormalResourcePackageWithoutVerify extends GriverNormalResourcePackage {
    public NormalResourcePackageWithoutVerify(String str, ResourceContext resourceContext) {
        super(str, resourceContext);
    }

    @Override // com.alibaba.ariver.resource.content.NormalResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage
    public void beforeParsePackage(ParseContext parseContext) {
        super.beforeParsePackage(parseContext);
        parseContext.needVerify = false;
    }

    @Override // com.alibaba.griver.base.resource.extensions.GriverNormalResourcePackage
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.alibaba.griver.base.resource.extensions.GriverNormalResourcePackage
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
