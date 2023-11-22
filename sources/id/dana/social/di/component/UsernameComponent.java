package id.dana.social.di.component;

import dagger.Subcomponent;
import id.dana.di.PerModule;
import id.dana.social.di.module.RelationshipBottomSheetModule;
import id.dana.social.di.module.UsernameModule;
import id.dana.social.view.activity.ChangeUsernameActivity;
import kotlin.Metadata;

@Subcomponent(modules = {UsernameModule.class, RelationshipBottomSheetModule.class})
@PerModule
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/di/component/UsernameComponent;", "", "Lid/dana/social/view/activity/ChangeUsernameActivity;", "p0", "", "getAuthRequestContext", "(Lid/dana/social/view/activity/ChangeUsernameActivity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface UsernameComponent {
    void getAuthRequestContext(ChangeUsernameActivity p0);
}
