package com.app.architecture.fragmentfactory;


import com.app.architecture.base.BaseFragment;
import com.app.architecture.ui.about.AboutFragment;
import com.app.architecture.ui.profile.ProfileFragment;

/**
 * Manage all fragment
 */
public class FragmentFactory {

    private static FragmentFactory mINSTANCE;
    private BaseFragment mBaseFragment;

    public static FragmentFactory newInstance() {
        if (mINSTANCE == null) {
            mINSTANCE = new FragmentFactory();
        }
        return mINSTANCE;
    }

    /**
     * Create Fragment Object
     *
     * @param frgTag Use to create fragment object
     * @return Created fragment object
     */
    public BaseFragment getFragment(TYPE frgTag) {
        switch (frgTag) {

            case PROFILE:
                mBaseFragment = new ProfileFragment();
                break;


            case ABOUT:
                mBaseFragment = new AboutFragment();
                break;
        }
        return mBaseFragment;
    }

    public enum TYPE {
        PROFILE, ABOUT
    }
}
