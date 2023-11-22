package ru.noties.markwon.renderer;

/* loaded from: classes6.dex */
public class ImageSize {
    public final Dimension BuiltInFictitiousFunctionClassFactory;
    public final Dimension getAuthRequestContext;

    /* loaded from: classes6.dex */
    public static class Dimension {
        public final float BuiltInFictitiousFunctionClassFactory;
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        public Dimension(float f, String str) {
            this.BuiltInFictitiousFunctionClassFactory = f;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Dimension{value=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", unit='");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public ImageSize(Dimension dimension, Dimension dimension2) {
        this.getAuthRequestContext = dimension;
        this.BuiltInFictitiousFunctionClassFactory = dimension2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImageSize{width=");
        sb.append(this.getAuthRequestContext);
        sb.append(", height=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append('}');
        return sb.toString();
    }
}
