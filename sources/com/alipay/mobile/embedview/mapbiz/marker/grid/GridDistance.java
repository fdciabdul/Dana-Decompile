package com.alipay.mobile.embedview.mapbiz.marker.grid;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class GridDistance {
    public static List<Cell> cluster(List<Cell> list, int i) {
        ArrayList arrayList = new ArrayList(list);
        ArrayList arrayList2 = new ArrayList();
        for (Cell cell : list) {
            if (arrayList.contains(cell)) {
                Cell<? extends CellTarget> merge = cell.merge(arrayList, i);
                if (merge.children.isEmpty()) {
                    arrayList.remove(cell);
                } else {
                    arrayList.removeAll(merge.children);
                }
                arrayList2.add(merge);
            }
        }
        return arrayList2;
    }
}
