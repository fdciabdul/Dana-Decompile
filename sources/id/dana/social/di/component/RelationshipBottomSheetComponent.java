package id.dana.social.di.component;

import dagger.Subcomponent;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.di.PerActivity;
import id.dana.social.ReciprocalFriendListFragment;
import id.dana.social.RelationshipBottomSheetDialog;
import id.dana.social.di.module.FriendRequestListModule;
import id.dana.social.di.module.RelationshipBottomSheetModule;
import kotlin.Metadata;

@Subcomponent(modules = {RelationshipBottomSheetModule.class, DeepLinkModule.class, FriendRequestListModule.class})
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/di/component/RelationshipBottomSheetComponent;", "", "Lid/dana/social/ReciprocalFriendListFragment;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/social/ReciprocalFriendListFragment;)V", "Lid/dana/social/RelationshipBottomSheetDialog;", "(Lid/dana/social/RelationshipBottomSheetDialog;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes2.dex */
public interface RelationshipBottomSheetComponent {
    void BuiltInFictitiousFunctionClassFactory(ReciprocalFriendListFragment p0);

    void BuiltInFictitiousFunctionClassFactory(RelationshipBottomSheetDialog p0);
}
