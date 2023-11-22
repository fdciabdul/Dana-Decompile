package id.dana.nearbyme.merchantdetail.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.BaseRequestOptions;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.nearbyme.merchantdetail.adapter.MerchantLatestReviewPhotoAdapter;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerModel;
import id.dana.nearbyme.merchantdetail.merchantreviewdetail.MerchantReviewDetailActivity;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewViewModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ImageResize;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(BC\u0012\u0006\u0010\u0004\u001a\u00020\u0018\u0012\u0006\u0010!\u001a\u00020\u001a\u0012\u0006\u0010\"\u001a\u00020\u0010\u0012\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0006\u0010$\u001a\u00020\u0005\u0012\u0006\u0010%\u001a\u00020\u0014¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0006\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010\nR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u000e\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0015\u001a\u00020\u0018X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001b\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 "}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewholder/MerchantLatestReviewViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewViewModel;", "Ljava/util/Date;", "p0", "", "getAuthRequestContext", "(Ljava/util/Date;)Z", "Lid/dana/nearbyme/merchantdetail/adapter/MerchantLatestReviewPhotoAdapter;", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantdetail/adapter/MerchantLatestReviewPhotoAdapter;", "Lkotlin/Function1;", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerModel;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "Lid/dana/nearbyme/model/ShopModel;", "Lid/dana/nearbyme/model/ShopModel;", "BuiltInFictitiousFunctionClassFactory", "Z", "", "getErrorConfigVersion", "Ljava/lang/String;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "", "scheduleImpl", "I", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "lookAheadTest", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "p1", "p2", "p3", "p4", "p5", "<init>", "(Landroid/view/ViewGroup;ILid/dana/nearbyme/model/ShopModel;Lkotlin/jvm/functions/Function1;ZLjava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantLatestReviewViewHolder extends BaseRecyclerViewHolder<MerchantReviewViewModel> {
    private final boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Function1<MediaViewerModel, Unit> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private MerchantLatestReviewPhotoAdapter getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final ViewGroup getErrorConfigVersion;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ShopModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final String PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final RecyclerView.RecycledViewPool scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final int NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(MerchantReviewViewModel merchantReviewViewModel) {
        MerchantReviewModel merchantReviewModel;
        MerchantReviewViewModel merchantReviewViewModel2 = merchantReviewViewModel;
        int i = 1;
        boolean z = false;
        if (merchantReviewViewModel2 != null && (merchantReviewModel = merchantReviewViewModel2.BuiltInFictitiousFunctionClassFactory) != null) {
            String str = merchantReviewModel.MyBillsEntityDataFactory;
            Context context = getContext();
            if (context != null) {
                GlideApp.getAuthRequestContext(context).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(str).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).PlaceComponentResult((int) R.drawable.avatar_placeholder).MyBillsEntityDataFactory((ImageView) this.itemView.findViewById(R.id.iv_avatar_user));
            }
            String str2 = merchantReviewModel.PrepareContext;
            String str3 = str2;
            if (str3 == null || str3.length() == 0) {
                TextView textView = (TextView) this.itemView.findViewById(R.id.getSecondaryProgressTintMode);
                if (textView != null) {
                    textView.setText(getContext().getResources().getString(R.string.user_review_anonymous_label));
                }
            } else {
                TextView textView2 = (TextView) this.itemView.findViewById(R.id.getSecondaryProgressTintMode);
                if (textView2 != null) {
                    if (str2 == null) {
                        str2 = "";
                    }
                    textView2.setText(str2);
                }
            }
            String str4 = merchantReviewModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
            String str5 = str4;
            if (str5 == null || str5.length() == 0) {
                TextView textView3 = (TextView) this.itemView.findViewById(R.id.tv_review_description);
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
            } else {
                TextView textView4 = (TextView) this.itemView.findViewById(R.id.tv_review_description);
                if (textView4 != null) {
                    if (str4 == null) {
                        str4 = "";
                    }
                    textView4.setText(str4);
                }
                TextView textView5 = (TextView) this.itemView.findViewById(R.id.tv_review_description);
                if (textView5 != null) {
                    textView5.setVisibility(0);
                }
            }
            Integer valueOf = Integer.valueOf(merchantReviewModel.initRecordTimeStamp);
            if (valueOf == null) {
                TextView textView6 = (TextView) this.itemView.findViewById(R.id.tv_rating);
                if (textView6 != null) {
                    textView6.setVisibility(8);
                }
            } else if (valueOf.intValue() != 0) {
                ((TextView) this.itemView.findViewById(R.id.tv_rating)).setVisibility(0);
                ((TextView) this.itemView.findViewById(R.id.tv_rating)).setText(valueOf.toString());
            } else {
                ((TextView) this.itemView.findViewById(R.id.tv_rating)).setVisibility(8);
            }
            List<MerchantImageModel> list = merchantReviewModel.BuiltInFictitiousFunctionClassFactory;
            String str6 = 0;
            str6 = 0;
            this.getAuthRequestContext = new MerchantLatestReviewPhotoAdapter(z, this.MyBillsEntityDataFactory, i, str6);
            RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(R.id.rv_photo_review);
            if (recyclerView != null) {
                MerchantLatestReviewPhotoAdapter merchantLatestReviewPhotoAdapter = this.getAuthRequestContext;
                if (merchantLatestReviewPhotoAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    merchantLatestReviewPhotoAdapter = null;
                }
                recyclerView.setAdapter(merchantLatestReviewPhotoAdapter);
            }
            RecyclerView recyclerView2 = (RecyclerView) this.itemView.findViewById(R.id.rv_photo_review);
            if (recyclerView2 != null) {
                recyclerView2.setRecycledViewPool(this.scheduleImpl);
            }
            MerchantLatestReviewPhotoAdapter merchantLatestReviewPhotoAdapter2 = this.getAuthRequestContext;
            if (merchantLatestReviewPhotoAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                merchantLatestReviewPhotoAdapter2 = null;
            }
            merchantLatestReviewPhotoAdapter2.setItems(list);
            long j = merchantReviewModel.moveToNextValue;
            TextView textView7 = (TextView) this.itemView.findViewById(R.id.saveMonthOfFetchFreeTransfer);
            int MyBillsEntityDataFactory = (int) DateTimeUtil.MyBillsEntityDataFactory(new Date(), new Date(j));
            Date date = new Date(j);
            if (MyBillsEntityDataFactory == 0) {
                Context context2 = getContext();
                if (context2 != null) {
                    str6 = context2.getString(R.string.feed_section_today);
                }
            } else if (MyBillsEntityDataFactory == 1) {
                Context context3 = getContext();
                if (context3 != null) {
                    str6 = context3.getString(R.string.feed_section_yesterday);
                }
            } else {
                str6 = DateTimeUtil.getAuthRequestContext(date);
            }
            String str7 = str6;
            if (getAuthRequestContext(date)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str6);
                sb.append(InputCardNumberView.DIVIDER);
                sb.append(DateTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2(date));
                str7 = sb.toString();
            }
            textView7.setText(str7 != null ? str7 : "");
        }
        if ((merchantReviewViewModel2 != null && merchantReviewViewModel2.MyBillsEntityDataFactory == 0) && getAdapterPosition() == this.NetworkUserEntityData$$ExternalSyntheticLambda0 - 1 && this.BuiltInFictitiousFunctionClassFactory) {
            Button button = (Button) this.itemView.findViewById(R.id.btn_see_other_review);
            if (button != null) {
                button.setVisibility(0);
            }
            Button button2 = (Button) this.itemView.findViewById(R.id.btn_see_other_review);
            if (button2 != null) {
                button2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantdetail.viewholder.MerchantLatestReviewViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MerchantLatestReviewViewHolder.PlaceComponentResult(MerchantLatestReviewViewHolder.this);
                    }
                });
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MerchantLatestReviewViewHolder(ViewGroup viewGroup, int i, ShopModel shopModel, Function1<? super MediaViewerModel, Unit> function1, boolean z, String str) {
        super(viewGroup.getContext(), R.layout.view_item_latest_review, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(shopModel, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.getErrorConfigVersion = viewGroup;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = shopModel;
        this.MyBillsEntityDataFactory = function1;
        this.BuiltInFictitiousFunctionClassFactory = z;
        this.PlaceComponentResult = str;
        this.scheduleImpl = new RecyclerView.RecycledViewPool();
    }

    private static boolean getAuthRequestContext(Date p0) {
        return DateTimeUtil.lookAheadTest(p0) < Calendar.getInstance().get(1);
    }

    public static /* synthetic */ void PlaceComponentResult(MerchantLatestReviewViewHolder merchantLatestReviewViewHolder) {
        Intrinsics.checkNotNullParameter(merchantLatestReviewViewHolder, "");
        MerchantReviewDetailActivity.Companion companion = MerchantReviewDetailActivity.INSTANCE;
        Context context = merchantLatestReviewViewHolder.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        MerchantReviewDetailActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, merchantLatestReviewViewHolder.PlaceComponentResult, merchantLatestReviewViewHolder.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
