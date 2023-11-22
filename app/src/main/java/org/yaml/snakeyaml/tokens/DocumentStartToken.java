package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token;

/* loaded from: classes6.dex */
public final class DocumentStartToken extends Token {
    public DocumentStartToken(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    @Override // org.yaml.snakeyaml.tokens.Token
    public final Token.ID BuiltInFictitiousFunctionClassFactory() {
        return Token.ID.DocumentStart;
    }
}
