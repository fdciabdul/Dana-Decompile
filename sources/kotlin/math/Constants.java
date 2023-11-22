package kotlin.math;

import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\t\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0004"}, d2 = {"Lkotlin/math/Constants;", "", "", "LN2", SummaryActivity.DAYS, "epsilon", "taylor_2_bound", "taylor_n_bound", "upper_taylor_2_bound", "upper_taylor_n_bound", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
final class Constants {
    public static final Constants INSTANCE = new Constants();
    public static final double LN2 = Math.log(2.0d);
    public static final double epsilon;
    public static final double taylor_2_bound;
    public static final double taylor_n_bound;
    public static final double upper_taylor_2_bound;
    public static final double upper_taylor_n_bound;

    private Constants() {
    }

    static {
        double ulp = Math.ulp(1.0d);
        epsilon = ulp;
        double sqrt = Math.sqrt(ulp);
        taylor_2_bound = sqrt;
        double sqrt2 = Math.sqrt(sqrt);
        taylor_n_bound = sqrt2;
        upper_taylor_2_bound = 1.0d / sqrt;
        upper_taylor_n_bound = 1.0d / sqrt2;
    }
}
