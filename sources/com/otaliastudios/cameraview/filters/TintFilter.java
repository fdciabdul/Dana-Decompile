package com.otaliastudios.cameraview.filters;

import android.graphics.Color;
import android.opengl.GLES20;
import com.otaliastudios.cameraview.filter.BaseFilter;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import com.otaliastudios.cameraview.internal.GlUtils;

/* loaded from: classes8.dex */
public class TintFilter extends BaseFilter implements OneParameterFilter {
    private int scheduleImpl = -65536;
    private int getErrorConfigVersion = -1;

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform vec3 tint;\nvec3 color_ratio;\nvarying vec2 vTextureCoord;\nvoid main() {\n  color_ratio[0] = 0.21;\n  color_ratio[1] = 0.71;\n  color_ratio[2] = 0.07;\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float avg_color = dot(color_ratio, color.rgb);\n  vec3 new_color = min(0.8 * avg_color + 0.2 * tint, 1.0);\n  gl_FragColor = vec4(new_color.rgb, color.a);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        super.BuiltInFictitiousFunctionClassFactory(i);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i, "tint");
        this.getErrorConfigVersion = glGetUniformLocation;
        GlUtils.PlaceComponentResult(glGetUniformLocation, "tint");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory() {
        super.BuiltInFictitiousFunctionClassFactory();
        this.getErrorConfigVersion = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public final void PlaceComponentResult(long j, float[] fArr) {
        super.PlaceComponentResult(j, fArr);
        GLES20.glUniform3fv(this.getErrorConfigVersion, 1, new float[]{Color.red(this.scheduleImpl) / 255.0f, Color.green(this.scheduleImpl) / 255.0f, Color.blue(this.scheduleImpl) / 255.0f}, 0);
        GlUtils.PlaceComponentResult("glUniform3fv");
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = this.scheduleImpl;
        return Color.argb(0, Color.red(i), Color.green(i), Color.blue(i)) / 1.6777215E7f;
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public final void getAuthRequestContext(float f) {
        int i = (int) (f * 1.6777215E7f);
        this.scheduleImpl = Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
    }
}
