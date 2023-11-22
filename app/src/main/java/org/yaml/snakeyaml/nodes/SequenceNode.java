package org.yaml.snakeyaml.nodes;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.List;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes6.dex */
public class SequenceNode extends CollectionNode<Node> {
    public final List<Node> KClassImpl$Data$declaredNonStaticMembers$2;

    public SequenceNode(Tag tag, boolean z, List<Node> list, Mark mark, DumperOptions.FlowStyle flowStyle) {
        super(tag, mark, flowStyle);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
    }

    @Override // org.yaml.snakeyaml.nodes.Node
    public final NodeId KClassImpl$Data$declaredNonStaticMembers$2() {
        return NodeId.sequence;
    }

    @Override // org.yaml.snakeyaml.nodes.CollectionNode
    public final List<Node> PlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(getClass().getName());
        sb.append(" (tag=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", value=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(")>");
        return sb.toString();
    }
}
