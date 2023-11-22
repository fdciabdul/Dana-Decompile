package id.dana.social.view.activity;

import dagger.MembersInjector;
import id.dana.social.contract.RelationshipBottomSheetContract;
import id.dana.social.contract.UsernameContract;

/* loaded from: classes5.dex */
public final class ChangeUsernameActivity_MembersInjector implements MembersInjector<ChangeUsernameActivity> {
    public static void PlaceComponentResult(ChangeUsernameActivity changeUsernameActivity, UsernameContract.Presenter presenter) {
        changeUsernameActivity.usernamePresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(ChangeUsernameActivity changeUsernameActivity, RelationshipBottomSheetContract.Presenter presenter) {
        changeUsernameActivity.settingPresenter = presenter;
    }
}
