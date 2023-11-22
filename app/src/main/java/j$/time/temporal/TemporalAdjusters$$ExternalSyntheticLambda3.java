package j$.time.temporal;

/* loaded from: classes6.dex */
public final /* synthetic */ class TemporalAdjusters$$ExternalSyntheticLambda3 implements TemporalAdjuster {
    public final /* synthetic */ int MyBillsEntityDataFactory;
    public final /* synthetic */ int PlaceComponentResult;

    public /* synthetic */ TemporalAdjusters$$ExternalSyntheticLambda3(int i, int i2) {
        this.PlaceComponentResult = i2;
        this.MyBillsEntityDataFactory = i;
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public final Temporal adjustInto(Temporal temporal) {
        if (this.PlaceComponentResult != 0) {
            int i = this.MyBillsEntityDataFactory;
            int i2 = temporal.get(ChronoField.DAY_OF_WEEK);
            if (i2 != i) {
                return temporal.plus(i2 - i >= 0 ? 7 - r1 : -r1, ChronoUnit.DAYS);
            }
            return temporal;
        }
        int i3 = this.MyBillsEntityDataFactory;
        int i4 = temporal.get(ChronoField.DAY_OF_WEEK);
        if (i4 != i3) {
            return temporal.minus(i3 - i4 >= 0 ? 7 - r0 : -r0, ChronoUnit.DAYS);
        }
        return temporal;
    }
}
