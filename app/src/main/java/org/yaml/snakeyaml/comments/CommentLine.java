package org.yaml.snakeyaml.comments;

import com.j256.ormlite.stmt.query.SimpleComparison;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.CommentEvent;

/* loaded from: classes6.dex */
public class CommentLine {
    private final CommentType BuiltInFictitiousFunctionClassFactory;
    public final Mark KClassImpl$Data$declaredNonStaticMembers$2;
    private final Mark MyBillsEntityDataFactory;
    private final String PlaceComponentResult;

    private CommentLine(Mark mark, Mark mark2, String str, CommentType commentType) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = mark;
        this.MyBillsEntityDataFactory = mark2;
        this.PlaceComponentResult = str;
        this.BuiltInFictitiousFunctionClassFactory = commentType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(getClass().getName());
        sb.append(" (type=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", value=");
        sb.append(this.PlaceComponentResult);
        sb.append(")>");
        return sb.toString();
    }

    public CommentLine(CommentEvent commentEvent) {
        this(commentEvent.scheduleImpl, commentEvent.PlaceComponentResult, commentEvent.BuiltInFictitiousFunctionClassFactory, commentEvent.getAuthRequestContext);
    }
}
