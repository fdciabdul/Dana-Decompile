package id.dana.splitbill.view;

import dagger.MembersInjector;
import id.dana.splitbill.SplitBillHistoryContract;
import id.dana.splitbill.mapper.SplitBillPayerToPayerModelMapper;

/* loaded from: classes5.dex */
public final class SplitBillHistoryView_MembersInjector implements MembersInjector<SplitBillHistoryView> {
    public static void MyBillsEntityDataFactory(SplitBillHistoryView splitBillHistoryView, SplitBillHistoryContract.Presenter presenter) {
        splitBillHistoryView.presenter = presenter;
    }

    public static void MyBillsEntityDataFactory(SplitBillHistoryView splitBillHistoryView, SplitBillPayerToPayerModelMapper splitBillPayerToPayerModelMapper) {
        splitBillHistoryView.splitBillPayerToPayerModelMapper = splitBillPayerToPayerModelMapper;
    }
}
