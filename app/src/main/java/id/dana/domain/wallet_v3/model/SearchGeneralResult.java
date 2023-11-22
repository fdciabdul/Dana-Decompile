package id.dana.domain.wallet_v3.model;

import id.dana.domain.pocket.model.PocketQueryList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b,\u0010-J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J|\u0010\u0017\u001a\u00020\u00002\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u001f\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010\u0005R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010\u0010R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b'\u0010\u0005R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010\nR\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b*\u0010\nR\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b+\u0010\n"}, d2 = {"Lid/dana/domain/wallet_v3/model/SearchGeneralResult;", "", "", "Lid/dana/domain/wallet_v3/model/UserAssetInfosModel;", "component1", "()Ljava/util/List;", "component2", "Lid/dana/domain/wallet_v3/model/UserPocketAssetListModel;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;", "component3", "()Lid/dana/domain/wallet_v3/model/UserPocketAssetListModel;", "component4", "component5", "Lid/dana/domain/pocket/model/PocketQueryList;", "Lid/dana/domain/wallet_v3/model/KtpInfo;", "component6", "()Lid/dana/domain/pocket/model/PocketQueryList;", "bankCards", "investmentCards", "voucherCards", "ticketCards", "loyaltyCards", "identityCards", "copy", "(Ljava/util/List;Ljava/util/List;Lid/dana/domain/wallet_v3/model/UserPocketAssetListModel;Lid/dana/domain/wallet_v3/model/UserPocketAssetListModel;Lid/dana/domain/wallet_v3/model/UserPocketAssetListModel;Lid/dana/domain/pocket/model/PocketQueryList;)Lid/dana/domain/wallet_v3/model/SearchGeneralResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getBankCards", "Lid/dana/domain/pocket/model/PocketQueryList;", "getIdentityCards", "getInvestmentCards", "Lid/dana/domain/wallet_v3/model/UserPocketAssetListModel;", "getLoyaltyCards", "getTicketCards", "getVoucherCards", "<init>", "(Ljava/util/List;Ljava/util/List;Lid/dana/domain/wallet_v3/model/UserPocketAssetListModel;Lid/dana/domain/wallet_v3/model/UserPocketAssetListModel;Lid/dana/domain/wallet_v3/model/UserPocketAssetListModel;Lid/dana/domain/pocket/model/PocketQueryList;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SearchGeneralResult {
    private final List<UserAssetInfosModel> bankCards;
    private final PocketQueryList<KtpInfo> identityCards;
    private final List<UserAssetInfosModel> investmentCards;
    private final UserPocketAssetListModel<UserPocketAssetModel> loyaltyCards;
    private final UserPocketAssetListModel<UserPocketAssetModel> ticketCards;
    private final UserPocketAssetListModel<UserPocketAssetModel> voucherCards;

    public SearchGeneralResult() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ SearchGeneralResult copy$default(SearchGeneralResult searchGeneralResult, List list, List list2, UserPocketAssetListModel userPocketAssetListModel, UserPocketAssetListModel userPocketAssetListModel2, UserPocketAssetListModel userPocketAssetListModel3, PocketQueryList pocketQueryList, int i, Object obj) {
        List<UserAssetInfosModel> list3 = list;
        if ((i & 1) != 0) {
            list3 = searchGeneralResult.bankCards;
        }
        List<UserAssetInfosModel> list4 = list2;
        if ((i & 2) != 0) {
            list4 = searchGeneralResult.investmentCards;
        }
        List list5 = list4;
        UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel4 = userPocketAssetListModel;
        if ((i & 4) != 0) {
            userPocketAssetListModel4 = searchGeneralResult.voucherCards;
        }
        UserPocketAssetListModel userPocketAssetListModel5 = userPocketAssetListModel4;
        UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel6 = userPocketAssetListModel2;
        if ((i & 8) != 0) {
            userPocketAssetListModel6 = searchGeneralResult.ticketCards;
        }
        UserPocketAssetListModel userPocketAssetListModel7 = userPocketAssetListModel6;
        UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel8 = userPocketAssetListModel3;
        if ((i & 16) != 0) {
            userPocketAssetListModel8 = searchGeneralResult.loyaltyCards;
        }
        UserPocketAssetListModel userPocketAssetListModel9 = userPocketAssetListModel8;
        PocketQueryList<KtpInfo> pocketQueryList2 = pocketQueryList;
        if ((i & 32) != 0) {
            pocketQueryList2 = searchGeneralResult.identityCards;
        }
        return searchGeneralResult.copy(list3, list5, userPocketAssetListModel5, userPocketAssetListModel7, userPocketAssetListModel9, pocketQueryList2);
    }

    public final List<UserAssetInfosModel> component1() {
        return this.bankCards;
    }

    public final List<UserAssetInfosModel> component2() {
        return this.investmentCards;
    }

    public final UserPocketAssetListModel<UserPocketAssetModel> component3() {
        return this.voucherCards;
    }

    public final UserPocketAssetListModel<UserPocketAssetModel> component4() {
        return this.ticketCards;
    }

    public final UserPocketAssetListModel<UserPocketAssetModel> component5() {
        return this.loyaltyCards;
    }

    public final PocketQueryList<KtpInfo> component6() {
        return this.identityCards;
    }

    public final SearchGeneralResult copy(List<UserAssetInfosModel> bankCards, List<UserAssetInfosModel> investmentCards, UserPocketAssetListModel<UserPocketAssetModel> voucherCards, UserPocketAssetListModel<UserPocketAssetModel> ticketCards, UserPocketAssetListModel<UserPocketAssetModel> loyaltyCards, PocketQueryList<KtpInfo> identityCards) {
        return new SearchGeneralResult(bankCards, investmentCards, voucherCards, ticketCards, loyaltyCards, identityCards);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SearchGeneralResult) {
            SearchGeneralResult searchGeneralResult = (SearchGeneralResult) other;
            return Intrinsics.areEqual(this.bankCards, searchGeneralResult.bankCards) && Intrinsics.areEqual(this.investmentCards, searchGeneralResult.investmentCards) && Intrinsics.areEqual(this.voucherCards, searchGeneralResult.voucherCards) && Intrinsics.areEqual(this.ticketCards, searchGeneralResult.ticketCards) && Intrinsics.areEqual(this.loyaltyCards, searchGeneralResult.loyaltyCards) && Intrinsics.areEqual(this.identityCards, searchGeneralResult.identityCards);
        }
        return false;
    }

    public final int hashCode() {
        List<UserAssetInfosModel> list = this.bankCards;
        int hashCode = list == null ? 0 : list.hashCode();
        List<UserAssetInfosModel> list2 = this.investmentCards;
        int hashCode2 = list2 == null ? 0 : list2.hashCode();
        UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel = this.voucherCards;
        int hashCode3 = userPocketAssetListModel == null ? 0 : userPocketAssetListModel.hashCode();
        UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel2 = this.ticketCards;
        int hashCode4 = userPocketAssetListModel2 == null ? 0 : userPocketAssetListModel2.hashCode();
        UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel3 = this.loyaltyCards;
        int hashCode5 = userPocketAssetListModel3 == null ? 0 : userPocketAssetListModel3.hashCode();
        PocketQueryList<KtpInfo> pocketQueryList = this.identityCards;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (pocketQueryList != null ? pocketQueryList.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SearchGeneralResult(bankCards=");
        sb.append(this.bankCards);
        sb.append(", investmentCards=");
        sb.append(this.investmentCards);
        sb.append(", voucherCards=");
        sb.append(this.voucherCards);
        sb.append(", ticketCards=");
        sb.append(this.ticketCards);
        sb.append(", loyaltyCards=");
        sb.append(this.loyaltyCards);
        sb.append(", identityCards=");
        sb.append(this.identityCards);
        sb.append(')');
        return sb.toString();
    }

    public SearchGeneralResult(List<UserAssetInfosModel> list, List<UserAssetInfosModel> list2, UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel, UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel2, UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel3, PocketQueryList<KtpInfo> pocketQueryList) {
        this.bankCards = list;
        this.investmentCards = list2;
        this.voucherCards = userPocketAssetListModel;
        this.ticketCards = userPocketAssetListModel2;
        this.loyaltyCards = userPocketAssetListModel3;
        this.identityCards = pocketQueryList;
    }

    public /* synthetic */ SearchGeneralResult(List list, List list2, UserPocketAssetListModel userPocketAssetListModel, UserPocketAssetListModel userPocketAssetListModel2, UserPocketAssetListModel userPocketAssetListModel3, PocketQueryList pocketQueryList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? new UserPocketAssetListModel(false, null, 0, 7, null) : userPocketAssetListModel, (i & 8) != 0 ? new UserPocketAssetListModel(false, null, 0, 7, null) : userPocketAssetListModel2, (i & 16) != 0 ? new UserPocketAssetListModel(false, null, 0, 7, null) : userPocketAssetListModel3, (i & 32) != 0 ? new PocketQueryList(false, null, 0, 7, null) : pocketQueryList);
    }

    @JvmName(name = "getBankCards")
    public final List<UserAssetInfosModel> getBankCards() {
        return this.bankCards;
    }

    @JvmName(name = "getInvestmentCards")
    public final List<UserAssetInfosModel> getInvestmentCards() {
        return this.investmentCards;
    }

    @JvmName(name = "getVoucherCards")
    public final UserPocketAssetListModel<UserPocketAssetModel> getVoucherCards() {
        return this.voucherCards;
    }

    @JvmName(name = "getTicketCards")
    public final UserPocketAssetListModel<UserPocketAssetModel> getTicketCards() {
        return this.ticketCards;
    }

    @JvmName(name = "getLoyaltyCards")
    public final UserPocketAssetListModel<UserPocketAssetModel> getLoyaltyCards() {
        return this.loyaltyCards;
    }

    @JvmName(name = "getIdentityCards")
    public final PocketQueryList<KtpInfo> getIdentityCards() {
        return this.identityCards;
    }
}
