package id.dana.social.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.social.contract.MyFeedsContract;
import id.dana.social.contract.MyFeedsPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\b\u001a\u00020\u0007X\u0007¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/social/di/module/MyFeedsModule;", "", "Lid/dana/social/contract/MyFeedsPresenter;", "p0", "Lid/dana/social/contract/MyFeedsContract$Presenter;", "getAuthRequestContext", "(Lid/dana/social/contract/MyFeedsPresenter;)Lid/dana/social/contract/MyFeedsContract$Presenter;", "Lid/dana/social/contract/MyFeedsContract$View;", "MyBillsEntityDataFactory", "()Lid/dana/social/contract/MyFeedsContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/social/contract/MyFeedsContract$View;", "<init>", "(Lid/dana/social/contract/MyFeedsContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes2.dex */
public final class MyFeedsModule {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final MyFeedsContract.View MyBillsEntityDataFactory;

    public MyFeedsModule(MyFeedsContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.MyBillsEntityDataFactory = view;
    }

    @Provides
    @PerActivity
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final MyFeedsContract.View getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Provides
    @PerActivity
    public final MyFeedsContract.Presenter getAuthRequestContext(MyFeedsPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
