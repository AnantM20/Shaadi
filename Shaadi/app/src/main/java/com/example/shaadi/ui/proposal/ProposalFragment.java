//package com.example.shaadi.ui.proposal;
//
//public class ProposalFragment {
//}
package com.example.shaadi.ui.proposal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.shaadi.databinding.FragmentGalleryBinding;
import com.example.shaadi.databinding.FragmentProposalBinding;

public class ProposalFragment extends Fragment {

    private FragmentProposalBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProposalViewModel proposalViewModel =
                new ViewModelProvider(this).get(ProposalViewModel.class);

        binding = FragmentProposalBinding.inflate(inflater, container, false);
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
