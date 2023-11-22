package id.dana.drawable.search.searchresult;

import dagger.MembersInjector;
import id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract;

/* loaded from: classes5.dex */
public final class ChainQueryFragment_MembersInjector implements MembersInjector<ChainQueryFragment> {
    public static void getAuthRequestContext(ChainQueryFragment chainQueryFragment, NearbyMerchantLocationSearchContract.Presenter presenter) {
        chainQueryFragment.searchPresenter = presenter;
    }
}
