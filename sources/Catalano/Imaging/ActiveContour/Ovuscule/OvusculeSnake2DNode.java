package Catalano.Imaging.ActiveContour.Ovuscule;

import Catalano.Core.DoublePoint;

/* loaded from: classes6.dex */
public class OvusculeSnake2DNode extends DoublePoint {
    public boolean PlaceComponentResult;
    public boolean getAuthRequestContext;

    @Override // Catalano.Core.DoublePoint
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(super.toString());
        sb.append(", frozen: ");
        sb.append(this.PlaceComponentResult);
        sb.append(", hidden: ");
        sb.append(this.getAuthRequestContext);
        sb.append("]");
        return sb.toString();
    }
}
