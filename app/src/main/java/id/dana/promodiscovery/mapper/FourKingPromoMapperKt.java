package id.dana.promodiscovery.mapper;

import id.dana.domain.promodiscovery.model.FourKingsPromoModel;
import id.dana.promodiscovery.model.FourKingItem;
import id.dana.promodiscovery.model.FourKingModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004*\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/promodiscovery/model/FourKingItem;", "", "getAuthRequestContext", "(Lid/dana/promodiscovery/model/FourKingItem;)Ljava/lang/String;", "", "Lid/dana/domain/promodiscovery/model/FourKingsPromoModel;", "Lid/dana/promodiscovery/model/FourKingModel;", "MyBillsEntityDataFactory", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FourKingPromoMapperKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[FourKingItem.values().length];
            iArr[FourKingItem.LOYALTY.ordinal()] = 1;
            iArr[FourKingItem.VOUCHER.ordinal()] = 2;
            iArr[FourKingItem.POINT.ordinal()] = 3;
            iArr[FourKingItem.QUEST.ordinal()] = 4;
            MyBillsEntityDataFactory = iArr;
        }
    }

    public static final List<FourKingModel> MyBillsEntityDataFactory(List<FourKingsPromoModel> list) {
        FourKingItem fourKingItem;
        Intrinsics.checkNotNullParameter(list, "");
        List<FourKingsPromoModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (FourKingsPromoModel fourKingsPromoModel : list2) {
            String pillarType = fourKingsPromoModel.getPillarType();
            switch (pillarType.hashCode()) {
                case 76307824:
                    if (pillarType.equals("POINT")) {
                        fourKingItem = FourKingItem.POINT;
                        break;
                    } else {
                        throw new IllegalStateException();
                    }
                case 77406402:
                    if (pillarType.equals("QUEST")) {
                        fourKingItem = FourKingItem.QUEST;
                        break;
                    } else {
                        throw new IllegalStateException();
                    }
                case 1076711462:
                    if (pillarType.equals("LOYALTY")) {
                        fourKingItem = FourKingItem.LOYALTY;
                        break;
                    } else {
                        throw new IllegalStateException();
                    }
                case 1358174862:
                    if (pillarType.equals("VOUCHER")) {
                        fourKingItem = FourKingItem.VOUCHER;
                        break;
                    } else {
                        throw new IllegalStateException();
                    }
                default:
                    throw new IllegalStateException();
            }
            int pillarAmount = fourKingsPromoModel.getPillarAmount();
            arrayList.add(new FourKingModel(fourKingItem, String.valueOf(pillarAmount), fourKingsPromoModel.isNewlyUpdated()));
        }
        return arrayList;
    }

    public static final String getAuthRequestContext(FourKingItem fourKingItem) {
        Intrinsics.checkNotNullParameter(fourKingItem, "");
        int i = WhenMappings.MyBillsEntityDataFactory[fourKingItem.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return "QUEST";
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return "POINT";
            }
            return "VOUCHER";
        }
        return "LOYALTY";
    }
}
