package com.example.desempenio.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.desempenio.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(requireActivity()).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        final TextView txtPeleadores = binding.txtPeleadores;

        dashboardViewModel.getPeleadores().observe(getViewLifecycleOwner(), peleadores -> {
            // Mostrar todos los peleadores en el TextView
            StringBuilder peleadoresTexto = new StringBuilder();
            for (Peleador peleador : peleadores) {
                peleadoresTexto.append("Nombre: ").append(peleador.getNombre()).append("\n");
                peleadoresTexto.append("Fecha de Nacimiento: ").append(peleador.getFechaNac()).append("\n");
                peleadoresTexto.append("Planeta: ").append(peleador.getPlaneta()).append("\n");
                peleadoresTexto.append("Universo: ").append(peleador.getUniverso()).append("\n");
                peleadoresTexto.append("Raza: ").append(peleador.getRaza()).append("\n");
                peleadoresTexto.append("Técnicas: ").append(peleador.getTecnicas().toString()).append("\n");
                peleadoresTexto.append("Poder: ").append(peleador.getPoder()).append("\n\n");
            }

            // Log para depurar
            Log.d("PeleadoresFragment", "Lista de peleadores: " + peleadoresTexto.toString());

            txtPeleadores.setText(peleadoresTexto.toString());
        });

        final TextView textView = binding.textPeleadores;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}