package id.dana.data.util;

import id.dana.utils.jacoco.ExcludeFromJacocoGeneratedReport;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@ExcludeFromJacocoGeneratedReport
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/util/BillerX2BConfigGenerator;", "", "", "", "x2bRedirectAllBillerConfig", "()Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BillerX2BConfigGenerator {
    public static final BillerX2BConfigGenerator INSTANCE = new BillerX2BConfigGenerator();

    private BillerX2BConfigGenerator() {
    }

    public final List<String> x2bRedirectAllBillerConfig() {
        return CollectionsKt.listOf((Object[]) new String[]{"x2b_redirect_all_biller_100_1", "x2b_redirect_all_biller_100_2", "x2b_redirect_all_biller_100_3", "x2b_redirect_all_biller_100_4", "x2b_redirect_all_biller_100_5", "x2b_redirect_all_biller_100_6"});
    }
}
