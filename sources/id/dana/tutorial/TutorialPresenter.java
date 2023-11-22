package id.dana.tutorial;

import id.dana.base.AbstractContractKt;
import id.dana.domain.danainfo.interactor.GetTutorials;
import id.dana.domain.promotion.Space;
import id.dana.tutorial.TutorialContract;
import id.dana.tutorial.mapper.TutorialModelMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\r"}, d2 = {"Lid/dana/tutorial/TutorialPresenter;", "Lid/dana/tutorial/TutorialContract$Presenter;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "Lid/dana/domain/danainfo/interactor/GetTutorials;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/danainfo/interactor/GetTutorials;", "PlaceComponentResult", "Lid/dana/tutorial/mapper/TutorialModelMapper;", "MyBillsEntityDataFactory", "Lid/dana/tutorial/mapper/TutorialModelMapper;", "Lid/dana/tutorial/TutorialContract$View;", "Lid/dana/tutorial/TutorialContract$View;", "p0", "p1", "p2", "<init>", "(Lid/dana/tutorial/TutorialContract$View;Lid/dana/domain/danainfo/interactor/GetTutorials;Lid/dana/tutorial/mapper/TutorialModelMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class TutorialPresenter implements TutorialContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetTutorials PlaceComponentResult;
    private final TutorialContract.View KClassImpl$Data$declaredNonStaticMembers$2;
    private final TutorialModelMapper MyBillsEntityDataFactory;

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final /* synthetic */ void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Inject
    public TutorialPresenter(TutorialContract.View view, GetTutorials getTutorials, TutorialModelMapper tutorialModelMapper) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getTutorials, "");
        Intrinsics.checkNotNullParameter(tutorialModelMapper, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.PlaceComponentResult = getTutorials;
        this.MyBillsEntityDataFactory = tutorialModelMapper;
    }

    @Override // id.dana.tutorial.TutorialContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.PlaceComponentResult.execute(Unit.INSTANCE, new Function1<Space, Unit>() { // from class: id.dana.tutorial.TutorialPresenter$getTutorial$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Space space) {
                invoke2(space);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x0055  */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(id.dana.domain.promotion.Space r5) {
                /*
                    r4 = this;
                    java.lang.String r0 = ""
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                    java.util.List r5 = r5.getCdpContents()
                    if (r5 == 0) goto L52
                    java.lang.Iterable r5 = (java.lang.Iterable) r5
                    id.dana.tutorial.TutorialPresenter r0 = id.dana.tutorial.TutorialPresenter.this
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r2 = 10
                    int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r2)
                    r1.<init>(r2)
                    java.util.Collection r1 = (java.util.Collection) r1
                    java.util.Iterator r5 = r5.iterator()
                L20:
                    boolean r2 = r5.hasNext()
                    if (r2 == 0) goto L3a
                    java.lang.Object r2 = r5.next()
                    id.dana.domain.promotion.CdpContent r2 = (id.dana.domain.promotion.CdpContent) r2
                    id.dana.tutorial.mapper.TutorialModelMapper r3 = id.dana.tutorial.TutorialPresenter.KClassImpl$Data$declaredNonStaticMembers$2(r0)
                    java.lang.Object r2 = r3.apply(r2)
                    id.dana.tutorial.model.TutorialModel r2 = (id.dana.tutorial.model.TutorialModel) r2
                    r1.add(r2)
                    goto L20
                L3a:
                    java.util.List r1 = (java.util.List) r1
                    java.lang.Iterable r1 = (java.lang.Iterable) r1
                    id.dana.tutorial.TutorialPresenter$getTutorial$1$invoke$$inlined$sortedBy$1 r5 = new id.dana.tutorial.TutorialPresenter$getTutorial$1$invoke$$inlined$sortedBy$1
                    r5.<init>()
                    java.util.Comparator r5 = (java.util.Comparator) r5
                    java.util.List r5 = kotlin.collections.CollectionsKt.sortedWith(r1, r5)
                    if (r5 == 0) goto L52
                    java.lang.Iterable r5 = (java.lang.Iterable) r5
                    java.util.List r5 = kotlin.collections.CollectionsKt.filterNotNull(r5)
                    goto L53
                L52:
                    r5 = 0
                L53:
                    if (r5 != 0) goto L59
                    java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
                L59:
                    id.dana.tutorial.TutorialPresenter r0 = id.dana.tutorial.TutorialPresenter.this
                    id.dana.tutorial.TutorialContract$View r0 = id.dana.tutorial.TutorialPresenter.getAuthRequestContext(r0)
                    r0.MyBillsEntityDataFactory(r5)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.tutorial.TutorialPresenter$getTutorial$1.invoke2(id.dana.domain.promotion.Space):void");
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.tutorial.TutorialPresenter$getTutorial$2
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
                TutorialContract.View unused;
                Intrinsics.checkNotNullParameter(th, "");
                unused = TutorialPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
            }
        });
    }
}
