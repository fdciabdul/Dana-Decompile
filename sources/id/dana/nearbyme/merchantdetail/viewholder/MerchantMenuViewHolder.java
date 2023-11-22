package id.dana.nearbyme.merchantdetail.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.nearbyme.merchantdetail.enums.MerchantMenu;
import id.dana.nearbyme.merchantdetail.model.MerchantMenuModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewholder/MerchantMenuViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantMenuModel;", "Landroid/view/ViewGroup;", "p0", "Lkotlin/Function1;", "", "", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantMenuViewHolder extends BaseRecyclerViewHolder<MerchantMenuModel> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[MerchantMenu.values().length];
            iArr[MerchantMenu.RESERVE.ordinal()] = 1;
            iArr[MerchantMenu.PICK_UP.ordinal()] = 2;
            iArr[MerchantMenu.CONTACT_US.ordinal()] = 3;
            iArr[MerchantMenu.DIRECTION.ordinal()] = 4;
            iArr[MerchantMenu.TOP_UP.ordinal()] = 5;
            iArr[MerchantMenu.HOME_SHOPPING.ordinal()] = 6;
            getAuthRequestContext = iArr;
        }
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(MerchantMenuModel merchantMenuModel) {
        String str;
        MerchantMenuModel merchantMenuModel2 = merchantMenuModel;
        if (merchantMenuModel2 != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) this.itemView.findViewById(R.id.SplitBillIntroductionContract$View);
            if (appCompatTextView != null) {
                MerchantMenu merchantMenu = merchantMenuModel2.MyBillsEntityDataFactory;
                Context context = getContext();
                if (context != null) {
                    switch (WhenMappings.getAuthRequestContext[merchantMenu.ordinal()]) {
                        case 1:
                            str = context.getString(R.string.merchant_detail_menu_reserve);
                            break;
                        case 2:
                            str = context.getString(R.string.merchant_detail_menu_pickup);
                            break;
                        case 3:
                            str = context.getString(R.string.merchant_detail_menu_contact_us);
                            break;
                        case 4:
                            str = context.getString(R.string.merchant_detail_menu_direction);
                            break;
                        case 5:
                            str = context.getString(R.string.merchant_detail_menu_top_up);
                            break;
                        case 6:
                            str = context.getString(R.string.merchant_detail_menu_home_shopping);
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                appCompatTextView.setText(str);
            }
            boolean kClassImpl$Data$declaredNonStaticMembers$2 = merchantMenuModel2.getKClassImpl$Data$declaredNonStaticMembers$2();
            int i = R.drawable.ic_action_home_shopping;
            if (kClassImpl$Data$declaredNonStaticMembers$2) {
                MerchantMenu merchantMenu2 = merchantMenuModel2.MyBillsEntityDataFactory;
                Context context2 = getContext();
                if (context2 != null) {
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) this.itemView.findViewById(R.id.SplitBillIntroductionContract$View);
                    if (appCompatTextView2 != null) {
                        appCompatTextView2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(context2, R.color.f24002131099997));
                    }
                    AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.iv_menu_icon);
                    if (appCompatImageView != null) {
                        switch (WhenMappings.getAuthRequestContext[merchantMenu2.ordinal()]) {
                            case 1:
                                i = R.drawable.ic_action_reserve;
                                break;
                            case 2:
                                i = R.drawable.ic_action_pickup;
                                break;
                            case 3:
                                i = R.drawable.ic_action_contact_us;
                                break;
                            case 4:
                                i = R.drawable.ic_action_direction;
                                break;
                            case 5:
                                i = R.drawable.ic_action_top_up;
                                break;
                            case 6:
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                        appCompatImageView.setBackgroundResource(i);
                        Unit unit = Unit.INSTANCE;
                        return;
                    }
                    return;
                }
                return;
            }
            MerchantMenu merchantMenu3 = merchantMenuModel2.MyBillsEntityDataFactory;
            Context context3 = getContext();
            if (context3 != null) {
                AppCompatTextView appCompatTextView3 = (AppCompatTextView) this.itemView.findViewById(R.id.SplitBillIntroductionContract$View);
                if (appCompatTextView3 != null) {
                    appCompatTextView3.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(context3, R.color.f23962131099992));
                }
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) this.itemView.findViewById(R.id.iv_menu_icon);
                if (appCompatImageView2 != null) {
                    switch (WhenMappings.getAuthRequestContext[merchantMenu3.ordinal()]) {
                        case 1:
                            i = R.drawable.ic_action_reserve_grey;
                            break;
                        case 2:
                            i = R.drawable.ic_action_pickup_grey;
                            break;
                        case 3:
                            i = R.drawable.ic_action_contact_us_grey;
                            break;
                        case 4:
                            i = R.drawable.ic_action_direction_grey;
                            break;
                        case 5:
                            i = R.drawable.ic_action_top_up_grey;
                            break;
                        case 6:
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    appCompatImageView2.setBackgroundResource(i);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantMenuViewHolder(ViewGroup viewGroup, final Function1<? super Integer, Unit> function1) {
        super(viewGroup.getContext(), R.layout.item_merchant_detail_menu, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantdetail.viewholder.MerchantMenuViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MerchantMenuViewHolder.PlaceComponentResult(Function1.this, this);
            }
        });
    }

    public static /* synthetic */ void PlaceComponentResult(Function1 function1, MerchantMenuViewHolder merchantMenuViewHolder) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(merchantMenuViewHolder, "");
        function1.invoke(Integer.valueOf(merchantMenuViewHolder.getAbsoluteAdapterPosition()));
    }
}
