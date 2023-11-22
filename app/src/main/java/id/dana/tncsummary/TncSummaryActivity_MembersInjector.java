package id.dana.tncsummary;

import dagger.MembersInjector;
import id.dana.tncsummary.TncSummaryContract;

/* loaded from: classes9.dex */
public final class TncSummaryActivity_MembersInjector implements MembersInjector<TncSummaryActivity> {
    public static void getAuthRequestContext(TncSummaryActivity tncSummaryActivity, TncSummaryContract.Presenter presenter) {
        tncSummaryActivity.tncSummaryPresenter = presenter;
    }
}
