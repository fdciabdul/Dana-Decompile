package com.otaliastudios.cameraview.engine.metering;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.offset.Angles;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.metering.MeteringTransform;
import com.otaliastudios.cameraview.size.AspectRatio;
import com.otaliastudios.cameraview.size.Size;

/* loaded from: classes8.dex */
public class Camera2MeteringTransform implements MeteringTransform<MeteringRectangle> {
    protected static final CameraLogger KClassImpl$Data$declaredNonStaticMembers$2 = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("Camera2MeteringTransform");
    private final Angles BuiltInFictitiousFunctionClassFactory;
    private final boolean MyBillsEntityDataFactory;
    private final CaptureRequest.Builder PlaceComponentResult;
    private final CameraCharacteristics getAuthRequestContext;
    private final Size moveToNextValue;
    private final Size scheduleImpl;

    public Camera2MeteringTransform(Angles angles, Size size, Size size2, boolean z, CameraCharacteristics cameraCharacteristics, CaptureRequest.Builder builder) {
        this.BuiltInFictitiousFunctionClassFactory = angles;
        this.moveToNextValue = size;
        this.scheduleImpl = size2;
        this.MyBillsEntityDataFactory = z;
        this.getAuthRequestContext = cameraCharacteristics;
        this.PlaceComponentResult = builder;
    }

    @Override // com.otaliastudios.cameraview.metering.MeteringTransform
    public final PointF KClassImpl$Data$declaredNonStaticMembers$2(PointF pointF) {
        int width;
        int height;
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        Size size = this.moveToNextValue;
        Size size2 = this.scheduleImpl;
        int i = size.BuiltInFictitiousFunctionClassFactory;
        int i2 = size.getAuthRequestContext;
        AspectRatio MyBillsEntityDataFactory = AspectRatio.MyBillsEntityDataFactory(size2);
        AspectRatio MyBillsEntityDataFactory2 = AspectRatio.MyBillsEntityDataFactory(size);
        if (this.MyBillsEntityDataFactory) {
            if (MyBillsEntityDataFactory.getAuthRequestContext / MyBillsEntityDataFactory.MyBillsEntityDataFactory > MyBillsEntityDataFactory2.getAuthRequestContext / MyBillsEntityDataFactory2.MyBillsEntityDataFactory) {
                float f = (MyBillsEntityDataFactory.getAuthRequestContext / MyBillsEntityDataFactory.MyBillsEntityDataFactory) / (MyBillsEntityDataFactory2.getAuthRequestContext / MyBillsEntityDataFactory2.MyBillsEntityDataFactory);
                pointF2.x += (size.BuiltInFictitiousFunctionClassFactory * (f - 1.0f)) / 2.0f;
                i = Math.round(size.BuiltInFictitiousFunctionClassFactory * f);
            } else {
                float f2 = (MyBillsEntityDataFactory2.getAuthRequestContext / MyBillsEntityDataFactory2.MyBillsEntityDataFactory) / (MyBillsEntityDataFactory.getAuthRequestContext / MyBillsEntityDataFactory.MyBillsEntityDataFactory);
                pointF2.y += (size.getAuthRequestContext * (f2 - 1.0f)) / 2.0f;
                i2 = Math.round(size.getAuthRequestContext * f2);
            }
        }
        Size size3 = new Size(i, i2);
        Size size4 = this.scheduleImpl;
        pointF2.x *= size4.BuiltInFictitiousFunctionClassFactory / size3.BuiltInFictitiousFunctionClassFactory;
        pointF2.y *= size4.getAuthRequestContext / size3.getAuthRequestContext;
        int KClassImpl$Data$declaredNonStaticMembers$22 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(Reference.SENSOR, Reference.VIEW, Axis.ABSOLUTE);
        boolean z = KClassImpl$Data$declaredNonStaticMembers$22 % 180 != 0;
        float f3 = pointF2.x;
        float f4 = pointF2.y;
        if (KClassImpl$Data$declaredNonStaticMembers$22 == 0) {
            pointF2.x = f3;
            pointF2.y = f4;
        } else if (KClassImpl$Data$declaredNonStaticMembers$22 == 90) {
            pointF2.x = f4;
            pointF2.y = size4.BuiltInFictitiousFunctionClassFactory - f3;
        } else if (KClassImpl$Data$declaredNonStaticMembers$22 == 180) {
            pointF2.x = size4.BuiltInFictitiousFunctionClassFactory - f3;
            pointF2.y = size4.getAuthRequestContext - f4;
        } else if (KClassImpl$Data$declaredNonStaticMembers$22 == 270) {
            pointF2.x = size4.getAuthRequestContext - f4;
            pointF2.y = f3;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected angle ");
            sb.append(KClassImpl$Data$declaredNonStaticMembers$22);
            throw new IllegalStateException(sb.toString());
        }
        if (z) {
            size4 = new Size(size4.getAuthRequestContext, size4.BuiltInFictitiousFunctionClassFactory);
        }
        Rect rect = (Rect) this.PlaceComponentResult.get(CaptureRequest.SCALER_CROP_REGION);
        if (rect != null) {
            width = rect.width();
        } else {
            width = size4.BuiltInFictitiousFunctionClassFactory;
        }
        if (rect != null) {
            height = rect.height();
        } else {
            height = size4.getAuthRequestContext;
        }
        pointF2.x += (width - size4.BuiltInFictitiousFunctionClassFactory) / 2.0f;
        pointF2.y += (height - size4.getAuthRequestContext) / 2.0f;
        Size size5 = new Size(width, height);
        Rect rect2 = (Rect) this.PlaceComponentResult.get(CaptureRequest.SCALER_CROP_REGION);
        pointF2.x += rect2 == null ? 0.0f : rect2.left;
        pointF2.y += rect2 == null ? 0.0f : rect2.top;
        Rect rect3 = (Rect) this.getAuthRequestContext.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (rect3 == null) {
            rect3 = new Rect(0, 0, size5.BuiltInFictitiousFunctionClassFactory, size5.getAuthRequestContext);
        }
        Size size6 = new Size(rect3.width(), rect3.height());
        CameraLogger cameraLogger = KClassImpl$Data$declaredNonStaticMembers$2;
        cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "input:", pointF, "output (before clipping):", pointF2);
        if (pointF2.x < 0.0f) {
            pointF2.x = 0.0f;
        }
        if (pointF2.y < 0.0f) {
            pointF2.y = 0.0f;
        }
        if (pointF2.x > size6.BuiltInFictitiousFunctionClassFactory) {
            pointF2.x = size6.BuiltInFictitiousFunctionClassFactory;
        }
        if (pointF2.y > size6.getAuthRequestContext) {
            pointF2.y = size6.getAuthRequestContext;
        }
        cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "input:", pointF, "output (after clipping):", pointF2);
        return pointF2;
    }

    @Override // com.otaliastudios.cameraview.metering.MeteringTransform
    public final /* synthetic */ MeteringRectangle PlaceComponentResult(RectF rectF, int i) {
        Rect rect = new Rect();
        rectF.round(rect);
        return new MeteringRectangle(rect, i);
    }
}
