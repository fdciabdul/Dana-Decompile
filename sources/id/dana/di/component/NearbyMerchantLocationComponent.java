package id.dana.di.component;

import dagger.Component;
import id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity;
import id.dana.di.PerActivity;
import id.dana.di.modules.NearbyMerchantLocationSearchModule;
import id.dana.drawable.search.searchresult.ChainQueryFragment;
import id.dana.nearbyme.NearbyMerchantLocationSearchView;
import kotlin.Metadata;

@Component(dependencies = {ApplicationComponent.class}, modules = {NearbyMerchantLocationSearchModule.class})
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/di/component/NearbyMerchantLocationComponent;", "", "Lid/dana/danah5/locationpicker/MiniProgramLocationPickerActivity;", "p0", "", "getAuthRequestContext", "(Lid/dana/danah5/locationpicker/MiniProgramLocationPickerActivity;)V", "Lid/dana/nearbyme/NearbyMerchantLocationSearchView;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/nearbyme/NearbyMerchantLocationSearchView;)V", "Lid/dana/nearbyrevamp/search/searchresult/ChainQueryFragment;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/nearbyrevamp/search/searchresult/ChainQueryFragment;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public interface NearbyMerchantLocationComponent {
    void BuiltInFictitiousFunctionClassFactory(ChainQueryFragment p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(NearbyMerchantLocationSearchView p0);

    void getAuthRequestContext(MiniProgramLocationPickerActivity p0);
}
