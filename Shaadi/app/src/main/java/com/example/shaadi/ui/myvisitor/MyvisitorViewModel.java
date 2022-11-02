//package com.example.shaadi.ui.myvisitor;
//
//public class MyvisitorViewModel {
//}
package com.example.shaadi.ui.myvisitor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyvisitorViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MyvisitorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is myvisitor fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
