package com.otaliastudios.cameraview.engine.metering;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.offset.Angles;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.metering.MeteringTransform;
import com.otaliastudios.cameraview.size.Size;

/* loaded from: classes8.dex */
public class Camera1MeteringTransform implements MeteringTransform<Camera.Area> {
    protected static final CameraLogger KClassImpl$Data$declaredNonStaticMembers$2 = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("Camera1MeteringTransform");
    private final Size BuiltInFictitiousFunctionClassFactory;
    private final int PlaceComponentResult;

    public Camera1MeteringTransform(Angles angles, Size size) {
        this.PlaceComponentResult = -angles.KClassImpl$Data$declaredNonStaticMembers$2(Reference.SENSOR, Reference.VIEW, Axis.ABSOLUTE);
        this.BuiltInFictitiousFunctionClassFactory = size;
    }

    @Override // com.otaliastudios.cameraview.metering.MeteringTransform
    public final PointF KClassImpl$Data$declaredNonStaticMembers$2(PointF pointF) {
        PointF pointF2 = new PointF();
        pointF2.x = ((pointF.x / this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory) * 2000.0f) - 1000.0f;
        pointF2.y = ((pointF.y / this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext) * 2000.0f) - 1000.0f;
        PointF pointF3 = new PointF();
        double d = this.PlaceComponentResult;
        Double.isNaN(d);
        double d2 = (d * 3.141592653589793d) / 180.0d;
        double d3 = pointF2.x;
        double cos = Math.cos(d2);
        double d4 = pointF2.y;
        double sin = Math.sin(d2);
        Double.isNaN(d3);
        Double.isNaN(d4);
        pointF3.x = (float) ((d3 * cos) - (d4 * sin));
        double d5 = pointF2.x;
        double sin2 = Math.sin(d2);
        double d6 = pointF2.y;
        double cos2 = Math.cos(d2);
        Double.isNaN(d5);
        Double.isNaN(d6);
        pointF3.y = (float) ((d5 * sin2) + (d6 * cos2));
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "scaled:", pointF2, "rotated:", pointF3);
        return pointF3;
    }

    @Override // com.otaliastudios.cameraview.metering.MeteringTransform
    public final /* synthetic */ Camera.Area PlaceComponentResult(RectF rectF, int i) {
        Rect rect = new Rect();
        rectF.round(rect);
        return new Camera.Area(rect, i);
    }
}
