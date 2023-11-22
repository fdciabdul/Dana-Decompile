package io.split.android.client;

import io.split.android.client.SplitFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class FilterGrouper {
    public List<SplitFilter> group(List<SplitFilter> list) {
        HashMap hashMap = new HashMap();
        for (SplitFilter splitFilter : list) {
            List list2 = (List) hashMap.get(splitFilter.getType());
            if (list2 == null) {
                list2 = new ArrayList();
                hashMap.put(splitFilter.getType(), list2);
            }
            list2.addAll(splitFilter.getValues());
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (((List) entry.getValue()).size() > 0) {
                arrayList.add(new SplitFilter((SplitFilter.Type) entry.getKey(), (List) entry.getValue()));
            }
        }
        return arrayList;
    }
}
