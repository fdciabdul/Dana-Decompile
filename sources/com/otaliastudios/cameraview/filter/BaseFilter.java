package com.otaliastudios.cameraview.filter;

import android.opengl.GLES20;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.internal.GlUtils;
import com.otaliastudios.cameraview.size.Size;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: classes8.dex */
public abstract class BaseFilter implements Filter {
    private static final CameraLogger scheduleImpl = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("BaseFilter");
    Size KClassImpl$Data$declaredNonStaticMembers$2;
    private FloatBuffer NetworkUserEntityData$$ExternalSyntheticLambda1 = GlUtils.BuiltInFictitiousFunctionClassFactory(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
    private FloatBuffer getErrorConfigVersion = GlUtils.BuiltInFictitiousFunctionClassFactory(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
    private int NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
    private int GetContactSyncConfig = -1;
    private int initRecordTimeStamp = -1;
    private int DatabaseTableConfigUtil = -1;
    int PlaceComponentResult = -1;
    protected String MyBillsEntityDataFactory = "aPosition";
    protected String moveToNextValue = "aTextureCoord";
    protected String BuiltInFictitiousFunctionClassFactory = "uMVPMatrix";
    protected String lookAheadTest = "uTexMatrix";
    protected String getAuthRequestContext = "vTextureCoord";

    /* JADX INFO: Access modifiers changed from: protected */
    public final String f_() {
        String str = this.getAuthRequestContext;
        StringBuilder sb = new StringBuilder();
        sb.append("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 ");
        sb.append(str);
        sb.append(";\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, ");
        sb.append(str);
        sb.append(");\n}\n");
        return sb.toString();
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public void BuiltInFictitiousFunctionClassFactory(int i) {
        this.PlaceComponentResult = i;
        int glGetAttribLocation = GLES20.glGetAttribLocation(i, this.MyBillsEntityDataFactory);
        this.initRecordTimeStamp = glGetAttribLocation;
        GlUtils.PlaceComponentResult(glGetAttribLocation, this.MyBillsEntityDataFactory);
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(i, this.moveToNextValue);
        this.DatabaseTableConfigUtil = glGetAttribLocation2;
        GlUtils.PlaceComponentResult(glGetAttribLocation2, this.moveToNextValue);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i, this.BuiltInFictitiousFunctionClassFactory);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = glGetUniformLocation;
        GlUtils.PlaceComponentResult(glGetUniformLocation, this.BuiltInFictitiousFunctionClassFactory);
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i, this.lookAheadTest);
        this.GetContactSyncConfig = glGetUniformLocation2;
        GlUtils.PlaceComponentResult(glGetUniformLocation2, this.lookAheadTest);
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public void BuiltInFictitiousFunctionClassFactory() {
        this.PlaceComponentResult = -1;
        this.initRecordTimeStamp = -1;
        this.DatabaseTableConfigUtil = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
        this.GetContactSyncConfig = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Size(i, i2);
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(long j, float[] fArr) {
        if (this.PlaceComponentResult != -1) {
            PlaceComponentResult(j, fArr);
            GLES20.glDrawArrays(5, 0, 4);
            GlUtils.PlaceComponentResult("glDrawArrays");
            GLES20.glDisableVertexAttribArray(this.initRecordTimeStamp);
            GLES20.glDisableVertexAttribArray(this.DatabaseTableConfigUtil);
            return;
        }
        scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(2, "Filter.draw() called after destroying the filter. This can happen rarely because of threading.");
    }

    public void PlaceComponentResult(long j, float[] fArr) {
        GLES20.glUniformMatrix4fv(this.NetworkUserEntityData$$ExternalSyntheticLambda0, 1, false, GlUtils.getAuthRequestContext, 0);
        GlUtils.PlaceComponentResult("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.GetContactSyncConfig, 1, false, fArr, 0);
        GlUtils.PlaceComponentResult("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.initRecordTimeStamp);
        StringBuilder sb = new StringBuilder();
        sb.append("glEnableVertexAttribArray: ");
        sb.append(this.initRecordTimeStamp);
        GlUtils.PlaceComponentResult(sb.toString());
        GLES20.glVertexAttribPointer(this.initRecordTimeStamp, 2, 5126, false, 8, (Buffer) this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        GlUtils.PlaceComponentResult("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.DatabaseTableConfigUtil);
        GlUtils.PlaceComponentResult("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.DatabaseTableConfigUtil, 2, 5126, false, 8, (Buffer) this.getErrorConfigVersion);
        GlUtils.PlaceComponentResult("glVertexAttribPointer");
    }

    protected BaseFilter e_() {
        try {
            return (BaseFilter) getClass().newInstance();
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Filters should have a public no-arguments constructor.", e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Filters should have a public no-arguments constructor.", e2);
        }
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final /* synthetic */ Filter PlaceComponentResult() {
        BaseFilter e_ = e_();
        Size size = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (size != null) {
            e_.KClassImpl$Data$declaredNonStaticMembers$2(size.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext);
        }
        if (this instanceof OneParameterFilter) {
            ((OneParameterFilter) e_).getAuthRequestContext(((OneParameterFilter) this).KClassImpl$Data$declaredNonStaticMembers$2());
        }
        if (this instanceof TwoParameterFilter) {
            ((TwoParameterFilter) e_).PlaceComponentResult(((TwoParameterFilter) this).MyBillsEntityDataFactory());
        }
        return e_;
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final String getAuthRequestContext() {
        String str = this.MyBillsEntityDataFactory;
        String str2 = this.moveToNextValue;
        String str3 = this.BuiltInFictitiousFunctionClassFactory;
        String str4 = this.lookAheadTest;
        String str5 = this.getAuthRequestContext;
        StringBuilder sb = new StringBuilder();
        sb.append("uniform mat4 ");
        sb.append(str3);
        sb.append(";\nuniform mat4 ");
        sb.append(str4);
        sb.append(";\nattribute vec4 ");
        sb.append(str);
        sb.append(";\nattribute vec4 ");
        sb.append(str2);
        sb.append(";\nvarying vec2 ");
        sb.append(str5);
        sb.append(";\nvoid main() {\n    gl_Position = ");
        sb.append(str3);
        sb.append(" * ");
        sb.append(str);
        sb.append(";\n    ");
        sb.append(str5);
        sb.append(" = (");
        sb.append(str4);
        sb.append(" * ");
        sb.append(str2);
        sb.append(").xy;\n}\n");
        return sb.toString();
    }
}
