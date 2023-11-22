package Catalano.Imaging.Filters;

import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class PeronaMalikAnisotropicDiffusion implements IApplyInPlace {
    private int BuiltInFictitiousFunctionClassFactory;
    private double MyBillsEntityDataFactory;
    private Diffusion PlaceComponentResult;
    private double getAuthRequestContext;

    /* loaded from: classes6.dex */
    public enum Diffusion {
        HighContrastEdges,
        WideRegions
    }

    public PeronaMalikAnisotropicDiffusion() {
        this((byte) 0);
    }

    private PeronaMalikAnisotropicDiffusion(byte b) {
        this(Diffusion.HighContrastEdges);
    }

    private PeronaMalikAnisotropicDiffusion(Diffusion diffusion) {
        this.BuiltInFictitiousFunctionClassFactory = 20;
        this.MyBillsEntityDataFactory = 10.0d;
        this.getAuthRequestContext = 0.25d;
        this.PlaceComponentResult = diffusion;
    }
}
