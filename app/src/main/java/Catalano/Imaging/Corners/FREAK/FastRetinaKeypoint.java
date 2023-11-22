package Catalano.Imaging.Corners.FREAK;

/* loaded from: classes6.dex */
public class FastRetinaKeypoint {
    private byte[] PlaceComponentResult;

    public boolean equals(Object obj) {
        byte[] bArr = ((FastRetinaKeypoint) obj).PlaceComponentResult;
        for (int i = 0; i < bArr.length; i++) {
            if (this.PlaceComponentResult[i] != bArr[i]) {
                return false;
            }
        }
        return true;
    }
}
