package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes.dex */
public class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {
    final FragmentManager PlaceComponentResult;

    public FragmentLayoutInflaterFactory(FragmentManager fragmentManager) {
        this.PlaceComponentResult = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        final FragmentStateManager createOrGetFragmentStateManager;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.PlaceComponentResult);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PlaceComponentResult);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(R.styleable.getErrorConfigVersion);
            }
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.getAuthRequestContext, -1);
            String string = obtainStyledAttributes.getString(R.styleable.lookAheadTest);
            obtainStyledAttributes.recycle();
            if (attributeValue == null || !FragmentFactory.BuiltInFictitiousFunctionClassFactory(context.getClassLoader(), attributeValue)) {
                return null;
            }
            int id2 = view != null ? view.getId() : 0;
            if (id2 == -1 && resourceId == -1 && string == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(attributeSet.getPositionDescription());
                sb.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
                sb.append(attributeValue);
                throw new IllegalArgumentException(sb.toString());
            }
            Fragment findFragmentById = resourceId != -1 ? this.PlaceComponentResult.findFragmentById(resourceId) : null;
            if (findFragmentById == null && string != null) {
                findFragmentById = this.PlaceComponentResult.findFragmentByTag(string);
            }
            if (findFragmentById == null && id2 != -1) {
                findFragmentById = this.PlaceComponentResult.findFragmentById(id2);
            }
            if (findFragmentById == null) {
                findFragmentById = this.PlaceComponentResult.getFragmentFactory().getAuthRequestContext(context.getClassLoader(), attributeValue);
                findFragmentById.mFromLayout = true;
                findFragmentById.mFragmentId = resourceId != 0 ? resourceId : id2;
                findFragmentById.mContainerId = id2;
                findFragmentById.mTag = string;
                findFragmentById.mInLayout = true;
                findFragmentById.mFragmentManager = this.PlaceComponentResult;
                findFragmentById.mHost = this.PlaceComponentResult.getHost();
                findFragmentById.onInflate(this.PlaceComponentResult.getHost().MyBillsEntityDataFactory, attributeSet, findFragmentById.mSavedFragmentState);
                createOrGetFragmentStateManager = this.PlaceComponentResult.addFragment(findFragmentById);
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Fragment ");
                    sb2.append(findFragmentById);
                    sb2.append(" has been inflated via the <fragment> tag: id=0x");
                    sb2.append(Integer.toHexString(resourceId));
                    InstrumentInjector.log_v(FragmentManager.TAG, sb2.toString());
                }
            } else if (findFragmentById.mInLayout) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(attributeSet.getPositionDescription());
                sb3.append(": Duplicate id 0x");
                sb3.append(Integer.toHexString(resourceId));
                sb3.append(", tag ");
                sb3.append(string);
                sb3.append(", or parent id 0x");
                sb3.append(Integer.toHexString(id2));
                sb3.append(" with another fragment for ");
                sb3.append(attributeValue);
                throw new IllegalArgumentException(sb3.toString());
            } else {
                findFragmentById.mInLayout = true;
                findFragmentById.mFragmentManager = this.PlaceComponentResult;
                findFragmentById.mHost = this.PlaceComponentResult.getHost();
                findFragmentById.onInflate(this.PlaceComponentResult.getHost().MyBillsEntityDataFactory, attributeSet, findFragmentById.mSavedFragmentState);
                createOrGetFragmentStateManager = this.PlaceComponentResult.createOrGetFragmentStateManager(findFragmentById);
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Retained Fragment ");
                    sb4.append(findFragmentById);
                    sb4.append(" has been re-attached via the <fragment> tag: id=0x");
                    sb4.append(Integer.toHexString(resourceId));
                    InstrumentInjector.log_v(FragmentManager.TAG, sb4.toString());
                }
            }
            ViewGroup viewGroup = (ViewGroup) view;
            FragmentStrictMode.getAuthRequestContext(findFragmentById, viewGroup);
            findFragmentById.mContainer = viewGroup;
            createOrGetFragmentStateManager.PlaceComponentResult();
            createOrGetFragmentStateManager.getAuthRequestContext();
            if (findFragmentById.mView == null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Fragment ");
                sb5.append(attributeValue);
                sb5.append(" did not create a view.");
                throw new IllegalStateException(sb5.toString());
            }
            if (resourceId != 0) {
                findFragmentById.mView.setId(resourceId);
            }
            if (findFragmentById.mView.getTag() == null) {
                findFragmentById.mView.setTag(string);
            }
            findFragmentById.mView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.FragmentLayoutInflaterFactory.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                }

                {
                    FragmentLayoutInflaterFactory.this = this;
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    Fragment fragment = createOrGetFragmentStateManager.PlaceComponentResult;
                    createOrGetFragmentStateManager.PlaceComponentResult();
                    SpecialEffectsController.MyBillsEntityDataFactory((ViewGroup) fragment.mView.getParent(), FragmentLayoutInflaterFactory.this.PlaceComponentResult).getAuthRequestContext();
                }
            });
            return findFragmentById.mView;
        }
        return null;
    }
}
