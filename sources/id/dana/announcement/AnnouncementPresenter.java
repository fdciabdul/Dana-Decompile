package id.dana.announcement;

import id.dana.announcement.AnnouncementContract;
import id.dana.domain.announcement.interactor.SaveGnAnnouncementId;
import id.dana.utils.foundation.logger.log.DanaLog;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u000e\u001a\u0006*\u00020\u00050\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0014\u0010\n\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010"}, d2 = {"Lid/dana/announcement/AnnouncementPresenter;", "Lid/dana/announcement/AnnouncementContract$Presenter;", "", "onDestroy", "()V", "", "p0", "PlaceComponentResult", "(Ljava/lang/String;)V", "Lid/dana/domain/announcement/interactor/SaveGnAnnouncementId;", "MyBillsEntityDataFactory", "Lid/dana/domain/announcement/interactor/SaveGnAnnouncementId;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "Lid/dana/announcement/AnnouncementContract$View;", "Lid/dana/announcement/AnnouncementContract$View;", "p1", "<init>", "(Lid/dana/announcement/AnnouncementContract$View;Lid/dana/domain/announcement/interactor/SaveGnAnnouncementId;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AnnouncementPresenter implements AnnouncementContract.Presenter {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final SaveGnAnnouncementId BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final String getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final AnnouncementContract.View MyBillsEntityDataFactory;

    @Inject
    public AnnouncementPresenter(AnnouncementContract.View view, SaveGnAnnouncementId saveGnAnnouncementId) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(saveGnAnnouncementId, "");
        this.MyBillsEntityDataFactory = view;
        this.BuiltInFictitiousFunctionClassFactory = saveGnAnnouncementId;
        this.getAuthRequestContext = "AnnouncementPresenter";
    }

    @Override // id.dana.announcement.AnnouncementContract.Presenter
    public final void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory.execute(new SaveGnAnnouncementId.Params(p0), new Function1<Boolean, Unit>() { // from class: id.dana.announcement.AnnouncementPresenter$saveGnAnnouncementId$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.announcement.AnnouncementPresenter$saveGnAnnouncementId$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                AnnouncementContract.View view;
                String str;
                Intrinsics.checkNotNullParameter(th, "");
                view = AnnouncementPresenter.this.MyBillsEntityDataFactory;
                view.onError(th.getMessage());
                str = AnnouncementPresenter.this.getAuthRequestContext;
                DanaLog.BuiltInFictitiousFunctionClassFactory(str, th.getMessage());
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }
}
