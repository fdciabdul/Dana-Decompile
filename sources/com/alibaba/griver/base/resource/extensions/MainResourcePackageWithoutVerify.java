package com.alibaba.griver.base.resource.extensions;

import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.parser.ParseContext;

/* loaded from: classes6.dex */
public class MainResourcePackageWithoutVerify extends GriverMainResourcePackage {
    public MainResourcePackageWithoutVerify(ResourceContext resourceContext) {
        super(resourceContext);
    }

    @Override // com.alibaba.griver.base.resource.extensions.GriverMainResourcePackage, com.alibaba.ariver.resource.content.MainResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage
    public void beforeParsePackage(ParseContext parseContext) {
        super.beforeParsePackage(parseContext);
        parseContext.needVerify = false;
    }
}
