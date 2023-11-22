package id.dana.mybills.mapper;

import id.dana.domain.mybills.model.BizProduct;
import id.dana.mybills.constant.BizProviderIconUrl;
import id.dana.mybills.model.BizProductModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModelKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/domain/mybills/model/BizProduct;", "Lid/dana/mybills/model/BizProductModel;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BizProductModelMapperKt {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final List<BizProductModel> BuiltInFictitiousFunctionClassFactory(List<BizProduct> list) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(list, "");
        List<BizProduct> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (BizProduct bizProduct : list2) {
            Intrinsics.checkNotNullParameter(bizProduct, "");
            String bizId = bizProduct.getBizId();
            MoneyViewModel authRequestContext = MoneyViewModelKt.getAuthRequestContext(bizProduct.getDenom());
            String goodsId = bizProduct.getGoodsId();
            String goodsTitle = bizProduct.getGoodsTitle();
            String goodsType = bizProduct.getGoodsType();
            String provider = bizProduct.getProvider();
            Intrinsics.checkNotNullParameter(provider, "");
            switch (provider.hashCode()) {
                case -1443520578:
                    if (provider.equals("smartfren")) {
                        str2 = BizProviderIconUrl.SMARTFREN;
                        str = str2;
                        break;
                    }
                    str = "";
                    break;
                case -456012530:
                    if (provider.equals("nex-parabola")) {
                        str2 = BizProviderIconUrl.NEX_PARABOLA;
                        str = str2;
                        break;
                    }
                    str = "";
                    break;
                case 3828:
                    if (provider.equals("xl")) {
                        str2 = BizProviderIconUrl.XL;
                        str = str2;
                        break;
                    }
                    str = "";
                    break;
                case 115115:
                    if (provider.equals("tri")) {
                        str2 = BizProviderIconUrl.TRI;
                        str = str2;
                        break;
                    }
                    str = "";
                    break;
                case 3008417:
                    if (provider.equals("axis")) {
                        str2 = BizProviderIconUrl.AXIS;
                        str = str2;
                        break;
                    }
                    str = "";
                    break;
                case 3029653:
                    if (provider.equals("bolt")) {
                        str2 = BizProviderIconUrl.BOLT;
                        str = str2;
                        break;
                    }
                    str = "";
                    break;
                case 3030551:
                    if (provider.equals("bpjs")) {
                        str2 = BizProviderIconUrl.BPJS;
                        str = str2;
                        break;
                    }
                    str = "";
                    break;
                case 954205196:
                    if (provider.equals("telkomsel")) {
                        str2 = BizProviderIconUrl.TELKOMSEL;
                        str = str2;
                        break;
                    }
                    str = "";
                    break;
                case 1943585142:
                    if (provider.equals("indosat")) {
                        str2 = BizProviderIconUrl.INDOSAT;
                        str = str2;
                        break;
                    }
                    str = "";
                    break;
                default:
                    str = "";
                    break;
            }
            arrayList.add(new BizProductModel(bizId, authRequestContext, goodsId, goodsTitle, goodsType, str, bizProduct.isGoodsActive(), bizProduct.getProvider(), bizProduct.getProviderName(), bizProduct.getTransactionDate(), bizProduct.getExtendInfo()));
        }
        return arrayList;
    }
}
