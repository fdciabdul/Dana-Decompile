package com.otaliastudios.cameraview.filters;

import android.opengl.GLES20;
import com.otaliastudios.cameraview.filter.BaseFilter;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import com.otaliastudios.cameraview.internal.GlUtils;

/* loaded from: classes8.dex */
public class GammaFilter extends BaseFilter implements OneParameterFilter {
    private float NetworkUserEntityData$$ExternalSyntheticLambda0 = 2.0f;
    private int scheduleImpl = -1;

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float gamma;\nvoid main() {\n  vec4 textureColor = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = vec4(pow(textureColor.rgb, vec3(gamma)), textureColor.w);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        super.BuiltInFictitiousFunctionClassFactory(i);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i, "gamma");
        this.scheduleImpl = glGetUniformLocation;
        GlUtils.PlaceComponentResult(glGetUniformLocation, "gamma");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory() {
        super.BuiltInFictitiousFunctionClassFactory();
        this.scheduleImpl = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public final void PlaceComponentResult(long j, float[] fArr) {
        super.PlaceComponentResult(j, fArr);
        GLES20.glUniform1f(this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        GlUtils.PlaceComponentResult("glUniform1f");
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0 / 2.0f;
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public final void getAuthRequestContext(float f) {
        float f2 = f * 2.0f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f2 <= 2.0f ? f2 : 2.0f;
    }
}
