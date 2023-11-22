package org.yaml.snakeyaml.nodes;

import java.util.List;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes6.dex */
public abstract class CollectionNode<T> extends Node {
    private DumperOptions.FlowStyle PlaceComponentResult;

    public abstract List<T> PlaceComponentResult();

    public CollectionNode(Tag tag, Mark mark, DumperOptions.FlowStyle flowStyle) {
        super(tag, mark, null);
        if (flowStyle == null) {
            throw new NullPointerException("Flow style must be provided.");
        }
        this.PlaceComponentResult = flowStyle;
    }

    public final void MyBillsEntityDataFactory(Mark mark) {
        this.lookAheadTest = mark;
    }
}
