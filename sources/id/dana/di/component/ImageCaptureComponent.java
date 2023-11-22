package id.dana.di.component;

import dagger.Subcomponent;
import id.dana.danah5.imagecapture.ImageCaptureActivity;
import id.dana.di.modules.ImageCaptureModule;
import id.dana.di.modules.features.imagecapture.ImageCaptureScope;
import id.dana.di.modules.features.imagecapture.ImageCaptureViewModelModule;
import kotlin.Metadata;

@Subcomponent(modules = {ImageCaptureModule.class, ImageCaptureViewModelModule.class})
@ImageCaptureScope
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/di/component/ImageCaptureComponent;", "", "Lid/dana/danah5/imagecapture/ImageCaptureActivity;", "p0", "", "MyBillsEntityDataFactory", "(Lid/dana/danah5/imagecapture/ImageCaptureActivity;)V", "Factory"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ImageCaptureComponent {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/di/component/ImageCaptureComponent$Factory;", "", "Lid/dana/di/component/ImageCaptureComponent;", "PlaceComponentResult", "()Lid/dana/di/component/ImageCaptureComponent;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Subcomponent.Factory
    /* loaded from: classes.dex */
    public interface Factory {
        ImageCaptureComponent PlaceComponentResult();
    }

    void MyBillsEntityDataFactory(ImageCaptureActivity p0);
}
