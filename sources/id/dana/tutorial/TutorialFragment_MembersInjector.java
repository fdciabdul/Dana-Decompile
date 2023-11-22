package id.dana.tutorial;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.tutorial.TutorialContract;

/* loaded from: classes9.dex */
public final class TutorialFragment_MembersInjector implements MembersInjector<TutorialFragment> {
    public static void PlaceComponentResult(TutorialFragment tutorialFragment, TutorialContract.Presenter presenter) {
        tutorialFragment.tutorialPresenter = presenter;
    }

    public static void PlaceComponentResult(TutorialFragment tutorialFragment, ReadLinkPropertiesContract.Presenter presenter) {
        tutorialFragment.readDeepLinkPropertiesPresenter = presenter;
    }
}
