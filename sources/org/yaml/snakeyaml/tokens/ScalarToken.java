package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token;

/* loaded from: classes6.dex */
public final class ScalarToken extends Token {
    public final DumperOptions.ScalarStyle BuiltInFictitiousFunctionClassFactory;
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public final String PlaceComponentResult;

    public ScalarToken(String str, Mark mark, Mark mark2) {
        this(str, true, mark, mark2, DumperOptions.ScalarStyle.PLAIN);
    }

    public ScalarToken(String str, boolean z, Mark mark, Mark mark2, DumperOptions.ScalarStyle scalarStyle) {
        super(mark, mark2);
        this.PlaceComponentResult = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        if (scalarStyle == null) {
            throw new NullPointerException("Style must be provided.");
        }
        this.BuiltInFictitiousFunctionClassFactory = scalarStyle;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // org.yaml.snakeyaml.tokens.Token
    public final Token.ID BuiltInFictitiousFunctionClassFactory() {
        return Token.ID.Scalar;
    }
}
