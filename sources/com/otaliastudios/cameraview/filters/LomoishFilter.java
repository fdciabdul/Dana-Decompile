package com.otaliastudios.cameraview.filters;

import android.opengl.GLES20;
import com.alipay.mobile.embedview.mapbiz.core.H5MapRenderOptimizer;
import com.otaliastudios.cameraview.filter.BaseFilter;
import com.otaliastudios.cameraview.internal.GlUtils;
import java.util.Random;

/* loaded from: classes8.dex */
public class LomoishFilter extends BaseFilter {
    private static final Random NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static final String getErrorConfigVersion;
    private int DatabaseTableConfigUtil = 1;
    private int scheduleImpl = 1;
    private int initRecordTimeStamp = -1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
    private int GetContactSyncConfig = -1;

    static {
        Random random = new Random();
        NetworkUserEntityData$$ExternalSyntheticLambda0 = random;
        StringBuilder sb = new StringBuilder();
        sb.append("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float stepsizeX;\nuniform float stepsizeY;\nuniform vec2 scale;\nuniform float inv_max_dist;\nvec2 seed;\nfloat stepsize;\nvarying vec2 vTextureCoord;\nfloat rand(vec2 loc) {\n  float theta1 = dot(loc, vec2(0.9898, 0.233));\n  float theta2 = dot(loc, vec2(12.0, 78.0));\n  float value = cos(theta1) * sin(theta2) + sin(theta1) * cos(theta2);\n  float temp = mod(197.0 * value, 1.0) + value;\n  float part1 = mod(220.0 * temp, 1.0) + temp;\n  float part2 = value * 0.5453;\n  float part3 = cos(theta1 + theta2) * 0.43758;\n  return fract(part1 + part2 + part3);\n}\nvoid main() {\n  seed[0] = ");
        sb.append(random.nextFloat());
        sb.append(";\n  seed[1] = ");
        sb.append(random.nextFloat());
        sb.append(";\n  stepsize = ");
        sb.append(0.003921569f);
        sb.append(";\n  vec3 nbr_color = vec3(0.0, 0.0, 0.0);\n  vec2 coord;\n  vec4 color = texture2D(sTexture, ");
        sb.append("vTextureCoord");
        sb.append(");\n  coord.x = ");
        sb.append("vTextureCoord");
        sb.append(".x - 0.5 * stepsizeX;\n  coord.y = ");
        sb.append("vTextureCoord");
        sb.append(".y - stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = ");
        sb.append("vTextureCoord");
        sb.append(".x - stepsizeX;\n  coord.y = ");
        sb.append("vTextureCoord");
        sb.append(".y + 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = ");
        sb.append("vTextureCoord");
        sb.append(".x + stepsizeX;\n  coord.y = ");
        sb.append("vTextureCoord");
        sb.append(".y - 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = ");
        sb.append("vTextureCoord");
        sb.append(".x + stepsizeX;\n  coord.y = ");
        sb.append("vTextureCoord");
        sb.append(".y + 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  vec3 s_color = vec3(color.rgb + 0.3 * nbr_color);\n  vec3 c_color = vec3(0.0, 0.0, 0.0);\n  float value;\n  if (s_color.r < 0.5) {\n    value = s_color.r;\n  } else {\n    value = 1.0 - s_color.r;\n  }\n  float red = 4.0 * value * value * value;\n  if (s_color.r < 0.5) {\n    c_color.r = red;\n  } else {\n    c_color.r = 1.0 - red;\n  }\n  if (s_color.g < 0.5) {\n    value = s_color.g;\n  } else {\n    value = 1.0 - s_color.g;\n  }\n  float green = 2.0 * value * value;\n  if (s_color.g < 0.5) {\n    c_color.g = green;\n  } else {\n    c_color.g = 1.0 - green;\n  }\n  c_color.b = s_color.b * 0.5 + 0.25;\n  float dither = rand(");
        sb.append("vTextureCoord");
        sb.append(" + seed);\n  vec3 xform = clamp((c_color.rgb - 0.15) * 1.53846, 0.0, 1.0);\n  vec3 temp = clamp((color.rgb + stepsize - 0.15) * 1.53846, 0.0, 1.0);\n  vec3 bw_color = clamp(xform + (temp - xform) * (dither - 0.5), 0.0, 1.0);\n  coord = ");
        sb.append("vTextureCoord");
        sb.append(" - vec2(0.5, 0.5);\n  float dist = length(coord * scale);\n  float lumen = 0.85 / (1.0 + exp((dist * inv_max_dist - 0.73) * 20.0)) + 0.15;\n  gl_FragColor = vec4(bw_color * lumen, color.a);\n}\n");
        getErrorConfigVersion = sb.toString();
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(i, i2);
        this.DatabaseTableConfigUtil = i;
        this.scheduleImpl = i2;
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return getErrorConfigVersion;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        super.BuiltInFictitiousFunctionClassFactory(i);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i, H5MapRenderOptimizer.KEY_SCALE);
        this.initRecordTimeStamp = glGetUniformLocation;
        GlUtils.PlaceComponentResult(glGetUniformLocation, H5MapRenderOptimizer.KEY_SCALE);
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i, "inv_max_dist");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = glGetUniformLocation2;
        GlUtils.PlaceComponentResult(glGetUniformLocation2, "inv_max_dist");
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(i, "stepsizeX");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = glGetUniformLocation3;
        GlUtils.PlaceComponentResult(glGetUniformLocation3, "stepsizeX");
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(i, "stepsizeY");
        this.GetContactSyncConfig = glGetUniformLocation4;
        GlUtils.PlaceComponentResult(glGetUniformLocation4, "stepsizeY");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory() {
        super.BuiltInFictitiousFunctionClassFactory();
        this.initRecordTimeStamp = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
        this.GetContactSyncConfig = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public final void PlaceComponentResult(long j, float[] fArr) {
        super.PlaceComponentResult(j, fArr);
        float[] fArr2 = new float[2];
        int i = this.DatabaseTableConfigUtil;
        int i2 = this.scheduleImpl;
        if (i > i2) {
            fArr2[0] = 1.0f;
            fArr2[1] = i2 / i;
        } else {
            fArr2[0] = i / i2;
            fArr2[1] = 1.0f;
        }
        float f = fArr2[0];
        float f2 = fArr2[1];
        float sqrt = (float) Math.sqrt((f * f) + (f2 * f2));
        GLES20.glUniform2fv(this.initRecordTimeStamp, 1, fArr2, 0);
        GlUtils.PlaceComponentResult("glUniform2fv");
        GLES20.glUniform1f(this.NetworkUserEntityData$$ExternalSyntheticLambda1, 1.0f / (sqrt * 0.5f));
        GlUtils.PlaceComponentResult("glUniform1f");
        GLES20.glUniform1f(this.NetworkUserEntityData$$ExternalSyntheticLambda2, 1.0f / this.DatabaseTableConfigUtil);
        GlUtils.PlaceComponentResult("glUniform1f");
        GLES20.glUniform1f(this.GetContactSyncConfig, 1.0f / this.scheduleImpl);
        GlUtils.PlaceComponentResult("glUniform1f");
    }
}
