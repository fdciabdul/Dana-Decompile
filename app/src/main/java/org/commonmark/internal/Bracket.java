package org.commonmark.internal;

import org.commonmark.node.Text;

/* loaded from: classes6.dex */
public class Bracket {
    public boolean BuiltInFictitiousFunctionClassFactory = true;
    public boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
    public final Text MyBillsEntityDataFactory;
    public final Delimiter NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final int PlaceComponentResult;
    public final boolean getAuthRequestContext;
    public final Bracket moveToNextValue;

    public static Bracket MyBillsEntityDataFactory(Text text, int i, Bracket bracket, Delimiter delimiter) {
        return new Bracket(text, i, bracket, delimiter, false);
    }

    public static Bracket KClassImpl$Data$declaredNonStaticMembers$2(Text text, int i, Bracket bracket, Delimiter delimiter) {
        return new Bracket(text, i, bracket, delimiter, true);
    }

    private Bracket(Text text, int i, Bracket bracket, Delimiter delimiter, boolean z) {
        this.MyBillsEntityDataFactory = text;
        this.PlaceComponentResult = i;
        this.getAuthRequestContext = z;
        this.moveToNextValue = bracket;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = delimiter;
    }
}
