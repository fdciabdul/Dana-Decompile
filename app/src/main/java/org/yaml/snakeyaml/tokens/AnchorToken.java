package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token;

/* loaded from: classes6.dex */
public final class AnchorToken extends Token {
    public final String getAuthRequestContext;

    public AnchorToken(String str, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.getAuthRequestContext = str;
    }

    @Override // org.yaml.snakeyaml.tokens.Token
    public final Token.ID BuiltInFictitiousFunctionClassFactory() {
        return Token.ID.Anchor;
    }
}
