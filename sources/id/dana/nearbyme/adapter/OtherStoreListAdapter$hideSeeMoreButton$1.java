package id.dana.nearbyme.adapter;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.nearbyme.model.MerchantItemWrapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006*\u00020\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/nearbyme/model/MerchantItemWrapper;", "it", "", BridgeDSL.INVOKE, "(Lid/dana/nearbyme/model/MerchantItemWrapper;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OtherStoreListAdapter$hideSeeMoreButton$1 extends Lambda implements Function1<MerchantItemWrapper, Boolean> {
    public static final OtherStoreListAdapter$hideSeeMoreButton$1 INSTANCE = new OtherStoreListAdapter$hideSeeMoreButton$1();

    OtherStoreListAdapter$hideSeeMoreButton$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(MerchantItemWrapper merchantItemWrapper) {
        return Boolean.valueOf(merchantItemWrapper.BuiltInFictitiousFunctionClassFactory == 1);
    }
}
