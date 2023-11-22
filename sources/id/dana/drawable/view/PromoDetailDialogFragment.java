package id.dana.drawable.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.nearbyme.model.PromoInfoModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0013\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/nearbyrevamp/view/PromoDetailDialogFragment;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", "isFullDialogHeightRequired", "()Z", "", "onShow", "()V", "onStart", "Lid/dana/nearbyme/model/PromoInfoModel;", "getErrorConfigVersion", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoDetailDialogFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<PromoInfoModel>() { // from class: id.dana.nearbyrevamp.view.PromoDetailDialogFragment$promoInfoModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PromoInfoModel invoke() {
            Bundle arguments = PromoDetailDialogFragment.this.getArguments();
            if (arguments != null) {
                return (PromoInfoModel) arguments.getParcelable("promo_info_model");
            }
            return null;
        }
    });

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* bridge */ /* synthetic */ View getPlaceComponentResult() {
        return null;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.view_bottom_sheet_promo_detail;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final boolean isFullDialogHeightRequired() {
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        initMatchParentDialog(dialog);
        initTransparentDialogDim(dialog);
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: id.dana.nearbyrevamp.view.PromoDetailDialogFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    PromoDetailDialogFragment.BuiltInFictitiousFunctionClassFactory(PromoDetailDialogFragment.this);
                }
            });
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        PromoInfoModel promoInfoModel = (PromoInfoModel) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        if (promoInfoModel != null) {
            int i = R.id.res_0x7f0a049c_barcodeutil_externalsyntheticlambda1;
            Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
            View view = map.get(Integer.valueOf(i));
            if (view == null) {
                View getAuthRequestContext = getGetAuthRequestContext();
                if (getAuthRequestContext == null || (view = getAuthRequestContext.findViewById(i)) == null) {
                    view = null;
                } else {
                    map.put(Integer.valueOf(i), view);
                }
            }
            NearbyPromoDetailView nearbyPromoDetailView = (NearbyPromoDetailView) view;
            if (nearbyPromoDetailView != null) {
                nearbyPromoDetailView.setPromoInfoModel(promoInfoModel);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/view/PromoDetailDialogFragment$Companion;", "", "Lid/dana/nearbyme/model/PromoInfoModel;", "p0", "Lid/dana/nearbyrevamp/view/PromoDetailDialogFragment;", "MyBillsEntityDataFactory", "(Lid/dana/nearbyme/model/PromoInfoModel;)Lid/dana/nearbyrevamp/view/PromoDetailDialogFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static PromoDetailDialogFragment MyBillsEntityDataFactory(PromoInfoModel p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            PromoDetailDialogFragment promoDetailDialogFragment = new PromoDetailDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("promo_info_model", p0);
            promoDetailDialogFragment.setArguments(bundle);
            return promoDetailDialogFragment;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PromoDetailDialogFragment promoDetailDialogFragment) {
        Intrinsics.checkNotNullParameter(promoDetailDialogFragment, "");
        promoDetailDialogFragment.dismiss();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
