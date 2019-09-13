package apps.rez.com.smartguru;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class SiswaDetailFragment extends Fragment implements View.OnClickListener{

    private String nama;
    private CardView biodata;
    private CardView pengetahuan;
    private CardView keterampilan;
    private CardView rapor;
    private FragmentActivity myContext;
    private FragmentManager fragmentManager;

    public SiswaDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_siswa_detail, container, false);
        biodata = view.findViewById(R.id.cvBioSiswa);
        pengetahuan = view.findViewById(R.id.cvNilaiPengetahuanSiswa);
        keterampilan = view.findViewById(R.id.cvNilaiKeterampilanSiswa);
        rapor = view.findViewById(R.id.cvRaporSiswa);

        biodata.setOnClickListener(this);
        pengetahuan.setOnClickListener(this);
        keterampilan.setOnClickListener(this);
        rapor.setOnClickListener(this);

        nama = getArguments().getString("nama");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        myContext=(FragmentActivity) context;
        super.onAttach(context);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.cvBioSiswa) {
            BiodataSiswaModalFragment biodataSiswaModalFragment = new BiodataSiswaModalFragment();
            fragmentManager = myContext.getSupportFragmentManager();
            biodataSiswaModalFragment.show(fragmentManager,"Fragment Biodata Siswa");
        }else if(view.getId() == R.id.cvNilaiPengetahuanSiswa){
            NilaiPengetahuanSiswaModalFragment nilaiPengetahuanSiswaModalFragment = new NilaiPengetahuanSiswaModalFragment();
            fragmentManager = myContext.getSupportFragmentManager();
            nilaiPengetahuanSiswaModalFragment.show(fragmentManager,"Fragment Nilai Pengetahuan Siswa");
        }else if (view.getId() == R.id.cvNilaiKeterampilanSiswa){
            NilaiKeterampilanModalFragment nilaiKeterampilanModalFragment = new NilaiKeterampilanModalFragment();
            fragmentManager = myContext.getSupportFragmentManager();
            nilaiKeterampilanModalFragment.show(fragmentManager,"Fragment Nilai Keterampilan Siswa");
        }else if (view.getId() == R.id.cvRaporSiswa){
            RaporSiswaModalFragment raporSiswaModalFragment = new RaporSiswaModalFragment();
            fragmentManager = myContext.getSupportFragmentManager();
            raporSiswaModalFragment.show(fragmentManager,"Fragment Rapor Siswa");
        }
    }
}