package com.example.yemeksiparisuygulamasi.ui.fragment;

import static java.lang.String.*;

import android.os.Bundle;
import com.example.yemeksiparisuygulamasi.data.entity.Yemekler;

import com.example.yemeksiparisuygulamasi.ui.viewmodel.YemekDetayViewModel;
import com.example.yemeksiparisuygulamasi.R;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import com.example.yemeksiparisuygulamasi.databinding.FragmentYemekDetayBinding;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.*;


public class YemekDetayFragment extends Fragment {
    int sayac=0;
    private FragmentYemekDetayBinding binding;
    private YemekDetayViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_yemek_detay, container, false);
        binding.setYemekDetayToolbarBaslik("Yemek Detay");
        YemekDetayFragmentArgs bundle = YemekDetayFragmentArgs.fromBundle(getArguments());
        Yemekler gelenYemek = bundle.getYemek();
        binding.setYemekNesnesi(gelenYemek);
        binding.setYemekDetayFragment(this);//yetkilendirme
        binding.ivYemek.setImageResource(getResources().getIdentifier(gelenYemek.getYemek_resim_adi(), "drawable", getActivity().getPackageName()));
        binding.tvYemekAd.setText(gelenYemek.getYemek_adi());
        binding.tvYemekFiyat.setText(gelenYemek.getYemek_fiyat() + " ₺");


        binding.buttonSepetEkle.setOnClickListener(view -> {

            String yemek_adi = binding.tvYemekAd.getText().toString();
            String yemek_resim_adi = binding.ivYemek.toString();
            int yemek_fiyat = binding.tvYemekFiyat.getInputType();
            int yemek_siparis_adet = binding.tvYemekFiyat.getInputType();

            viewModel.Ekle(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, view, gelenYemek);

        });


        binding.buttonSepeteGit.setOnClickListener(view ->{
            Navigation.findNavController(view).navigate(R.id.sepetGecis);
        });

        return binding.getRoot();
    }




    //viewModel tanımlaması
        @Override
        public void onCreate (@Nullable Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            viewModel = new ViewModelProvider(this).get(YemekDetayViewModel.class);
        }





    public void buttonArttir(){
        sayac++;
        binding.textViewAdet.setText(" " + sayac);

    }

    public void buttonAzalt(){
        if (sayac > 0) {
            sayac--;
            binding.textViewAdet.setText(" " + sayac);
        } else {
           sayac = 0;
        }

    }




        public void sayacSifirla () {
            sayac = 0;
            binding.textViewAdet.setText(" " + sayac);

        }


}




















