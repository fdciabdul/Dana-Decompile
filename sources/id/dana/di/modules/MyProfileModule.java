package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.myprofile.MyProfileContract;
import id.dana.myprofile.MyProfilePresenter;

@Module
/* loaded from: classes2.dex */
public class MyProfileModule {
    private MyProfileContract.View PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public MyProfileContract.Presenter MyBillsEntityDataFactory(MyProfilePresenter myProfilePresenter) {
        return myProfilePresenter;
    }

    public MyProfileModule(MyProfileContract.View view) {
        this.PlaceComponentResult = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public MyProfileContract.View BuiltInFictitiousFunctionClassFactory() {
        return this.PlaceComponentResult;
    }
}
