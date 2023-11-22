package androidx.core.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import androidx.core.content.ContextCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.ArrayList;
import java.util.Iterator;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public final class TaskStackBuilder implements Iterable<Intent> {
    public final ArrayList<Intent> MyBillsEntityDataFactory = new ArrayList<>();
    public final Context getAuthRequestContext;

    /* loaded from: classes.dex */
    public interface SupportParentable {
        Intent getSupportParentActivityIntent();
    }

    private TaskStackBuilder(Context context) {
        this.getAuthRequestContext = context;
    }

    public static TaskStackBuilder PlaceComponentResult(Context context) {
        return new TaskStackBuilder(context);
    }

    public final TaskStackBuilder BuiltInFictitiousFunctionClassFactory(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.getAuthRequestContext.getPackageManager());
        }
        if (component != null) {
            MyBillsEntityDataFactory(component);
        }
        this.MyBillsEntityDataFactory.add(intent);
        return this;
    }

    public final TaskStackBuilder MyBillsEntityDataFactory(ComponentName componentName) {
        int size = this.MyBillsEntityDataFactory.size();
        try {
            Intent BuiltInFictitiousFunctionClassFactory = NavUtils.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, componentName);
            while (BuiltInFictitiousFunctionClassFactory != null) {
                this.MyBillsEntityDataFactory.add(size, BuiltInFictitiousFunctionClassFactory);
                BuiltInFictitiousFunctionClassFactory = NavUtils.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            InstrumentInjector.log_e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    @Override // java.lang.Iterable
    @Deprecated
    public final Iterator<Intent> iterator() {
        return this.MyBillsEntityDataFactory.iterator();
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        if (this.MyBillsEntityDataFactory.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.MyBillsEntityDataFactory.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (ContextCompat.getAuthRequestContext(this.getAuthRequestContext, intentArr, null)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.getAuthRequestContext.startActivity(intent);
    }

    /* loaded from: classes6.dex */
    static class Api16Impl {
        private Api16Impl() {
        }
    }
}
