package id.dana.pushverify.view.verificationlist.list;

import com.alibaba.ariver.kernel.RVEvents;
import id.dana.base.AbstractContractKt;
import id.dana.pushverify.model.VerificationDetailModel;
import id.dana.pushverify.view.verificationlist.adapter.VerificationAdapterUtil;
import id.dana.pushverify.view.verificationlist.adapter.VerificationListAdapter;
import id.dana.pushverify.view.verificationlist.list.VerificationListContract;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u001d\u0010\u000f\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004"}, d2 = {"Lid/dana/pushverify/view/verificationlist/list/VerificationListHistoryFragment$getVerificationListModule$1;", "Lid/dana/pushverify/view/verificationlist/list/VerificationListContract$View;", "", "dismissProgress", "()V", "getAuthRequestContext", "", "p0", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "", "Lid/dana/pushverify/model/VerificationDetailModel;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)V", "PlaceComponentResult", "MyBillsEntityDataFactory", "showProgress"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerificationListHistoryFragment$getVerificationListModule$1 implements VerificationListContract.View {
    final /* synthetic */ VerificationListHistoryFragment MyBillsEntityDataFactory;

    @Override // id.dana.pushverify.view.verificationlist.list.VerificationListContract.View
    public final void PlaceComponentResult(List<VerificationDetailModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VerificationListHistoryFragment$getVerificationListModule$1(VerificationListHistoryFragment verificationListHistoryFragment) {
        this.MyBillsEntityDataFactory = verificationListHistoryFragment;
    }

    @Override // id.dana.pushverify.view.verificationlist.list.VerificationListContract.View
    public final void MyBillsEntityDataFactory(List<VerificationDetailModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        VerificationListHistoryFragment.lookAheadTest(this.MyBillsEntityDataFactory);
        VerificationListHistoryFragment.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, p0);
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory = false;
    }

    @Override // id.dana.pushverify.view.verificationlist.list.VerificationListContract.View
    public final void getAuthRequestContext() {
        this.MyBillsEntityDataFactory.getAuthRequestContext(0);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String p0) {
        this.MyBillsEntityDataFactory.getAuthRequestContext(99);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        VerificationListHistoryFragment.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        VerificationListAdapter.KClassImpl$Data$declaredNonStaticMembers$2((VerificationListAdapter) this.MyBillsEntityDataFactory.getAuthRequestContext.getValue(), CollectionsKt.emptyList());
    }

    @Override // id.dana.pushverify.view.verificationlist.list.VerificationListContract.View
    public final void MyBillsEntityDataFactory() {
        VerificationListAdapter MyBillsEntityDataFactory = VerificationListHistoryFragment.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
        VerificationAdapterUtil verificationAdapterUtil = VerificationAdapterUtil.INSTANCE;
        VerificationDetailModel MyBillsEntityDataFactory2 = VerificationAdapterUtil.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory2, "");
        List<VerificationDetailModel> list = MyBillsEntityDataFactory.getAuthRequestContext.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(list, "");
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(MyBillsEntityDataFactory2);
        VerificationListAdapter.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory, arrayList);
    }

    @Override // id.dana.pushverify.view.verificationlist.list.VerificationListContract.View
    public final void BuiltInFictitiousFunctionClassFactory(final List<VerificationDetailModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        VerificationListHistoryFragment.lookAheadTest(this.MyBillsEntityDataFactory);
        final VerificationListAdapter MyBillsEntityDataFactory = VerificationListHistoryFragment.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
        List<VerificationDetailModel> emptyList = CollectionsKt.emptyList();
        Runnable runnable = new Runnable() { // from class: id.dana.pushverify.view.verificationlist.list.VerificationListHistoryFragment$getVerificationListModule$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VerificationListHistoryFragment$getVerificationListModule$1.getAuthRequestContext(VerificationListAdapter.this, p0);
            }
        };
        Intrinsics.checkNotNullParameter(emptyList, "");
        MyBillsEntityDataFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(emptyList, runnable);
    }

    public static /* synthetic */ void getAuthRequestContext(VerificationListAdapter verificationListAdapter, List list) {
        Intrinsics.checkNotNullParameter(verificationListAdapter, "");
        Intrinsics.checkNotNullParameter(list, "");
        VerificationListAdapter.KClassImpl$Data$declaredNonStaticMembers$2(verificationListAdapter, list);
    }
}
