package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.nodes.Node;

/* loaded from: classes6.dex */
public abstract class AbstractConstruct implements Construct {
    @Override // org.yaml.snakeyaml.constructor.Construct
    public final void getAuthRequestContext(Node node, Object obj) {
        if (node.MyBillsEntityDataFactory()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Not Implemented in ");
            sb.append(getClass().getName());
            throw new IllegalStateException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unexpected recursive structure for Node: ");
        sb2.append(node);
        throw new YAMLException(sb2.toString());
    }
}
