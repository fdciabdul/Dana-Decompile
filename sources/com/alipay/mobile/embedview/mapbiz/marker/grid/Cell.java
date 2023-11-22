package com.alipay.mobile.embedview.mapbiz.marker.grid;

import android.graphics.Point;
import com.alipay.mobile.embedview.mapbiz.marker.grid.CellTarget;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class Cell<T extends CellTarget> {
    public final Children children;
    public final Cell<? extends CellTarget> refer;
    public final T target;

    /* loaded from: classes6.dex */
    public static class Children extends ArrayList<Cell<? extends CellTarget>> {
    }

    public Cell(T t) {
        this.children = new Children();
        this.target = t;
        this.refer = null;
    }

    public Cell(T t, Cell<? extends CellTarget> cell) {
        this.children = new Children();
        this.target = t;
        this.refer = cell;
    }

    public Cell<? extends CellTarget> merge(List<Cell<T>> list, int i) {
        Point point = this.target.toPoint();
        if (point == null) {
            return this;
        }
        int i2 = point.x;
        int i3 = point.x;
        int i4 = point.y;
        int i5 = point.y;
        ArrayList<Cell> arrayList = new ArrayList();
        int i6 = 0;
        int i7 = 0;
        for (Cell<T> cell : list) {
            T t = cell.target;
            if (t != null) {
                Point point2 = t.toPoint();
                if (point2.x >= i2 - i && point2.x <= i3 + i && point2.y >= i4 - i && point2.y <= i5 + i) {
                    arrayList.add(cell);
                    i6 += point2.x;
                    i7 += point2.y;
                }
            }
        }
        int size = arrayList.size();
        if (size <= 1) {
            return this;
        }
        int i8 = i6 / size;
        int i9 = i7 / size;
        Cell cell2 = null;
        double d = -1.0d;
        for (Cell cell3 : arrayList) {
            Point point3 = cell3.target.toPoint();
            int i10 = point3.x - i8;
            int i11 = point3.y - i9;
            double sqrt = Math.sqrt((i10 * i10) + (i11 * i11));
            if (d > sqrt || d == -1.0d) {
                cell2 = cell3;
                d = sqrt;
            }
        }
        Cell<? extends CellTarget> cell4 = new Cell<>(new SimpleCellTarget(i8, i9), cell2);
        cell4.children.addAll(arrayList);
        return cell4;
    }
}
