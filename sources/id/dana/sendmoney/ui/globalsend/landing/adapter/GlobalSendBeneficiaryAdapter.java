package id.dana.sendmoney.ui.globalsend.landing.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.util.MaskedTextUtil;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemViewListBeneficiaryGlobalSendBinding;
import id.dana.sendmoney.ui.globalsend.form.model.BeneficiaryInfoModel;
import id.dana.sendmoney.ui.globalsend.landing.GlobalSendSortRecipientExtKt;
import id.dana.sendmoney.ui.globalsend.landing.adapter.GlobalSendBeneficiaryAdapter;
import id.dana.sendmoney.ui.globalsend.landing.view.MoreActionBeneficiaryListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB:\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\n\u001a\u00020\u0010\u0012\u0019\u0010\u0018\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0007¢\u0006\u0002\b\u0014\u0012\u0004\u0012\u00020\u000b0\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R'\u0010\u0017\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0007¢\u0006\u0002\b\u0014\u0012\u0004\u0012\u00020\u000b0\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/landing/adapter/GlobalSendBeneficiaryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/sendmoney/ui/globalsend/landing/adapter/GlobalSendBeneficiaryAdapter$GlobalSendBeneficiaryViewHolder;", "", "getItemCount", "()I", "", "Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;", "p0", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;Ljava/lang/String;)V", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/ui/globalsend/landing/view/MoreActionBeneficiaryListener;", "PlaceComponentResult", "Lid/dana/sendmoney/ui/globalsend/landing/view/MoreActionBeneficiaryListener;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "getAuthRequestContext", "Lkotlin/jvm/functions/Function1;", "MyBillsEntityDataFactory", "p2", "<init>", "(Ljava/util/List;Lid/dana/sendmoney/ui/globalsend/landing/view/MoreActionBeneficiaryListener;Lkotlin/jvm/functions/Function1;)V", "Companion", "GlobalSendBeneficiaryViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalSendBeneficiaryAdapter extends RecyclerView.Adapter<GlobalSendBeneficiaryViewHolder> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public List<BeneficiaryInfoModel> KClassImpl$Data$declaredNonStaticMembers$2;
    private final MoreActionBeneficiaryListener PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Function1<BeneficiaryInfoModel, Unit> MyBillsEntityDataFactory;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(GlobalSendBeneficiaryViewHolder globalSendBeneficiaryViewHolder, int i) {
        final GlobalSendBeneficiaryViewHolder globalSendBeneficiaryViewHolder2 = globalSendBeneficiaryViewHolder;
        Intrinsics.checkNotNullParameter(globalSendBeneficiaryViewHolder2, "");
        final BeneficiaryInfoModel beneficiaryInfoModel = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
        Intrinsics.checkNotNullParameter(beneficiaryInfoModel, "");
        ItemViewListBeneficiaryGlobalSendBinding itemViewListBeneficiaryGlobalSendBinding = globalSendBeneficiaryViewHolder2.KClassImpl$Data$declaredNonStaticMembers$2;
        CircleImageView circleImageView = itemViewListBeneficiaryGlobalSendBinding.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "");
        GlobalSendBeneficiaryViewHolder.PlaceComponentResult(circleImageView, beneficiaryInfoModel.PrepareContext, R.drawable.ic_card_glyph);
        CircleImageView circleImageView2 = itemViewListBeneficiaryGlobalSendBinding.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(circleImageView2, "");
        GlobalSendBeneficiaryViewHolder.PlaceComponentResult(circleImageView2, GlobalSendBeneficiaryViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(beneficiaryInfoModel.lookAheadTest), R.drawable.bg_circle_grey_20);
        TextView textView = itemViewListBeneficiaryGlobalSendBinding.getErrorConfigVersion;
        textView.setText(beneficiaryInfoModel.KClassImpl$Data$declaredNonStaticMembers$2());
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = globalSendBeneficiaryViewHolder2.itemView.getContext().getString(R.string.res_0x7f130329_networkuserentitydata_externalsyntheticlambda3);
        Intrinsics.checkNotNullExpressionValue(string, "");
        StringBuilder sb = new StringBuilder();
        sb.append(beneficiaryInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append("-");
        sb.append(beneficiaryInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda8);
        Unit unit = Unit.INSTANCE;
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{obj}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        textView.setContentDescription(format);
        itemViewListBeneficiaryGlobalSendBinding.MyBillsEntityDataFactory.setText(beneficiaryInfoModel.MyBillsEntityDataFactory());
        TextView textView2 = itemViewListBeneficiaryGlobalSendBinding.scheduleImpl;
        MaskedTextUtil maskedTextUtil = MaskedTextUtil.INSTANCE;
        MaskedTextUtil maskedTextUtil2 = MaskedTextUtil.INSTANCE;
        textView2.setText(MaskedTextUtil.getAuthRequestContext(MaskedTextUtil.MyBillsEntityDataFactory(beneficiaryInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda7)));
        AppCompatImageView appCompatImageView = itemViewListBeneficiaryGlobalSendBinding.BuiltInFictitiousFunctionClassFactory;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.landing.adapter.GlobalSendBeneficiaryAdapter$GlobalSendBeneficiaryViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GlobalSendBeneficiaryAdapter.GlobalSendBeneficiaryViewHolder.BuiltInFictitiousFunctionClassFactory(GlobalSendBeneficiaryAdapter.GlobalSendBeneficiaryViewHolder.this, beneficiaryInfoModel);
            }
        });
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String string2 = globalSendBeneficiaryViewHolder2.itemView.getContext().getString(R.string.btn_action);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(globalSendBeneficiaryViewHolder2.getAbsoluteAdapterPosition())}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "");
        appCompatImageView.setContentDescription(format2);
        itemViewListBeneficiaryGlobalSendBinding.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.landing.adapter.GlobalSendBeneficiaryAdapter$GlobalSendBeneficiaryViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GlobalSendBeneficiaryAdapter.GlobalSendBeneficiaryViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(GlobalSendBeneficiaryAdapter.GlobalSendBeneficiaryViewHolder.this, beneficiaryInfoModel);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ GlobalSendBeneficiaryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemViewListBeneficiaryGlobalSendBinding authRequestContext = ItemViewListBeneficiaryGlobalSendBinding.getAuthRequestContext(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return new GlobalSendBeneficiaryViewHolder(authRequestContext, this.PlaceComponentResult, this.MyBillsEntityDataFactory);
    }

    public /* synthetic */ GlobalSendBeneficiaryAdapter(ArrayList arrayList, MoreActionBeneficiaryListener moreActionBeneficiaryListener, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList, moreActionBeneficiaryListener, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private GlobalSendBeneficiaryAdapter(List<BeneficiaryInfoModel> list, MoreActionBeneficiaryListener moreActionBeneficiaryListener, Function1<? super BeneficiaryInfoModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(moreActionBeneficiaryListener, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.PlaceComponentResult = moreActionBeneficiaryListener;
        this.MyBillsEntityDataFactory = function1;
    }

    public final void BuiltInFictitiousFunctionClassFactory(List<BeneficiaryInfoModel> p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (!p0.isEmpty()) {
            p0 = GlobalSendSortRecipientExtKt.MyBillsEntityDataFactory(p0, p1);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.size();
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\u0003\u001a\u00020\f\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u000f\u0012\u0019\u0010\u0016\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0012¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\t*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0010R'\u0010\u0014\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0012¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\t0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/landing/adapter/GlobalSendBeneficiaryAdapter$GlobalSendBeneficiaryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Ljava/lang/String;", "Lde/hdodenhof/circleimageview/CircleImageView;", "", "p1", "", "PlaceComponentResult", "(Lde/hdodenhof/circleimageview/CircleImageView;Ljava/lang/String;I)V", "Lid/dana/sendmoney/databinding/ItemViewListBeneficiaryGlobalSendBinding;", "getAuthRequestContext", "Lid/dana/sendmoney/databinding/ItemViewListBeneficiaryGlobalSendBinding;", "Lid/dana/sendmoney/ui/globalsend/landing/view/MoreActionBeneficiaryListener;", "Lid/dana/sendmoney/ui/globalsend/landing/view/MoreActionBeneficiaryListener;", "Lkotlin/Function1;", "Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;", "Lkotlin/ParameterName;", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function1;", "p2", "<init>", "(Lid/dana/sendmoney/databinding/ItemViewListBeneficiaryGlobalSendBinding;Lid/dana/sendmoney/ui/globalsend/landing/view/MoreActionBeneficiaryListener;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class GlobalSendBeneficiaryViewHolder extends RecyclerView.ViewHolder {
        private final Function1<BeneficiaryInfoModel, Unit> MyBillsEntityDataFactory;
        private final MoreActionBeneficiaryListener PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final ItemViewListBeneficiaryGlobalSendBinding KClassImpl$Data$declaredNonStaticMembers$2;

        static String KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
            StringBuilder sb = new StringBuilder();
            sb.append("https://a.m.dana.id/resource/global-transfer/icons/country/");
            sb.append(p0);
            sb.append("-rounded.png");
            return sb.toString();
        }

        public static void PlaceComponentResult(CircleImageView circleImageView, String str, int i) {
            Intrinsics.checkNotNullParameter(circleImageView, "");
            Intrinsics.checkNotNullParameter(str, "");
            GlideApp.getAuthRequestContext(circleImageView.getContext()).PlaceComponentResult(str).getErrorConfigVersion(i).MyBillsEntityDataFactory((ImageView) circleImageView);
        }

        public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GlobalSendBeneficiaryViewHolder globalSendBeneficiaryViewHolder, BeneficiaryInfoModel beneficiaryInfoModel) {
            Intrinsics.checkNotNullParameter(globalSendBeneficiaryViewHolder, "");
            Intrinsics.checkNotNullParameter(beneficiaryInfoModel, "");
            globalSendBeneficiaryViewHolder.MyBillsEntityDataFactory.invoke(beneficiaryInfoModel);
        }

        public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(GlobalSendBeneficiaryViewHolder globalSendBeneficiaryViewHolder, BeneficiaryInfoModel beneficiaryInfoModel) {
            Intrinsics.checkNotNullParameter(globalSendBeneficiaryViewHolder, "");
            Intrinsics.checkNotNullParameter(beneficiaryInfoModel, "");
            MoreActionBeneficiaryListener moreActionBeneficiaryListener = globalSendBeneficiaryViewHolder.PlaceComponentResult;
            if (moreActionBeneficiaryListener != null) {
                moreActionBeneficiaryListener.BuiltInFictitiousFunctionClassFactory(beneficiaryInfoModel);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public GlobalSendBeneficiaryViewHolder(ItemViewListBeneficiaryGlobalSendBinding itemViewListBeneficiaryGlobalSendBinding, MoreActionBeneficiaryListener moreActionBeneficiaryListener, Function1<? super BeneficiaryInfoModel, Unit> function1) {
            super(itemViewListBeneficiaryGlobalSendBinding.getAuthRequestContext);
            Intrinsics.checkNotNullParameter(itemViewListBeneficiaryGlobalSendBinding, "");
            Intrinsics.checkNotNullParameter(function1, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = itemViewListBeneficiaryGlobalSendBinding;
            this.PlaceComponentResult = moreActionBeneficiaryListener;
            this.MyBillsEntityDataFactory = function1;
        }
    }
}
