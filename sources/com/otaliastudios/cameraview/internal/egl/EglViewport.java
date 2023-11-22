package com.otaliastudios.cameraview.internal.egl;

import android.opengl.GLES20;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.filter.Filter;
import com.otaliastudios.cameraview.filter.NoFilter;
import com.otaliastudios.cameraview.internal.GlUtils;

/* loaded from: classes8.dex */
public class EglViewport {
    private static final CameraLogger KClassImpl$Data$declaredNonStaticMembers$2 = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("EglViewport");
    private int BuiltInFictitiousFunctionClassFactory;
    public Filter MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    public int PlaceComponentResult;
    public Filter getAuthRequestContext;

    public EglViewport() {
        this(new NoFilter());
    }

    public EglViewport(Filter filter) {
        this.PlaceComponentResult = -1;
        this.BuiltInFictitiousFunctionClassFactory = 36197;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 33984;
        this.MyBillsEntityDataFactory = filter;
        MyBillsEntityDataFactory();
    }

    private void MyBillsEntityDataFactory() {
        int MyBillsEntityDataFactory = GlUtils.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(), this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0());
        this.PlaceComponentResult = MyBillsEntityDataFactory;
        this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory);
    }

    public final int getAuthRequestContext() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GlUtils.PlaceComponentResult("glGenTextures");
        int i = iArr[0];
        GLES20.glActiveTexture(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        GLES20.glBindTexture(this.BuiltInFictitiousFunctionClassFactory, i);
        StringBuilder sb = new StringBuilder();
        sb.append("glBindTexture ");
        sb.append(i);
        GlUtils.PlaceComponentResult(sb.toString());
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GlUtils.PlaceComponentResult("glTexParameter");
        return i;
    }

    public final void BuiltInFictitiousFunctionClassFactory(long j, int i, float[] fArr) {
        if (this.getAuthRequestContext != null) {
            if (this.PlaceComponentResult != -1) {
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
                GLES20.glDeleteProgram(this.PlaceComponentResult);
                this.PlaceComponentResult = -1;
            }
            this.MyBillsEntityDataFactory = this.getAuthRequestContext;
            this.getAuthRequestContext = null;
            MyBillsEntityDataFactory();
        }
        GlUtils.PlaceComponentResult("draw start");
        GLES20.glUseProgram(this.PlaceComponentResult);
        GlUtils.PlaceComponentResult("glUseProgram");
        GLES20.glActiveTexture(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        GLES20.glBindTexture(this.BuiltInFictitiousFunctionClassFactory, i);
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(j, fArr);
        GLES20.glBindTexture(this.BuiltInFictitiousFunctionClassFactory, 0);
        GLES20.glUseProgram(0);
    }
}
