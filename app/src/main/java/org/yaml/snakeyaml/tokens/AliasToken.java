package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token;

/* loaded from: classes6.dex */
public final class AliasToken extends Token {
    public final String MyBillsEntityDataFactory;

    public AliasToken(String str, Mark mark, Mark mark2) {
        super(mark, mark2);
        if (str == null) {
            throw new NullPointerException("alias is expected");
        }
        this.MyBillsEntityDataFactory = str;
    }

    @Override // org.yaml.snakeyaml.tokens.Token
    public final Token.ID BuiltInFictitiousFunctionClassFactory() {
        return Token.ID.Alias;
    }
}
