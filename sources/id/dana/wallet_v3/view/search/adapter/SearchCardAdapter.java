package id.dana.wallet_v3.view.search.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.wallet_v3.identity.viewholder.KtpCardViewHolder;
import id.dana.wallet_v3.investment.viewholder.DanaEmasCardViewHolder;
import id.dana.wallet_v3.investment.viewholder.DanaGoalsCardViewHolder;
import id.dana.wallet_v3.investment.viewholder.DanaPlusWalletViewHolder;
import id.dana.wallet_v3.listener.AssetRecommendationClickListener;
import id.dana.wallet_v3.listener.DanaBalanceClickListener;
import id.dana.wallet_v3.listener.DanaEmasClickListener;
import id.dana.wallet_v3.listener.DanaPlusClickListener;
import id.dana.wallet_v3.listener.GoalsClickListener;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.loyalty.adapter.DanaLoyaltyCardViewHolder;
import id.dana.wallet_v3.model.WalletV3CardModel;
import id.dana.wallet_v3.payment.viewholder.BankCardViewHolder;
import id.dana.wallet_v3.payment.viewholder.DanaBalanceCardViewHolder;
import id.dana.wallet_v3.payment.viewholder.PaylaterCardViewHolder;
import id.dana.wallet_v3.view.search.viewholder.AssetSearchRecommendationViewHolder;
import id.dana.wallet_v3.view.search.viewholder.NoResultViewHolder;
import id.dana.wallet_v3.view.search.viewholder.TitleViewHolder;
import id.dana.wallet_v3.vouchersandtickets.viewholder.DealsViewHolder;
import id.dana.wallet_v3.vouchersandtickets.viewholder.MovieTicketViewHolder;
import id.dana.wallet_v3.vouchersandtickets.viewholder.ParkingTicketViewHolder;
import id.dana.wallet_v3.vouchersandtickets.viewholder.TravelTicketViewHolder;
import id.dana.wallet_v3.vouchersandtickets.viewholder.VoucherViewHolder;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001BO\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\bC\u0010DJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010 R\u0016\u0010%\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010'\u001a\u0004\u0018\u00010&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u0004\u0018\u00010)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u0004\u0018\u00010,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R.\u00101\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u00010/8\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u00108\u001a\u0004\u0018\u0001078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b8\u00109R.\u0010:\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u00010/8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b:\u00102\u001a\u0004\b;\u00104\"\u0004\b<\u00106R.\u0010=\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u00010/8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b=\u00102\u001a\u0004\b>\u00104\"\u0004\b?\u00106R\u0016\u0010A\u001a\u0004\u0018\u00010@8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bA\u0010B"}, d2 = {"Lid/dana/wallet_v3/view/search/adapter/SearchCardAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "", "position", "getItemViewType", "(I)I", "", "initializeCountDownTimerPublishSubject", "()V", "initializeCountUpTimerPublishSubject", "assetType", "notifyDataSetChangeByAsset", "(I)V", "holder", "onBindViewHolder", "(Lid/dana/base/BaseRecyclerViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lid/dana/base/BaseRecyclerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onDetachedFromRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Lid/dana/wallet_v3/listener/AssetRecommendationClickListener;", "assetRecommendationClickListener", "Lid/dana/wallet_v3/listener/AssetRecommendationClickListener;", "Lio/reactivex/subjects/PublishSubject;", "countDownPublishSubject", "Lio/reactivex/subjects/PublishSubject;", "Lio/reactivex/disposables/Disposable;", "countDownPublishSubjectDisposable", "Lio/reactivex/disposables/Disposable;", "countUpPublishSubject", "countUpPublishSubjectDisposable", "Lid/dana/wallet_v3/listener/DanaBalanceClickListener;", "danaBalanceClickListener", "Lid/dana/wallet_v3/listener/DanaBalanceClickListener;", "Lid/dana/wallet_v3/listener/DanaEmasClickListener;", "danaEmasClickListener", "Lid/dana/wallet_v3/listener/DanaEmasClickListener;", "Lid/dana/wallet_v3/listener/GoalsClickListener;", "danaGoalsClickListener", "Lid/dana/wallet_v3/listener/GoalsClickListener;", "", "value", "danaPlusBalanceVisibility", "Ljava/lang/Boolean;", "getDanaPlusBalanceVisibility", "()Ljava/lang/Boolean;", "setDanaPlusBalanceVisibility", "(Ljava/lang/Boolean;)V", "Lid/dana/wallet_v3/listener/DanaPlusClickListener;", "danaPlusClickListener", "Lid/dana/wallet_v3/listener/DanaPlusClickListener;", "emasBalanceVisibility", "getEmasBalanceVisibility", "setEmasBalanceVisibility", "goalsBalanceVisibility", "getGoalsBalanceVisibility", "setGoalsBalanceVisibility", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "<init>", "(Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;Lid/dana/wallet_v3/listener/DanaBalanceClickListener;Lid/dana/wallet_v3/listener/DanaEmasClickListener;Lid/dana/wallet_v3/listener/GoalsClickListener;Lid/dana/wallet_v3/listener/DanaPlusClickListener;Lid/dana/wallet_v3/listener/AssetRecommendationClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SearchCardAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<WalletV3CardModel>, WalletV3CardModel> {
    private final AssetRecommendationClickListener assetRecommendationClickListener;
    private final PublishSubject<Integer> countDownPublishSubject;
    private Disposable countDownPublishSubjectDisposable;
    private PublishSubject<Integer> countUpPublishSubject;
    private Disposable countUpPublishSubjectDisposable;
    private final DanaBalanceClickListener danaBalanceClickListener;
    private final DanaEmasClickListener danaEmasClickListener;
    private final GoalsClickListener danaGoalsClickListener;
    private Boolean danaPlusBalanceVisibility;
    private final DanaPlusClickListener danaPlusClickListener;
    private Boolean emasBalanceVisibility;
    private Boolean goalsBalanceVisibility;
    private final WalletCardAssetClickListener walletCardAssetClickListener;

    public SearchCardAdapter() {
        this(null, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ SearchCardAdapter(WalletCardAssetClickListener walletCardAssetClickListener, DanaBalanceClickListener danaBalanceClickListener, DanaEmasClickListener danaEmasClickListener, GoalsClickListener goalsClickListener, DanaPlusClickListener danaPlusClickListener, AssetRecommendationClickListener assetRecommendationClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : walletCardAssetClickListener, (i & 2) != 0 ? null : danaBalanceClickListener, (i & 4) != 0 ? null : danaEmasClickListener, (i & 8) != 0 ? null : goalsClickListener, (i & 16) != 0 ? null : danaPlusClickListener, (i & 32) != 0 ? null : assetRecommendationClickListener);
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((SearchCardAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    public SearchCardAdapter(WalletCardAssetClickListener walletCardAssetClickListener, DanaBalanceClickListener danaBalanceClickListener, DanaEmasClickListener danaEmasClickListener, GoalsClickListener goalsClickListener, DanaPlusClickListener danaPlusClickListener, AssetRecommendationClickListener assetRecommendationClickListener) {
        this.walletCardAssetClickListener = walletCardAssetClickListener;
        this.danaBalanceClickListener = danaBalanceClickListener;
        this.danaEmasClickListener = danaEmasClickListener;
        this.danaGoalsClickListener = goalsClickListener;
        this.danaPlusClickListener = danaPlusClickListener;
        this.assetRecommendationClickListener = assetRecommendationClickListener;
        PublishSubject<Integer> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.countUpPublishSubject = PlaceComponentResult;
        PublishSubject<Integer> PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        this.countDownPublishSubject = PlaceComponentResult2;
        initializeCountUpTimerPublishSubject();
        initializeCountDownTimerPublishSubject();
    }

    @JvmName(name = "getGoalsBalanceVisibility")
    public final Boolean getGoalsBalanceVisibility() {
        return this.goalsBalanceVisibility;
    }

    @JvmName(name = "setGoalsBalanceVisibility")
    public final void setGoalsBalanceVisibility(Boolean bool) {
        this.goalsBalanceVisibility = bool;
        notifyDataSetChangeByAsset(6);
    }

    @JvmName(name = "getEmasBalanceVisibility")
    public final Boolean getEmasBalanceVisibility() {
        return this.emasBalanceVisibility;
    }

    @JvmName(name = "setEmasBalanceVisibility")
    public final void setEmasBalanceVisibility(Boolean bool) {
        this.emasBalanceVisibility = bool;
        notifyDataSetChangeByAsset(5);
    }

    @JvmName(name = "getDanaPlusBalanceVisibility")
    public final Boolean getDanaPlusBalanceVisibility() {
        return this.danaPlusBalanceVisibility;
    }

    @JvmName(name = "setDanaPlusBalanceVisibility")
    public final void setDanaPlusBalanceVisibility(Boolean bool) {
        this.danaPlusBalanceVisibility = bool;
        notifyDataSetChangeByAsset(4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final BaseRecyclerViewHolder<WalletV3CardModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "");
        switch (viewType) {
            case 0:
                Context context = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "");
                return new BankCardViewHolder(context, parent, this.walletCardAssetClickListener);
            case 1:
                Context context2 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                return new DanaBalanceCardViewHolder(context2, parent, this.danaBalanceClickListener);
            case 2:
                Context context3 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "");
                return new PaylaterCardViewHolder(context3, parent, this.walletCardAssetClickListener);
            case 3:
            case 7:
            case 11:
            case 12:
            default:
                Context context4 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "");
                return new BankCardViewHolder(context4, parent, this.walletCardAssetClickListener);
            case 4:
                Context context5 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context5, "");
                return new DanaPlusWalletViewHolder(context5, parent, true, this.walletCardAssetClickListener, this.danaPlusClickListener);
            case 5:
                Context context6 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context6, "");
                Boolean bool = this.emasBalanceVisibility;
                return new DanaEmasCardViewHolder(context6, parent, bool != null ? bool.booleanValue() : false, this.walletCardAssetClickListener, this.danaEmasClickListener);
            case 6:
                Context context7 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context7, "");
                Boolean bool2 = this.goalsBalanceVisibility;
                return new DanaGoalsCardViewHolder(context7, parent, bool2 != null ? bool2.booleanValue() : false, this.walletCardAssetClickListener, this.danaGoalsClickListener);
            case 8:
                Context context8 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context8, "");
                return new VoucherViewHolder(context8, parent, this.countDownPublishSubject, this.walletCardAssetClickListener);
            case 9:
                Context context9 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context9, "");
                return new TravelTicketViewHolder(context9, parent, this.walletCardAssetClickListener);
            case 10:
                Context context10 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context10, "");
                return new ParkingTicketViewHolder(context10, parent, this.countUpPublishSubject, this.walletCardAssetClickListener);
            case 13:
                Context context11 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context11, "");
                return new DanaLoyaltyCardViewHolder(context11, parent, this.walletCardAssetClickListener);
            case 14:
                Context context12 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context12, "");
                return new KtpCardViewHolder(context12, parent, this.walletCardAssetClickListener);
            case 15:
                Context context13 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context13, "");
                return new MovieTicketViewHolder(context13, parent, this.walletCardAssetClickListener);
            case 16:
                return new AssetSearchRecommendationViewHolder(parent, this.assetRecommendationClickListener);
            case 17:
                return new TitleViewHolder(parent);
            case 18:
                return new NoResultViewHolder(parent);
            case 19:
                Context context14 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context14, "");
                return new DealsViewHolder(context14, parent, this.walletCardAssetClickListener, this.countDownPublishSubject);
        }
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void onBindViewHolder(BaseRecyclerViewHolder<WalletV3CardModel> holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "");
        if (holder instanceof DanaGoalsCardViewHolder) {
            DanaGoalsCardViewHolder danaGoalsCardViewHolder = (DanaGoalsCardViewHolder) holder;
            Boolean bool = this.goalsBalanceVisibility;
            danaGoalsCardViewHolder.setBalanceVisible(bool != null ? bool.booleanValue() : false);
        } else if (holder instanceof DanaEmasCardViewHolder) {
            DanaEmasCardViewHolder danaEmasCardViewHolder = (DanaEmasCardViewHolder) holder;
            Boolean bool2 = this.emasBalanceVisibility;
            danaEmasCardViewHolder.setBalanceVisible(bool2 != null ? bool2.booleanValue() : false);
        } else if (holder instanceof DanaPlusWalletViewHolder) {
            DanaPlusWalletViewHolder danaPlusWalletViewHolder = (DanaPlusWalletViewHolder) holder;
            Boolean bool3 = this.danaPlusBalanceVisibility;
            danaPlusWalletViewHolder.setBalanceVisible(bool3 != null ? bool3.booleanValue() : false);
        }
        super.onBindViewHolder((SearchCardAdapter) holder, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int position) {
        return getItems().get(position).getViewType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "");
        super.onDetachedFromRecyclerView(recyclerView);
        Disposable disposable = this.countUpPublishSubjectDisposable;
        Disposable disposable2 = null;
        if (disposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            disposable = null;
        }
        disposable.dispose();
        Disposable disposable3 = this.countDownPublishSubjectDisposable;
        if (disposable3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            disposable2 = disposable3;
        }
        disposable2.dispose();
    }

    private final void notifyDataSetChangeByAsset(int assetType) {
        List<WalletV3CardModel> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        int i = 0;
        for (Object obj : items) {
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (((WalletV3CardModel) obj).getViewType() == assetType) {
                notifyItemChanged(i);
            }
            i++;
        }
    }

    private final void initializeCountUpTimerPublishSubject() {
        Disposable subscribe = Observable.interval(60L, TimeUnit.SECONDS).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.wallet_v3.view.search.adapter.SearchCardAdapter$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SearchCardAdapter.m3105initializeCountUpTimerPublishSubject$lambda1(SearchCardAdapter.this, (Long) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        this.countUpPublishSubjectDisposable = subscribe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initializeCountUpTimerPublishSubject$lambda-1  reason: not valid java name */
    public static final void m3105initializeCountUpTimerPublishSubject$lambda1(SearchCardAdapter searchCardAdapter, Long l) {
        Intrinsics.checkNotNullParameter(searchCardAdapter, "");
        searchCardAdapter.countUpPublishSubject.onNext(Integer.valueOf((int) l.longValue()));
    }

    private final void initializeCountDownTimerPublishSubject() {
        Disposable subscribe = Observable.interval(1L, TimeUnit.SECONDS).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.wallet_v3.view.search.adapter.SearchCardAdapter$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SearchCardAdapter.m3104initializeCountDownTimerPublishSubject$lambda2(SearchCardAdapter.this, (Long) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        this.countDownPublishSubjectDisposable = subscribe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initializeCountDownTimerPublishSubject$lambda-2  reason: not valid java name */
    public static final void m3104initializeCountDownTimerPublishSubject$lambda2(SearchCardAdapter searchCardAdapter, Long l) {
        Intrinsics.checkNotNullParameter(searchCardAdapter, "");
        searchCardAdapter.countDownPublishSubject.onNext(Integer.valueOf((int) l.longValue()));
    }
}
