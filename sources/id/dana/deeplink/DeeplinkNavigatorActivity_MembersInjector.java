package id.dana.deeplink;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;

/* loaded from: classes8.dex */
public final class DeeplinkNavigatorActivity_MembersInjector implements MembersInjector<DeeplinkNavigatorActivity> {
    public static void PlaceComponentResult(DeeplinkNavigatorActivity deeplinkNavigatorActivity, ReadLinkPropertiesContract.Presenter presenter) {
        deeplinkNavigatorActivity.readLinkProperties = presenter;
    }
}
