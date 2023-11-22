package org.yaml.snakeyaml.tokens;

import java.util.Objects;
import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token;

/* loaded from: classes6.dex */
public final class CommentToken extends Token {
    public final CommentType MyBillsEntityDataFactory;
    public final String PlaceComponentResult;

    public CommentToken(CommentType commentType, String str, Mark mark, Mark mark2) {
        super(mark, mark2);
        Objects.requireNonNull(commentType);
        this.MyBillsEntityDataFactory = commentType;
        Objects.requireNonNull(str);
        this.PlaceComponentResult = str;
    }

    @Override // org.yaml.snakeyaml.tokens.Token
    public final Token.ID BuiltInFictitiousFunctionClassFactory() {
        return Token.ID.Comment;
    }
}
