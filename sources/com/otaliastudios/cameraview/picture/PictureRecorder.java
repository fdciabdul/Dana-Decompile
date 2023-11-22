package com.otaliastudios.cameraview.picture;

import com.otaliastudios.cameraview.PictureResult;

/* loaded from: classes8.dex */
public abstract class PictureRecorder {
    protected Exception BuiltInFictitiousFunctionClassFactory;
    PictureResultListener getAuthRequestContext;
    PictureResult.Stub moveToNextValue;

    /* loaded from: classes8.dex */
    public interface PictureResultListener {
        void PlaceComponentResult(boolean z);

        void getAuthRequestContext(PictureResult.Stub stub, Exception exc);
    }

    public abstract void PlaceComponentResult();

    public PictureRecorder(PictureResult.Stub stub, PictureResultListener pictureResultListener) {
        this.moveToNextValue = stub;
        this.getAuthRequestContext = pictureResultListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void MyBillsEntityDataFactory() {
        PictureResultListener pictureResultListener = this.getAuthRequestContext;
        if (pictureResultListener != null) {
            pictureResultListener.getAuthRequestContext(this.moveToNextValue, this.BuiltInFictitiousFunctionClassFactory);
            this.getAuthRequestContext = null;
            this.moveToNextValue = null;
        }
    }
}
