package id.dana.sendmoney_v2.recipient.view;

import android.content.ContentResolver;
import id.dana.R;
import id.dana.sendmoney_v2.recipient.datasource.BankDataSourceFactory;
import id.dana.sendmoney_v2.recipient.datasource.NewContactDataSourceFactory;
import id.dana.sendmoney_v2.recipient.datasource.NewSearchDataSourceFactory;
import id.dana.sendmoney_v2.recipient.datasource.RecipientDataSourceFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u0000 \u00152\u00020\u0001:\u0004\u0016\u0017\u0015\u0018B)\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\n\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0017\u0010\r\u001a\u00020\u000b8\u0007¢\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0007X\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\tR\u0011\u0010\b\u001a\u00020\u0007X\u0007¢\u0006\u0006\n\u0004\b\r\u0010\t\u0082\u0001\u0003\u0019\u001a\u001b"}, d2 = {"Lid/dana/sendmoney_v2/recipient/view/RecipientSourceType;", "", "Landroid/content/ContentResolver;", "p0", "Lid/dana/sendmoney_v2/recipient/datasource/RecipientDataSourceFactory;", "MyBillsEntityDataFactory", "(Landroid/content/ContentResolver;)Lid/dana/sendmoney_v2/recipient/datasource/RecipientDataSourceFactory;", "", "getAuthRequestContext", "I", "BuiltInFictitiousFunctionClassFactory", "", "Z", "PlaceComponentResult", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "p2", "p3", "<init>", "(IIIZ)V", "Companion", "All", "Bank", "Contact", "Lid/dana/sendmoney_v2/recipient/view/RecipientSourceType$Contact;", "Lid/dana/sendmoney_v2/recipient/view/RecipientSourceType$Bank;", "Lid/dana/sendmoney_v2/recipient/view/RecipientSourceType$All;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class RecipientSourceType {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final int getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final int BuiltInFictitiousFunctionClassFactory;

    public /* synthetic */ RecipientSourceType(int i, int i2, int i3, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, z);
    }

    public abstract RecipientDataSourceFactory MyBillsEntityDataFactory(ContentResolver p0);

    private RecipientSourceType(int i, int i2, int i3, boolean z) {
        this.getAuthRequestContext = i;
        this.BuiltInFictitiousFunctionClassFactory = i2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i3;
        this.PlaceComponentResult = z;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney_v2/recipient/view/RecipientSourceType$Contact;", "Lid/dana/sendmoney_v2/recipient/view/RecipientSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Contact extends RecipientSourceType {
        public static final Contact INSTANCE = new Contact();

        private Contact() {
            super(R.string.recent_transfer, R.string.enter_new_number, R.string.search_phone_number, true, null);
        }

        @Override // id.dana.sendmoney_v2.recipient.view.RecipientSourceType
        public final /* synthetic */ RecipientDataSourceFactory MyBillsEntityDataFactory(ContentResolver contentResolver) {
            Intrinsics.checkNotNullParameter(contentResolver, "");
            return new NewContactDataSourceFactory();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney_v2/recipient/view/RecipientSourceType$Bank;", "Lid/dana/sendmoney_v2/recipient/view/RecipientSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Bank extends RecipientSourceType {
        public static final Bank INSTANCE = new Bank();

        private Bank() {
            super(R.string.recent_transaction, R.string.enter_new_bank, R.string.search_bank_account, true, null);
        }

        @Override // id.dana.sendmoney_v2.recipient.view.RecipientSourceType
        public final /* synthetic */ RecipientDataSourceFactory MyBillsEntityDataFactory(ContentResolver contentResolver) {
            Intrinsics.checkNotNullParameter(contentResolver, "");
            return new BankDataSourceFactory(contentResolver);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney_v2/recipient/view/RecipientSourceType$All;", "Lid/dana/sendmoney_v2/recipient/view/RecipientSourceType;", "Landroid/content/ContentResolver;", "p0", "Lid/dana/sendmoney_v2/recipient/datasource/RecipientDataSourceFactory;", "MyBillsEntityDataFactory", "(Landroid/content/ContentResolver;)Lid/dana/sendmoney_v2/recipient/datasource/RecipientDataSourceFactory;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class All extends RecipientSourceType {
        public static final All INSTANCE = new All();

        private All() {
            super(R.string.searching, R.string.enter_new_number, R.string.type_name_bank_or_phone_number, false, null);
        }

        @Override // id.dana.sendmoney_v2.recipient.view.RecipientSourceType
        public final RecipientDataSourceFactory MyBillsEntityDataFactory(ContentResolver p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new NewSearchDataSourceFactory();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney_v2/recipient/view/RecipientSourceType$Companion;", "", "", "p0", "Lid/dana/sendmoney_v2/recipient/view/RecipientSourceType;", "getAuthRequestContext", "(I)Lid/dana/sendmoney_v2/recipient/view/RecipientSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static RecipientSourceType getAuthRequestContext(int p0) {
            if (p0 != 1) {
                if (p0 != 2) {
                    if (p0 == 3) {
                        return All.INSTANCE;
                    }
                    return All.INSTANCE;
                }
                return Contact.INSTANCE;
            }
            return Bank.INSTANCE;
        }
    }
}
