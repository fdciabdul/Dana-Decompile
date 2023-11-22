package id.dana.contract.sendmoney;

import dagger.MembersInjector;
import id.dana.domain.sendmoney.interactor.CheckTransferX2PFeature;

/* loaded from: classes4.dex */
public final class PayMethodPresenter_MembersInjector implements MembersInjector<PayMethodPresenter> {
    public static void getAuthRequestContext(PayMethodPresenter payMethodPresenter, CheckTransferX2PFeature checkTransferX2PFeature) {
        payMethodPresenter.getAuthRequestContext = checkTransferX2PFeature;
    }
}
