package com.example.yemeksiparisuygulamasi.ui.fragment;

import android.os.Bundle;
import com.example.yemeksiparisuygulamasi.data.entity.Yemekler;
import com.example.yemeksiparisuygulamasi.ui.adapter.YemeklerAdapter;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.example.yemeksiparisuygulamasi.ui.viewmodel.AnasayfaViewModel;
import com.example.yemeksiparisuygulamasi.databinding.FragmentAnasayfaBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yemeksiparisuygulamasi.R;
import com.example.yemeksiparisuygulamasi.ui.viewmodel.YemekDetayViewModel;

import java.util.ArrayList;


public class AnasayfaFragment extends Fragment {
    private FragmentAnasayfaBinding binding;
    private AnasayfaViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa,container, false);


        binding.setAnasayfaToolbarBaslik("Anasayfa");
        binding.setAnasayfaFragment(this);



        ArrayList<Yemekler> yemeklerListesi = new ArrayList<>();
        Yemekler y1 = new Yemekler(1, "kiraz", "kiraz", 17);
        Yemekler y2 = new Yemekler(2, "Elma", "elma", 18);
        Yemekler y3 = new Yemekler(3, "Karpuz", "karpuz", 25);
        Yemekler y4 = new Yemekler(4, "Armut", "armut", 35);
        Yemekler y5 = new Yemekler(5, "Ananas", "ananas", 55);
        Yemekler y6 = new Yemekler(6, "Mandalina", "mandalina", 25);
        yemeklerListesi.add(y1);
        yemeklerListesi.add(y2);
        yemeklerListesi.add(y3);
        yemeklerListesi.add(y4);
        yemeklerListesi.add(y5);
        yemeklerListesi.add(y6);

        //yemekler adapterdan bir nesne oluşturcaz
        YemeklerAdapter adapter = new YemeklerAdapter(requireContext(),yemeklerListesi);
        //ve bunu da viewBinding yaparak recyclerview'a akataracağız.
        binding.setYemeklerAdapter(adapter);

        return binding.getRoot();

    }

    @Override
    public void onCreate (@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AnasayfaViewModel.class);
    }


}
