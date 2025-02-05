package com.example.desempenio.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.desempenio.R;
import com.example.desempenio.databinding.FragmentNotificationsBinding;
import com.example.desempenio.ui.dashboard.DashboardViewModel;
import com.example.desempenio.ui.dashboard.Peleador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    TextView lblHora, lblFecha;
    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        dashboardViewModel = new ViewModelProvider(requireActivity()).get(DashboardViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        dashboardViewModel.getPeleadores().observe(getViewLifecycleOwner(), peleadores -> {
            if (peleadores.size() >= 8) {
                // Mostrar 4 combates aleatorios
                mostrarCombatesAleatorios(root, peleadores);
            } else {
                // Mostrar un mensaje si no hay suficientes peleadores
                mostrarMensajeAdvertencia(root);
            }
        });

        lblFecha = root.findViewById(R.id.lblFecha);
        lblHora = root.findViewById(R.id.lblHorario);
        final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    private void mostrarCombatesAleatorios(View root, List<Peleador> peleadores) {
        // Mezclar aleatoriamente los peleadores
        Collections.shuffle(peleadores);

        // Obtener las referencias de los contenedores de combate
        LinearLayout combate1 = root.findViewById(R.id.combate1);
        LinearLayout combate2 = root.findViewById(R.id.combate2);
        LinearLayout combate3 = root.findViewById(R.id.combate3);
        LinearLayout combate4 = root.findViewById(R.id.combate4);

        // Mostrar cada combate
        mostrarCombate(peleadores.get(0), peleadores.get(1), combate1, R.id.lblIzquierda1, R.id.lblDerecha1, R.id.imageView1);
        mostrarCombate(peleadores.get(2), peleadores.get(3), combate2, R.id.lblIzquierda2, R.id.lblDerecha2, R.id.imageView2);
        mostrarCombate(peleadores.get(4), peleadores.get(5), combate3, R.id.lblIzquierda3, R.id.lblDerecha3, R.id.imageView3);
        mostrarCombate(peleadores.get(6), peleadores.get(7), combate4, R.id.lblIzquierda4, R.id.lblDerecha4, R.id.imageView4);
    }

    // Método para mostrar un combate en el LinearLayout correspondiente
    private void mostrarCombate(Peleador peleador1, Peleador peleador2, LinearLayout combateLayout, int idIzquierda, int idDerecha, int idImagen) {
        TextView txtPeleador1 = combateLayout.findViewById(idIzquierda);
        TextView txtPeleador2 = combateLayout.findViewById(idDerecha);
        ImageView imageView = combateLayout.findViewById(idImagen);

        // Asignar los nombres de los peleadores
        txtPeleador1.setText(peleador1.getNombre());
        txtPeleador2.setText(peleador2.getNombre());

        // Asignar una imagen de "vs" al ImageView
        imageView.setImageResource(R.drawable.vs);  // Asegúrate de tener la imagen "vs" en drawable
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();

        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");

        lblFecha.setText(fechaActual.format(formatoFecha));
        lblHora.setText(horaActual.format(formatoHora));
    }

    // Método para mostrar un mensaje cuando no hay suficientes peleadores
    private void mostrarMensajeAdvertencia(View root) {
        TextView txtCombates = root.findViewById(R.id.text_notifications);
        txtCombates.setText("No hay suficientes peleadores registrados. Necesitas al menos 8 peleadores.");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}