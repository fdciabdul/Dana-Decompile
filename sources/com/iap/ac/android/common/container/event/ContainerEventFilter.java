package com.iap.ac.android.common.container.event;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class ContainerEventFilter {
    public Set<String> actions = new HashSet();

    public Iterator<String> actionIterator() {
        return this.actions.iterator();
    }

    public void addAction(String str) {
        this.actions.add(str);
    }

    public void setEventsList(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.actions.addAll(list);
    }
}
