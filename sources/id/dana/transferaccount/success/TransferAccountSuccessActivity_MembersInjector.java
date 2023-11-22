package id.dana.transferaccount.success;

import dagger.MembersInjector;
import id.dana.transferaccount.success.TransferAccountSuccessContract;

/* loaded from: classes5.dex */
public final class TransferAccountSuccessActivity_MembersInjector implements MembersInjector<TransferAccountSuccessActivity> {
    public static void PlaceComponentResult(TransferAccountSuccessActivity transferAccountSuccessActivity, TransferAccountSuccessContract.Presenter presenter) {
        transferAccountSuccessActivity.transferAccountSuccessPresenter = presenter;
    }
}
