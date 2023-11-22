package Catalano.Imaging.Corners;

/* loaded from: classes6.dex */
public class FeaturePoint implements Comparable<FeaturePoint> {
    public int MyBillsEntityDataFactory;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(FeaturePoint featurePoint) {
        int i = featurePoint.MyBillsEntityDataFactory;
        int i2 = this.MyBillsEntityDataFactory;
        if (i < i2) {
            return 1;
        }
        return i == i2 ? 0 : -1;
    }
}
