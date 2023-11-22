package id.dana.utils.handpick;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import id.dana.tracker.mixpanel.RegistrationEvent;
import id.dana.utils.FileUtil;
import id.dana.utils.OSUtil;
import id.dana.utils.handpick.HandPicked;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class HandPicked {
    Uri PlaceComponentResult;
    final Builder getAuthRequestContext;

    public /* synthetic */ HandPicked(Builder builder, byte b) {
        this(builder);
    }

    private HandPicked(Builder builder) {
        this.getAuthRequestContext = builder;
        builder.BuiltInFictitiousFunctionClassFactory = new Builder.OnActivityResultCallback() { // from class: id.dana.utils.handpick.HandPicked$$ExternalSyntheticLambda0
            @Override // id.dana.utils.handpick.HandPicked.Builder.OnActivityResultCallback
            public final void KClassImpl$Data$declaredNonStaticMembers$2(ActivityResult activityResult) {
                Uri data;
                HandPicked handPicked = HandPicked.this;
                int i = activityResult.BuiltInFictitiousFunctionClassFactory;
                Intent intent = activityResult.MyBillsEntityDataFactory;
                if (i != -1) {
                    handPicked.getAuthRequestContext.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(new Exception("action_result_canceled"));
                    return;
                }
                String str = RegistrationEvent.ProfilePhotoSource.CAMERA;
                if (intent != null) {
                    intent.getAction();
                    if (intent.getData() == null) {
                        data = handPicked.PlaceComponentResult;
                    } else {
                        data = intent.getData();
                        str = "Gallery";
                    }
                    if (data != null) {
                        handPicked.getAuthRequestContext.PlaceComponentResult.MyBillsEntityDataFactory(data, str);
                    }
                } else if (handPicked.PlaceComponentResult != null) {
                    handPicked.getAuthRequestContext.PlaceComponentResult.MyBillsEntityDataFactory(handPicked.PlaceComponentResult, RegistrationEvent.ProfilePhotoSource.CAMERA);
                }
            }
        };
    }

    private static void BuiltInFictitiousFunctionClassFactory(Context context, List<Intent> list, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 0).iterator();
        while (it.hasNext()) {
            String str = it.next().activityInfo.packageName;
            Intent intent2 = new Intent(intent);
            intent2.setPackage(str);
            list.add(intent2);
        }
    }

    private Intent KClassImpl$Data$declaredNonStaticMembers$2() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(this.getAuthRequestContext.MyBillsEntityDataFactory.PlaceComponentResult().getPackageManager()) != null) {
            try {
                Context PlaceComponentResult = this.getAuthRequestContext.MyBillsEntityDataFactory.PlaceComponentResult();
                String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                StringBuilder sb = new StringBuilder();
                sb.append("JPEG_");
                sb.append(format);
                sb.append("_");
                File createTempFile = File.createTempFile(sb.toString(), ".jpg", FileUtil.PlaceComponentResult(PlaceComponentResult));
                try {
                    if (OSUtil.NetworkUserEntityData$$ExternalSyntheticLambda2()) {
                        this.PlaceComponentResult = FileProvider.getUriForFile(this.getAuthRequestContext.MyBillsEntityDataFactory.PlaceComponentResult(), "id.dana.provider", createTempFile);
                    } else {
                        this.PlaceComponentResult = Uri.fromFile(createTempFile);
                    }
                    this.PlaceComponentResult.toString();
                    intent.putExtra("return-data", true);
                    intent.putExtra(TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT, this.PlaceComponentResult);
                    return intent;
                } catch (Exception unused) {
                    return null;
                }
            } catch (IOException e) {
                this.getAuthRequestContext.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(e);
                return null;
            }
        }
        return null;
    }

    public final void getAuthRequestContext() {
        Intent intent;
        ArrayList arrayList = new ArrayList();
        if (this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.MyBillsEntityDataFactory.PlaceComponentResult(), arrayList, new Intent("android.intent.action.PICK").setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*"));
        }
        if (this.getAuthRequestContext.getAuthRequestContext) {
            BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.MyBillsEntityDataFactory.PlaceComponentResult(), arrayList, KClassImpl$Data$declaredNonStaticMembers$2());
        }
        if (arrayList.isEmpty()) {
            intent = null;
        } else {
            intent = Intent.createChooser((Intent) arrayList.remove(arrayList.size() - 1), this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2);
            intent.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        }
        if (intent != null) {
            this.getAuthRequestContext.lookAheadTest.MyBillsEntityDataFactory(intent, null);
        }
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        OnActivityResultCallback BuiltInFictitiousFunctionClassFactory;
        public String KClassImpl$Data$declaredNonStaticMembers$2;
        final ContextFacade MyBillsEntityDataFactory;
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
        public HandPickedResultHandler PlaceComponentResult;
        public boolean getAuthRequestContext;
        final ActivityResultLauncher<Intent> lookAheadTest;

        /* loaded from: classes5.dex */
        interface OnActivityResultCallback {
            void KClassImpl$Data$declaredNonStaticMembers$2(ActivityResult activityResult);
        }

        public Builder(Fragment fragment) {
            this.MyBillsEntityDataFactory = new FragmentFacade(fragment);
            this.lookAheadTest = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.utils.handpick.HandPicked$Builder$$ExternalSyntheticLambda0
                @Override // androidx.view.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    HandPicked.Builder.this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2((ActivityResult) obj);
                }
            });
        }

        public Builder(AppCompatActivity appCompatActivity) {
            this.MyBillsEntityDataFactory = new ActivityFacade(appCompatActivity);
            this.lookAheadTest = appCompatActivity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.utils.handpick.HandPicked$Builder$$ExternalSyntheticLambda1
                @Override // androidx.view.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    HandPicked.Builder.this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2((ActivityResult) obj);
                }
            });
        }
    }
}
