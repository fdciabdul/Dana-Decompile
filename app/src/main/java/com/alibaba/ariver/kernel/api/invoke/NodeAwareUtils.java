package com.alibaba.ariver.kernel.api.invoke;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.exthub.common.ExtHubLogger;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class NodeAwareUtils {
    public static void handleSetNode(Node node, Extension extension) {
        NodeAware nodeAware;
        Class nodeType;
        boolean z;
        if (!(extension instanceof NodeAware) || (nodeType = (nodeAware = (NodeAware) extension).getNodeType()) == null) {
            return;
        }
        Node node2 = node;
        while (true) {
            z = false;
            if (node2 == null) {
                break;
            } else if (nodeType.isAssignableFrom(node2.getClass())) {
                z = true;
                nodeAware.setNode(new WeakReference(node2));
                break;
            } else {
                node2 = node2.getParentNode();
            }
        }
        if (z) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("cannot find Wanted node type: ");
        sb.append(nodeType);
        sb.append(" with target node: ");
        sb.append(node);
        sb.append(" in extension ");
        sb.append(extension);
        ExtHubLogger.w("AriverKernel:ExtensionInvoker:Aware", sb.toString());
    }
}
