package ru.noties.markwon.tasklist;

import org.commonmark.parser.Parser;
import ru.noties.markwon.tasklist.TaskListBlockParser;

/* loaded from: classes6.dex */
public class TaskListExtension implements Parser.ParserExtension {
    public static TaskListExtension KClassImpl$Data$declaredNonStaticMembers$2() {
        return new TaskListExtension();
    }

    @Override // org.commonmark.parser.Parser.ParserExtension
    public final void BuiltInFictitiousFunctionClassFactory(Parser.Builder builder) {
        builder.PlaceComponentResult.add(new TaskListBlockParser.Factory());
    }
}
