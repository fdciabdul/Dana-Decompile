package id.dana.wallet_v3.factory;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.richview.wallet.BaseWalletCardView;
import id.dana.wallet_v3.listener.DanaBalanceClickListener;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.IdentityCardModel;
import id.dana.wallet_v3.model.InvestmentCardModel;
import id.dana.wallet_v3.model.LoyaltyCardModel;
import id.dana.wallet_v3.model.PaymentCardModel;
import id.dana.wallet_v3.model.VoucherAndTicketCardModel;
import id.dana.wallet_v3.model.WalletV3CardModel;
import id.dana.wallet_v3.view.walletcardview.BankWalletV3CardView;
import id.dana.wallet_v3.view.walletcardview.DanaBalanceWalletV3CardView;
import id.dana.wallet_v3.view.walletcardview.DanaDealsWalletV3CardView;
import id.dana.wallet_v3.view.walletcardview.DanaEmasWalletV3CardView;
import id.dana.wallet_v3.view.walletcardview.DanaGoalsWalletV3CardView;
import id.dana.wallet_v3.view.walletcardview.DanaPaylaterWalletV3CardView;
import id.dana.wallet_v3.view.walletcardview.DanaPlusWalletV3CardView;
import id.dana.wallet_v3.view.walletcardview.DefaultEmptyCardView;
import id.dana.wallet_v3.view.walletcardview.ErrorStateCardView;
import id.dana.wallet_v3.view.walletcardview.IdentityWalletV3CardView;
import id.dana.wallet_v3.view.walletcardview.LoyaltyWalletV3CardView;
import id.dana.wallet_v3.view.walletcardview.MovieTicketWalletV3CardView;
import id.dana.wallet_v3.view.walletcardview.ParkingTicketV3WalletCardView;
import id.dana.wallet_v3.view.walletcardview.TravelTicketWalletV3CardView;
import id.dana.wallet_v3.view.walletcardview.VoucherWalletV3CardView;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bB\u0010CJ'\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0019\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001c\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0017¢\u0006\u0004\b\u001c\u0010\u001aJ\u0017\u0010\u001f\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u00128\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00178\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010\u001aR(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00178\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010+\u001a\u0004\b/\u0010-\"\u0004\b0\u0010\u001aR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b\u001e\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u0010 R$\u00105\u001a\u0004\u0018\u00010\u00128\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b5\u0010&\u001a\u0004\b6\u0010(\"\u0004\b7\u0010*R$\u00108\u001a\u0004\u0018\u00010\u00128\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b8\u0010&\u001a\u0004\b9\u0010(\"\u0004\b:\u0010*R$\u0010;\u001a\u0004\u0018\u00010\u00128\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b;\u0010&\u001a\u0004\b<\u0010(\"\u0004\b=\u0010*R$\u0010\"\u001a\u0004\u0018\u00010!8\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b\"\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010$"}, d2 = {"Lid/dana/wallet_v3/factory/WalletCardFactory;", "", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/wallet_v3/model/WalletV3CardModel;", "data", "", "cardIndex", "Lid/dana/richview/wallet/BaseWalletCardView;", "generateCardView", "(Landroid/content/Context;Lid/dana/wallet_v3/model/WalletV3CardModel;I)Lid/dana/richview/wallet/BaseWalletCardView;", "", "type", "generateEmptyCardView", "(Landroid/content/Context;Ljava/lang/String;)Lid/dana/richview/wallet/BaseWalletCardView;", "generateErrorStateCardView", "(Landroid/content/Context;)Lid/dana/richview/wallet/BaseWalletCardView;", "", "", "allBalanceVisibility", "", "setAllBalanceVisibility", "(Ljava/util/List;)V", "Lio/reactivex/subjects/PublishSubject;", "countDownPublishSubject", "setCountDownPublishSubject", "(Lio/reactivex/subjects/PublishSubject;)V", "countUpPublishSubject", "setCountUpPublishSubject", "Lid/dana/wallet_v3/listener/DanaBalanceClickListener;", "danaBalanceClickListener", "setDanaBalanceClickListener", "(Lid/dana/wallet_v3/listener/DanaBalanceClickListener;)V", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "setWalletCardAssetClickListener", "(Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;)V", "balanceVisibility", "Ljava/lang/Boolean;", "getBalanceVisibility$app_productionRelease", "()Ljava/lang/Boolean;", "setBalanceVisibility$app_productionRelease", "(Ljava/lang/Boolean;)V", "Lio/reactivex/subjects/PublishSubject;", "getCountDownPublishSubject$app_productionRelease", "()Lio/reactivex/subjects/PublishSubject;", "setCountDownPublishSubject$app_productionRelease", "getCountUpPublishSubject$app_productionRelease", "setCountUpPublishSubject$app_productionRelease", "Lid/dana/wallet_v3/listener/DanaBalanceClickListener;", "getDanaBalanceClickListener$app_productionRelease", "()Lid/dana/wallet_v3/listener/DanaBalanceClickListener;", "setDanaBalanceClickListener$app_productionRelease", "danaPlusBalanceVisibility", "getDanaPlusBalanceVisibility$app_productionRelease", "setDanaPlusBalanceVisibility$app_productionRelease", "emasBalanceVisibility", "getEmasBalanceVisibility$app_productionRelease", "setEmasBalanceVisibility$app_productionRelease", "goalsBalanceVisibility", "getGoalsBalanceVisibility$app_productionRelease", "setGoalsBalanceVisibility$app_productionRelease", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "getWalletCardAssetClickListener$app_productionRelease", "()Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "setWalletCardAssetClickListener$app_productionRelease", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WalletCardFactory {
    public static final WalletCardFactory INSTANCE = new WalletCardFactory();
    private static Boolean balanceVisibility;
    private static PublishSubject<Integer> countDownPublishSubject;
    private static PublishSubject<Integer> countUpPublishSubject;
    private static DanaBalanceClickListener danaBalanceClickListener;
    private static Boolean danaPlusBalanceVisibility;
    private static Boolean emasBalanceVisibility;
    private static Boolean goalsBalanceVisibility;
    private static WalletCardAssetClickListener walletCardAssetClickListener;

    private WalletCardFactory() {
    }

    static {
        Boolean bool = Boolean.TRUE;
        balanceVisibility = bool;
        goalsBalanceVisibility = bool;
        emasBalanceVisibility = bool;
        danaPlusBalanceVisibility = bool;
        PublishSubject<Integer> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        countUpPublishSubject = PlaceComponentResult;
        PublishSubject<Integer> PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        countDownPublishSubject = PlaceComponentResult2;
    }

    @JvmName(name = "getBalanceVisibility$app_productionRelease")
    public final Boolean getBalanceVisibility$app_productionRelease() {
        return balanceVisibility;
    }

    @JvmName(name = "setBalanceVisibility$app_productionRelease")
    public final void setBalanceVisibility$app_productionRelease(Boolean bool) {
        balanceVisibility = bool;
    }

    @JvmName(name = "getGoalsBalanceVisibility$app_productionRelease")
    public final Boolean getGoalsBalanceVisibility$app_productionRelease() {
        return goalsBalanceVisibility;
    }

    @JvmName(name = "setGoalsBalanceVisibility$app_productionRelease")
    public final void setGoalsBalanceVisibility$app_productionRelease(Boolean bool) {
        goalsBalanceVisibility = bool;
    }

    @JvmName(name = "getEmasBalanceVisibility$app_productionRelease")
    public final Boolean getEmasBalanceVisibility$app_productionRelease() {
        return emasBalanceVisibility;
    }

    @JvmName(name = "setEmasBalanceVisibility$app_productionRelease")
    public final void setEmasBalanceVisibility$app_productionRelease(Boolean bool) {
        emasBalanceVisibility = bool;
    }

    @JvmName(name = "getDanaPlusBalanceVisibility$app_productionRelease")
    public final Boolean getDanaPlusBalanceVisibility$app_productionRelease() {
        return danaPlusBalanceVisibility;
    }

    @JvmName(name = "setDanaPlusBalanceVisibility$app_productionRelease")
    public final void setDanaPlusBalanceVisibility$app_productionRelease(Boolean bool) {
        danaPlusBalanceVisibility = bool;
    }

    @JvmName(name = "getCountUpPublishSubject$app_productionRelease")
    public final PublishSubject<Integer> getCountUpPublishSubject$app_productionRelease() {
        return countUpPublishSubject;
    }

    @JvmName(name = "setCountUpPublishSubject$app_productionRelease")
    public final void setCountUpPublishSubject$app_productionRelease(PublishSubject<Integer> publishSubject) {
        Intrinsics.checkNotNullParameter(publishSubject, "");
        countUpPublishSubject = publishSubject;
    }

    @JvmName(name = "getCountDownPublishSubject$app_productionRelease")
    public final PublishSubject<Integer> getCountDownPublishSubject$app_productionRelease() {
        return countDownPublishSubject;
    }

    @JvmName(name = "setCountDownPublishSubject$app_productionRelease")
    public final void setCountDownPublishSubject$app_productionRelease(PublishSubject<Integer> publishSubject) {
        Intrinsics.checkNotNullParameter(publishSubject, "");
        countDownPublishSubject = publishSubject;
    }

    @JvmName(name = "getDanaBalanceClickListener$app_productionRelease")
    public final DanaBalanceClickListener getDanaBalanceClickListener$app_productionRelease() {
        return danaBalanceClickListener;
    }

    @JvmName(name = "setDanaBalanceClickListener$app_productionRelease")
    public final void setDanaBalanceClickListener$app_productionRelease(DanaBalanceClickListener danaBalanceClickListener2) {
        danaBalanceClickListener = danaBalanceClickListener2;
    }

    @JvmName(name = "getWalletCardAssetClickListener$app_productionRelease")
    public final WalletCardAssetClickListener getWalletCardAssetClickListener$app_productionRelease() {
        return walletCardAssetClickListener;
    }

    @JvmName(name = "setWalletCardAssetClickListener$app_productionRelease")
    public final void setWalletCardAssetClickListener$app_productionRelease(WalletCardAssetClickListener walletCardAssetClickListener2) {
        walletCardAssetClickListener = walletCardAssetClickListener2;
    }

    public final void setAllBalanceVisibility(List<Boolean> allBalanceVisibility) {
        balanceVisibility = allBalanceVisibility != null ? (Boolean) CollectionsKt.getOrNull(allBalanceVisibility, 0) : null;
        goalsBalanceVisibility = allBalanceVisibility != null ? (Boolean) CollectionsKt.getOrNull(allBalanceVisibility, 1) : null;
        danaPlusBalanceVisibility = allBalanceVisibility != null ? (Boolean) CollectionsKt.getOrNull(allBalanceVisibility, 2) : null;
        emasBalanceVisibility = allBalanceVisibility != null ? (Boolean) CollectionsKt.getOrNull(allBalanceVisibility, 3) : null;
    }

    public final void setCountUpPublishSubject(PublishSubject<Integer> countUpPublishSubject2) {
        Intrinsics.checkNotNullParameter(countUpPublishSubject2, "");
        countUpPublishSubject = countUpPublishSubject2;
    }

    public final void setCountDownPublishSubject(PublishSubject<Integer> countDownPublishSubject2) {
        Intrinsics.checkNotNullParameter(countDownPublishSubject2, "");
        countDownPublishSubject = countDownPublishSubject2;
    }

    public final void setDanaBalanceClickListener(DanaBalanceClickListener danaBalanceClickListener2) {
        danaBalanceClickListener = danaBalanceClickListener2;
    }

    public final void setWalletCardAssetClickListener(WalletCardAssetClickListener walletCardAssetClickListener2) {
        walletCardAssetClickListener = walletCardAssetClickListener2;
    }

    public final BaseWalletCardView generateCardView(Context context, WalletV3CardModel data, int cardIndex) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(data, "");
        if (data instanceof PaymentCardModel.BankCard) {
            BankWalletV3CardView bankWalletV3CardView = new BankWalletV3CardView(context, null, 0, 6, null);
            bankWalletV3CardView.setCard((PaymentCardModel.BankCard) data);
            bankWalletV3CardView.setOnBankClickListener(walletCardAssetClickListener);
            return bankWalletV3CardView.setupMarginLayoutForNewWalletFragmentSectionView();
        } else if (data instanceof PaymentCardModel.DanaCard) {
            return new DanaBalanceWalletV3CardView(context, (PaymentCardModel.DanaCard) data, danaBalanceClickListener).setupMarginLayoutForNewWalletFragmentSectionView();
        } else {
            if (data instanceof PaymentCardModel.PaylaterCard) {
                return new DanaPaylaterWalletV3CardView(context, (PaymentCardModel.PaylaterCard) data, walletCardAssetClickListener).setupMarginLayoutForNewWalletFragmentSectionView();
            }
            if (data instanceof PaymentCardModel.EmptyCard) {
                return new DefaultEmptyCardView(context, "PAYMENT", walletCardAssetClickListener).setupMarginLayoutForNewWalletFragmentSectionView();
            }
            if (data instanceof InvestmentCardModel.DanaPlusCard) {
                return new DanaPlusWalletV3CardView(context, (InvestmentCardModel.DanaPlusCard) data, danaPlusBalanceVisibility, walletCardAssetClickListener, null, 16, null).setupMarginLayoutForNewWalletFragmentSectionView();
            }
            if (data instanceof InvestmentCardModel.EmasCard) {
                WalletCardAssetClickListener walletCardAssetClickListener2 = walletCardAssetClickListener;
                Boolean bool = emasBalanceVisibility;
                return new DanaEmasWalletV3CardView(context, (InvestmentCardModel.EmasCard) data, bool != null ? bool.booleanValue() : false, walletCardAssetClickListener2, null, 16, null).setupMarginLayoutForNewWalletFragmentSectionView();
            } else if (data instanceof InvestmentCardModel.DanaGoalsCard) {
                InvestmentCardModel.DanaGoalsCard danaGoalsCard = (InvestmentCardModel.DanaGoalsCard) data;
                Boolean bool2 = goalsBalanceVisibility;
                return new DanaGoalsWalletV3CardView(context, danaGoalsCard, bool2 != null ? bool2.booleanValue() : false, walletCardAssetClickListener, null, 16, null).setupMarginLayoutForNewWalletFragmentSectionView();
            } else if (data instanceof VoucherAndTicketCardModel.VoucherCard) {
                return new VoucherWalletV3CardView(context, walletCardAssetClickListener, (VoucherAndTicketCardModel.VoucherCard) data, countDownPublishSubject, cardIndex);
            } else if (data instanceof VoucherAndTicketCardModel.DealsCard) {
                return new DanaDealsWalletV3CardView(context, walletCardAssetClickListener, (VoucherAndTicketCardModel.DealsCard) data, countDownPublishSubject, cardIndex);
            } else if (data instanceof VoucherAndTicketCardModel.ParkingTicketCard) {
                return new ParkingTicketV3WalletCardView(context, (VoucherAndTicketCardModel.ParkingTicketCard) data, walletCardAssetClickListener, countUpPublishSubject);
            } else if (data instanceof VoucherAndTicketCardModel.TravelTicketCard) {
                return new TravelTicketWalletV3CardView(context, (VoucherAndTicketCardModel.TravelTicketCard) data, walletCardAssetClickListener);
            } else {
                if (data instanceof VoucherAndTicketCardModel.MovieTicketCard) {
                    return new MovieTicketWalletV3CardView(context, (VoucherAndTicketCardModel.MovieTicketCard) data, walletCardAssetClickListener);
                }
                if (data instanceof VoucherAndTicketCardModel.LoadingState) {
                    return null;
                }
                if (data instanceof LoyaltyCardModel.LoyaltyCard) {
                    return new LoyaltyWalletV3CardView(context, walletCardAssetClickListener, (LoyaltyCardModel.LoyaltyCard) data);
                }
                if (data instanceof IdentityCardModel.KtpCard) {
                    return new IdentityWalletV3CardView(context, (IdentityCardModel.KtpCard) data, walletCardAssetClickListener);
                }
                return new ErrorStateCardView(context);
            }
        }
    }

    public final BaseWalletCardView generateEmptyCardView(Context context, String type) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(type, "");
        switch (type.hashCode()) {
            case -1150817175:
                if (type.equals("FINANCIAL")) {
                    return new DefaultEmptyCardView(context, "FINANCIAL", walletCardAssetClickListener).setupMarginLayoutForNewWalletFragmentSectionView();
                }
                break;
            case -554006299:
                if (type.equals("VOUCHER_AND_TICKET")) {
                    return new DefaultEmptyCardView(context, "VOUCHER_AND_TICKET", walletCardAssetClickListener).setupMarginLayoutForNewWalletFragmentSectionView();
                }
                break;
            case 646865086:
                if (type.equals("IDENTITY")) {
                    return new DefaultEmptyCardView(context, "IDENTITY", walletCardAssetClickListener).setupMarginLayoutForNewWalletFragmentSectionView();
                }
                break;
            case 1076711462:
                if (type.equals("LOYALTY")) {
                    return new DefaultEmptyCardView(context, "LOYALTY", walletCardAssetClickListener).setupMarginLayoutForNewWalletFragmentSectionView();
                }
                break;
        }
        return new ErrorStateCardView(context);
    }

    public final BaseWalletCardView generateErrorStateCardView(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        return new ErrorStateCardView(context);
    }
}
