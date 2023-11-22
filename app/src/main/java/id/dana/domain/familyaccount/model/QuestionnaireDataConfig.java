package id.dana.domain.familyaccount.model;

import id.dana.challenge.ChallengeControl;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J8\u0010\t\u001a\u00020\u00002\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R!\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005R$\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0016\u0010\u0005"}, d2 = {"Lid/dana/domain/familyaccount/model/QuestionnaireDataConfig;", "", "", "", "component1", "()Ljava/util/List;", "component2", "address", ChallengeControl.Key.RELATION, "copy", "(Ljava/util/List;Ljava/util/List;)Lid/dana/domain/familyaccount/model/QuestionnaireDataConfig;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getAddress", "getRelation", "<init>", "(Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QuestionnaireDataConfig {
    private final List<String> address;
    private final List<String> relation;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public QuestionnaireDataConfig() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.familyaccount.model.QuestionnaireDataConfig.<init>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuestionnaireDataConfig copy$default(QuestionnaireDataConfig questionnaireDataConfig, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = questionnaireDataConfig.address;
        }
        if ((i & 2) != 0) {
            list2 = questionnaireDataConfig.relation;
        }
        return questionnaireDataConfig.copy(list, list2);
    }

    public final List<String> component1() {
        return this.address;
    }

    public final List<String> component2() {
        return this.relation;
    }

    public final QuestionnaireDataConfig copy(List<String> address, List<String> relation) {
        return new QuestionnaireDataConfig(address, relation);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QuestionnaireDataConfig) {
            QuestionnaireDataConfig questionnaireDataConfig = (QuestionnaireDataConfig) other;
            return Intrinsics.areEqual(this.address, questionnaireDataConfig.address) && Intrinsics.areEqual(this.relation, questionnaireDataConfig.relation);
        }
        return false;
    }

    public final int hashCode() {
        List<String> list = this.address;
        int hashCode = list == null ? 0 : list.hashCode();
        List<String> list2 = this.relation;
        return (hashCode * 31) + (list2 != null ? list2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QuestionnaireDataConfig(address=");
        sb.append(this.address);
        sb.append(", relation=");
        sb.append(this.relation);
        sb.append(')');
        return sb.toString();
    }

    public QuestionnaireDataConfig(List<String> list, List<String> list2) {
        this.address = list;
        this.relation = list2;
    }

    public /* synthetic */ QuestionnaireDataConfig(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2);
    }

    @JvmName(name = "getAddress")
    public final List<String> getAddress() {
        return this.address;
    }

    @JvmName(name = "getRelation")
    public final List<String> getRelation() {
        return this.relation;
    }
}
