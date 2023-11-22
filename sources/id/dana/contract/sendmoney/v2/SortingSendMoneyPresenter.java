package id.dana.contract.sendmoney.v2;

import id.dana.contract.sendmoney.v2.SortingSendMoneyContract;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.sendmoney.interactor.GetSortingSendMoney;
import id.dana.domain.sendmoney.interactor.SaveSortingSendMoney;
import id.dana.sendmoney_v2.constants.SortingByConst;
import id.dana.utils.foundation.logger.log.DanaLog;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0003\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\n\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011"}, d2 = {"Lid/dana/contract/sendmoney/v2/SortingSendMoneyPresenter;", "Lid/dana/contract/sendmoney/v2/SortingSendMoneyContract$Presenter;", "", "getAuthRequestContext", "()V", "onDestroy", "", "p0", "(Ljava/lang/String;)V", "Lid/dana/domain/sendmoney/interactor/GetSortingSendMoney;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/sendmoney/interactor/GetSortingSendMoney;", "PlaceComponentResult", "Lid/dana/domain/sendmoney/interactor/SaveSortingSendMoney;", "MyBillsEntityDataFactory", "Lid/dana/domain/sendmoney/interactor/SaveSortingSendMoney;", "Lid/dana/contract/sendmoney/v2/SortingSendMoneyContract$View;", "Lid/dana/contract/sendmoney/v2/SortingSendMoneyContract$View;", "p1", "p2", "<init>", "(Lid/dana/domain/sendmoney/interactor/GetSortingSendMoney;Lid/dana/domain/sendmoney/interactor/SaveSortingSendMoney;Lid/dana/contract/sendmoney/v2/SortingSendMoneyContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SortingSendMoneyPresenter implements SortingSendMoneyContract.Presenter {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GetSortingSendMoney PlaceComponentResult;
    private final SaveSortingSendMoney MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SortingSendMoneyContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public SortingSendMoneyPresenter(GetSortingSendMoney getSortingSendMoney, SaveSortingSendMoney saveSortingSendMoney, SortingSendMoneyContract.View view) {
        Intrinsics.checkNotNullParameter(getSortingSendMoney, "");
        Intrinsics.checkNotNullParameter(saveSortingSendMoney, "");
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = getSortingSendMoney;
        this.MyBillsEntityDataFactory = saveSortingSendMoney;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    public final void getAuthRequestContext() {
        this.PlaceComponentResult.execute(NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.contract.sendmoney.v2.SortingSendMoneyPresenter$getSortingSendMoney$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                SortingSendMoneyContract.View view;
                Intrinsics.checkNotNullParameter(str, "");
                view = SortingSendMoneyPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.getAuthRequestContext(str);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.sendmoney.v2.SortingSendMoneyPresenter$getSortingSendMoney$2
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
                SortingSendMoneyContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = SortingSendMoneyPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.getAuthRequestContext(SortingByConst.FREQUENT);
                DanaLog.BuiltInFictitiousFunctionClassFactory("SortingSendMoney", th.getMessage(), th);
            }
        });
    }

    public final void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.execute(new SaveSortingSendMoney.Param(p0), new Function1<Boolean, Unit>() { // from class: id.dana.contract.sendmoney.v2.SortingSendMoneyPresenter$saveSortingSendMoney$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                SortingSendMoneyContract.View view;
                view = SortingSendMoneyPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.BuiltInFictitiousFunctionClassFactory();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.sendmoney.v2.SortingSendMoneyPresenter$saveSortingSendMoney$2
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
                SortingSendMoneyContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = SortingSendMoneyPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.PlaceComponentResult();
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
        this.MyBillsEntityDataFactory.dispose();
    }
}
