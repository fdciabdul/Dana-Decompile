package com.otaliastudios.cameraview.filters;

import android.opengl.GLES20;
import com.alipay.mobile.embedview.mapbiz.core.H5MapRenderOptimizer;
import com.otaliastudios.cameraview.filter.BaseFilter;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import com.otaliastudios.cameraview.internal.GlUtils;

/* loaded from: classes8.dex */
public class SharpnessFilter extends BaseFilter implements OneParameterFilter {
    private float scheduleImpl = 0.5f;
    private int GetContactSyncConfig = 1;
    private int getErrorConfigVersion = 1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
    private int initRecordTimeStamp = -1;

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float scale;\nuniform float stepsizeX;\nuniform float stepsizeY;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 nbr_color = vec3(0.0, 0.0, 0.0);\n  vec2 coord;\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  coord.x = vTextureCoord.x - 0.5 * stepsizeX;\n  coord.y = vTextureCoord.y - stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = vTextureCoord.x - stepsizeX;\n  coord.y = vTextureCoord.y + 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = vTextureCoord.x + stepsizeX;\n  coord.y = vTextureCoord.y - 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = vTextureCoord.x + stepsizeX;\n  coord.y = vTextureCoord.y + 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  gl_FragColor = vec4(color.rgb - 2.0 * scale * nbr_color, color.a);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(i, i2);
        this.GetContactSyncConfig = i;
        this.getErrorConfigVersion = i2;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        super.BuiltInFictitiousFunctionClassFactory(i);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i, H5MapRenderOptimizer.KEY_SCALE);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = glGetUniformLocation;
        GlUtils.PlaceComponentResult(glGetUniformLocation, H5MapRenderOptimizer.KEY_SCALE);
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i, "stepsizeX");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = glGetUniformLocation2;
        GlUtils.PlaceComponentResult(glGetUniformLocation2, "stepsizeX");
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(i, "stepsizeY");
        this.initRecordTimeStamp = glGetUniformLocation3;
        GlUtils.PlaceComponentResult(glGetUniformLocation3, "stepsizeY");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory() {
        super.BuiltInFictitiousFunctionClassFactory();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
        this.initRecordTimeStamp = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public final void PlaceComponentResult(long j, float[] fArr) {
        super.PlaceComponentResult(j, fArr);
        GLES20.glUniform1f(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.scheduleImpl);
        GlUtils.PlaceComponentResult("glUniform1f");
        GLES20.glUniform1f(this.NetworkUserEntityData$$ExternalSyntheticLambda1, 1.0f / this.GetContactSyncConfig);
        GlUtils.PlaceComponentResult("glUniform1f");
        GLES20.glUniform1f(this.initRecordTimeStamp, 1.0f / this.getErrorConfigVersion);
        GlUtils.PlaceComponentResult("glUniform1f");
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public final void getAuthRequestContext(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.scheduleImpl = f;
    }
}
