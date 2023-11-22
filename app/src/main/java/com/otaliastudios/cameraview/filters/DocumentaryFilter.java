package com.otaliastudios.cameraview.filters;

import android.opengl.GLES20;
import com.alipay.mobile.embedview.mapbiz.core.H5MapRenderOptimizer;
import com.otaliastudios.cameraview.filter.BaseFilter;
import com.otaliastudios.cameraview.internal.GlUtils;
import java.util.Random;

/* loaded from: classes8.dex */
public class DocumentaryFilter extends BaseFilter {
    private static final String NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static final Random scheduleImpl;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1 = 1;
    private int getErrorConfigVersion = 1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
    private int initRecordTimeStamp = -1;

    static {
        Random random = new Random();
        scheduleImpl = random;
        StringBuilder sb = new StringBuilder();
        sb.append("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvec2 seed;\nfloat stepsize;\nuniform float inv_max_dist;\nuniform vec2 scale;\nvarying vec2 vTextureCoord;\nfloat rand(vec2 loc) {\n  float theta1 = dot(loc, vec2(0.9898, 0.233));\n  float theta2 = dot(loc, vec2(12.0, 78.0));\n  float value = cos(theta1) * sin(theta2) + sin(theta1) * cos(theta2);\n  float temp = mod(197.0 * value, 1.0) + value;\n  float part1 = mod(220.0 * temp, 1.0) + temp;\n  float part2 = value * 0.5453;\n  float part3 = cos(theta1 + theta2) * 0.43758;\n  return fract(part1 + part2 + part3);\n}\nvoid main() {\n  seed[0] = ");
        sb.append(random.nextFloat());
        sb.append(";\n  seed[1] = ");
        sb.append(random.nextFloat());
        sb.append(";\n  stepsize = ");
        sb.append(0.003921569f);
        sb.append(";\n  vec4 color = texture2D(sTexture, ");
        sb.append("vTextureCoord");
        sb.append(");\n  float dither = rand(");
        sb.append("vTextureCoord");
        sb.append(" + seed);\n  vec3 xform = clamp(2.0 * color.rgb, 0.0, 1.0);\n  vec3 temp = clamp(2.0 * (color.rgb + stepsize), 0.0, 1.0);\n  vec3 new_color = clamp(xform + (temp - xform) * (dither - 0.5), 0.0, 1.0);\n  float gray = dot(new_color, vec3(0.299, 0.587, 0.114));\n  new_color = vec3(gray, gray, gray);\n  vec2 coord = ");
        sb.append("vTextureCoord");
        sb.append(" - vec2(0.5, 0.5);\n  float dist = length(coord * scale);\n  float lumen = 0.85 / (1.0 + exp((dist * inv_max_dist - 0.83) * 20.0)) + 0.15;\n  gl_FragColor = vec4(new_color * lumen, color.a);\n}\n");
        NetworkUserEntityData$$ExternalSyntheticLambda0 = sb.toString();
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(i, i2);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = i;
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
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = glGetUniformLocation;
        GlUtils.PlaceComponentResult(glGetUniformLocation, H5MapRenderOptimizer.KEY_SCALE);
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i, "inv_max_dist");
        this.initRecordTimeStamp = glGetUniformLocation2;
        GlUtils.PlaceComponentResult(glGetUniformLocation2, "inv_max_dist");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory() {
        super.BuiltInFictitiousFunctionClassFactory();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
        this.initRecordTimeStamp = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public final void PlaceComponentResult(long j, float[] fArr) {
        super.PlaceComponentResult(j, fArr);
        float[] fArr2 = new float[2];
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int i2 = this.getErrorConfigVersion;
        if (i > i2) {
            fArr2[0] = 1.0f;
            fArr2[1] = i2 / i;
        } else {
            fArr2[0] = i / i2;
            fArr2[1] = 1.0f;
        }
        GLES20.glUniform2fv(this.NetworkUserEntityData$$ExternalSyntheticLambda2, 1, fArr2, 0);
        GlUtils.PlaceComponentResult("glUniform2fv");
        float f = fArr2[0];
        float f2 = fArr2[1];
        GLES20.glUniform1f(this.initRecordTimeStamp, 1.0f / (((float) Math.sqrt((f * f) + (f2 * f2))) * 0.5f));
        GlUtils.PlaceComponentResult("glUniform1f");
    }
}
