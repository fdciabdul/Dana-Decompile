package id.dana.social.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.social.contract.RelationshipBottomSheetContract;
import id.dana.social.presenter.RelationshipBottomSheetPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/social/di/module/RelationshipBottomSheetModule;", "", "Lid/dana/social/presenter/RelationshipBottomSheetPresenter;", "p0", "Lid/dana/social/contract/RelationshipBottomSheetContract$Presenter;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/social/presenter/RelationshipBottomSheetPresenter;)Lid/dana/social/contract/RelationshipBottomSheetContract$Presenter;", "Lid/dana/social/contract/RelationshipBottomSheetContract$View;", "getAuthRequestContext", "()Lid/dana/social/contract/RelationshipBottomSheetContract$View;", "Lid/dana/social/contract/RelationshipBottomSheetContract$View;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/social/contract/RelationshipBottomSheetContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes2.dex */
public final class RelationshipBottomSheetModule {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final RelationshipBottomSheetContract.View MyBillsEntityDataFactory;

    public RelationshipBottomSheetModule(RelationshipBottomSheetContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.MyBillsEntityDataFactory = view;
    }

    @Provides
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final RelationshipBottomSheetContract.View getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Provides
    public final RelationshipBottomSheetContract.Presenter BuiltInFictitiousFunctionClassFactory(RelationshipBottomSheetPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
