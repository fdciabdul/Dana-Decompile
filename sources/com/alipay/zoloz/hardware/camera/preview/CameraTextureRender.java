package com.alipay.zoloz.hardware.camera.preview;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.alipay.zoloz.hardware.log.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes7.dex */
public class CameraTextureRender {
    public static volatile float ANIMRATION = 1.0f;
    private static final String FRAGMENT_SHADER_EXT = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 textureCoordinate;\nuniform samplerExternalOES vTexture;\nuniform vec4 uUVRange;\nuniform vec2 uCornerRation;\nvoid main() {\nfloat testResult = 1.0;\nif(uCornerRation.x > 0.0 || uCornerRation.y > 0.0){\nvec2 uvcenter = vec2(uUVRange.x+uUVRange.y,uUVRange.z+uUVRange.w)*0.5;\nvec2 roiSize = abs(vec2(uUVRange.x - uUVRange.y,uUVRange.z - uUVRange.w));\nvec2 uvcornerSize = roiSize*uCornerRation;\nvec2 relativeuv = abs(textureCoordinate - uvcenter);\nvec2 roiHalfSizeWithoutCorner = abs(roiSize - uvcornerSize*2.0)*0.5;\nfloat rx = relativeuv.x - roiHalfSizeWithoutCorner.x;\nfloat ry = relativeuv.y - roiHalfSizeWithoutCorner.y;\nfloat mx = step(roiHalfSizeWithoutCorner.x, relativeuv.x);\nfloat my = step(roiHalfSizeWithoutCorner.y, relativeuv.y);\nfloat ecclipse = step(1.0,rx*rx/(uvcornerSize.x*uvcornerSize.x) + ry*ry/(uvcornerSize.y*uvcornerSize.y));\nif(mx*my*ecclipse > 0.5) \ndiscard;}\ngl_FragColor = texture2D(vTexture, textureCoordinate)  ;\n}\n";
    private static final String LEVEL_1_BEAUTY_FRAGMENT_SHADER_EXT = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES vTexture;\nvarying mediump vec2 textureCoordinate;\nuniform vec4 uUVRange;\nuniform vec2 uCornerRation;\nconst mediump vec4 params = vec4(0.6, 0.8, 0.25, 0.15); \nconst mediump vec3 W = vec3(0.299,0.587,0.114);\nconst mat3 saturateMatrix = mat3(\n1.1102,-0.0598,-0.061,\n-0.0774,1.0826,-0.1186,\n-0.0228,-0.0228,1.1772);\nvoid main(){\nfloat testResult = 1.0;\nif(uCornerRation.x > 0.0 || uCornerRation.y > 0.0){\nvec2 uvcenter = vec2(uUVRange.x+uUVRange.y,uUVRange.z+uUVRange.w)*0.5;\nvec2 roiSize = abs(vec2(uUVRange.x - uUVRange.y,uUVRange.z - uUVRange.w));\nvec2 uvcornerSize = roiSize*uCornerRation;\nvec2 relativeuv = abs(textureCoordinate - uvcenter);\nvec2 roiHalfSizeWithoutCorner = abs(roiSize - uvcornerSize*2.0)*0.5;\nfloat rx = relativeuv.x - roiHalfSizeWithoutCorner.x;\nfloat ry = relativeuv.y - roiHalfSizeWithoutCorner.y;\nfloat mx = step(roiHalfSizeWithoutCorner.x, relativeuv.x);\nfloat my = step(roiHalfSizeWithoutCorner.y, relativeuv.y);\nfloat ecclipse = step(1.0,rx*rx/(uvcornerSize.x*uvcornerSize.x) + ry*ry/(uvcornerSize.y*uvcornerSize.y));\nif(mx*my*ecclipse > 0.5) \ndiscard;}\nvec3 centralColor = texture2D(vTexture, textureCoordinate).rgb;\nfloat lumance = dot(centralColor, W);\n\nfloat alpha = pow(lumance, params.r);\nvec3 smoothColor = centralColor;\n\nsmoothColor.r = clamp(pow(smoothColor.r, params.g),0.0,1.0);\nsmoothColor.g = clamp(pow(smoothColor.g, params.g),0.0,1.0);\nsmoothColor.b = clamp(pow(smoothColor.b, params.g),0.0,1.0);\n\nvec3 lvse = vec3(1.0)-(vec3(1.0)-smoothColor)*(vec3(1.0)-centralColor);\nvec3 bianliang = max(smoothColor, centralColor);\nvec3 rouguang = 2.0*centralColor*smoothColor + centralColor*centralColor - 2.0*centralColor*centralColor*smoothColor;\n\ngl_FragColor = vec4(mix(centralColor, lvse, alpha), 1.0);\ngl_FragColor.rgb = mix(gl_FragColor.rgb, bianliang, alpha);\ngl_FragColor.rgb = mix(gl_FragColor.rgb, rouguang, params.b);\ngl_FragColor.r = log(centralColor.r*(3.0) + 1.0)/log(3.5);\ngl_FragColor.g = log(centralColor.g*(3.0) + 1.0)/log(3.5);\ngl_FragColor.b = log(centralColor.b*(3.0) + 1.0)/log(3.5);\n}\n";
    private static final String ROUNDCORNER_FUCNTION = "float testResult = 1.0;\nif(uCornerRation.x > 0.0 || uCornerRation.y > 0.0){\nvec2 uvcenter = vec2(uUVRange.x+uUVRange.y,uUVRange.z+uUVRange.w)*0.5;\nvec2 roiSize = abs(vec2(uUVRange.x - uUVRange.y,uUVRange.z - uUVRange.w));\nvec2 uvcornerSize = roiSize*uCornerRation;\nvec2 relativeuv = abs(textureCoordinate - uvcenter);\nvec2 roiHalfSizeWithoutCorner = abs(roiSize - uvcornerSize*2.0)*0.5;\nfloat rx = relativeuv.x - roiHalfSizeWithoutCorner.x;\nfloat ry = relativeuv.y - roiHalfSizeWithoutCorner.y;\nfloat mx = step(roiHalfSizeWithoutCorner.x, relativeuv.x);\nfloat my = step(roiHalfSizeWithoutCorner.y, relativeuv.y);\nfloat ecclipse = step(1.0,rx*rx/(uvcornerSize.x*uvcornerSize.x) + ry*ry/(uvcornerSize.y*uvcornerSize.y));\nif(mx*my*ecclipse > 0.5) \ndiscard;}\n";
    public static final String TAG = "CameraTextureRender";
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 textureCoordinate;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    textureCoordinate = (uTexMatrix * aTextureCoord).xy;\n}\n";
    private float[] FULL_RECTANGLE_COORDS;
    private int mProgram;
    private SurfaceTexture mSurfaceTexture;
    private FloatBuffer mTexBuffer;
    private int mTexture;
    private FloatBuffer mVertextBuffer;
    private int maPositionLoc;
    private int maTextureCoordLoc;
    private int muCornerRationLoc;
    private int muMVPMatrixLoc;
    private int muTexMatrixLoc;
    private int muUVRangeLoc;
    private RectF mColorPreviewTextureRoi = new RectF();
    private PointF mCornerRation = new PointF();
    private float[] mTexMatrix = new float[16];
    private float[] mMvpMatrix = new float[16];
    private boolean mIsNeedMirror = false;

    public CameraTextureRender() {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        this.FULL_RECTANGLE_COORDS = fArr;
        this.mVertextBuffer = createFloatBuffer(fArr);
    }

    public Rect create(int i, SurfaceTexture surfaceTexture, int i2, int i3, int i4, int i5, int i6, float f, float f2) {
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float[] fArr;
        float f8;
        float f9 = 0.0f;
        float f10 = 1.0f;
        if (i6 == 90) {
            float f11 = i3;
            float f12 = i2;
            f8 = (i4 * 1.0f) / i5;
            if ((f11 * 1.0f) / f12 >= f8) {
                float f13 = ((f11 - (f12 * f8)) * 0.5f) / f11;
                f9 = f13;
                f4 = 1.0f - f13;
                f6 = 0.0f;
            } else {
                f6 = ((f12 - (f11 / f8)) * 0.5f) / f12;
                f10 = 1.0f - f6;
                f4 = 1.0f;
            }
            fArr = new float[]{f10, f9, f10, f4, f6, f9, f6, f4};
            f5 = f9;
            f7 = f10;
        } else {
            float f14 = i2;
            float f15 = i3;
            float f16 = (i4 * 1.0f) / i5;
            if ((f14 * 1.0f) / f15 >= f16) {
                float f17 = ((f14 - (f15 * f16)) * 0.5f) / f14;
                f10 = 1.0f - f17;
                f9 = f17;
                f3 = 0.0f;
                f4 = 1.0f;
            } else {
                f3 = ((f15 - (f14 / f16)) * 0.5f) / f15;
                f4 = 1.0f - f3;
            }
            float[] fArr2 = {f9, f3, f10, f3, f9, f4, f10, f4};
            f5 = f3;
            f6 = f9;
            f7 = f10;
            fArr = fArr2;
            f8 = f16;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("colorWidth=");
        sb.append(i2);
        sb.append(", colorHeight=");
        sb.append(i3);
        sb.append(", rotate=");
        sb.append(i6);
        sb.append(", uiWidth=");
        sb.append(i4);
        sb.append(", uiHeight=");
        sb.append(i5);
        sb.append(", uiScale=");
        sb.append(f8);
        sb.append(", left=");
        sb.append(f6);
        sb.append(", top=");
        sb.append(f4);
        sb.append(", right=");
        sb.append(f7);
        sb.append(", bottom=");
        sb.append(f5);
        Log.d(TAG, sb.toString());
        this.mTexBuffer = createFloatBuffer(fArr);
        this.mTexture = i;
        this.mSurfaceTexture = surfaceTexture;
        initProgram();
        this.mColorPreviewTextureRoi.set(f6, f4, f7, f5);
        this.mCornerRation.set(f, f2);
        Rect rect = new Rect();
        float f18 = i2;
        rect.left = (int) (f6 * f18);
        rect.right = (int) (f7 * f18);
        float f19 = i3;
        rect.top = (int) (f4 * f19);
        rect.bottom = (int) (f5 * f19);
        return rect;
    }

    public void setMirror(boolean z) {
        this.mIsNeedMirror = z;
    }

    public void draw() {
        float f = ANIMRATION;
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            return;
        }
        surfaceTexture.getTransformMatrix(this.mTexMatrix);
        Matrix.setIdentityM(this.mMvpMatrix, 0);
        if (this.mIsNeedMirror) {
            Matrix.scaleM(this.mMvpMatrix, 0, -1.0f, 1.0f, 1.0f);
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        if (ANIMRATION < 0.0f) {
            return;
        }
        GLES20.glUseProgram(this.mProgram);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.mTexture);
        GLES20.glUniformMatrix4fv(this.muMVPMatrixLoc, 1, false, this.mMvpMatrix, 0);
        GLES20.glUniformMatrix4fv(this.muTexMatrixLoc, 1, false, this.mTexMatrix, 0);
        GLES20.glUniform4f(this.muUVRangeLoc, this.mColorPreviewTextureRoi.left, this.mColorPreviewTextureRoi.right, this.mColorPreviewTextureRoi.top, this.mColorPreviewTextureRoi.bottom);
        GLES20.glUniform2f(this.muCornerRationLoc, this.mCornerRation.x / f, this.mCornerRation.y / f);
        GLES20.glEnableVertexAttribArray(this.maPositionLoc);
        for (int i = 0; i < 8; i++) {
            this.mVertextBuffer.put(i, this.FULL_RECTANGLE_COORDS[i] * f);
        }
        GLES20.glVertexAttribPointer(this.maPositionLoc, 2, 5126, false, 8, (Buffer) this.mVertextBuffer);
        GLES20.glEnableVertexAttribArray(this.maTextureCoordLoc);
        GLES20.glVertexAttribPointer(this.maTextureCoordLoc, 2, 5126, false, 8, (Buffer) this.mTexBuffer);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.maPositionLoc);
        GLES20.glDisableVertexAttribArray(this.maTextureCoordLoc);
        GLES20.glUseProgram(0);
    }

    private void initProgram() {
        int loadShader = loadShader(35633, VERTEX_SHADER);
        int loadShader2 = loadShader(35632, FRAGMENT_SHADER_EXT);
        this.mProgram = GLES20.glCreateProgram();
        checkGlError("glCreateProgram");
        GLES20.glAttachShader(this.mProgram, loadShader);
        checkGlError("glAttachVertShader");
        GLES20.glAttachShader(this.mProgram, loadShader2);
        checkGlError("glAttachFragShader");
        GLES20.glLinkProgram(this.mProgram);
        checkGlError("glLinkProgram");
        GLES20.glDeleteShader(loadShader);
        GLES20.glDeleteShader(loadShader2);
        StringBuilder sb = new StringBuilder();
        sb.append(" mProgram = ");
        sb.append(this.mProgram);
        Log.d(TAG, sb.toString());
        this.maPositionLoc = GLES20.glGetAttribLocation(this.mProgram, "aPosition");
        this.maTextureCoordLoc = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
        this.muMVPMatrixLoc = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
        this.muTexMatrixLoc = GLES20.glGetUniformLocation(this.mProgram, "uTexMatrix");
        this.muUVRangeLoc = GLES20.glGetUniformLocation(this.mProgram, "uUVRange");
        this.muCornerRationLoc = GLES20.glGetUniformLocation(this.mProgram, "uCornerRation");
    }

    static int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not compile shader : ");
            sb.append(i);
            sb.append(" source :");
            sb.append(str);
            Log.e(TAG, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" ");
            sb2.append(GLES20.glGetShaderInfoLog(glCreateShader));
            Log.e(TAG, sb2.toString());
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }

    private void checkGlError(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(": glError 0x");
        sb.append(Integer.toHexString(glGetError));
        String obj = sb.toString();
        Log.d(TAG, obj);
        throw new RuntimeException(obj);
    }

    static FloatBuffer createFloatBuffer(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }
}
