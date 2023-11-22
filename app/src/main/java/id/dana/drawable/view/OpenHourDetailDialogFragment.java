package id.dana.drawable.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.drawable.merchantdetail.adapter.OpenHourDetailAdapter;
import id.dana.nearbyme.model.ShopModel;
import id.dana.nearbyme.model.ShopOpenHourModel;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0016\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rR\u0013\u0010\u0012\u001a\u00020\u000fX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011"}, d2 = {"Lid/dana/nearbyrevamp/view/OpenHourDetailDialogFragment;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", "isFullDialogHeightRequired", "()Z", "", "onShow", "()V", "onStart", "Lid/dana/nearbyrevamp/merchantdetail/adapter/OpenHourDetailAdapter;", "scheduleImpl", "Lkotlin/Lazy;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/model/ShopModel;", "moveToNextValue", "getAuthRequestContext", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OpenHourDetailDialogFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<OpenHourDetailAdapter>() { // from class: id.dana.nearbyrevamp.view.OpenHourDetailDialogFragment$openHourDetailAdapter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final OpenHourDetailAdapter invoke() {
            return new OpenHourDetailAdapter();
        }
    });

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<ShopModel>() { // from class: id.dana.nearbyrevamp.view.OpenHourDetailDialogFragment$shopModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ShopModel invoke() {
            Bundle arguments = OpenHourDetailDialogFragment.this.getArguments();
            if (arguments != null) {
                return (ShopModel) arguments.getParcelable("shopModel");
            }
            return null;
        }
    });

    private View PlaceComponentResult(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

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
        return R.layout.view_open_hour_detail_bottomsheet;
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
            dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: id.dana.nearbyrevamp.view.OpenHourDetailDialogFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    OpenHourDetailDialogFragment.BuiltInFictitiousFunctionClassFactory(OpenHourDetailDialogFragment.this);
                }
            });
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        Locale locale;
        super.onShow();
        RecyclerView recyclerView = (RecyclerView) PlaceComponentResult(R.id.res_0x7f0a1112_linkspan_resolver);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        RecyclerView recyclerView2 = (RecyclerView) PlaceComponentResult(R.id.res_0x7f0a1112_linkspan_resolver);
        if (recyclerView2 != null) {
            recyclerView2.setAdapter((OpenHourDetailAdapter) this.BuiltInFictitiousFunctionClassFactory.getValue());
        }
        if (((ShopModel) this.getAuthRequestContext.getValue()) != null) {
            OpenHourDetailAdapter openHourDetailAdapter = (OpenHourDetailAdapter) this.BuiltInFictitiousFunctionClassFactory.getValue();
            ShopModel shopModel = (ShopModel) this.getAuthRequestContext.getValue();
            Intrinsics.checkNotNull(shopModel);
            List<ShopOpenHourModel> list = shopModel.C;
            Intrinsics.checkNotNullExpressionValue(list, "");
            ArrayList arrayList = new ArrayList();
            ShopModel shopModel2 = (ShopModel) this.getAuthRequestContext.getValue();
            Intrinsics.checkNotNull(shopModel2);
            if (!shopModel2.moveToNextValue()) {
                arrayList.addAll(list);
            } else {
                ArrayList arrayList2 = new ArrayList();
                locale = Locale.getDefault();
                String[] weekdays = DateFormatSymbols.getInstance(locale).getWeekdays();
                Intrinsics.checkNotNullExpressionValue(weekdays, "");
                for (String str : weekdays) {
                    Intrinsics.checkNotNullExpressionValue(str, "");
                    if (str.length() > 0) {
                        arrayList2.add(new ShopOpenHourModel(str, 0L, 0L, false, true, 14, null));
                    }
                }
                if (Intrinsics.areEqual(((ShopOpenHourModel) CollectionsKt.first((List) arrayList2)).BuiltInFictitiousFunctionClassFactory, weekdays[1])) {
                    arrayList2.add((ShopOpenHourModel) CollectionsKt.removeFirst(arrayList2));
                }
                arrayList.addAll(arrayList2);
            }
            Intrinsics.checkNotNull((ShopModel) this.getAuthRequestContext.getValue());
            ((ShopOpenHourModel) arrayList.get(ShopModel.KClassImpl$Data$declaredNonStaticMembers$2())).KClassImpl$Data$declaredNonStaticMembers$2 = true;
            openHourDetailAdapter.setItems(arrayList);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/view/OpenHourDetailDialogFragment$Companion;", "", "Lid/dana/nearbyme/model/ShopModel;", "p0", "Lid/dana/nearbyrevamp/view/OpenHourDetailDialogFragment;", "MyBillsEntityDataFactory", "(Lid/dana/nearbyme/model/ShopModel;)Lid/dana/nearbyrevamp/view/OpenHourDetailDialogFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static OpenHourDetailDialogFragment MyBillsEntityDataFactory(ShopModel p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            OpenHourDetailDialogFragment openHourDetailDialogFragment = new OpenHourDetailDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("shopModel", p0);
            openHourDetailDialogFragment.setArguments(bundle);
            return openHourDetailDialogFragment;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(OpenHourDetailDialogFragment openHourDetailDialogFragment) {
        Intrinsics.checkNotNullParameter(openHourDetailDialogFragment, "");
        openHourDetailDialogFragment.dismiss();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
