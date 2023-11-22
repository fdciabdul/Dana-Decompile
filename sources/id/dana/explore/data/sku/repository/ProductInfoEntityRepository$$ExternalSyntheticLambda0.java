package id.dana.explore.data.sku.repository;

import id.dana.explore.data.sku.repository.source.network.response.CreateProductOrderResult;
import io.reactivex.functions.Function;

/* loaded from: classes5.dex */
public final /* synthetic */ class ProductInfoEntityRepository$$ExternalSyntheticLambda0 implements Function {
    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return ProductInfoEntityRepository.getAuthRequestContext((CreateProductOrderResult) obj);
    }
}
