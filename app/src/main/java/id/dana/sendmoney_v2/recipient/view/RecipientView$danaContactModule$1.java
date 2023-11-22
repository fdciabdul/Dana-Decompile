package id.dana.sendmoney_v2.recipient.view;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.alibaba.ariver.kernel.RVEvents;
import id.dana.base.AbstractContractKt;
import id.dana.contract.contact.DanaContactContract;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney_v2.recipient.adapter.RecipientAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004"}, d2 = {"Lid/dana/sendmoney_v2/recipient/view/RecipientView$danaContactModule$1;", "Lid/dana/contract/contact/DanaContactContract$View;", "", "dismissProgress", "()V", "onEnableContactSyncFeature", "", "p0", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "", "onGetContactSyncState", "(Z)V", "", "onGetDanaUserContactSuccess", "(Ljava/util/List;)V", "Lid/dana/sendmoney/model/RecipientViewModel;", "onGetRecipientSyncContacts", "showProgress"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecipientView$danaContactModule$1 implements DanaContactContract.View {
    final /* synthetic */ RecipientView BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.contract.contact.DanaContactContract.View
    public final void onGetContactSyncState(boolean p0) {
    }

    @Override // id.dana.contract.contact.DanaContactContract.View
    public final /* synthetic */ void onGetSyncContacts(List list) {
        DanaContactContract.View.CC.MyBillsEntityDataFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecipientView$danaContactModule$1(RecipientView recipientView) {
        this.BuiltInFictitiousFunctionClassFactory = recipientView;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        Handler handler = new Handler(Looper.getMainLooper());
        final RecipientView recipientView = this.BuiltInFictitiousFunctionClassFactory;
        handler.postDelayed(new Runnable() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$danaContactModule$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RecipientView$danaContactModule$1.PlaceComponentResult(RecipientView.this);
            }
        }, 500L);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        Handler handler = new Handler(Looper.getMainLooper());
        final RecipientView recipientView = this.BuiltInFictitiousFunctionClassFactory;
        handler.postDelayed(new Runnable() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$danaContactModule$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                RecipientView$danaContactModule$1.KClassImpl$Data$declaredNonStaticMembers$2(RecipientView.this);
            }
        }, 250L);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String p0) {
        this.BuiltInFictitiousFunctionClassFactory.getSavedBankPresenter().PlaceComponentResult();
    }

    @Override // id.dana.contract.contact.DanaContactContract.View
    public final void onGetDanaUserContactSuccess(List<String> p0) {
        RecipientAdapter recipientAdapter;
        recipientAdapter = this.BuiltInFictitiousFunctionClassFactory.FragmentBottomSheetPaymentSettingBinding;
        if (recipientAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientAdapter = null;
        }
        if (p0 == null) {
            p0 = CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNullParameter(p0, "");
        recipientAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
        recipientAdapter.notifyDataSetChanged();
    }

    @Override // id.dana.contract.contact.DanaContactContract.View
    public final void onEnableContactSyncFeature() {
        this.BuiltInFictitiousFunctionClassFactory.getOnContactSyncEnabled().invoke();
    }

    @Override // id.dana.contract.contact.DanaContactContract.View
    public final void onGetRecipientSyncContacts(List<RecipientViewModel> p0) {
        this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = p0;
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(RecipientView recipientView) {
        View view;
        Intrinsics.checkNotNullParameter(recipientView, "");
        RecipientView.access$dismissShimmer(recipientView);
        view = recipientView.getView();
        if (view != null) {
            recipientView.bindView(view);
        }
    }

    public static /* synthetic */ void PlaceComponentResult(RecipientView recipientView) {
        Intrinsics.checkNotNullParameter(recipientView, "");
        RecipientView.access$showShimmer(recipientView);
    }
}
