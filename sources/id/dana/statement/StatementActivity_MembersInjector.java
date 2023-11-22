package id.dana.statement;

import dagger.MembersInjector;
import id.dana.statement.UserStatementContract;
import id.dana.usereducation.BottomSheetOnBoardingContract;

/* loaded from: classes5.dex */
public final class StatementActivity_MembersInjector implements MembersInjector<StatementActivity> {
    public static void getAuthRequestContext(StatementActivity statementActivity, UserStatementContract.Presenter presenter) {
        statementActivity.presenter = presenter;
    }

    public static void MyBillsEntityDataFactory(StatementActivity statementActivity, BottomSheetOnBoardingContract.Presenter presenter) {
        statementActivity.onBoardingPresenter = presenter;
    }
}
