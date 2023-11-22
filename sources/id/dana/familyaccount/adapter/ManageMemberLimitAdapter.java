package id.dana.familyaccount.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.R;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.core.ui.recyclerview.BaseViewBindingViewHolder;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.databinding.ItemListManageMemberLimitBinding;
import id.dana.familyaccount.model.FamilyMemberInfoModel;
import id.dana.familyaccount.model.LimitInfoModelKt;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.richview.CircleImageSelectionView;
import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB#\u0012\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u000b\u0010\fR&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/familyaccount/adapter/ManageMemberLimitAdapter;", "Lid/dana/core/ui/recyclerview/BaseRecyclerViewDiffUtilAdapter;", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "Lid/dana/familyaccount/adapter/ManageMemberLimitAdapter$ManageMemberLimitViewHolder;", "Lkotlin/Function2;", "", "", "getAuthRequestContext", "Lkotlin/jvm/functions/Function2;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "ManageMemberLimitViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ManageMemberLimitAdapter extends BaseRecyclerViewDiffUtilAdapter<FamilyMemberInfoModel, ManageMemberLimitViewHolder> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Function2<FamilyMemberInfoModel, Integer, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function2] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ManageMemberLimitAdapter() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.adapter.ManageMemberLimitAdapter.<init>():void");
    }

    @Override // id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter
    public final /* synthetic */ ManageMemberLimitViewHolder PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemListManageMemberLimitBinding KClassImpl$Data$declaredNonStaticMembers$2 = ItemListManageMemberLimitBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return new ManageMemberLimitViewHolder(KClassImpl$Data$declaredNonStaticMembers$2, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public /* synthetic */ ManageMemberLimitAdapter(AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function2<FamilyMemberInfoModel, Integer, Unit>() { // from class: id.dana.familyaccount.adapter.ManageMemberLimitAdapter.1
            public final void invoke(FamilyMemberInfoModel familyMemberInfoModel, int i2) {
                Intrinsics.checkNotNullParameter(familyMemberInfoModel, "");
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(FamilyMemberInfoModel familyMemberInfoModel, Integer num) {
                invoke(familyMemberInfoModel, num.intValue());
                return Unit.INSTANCE;
            }
        } : anonymousClass1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ManageMemberLimitAdapter(Function2<? super FamilyMemberInfoModel, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function2;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R&\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/familyaccount/adapter/ManageMemberLimitAdapter$ManageMemberLimitViewHolder;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "Lid/dana/databinding/ItemListManageMemberLimitBinding;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/databinding/ItemListManageMemberLimitBinding;", "getAuthRequestContext", "Lkotlin/Function2;", "", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function2;", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Lid/dana/databinding/ItemListManageMemberLimitBinding;Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ManageMemberLimitViewHolder extends BaseViewBindingViewHolder<FamilyMemberInfoModel> {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final ItemListManageMemberLimitBinding getAuthRequestContext;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final Function2<FamilyMemberInfoModel, Integer, Unit> MyBillsEntityDataFactory;

        @Override // id.dana.core.ui.recyclerview.BaseViewBindingViewHolder
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FamilyMemberInfoModel familyMemberInfoModel, int i) {
            String format;
            String obj;
            FamilyMemberInfoModel familyMemberInfoModel2 = familyMemberInfoModel;
            Intrinsics.checkNotNullParameter(familyMemberInfoModel2, "");
            super.KClassImpl$Data$declaredNonStaticMembers$2((ManageMemberLimitViewHolder) familyMemberInfoModel2, i);
            ItemListManageMemberLimitBinding itemListManageMemberLimitBinding = this.getAuthRequestContext;
            CircleImageSelectionView circleImageSelectionView = itemListManageMemberLimitBinding.MyBillsEntityDataFactory;
            circleImageSelectionView.loadImage(familyMemberInfoModel2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, R.drawable.ic_avatar_grey_default);
            circleImageSelectionView.setBorderColor(R.drawable.bg_grey_circle);
            itemListManageMemberLimitBinding.BuiltInFictitiousFunctionClassFactory.setText(familyMemberInfoModel2.PlaceComponentResult());
            TextView textView = itemListManageMemberLimitBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            boolean BuiltInFictitiousFunctionClassFactory = LimitInfoModelKt.BuiltInFictitiousFunctionClassFactory(familyMemberInfoModel2.KClassImpl$Data$declaredNonStaticMembers$2);
            MoneyViewModel moneyViewModel = familyMemberInfoModel2.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
            if (BuiltInFictitiousFunctionClassFactory) {
                obj = this.getAuthRequestContext.PlaceComponentResult.getContext().getString(R.string.family_account_text_set_limit);
                Intrinsics.checkNotNullExpressionValue(obj, "");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
                format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
                sb.append(format != null ? format : "");
                obj = sb.toString();
            }
            textView.setText(obj);
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", BridgeDSL.INVOKE, "(Lid/dana/familyaccount/model/FamilyMemberInfoModel;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: id.dana.familyaccount.adapter.ManageMemberLimitAdapter$ManageMemberLimitViewHolder$1 */
        /* loaded from: classes5.dex */
        static final class AnonymousClass1 extends Lambda implements Function2<FamilyMemberInfoModel, Integer, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            AnonymousClass1() {
                super(2);
            }

            public final void invoke(FamilyMemberInfoModel familyMemberInfoModel, int i) {
                Intrinsics.checkNotNullParameter(familyMemberInfoModel, "");
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(FamilyMemberInfoModel familyMemberInfoModel, Integer num) {
                invoke(familyMemberInfoModel, num.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ManageMemberLimitViewHolder(ItemListManageMemberLimitBinding itemListManageMemberLimitBinding, Function2<? super FamilyMemberInfoModel, ? super Integer, Unit> function2) {
            super(itemListManageMemberLimitBinding, function2);
            Intrinsics.checkNotNullParameter(itemListManageMemberLimitBinding, "");
            Intrinsics.checkNotNullParameter(function2, "");
            this.getAuthRequestContext = itemListManageMemberLimitBinding;
            this.MyBillsEntityDataFactory = function2;
        }
    }
}
