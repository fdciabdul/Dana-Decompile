package com.otaliastudios.cameraview.filters;

import android.opengl.GLES20;
import com.alipay.mobile.embedview.mapbiz.core.H5MapRenderOptimizer;
import com.otaliastudios.cameraview.filter.BaseFilter;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import com.otaliastudios.cameraview.internal.GlUtils;

/* loaded from: classes8.dex */
public class TemperatureFilter extends BaseFilter implements OneParameterFilter {
    private float scheduleImpl = 1.0f;
    private int getErrorConfigVersion = -1;

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float scale;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  vec3 new_color = color.rgb;\n  new_color.r = color.r + color.r * ( 1.0 - color.r) * scale;\n  new_color.b = color.b - color.b * ( 1.0 - color.b) * scale;\n  if (scale > 0.0) { \n    new_color.g = color.g + color.g * ( 1.0 - color.g) * scale * 0.25;\n  }\n  float max_value = max(new_color.r, max(new_color.g, new_color.b));\n  if (max_value > 1.0) { \n     new_color /= max_value;\n  } \n  gl_FragColor = vec4(new_color, color.a);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        super.BuiltInFictitiousFunctionClassFactory(i);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i, H5MapRenderOptimizer.KEY_SCALE);
        this.getErrorConfigVersion = glGetUniformLocation;
        GlUtils.PlaceComponentResult(glGetUniformLocation, H5MapRenderOptimizer.KEY_SCALE);
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory() {
        super.BuiltInFictitiousFunctionClassFactory();
        this.getErrorConfigVersion = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public final void PlaceComponentResult(long j, float[] fArr) {
        super.PlaceComponentResult(j, fArr);
        GLES20.glUniform1f(this.getErrorConfigVersion, this.scheduleImpl);
        GlUtils.PlaceComponentResult("glUniform1f");
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
