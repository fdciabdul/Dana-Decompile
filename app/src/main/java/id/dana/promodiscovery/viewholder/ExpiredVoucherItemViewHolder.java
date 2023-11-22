package id.dana.promodiscovery.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.glidetransformations.FitEndTransformation;
import id.dana.promocenter.model.PromoModel;
import id.dana.promodiscovery.richview.PromoDiscoveryListItemListener;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ImageUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0012\u0010\u000e\u001a\u00020\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/promodiscovery/viewholder/ExpiredVoucherItemViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promocenter/model/PromoModel;", "", "dispose", "()V", "Lio/reactivex/disposables/Disposable;", "getAuthRequestContext", "Lio/reactivex/disposables/Disposable;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "PlaceComponentResult", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "Landroid/view/ViewGroup;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExpiredVoucherItemViewHolder extends BaseRecyclerViewHolder<PromoModel> {
    public ViewGroup MyBillsEntityDataFactory;
    public final PromoDiscoveryListItemListener<PromoModel> PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Disposable KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(PromoModel promoModel) {
        final PromoModel promoModel2 = promoModel;
        super.bindData(promoModel2);
        if (promoModel2 != null) {
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.promodiscovery.viewholder.ExpiredVoucherItemViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExpiredVoucherItemViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(ExpiredVoucherItemViewHolder.this, promoModel2);
                }
            });
            String str = promoModel2.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(str, "");
            RequestBuilder KClassImpl$Data$declaredNonStaticMembers$2 = Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).getAuthRequestContext(ImageUtil.MyBillsEntityDataFactory(str, "_noText")).KClassImpl$Data$declaredNonStaticMembers$2(new FitEndTransformation(), new CenterCrop(), new GranularRoundedCorners(0.0f, 0.0f, 32.0f));
            RequestBuilder KClassImpl$Data$declaredNonStaticMembers$22 = Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).getAuthRequestContext("https://a.m.dana.id/resource/imgs/promo-center/PromoCenter-dana-banner.png").KClassImpl$Data$declaredNonStaticMembers$2(new FitEndTransformation(), new CenterCrop(), new GranularRoundedCorners(0.0f, 0.0f, 32.0f));
            RequestBuilder KClassImpl$Data$declaredNonStaticMembers$23 = Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).getAuthRequestContext(str).KClassImpl$Data$declaredNonStaticMembers$2(new FitEndTransformation(), new CenterCrop(), new GranularRoundedCorners(0.0f, 0.0f, 32.0f));
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$23, "");
            RequestBuilder BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$23);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory((ImageView) ((ShapeableImageView) this.itemView.findViewById(R.id.iv_promo_image)));
            Glide.getAuthRequestContext(this.itemView).getAuthRequestContext((String) null).getAuthRequestContext((int) R.drawable.dana_coin).BuiltInFictitiousFunctionClassFactory(R.drawable.dana_coin).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) this.itemView.findViewById(R.id.SendMoneyHomePresenter)));
            MaterialTextView materialTextView = (MaterialTextView) this.itemView.findViewById(R.id.tv_promo_title);
            if (materialTextView != null) {
                String str2 = promoModel2.scheduleImpl;
                materialTextView.setText(str2 != null ? str2 : "");
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = Observable.interval(1L, TimeUnit.SECONDS).takeUntil(new Predicate() { // from class: id.dana.promodiscovery.viewholder.ExpiredVoucherItemViewHolder$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    boolean KClassImpl$Data$declaredNonStaticMembers$24;
                    KClassImpl$Data$declaredNonStaticMembers$24 = ExpiredVoucherItemViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(PromoModel.this, (Long) obj);
                    return KClassImpl$Data$declaredNonStaticMembers$24;
                }
            }).doOnNext(new Consumer() { // from class: id.dana.promodiscovery.viewholder.ExpiredVoucherItemViewHolder$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    Long l = (Long) obj;
                    ExpiredVoucherItemViewHolder.BuiltInFictitiousFunctionClassFactory(PromoModel.this);
                }
            }).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.promodiscovery.viewholder.ExpiredVoucherItemViewHolder$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    Long l = (Long) obj;
                    ExpiredVoucherItemViewHolder.getAuthRequestContext(ExpiredVoucherItemViewHolder.this, promoModel2);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ExpiredVoucherItemViewHolder(ViewGroup viewGroup, PromoDiscoveryListItemListener<? super PromoModel> promoDiscoveryListItemListener) {
        super(viewGroup.getContext(), R.layout.expired_voucher_item_layout, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(promoDiscoveryListItemListener, "");
        this.MyBillsEntityDataFactory = viewGroup;
        this.PlaceComponentResult = promoDiscoveryListItemListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(PromoModel promoModel, Long l) {
        Intrinsics.checkNotNullParameter(promoModel, "");
        Intrinsics.checkNotNullParameter(l, "");
        return l.longValue() >= promoModel.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void dispose() {
        super.dispose();
        Disposable disposable = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ExpiredVoucherItemViewHolder expiredVoucherItemViewHolder, PromoModel promoModel) {
        Intrinsics.checkNotNullParameter(expiredVoucherItemViewHolder, "");
        Intrinsics.checkNotNullParameter(promoModel, "");
        expiredVoucherItemViewHolder.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(promoModel);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PromoModel promoModel) {
        Intrinsics.checkNotNullParameter(promoModel, "");
        promoModel.BuiltInFictitiousFunctionClassFactory -= 1000;
    }

    public static /* synthetic */ void getAuthRequestContext(ExpiredVoucherItemViewHolder expiredVoucherItemViewHolder, PromoModel promoModel) {
        Locale locale;
        Intrinsics.checkNotNullParameter(expiredVoucherItemViewHolder, "");
        Intrinsics.checkNotNullParameter(promoModel, "");
        if (DateTimeUtil.MyBillsEntityDataFactory(new Date(promoModel.BuiltInFictitiousFunctionClassFactory)) >= 24) {
            ((MaterialTextView) expiredVoucherItemViewHolder.itemView.findViewById(R.id.tv_countdown_time_left)).setText(expiredVoucherItemViewHolder.getContext().getResources().getString(R.string.expired_date_time_in_days, String.valueOf(DateTimeUtil.MyBillsEntityDataFactory(new Date(promoModel.BuiltInFictitiousFunctionClassFactory), new Date()))));
            return;
        }
        MaterialTextView materialTextView = (MaterialTextView) expiredVoucherItemViewHolder.itemView.findViewById(R.id.tv_countdown_time_left);
        Date date = new Date(promoModel.BuiltInFictitiousFunctionClassFactory);
        locale = Locale.getDefault();
        materialTextView.setText(DateTimeUtil.MyBillsEntityDataFactory(date, "HH:mm:ss", locale));
    }
}
