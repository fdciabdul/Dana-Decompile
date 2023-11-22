package id.dana.myprofile;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.contract.payasset.QueryPayMethodContract;
import id.dana.contract.paylater.PayLaterContract;
import id.dana.contract.staticqr.GetStaticQrContract;
import id.dana.contract.user.GetBalanceContract;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.investment.contract.DanaPlusContract;
import id.dana.investment.contract.GoldInvestmentContract;
import id.dana.investment.contract.InvestmentContract;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.myprofile.MyProfileContract;
import id.dana.savings.contract.SavingContract;
import id.dana.statement.UserStatementContract;
import id.dana.usereducation.BottomSheetOnBoardingContract;

/* loaded from: classes5.dex */
public final class NewMyProfileFragment_MembersInjector implements MembersInjector<NewMyProfileFragment> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(NewMyProfileFragment newMyProfileFragment, GetBalanceContract.Presenter presenter) {
        newMyProfileFragment.getBalancePresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(NewMyProfileFragment newMyProfileFragment, GetStaticQrContract.Presenter presenter) {
        newMyProfileFragment.getStaticQrPresenter = presenter;
    }

    public static void getAuthRequestContext(NewMyProfileFragment newMyProfileFragment, UserStatementContract.Presenter presenter) {
        newMyProfileFragment.getUserStatementPresenter = presenter;
    }

    public static void PlaceComponentResult(NewMyProfileFragment newMyProfileFragment, ProductPageManager productPageManager) {
        newMyProfileFragment.productPageManager = productPageManager;
    }

    public static void MyBillsEntityDataFactory(NewMyProfileFragment newMyProfileFragment, MyProfileContract.Presenter presenter) {
        newMyProfileFragment.myProfilePresenter = presenter;
    }

    public static void PlaceComponentResult(NewMyProfileFragment newMyProfileFragment, GenerateDeepLinkContract.ProfilePresenter profilePresenter) {
        newMyProfileFragment.profileQrDeepLinkPresenter = profilePresenter;
    }

    public static void PlaceComponentResult(NewMyProfileFragment newMyProfileFragment, QueryPayMethodContract.Presenter presenter) {
        newMyProfileFragment.queryPayPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(NewMyProfileFragment newMyProfileFragment, BottomSheetOnBoardingContract.Presenter presenter) {
        newMyProfileFragment.bottomSheetOnBoardingPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(NewMyProfileFragment newMyProfileFragment, SavingContract.Presenter presenter) {
        newMyProfileFragment.savingPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(NewMyProfileFragment newMyProfileFragment, DynamicUrlWrapper dynamicUrlWrapper) {
        newMyProfileFragment.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(NewMyProfileFragment newMyProfileFragment, InvestmentContract.Presenter presenter) {
        newMyProfileFragment.investmentPresenter = presenter;
    }

    public static void getAuthRequestContext(NewMyProfileFragment newMyProfileFragment, GoldInvestmentContract.Presenter presenter) {
        newMyProfileFragment.goldInvestmentPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(NewMyProfileFragment newMyProfileFragment, ReadLinkPropertiesContract.Presenter presenter) {
        newMyProfileFragment.readLinkPropertiesPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(NewMyProfileFragment newMyProfileFragment, PayLaterContract.Presenter presenter) {
        newMyProfileFragment.payLaterPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(NewMyProfileFragment newMyProfileFragment, DanaPlusContract.Presenter presenter) {
        newMyProfileFragment.danaPlusPresenter = presenter;
    }
}
