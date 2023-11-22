package com.otaliastudios.cameraview.preview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.R;
import com.otaliastudios.cameraview.preview.CameraPreview;

/* loaded from: classes2.dex */
public class SurfaceCameraPreview extends CameraPreview<SurfaceView, SurfaceHolder> {
    private static final CameraLogger DatabaseTableConfigUtil = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("SurfaceCameraPreview");
    private View NetworkUserEntityData$$ExternalSyntheticLambda2;
    private boolean initRecordTimeStamp;

    public SurfaceCameraPreview(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    final View MyBillsEntityDataFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public final Class<SurfaceHolder> KClassImpl$Data$declaredNonStaticMembers$2() {
        return SurfaceHolder.class;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public final /* synthetic */ SurfaceHolder getAuthRequestContext() {
        return ((SurfaceView) this.lookAheadTest).getHolder();
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    protected final /* synthetic */ SurfaceView PlaceComponentResult(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.cameraview_surface_view, viewGroup, false);
        viewGroup.addView(inflate, 0);
        SurfaceView surfaceView = (SurfaceView) inflate.findViewById(R.id.res_0x7f0a12a1_kclassimpl_data_declarednonstaticmembers_2);
        SurfaceHolder holder = surfaceView.getHolder();
        holder.setType(3);
        holder.addCallback(new SurfaceHolder.Callback() { // from class: com.otaliastudios.cameraview.preview.SurfaceCameraPreview.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                SurfaceCameraPreview.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1, "callback:", "surfaceChanged", "w:", Integer.valueOf(i2), "h:", Integer.valueOf(i3), "dispatched:", Boolean.valueOf(SurfaceCameraPreview.this.initRecordTimeStamp));
                if (!SurfaceCameraPreview.this.initRecordTimeStamp) {
                    SurfaceCameraPreview.this.BuiltInFictitiousFunctionClassFactory(i2, i3);
                    SurfaceCameraPreview.this.initRecordTimeStamp = true;
                    return;
                }
                SurfaceCameraPreview.this.MyBillsEntityDataFactory(i2, i3);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                SurfaceCameraPreview.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1, "callback:", "surfaceDestroyed");
                SurfaceCameraPreview surfaceCameraPreview = SurfaceCameraPreview.this;
                surfaceCameraPreview.getErrorConfigVersion = 0;
                surfaceCameraPreview.scheduleImpl = 0;
                CameraPreview.SurfaceCallback surfaceCallback = surfaceCameraPreview.moveToNextValue;
                if (surfaceCallback != null) {
                    surfaceCallback.X();
                }
                SurfaceCameraPreview.this.initRecordTimeStamp = false;
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = inflate;
        return surfaceView;
    }
}
