package id.dana.sendmoney_v2.recipient.datasource;

import androidx.paging.DataSource;
import id.dana.sendmoney.model.RecipientViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bR\u0012\u0010\f\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\r8\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\u0010"}, d2 = {"Lid/dana/sendmoney_v2/recipient/datasource/RecipientDataSourceFactory;", "Landroidx/paging/DataSource$Factory;", "", "Lid/dana/sendmoney/model/RecipientViewModel;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)V", "", "moveToNextValue", "Ljava/lang/String;", "getAuthRequestContext", "", "lookAheadTest", "Z", "()Z", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class RecipientDataSourceFactory extends DataSource.Factory<Integer, RecipientViewModel> {

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public boolean MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String getAuthRequestContext = "";

    public abstract void BuiltInFictitiousFunctionClassFactory(List<RecipientViewModel> p0);

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }
}
