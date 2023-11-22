package com.alibaba.ariver.engine.common.extension.bind;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.exthub.base.ExtHubApp;
import com.alibaba.exthub.base.ExtHubPage;

/* loaded from: classes3.dex */
public class ExtHubNodeBinder implements Binder<BindingNode, Node> {

    /* renamed from: a  reason: collision with root package name */
    private String f6041a;
    private Page b;

    public ExtHubNodeBinder(String str, Page page) {
        this.f6041a = str;
        this.b = page;
    }

    @Override // com.alibaba.ariver.engine.common.extension.bind.Binder
    public Node bind(Class<Node> cls, BindingNode bindingNode) throws BindException {
        if (bindingNode.value() == App.class) {
            if (this.b == null) {
                return new ExtHubApp(this.f6041a);
            }
            return new ExtHubApp(this.f6041a, this.b);
        } else if (bindingNode.value() == Page.class) {
            Page page = this.b;
            return page == null ? new ExtHubPage(this.f6041a) : page;
        } else {
            return null;
        }
    }
}
