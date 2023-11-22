package j$.util;

/* loaded from: classes.dex */
public final class StringJoiner {
    private String BuiltInFictitiousFunctionClassFactory;
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    public final String MyBillsEntityDataFactory;
    public StringBuilder PlaceComponentResult;
    private final String getAuthRequestContext;

    public StringJoiner(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        if (charSequence2 == null) {
            throw new NullPointerException("The prefix must not be null");
        }
        if (charSequence == null) {
            throw new NullPointerException("The delimiter must not be null");
        }
        if (charSequence3 == null) {
            throw new NullPointerException("The suffix must not be null");
        }
        String charSequence4 = charSequence2.toString();
        this.MyBillsEntityDataFactory = charSequence4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = charSequence.toString();
        String charSequence5 = charSequence3.toString();
        this.getAuthRequestContext = charSequence5;
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence4);
        sb.append(charSequence5);
        this.BuiltInFictitiousFunctionClassFactory = sb.toString();
    }

    public final StringJoiner BuiltInFictitiousFunctionClassFactory(CharSequence charSequence) {
        StringBuilder sb = this.PlaceComponentResult;
        if (sb != null) {
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.MyBillsEntityDataFactory);
            this.PlaceComponentResult = sb2;
        }
        this.PlaceComponentResult.append(charSequence);
        return this;
    }

    public final String toString() {
        if (this.PlaceComponentResult == null) {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
        if (this.getAuthRequestContext.equals("")) {
            return this.PlaceComponentResult.toString();
        }
        int length = this.PlaceComponentResult.length();
        StringBuilder sb = this.PlaceComponentResult;
        sb.append(this.getAuthRequestContext);
        String obj = sb.toString();
        this.PlaceComponentResult.setLength(length);
        return obj;
    }
}
