package id.dana.sendmoney_v2.landing.view;

import android.content.Context;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.contract.sendmoney.QueryPrefixErrorHandler;
import id.dana.contract.sendmoney.v2.BillerX2BContract;
import id.dana.danah5.DanaH5;
import id.dana.domain.sendmoney.model.BillerX2B;
import id.dana.sendmoney.model.BaseRecipientModel;
import id.dana.sendmoney.model.RecentRecipientModel;
import id.dana.sendmoney.recipient.RecipientIdType;
import id.dana.sendmoney_v2.model.BillerX2BModel;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\b\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\b\b\u0010\u0012"}, d2 = {"Lid/dana/sendmoney_v2/landing/view/RecentTransactionView$billerX2BModule$1;", "Lid/dana/contract/sendmoney/v2/BillerX2BContract$View;", "", "p0", "", "PlaceComponentResult", "(Z)V", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "Lid/dana/sendmoney/model/BaseRecipientModel;", "getAuthRequestContext", "(Lid/dana/sendmoney/model/BaseRecipientModel;)V", "Lid/dana/sendmoney_v2/model/BillerX2BModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney_v2/model/BillerX2BModel;)V", "", "Lid/dana/domain/sendmoney/model/BillerX2B;", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecentTransactionView$billerX2BModule$1 implements BillerX2BContract.View {
    final /* synthetic */ RecentTransactionView PlaceComponentResult;

    @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
    public final void BuiltInFictitiousFunctionClassFactory(List<BillerX2B> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
    public final void PlaceComponentResult(boolean p0) {
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void showProgress() {
        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecentTransactionView$billerX2BModule$1(RecentTransactionView recentTransactionView) {
        this.PlaceComponentResult = recentTransactionView;
    }

    @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(BillerX2BModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        RecentTransactionView.access$showBillerX2BDialog(this.PlaceComponentResult, p0);
    }

    @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
    public final void getAuthRequestContext(BaseRecipientModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p0 instanceof RecentRecipientModel) {
            RecentTransactionView.access$handleClickedRecipientType(this.PlaceComponentResult, (RecentRecipientModel) p0, "bank", RecipientIdType.INSTITUTION);
        }
    }

    @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        DanaH5.startContainerFullUrl(p0);
    }

    @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
    public final void getAuthRequestContext(String p0) {
        RecentRecipientModel recentRecipientModel;
        Intrinsics.checkNotNullParameter(p0, "");
        RecentTransactionView recentTransactionView = this.PlaceComponentResult;
        recentRecipientModel = recentTransactionView.moveToNextValue;
        if (recentRecipientModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recentRecipientModel = null;
        }
        RecentTransactionView.access$handleClickedRecipientType(recentTransactionView, recentRecipientModel, "bank", RecipientIdType.INSTITUTION);
    }

    @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
    public final void PlaceComponentResult(final BaseRecipientModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        RecentTransactionView recentTransactionView = this.PlaceComponentResult;
        Context context = recentTransactionView.getContext();
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.base.BaseActivity");
        }
        recentTransactionView.BuiltInFictitiousFunctionClassFactory = QueryPrefixErrorHandler.MyBillsEntityDataFactory((BaseActivity) context).subscribe(new Consumer() { // from class: id.dana.sendmoney_v2.landing.view.RecentTransactionView$billerX2BModule$1$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Long l = (Long) obj;
                RecentTransactionView$billerX2BModule$1.BuiltInFictitiousFunctionClassFactory(RecentTransactionView$billerX2BModule$1.this, p0);
            }
        });
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(RecentTransactionView$billerX2BModule$1 recentTransactionView$billerX2BModule$1, BaseRecipientModel baseRecipientModel) {
        Intrinsics.checkNotNullParameter(recentTransactionView$billerX2BModule$1, "");
        Intrinsics.checkNotNullParameter(baseRecipientModel, "");
        Intrinsics.checkNotNullParameter(baseRecipientModel, "");
        if (baseRecipientModel instanceof RecentRecipientModel) {
            RecentTransactionView.access$handleClickedRecipientType(recentTransactionView$billerX2BModule$1.PlaceComponentResult, (RecentRecipientModel) baseRecipientModel, "bank", RecipientIdType.INSTITUTION);
        }
    }
}
