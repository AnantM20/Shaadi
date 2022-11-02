//package com.example.shaadi.ui.myvisitor;
//
//public class MyvisitorFragment {
//}
package com.example.shaadi.ui.myvisitor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.shaadi.databinding.FragmentGalleryBinding;
import com.example.shaadi.databinding.FragmentMyvisitorBinding;

public class MyvisitorFragment extends Fragment {

    private FragmentMyvisitorBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MyvisitorViewModel myvisitorViewModel =
                new ViewModelProvider(this).get(MyvisitorViewModel.class);

        binding = FragmentMyvisitorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textGallery;
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
