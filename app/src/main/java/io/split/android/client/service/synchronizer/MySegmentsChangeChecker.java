package io.split.android.client.service.synchronizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes6.dex */
public class MySegmentsChangeChecker {
    public boolean mySegmentsHaveChanged(List<String> list, List<String> list2) {
        ArrayList arrayList = new ArrayList(list);
        ArrayList arrayList2 = new ArrayList(list2);
        Collections.sort(arrayList);
        Collections.sort(arrayList2);
        return !arrayList.equals(arrayList2);
    }
}
