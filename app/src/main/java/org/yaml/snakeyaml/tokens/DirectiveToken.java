package org.yaml.snakeyaml.tokens;

import java.util.List;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.tokens.Token;

/* loaded from: classes6.dex */
public final class DirectiveToken<T> extends Token {
    public final List<T> KClassImpl$Data$declaredNonStaticMembers$2;
    public final String PlaceComponentResult;

    public DirectiveToken(String str, List<T> list, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.PlaceComponentResult = str;
        if (list != null && list.size() != 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Two strings must be provided instead of ");
            sb.append(list.size());
            throw new YAMLException(sb.toString());
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
    }

    @Override // org.yaml.snakeyaml.tokens.Token
    public final Token.ID BuiltInFictitiousFunctionClassFactory() {
        return Token.ID.Directive;
    }
}
