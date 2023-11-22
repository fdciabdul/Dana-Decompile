package org.yaml.snakeyaml.nodes;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: classes6.dex */
public final class NodeTuple {
    public final Node BuiltInFictitiousFunctionClassFactory;
    public final Node KClassImpl$Data$declaredNonStaticMembers$2;

    public NodeTuple(Node node, Node node2) {
        if (node == null || node2 == null) {
            throw new NullPointerException("Nodes must be provided.");
        }
        this.BuiltInFictitiousFunctionClassFactory = node;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = node2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<NodeTuple keyNode=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append("; valueNode=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return sb.toString();
    }
}
