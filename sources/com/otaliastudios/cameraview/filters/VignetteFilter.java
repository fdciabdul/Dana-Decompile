package com.otaliastudios.cameraview.filters;

import android.opengl.GLES20;
import com.alipay.mobile.embedview.mapbiz.core.H5MapRenderOptimizer;
import com.otaliastudios.cameraview.filter.BaseFilter;
import com.otaliastudios.cameraview.filter.TwoParameterFilter;
import com.otaliastudios.cameraview.internal.GlUtils;

/* loaded from: classes8.dex */
public class VignetteFilter extends BaseFilter implements TwoParameterFilter {
    private float NetworkUserEntityData$$ExternalSyntheticLambda2 = 0.85f;
    private float NetworkUserEntityData$$ExternalSyntheticLambda1 = 0.5f;
    private int GetContactSyncConfig = 1;
    private int scheduleImpl = 1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
    private int getErrorConfigVersion = -1;
    private int initRecordTimeStamp = -1;
    private int DatabaseTableConfigUtil = -1;

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float range;\nuniform float inv_max_dist;\nuniform float shade;\nuniform vec2 scale;\nvarying vec2 vTextureCoord;\nvoid main() {\n  const float slope = 20.0;\n  vec2 coord = vTextureCoord - vec2(0.5, 0.5);\n  float dist = length(coord * scale);\n  float lumen = shade / (1.0 + exp((dist * inv_max_dist - range) * slope)) + (1.0 - shade);\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = vec4(color.rgb * lumen, color.a);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(i, i2);
        this.GetContactSyncConfig = i;
        this.scheduleImpl = i2;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        super.BuiltInFictitiousFunctionClassFactory(i);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i, "range");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = glGetUniformLocation;
        GlUtils.PlaceComponentResult(glGetUniformLocation, "range");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i, "inv_max_dist");
        this.getErrorConfigVersion = glGetUniformLocation2;
        GlUtils.PlaceComponentResult(glGetUniformLocation2, "inv_max_dist");
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(i, "shade");
        this.initRecordTimeStamp = glGetUniformLocation3;
        GlUtils.PlaceComponentResult(glGetUniformLocation3, "shade");
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(i, H5MapRenderOptimizer.KEY_SCALE);
        this.DatabaseTableConfigUtil = glGetUniformLocation4;
        GlUtils.PlaceComponentResult(glGetUniformLocation4, H5MapRenderOptimizer.KEY_SCALE);
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory() {
        super.BuiltInFictitiousFunctionClassFactory();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
        this.getErrorConfigVersion = -1;
        this.initRecordTimeStamp = -1;
        this.DatabaseTableConfigUtil = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public final void PlaceComponentResult(long j, float[] fArr) {
        super.PlaceComponentResult(j, fArr);
        float[] fArr2 = new float[2];
        int i = this.GetContactSyncConfig;
        int i2 = this.scheduleImpl;
        if (i > i2) {
            fArr2[0] = 1.0f;
            fArr2[1] = i2 / i;
        } else {
            fArr2[0] = i / i2;
            fArr2[1] = 1.0f;
        }
        GLES20.glUniform2fv(this.DatabaseTableConfigUtil, 1, fArr2, 0);
        GlUtils.PlaceComponentResult("glUniform2fv");
        float f = fArr2[0];
        float f2 = fArr2[1];
        GLES20.glUniform1f(this.getErrorConfigVersion, 1.0f / (((float) Math.sqrt((f * f) + (f2 * f2))) * 0.5f));
        GlUtils.PlaceComponentResult("glUniform1f");
        GLES20.glUniform1f(this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        GlUtils.PlaceComponentResult("glUniform1f");
        GLES20.glUniform1f(this.NetworkUserEntityData$$ExternalSyntheticLambda0, 1.3f - (((float) Math.sqrt(this.NetworkUserEntityData$$ExternalSyntheticLambda2)) * 0.7f));
        GlUtils.PlaceComponentResult("glUniform1f");
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    @Override // com.otaliastudios.cameraview.filter.TwoParameterFilter
    public final float MyBillsEntityDataFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public final void getAuthRequestContext(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = f;
    }

    @Override // com.otaliastudios.cameraview.filter.TwoParameterFilter
    public final void PlaceComponentResult(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = f;
    }
}
