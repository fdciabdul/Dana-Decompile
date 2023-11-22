package androidx.appcompat.app;

/* loaded from: classes.dex */
class TwilightCalculator {
    private static TwilightCalculator getAuthRequestContext;
    public long KClassImpl$Data$declaredNonStaticMembers$2;
    public long MyBillsEntityDataFactory;
    public int PlaceComponentResult;

    TwilightCalculator() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TwilightCalculator MyBillsEntityDataFactory() {
        if (getAuthRequestContext == null) {
            getAuthRequestContext = new TwilightCalculator();
        }
        return getAuthRequestContext;
    }

    public final void PlaceComponentResult(long j, double d, double d2) {
        float f = ((float) (j - 946728000000L)) / 8.64E7f;
        double d3 = (0.01720197f * f) + 6.24006f;
        double sin = Math.sin(d3) * 0.03341960161924362d;
        Double.isNaN(d3);
        double sin2 = sin + d3 + (Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double d4 = (-d2) / 360.0d;
        double d5 = f - 9.0E-4f;
        Double.isNaN(d5);
        double round = ((float) Math.round(d5 - d4)) + 9.0E-4f;
        double sin3 = Math.sin(d3);
        Double.isNaN(round);
        double sin4 = round + d4 + (sin3 * 0.0053d) + (Math.sin(2.0d * sin2) * (-0.0069d));
        double asin = Math.asin(Math.sin(sin2) * Math.sin(0.4092797040939331d));
        double d6 = 0.01745329238474369d * d;
        double sin5 = (Math.sin(-0.10471975803375244d) - (Math.sin(d6) * Math.sin(asin))) / (Math.cos(d6) * Math.cos(asin));
        if (sin5 >= 1.0d) {
            this.PlaceComponentResult = 1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = -1L;
            this.MyBillsEntityDataFactory = -1L;
        } else if (sin5 <= -1.0d) {
            this.PlaceComponentResult = 0;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = -1L;
            this.MyBillsEntityDataFactory = -1L;
        } else {
            double acos = (float) (Math.acos(sin5) / 6.283185307179586d);
            Double.isNaN(acos);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = Math.round((sin4 + acos) * 8.64E7d) + 946728000000L;
            Double.isNaN(acos);
            long round2 = Math.round((sin4 - acos) * 8.64E7d) + 946728000000L;
            this.MyBillsEntityDataFactory = round2;
            if (round2 < j && this.KClassImpl$Data$declaredNonStaticMembers$2 > j) {
                this.PlaceComponentResult = 0;
            } else {
                this.PlaceComponentResult = 1;
            }
        }
    }
}
