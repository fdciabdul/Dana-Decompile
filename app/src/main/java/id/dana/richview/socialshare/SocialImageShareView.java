package id.dana.richview.socialshare;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.FileProvider;
import com.alibaba.griver.image.framework.api.APImageFormat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.data.socialshare.ShareAppKey;
import id.dana.richview.socialshare.SocialShareView;
import id.dana.richview.socialshare.model.SocialShareButton;
import id.dana.richview.socialshare.model.SocialShareModel;
import id.dana.richview.socialshare.model.SocialShareModelFactory;
import id.dana.util.MediaStoreUtil;
import id.dana.utils.BitmapUtil;
import id.dana.utils.OSUtil;
import id.dana.utils.SizeUtil;
import id.dana.utils.android.IntentUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 <2\u00020\u0001:\u0002<=B'\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u00106\u001a\u000205¢\u0006\u0004\b7\u00108B+\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u00109\u001a\u000205\u0012\u0006\u0010:\u001a\u000205¢\u0006\u0004\b7\u0010;J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00158\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b \u0010#R*\u0010*\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00038\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010\u0014R\"\u0010,\u001a\u00020+8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u0010\u0016\u001a\u0002028\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b3\u00104"}, d2 = {"Lid/dana/richview/socialshare/SocialImageShareView;", "Lid/dana/richview/socialshare/SocialShareView;", "", "", "socialMediaCategoryList", "", "onSuccessGetSocialMediaCategoryShare", "(Ljava/util/List;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "saveImage", "()V", "setOnClickOthers", "setup", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "shareToSocialApp", "(Ljava/lang/String;)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "getEnableSaveButton", "()Z", "setEnableSaveButton", "(Z)V", "enableSaveButton", "Ljava/io/File;", "PlaceComponentResult", "Ljava/io/File;", "getAuthRequestContext", "", "BuiltInFictitiousFunctionClassFactory", LogConstants.RESULT_FALSE, "MyBillsEntityDataFactory", "value", "Ljava/lang/String;", "getImageFilePath", "()Ljava/lang/String;", "setImageFilePath", "imageFilePath", "Lid/dana/richview/socialshare/SocialImageShareView$SaveImageListener;", "saveImageListener", "Lid/dana/richview/socialshare/SocialImageShareView$SaveImageListener;", "getSaveImageListener", "()Lid/dana/richview/socialshare/SocialImageShareView$SaveImageListener;", "setSaveImageListener", "(Lid/dana/richview/socialshare/SocialImageShareView$SaveImageListener;)V", "Landroid/net/Uri;", "scheduleImpl", "Landroid/net/Uri;", "", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "SaveImageListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocialImageShareView extends SocialShareView {
    private float BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean enableSaveButton;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String imageFilePath;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private File getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private float MyBillsEntityDataFactory;
    public SaveImageListener saveImageListener;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private Uri KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/richview/socialshare/SocialImageShareView$SaveImageListener;", "Lid/dana/richview/socialshare/SocialShareView$Listener;", "", "MyBillsEntityDataFactory", "()V", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface SaveImageListener extends SocialShareView.Listener {
        void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0);

        void MyBillsEntityDataFactory();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SocialImageShareView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SocialImageShareView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @JvmName(name = "getSaveImageListener")
    public final SaveImageListener getSaveImageListener() {
        SaveImageListener saveImageListener = this.saveImageListener;
        if (saveImageListener != null) {
            return saveImageListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSaveImageListener")
    public final void setSaveImageListener(SaveImageListener saveImageListener) {
        Intrinsics.checkNotNullParameter(saveImageListener, "");
        this.saveImageListener = saveImageListener;
    }

    @JvmName(name = "getEnableSaveButton")
    public final boolean getEnableSaveButton() {
        return this.enableSaveButton;
    }

    @JvmName(name = "setEnableSaveButton")
    public final void setEnableSaveButton(boolean z) {
        this.enableSaveButton = z;
    }

    @JvmName(name = "getImageFilePath")
    public final String getImageFilePath() {
        return this.imageFilePath;
    }

    @JvmName(name = "setImageFilePath")
    public final void setImageFilePath(String str) {
        Uri fromFile;
        Intrinsics.checkNotNullParameter(str, "");
        this.imageFilePath = str;
        File file = new File(this.imageFilePath);
        this.getAuthRequestContext = file;
        if (OSUtil.NetworkUserEntityData$$ExternalSyntheticLambda2()) {
            fromFile = FileProvider.getUriForFile(getContext(), "id.dana.provider", file);
            Intrinsics.checkNotNullExpressionValue(fromFile, "");
        } else {
            fromFile = Uri.fromFile(file);
            Intrinsics.checkNotNullExpressionValue(fromFile, "");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = fromFile;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocialImageShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = 48.0f;
        this.BuiltInFictitiousFunctionClassFactory = 48.0f;
        this.imageFilePath = "";
    }

    public /* synthetic */ SocialImageShareView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocialImageShareView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = 48.0f;
        this.BuiltInFictitiousFunctionClassFactory = 48.0f;
        this.imageFilePath = "";
    }

    @Override // id.dana.richview.socialshare.SocialShareView, id.dana.base.BaseRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        super.parseAttrs(context, attrs);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ImageCaptureViewModel$getTipUploadPhoto$2);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
        try {
            this.MyBillsEntityDataFactory = obtainStyledAttributes.getDimension(2, SizeUtil.getAuthRequestContext(48));
            this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getDimension(1, SizeUtil.getAuthRequestContext(48));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // id.dana.richview.socialshare.SocialShareView, id.dana.base.BaseRichView
    public final void setup() {
        super.setup();
        float f = this.MyBillsEntityDataFactory;
        float f2 = this.BuiltInFictitiousFunctionClassFactory;
        for (SocialShareButton socialShareButton : this.socialShareButtonList) {
            socialShareButton.KClassImpl$Data$declaredNonStaticMembers$2.getLayoutParams().width = (int) f;
            socialShareButton.KClassImpl$Data$declaredNonStaticMembers$2.getLayoutParams().height = (int) f2;
            socialShareButton.KClassImpl$Data$declaredNonStaticMembers$2.requestLayout();
        }
        CircleImageView circleImageView = (CircleImageView) _$_findCachedViewById(R.id.civ_share_others);
        if (circleImageView != null) {
            ViewGroup.LayoutParams layoutParams = circleImageView.getLayoutParams();
            if (layoutParams != null) {
                Intrinsics.checkNotNullExpressionValue(layoutParams, "");
                layoutParams.width = (int) f;
                layoutParams.height = (int) f2;
            }
            circleImageView.requestLayout();
        }
        CircleImageView circleImageView2 = (CircleImageView) _$_findCachedViewById(R.id.res_0x7f0a0324_trackerkey_globalsearchopenproperties);
        if (circleImageView2 != null) {
            ViewGroup.LayoutParams layoutParams2 = circleImageView2.getLayoutParams();
            if (layoutParams2 != null) {
                Intrinsics.checkNotNullExpressionValue(layoutParams2, "");
                layoutParams2.width = (int) f;
                layoutParams2.height = (int) f2;
            }
            circleImageView2.requestLayout();
        }
    }

    @Override // id.dana.richview.socialshare.SocialShareView, id.dana.richview.socialshare.SocialShareContract.View
    public final void onSuccessGetSocialMediaCategoryShare(List<String> socialMediaCategoryList) {
        super.onSuccessGetSocialMediaCategoryShare(socialMediaCategoryList);
        if (this.enableSaveButton) {
            SocialShareButton socialShareButton = this.socialShareButtonList.get(2);
            attachImageWithGlide(R.drawable.ic_social_save, socialShareButton.KClassImpl$Data$declaredNonStaticMembers$2);
            socialShareButton.MyBillsEntityDataFactory.setText(R.string.option_save);
            socialShareButton.PlaceComponentResult.setVisibility(0);
            socialShareButton.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.socialshare.SocialImageShareView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SocialImageShareView.m2856$r8$lambda$IP7MgrqpZW5lTqvqB2smvmeDRs(SocialImageShareView.this, view);
                }
            });
        }
        ArrayList arrayListOf = CollectionsKt.arrayListOf(ShareAppKey.WHATSAPP, ShareAppKey.LINE);
        int size = arrayListOf.size();
        for (int i = 0; i < size; i++) {
            SocialShareModel BuiltInFictitiousFunctionClassFactory = SocialShareModelFactory.BuiltInFictitiousFunctionClassFactory(getContext(), (String) arrayListOf.get(i));
            if (BuiltInFictitiousFunctionClassFactory != null) {
                updateSocialShareButton(this.socialShareButtonList.get(i), BuiltInFictitiousFunctionClassFactory, i);
            }
        }
    }

    @Override // id.dana.richview.socialshare.SocialShareView
    public final void shareToSocialApp(String packageName) {
        Uri uri = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (uri != null) {
            if (uri == null) {
                try {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    uri = null;
                } catch (ActivityNotFoundException e) {
                    showMessage(getResources().getString(R.string.share_failed));
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SOCIAL_SHARE_TAG, DanaLogConstants.Prefix.SOCIAL_SHARE_INTENT_PREFIX, e);
                    return;
                }
            }
            Intent authRequestContext = IntentUtil.getAuthRequestContext(uri);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            if (IntentUtil.PlaceComponentResult(context, packageName)) {
                authRequestContext.setPackage(packageName);
                getContext().startActivity(authRequestContext);
                return;
            }
            showMessage(getResources().getString(R.string.social_share_pop_up_description));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.richview.socialshare.SocialShareView
    public final void setOnClickOthers() {
        Uri uri;
        if (!this.enableShareButton || (uri = this.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            return;
        }
        if (uri == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            uri = null;
        }
        getContext().startActivity(Intent.createChooser(IntentUtil.getAuthRequestContext(uri), getContext().getString(R.string.share_via)));
    }

    public final void saveImage() {
        Uri uri;
        if (!this.enableSaveButton || (uri = this.KClassImpl$Data$declaredNonStaticMembers$2) == null || this.saveImageListener == null) {
            return;
        }
        File file = null;
        if (uri == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            uri = null;
        }
        Bitmap PlaceComponentResult = BitmapUtil.PlaceComponentResult(uri, getContext());
        if (PlaceComponentResult != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            File file2 = this.getAuthRequestContext;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                file = file2;
            }
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "");
            getSaveImageListener().KClassImpl$Data$declaredNonStaticMembers$2(MediaStoreUtil.getAuthRequestContext(context, name, APImageFormat.SUFFIX_PNG, PlaceComponentResult, ""));
        }
    }

    /* renamed from: $r8$lambda$IP7M-grqpZW5lTqvqB2smvmeDRs  reason: not valid java name */
    public static /* synthetic */ void m2856$r8$lambda$IP7MgrqpZW5lTqvqB2smvmeDRs(SocialImageShareView socialImageShareView, View view) {
        Intrinsics.checkNotNullParameter(socialImageShareView, "");
        socialImageShareView.getSaveImageListener().MyBillsEntityDataFactory();
    }
}
