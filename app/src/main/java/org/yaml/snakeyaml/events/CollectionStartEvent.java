package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes6.dex */
public abstract class CollectionStartEvent extends NodeEvent {
    public final DumperOptions.FlowStyle KClassImpl$Data$declaredNonStaticMembers$2;
    public final String MyBillsEntityDataFactory;
    private final boolean getAuthRequestContext;

    public CollectionStartEvent(String str, String str2, boolean z, Mark mark, Mark mark2, DumperOptions.FlowStyle flowStyle) {
        super(str, mark, mark2);
        this.MyBillsEntityDataFactory = str2;
        this.getAuthRequestContext = z;
        if (flowStyle == null) {
            throw new NullPointerException("Flow style must be provided.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = flowStyle;
    }

    public final boolean getAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.yaml.snakeyaml.events.NodeEvent, org.yaml.snakeyaml.events.Event
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.KClassImpl$Data$declaredNonStaticMembers$2());
        sb.append(", tag=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", implicit=");
        sb.append(this.getAuthRequestContext);
        return sb.toString();
    }

    public final boolean PlaceComponentResult() {
        return DumperOptions.FlowStyle.FLOW == this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
