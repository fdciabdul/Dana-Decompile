package Catalano.Imaging.Tools;

/* loaded from: classes6.dex */
public class HoughLine implements Comparable {
    private int MyBillsEntityDataFactory;

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        int i = this.MyBillsEntityDataFactory;
        int i2 = ((HoughLine) obj).MyBillsEntityDataFactory;
        if (i > i2) {
            return -1;
        }
        return i < i2 ? 1 : 0;
    }
}
