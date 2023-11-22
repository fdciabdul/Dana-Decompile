package id.dana.miniprogram.di;

import dagger.Lazy;
import id.dana.domain.miniprogram.interactor.GetMiniPrograms;
import id.dana.domain.miniprogram.interactor.SetFavoriteMiniPrograms;
import id.dana.domain.miniprogram.interactor.SetRecentMiniProgram;
import id.dana.miniprogram.di.MiniProgramContract;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB;\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0010\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\t\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\t¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0012\u0010\u000b\u001a\u00020\u000eX\u0086\"¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00150\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\fR\u0012\u0010\u0017\u001a\u00020\u000eX\u0086\"¢\u0006\u0006\n\u0004\b\u0014\u0010\u000f"}, d2 = {"Lid/dana/miniprogram/di/MiniProgramPresenter;", "Lid/dana/miniprogram/di/MiniProgramContract$Presenter;", "", "onDestroy", "()V", "", "p0", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "Ldagger/Lazy;", "Lid/dana/domain/miniprogram/interactor/GetMiniPrograms;", "getAuthRequestContext", "Ldagger/Lazy;", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "Lid/dana/miniprogram/di/MiniProgramContract$View;", "Lid/dana/miniprogram/di/MiniProgramContract$View;", "PlaceComponentResult", "Lid/dana/domain/miniprogram/interactor/SetFavoriteMiniPrograms;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/miniprogram/interactor/SetRecentMiniProgram;", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p1", "p2", "p3", "<init>", "(Lid/dana/miniprogram/di/MiniProgramContract$View;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MiniProgramPresenter implements MiniProgramContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final MiniProgramContract.View PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public CoroutineScope NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public CoroutineScope getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Lazy<SetFavoriteMiniPrograms> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Lazy<GetMiniPrograms> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy<SetRecentMiniProgram> MyBillsEntityDataFactory;

    @Inject
    public MiniProgramPresenter(MiniProgramContract.View view, Lazy<GetMiniPrograms> lazy, Lazy<SetFavoriteMiniPrograms> lazy2, Lazy<SetRecentMiniProgram> lazy3) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        this.PlaceComponentResult = view;
        this.BuiltInFictitiousFunctionClassFactory = lazy;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy2;
        this.MyBillsEntityDataFactory = lazy3;
    }

    public final void MyBillsEntityDataFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final SetRecentMiniProgram.Params params = new SetRecentMiniProgram.Params(p0, 0L, 2, null);
        this.MyBillsEntityDataFactory.get().execute(params, new Function0<Unit>() { // from class: id.dana.miniprogram.di.MiniProgramPresenter$setRecentMiniProgram$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MiniProgramContract.View view;
                view = MiniProgramPresenter.this.PlaceComponentResult;
                view.onSetRecentMiniProgram(p0, params.getLastOpen());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.miniprogram.di.MiniProgramPresenter$setRecentMiniProgram$2
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
                MiniProgramContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = MiniProgramPresenter.this.PlaceComponentResult;
                view.onError(th.getMessage());
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.MyBillsEntityDataFactory.get().dispose();
    }
}
