package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.familyaccount.contract.FamilyJoinInvitationContract;
import id.dana.familyaccount.contract.FamilyJoinInvitationPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/di/modules/FamilyAccountJoinInvitationModule;", "", "Lid/dana/familyaccount/contract/FamilyJoinInvitationPresenter;", "p0", "Lid/dana/familyaccount/contract/FamilyJoinInvitationContract$Presenter;", "PlaceComponentResult", "(Lid/dana/familyaccount/contract/FamilyJoinInvitationPresenter;)Lid/dana/familyaccount/contract/FamilyJoinInvitationContract$Presenter;", "Lid/dana/familyaccount/contract/FamilyJoinInvitationContract$View;", "MyBillsEntityDataFactory", "()Lid/dana/familyaccount/contract/FamilyJoinInvitationContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/familyaccount/contract/FamilyJoinInvitationContract$View;", "<init>", "(Lid/dana/familyaccount/contract/FamilyJoinInvitationContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class FamilyAccountJoinInvitationModule {
    private final FamilyJoinInvitationContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    public FamilyAccountJoinInvitationModule(FamilyJoinInvitationContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    @Provides
    @PerActivity
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final FamilyJoinInvitationContract.View getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Provides
    @PerActivity
    public final FamilyJoinInvitationContract.Presenter PlaceComponentResult(FamilyJoinInvitationPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
