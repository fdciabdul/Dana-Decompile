package com.otaliastudios.cameraview.filters;

import android.graphics.Color;
import android.opengl.GLES20;
import com.otaliastudios.cameraview.filter.BaseFilter;
import com.otaliastudios.cameraview.filter.TwoParameterFilter;
import com.otaliastudios.cameraview.internal.GlUtils;

/* loaded from: classes8.dex */
public class DuotoneFilter extends BaseFilter implements TwoParameterFilter {
    private int NetworkUserEntityData$$ExternalSyntheticLambda0 = -65281;
    private int getErrorConfigVersion = -256;
    private int scheduleImpl = -1;
    private int DatabaseTableConfigUtil = -1;

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform vec3 first;\nuniform vec3 second;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float energy = (color.r + color.g + color.b) * 0.3333;\n  vec3 new_color = (1.0 - energy) * first + energy * second;\n  gl_FragColor = vec4(new_color.rgb, color.a);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        super.BuiltInFictitiousFunctionClassFactory(i);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i, "first");
        this.scheduleImpl = glGetUniformLocation;
        GlUtils.PlaceComponentResult(glGetUniformLocation, "first");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i, "second");
        this.DatabaseTableConfigUtil = glGetUniformLocation2;
        GlUtils.PlaceComponentResult(glGetUniformLocation2, "second");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public final void PlaceComponentResult(long j, float[] fArr) {
        super.PlaceComponentResult(j, fArr);
        GLES20.glUniform3fv(this.scheduleImpl, 1, new float[]{Color.red(this.NetworkUserEntityData$$ExternalSyntheticLambda0) / 255.0f, Color.green(this.NetworkUserEntityData$$ExternalSyntheticLambda0) / 255.0f, Color.blue(this.NetworkUserEntityData$$ExternalSyntheticLambda0) / 255.0f}, 0);
        GlUtils.PlaceComponentResult("glUniform3fv");
        GLES20.glUniform3fv(this.DatabaseTableConfigUtil, 1, new float[]{Color.red(this.getErrorConfigVersion) / 255.0f, Color.green(this.getErrorConfigVersion) / 255.0f, Color.blue(this.getErrorConfigVersion) / 255.0f}, 0);
        GlUtils.PlaceComponentResult("glUniform3fv");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory() {
        super.BuiltInFictitiousFunctionClassFactory();
        this.scheduleImpl = -1;
        this.DatabaseTableConfigUtil = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        return Color.argb(0, Color.red(i), Color.green(i), Color.blue(i)) / 1.6777215E7f;
    }

    @Override // com.otaliastudios.cameraview.filter.TwoParameterFilter
    public final float MyBillsEntityDataFactory() {
        int i = this.getErrorConfigVersion;
        return Color.argb(0, Color.red(i), Color.green(i), Color.blue(i)) / 1.6777215E7f;
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public final void getAuthRequestContext(float f) {
        int i = (int) (f * 1.6777215E7f);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
    }

    @Override // com.otaliastudios.cameraview.filter.TwoParameterFilter
    public final void PlaceComponentResult(float f) {
        int i = (int) (f * 1.6777215E7f);
        this.getErrorConfigVersion = Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
    }
}
