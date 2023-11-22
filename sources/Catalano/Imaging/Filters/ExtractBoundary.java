package Catalano.Imaging.Filters;

import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class ExtractBoundary implements IApplyInPlace {
    private Algorithm getAuthRequestContext = Algorithm.Erosion;

    /* loaded from: classes6.dex */
    public enum Algorithm {
        Erosion,
        Dilatation
    }
}
