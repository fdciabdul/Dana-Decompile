package com.otaliastudios.cameraview.metering;

import android.graphics.PointF;
import android.graphics.RectF;
import com.otaliastudios.cameraview.size.Size;

/* loaded from: classes8.dex */
class MeteringRegion implements Comparable<MeteringRegion> {
    final int KClassImpl$Data$declaredNonStaticMembers$2;
    final RectF MyBillsEntityDataFactory;

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(MeteringRegion meteringRegion) {
        return -Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2).compareTo(Integer.valueOf(meteringRegion.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MeteringRegion(RectF rectF, int i) {
        this.MyBillsEntityDataFactory = rectF;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MeteringRegion PlaceComponentResult(MeteringTransform meteringTransform) {
        RectF rectF = new RectF(Float.MAX_VALUE, Float.MAX_VALUE, -3.4028235E38f, -3.4028235E38f);
        PointF pointF = new PointF();
        pointF.set(this.MyBillsEntityDataFactory.left, this.MyBillsEntityDataFactory.top);
        PointF KClassImpl$Data$declaredNonStaticMembers$2 = meteringTransform.KClassImpl$Data$declaredNonStaticMembers$2(pointF);
        PlaceComponentResult(rectF, KClassImpl$Data$declaredNonStaticMembers$2);
        KClassImpl$Data$declaredNonStaticMembers$2.set(this.MyBillsEntityDataFactory.right, this.MyBillsEntityDataFactory.top);
        PointF KClassImpl$Data$declaredNonStaticMembers$22 = meteringTransform.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2);
        PlaceComponentResult(rectF, KClassImpl$Data$declaredNonStaticMembers$22);
        KClassImpl$Data$declaredNonStaticMembers$22.set(this.MyBillsEntityDataFactory.right, this.MyBillsEntityDataFactory.bottom);
        PointF KClassImpl$Data$declaredNonStaticMembers$23 = meteringTransform.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22);
        PlaceComponentResult(rectF, KClassImpl$Data$declaredNonStaticMembers$23);
        KClassImpl$Data$declaredNonStaticMembers$23.set(this.MyBillsEntityDataFactory.left, this.MyBillsEntityDataFactory.bottom);
        PlaceComponentResult(rectF, meteringTransform.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$23));
        return new MeteringRegion(rectF, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    private static void PlaceComponentResult(RectF rectF, PointF pointF) {
        rectF.left = Math.min(rectF.left, pointF.x);
        rectF.top = Math.min(rectF.top, pointF.y);
        rectF.right = Math.max(rectF.right, pointF.x);
        rectF.bottom = Math.max(rectF.bottom, pointF.y);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MeteringRegion KClassImpl$Data$declaredNonStaticMembers$2(Size size) {
        RectF rectF = new RectF(0.0f, 0.0f, size.BuiltInFictitiousFunctionClassFactory, size.getAuthRequestContext);
        RectF rectF2 = new RectF();
        rectF2.set(Math.max(rectF.left, this.MyBillsEntityDataFactory.left), Math.max(rectF.top, this.MyBillsEntityDataFactory.top), Math.min(rectF.right, this.MyBillsEntityDataFactory.right), Math.min(rectF.bottom, this.MyBillsEntityDataFactory.bottom));
        return new MeteringRegion(rectF2, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
