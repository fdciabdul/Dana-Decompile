package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event;

/* loaded from: classes6.dex */
public final class DocumentEndEvent extends Event {
    private final boolean MyBillsEntityDataFactory;

    public DocumentEndEvent(Mark mark, Mark mark2, boolean z) {
        super(mark, mark2);
        this.MyBillsEntityDataFactory = z;
    }

    @Override // org.yaml.snakeyaml.events.Event
    public final Event.ID BuiltInFictitiousFunctionClassFactory() {
        return Event.ID.DocumentEnd;
    }
}
