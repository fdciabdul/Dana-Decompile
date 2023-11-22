package com.otaliastudios.cameraview.metering;

import android.graphics.PointF;
import android.graphics.RectF;
import com.otaliastudios.cameraview.size.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class MeteringRegions {
    final List<MeteringRegion> getAuthRequestContext;

    private MeteringRegions(List<MeteringRegion> list) {
        this.getAuthRequestContext = list;
    }

    public final MeteringRegions getAuthRequestContext(MeteringTransform meteringTransform) {
        ArrayList arrayList = new ArrayList();
        Iterator<MeteringRegion> it = this.getAuthRequestContext.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().PlaceComponentResult(meteringTransform));
        }
        return new MeteringRegions(arrayList);
    }

    public final <T> List<T> PlaceComponentResult(int i, MeteringTransform<T> meteringTransform) {
        ArrayList arrayList = new ArrayList();
        Collections.sort(this.getAuthRequestContext);
        for (MeteringRegion meteringRegion : this.getAuthRequestContext) {
            arrayList.add(meteringTransform.PlaceComponentResult(meteringRegion.MyBillsEntityDataFactory, meteringRegion.KClassImpl$Data$declaredNonStaticMembers$2));
        }
        return arrayList.subList(0, Math.min(i, arrayList.size()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MeteringRegions MyBillsEntityDataFactory(Size size, RectF rectF, boolean z) {
        ArrayList arrayList = new ArrayList();
        PointF pointF = new PointF(rectF.centerX(), rectF.centerY());
        float width = rectF.width();
        float height = rectF.height();
        arrayList.add(new MeteringRegion(rectF, 1000));
        if (z) {
            arrayList.add(new MeteringRegion(PlaceComponentResult(pointF, width * 1.5f, height * 1.5f), Math.round(100.0f)));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((MeteringRegion) it.next()).KClassImpl$Data$declaredNonStaticMembers$2(size));
        }
        return new MeteringRegions(arrayList2);
    }

    private static RectF PlaceComponentResult(PointF pointF, float f, float f2) {
        float f3 = f / 2.0f;
        float f4 = f2 / 2.0f;
        return new RectF(pointF.x - f3, pointF.y - f4, pointF.x + f3, pointF.y + f4);
    }

    public static MeteringRegions MyBillsEntityDataFactory(Size size, PointF pointF) {
        return MyBillsEntityDataFactory(size, PlaceComponentResult(pointF, size.BuiltInFictitiousFunctionClassFactory * 0.05f, size.getAuthRequestContext * 0.05f), true);
    }
}
