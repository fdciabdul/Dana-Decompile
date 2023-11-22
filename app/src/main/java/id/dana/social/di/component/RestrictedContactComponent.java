package id.dana.social.di.component;

import dagger.Subcomponent;
import id.dana.di.PerModule;
import id.dana.social.di.module.BlockedFragmentModule;
import id.dana.social.di.module.MutedFragmentModule;
import id.dana.social.di.module.SocialCommonModule;
import kotlin.Metadata;

@Subcomponent(modules = {SocialCommonModule.class})
@PerModule
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/di/component/RestrictedContactComponent;", "", "Lid/dana/social/di/module/BlockedFragmentModule;", "p0", "Lid/dana/social/di/component/BlockedFragmentComponent;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/social/di/module/BlockedFragmentModule;)Lid/dana/social/di/component/BlockedFragmentComponent;", "Lid/dana/social/di/module/MutedFragmentModule;", "Lid/dana/social/di/component/MutedFragmentComponent;", "PlaceComponentResult", "(Lid/dana/social/di/module/MutedFragmentModule;)Lid/dana/social/di/component/MutedFragmentComponent;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface RestrictedContactComponent {
    BlockedFragmentComponent BuiltInFictitiousFunctionClassFactory(BlockedFragmentModule p0);

    MutedFragmentComponent PlaceComponentResult(MutedFragmentModule p0);
}
