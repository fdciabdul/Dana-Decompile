package com.otaliastudios.cameraview.preview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.R;
import com.otaliastudios.cameraview.preview.CameraPreview;
import com.otaliastudios.cameraview.size.AspectRatio;
import java.util.concurrent.ExecutionException;

/* loaded from: classes2.dex */
public class TextureCameraPreview extends CameraPreview<TextureView, SurfaceTexture> {
    private View initRecordTimeStamp;

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public final boolean scheduleImpl() {
        return true;
    }

    public TextureCameraPreview(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    final View MyBillsEntityDataFactory() {
        return this.initRecordTimeStamp;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public final Class<SurfaceTexture> KClassImpl$Data$declaredNonStaticMembers$2() {
        return SurfaceTexture.class;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public final void MyBillsEntityDataFactory(final int i) {
        super.MyBillsEntityDataFactory(i);
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ((TextureView) this.lookAheadTest).post(new Runnable() { // from class: com.otaliastudios.cameraview.preview.TextureCameraPreview.3
            @Override // java.lang.Runnable
            public void run() {
                Matrix matrix = new Matrix();
                float f = TextureCameraPreview.this.getErrorConfigVersion / 2.0f;
                float f2 = TextureCameraPreview.this.scheduleImpl / 2.0f;
                if (i % 180 != 0) {
                    float f3 = TextureCameraPreview.this.scheduleImpl / TextureCameraPreview.this.getErrorConfigVersion;
                    matrix.postScale(f3, 1.0f / f3, f, f2);
                }
                matrix.postRotate(i, f, f2);
                ((TextureView) TextureCameraPreview.this.lookAheadTest).setTransform(matrix);
                taskCompletionSource.setResult(null);
            }
        });
        try {
            Tasks.await(taskCompletionSource.getTask());
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    protected final void PlaceComponentResult(final CameraPreview.CropCallback cropCallback) {
        ((TextureView) this.lookAheadTest).post(new Runnable() { // from class: com.otaliastudios.cameraview.preview.TextureCameraPreview.2
            @Override // java.lang.Runnable
            public void run() {
                float f;
                if (TextureCameraPreview.this.getAuthRequestContext == 0 || TextureCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda0 == 0 || TextureCameraPreview.this.scheduleImpl == 0 || TextureCameraPreview.this.getErrorConfigVersion == 0) {
                    return;
                }
                AspectRatio BuiltInFictitiousFunctionClassFactory = AspectRatio.BuiltInFictitiousFunctionClassFactory(TextureCameraPreview.this.getErrorConfigVersion, TextureCameraPreview.this.scheduleImpl);
                AspectRatio BuiltInFictitiousFunctionClassFactory2 = AspectRatio.BuiltInFictitiousFunctionClassFactory(TextureCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda0, TextureCameraPreview.this.getAuthRequestContext);
                float f2 = 1.0f;
                if (BuiltInFictitiousFunctionClassFactory.getAuthRequestContext / BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory >= BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext / BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory) {
                    f = (BuiltInFictitiousFunctionClassFactory.getAuthRequestContext / BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory) / (BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext / BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory);
                } else {
                    f2 = (BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext / BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory) / (BuiltInFictitiousFunctionClassFactory.getAuthRequestContext / BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
                    f = 1.0f;
                }
                ((TextureView) TextureCameraPreview.this.lookAheadTest).setScaleX(f2);
                ((TextureView) TextureCameraPreview.this.lookAheadTest).setScaleY(f);
                TextureCameraPreview.this.PlaceComponentResult = f2 > 1.02f || f > 1.02f;
                CameraPreview.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "crop:", "applied scaleX=", Float.valueOf(f2));
                CameraPreview.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "crop:", "applied scaleY=", Float.valueOf(f));
            }
        });
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public final /* synthetic */ SurfaceTexture getAuthRequestContext() {
        return ((TextureView) this.lookAheadTest).getSurfaceTexture();
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    protected final /* synthetic */ TextureView PlaceComponentResult(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.cameraview_texture_view, viewGroup, false);
        viewGroup.addView(inflate, 0);
        TextureView textureView = (TextureView) inflate.findViewById(R.id.MyBillsEntityDataFactory_res_0x7f0a130e);
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.otaliastudios.cameraview.preview.TextureCameraPreview.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TextureCameraPreview.this.BuiltInFictitiousFunctionClassFactory(i, i2);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                TextureCameraPreview.this.MyBillsEntityDataFactory(i, i2);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                TextureCameraPreview textureCameraPreview = TextureCameraPreview.this;
                textureCameraPreview.getErrorConfigVersion = 0;
                textureCameraPreview.scheduleImpl = 0;
                CameraPreview.SurfaceCallback surfaceCallback = textureCameraPreview.moveToNextValue;
                if (surfaceCallback != null) {
                    surfaceCallback.X();
                    return true;
                }
                return true;
            }
        });
        this.initRecordTimeStamp = inflate;
        return textureView;
    }
}
