package id.dana.di.modules.features.imagecapture;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.di.module.ViewModelKey;
import id.dana.danah5.imagecapture.viewmodel.ImageCaptureViewModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\u0005\u0010\t"}, d2 = {"Lid/dana/di/modules/features/imagecapture/ImageCaptureViewModelModule;", "", "Lid/dana/danah5/imagecapture/viewmodel/ImageCaptureViewModel;", "p0", "Landroidx/lifecycle/ViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/danah5/imagecapture/viewmodel/ImageCaptureViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/core/ui/di/module/ViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Lid/dana/core/ui/di/module/ViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes8.dex */
public abstract class ImageCaptureViewModelModule {
    @ImageCaptureScope
    @Binds
    @IntoMap
    @ViewModelKey(ImageCaptureViewModel.class)
    public abstract ViewModel KClassImpl$Data$declaredNonStaticMembers$2(ImageCaptureViewModel p0);

    @ImageCaptureScope
    @Binds
    public abstract ViewModelProvider.Factory KClassImpl$Data$declaredNonStaticMembers$2(ViewModelFactory p0);
}
