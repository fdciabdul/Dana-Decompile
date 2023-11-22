package com.caverock.androidsvg;

/* loaded from: classes3.dex */
public class PreserveAspectRatio {
    private Alignment alignment;
    private Scale scale;
    public static final PreserveAspectRatio UNSCALED = new PreserveAspectRatio(null, null);
    public static final PreserveAspectRatio STRETCH = new PreserveAspectRatio(Alignment.none, null);
    public static final PreserveAspectRatio LETTERBOX = new PreserveAspectRatio(Alignment.xMidYMid, Scale.meet);
    public static final PreserveAspectRatio START = new PreserveAspectRatio(Alignment.xMinYMin, Scale.meet);
    public static final PreserveAspectRatio END = new PreserveAspectRatio(Alignment.xMaxYMax, Scale.meet);
    public static final PreserveAspectRatio TOP = new PreserveAspectRatio(Alignment.xMidYMin, Scale.meet);
    public static final PreserveAspectRatio BOTTOM = new PreserveAspectRatio(Alignment.xMidYMax, Scale.meet);
    public static final PreserveAspectRatio FULLSCREEN = new PreserveAspectRatio(Alignment.xMidYMid, Scale.slice);
    public static final PreserveAspectRatio FULLSCREEN_START = new PreserveAspectRatio(Alignment.xMinYMin, Scale.slice);

    /* loaded from: classes3.dex */
    public enum Alignment {
        none,
        xMinYMin,
        xMidYMin,
        xMaxYMin,
        xMinYMid,
        xMidYMid,
        xMaxYMid,
        xMinYMax,
        xMidYMax,
        xMaxYMax
    }

    /* loaded from: classes3.dex */
    public enum Scale {
        meet,
        slice
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PreserveAspectRatio(Alignment alignment, Scale scale) {
        this.alignment = alignment;
        this.scale = scale;
    }

    public static PreserveAspectRatio of(String str) {
        try {
            return SVGParser.parsePreserveAspectRatio(str);
        } catch (SVGParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Alignment getAlignment() {
        return this.alignment;
    }

    public Scale getScale() {
        return this.scale;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
            return this.alignment == preserveAspectRatio.alignment && this.scale == preserveAspectRatio.scale;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.alignment);
        sb.append(" ");
        sb.append(this.scale);
        return sb.toString();
    }
}
