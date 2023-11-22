package org.yaml.snakeyaml.nodes;

import com.j256.ormlite.stmt.query.SimpleComparison;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes6.dex */
public class ScalarNode extends Node {
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    private final DumperOptions.ScalarStyle MyBillsEntityDataFactory;

    public ScalarNode(Tag tag, boolean z, String str, Mark mark, Mark mark2, DumperOptions.ScalarStyle scalarStyle) {
        super(tag, mark, mark2);
        if (str == null) {
            throw new NullPointerException("value in a Node is required.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        if (scalarStyle == null) {
            throw new NullPointerException("Scalar style must be provided.");
        }
        this.MyBillsEntityDataFactory = scalarStyle;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
    }

    @Override // org.yaml.snakeyaml.nodes.Node
    public final NodeId KClassImpl$Data$declaredNonStaticMembers$2() {
        return NodeId.scalar;
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
