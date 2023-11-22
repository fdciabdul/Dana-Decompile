package id.dana.pushverify.view.verificationlist.adapter;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.databinding.ViewVerificationHistoryBinding;
import id.dana.pushverify.model.VerificationDetailModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/pushverify/view/verificationlist/adapter/VerificationHistoryViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/pushverify/model/VerificationDetailModel;", "Lid/dana/databinding/ViewVerificationHistoryBinding;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(I)V", "p1", "getAuthRequestContext", "(II)V", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerificationHistoryViewHolder extends ViewBindingRecyclerViewHolder<VerificationDetailModel, ViewVerificationHistoryBinding> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        VerificationDetailModel verificationDetailModel = (VerificationDetailModel) obj;
        if (verificationDetailModel != null) {
            VerificationAdapterUtil verificationAdapterUtil = VerificationAdapterUtil.INSTANCE;
            getBinding().PlaceComponentResult.setText(getContext().getString(VerificationAdapterUtil.MyBillsEntityDataFactory(verificationDetailModel.lookAheadTest), verificationDetailModel.BuiltInFictitiousFunctionClassFactory));
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setText(verificationDetailModel.getAuthRequestContext);
            GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(verificationDetailModel.PlaceComponentResult).PlaceComponentResult((int) R.drawable.ic_push_verify_merchant).MyBillsEntityDataFactory((ImageView) getBinding().BuiltInFictitiousFunctionClassFactory);
            String str = verificationDetailModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
            switch (str.hashCode()) {
                case -1927193528:
                    if (str.equals("ABNORMAL")) {
                        getAuthRequestContext(R.string.pushverify_list_verification_failed, R.color.f26712131100373);
                        KClassImpl$Data$declaredNonStaticMembers$2(R.drawable.ic_verification_list_item_failed);
                        return;
                    }
                    return;
                case -1211756856:
                    if (str.equals("VERIFIED")) {
                        getAuthRequestContext(R.string.pushverify_list_verified, R.color.f23922131099979);
                        KClassImpl$Data$declaredNonStaticMembers$2(R.drawable.ic_verification_list_item_success);
                        return;
                    }
                    return;
                case -591252731:
                    if (str.equals("EXPIRED")) {
                        getAuthRequestContext(R.string.pushverify_list_expired, R.color.f23962131099992);
                        KClassImpl$Data$declaredNonStaticMembers$2(R.drawable.ic_push_verify_history);
                        return;
                    }
                    return;
                case 174130302:
                    if (str.equals("REJECTED")) {
                        getAuthRequestContext(R.string.pushverify_list_rejected, R.color.f26712131100373);
                        KClassImpl$Data$declaredNonStaticMembers$2(R.drawable.ic_verification_list_item_reject);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ViewVerificationHistoryBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewVerificationHistoryBinding MyBillsEntityDataFactory = ViewVerificationHistoryBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public VerificationHistoryViewHolder(android.view.ViewGroup r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131560245(0x7f0d0735, float:1.8745857E38)
            r2.<init>(r1, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.pushverify.view.verificationlist.adapter.VerificationHistoryViewHolder.<init>(android.view.ViewGroup):void");
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
        AppCompatImageView appCompatImageView = getBinding().getAuthRequestContext;
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, p0);
        } else {
            appCompatImageView.setImageResource(p0);
        }
    }

    private final void getAuthRequestContext(int p0, int p1) {
        AppCompatTextView appCompatTextView = getBinding().MyBillsEntityDataFactory;
        appCompatTextView.setText(appCompatTextView.getContext().getString(p0));
        appCompatTextView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(appCompatTextView.getContext(), p1));
    }
}
