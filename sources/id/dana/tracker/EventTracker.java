package id.dana.tracker;

import id.dana.analytics.tracker.EventStrategy;
import id.dana.tracker.EventTrackerModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class EventTracker {
    private EventTracker() {
    }

    public static void BuiltInFictitiousFunctionClassFactory(EventStrategy... eventStrategyArr) {
        for (EventStrategy eventStrategy : eventStrategyArr) {
            eventStrategy.PlaceComponentResult();
        }
    }

    public static void PlaceComponentResult(EventTrackerModel eventTrackerModel) {
        if (eventTrackerModel != null) {
            EventTrackerModel.Builder builder = eventTrackerModel.getAuthRequestContext;
            List arrayList = builder != null ? builder.PlaceComponentResult : new ArrayList();
            for (EventStrategy eventStrategy : (EventStrategy[]) arrayList.toArray(new EventStrategy[arrayList.size()])) {
                eventStrategy.PlaceComponentResult();
            }
        }
    }
}
