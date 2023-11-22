package com.alibaba.ariver.engine.common.extension.bind;

import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.exthub.common.ExtHubLogger;

/* loaded from: classes3.dex */
public class NodeBinder implements Binder<BindingNode, Node> {

    /* renamed from: a  reason: collision with root package name */
    private Node f6043a;

    public NodeBinder(Node node) {
        this.f6043a = node;
    }

    @Override // com.alibaba.ariver.engine.common.extension.bind.Binder
    public Node bind(Class<Node> cls, BindingNode bindingNode) throws BindException {
        Node a2 = a(bindingNode.value(), this.f6043a);
        if (a2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot find scope for node: ");
            sb.append(this.f6043a);
            sb.append(" scope: ");
            sb.append(bindingNode.value());
            ExtHubLogger.w("AriverEngine:NodeBinder", sb.toString());
        }
        return a2;
    }

    private Node a(Class<? extends Scope> cls, Node node) {
        Class scopeType;
        while (node != null && (node instanceof Scope) && (scopeType = ((Scope) node).getScopeType()) != null) {
            if (scopeType.equals(cls)) {
                return node;
            }
            node = node.getParentNode();
        }
        return null;
    }
}
