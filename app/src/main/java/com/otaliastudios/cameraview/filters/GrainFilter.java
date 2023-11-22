package com.otaliastudios.cameraview.filters;

import android.opengl.GLES20;
import com.alipay.mobile.embedview.mapbiz.core.H5MapRenderOptimizer;
import com.otaliastudios.cameraview.filter.BaseFilter;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import com.otaliastudios.cameraview.internal.GlUtils;
import java.util.Random;

/* loaded from: classes8.dex */
public class GrainFilter extends BaseFilter implements OneParameterFilter {
    private static final String NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static final Random scheduleImpl;
    private float initRecordTimeStamp = 0.5f;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2 = 1;
    private int getErrorConfigVersion = 1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
    private int GetContactSyncConfig = -1;
    private int DatabaseTableConfigUtil = -1;

    static {
        Random random = new Random();
        scheduleImpl = random;
        StringBuilder sb = new StringBuilder();
        sb.append("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvec2 seed;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES tex_sampler_0;\nuniform samplerExternalOES tex_sampler_1;\nuniform float scale;\nuniform float stepX;\nuniform float stepY;\nfloat rand(vec2 loc) {\n  float theta1 = dot(loc, vec2(0.9898, 0.233));\n  float theta2 = dot(loc, vec2(12.0, 78.0));\n  float value = cos(theta1) * sin(theta2) + sin(theta1) * cos(theta2);\n  float temp = mod(197.0 * value, 1.0) + value;\n  float part1 = mod(220.0 * temp, 1.0) + temp;\n  float part2 = value * 0.5453;\n  float part3 = cos(theta1 + theta2) * 0.43758;\n  float sum = (part1 + part2 + part3);\n  return fract(sum)*scale;\n}\nvoid main() {\n  seed[0] = ");
        sb.append(random.nextFloat());
        sb.append(";\n  seed[1] = ");
        sb.append(random.nextFloat());
        sb.append(";\n  float noise = texture2D(tex_sampler_1, ");
        sb.append("vTextureCoord");
        sb.append(" + vec2(-stepX, -stepY)).r * 0.224;\n  noise += texture2D(tex_sampler_1, ");
        sb.append("vTextureCoord");
        sb.append(" + vec2(-stepX, stepY)).r * 0.224;\n  noise += texture2D(tex_sampler_1, ");
        sb.append("vTextureCoord");
        sb.append(" + vec2(stepX, -stepY)).r * 0.224;\n  noise += texture2D(tex_sampler_1, ");
        sb.append("vTextureCoord");
        sb.append(" + vec2(stepX, stepY)).r * 0.224;\n  noise += 0.4448;\n  noise *= scale;\n  vec4 color = texture2D(tex_sampler_0, ");
        sb.append("vTextureCoord");
        sb.append(");\n  float energy = 0.33333 * color.r + 0.33333 * color.g + 0.33333 * color.b;\n  float mask = (1.0 - sqrt(energy));\n  float weight = 1.0 - 1.333 * mask * noise;\n  gl_FragColor = vec4(color.rgb * weight, color.a);\n  gl_FragColor = gl_FragColor+vec4(rand(");
        sb.append("vTextureCoord");
        sb.append(" + seed), rand(");
        sb.append("vTextureCoord");
        sb.append(" + seed),rand(");
        sb.append("vTextureCoord");
        sb.append(" + seed),1);\n}\n");
        NetworkUserEntityData$$ExternalSyntheticLambda0 = sb.toString();
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(i, i2);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i;
        this.getErrorConfigVersion = i2;
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        super.BuiltInFictitiousFunctionClassFactory(i);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i, H5MapRenderOptimizer.KEY_SCALE);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = glGetUniformLocation;
        GlUtils.PlaceComponentResult(glGetUniformLocation, H5MapRenderOptimizer.KEY_SCALE);
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i, "stepX");
        this.GetContactSyncConfig = glGetUniformLocation2;
        GlUtils.PlaceComponentResult(glGetUniformLocation2, "stepX");
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(i, "stepY");
        this.DatabaseTableConfigUtil = glGetUniformLocation3;
        GlUtils.PlaceComponentResult(glGetUniformLocation3, "stepY");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory() {
        super.BuiltInFictitiousFunctionClassFactory();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
        this.GetContactSyncConfig = -1;
        this.DatabaseTableConfigUtil = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public final void PlaceComponentResult(long j, float[] fArr) {
        super.PlaceComponentResult(j, fArr);
        GLES20.glUniform1f(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.initRecordTimeStamp);
        GlUtils.PlaceComponentResult("glUniform1f");
        GLES20.glUniform1f(this.GetContactSyncConfig, 0.5f / this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        GlUtils.PlaceComponentResult("glUniform1f");
        GLES20.glUniform1f(this.DatabaseTableConfigUtil, 0.5f / this.getErrorConfigVersion);
        GlUtils.PlaceComponentResult("glUniform1f");
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.initRecordTimeStamp;
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public final void getAuthRequestContext(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.initRecordTimeStamp = f;
    }
}
