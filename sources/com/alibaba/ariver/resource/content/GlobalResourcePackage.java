package com.alibaba.ariver.resource.content;

/* loaded from: classes6.dex */
public class GlobalResourcePackage extends NormalResourcePackage {
    public GlobalResourcePackage(String str) {
        super(str, null);
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public void teardown() {
        super.teardown();
        GlobalPackagePool.getInstance().remove(this.appId);
    }
}
