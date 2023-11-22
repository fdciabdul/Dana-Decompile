package id.dana.kyb.view;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesPresenter;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.kyb.KybContract;
import id.dana.kyb.adapter.KybRejectReasonAdapter;
import id.dana.switchfaceauth.SwitchFaceAuthContract;
import id.dana.tncsummary.TncSummaryContract;

/* loaded from: classes5.dex */
public final class MyBusinessFragment_MembersInjector implements MembersInjector<MyBusinessFragment> {
    public static void MyBillsEntityDataFactory(MyBusinessFragment myBusinessFragment, Lazy<KybContract.Presenter> lazy) {
        myBusinessFragment.presenter = lazy;
    }

    public static void BuiltInFictitiousFunctionClassFactory(MyBusinessFragment myBusinessFragment, Lazy<ReadLinkPropertiesPresenter> lazy) {
        myBusinessFragment.readLinkPropertiesPresenter = lazy;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(MyBusinessFragment myBusinessFragment, Lazy<SwitchFaceAuthContract.Presenter> lazy) {
        myBusinessFragment.switchFaceAuthPresenter = lazy;
    }

    public static void lookAheadTest(MyBusinessFragment myBusinessFragment, Lazy<TncSummaryContract.Presenter> lazy) {
        myBusinessFragment.tncSummaryPresenter = lazy;
    }

    public static void PlaceComponentResult(MyBusinessFragment myBusinessFragment, Lazy<KybRejectReasonAdapter> lazy) {
        myBusinessFragment.rejectReasonAdapter = lazy;
    }

    public static void getAuthRequestContext(MyBusinessFragment myBusinessFragment, Lazy<DynamicUrlWrapper> lazy) {
        myBusinessFragment.dynamicUrlWrapper = lazy;
    }
}
