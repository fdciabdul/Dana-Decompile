package com.otaliastudios.cameraview.internal;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.otaliastudios.cameraview.CameraLogger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes8.dex */
public class GlUtils {
    private static final CameraLogger BuiltInFictitiousFunctionClassFactory = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("GlUtils");
    public static final float[] getAuthRequestContext;

    static {
        float[] fArr = new float[16];
        getAuthRequestContext = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public static void PlaceComponentResult(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            throw new RuntimeException(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(3, "Error during", str, "glError 0x", Integer.toHexString(glGetError)));
        }
    }

    public static void PlaceComponentResult(int i, String str) {
        if (i < 0) {
            throw new RuntimeException(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(3, "Unable to locate", str, "in program"));
        }
    }

    private static int getAuthRequestContext(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        StringBuilder sb = new StringBuilder();
        sb.append("glCreateShader type=");
        sb.append(i);
        PlaceComponentResult(sb.toString());
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(3, "Could not compile shader", Integer.valueOf(i), ":", GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }

    public static int MyBillsEntityDataFactory(String str, String str2) {
        int authRequestContext;
        int authRequestContext2 = getAuthRequestContext(35633, str);
        if (authRequestContext2 == 0 || (authRequestContext = getAuthRequestContext(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        PlaceComponentResult("glCreateProgram");
        if (glCreateProgram == 0) {
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(3, "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, authRequestContext2);
        PlaceComponentResult("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, authRequestContext);
        PlaceComponentResult("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(3, "Could not link program:", GLES20.glGetProgramInfoLog(glCreateProgram));
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        return glCreateProgram;
    }

    public static FloatBuffer BuiltInFictitiousFunctionClassFactory(float[] fArr) {
        int length = fArr.length;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(32);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }
}
