package id.dana.sendmoney_v2.recipient.view;

import dagger.MembersInjector;
import id.dana.contract.contact.DanaContactContract;
import id.dana.contract.sendmoney.bank.SavedBankCardContract;
import id.dana.contract.sendmoney.v2.SortingSendMoneyPresenter;
import id.dana.sendmoney.recipient.recent.RecentRecipientContract;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.usereducation.BottomSheetOnBoardingContract;

/* loaded from: classes5.dex */
public final class RecipientView_MembersInjector implements MembersInjector<RecipientView> {
    public static void MyBillsEntityDataFactory(RecipientView recipientView, DanaContactContract.Presenter presenter) {
        recipientView.danaContactPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(RecipientView recipientView, SavedBankCardContract.Presenter presenter) {
        recipientView.savedBankPresenter = presenter;
    }

    public static void getAuthRequestContext(RecipientView recipientView, BottomSheetOnBoardingContract.Presenter presenter) {
        recipientView.onBoardingPresenter = presenter;
    }

    public static void PlaceComponentResult(RecipientView recipientView, SortingSendMoneyPresenter sortingSendMoneyPresenter) {
        recipientView.sortingSendMoneyPresenter = sortingSendMoneyPresenter;
    }

    public static void PlaceComponentResult(RecipientView recipientView, RecentRecipientContract.Presenter presenter) {
        recipientView.recentRecipientPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(RecipientView recipientView, SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        recipientView.sendMoneyAnalyticTracker = sendMoneyAnalyticTracker;
    }
}
