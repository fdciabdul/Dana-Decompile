package id.dana.di.component;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/di/component/MerchantPhotoModule;", "", "Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoContract$View;", "MyBillsEntityDataFactory", "()Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoContract$View;", "getAuthRequestContext", "Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoContract$View;", "p0", "<init>", "(Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class MerchantPhotoModule {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final MerchantPhotoContract.View MyBillsEntityDataFactory;

    public MerchantPhotoModule(MerchantPhotoContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.MyBillsEntityDataFactory = view;
    }

    @Provides
    @PerActivity
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final MerchantPhotoContract.View getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }
}
