package Catalano.Math.Geometry;

/* loaded from: classes6.dex */
class PointToProcess implements Comparable<PointToProcess> {
    public float KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(PointToProcess pointToProcess) {
        float f = this.KClassImpl$Data$declaredNonStaticMembers$2;
        float f2 = pointToProcess.KClassImpl$Data$declaredNonStaticMembers$2;
        if (f == f2) {
            return 0;
        }
        return f > f2 ? 1 : -1;
    }
}
