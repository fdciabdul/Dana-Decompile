package org.yaml.snakeyaml.comments;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import org.yaml.snakeyaml.events.CommentEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.parser.Parser;

/* loaded from: classes6.dex */
public class CommentEventsCollector {
    private List<CommentLine> BuiltInFictitiousFunctionClassFactory = new ArrayList();
    private final Queue<Event> MyBillsEntityDataFactory;
    private final CommentType[] getAuthRequestContext;

    public CommentEventsCollector(final Parser parser, CommentType... commentTypeArr) {
        this.MyBillsEntityDataFactory = new AbstractQueue<Event>() { // from class: org.yaml.snakeyaml.comments.CommentEventsCollector.1
            @Override // java.util.Queue
            public /* synthetic */ boolean offer(Object obj) {
                Event event = (Event) obj;
                return getAuthRequestContext();
            }

            private static boolean getAuthRequestContext() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<Event> iterator() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Queue
            public /* synthetic */ Object peek() {
                return parser.PlaceComponentResult();
            }

            @Override // java.util.Queue
            public /* synthetic */ Object poll() {
                return parser.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        };
        this.getAuthRequestContext = commentTypeArr;
    }

    private boolean MyBillsEntityDataFactory(Event event) {
        if (event != null && event.getAuthRequestContext(Event.ID.Comment)) {
            CommentEvent commentEvent = (CommentEvent) event;
            for (CommentType commentType : this.getAuthRequestContext) {
                if (commentEvent.getAuthRequestContext == commentType) {
                    return true;
                }
            }
        }
        return false;
    }

    public final List<CommentLine> KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            return this.BuiltInFictitiousFunctionClassFactory;
        } finally {
            this.BuiltInFictitiousFunctionClassFactory = new ArrayList();
        }
    }

    public final boolean PlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory.isEmpty();
    }

    public final CommentEventsCollector BuiltInFictitiousFunctionClassFactory() {
        while (MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.peek())) {
            this.BuiltInFictitiousFunctionClassFactory.add(new CommentLine((CommentEvent) this.MyBillsEntityDataFactory.poll()));
        }
        return this;
    }
}
