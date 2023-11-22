package Catalano.Math.Random;

/* loaded from: classes6.dex */
public class StandardRandom implements IRandomNumberGenerator {
    private java.util.Random KClassImpl$Data$declaredNonStaticMembers$2;
    private long getAuthRequestContext;

    public StandardRandom() {
        this(System.nanoTime());
    }

    private StandardRandom(long j) {
        this.getAuthRequestContext = j;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new java.util.Random(j);
    }
}
