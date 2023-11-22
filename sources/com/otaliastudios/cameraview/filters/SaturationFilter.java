package com.otaliastudios.cameraview.filters;

import android.opengl.GLES20;
import com.alipay.mobile.embedview.mapbiz.core.H5MapRenderOptimizer;
import com.otaliastudios.cameraview.filter.BaseFilter;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import com.otaliastudios.cameraview.internal.GlUtils;

/* loaded from: classes8.dex */
public class SaturationFilter extends BaseFilter implements OneParameterFilter {
    private float scheduleImpl = 1.0f;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
    private int getErrorConfigVersion = -1;

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float scale;\nuniform vec3 exponents;\nfloat shift;\nvec3 weights;\nvarying vec2 vTextureCoord;\nvoid main() {\n  weights[0] = 0.25;\n  weights[1] = 0.625;\n  weights[2] = 0.125;\n  shift = 0.003921569;\n  vec4 oldcolor = texture2D(sTexture, vTextureCoord);\n  float kv = dot(oldcolor.rgb, weights) + shift;\n  vec3 new_color = scale * oldcolor.rgb + (1.0 - scale) * kv;\n  gl_FragColor = vec4(new_color, oldcolor.a);\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float de = dot(color.rgb, weights);\n  float inv_de = 1.0 / de;\n  vec3 verynew_color = de * pow(color.rgb * inv_de, exponents);\n  float max_color = max(max(max(verynew_color.r, verynew_color.g), verynew_color.b), 1.0);\n  gl_FragColor = gl_FragColor+vec4(verynew_color / max_color, color.a);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        super.BuiltInFictitiousFunctionClassFactory(i);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i, H5MapRenderOptimizer.KEY_SCALE);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = glGetUniformLocation;
        GlUtils.PlaceComponentResult(glGetUniformLocation, H5MapRenderOptimizer.KEY_SCALE);
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i, "exponents");
        this.getErrorConfigVersion = glGetUniformLocation2;
        GlUtils.PlaceComponentResult(glGetUniformLocation2, "exponents");
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
        float f = this.scheduleImpl;
        if (f > 0.0f) {
            GLES20.glUniform1f(this.NetworkUserEntityData$$ExternalSyntheticLambda0, 0.0f);
            GlUtils.PlaceComponentResult("glUniform1f");
            int i = this.getErrorConfigVersion;
            float f2 = this.scheduleImpl;
            GLES20.glUniform3f(i, (0.9f * f2) + 1.0f, (2.1f * f2) + 1.0f, (f2 * 2.7f) + 1.0f);
            GlUtils.PlaceComponentResult("glUniform3f");
            return;
        }
        GLES20.glUniform1f(this.NetworkUserEntityData$$ExternalSyntheticLambda0, f + 1.0f);
        GlUtils.PlaceComponentResult("glUniform1f");
        GLES20.glUniform3f(this.getErrorConfigVersion, 0.0f, 0.0f, 0.0f);
        GlUtils.PlaceComponentResult("glUniform3f");
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        return (this.scheduleImpl + 1.0f) / 2.0f;
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public final void getAuthRequestContext(float f) {
        float f2 = (f * 2.0f) - 1.0f;
        if (f2 < -1.0f) {
            f2 = -1.0f;
        }
        this.scheduleImpl = f2 <= 1.0f ? f2 : 1.0f;
    }
}
