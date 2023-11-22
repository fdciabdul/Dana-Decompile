package id.dana.nearbyme.merchantdetail.merchantphoto;

import dagger.MembersInjector;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;

/* loaded from: classes5.dex */
public final class MerchantPhotoViewerDialog_MembersInjector implements MembersInjector<MerchantPhotoViewerDialog> {
    public static void BuiltInFictitiousFunctionClassFactory(MerchantPhotoViewerDialog merchantPhotoViewerDialog, MediaViewerContract.Presenter<MerchantImageModel> presenter) {
        merchantPhotoViewerDialog.merchantPhotoViewerPresenter = presenter;
    }
}
