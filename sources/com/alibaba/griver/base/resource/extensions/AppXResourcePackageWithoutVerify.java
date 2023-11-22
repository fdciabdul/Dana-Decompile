package com.alibaba.griver.base.resource.extensions;

import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.parser.ParseContext;

/* loaded from: classes6.dex */
public class AppXResourcePackageWithoutVerify extends GriverAppXResourcePackage {
    public AppXResourcePackageWithoutVerify(ResourceContext resourceContext) {
        super(resourceContext);
    }

    @Override // com.alibaba.ariver.resource.content.NormalResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage
    public void beforeParsePackage(ParseContext parseContext) {
        super.beforeParsePackage(parseContext);
        parseContext.needVerify = false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
