package id.dana.mybills.domain.model;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012$\u0010\u000b\u001a \u0012\u0004\u0012\u00020\u0003\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00070\u00060\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J.\u0010\t\u001a \u0012\u0004\u0012\u00020\u0003\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00070\u00060\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0005JN\u0010\f\u001a\u00020\u00002\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022&\b\u0002\u0010\u000b\u001a \u0012\u0004\u0012\u00020\u0003\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00070\u00060\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R8\u0010\u000b\u001a \u0012\u0004\u0012\u00020\u0003\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00070\u00060\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0018\u0010\u0005"}, d2 = {"Lid/dana/mybills/domain/model/FormModel;", "", "", "", "component1", "()Ljava/util/Map;", "", "Lkotlin/Function1;", "", "component2", "fields", "rules", "copy", "(Ljava/util/Map;Ljava/util/Map;)Lid/dana/mybills/domain/model/FormModel;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/Map;", "getFields", "getRules", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FormModel {
    private final Map<String, String> fields;
    private final Map<String, List<Function1<String, Boolean>>> rules;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FormModel copy$default(FormModel formModel, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            map = formModel.fields;
        }
        if ((i & 2) != 0) {
            map2 = formModel.rules;
        }
        return formModel.copy(map, map2);
    }

    public final Map<String, String> component1() {
        return this.fields;
    }

    public final Map<String, List<Function1<String, Boolean>>> component2() {
        return this.rules;
    }

    public final FormModel copy(Map<String, String> fields, Map<String, ? extends List<? extends Function1<? super String, Boolean>>> rules) {
        Intrinsics.checkNotNullParameter(fields, "");
        Intrinsics.checkNotNullParameter(rules, "");
        return new FormModel(fields, rules);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FormModel) {
            FormModel formModel = (FormModel) other;
            return Intrinsics.areEqual(this.fields, formModel.fields) && Intrinsics.areEqual(this.rules, formModel.rules);
        }
        return false;
    }

    public final int hashCode() {
        return (this.fields.hashCode() * 31) + this.rules.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FormModel(fields=");
        sb.append(this.fields);
        sb.append(", rules=");
        sb.append(this.rules);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FormModel(Map<String, String> map, Map<String, ? extends List<? extends Function1<? super String, Boolean>>> map2) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(map2, "");
        this.fields = map;
        this.rules = map2;
    }

    @JvmName(name = "getFields")
    public final Map<String, String> getFields() {
        return this.fields;
    }

    @JvmName(name = "getRules")
    public final Map<String, List<Function1<String, Boolean>>> getRules() {
        return this.rules;
    }
}
