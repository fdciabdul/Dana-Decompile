package id.dana.contract.deeplink;

import dagger.MembersInjector;
import id.dana.domain.paylater.interactor.GetUserLoanInfo;

/* loaded from: classes4.dex */
public final class DeepLinkView_MembersInjector implements MembersInjector<DeepLinkView> {
    public static void MyBillsEntityDataFactory(DeepLinkView deepLinkView, GetUserLoanInfo getUserLoanInfo) {
        deepLinkView.getUserLoanInfo = getUserLoanInfo;
    }
}
