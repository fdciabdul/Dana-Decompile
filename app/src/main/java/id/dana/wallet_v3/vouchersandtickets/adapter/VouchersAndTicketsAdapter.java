package id.dana.wallet_v3.vouchersandtickets.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.griver.video.H5Constants;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.VoucherAndTicketCardModel;
import id.dana.wallet_v3.model.WalletV3CardModel;
import id.dana.wallet_v3.vouchersandtickets.viewholder.DealsViewHolder;
import id.dana.wallet_v3.vouchersandtickets.viewholder.LoadingSpinnerViewHolder;
import id.dana.wallet_v3.vouchersandtickets.viewholder.MovieTicketViewHolder;
import id.dana.wallet_v3.vouchersandtickets.viewholder.ParkingTicketViewHolder;
import id.dana.wallet_v3.vouchersandtickets.viewholder.TravelTicketViewHolder;
import id.dana.wallet_v3.vouchersandtickets.viewholder.VoucherEmptyCardViewHolder;
import id.dana.wallet_v3.vouchersandtickets.viewholder.VoucherViewHolder;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\nR\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u0004\u0018\u00010!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#"}, d2 = {"Lid/dana/wallet_v3/vouchersandtickets/adapter/VouchersAndTicketsAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "", "position", "getItemViewType", "(I)I", "", H5Constants.PARAM_HIDE_LOADING_VIEW, "()V", "initializeCountDownTimerPublishSubject", "initializeCountUpTimerPublishSubject", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lid/dana/base/BaseRecyclerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onDetachedFromRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "showLoadingViewOnTheLastItem", "Lio/reactivex/subjects/PublishSubject;", "countDownPublishSubject", "Lio/reactivex/subjects/PublishSubject;", "Lio/reactivex/disposables/Disposable;", "countDownPublishSubjectDisposable", "Lio/reactivex/disposables/Disposable;", "countUpPublishSubject", "countUpPublishSubjectDisposable", "currentLoadingViewIndex", "I", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "<init>", "(Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class VouchersAndTicketsAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<WalletV3CardModel>, WalletV3CardModel> {
    private final PublishSubject<Integer> countDownPublishSubject;
    private Disposable countDownPublishSubjectDisposable;
    private PublishSubject<Integer> countUpPublishSubject;
    private Disposable countUpPublishSubjectDisposable;
    private int currentLoadingViewIndex;
    private final WalletCardAssetClickListener walletCardAssetClickListener;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.wallet_v3.listener.WalletCardAssetClickListener] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public VouchersAndTicketsAdapter() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.vouchersandtickets.adapter.VouchersAndTicketsAdapter.<init>():void");
    }

    public /* synthetic */ VouchersAndTicketsAdapter(WalletCardAssetClickListener walletCardAssetClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : walletCardAssetClickListener);
    }

    public VouchersAndTicketsAdapter(WalletCardAssetClickListener walletCardAssetClickListener) {
        this.walletCardAssetClickListener = walletCardAssetClickListener;
        PublishSubject<Integer> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.countUpPublishSubject = PlaceComponentResult;
        PublishSubject<Integer> PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        this.countDownPublishSubject = PlaceComponentResult2;
        this.currentLoadingViewIndex = -1;
        initializeCountUpTimerPublishSubject();
        initializeCountDownTimerPublishSubject();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final BaseRecyclerViewHolder<WalletV3CardModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "");
        if (viewType == 3) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            return new VoucherEmptyCardViewHolder(context, parent, this.walletCardAssetClickListener);
        } else if (viewType == 15) {
            Context context2 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "");
            return new MovieTicketViewHolder(context2, parent, this.walletCardAssetClickListener);
        } else if (viewType != 19) {
            switch (viewType) {
                case 8:
                    Context context3 = parent.getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "");
                    return new VoucherViewHolder(context3, parent, this.countDownPublishSubject, this.walletCardAssetClickListener);
                case 9:
                    Context context4 = parent.getContext();
                    Intrinsics.checkNotNullExpressionValue(context4, "");
                    return new TravelTicketViewHolder(context4, parent, this.walletCardAssetClickListener);
                case 10:
                    Context context5 = parent.getContext();
                    Intrinsics.checkNotNullExpressionValue(context5, "");
                    return new ParkingTicketViewHolder(context5, parent, this.countUpPublishSubject, this.walletCardAssetClickListener);
                case 11:
                    Context context6 = parent.getContext();
                    Intrinsics.checkNotNullExpressionValue(context6, "");
                    return new LoadingSpinnerViewHolder(context6, parent);
                default:
                    Context context7 = parent.getContext();
                    Intrinsics.checkNotNullExpressionValue(context7, "");
                    return new LoadingSpinnerViewHolder(context7, parent);
            }
        } else {
            Context context8 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context8, "");
            return new DealsViewHolder(context8, parent, this.walletCardAssetClickListener, this.countDownPublishSubject);
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public final void showLoadingViewOnTheLastItem() {
        ?? r2 = 0;
        appendItem(new VoucherAndTicketCardModel.LoadingState(r2, 1, r2));
        this.currentLoadingViewIndex = getItems().size() - 1;
    }

    public final void hideLoadingView() {
        removeItem(this.currentLoadingViewIndex);
        this.currentLoadingViewIndex = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int position) {
        return getItem(position).getViewType();
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

    private final void initializeCountUpTimerPublishSubject() {
        Disposable subscribe = Observable.interval(60L, TimeUnit.SECONDS).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.wallet_v3.vouchersandtickets.adapter.VouchersAndTicketsAdapter$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VouchersAndTicketsAdapter.m3140initializeCountUpTimerPublishSubject$lambda0(VouchersAndTicketsAdapter.this, (Long) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        this.countUpPublishSubjectDisposable = subscribe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initializeCountUpTimerPublishSubject$lambda-0  reason: not valid java name */
    public static final void m3140initializeCountUpTimerPublishSubject$lambda0(VouchersAndTicketsAdapter vouchersAndTicketsAdapter, Long l) {
        Intrinsics.checkNotNullParameter(vouchersAndTicketsAdapter, "");
        vouchersAndTicketsAdapter.countUpPublishSubject.onNext(Integer.valueOf((int) l.longValue()));
    }

    private final void initializeCountDownTimerPublishSubject() {
        Disposable subscribe = Observable.interval(1L, TimeUnit.SECONDS).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.wallet_v3.vouchersandtickets.adapter.VouchersAndTicketsAdapter$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VouchersAndTicketsAdapter.m3139initializeCountDownTimerPublishSubject$lambda1(VouchersAndTicketsAdapter.this, (Long) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        this.countDownPublishSubjectDisposable = subscribe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initializeCountDownTimerPublishSubject$lambda-1  reason: not valid java name */
    public static final void m3139initializeCountDownTimerPublishSubject$lambda1(VouchersAndTicketsAdapter vouchersAndTicketsAdapter, Long l) {
        Intrinsics.checkNotNullParameter(vouchersAndTicketsAdapter, "");
        vouchersAndTicketsAdapter.countDownPublishSubject.onNext(Integer.valueOf((int) l.longValue()));
    }
}
