package id.dana.explore.data.sku.repository;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/explore/data/sku/repository/LastTransactionInvalidException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LastTransactionInvalidException extends Exception {
    public LastTransactionInvalidException() {
        super("Last Succesful Transaction has empty bizIds or goodsId");
    }
}
