package com.example.yemeksiparisuygulamasi.ui.fragment;
import android.os.Bundle;
import com.example.yemeksiparisuygulamasi.data.entity.Sepet_Yemekler;
import com.example.yemeksiparisuygulamasi.data.entity.Yemekler;
import com.example.yemeksiparisuygulamasi.ui.adapter.Sepet_Yemekler_Adapter;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.yemeksiparisuygulamasi.databinding.FragmentSepetBinding;
import com.example.yemeksiparisuygulamasi.databinding.CardTasarimSepetBinding;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yemeksiparisuygulamasi.R;
import com.example.yemeksiparisuygulamasi.ui.adapter.YemeklerAdapter;
import com.example.yemeksiparisuygulamasi.ui.viewmodel.YemekDetayViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import com.example.yemeksiparisuygulamasi.ui.viewmodel.SepetViewModel;
import com.example.yemeksiparisuygulamasi.databinding.FragmentYemekDetayBinding;

public class SepetFragment extends Fragment {
    private FragmentSepetBinding binding;
    private CardTasarimSepetBinding tasarim;
    private SepetViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sepet,container, false);


        binding.setSepetToolbarBaslik("Sepetim");
        binding.setSepetFragment(this);

        binding.rvSepet.setLayoutManager(new LinearLayoutManager(requireContext()));

        ArrayList<Sepet_Yemekler> sepetListesi = new ArrayList<>();
        Sepet_Yemekler y1 = new Sepet_Yemekler(1, "kiraz", "kiraz", 17,1);
        Sepet_Yemekler y2 = new Sepet_Yemekler(2, "Elma", "elma", 18,2);
        sepetListesi.add(y1);
        sepetListesi.add(y2);



        Sepet_Yemekler_Adapter adapter = new Sepet_Yemekler_Adapter(requireContext(),sepetListesi);
        binding.setSepetYemeklerAdapter(adapter);

/*
        tasarim.imageViewSepetSil.setOnClickListener(view ->{

            viewModel.Sil(view);
        });
*/
        return binding.getRoot();

    }

    @Override
    public void onCreate (@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SepetViewModel.class);
    }




}