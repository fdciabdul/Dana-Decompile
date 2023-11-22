package id.dana.splitbill.view;

import dagger.MembersInjector;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.splitbill.SplitBillContract;
import id.dana.splitbill.mapper.RecipientModelMapper;
import id.dana.splitbill.mapper.SplitBillPayerToPayerModelMapper;
import id.dana.splitbill.mapper.SplitBillPayerToRecipientModelMapper;
import id.dana.splitbill.tracker.SplitBillAnalyticTracker;

/* loaded from: classes5.dex */
public final class SplitBillActivity_MembersInjector implements MembersInjector<SplitBillActivity> {
    public static void MyBillsEntityDataFactory(SplitBillActivity splitBillActivity, GenerateDeepLinkContract.SplitBillPresenter splitBillPresenter) {
        splitBillActivity.deepLinkPresenter = splitBillPresenter;
    }

    public static void PlaceComponentResult(SplitBillActivity splitBillActivity, SplitBillContract.Presenter presenter) {
        splitBillActivity.splitBillPresenter = presenter;
    }

    public static void PlaceComponentResult(SplitBillActivity splitBillActivity, GenerateDeepLinkContract.SplitBillPresenter splitBillPresenter) {
        splitBillActivity.presenter = splitBillPresenter;
    }

    public static void PlaceComponentResult(SplitBillActivity splitBillActivity, RecipientModelMapper recipientModelMapper) {
        splitBillActivity.recipientModelMapper = recipientModelMapper;
    }

    public static void MyBillsEntityDataFactory(SplitBillActivity splitBillActivity, SplitBillPayerToRecipientModelMapper splitBillPayerToRecipientModelMapper) {
        splitBillActivity.splitBillPayerToRecipientModelMapper = splitBillPayerToRecipientModelMapper;
    }

    public static void MyBillsEntityDataFactory(SplitBillActivity splitBillActivity, SplitBillPayerToPayerModelMapper splitBillPayerToPayerModelMapper) {
        splitBillActivity.splitBillPayerToPayerModelMapper = splitBillPayerToPayerModelMapper;
    }

    public static void getAuthRequestContext(SplitBillActivity splitBillActivity, SplitBillAnalyticTracker splitBillAnalyticTracker) {
        splitBillActivity.splitBillAnalyticTracker = splitBillAnalyticTracker;
    }
}
