package com.example.desempenio.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.desempenio.R;
import com.example.desempenio.databinding.FragmentHomeBinding;
import com.example.desempenio.ui.dashboard.DashboardViewModel;
import com.example.desempenio.ui.dashboard.Peleador;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    TextView txtPoder;
    EditText txtNombre, txtFechaNac, txtPlaneta;
    Spinner spnUniverso;
    RadioButton rbtExtraterrestre, rbtTerrestre;
    CheckBox chkVolar, chkAumentoPoder, chkSentidoKi, chkTransformacion;
    String universos[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        dashboardViewModel = new ViewModelProvider(requireActivity()).get(DashboardViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        txtNombre = root.findViewById(R.id.txtNombre);
        txtPlaneta = root.findViewById(R.id.txtPlaneta);
        txtPoder = root.findViewById(R.id.txtPoder);
        txtFechaNac = root.findViewById(R.id.txtFechaNac);
        spnUniverso = root.findViewById(R.id.spnUniverso);
        rbtExtraterrestre = root.findViewById(R.id.rbtExtraterrestre);
        rbtTerrestre = root.findViewById(R.id.rbtTerrestre);
        chkVolar = root.findViewById(R.id.chkVolar);
        chkAumentoPoder = root.findViewById(R.id.chkAumentoPoder);
        chkSentidoKi = root.findViewById(R.id.chkSentidoKi);
        chkTransformacion = root.findViewById(R.id.chkTransformacion);
        spnUniverso.setAdapter(new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, universos));

        root.findViewById(R.id.btnGuardar).setOnClickListener(v -> {
            Peleador nuevoPeleador = crearPeleador();  // Crear el objeto Peleador
            dashboardViewModel.agregarPeleador(nuevoPeleador);  // Agregar al ViewModel
        });

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    private Peleador crearPeleador() {

        String nombre = txtNombre.getText().toString();
        String fechaNac = txtFechaNac.getText().toString();
        String planeta = txtPlaneta.getText().toString();
        String universo = spnUniverso.getSelectedItem().toString();
        String poder = txtPoder.getText().toString();
        String raza = rbtExtraterrestre.isChecked() ? "Extraterrestre" : "Terrestre";

        // Obtener las técnicas seleccionadas
        List<String> tecnicas = new ArrayList<>();
        if (chkVolar.isChecked())
            tecnicas.add("Volar");
        if (chkAumentoPoder.isChecked())
            tecnicas.add("Aumento de Poder");
        if (chkSentidoKi.isChecked())
            tecnicas.add("Sentido de Ki");
        if (chkTransformacion.isChecked())
            tecnicas.add("Transformación");

        Toast.makeText(getActivity(), "Guardado", Toast.LENGTH_SHORT).show();
        // Crear y retornar un nuevo objeto Peleador
        return new Peleador(nombre, fechaNac, planeta, universo, poder, raza, tecnicas);
    }

    @Override
    public void onPause() {
        super.onPause();

        txtNombre.setText("");
        txtFechaNac.setText("");
        txtPlaneta.setText("");
        txtPoder.setText("");
        rbtExtraterrestre.setChecked(false);
        rbtTerrestre.setChecked(false);
        chkVolar.setChecked(false);
        chkAumentoPoder.setChecked(false);
        chkSentidoKi.setChecked(false);
        chkTransformacion.setChecked(false);
        spnUniverso.setSelection(0);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}