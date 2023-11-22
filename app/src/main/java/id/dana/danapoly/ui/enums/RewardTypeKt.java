package id.dana.danapoly.ui.enums;

import id.dana.danapoly.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danapoly/ui/enums/RewardType;", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/danapoly/ui/enums/RewardType;)I"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RewardTypeKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[RewardType.values().length];
            iArr[RewardType.START.ordinal()] = 1;
            iArr[RewardType.STOP.ordinal()] = 2;
            iArr[RewardType.DARE.ordinal()] = 3;
            iArr[RewardType.TREASURE.ordinal()] = 4;
            iArr[RewardType.TRIVIA.ordinal()] = 5;
            iArr[RewardType.TRICK.ordinal()] = 6;
            iArr[RewardType.DANA_BALANCE.ordinal()] = 7;
            iArr[RewardType.A_PLUS_REWARD.ordinal()] = 8;
            iArr[RewardType.DANA_DEALS.ordinal()] = 9;
            MyBillsEntityDataFactory = iArr;
        }
    }

    public static final int BuiltInFictitiousFunctionClassFactory(RewardType rewardType) {
        Intrinsics.checkNotNullParameter(rewardType, "");
        switch (WhenMappings.MyBillsEntityDataFactory[rewardType.ordinal()]) {
            case 1:
                return R.drawable.ic_danapoly_card_start;
            case 2:
                return R.drawable.res_0x7f0808b5_bottomsheetcardbindingview_watchercardnumberview_1;
            case 3:
                return R.drawable.ic_danapoly_card_dare;
            case 4:
                return R.drawable.res_0x7f0808b6_verifypinstatemanager_executeriskchallenge_2_1;
            case 5:
                return R.drawable.ic_danapoly_card_did_you_know;
            case 6:
                return R.drawable.ic_danapoly_card_trick;
            case 7:
                return R.drawable.ic_danapoly_card_dana_balance;
            case 8:
                return R.drawable.ic_danapoly_card_aplusreward;
            case 9:
                return R.drawable.ic_danapoly_card_dana_deals;
            default:
                return R.drawable.ic_danapoly_card_default;
        }
    }
}
