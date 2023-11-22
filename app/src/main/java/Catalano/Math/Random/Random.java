package Catalano.Math.Random;

/* loaded from: classes6.dex */
public class Random {
    private IRandomNumberGenerator getAuthRequestContext;

    public Random() {
        this(new UniversalGenerator());
    }

    private Random(IRandomNumberGenerator iRandomNumberGenerator) {
        this.getAuthRequestContext = iRandomNumberGenerator;
    }
}
