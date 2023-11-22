package id.dana.nearbyme.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.component.ApplicationComponent;
import id.dana.nearbyme.di.module.MerchantPhotoViewerModule;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerDialog;
import kotlin.Metadata;

@Component(dependencies = {ApplicationComponent.class}, modules = {MerchantPhotoViewerModule.class})
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/di/component/MerchantPhotoViewerComponent;", "", "Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoViewerDialog;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoViewerDialog;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public interface MerchantPhotoViewerComponent {
    void BuiltInFictitiousFunctionClassFactory(MerchantPhotoViewerDialog p0);
}