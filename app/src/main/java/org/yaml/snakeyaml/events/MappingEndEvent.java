package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event;

/* loaded from: classes6.dex */
public final class MappingEndEvent extends CollectionEndEvent {
    public MappingEndEvent(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    @Override // org.yaml.snakeyaml.events.Event
    public final Event.ID BuiltInFictitiousFunctionClassFactory() {
        return Event.ID.MappingEnd;
    }
}
