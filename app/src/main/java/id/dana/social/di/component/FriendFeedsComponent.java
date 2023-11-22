package id.dana.social.di.component;

import dagger.Subcomponent;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.DanaContactModule;
import id.dana.social.di.module.FriendsFeedsModule;
import id.dana.social.di.module.RelationshipBottomSheetModule;
import id.dana.social.fragment.FriendsFeedsFragment;
import id.dana.social.v2.FeedsActivity;
import kotlin.Metadata;

@Subcomponent(modules = {FriendsFeedsModule.class, DeepLinkModule.class, DanaContactModule.class, RelationshipBottomSheetModule.class})
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/di/component/FriendFeedsComponent;", "", "Lid/dana/social/fragment/FriendsFeedsFragment;", "p0", "", "getAuthRequestContext", "(Lid/dana/social/fragment/FriendsFeedsFragment;)V", "Lid/dana/social/v2/FeedsActivity;", "MyBillsEntityDataFactory", "(Lid/dana/social/v2/FeedsActivity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes2.dex */
public interface FriendFeedsComponent {
    void MyBillsEntityDataFactory(FeedsActivity p0);

    void getAuthRequestContext(FriendsFeedsFragment p0);
}
