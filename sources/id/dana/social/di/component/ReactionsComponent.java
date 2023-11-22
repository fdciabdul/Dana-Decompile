package id.dana.social.di.component;

import dagger.Subcomponent;
import id.dana.di.PerActivity;
import id.dana.social.AddReactionBottomSheetDialog;
import id.dana.social.di.module.ReactionsModule;
import id.dana.social.view.ActivityReactionsBottomSheetDialog;
import id.dana.social.view.ReactionSectionView;
import kotlin.Metadata;

@Subcomponent(modules = {ReactionsModule.class})
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/di/component/ReactionsComponent;", "", "Lid/dana/social/AddReactionBottomSheetDialog;", "p0", "", "MyBillsEntityDataFactory", "(Lid/dana/social/AddReactionBottomSheetDialog;)V", "Lid/dana/social/view/ActivityReactionsBottomSheetDialog;", "(Lid/dana/social/view/ActivityReactionsBottomSheetDialog;)V", "Lid/dana/social/view/ReactionSectionView;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/social/view/ReactionSectionView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes2.dex */
public interface ReactionsComponent {
    void KClassImpl$Data$declaredNonStaticMembers$2(ReactionSectionView p0);

    void MyBillsEntityDataFactory(AddReactionBottomSheetDialog p0);

    void MyBillsEntityDataFactory(ActivityReactionsBottomSheetDialog p0);
}
