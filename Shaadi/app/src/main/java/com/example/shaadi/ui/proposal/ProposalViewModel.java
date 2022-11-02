//package com.example.shaadi.ui.proposal;
//
//public class ProposalViewModel {
//}
package com.example.shaadi.ui.proposal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProposalViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ProposalViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is proposal fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
