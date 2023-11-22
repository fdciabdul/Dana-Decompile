package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.promoquest.mission.MissionListContract;
import id.dana.contract.promoquest.mission.MissionListPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/di/modules/PromoQuestModule;", "", "Lid/dana/contract/promoquest/mission/MissionListContract$View;", "MyBillsEntityDataFactory", "()Lid/dana/contract/promoquest/mission/MissionListContract$View;", "Lid/dana/contract/promoquest/mission/MissionListPresenter;", "p0", "Lid/dana/contract/promoquest/mission/MissionListContract$Presenter;", "PlaceComponentResult", "(Lid/dana/contract/promoquest/mission/MissionListPresenter;)Lid/dana/contract/promoquest/mission/MissionListContract$Presenter;", "Lid/dana/contract/promoquest/mission/MissionListContract$View;", "getAuthRequestContext", "<init>", "(Lid/dana/contract/promoquest/mission/MissionListContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class PromoQuestModule {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final MissionListContract.View getAuthRequestContext;

    public PromoQuestModule(MissionListContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = view;
    }

    @Provides
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final MissionListContract.View getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Provides
    public final MissionListContract.Presenter PlaceComponentResult(MissionListPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
