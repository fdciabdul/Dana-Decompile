package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event;

/* loaded from: classes6.dex */
public final class CommentEvent extends Event {
    public final String BuiltInFictitiousFunctionClassFactory;
    public final CommentType getAuthRequestContext;

    public CommentEvent(CommentType commentType, String str, Mark mark, Mark mark2) {
        super(mark, mark2);
        if (commentType == null) {
            throw new NullPointerException("Event Type must be provided.");
        }
        this.getAuthRequestContext = commentType;
        if (str == null) {
            throw new NullPointerException("Value must be provided.");
        }
        this.BuiltInFictitiousFunctionClassFactory = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.yaml.snakeyaml.events.Event
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.KClassImpl$Data$declaredNonStaticMembers$2());
        sb.append("type=");
        sb.append(this.getAuthRequestContext);
        sb.append(", value=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        return sb.toString();
    }

    @Override // org.yaml.snakeyaml.events.Event
    public final Event.ID BuiltInFictitiousFunctionClassFactory() {
        return Event.ID.Comment;
    }
}
