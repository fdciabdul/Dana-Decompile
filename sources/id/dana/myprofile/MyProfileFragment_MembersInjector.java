package id.dana.myprofile;

import dagger.MembersInjector;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.contract.payasset.QueryPayMethodContract;
import id.dana.contract.staticqr.GetStaticQrContract;
import id.dana.contract.user.GetBalanceContract;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.investment.contract.InvestmentContract;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.myprofile.MyProfileContract;
import id.dana.savings.contract.SavingContract;
import id.dana.statement.UserStatementContract;
import id.dana.usereducation.BottomSheetOnBoardingContract;

/* loaded from: classes5.dex */
public final class MyProfileFragment_MembersInjector implements MembersInjector<MyProfileFragment> {
    public static void BuiltInFictitiousFunctionClassFactory(MyProfileFragment myProfileFragment, GetBalanceContract.Presenter presenter) {
        myProfileFragment.getBalancePresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(MyProfileFragment myProfileFragment, GetStaticQrContract.Presenter presenter) {
        myProfileFragment.getStaticQrPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(MyProfileFragment myProfileFragment, UserStatementContract.Presenter presenter) {
        myProfileFragment.getUserStatementPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(MyProfileFragment myProfileFragment, ProductPageManager productPageManager) {
        myProfileFragment.productPageManager = productPageManager;
    }

    public static void PlaceComponentResult(MyProfileFragment myProfileFragment, DynamicUrlWrapper dynamicUrlWrapper) {
        myProfileFragment.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(MyProfileFragment myProfileFragment, MyProfileContract.Presenter presenter) {
        myProfileFragment.myProfilePresenter = presenter;
    }

    public static void PlaceComponentResult(MyProfileFragment myProfileFragment, GenerateDeepLinkContract.ProfilePresenter profilePresenter) {
        myProfileFragment.profileQrDeepLinkPresenter = profilePresenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(MyProfileFragment myProfileFragment, QueryPayMethodContract.Presenter presenter) {
        myProfileFragment.queryPayPresenter = presenter;
    }

    public static void getAuthRequestContext(MyProfileFragment myProfileFragment, BottomSheetOnBoardingContract.Presenter presenter) {
        myProfileFragment.bottomSheetOnBoardingPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(MyProfileFragment myProfileFragment, SavingContract.Presenter presenter) {
        myProfileFragment.savingPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(MyProfileFragment myProfileFragment, InvestmentContract.Presenter presenter) {
        myProfileFragment.investmentPresenter = presenter;
    }
}
