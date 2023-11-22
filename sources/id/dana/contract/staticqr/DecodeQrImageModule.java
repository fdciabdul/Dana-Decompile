package id.dana.contract.staticqr;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.staticqr.DecodeQrImageContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class DecodeQrImageModule {
    private final DecodeQrImageContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public DecodeQrImageContract.Presenter MyBillsEntityDataFactory(DecodeQrImagePresenter decodeQrImagePresenter) {
        return decodeQrImagePresenter;
    }

    public DecodeQrImageModule(DecodeQrImageContract.View view) {
        this.MyBillsEntityDataFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public DecodeQrImageContract.View PlaceComponentResult() {
        return this.MyBillsEntityDataFactory;
    }
}
