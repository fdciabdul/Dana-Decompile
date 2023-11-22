package com.otaliastudios.cameraview.filters;

import android.opengl.GLES20;
import com.otaliastudios.cameraview.filter.BaseFilter;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import com.otaliastudios.cameraview.internal.GlUtils;

/* loaded from: classes8.dex */
public class FillLightFilter extends BaseFilter implements OneParameterFilter {
    private float scheduleImpl = 0.5f;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
    private int getErrorConfigVersion = -1;

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float mult;\nuniform float igamma;\nvarying vec2 vTextureCoord;\nvoid main() {\n  const vec3 color_weights = vec3(0.25, 0.5, 0.25);\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float lightmask = dot(color.rgb, color_weights);\n  float backmask = (1.0 - lightmask);\n  vec3 ones = vec3(1.0, 1.0, 1.0);\n  vec3 diff = pow(mult * color.rgb, igamma * ones) - color.rgb;\n  diff = min(diff, 1.0);\n  vec3 new_color = min(color.rgb + diff * backmask, 1.0);\n  gl_FragColor = vec4(new_color, color.a);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        super.BuiltInFictitiousFunctionClassFactory(i);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i, "mult");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = glGetUniformLocation;
        GlUtils.PlaceComponentResult(glGetUniformLocation, "mult");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i, "igamma");
        this.getErrorConfigVersion = glGetUniformLocation2;
        GlUtils.PlaceComponentResult(glGetUniformLocation2, "igamma");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory() {
        super.BuiltInFictitiousFunctionClassFactory();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
        this.getErrorConfigVersion = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public final void PlaceComponentResult(long j, float[] fArr) {
        super.PlaceComponentResult(j, fArr);
        float f = 1.0f / (((1.0f - this.scheduleImpl) * 0.7f) + 0.3f);
        GLES20.glUniform1f(this.NetworkUserEntityData$$ExternalSyntheticLambda0, f);
        GlUtils.PlaceComponentResult("glUniform1f");
        GLES20.glUniform1f(this.getErrorConfigVersion, 1.0f / ((f * 0.7f) + 0.3f));
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
