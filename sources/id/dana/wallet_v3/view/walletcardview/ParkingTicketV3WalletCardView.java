package id.dana.wallet_v3.view.walletcardview;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.material.card.MaterialCardView;
import id.dana.R;
import id.dana.electronicmoney.util.ElectronicMoneyUtils;
import id.dana.richview.wallet.BaseWalletCustomCardView;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.VoucherAndTicketCardModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&B1\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0017¢\u0006\u0004\b$\u0010%J\u0013\u0010\u0003\u001a\u0006*\u00020\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0012J\u000f\u0010\u0016\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!"}, d2 = {"Lid/dana/wallet_v3/view/walletcardview/ParkingTicketV3WalletCardView;", "Lid/dana/richview/wallet/BaseWalletCustomCardView;", "Lio/reactivex/disposables/Disposable;", "createTimeCounter", "()Lio/reactivex/disposables/Disposable;", "", "getCardInstId", "()Ljava/lang/CharSequence;", "", "time", "", "getDurationText", "(J)Ljava/lang/String;", "", "getLayout", "()I", "", "invokeListeners", "()V", "onAttachedToWindow", "onDetachedFromWindow", "setup", "setupStaticDatas", "Lio/reactivex/subjects/PublishSubject;", "countUpPublishSubject", "Lio/reactivex/subjects/PublishSubject;", "countdownDisposable", "Lio/reactivex/disposables/Disposable;", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "onParkingTicketClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$ParkingTicketCard;", "parkingTicketModel", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$ParkingTicketCard;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$ParkingTicketCard;Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;Lio/reactivex/subjects/PublishSubject;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ParkingTicketV3WalletCardView extends BaseWalletCustomCardView {
    private static final int HOUR = 3600000;
    private static final int MINUTE = 60000;
    private static final String TAG = "TicketSection";
    public Map<Integer, View> _$_findViewCache;
    private final PublishSubject<Integer> countUpPublishSubject;
    private Disposable countdownDisposable;
    private final WalletCardAssetClickListener onParkingTicketClickListener;
    private final VoucherAndTicketCardModel.ParkingTicketCard parkingTicketModel;

    @Override // id.dana.richview.wallet.BaseWalletCustomCardView, id.dana.richview.wallet.BaseWalletCardView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.richview.wallet.BaseWalletCustomCardView, id.dana.richview.wallet.BaseWalletCardView
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.component.BaseRichView
    public final int getLayout() {
        return R.layout.parking_wallet_v3_card;
    }

    @Override // id.dana.component.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParkingTicketV3WalletCardView(Context context, VoucherAndTicketCardModel.ParkingTicketCard parkingTicketCard, WalletCardAssetClickListener walletCardAssetClickListener, PublishSubject<Integer> publishSubject) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(parkingTicketCard, "");
        Intrinsics.checkNotNullParameter(publishSubject, "");
        this._$_findViewCache = new LinkedHashMap();
        this.parkingTicketModel = parkingTicketCard;
        this.onParkingTicketClickListener = walletCardAssetClickListener;
        this.countUpPublishSubject = publishSubject;
        this.countdownDisposable = createTimeCounter();
    }

    public /* synthetic */ ParkingTicketV3WalletCardView(Context context, VoucherAndTicketCardModel.ParkingTicketCard parkingTicketCard, WalletCardAssetClickListener walletCardAssetClickListener, PublishSubject publishSubject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, parkingTicketCard, (i & 4) != 0 ? null : walletCardAssetClickListener, publishSubject);
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public final CharSequence getCardInstId() {
        String ticketId = this.parkingTicketModel.getTicketId();
        if (ticketId == null) {
            ticketId = "";
        }
        return ticketId;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setupStaticDatas();
    }

    private final void setupStaticDatas() {
        Locale locale;
        Locale locale2;
        VoucherAndTicketCardModel.ParkingTicketCard parkingTicketCard = this.parkingTicketModel;
        Date date = new Date(this.parkingTicketModel.getEnterTime());
        locale = Locale.getDefault();
        String MyBillsEntityDataFactory = DateTimeUtil.MyBillsEntityDataFactory(date, "HH:mm:ss", locale);
        Date date2 = new Date(this.parkingTicketModel.getEnterTime());
        locale2 = Locale.getDefault();
        String MyBillsEntityDataFactory2 = DateTimeUtil.MyBillsEntityDataFactory(date2, "dd MMM yyyy", locale2);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_place)).setText(parkingTicketCard.getLocation());
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_start_time)).setText(MyBillsEntityDataFactory);
        ((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a18e7_unsupportedoperationexception_annotations)).setText(MyBillsEntityDataFactory2);
        ((AppCompatTextView) _$_findCachedViewById(R.id.CredentialModule$Declarations)).setText(getDurationText(parkingTicketCard.getDuration()));
        ((AppCompatTextView) _$_findCachedViewById(R.id.FriendRepository)).setText(parkingTicketCard.getTicketName());
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.computeBackingRowMap);
        ElectronicMoneyUtils electronicMoneyUtils = ElectronicMoneyUtils.INSTANCE;
        appCompatTextView.setText(ElectronicMoneyUtils.MyBillsEntityDataFactory(String.valueOf(parkingTicketCard.getTotal())));
        MaterialCardView materialCardView = (MaterialCardView) _$_findCachedViewById(R.id.res_0x7f0a058c_access_getmerchantinforepository_p);
        Intrinsics.checkNotNullExpressionValue(materialCardView, "");
        setToGrayScale(materialCardView, parkingTicketCard.getIsUsed());
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public final void invokeListeners() {
        WalletCardAssetClickListener walletCardAssetClickListener = this.onParkingTicketClickListener;
        if (walletCardAssetClickListener != null) {
            walletCardAssetClickListener.onCardClicked(this.parkingTicketModel);
        }
    }

    private final Disposable createTimeCounter() {
        return this.countUpPublishSubject.subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).doOnError(new Consumer() { // from class: id.dana.wallet_v3.view.walletcardview.ParkingTicketV3WalletCardView$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ParkingTicketV3WalletCardView.m3132createTimeCounter$lambda1((Throwable) obj);
            }
        }).subscribe(new Consumer() { // from class: id.dana.wallet_v3.view.walletcardview.ParkingTicketV3WalletCardView$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ParkingTicketV3WalletCardView.m3133createTimeCounter$lambda2(ParkingTicketV3WalletCardView.this, (Integer) obj);
            }
        });
    }

    /* renamed from: createTimeCounter$lambda-1 */
    public static final void m3132createTimeCounter$lambda1(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("error on countUpPublishSubject ");
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        sb.append(message);
        DanaLog.BuiltInFictitiousFunctionClassFactory(TAG, sb.toString());
    }

    /* renamed from: createTimeCounter$lambda-2 */
    public static final void m3133createTimeCounter$lambda2(ParkingTicketV3WalletCardView parkingTicketV3WalletCardView, Integer num) {
        Intrinsics.checkNotNullParameter(parkingTicketV3WalletCardView, "");
        VoucherAndTicketCardModel.ParkingTicketCard parkingTicketCard = parkingTicketV3WalletCardView.parkingTicketModel;
        parkingTicketCard.setDuration(parkingTicketCard.getDuration() - 60000);
        ((AppCompatTextView) parkingTicketV3WalletCardView._$_findCachedViewById(R.id.CredentialModule$Declarations)).setText(parkingTicketV3WalletCardView.getDurationText(parkingTicketV3WalletCardView.parkingTicketModel.getDuration()));
    }

    private final String getDurationText(long time) {
        long j = time / 3600000;
        String string = getContext().getResources().getString(R.string.parking_asset_duration, Long.valueOf(j), Long.valueOf((time - (3600000 * j)) / 60000));
        Intrinsics.checkNotNullExpressionValue(string, "");
        return string;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable disposable = this.countdownDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
