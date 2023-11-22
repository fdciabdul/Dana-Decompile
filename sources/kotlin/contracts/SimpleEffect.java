package kotlin.contracts;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/contracts/SimpleEffect;", "Lkotlin/contracts/Effect;", "", "booleanExpression", "Lkotlin/contracts/ConditionalEffect;", "implies", "(Z)Lkotlin/contracts/ConditionalEffect;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public interface SimpleEffect extends Effect {
    ConditionalEffect implies(boolean booleanExpression);
}
