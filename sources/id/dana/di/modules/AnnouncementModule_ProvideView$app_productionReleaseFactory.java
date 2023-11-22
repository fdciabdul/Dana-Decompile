package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.announcement.AnnouncementContract;

/* loaded from: classes4.dex */
public final class AnnouncementModule_ProvideView$app_productionReleaseFactory implements Factory<AnnouncementContract.View> {
    private final AnnouncementModule MyBillsEntityDataFactory;

    public static AnnouncementContract.View BuiltInFictitiousFunctionClassFactory(AnnouncementModule announcementModule) {
        return (AnnouncementContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(announcementModule.getBuiltInFictitiousFunctionClassFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (AnnouncementContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getBuiltInFictitiousFunctionClassFactory());
    }
}
